package com.mdt.ait.helpers;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.google.common.collect.ImmutableList;
import com.mdt.ait.AIT;
import com.mdt.ait.world.dimensions.TardisChunkGen;
import com.mojang.serialization.Lifecycle;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Dimension;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.border.IBorderListener;
import net.minecraft.world.chunk.listener.IChunkStatusListener;
import net.minecraft.world.chunk.listener.IChunkStatusListenerFactory;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.DerivedWorldInfo;
import net.minecraft.world.storage.IServerConfiguration;
import net.minecraft.world.storage.SaveFormat.LevelSave;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class DynamicDimensionHelper
{
	// we need to read some private fields in MinecraftServer
	// we can use Access Transformers, Accessor Mixins, or ObfuscationReflectionHelper to get at these
	// we'll use ORH here as ATs and Mixins seem to be causing headaches for dependant mods lately
		// it also lets us define the private-field-getting-shenanigans in the same class we're using them
		// it also doesn't need any extra resources or buildscript stuff, which makes this example simpler to describe
	public static final Function<MinecraftServer, IChunkStatusListenerFactory> CHUNK_STATUS_LISTENER_FACTORY_FIELD =
		getInstanceField(MinecraftServer.class, "field_213220_d");
	public static final Function<MinecraftServer, Executor> BACKGROUND_EXECUTOR_FIELD =
		getInstanceField(MinecraftServer.class, "field_213217_au");
	public static final Function<MinecraftServer, LevelSave> ANVIL_CONVERTER_FOR_ANVIL_FILE_FIELD =
		getInstanceField(MinecraftServer.class, "field_71310_m");
	
	/**
	 * Gets a world, dynamically creating and registering one if it doesn't exist.<br>
	 * The dimension registry is stored in the server's level file, all previously registered dimensions are loaded
	 * and recreated and reregistered whenever the server starts.<br>
	 * Static, singular dimensions can be registered via this getOrCreateWorld method
	 * in the FMLServerStartingEvent, which runs immediately after existing dimensions are loaded and registered.<br>
	 * Dynamic dimensions (mystcraft, etc) seem to be able to be registered at runtime with no repercussions aside from
	 * lagging the server for a couple seconds while the world initializes.
	 * @param server a MinecraftServer instance (you can get this from a ServerPlayerEntity or ServerWorld)
	 * @param worldKey A RegistryKey for your world, you can make one via RegistryKey.getOrCreateKey(Registry.WORLD_KEY, yourWorldResourceLocation);
	 * @param dimensionFactory A function that produces a new Dimension instance if necessary, given the server and dimension id<br>
	 * (dimension ID will be the same as the world ID from worldKey)<br>
	 * It should be assumed that intended dimension has not been created or registered yet,
	 * so making the factory attempt to get this dimension from the server's dimension registry will fail
	 * @return Returns a ServerWorld, creating and registering a world and dimension for it if the world does not already exist
	 */
	public static ServerWorld getOrCreateWorld(MinecraftServer server, RegistryKey<World> worldKey, BiFunction<MinecraftServer, RegistryKey<Dimension>, Dimension> dimensionFactory)
	{
		
		// this is marked as deprecated but it's not called from anywhere and I'm not sure how old it is,
		// it's probably left over from forge's previous dimension api
		// in any case we need to get at the server's world field, and if we didn't use this getter,
		// then we'd just end up making a private-field-getter for it ourselves anyway
		@SuppressWarnings("deprecation")
		Map<RegistryKey<World>, ServerWorld> map = server.forgeGetWorldMap();
		
		// if the world already exists, return it
		if (map.containsKey(worldKey))
		{
			return map.get(worldKey);
		}
		else
		{			
			// for vanilla worlds, forge fires the world load event *after* the world is put into the map
			// we'll do the same for consistency
			// (this is why we're not just using map::computeIfAbsent)
			ServerWorld newWorld = createAndRegisterWorldAndDimension(server, map, worldKey, dimensionFactory);
			
			return newWorld;
		}
	}
	
	@SuppressWarnings("deprecation") // markWorldsDirty is deprecated, see below
	private static ServerWorld createAndRegisterWorldAndDimension(MinecraftServer server, Map<RegistryKey<World>, ServerWorld> map, RegistryKey<World> worldKey, BiFunction<MinecraftServer, RegistryKey<Dimension>, Dimension> dimensionFactory)
	{
		ServerWorld overworld = server.getLevel(World.OVERWORLD);
		RegistryKey<Dimension> dimensionKey = RegistryKey.create(Registry.LEVEL_STEM_REGISTRY, worldKey.location());
		Dimension dimension = dimensionFactory.apply(server, dimensionKey);

		// we need to get some private fields from MinecraftServer here
			// chunkStatusListenerFactory
			// backgroundExecutor
			// anvilConverterForAnvilFile
		// the int in create() here is radius of chunks to watch, 11 is what the server uses when it initializes worlds
		IChunkStatusListener chunkListener = CHUNK_STATUS_LISTENER_FACTORY_FIELD.apply(server).create(11);
		Executor executor = BACKGROUND_EXECUTOR_FIELD.apply(server);
		LevelSave levelSave = ANVIL_CONVERTER_FOR_ANVIL_FILE_FIELD.apply(server);
		
		// this is the same order server init creates these worlds:
		// instantiate world, add border listener, add to map, fire world load event
		// (in server init, the dimension is already in the dimension registry,
			// that'll get registered here before the world is instantiated as well)
		
		IServerConfiguration serverConfig = server.getWorldData();
		DimensionGeneratorSettings dimensionGeneratorSettings = serverConfig.worldGenSettings();
		// this next line registers the Dimension
		dimensionGeneratorSettings.dimensions().register(dimensionKey, dimension, Lifecycle.experimental());
		DerivedWorldInfo derivedWorldInfo = new DerivedWorldInfo(serverConfig, serverConfig.overworldData());
		// now we have everything we need to create the world instance
		ServerWorld newWorld = new ServerWorld(
			server,
			executor,
			levelSave,
			derivedWorldInfo,
			worldKey,
			dimension.type(),
			chunkListener,
			dimension.generator(),
			dimensionGeneratorSettings.isDebug(), // boolean: is-debug-world
			BiomeManager.obfuscateSeed(dimensionGeneratorSettings.seed()),
			ImmutableList.of(), // "special spawn list"
				// phantoms, raiders, travelling traders, cats are overworld special spawns
				// the dimension loader is hardcoded to initialize preexisting non-overworld worlds with no special spawn lists
				// so this can probably be left empty for best results and spawns should be handled via other means
			false); // "tick time", true for overworld, always false for everything else

		// add world border listener
		overworld.getWorldBorder().addListener(new IBorderListener.Impl(newWorld.getWorldBorder()));
		
		// register world
		map.put(worldKey, newWorld);
		
		// update forge's world cache (very important, if we don't do this then the new world won't tick!)
		server.markWorldsDirty();
		
		// fire world load event
		MinecraftForge.EVENT_BUS.post(new WorldEvent.Load(newWorld)); // event isn't cancellable
		
		return newWorld;
	}
	
	// helper for making the private field getters via reflection
	@SuppressWarnings("unchecked") // also throws ClassCastException if the types are wrong
	static <FIELDHOLDER,FIELDTYPE> Function<FIELDHOLDER,FIELDTYPE> getInstanceField(Class<FIELDHOLDER> fieldHolderClass, String fieldName)
	{
		// forge's ORH is needed to reflect into vanilla minecraft java
		Field field = ObfuscationReflectionHelper.findField(fieldHolderClass, fieldName);
		
		return instance -> {
			try
			{
				return (FIELDTYPE)(field.get(instance));
			}
			catch (IllegalArgumentException | IllegalAccessException e)
			{
				throw new RuntimeException(e);
			}
		};
	}

	public static void registerChunkGenerators() {
		Registry.register(Registry.CHUNK_GENERATOR, new ResourceLocation(AIT.MOD_ID, "tardis"), TardisChunkGen.CODEC);
	}
}
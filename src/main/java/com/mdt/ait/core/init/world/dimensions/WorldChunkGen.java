package com.mdt.ait.core.init.world.dimensions;

import com.mdt.ait.AIT;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.Blockreader;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;

// if we're creating dimensions at runtime,
// then we'll also need to create chunk generator instances at runtime
// example of how to make a chunk generator for a single-biome dimension, same as the debug world chunk generator
// for more complicated biome schemes, you'll need a proper biome provider in the codec, like NoiseChunkGenerator
public class WorldChunkGen extends ChunkGenerator {
    // we can define the dimension's biome in a json at data/yourmod/worldgen/biome/your_biome
    public static RegistryKey<Biome> biomeRegistryKey = RegistryKey.create(Registry.BIOME_REGISTRY,
            new ResourceLocation(AIT.MOD_ID, "World"));

    // this Codec will need to be registered to the chunk generator registry in Registry
    // during FMLCommonSetupEvent::enqueueWork
    // (unless and until a forge registry wrapper becomes made for chunk generators)
    public static final Codec<WorldChunkGen> CODEC =
            // the registry lookup doesn't actually serialize, so we don't need a field for it
            RegistryLookupCodec.create(Registry.BIOME_REGISTRY)
                    .xmap(WorldChunkGen::new, WorldChunkGen::getBiomeRegistry)
                    .codec();

    private final Registry<Biome> biomes;

    public Registry<Biome> getBiomeRegistry() { return this.biomes; }

    // create chunk generator at runtime when dynamic dimension is created
    public WorldChunkGen(MinecraftServer server) {
        this(server.registryAccess() // get dynamic registry
                .registryOrThrow(Registry.BIOME_REGISTRY));
    }

    // create chunk generator when dimension is loaded from the dimension registry on server init
    public WorldChunkGen(Registry<Biome> biomes) {
        super(new SingleBiomeProvider(biomes.getOrThrow(WorldChunkGen.biomeRegistryKey)), new DimensionStructuresSettings(false));
        this.biomes = biomes;
    }

    //get codec
    @Override
    protected Codec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    // get chunk generator but with seed
    @Override
    public ChunkGenerator withSeed(long p_230349_1_)
    {
        return this;
    }

    @Override
    public void buildSurfaceAndBedrock(WorldGenRegion p_225551_1_, IChunk p_225551_2_) {

    }

    // fill from noise
    @Override
    public void fillFromNoise(IWorld p_230352_1_, StructureManager p_230352_2_, IChunk p_230352_3_) {

    }

    @Override
    public int getBaseHeight(int pX, int pZ, Type pHeightmapType) {
        return 0;
    }

    @Override
    public IBlockReader getBaseColumn(int p_230348_1_, int p_230348_2_) {
        return new Blockreader(new BlockState[0]);
    }
}
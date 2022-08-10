package com.mdt.ait.depreciated.helpers.tardis;

import com.mdt.ait.AIT;
import com.mdt.ait.depreciated.helpers.DynamicDimensionHelper;
import com.mdt.ait.depreciated.dimensions.TardisDimensionFactory;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.world.ForgeChunkManager;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.UUID;

public class OldTardisManager extends WorldSavedData {
    private static OldTardisManager TARDIS_MANAGER_INSTANCE = null;
    public static final String TARDIS_FILE_NAME =  AIT.MOD_ID + "tardis_manager";

    public HashMap<UUID, OldTardis> ALL_TARDISES = new HashMap<>();
    public boolean CHECK_IS_SYNCED = false;
    public boolean CHECK_IS_SAVED = false;
    public int LOADED_WORLD = 0;
    public boolean active = false;

    /*=========================================== SERIALISATION ======================================================*/

    public OldTardisManager(String string) {
        super(string);
    }

    public OldTardisManager() {
        this(TARDIS_FILE_NAME);
    }

    @Override
    public void load(CompoundNBT nbt) {
        ListNBT listnbt = nbt.getList("instances", Constants.NBT.TAG_COMPOUND);
        for (int i = 0; i < listnbt.size(); ++i) {
            CompoundNBT tardis_nbt = listnbt.getCompound(i);
            UUID tardis_id = tardis_nbt.getUUID("id");
            System.out.println("LOAD" + tardis_id);
            ALL_TARDISES.put(tardis_id, new OldTardis(tardis_id, tardis_nbt));
        }
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        ListNBT tardis_list = new ListNBT();
        ALL_TARDISES.forEach((id, tardis) -> tardis_list.add(tardis.save(new CompoundNBT())));
        System.out.println("SAVE" + tardis_list);
        nbt.put("instances", tardis_list);
        return nbt;
    }

    public boolean checkIsDataDirty(int current_world) {
        if (current_world != LOADED_WORLD) {
            ALL_TARDISES.clear();
            CHECK_IS_SYNCED = false;
        }
        return CHECK_IS_SYNCED;
    }

    /**
     * call .hashcode() on a server world or client world
     */
    public static OldTardisManager getTardisManagerForWorld(World world) {
        //TARDIS_MANAGER_INSTANCE.checkIsDataDirty(world.hashCode());
        return TARDIS_MANAGER_INSTANCE;
    }

    /*=========================================== DATA MANAGEMENT ======================================================*/

    public OldTardis newTardis(UUID owner, BlockPos pos, boolean clientSide) {
        MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
        OldTardis tardis = new OldTardis(owner);
        ALL_TARDISES.put(owner, tardis);
        if (!clientSide) {
            //why are we forcing a chunk?
            ServerWorld overWorldServer = server.getLevel(World.OVERWORLD);
            if (overWorldServer != null) {
                ChunkPos chunkPos = new ChunkPos(pos);
                ForgeChunkManager.forceChunk(overWorldServer, AIT.MOD_ID, pos, chunkPos.x, chunkPos.z, true, true);
            }
            //create server world
            ServerWorld tardis_world = DynamicDimensionHelper.getOrCreateWorld(server, tardis.interior_key, (_server, key) -> TardisDimensionFactory.createTardisDimension(_server));
            com.mdt.ait.network.Network.sendPacketToAll(new com.mdt.ait.network.packets.DimensionSyncPacket(tardis.interior_key));
            //place tardis interior
            final String interior_type_name = "hartnell_interior";
            Template console_room_temp = tardis_world.getStructureManager().get(new ResourceLocation(AIT.MOD_ID, interior_type_name));
            try {
                console_room_temp.placeInWorld(tardis_world, new BlockPos(0, 128, 0), new PlacementSettings(), tardis_world.getRandom());
                tardis.hasGenerated = true;
                ForgeChunkManager.forceChunk(tardis_world, AIT.MOD_ID, new BlockPos(0, 128, 0), 0, 0, true, true);
            } catch (NullPointerException e) {
                throw new RuntimeException("OldTardis missing appropriate interior: " + interior_type_name + e);
            }
        }
        CHECK_IS_SYNCED = false;
        CHECK_IS_SAVED = false;
        active = true;
        return tardis;
    }

    public OldTardis getTardis(UUID owner) {
        return ALL_TARDISES.get(owner);
    }

    public static OldTardisManager getInstance() {
        if (TARDIS_MANAGER_INSTANCE == null) {
            TARDIS_MANAGER_INSTANCE = new OldTardisManager();
        }
        return TARDIS_MANAGER_INSTANCE;
    }

    public OldTardis getTardisFromLevel(@Nonnull World world) {
        return ALL_TARDISES.get(UUID.fromString(world.dimension().getRegistryName().getPath()));
    }

    public boolean hasTardis(UUID owner) {
        return ALL_TARDISES.containsKey(owner);
    }

}

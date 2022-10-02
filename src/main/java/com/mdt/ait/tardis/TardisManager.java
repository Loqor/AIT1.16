package com.mdt.ait.tardis;

import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.common.worldsaveddata.TardisWorldSavedData;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.util.HashMap;
import java.util.UUID;


public class TardisManager {
    public static HashMap<UUID, Tardis> tardis_list = new HashMap<UUID, Tardis>();

    public static int latestTardisNumber = -1;

    private static boolean loaded = false;


    private final MinecraftServer server = ServerLifecycleHooks.getCurrentServer();

    public static TardisWorldSavedData tardisWorldSavedData;

    public TardisManager() {
        tardisWorldSavedData = new TardisWorldSavedData(this);
    }


    public Tardis createNewTardis(UUID owner, BlockPos exterior_position, RegistryKey<World> exterior_dimension) throws Exception {

        if (!loaded) {
            System.out.println("Warning TardisManager has not been loaded before Creating New Tardis");
            UUID tardisID = UUID.randomUUID();
            tardisWorldSavedData.setDirty(true);
            latestTardisNumber += 1;
            Tardis tardis = new Tardis(owner, exterior_position, exterior_dimension, tardisID, new Tuple<Integer, Integer>(latestTardisNumber, latestTardisNumber), false);
            tardis_list.put(tardisID, tardis);
            loaded = true;
            return tardis;
        } else {
            UUID tardisID = UUID.randomUUID();
            tardisWorldSavedData.setDirty(true);
            latestTardisNumber += 1;
            Tardis tardis = new Tardis(owner, exterior_position, exterior_dimension, tardisID, new Tuple<Integer, Integer>(latestTardisNumber, latestTardisNumber), false);
            tardis_list.put(tardisID, tardis);
            return tardis;

        }
    }

    public Tardis getTardis(UUID tardisID) {
        return tardis_list.get(tardisID);
    }

    public Tardis moveTardis(UUID tardis_id, BlockPos new_exterior_position, Direction exterior_facing, RegistryKey<World> exterior_dimension) {
        Tardis tardis = getTardis(tardis_id);

        ServerWorld oldDimension = server.getLevel(tardis.exterior_dimension);
        ServerWorld newDimension = server.getLevel(exterior_dimension);
        assert newDimension != null;
        assert oldDimension != null;
        BlockState newBlockState = new TardisBlock().getStateIfMoved(exterior_facing);
        newDimension.setBlockAndUpdate(new_exterior_position, newBlockState);
        oldDimension.removeBlock(tardis.exterior_position, true);
        TardisTileEntity newTardisTileEntity = (TardisTileEntity) newDimension.getBlockEntity(new_exterior_position);
        assert newTardisTileEntity != null;
        newTardisTileEntity.linked_tardis_id = tardis.tardisID;
        newTardisTileEntity.linked_tardis = tardis;
        tardis.__moveExterior(new_exterior_position, exterior_facing, exterior_dimension);

        return tardis;

    }

    public void load(CompoundNBT tag) {
        System.out.println("Tardis Manager: Loading!");
        ListNBT tardis_nbt_list = tag.getList("tardis_list", Constants.NBT.TAG_COMPOUND); // Always add Constants.NBT.TAG_COMPOUND idk why you need it but you do
        tardis_nbt_list.forEach((inbt) -> {
            Tardis tardis = new Tardis((CompoundNBT) inbt);
            tardis_list.put(tardis.tardisID, tardis);
        });
        loaded = true;
        latestTardisNumber = tardis_list.size() - 1;
        tardisWorldSavedData.setDirty(false);

    }

    public CompoundNBT save(CompoundNBT tag) {
        System.out.println("Tardis Manager Saving");
        System.out.println(tardis_list);
        ListNBT tardis_nbt_list = new ListNBT(); // Create ListNBT
        tardis_list.forEach((id, tardis) -> tardis_nbt_list.add(tardis.save()));
        tag.put("tardis_list", tardis_nbt_list);
        tardisWorldSavedData.setDirty(false);
        return tag;
    }

    public TardisWorldSavedData getTardisWorldSavedData() {
        return tardisWorldSavedData;
    }
}

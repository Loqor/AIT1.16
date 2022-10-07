package com.mdt.ait.tardis;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.common.worldsaveddata.TardisWorldSavedData;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.core.init.enums.EnumMatState;
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
import java.util.Objects;
import java.util.UUID;


public class TardisManager {
    public static HashMap<UUID, Tardis> tardis_list = new HashMap<UUID, Tardis>();

    public static HashMap<Integer, UUID> integerMapToUUID = new HashMap<Integer, UUID>();
    public static int latestTardisNumber = -1;

    private static boolean loaded = false;


    private final MinecraftServer server = AIT.server;

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
            integerMapToUUID.put(latestTardisNumber, tardis.tardisID);
            loaded = true;
            return tardis;
        } else {
            UUID tardisID = UUID.randomUUID();
            tardisWorldSavedData.setDirty(true);
            latestTardisNumber += 1;
            Tardis tardis = new Tardis(owner, exterior_position, exterior_dimension, tardisID, new Tuple<Integer, Integer>(latestTardisNumber, latestTardisNumber), false);
            tardis_list.put(tardisID, tardis);
            integerMapToUUID.put(latestTardisNumber, tardis.tardisID);
            return tardis;

        }
    }

    public Tardis getTardis(UUID tardisID) {
        return tardis_list.get(tardisID);
    }

    public Tardis getTardisFromPosition(BlockPos pos) {
        return getTardis(getTardisIDFromPosition(pos));
    }

    public UUID getTardisIDFromPosition(BlockPos pos) {
        int x = pos.getX();
        int z = pos.getZ();
        int x_grid_position;
        int z_grid_position;
        int x_r = TardisConfig.tardis_dimension_start_x - x;
        double x_g = ((double) x_r) / ((double) TardisConfig.tardis_area_x);
        int x_gr = ((int) Math.ceil(x_g));
        if (x_gr > 0) {
            x_grid_position = x_gr + 1;
        } else {
            x_grid_position = 1;
        }
        int z_r = TardisConfig.tardis_dimension_start_z - z;
        double z_g = ((double) z_r) / ((double) TardisConfig.tardis_area_z);
        int z_gr = ((int) Math.ceil(z_g));
        if (z_gr > 0) {
            z_grid_position = z_gr + 1;
        } else {
            z_grid_position = 1;
        }

        return integerMapToUUID.get(x_grid_position);
    }

    public Tardis moveTARDIS(UUID tardis_id, BlockPos new_exterior_position, Direction exterior_facing, RegistryKey<World> exterior_dimension) {
        Tardis tardis = getTardis(tardis_id);

        ServerWorld oldDimension = server.getLevel(tardis.exterior_dimension);
        ServerWorld newDimension = server.getLevel(exterior_dimension);
        assert newDimension != null;
        assert oldDimension != null;

        BlockState newBlockState = oldDimension.getBlockState(tardis.exterior_position).setValue(TardisBlock.isExistingTardis, true).setValue(TardisBlock.FACING, exterior_facing);
        newDimension.setBlockAndUpdate(new_exterior_position, newBlockState);

        TardisTileEntity newTardisTileEntity = (TardisTileEntity) newDimension.getBlockEntity(new_exterior_position);

        assert newTardisTileEntity != null;
        newTardisTileEntity.setExterior(((TardisTileEntity) Objects.requireNonNull(oldDimension.getBlockEntity(tardis.exterior_position))).currentExterior());
        newTardisTileEntity.linked_tardis_id = tardis.tardisID;
        newTardisTileEntity.setDoorState(EnumDoorState.CLOSED);
        newTardisTileEntity.linked_tardis = tardis;
        oldDimension.removeBlock(tardis.exterior_position, false);

        tardis.__moveExterior(new_exterior_position, exterior_facing, exterior_dimension); // Has to be called last
        newTardisTileEntity.setMatState(EnumMatState.REMAT);
        return tardis;

    }

    public void load(CompoundNBT tag) {
        System.out.println("Tardis Manager: Loading!");
        ListNBT tardis_nbt_list = tag.getList("tardis_list", Constants.NBT.TAG_COMPOUND); // Always add Constants.NBT.TAG_COMPOUND idk why you need it but you do
        ListNBT int_to_tardis_id_list = tag.getList("integer_tardis_list_to_get_UUID", Constants.NBT.TAG_COMPOUND);
        tardis_nbt_list.forEach((inbt) -> {
            Tardis tardis = new Tardis((CompoundNBT) inbt);
            tardis_list.put(tardis.tardisID, tardis);
        });
        int_to_tardis_id_list.forEach((inbt -> {
            CompoundNBT nbt = ((CompoundNBT) inbt);
            integerMapToUUID.put(nbt.getInt("number"), nbt.getUUID("tardis_ID"));
        }));
        loaded = true;
        latestTardisNumber = tardis_list.size() - 1;
        tardisWorldSavedData.setDirty(false);

    }

    public CompoundNBT save(CompoundNBT tag) {
        System.out.println("Tardis Manager Saving");
        System.out.println(tardis_list);
        ListNBT tardis_nbt_list = new ListNBT(); // Create ListNBT
        ListNBT int_to_tardis_id_list = new ListNBT(); // Create ListNBT
        tardis_list.forEach((id, tardis) -> tardis_nbt_list.add(tardis.save()));
        integerMapToUUID.forEach((number, UUID) -> {
            CompoundNBT nbt = new CompoundNBT();
            nbt.putInt("number", number);
            nbt.putUUID("tardis_ID", UUID);
            int_to_tardis_id_list.add(nbt);
        });
        tag.put("tardis_list", tardis_nbt_list);
        tag.put("integer_tardis_list_to_get_UUID", int_to_tardis_id_list);
        tardisWorldSavedData.setDirty(false);
        return tag;
    }

    public TardisWorldSavedData getTardisWorldSavedData() {
        return tardisWorldSavedData;
    }
}

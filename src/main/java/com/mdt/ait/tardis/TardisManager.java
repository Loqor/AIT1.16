package com.mdt.ait.tardis;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.common.worldsaveddata.TardisWorldSavedData;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.core.init.enums.EnumMatState;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.FallingBlockEntity;
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
import net.minecraftforge.common.world.ForgeChunkManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;


public class TardisManager {
    public static HashMap<UUID, Tardis> tardis_list = new HashMap<UUID, Tardis>();

    public static HashMap<Integer, UUID> integerMapToUUID = new HashMap<Integer, UUID>();
    public static int latestTardisNumber = 0;

    private static boolean loaded = false;

    private final MinecraftServer server = AIT.server;

    public static TardisWorldSavedData tardisWorldSavedData;
    public boolean rematerialize = false;
    public boolean canFall = false;

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

    /*public boolean getBlockUnderTardis(UUID tardisID, ServerWorld level) {
        Tardis tardis = this.getTardis(tardisID);
        BlockPos underTardis = new BlockPos(tardis.exterior_position.getX(),
                tardis.exterior_position.getY() - 1, tardis.exterior_position.getZ());
        Block block = level.getBlockState(underTardis).getBlock();
        if(block == Blocks.AIR) {
            return true;
        }
        return false;
    }*/

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
//        if (x_gr > 0) {
//            x_grid_position = x_gr + 1;
//        } else {
//            x_grid_position = 1;
//        }
        int z_r = TardisConfig.tardis_dimension_start_z - z;
        double z_g = ((double) z_r) / ((double) TardisConfig.tardis_area_z);
        int z_gr = ((int) Math.ceil(z_g));
//        if (z_gr > 0) {
//            z_grid_position = z_gr + 1;
//        } else {
//            z_grid_position = 1;
//        }

        System.out.println(integerMapToUUID);
        System.out.println(x_gr);
        return integerMapToUUID.get(x_gr);
    }

    public void setTargetDimensionForTardis(UUID tardisIDRegistryKey, RegistryKey<World> newTargetDimension) {
        this.getTardis(tardisIDRegistryKey).target_dimension = newTargetDimension;
    }

    /*public boolean isBlockBelow(BlockPos blockPos, World world) {
        if(world.getBlockState(blockPos).getBlock() == Blocks.AIR) {
            return true;
        }
        return false;
    }*/

    public void moveTARDIS(UUID tardis_id, BlockPos new_exterior_position, Direction exterior_facing, RegistryKey<World> exterior_dimension) {
        Tardis tardis = getTardis(tardis_id);

        ServerWorld oldDimension = server.getLevel(tardis.exterior_dimension);
        ServerWorld newDimension = server.getLevel(exterior_dimension);
        assert newDimension != null;
        assert oldDimension != null;

        BlockPos __setAirBlockPos = new BlockPos(new_exterior_position.getX(), new_exterior_position.getY() +1 , new_exterior_position.getZ());

        ServerWorld forceWorld = AIT.server.getLevel(tardis.exterior_dimension);
        assert forceWorld != null;

        ForgeChunkManager.forceChunk(forceWorld, AIT.MOD_ID, tardis.exterior_position, 0, 0, true, true);
        BlockState newBlockState = oldDimension.getBlockState(tardis.exterior_position).setValue(TardisBlock.isExistingTardis, true).setValue(TardisBlock.FACING, exterior_facing);
        if(rematerialize = true) {
            //if(isBlockBelow(new BlockPos(new_exterior_position.getX(), new_exterior_position.getY() - 1, new_exterior_position.getZ()), newDimension)) {
                //BlockPos newExteriorPositionCorrected = new BlockPos(new_exterior_position.getX(), new_exterior_position.getY() - 1, new_exterior_position.getZ());
                newDimension.setBlockAndUpdate(new_exterior_position, newBlockState);
                if ((newDimension.getBlockState(__setAirBlockPos).getBlock() != Blocks.BEDROCK)
                        || (newDimension.getBlockState(__setAirBlockPos).getBlock() != Blocks.DIAMOND_BLOCK)
                        || (newDimension.getBlockState(__setAirBlockPos).getBlock() != Blocks.END_PORTAL_FRAME)
                        || (newDimension.getBlockState(__setAirBlockPos).getBlock() != Blocks.DRAGON_EGG)
                        || (newDimension.getBlockState(__setAirBlockPos).getBlock() != Blocks.NETHERITE_BLOCK)
                        || (newDimension.getBlockState(__setAirBlockPos).getBlock() != Blocks.ANCIENT_DEBRIS)
                        || (newDimension.getBlockState(__setAirBlockPos).getBlock() != Blocks.DIAMOND_ORE)
                        || (newDimension.getBlockState(__setAirBlockPos).getBlock() != Blocks.COMMAND_BLOCK)
                        || (newDimension.getBlockState(__setAirBlockPos).getBlock() != Blocks.REPEATING_COMMAND_BLOCK)
                        || (newDimension.getBlockState(__setAirBlockPos).getBlock() != Blocks.CHAIN_COMMAND_BLOCK)
                        || (newDimension.getBlockState(__setAirBlockPos).getBlock() != Blocks.PISTON)
                        || (newDimension.getBlockState(__setAirBlockPos).getBlock() != Blocks.STICKY_PISTON)
                        || (newDimension.getBlockState(__setAirBlockPos).getBlock() != Blocks.REDSTONE_WIRE)
                        || (newDimension.getBlockState(__setAirBlockPos).getBlock() != Blocks.REPEATER)) {
                    newDimension.setBlockAndUpdate(__setAirBlockPos, Blocks.AIR.defaultBlockState());
                }

                TardisTileEntity newTardisTileEntity = (TardisTileEntity) newDimension.getBlockEntity(new_exterior_position);

                assert newTardisTileEntity != null;
                newTardisTileEntity.setExterior(((TardisTileEntity) Objects.requireNonNull(oldDimension.getBlockEntity(tardis.exterior_position))).currentExterior());
                newTardisTileEntity.linked_tardis_id = tardis.tardisID;
                newTardisTileEntity.setDoorState(EnumDoorState.CLOSED);
                newTardisTileEntity.linked_tardis = tardis;
                newDimension.setBlockEntity(new_exterior_position, newTardisTileEntity);
                oldDimension.removeBlock(tardis.exterior_position, false);

                tardis.__moveExterior(new_exterior_position, exterior_facing, exterior_dimension); // Has to be called last
                ServerWorld forceWorld1 = AIT.server.getLevel(exterior_dimension);
                assert forceWorld1 != null;
                ForgeChunkManager.forceChunk(forceWorld, AIT.MOD_ID, tardis.exterior_position, 0, 0, false, false);
                if (!newDimension.getChunkAt(new_exterior_position).isEmpty()) {
                    newTardisTileEntity.setMatState(EnumMatState.REMAT);
                } else {
                    newTardisTileEntity.setMatState(EnumMatState.SOLID);
                }
            //}
        }
    }

    public void setTardisTargetLocation(UUID tardisID, BlockPos targetPosition, Direction targetFacing, RegistryKey<World> targetDimension) {
        Tardis tardis = getTardis(tardisID);
        tardis.__setTargetLocation(targetPosition, targetFacing, targetDimension);
    }

    public void setTardisTargetBlockPos(UUID tardisID, BlockPos __targetPosition) {
        if(this.getTardis(tardisID).targetPosition != __targetPosition) {
            this.getTardis(tardisID).targetPosition = __targetPosition;
        }
    }

    public void setTardisExteriorFacing(UUID tardisID, Direction __targetFacing) {
        this.getTardis(tardisID).target_facing_direction = __targetFacing;
    }

    public void moveTardisToTargetLocation(UUID tardisID) {
        Tardis tardis = getTardis(tardisID);
        moveTARDIS(tardisID, tardis.targetPosition, tardis.target_facing_direction, tardis.target_dimension);
    }

    public boolean doesTardisHaveATargetLocation(UUID tardisID) {
        Tardis tardis = getTardis(tardisID);
        return tardis.targetPosition != null && tardis.target_dimension != null && tardis.target_facing_direction != null;
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
        tag.getBoolean("canFall");
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
        tag.putBoolean("canFall", canFall);
        return tag;
    }

    public TardisWorldSavedData getTardisWorldSavedData() {
        return tardisWorldSavedData;
    }
}
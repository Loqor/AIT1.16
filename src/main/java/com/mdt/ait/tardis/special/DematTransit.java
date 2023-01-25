package com.mdt.ait.tardis.special;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.entities.ControlInteractionEntity;
import com.mdt.ait.common.tileentities.BasicInteriorDoorTile;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.enums.EnumMatState;
import com.mdt.ait.tardis.Tardis;
import com.mdt.ait.tardis.TardisConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.world.ForgeChunkManager;

import java.util.Objects;
import java.util.UUID;

import static java.lang.Math.abs;

public class DematTransit {

    public UUID tardisID;

    public boolean isReadyForRemat = false;

    public BlockPos leverPos;

    public ControlInteractionEntity leverControl;

    public BlockPos landingPosition;

    public BlockState newBlockState;

    public boolean readyForDemat = false;

    public boolean finished = false;

    public boolean waitTillLandingSoundIsOver = false;

    public int landingSoundTick = 0;

    public int tardisX;
    public int tardisY;
    public int tardisZ;
    public int finalTardisX;
    public int finalTardisZ;
    public int finalTardisTicker;
    public boolean areGoingCrossDimensionally = false;

    public DematTransit(UUID tardisID) {
        this.tardisID = tardisID;
    }

    public int runTransitFormula() {
        Tardis tardis = AIT.tardisManager.getTardis(tardisID);
        tardisX = tardis.exterior_position.getX() % tardis.targetPosition.getX();
        tardisZ = tardis.exterior_position.getZ() % tardis.targetPosition.getZ();
        finalTardisX = abs(tardisX);
        finalTardisZ = abs(tardisZ);
        finalTardisTicker = (int) Math.sqrt(tardis.targetPosition.getX() ^ 2 + tardis.targetPosition.getZ() ^ 2);
        return finalTardisTicker;
    }

    public int getFlightTicks() {
        return runTransitFormula(); // @TODO: LOQOR MAKE A FORMULA FOR THIS
    }

    public void finishedDematAnimation() {
        if (this.tardisID != null) {
            Tardis tardis = AIT.tardisManager.getTardis(tardisID);
            ServerWorld oldDimension = AIT.server.getLevel(tardis.exterior_dimension);
            ServerWorld newDimension = AIT.server.getLevel(tardis.target_dimension);
            assert oldDimension != null;
            assert newDimension != null;
            tardis.landed = false;
            if (!TardisConfig.cantLandOnBlockList.contains(newDimension.getBlockState(tardis.targetPosition.below(1)).getBlock())) { // Checks if the block below the tardis's target position is a valid block to land on
                if (newDimension.getBlockState(tardis.targetPosition.above(1)).getBlock().equals(Blocks.AIR)) {
                    landTardisPart1(tardis.targetPosition);
                }
            } else {
                int increase = 0;
                BlockPos targetPos;
                boolean upFailed = false;
                boolean downFailed = false;
                while (true) {
                    increase += 1;
                    if (!upFailed) {
                        if (!TardisConfig.cantLandOnBlockList.contains(newDimension.getBlockState(tardis.targetPosition.above(increase)).getBlock())) {
                            //(newDimension.getBlockState(tardis.targetPosition.above(increase)).getBlock());
                            if (newDimension.getBlockState(tardis.targetPosition.above(increase + 1)).getBlock().equals(Blocks.AIR) && newDimension.getBlockState(tardis.targetPosition.above(increase + 2)).getBlock().equals(Blocks.AIR)) {
                                targetPos = tardis.targetPosition.above(increase + 1);
                                landTardisPart1(targetPos);
                                break;
                            }
                        }

                        if (tardis.targetPosition.above(increase + 2).getY() >= 255) {
                            upFailed = true;
                            increase = 0;
                        }
                    } else {
                        if (!TardisConfig.cantLandOnBlockList.contains(newDimension.getBlockState(tardis.targetPosition.below(increase)).getBlock())) {
                            if (newDimension.getBlockState(tardis.targetPosition.above(increase + 1)).getBlock().equals(Blocks.AIR) && newDimension.getBlockState(tardis.targetPosition.above(increase + 2)).getBlock().equals(Blocks.AIR)) {
                                targetPos = tardis.targetPosition.below(increase);
                                landTardisPart1(targetPos.above(1));
                                break;
                            }
                        }

                        if (tardis.targetPosition.below(increase + 2).getY() <= 0) {
                            downFailed = true;
                            break;
                        }
                    }

                }
                if (upFailed && downFailed) {
                    landTardisPart1(tardis.targetPosition);
                }
            }
        }
    }

    public void landTardisPart1(BlockPos landing_position) {
        this.landingPosition = landing_position;
        Tardis tardis = AIT.tardisManager.getTardis(tardisID);
        ServerWorld oldDimension = AIT.server.getLevel(tardis.exterior_dimension);
        ServerWorld newDimension = AIT.server.getLevel(tardis.target_dimension);
        ServerWorld tardisDimension = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        assert oldDimension != null;
        BlockState oldBlockState = oldDimension.getBlockState(tardis.exterior_position);
        TardisTileEntity oldTardisTileEntity = (TardisTileEntity) oldDimension.getBlockEntity(tardis.exterior_position);
        assert oldTardisTileEntity != null;
        this.newBlockState = oldBlockState.setValue(TardisBlock.isExistingTardis, true).setValue(TardisBlock.FACING, tardis.target_facing_direction);
        assert newDimension != null;
        assert tardisDimension != null;
        ForgeChunkManager.forceChunk(oldDimension, AIT.MOD_ID, tardis.exterior_position, newDimension.getChunk(tardis.exterior_position).getPos().x, newDimension.getChunk(tardis.exterior_position).getPos().z, true, true);
        ForgeChunkManager.forceChunk(tardisDimension, AIT.MOD_ID, tardis.interior_door_position, tardisDimension.getChunk(tardis.interior_door_position).getPos().x, tardisDimension.getChunk(tardis.interior_door_position).getPos().z, true, true);
        oldDimension.removeBlock(tardis.exterior_position, false);
        readyForDemat = true;
        // pass or something idk
    }

    public void failLandTardis() {
        // yoink, taken from right above you fool.
        // (aaaaaaaaaaaaaa)
        this.readyForDemat = false;
        Tardis tardis = AIT.tardisManager.getTardis(tardisID);
        tardis.landed = false;
        ServerWorld newDimension = AIT.server.getLevel(tardis.target_dimension);
        ServerWorld tardisDim = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        assert newDimension != null;
        assert tardisDim != null;
        ForgeChunkManager.forceChunk(newDimension, AIT.MOD_ID, landingPosition, newDimension.getChunk(landingPosition).getPos().x, newDimension.getChunk(landingPosition).getPos().z, true, true);
        newDimension.setBlockAndUpdate(landingPosition, newBlockState);
        TardisTileEntity newTardisTileEntity = (TardisTileEntity) newDimension.getBlockEntity(landingPosition);
        BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) tardisDim.getBlockEntity(tardis.interior_door_position);
        assert newTardisTileEntity != null;
        assert tardis.exteriorType != null;
        newTardisTileEntity.setExterior(tardis.exteriorType);
        if(basicInteriorDoorTile != null) {
            basicInteriorDoorTile.setInteriorDoor(tardis.interiorDoorType);
        }
        newTardisTileEntity.linked_tardis_id = tardis.tardisID;
        newTardisTileEntity.setDoorState(EnumDoorState.CLOSED);
        newTardisTileEntity.linked_tardis = tardis;
        newTardisTileEntity.setMatState(EnumMatState.FAIL_REMAT);
        newTardisTileEntity.dematTransit = this;
        tardis.targetPosition = landingPosition;
        newDimension.setBlockEntity(landingPosition, newTardisTileEntity);
        if (!newDimension.getBlockState(landingPosition.above(1)).getBlock().equals(Blocks.AIR)) {
            newDimension.removeBlock(landingPosition.above(1), false);
        }
        tardis.__moveExterior(landingPosition, tardis.target_facing_direction, tardis.target_dimension);
    }

    public void landTardisPart2() {
        this.readyForDemat = false;
        Tardis tardis = AIT.tardisManager.getTardis(tardisID);
        tardis.landed = false;
        ServerWorld newDimension = AIT.server.getLevel(tardis.target_dimension);
        ServerWorld tardisDim = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        assert newDimension != null;
        assert tardisDim != null;
        ForgeChunkManager.forceChunk(newDimension, AIT.MOD_ID, landingPosition, newDimension.getChunk(landingPosition).getPos().x, newDimension.getChunk(landingPosition).getPos().z, true, true);
        newDimension.setBlockAndUpdate(landingPosition, newBlockState);
        TardisTileEntity newTardisTileEntity = (TardisTileEntity) newDimension.getBlockEntity(landingPosition);
        BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) tardisDim.getBlockEntity(tardis.interior_door_position);
        assert newTardisTileEntity != null;
        assert tardis.exteriorType != null;
        newTardisTileEntity.setExterior(tardis.exteriorType);
        if(basicInteriorDoorTile != null) {
            basicInteriorDoorTile.setInteriorDoor(tardis.interiorDoorType);
        }
        newTardisTileEntity.linked_tardis_id = tardis.tardisID;
        newTardisTileEntity.setDoorState(EnumDoorState.CLOSED);
        newTardisTileEntity.linked_tardis = tardis;
        newTardisTileEntity.setMatState(EnumMatState.REMAT);
        newTardisTileEntity.dematTransit = this;
        tardis.targetPosition = landingPosition;
        newDimension.setBlockEntity(landingPosition, newTardisTileEntity);
        if (!newDimension.getBlockState(landingPosition.above(1)).getBlock().equals(Blocks.AIR)) {
            newDimension.removeBlock(landingPosition.above(1), false);
        }
        tardis.__moveExterior(landingPosition, tardis.target_facing_direction, tardis.target_dimension);
    }

    public void finished() {
        Tardis tardis = AIT.tardisManager.getTardis(tardisID);
        tardis.lockedTardis = false;
        tardis.landed = true;
        ServerWorld exteriorDimension = AIT.server.getLevel(tardis.exterior_dimension);
        ServerWorld tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        assert exteriorDimension != null;
        TardisTileEntity tardisTileEntity = (TardisTileEntity) exteriorDimension.getBlockEntity(tardis.exterior_position);
        assert tardisTileEntity != null;
        tardisTileEntity.setLockedState(false, EnumDoorState.CLOSED);
        assert tardisWorld != null;
        if (tardis.interior_door_position != null) {
            if (Objects.requireNonNull(AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION)).getBlockEntity(tardis.interior_door_position) instanceof BasicInteriorDoorTile) {
                BasicInteriorDoorTile interiorDoorTile = (BasicInteriorDoorTile) tardisWorld.getBlockEntity(tardis.interior_door_position);
                assert interiorDoorTile != null;
                interiorDoorTile.setLockedState(false, EnumDoorState.CLOSED);
            }
        }
        if(!this.waitTillLandingSoundIsOver) {
            while (this.landingSoundTick < 660) {
                this.landingSoundTick += 1;
            }
        }
        if(this.landingSoundTick == 660) {
            this.waitTillLandingSoundIsOver = true;
        }
        if(this.waitTillLandingSoundIsOver) {
            this.finished = true;
        }
        //System.out.println(this.waitTillLandingSoundIsOver + " + " + this.landingSoundTick);
    }
}

package com.mdt.ait.tardis.special;

import com.mdt.ait.common.entities.ControlInteractionEntity;
import io.mdt.ait.tardis.TARDIS;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.UUID;

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

    public DematTransit(UUID tardisId) {
        this.tardisID = tardisId;
    }

    public int runTransitFormula() {
        /*Tardis tardis = AIT.tardisManager.getTardis(tardisID);
        if(tardis.exteriorPosition.getX() != 0) {
            tardisX = tardis.exteriorPosition.getX() % tardis.targetPosition.getX();
        } else {
            tardisX = tardis.exteriorPosition.getX() + tardis.targetPosition.getX();
        }
        if(tardis.exteriorPosition.getZ() != 0) {
            tardisZ = tardis.exteriorPosition.getZ() % tardis.targetPosition.getZ();
        } else {
            tardisZ = tardis.exteriorPosition.getZ() + tardis.targetPosition.getZ();
        }
        finalTardisX = abs(tardisX);
        finalTardisZ = abs(tardisZ);
        finalTardisTicker = (int) Math.sqrt(tardis.targetPosition.getX() ^ 2 + tardis.targetPosition.getZ() ^ 2);*/
        return finalTardisTicker;
    }

    public int getFlightTicks() {
        return runTransitFormula(); // @TODO: LOQOR MAKE A FORMULA FOR THIS
    }

    public void finishedDematAnimation() {
        /*if (this.tardisID != null) {
            Tardis tardis = AIT.tardisManager.getTardis(tardisID);
            ServerWorld oldDimension = AIT.server.getLevel(tardis.exterior_dimension);
            ServerWorld newDimension = AIT.server.getLevel(tardis.targetDimension);
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
        }*/
    }

    public void landTardisPart1(BlockPos landing_position) {
        /*this.landingPosition = landing_position;
        Tardis tardis = AIT.tardisManager.getTardis(tardisID);
        ServerWorld oldDimension = AIT.server.getLevel(tardis.exterior_dimension);
        ServerWorld newDimension = AIT.server.getLevel(tardis.targetDimension);
        ServerWorld tardisDimension = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        assert oldDimension != null;
        BlockState oldBlockState = oldDimension.getBlockState(tardis.exteriorPosition);
        TardisTileEntity oldTardisTileEntity = (TardisTileEntity) oldDimension.getBlockEntity(tardis.exteriorPosition);
        assert oldTardisTileEntity != null;
        this.newBlockState = oldBlockState.setValue(TardisBlock.isExistingTardis, true).setValue(TardisBlock.FACING, tardis.targetFacingDirection);
        assert newDimension != null;
        assert tardisDimension != null;
        ForgeChunkManager.forceChunk(oldDimension, AIT.MOD_ID, tardis.exteriorPosition, newDimension.getChunk(tardis.exteriorPosition).getPos().x, newDimension.getChunk(tardis.exteriorPosition).getPos().z, true, true);
        ForgeChunkManager.forceChunk(tardisDimension, AIT.MOD_ID, tardis.interiorDoorPosition, tardisDimension.getChunk(tardis.interiorDoorPosition).getPos().x, tardisDimension.getChunk(tardis.interiorDoorPosition).getPos().z, true, true);
        oldDimension.removeBlock(tardis.exteriorPosition, false);
        readyForDemat = true;*/
        // pass or something idk
    }


    // Function that lands the tardis somewhere, makes it do a funky fade and sends it back where it came from
    // @TODO fix fading not working suddenly
    public static void failLandTardis(TARDIS tardis, BlockPos blockpos, World world, PlayerEntity playerentity, BlockPos oldPos, RegistryKey oldDimension, Direction oldDirection) {
        /*tardis.setInteriorDoorState(EnumDoorState.CLOSED);
        tardis.setExteriorDoorState(EnumDoorState.CLOSED);
        ServerWorld exteriorWorld = AIT.server.getLevel(tardis.exterior_dimension);
        ServerWorld interiorWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        interiorWorld.playSound(null, tardis.centerPosition, AITSounds.TARDIS_FAIL_LANDING.get(), SoundCategory.MASTER, 1f, 1f);
        exteriorWorld.playSound(null, tardis.exteriorPosition, AITSounds.TARDIS_FAIL_LANDING.get(), SoundCategory.MASTER, 1f, 1f);
        lockTardis(tardis,true);
        BlockPos targetPosition = new BlockPos(blockpos.getX(), blockpos.getY() + 1, blockpos.getZ());
        AIT.tardisManager.setTardisTargetBlockPos(tardis.tardisId, targetPosition);
        tardis.targetDimension = world.dimension();
        tardis.targetFacingDirection = flipDirection(playerentity);
        DematTransit dematTransit = AIT.tardisManager.moveTardisToTargetLocation(tardis.tardisId);
        dematTransit.finishedDematAnimation();
        dematTransit.failLandTardisPart2();
        AIT.tardisManager.setTardisTargetBlockPos(tardis.tardisId, oldPos);
        tardis.targetDimension = oldDimension;
        tardis.targetFacingDirection = oldDirection;*/
    }

    public void failLandTardisPart2() {
        // yoink, taken from landTardisPart2 you fool.
        // (aaaaaaaaaaaaaa)
        /*this.readyForDemat = false;
        Tardis tardis = AIT.tardisManager.getTardis(tardisID);
        tardis.landed = false;
        ServerWorld newDimension = AIT.server.getLevel(tardis.targetDimension);
        ServerWorld tardisDim = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        assert newDimension != null;
        assert tardisDim != null;
        ForgeChunkManager.forceChunk(newDimension, AIT.MOD_ID, landingPosition, newDimension.getChunk(landingPosition).getPos().x, newDimension.getChunk(landingPosition).getPos().z, true, true);
        newDimension.setBlockAndUpdate(landingPosition, newBlockState);
        TardisTileEntity newTardisTileEntity = (TardisTileEntity) newDimension.getBlockEntity(landingPosition);
        BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) tardisDim.getBlockEntity(tardis.interiorDoorPosition);
        assert newTardisTileEntity != null;
        assert tardis.exteriorType != null;
        newTardisTileEntity.setExterior(tardis.exteriorType);
        if(basicInteriorDoorTile != null) {
            basicInteriorDoorTile.setInteriorDoor(tardis.interiorDoorType);
        }
        newTardisTileEntity.linkedTardisId = tardis.tardisId;
        newTardisTileEntity.setDoorState(EnumDoorState.CLOSED);
        newTardisTileEntity.linkedTardis = tardis;
        newTardisTileEntity.setMatState(EnumMatState.FAIL_REMAT);
        newTardisTileEntity.dematTransit = this;
        tardis.targetPosition = landingPosition;
        newDimension.setBlockEntity(landingPosition, newTardisTileEntity);
        if (!newDimension.getBlockState(landingPosition.above(1)).getBlock().equals(Blocks.AIR)) {
            newDimension.removeBlock(landingPosition.above(1), false);
        }
        tardis.__moveExterior(landingPosition, tardis.targetFacingDirection, tardis.targetDimension);*/
    }

    public void landTardisPart2() {
        /*this.readyForDemat = false;
        Tardis tardis = AIT.tardisManager.getTardis(tardisID);
        tardis.landed = false;
        ServerWorld newDimension = AIT.server.getLevel(tardis.targetDimension);
        ServerWorld tardisDim = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        assert newDimension != null;
        assert tardisDim != null;
        ForgeChunkManager.forceChunk(newDimension, AIT.MOD_ID, landingPosition, newDimension.getChunk(landingPosition).getPos().x, newDimension.getChunk(landingPosition).getPos().z, true, true);
        newDimension.setBlockAndUpdate(landingPosition, newBlockState);
        TardisTileEntity newTardisTileEntity = (TardisTileEntity) newDimension.getBlockEntity(landingPosition);
        BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) tardisDim.getBlockEntity(tardis.interiorDoorPosition);
        assert newTardisTileEntity != null;
        assert tardis.exteriorType != null;
        newTardisTileEntity.setExterior(tardis.exteriorType);
        if(basicInteriorDoorTile != null) {
            basicInteriorDoorTile.setInteriorDoor(tardis.interiorDoorType);
        }
        newTardisTileEntity.linkedTardisId = tardis.tardisId;
        newTardisTileEntity.setDoorState(EnumDoorState.CLOSED);
        newTardisTileEntity.linkedTardis = tardis;
        newTardisTileEntity.setMatState(EnumMatState.REMAT);
        newTardisTileEntity.dematTransit = this;
        tardis.targetPosition = landingPosition;
        newDimension.setBlockEntity(landingPosition, newTardisTileEntity);
        if (!newDimension.getBlockState(landingPosition.above(1)).getBlock().equals(Blocks.AIR)) {
            newDimension.removeBlock(landingPosition.above(1), false);
        }
        tardis.__moveExterior(landingPosition, tardis.targetFacingDirection, tardis.targetDimension);*/
    }

    public void finished() {
        /*Tardis tardis = AIT.tardisManager.getTardis(tardisID);
        tardis.lockedTardis = false;
        tardis.landed = true;
        ServerWorld exteriorDimension = AIT.server.getLevel(tardis.exterior_dimension);
        ServerWorld tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        assert exteriorDimension != null;
        TardisTileEntity tardisTileEntity = (TardisTileEntity) exteriorDimension.getBlockEntity(tardis.exteriorPosition);
        assert tardisTileEntity != null;
        tardisTileEntity.setLockedState(false, EnumDoorState.CLOSED);
        assert tardisWorld != null;
        if (tardis.interiorDoorPosition != null) {
            if (Objects.requireNonNull(AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION)).getBlockEntity(tardis.interiorDoorPosition) instanceof BasicInteriorDoorTile) {
                BasicInteriorDoorTile interiorDoorTile = (BasicInteriorDoorTile) tardisWorld.getBlockEntity(tardis.interiorDoorPosition);
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
        }*/
        //System.out.println(this.waitTillLandingSoundIsOver + " + " + this.landingSoundTick);
    }
}

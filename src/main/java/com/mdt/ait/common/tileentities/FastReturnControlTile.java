package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.FastReturnControlBlock;
import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.core.init.AITTiles;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.UUID;

public class FastReturnControlTile extends TileEntity implements ITickableTileEntity {
    public UUID tardisID;

    public FastReturnControlTile() {
        super(AITTiles.TARDIS_FAST_RETURN_CONTROL_TILE_ENTITY_TYPE.get());
    }

    public ActionResultType useOn(World world, PlayerEntity playerEntity, BlockPos blockpos, Hand hand, BlockRayTraceResult pHit) {
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (block instanceof FastReturnControlBlock && hand == Hand.MAIN_HAND) {
            playerEntity.playSound(AITSounds.BUTTON_PRESS.get(), 5, 1);
            if (this.tardisID != null) {
                if(!level.isClientSide) {
                    /*Tardis tardis = AIT.tardisManager.getTardis(this.tardisID);
                    AIT.tardisManager.setTardisTargetBlockPos(tardisID, tardis.previousExteriorPos);
                    tardis.targetFacingDirection = tardis.previousDirection;
                    tardis.targetDimension = tardis.previous_dimension;
                    if (playerEntity != null) {
                        playerEntity.sendMessage(new TranslationTextComponent("Set Coords to " + tardis.previousExteriorPos.getX() + " " + tardis.previousExteriorPos.getY() + " " + tardis.previousExteriorPos.getZ()).setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW).withItalic(true)), UUID.randomUUID());
                    }*/
                }
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public void tick() {

    }
}

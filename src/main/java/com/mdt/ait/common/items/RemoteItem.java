package com.mdt.ait.common.items;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.BasicInteriorDoorBlock;
import com.mdt.ait.common.blocks.BasicRotorBlock;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.tardis.special.DematTransit;
import io.mdt.ait.tardis.TARDIS;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class RemoteItem extends Item {

    private int ticks;
    private boolean isFailing;
    private TARDIS tardis;

    public RemoteItem(Item.Properties properties) {
        super(properties.stacksTo(1));
    }


    // (mostly) COPIED FROM TARDISKey file
    // Edited for RemoteItem Usage
    public DematTransit dematTransit;
    @Override
    public ActionResultType useOn(ItemUseContext context) {
        CompoundNBT tag = context.getItemInHand().getOrCreateTag();
        ItemStack itemInHand = context.getItemInHand();
        PlayerEntity playerentity = context.getPlayer();
        World world = playerentity.level;
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (!(block instanceof TardisBlock) && !(block instanceof BasicInteriorDoorBlock) && !(block instanceof BasicRotorBlock)) {
            context.getLevel().playSound(null, context.getClickedPos(), SoundEvents.NOTE_BLOCK_BIT, SoundCategory.MASTER, 1, 0.5f);
            /*this.tardis = AIT.tardisManager.getTardis(TARDISKey.getTardisId(itemInHand));
            if(!world.isClientSide) {
                if (world.dimension() == AITDimensions.TARDIS_DIMENSION) {
                    RegistryKey<World> oldDimension = tardis.exterior_dimension;
                    BlockPos oldPos = tardis.exteriorPosition;
                    Direction oldDirection = tardis.exteriorFacing;
                    playerentity.getCooldowns().addCooldown(this, 200); // 10 seconds in ticks
                    DematTransit.failLandTardis(this.tardis, blockpos,world,playerentity,oldPos,oldDimension,oldDirection);
                } else {
                    playerentity.getCooldowns().addCooldown(this, 100); // 5 seconds in ticks

                    BlockPos targetPosition = new BlockPos(blockpos.getX(), blockpos.getY() + 1, blockpos.getZ());
                    AIT.tardisManager.setTardisTargetBlockPos(this.tardis.tardisId, targetPosition);
                    this.tardis.targetDimension = world.dimension();
                    this.tardis.targetFacingDirection = flipDirection(playerentity);
                    this.dematTransit = AIT.tardisManager.moveTardisToTargetLocation(this.tardis.tardisId);
                    this.dematTransit.finishedDematAnimation();
                    this.dematTransit.landTardisPart2();
                }
            }*/
        }

        if (block instanceof TardisBlock) {
            /*if(TARDISKey.getTardisId(itemInHand).needsInitialization()) {
                TardisTileEntity tardisTileEntity = (TardisTileEntity) world.getBlockEntity(context.getClickedPos());
                assert tardisTileEntity != null;
                if(tardisTileEntity.linkedTardisId != null) {
                    tag.putUUID("tardisIdentification", tardisTileEntity.linkedTardisId);
                }
                tag.putString("greekCharacters", TardisConfig.tardisNamesList.get(random.nextInt(23)) + " "
                        + TardisConfig.tardisNamesList.get(random.nextInt(23)) + " " +
                        TardisConfig.tardisNamesList.get(random.nextInt(23)));
            }*/
        }

        return ActionResultType.sidedSuccess(world.isClientSide());
    }

    // Flips the direction so that the tardis faces the player when it lands
    // Useless function, use player.getDirection().getOpposite() instead! @TODO replace all instances
    public static Direction flipDirection(PlayerEntity player) {
        return player.getDirection().getOpposite();
    }

    @Override
    public void inventoryTick(ItemStack pStack, World pLevel, Entity pEntity, int pItemSlot, boolean pIsSelected) {
        // unused code for dematting as it just insta tps to the spot rn due to null errors
        // @TODO fix remote demat
//        if (isDematerialising) {
//            ticks++;
//            if (ticks <= 320) {
//                if (dematTransit != null) {
//                    ticks = 0;
//                    isDematerialising = false;
//                    isRematerialising = true;
//                }
//            }
//        }
//        if (isRematerialising) {
//            if (dematTransit != null) {
//                dematTransit.finishedDematAnimation();
//                dematTransit.landTardisPart2();
//            }
//            isRematerialising = false;
//        }
//        if (isDematerialising) {
//            ticks++;
//            if(ticks >= 180) {
//                if (this.dematTransit != null) {
//                    landTardis();
//                }
//                ticks = 0;
//            }
//        }
        if (isFailing) {
            ticks++;
            if (ticks >= 220) {
                //lockTardis(this.tardis,false);
                ticks = 0;
                isFailing = false;
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pItemSlot, pIsSelected);
    }

    public static void lockTardis(TARDIS tardis, boolean locked) {
        /*ServerWorld tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);

        if (tardis.interiorDoorPosition != null) {
            if (Objects.requireNonNull(AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION)).getBlockEntity(tardis.interiorDoorPosition) instanceof BasicInteriorDoorTile) {
                assert tardisWorld != null;
                BasicInteriorDoorTile interiorDoorTile = (BasicInteriorDoorTile) tardisWorld.getBlockEntity(tardis.interiorDoorPosition);
                assert interiorDoorTile != null;
                interiorDoorTile.setLockedState(locked, EnumDoorState.CLOSED);
            }
        }*/
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        /*if(TARDISKey.getTardisId(stack).needsInitialization()) {
            tooltip.add(new TranslationTextComponent("Remote ID: " + TARDISKey.getGreekCharacters(stack))
                    .setStyle(Style.EMPTY.withItalic(true).withColor(TextFormatting.AQUA)));
            tooltip.add(new TranslationTextComponent("Linked TARDIS: " + TARDISKey.getTardisId(stack))
                    .setStyle(Style.EMPTY.withItalic(true).withColor(TextFormatting.DARK_AQUA)));
        } else {
            tooltip.add(new TranslationTextComponent("Link to TARDIS via the exterior!")
                    .setStyle(Style.EMPTY.withItalic(true).withColor(TextFormatting.AQUA)));
            // i tricked you!
            // you got me mzsty - Duzo
        }*/
    }
}

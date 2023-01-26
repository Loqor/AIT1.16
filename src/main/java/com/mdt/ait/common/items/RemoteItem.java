package com.mdt.ait.common.items;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.BasicInteriorDoorBlock;
import com.mdt.ait.common.blocks.BasicRotorBlock;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.BasicInteriorDoorTile;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.tardis.Tardis;
import com.mdt.ait.tardis.TardisConfig;
import com.mdt.ait.tardis.special.DematTransit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Dimension;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

import static com.mdt.ait.tardis.special.DematTransit.failLandTardis;

public class RemoteItem extends Item {
    public RemoteItem(Item.Properties p_i48487_1_) {
        super(p_i48487_1_.stacksTo(1));
    }
    private int ticks;
    private boolean isFailing;
    private Tardis tardis;

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
            if (TARDISKey.getTardisId(itemInHand) != null) {
                this.tardis = AIT.tardisManager.getTardis(TARDISKey.getTardisId(itemInHand));
                if(!world.isClientSide) {
                    if (world.dimension() == AITDimensions.TARDIS_DIMENSION) {
                        RegistryKey oldDimension = tardis.exterior_dimension;
                        BlockPos oldPos = tardis.exterior_position;
                        Direction oldDirection = tardis.exterior_facing;
                        playerentity.getCooldowns().addCooldown(this, 200); // 10 seconds in ticks
                        failLandTardis(this.tardis, blockpos,world,playerentity,oldPos,oldDimension,oldDirection);

                    } else {
                        playerentity.getCooldowns().addCooldown(this, 100); // 5 seconds in ticks

                        BlockPos targetPosition = new BlockPos(blockpos.getX(), blockpos.getY() + 1, blockpos.getZ());
                        AIT.tardisManager.setTardisTargetBlockPos(this.tardis.tardisID, targetPosition);
                        this.tardis.target_dimension = world.dimension();
                        this.tardis.target_facing_direction = flipDirection(playerentity);
                        this.dematTransit = AIT.tardisManager.moveTardisToTargetLocation(this.tardis.tardisID);
                        this.dematTransit.finishedDematAnimation();
                        this.dematTransit.landTardisPart2();
                    }
                }
            }

        }

        if (block instanceof TardisBlock) {
            if(TARDISKey.getTardisId(itemInHand) == null) {
                TardisTileEntity tardisTileEntity = (TardisTileEntity) world.getBlockEntity(context.getClickedPos());
                assert tardisTileEntity != null;
                tag.putUUID("tardisIdentification", tardisTileEntity.linked_tardis_id);
                tag.putString("greekCharacters", TardisConfig.tardisNamesList.get(random.nextInt(23)) + " "
                        + TardisConfig.tardisNamesList.get(random.nextInt(23)) + " " +
                        TardisConfig.tardisNamesList.get(random.nextInt(23)));
            }
        }
        return ActionResultType.sidedSuccess(world.isClientSide());
    }

    // Flips the direction so that the tardis faces the player when it lands
    public static Direction flipDirection(PlayerEntity player) {
        if (player.getDirection() == Direction.EAST) {
            return Direction.WEST;
        }
        if (player.getDirection() == Direction.WEST) {
            return Direction.EAST;
        }
        if (player.getDirection() == Direction.NORTH) {
            return Direction.SOUTH;
        }
        if (player.getDirection() == Direction.SOUTH) {
            return Direction.NORTH;
        }
        return Direction.NORTH; // if all else fails, just face to the north
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
                lockTardis(this.tardis,false);
                ticks = 0;
                isFailing = false;
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pItemSlot, pIsSelected);
    }

    public static void lockTardis(Tardis tardis,boolean locked) {
        ServerWorld tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        // cheeky copy from DematTransit:189 cus it was causing crashes previously
        if (tardis.interior_door_position != null) {
            if (Objects.requireNonNull(AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION)).getBlockEntity(tardis.interior_door_position) instanceof BasicInteriorDoorTile) {
                assert tardisWorld != null;
                BasicInteriorDoorTile interiorDoorTile = (BasicInteriorDoorTile) tardisWorld.getBlockEntity(tardis.interior_door_position);
                assert interiorDoorTile != null;
                interiorDoorTile.setLockedState(locked, EnumDoorState.CLOSED);
            }
        }
    }

//    public void failLandTardis(Tardis tardis,DematTransit dematTransit, BlockPos blockpos, World world, PlayerEntity playerentity, BlockPos oldPos, RegistryKey oldDimension, Direction oldDirection) {
//        tardis.setInteriorDoorState(EnumDoorState.CLOSED);
//        tardis.setExteriorDoorState(EnumDoorState.CLOSED);
//        ServerWorld exteriorWorld = AIT.server.getLevel(tardis.exterior_dimension);
//        ServerWorld interiorWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
//        interiorWorld.playSound(null, tardis.center_position, AITSounds.TARDIS_FAIL_LANDING.get(), SoundCategory.MASTER, 1f, 1f);
//        exteriorWorld.playSound(null, tardis.exterior_position, AITSounds.TARDIS_FAIL_LANDING.get(), SoundCategory.MASTER, 1f, 1f);
//        lockTardis(true);
//        BlockPos targetPosition = new BlockPos(blockpos.getX(), blockpos.getY() + 1, blockpos.getZ());
//        AIT.tardisManager.setTardisTargetBlockPos(tardis.tardisID, targetPosition);
//        tardis.target_dimension = world.dimension();
//        tardis.target_facing_direction = flipDirection(playerentity);
//        dematTransit = AIT.tardisManager.moveTardisToTargetLocation(this.tardis.tardisID);
//        dematTransit.finishedDematAnimation();
//        dematTransit.failLandTardis();
//        AIT.tardisManager.setTardisTargetBlockPos(this.tardis.tardisID, oldPos);
//        tardis.target_dimension = oldDimension;
//        tardis.target_facing_direction = oldDirection;
//    }

//    private void landTardis() {
//        if (isDematerialising) {
//            while (landingTicks <= 660) {
//                landingTicks++;
//            }
//        }
//
//        if (landingTicks >= 660) {
//            isDematerialising = false;
//        }
//
//        if (!isDematerialising) {
//            dematTransit.finishedDematAnimation();
//            dematTransit.landTardisPart2();
//        }
//        landingTicks = 0;
//    }


    @Override
    public void appendHoverText(ItemStack pStack, @Nullable World pWorldIn, List<ITextComponent> pTooltip, ITooltipFlag pFlagIn) {
        super.appendHoverText(pStack, pWorldIn, pTooltip, pFlagIn);
        if(TARDISKey.getTardisId(pStack) != null) {
            pTooltip.add(new TranslationTextComponent("Remote ID: " + TARDISKey.getGreekCharacters(pStack))
                    .setStyle(Style.EMPTY.withItalic(true).withColor(TextFormatting.AQUA)));
            pTooltip.add(new TranslationTextComponent("Linked TARDIS: " + TARDISKey.getTardisId(pStack))
                    .setStyle(Style.EMPTY.withItalic(true).withColor(TextFormatting.DARK_AQUA)));
        } else {
            pTooltip.add(new TranslationTextComponent("Link to TARDIS via the exterior!")
                    .setStyle(Style.EMPTY.withItalic(true).withColor(TextFormatting.AQUA)));
            // i tricked you!
            // you got me mzsty - Duzo
        }
    }
}

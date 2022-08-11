package com.mdt.ait.common.items;

import com.mdt.ait.client.models.tileentities.Typewriter;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.blocks.TestBlock;
import com.mdt.ait.common.blocks.TypewriterBlock;
import com.mdt.ait.common.tileentities.ConsoleTileEntity;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.AITItems;
import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.itemgroups.AITItemGroups;
import com.mdt.ait.tardis.TardisInteriors;
import com.mdt.ait.tardis.interiors.TardisInterior;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.LogicalSidedProvider;
import org.apache.logging.log4j.core.jmx.Server;
import com.mdt.ait.common.blocks.ConsoleBlock;

import javax.annotation.Nullable;
import java.util.List;

import static com.mdt.ait.core.init.enums.EnumDoorState.*;
import static net.minecraft.block.DoorBlock.OPEN;
import static net.minecraft.block.RedstoneLampBlock.LIT;
import static net.minecraft.block.RedstoneWireBlock.POWER;

public class SonicItem extends Item {
    private static final Integer COOLDOWN_TIME = 20;
    private static final Integer REDSTONE_COOLDOWN_TIME = 10;
    public EnumExteriorType currentexterior = EnumExteriorType.BASIC_BOX;

//    public EnumExteriorType getNextExterior() {
//        switch (currentexterior) {
//            case BASIC_BOX:
//                return EnumExteriorType.MINT_BOX;
//            case MINT_BOX:
//                return EnumExteriorType.BASIC_BOX;
//        }
//        return EnumExteriorType.BASIC_BOX;
//    }
//
//    public void setExterior(EnumExteriorType exterior) {
//        this.currentexterior = exterior;
//    }

    public SonicItem(Properties tab) {
        super(new Item.Properties().stacksTo(1).tab(AITItemGroups.AITITEMS));
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable World pWorldIn, List<ITextComponent> pTooltip, ITooltipFlag pFlagIn) {
        super.appendHoverText(pStack, pWorldIn, pTooltip, pFlagIn);
        pTooltip.add(new TranslationTextComponent("Sonic Screwdriver"));
    }

    @Override
    public void onUseTick(World pWorldIn, LivingEntity pLivingEntityIn, ItemStack pStack, int pCount) {

    }

    public ActionResultType useOn(ItemUseContext context) {
        PlayerEntity playerentity = context.getPlayer();
        assert playerentity != null;
        World world = playerentity.level;
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        Item item = playerentity.getMainHandItem().getItem();
        if (CampfireBlock.canLight(blockstate)) {
            world.setBlock(blockpos, blockstate.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
        }
        if (block instanceof TypewriterBlock && playerentity.isCrouching()) {
            world.playSound(null, playerentity.getX(), playerentity.getY(), playerentity.getZ(), AITSounds.TYPEWRITER_DING.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
            return ActionResultType.sidedSuccess(world.isClientSide());
        }
        if (block instanceof TNTBlock) {
            playerentity.level.removeBlock(blockpos, true);
            TNTEntity tnt = new TNTEntity(world, (double) ((float) blockpos.getX() + 0.5F), (double) blockpos.getY(), (double) ((float) blockpos.getZ() + 0.5F), playerentity);
            world.addFreshEntity(tnt);
            world.playSound(null, tnt.getX(), tnt.getY(), tnt.getZ(), SoundEvents.TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResultType.sidedSuccess(world.isClientSide());
        }
//        if (block instanceof TardisBlock && playerentity.isCrouching()) {
//            TileEntity tileEntity = world.getBlockEntity(blockpos);
//            if(tileEntity instanceof TardisTileEntity) {
//                ((TardisTileEntity) tileEntity).useOnTardis(context, blockpos, blockstate, block);
//            }
//            System.out.println("Idk if this is working or not");
//            return ActionResultType.sidedSuccess(world.isClientSide());
//        }

        if (block instanceof ConsoleBlock && playerentity.isCrouching()) {
            TileEntity tileEntity = world.getBlockEntity(blockpos);
            if(tileEntity instanceof ConsoleTileEntity) {
                ((ConsoleTileEntity) tileEntity).useOnConsole(context, blockpos, blockstate, block);
            }
            System.out.println("Idk if this is working or not");
            return ActionResultType.sidedSuccess(world.isClientSide());
        }

        if (block instanceof DoorBlock) {
            world.setBlock(blockpos, blockstate.setValue(OPEN, !blockstate.getValue(OPEN)), 10);
            world.levelEvent(playerentity, blockstate.getValue(OPEN) ? blockstate.getMaterial() == Material.METAL ? 1005 : 1006 : blockstate.getMaterial() == Material.METAL ? 1011 : 1012, blockpos, 0);
        }
        if (block instanceof TrapDoorBlock) {
            world.setBlock(blockpos, blockstate.setValue(OPEN, !blockstate.getValue(OPEN)), 10);
            world.levelEvent(playerentity, blockstate.getValue(OPEN) ? blockstate.getMaterial() == Material.METAL ? 1005 : 1006 : blockstate.getMaterial() == Material.METAL ? 1011 : 1012, blockpos, 0);
        }



        if (block instanceof RedstoneLampBlock) {
            world.setBlock(blockpos, blockstate.setValue(LIT, !blockstate.getValue(LIT)), 10);
        }
        if (block instanceof RedstoneWireBlock) {
            int i = world.getBestNeighborSignal(blockpos);
            if (i == 15) {
                world.setBlock(blockpos, (BlockState)blockstate.setValue(POWER, i = 0), 2);
            }
            else {
                world.setBlock(blockpos, (BlockState)blockstate.setValue(POWER, i+1), 2);
            }
        }

        world.playSound(null, blockpos.getX(), blockpos.getY(), blockpos.getZ(), AITSounds.SONIC_SOUND.get(), SoundCategory.PLAYERS, 0.25F, 1.0F);
        if (block instanceof RedstoneWireBlock) {
            playerentity.getCooldowns().addCooldown(this, REDSTONE_COOLDOWN_TIME);
        }
        else {
            playerentity.getCooldowns().addCooldown(this, COOLDOWN_TIME);
        }
        if (playerentity.isCrouching()) {
            world.playSound(null, blockpos.getX(), blockpos.getY(), blockpos.getZ(), AITSounds.SONIC_SOUND.get(), SoundCategory.PLAYERS, 0.25F, 1.0F);
            playerentity.getCooldowns().addCooldown(this, COOLDOWN_TIME);
        }

        return ActionResultType.SUCCESS;
    }
}

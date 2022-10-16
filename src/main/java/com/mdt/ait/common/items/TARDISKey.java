package com.mdt.ait.common.items;

import com.mdt.ait.common.blocks.BasicInteriorDoorBlock;
import com.mdt.ait.common.blocks.BasicRotorBlock;
import com.mdt.ait.common.blocks.HartnellRotorBlock;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.BasicInteriorDoorTile;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.AITBlocks;
import com.mdt.ait.core.init.enums.EnumLockState;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

import static com.mdt.ait.core.init.enums.EnumDoorState.BOTH;
import static com.mdt.ait.core.init.enums.EnumDoorState.FIRST;

public class TARDISKey extends Item {

    public TARDISKey(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    public UUID tardisID;

    public String tardisIDForToolTip;

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        PlayerEntity playerentity = context.getPlayer();
        World world = playerentity.level;
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (block instanceof TardisBlock) {
            TileEntity tileEntity = world.getBlockEntity(blockpos);
            if (tileEntity instanceof TardisTileEntity) {
                ((TardisTileEntity) tileEntity).keyUsedOnTardis(context, blockpos, blockstate, block);
            }
        }
        if (block instanceof BasicInteriorDoorBlock) {
            TileEntity tileEntity = world.getBlockEntity(blockpos);
            if (tileEntity instanceof BasicInteriorDoorTile) {
                ((BasicInteriorDoorTile) tileEntity).keyUsedOnTardisDoor(context, blockpos, blockstate, block);
            }
        }
        if (block instanceof BasicRotorBlock) {
            BasicRotorBlock basicRotorBlock = (BasicRotorBlock) block;
            tardisID = basicRotorBlock.tardisID;
            tardisIDForToolTip = basicRotorBlock.tardisID.toString();
        }
        if (block instanceof HartnellRotorBlock) {
            HartnellRotorBlock hartnellRotorBlock = (HartnellRotorBlock) block;
            tardisID = hartnellRotorBlock.tardisID;
            tardisIDForToolTip = hartnellRotorBlock.tardisID.toString();
        }
        return ActionResultType.sidedSuccess(world.isClientSide());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable World pWorldIn, List<ITextComponent> pTooltip, ITooltipFlag pFlagIn) {
        super.appendHoverText(pStack, pWorldIn, pTooltip, pFlagIn);
        if(tardisIDForToolTip != null) {
            pTooltip.add(new TranslationTextComponent(tardisIDForToolTip)
                    .setStyle(Style.EMPTY.withItalic(true).withColor(TextFormatting.YELLOW)));
        } else {
            pTooltip.add(new TranslationTextComponent("Link to TARDIS by clicking on the rotor!")
                    .setStyle(Style.EMPTY.withItalic(true).withColor(TextFormatting.YELLOW)));
        }
    }


}

package com.mdt.ait.common.items;

import com.mdt.ait.common.blocks.BasicInteriorDoorBlock;
import com.mdt.ait.common.blocks.BasicRotorBlock;
import com.mdt.ait.common.blocks.HartnellRotorBlock;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.BasicInteriorDoorTile;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.tardis.TardisConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
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

public class TARDISKey extends Item {

    public TARDISKey(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }


    public static UUID getTardisId(ItemStack stack) {
        CompoundNBT nbt = stack.getOrCreateTag();
        if(nbt.contains("tardisIdentification")) {
            return stack.getOrCreateTag().getUUID("tardisIdentification");
        }
        return null;
    }
    public static String getGreekCharacters(ItemStack stack) {
        CompoundNBT nbt = stack.getOrCreateTag();
        if(nbt.contains("tardisIdentification")) {
            return stack.getOrCreateTag().getString("greekCharacters");
        }
        return null;
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        CompoundNBT tag = context.getItemInHand().getOrCreateTag();
        ItemStack itemInHand = context.getItemInHand();
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
        if (block instanceof TardisBlock) {
            if(TARDISKey.getTardisId(itemInHand) == null) {
                TardisTileEntity tardisTileEntity = (TardisTileEntity) world.getBlockEntity(context.getClickedPos());
                assert tardisTileEntity != null;
                if(tardisTileEntity.linked_tardis_id != null) {
                    tag.putUUID("tardisIdentification", tardisTileEntity.linked_tardis_id);
                }
                tag.putString("greekCharacters", TardisConfig.tardisNamesList.get(random.nextInt(23)) + " "
                        + TardisConfig.tardisNamesList.get(random.nextInt(23)) + " " +
                        TardisConfig.tardisNamesList.get(random.nextInt(23)));
            }
        }
        return ActionResultType.sidedSuccess(world.isClientSide());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable World pWorldIn, List<ITextComponent> pTooltip, ITooltipFlag pFlagIn) {
        super.appendHoverText(pStack, pWorldIn, pTooltip, pFlagIn);
        if(this.getTardisId(pStack) != null) {
            pTooltip.add(new TranslationTextComponent("Key ID: " + TARDISKey.getGreekCharacters(pStack))
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

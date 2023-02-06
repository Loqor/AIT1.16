package com.mdt.ait.common.items;

import com.mdt.ait.common.blocks.BasicInteriorDoorBlock;
import com.mdt.ait.common.blocks.TardisBlock;
import io.mdt.ait.common.tiles.TARDISTileEntity;
import io.mdt.ait.tardis.TARDISInteriorDoorTile;
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

    public TARDISKey(Properties properties) {
        super(properties);
    }

    public static UUID getTardisId(ItemStack stack) {
        return stack.getOrCreateTag().getUUID("uuid");
    }

    public static String getGreekCharacters(ItemStack stack) {
        return stack.getOrCreateTag().getString("greekCharacters");
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        CompoundNBT tag = context.getItemInHand().getOrCreateTag();
        ItemStack itemInHand = context.getItemInHand();
        PlayerEntity player = context.getPlayer();
        World world = player.level;
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (block instanceof TardisBlock) {
            TileEntity tileEntity = world.getBlockEntity(blockpos);
            if (tileEntity instanceof TARDISTileEntity) {
                //((TARDISTileEntity) tileEntity).keyUsedOnTardis(context, blockpos, blockstate, block); fixme
            }
        }
        if (block instanceof BasicInteriorDoorBlock) {
            TileEntity tileEntity = world.getBlockEntity(blockpos);
            if (tileEntity instanceof TARDISInteriorDoorTile) {
                ((TARDISInteriorDoorTile) tileEntity).onKey(context, blockpos);
            }
        }
        if (block instanceof TardisBlock) {
            TARDISKey.getTardisId(itemInHand);
            TARDISTileEntity tardisTileEntity = (TARDISTileEntity) world.getBlockEntity(context.getClickedPos());
            /*if(tardisTileEntity.tard != null) {
                tag.putUUID("tardisIdentification", tardisTileEntity.linkedTardisId);
            }
            tag.putString("greekCharacters", TardisConfig.tardisNamesList.get(random.nextInt(23)) + " "
                    + TardisConfig.tardisNamesList.get(random.nextInt(23)) + " " +
                    TardisConfig.tardisNamesList.get(random.nextInt(23)));*/
        }
        return ActionResultType.sidedSuccess(world.isClientSide());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        /*if(TARDISKey.getTardisId(stack).needsInitialization()) {
            tooltip.add(new TranslationTextComponent("Key ID: " + TARDISKey.getGreekCharacters(stack))
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

package com.mdt.ait.common.items;

import com.mdt.ait.common.blocks.BasicInteriorDoorBlock;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.BasicInteriorDoorTile;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.enums.EnumLockState;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.mdt.ait.core.init.enums.EnumDoorState.BOTH;
import static com.mdt.ait.core.init.enums.EnumDoorState.FIRST;

public class TARDISKey extends Item {

    public TARDISKey(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

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
        return ActionResultType.sidedSuccess(world.isClientSide());
    }
}

package com.mdt.ait.common.items;

import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
            //TardisBlock.LockTardis(context, blockpos, blockstate, block);
            }
        return ActionResultType.SUCCESS;
    }
}

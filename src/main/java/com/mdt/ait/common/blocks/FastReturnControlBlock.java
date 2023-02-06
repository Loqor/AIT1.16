package com.mdt.ait.common.blocks;

import com.mdt.ait.AIT;
import com.mdt.ait.common.tileentities.FastReturnControlTile;
import com.mdt.ait.common.tileentities.TardisCoordinateControlTile;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.AITTiles;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.UUID;

public class FastReturnControlBlock extends Block {

    public FastReturnControlBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    public UUID tardisID;

    @Override
    public ActionResultType use(BlockState pState, World pWorldIn, BlockPos pPos, PlayerEntity pPlayer, Hand pHandIn, BlockRayTraceResult pHit) {
        TileEntity tileEntity = pWorldIn.getBlockEntity(pPos);
        if (tileEntity instanceof FastReturnControlTile) {
            ((FastReturnControlTile) tileEntity).useOn(pWorldIn, pPlayer, pPos, pHandIn, pHit);
        }
        return super.use(pState, pWorldIn, pPos, pPlayer, pHandIn, pHit);
    }

    @Override
    public void onPlace(BlockState blockState1, World world, BlockPos blockPos, BlockState blockState2, boolean bool) {
        super.onPlace(blockState1, world, blockPos, blockState2, bool);
        if (!world.isClientSide && world.dimension() == AITDimensions.TARDIS_DIMENSION) {
            ServerWorld serverWorld = ((ServerWorld) world);
            FastReturnControlTile fastReturnControlTile = (FastReturnControlTile) serverWorld.getBlockEntity(blockPos);
            //this.tardisID = AIT.tardisManager.getTardisIDFromPosition(blockPos);
            assert fastReturnControlTile != null;
            fastReturnControlTile.tardisID = this.tardisID;
            serverWorld.setBlockEntity(blockPos, fastReturnControlTile);
        }
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return AITTiles.TARDIS_FAST_RETURN_CONTROL_TILE_ENTITY_TYPE.get().create();
    }

}

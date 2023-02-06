package com.mdt.ait.common.blocks;

import com.mdt.ait.common.tileentities.PhoneBoothTile;
import com.mdt.ait.common.tileentities.TSVTile;
import com.mdt.ait.common.tileentities.PhoneBoothTile;
import com.mdt.ait.core.init.interfaces.ICantBreak;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Objects;

public class PhoneBoothBlock extends Block implements ICantBreak {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static VoxelShape YES_SHAPE = Block.box(0, 0, 0, 16, 38.25, 16);
    public static VoxelShape COLLIDE_SHAPE = VoxelShapes.or(Block.box(0, 0, 0, 16, 2, 16)/*, Block.box(0, 0, 0, 1, 38.25, 1)*/).optimize();

    public PhoneBoothBlock() {
        super(Properties.of(Material.STONE).strength(15.0f).noOcclusion());
    }

    @Override
    public BlockRenderType getRenderShape(BlockState pState) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public void entityInside(BlockState pState, World pLevel, BlockPos pPos, Entity pEntity) {
        TileEntity tileEntity = pLevel.getBlockEntity(pPos);
        if (tileEntity instanceof PhoneBoothTile) {
            PhoneBoothTile phoneBoothTile = (PhoneBoothTile) tileEntity.getTileEntity();
            phoneBoothTile.entityInside(pState, pLevel, pPos, pEntity);
            if(phoneBoothTile.atNewLocation) {
                BlockPos oldPos = pPos;
                pLevel.setBlock(new BlockPos(pPos.getX(), 128, pPos.getZ()), defaultBlockState(), 3);
                pLevel.setBlockEntity(new BlockPos(pPos.getX(), 128, pPos.getZ()), phoneBoothTile);
                pLevel.removeBlock(oldPos, false);
            }
        }
        super.entityInside(pState, pLevel, pPos, pEntity);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return YES_SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        return COLLIDE_SHAPE;
    }

    @Override
    public ActionResultType use(BlockState pState, World pLevel, BlockPos pPos, PlayerEntity pPlayer, Hand pHand, BlockRayTraceResult pHit) {
        TileEntity tileEntity = pLevel.getBlockEntity(pPos);
        if (tileEntity instanceof PhoneBoothTile) {
            ((PhoneBoothTile) tileEntity).useOn(pLevel, pPlayer, pPos, pHand);
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new PhoneBoothTile();
    }
}

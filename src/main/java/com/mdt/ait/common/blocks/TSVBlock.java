package com.mdt.ait.common.blocks;

import com.mdt.ait.common.tileentities.TSVTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class TSVBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static VoxelShape YES_SHAPE = Block.box(0, 0, 0, 16, 16, 16);
    public static VoxelShape NO_SHAPE = Block.box(0, 0, 0, 16, 16, 16);
    public static VoxelShape MAYBE_SHAPE = Block.box(0, 0, 0, 16, 16, 16);
    public static VoxelShape SO_SHAPE = Block.box(0, 0, 0, 16, 16, 16);

    public TSVBlock() {
        super(Properties.of(Material.STONE).strength(15.0f).noOcclusion().lightLevel((p_235464_0_) -> 5).instabreak());
    }

    @Override
    public BlockRenderType getRenderShape(BlockState pState) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.getValue(FACING).ordinal()) {
            case 2:
                return YES_SHAPE;
            case 3:
                return NO_SHAPE;
            case 4:
                return MAYBE_SHAPE;
            case 5:
                return SO_SHAPE;
        }
        return YES_SHAPE;
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
        return new TSVTile();
    }
}

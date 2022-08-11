package com.mdt.ait.common.blocks;

import com.mdt.ait.common.tileentities.ConsoleTileEntity;
import com.mdt.ait.core.init.AITBlockStates;
import com.mdt.ait.core.init.enums.EnumConsoleType;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class ConsoleBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static EnumProperty<EnumConsoleType> CONSOLE_TYPE = AITBlockStates.TARDIS_CONSOLE;

    public static VoxelShape YES_SHAPE = Block.box(0, 0, 0, 16, 16, 16);

    public ConsoleBlock() {
        super(Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noOcclusion());
    }

    @Override
    public BlockRenderType getRenderShape(BlockState pState) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return YES_SHAPE;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING).add(CONSOLE_TYPE);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return state.getValue(CONSOLE_TYPE).tileEntity.get();
    }
}

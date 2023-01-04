package com.mdt.ait.common.blocks;

import com.mdt.ait.AIT;
import com.mdt.ait.common.tileentities.DimensionSwitchControlTile;
import com.mdt.ait.common.tileentities.TardisCoordinateControlTile;
import com.mdt.ait.core.init.AITDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.UUID;

public class TardisCoordinateControlBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public UUID tardisID;

    //WORKS
    private static final VoxelShape NORTH_SHAPE = VoxelShapes.or(Block.box(0, 0, 0, 16, 2, 16),
            Block.box(4.5, 2, 4.5, 1.5, 3, 1.5), Block.box(6.5, 2, 1.5, 9.5, 3, 4.5)
            , Block.box(11.5, 2, 1.5, 14.5, 3, 4.5), Block.box(16, 2, 6, 14, 3, 8)).optimize();

    private static final VoxelShape EAST_SHAPE = VoxelShapes.or(Block.box(0, 0, 0, 16, 2, 16),
            Block.box(4.5, 2, 4.5, 1.5, 3, 1.5), Block.box(4.5, 2, 9.5, 4.5, 3, 6.5)
            , Block.box(4.5, 2, 14.5, 1.5, 3, 11.5), Block.box(8, 2, 2, 6, 3, 0)).optimize();

    private static final VoxelShape SOUTH_SHAPE = VoxelShapes.or(Block.box(0, 0, 0, 16, 2, 16),
            Block.box(1.5, 2, 1.5, 4.5, 3, 4.5), Block.box(9.5, 2, 4.5, 6.5, 3, 1.5)
            , Block.box(14.5, 2, 4.5, 11.5, 3, 1.5), Block.box(0, 2, 10, 2, 3, 8)).optimize();

    //WORKS
    private static final VoxelShape WEST_SHAPE = VoxelShapes.or(Block.box(0, 0, 0, 16, 2, 16),
            Block.box(1.5, 2, 1.5, 4.5, 3, 4.5), Block.box(1.5, 2, 6.5, 4.5, 3, 9.5)
            , Block.box(1.5, 2, 11.5, 4.5, 3, 14.5), Block.box(6, 2, 0, 8, 3, 2)).optimize();

    public TardisCoordinateControlBlock() {
        super(Properties.of(Material.STONE).strength(15.0f).noOcclusion());
    }

    @Override
    public BlockRenderType getRenderShape(BlockState pState) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.getValue(FACING)) {
            case NORTH:
                return NORTH_SHAPE;
            case EAST:
                return EAST_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            default:
                throw new RuntimeException("Invalid facing direction in getCollisionShape() " +
                        "//HOW THE HECK DID YOU GET HERE??");
        }
    }

    @Override
    public ActionResultType use(BlockState pState, World pWorldIn, BlockPos pPos, PlayerEntity pPlayer, Hand pHandIn, BlockRayTraceResult pHit) {
        TileEntity tileEntity = pWorldIn.getBlockEntity(pPos);
        if (tileEntity instanceof TardisCoordinateControlTile) {
            ((TardisCoordinateControlTile) tileEntity).useOn(pWorldIn, pPlayer, pPos, pHandIn, pHit);
        }
        return super.use(pState, pWorldIn, pPos, pPlayer, pHandIn, pHit);
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

    @Override
    public void onPlace(BlockState blockState1, World world, BlockPos blockPos, BlockState blockState2, boolean bool) {
        super.onPlace(blockState1, world, blockPos, blockState2, bool);
        if (!world.isClientSide && world.dimension() == AITDimensions.TARDIS_DIMENSION) {
            ServerWorld serverWorld = ((ServerWorld) world);
            TardisCoordinateControlTile tardisCoordinateControlTile = (TardisCoordinateControlTile) serverWorld.getBlockEntity(blockPos);
            this.tardisID = AIT.tardisManager.getTardisIDFromPosition(blockPos);
            assert tardisCoordinateControlTile != null;
            tardisCoordinateControlTile.tardisID = tardisID;
            serverWorld.setBlockEntity(blockPos, tardisCoordinateControlTile);
            TileEntity tileEntity = world.getBlockEntity(blockPos);
            if (tileEntity instanceof TardisCoordinateControlTile) {
                ((TardisCoordinateControlTile) tileEntity).onPlace();
            }
        }
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        TardisCoordinateControlTile tardisCoordinateControlTile = new TardisCoordinateControlTile();
        return tardisCoordinateControlTile;
    }
}

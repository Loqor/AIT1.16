package com.mdt.ait.common.blocks;

import com.mdt.ait.AIT;
import com.mdt.ait.common.tileentities.DoorSwitchControlTile;
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
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.UUID;

public class DoorSwitchControlBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public UUID tardisID;

    private static final VoxelShape NORTH_SHAPE = VoxelShapes.or(Block.box(2, 0, 1, 14, 2, 15)).optimize();
    private static final VoxelShape EAST_SHAPE = VoxelShapes.or(Block.box(1, 0, 2, 15, 2, 14)).optimize();
    private static final VoxelShape SOUTH_SHAPE = VoxelShapes.or(Block.box(2, 0, 1, 14, 2, 15)).optimize();
    private static final VoxelShape WEST_SHAPE = VoxelShapes.or(Block.box(1, 0, 2, 15, 2, 14)).optimize();

    public DoorSwitchControlBlock() {
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
        if (tileEntity instanceof DoorSwitchControlTile) {
            ((DoorSwitchControlTile) tileEntity).useOn(pWorldIn, pPlayer, pPos, pHandIn, pHit);
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
            DoorSwitchControlTile DoorSwitchControlTile = (DoorSwitchControlTile) serverWorld.getBlockEntity(blockPos);
            //this.tardisID = AIT.tardisManager.getTardisIDFromPosition(blockPos);
            assert DoorSwitchControlTile != null;
            DoorSwitchControlTile.tardisID = tardisID;
            serverWorld.setBlockEntity(blockPos, DoorSwitchControlTile);
            TileEntity tileEntity = world.getBlockEntity(blockPos);
            if (tileEntity instanceof DoorSwitchControlTile) {
                ((DoorSwitchControlTile) tileEntity).onPlace();
            }
        }
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new DoorSwitchControlTile();
    }
}

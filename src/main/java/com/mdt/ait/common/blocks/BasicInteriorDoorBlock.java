package com.mdt.ait.common.blocks;

import com.mdt.ait.AIT;
import com.mdt.ait.common.tileentities.BasicInteriorDoorTile;
import com.mdt.ait.common.tileentities.TSVTile;
import com.mdt.ait.common.tileentities.TardisTileEntity;
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
import net.minecraft.util.math.AxisAlignedBB;
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

public class BasicInteriorDoorBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public UUID tardisID;

    /*public static final VoxelShape NORTH_AABB = VoxelShapes.box(0, 0, -1, 2, 32, -0.1);
    public static final VoxelShape EAST_AABB = VoxelShapes.box(16.1, 0, 0, 16, 32, 2);
    public static final VoxelShape SOUTH_AABB = VoxelShapes.box(0, 0, 16.1, 2, 32, 16);
    public static final VoxelShape WEST_AABB = VoxelShapes.box(-1, 0, 0, -0.1, 32, 2);*/

    public static final VoxelShape NORTH_AABB = VoxelShapes.create(new AxisAlignedBB(0, 0, -0.0625, 1, 2, -0.006249999999999978));
    public static final VoxelShape EAST_AABB = VoxelShapes.create(new AxisAlignedBB(1.00625, 0, 0, 1.0625, 2, 1));
    public static final VoxelShape SOUTH_AABB = VoxelShapes.create(new AxisAlignedBB(0, 0, 1.00625, 1, 2, 1.0625));
    public static final VoxelShape WEST_AABB = VoxelShapes.create(new AxisAlignedBB(-0.0625, 0, 0, -0.006249999999999978, 2, 1));

    public BasicInteriorDoorBlock() {
        super(Properties.of(Material.STONE).strength(15.0f).noOcclusion().instabreak().noCollission());
    }

    @Override
    public BlockRenderType getRenderShape(BlockState pState) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public VoxelShape getShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        switch(pState.getValue(FACING)) {
            case NORTH:
                return NORTH_AABB;
            case EAST:
                return EAST_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case WEST:
                return WEST_AABB;
            default:
                throw new RuntimeException("Invalid facing direction in getCollisionShape() " +
                        "//HOW THE HECK DID YOU GET HERE??");
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.getValue(FACING)) {
            case NORTH:
                return NORTH_AABB;
            case EAST:
                return EAST_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case WEST:
                return WEST_AABB;
            default:
                throw new RuntimeException("Invalid facing direction in getCollisionShape() " +
                        "//HOW THE HECK DID YOU GET HERE??");
        }
    }

    @Override
    public ActionResultType use(BlockState pState, World pWorldIn, BlockPos pPos, PlayerEntity pPlayer, Hand pHandIn, BlockRayTraceResult pHit) {
        TileEntity tileEntity = pWorldIn.getBlockEntity(pPos);
        if(tileEntity instanceof BasicInteriorDoorTile) {
            ((BasicInteriorDoorTile) tileEntity).useOn(pWorldIn, pPlayer, pPos, pHandIn);
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
            this.tardisID = AIT.tardisManager.getTardisIDFromPosition(blockPos);
//            BlockPos tempBlockPos = AIT.tardisManager.getTardis(this.tardisID).interior_door_position;
            ServerWorld serverWorld = ((ServerWorld) world);
            BasicInteriorDoorTile basicInteriorDoorTile = ((BasicInteriorDoorTile) serverWorld.getBlockEntity(blockPos));
            assert basicInteriorDoorTile != null;
            basicInteriorDoorTile.tardisID = this.tardisID;
            basicInteriorDoorTile.linked_tardis = AIT.tardisManager.getTardis(this.tardisID);
            serverWorld.setBlockEntity(blockPos, basicInteriorDoorTile);
        }


    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new BasicInteriorDoorTile();
    }
}

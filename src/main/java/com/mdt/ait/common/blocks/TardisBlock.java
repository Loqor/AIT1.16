package com.mdt.ait.common.blocks;

import com.mdt.ait.core.init.AITBlockStates;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.interfaces.ITardisBlock;
import io.mdt.ait.common.tiles.TARDISTileEntity;
import io.mdt.ait.tardis.TARDISManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
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

public class TardisBlock extends FallingBlock implements ITardisBlock { // ITardisBlock has some of the same functionality as interface ICantBreak

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static EnumProperty<EnumExteriorType> EXTERIOR_TYPE = AITBlockStates.TARDIS_EXTERIOR;

    public UUID tardisID;
    public static BooleanProperty isExistingTardis = BooleanProperty.create("is_existing_tardis");


    public static final VoxelShape NORTH_AABB = VoxelShapes.create(new AxisAlignedBB(0, 0, 0.006249999999999978, 1, 2, 1));
    public static final VoxelShape EAST_AABB = VoxelShapes.create(new AxisAlignedBB(0, 0, 0, 0.99375, 2, 1));
    public static final VoxelShape SOUTH_AABB = VoxelShapes.create(new AxisAlignedBB(0, 0, 0, 1, 2, 0.99375));
    public static final VoxelShape WEST_AABB = VoxelShapes.create(new AxisAlignedBB(0.006249999999999978, 0, 0, 1, 2, 1));
    public static final VoxelShape SIEGE = Block.box(-4, 0, -4, 4, 4, 4);

    public TardisBlock() {
        super(Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noOcclusion());
    }

    @Override
    public void onPlace(BlockState pState, World pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        TARDISTileEntity tardisTileEntity = (TARDISTileEntity) pLevel.getBlockEntity(pPos);
        if(tardisTileEntity != null && pLevel instanceof ServerWorld) {
            tardisTileEntity.link(TARDISManager.create(pPos, pLevel.dimension()));
        }

        super.onPlace(pState, pLevel, pPos, pOldState, pIsMoving);
    }

    @Override
    public ActionResultType use(BlockState pState, World pWorldIn, BlockPos pPos, PlayerEntity pPlayer, Hand pHandIn, BlockRayTraceResult pHit) {
        TileEntity tileEntity = pWorldIn.getBlockEntity(pPos);
        if (tileEntity instanceof TARDISTileEntity) {
            //((TARDISTileEntity) tileEntity).use(pWorldIn, pPlayer, pPos, pHandIn); FIXME: this
        }
        return super.use(pState, pWorldIn, pPos, pPlayer, pHandIn, pHit);
    }

    @Override
    public BlockRenderType getRenderShape(BlockState pState) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        TileEntity tileEntity = worldIn.getBlockEntity(pos);
        if (tileEntity instanceof TARDISTileEntity) {
            //EnumExteriorType exteriorType = ((TARDISTileEntity) tileEntity).currentExterior();
            //if (exteriorType == EnumExteriorType.SIEGE_MODE) {
            //    return SIEGE;
            //}
        }
        switch (state.getValue(FACING)) {
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
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING).add(EXTERIOR_TYPE).add(isExistingTardis);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState blockState = this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
        blockState = blockState.setValue(isExistingTardis, false);

        return blockState;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TARDISTileEntity();
    }
}

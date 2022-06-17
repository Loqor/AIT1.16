package com.mdt.ait.common.blocks;

import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.AITBlockStates;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.interfaces.ICantBreak;
import com.mdt.ait.helpers.tardis.Tardis;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class TardisBlock extends Block implements ICantBreak {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static EnumProperty<EnumExteriorType> EXTERIOR_TYPE = AITBlockStates.TARDIS_EXTERIOR;


    public static final VoxelShape NORTH_AABB = VoxelShapes.create(new AxisAlignedBB(0, 0, 0.006249999999999978, 1, 2, 1));
    public static final VoxelShape EAST_AABB = VoxelShapes.create(new AxisAlignedBB(0, 0, 0, 0.99375, 2, 1));
    public static final VoxelShape SOUTH_AABB = VoxelShapes.create(new AxisAlignedBB(0, 0, 0, 1, 2, 0.99375));
    public static final VoxelShape WEST_AABB = VoxelShapes.create(new AxisAlignedBB(0.006249999999999978, 0, 0, 1, 2, 1));

    public TardisBlock() {
        super(Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noOcclusion());
    }

    @Override
    public ActionResultType use(BlockState pState, World pWorldIn, BlockPos pPos, PlayerEntity pPlayer, Hand pHandIn, BlockRayTraceResult pHit) {
        TileEntity tileEntity = pWorldIn.getBlockEntity(pPos);
        if (tileEntity instanceof TardisTileEntity) {
            ((TardisTileEntity) tileEntity).useOn(pWorldIn, pPlayer, pPos, pHandIn);
        }
        return super.use(pState, pWorldIn, pPos, pPlayer, pHandIn, pHit);
    }

    @Override
    public BlockRenderType getRenderShape(BlockState pState) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
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

    //@Override
    //public void onPlace(BlockState blockstate, World world, BlockPos bpos, BlockState blockState, boolean bool) {
    //    TileEntity tileEntity = world.getBlockEntity(bpos);
    //    if(tileEntity instanceof TardisTileEntity) {
    //        ((TardisTileEntity) tileEntity).onPlace(blockstate, world, bpos, blockState, bool);
    //    }
    //    super.onPlace(blockstate, world, bpos, blockState, bool);
    //}

    //@Override
    //public void onRemove(BlockState blockstate, World world, BlockPos bpos, BlockState blockState, boolean bool) {
    //    TileEntity tileEntity = world.getBlockEntity(bpos);
    //    if(tileEntity instanceof TardisTileEntity) {
    //        ((TardisTileEntity) tileEntity).onRemove(blockstate, world, bpos, blockState, bool);
    //    }
    //    super.onRemove(blockstate, world, bpos, blockState, bool);
    //}


    @Override
    public void entityInside(BlockState blockstate, World world, BlockPos bpos, Entity entity) {
        TileEntity tileEntity = world.getBlockEntity(bpos);
        if (tileEntity instanceof TardisTileEntity) {
            ((TardisTileEntity) tileEntity).entityInside(entity);
            super.entityInside(blockstate, world, bpos, entity);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING).add(EXTERIOR_TYPE);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return state.getValue(EXTERIOR_TYPE).tileEntity.get();
    }
}

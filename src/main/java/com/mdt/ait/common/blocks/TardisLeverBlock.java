package com.mdt.ait.common.blocks;

import com.mdt.ait.AIT;
import com.mdt.ait.common.tileentities.TSVTile;
import com.mdt.ait.common.tileentities.TardisLeverTile;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.tardis.Tardis;
import com.mdt.ait.tardis.TardisManager;
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
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.UUID;

public class TardisLeverBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public UUID tardisID;

    public static VoxelShape YES_SHAPE = Block.box(0, 0, 0, 16, 1, 16);

    public TardisLeverBlock() {
        super(Properties.of(Material.STONE).strength(15.0f).noOcclusion());
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
    public ActionResultType use(BlockState pState, World pWorldIn, BlockPos pPos, PlayerEntity pPlayer, Hand pHandIn, BlockRayTraceResult pHit) {
        TileEntity tileEntity = pWorldIn.getBlockEntity(pPos);
        if (tileEntity instanceof TardisLeverTile) {
            ((TardisLeverTile) tileEntity).useOn(pWorldIn, pPlayer, pPos, pHandIn, pHit);
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
            TardisLeverTile tardisLeverTile = (TardisLeverTile) serverWorld.getBlockEntity(blockPos);
            this.tardisID = AIT.tardisManager.getTardisIDFromPosition(blockPos);
            assert tardisLeverTile != null;
            tardisLeverTile.tardisID = this.tardisID;
            serverWorld.setBlockEntity(blockPos, tardisLeverTile);
            tardisLeverTile.onPlace(blockState1, world, blockPos);
        }
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        TardisLeverTile tardisLeverTile = new TardisLeverTile();
        return tardisLeverTile;
    }
}

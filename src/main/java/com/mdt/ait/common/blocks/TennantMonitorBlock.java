package com.mdt.ait.common.blocks;

import com.mdt.ait.client.screen.MonitorScreen;
import com.mdt.ait.common.tileentities.TennantMonitorTile;
import com.mdt.ait.core.init.AITDimensions;
import io.mdt.ait.tardis.TARDISManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
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
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.UUID;

public class TennantMonitorBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static VoxelShape YES_SHAPE = Block.box(0, 0, 0, 16, 16, 16);

    public UUID tardisID;

    public TennantMonitorBlock() {
        super(Properties.of(Material.STONE).strength(15.0f).noOcclusion().instabreak());
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
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
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

    @Override
    public void onPlace(BlockState blockState1, World world, BlockPos blockPos, BlockState blockState2, boolean bool) {
        super.onPlace(blockState1, world, blockPos, blockState2, bool);
        if (!world.isClientSide && world.dimension() == AITDimensions.TARDIS_DIMENSION) {
            ServerWorld serverWorld = ((ServerWorld) world);
            TennantMonitorTile tennantMonitorTile = (TennantMonitorTile) serverWorld.getBlockEntity(blockPos);
            this.tardisID = TARDISManager.findUUID(blockPos);
            assert tennantMonitorTile != null;
            tennantMonitorTile.tardisID = tardisID;
            serverWorld.setBlockEntity(blockPos, tennantMonitorTile);
        }
    }

    @Override
    public void tick(BlockState pState, ServerWorld world, BlockPos blockPos, Random pRand) {
        super.tick(pState, world, blockPos, pRand);
        if (!world.isClientSide && world.dimension() == AITDimensions.TARDIS_DIMENSION && tardisID == null) {
            this.tardisID = TARDISManager.findUUID(blockPos);
        }
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TennantMonitorTile();
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
                                Hand handIn, BlockRayTraceResult hit) {
        //if (!worldIn.isClientSide()) {
            if (worldIn.dimension() == AITDimensions.TARDIS_DIMENSION) {
                        TennantMonitorTile tennantMonitorTile = (TennantMonitorTile) worldIn.getBlockEntity(pos);
                        if (!worldIn.isClientSide) {
                            this.tardisID = TARDISManager.findUUID(pos);
                }
                assert tennantMonitorTile != null;
                tennantMonitorTile.tardisID = tardisID;
                Block block = worldIn.getBlockState(pos).getBlock();
                if (block instanceof TennantMonitorBlock) {
                    Minecraft.getInstance().setScreen(new MonitorScreen(new TranslationTextComponent("TARDIS Monitor"), tardisID, worldIn));
                }
            }
        //}
        return super.use(state, worldIn, pos, player, handIn, hit);
    }
}

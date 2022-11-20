package com.mdt.ait.common.blocks;

import com.mdt.ait.AIT;
import com.mdt.ait.common.tileentities.ConsoleTileEntity;
import com.mdt.ait.common.tileentities.HartnellRotorTile;
import com.mdt.ait.core.init.AITBlockStates;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.enums.EnumConsoleType;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.interfaces.IConsoleBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
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
import java.util.Random;
import java.util.UUID;

public class ConsoleBlock extends Block implements IConsoleBlock {

    public UUID tardisID;

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
    public void onPlace(BlockState pState, World world, BlockPos blockPos, BlockState pOldState, boolean pIsMoving) {
        super.onPlace(pState, world, blockPos, pOldState, pIsMoving);
        if (!world.isClientSide && world.dimension() == AITDimensions.TARDIS_DIMENSION) {
            ServerWorld serverWorld = ((ServerWorld) world);
            ConsoleTileEntity consoleTileEntity = (ConsoleTileEntity) serverWorld.getBlockEntity(blockPos);
            this.tardisID = AIT.tardisManager.getTardisIDFromPosition(blockPos);
            assert consoleTileEntity != null;
            consoleTileEntity.tardisID = tardisID;
            serverWorld.setBlockEntity(blockPos, consoleTileEntity);
            consoleTileEntity.onPlace(pState, world, blockPos, pOldState, pIsMoving);
        }
    }

    @Override
    public ActionResultType use(BlockState pState, World world, BlockPos blockPos, PlayerEntity pPlayer, Hand pHand, BlockRayTraceResult pHit) {
        if (!world.isClientSide && world.dimension() == AITDimensions.TARDIS_DIMENSION) {
            ServerWorld serverWorld = ((ServerWorld) world);
            ConsoleTileEntity consoleTileEntity = (ConsoleTileEntity) serverWorld.getBlockEntity(blockPos);
            assert consoleTileEntity != null;
            consoleTileEntity.onRemoval(pState, world, blockPos, pPlayer, pHand);
        }
        return super.use(pState, world, blockPos, pPlayer, pHand, pHit);
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

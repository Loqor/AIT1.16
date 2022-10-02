package com.mdt.ait.common.blocks;

import com.mdt.ait.common.tileentities.BasicInteriorDoorTile;
import com.mdt.ait.core.init.AITItems;
import com.mdt.ait.core.init.AITSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import static com.mdt.ait.core.init.enums.EnumDoorState.FIRST;

public class CowSkullBlock extends HorizontalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    //public static VoxelShape YES_SHAPE = Block.box(0, 0, 0, 8, 8, 8);
    public static final VoxelShape YES_SHAPE = VoxelShapes.create(new AxisAlignedBB(0, 0, 0, 1, 0.55, 1));

    public CowSkullBlock(Properties properties) {
            super(properties.of(Material.STONE).strength(3.0F, 6.0F).noOcclusion());
    }

    @Override
    public BlockRenderType getRenderShape(BlockState p_149645_1_) {
        return BlockRenderType.MODEL;
    }


    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
        return p_185471_1_.rotate(p_185471_2_.getRotation(p_185471_1_.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FACING);
    }

    public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return YES_SHAPE;
    }

    @Override
    public ActionResultType use(BlockState pState, World pLevel, BlockPos pPos, PlayerEntity pPlayer, Hand pHand, BlockRayTraceResult pHit) {
        Block block = pState.getBlock();
        BlockPos pos = new BlockPos(pPos.getX(), pPos.getY(), pPos.getZ());
        if (block instanceof CowSkullBlock && pHand == Hand.MAIN_HAND && !pLevel.isClientSide && pPlayer.getItemBySlot(EquipmentSlotType.HEAD) == ItemStack.EMPTY) {
            pPlayer.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(AITItems.COW_SKULL.get()));
            pLevel.removeBlock(pos,false);
        } else if(pPlayer.getItemBySlot(EquipmentSlotType.HEAD) != ItemStack.EMPTY && pPlayer.getItemBySlot(EquipmentSlotType.MAINHAND) == ItemStack.EMPTY) {
            pPlayer.setItemInHand(Hand.MAIN_HAND, new ItemStack(AITItems.COW_SKULL.get()));
            pLevel.removeBlock(pos,false);
        }
        return ActionResultType.SUCCESS;
    }
}

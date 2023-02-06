package com.mdt.ait.common.blocks;

import com.mdt.ait.AIT;
import com.mdt.ait.common.items.SonicItem;
import com.mdt.ait.common.tileentities.ARSRemoverTile;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.AITItems;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.tardis.structures.BaseStructure;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.UUID;

import static com.mdt.ait.common.blocks.ARSProducerBlock.checkHeldItem;

public class ARSRemoverBlock extends Block {
    public String structure_name = "short_corridor";

    public ARSRemoverBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return AITTiles.ARS_REMOVER_TILE.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public ActionResultType use(BlockState pState, World pLevel, BlockPos pPos, PlayerEntity pPlayer, Hand pHand, BlockRayTraceResult pHit) {
        if (checkHeldItem(pPlayer, AITItems.TENNANT_SONIC.get()) || checkHeldItem(pPlayer, AITItems.WHITTAKER_SONIC.get())) {
            if (!pLevel.isClientSide) {
                ServerWorld tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
                BaseStructure baseStructure = new BaseStructure(tardisWorld, this.structure_name);
                Direction block_direction = pHit.getDirection().getOpposite();
                SonicItem sonic = (SonicItem) pPlayer.getMainHandItem().getItem();
                this.structure_name = sonic.structure_name;
                TileEntity tileEntity = pLevel.getBlockEntity(pPos);
                System.out.println("sadsad");
                if (tileEntity instanceof ARSRemoverTile) {
                    System.out.println("is ars tile");
                    ((ARSRemoverTile) tileEntity).cloisterCountdown(pLevel, block_direction,3, pPos, pPlayer, "second(s) until room deletion.",baseStructure);
                }
                //baseStructure.placeStructure(tardisWorld, pPos, block_direction,pPlayer);
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}


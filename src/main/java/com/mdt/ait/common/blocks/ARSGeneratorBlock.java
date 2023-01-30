package com.mdt.ait.common.blocks;

import com.mdt.ait.AIT;
import com.mdt.ait.common.items.SonicItem;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.AITItems;
import com.mdt.ait.tardis.structures.BaseStructure;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.UUID;

import static com.mdt.ait.common.blocks.ARSProducerBlock.checkHeldItem;

public class ARSGeneratorBlock extends Block {
    public UUID tardisID;
    public String structure_name = "short_corridor";

    public ARSGeneratorBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    @Override
    public ActionResultType use(BlockState pState, World pLevel, BlockPos pPos, PlayerEntity pPlayer, Hand pHand, BlockRayTraceResult pHit) {
            if (checkHeldItem(pPlayer, AITItems.TENNANT_SONIC.get()) || checkHeldItem(pPlayer, AITItems.WHITTAKER_SONIC.get())) {
                ServerWorld tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
                BaseStructure baseStructure = new BaseStructure(tardisWorld, this.structure_name);
                Direction block_direction = pHit.getDirection().getOpposite();
                SonicItem sonic = (SonicItem) pPlayer.getMainHandItem().getItem();
                this.structure_name = sonic.structure_name;
                if (!pLevel.isClientSide()) {
                    baseStructure.placeStructure(tardisWorld, pPos, block_direction,pPlayer);
                }
            }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}


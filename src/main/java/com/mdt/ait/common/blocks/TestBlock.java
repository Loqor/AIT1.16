package com.mdt.ait.common.blocks;

import com.mdt.ait.core.init.AITItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class TestBlock extends Block{
    public TestBlock() {
        super(Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)
                .harvestTool(ToolType.PICKAXE).sound(SoundType.STONE));
    }

}

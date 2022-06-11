package com.mdt.ait.core.init;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.TSVBlock;
import com.mdt.ait.common.blocks.TardisBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AITBlocks {


    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AIT.MOD_ID);

    public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_block",
            () -> new Block(
                    Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)
                            .harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

    public static final RegistryObject<Block> TARDIS_BLOCK = BLOCKS.register("tardis", TardisBlock::new);
    public static final RegistryObject<Block> TSV_BLOCK = BLOCKS.register("tsv", TSVBlock::new);
}

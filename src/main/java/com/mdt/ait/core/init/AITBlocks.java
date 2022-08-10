package com.mdt.ait.core.init;

import com.mdt.ait.AIT;
import com.mdt.ait.common.ModSlabBlock;
import com.mdt.ait.common.blocks.*;
import com.mdt.ait.common.blocks.DirectionalBlock;
import net.minecraft.block.*;
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
    public static final RegistryObject<Block> TYPEWRITER_BLOCK = BLOCKS.register("typewriter", TypewriterBlock::new);
    public static final RegistryObject<Block> RAMP_BLOCK = BLOCKS.register("ramp", RampBlock::new);
    public static final RegistryObject<Block> INTERIOR_DOOR_BLOCK = BLOCKS.register("basic_interior_door_block", BasicInteriorDoorBlock::new);
    public static final RegistryObject<InvisBlock> INVIS_BLOCK = BLOCKS.register("invis_block", InvisBlock::new);

    public static final RegistryObject<InvisLightBlock> INVIS_LIGHT_BLOCK = BLOCKS.register("invis_light_block", InvisLightBlock::new);

    //Steel Grating
    public static final RegistryObject<Block> STEEL_GRATE = BLOCKS.register(
            "steel_grate", () -> new Block(TransparentGrateBlock.Properties.of(
                    Material.METAL, MaterialColor.COLOR_BROWN).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> STEEL_GRATE_BLOCK = BLOCKS.register(
            "steel_grate_block", () -> new Block(TransparentGrateBlock.Properties.of(
                    Material.METAL, MaterialColor.COLOR_BROWN).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> STEEL_GRATE_SLAB = BLOCKS.register(
            "steel_grate_slab", () -> new SlabBlock(ModSlabBlock.Properties.of(
                    Material.METAL, MaterialColor.COLOR_BROWN).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> MINT_SOLID_SLAB = BLOCKS.register(
            "mint_solid_slab", () -> new SlabBlock(ModSlabBlock.Properties.of(
                    Material.STONE, MaterialColor.COLOR_LIGHT_GREEN).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> STEEL_GRATE_BLOCK_SLAB = BLOCKS.register(
            "steel_grate_block_slab", () -> new SlabBlock(ModSlabBlock.Properties.of(
                    Material.METAL, MaterialColor.COLOR_BROWN).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.METAL).noOcclusion()));


    //Hartnell Mint/Blowup Blocks
    public static final RegistryObject<Block> HARTNELL_MINT_A = BLOCKS.register(
            "hartnell_mint_a", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_LIGHT_GREEN).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> HARTNELL_MINT_B = BLOCKS.register(
            "hartnell_mint_b", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_LIGHT_GREEN).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MINT_SOLID = BLOCKS.register(
            "mint_solid", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_LIGHT_GREEN).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> HARTNELL_BLOWUP_A = BLOCKS.register(
            "hartnell_blowup_a", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> HARTNELL_BLOWUP_B = BLOCKS.register(
            "hartnell_blowup_b", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> HARTNELL_BLOWUP_SOLID = BLOCKS.register(
            "hartnell_blowup_solid", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));


    //Tom Baker Blocks
    public static final RegistryObject<Block> TBAKER_ROUNDEL_A = BLOCKS.register(
            "tbaker_roundel_a", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> TBAKER_ROUNDEL_B = BLOCKS.register(
            "tbaker_roundel_b", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> TBAKER_SOLID = BLOCKS.register(
            "tbaker_solid", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_YELLOW).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));


    //Master Blocks
    public static final RegistryObject<Block> MASTER_ROUNDEL_A = BLOCKS.register(
            "master_roundel_a", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MASTER_ROUNDEL_B = BLOCKS.register(
            "master_roundel_b", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MASTER_SOLID = BLOCKS.register(
            "master_solid", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));


    //Coral Blocks
    public static final RegistryObject<Block> CORAL_WALL_BLOCK = BLOCKS.register(
            "coral_wall_block", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CORAL_ROUNDEL = BLOCKS.register(
            "coral_roundel", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SMALL_CORAL_ROUNDEL = BLOCKS.register(
            "small_coral_roundel", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_ORANGE).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE).noOcclusion()));
    public static final RegistryObject<DirectionalBlock> CORAL_WALL_BLOCK_STRIP = BLOCKS.register(
            "coral_wall_block_strip", () -> new DirectionalBlock(DirectionalBlock.Properties.of(
                    Material.STONE, MaterialColor.COLOR_ORANGE).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE).noOcclusion()));
    public static final RegistryObject<Block> CORAL_WALL_BLOCK_STRIP_ONE = BLOCKS.register(
            "coral_wall_block_strip_one", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_ORANGE).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE).noOcclusion()));


    //Toyota Blocks
    public static final RegistryObject<Block> TOYOTA_FLASHING_LIGHT = BLOCKS.register(
            "toyota_flashing_light", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).lightLevel((p_235464_0_) -> 15).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> TOYOTA_FLASHING_LIGHT1 = BLOCKS.register(
            "toyota_flashing_light1", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).lightLevel((p_235464_0_) -> 15).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> TOYOTA_FLASHING_LIGHT1A = BLOCKS.register(
            "toyota_flashing_light1a", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).lightLevel((p_235464_0_) -> 15).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> TOYOTA_FLASHING_LIGHTA = BLOCKS.register(
            "toyota_flashing_lighta", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).lightLevel((p_235464_0_) -> 15).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<DirectionalBlock> TOYOTA_PILLAR = BLOCKS.register(
            "toyota_pillar", () -> new DirectionalBlock(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> TOYOTA_ROOF = BLOCKS.register(
            "toyota_roof", () -> new Block(Block.Properties.of(
                    Material.WOOL, MaterialColor.COLOR_BLACK).strength(0.8F).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> TOYOTA_ROOF_LIGHT = BLOCKS.register(
            "toyota_roof_light", () -> new Block(Block.Properties.of(
                    Material.WOOL, MaterialColor.COLOR_BLACK).lightLevel((p_235464_0_) -> 15).strength(0.8F).sound(SoundType.WOOL)));


    //Hartnell Interior cont.
    public static final RegistryObject<Block> BRASS_PILLAR = BLOCKS.register(
            "brass_pillar", () -> new Block(Block.Properties.of(
                    Material.METAL, MaterialColor.COLOR_BROWN).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> ORMULUCLOCK = BLOCKS.register(
            "ormuluclock", () -> new DirectionalBlock(DirectionalBlock.Properties.of(
                    Material.METAL, MaterialColor.COLOR_BROWN).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> ARMILLARYSPHERE = BLOCKS.register(
            "armillarysphere", () -> new DirectionalBlock(DirectionalBlock.Properties.of(
                    Material.METAL, MaterialColor.COLOR_BROWN).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.METAL).noOcclusion()));


    //War Blocks
    public static final RegistryObject<Block> WAR_ROUNDEL_A = BLOCKS.register(
            "war_roundel_a", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> WAR_ROUNDEL_B = BLOCKS.register(
            "war_roundel_b", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> WAR_SOLID = BLOCKS.register(
            "war_solid", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> WAR_SOLID_SLAB = BLOCKS.register(
            "war_solid_slab", () -> new SlabBlock(ModSlabBlock.Properties.of(
                    Material.METAL, MaterialColor.COLOR_BROWN).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.METAL).noOcclusion()));


    //Random Roundels
    public static final RegistryObject<Block> THREE_DOCTORS_ROUNDEL_A = BLOCKS.register(
            "3_doctors_roundel_a", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> THREE_DOCTORS_ROUNDEL_B = BLOCKS.register(
            "3_doctors_roundel_b", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.METAL).noOcclusion()));

    //Light Blocks
    public static final RegistryObject<RotatedPillarBlock> LIGHT_BLOCK_ORANGE = BLOCKS.register("light_block_orange", () -> new RotatedPillarBlock(Block.Properties.of(
            Material.GLASS, MaterialColor.COLOR_ORANGE).harvestLevel(-1).sound(SoundType.GLASS).noOcclusion().lightLevel((p_235464_0_) -> 10)));
    public static final RegistryObject<RotatedPillarBlock> LIGHT_BLOCK_BLUE = BLOCKS.register("light_block_blue", () -> new RotatedPillarBlock(Block.Properties.of(
            Material.GLASS, MaterialColor.COLOR_LIGHT_BLUE).harvestLevel(-1).sound(SoundType.GLASS).noOcclusion().lightLevel((p_235464_0_) -> 10)));
    public static final RegistryObject<RotatedPillarBlock> LIGHT_BLOCK_PURPLE = BLOCKS.register("light_block_purple", () -> new RotatedPillarBlock(Block.Properties.of(
            Material.GLASS, MaterialColor.COLOR_PURPLE).harvestLevel(-1).sound(SoundType.GLASS).noOcclusion().lightLevel((p_235464_0_) -> 10)));
    public static final RegistryObject<RotatedPillarBlock> LIGHT_BLOCK_GREEN = BLOCKS.register("light_block_green", () -> new RotatedPillarBlock(Block.Properties.of(
            Material.GLASS, MaterialColor.COLOR_LIGHT_GREEN).harvestLevel(-1).sound(SoundType.GLASS).noOcclusion().lightLevel((p_235464_0_) -> 10)));

}
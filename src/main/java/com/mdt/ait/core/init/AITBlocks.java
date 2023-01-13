package com.mdt.ait.core.init;

import com.mdt.ait.AIT;
import com.mdt.ait.common.ModSlabBlock;
import com.mdt.ait.common.blocks.*;
import com.mdt.ait.common.blocks.DirectionalBlock;
import com.mdt.ait.core.init.itemgroups.AITItemGroups;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class AITBlocks {


    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AIT.MOD_ID);

    public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_block", TestBlock::new);
    // public static final RegistryObject<Block> AMONGUS_BLOCK = BLOCKS.register("amongus_block", () -> new Block(Block.Properties.of(Material.STONE))); when does this get added????
    public static final RegistryObject<Block> TARDIS_BLOCK = BLOCKS.register("tardis", TardisBlock::new);
    public static final RegistryObject<Block> RECORD_PLAYER_BLOCK = BLOCKS.register("record_player", RecordPlayerBlock::new);
    public static final RegistryObject<Block> GBTCASING_BLOCK = BLOCKS.register("gbtcasing", GBTCasingBlock::new);
    public static final RegistryObject<Block> TARDIS_LEVER_BLOCK = BLOCKS.register("tardis_lever", TardisLeverBlock::new);
    public static final RegistryObject<Block> BASIC_ROTOR_BLOCK = BLOCKS.register("basic_rotor", BasicRotorBlock::new);
    public static final RegistryObject<Block> HUDOLIN_ROTOR_BLOCK = BLOCKS.register("hudolin_rotor", HudolinRotorBlock::new);
    public static final RegistryObject<Block> HARTNELL_ROTOR_BLOCK = BLOCKS.register("hartnell_rotor", HartnellRotorBlock::new);
    public static final RegistryObject<Block> TOYOTA_ROTOR_BLOCK = BLOCKS.register("toyota_rotor", ToyotaRotorBlock::new);
    public static final RegistryObject<Block> TOYOTA_WHIRLAGIG_BLOCK = BLOCKS.register("toyota_whirlagig", ToyotaWhirlagigBlock::new);
    public static final RegistryObject<Block> DOOR_SWITCH_CONTROL_BLOCK = BLOCKS.register("door_switch_control", DoorSwitchControlBlock::new);
    public static final RegistryObject<Block> EXTERIOR_FACING_CONTROL_BLOCK = BLOCKS.register("exterior_facing_control", ExteriorFacingControlBlock::new);
    public static final RegistryObject<Block> DIMENSION_SWITCH_CONTROL_BLOCK = BLOCKS.register("dimension_switch_control", DimensionSwitchControlBlock::new);
    public static final RegistryObject<Block> TARDIS_COORDINATE_CONTROL_BLOCK = BLOCKS.register("tardis_coordinate_control", TardisCoordinateControlBlock::new);
    public static final RegistryObject<Block> TENNANT_MONITOR_BLOCK = BLOCKS.register("tennant_monitor", TennantMonitorBlock::new);
    public static final RegistryObject<Block> TOYOTA_MONITOR_BLOCK = BLOCKS.register("toyota_monitor", ToyotaMonitorBlock::new);
    public static final RegistryObject<Block> ROUNDEL_FACE_BLOCK = BLOCKS.register("roundel_face", RoundelFaceBlock::new);
    public static final RegistryObject<Block> CONSOLE_BLOCK = BLOCKS.register("console_block", ConsoleBlock::new);
    public static final RegistryObject<Block> TARDIS_CORAL_BLOCK = BLOCKS.register("tardis_coral", TardisCoralBlock::new);
    public static final RegistryObject<Block> TSV_BLOCK = BLOCKS.register("tsv", TSVBlock::new);
    public static final RegistryObject<Block> ROUNDEL_DOORS_BLOCK = BLOCKS.register("roundel_doors", RoundelDoorsBlock::new);

    public static final RegistryObject<Block> RICK_PORTAL_BLOCK = BLOCKS.register("ricks_portal", RickPortalBlock::new);
    public static final RegistryObject<Block> TYPEWRITER_BLOCK = BLOCKS.register("typewriter", TypewriterBlock::new);
    public static final RegistryObject<Block> RAMP_BLOCK = BLOCKS.register("ramp", RampBlock::new);
    public static final RegistryObject<Block> INTERIOR_DOOR_BLOCK = BLOCKS.register("basic_interior_door_block", BasicInteriorDoorBlock::new);
    public static final RegistryObject<InvisBlock> INVIS_BLOCK = BLOCKS.register("invis_block", InvisBlock::new);
    public static final RegistryObject<Block> VORTEX_BLOCK = BLOCKS.register("vortex_block", VortexBlock::new);
    public static final RegistryObject<Block> TARDIS_POWER_ACCESS_POINT_BLOCK = BLOCKS.register("tardis_power_access_point", TardisPowerAccessPointBlock::new);
    public static final RegistryObject<Block> INTERIOR_CENTER_BLOCK = BLOCKS.register(
            "interior_center_block", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));

    public static final RegistryObject<InvisLightBlock> INVIS_LIGHT_BLOCK = BLOCKS.register("invis_light_block", InvisLightBlock::new);

    //Gallifrey
    public static final RegistryObject<Block> GALLIFREY_STONE = BLOCKS.register(
            "gallifrey_stone", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<GallifreySandBlock> GALLIFREY_SAND = BLOCKS.register(
            "gallifrey_sand", () -> new GallifreySandBlock(AbstractBlock.Properties.of(Material.SAND, MaterialColor.COLOR_RED).strength(0.5F).sound(SoundType.SAND)));

    //Ores
    public static final RegistryObject<Block> SONIC_CRYSTAL_ORE = BLOCKS.register(
            "sonic_crystal_ore", () -> new Block(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));

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

    //Forest cosmetic blocks
    public static final RegistryObject<CowSkullBlock> COW_SKULL = BLOCKS.register(
            "cow_skull", () -> new CowSkullBlock(CowSkullBlock.Properties.of(
                    Material.SHULKER_SHELL, MaterialColor.COLOR_LIGHT_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.METAL).noOcclusion()));


    //War Blocks
    public static final RegistryObject<Block> WAR_ROUNDEL_A = BLOCKS.register(
            "war_roundel_a", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> WAR_ROUNDEL_B = BLOCKS.register(
            "war_roundel_b", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.STONE)));

    //Random Roundels
    public static final RegistryObject<Block> THREE_DOCTORS_ROUNDEL_A = BLOCKS.register(
            "3_doctors_roundel_a", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> THREE_DOCTORS_ROUNDEL_B = BLOCKS.register(
            "3_doctors_roundel_b", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> THREE_DOCTORS_SOLID = BLOCKS.register(
            "3_doctors_solid", () -> new Block(Block.Properties.of(
                    Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(-1).strength(3.0F, 6.0F).sound(SoundType.METAL)));

    //Light Blocks
    public static final RegistryObject<RotatedPillarBlock> LIGHT_BLOCK_ORANGE = BLOCKS.register("light_block_orange", () -> new RotatedPillarBlock(Block.Properties.of(
            Material.GLASS, MaterialColor.COLOR_ORANGE).harvestLevel(-1).sound(SoundType.GLASS).noOcclusion().lightLevel((p_235464_0_) -> 10)));
    public static final RegistryObject<RotatedPillarBlock> LIGHT_BLOCK_BLUE = BLOCKS.register("light_block_blue", () -> new RotatedPillarBlock(Block.Properties.of(
            Material.GLASS, MaterialColor.COLOR_LIGHT_BLUE).harvestLevel(-1).sound(SoundType.GLASS).lightLevel((p_235464_0_) -> 10)));
    public static final RegistryObject<RotatedPillarBlock> LIGHT_BLOCK_PURPLE = BLOCKS.register("light_block_purple", () -> new RotatedPillarBlock(Block.Properties.of(
            Material.GLASS, MaterialColor.COLOR_PURPLE).harvestLevel(-1).sound(SoundType.GLASS).lightLevel((p_235464_0_) -> 10)));
    public static final RegistryObject<RotatedPillarBlock> LIGHT_BLOCK_GREEN = BLOCKS.register("light_block_green", () -> new RotatedPillarBlock(Block.Properties.of(
            Material.GLASS, MaterialColor.COLOR_LIGHT_GREEN).harvestLevel(-1).sound(SoundType.GLASS).lightLevel((p_235464_0_) -> 10)));

    //Custom blocks
    public static final RegistryObject<Block> DARKSTONE = BLOCKS.register(
            "darkstone", () -> new Block(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));

    public static final RegistryObject<Block> DARKSTONE_STAIRS = registerBlock("darkstone_stairs", () -> new StairsBlock(() -> DARKSTONE.get().defaultBlockState(), Block.Properties.of(Material.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(3f,3f)),AITItemGroups.AITBLOCKS);
    public static final RegistryObject<Block> DARKSTONE_SLAB = registerBlock("darkstone_slab", () -> new SlabBlock(Block.Properties.of(Material.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(3f,3f)),AITItemGroups.AITBLOCKS);
    public static final RegistryObject<Block> ARS_PRODUCER = registerBlock("ars_producer", () -> new ARSProducerBlock(AbstractBlock.Properties.of(Material.EGG)),AITItemGroups.AITBLOCKS);
    public static final RegistryObject<Block> DW2012_BLOCK = registerBlock("dw2012_block", () -> new Block(Block.Properties.of(Material.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE).strength(3f,3f)),AITItemGroups.AITROUNDELS);
    public static final RegistryObject<Block> DW2012_BLOCK_B = registerBlock("dw2012_block_b", () -> new Block(Block.Properties.of(Material.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE).strength(3f,3f)),AITItemGroups.AITROUNDELS);

    // I'd recommend you use this to save the hassle of adding it in AITItems too, but its up to you. I will be using this for all the blocks I add, though. - Duzo
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, ItemGroup tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, ItemGroup tab) {
        AITItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
}

package com.mdt.ait.core.init;

import com.mdt.ait.AIT;
import com.mdt.ait.common.items.SonicItem;
import com.mdt.ait.core.init.itemgroups.AITItemGroups;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.imageio.spi.RegisterableService;

public class AITItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AIT.MOD_ID);

    public static final RegistryObject<SonicItem> TENNANT_SONIC = ITEMS.register(
            "tennant_sonic", () -> new SonicItem(new Item.Properties().tab(AITItemGroups.AITITEMS)));

    public static final RegistryObject<BlockItem> TARDIS = ITEMS.register(
            "tardis", () -> new BlockItem(
                    AITBlocks.TARDIS_BLOCK.get(),new Item.Properties().tab(AITItemGroups.AITITEMS)));
    public static final RegistryObject<BlockItem> TSV = ITEMS.register(
            "tsv", () -> new BlockItem(
                    AITBlocks.TSV_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));

    public static final RegistryObject<BlockItem> BASIC_INTERIOR_DOOR = ITEMS.register(
            "interior_doors", () -> new BlockItem(
                    AITBlocks.INTERIOR_DOOR_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));

    public static final RegistryObject<BlockItem> TEST_BLOCK_ITEM = ITEMS.register("test_block",
            () -> new BlockItem(
                    AITBlocks.TEST_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final  RegistryObject<BlockItem> STEEL_GRATE = ITEMS.register(
            "steel_grate", () -> new BlockItem(AITBlocks.STEEL_GRATE.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final  RegistryObject<BlockItem> STEEL_GRATE_SLAB = ITEMS.register(
            "steel_grate_slab", () -> new BlockItem(AITBlocks.STEEL_GRATE_SLAB.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final  RegistryObject<BlockItem> MINT_SOLID_SLAB = ITEMS.register(
            "mint_solid_slab", () -> new BlockItem(AITBlocks.MINT_SOLID_SLAB.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> CORAL_WALL_BLOCK = ITEMS.register(
            "coral_wall_block", () -> new BlockItem(AITBlocks.CORAL_WALL_BLOCK.get(),new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> CORAL_WALL_BLOCK_STRIP = ITEMS.register(
            "coral_wall_block_strip", () -> new BlockItem(AITBlocks.CORAL_WALL_BLOCK_STRIP.get(),new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> CORAL_WALL_BLOCK_STRIP_ONE = ITEMS.register(
            "coral_wall_block_strip_one", () -> new BlockItem(AITBlocks.CORAL_WALL_BLOCK_STRIP_ONE.get(),new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> TBAKER_SOLID = ITEMS.register(
            "tbaker_solid", () -> new BlockItem(AITBlocks.TBAKER_SOLID.get(),new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> MASTER_SOLID = ITEMS.register(
            "master_solid", () -> new BlockItem(AITBlocks.MASTER_SOLID.get(),new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> MINT_SOLID = ITEMS.register(
            "mint_solid", () -> new BlockItem(AITBlocks.MINT_SOLID.get(),new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> HARTNELL_BLOWUP_SOLID = ITEMS.register(
            "hartnell_blowup_solid", () -> new BlockItem(AITBlocks.HARTNELL_BLOWUP_SOLID.get(),new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> STEEL_GRATE_BLOCK = ITEMS.register(
            "steel_grate_block", () -> new BlockItem(AITBlocks.STEEL_GRATE_BLOCK.get(),new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> STEEL_GRATE_BLOCK_SLAB = ITEMS.register(
            "steel_grate_block_slab", () -> new BlockItem(AITBlocks.STEEL_GRATE_BLOCK_SLAB.get(),new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> BRASS_PILLAR = ITEMS.register(
            "brass_pillar", () -> new BlockItem(AITBlocks.BRASS_PILLAR.get(),new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> ORMULUCLOCK = ITEMS.register(
            "ormuluclock", () -> new BlockItem(AITBlocks.ORMULUCLOCK.get(),new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> ARMILLARYSPHERE = ITEMS.register(
            "armillarysphere", () -> new BlockItem(AITBlocks.ARMILLARYSPHERE.get(),new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> WAR_SOLID = ITEMS.register(
            "war_solid", () -> new BlockItem(AITBlocks.WAR_SOLID.get(),new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> WAR_SOLID_SLAB = ITEMS.register(
            "war_solid_slab", () -> new BlockItem(AITBlocks.WAR_SOLID_SLAB.get(),new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final  RegistryObject<BlockItem> HARTNELL_MINT_A = ITEMS.register(
            "hartnell_mint_a", () -> new BlockItem(AITBlocks.HARTNELL_MINT_A.get(), new Item.Properties().tab(AITItemGroups.AITROUNDELS)));
    public static final  RegistryObject<BlockItem> HARTNELL_MINT_B = ITEMS.register(
            "hartnell_mint_b", () -> new BlockItem(AITBlocks.HARTNELL_MINT_B.get(), new Item.Properties().tab(AITItemGroups.AITROUNDELS)));
    public static final  RegistryObject<BlockItem> TBAKER_ROUNDEL_A = ITEMS.register(
            "tbaker_roundel_a", () -> new BlockItem(AITBlocks.TBAKER_ROUNDEL_A.get(), new Item.Properties().tab(AITItemGroups.AITROUNDELS)));
    public static final  RegistryObject<BlockItem> TBAKER_ROUNDEL_B = ITEMS.register(
            "tbaker_roundel_b", () -> new BlockItem(AITBlocks.TBAKER_ROUNDEL_B.get(), new Item.Properties().tab(AITItemGroups.AITROUNDELS)));
    public static final  RegistryObject<BlockItem> MASTER_ROUNDEL_A = ITEMS.register(
            "master_roundel_a", () -> new BlockItem(AITBlocks.MASTER_ROUNDEL_A.get(), new Item.Properties().tab(AITItemGroups.AITROUNDELS)));
    public static final  RegistryObject<BlockItem> MASTER_ROUNDEL_B = ITEMS.register(
            "master_roundel_b", () -> new BlockItem(AITBlocks.MASTER_ROUNDEL_B.get(), new Item.Properties().tab(AITItemGroups.AITROUNDELS)));
    public static final  RegistryObject<BlockItem> HARTNELL_BLOWUP_A = ITEMS.register(
            "hartnell_blowup_a", () -> new BlockItem(AITBlocks.HARTNELL_BLOWUP_A.get(), new Item.Properties().tab(AITItemGroups.AITROUNDELS)));
    public static final  RegistryObject<BlockItem> HARTNELL_BLOWUP_B = ITEMS.register(
            "hartnell_blowup_b", () -> new BlockItem(AITBlocks.HARTNELL_BLOWUP_B.get(), new Item.Properties().tab(AITItemGroups.AITROUNDELS)));
    public static final RegistryObject<BlockItem> CORAL_ROUNDEL = ITEMS.register(
            "coral_roundel", () -> new BlockItem(AITBlocks.CORAL_ROUNDEL.get(),new Item.Properties().tab(AITItemGroups.AITROUNDELS)));
    public static final RegistryObject<BlockItem> TOYOTA_FLASHING_LIGHT = ITEMS.register(
            "toyota_flashing_light", () -> new BlockItem(AITBlocks.TOYOTA_FLASHING_LIGHT.get(),new Item.Properties().tab(AITItemGroups.AITROUNDELS)));
    public static final RegistryObject<BlockItem> TOYOTA_FLASHING_LIGHT1 = ITEMS.register(
            "toyota_flashing_light1", () -> new BlockItem(AITBlocks.TOYOTA_FLASHING_LIGHT1.get(),new Item.Properties().tab(AITItemGroups.AITROUNDELS)));
    public static final RegistryObject<BlockItem> TOYOTA_FLASHING_LIGHTA = ITEMS.register(
            "toyota_flashing_lighta", () -> new BlockItem(AITBlocks.TOYOTA_FLASHING_LIGHTA.get(),new Item.Properties().tab(AITItemGroups.AITROUNDELS)));
    public static final RegistryObject<BlockItem> TOYOTA_FLASHING_LIGHT1A = ITEMS.register(
            "toyota_flashing_light1a", () -> new BlockItem(AITBlocks.TOYOTA_FLASHING_LIGHT1A.get(),new Item.Properties().tab(AITItemGroups.AITROUNDELS)));
    public static final RegistryObject<BlockItem> WAR_ROUNDEL_A = ITEMS.register(
            "war_roundel_a", () -> new BlockItem(AITBlocks.WAR_ROUNDEL_A.get(),new Item.Properties().tab(AITItemGroups.AITROUNDELS)));
    public static final RegistryObject<BlockItem> WAR_ROUNDEL_B = ITEMS.register(
            "war_roundel_b", () -> new BlockItem(AITBlocks.WAR_ROUNDEL_B.get(),new Item.Properties().tab(AITItemGroups.AITROUNDELS)));
    public static final RegistryObject<BlockItem> THREE_DOCTORS_ROUNDEL_A = ITEMS.register(
            "3_doctors_roundel_a", () -> new BlockItem(AITBlocks.THREE_DOCTORS_ROUNDEL_A.get(),new Item.Properties().tab(AITItemGroups.AITROUNDELS)));
    public static final RegistryObject<BlockItem> THREE_DOCTORS_ROUNDEL_B = ITEMS.register(
            "3_doctors_roundel_b", () -> new BlockItem(AITBlocks.THREE_DOCTORS_ROUNDEL_B.get(),new Item.Properties().tab(AITItemGroups.AITROUNDELS)));
    public static final RegistryObject<BlockItem> SMALL_CORAL_ROUNDEL = ITEMS.register(
            "small_coral_roundel", () -> new BlockItem(AITBlocks.SMALL_CORAL_ROUNDEL.get(),new Item.Properties().tab(AITItemGroups.AITROUNDELS)));
}

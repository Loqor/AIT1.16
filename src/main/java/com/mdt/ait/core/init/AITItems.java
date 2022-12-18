package com.mdt.ait.core.init;

import com.mdt.ait.AIT;
import com.mdt.ait.common.AITArmorMaterials;
import com.mdt.ait.common.items.*;
import com.mdt.ait.core.init.itemgroups.AITItemGroups;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.concurrent.locks.ReentrantLock;

public class AITItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AIT.MOD_ID);

    //Crafting stuff
    public static final RegistryObject<Item> SONIC_CRYSTAL = ITEMS.register(
            "sonic_crystal", () -> new Item(new Item.Properties().tab(AITItemGroups.AITITEMS)));
    public static final RegistryObject<Item> PLASMIC_SHELL = ITEMS.register(
            "plasmic_shell", ()-> new Item(new Item.Properties().tab(AITItemGroups.AITITEMS)));
    public static final RegistryObject<Item> TARDIS_HEART = ITEMS.register(
            "tardis_heart", ()-> new Item(new Item.Properties().tab(AITItemGroups.AITITEMS)));

    //Useful Items
    public static final RegistryObject<Item> STATTENHEIM_REMOTE = ITEMS.register(
            "stattenheim_remote", () -> new Item(new Item.Properties().tab(AITItemGroups.AITITEMS)));
    public static final RegistryObject<Item> RICKS_PORTAL_GUN = ITEMS.register(
            "ricks_portal_gun", () -> new Item(new Item.Properties().tab(AITItemGroups.AITITEMS)));
    public static final RegistryObject<SlingRingItem> SLING_RING = ITEMS.register(
            "sling_ring", () -> new SlingRingItem((new Item.Properties())));

    //Manuals
    public static final RegistryObject<GallifreyanManualItem> GALLIFREYAN_MANUAL = ITEMS.register(
            "gallifreyan_manual", () -> new GallifreyanManualItem((new Item.Properties().tab(AITItemGroups.AITITEMS))));

    //Fezzes
    public static final RegistryObject<FezArmorItem> WHITE_FEZ = ITEMS.register( //reciped
            "white_fez", () -> new FezArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.HEAD, new Item.Properties().tab(AITItemGroups.AITFEZZES)));

    public static final RegistryObject<FezArmorItem> GRAY_FEZ = ITEMS.register( //reciped
            "gray_fez", () -> new FezArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.HEAD, new Item.Properties().tab(AITItemGroups.AITFEZZES)));

    public static final RegistryObject<FezArmorItem> BLACK_FEZ = ITEMS.register( //reciped
            "black_fez", () -> new FezArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.HEAD, new Item.Properties().tab(AITItemGroups.AITFEZZES)));

    public static final RegistryObject<FezArmorItem> RED_FEZ = ITEMS.register( //reciped
            "red_fez", () -> new FezArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.HEAD, new Item.Properties().tab(AITItemGroups.AITFEZZES)));

    public static final RegistryObject<FezArmorItem> ORANGE_FEZ = ITEMS.register( //reciped
            "orange_fez", () -> new FezArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.HEAD, new Item.Properties().tab(AITItemGroups.AITFEZZES)));

    public static final RegistryObject<FezArmorItem> YELLOW_FEZ = ITEMS.register( //reciped
            "yellow_fez", () -> new FezArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.HEAD, new Item.Properties().tab(AITItemGroups.AITFEZZES)));

    public static final RegistryObject<FezArmorItem> L_GREEN_FEZ = ITEMS.register( //reciped
            "l_green_fez", () -> new FezArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.HEAD, new Item.Properties().tab(AITItemGroups.AITFEZZES)));

    public static final RegistryObject<FezArmorItem> GREEN_FEZ = ITEMS.register( //reciped
            "green_fez", () -> new FezArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.HEAD, new Item.Properties().tab(AITItemGroups.AITFEZZES)));

    public static final RegistryObject<FezArmorItem> D_GREEN_FEZ = ITEMS.register( //reciped
            "d_green_fez", () -> new FezArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.HEAD, new Item.Properties().tab(AITItemGroups.AITFEZZES)));

    public static final RegistryObject<FezArmorItem> L_BLUE_FEZ = ITEMS.register( //reciped
            "l_blue_fez", () -> new FezArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.HEAD, new Item.Properties().tab(AITItemGroups.AITFEZZES)));

    public static final RegistryObject<FezArmorItem> BLUE_FEZ = ITEMS.register( //reciped
            "blue_fez", () -> new FezArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.HEAD, new Item.Properties().tab(AITItemGroups.AITFEZZES)));

    public static final RegistryObject<FezArmorItem> D_BLUE_FEZ = ITEMS.register( //reciped
            "d_blue_fez", () -> new FezArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.HEAD, new Item.Properties().tab(AITItemGroups.AITFEZZES)));

    public static final RegistryObject<FezArmorItem> L_PURPLE_FEZ = ITEMS.register( //reciped
            "l_purple_fez", () -> new FezArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.HEAD, new Item.Properties().tab(AITItemGroups.AITFEZZES)));

    public static final RegistryObject<FezArmorItem> PURPLE_FEZ = ITEMS.register( //reciped
            "purple_fez", () -> new FezArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.HEAD, new Item.Properties().tab(AITItemGroups.AITFEZZES)));

    public static final RegistryObject<FezArmorItem> D_PURPLE_FEZ = ITEMS.register( //reciped
            "d_purple_fez", () -> new FezArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.HEAD, new Item.Properties().tab(AITItemGroups.AITFEZZES)));

    public static final RegistryObject<FezArmorItem> PINK_FEZ = ITEMS.register(
            "pink_fez", () -> new FezArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.HEAD, new Item.Properties().tab(AITItemGroups.AITFEZZES)));

    public static final RegistryObject<FezArmorItem> BROWN_FEZ = ITEMS.register(
            "brown_fez", () -> new FezArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.HEAD, new Item.Properties().tab(AITItemGroups.AITFEZZES)));
    /*======================================================================================================================================================*/

    //Foodstuffs
    public static final RegistryObject<Item> NUKA_COLA = ITEMS.register(
            "nuka_cola", () -> new Item(new Item.Properties().stacksTo(16).tab(AITItemGroups.AITFOODSTUFFS).food(CustomFood.NUKA_COLA)));

    //Cosmetics
    public static final RegistryObject<MessengerArmorItem> MESSENGER_BAG = ITEMS.register(
            "messenger_bag", () -> new MessengerArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.CHEST, new Item.Properties().tab(AITItemGroups.AITCOSMETICS)));

    public static final RegistryObject<ThreeDGlassesArmorItem> THREED_GLASSES = ITEMS.register(
            "3d_glasses", () -> new ThreeDGlassesArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.HEAD, new Item.Properties().tab(AITItemGroups.AITCOSMETICS)));

    public static final RegistryObject<AngelWingsItem> ANGEL_WINGS = ITEMS.register(
            "angel_wings", () -> new AngelWingsItem(AITArmorMaterials.FEZ, EquipmentSlotType.CHEST, new Item.Properties().tab(AITItemGroups.AITCOSMETICS).defaultDurability(864).fireResistant()));

    public static final RegistryObject<FourthsScarfArmorItem> FOURTHS_SCARF = ITEMS.register(
            "fourths_scarf", () -> new FourthsScarfArmorItem(AITArmorMaterials.FEZ, EquipmentSlotType.CHEST, new Item.Properties().tab(AITItemGroups.AITCOSMETICS)));

    //Sonic Screwdrivers
    public static final RegistryObject<SonicItem> TENNANT_SONIC = ITEMS.register(
            "tennant_sonic", () -> new SonicItem(new Item.Properties().tab(AITItemGroups.AITITEMS)));

    public static final RegistryObject<SonicItem> WHITTAKER_SONIC = ITEMS.register(
            "whittaker_sonic", () -> new SonicItem(new Item.Properties().tab(AITItemGroups.AITITEMS)));

    //Weapons
    public static final RegistryObject<CyberShockItem> CYBER_SHOCK = ITEMS.register(
            "cyber_shock", () -> new CyberShockItem(ItemTier.DIAMOND, 5, 2.0f, new Item.Properties().tab(AITItemGroups.AITWEAPONS)));
    public static final RegistryObject<AngelSwordItem> ANGEL_SWORD = ITEMS.register(
            "angel_sword", () -> new AngelSwordItem(ItemTier.NETHERITE, 12, 3.0f, new Item.Properties().tab(AITItemGroups.AITWEAPONS)));

    //Keys
    public static final RegistryObject<TARDISKey> GOLDEN_TARDIS_KEY = ITEMS.register(
            "golden_tardis_key", () -> new TARDISKey(new Item.Properties().tab(AITItemGroups.AITITEMS)));

    //Tools
    public static final RegistryObject<DematterStick> DEMATTER_STICK = ITEMS.register(
            "dematter_stick", () -> new DematterStick(new Item.Properties()));

    public static final RegistryObject<DevTool> DEV_TOOL = ITEMS.register(
            "dev_tool", () -> new DevTool(new Item.Properties())
    );

    //Time Machines
    public static final RegistryObject<BlockItem> TARDIS = ITEMS.register(
            "tardis", () -> new BlockItem(
                    AITBlocks.TARDIS_BLOCK.get(),new Item.Properties().tab(AITItemGroups.AITITEMS)));

    //Misc.
    public static final RegistryObject<BlockItem> RECORD_PLAYER = ITEMS.register(
            "record_player", () -> new BlockItem(
                    AITBlocks.RECORD_PLAYER_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> GBTCASING = ITEMS.register(
            "gbtcasing", () -> new BlockItem(
                    AITBlocks.GBTCASING_BLOCK.get(),new Item.Properties().tab(AITItemGroups.AITITEMS)));
    public static final RegistryObject<BlockItem> TARDIS_CORAL = ITEMS.register(
            "tardis_coral", () -> new BlockItem(
                    AITBlocks.TARDIS_CORAL_BLOCK.get(),new Item.Properties().tab(AITItemGroups.AITITEMS)));

    //Controls
    public static final RegistryObject<BlockItem> TARDIS_LEVER = ITEMS.register(
            "tardis_lever", () -> new BlockItem(
                    AITBlocks.TARDIS_LEVER_BLOCK.get(),new Item.Properties().tab(AITItemGroups.AITITEMS)));

    //Rotors
    public static final RegistryObject<BlockItem> BASIC_ROTOR = ITEMS.register(
            "basic_rotor", () -> new BlockItem(
                    AITBlocks.BASIC_ROTOR_BLOCK.get(),new Item.Properties().tab(AITItemGroups.AITITEMS)));
    public static final RegistryObject<BlockItem> HARTNELL_ROTOR = ITEMS.register(
            "hartnell_rotor", () -> new BlockItem(
                    AITBlocks.HARTNELL_ROTOR_BLOCK.get(),new Item.Properties().tab(AITItemGroups.AITITEMS)));
    public static final RegistryObject<BlockItem> HUDOLIN_ROTOR = ITEMS.register(
            "hudolin_rotor", () -> new BlockItem(
                    AITBlocks.HUDOLIN_ROTOR_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITITEMS)));
    public static final RegistryObject<BlockItem> TOYOTA_WHIRLAGIG = ITEMS.register(
            "toyota_whirlagig", () -> new BlockItem(
                    AITBlocks.TOYOTA_WHIRLAGIG_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITITEMS)));
    public static final RegistryObject<BlockItem> TOYOTA_ROTOR = ITEMS.register(
            "toyota_rotor", () -> new BlockItem(
                    AITBlocks.TOYOTA_ROTOR_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITITEMS)));

    //Controls
    public static final RegistryObject<BlockItem> DIMENSION_SWITCH_CONTROL = ITEMS.register(
            "dimension_switch_control", () -> new BlockItem(
                    AITBlocks.DIMENSION_SWITCH_CONTROL_BLOCK.get(),new Item.Properties().tab(AITItemGroups.AITITEMS)));
    public static final RegistryObject<BlockItem> TARDIS_COORDINATE_CONTROL = ITEMS.register(
            "tardis_coordinate_control", () -> new BlockItem(
                    AITBlocks.TARDIS_COORDINATE_CONTROL_BLOCK.get(),new Item.Properties().tab(AITItemGroups.AITITEMS)));
    public static final RegistryObject<BlockItem> EXTERIOR_FACING_CONTROL = ITEMS.register(
            "exterior_facing_control", () -> new BlockItem(
                    AITBlocks.EXTERIOR_FACING_CONTROL_BLOCK.get(),new Item.Properties().tab(AITItemGroups.AITITEMS)));
    public static final RegistryObject<BlockItem> TENNANT_MONITOR = ITEMS.register(
            "tennant_monitor", () -> new BlockItem(
                    AITBlocks.TENNANT_MONITOR_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITITEMS)));
    public static final RegistryObject<BlockItem> TOYOTA_MONITOR = ITEMS.register(
            "toyota_monitor", () -> new BlockItem(
                    AITBlocks.TOYOTA_MONITOR_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITITEMS)));
    public static final RegistryObject<BlockItem> DOOR_SWITCH_CONTROL_BLOCK = ITEMS.register(
            "door_switch_control", () -> new BlockItem(
                    AITBlocks.DOOR_SWITCH_CONTROL_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITITEMS)));

    public static final RegistryObject<BlockItem> TARDIS_POWER_ACCESS_POINT = ITEMS.register(
            "tardis_power_access_point", () -> new BlockItem(
                    AITBlocks.TARDIS_POWER_ACCESS_POINT_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITITEMS)));

    public static final RegistryObject<BlockItem> ROUNDEL_FACE = ITEMS.register(
            "roundel_face", () -> new BlockItem(
                    AITBlocks.ROUNDEL_FACE_BLOCK.get(),new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> CONSOLE_BLOCK = ITEMS.register(
            "console_block", () -> new BlockItem(
                    AITBlocks.CONSOLE_BLOCK.get(),new Item.Properties().tab(AITItemGroups.AITITEMS)));
    public static final RegistryObject<BlockItem> TSV = ITEMS.register(
            "tsv", () -> new BlockItem(
                    AITBlocks.TSV_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> RAMP = ITEMS.register(
            "ramp", () -> new BlockItem(
                    AITBlocks.RAMP_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));

    //Monitors
    public static final RegistryObject<BlockItem> TYPEWRITER = ITEMS.register(
            "typewriter", () -> new BlockItem(
                    AITBlocks.TYPEWRITER_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));

    public static final RegistryObject<BlockItem> INVIS_BLOCK = ITEMS.register(
            "invis_block", () -> new BlockItem(
                    AITBlocks.INVIS_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));

    public static final RegistryObject<BlockItem> INVIS_LIGHT_BLOCK = ITEMS.register("invis_light_block", () -> new BlockItem(
            AITBlocks.INVIS_LIGHT_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)
    ));

    //Interior Doors
    public static final RegistryObject<BlockItem> BASIC_INTERIOR_DOOR = ITEMS.register(
            "interior_doors", () -> new BlockItem(
                    AITBlocks.INTERIOR_DOOR_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));

    public static final RegistryObject<BlockItem> TEST_BLOCK_ITEM = ITEMS.register("test_block",
            () -> new BlockItem(
                    AITBlocks.TEST_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> GALLIFREY_STONE = ITEMS.register(
            "gallifrey_stone", () -> new BlockItem(AITBlocks.GALLIFREY_STONE.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> GALLIFREY_SAND = ITEMS.register(
            "gallifrey_sand", () -> new BlockItem(AITBlocks.GALLIFREY_SAND.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
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
    public static final RegistryObject<BlockItem> COW_SKULL = ITEMS.register(
            "cow_skull", () -> new BlockItem(AITBlocks.COW_SKULL.get(),new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
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
    public static final RegistryObject<BlockItem> LIGHT_BLOCK_ORANGE = ITEMS.register(
            "light_block_orange", () -> new BlockItem(AITBlocks.LIGHT_BLOCK_ORANGE.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> LIGHT_BLOCK_BLUE = ITEMS.register(
            "light_block_blue", () -> new BlockItem(AITBlocks.LIGHT_BLOCK_BLUE.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> LIGHT_BLOCK_PURPLE = ITEMS.register(
            "light_block_purple", () -> new BlockItem(AITBlocks.LIGHT_BLOCK_PURPLE.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> LIGHT_BLOCK_GREEN = ITEMS.register(
            "light_block_green", () -> new BlockItem(AITBlocks.LIGHT_BLOCK_GREEN.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> TOYOTA_ROOF = ITEMS.register(
            "toyota_roof", () -> new BlockItem(AITBlocks.TOYOTA_ROOF.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> TOYOTA_ROOF_LIGHT = ITEMS.register(
            "toyota_roof_light", () -> new BlockItem(AITBlocks.TOYOTA_ROOF_LIGHT.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> TOYOTA_PILLAR = ITEMS.register(
            "toyota_pillar", () -> new BlockItem(AITBlocks.TOYOTA_PILLAR.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> INTERIOR_CENTER_BLOCK = ITEMS.register(
            "interior_center_block", () -> new BlockItem(AITBlocks.INTERIOR_CENTER_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
   /* public static final RegistryObject<BlockItem> TOYOTA_ROOF = ITEMS.register(
            "toyota_roof", () -> new BlockItem(AITBlocks.TOYOTA_ROOF.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> TOYOTA_ROOF = ITEMS.register(
            "toyota_roof", () -> new BlockItem(AITBlocks.TOYOTA_ROOF.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> TOYOTA_ROOF = ITEMS.register(
            "toyota_roof", () -> new BlockItem(AITBlocks.TOYOTA_ROOF.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
    public static final RegistryObject<BlockItem> TOYOTA_ROOF = ITEMS.register(
            "toyota_roof", () -> new BlockItem(AITBlocks.TOYOTA_ROOF.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));*/

    //Entities
    public static final RegistryObject<AITSpawnEgg> K9_SPAWN_EGG = ITEMS.register
            ("k9_spawn_egg", () -> new AITSpawnEgg(AITEntities.K9,0x2F329F,0x2FBD9F,new Item.Properties().tab(AITItemGroups.AITMOBS)));
    public static final RegistryObject<AITSpawnEgg> CYBER_CAVALRY_SPAWN_EGG = ITEMS.register
            ("cybercavalry_spawn_egg", () -> new AITSpawnEgg(AITEntities.CYBERCAVALRY,0x2F329F,0x2FBD9F,new Item.Properties().tab(AITItemGroups.AITMOBS)));
    public static final RegistryObject<AITSpawnEgg> ANGEL_ENTITY_SPAWN_EGG = ITEMS.register
            ("angel_entity_spawn_egg", () -> new AITSpawnEgg(AITEntities.ANGEL_ENTITY,0x2F329F,0x2F329F,new Item.Properties().tab(AITItemGroups.AITMOBS)));
    public static final RegistryObject<AITSpawnEgg> CLASSIC_DALEK_ENTITY_SPAWN_EGG = ITEMS.register
            ("classic_dalek_entity_spawn_egg", () -> new AITSpawnEgg(AITEntities.CLASSIC_DALEK_ENTITY,0x2F329F,0x6F525F,new Item.Properties().tab(AITItemGroups.AITMOBS)));
}

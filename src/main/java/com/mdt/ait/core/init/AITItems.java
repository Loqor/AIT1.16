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

public class AITItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AIT.MOD_ID);

    public static final RegistryObject<SonicItem> TENNANT_SONIC = ITEMS.register(
            "tennant_sonic", () -> new SonicItem(new Item.Properties().tab(AITItemGroups.AITITEMS)));

    public static final RegistryObject<BlockItem> TEST_BLOCK_ITEM = ITEMS.register("test_block",
            () -> new BlockItem(
                    AITBlocks.TEST_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));

    public static final RegistryObject<BlockItem> TARDIS = ITEMS.register(
            "tardis", () -> new BlockItem(
                    AITBlocks.TARDIS_BLOCK.get(),new Item.Properties().tab(AITItemGroups.AITITEMS)));
    public static final RegistryObject<BlockItem> TSV = ITEMS.register(
            "tsv", () -> new BlockItem(
                    AITBlocks.TSV_BLOCK.get(), new Item.Properties().tab(AITItemGroups.AITBLOCKS)));
}

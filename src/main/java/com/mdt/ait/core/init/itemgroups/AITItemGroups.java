package com.mdt.ait.core.init.itemgroups;

import com.mdt.ait.core.init.AITBlocks;
import com.mdt.ait.core.init.AITItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class AITItemGroups {

    public static final ItemGroup AITITEMS = new ItemGroup("Items") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(AITItems.TARDIS.get());
        }
    };

    public static final ItemGroup AITBLOCKS = new ItemGroup("Blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(AITItems.TEST_BLOCK_ITEM.get());
        }
    };
}
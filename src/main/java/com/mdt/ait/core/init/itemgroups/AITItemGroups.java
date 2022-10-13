package com.mdt.ait.core.init.itemgroups;

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
            return new ItemStack(AITItems.TYPEWRITER.get());
        }
    };

    public static final ItemGroup AITROUNDELS = new ItemGroup("Roundels") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(AITItems.HARTNELL_MINT_A.get());
        }
    };

    public static final ItemGroup AITCOSMETICS = new ItemGroup("Cosmetics") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(AITItems.THREED_GLASSES.get());
        }
    };
    public static final ItemGroup AITFEZZES = new ItemGroup("Fezzes") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(AITItems.RED_FEZ.get());
        }
    };
    public static final ItemGroup AITFOODSTUFFS = new ItemGroup("Foodstuffs") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(AITItems.NUKA_COLA.get());
        }
    };
    public static final ItemGroup AITMOBS = new ItemGroup("Mobs") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(AITItems.K9_SPAWN_EGG.get());
        }
    };
    public static final ItemGroup AITWEAPONS = new ItemGroup("Weapons") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(AITItems.ANGEL_SWORD.get());
        }
    };
}
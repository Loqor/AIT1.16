package io.mdt.ait.tardis;

import com.mdt.ait.core.init.AITBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class TARDISConfig {

    public static final String INTERIOR_CENTER_BLOCK = "ait:interior_center_block";
    public static final String INTERIOR_DOOR_BLOCK = "ait:basic_interior_door_block";

    public static final int TARDIS_USABLE_AREA = 40055;
    public static final int TARDIS_AREA = TARDIS_USABLE_AREA + 1000;

    public static final int TARDIS_DIMENSION_START = 28000000;
    public static final int TARDIS_CENTER_Y = 100;

    public static final int TARDIS_BASE_ENERGY_STORAGE = 50000;
    public static final int TARDIS_BASE_RECHARGE_RATE = 1000; // Per second

    public static final Block[] CANT_LAND_ON = new Block[] {
            Blocks.AIR,
            Blocks.CAVE_AIR,
            Blocks.WATER,
            Blocks.LAVA,
            AITBlocks.TARDIS_BLOCK.get(),
            AITBlocks.TARDIS_POWER_ACCESS_POINT_BLOCK.get(),
            AITBlocks.TARDIS_LEVER_BLOCK.get(),
            AITBlocks.DIMENSION_SWITCH_CONTROL_BLOCK.get()
    };

    public static final String[] TARDIS_NAMES = new String[] {
            "Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Iota",
            "Kappa", "Lambda", "Mu", "Nu", "Xi", "Omicron", "Pi", "Rho", "Sigma", "Tau",
            "Upsilon", "Phi", "Chi", "Psi", "Omega"
    };
}

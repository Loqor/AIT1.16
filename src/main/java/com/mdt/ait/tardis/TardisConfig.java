package com.mdt.ait.tardis;

import com.mdt.ait.core.init.AITBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.ArrayList;

public class TardisConfig {

    public static final ArrayList<Block> cantLandOnBlockList = new ArrayList<>();
    public static final ArrayList<String> tardisNamesList = new ArrayList<>();

    public static void init() {
        cantLandOnBlockList.add(Blocks.AIR);
        cantLandOnBlockList.add(Blocks.CAVE_AIR);
        cantLandOnBlockList.add(Blocks.VOID_AIR);
        cantLandOnBlockList.add(Blocks.WATER);
        cantLandOnBlockList.add(Blocks.LAVA);
        cantLandOnBlockList.add(AITBlocks.TARDIS_BLOCK.get());
        cantLandOnBlockList.add(AITBlocks.TARDIS_POWER_ACCESS_POINT_BLOCK.get());
        cantLandOnBlockList.add(AITBlocks.TARDIS_LEVER_BLOCK.get());
        cantLandOnBlockList.add(AITBlocks.DIMENSION_SWITCH_CONTROL_BLOCK.get());
        tardisNamesList.add("Alpha");
        tardisNamesList.add("Beta");
        tardisNamesList.add("Gamma");
        tardisNamesList.add("Delta");
        tardisNamesList.add("Epsilon");
        tardisNamesList.add("Zeta");
        tardisNamesList.add("Eta");
        tardisNamesList.add("Theta");
        tardisNamesList.add("Iota");
        tardisNamesList.add("Kappa");
        tardisNamesList.add("Lambda");
        tardisNamesList.add("Mu");
        tardisNamesList.add("Nu");
        tardisNamesList.add("Xi");
        tardisNamesList.add("Omikron");
        tardisNamesList.add("Pi");
        tardisNamesList.add("Rho");
        tardisNamesList.add("Sigma");
        tardisNamesList.add("Tau");
        tardisNamesList.add("Upsilon");
        tardisNamesList.add("Phi");
        tardisNamesList.add("Chi");
        tardisNamesList.add("Psi");
        tardisNamesList.add("Omega");
    }

    public static final int tardis_usable_area_x = 40055;
    public static final int tardis_usable_area_z = 40055;
    public static final int tardis_area_x = tardis_usable_area_x + 1000;
    public static final int tardis_area_z = tardis_usable_area_z + 1000;
    public static final int tardis_dimension_start_x = 28000000;
    public static final int tardis_dimension_start_z = 28000000;
    public static final int tardis_center_y = 100;

    public static final int tardis_default_base_energy_storage = 50000;

    public static final int tardis_default_energy_recharge_rate = 1000; // Per second

    public static final String tardis_center_block_name = "ait:interior_center_block";

}

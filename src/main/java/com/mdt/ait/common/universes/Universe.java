package com.mdt.ait.common.universes;

import com.mdt.ait.core.init.enums.EnumDangerLevel;
import net.minecraft.world.World;

import java.util.HashMap;

public class Universe {

    public String name;
    public EnumDangerLevel dangerLevel;



    public Universe(String name, EnumDangerLevel dangerLevel) {
        this.name = name;
        this.dangerLevel = dangerLevel;
    }


    public String getName() {
        return this.name;
    }
}

package com.mdt.ait.common.items;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class CustomFood {

    public static final Food NUKA_COLA = (new Food.Builder()).nutrition(4).saturationMod(1.2F).effect
            (new EffectInstance(Effects.NIGHT_VISION, 4000, 1), 1.0F).effect
            (new EffectInstance(Effects.WEAKNESS, 2000, 1), 1.0F).alwaysEat().build();
}
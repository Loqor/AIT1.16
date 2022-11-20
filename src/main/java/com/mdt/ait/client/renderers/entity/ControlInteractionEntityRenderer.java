package com.mdt.ait.client.renderers.entity;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.entities.ClassicDalek;
import com.mdt.ait.client.models.entities.ControlInteractionIgnore;
import com.mdt.ait.client.renderers.layers.ClassicDalekEmissionLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;


public class ControlInteractionEntityRenderer extends MobRenderer {

    public static final ResourceLocation TEXTURE = new ResourceLocation(AIT.MOD_ID, "textures/entity/invisible.png");

    public ControlInteractionEntityRenderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new ControlInteractionIgnore(), 0.35f);
    }

    @Override
    public ResourceLocation getTextureLocation(Entity p_110775_1_) {
        return TEXTURE;
    }
}
package com.mdt.ait.client.renderers.entity;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.entities.ClassicDalek;
import com.mdt.ait.client.models.entities.K9EntityModel;
import com.mdt.ait.client.renderers.layers.ClassicDalekEmissionLayer;
import com.mdt.ait.client.renderers.layers.K9EmissionLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;


public class ClassicDalekEntityRenderer extends MobRenderer {

    public static final ResourceLocation TEXTURE = new ResourceLocation(AIT.MOD_ID, "textures/entity/classic_dalek.png");

    public ClassicDalekEntityRenderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new ClassicDalek(), 0.35f);
        this.addLayer(new ClassicDalekEmissionLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Entity p_110775_1_) {
        return TEXTURE;
    }
}
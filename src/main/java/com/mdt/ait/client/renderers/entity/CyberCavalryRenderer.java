package com.mdt.ait.client.renderers.entity;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.entities.CyberCavalry;
import com.mdt.ait.client.models.entities.K9EntityModel;
import com.mdt.ait.client.renderers.layers.CyberCavalryEmissionLayer;
import com.mdt.ait.client.renderers.layers.K9EmissionLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;


public class CyberCavalryRenderer extends MobRenderer {

    public static final ResourceLocation TEXTURE = new ResourceLocation(AIT.MOD_ID, "textures/entity/cybercavalry.png");

    public CyberCavalryRenderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new CyberCavalry(0), 0.35f);
        this.addLayer(new CyberCavalryEmissionLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Entity p_110775_1_) {
        return TEXTURE;
    }
}
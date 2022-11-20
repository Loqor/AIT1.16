package com.mdt.ait.client.renderers.entity;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.entities.ClassicDalek;
import com.mdt.ait.client.models.entities.LaserShot;
import com.mdt.ait.client.renderers.layers.ClassicDalekEmissionLayer;
import com.mdt.ait.client.renderers.layers.LaserShotEmissionLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;


public class LaserShotEntityRenderer extends MobRenderer {

    public static final ResourceLocation TEXTURE = new ResourceLocation(AIT.MOD_ID, "textures/entity/projectiles/laser_shot.png");

    public LaserShotEntityRenderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new LaserShot(), 0.35f);
        this.addLayer(new LaserShotEmissionLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Entity p_110775_1_) {
        return TEXTURE;
    }
}
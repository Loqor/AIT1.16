package com.mdt.ait.client.renderers.machines;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.machines.Delorean;
import com.mdt.ait.client.renderers.layers.DeloreanEmissionLayer;
import com.mdt.ait.common.entities.DeloreanEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class DeloreanRenderer extends MobRenderer<DeloreanEntity, Delorean> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(AIT.MOD_ID, "textures/machines/delorean_machine.png");

    public DeloreanRenderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new Delorean(), 1f);
        this.addLayer(new DeloreanEmissionLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(DeloreanEntity pEntity) {
        return TEXTURE;
    }
}

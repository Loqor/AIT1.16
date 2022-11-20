package com.mdt.ait.client.renderers.machines;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.entities.ClassicDalek;
import com.mdt.ait.client.models.entities.ControlInteractionIgnore;
import com.mdt.ait.client.models.exteriors.BasicBox;
import com.mdt.ait.client.models.machines.Delorean;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.client.renderers.layers.DeloreanEmissionLayer;
import com.mdt.ait.common.entities.DeloreanEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.passive.AmbientEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

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

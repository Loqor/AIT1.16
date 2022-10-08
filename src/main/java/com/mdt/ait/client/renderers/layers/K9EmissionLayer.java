package com.mdt.ait.client.renderers.layers;

import com.mdt.ait.AIT;
import com.mdt.ait.client.renderers.entity.AITAbstractEyesLayer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.SpiderEyesLayer;
import net.minecraft.client.renderer.entity.model.SpiderModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class K9EmissionLayer<T extends Entity, M extends SpiderModel<T>> extends AITAbstractEyesLayer<T, M> {
    private static final RenderType K9_EMISSION = RenderType.eyes(new ResourceLocation(AIT.MOD_ID, "textures/entity/k9_emission.png"));

    public K9EmissionLayer(IEntityRenderer<T, M> p_116981_) {
       super(p_116981_);
    }
    @Override
    public RenderType renderType() {
        return K9_EMISSION;
    }
}

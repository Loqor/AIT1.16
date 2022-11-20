package com.mdt.ait.client.renderers.layers;

import com.mdt.ait.AIT;
import com.mdt.ait.client.renderers.entity.AITAbstractEyesLayer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.model.SpiderModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ClassicDalekEmissionLayer<T extends Entity, M extends SpiderModel<T>> extends AITAbstractEyesLayer<T, M> {
    private static final RenderType DALEK_EMISSION = RenderType.eyes(new ResourceLocation(AIT.MOD_ID, "textures/entity/classic_dalek_emission.png"));

    public ClassicDalekEmissionLayer(IEntityRenderer<T, M> p_116981_) {
       super(p_116981_);
    }
    @Override
    public RenderType renderType() {
        return DALEK_EMISSION;
    }
}

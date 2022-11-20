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
public class LaserShotEmissionLayer<T extends Entity, M extends SpiderModel<T>> extends AITAbstractEyesLayer<T, M> {
    private static final RenderType BEAM_EMISSION = RenderType.eyes(new ResourceLocation(AIT.MOD_ID, "textures/entity/projectiles/laser_shot.png"));

    public LaserShotEmissionLayer(IEntityRenderer<T, M> p_116981_) {
       super(p_116981_);
    }
    @Override
    public RenderType renderType() {
        return BEAM_EMISSION;
    }
}

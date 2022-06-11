package com.mdt.ait.client.renderers;

import com.mdt.ait.AIT;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AITRenderTypes extends RenderType {

    protected static final RenderState.LightmapState LIGHTMAP = new RenderState.LightmapState(true);
    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/basic_tardis_exterior.png");

    protected static final RenderState.TransparencyState GENERIC = new RenderState.TransparencyState("generic", () -> {
        RenderSystem.enableBlend();
        RenderSystem.enableAlphaTest();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        //RenderSystem.color4f(1, 1, 1, 0.4F);
    }, () -> {
        RenderSystem.disableAlphaTest();
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
    });

    protected static final RenderState.DiffuseLightingState DIFFUSE_LIGHTING_ENABLED = new RenderState.DiffuseLightingState(true);

    public AITRenderTypes(String p_i225992_1_, VertexFormat p_i225992_2_, int p_i225992_3_, int p_i225992_4_, boolean p_i225992_5_, boolean p_i225992_6_, Runnable p_i225992_7_, Runnable p_i225992_8_) {
        super(p_i225992_1_, p_i225992_2_, p_i225992_3_, p_i225992_4_, p_i225992_5_, p_i225992_6_, p_i225992_7_, p_i225992_8_);
    }

    public static RenderType TardisLightmap(ResourceLocation locationIn, boolean bool) {
        RenderType.State rendertype$state = RenderType.State.builder().setTextureState(new TextureState(locationIn, false, false)).setTransparencyState(GENERIC).setCullState(CULL).setAlphaState(DEFAULT_ALPHA).setWriteMaskState(COLOR_DEPTH_WRITE).setFogState(NO_FOG).createCompositeState(true);
        return create("tardis_lightmap", DefaultVertexFormats.NEW_ENTITY, 7, 256, false, true, rendertype$state);
    }

    public static RenderType TardisRenderOver(ResourceLocation locationIn) {
        State state = State.builder().setTextureState(new TextureState(locationIn, false, false)).setDiffuseLightingState(DIFFUSE_LIGHTING_ENABLED).setTransparencyState(GENERIC).setAlphaState(DEFAULT_ALPHA).setShadeModelState(SMOOTH_SHADE).setCullState(CULL).setLightmapState(RenderState.LIGHTMAP).setOverlayState(OVERLAY).createCompositeState(true);
        return RenderType.create("tardis", DefaultVertexFormats.NEW_ENTITY, 7, 256, state);
    }
}

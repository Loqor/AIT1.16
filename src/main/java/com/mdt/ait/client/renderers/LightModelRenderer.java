package com.mdt.ait.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class LightModelRenderer extends ModelRenderer {
    public static final int MAX_LIGHT = 15728880;
    float bright = 0;

    public LightModelRenderer(Model model) {
        super(model);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float i, float i1, float i2, float i3) {
        float lightDifference = MAX_LIGHT - packedLightIn;
        packedLightIn += lightDifference * this.bright;
        super.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, i, i1, i2, i3);
    }
    public void setBright(float b) {
        this.bright = b;
    }
}

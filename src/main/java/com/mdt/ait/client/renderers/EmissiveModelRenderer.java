package com.mdt.ait.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
public class EmissiveModelRenderer extends ModelRenderer{

    public static final int MAX_LIGHT = 15728880;
    float brightness = 0;

    public EmissiveModelRenderer(Model model) {
        super(model);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {

        float solid = MAX_LIGHT - packedLightIn;

        packedLightIn += solid * this.brightness;

        super.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }

    public void setBright(float bright) {
        this.brightness = bright;
    }


}

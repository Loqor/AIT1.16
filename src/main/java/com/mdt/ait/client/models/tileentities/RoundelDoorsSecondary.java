package com.mdt.ait.client.models.tileentities;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.client.models.tileentities.RoundelDoors;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class RoundelDoorsSecondary extends RoundelDoors {
	public final ModelRenderer doorright;
	private final ModelRenderer bb_main;

	public RoundelDoorsSecondary() {
		texWidth = 128;
		texHeight = 128;

		doorright = new ModelRenderer(this);
		doorright.setPos(8.0F, 24.0F, -8.0F);
		doorright.texOffs(0, 0).addBox(-16.0F, -48.0F, 0.0F, 16.0F, 48.0F, 5.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);
		bb_main.texOffs(17, 54).addBox(4.95F, -48.0F, -8.0F, 3.0F, 48.0F, 5.0F, 0.001F, true);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		doorright.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
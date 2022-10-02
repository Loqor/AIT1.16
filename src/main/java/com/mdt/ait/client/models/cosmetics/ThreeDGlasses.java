package com.mdt.ait.client.models.cosmetics;// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ThreeDGlasses extends EntityModel<Entity> {
	private final ModelRenderer bb_main;

	public ThreeDGlasses() {
		texWidth = 64;
		texHeight = 64;

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);
		bb_main.texOffs(0, 5).addBox(0.0F, -31.0F, -6.0F, 6.0F, 4.0F, 0.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(-6.0F, -31.0F, -6.0F, 6.0F, 4.0F, 0.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(-6.0F, -30.0F, -6.0F, 0.0F, 2.0F, 16.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(6.0F, -30.0F, -6.0F, 0.0F, 2.0F, 16.0F, 0.0F, true);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
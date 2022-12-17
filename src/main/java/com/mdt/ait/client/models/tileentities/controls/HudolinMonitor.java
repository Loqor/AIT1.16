package com.mdt.ait.client.models.tileentities.controls;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class HudolinMonitor extends EntityModel<Entity> {
	private final ModelRenderer bb_main;

	public HudolinMonitor() {
		texWidth = 128;
		texHeight = 128;

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);
		bb_main.texOffs(29, 0).addBox(-7.0F, -19.0F, -5.0F, 14.0F, 17.0F, 10.0F, 0.0F, false);
		bb_main.texOffs(29, 0).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(-7.0F, -89.0F, 0.0F, 14.0F, 70.0F, 0.0F, 0.0F, false);
		bb_main.texOffs(29, 28).addBox(-7.0F, -19.0F, -5.15F, 14.0F, 17.0F, 0.0F, 0.0F, false);
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
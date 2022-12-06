package com.mdt.ait.client.models.cosmetics;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FourthsScarf extends EntityModel<Entity> {
	private final ModelRenderer scarf;

	public FourthsScarf() {
		texWidth = 64;
		texHeight = 64;

		scarf = new ModelRenderer(this);
		scarf.setPos(0.0F, 23.75F, 0.0F);
		scarf.texOffs(0, 0).addBox(-5.0F, -24.0F, -2.5F, 10.0F, 0.0F, 5.0F, 0.0F, false);
		scarf.texOffs(44, 40).addBox(-5.0F, -24.0F, -2.5F, 10.0F, 24.0F, 0.0F, 0.0F, false);
		scarf.texOffs(44, 0).addBox(-5.0F, -24.0F, 2.5F, 10.0F, 24.0F, 0.0F, 0.0F, false);
		scarf.texOffs(0, 35).addBox(-5.0F, -24.0F, -2.5F, 0.0F, 24.0F, 5.0F, 0.0F, false);
		scarf.texOffs(11, 35).addBox(5.0F, -24.0F, -2.5F, 0.0F, 24.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		scarf.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
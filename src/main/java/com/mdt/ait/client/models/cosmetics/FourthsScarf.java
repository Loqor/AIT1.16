package com.mdt.ait.client.models.cosmetics;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FourthsScarf extends EntityModel<Entity> {
	private final ModelRenderer bone;

	public FourthsScarf() {
		texWidth = 24;
		texHeight = 16;

		bone = new ModelRenderer(this);
		bone.setPos(0.0F, 24.0F, 0.5F);
		bone.texOffs(0, 0).addBox(-4.0F, -24.0F, -2.5F, 8.0F, 0.0F, 4.0F, 0.001F, false);
		bone.texOffs(4, 4).addBox(-4.0F, -24.0F, -2.5F, 8.0F, 12.0F, 0.0F, 0.005F, false);
		bone.texOffs(8, 4).addBox(-4.0F, -24.0F, 1.5F, 8.0F, 2.0F, 0.0F, 0.003F, false);
		bone.texOffs(0, 0).addBox(-4.0F, -24.0F, -2.5F, 0.0F, 2.0F, 4.0F, 0.002F, false);
		bone.texOffs(9, 0).addBox(4.0F, -24.0F, -2.5F, 0.0F, 2.0F, 4.0F, 0.004F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
package com.mdt.ait.client.models.tileentities.controls;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FastReturnLeverControl extends EntityModel<Entity> {
	private final ModelRenderer lever;
	private final ModelRenderer base;

	public FastReturnLeverControl() {
		texWidth = 64;
		texHeight = 64;

		lever = new ModelRenderer(this);
		lever.setPos(-0.25F, 21.25F, 0.0F);
		setRotationAngle(lever, 0.0F, 0.0F, 0.9163F);
		lever.texOffs(0, 29).addBox(-0.9813F, -10.1496F, -6.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
		lever.texOffs(5, 0).addBox(-0.9813F, -8.1496F, 5.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);
		lever.texOffs(31, 17).addBox(-0.9813F, -4.1496F, 0.0F, 2.0F, 0.0F, 5.0F, 0.0F, false);
		lever.texOffs(0, 0).addBox(-0.9813F, -4.1496F, 0.0F, 2.0F, 6.0F, 0.0F, 0.0F, false);

		base = new ModelRenderer(this);
		base.setPos(0.0F, 24.0F, 0.0F);
		base.texOffs(0, 0).addBox(-7.0F, -2.0F, -7.0F, 14.0F, 2.0F, 14.0F, 0.0F, false);
		base.texOffs(0, 17).addBox(-5.0F, -3.0F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
		base.texOffs(17, 29).addBox(-4.0F, -3.25F, -3.0F, 8.0F, 0.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		lever.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
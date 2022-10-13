package com.mdt.ait.client.models.entities;// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.entities.CyberCavalryEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class CyberCavalry extends BipedModel<CyberCavalryEntity> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;

	public CyberCavalry(float p_i1148_1_) {
		super(RenderType::entityCutoutNoCull, p_i1148_1_, 0.0F, 64, 32);
		texWidth = 128;
		texHeight = 128;

		head = new ModelRenderer(this);
		head.setPos(0.0F, 0.0F, 0.0F);
		head.texOffs(0, 17).addBox(-4.0F, -8.0F, -3.625F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.texOffs(59, 59).addBox(3.5F, -7.0F, -2.125F, 2.0F, 5.0F, 5.0F, 0.0F, false);
		head.texOffs(17, 64).addBox(3.0F, -10.0F, -0.625F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		head.texOffs(0, 51).addBox(-1.5F, -11.0F, -1.875F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		head.texOffs(17, 37).addBox(-5.0F, -10.0F, -0.625F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		head.texOffs(13, 34).addBox(-3.0F, -9.5F, -0.125F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		head.texOffs(33, 17).addBox(-5.5F, -7.0F, -2.125F, 2.0F, 5.0F, 5.0F, 0.0F, false);
		head.texOffs(0, 0).addBox(-4.0F, -8.0F, -3.625F, 8.0F, 8.0F, 8.0F, 0.25F, false);

		body = new ModelRenderer(this);
		body.setPos(0.0F, 24.0F, 0.0F);
		body.texOffs(33, 0).addBox(-4.0F, -24.0F, -1.625F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		body.texOffs(29, 30).addBox(-4.0F, -24.0F, -1.625F, 8.0F, 12.0F, 4.0F, 0.25F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setPos(-4.0F, 2.0F, 0.0F);
		rightArm.texOffs(58, 0).addBox(-4.0F, -2.0F, -1.625F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		rightArm.texOffs(30, 47).addBox(-4.0F, -2.0F, -1.625F, 4.0F, 12.0F, 4.0F, 0.255F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setPos(4.0F, 2.0F, 0.0F);
		leftArm.texOffs(50, 17).addBox(0.0F, -2.0F, -1.625F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		leftArm.texOffs(47, 47).addBox(0.0F, -2.0F, -1.625F, 4.0F, 12.0F, 4.0F, 0.255F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setPos(-2.0F, 12.0F, 0.0F);
		rightLeg.texOffs(60, 34).addBox(-2.0F, 0.0F, -1.625F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		rightLeg.texOffs(0, 34).addBox(-2.0F, 0.0F, -1.625F, 4.0F, 12.0F, 4.0F, 0.255F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setPos(2.0F, 12.0F, 0.0F);
		leftLeg.texOffs(0, 60).addBox(-2.0F, 0.0F, -1.625F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		leftLeg.texOffs(13, 47).addBox(-2.0F, 0.0F, -1.625F, 4.0F, 12.0F, 4.0F, 0.255F, false);
	}

	@Override
	public void setupAnim(CyberCavalryEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.head.yRot = pNetHeadYaw * ((float) Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float) Math.PI / 180F);
		this.body.yRot = 0.0F;
		this.rightArm.z = 0.0F;
		this.rightArm.x = -4.5F;
		this.leftArm.z = 0.0F;
		this.leftArm.x = 4.5F;
		float f = 1.0F;
		this.rightArm.xRot = MathHelper.cos(pLimbSwing * 0.6662F + (float) Math.PI) * 2.0F * pLimbSwingAmount * 0.5F / f;
		this.leftArm.xRot = MathHelper.cos(pLimbSwing * 0.6662F) * 2.0F * pLimbSwingAmount * 0.5F / f;
		this.rightArm.zRot = 0.0F;
		this.leftArm.zRot = 0.0F;
		this.rightLeg.xRot = MathHelper.cos(pLimbSwing * 0.6662F) * 1.4F * pLimbSwingAmount / f;
		this.leftLeg.xRot = MathHelper.cos(pLimbSwing * 0.6662F + (float) Math.PI) * 1.4F * pLimbSwingAmount / f;
		this.rightLeg.yRot = 0.0F;
		this.leftLeg.yRot = 0.0F;
		this.rightLeg.zRot = 0.0F;
		this.leftLeg.zRot = 0.0F;
		if (this.riding) {
			this.rightArm.xRot += (-(float) Math.PI / 5F);
			this.leftArm.xRot += (-(float) Math.PI / 5F);
			this.rightLeg.xRot = -1.4137167F;
			this.rightLeg.yRot = ((float) Math.PI / 10F);
			this.rightLeg.zRot = 0.07853982F;
			this.leftLeg.xRot = -1.4137167F;
			this.leftLeg.yRot = (-(float) Math.PI / 10F);
			this.leftLeg.zRot = -0.07853982F;
		}
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
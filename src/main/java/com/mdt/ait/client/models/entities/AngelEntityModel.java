package com.mdt.ait.client.models.entities;// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.entities.AngelEntity;
import com.mdt.ait.common.entities.CyberCavalryEntity;
import com.mdt.ait.core.init.AITItems;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;

public class AngelEntityModel extends BipedModel<AngelEntity> {
	public final ModelRenderer left_base;
	public final ModelRenderer cube_r1;
	public final ModelRenderer left_tip;
	public final ModelRenderer cube_r2;
	public final ModelRenderer right_base;
	public final ModelRenderer right_tip;
	public final ModelRenderer cube_r3;
	public final ModelRenderer head;
	public final ModelRenderer body;
	public final ModelRenderer rightArm;
	public final ModelRenderer leftArm;
	public final ModelRenderer rightLeg;
	public final ModelRenderer leftLeg;

	public AngelEntityModel(float p_i1148_1_) {
		super(RenderType::entityCutoutNoCull, p_i1148_1_, 0.0F, 64, 32);
		texWidth = 256;
		texHeight = 256;

		left_base = new ModelRenderer(this);
		left_base.setPos(1.0F, 21.0F, 2.5F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(-39.0F, 0.0F, 1.5F);
		left_base.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 3.1416F, 0.0F);
		cube_r1.texOffs(0, 33).addBox(-39.0F, -32.0F, 1.0F, 32.0F, 32.0F, 0.0F, 0.001F, false);

		left_tip = new ModelRenderer(this);
		left_tip.setPos(-32.0F, 0.0F, 0.25F);
		left_base.addChild(left_tip);
		

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(24.0F, 0.0F, 0.25F);
		left_tip.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -2.3998F, 0.0F);
		cube_r2.texOffs(0, 0).addBox(17.5F, -32.0F, 16.25F, 32.0F, 32.0F, 0.0F, 0.001F, true);

		right_base = new ModelRenderer(this);
		right_base.setPos(-1.0F, 21.0F, 2.5F);
		right_base.texOffs(0, 33).addBox(0.0F, -32.0F, 0.5F, 32.0F, 32.0F, 0.0F, 0.001F, false);

		right_tip = new ModelRenderer(this);
		right_tip.setPos(32.0F, 0.0F, 0.5F);
		right_base.addChild(right_tip);
		

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, 0.0F, 0.0F);
		right_tip.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -0.6545F, 0.0F);
		cube_r3.texOffs(0, 0).addBox(0.0F, -32.0F, 0.0F, 32.0F, 32.0F, 0.0F, 0.001F, true);

		head = new ModelRenderer(this);
		head.setPos(0.0F, 0.0F, 0.0F);
		head.texOffs(1, 73).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.texOffs(33, 73).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.25F, false);

		body = new ModelRenderer(this);
		body.setPos(0.0F, 24.0F, 0.0F);
		body.texOffs(17, 89).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		body.texOffs(17, 105).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.25F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setPos(4.0F, 2.0F, 0.0F);
		rightArm.texOffs(33, 121).addBox(0.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);
		rightArm.texOffs(49, 121).addBox(0.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.255F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setPos(-4.0F, 2.0F, 0.0F);
		leftArm.texOffs(41, 89).addBox(-3.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);
		leftArm.texOffs(41, 105).addBox(-3.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.255F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setPos(2.0F, 12.0F, 0.0F);
		rightLeg.texOffs(1, 89).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		rightLeg.texOffs(1, 106).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.255F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setPos(-2.0F, 12.0F, 0.0F);
		leftLeg.texOffs(17, 121).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		leftLeg.texOffs(1, 121).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.255F, false);
	}

	@Override
	public void setupAnim(AngelEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.head.yRot = pNetHeadYaw * ((float) Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float) Math.PI / 180F);
		this.body.yRot = 0.0F;
		this.rightArm.z = 0.0F;
		this.rightArm.x = 4F;
		this.leftArm.z = 0.0F;
		this.leftArm.x = -4F;
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
		//if(!pEntity.dropWingsTurnThemOff) {
		//	this.left_base.visible = true;
		//	this.right_base.visible = true;
		//} else {
		//	this.left_base.visible = false;
		//	this.right_base.visible = false;
		//}
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		left_base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		right_base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
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
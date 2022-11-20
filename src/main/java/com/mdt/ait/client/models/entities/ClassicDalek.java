package com.mdt.ait.client.models.entities;// Made with Blockbench 4.4.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.entities.ClassicDalekEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.math.MathHelper;

public class ClassicDalek extends EntityModel<ClassicDalekEntity> {
	private final ModelRenderer base;
	public final ModelRenderer neck;
	public final ModelRenderer cube_r1;
	public final ModelRenderer cube_r2;
	public final ModelRenderer cube_r3;
	public final ModelRenderer spheres;
	public final ModelRenderer gun_torso;
	public final ModelRenderer gun;
	public final ModelRenderer iignore;
	public final ModelRenderer suction;
	public final ModelRenderer head;
	public final ModelRenderer cube_r4;
	public final ModelRenderer cube_r5;
	public final ModelRenderer cube_r6;
	public final ModelRenderer eyestalk;

	public ClassicDalek() {
		texWidth = 128;
		texHeight = 128;

		base = new ModelRenderer(this);
		base.setPos(0.0F, 24.0F, 0.0F);
		base.texOffs(0, 68).addBox(-6.5F, -15.0F, -9.5F, 13.0F, 12.0F, 2.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(-7.0F, -17.0F, -7.5F, 14.0F, 14.0F, 15.0F, 0.0F, false);
		base.texOffs(0, 30).addBox(-8.0F, -3.0F, -9.0F, 16.0F, 3.0F, 17.0F, 0.0F, false);
		base.texOffs(81, 67).addBox(-7.0F, -3.0F, -11.0F, 14.0F, 3.0F, 2.0F, 0.0F, false);

		neck = new ModelRenderer(this);
		neck.setPos(0.0F, 3.7906F, -5.7815F);
		base.addChild(neck);
		neck.texOffs(59, 0).addBox(-5.5F, -29.7906F, 0.2815F, 11.0F, 3.0F, 12.0F, 0.001F, false);
		neck.texOffs(39, 67).addBox(-4.5F, -32.7906F, 1.2815F, 9.0F, 3.0F, 10.0F, 0.0F, false);
		neck.texOffs(49, 51).addBox(-5.5F, -32.7906F, 0.2815F, 11.0F, 3.0F, 12.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		neck.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.2182F, 0.0F, 0.0F);
		cube_r1.texOffs(81, 73).addBox(-5.5F, -29.0F, -6.5F, 11.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(6.7566F, -0.2172F, 5.7805F);
		neck.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -0.2182F);
		cube_r2.texOffs(19, 71).addBox(4.5F, -29.0F, -5.5F, 1.0F, 3.0F, 12.0F, 0.001F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(-6.7566F, -0.2172F, 5.7805F);
		neck.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, 0.2182F);
		cube_r3.texOffs(34, 81).addBox(-5.5F, -29.0F, -5.5F, 1.0F, 3.0F, 12.0F, 0.001F, false);

		spheres = new ModelRenderer(this);
		spheres.setPos(0.0F, 0.0F, 0.0F);
		base.addChild(spheres);
		spheres.texOffs(7, 11).addBox(-7.5F, -15.5F, 4.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(-7.5F, -15.5F, 1.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(-7.5F, -15.5F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(-7.5F, -15.5F, -6.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(-7.5F, -10.75F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(-7.5F, -10.75F, -6.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(-7.5F, -10.75F, 1.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(-7.5F, -10.75F, 4.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(-7.5F, -6.0F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(-7.5F, -6.0F, -6.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(-7.5F, -6.0F, 1.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(-7.5F, -6.0F, 4.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(5.5F, -15.5F, 4.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(5.5F, -15.5F, 1.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(5.5F, -15.5F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(5.5F, -15.5F, -6.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(5.5F, -10.75F, -6.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(5.5F, -10.75F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(5.5F, -10.75F, 1.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(5.5F, -10.75F, 4.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(5.5F, -6.0F, 4.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(5.5F, -6.0F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(5.5F, -6.0F, -6.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		spheres.texOffs(7, 11).addBox(-5.0F, -14.0F, -10.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		spheres.texOffs(7, 11).addBox(-1.0F, -14.0F, -10.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		spheres.texOffs(7, 11).addBox(3.0F, -14.0F, -10.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		spheres.texOffs(7, 11).addBox(3.0F, -10.0F, -10.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		spheres.texOffs(7, 11).addBox(-1.0F, -10.0F, -10.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		spheres.texOffs(7, 11).addBox(-5.0F, -10.0F, -10.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		spheres.texOffs(7, 11).addBox(-5.0F, -6.0F, -10.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		spheres.texOffs(7, 11).addBox(-1.0F, -6.0F, -10.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		spheres.texOffs(7, 11).addBox(3.0F, -6.0F, -10.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		spheres.texOffs(7, 11).addBox(5.5F, -6.0F, 1.1F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		spheres.texOffs(7, 11).addBox(3.0F, -15.5F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		spheres.texOffs(7, 11).addBox(-1.0F, -15.5F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		spheres.texOffs(7, 11).addBox(-5.0F, -15.5F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		spheres.texOffs(7, 11).addBox(-5.0F, -11.0F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		spheres.texOffs(7, 11).addBox(-1.0F, -11.0F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		spheres.texOffs(7, 11).addBox(-5.0F, -6.0F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		spheres.texOffs(7, 11).addBox(-1.0F, -6.0F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		spheres.texOffs(7, 11).addBox(3.0F, -6.0F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		spheres.texOffs(7, 11).addBox(3.0F, -11.0F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		gun_torso = new ModelRenderer(this);
		gun_torso.setPos(0.0F, 4.0F, 0.0F);
		gun_torso.texOffs(50, 17).addBox(-6.5F, -3.0F, -6.5F, 13.0F, 6.0F, 13.0F, 0.001F, false);
		gun_torso.texOffs(0, 6).addBox(-5.0F, -1.5F, -7.5F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		gun_torso.texOffs(0, 30).addBox(1.0F, -1.5F, -7.5F, 4.0F, 4.0F, 1.0F, 0.0F, false);

		gun = new ModelRenderer(this);
		gun.setPos(3.0F, -2.5F, -7.25F);
		gun_torso.addChild(gun);
		gun.texOffs(0, 83).addBox(-2.0F, 3.0F, -8.5F, 4.0F, 0.0F, 8.0F, 0.001F, false);
		gun.texOffs(80, 85).addBox(0.0F, 1.0F, -8.75F, 0.0F, 4.0F, 9.0F, 0.001F, false);
		gun.texOffs(37, 51).addBox(-0.5F, 2.5F, -9.25F, 1.0F, 1.0F, 9.0F, 0.001F, false);

		iignore = new ModelRenderer(this);
		iignore.setPos(0.0F, 0.0F, 0.0F);
		gun.addChild(iignore);
		setRotationAngle(iignore, 0.0F, 0.0F, 0.7854F);
		iignore.texOffs(50, 37).addBox(0.1213F, 2.1213F, -8.5F, 4.0F, 0.0F, 8.0F, 0.001F, false);
		iignore.texOffs(61, 85).addBox(2.1213F, 0.1213F, -8.75F, 0.0F, 4.0F, 9.0F, 0.001F, false);

		suction = new ModelRenderer(this);
		suction.setPos(-3.0F, 0.5F, -7.5F);
		gun_torso.addChild(suction);
		suction.texOffs(62, 67).addBox(-0.5F, -0.5F, -12.0F, 1.0F, 1.0F, 16.0F, 0.0F, false);
		suction.texOffs(7, 36).addBox(-1.5F, -1.5F, -13.0F, 3.0F, 0.0F, 1.0F, 0.001F, false);
		suction.texOffs(11, 30).addBox(1.5F, -1.5F, -13.0F, 0.0F, 3.0F, 1.0F, 0.001F, false);
		suction.texOffs(11, 6).addBox(-1.5F, -1.5F, -13.0F, 0.0F, 3.0F, 1.0F, 0.001F, false);
		suction.texOffs(0, 12).addBox(-1.5F, 1.5F, -13.0F, 3.0F, 0.0F, 1.0F, 0.001F, false);
		suction.texOffs(49, 55).addBox(-1.5F, -1.5F, -12.0F, 3.0F, 3.0F, 0.0F, 0.001F, false);

		head = new ModelRenderer(this);
		head.setPos(0.0F, -8.0F, 0.0F);
		head.texOffs(0, 51).addBox(-6.0F, -1.0F, -5.5F, 12.0F, 4.0F, 12.0F, 0.0F, false);
		head.texOffs(67, 37).addBox(-5.0F, -3.0F, -4.5F, 10.0F, 2.0F, 10.0F, 0.0F, false);
		head.texOffs(0, 0).addBox(-2.0F, -1.0F, -6.5F, 4.0F, 3.0F, 2.0F, 0.0F, false);
		head.texOffs(44, 0).addBox(-5.75F, -3.5F, -0.5F, 2.0F, 2.0F, 2.0F, 0.001F, false);
		head.texOffs(0, 42).addBox(3.75F, -3.5F, -0.5F, 2.0F, 2.0F, 2.0F, 0.001F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(-2.4408F, 36.7234F, -0.5F);
		head.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.6109F);
		cube_r4.texOffs(0, 36).addBox(-17.5F, -38.5F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(2.4408F, 36.7234F, -0.5F);
		head.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, -0.6109F);
		cube_r5.texOffs(7, 39).addBox(15.5F, -38.5F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.0F, 34.7471F, -14.2714F);
		head.addChild(cube_r6);
		setRotationAngle(cube_r6, -0.3927F, 0.0F, 0.0F);
		cube_r6.texOffs(50, 37).addBox(1.0F, -39.0F, -6.5F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r6.texOffs(0, 51).addBox(-2.0F, -39.0F, -6.5F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		eyestalk = new ModelRenderer(this);
		eyestalk.setPos(0.0F, -1.5F, -4.0F);
		head.addChild(eyestalk);
		eyestalk.texOffs(44, 0).addBox(-0.5F, -0.5F, -10.5F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		eyestalk.texOffs(37, 51).addBox(-1.5F, -1.5F, -7.5F, 3.0F, 3.0F, 0.0F, 0.0F, false);
		eyestalk.texOffs(49, 51).addBox(-1.5F, -1.5F, -8.5F, 3.0F, 3.0F, 0.0F, 0.0F, false);
		eyestalk.texOffs(37, 55).addBox(-1.5F, -1.5F, -9.5F, 3.0F, 3.0F, 0.0F, 0.0F, false);
		eyestalk.texOffs(44, 5).addBox(-1.5F, -1.5F, -11.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(ClassicDalekEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.eyestalk.xRot = pHeadPitch * ((float)Math.PI / 300f);
		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 300f);
		if(pEntity.isAggressive()) {
			this.gun.yRot = pNetHeadYaw * ((float)Math.PI / 300f);
			this.gun.xRot = pHeadPitch * ((float)Math.PI / 300f);
		} else {
			this.gun.yRot = 0f;
			this.gun.xRot = 0f;
		}
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		matrixStack.pushPose();
		matrixStack.scale(0.85f, 0.85f, 0.85f);
		matrixStack.translate(0, 0.25, 0);
		base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		gun_torso.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		matrixStack.popPose();
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
package com.mdt.ait.client.models.phonebooths;// Made with Blockbench 4.6.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.PhoneBoothTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PhoneBooth extends EntityModel<Entity> {
	public final ModelRenderer box;
	public final ModelRenderer base;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	public final ModelRenderer staticPhone;
	private final ModelRenderer cube_r3;
	public final ModelRenderer heldPhone;
	private final ModelRenderer cube_r4;
	public final ModelRenderer doors;
	public final ModelRenderer secondary;
	public final ModelRenderer umbrella;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;

	public PhoneBooth() {
		texWidth = 128;
		texHeight = 128;

		box = new ModelRenderer(this);
		box.setPos(0.0F, 24.0F, 0.0F);
		

		base = new ModelRenderer(this);
		base.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(base);
		base.texOffs(49, 43).addBox(-8.0F, -32.25F, -8.0F, 0.0F, 30.0F, 16.0F, 0.01F, false);
		base.texOffs(66, 24).addBox(-8.0F, -32.25F, 8.0F, 16.0F, 30.0F, 0.0F, 0.01F, false);
		base.texOffs(0, 0).addBox(-8.0F, -36.25F, -8.0F, 16.0F, 4.0F, 16.0F, 0.0F, false);
		base.texOffs(0, 40).addBox(-8.0F, -36.25F, -8.0F, 16.0F, 2.0F, 16.0F, 0.25F, false);
		base.texOffs(49, 5).addBox(-8.0F, -2.25F, -8.0F, 16.0F, 2.0F, 16.0F, 0.0F, false);
		base.texOffs(0, 21).addBox(-8.0F, -2.25F, -8.0F, 16.0F, 2.0F, 16.0F, 0.25F, false);
		base.texOffs(38, 59).addBox(-8.0F, -32.25F, -8.0F, 1.0F, 30.0F, 1.0F, 0.0F, false);
		base.texOffs(33, 59).addBox(7.0F, -32.25F, -8.0F, 1.0F, 30.0F, 1.0F, 0.0F, false);
		base.texOffs(98, 5).addBox(3.0F, -20.225F, 3.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		base.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.7854F, 0.0F);
		cube_r1.texOffs(49, 8).addBox(-2.0F, -27.25F, 7.05F, 4.0F, 6.0F, 0.0F, 0.001F, false);
		cube_r1.texOffs(3, 6).addBox(-2.0F, -27.25F, 7.25F, 4.0F, 7.0F, 2.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, -0.25F, 0.0F);
		base.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 3.1416F, 0.0F);
		cube_r2.texOffs(49, 43).addBox(-8.0F, -32.0F, -8.0F, 0.0F, 30.0F, 16.0F, 0.01F, false);

		staticPhone = new ModelRenderer(this);
		staticPhone.setPos(4.0F, -24.0F, 5.0F);
		base.addChild(staticPhone);
		

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, 0.0F, 0.0F);
		staticPhone.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.7854F, 0.0F);
		cube_r3.texOffs(49, 1).addBox(-0.2929F, -2.75F, -0.364F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		heldPhone = new ModelRenderer(this);
		heldPhone.setPos(4.0F, -24.0F, 5.0F);
		base.addChild(heldPhone);
		

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(0.0F, 0.0F, 0.0F);
		heldPhone.addChild(cube_r4);
		setRotationAngle(cube_r4, -2.9671F, -0.2182F, 3.1416F);
		cube_r4.texOffs(49, 1).addBox(0.7071F, -1.25F, -0.364F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		doors = new ModelRenderer(this);
		doors.setPos(6.5F, 0.0F, -7.5F);
		box.addChild(doors);
		doors.texOffs(0, 7).addBox(-6.5F, -21.75F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		doors.texOffs(82, 87).addBox(-6.5F, -32.25F, -0.5F, 7.0F, 30.0F, 1.0F, 0.0F, false);

		secondary = new ModelRenderer(this);
		secondary.setPos(-6.5F, 0.0F, 0.5F);
		doors.addChild(secondary);
		secondary.texOffs(82, 55).addBox(-7.0F, -32.25F, -1.0F, 7.0F, 30.0F, 1.0F, 0.0F, false);

		umbrella = new ModelRenderer(this);
		umbrella.setPos(0.0F, -42.25F, 0.0F);
		box.addChild(umbrella);
		umbrella.texOffs(0, 0).addBox(-0.5F, 0.25F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(0.0F, 0.25F, 0.0F);
		umbrella.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.6117F, -0.6002F, 0.8929F);
		cube_r5.texOffs(49, 44).addBox(0.5F, -3.25F, 0.0F, 8.0F, 6.0F, 0.0F, 0.01F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.0F, 0.25F, 0.0F);
		umbrella.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.6981F, -0.829F, 0.0F);
		cube_r6.texOffs(49, 36).addBox(0.0F, -3.25F, -8.5F, 0.0F, 6.0F, 8.0F, 0.01F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(0.0F, 0.25F, 0.0F);
		umbrella.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.6117F, -0.6002F, -0.8929F);
		cube_r7.texOffs(49, 44).addBox(-8.5F, -3.25F, 0.0F, 8.0F, 6.0F, 0.0F, 0.01F, true);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(0.0F, 0.25F, 0.0F);
		umbrella.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.6981F, -0.829F, 0.0F);
		cube_r8.texOffs(49, 42).addBox(0.0F, -3.25F, 0.5F, 0.0F, 6.0F, 8.0F, 0.01F, true);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setPos(0.0F, 0.25F, 0.0F);
		umbrella.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.6981F, 0.0F, 0.0F);
		cube_r9.texOffs(49, 42).addBox(0.0F, -3.25F, 0.5F, 0.0F, 6.0F, 8.0F, 0.01F, true);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setPos(0.0F, 0.25F, 0.0F);
		umbrella.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, 0.6981F);
		cube_r10.texOffs(49, 44).addBox(0.5F, -3.25F, 0.0F, 8.0F, 6.0F, 0.0F, 0.01F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setPos(0.0F, 0.25F, 0.0F);
		umbrella.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, -0.6981F);
		cube_r11.texOffs(49, 44).addBox(-8.5F, -3.25F, 0.0F, 8.0F, 6.0F, 0.0F, 0.01F, true);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setPos(0.0F, 0.25F, 0.0F);
		umbrella.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.6981F, 0.0F, 0.0F);
		cube_r12.texOffs(49, 36).addBox(0.0F, -3.25F, -8.5F, 0.0F, 6.0F, 8.0F, 0.01F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		box.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(PhoneBoothTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
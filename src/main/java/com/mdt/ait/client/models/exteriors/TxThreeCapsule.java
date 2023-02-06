package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.mdt.ait.common.tiles.TARDISTileEntity;
import io.mdt.ait.tardis.exterior.model.BasicBoxModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TxThreeCapsule extends BasicBoxModel {
	public final ModelRenderer door;
	public final ModelRenderer cube_r1;
	public final ModelRenderer cube_r2;
	public final ModelRenderer universe;
	public final ModelRenderer base;
	public final ModelRenderer bone;
	public final ModelRenderer cube_r3;
	public final ModelRenderer cube_r4;
	public final ModelRenderer bone2;
	public final ModelRenderer cube_r5;
	public final ModelRenderer cube_r6;
	public final ModelRenderer bone3;
	public final ModelRenderer cube_r7;
	public final ModelRenderer cube_r8;

	public TxThreeCapsule() {
		texWidth = 128;
		texHeight = 128;

		door = new ModelRenderer(this);
		door.setPos(6.0F, 7.0F, -6.0F);
		door.texOffs(0, 63).addBox(-12.0F, -13.0F, -0.25F, 12.0F, 28.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(-6.0F, 34.0F, 6.0F);
		door.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.7854F);
		cube_r1.texOffs(70, 64).addBox(-18.25F, -26.0F, -6.5F, 2.0F, 18.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(-6.0F, 17.0F, 6.0F);
		door.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 0.7854F);
		cube_r2.texOffs(77, 0).addBox(-18.25F, -26.0F, -6.5F, 2.0F, 18.0F, 1.0F, 0.0F, false);

		universe = new ModelRenderer(this);
		universe.setPos(0.0F, 24.0F, 0.0F);
		universe.texOffs(0, 0).addBox(-6.0F, -30.0F, -6.0F, 12.0F, 28.0F, 12.0F, 0.0F, false);

		base = new ModelRenderer(this);
		base.setPos(0.0F, 24.0F, 0.0F);
		base.texOffs(36, 63).addBox(5.5F, -30.0F, 5.5F, 2.0F, 28.0F, 2.0F, 0.0F, false);
		base.texOffs(0, 44).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 16.0F, 0.0F, false);
		base.texOffs(33, 25).addBox(-8.0F, -32.0F, -8.0F, 16.0F, 2.0F, 16.0F, 0.0F, false);
		base.texOffs(54, 63).addBox(5.5F, -30.0F, -7.5F, 2.0F, 28.0F, 2.0F, 0.0F, false);
		base.texOffs(45, 63).addBox(-7.5F, -30.0F, -7.5F, 2.0F, 28.0F, 2.0F, 0.0F, false);
		base.texOffs(27, 63).addBox(-7.5F, -30.0F, 5.5F, 2.0F, 28.0F, 2.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setPos(0.0F, 17.0F, 0.0F);
		base.addChild(bone);
		

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, 0.0F, 0.0F);
		bone.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.7854F, 0.0F, 0.0F);
		cube_r3.texOffs(63, 61).addBox(-6.5F, -26.0F, 16.25F, 1.0F, 18.0F, 2.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(0.0F, -17.0F, 0.0F);
		bone.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.7854F, 0.0F, 0.0F);
		cube_r4.texOffs(63, 0).addBox(-6.5F, -26.0F, 16.25F, 1.0F, 18.0F, 2.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setPos(0.0F, 17.0F, 0.0F);
		base.addChild(bone2);
		

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(0.0F, 0.0F, 0.0F);
		bone2.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, -0.7854F);
		cube_r5.texOffs(70, 0).addBox(16.25F, -26.0F, 5.5F, 2.0F, 18.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.0F, -17.0F, 0.0F);
		bone2.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, -0.7854F);
		cube_r6.texOffs(70, 44).addBox(16.25F, -26.0F, 5.5F, 2.0F, 18.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setPos(0.0F, 17.0F, 0.0F);
		base.addChild(bone3);
		

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(0.0F, 0.0F, 0.0F);
		bone3.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.7854F, 0.0F, 0.0F);
		cube_r7.texOffs(49, 0).addBox(5.5F, -26.0F, -18.25F, 1.0F, 18.0F, 2.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(0.0F, -17.0F, 0.0F);
		bone3.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.7854F, 0.0F, 0.0F);
		cube_r8.texOffs(56, 0).addBox(5.5F, -26.0F, -18.25F, 1.0F, 18.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		door.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		//universe.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(TARDISTileEntity tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1); //fixme
	}
}
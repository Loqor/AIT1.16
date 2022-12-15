package com.mdt.ait.client.models.tileentities;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.VortexTileTemp;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class VortexModelTemp extends EntityModel<Entity> {
	public final ModelRenderer vortex;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer bone;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer cube_r32;
	private final ModelRenderer cube_r33;
	private final ModelRenderer cube_r34;
	private final ModelRenderer cube_r35;
	private final ModelRenderer cube_r36;

	public VortexModelTemp() {
		texWidth = 512;
		texHeight = 512;

		vortex = new ModelRenderer(this);
		vortex.setPos(0.0F, 24.0F, 0.0F);
		setRotationAngle(vortex, 0.0F, 0.0F, 3.0107F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0014F, -35.4385F, -18.8368F);
		vortex.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.0F);
		cube_r1.texOffs(-236, 151).addBox(-9.4468F, -0.0068F, -99.1268F, 19.0F, 0.0F, 236.0F, 0.005F, true);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(-9.4486F, -35.4385F, -18.8368F);
		vortex.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -0.5236F);
		cube_r2.texOffs(-236, 151).addBox(-18.9968F, -0.0068F, -99.1268F, 19.0F, 0.0F, 236.0F, 0.005F, true);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(-25.931F, -25.996F, 0.0364F);
		vortex.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -1.0472F);
		cube_r3.texOffs(-236, 151).addBox(-19.0014F, 0.0569F, -118.0F, 19.0F, 0.0F, 236.0F, 0.005F, true);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(25.931F, -25.996F, 0.0364F);
		vortex.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 1.0472F);
		cube_r4.texOffs(-236, 151).addBox(0.0014F, 0.0569F, -118.0F, 19.0F, 0.0F, 236.0F, 0.005F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(9.4486F, -35.4385F, -18.8368F);
		vortex.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, 0.5236F);
		cube_r5.texOffs(-236, 151).addBox(-0.0032F, -0.0068F, -99.1268F, 19.0F, 0.0F, 236.0F, 0.005F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(-25.931F, 25.996F, 0.0364F);
		vortex.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, 1.0472F);
		cube_r6.texOffs(-236, 151).addBox(-19.0014F, -0.0569F, -118.0F, 19.0F, 0.0F, 236.0F, 0.005F, true);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(-35.2786F, 9.4148F, 0.0364F);
		vortex.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, 1.5708F);
		cube_r7.texOffs(-236, 151).addBox(-18.9148F, 0.1069F, -118.0F, 19.0F, 0.0F, 236.0F, 0.005F, true);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(-9.4486F, 35.4385F, -18.8368F);
		vortex.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, 0.5236F);
		cube_r8.texOffs(-236, 151).addBox(-18.9968F, 0.0068F, -99.1268F, 19.0F, 0.0F, 236.0F, 0.005F, true);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setPos(0.0014F, 35.4385F, -18.8368F);
		vortex.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, 0.0F);
		cube_r9.texOffs(-236, 151).addBox(-9.4468F, 0.0068F, -99.1268F, 19.0F, 0.0F, 236.0F, 0.005F, true);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setPos(25.931F, 25.996F, 0.0364F);
		vortex.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, -1.0472F);
		cube_r10.texOffs(-236, 151).addBox(0.0014F, -0.0569F, -118.0F, 19.0F, 0.0F, 236.0F, 0.005F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setPos(35.2786F, 9.4148F, 0.0364F);
		vortex.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, -1.5708F);
		cube_r11.texOffs(-236, 151).addBox(-0.0852F, 0.1069F, -118.0F, 19.0F, 0.0F, 236.0F, 0.005F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setPos(9.4486F, 35.4385F, -18.8368F);
		vortex.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, -0.5236F);
		cube_r12.texOffs(-236, 151).addBox(-0.0032F, 0.0068F, -99.1268F, 19.0F, 0.0F, 236.0F, 0.005F, false);

		bone = new ModelRenderer(this);
		bone.setPos(17.6772F, 30.6956F, 117.9726F);
		vortex.addChild(bone);
		

		cube_r13 = new ModelRenderer(this);
		cube_r13.setPos(0.0F, 0.0F, 0.0F);
		bone.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.1745F, 0.0F, -0.5236F);
		cube_r13.texOffs(-204, 308).addBox(-9.5F, 0.0F, 0.0F, 19.0F, 0.0F, 204.0F, 0.005F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setPos(12.9559F, -12.9569F, 0.0F);
		bone.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.1745F, 0.0F, -1.0472F);
		cube_r14.texOffs(-204, 308).addBox(-9.5F, 0.0F, 0.0F, 19.0F, 0.0F, 204.0F, 0.005F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setPos(-48.3089F, -12.9569F, 0.0F);
		bone.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.1745F, 0.0F, 1.0472F);
		cube_r15.texOffs(-204, 308).addBox(-9.5F, 0.0F, 0.0F, 19.0F, 0.0F, 204.0F, 0.005F, true);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setPos(-35.353F, 0.0F, 0.0F);
		bone.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.1745F, 0.0F, 0.5236F);
		cube_r16.texOffs(-204, 308).addBox(-9.5F, 0.0F, 0.0F, 19.0F, 0.0F, 204.0F, 0.005F, true);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setPos(-17.6219F, 4.7493F, 0.0F);
		bone.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.1745F, 0.0F, 0.0F);
		cube_r17.texOffs(-204, 308).addBox(-9.5F, 0.0F, 0.0F, 19.0F, 0.0F, 204.0F, 0.005F, true);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setPos(17.7084F, -30.6956F, -0.0091F);
		bone.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.1745F, 0.0F, -1.5708F);
		cube_r18.texOffs(-204, 308).addBox(-9.5F, 0.0F, 0.0F, 19.0F, 0.0F, 204.0F, 0.005F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setPos(-53.0627F, -30.6956F, -0.0091F);
		bone.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.1745F, 0.0F, 1.5708F);
		cube_r19.texOffs(-204, 308).addBox(-9.5F, 0.0F, 0.0F, 19.0F, 0.0F, 204.0F, 0.005F, true);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setPos(-17.6226F, -66.1409F, -0.0091F);
		bone.addChild(cube_r20);
		setRotationAngle(cube_r20, -0.1745F, 0.0F, 0.0F);
		cube_r20.texOffs(-204, 308).addBox(-9.5F, 0.0F, 0.0F, 19.0F, 0.0F, 204.0F, 0.005F, true);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setPos(-35.3537F, -61.3916F, -0.0091F);
		bone.addChild(cube_r21);
		setRotationAngle(cube_r21, -0.1745F, 0.0F, -0.5236F);
		cube_r21.texOffs(-204, 308).addBox(-9.5F, 0.0F, 0.0F, 19.0F, 0.0F, 204.0F, 0.005F, true);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setPos(-48.3096F, -48.4347F, -0.0091F);
		bone.addChild(cube_r22);
		setRotationAngle(cube_r22, -0.1745F, 0.0F, -1.0472F);
		cube_r22.texOffs(-204, 308).addBox(-9.5F, 0.0F, 0.0F, 19.0F, 0.0F, 204.0F, 0.005F, true);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setPos(12.9552F, -48.4347F, -0.0091F);
		bone.addChild(cube_r23);
		setRotationAngle(cube_r23, -0.1745F, 0.0F, 1.0472F);
		cube_r23.texOffs(-204, 308).addBox(-9.5F, 0.0F, 0.0F, 19.0F, 0.0F, 204.0F, 0.005F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setPos(-0.0007F, -61.3916F, -0.0091F);
		bone.addChild(cube_r24);
		setRotationAngle(cube_r24, -0.1745F, 0.0F, 0.5236F);
		cube_r24.texOffs(-204, 308).addBox(-9.5F, 0.0F, 0.0F, 19.0F, 0.0F, 204.0F, 0.005F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setPos(17.7084F, -30.6956F, -235.9362F);
		bone.addChild(cube_r25);
		setRotationAngle(cube_r25, -0.1745F, 0.0F, -1.5708F);
		cube_r25.texOffs(-204, 308).addBox(-9.5F, 0.0F, -204.0F, 19.0F, 0.0F, 204.0F, 0.005F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setPos(-53.0627F, -30.6956F, -235.9362F);
		bone.addChild(cube_r26);
		setRotationAngle(cube_r26, -0.1745F, 0.0F, 1.5708F);
		cube_r26.texOffs(-204, 308).addBox(-9.5F, 0.0F, -204.0F, 19.0F, 0.0F, 204.0F, 0.005F, true);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setPos(-17.6219F, 4.7493F, -235.9452F);
		bone.addChild(cube_r27);
		setRotationAngle(cube_r27, -0.1745F, 0.0F, 0.0F);
		cube_r27.texOffs(-204, 308).addBox(-9.5F, 0.0F, -204.0F, 19.0F, 0.0F, 204.0F, 0.005F, true);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setPos(-35.353F, 0.0F, -235.9452F);
		bone.addChild(cube_r28);
		setRotationAngle(cube_r28, -0.1745F, 0.0F, 0.5236F);
		cube_r28.texOffs(-204, 308).addBox(-9.5F, 0.0F, -204.0F, 19.0F, 0.0F, 204.0F, 0.005F, true);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setPos(-48.3089F, -12.9569F, -235.9452F);
		bone.addChild(cube_r29);
		setRotationAngle(cube_r29, -0.1745F, 0.0F, 1.0472F);
		cube_r29.texOffs(-204, 308).addBox(-9.5F, 0.0F, -204.0F, 19.0F, 0.0F, 204.0F, 0.005F, true);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setPos(12.9559F, -12.9569F, -235.9452F);
		bone.addChild(cube_r30);
		setRotationAngle(cube_r30, -0.1745F, 0.0F, -1.0472F);
		cube_r30.texOffs(-204, 308).addBox(-9.5F, 0.0F, -204.0F, 19.0F, 0.0F, 204.0F, 0.005F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setPos(0.0F, 0.0F, -235.9452F);
		bone.addChild(cube_r31);
		setRotationAngle(cube_r31, -0.1745F, 0.0F, -0.5236F);
		cube_r31.texOffs(-204, 308).addBox(-9.5F, 0.0F, -204.0F, 19.0F, 0.0F, 204.0F, 0.005F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setPos(-17.6226F, -66.1409F, -235.9362F);
		bone.addChild(cube_r32);
		setRotationAngle(cube_r32, 0.1745F, 0.0F, 0.0F);
		cube_r32.texOffs(-204, 308).addBox(-9.5F, 0.0F, -204.0F, 19.0F, 0.0F, 204.0F, 0.005F, true);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setPos(-35.3537F, -61.3916F, -235.9362F);
		bone.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.1745F, 0.0F, -0.5236F);
		cube_r33.texOffs(-204, 308).addBox(-9.5F, 0.0F, -204.0F, 19.0F, 0.0F, 204.0F, 0.005F, true);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setPos(-48.3096F, -48.4347F, -235.9362F);
		bone.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.1745F, 0.0F, -1.0472F);
		cube_r34.texOffs(-204, 308).addBox(-9.5F, 0.0F, -204.0F, 19.0F, 0.0F, 204.0F, 0.005F, true);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setPos(12.9552F, -48.4347F, -235.9362F);
		bone.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.1745F, 0.0F, 1.0472F);
		cube_r35.texOffs(-204, 308).addBox(-9.5F, 0.0F, -204.0F, 19.0F, 0.0F, 204.0F, 0.005F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setPos(-0.0007F, -61.3916F, -235.9362F);
		bone.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.1745F, 0.0F, 0.5236F);
		cube_r36.texOffs(-204, 308).addBox(-9.5F, 0.0F, -204.0F, 19.0F, 0.0F, 204.0F, 0.005F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		vortex.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(VortexTileTemp tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
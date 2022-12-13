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

	public VortexModelTemp() {
		texWidth = 512;
		texHeight = 512;

		vortex = new ModelRenderer(this);
		vortex.setPos(0.0F, 24.0F, 0.0F);
		vortex.texOffs(213, 93).addBox(-9.5532F, 22.7932F, -117.9636F, 19.0F, 0.0F, 236.0F, 0.005F, false);
		vortex.texOffs(213, 93).addBox(-9.5546F, -22.7932F, -117.9636F, 19.0F, 0.0F, 236.0F, 0.005F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, -17.7748F, -6.0445F);
		vortex.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.3927F, 0.0F, 0.0F);
		cube_r1.texOffs(354, 132).addBox(-9.5532F, 84.9668F, 99.1132F, 19.0F, 0.0F, 66.0F, 0.005F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(-0.0014F, 17.7608F, -6.0463F);
		vortex.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.3927F, 0.0F, 0.0F);
		cube_r2.texOffs(354, 132).addBox(-9.5532F, -84.9532F, 99.1132F, 19.0F, 0.0F, 66.0F, 0.005F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(58.9202F, -0.0085F, 30.829F);
		vortex.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.3927F, 0.0F, -1.5708F);
		cube_r3.texOffs(354, 132).addBox(-9.5532F, 0.0068F, 94.3932F, 19.0F, 0.0F, 66.0F, 0.005F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(-58.9202F, -0.0085F, 30.829F);
		vortex.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.3927F, 0.0F, 1.5708F);
		cube_r4.texOffs(354, 132).addBox(-9.5532F, 0.0068F, 94.3932F, 19.0F, 0.0F, 66.0F, 0.005F, true);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(-29.5899F, 56.2818F, 26.4683F);
		vortex.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.3927F, 0.0F, 0.7854F);
		cube_r5.texOffs(354, 132).addBox(-28.4332F, 0.0068F, 99.1132F, 19.0F, 0.0F, 66.0F, 0.005F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(29.5865F, 56.2818F, 26.4683F);
		vortex.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.3927F, 0.0F, -0.7854F);
		cube_r6.texOffs(354, 132).addBox(9.3268F, 0.0068F, 99.1132F, 19.0F, 0.0F, 66.0F, 0.005F, true);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(29.5882F, -56.2923F, 26.4665F);
		vortex.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.3927F, 0.0F, 0.7854F);
		cube_r7.texOffs(354, 132).addBox(9.3268F, 0.0068F, 99.1132F, 19.0F, 0.0F, 66.0F, 0.005F, true);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(-29.5882F, -56.2923F, 26.4665F);
		vortex.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.3927F, 0.0F, -0.7854F);
		cube_r8.texOffs(354, 132).addBox(-28.4332F, 0.0068F, 99.1132F, 19.0F, 0.0F, 66.0F, 0.005F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setPos(0.0F, -17.7748F, 6.131F);
		vortex.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.3927F, 0.0F, 0.0F);
		cube_r9.texOffs(24, 194).addBox(-9.5532F, 84.9668F, -165.2068F, 19.0F, 0.0F, 66.0F, 0.005F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setPos(-0.0014F, 17.7608F, 6.1328F);
		vortex.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.3927F, 0.0F, 0.0F);
		cube_r10.texOffs(24, 194).addBox(-9.5532F, -84.9532F, -165.2068F, 19.0F, 0.0F, 66.0F, 0.005F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setPos(2.7669F, -29.4737F, -18.8368F);
		vortex.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, 0.7854F);
		cube_r11.texOffs(213, 93).addBox(9.3268F, 0.0068F, -99.1268F, 19.0F, 0.0F, 236.0F, 0.005F, true);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setPos(29.5865F, 56.2818F, -26.3818F);
		vortex.addChild(cube_r12);
		setRotationAngle(cube_r12, -0.3927F, 0.0F, -0.7854F);
		cube_r12.texOffs(24, 194).addBox(9.3268F, 0.0068F, -165.2068F, 19.0F, 0.0F, 66.0F, 0.005F, true);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setPos(-29.5899F, 56.2818F, -26.3818F);
		vortex.addChild(cube_r13);
		setRotationAngle(cube_r13, -0.3927F, 0.0F, 0.7854F);
		cube_r13.texOffs(24, 194).addBox(-28.4332F, 0.0068F, -165.2068F, 19.0F, 0.0F, 66.0F, 0.005F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setPos(29.5882F, -56.2923F, -26.38F);
		vortex.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.3927F, 0.0F, 0.7854F);
		cube_r14.texOffs(24, 194).addBox(9.3268F, 0.0068F, -165.2068F, 19.0F, 0.0F, 66.0F, 0.005F, true);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setPos(-29.5882F, -56.2923F, -26.38F);
		vortex.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.3927F, 0.0F, -0.7854F);
		cube_r15.texOffs(24, 194).addBox(-28.4332F, 0.0068F, -165.2068F, 19.0F, 0.0F, 66.0F, 0.005F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setPos(-2.7696F, -29.4737F, -18.8368F);
		vortex.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 0.0F, -0.7854F);
		cube_r16.texOffs(213, 93).addBox(-28.4332F, 0.0068F, -99.1268F, 19.0F, 0.0F, 236.0F, 0.005F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setPos(2.7682F, 29.4601F, -18.8368F);
		vortex.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 0.0F, -0.7854F);
		cube_r17.texOffs(213, 93).addBox(9.3268F, 0.0068F, -99.1268F, 19.0F, 0.0F, 236.0F, 0.005F, true);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setPos(-2.7682F, 29.4601F, -18.8368F);
		vortex.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 0.0F, 0.7854F);
		cube_r18.texOffs(213, 93).addBox(-28.4332F, 0.0068F, -99.1268F, 19.0F, 0.0F, 236.0F, 0.005F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setPos(58.9202F, -0.0085F, -30.7425F);
		vortex.addChild(cube_r19);
		setRotationAngle(cube_r19, -0.3927F, 0.0F, -1.5708F);
		cube_r19.texOffs(24, 194).addBox(-9.5532F, 0.0068F, -160.4868F, 19.0F, 0.0F, 66.0F, 0.005F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setPos(-58.9202F, -0.0085F, -30.7425F);
		vortex.addChild(cube_r20);
		setRotationAngle(cube_r20, -0.3927F, 0.0F, 1.5708F);
		cube_r20.texOffs(24, 194).addBox(-9.5532F, 0.0068F, -160.4868F, 19.0F, 0.0F, 66.0F, 0.005F, true);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setPos(-22.7949F, -0.0085F, -18.8368F);
		vortex.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, 0.0F, 1.5708F);
		cube_r21.texOffs(213, 93).addBox(-9.5532F, 0.0068F, -99.1268F, 19.0F, 0.0F, 236.0F, 0.005F, true);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setPos(22.7949F, -0.0085F, -18.8368F);
		vortex.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, 0.0F, -1.5708F);
		cube_r22.texOffs(213, 93).addBox(-9.5532F, 0.0068F, -99.1268F, 19.0F, 0.0F, 236.0F, 0.005F, false);
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
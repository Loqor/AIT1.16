package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.mdt.ait.common.tiles.TARDISTileEntity;
import io.mdt.ait.tardis.exterior.model.BasicBoxModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class CoralExterior extends BasicBoxModel {
	private final ModelRenderer box;
	public final ModelRenderer right_door;
	public final ModelRenderer left_door;
	private final ModelRenderer base;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer bone;
	private final ModelRenderer cube_r4;

	public CoralExterior() {
		texWidth = 512;
		texHeight = 512;

		box = new ModelRenderer(this);
		box.setPos(-19.5F, 24.0F, -19.5F);
		

		right_door = new ModelRenderer(this);
		right_door.setPos(34.0F, -35.0F, 2.5F);
		box.addChild(right_door);
		setRotationAngle(right_door, 0.0F, 0.0F, 0.0F);
		right_door.texOffs(0, 22).addBox(-13.0F, 0.0F, -0.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		right_door.texOffs(0, 18).addBox(-13.0F, -4.0F, -1.25F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		right_door.texOffs(0, 18).addBox(-13.0F, -1.0F, -1.25F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		right_door.texOffs(0, 18).addBox(-13.0F, -4.0F, -1.25F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		right_door.texOffs(197, 131).addBox(-14.0F, -23.0F, -0.5F, 14.0F, 55.0F, 1.0F, 0.0F, false);

		left_door = new ModelRenderer(this);
		left_door.setPos(5.0F, -35.0F, 2.5F);
		box.addChild(left_door);
		setRotationAngle(left_door, 0.0F, 0.0F, 0.0F);
		left_door.texOffs(166, 188).addBox(0.0F, -23.0F, -0.5F, 14.0F, 55.0F, 1.0F, 0.0F, false);
		left_door.texOffs(98, 219).addBox(14.0F, -23.0F, -1.0F, 1.0F, 55.0F, 1.0F, 0.0F, false);
		left_door.texOffs(4, 18).addBox(11.0F, -4.0F, -1.25F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		left_door.texOffs(4, 18).addBox(11.0F, -2.0F, -1.25F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		left_door.texOffs(4, 18).addBox(11.0F, -4.0F, -1.25F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		base = new ModelRenderer(this);
		base.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(base);
		base.texOffs(124, 198).addBox(1.0F, -65.0F, 35.0F, 3.0F, 62.0F, 3.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(0.0F, -3.0F, 0.0F, 39.0F, 3.0F, 39.0F, 0.0F, false);
		base.texOffs(110, 43).addBox(2.0F, -66.0F, 2.0F, 35.0F, 2.0F, 35.0F, 0.0F, false);
		base.texOffs(118, 0).addBox(3.0F, -69.0F, 3.0F, 33.0F, 3.0F, 33.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(17.0F, -71.0F, 17.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		base.texOffs(16, 0).addBox(18.0F, -77.0F, 18.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		base.texOffs(0, 8).addBox(17.5F, -76.0F, 17.5F, 1.0F, 5.0F, 0.0F, 0.0F, false);
		base.texOffs(0, 8).addBox(20.5F, -76.0F, 17.5F, 1.0F, 5.0F, 0.0F, 0.0F, false);
		base.texOffs(0, 8).addBox(18.5F, -73.0F, 17.5F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		base.texOffs(0, 8).addBox(18.5F, -75.0F, 17.5F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		base.texOffs(0, 8).addBox(17.5F, -76.0F, 17.5F, 4.0F, 0.0F, 4.0F, 0.001F, false);
		base.texOffs(0, 8).addBox(17.5F, -75.0F, 18.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		base.texOffs(0, 8).addBox(17.5F, -73.0F, 18.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		base.texOffs(0, 8).addBox(17.5F, -76.0F, 20.5F, 0.0F, 5.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 8).addBox(17.5F, -76.0F, 17.5F, 0.0F, 5.0F, 1.0F, 0.0F, false);
		base.texOffs(14, 16).addBox(18.0F, -76.0F, 18.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		base.texOffs(150, 201).addBox(35.0F, -65.0F, 1.0F, 3.0F, 62.0F, 3.0F, 0.0F, false);
		base.texOffs(230, 188).addBox(34.0F, -58.0F, 1.5F, 1.0F, 55.0F, 1.0F, 0.0F, false);
		base.texOffs(113, 93).addBox(4.0F, -59.0F, 1.5F, 31.0F, 1.0F, 36.0F, 0.0F, false);
		base.texOffs(0, 43).addBox(2.0F, -64.0F, 0.0F, 35.0F, 5.0F, 39.0F, 0.0F, false);
		base.texOffs(0, 88).addBox(0.0F, -64.0F, 2.0F, 39.0F, 5.0F, 35.0F, 0.0F, false);
		base.texOffs(0, 129).addBox(1.5F, -59.0F, 4.0F, 36.0F, 1.0F, 31.0F, 0.0F, false);
		base.texOffs(93, 219).addBox(1.5F, -58.0F, 19.0F, 1.0F, 55.0F, 1.0F, 0.0F, false);
		base.texOffs(62, 162).addBox(2.0F, -58.0F, 20.0F, 1.0F, 55.0F, 14.0F, 0.0F, false);
		base.texOffs(31, 162).addBox(2.0F, -58.0F, 5.0F, 1.0F, 55.0F, 14.0F, 0.0F, false);
		base.texOffs(135, 131).addBox(36.0F, -58.0F, 20.0F, 1.0F, 55.0F, 14.0F, 0.0F, false);
		base.texOffs(210, 188).addBox(36.5F, -58.0F, 19.0F, 1.0F, 55.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 162).addBox(36.0F, -58.0F, 5.0F, 1.0F, 55.0F, 14.0F, 0.0F, false);
		base.texOffs(228, 131).addBox(4.0F, -58.0F, 1.5F, 1.0F, 55.0F, 1.0F, 0.0F, false);
		base.texOffs(113, 219).addBox(1.5F, -58.0F, 34.0F, 1.0F, 55.0F, 1.0F, 0.0F, false);
		base.texOffs(118, 219).addBox(1.5F, -58.0F, 4.0F, 1.0F, 55.0F, 1.0F, 0.0F, false);
		base.texOffs(103, 219).addBox(36.5F, -58.0F, 4.0F, 1.0F, 55.0F, 1.0F, 0.0F, false);
		base.texOffs(108, 219).addBox(36.5F, -58.0F, 34.0F, 1.0F, 55.0F, 1.0F, 0.0F, false);
		base.texOffs(137, 201).addBox(1.0F, -65.0F, 1.0F, 3.0F, 62.0F, 3.0F, 0.0F, false);
		base.texOffs(197, 188).addBox(35.0F, -65.0F, 35.0F, 3.0F, 62.0F, 3.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		base.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 1.5708F, 0.0F);
		cube_r1.texOffs(118, 219).addBox(-37.5F, -58.0F, 4.0F, 1.0F, 55.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(113, 219).addBox(-37.5F, -58.0F, 34.0F, 1.0F, 55.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(-15.0F, 0.0F, 15.0F);
		base.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 3.1416F, 0.0F);
		cube_r2.texOffs(0, 8).addBox(-36.5F, -76.0F, -6.5F, 0.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r2.texOffs(0, 8).addBox(-36.5F, -76.0F, -3.5F, 0.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r2.texOffs(0, 8).addBox(-36.5F, -73.0F, -5.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r2.texOffs(0, 8).addBox(-36.5F, -75.0F, -5.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(24.0F, 0.0F, -15.0F);
		base.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 3.1416F, 0.0F);
		cube_r3.texOffs(0, 8).addBox(3.5F, -73.0F, -36.5F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		cube_r3.texOffs(0, 8).addBox(3.5F, -75.0F, -36.5F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		cube_r3.texOffs(0, 8).addBox(5.5F, -76.0F, -36.5F, 1.0F, 5.0F, 0.0F, 0.0F, false);
		cube_r3.texOffs(0, 8).addBox(2.5F, -76.0F, -36.5F, 1.0F, 5.0F, 0.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setPos(39.0F, 0.0F, 39.0F);
		base.addChild(bone);


		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(0.0F, 0.0F, 0.0F);
		bone.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, -1.5708F, 0.0F);
		cube_r4.texOffs(210, 188).addBox(-2.5F, -58.0F, 19.0F, 1.0F, 55.0F, 1.0F, 0.0F, false);
		cube_r4.texOffs(0, 162).addBox(-3.0F, -58.0F, 5.0F, 1.0F, 55.0F, 14.0F, 0.0F, false);
		cube_r4.texOffs(135, 131).addBox(-3.0F, -58.0F, 20.0F, 1.0F, 55.0F, 14.0F, 0.0F, false);
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		box.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void render(TARDISTileEntity tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1); //fixme
	}
}
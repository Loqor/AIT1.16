package com.mdt.ait.client.models.tileentities;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.client.models.tileentities.BasicInteriorDoor;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ClassicInteriorDoors extends BasicInteriorDoor {
	public final ModelRenderer box;
	public final ModelRenderer base;
	public final ModelRenderer left_door;
	public final ModelRenderer cube_r1;
	public final ModelRenderer cube_r2;
	public final ModelRenderer right_door;
	public final ModelRenderer cube_r3;

	public ClassicInteriorDoors() {
		texWidth = 512;
		texHeight = 512;

		box = new ModelRenderer(this);
		box.setPos(0.0F, 28.0F, 8.0F);
		box.texOffs(0, 48).addBox(-20.0F, -3.0F, -20.0F, 40.0F, 3.0F, 40.0F, 0.0F, false);

		base = new ModelRenderer(this);
		base.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(base);
		base.texOffs(0, 0).addBox(-18.0F, -71.0F, -21.0F, 36.0F, 5.0F, 42.0F, 0.0F, false);
		base.texOffs(115, 0).addBox(-18.0F, -75.0F, -18.0F, 36.0F, 4.0F, 36.0F, 0.0F, false);
		base.texOffs(121, 48).addBox(-16.0F, -76.0F, -16.0F, 32.0F, 1.0F, 32.0F, 0.0F, false);
		base.texOffs(0, 92).addBox(-21.0F, -71.0F, -18.0F, 42.0F, 5.0F, 36.0F, 0.0F, false);
		base.texOffs(120, 97).addBox(-14.0F, -66.0F, -18.5F, 28.0F, 1.0F, 37.0F, 0.0F, false);
		base.texOffs(0, 134).addBox(-18.5F, -66.0F, -14.0F, 37.0F, 1.0F, 28.0F, 0.0F, false);
		base.texOffs(31, 164).addBox(-18.0F, -65.0F, 0.0F, 1.0F, 62.0F, 14.0F, 0.0F, false);
		base.texOffs(0, 164).addBox(-18.0F, -65.0F, -14.0F, 1.0F, 62.0F, 14.0F, 0.0F, false);
		base.texOffs(169, 213).addBox(-18.5F, -65.0F, -0.5F, 1.0F, 62.0F, 1.0F, 0.0F, false);
		base.texOffs(159, 213).addBox(17.5F, -65.0F, -0.5F, 1.0F, 62.0F, 1.0F, 0.0F, false);
		base.texOffs(131, 136).addBox(17.0F, -65.0F, -14.0F, 1.0F, 62.0F, 14.0F, 0.0F, false);
		base.texOffs(162, 136).addBox(17.0F, -65.0F, 0.0F, 1.0F, 62.0F, 14.0F, 0.0F, false);
		base.texOffs(193, 136).addBox(14.0F, -73.0F, -19.0F, 5.0F, 70.0F, 5.0F, 0.0F, false);
		base.texOffs(138, 213).addBox(-19.0F, -73.0F, -19.0F, 5.0F, 70.0F, 5.0F, 0.0F, false);
		base.texOffs(188, 212).addBox(-19.0F, -73.0F, 14.0F, 5.0F, 70.0F, 5.0F, 0.0F, false);
		base.texOffs(209, 207).addBox(14.0F, -73.0F, 14.0F, 5.0F, 70.0F, 5.0F, 0.0F, false);

		left_door = new ModelRenderer(this);
		left_door.setPos(-14.0F, -32.0F, -17.0F);
		box.addChild(left_door);
		left_door.texOffs(93, 215).addBox(0.0F, -33.0F, -1.0F, 14.0F, 62.0F, 1.0F, 0.0F, false);
		left_door.texOffs(248, 71).addBox(4.0F, -14.0F, 0.0F, 6.0F, 9.0F, 3.0F, 0.0F, false);
		left_door.texOffs(0, 12).addBox(10.0F, -11.0F, -1.75F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		left_door.texOffs(174, 213).addBox(13.5F, -33.0F, -1.5F, 1.0F, 62.0F, 1.0F, 0.0F, false);
		left_door.texOffs(276, 125).addBox(12.8F, -6.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(15.55F, -5.0F, 0.25F);
		left_door.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -1.5708F);
		cube_r1.texOffs(297, 211).addBox(-33.5F, -3.05F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(12.1F, 27.9F, 0.5F);
		left_door.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -1.5708F);
		cube_r2.texOffs(276, 200).addBox(-0.1F, -0.1F, -0.5F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		right_door = new ModelRenderer(this);
		right_door.setPos(14.0F, -32.0F, -17.0F);
		box.addChild(right_door);
		right_door.texOffs(230, 200).addBox(-14.0F, -33.0F, -1.0F, 14.0F, 62.0F, 1.0F, 0.0F, false);
		right_door.texOffs(276, 200).addBox(-13.4F, -6.0F, 0.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		right_door.texOffs(297, 211).addBox(-13.95F, -5.5F, -0.25F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		right_door.texOffs(0, 0).addBox(-12.75F, -13.0F, -1.75F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(-12.5F, -10.0F, -1.5F);
		right_door.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 3.1416F, 0.0F);
		cube_r3.texOffs(0, 0).addBox(-0.75F, -3.0F, -2.25F, 1.0F, 5.0F, 1.0F, 0.0F, false);
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
}
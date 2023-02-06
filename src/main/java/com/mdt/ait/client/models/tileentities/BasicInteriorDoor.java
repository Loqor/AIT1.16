package com.mdt.ait.client.models.tileentities;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.mdt.ait.tardis.TARDISInteriorDoorTile;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class BasicInteriorDoor extends EntityModel<Entity> {
	public final ModelRenderer box;
	public final ModelRenderer base;
	public final ModelRenderer Posts;
	public final ModelRenderer cube_r1;
	public final ModelRenderer Walls;
	public final ModelRenderer Roof;
	public final ModelRenderer PCB;
	public final ModelRenderer cube_r2;
	public final ModelRenderer cube_r3;
	public final ModelRenderer right_door;
	public final ModelRenderer left_door;

	public BasicInteriorDoor() {
		texWidth = 256;
		texHeight = 256;

		box = new ModelRenderer(this);
		box.setPos(0.0F, 24.0F, 8.0F);
		

		base = new ModelRenderer(this);
		base.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(base);
		base.texOffs(0, 0).addBox(-19.0F, -4.0F, -19.0F, 38.0F, 4.0F, 5.0F, 0.0F, false);

		Posts = new ModelRenderer(this);
		Posts.setPos(0.0F, 0.0F, 0.0F);
		base.addChild(Posts);
		Posts.texOffs(0, 70).addBox(-18.0F, -62.0F, -18.0F, 4.0F, 58.0F, 4.0F, 0.001F, true);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		Posts.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
		cube_r1.texOffs(56, 18).addBox(-18.0F, -62.0F, -18.0F, 4.0F, 58.0F, 4.0F, 0.001F, true);

		Walls = new ModelRenderer(this);
		Walls.setPos(0.0F, 0.0F, 0.0F);
		base.addChild(Walls);
		Walls.texOffs(20, 70).addBox(-14.0F, -56.0F, -16.0F, 1.0F, 52.0F, 1.0F, 0.0F, false);
		Walls.texOffs(16, 70).addBox(13.0F, -56.0F, -16.0F, 1.0F, 52.0F, 1.0F, 0.0F, false);
		Walls.texOffs(72, 9).addBox(-13.0F, -56.0F, -16.0F, 26.0F, 1.0F, 1.0F, 0.0F, false);

		Roof = new ModelRenderer(this);
		Roof.setPos(0.0F, 0.0F, 0.0F);
		base.addChild(Roof);
		Roof.texOffs(144, 26).addBox(-16.0F, -65.0F, -18.0F, 32.0F, 4.0F, 4.0F, 0.0F, false);
		Roof.texOffs(120, 78).addBox(-17.0F, -64.5F, -17.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		Roof.texOffs(112, 78).addBox(16.0F, -64.5F, -17.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		PCB = new ModelRenderer(this);
		PCB.setPos(0.0F, 0.0F, 0.0F);
		base.addChild(PCB);
		PCB.texOffs(0, 132).addBox(-17.0F, -61.0F, -19.0F, 34.0F, 5.0F, 4.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, 0.0F, 0.0F);
		PCB.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 1.5708F, 0.0F);
		cube_r2.texOffs(96, 78).addBox(14.0F, -61.0F, -19.0F, 3.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, 0.0F, 0.0F);
		PCB.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -1.5708F, 0.0F);
		cube_r3.texOffs(104, 78).addBox(-17.0F, -61.0F, -19.0F, 3.0F, 5.0F, 1.0F, 0.0F, false);

		right_door = new ModelRenderer(this);
		right_door.setPos(13.5F, -29.5F, -15.5F);
		box.addChild(right_door);
		right_door.texOffs(28, 18).addBox(-13.5F, -25.5F, -0.5F, 13.0F, 51.0F, 1.0F, 0.0F, false);
		right_door.texOffs(0, 0).addBox(-12.5F, -6.5F, -1.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		left_door = new ModelRenderer(this);
		left_door.setPos(-13.5F, -29.5F, -15.5F);
		box.addChild(left_door);
		left_door.texOffs(0, 18).addBox(0.5F, -25.5F, -0.5F, 13.0F, 51.0F, 1.0F, 0.0F, false);
		left_door.texOffs(0, 9).addBox(9.5F, -6.5F, -1.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
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

	public void render(TARDISInteriorDoorTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
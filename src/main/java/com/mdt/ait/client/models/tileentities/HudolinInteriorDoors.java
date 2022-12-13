package com.mdt.ait.client.models.tileentities;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.client.models.tileentities.BasicInteriorDoor;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class HudolinInteriorDoors extends BasicInteriorDoor {
	public final ModelRenderer box;
	public final ModelRenderer base;
	public final ModelRenderer right_door;
	public final ModelRenderer left_door;

	public HudolinInteriorDoors() {
		texWidth = 512;
		texHeight = 512;

		box = new ModelRenderer(this);
		box.setPos(0.0F, -11.0F, 8.0F);
		

		base = new ModelRenderer(this);
		base.setPos(-19.0F, 35.0F, 19.0F);
		box.addChild(base);
		base.texOffs(182, 33).addBox(0.0F, -3.0F, -38.0F, 38.0F, 3.0F, 5.0F, 0.0F, false);
		base.texOffs(0, 281).addBox(1.0F, -67.0F, -37.0F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		base.texOffs(62, 212).addBox(33.0F, -67.0F, -37.0F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		base.texOffs(32, 32).addBox(2.0F, -66.0F, -39.0F, 34.0F, 5.0F, 8.0F, 0.0F, false);
		base.texOffs(62, 77).addBox(37.0F, -66.0F, -36.0F, 2.0F, 5.0F, 3.0F, 0.0F, false);
		base.texOffs(62, 77).addBox(-1.0F, -66.0F, -36.0F, 2.0F, 5.0F, 3.0F, 0.0F, false);
		base.texOffs(181, 77).addBox(2.0F, -62.0F, -36.0F, 34.0F, 3.0F, 2.0F, 0.0F, false);
		base.texOffs(182, 79).addBox(3.0F, -69.0F, -36.5F, 32.0F, 3.0F, 3.0F, 0.0F, false);

		right_door = new ModelRenderer(this);
		right_door.setPos(14.0F, 4.0F, -16.0F);
		box.addChild(right_door);
		right_door.texOffs(31, 212).addBox(-14.0F, -28.0F, -1.0F, 14.0F, 56.0F, 1.0F, 0.0F, false);
		right_door.texOffs(34, 350).addBox(-13.0F, -8.0F, -1.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		right_door.texOffs(34, 350).addBox(-13.0F, -10.0F, -1.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		left_door = new ModelRenderer(this);
		left_door.setPos(-14.0F, 6.0F, -16.25F);
		box.addChild(left_door);
		left_door.texOffs(0, 212).addBox(0.0F, -30.0F, -0.75F, 14.0F, 56.0F, 1.0F, 0.0F, false);
		left_door.texOffs(39, 350).addBox(2.0F, -10.5F, -1.25F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		left_door.texOffs(17, 281).addBox(13.5F, -30.0F, -1.25F, 1.0F, 56.0F, 1.0F, 0.0F, false);
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
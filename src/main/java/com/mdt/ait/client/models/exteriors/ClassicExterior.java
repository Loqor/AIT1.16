package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ClassicExterior extends BasicBox {
	public final ModelRenderer box;
	public final ModelRenderer base;
	public final ModelRenderer cube_r1;
	public final ModelRenderer cube_r2;
	public final ModelRenderer right_door;
	public final ModelRenderer left_door;

	public ClassicExterior() {
		texWidth = 512;
		texHeight = 512;

		box = new ModelRenderer(this);
		box.setPos(0.0F, 24.0F, 0.0F);
		

		base = new ModelRenderer(this);
		base.setPos(0.0F, -1.0F, 0.0F);
		box.addChild(base);
		base.texOffs(0, 0).addBox(-22.5F, -3.0F, -22.5F, 45.0F, 4.0F, 45.0F, 0.0F, false);
		base.texOffs(130, 241).addBox(-21.0F, -74.0F, -21.0F, 5.0F, 71.0F, 5.0F, 0.0F, false);
		base.texOffs(109, 241).addBox(-21.0F, -74.0F, 16.0F, 5.0F, 71.0F, 5.0F, 0.0F, false);
		base.texOffs(88, 241).addBox(16.0F, -74.0F, 16.0F, 5.0F, 71.0F, 5.0F, 0.0F, false);
		base.texOffs(67, 179).addBox(16.0F, -74.0F, -21.0F, 5.0F, 71.0F, 5.0F, 0.0F, false);
		base.texOffs(156, 241).addBox(-19.5F, -64.0F, -0.5F, 1.0F, 61.0F, 1.0F, 0.0F, false);
		base.texOffs(151, 241).addBox(-0.5F, -64.0F, 18.5F, 1.0F, 61.0F, 1.0F, 0.0F, false);
		base.texOffs(88, 179).addBox(18.5F, -64.0F, -0.5F, 1.0F, 61.0F, 1.0F, 0.0F, false);
		base.texOffs(164, 147).addBox(-19.0F, -64.0F, -16.0F, 1.0F, 61.0F, 32.0F, 0.0F, false);
		base.texOffs(0, 179).addBox(-16.0F, -64.0F, 18.0F, 32.0F, 61.0F, 1.0F, 0.0F, false);
		base.texOffs(97, 147).addBox(18.0F, -64.0F, -16.0F, 1.0F, 61.0F, 32.0F, 0.0F, false);
		base.texOffs(118, 50).addBox(-20.0F, -76.0F, -20.0F, 40.0F, 3.0F, 40.0F, 0.0F, false);
		base.texOffs(124, 104).addBox(-19.5F, -78.0F, -19.5F, 39.0F, 3.0F, 39.0F, 0.0F, false);
		base.texOffs(136, 0).addBox(-18.0F, -79.0F, -18.0F, 36.0F, 3.0F, 36.0F, 0.0F, false);
		base.texOffs(0, 143).addBox(-16.0F, -80.0F, -16.0F, 32.0F, 3.0F, 32.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(-5.0F, -82.5F, -5.0F, 10.0F, 3.0F, 10.0F, 0.0F, false);
		base.texOffs(0, 24).addBox(-4.0F, -83.5F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		base.texOffs(0, 14).addBox(-4.0F, -90.5F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		base.texOffs(25, 34).addBox(-2.0F, -89.5F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		base.texOffs(0, 34).addBox(-3.0F, -91.5F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		base.texOffs(25, 14).addBox(-3.5F, -89.5F, -3.5F, 1.0F, 6.0F, 0.0F, 0.0F, false);
		base.texOffs(0, 14).addBox(-3.5F, -89.5F, 2.5F, 0.0F, 6.0F, 1.0F, 0.0F, false);
		base.texOffs(3, 24).addBox(2.5F, -89.5F, 3.5F, 1.0F, 6.0F, 0.0F, 0.0F, false);
		base.texOffs(6, 0).addBox(3.5F, -89.5F, -3.5F, 0.0F, 6.0F, 1.0F, 0.0F, false);
		base.texOffs(3, 0).addBox(-3.5F, -89.5F, -3.5F, 0.0F, 6.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 24).addBox(-3.5F, -89.5F, 3.5F, 1.0F, 6.0F, 0.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(3.5F, -89.5F, 2.5F, 0.0F, 6.0F, 1.0F, 0.0F, false);
		base.texOffs(3, 14).addBox(2.5F, -89.5F, -3.5F, 1.0F, 6.0F, 0.0F, 0.0F, false);
		base.texOffs(0, 50).addBox(-18.0F, -73.0F, -22.5F, 36.0F, 5.0F, 45.0F, 0.0F, false);
		base.texOffs(0, 101).addBox(-22.5F, -73.0F, -18.0F, 45.0F, 5.0F, 36.0F, 0.0F, false);
		base.texOffs(230, 100).addBox(-16.0F, -65.0F, -19.5F, 32.0F, 1.0F, 1.0F, 0.0F, false);
		base.texOffs(181, 45).addBox(-16.0F, -68.0F, -19.875F, 32.0F, 3.0F, 1.0F, 0.0F, false);
		base.texOffs(132, 162).addBox(-14.5F, -69.25F, -20.125F, 29.0F, 3.0F, 1.0F, 0.0F, false);
		base.texOffs(230, 97).addBox(-16.0F, -65.0F, 18.5F, 32.0F, 1.0F, 1.0F, 0.0F, false);
		base.texOffs(163, 99).addBox(-16.0F, -68.0F, 18.875F, 32.0F, 3.0F, 1.0F, 0.0F, false);
		base.texOffs(132, 157).addBox(-14.5F, -69.25F, 19.125F, 29.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		base.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 1.5708F, 0.0F);
		cube_r1.texOffs(132, 147).addBox(-14.5F, -69.25F, 19.125F, 29.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(136, 40).addBox(-16.0F, -68.0F, 18.875F, 32.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(203, 40).addBox(-16.0F, -65.0F, 18.5F, 32.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, 0.0F, 0.0F);
		base.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -1.5708F, 0.0F);
		cube_r2.texOffs(132, 152).addBox(-14.5F, -69.25F, 19.125F, 29.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r2.texOffs(163, 94).addBox(-16.0F, -68.0F, 18.875F, 32.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r2.texOffs(230, 94).addBox(-16.0F, -65.0F, 18.5F, 32.0F, 1.0F, 1.0F, 0.0F, false);

		right_door = new ModelRenderer(this);
		right_door.setPos(16.0F, -42.0F, -18.0F);
		box.addChild(right_door);
		right_door.texOffs(231, 210).addBox(-16.0F, -23.0F, -1.0F, 16.0F, 61.0F, 1.0F, 0.0F, false);
		right_door.texOffs(36, 0).addBox(-14.0F, -1.5F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		left_door = new ModelRenderer(this);
		left_door.setPos(-16.0F, -42.0F, -18.0F);
		box.addChild(left_door);
		left_door.texOffs(231, 147).addBox(0.0F, -23.0F, -1.0F, 16.0F, 61.0F, 1.0F, 0.0F, false);
		left_door.texOffs(30, 0).addBox(11.0F, -0.5F, -2.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		left_door.texOffs(161, 241).addBox(15.5F, -23.0F, -1.5F, 1.0F, 61.0F, 1.0F, 0.0F, false);
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
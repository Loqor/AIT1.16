package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.client.models.exteriors.BasicBox;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class NukaColaExterior extends BasicBox {
	public final ModelRenderer box;
	public final ModelRenderer base;
	public final ModelRenderer cube_r1;
	public final ModelRenderer cube_r2;
	public final ModelRenderer door;
	public final ModelRenderer cube_r3;
	public final ModelRenderer cube_r4;
	public final ModelRenderer cube_r5;

	public NukaColaExterior() {
		texWidth = 1024;
		texHeight = 1024;

		box = new ModelRenderer(this);
		box.setPos(-41.0F, -64.0F, -32.0F);
		

		base = new ModelRenderer(this);
		base.setPos(41.0F, -14.0F, 32.0F);
		box.addChild(base);
		base.texOffs(164, 432).addBox(-40.625F, 88.0F, -39.8928F, 76.0F, 12.0F, 8.0F, 0.01F, false);
		base.texOffs(0, 252).addBox(-42.625F, -74.0F, -31.8928F, 80.0F, 0.0F, 68.0F, 0.05F, false);
		base.texOffs(212, 180).addBox(-42.625F, 102.0F, -31.8928F, 80.0F, 0.0F, 68.0F, 0.05F, false);
		base.texOffs(300, 252).addBox(-42.625F, -74.0F, 36.1072F, 80.0F, 176.0F, 0.0F, 0.05F, false);
		base.texOffs(0, 0).addBox(37.375F, -74.0F, -31.8928F, 0.0F, 176.0F, 68.0F, 0.05F, false);
		base.texOffs(140, 0).addBox(-42.625F, -74.0F, -31.8928F, 0.0F, 176.0F, 68.0F, 0.05F, false);
		base.texOffs(336, 432).addBox(-42.625F, 86.0F, -31.8928F, 80.0F, 16.0F, 0.0F, 0.01F, false);
		base.texOffs(348, 452).addBox(33.375F, -74.0F, -31.8928F, 4.0F, 160.0F, 0.0F, 0.01F, false);
		base.texOffs(336, 452).addBox(-42.625F, -74.0F, -31.8928F, 4.0F, 160.0F, 0.0F, 0.01F, false);
		base.texOffs(444, 176).addBox(-38.625F, -74.0F, -31.8928F, 72.0F, 4.0F, 0.0F, 0.01F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(-83.25F, 7.175F, 6.4822F);
		base.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
		cube_r1.texOffs(524, 317).addBox(-35.1428F, -79.175F, -40.125F, 56.0F, 33.0F, 0.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, 7.175F, -2.5178F);
		base.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -1.5708F, 0.0F);
		cube_r2.texOffs(580, 317).addBox(-26.1072F, -79.175F, -37.875F, 56.0F, 33.0F, 0.0F, 0.0F, false);

		door = new ModelRenderer(this);
		door.setPos(0.0F, -21.0F, 0.0F);
		box.addChild(door);
		door.texOffs(0, 324).addBox(0.375F, -65.0F, -3.8928F, 76.0F, 164.0F, 4.0F, 0.0F, false);
		door.texOffs(280, 0).addBox(-1.625F, -67.0F, -11.8928F, 80.0F, 164.0F, 8.0F, 0.0F, false);
		door.texOffs(72, 0).addBox(34.375F, -20.0F, -19.8928F, 40.0F, 56.0F, 8.0F, 0.0F, false);
		door.texOffs(0, 0).addBox(4.375F, -12.0F, -12.8928F, 12.0F, 12.0F, 4.0F, 0.0F, false);
		door.texOffs(580, 317).addBox(20.0F, -65.0F, -12.0F, 56.0F, 33.0F, 0.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(42.375F, 109.7521F, -68.5426F);
		door.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.6545F, 0.0F, 0.0F);
		cube_r3.texOffs(164, 324).addBox(-8.0F, -156.0F, -44.0F, 40.0F, 12.0F, 8.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(42.375F, 100.2945F, -16.8525F);
		door.addChild(cube_r4);
		setRotationAngle(cube_r4, -0.3491F, 0.0F, 0.0F);
		cube_r4.texOffs(164, 372).addBox(-8.0F, -124.0F, -44.0F, 40.0F, 12.0F, 8.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(42.375F, -39.7244F, 1.8745F);
		door.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.8727F, 0.0F, 0.0F);
		cube_r5.texOffs(164, 348).addBox(-8.0F, 32.0F, -72.0F, 40.0F, 12.0F, 8.0F, 0.0F, false);
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
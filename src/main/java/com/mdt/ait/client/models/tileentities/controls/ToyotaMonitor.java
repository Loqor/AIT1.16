package com.mdt.ait.client.models.tileentities.controls;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.ToyotaMonitorTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ToyotaMonitor extends EntityModel<Entity> {
	public final ModelRenderer bb_main;
	public final ModelRenderer cube_r1;
	public final ModelRenderer cube_r2;
	public final ModelRenderer cube_r3;
	public final ModelRenderer cube_r4;
	public final ModelRenderer cube_r5;
	public final ModelRenderer cube_r6;

	public ToyotaMonitor() {
		texWidth = 128;
		texHeight = 128;

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);
		bb_main.texOffs(0, 0).addBox(-9.0F, -2.0F, -9.0F, 18.0F, 2.0F, 18.0F, 0.001F, false);
		bb_main.texOffs(0, 0).addBox(-2.0F, -3.0F, -10.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, -3.2576F, 0.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.1745F, 0.0F, 0.0F);
		cube_r1.texOffs(36, 20).addBox(-10.0F, -1.8729F, -22.2288F, 20.0F, 7.0F, 0.0F, 0.001F, false);
		cube_r1.texOffs(0, 6).addBox(-2.0F, 0.557F, -21.2487F, 4.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, -3.2576F, 0.0F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.1745F, 0.0F, 0.0F);
		cube_r2.texOffs(36, 20).addBox(-10.0F, -1.8729F, 22.2288F, 20.0F, 7.0F, 0.0F, 0.001F, false);
		cube_r2.texOffs(0, 6).addBox(-2.0F, 0.557F, 20.2487F, 4.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r2.texOffs(0, 33).addBox(-8.0F, -3.8729F, 21.2288F, 16.0F, 11.0F, 2.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, -3.2576F, 0.0F);
		bb_main.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 3.1416F, 0.0F);
		cube_r3.texOffs(0, 0).addBox(-2.0F, 0.2576F, -10.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(0.0F, -3.2576F, 0.0F);
		bb_main.addChild(cube_r4);
		setRotationAngle(cube_r4, 2.7925F, 0.0F, 3.1416F);
		cube_r4.texOffs(22, 32).addBox(-1.0F, 4.5416F, -21.6248F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(0.0F, -3.2576F, 0.0F);
		bb_main.addChild(cube_r5);
		setRotationAngle(cube_r5, -2.9671F, 0.0F, -3.1416F);
		cube_r5.texOffs(0, 20).addBox(-8.0F, -3.8729F, 21.2288F, 16.0F, 11.0F, 2.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.0F, -3.2576F, 0.0F);
		bb_main.addChild(cube_r6);
		setRotationAngle(cube_r6, -0.3491F, 0.0F, 0.0F);
		cube_r6.texOffs(22, 32).addBox(-1.0F, 4.5416F, -21.6248F, 2.0F, 2.0F, 14.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(ToyotaMonitorTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
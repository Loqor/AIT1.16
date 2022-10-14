package com.mdt.ait.client.models.tileentities.controls;// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.TennantMonitorTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TennantMonitor extends EntityModel<Entity> {
	public final ModelRenderer box;
	public final ModelRenderer cube_r1;
	public final ModelRenderer cube_r2;
	public final ModelRenderer cube_r3;

	public TennantMonitor() {
		texWidth = 64;
		texHeight = 64;

		box = new ModelRenderer(this);
		box.setPos(0.0F, 15.8014F, 3.1762F);
		box.texOffs(0, 0).addBox(-8.0F, 6.1986F, -7.1762F, 16.0F, 2.0F, 8.0F, 0.001F, false);
		box.texOffs(0, 28).addBox(-2.0F, 0.1576F, -0.0603F, 4.0F, 3.0F, 9.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(cube_r1);
		setRotationAngle(cube_r1, -1.309F, 0.0F, 0.0F);
		cube_r1.texOffs(0, 4).addBox(-8.0F, 4.6986F, 4.0F, 4.0F, 4.0F, 0.0F, 0.001F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(-2.0F, 10.9295F, -1.9715F);
		box.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.48F, 0.0F, 0.0F);
		cube_r2.texOffs(0, 0).addBox(6.0F, -16.0F, -5.0F, 4.0F, 4.0F, 0.0F, 0.001F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, 10.8076F, 3.9397F);
		box.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.3927F, 0.0F, 0.0F);
		cube_r3.texOffs(0, 11).addBox(-8.0F, -14.0F, -9.0F, 16.0F, 13.0F, 3.0F, 0.0F, false);
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

	public void render(TennantMonitorTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
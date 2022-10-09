package com.mdt.ait.client.models.tileentities.controls;// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.BasicRotorTile;
import com.mdt.ait.common.tileentities.DimensionSwitchControlTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class DimensionSwitchControl extends EntityModel<Entity> {
	public final ModelRenderer box;
	public final ModelRenderer planet;
	public final ModelRenderer cube_r1;
	public final ModelRenderer screen;
	public final ModelRenderer base;

	public DimensionSwitchControl() {
		texWidth = 128;
		texHeight = 128;

		box = new ModelRenderer(this);
		box.setPos(0.0F, 23.5F, 0.0F);
		

		planet = new ModelRenderer(this);
		planet.setPos(0.0F, -9.0F, 0.0F);
		box.addChild(planet);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		planet.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.1684F, -0.5306F, -0.4988F);
		cube_r1.texOffs(49, 19).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, false);

		screen = new ModelRenderer(this);
		screen.setPos(0.0F, 0.5F, 0.0F);
		box.addChild(screen);
		screen.texOffs(49, 0).addBox(-6.0F, -14.0F, -8.0F, 12.0F, 12.0F, 1.0F, 0.0F, false);

		base = new ModelRenderer(this);
		base.setPos(0.0F, 0.5F, 0.0F);
		box.addChild(base);
		base.texOffs(0, 19).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 16.0F, 0.0F, false);
		base.texOffs(37, 38).addBox(6.0F, -14.0F, -8.0F, 2.0F, 12.0F, 16.0F, 0.0F, false);
		base.texOffs(21, 38).addBox(-6.0F, -14.0F, 6.0F, 12.0F, 12.0F, 2.0F, 0.0F, false);
		base.texOffs(0, 38).addBox(-8.0F, -14.0F, -8.0F, 2.0F, 12.0F, 16.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 2.0F, 16.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		screen.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(DimensionSwitchControlTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
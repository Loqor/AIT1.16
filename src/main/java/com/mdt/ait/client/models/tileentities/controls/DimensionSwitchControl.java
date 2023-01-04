package com.mdt.ait.client.models.tileentities.controls;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


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

	public DimensionSwitchControl() {
		texWidth = 128;
		texHeight = 128;

		box = new ModelRenderer(this);
		box.setPos(8.0F, 24.0F, -8.0F);
		box.texOffs(0, 0).addBox(-16.0F, -16.0F, 0.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
		box.texOffs(48, 0).addBox(-15.0F, -15.0F, 15.0F, 14.0F, 14.0F, 0.0F, 0.0F, false);
		box.texOffs(28, 32).addBox(-15.0F, -1.0F, 0.0F, 14.0F, 0.0F, 15.0F, 0.0F, false);
		box.texOffs(0, 32).addBox(-15.0F, -15.0F, 0.0F, 14.0F, 0.0F, 15.0F, 0.0F, false);
		box.texOffs(0, 32).addBox(-15.0F, -15.0F, 0.0F, 0.0F, 14.0F, 15.0F, 0.0F, false);
		box.texOffs(30, 32).addBox(-1.0F, -15.0F, 0.0F, 0.0F, 14.0F, 15.0F, 0.0F, false);

		planet = new ModelRenderer(this);
		planet.setPos(-8.0F, -9.5F, 8.0F);
		box.addChild(planet);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		planet.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.1684F, -0.5306F, -0.4988F);
		cube_r1.texOffs(64, 22).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, false);
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

	public void render(DimensionSwitchControlTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
package com.mdt.ait.client.models.tileentities.controls;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.DoorSwitchControlTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class DoorSwitchControl extends EntityModel<Entity> {
	public final ModelRenderer second;
	public final ModelRenderer cube_r1;
	public final ModelRenderer first;
	public final ModelRenderer cube_r2;
	public final ModelRenderer base;

	public DoorSwitchControl() {
		texWidth = 64;
		texHeight = 64;

		second = new ModelRenderer(this);
		second.setPos(3.0F, 22.0F, 1.5F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(-3.0F, 2.0F, -1.5F);
		second.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.6545F, 0.0F, 0.0F);
		cube_r1.texOffs(0, 26).addBox(2.25F, -3.5F, -7.0F, 0.0F, 2.0F, 8.0F, 0.0F, false);
		cube_r1.texOffs(0, 5).addBox(1.25F, -3.5F, -9.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		first = new ModelRenderer(this);
		first.setPos(-3.0F, 22.0F, 1.5F);
		

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(3.0F, 2.0F, -1.5F);
		first.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.6545F, 0.0F, 0.0F);
		cube_r2.texOffs(25, 18).addBox(-2.0F, -3.5F, -7.0F, 0.0F, 2.0F, 8.0F, 0.0F, false);
		cube_r2.texOffs(0, 0).addBox(-4.0F, -3.5F, -9.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		base = new ModelRenderer(this);
		base.setPos(0.0F, 24.0F, 0.0F);
		base.texOffs(0, 17).addBox(-4.0F, -2.25F, -3.0F, 8.0F, 0.0F, 8.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(-6.0F, -2.0F, -7.0F, 12.0F, 2.0F, 14.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		second.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		first.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(DoorSwitchControlTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
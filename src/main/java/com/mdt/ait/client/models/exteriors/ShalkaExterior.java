package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.4.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.mdt.ait.common.tiles.TARDISTileEntity;
import io.mdt.ait.tardis.exterior.model.BasicBoxModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ShalkaExterior extends BasicBoxModel {
	public final ModelRenderer box;
	public final ModelRenderer base;
	public final ModelRenderer right_door;
	public final ModelRenderer left_door;

	public ShalkaExterior() {
		texWidth = 512;
		texHeight = 512;

		box = new ModelRenderer(this);
		box.setPos(0.0F, -16.0F, 0.0F);
		

		base = new ModelRenderer(this);
		base.setPos(6.5F, 40.0F, 6.5F);
		box.addChild(base);
		base.texOffs(0, 0).addBox(-25.5F, -2.0F, -25.5F, 38.0F, 2.0F, 38.0F, 0.0F, false);
		base.texOffs(141, 188).addBox(-24.5F, -72.0F, -24.5F, 4.0F, 70.0F, 4.0F, 0.0F, false);
		base.texOffs(124, 188).addBox(7.5F, -72.0F, -24.5F, 4.0F, 70.0F, 4.0F, 0.0F, false);
		base.texOffs(107, 188).addBox(7.5F, -72.0F, 7.5F, 4.0F, 70.0F, 4.0F, 0.0F, false);
		base.texOffs(90, 123).addBox(-24.5F, -72.0F, 7.5F, 4.0F, 70.0F, 4.0F, 0.0F, false);
		base.texOffs(0, 123).addBox(-22.5F, -64.0F, -20.5F, 1.0F, 62.0F, 28.0F, 0.0F, false);
		base.texOffs(59, 189).addBox(-23.0F, -64.0F, -7.0F, 1.0F, 62.0F, 1.0F, 0.0F, false);
		base.texOffs(163, 188).addBox(-7.0F, -64.0F, 9.0F, 1.0F, 62.0F, 1.0F, 0.0F, false);
		base.texOffs(158, 188).addBox(9.0F, -64.0F, -7.0F, 1.0F, 62.0F, 1.0F, 0.0F, false);
		base.texOffs(172, 78).addBox(-20.5F, -64.0F, 8.5F, 28.0F, 62.0F, 1.0F, 0.0F, false);
		base.texOffs(113, 95).addBox(8.5F, -64.0F, -20.5F, 1.0F, 62.0F, 28.0F, 0.0F, false);
		base.texOffs(0, 41).addBox(-22.5F, -71.0F, -25.5F, 32.0F, 5.0F, 38.0F, 0.0F, false);
		base.texOffs(0, 85).addBox(-25.5F, -71.0F, -22.5F, 38.0F, 5.0F, 32.0F, 0.0F, false);
		base.texOffs(16, 20).addBox(5.5F, -73.0F, -23.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		base.texOffs(0, 17).addBox(-23.5F, -73.0F, -23.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		base.texOffs(16, 12).addBox(-23.5F, -73.0F, 5.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		base.texOffs(0, 9).addBox(5.5F, -73.0F, 5.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		base.texOffs(103, 41).addBox(-23.0F, -74.0F, -23.0F, 33.0F, 3.0F, 33.0F, 0.0F, false);
		base.texOffs(115, 0).addBox(-21.0F, -75.0F, -21.0F, 29.0F, 1.0F, 29.0F, 0.0F, false);
		base.texOffs(28, 28).addBox(-4.5F, -81.5F, -4.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		base.texOffs(23, 28).addBox(-4.5F, -81.5F, -9.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		base.texOffs(18, 28).addBox(-9.5F, -81.5F, -4.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		base.texOffs(13, 28).addBox(-9.5F, -81.5F, -9.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(-10.0F, -82.5F, -10.0F, 7.0F, 1.0F, 7.0F, 0.0F, false);
		base.texOffs(0, 25).addBox(-8.0F, -81.5F, -8.0F, 3.0F, 7.0F, 3.0F, 0.0F, false);
		base.texOffs(0, 290).addBox(-23.5F, -66.0F, -23.5F, 34.0F, 1.0F, 34.0F, 0.0F, false);
		base.texOffs(0, 348).addBox(-23.0F, -65.0F, -23.0F, 33.0F, 1.0F, 33.0F, 0.0F, false);

		right_door = new ModelRenderer(this);
		right_door.setPos(14.0F, 6.0F, -15.0F);
		box.addChild(right_door);
		right_door.texOffs(172, 144).addBox(-14.0F, -30.0F, -1.0F, 14.0F, 62.0F, 1.0F, 0.0F, false);
		right_door.texOffs(0, 9).addBox(-13.0F, -12.0F, -1.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		right_door.texOffs(0, 0).addBox(-13.0F, -10.0F, -2.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		left_door = new ModelRenderer(this);
		left_door.setPos(-14.0F, 6.0F, -15.0F);
		box.addChild(left_door);
		left_door.texOffs(59, 123).addBox(0.0F, -30.0F, -1.0F, 14.0F, 62.0F, 1.0F, 0.0F, false);
		left_door.texOffs(64, 189).addBox(13.5F, -30.0F, -1.5F, 1.0F, 62.0F, 1.0F, 0.0F, false);
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

	public void render(TARDISTileEntity tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1); //fixme
	}
}
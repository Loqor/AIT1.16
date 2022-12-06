package com.mdt.ait.client.models.tileentities;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.RecordPlayerTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class RecordPlayer extends EntityModel<Entity> {
	public final ModelRenderer base;
	public final ModelRenderer lid;
	public final ModelRenderer needle;
	public final ModelRenderer vl_slider;
	public final ModelRenderer record;

	public RecordPlayer() {
		texWidth = 128;
		texHeight = 128;

		base = new ModelRenderer(this);
		base.setPos(5.5F, 24.0F, 0.0F);
		base.texOffs(49, 0).addBox(-13.0F, -3.1F, -5.5F, 10.0F, 0.0F, 10.0F, 0.001F, false);
		base.texOffs(0, 0).addBox(-13.5F, -3.0F, -8.0F, 16.0F, 3.0F, 16.0F, 0.0F, false);
		base.texOffs(49, 20).addBox(-2.5F, -3.5F, -7.0F, 4.0F, 1.0F, 13.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(-4.5F, -4.5F, 4.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		base.texOffs(0, 9).addBox(-12.5F, -3.5F, 7.25F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 6).addBox(-1.5F, -3.5F, 7.25F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		lid = new ModelRenderer(this);
		lid.setPos(0.0F, 21.0F, 8.0F);
		setRotationAngle(lid, -1.309F, 0.0F, 0.0F);
		lid.texOffs(50, 37).addBox(-8.0F, -2.0F, -16.0F, 16.0F, 2.0F, 0.0F, 0.001F, false);
		lid.texOffs(0, 20).addBox(-8.0F, -2.0F, -16.0F, 16.0F, 0.0F, 16.0F, 0.001F, false);
		lid.texOffs(49, 11).addBox(-8.0F, -2.0F, 0.0F, 16.0F, 2.0F, 0.0F, 0.001F, false);
		lid.texOffs(0, 37).addBox(-8.0F, -2.0F, -16.0F, 0.0F, 2.0F, 16.0F, 0.001F, false);
		lid.texOffs(33, 37).addBox(8.0F, -2.0F, -16.0F, 0.0F, 2.0F, 16.0F, 0.001F, false);

		needle = new ModelRenderer(this);
		needle.setPos(2.5F, 20.4F, 5.5F);
		needle.texOffs(17, 37).addBox(-0.5F, -1.0F, -9.5F, 1.0F, 0.0F, 10.0F, 0.0F, false);

		vl_slider = new ModelRenderer(this);
		vl_slider.setPos(5.5F, 24.0F, 0.0F);
		vl_slider.texOffs(8, 8).addBox(-1.0F, -3.5F, -6.0F, 2.0F, 0.0F, 1.0F, 0.001F, false);

		record = new ModelRenderer(this);
		record.setPos(-2.5F, 20.8F, -0.5F);
		record.texOffs(-10, 38).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, 0.001F, false);
		record.texOffs(7, 10).addBox(-1.0F, -0.1F, -1.0F, 2.0F, 0.0F, 2.0F, 0.001F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		lid.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		needle.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		vl_slider.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		record.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(RecordPlayerTile tile, MatrixStack matrixStack, IVertexBuilder vertexBuffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStack, vertexBuffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
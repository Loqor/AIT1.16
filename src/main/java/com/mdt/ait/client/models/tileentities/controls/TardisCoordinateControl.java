package com.mdt.ait.client.models.tileentities.controls;// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.TardisCoordinateControlTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TardisCoordinateControl extends EntityModel<Entity> {
	public final ModelRenderer box;
	public final ModelRenderer base;
	public final ModelRenderer cube_r1;
	public final ModelRenderer increment;
	public final ModelRenderer x;
	public final ModelRenderer y;
	public final ModelRenderer z;

	public TardisCoordinateControl() {
		texWidth = 64;
		texHeight = 64;

		box = new ModelRenderer(this);
		box.setPos(0.0F, 24.0F, 0.0F);
		

		base = new ModelRenderer(this);
		base.setPos(0.0F, 1.0615F, 0.609F);
		box.addChild(base);
		base.texOffs(0, 0).addBox(-8.0F, -3.0615F, -8.609F, 16.0F, 2.0F, 16.0F, 0.001F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		base.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.3927F, 0.0F, 0.0F);
		cube_r1.texOffs(0, 32).addBox(-8.0F, -2.0F, 3.0F, 16.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r1.texOffs(0, 19).addBox(-8.0F, -4.0F, -2.0F, 16.0F, 2.0F, 10.0F, 0.0F, false);

		increment = new ModelRenderer(this);
		increment.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(increment);
		increment.texOffs(0, 19).addBox(-8.0F, -3.0F, -2.0F, 2.0F, 1.0F, 2.0F, -0.001F, false);

		x = new ModelRenderer(this);
		x.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(x);
		x.texOffs(0, 0).addBox(-6.5F, -3.0F, -6.5F, 3.0F, 1.0F, 3.0F, 0.001F, false);

		y = new ModelRenderer(this);
		y.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(y);
		y.texOffs(0, 5).addBox(-1.5F, -3.0F, -6.5F, 3.0F, 1.0F, 3.0F, 0.001F, false);

		z = new ModelRenderer(this);
		z.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(z);
		z.texOffs(0, 10).addBox(3.5F, -3.0F, -6.5F, 3.0F, 1.0F, 3.0F, 0.001F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		increment.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(TardisCoordinateControlTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
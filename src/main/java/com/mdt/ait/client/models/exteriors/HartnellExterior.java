package com.mdt.ait.client.models.exteriors;


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.mdt.ait.tardis.exterior.model.BasicBoxModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class HartnellExterior extends BasicBoxModel {
	public final ModelRenderer box;
	public final ModelRenderer right_door;
	public final ModelRenderer left_door;
	public final ModelRenderer base;
	public final ModelRenderer cube_r1;
	public final ModelRenderer cube_r2;
	public final ModelRenderer cube_r3;
	public final ModelRenderer cube_r4;

	public HartnellExterior() {
		texWidth = 512;
		texHeight = 512;

		box = new ModelRenderer(this);
		box.setPos(0.0F, 24.0F, 0.0F);
		

		right_door = new ModelRenderer(this);
		right_door.setPos(14.0F, -32.0F, -16.0F);
		box.addChild(right_door);
		right_door.texOffs(118, 189).addBox(-14.0F, -28.0F, -1.0F, 14.0F, 57.0F, 1.0F, 0.0F, false);

		left_door = new ModelRenderer(this);
		left_door.setPos(-14.0F, -32.0F, -16.0F);
		box.addChild(left_door);
		left_door.texOffs(177, 130).addBox(0.0F, -28.0F, -1.0F, 14.0F, 57.0F, 1.0F, 0.0F, false);
		left_door.texOffs(0, 0).addBox(12.0F, -5.0F, -1.75F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		left_door.texOffs(10, 210).addBox(13.5F, -28.0F, -1.25F, 1.0F, 57.0F, 1.0F, 0.0F, false);

		base = new ModelRenderer(this);
		base.setPos(3.5F, -2.5F, -32.5F);
		box.addChild(base);
		base.texOffs(0, 0).addBox(-22.5F, -0.5F, 13.5F, 38.0F, 3.0F, 38.0F, 0.0F, false);
		base.texOffs(200, 189).addBox(10.5F, -64.5F, 14.5F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		base.texOffs(183, 189).addBox(-21.5F, -64.5F, 14.5F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		base.texOffs(166, 189).addBox(-21.5F, -64.5F, 46.5F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		base.texOffs(149, 189).addBox(10.5F, -64.5F, 46.5F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		base.texOffs(0, 42).addBox(-19.5F, -63.5F, 13.5F, 32.0F, 5.0F, 38.0F, 0.0F, false);
		base.texOffs(0, 86).addBox(-22.5F, -63.5F, 16.5F, 38.0F, 5.0F, 32.0F, 0.0F, false);
		base.texOffs(107, 90).addBox(-20.5F, -68.5F, 15.5F, 34.0F, 5.0F, 34.0F, 0.0F, false);
		base.texOffs(0, 7).addBox(-6.0F, -70.5F, 30.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(-6.0F, -76.5F, 30.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
		base.texOffs(0, 32).addBox(-2.0F, -75.5F, 30.0F, 1.0F, 5.0F, 0.0F, 0.001F, false);
		base.texOffs(13, 30).addBox(-6.0F, -75.5F, 30.0F, 0.0F, 5.0F, 1.0F, 0.001F, false);
		base.texOffs(19, 30).addBox(-6.0F, -75.5F, 35.0F, 1.0F, 5.0F, 0.0F, 0.001F, false);
		base.texOffs(30, 9).addBox(-1.0F, -75.5F, 34.0F, 0.0F, 5.0F, 1.0F, 0.001F, false);
		base.texOffs(0, 14).addBox(-5.5F, -75.5F, 30.5F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		base.texOffs(24, 27).addBox(11.0F, -66.5F, 15.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		base.texOffs(0, 24).addBox(-21.0F, -66.5F, 15.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		base.texOffs(14, 22).addBox(-21.0F, -66.5F, 47.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		base.texOffs(17, 14).addBox(11.0F, -66.5F, 47.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		base.texOffs(115, 0).addBox(-19.5F, -69.5F, 16.5F, 32.0F, 1.0F, 32.0F, 0.0F, false);
		base.texOffs(59, 124).addBox(-20.5F, -57.5F, 18.5F, 1.0F, 57.0F, 28.0F, 0.0F, false);
		base.texOffs(5, 210).addBox(-20.75F, -57.5F, 32.0F, 1.0F, 57.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 210).addBox(-4.0F, -57.5F, 48.75F, 1.0F, 57.0F, 1.0F, 0.0F, false);
		base.texOffs(208, 130).addBox(12.75F, -57.5F, 32.0F, 1.0F, 57.0F, 1.0F, 0.0F, false);
		base.texOffs(118, 130).addBox(-17.5F, -57.5F, 48.5F, 28.0F, 57.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 124).addBox(12.5F, -57.5F, 18.5F, 1.0F, 57.0F, 28.0F, 0.0F, false);
		base.texOffs(103, 42).addBox(-21.0F, -58.5F, 15.0F, 35.0F, 1.0F, 35.0F, 0.0F, false);
		base.texOffs(17, 3).addBox(-5.5F, -77.5F, 30.5F, 4.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(29.0F, 0.0F, 36.0F);
		base.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
		cube_r1.texOffs(27, 9).addBox(-1.0F, -75.5F, 30.0F, 0.0F, 5.0F, 1.0F, 0.001F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(-7.0F, 0.0F, 65.0F);
		base.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -1.5708F, 0.0F);
		cube_r2.texOffs(16, 30).addBox(-31.0F, -75.5F, -1.0F, 1.0F, 5.0F, 0.0F, 0.001F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(-36.0F, 0.0F, 29.0F);
		base.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -1.5708F, 0.0F);
		cube_r3.texOffs(30, 0).addBox(1.0F, -75.5F, -31.0F, 0.0F, 5.0F, 1.0F, 0.001F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(0.0F, 0.0F, 0.0F);
		base.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, -1.5708F, 0.0F);
		cube_r4.texOffs(30, 16).addBox(30.0F, -75.5F, 1.0F, 1.0F, 5.0F, 0.0F, 0.001F, false);
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
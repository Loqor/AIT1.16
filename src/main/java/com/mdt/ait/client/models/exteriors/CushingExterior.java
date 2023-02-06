package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.mdt.ait.tardis.exterior.model.BasicBoxModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class CushingExterior extends BasicBoxModel {
	public final ModelRenderer box;
	public final ModelRenderer base;
	public final ModelRenderer right_door;
	public final ModelRenderer left_door;

	public CushingExterior() {
		texWidth = 512;
		texHeight = 512;

		box = new ModelRenderer(this);
		box.setPos(18.0F, 24.0F, 18.0F);
		

		base = new ModelRenderer(this);
		base.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(base);
		base.texOffs(0, 0).addBox(-40.0F, -3.0F, -40.0F, 44.0F, 3.0F, 44.0F, 0.0F, false);
		base.texOffs(126, 48).addBox(-38.0F, -76.0F, -38.0F, 40.0F, 3.0F, 40.0F, 0.0F, false);
		base.texOffs(132, 92).addBox(-37.5F, -79.0F, -37.5F, 39.0F, 3.0F, 39.0F, 0.0F, false);
		base.texOffs(133, 0).addBox(-37.0F, -82.0F, -37.0F, 38.0F, 3.0F, 38.0F, 0.0F, false);
		base.texOffs(0, 10).addBox(-22.0F, -83.0F, -22.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(-22.0F, -90.0F, -22.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		base.texOffs(21, 24).addBox(-20.0F, -89.0F, -20.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		base.texOffs(0, 20).addBox(-21.0F, -91.0F, -21.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		base.texOffs(28, 0).addBox(-21.5F, -89.0F, -21.5F, 1.0F, 6.0F, 0.0F, 0.0F, false);
		base.texOffs(3, 0).addBox(-21.5F, -89.0F, -15.5F, 0.0F, 6.0F, 1.0F, 0.0F, false);
		base.texOffs(25, 0).addBox(-15.5F, -89.0F, -14.5F, 1.0F, 6.0F, 0.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(-14.5F, -89.0F, -21.5F, 0.0F, 6.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 10).addBox(-21.5F, -89.0F, -21.5F, 0.0F, 6.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 28).addBox(-21.5F, -89.0F, -14.5F, 1.0F, 6.0F, 0.0F, 0.0F, false);
		base.texOffs(3, 10).addBox(-14.5F, -89.0F, -15.5F, 0.0F, 6.0F, 1.0F, 0.0F, false);
		base.texOffs(25, 10).addBox(-15.5F, -89.0F, -21.5F, 1.0F, 6.0F, 0.0F, 0.0F, false);
		base.texOffs(0, 48).addBox(-38.0F, -73.0F, -40.5F, 40.0F, 5.0F, 45.0F, 0.0F, false);
		base.texOffs(0, 99).addBox(-40.5F, -73.0F, -38.0F, 45.0F, 5.0F, 40.0F, 0.0F, false);
		base.texOffs(206, 176).addBox(-34.0F, -66.0F, -37.5F, 32.0F, 1.0F, 1.0F, 0.0F, false);
		base.texOffs(206, 169).addBox(-34.0F, -68.0F, -38.0F, 32.0F, 2.0F, 1.0F, 0.0F, false);
		base.texOffs(174, 198).addBox(-38.0F, -68.0F, -34.0F, 1.0F, 2.0F, 32.0F, 0.0F, false);
		base.texOffs(35, 209).addBox(-37.5F, -66.0F, -34.0F, 1.0F, 1.0F, 32.0F, 0.0F, false);
		base.texOffs(177, 42).addBox(-34.0F, -68.0F, 1.0F, 32.0F, 2.0F, 1.0F, 0.0F, false);
		base.texOffs(206, 173).addBox(-34.0F, -66.0F, 0.5F, 32.0F, 1.0F, 1.0F, 0.0F, false);
		base.texOffs(102, 198).addBox(1.0F, -68.0F, -34.0F, 1.0F, 2.0F, 32.0F, 0.0F, false);
		base.texOffs(206, 135).addBox(0.5F, -66.0F, -34.0F, 1.0F, 1.0F, 32.0F, 0.0F, false);
		base.texOffs(235, 233).addBox(-2.0F, -75.0F, -39.0F, 5.0F, 72.0F, 5.0F, 0.0F, false);
		base.texOffs(5, 240).addBox(-37.5F, -65.0F, -18.5F, 1.0F, 62.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 240).addBox(-18.5F, -65.0F, 0.5F, 1.0F, 62.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 145).addBox(-37.0F, -65.0F, -34.0F, 1.0F, 62.0F, 32.0F, 0.0F, false);
		base.texOffs(67, 145).addBox(-34.0F, -65.0F, 0.0F, 32.0F, 62.0F, 1.0F, 0.0F, false);
		base.texOffs(139, 135).addBox(0.0F, -65.0F, -34.0F, 1.0F, 62.0F, 32.0F, 0.0F, false);
		base.texOffs(10, 240).addBox(0.5F, -65.0F, -18.5F, 1.0F, 62.0F, 1.0F, 0.0F, false);
		base.texOffs(214, 233).addBox(-39.0F, -75.0F, -39.0F, 5.0F, 72.0F, 5.0F, 0.0F, false);
		base.texOffs(193, 233).addBox(-39.0F, -75.0F, -2.0F, 5.0F, 72.0F, 5.0F, 0.0F, false);
		base.texOffs(172, 233).addBox(-2.0F, -75.0F, -2.0F, 5.0F, 72.0F, 5.0F, 0.0F, false);

		right_door = new ModelRenderer(this);
		right_door.setPos(-2.0F, -42.0F, -37.0F);
		box.addChild(right_door);
		right_door.texOffs(137, 233).addBox(-16.0F, -23.0F, 0.0F, 16.0F, 62.0F, 1.0F, 0.0F, false);
		right_door.texOffs(19, 20).addBox(-15.0F, -2.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		left_door = new ModelRenderer(this);
		left_door.setPos(-34.0F, -42.0F, -37.0F);
		box.addChild(left_door);
		left_door.texOffs(102, 233).addBox(0.0F, -23.0F, 0.0F, 16.0F, 62.0F, 1.0F, 0.0F, false);
		left_door.texOffs(0, 21).addBox(11.0F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		left_door.texOffs(15, 240).addBox(15.5F, -23.0F, -0.5F, 1.0F, 62.0F, 1.0F, 0.0F, false);
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
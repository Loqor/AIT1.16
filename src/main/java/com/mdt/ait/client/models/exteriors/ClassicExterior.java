package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.5.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.client.models.exteriors.BasicBox;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ClassicExterior extends BasicBox {
	public final ModelRenderer box;
	public final ModelRenderer base;
	public final ModelRenderer left_door;
	public final ModelRenderer right_door;

	public ClassicExterior() {
		texWidth = 512;
		texHeight = 512;

		box = new ModelRenderer(this);
		box.setPos(0.0F, 24.0F, 0.0F);
		

		base = new ModelRenderer(this);
		base.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(base);
		base.texOffs(0, 48).addBox(-20.0F, -3.0F, -20.0F, 40.0F, 3.0F, 40.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(-18.0F, -71.0F, -21.0F, 36.0F, 5.0F, 42.0F, 0.0F, false);
		base.texOffs(115, 0).addBox(-18.0F, -75.0F, -18.0F, 36.0F, 4.0F, 36.0F, 0.0F, false);
		base.texOffs(121, 48).addBox(-16.0F, -76.0F, -16.0F, 32.0F, 1.0F, 32.0F, 0.0F, false);
		base.texOffs(62, 193).addBox(-10.0F, -77.0F, -10.0F, 20.0F, 1.0F, 20.0F, 0.0F, false);
		base.texOffs(0, 92).addBox(-21.0F, -71.0F, -18.0F, 42.0F, 5.0F, 36.0F, 0.0F, false);
		base.texOffs(120, 97).addBox(-14.0F, -66.0F, -18.5F, 28.0F, 1.0F, 37.0F, 0.0F, false);
		base.texOffs(0, 134).addBox(-18.5F, -66.0F, -14.0F, 37.0F, 1.0F, 28.0F, 0.0F, false);
		base.texOffs(31, 164).addBox(-18.0F, -65.0F, 0.0F, 1.0F, 62.0F, 14.0F, 0.0F, false);
		base.texOffs(0, 164).addBox(-18.0F, -65.0F, -14.0F, 1.0F, 62.0F, 14.0F, 0.0F, false);
		base.texOffs(169, 213).addBox(-18.5F, -65.0F, -0.5F, 1.0F, 62.0F, 1.0F, 0.0F, false);
		base.texOffs(164, 213).addBox(-0.5F, -65.0F, 17.5F, 1.0F, 62.0F, 1.0F, 0.0F, false);
		base.texOffs(214, 136).addBox(0.0F, -65.0F, 17.0F, 14.0F, 62.0F, 1.0F, 0.0F, false);
		base.texOffs(62, 215).addBox(-14.0F, -65.0F, 17.0F, 14.0F, 62.0F, 1.0F, 0.0F, false);
		base.texOffs(159, 213).addBox(17.5F, -65.0F, -0.5F, 1.0F, 62.0F, 1.0F, 0.0F, false);
		base.texOffs(131, 136).addBox(17.0F, -65.0F, -14.0F, 1.0F, 62.0F, 14.0F, 0.0F, false);
		base.texOffs(162, 136).addBox(17.0F, -65.0F, 0.0F, 1.0F, 62.0F, 14.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(-4.5F, -79.0F, -4.5F, 9.0F, 2.0F, 9.0F, 0.0F, false);
		base.texOffs(0, 12).addBox(-4.0F, -86.0F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		base.texOffs(25, 22).addBox(-2.0F, -85.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		base.texOffs(0, 22).addBox(-3.0F, -86.75F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		base.texOffs(6, 30).addBox(-3.25F, -85.0F, -3.25F, 1.0F, 6.0F, 0.0F, 0.0F, false);
		base.texOffs(28, 0).addBox(-3.25F, -85.0F, 2.25F, 0.0F, 6.0F, 1.0F, 0.0F, false);
		base.texOffs(3, 30).addBox(2.25F, -85.0F, 3.25F, 1.0F, 6.0F, 0.0F, 0.0F, false);
		base.texOffs(25, 12).addBox(3.25F, -85.0F, -3.25F, 0.0F, 6.0F, 1.0F, 0.0F, false);
		base.texOffs(5, 12).addBox(-3.25F, -85.0F, -3.25F, 0.0F, 6.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 30).addBox(-3.25F, -85.0F, 3.25F, 1.0F, 6.0F, 0.0F, 0.0F, false);
		base.texOffs(5, 0).addBox(3.25F, -85.0F, 2.25F, 0.0F, 6.0F, 1.0F, 0.0F, false);
		base.texOffs(28, 12).addBox(2.25F, -85.0F, -3.25F, 1.0F, 6.0F, 0.0F, 0.0F, false);
		base.texOffs(193, 136).addBox(14.0F, -73.0F, -19.0F, 5.0F, 70.0F, 5.0F, 0.0F, false);
		base.texOffs(138, 213).addBox(-19.0F, -73.0F, -19.0F, 5.0F, 70.0F, 5.0F, 0.0F, false);
		base.texOffs(188, 212).addBox(-19.0F, -73.0F, 14.0F, 5.0F, 70.0F, 5.0F, 0.0F, false);
		base.texOffs(209, 207).addBox(14.0F, -73.0F, 14.0F, 5.0F, 70.0F, 5.0F, 0.0F, false);

		left_door = new ModelRenderer(this);
		left_door.setPos(-14.0F, -8.0F, -17.0F);
		left_door.texOffs(93, 215).addBox(0.0F, -33.0F, -1.0F, 14.0F, 62.0F, 1.0F, 0.0F, false);
		left_door.texOffs(0, 12).addBox(10.0F, -12.0F, -2.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		left_door.texOffs(174, 213).addBox(13.5F, -33.0F, -1.5F, 1.0F, 62.0F, 1.0F, 0.0F, false);

		right_door = new ModelRenderer(this);
		right_door.setPos(14.0F, -8.0F, -17.0F);
		right_door.texOffs(230, 200).addBox(-14.0F, -33.0F, -1.0F, 14.0F, 62.0F, 1.0F, 0.0F, false);
		right_door.texOffs(0, 0).addBox(-13.0F, -13.0F, -2.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		box.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		left_door.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		right_door.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
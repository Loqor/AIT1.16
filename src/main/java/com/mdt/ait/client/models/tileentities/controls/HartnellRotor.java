package com.mdt.ait.client.models.tileentities.controls;// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.HartnellRotorTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class HartnellRotor extends EntityModel<Entity> {
	public final ModelRenderer box;
	public final ModelRenderer casing;
	public final ModelRenderer rotor;
	public final ModelRenderer base;

	public HartnellRotor() {
		texWidth = 128;
		texHeight = 128;

		box = new ModelRenderer(this);
		box.setPos(0.0F, 24.0F, 0.0F);
		

		casing = new ModelRenderer(this);
		casing.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(casing);
		casing.texOffs(72, 0).addBox(-7.0F, -21.0F, -7.0F, 14.0F, 19.0F, 14.0F, 0.0F, false);

		rotor = new ModelRenderer(this);
		rotor.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(rotor);
		rotor.texOffs(0, 46).addBox(0.0F, -17.0F, -6.0F, 0.0F, 15.0F, 12.0F, 0.001F, false);
		rotor.texOffs(0, 58).addBox(-6.0F, -17.0F, 0.0F, 12.0F, 15.0F, 0.0F, 0.001F, false);
		rotor.texOffs(32, 61).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 4.0F, 8.0F, 0.0F, false);
		rotor.texOffs(65, 63).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 4.0F, 6.0F, 0.0F, false);

		base = new ModelRenderer(this);
		base.setPos(0.0F, 24.0F, 0.0F);
		base.texOffs(0, 29).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 16.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(HartnellRotorTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn,buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
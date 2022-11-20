package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.4.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.client.models.exteriors.BasicBox;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TARDIMExterior extends BasicBox {
	public final ModelRenderer box;
	public final ModelRenderer door;
	public final ModelRenderer base;

	public TARDIMExterior() {
		texWidth = 128;
		texHeight = 128;

		box = new ModelRenderer(this);
		box.setPos(6.5F, 24.0F, -9.5F);
		

		door = new ModelRenderer(this);
		door.setPos(0.0F, -16.0F, 0.0F);
		box.addChild(door);
		door.texOffs(0, 69).addBox(-14.5F, -16.0F, -1.5F, 16.0F, 32.0F, 3.0F, 0.0F, true);

		base = new ModelRenderer(this);
		base.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(base);
		base.texOffs(0, 104).addBox(-14.5F, -40.0F, 1.5F, 16.0F, 8.0F, 16.0F, 0.0F, false);
		base.texOffs(44, 56).addBox(-14.5F, 0.0F, 1.5F, 16.0F, 0.0F, 16.0F, 0.002F, false);
		base.texOffs(38, 56).addBox(-17.5F, -32.0F, 1.5F, 3.0F, 32.0F, 16.0F, 0.0F, true);
		base.texOffs(0, 34).addBox(-14.5F, -32.0F, 17.5F, 16.0F, 32.0F, 3.0F, 0.0F, true);
		base.texOffs(38, 56).addBox(1.5F, -32.0F, 1.5F, 3.0F, 32.0F, 16.0F, 0.0F, true);
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
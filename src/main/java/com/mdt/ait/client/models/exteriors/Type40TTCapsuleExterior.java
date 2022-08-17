package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Type40TTCapsuleExterior extends BasicBox {
	public final ModelRenderer box;
	public final ModelRenderer door_slat_1;
	public final ModelRenderer door_slat_2;
	public final ModelRenderer door_slat_3;
	public final ModelRenderer door_slat_4;
	public final ModelRenderer base;

	public Type40TTCapsuleExterior() {
		texWidth = 128;
		texHeight = 128;

		box = new ModelRenderer(this);
		box.setPos(0.0F, 0.0F, 0.0F);
		

		door_slat_1 = new ModelRenderer(this);
		door_slat_1.setPos(11.0F, 24.0F, -11.0F);
		box.addChild(door_slat_1);
		door_slat_1.texOffs(85, 70).addBox(-19.0F, -36.0F, 1.0F, 4.0F, 36.0F, 1.0F, 0.0F, false);

		door_slat_2 = new ModelRenderer(this);
		door_slat_2.setPos(11.0F, 24.0F, -11.0F);
		box.addChild(door_slat_2);
		door_slat_2.texOffs(0, 86).addBox(-15.0F, -36.0F, 1.0F, 4.0F, 36.0F, 1.0F, 0.0F, false);

		door_slat_3 = new ModelRenderer(this);
		door_slat_3.setPos(11.0F, 24.0F, -11.0F);
		box.addChild(door_slat_3);
		door_slat_3.texOffs(11, 86).addBox(-11.0F, -36.0F, 1.0F, 4.0F, 36.0F, 1.0F, 0.0F, false);

		door_slat_4 = new ModelRenderer(this);
		door_slat_4.setPos(11.0F, 24.0F, -11.0F);
		box.addChild(door_slat_4);
		door_slat_4.texOffs(22, 86).addBox(-7.0F, -36.0F, 1.0F, 4.0F, 36.0F, 1.0F, 0.0F, false);

		base = new ModelRenderer(this);
		base.setPos(11.0F, 24.0F, -11.0F);
		box.addChild(base);
		base.texOffs(0, 0).addBox(-23.0F, -48.0F, 2.0F, 24.0F, 48.0F, 21.0F, 0.0F, false);
		base.texOffs(70, 70).addBox(-3.0F, -36.0F, -1.0F, 4.0F, 36.0F, 3.0F, 0.0F, false);
		base.texOffs(55, 70).addBox(-23.0F, -36.0F, -1.0F, 4.0F, 36.0F, 3.0F, 0.0F, false);
		base.texOffs(0, 70).addBox(-23.0F, -48.0F, -1.0F, 24.0F, 12.0F, 3.0F, 0.0F, false);
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

	public void render(TardisTileEntity tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, tile.getAlpha());
	}
}
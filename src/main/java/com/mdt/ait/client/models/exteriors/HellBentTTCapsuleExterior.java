package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.client.models.exteriors.BasicBox;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class HellBentTTCapsuleExterior extends BasicBox {
	public final ModelRenderer box;
	public final ModelRenderer base;
	public final ModelRenderer right_door;
	public final ModelRenderer left_door;

	public HellBentTTCapsuleExterior() {
		texWidth = 256;
		texHeight = 256;

		box = new ModelRenderer(this);
		box.setPos(0.0F, -3.5F, 0.0F);
		

		base = new ModelRenderer(this);
		base.setPos(0.0F, 27.5F, 0.0F);
		box.addChild(base);
		base.texOffs(0, 37).addBox(-12.0F, -4.0F, -12.0F, 24.0F, 4.0F, 24.0F, 0.5F, false);
		base.texOffs(90, 66).addBox(-12.0F, -46.5F, 11.0F, 24.0F, 42.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(-12.0F, -59.0F, -12.0F, 24.0F, 12.0F, 24.0F, 0.5F, false);
		base.texOffs(116, 0).addBox(8.0F, -46.5F, -12.0F, 4.0F, 42.0F, 2.0F, 0.0F, false);
		base.texOffs(109, 110).addBox(-12.0F, -46.5F, -12.0F, 4.0F, 42.0F, 2.0F, 0.0F, false);
		base.texOffs(45, 66).addBox(-12.0F, -46.5F, -10.0F, 1.0F, 42.0F, 21.0F, 0.0F, false);
		base.texOffs(0, 66).addBox(11.0F, -46.5F, -10.0F, 1.0F, 42.0F, 21.0F, 0.0F, false);

		right_door = new ModelRenderer(this);
		right_door.setPos(8.0F, 1.0F, -10.0F);
		box.addChild(right_door);
		right_door.texOffs(90, 110).addBox(-8.0F, -20.0F, -1.0F, 8.0F, 42.0F, 1.0F, 0.0F, false);

		left_door = new ModelRenderer(this);
		left_door.setPos(-8.0F, 1.0F, -10.0F);
		box.addChild(left_door);
		left_door.texOffs(97, 0).addBox(0.0F, -20.0F, -1.0F, 8.0F, 42.0F, 1.0F, 0.0F, false);
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
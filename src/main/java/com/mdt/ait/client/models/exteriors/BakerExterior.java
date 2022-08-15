package com.mdt.ait.client.models.exteriors;


import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class BakerExterior extends BasicBox {
	public final ModelRenderer box;
	public final ModelRenderer lamp;
	public final ModelRenderer right_door;
	public final ModelRenderer left_door;

	public BakerExterior() {
		texWidth = 512;
		texHeight = 512;

		box = new ModelRenderer(this);
		box.setPos(0.0F, 24.0F, 0.0F);
		box.texOffs(124, 183).addBox(-14.0F, -56.0F, 16.0F, 14.0F, 54.0F, 1.0F, 0.0F, false);
		box.texOffs(0, 0).addBox(-19.0F, -2.0F, -19.0F, 38.0F, 2.0F, 38.0F, 0.0F, false);
		box.texOffs(34, 191).addBox(14.0F, -64.0F, 14.0F, 4.0F, 62.0F, 4.0F, 0.0F, false);
		box.texOffs(17, 191).addBox(-18.0F, -64.0F, 14.0F, 4.0F, 62.0F, 4.0F, 0.0F, false);
		box.texOffs(0, 191).addBox(-18.0F, -64.0F, -18.0F, 4.0F, 62.0F, 4.0F, 0.0F, false);
		box.texOffs(186, 127).addBox(14.0F, -64.0F, -18.0F, 4.0F, 62.0F, 4.0F, 0.0F, false);
		box.texOffs(93, 127).addBox(16.0F, -56.0F, 0.0F, 1.0F, 54.0F, 14.0F, 0.0F, false);
		box.texOffs(155, 183).addBox(0.0F, -56.0F, 16.0F, 14.0F, 54.0F, 1.0F, 0.0F, false);
		box.texOffs(66, 191).addBox(-0.5F, -56.0F, 16.5F, 1.0F, 54.0F, 1.0F, 0.0F, false);
		box.texOffs(62, 122).addBox(16.0F, -56.0F, -14.0F, 1.0F, 54.0F, 14.0F, 0.0F, false);
		box.texOffs(31, 122).addBox(-17.0F, -56.0F, -14.0F, 1.0F, 54.0F, 14.0F, 0.0F, false);
		box.texOffs(0, 122).addBox(-17.0F, -56.0F, 0.0F, 1.0F, 54.0F, 14.0F, 0.0F, false);
		box.texOffs(51, 191).addBox(-17.5F, -56.0F, -0.5F, 1.0F, 54.0F, 1.0F, 0.0F, false);
		box.texOffs(0, 40).addBox(-16.0F, -61.0F, -19.0F, 32.0F, 5.0F, 38.0F, 0.0F, false);
		box.texOffs(0, 84).addBox(-19.0F, -61.0F, -16.0F, 38.0F, 5.0F, 32.0F, 0.0F, false);
		box.texOffs(103, 40).addBox(-16.0F, -65.5F, -16.0F, 32.0F, 1.0F, 32.0F, 0.0F, false);
		box.texOffs(107, 88).addBox(-17.0F, -64.5F, -17.0F, 34.0F, 4.0F, 34.0F, 0.0F, false);
		box.texOffs(0, 0).addBox(-2.5F, -66.5F, -2.5F, 5.0F, 1.0F, 5.0F, 0.0F, false);
		box.texOffs(61, 191).addBox(16.5F, -56.0F, -0.5F, 1.0F, 54.0F, 1.0F, 0.0F, false);

		lamp = new ModelRenderer(this);
		lamp.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(lamp);
		lamp.texOffs(0, 7).addBox(-2.0F, -71.5F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		right_door = new ModelRenderer(this);
		right_door.setPos(14.0F, -35.0F, -16.0F);
		box.addChild(right_door);
		right_door.texOffs(155, 127).addBox(-14.0F, -21.0F, -1.0F, 14.0F, 54.0F, 1.0F, 0.0F, false);

		left_door = new ModelRenderer(this);
		left_door.setPos(-14.0F, -35.0F, -16.0F);
		box.addChild(left_door);
		left_door.texOffs(124, 127).addBox(0.0F, -21.0F, -1.0F, 14.0F, 54.0F, 1.0F, 0.0F, false);
		left_door.texOffs(56, 191).addBox(13.5F, -21.0F, -1.5F, 1.0F, 54.0F, 1.0F, 0.0F, false);
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
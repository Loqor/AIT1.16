package com.mdt.ait.client.models.tileentities;

import com.mdt.ait.common.tileentities.RampTile;
import com.mdt.ait.common.tileentities.TardisCoralTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TardisCoral extends EntityModel<Entity> {
	public final ModelRenderer bone;

	public TardisCoral() {
		texWidth = 128;
		texHeight = 128;

		bone = new ModelRenderer(this);
		bone.setPos(0.0F, 24.0F, 0.0F);
		bone.texOffs(0, 45).addBox(-19.0F, -32.0F, 0.0F, 38.0F, 32.0F, 0.0F, 0.0F, false);
		bone.texOffs(0, 7).addBox(0.0F, -32.0F, -19.0F, 0.0F, 32.0F, 38.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(TardisCoralTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, i, i1, i2, i3);
	}
}
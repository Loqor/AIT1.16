package com.mdt.ait.client.models.tileentities;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.ArsEggTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ArsEgg extends EntityModel<Entity> {
	public final ModelRenderer egg;
	public final ModelRenderer root;

	public ArsEgg() {
		texWidth = 64;
		texHeight = 64;

		egg = new ModelRenderer(this);
		egg.setPos(0.0F, 24.0F, 0.0F);
		egg.texOffs(0, 0).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 8.0F, 6.0F, 0.0F, false);
		egg.texOffs(24, 0).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 2.0F, 6.0F, -0.25F, false);

		root = new ModelRenderer(this);
		root.setPos(0.0F, 24.0F, 0.0F);
		root.texOffs(0, 24).addBox(-3.0F, -16.5F, 0.0F, 6.0F, 8.0F, 0.0F, 0.001F, false);
		root.texOffs(19, 18).addBox(0.0F, -16.5F, -3.0F, 0.0F, 8.0F, 6.0F, 0.001F, false);
		root.texOffs(19, 9).addBox(-3.0F, -8.25F, -3.0F, 6.0F, 2.0F, 6.0F, 0.25F, false);
		root.texOffs(11, 31).addBox(-1.0F, -16.5F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		egg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		root.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(ArsEggTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
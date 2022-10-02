package com.mdt.ait.client.models.tileentities;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.GBTCasingTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class GBTCasing extends EntityModel<Entity> {
	public final ModelRenderer base;
	public final ModelRenderer spin;
	public final ModelRenderer cable;

	public GBTCasing() {
		texWidth = 256;
		texHeight = 256;

		base = new ModelRenderer(this);
		base.setPos(0.0F, 24.0F, 5.0F);
		base.texOffs(0, 0).addBox(-24.0F, -48.0F, -29.0F, 48.0F, 48.0F, 48.0F, 0.0F, false);

		spin = new ModelRenderer(this);
		spin.setPos(11.5F, -20.0F, 11.5F);
		base.addChild(spin);
		spin.texOffs(12, 107).addBox(-2.5F, -9.0F, 0.0F, 5.0F, 9.0F, 0.0F, 0.01F, false);
		spin.texOffs(78, 130).addBox(0.0F, -9.0F, -2.5F, 0.0F, 9.0F, 5.0F, 0.01F, false);

		cable = new ModelRenderer(this);
		cable.setPos(0.0F, 0.0F, -5.0F);
		base.addChild(cable);
		cable.texOffs(96, 192).addBox(9.0F, -11.0F, 14.0F, 5.0F, 5.0F, 10.0F, 0.0F, false);
		cable.texOffs(8, 126).addBox(8.0F, -10.0F, 14.0F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		cable.texOffs(134, 114).addBox(14.0F, -10.0F, 14.0F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		cable.texOffs(47, 168).addBox(9.0F, -20.0F, 14.0F, 5.0F, 9.0F, 5.0F, 0.0F, false);
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

	public void render(GBTCasingTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn,buffer,combinedLight,combinedOverlay,1,1,1,1);
	}
}
package com.mdt.ait.client.models.tileentities;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.ToyotaRotorTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ToyotaRotor extends EntityModel<Entity> {
	public final ModelRenderer top;
	public final ModelRenderer bone;
	public final ModelRenderer toppipe;
	public final ModelRenderer bone3;
	public final ModelRenderer bottom;

	public ToyotaRotor() {
		texWidth = 128;
		texHeight = 128;

		top = new ModelRenderer(this);
		top.setPos(0.0F, 24.0F, 16.0F);
		top.texOffs(90, 92).addBox(1.25F, -49.5F, -13.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		top.texOffs(72, 92).addBox(3.5F, -49.5F, -17.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		top.texOffs(63, 92).addBox(-5.5F, -49.5F, -17.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		top.texOffs(63, 92).addBox(-3.5F, -49.5F, -13.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		top.texOffs(88, 63).addBox(-3.5F, -49.5F, -21.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		top.texOffs(45, 80).addBox(1.5F, -49.5F, -21.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		top.texOffs(116, 40).addBox(3.0F, -48.0F, -17.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);
		top.texOffs(116, 40).addBox(0.75F, -48.0F, -13.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);
		top.texOffs(116, 40).addBox(-4.0F, -48.0F, -13.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);
		top.texOffs(116, 40).addBox(1.0F, -48.0F, -21.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);
		top.texOffs(116, 40).addBox(-4.0F, -48.0F, -21.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);
		top.texOffs(116, 40).addBox(-6.0F, -48.0F, -17.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setPos(8.0F, 8.0F, -8.0F);
		bone.texOffs(45, 44).addBox(-16.0F, -32.0F, 0.0F, 16.0F, 2.0F, 16.0F, 0.0F, false);
		bone.texOffs(61, 0).addBox(-16.0F, 14.0F, 0.0F, 16.0F, 2.0F, 16.0F, 0.0F, false);
		bone.texOffs(0, 0).addBox(-15.5F, -30.0F, 0.5F, 15.0F, 44.0F, 15.0F, 0.005F, false);
		bone.texOffs(112, 71).addBox(-10.0F, -32.0F, 6.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		toppipe = new ModelRenderer(this);
		toppipe.setPos(0.0F, 24.0F, 0.0F);
		toppipe.texOffs(112, 112).addBox(-1.0F, -36.0F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setPos(0.0F, 24.0F, 0.0F);
		bone3.texOffs(112, 112).addBox(-1.0F, -22.0F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);
		bone3.texOffs(112, 87).addBox(-2.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		bottom = new ModelRenderer(this);
		bottom.setPos(0.0F, -28.0F, 16.0F);
		bottom.texOffs(61, 63).addBox(1.25F, 28.5F, -13.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		bottom.texOffs(61, 63).addBox(3.5F, 28.5F, -17.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		bottom.texOffs(61, 63).addBox(-5.5F, 28.5F, -17.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		bottom.texOffs(61, 63).addBox(-3.5F, 28.5F, -13.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		bottom.texOffs(61, 63).addBox(-3.5F, 28.5F, -21.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		bottom.texOffs(61, 63).addBox(1.5F, 28.5F, -21.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		bottom.texOffs(116, 55).addBox(-4.0F, 40.0F, -13.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);
		bottom.texOffs(116, 55).addBox(0.75F, 40.0F, -13.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);
		bottom.texOffs(116, 55).addBox(1.0F, 40.0F, -21.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);
		bottom.texOffs(116, 55).addBox(-4.0F, 40.0F, -21.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);
		bottom.texOffs(116, 55).addBox(-6.0F, 40.0F, -17.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);
		bottom.texOffs(116, 55).addBox(3.0F, 40.0F, -17.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		top.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bottom.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(ToyotaRotorTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
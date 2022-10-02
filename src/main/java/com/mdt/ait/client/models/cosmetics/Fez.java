package com.mdt.ait.client.models.cosmetics;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class Fez extends AgeableModel<LivingEntity> {
	private final ModelRenderer fez;
	private final ModelRenderer cube_r1;

	public Fez() {
		texWidth = 32;
		texHeight = 32;

		fez = new ModelRenderer(this);
		fez.setPos(1.0F, 24.0F, 1.0F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		fez.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.215F, -0.0376F, -0.1705F);
		cube_r1.texOffs(0, 10).addBox(0.65F, -35.6F, -7.9F, 4.0F, 0.0F, 4.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(0.75F, -35.5F, -8.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		cube_r1.texOffs(13, 11).addBox(0.65F, -35.6F, -7.9F, 0.0F, 5.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(LivingEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

	}

	@Override
	protected Iterable<ModelRenderer> headParts() {
		return ImmutableList.of(fez);
	}

	@Override
	protected Iterable<ModelRenderer> bodyParts() {
		return ImmutableList.of();
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		fez.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
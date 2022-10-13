package com.mdt.ait.client.models.cosmetics;// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class AngelWings<T extends LivingEntity> extends AgeableModel<T> {
	public final ModelRenderer right_base;
	public final ModelRenderer right_tip;
	public final ModelRenderer cube_r1;
	public final ModelRenderer left_base;
	public final ModelRenderer cube_r2;
	public final ModelRenderer left_tip;
	public final ModelRenderer cube_r3;

	public AngelWings() {
		texWidth = 256;
		texHeight = 256;

		right_base = new ModelRenderer(this);
		right_base.setPos(-1.0F, 8.0F, 3.0F);
		right_base.texOffs(0, 33).addBox(0.0F, -19.0F, 0.0F, 32.0F, 32.0F, 0.0F, 0.001F, false);

		right_tip = new ModelRenderer(this);
		right_tip.setPos(32.0F, 0.0F, 0.0F);
		right_base.addChild(right_tip);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 13.0F, 0.0F);
		right_tip.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -0.6545F, 0.0F);
		cube_r1.texOffs(0, 0).addBox(0.0F, -32.0F, 0.0F, 32.0F, 32.0F, 0.0F, 0.001F, true);

		left_base = new ModelRenderer(this);
		left_base.setPos(1.0F, 8.0F, 3.25F);
		

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(-39.0F, 13.0F, 0.75F);
		left_base.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 3.1416F, 0.0F);
		cube_r2.texOffs(0, 33).addBox(-39.0F, -32.0F, 1.0F, 32.0F, 32.0F, 0.0F, 0.001F, false);

		left_tip = new ModelRenderer(this);
		left_tip.setPos(-32.0F, 0.0F, -0.25F);
		left_base.addChild(left_tip);
		

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(24.0F, 13.0F, 0.0F);
		left_tip.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -2.3998F, 0.0F);
		cube_r3.texOffs(0, 0).addBox(17.5F, -32.0F, 16.25F, 32.0F, 32.0F, 0.0F, 0.001F, true);
	}

	@Override
	public void setupAnim(T pEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//Make wing idle animations here
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		right_base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		left_base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected Iterable<ModelRenderer> headParts() {
		return ImmutableList.of();
	}

	@Override
	protected Iterable<ModelRenderer> bodyParts() {
		return ImmutableList.of(this.right_base, this.left_base);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
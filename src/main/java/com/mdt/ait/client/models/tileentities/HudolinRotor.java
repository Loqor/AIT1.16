package com.mdt.ait.client.models.tileentities;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.HudolinRotorTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class HudolinRotor extends EntityModel<Entity> {
	public final ModelRenderer bottom;
	public final ModelRenderer cube_r1;
	public final ModelRenderer top;
	public final ModelRenderer cube_r2;
	public final ModelRenderer bone;

	public HudolinRotor() {
		texWidth = 128;
		texHeight = 128;

		bottom = new ModelRenderer(this);
		bottom.setPos(0.0F, 24.0F, 0.0F);
		bottom.texOffs(58, 19).addBox(-7.5F, -8.0F, -7.5F, 15.0F, 1.0F, 15.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, -16.0F, 0.0F);
		bottom.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.7854F, 0.0F);
		cube_r1.texOffs(61, 63).addBox(-6.5F, -2.0F, -1.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(70, 63).addBox(-5.0F, -2.0F, 3.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(79, 63).addBox(-5.0F, -2.0F, -5.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(0, 80).addBox(-1.0F, -2.0F, 4.5F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(9, 80).addBox(-1.0F, -2.0F, -6.5F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(18, 80).addBox(4.5F, -2.0F, -1.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(27, 80).addBox(3.0F, -2.0F, -5.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(36, 80).addBox(3.0F, -2.0F, 3.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);

		top = new ModelRenderer(this);
		top.setPos(0.0F, 24.0F, 16.0F);
		top.texOffs(0, 63).addBox(-7.5F, -41.0F, -23.5F, 15.0F, 1.0F, 15.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, -16.0F, -16.0F);
		top.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -0.3927F, 0.0F);
		cube_r2.texOffs(45, 80).addBox(3.0F, -40.0F, -5.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		cube_r2.texOffs(88, 63).addBox(-5.0F, -40.0F, -5.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		cube_r2.texOffs(54, 90).addBox(-1.0F, -40.0F, -6.5F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		cube_r2.texOffs(63, 92).addBox(-6.5F, -40.0F, -1.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		cube_r2.texOffs(72, 92).addBox(4.5F, -40.0F, -1.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		cube_r2.texOffs(81, 92).addBox(-5.0F, -40.0F, 3.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		cube_r2.texOffs(90, 92).addBox(3.0F, -40.0F, 3.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);
		cube_r2.texOffs(97, 63).addBox(-1.0F, -40.0F, 4.5F, 2.0F, 26.0F, 2.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setPos(8.0F, 8.0F, -8.0F);
		bone.texOffs(45, 44).addBox(-16.0F, -32.0F, 0.0F, 16.0F, 2.0F, 16.0F, 0.0F, false);
		bone.texOffs(61, 0).addBox(-16.0F, 14.0F, 0.0F, 16.0F, 2.0F, 16.0F, 0.0F, false);
		bone.texOffs(0, 0).addBox(-15.5F, -30.0F, 0.5F, 15.0F, 44.0F, 15.0F, 0.005F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		//bottom.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		//top.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(HudolinRotorTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
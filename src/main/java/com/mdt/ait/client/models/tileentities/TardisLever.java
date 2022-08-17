package com.mdt.ait.client.models.tileentities;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.client.renderers.tileentities.TardisLeverRenderer;
import com.mdt.ait.common.tileentities.TardisLeverTile;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TardisLever extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer cube_r1;
	private final ModelRenderer bb_main;

	public TardisLever() {
		texWidth = 64;
		texHeight = 64;

		bone = new ModelRenderer(this);
		bone.setPos(0.0F, 21.0F, 3.9822F);
		setRotationAngle(bone, -0.5236F, 0.0F, 0.0F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(8.0F, 5.0F, -12.0F);
		bone.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.7854F, 0.0F, 0.0F);
		cube_r1.texOffs(5, 43).addBox(-12.5F, -3.0F, 11.75F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 26).addBox(-13.5F, -6.0F, 10.75F, 11.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r1.texOffs(0, 43).addBox(-4.5F, -3.0F, 11.75F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(42, 40).addBox(-4.5F, 4.0F, 10.75F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r1.texOffs(40, 18).addBox(-12.5F, 4.0F, 10.75F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);
		bb_main.texOffs(0, 0).addBox(-8.0F, -1.0F, -8.0178F, 16.0F, 1.0F, 16.0F, 0.0F, false);
		bb_main.texOffs(40, 26).addBox(6.5F, -5.0F, 1.9822F, 1.0F, 4.0F, 5.0F, 0.0F, false);
		bb_main.texOffs(21, 38).addBox(4.5F, -5.0F, 1.9822F, 1.0F, 4.0F, 5.0F, 0.0F, false);
		bb_main.texOffs(32, 33).addBox(2.5F, -5.0F, 1.9822F, 1.0F, 4.0F, 5.0F, 0.0F, false);
		bb_main.texOffs(13, 33).addBox(0.5F, -5.0F, 1.9822F, 1.0F, 4.0F, 5.0F, 0.0F, false);
		bb_main.texOffs(0, 33).addBox(-1.5F, -5.0F, 1.9822F, 1.0F, 4.0F, 5.0F, 0.0F, false);
		bb_main.texOffs(32, 21).addBox(-3.5F, -5.0F, 1.9822F, 1.0F, 4.0F, 5.0F, 0.0F, false);
		bb_main.texOffs(24, 28).addBox(-5.5F, -5.0F, 1.9822F, 1.0F, 4.0F, 5.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(-7.5F, -5.0F, 1.9822F, 1.0F, 4.0F, 5.0F, 0.0F, false);
		bb_main.texOffs(0, 18).addBox(-6.5F, -4.0F, 2.4822F, 13.0F, 3.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(TardisLeverTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
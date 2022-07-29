package com.mdt.ait.client.models.tileentities;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.TypewriterTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Typewriter extends EntityModel<Entity> {
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;

	public Typewriter() {
		texWidth = 128;
		texHeight = 128;

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);
		bb_main.texOffs(0, 0).addBox(-7.0F, 0.0F, -6.0F, 14.0F, 0.0F, 12.0F, 0.001F, false);
		bb_main.texOffs(0, 36).addBox(-7.0F, -6.0F, -6.0F, 0.0F, 6.0F, 12.0F, 0.001F, false);
		bb_main.texOffs(35, 24).addBox(7.0F, -6.0F, -6.0F, 0.0F, 6.0F, 12.0F, 0.001F, false);
		bb_main.texOffs(13, 43).addBox(-7.0F, -3.0F, -6.0F, 14.0F, 3.0F, 0.0F, 0.001F, false);
		bb_main.texOffs(38, 13).addBox(-7.0F, -3.0F, 0.0F, 14.0F, 3.0F, 3.0F, 0.0F, false);
		bb_main.texOffs(41, 8).addBox(-7.0F, -3.0F, 6.0F, 14.0F, 3.0F, 0.0F, 0.001F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.7854F, 0.0F, 0.0F);
		cube_r1.texOffs(0, 26).addBox(-7.0F, -1.75F, 2.0F, 14.0F, 0.0F, 9.0F, 0.0F, false);
		cube_r1.texOffs(38, 20).addBox(-7.0F, -2.5F, 4.5F, 14.0F, 0.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 13).addBox(-7.0F, -1.0F, 2.0F, 14.0F, 3.0F, 9.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, 1.2701F, -0.1891F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, -1.2217F, 0.0F, 0.0F);
		cube_r2.texOffs(41, 0).addBox(-7.0F, -3.0F, -6.0F, 14.0F, 7.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(TypewriterTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
package com.mdt.ait.client.models.tileentities.controls;// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.TardisPowerAccessPointTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TardisPowerAccessPoint extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer bb_main;

	public TardisPowerAccessPoint() {
		texWidth = 64;
		texHeight = 64;

		bone = new ModelRenderer(this);
		bone.setPos(0.0F, 16.0F, 0.0F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		bone.addChild(cube_r1);
		setRotationAngle(cube_r1, -1.5708F, -0.7854F, 1.5708F);
		cube_r1.texOffs(0, 0).addBox(-7.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.001F, false);
		cube_r1.texOffs(25, 36).addBox(7.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.001F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, 0.0F, 0.0F);
		bone.addChild(cube_r2);
		setRotationAngle(cube_r2, 1.5708F, -0.7854F, -1.5708F);
		cube_r2.texOffs(29, 0).addBox(7.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.001F, false);
		cube_r2.texOffs(38, 36).addBox(-7.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.001F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, 0.0F, 0.0F);
		bone.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.7854F);
		cube_r3.texOffs(42, 0).addBox(-7.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.001F, false);
		cube_r3.texOffs(45, 26).addBox(7.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.001F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(0.0F, 0.0F, 0.0F);
		bone.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.7854F);
		cube_r4.texOffs(45, 13).addBox(7.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.001F, false);
		cube_r4.texOffs(45, 43).addBox(-7.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.001F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(0.0F, 8.0F, 0.0F);
		bone.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.7854F, 0.0F);
		cube_r5.texOffs(25, 49).addBox(7.0F, -11.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.001F, false);
		cube_r5.texOffs(52, 50).addBox(-7.0F, -11.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.001F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.0F, 8.0F, 0.0F);
		bone.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, -0.7854F, 0.0F);
		cube_r6.texOffs(38, 50).addBox(-7.0F, -11.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.001F, false);
		cube_r6.texOffs(52, 33).addBox(7.0F, -11.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.001F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);
		bb_main.texOffs(0, 23).addBox(-8.0F, -11.0F, -3.0F, 16.0F, 6.0F, 6.0F, 0.0F, false);
		bb_main.texOffs(0, 36).addBox(-3.0F, -16.0F, -3.0F, 6.0F, 16.0F, 6.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(-3.0F, -11.0F, -8.0F, 6.0F, 6.0F, 16.0F, 0.0F, false);
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

	public void render(TardisPowerAccessPointTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, i, i1, i2, i3);
	}
}
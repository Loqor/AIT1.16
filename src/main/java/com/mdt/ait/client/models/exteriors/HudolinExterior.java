package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class HudolinExterior extends BasicBox {
	public final ModelRenderer box;
	public final ModelRenderer base;
	public final ModelRenderer cube_r1;
	public final ModelRenderer cube_r2;
	public final ModelRenderer right_door;
	public final ModelRenderer left_door;

	public HudolinExterior() {
		texWidth = 512;
		texHeight = 512;

		box = new ModelRenderer(this);
		box.setPos(0.0F, -11.0F, 0.25F);
		

		base = new ModelRenderer(this);
		base.setPos(-19.0F, 35.0F, 19.0F);
		box.addChild(base);
		base.texOffs(149, 0).addBox(0.0F, -3.0F, -38.0F, 38.0F, 3.0F, 38.0F, 0.0F, false);
		base.texOffs(0, 281).addBox(1.0F, -67.0F, -37.0F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		base.texOffs(96, 212).addBox(1.0F, -67.0F, -5.0F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		base.texOffs(79, 212).addBox(33.0F, -67.0F, -5.0F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		base.texOffs(62, 212).addBox(33.0F, -67.0F, -37.0F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(2.0F, -66.0F, -39.0F, 34.0F, 5.0F, 40.0F, 0.0F, false);
		base.texOffs(0, 46).addBox(-1.0F, -66.0F, -36.0F, 40.0F, 5.0F, 34.0F, 0.0F, false);
		base.texOffs(149, 46).addBox(2.0F, -69.0F, -36.0F, 34.0F, 5.0F, 34.0F, 0.0F, false);
		base.texOffs(0, 86).addBox(5.0F, -64.0F, -36.5F, 28.0F, 5.0F, 35.0F, 0.0F, false);
		base.texOffs(59, 127).addBox(2.0F, -59.0F, -33.0F, 1.0F, 56.0F, 28.0F, 0.0F, false);
		base.texOffs(118, 127).addBox(5.0F, -59.0F, -3.0F, 28.0F, 56.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 127).addBox(35.0F, -59.0F, -33.0F, 1.0F, 56.0F, 28.0F, 0.0F, false);
		base.texOffs(32, 281).addBox(1.5F, -59.0F, -19.5F, 1.0F, 56.0F, 1.0F, 0.0F, false);
		base.texOffs(27, 281).addBox(18.5F, -59.0F, -2.5F, 1.0F, 56.0F, 1.0F, 0.0F, false);
		base.texOffs(22, 281).addBox(35.5F, -59.0F, -19.5F, 1.0F, 56.0F, 1.0F, 0.0F, false);
		base.texOffs(97, 360).addBox(21.75F, -78.0F, -22.0F, 0.0F, 5.0F, 1.0F, 0.001F, false);
		base.texOffs(114, 292).addBox(17.5F, -74.0F, -20.75F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		base.texOffs(114, 292).addBox(17.5F, -78.0F, -20.75F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		base.texOffs(60, 360).addBox(17.0F, -77.0F, -21.25F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		base.texOffs(48, 312).addBox(16.0F, -73.0F, -22.25F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		base.texOffs(75, 307).addBox(15.0F, -72.0F, -23.25F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		base.texOffs(69, 333).addBox(16.0F, -79.0F, -22.25F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		base.texOffs(112, 326).addBox(16.25F, -78.0F, -22.0F, 1.0F, 5.0F, 0.0F, 0.001F, false);
		base.texOffs(129, 353).addBox(16.25F, -78.0F, -17.5F, 0.0F, 5.0F, 1.0F, 0.001F, false);
		base.texOffs(116, 320).addBox(16.25F, -78.0F, -22.0F, 0.0F, 5.0F, 1.0F, 0.001F, false);
		base.texOffs(86, 322).addBox(16.25F, -78.0F, -16.5F, 1.0F, 5.0F, 0.0F, 0.001F, false);
		base.texOffs(94, 349).addBox(21.75F, -78.0F, -17.5F, 0.0F, 5.0F, 1.0F, 0.001F, false);
		base.texOffs(140, 348).addBox(20.75F, -78.0F, -22.0F, 1.0F, 5.0F, 0.0F, 0.001F, false);
		base.texOffs(98, 335).addBox(20.75F, -78.0F, -16.5F, 1.0F, 5.0F, 0.0F, 0.001F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(19.0F, -68.5F, -19.0F);
		base.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
		cube_r1.texOffs(254, 86).addBox(-16.0F, -2.5F, -16.0F, 32.0F, 5.0F, 32.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(21.0F, -62.0F, -57.0F);
		base.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -1.5708F, 0.0F);
		cube_r2.texOffs(127, 86).addBox(24.0F, -2.0F, -15.5F, 28.0F, 5.0F, 35.0F, 0.0F, false);

		right_door = new ModelRenderer(this);
		right_door.setPos(14.0F, 4.0F, -16.0F);
		box.addChild(right_door);
		right_door.texOffs(31, 212).addBox(-14.0F, -28.0F, -1.0F, 14.0F, 56.0F, 1.0F, 0.0F, false);
		right_door.texOffs(34, 350).addBox(-13.0F, -8.0F, -1.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		right_door.texOffs(34, 350).addBox(-13.0F, -10.0F, -1.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		left_door = new ModelRenderer(this);
		left_door.setPos(-14.0F, 6.0F, -16.25F);
		box.addChild(left_door);
		left_door.texOffs(0, 212).addBox(0.0F, -30.0F, -0.75F, 14.0F, 56.0F, 1.0F, 0.0F, false);
		left_door.texOffs(39, 350).addBox(2.0F, -10.5F, -1.25F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		left_door.texOffs(17, 281).addBox(13.5F, -30.0F, -1.25F, 1.0F, 56.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		box.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
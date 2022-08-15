package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MintExterior extends BasicBox {
	public final ModelRenderer right_door;
	private final ModelRenderer cube_r1;
	public final ModelRenderer left_door;
	private final ModelRenderer cube_r2;
	private final ModelRenderer base;
	private final ModelRenderer cube_r3;

	public MintExterior() {
		texWidth = 512;
		texHeight = 512;

		right_door = new ModelRenderer(this);
		right_door.setPos(14.0F, -9.0F, -17.0F);
		right_door.texOffs(0, 17).addBox(-13.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		right_door.texOffs(0, 12).addBox(-13.0F, 1.0F, -0.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(-34.0F, 33.0F, -3.0F);
		right_door.addChild(cube_r1);
		setRotationAngle(cube_r1, -3.1416F, 0.0F, 3.1416F);
		cube_r1.texOffs(174, 116).addBox(-34.0F, -59.0F, -4.0F, 14.0F, 56.0F, 1.0F, 0.0F, false);

		left_door = new ModelRenderer(this);
		left_door.setPos(-14.0F, -9.0F, -17.0F);
		left_door.texOffs(5, 17).addBox(3.0F, -7.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		left_door.texOffs(126, 200).addBox(13.5F, -26.0F, -0.75F, 1.0F, 56.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(-6.0F, 33.0F, -3.0F);
		left_door.addChild(cube_r2);
		setRotationAngle(cube_r2, -3.1416F, 0.0F, 3.1416F);
		cube_r2.texOffs(174, 173).addBox(-20.0F, -59.0F, -4.0F, 14.0F, 56.0F, 1.0F, 0.0F, false);

		base = new ModelRenderer(this);
		base.setPos(32.0F, 23.0F, -8.0F);
		base.texOffs(0, 0).addBox(-51.0F, -2.0F, -11.0F, 38.0F, 3.0F, 38.0F, 0.0F, false);
		base.texOffs(106, 200).addBox(-18.0F, -66.0F, -10.0F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		base.texOffs(90, 180).addBox(-50.0F, -66.0F, -10.0F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		base.texOffs(74, 180).addBox(-50.0F, -66.0F, 22.0F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		base.texOffs(58, 180).addBox(-18.0F, -66.0F, 22.0F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		base.texOffs(110, 84).addBox(-49.0F, -67.0F, -6.0F, 34.0F, 4.0F, 28.0F, 0.0F, false);
		base.texOffs(114, 7).addBox(-46.0F, -67.0F, -9.0F, 28.0F, 4.0F, 3.0F, 0.0F, false);
		base.texOffs(114, 0).addBox(-46.0F, -67.0F, 22.0F, 28.0F, 4.0F, 3.0F, 0.0F, false);
		base.texOffs(106, 41).addBox(-48.0F, -68.0F, -8.0F, 32.0F, 2.0F, 32.0F, 0.0F, false);
		base.texOffs(0, 84).addBox(-51.0F, -63.0F, -9.0F, 38.0F, 5.0F, 34.0F, 0.0F, false);
		base.texOffs(134, 200).addBox(-32.5F, -58.0F, 24.75F, 1.0F, 56.0F, 1.0F, 0.0F, false);
		base.texOffs(130, 200).addBox(-15.25F, -58.0F, 7.5F, 1.0F, 56.0F, 1.0F, 0.0F, false);
		base.texOffs(122, 200).addBox(-49.75F, -58.0F, 7.5F, 1.0F, 56.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 11).addBox(-34.0F, -69.0F, 6.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		base.texOffs(116, 116).addBox(-16.0F, -58.0F, -6.0F, 1.0F, 56.0F, 28.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(-34.5F, -75.0F, 5.5F, 5.0F, 6.0F, 5.0F, 0.0F, false);
		base.texOffs(58, 123).addBox(-46.0F, -58.0F, 24.0F, 28.0F, 56.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 123).addBox(-49.0F, -58.0F, -6.0F, 1.0F, 56.0F, 28.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(-12.0F, 1.0F, -12.0F);
		base.addChild(cube_r3);
		setRotationAngle(cube_r3, -3.1416F, 0.0F, 3.1416F);
		cube_r3.texOffs(0, 41).addBox(3.0F, -64.0F, -39.0F, 34.0F, 5.0F, 38.0F, 0.0F, false);
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		right_door.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		left_door.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void render(TardisTileEntity tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, tile.getAlpha());
	}
}
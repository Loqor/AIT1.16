package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ClockExterior extends BasicBox {
	public final ModelRenderer bone4;
	public final ModelRenderer bone;
	public final ModelRenderer bone2;
	public final ModelRenderer bone3;
	public final ModelRenderer door;

	public ClockExterior() {
		texWidth = 128;
		texHeight = 128;

		bone4 = new ModelRenderer(this);
		bone4.setPos(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone4, 0.0F, 1.5708F, 0.0F);
		

		bone = new ModelRenderer(this);
		bone.setPos(0.0F, 0.0F, 0.0F);
		bone4.addChild(bone);
		bone.texOffs(40, 0).addBox(-5.0F, -2.0F, -8.0F, 10.0F, 2.0F, 16.0F, 0.0F, false);
		bone.texOffs(57, 34).addBox(-5.0F, -3.0F, -8.0F, 10.0F, 1.0F, 16.0F, 0.001F, false);
		bone.texOffs(25, 27).addBox(-4.5F, -11.0F, -7.5F, 9.0F, 8.0F, 15.0F, 0.0F, false);
		bone.texOffs(80, 115).addBox(4.5F, -7.0F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone.texOffs(36, 51).addBox(-5.0F, -12.0F, -8.0F, 10.0F, 1.0F, 16.0F, 0.0F, false);
		bone.texOffs(0, 50).addBox(-5.0F, -42.0F, -8.0F, 10.0F, 1.0F, 16.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setPos(0.0F, 0.0F, 0.0F);
		bone4.addChild(bone2);
		bone2.texOffs(0, 0).addBox(-3.5F, -41.0F, -6.5F, 6.0F, 29.0F, 13.0F, 0.0F, false);
		bone2.texOffs(102, -13).addBox(0.5F, -41.0F, -6.5F, 0.0F, 29.0F, 13.0F, 0.0F, false);
		bone2.texOffs(0, 67).addBox(-3.5F, -55.0F, -6.5F, 7.0F, 13.0F, 13.0F, 0.0F, false);
		bone2.texOffs(0, 102).addBox(2.25F, -55.0F, -4.5F, 1.0F, 12.0F, 9.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setPos(0.0F, 0.0F, 0.0F);
		bone4.addChild(bone3);
		bone3.texOffs(74, 54).addBox(-4.0F, -58.0F, -7.0F, 8.0F, 3.0F, 14.0F, 0.0F, false);
		bone3.texOffs(58, 18).addBox(2.5F, -62.0F, -6.5F, 2.0F, 3.0F, 13.0F, 0.0F, false);
		bone3.texOffs(27, 0).addBox(2.5F, -64.0F, -4.5F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		bone3.texOffs(40, 68).addBox(-4.5F, -60.025F, -7.5F, 9.0F, 2.0F, 15.0F, 0.0F, false);

		door = new ModelRenderer(this);
		door.setPos(2.5F, -27.0F, -6.5F);
		bone4.addChild(door);
		door.texOffs(47, 86).addBox(0.0F, -14.0F, 0.0F, 1.0F, 29.0F, 13.0F, 0.0F, false);
		door.texOffs(88, 86).addBox(-0.75F, -14.0F, 2.0F, 1.0F, 29.0F, 9.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bone4.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(TardisTileEntity tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, tile.getAlpha());
	}
}
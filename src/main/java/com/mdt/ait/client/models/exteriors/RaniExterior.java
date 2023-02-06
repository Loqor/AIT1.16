package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.4.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.mdt.ait.common.tiles.TARDISTileEntity;
import io.mdt.ait.tardis.exterior.model.BasicBoxModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class RaniExterior extends BasicBoxModel {
	public final ModelRenderer box;
	public final ModelRenderer walls;
	public final ModelRenderer roof;
	public final ModelRenderer door;

	public RaniExterior() {
		texWidth = 512;
		texHeight = 512;

		box = new ModelRenderer(this);
		box.setPos(0.0F, 24.0F, 0.0F);
		box.texOffs(115, 56).addBox(-20.5F, -4.0F, -14.5F, 41.0F, 4.0F, 29.0F, 0.0F, false);

		walls = new ModelRenderer(this);
		walls.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(walls);
		walls.texOffs(0, 0).addBox(-19.0F, -64.0F, -12.5F, 38.0F, 60.0F, 25.0F, 0.0F, false);
		walls.texOffs(0, 145).addBox(12.5F, -64.0F, -13.5F, 5.0F, 60.0F, 27.0F, 0.0F, false);
		walls.texOffs(103, 121).addBox(-17.5F, -64.0F, -13.5F, 5.0F, 60.0F, 27.0F, 0.0F, false);

		roof = new ModelRenderer(this);
		roof.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(roof);
		roof.texOffs(117, 89).addBox(-20.5F, -67.0F, -14.5F, 41.0F, 3.0F, 29.0F, 0.0F, false);
		roof.texOffs(0, 85).addBox(-21.0F, -69.5F, -15.5F, 42.0F, 2.0F, 31.0F, 0.0F, false);
		roof.texOffs(0, 118).addBox(-19.5F, -67.5F, -13.5F, 39.0F, 1.0F, 26.0F, 0.0F, false);

		door = new ModelRenderer(this);
		door.setPos(-11.0F, -33.5F, -12.5F);
		box.addChild(door);
		door.texOffs(167, 121).addBox(-0.5F, -29.5F, -1.0F, 23.0F, 59.0F, 1.0F, 0.0F, false);
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

	public void render(TARDISTileEntity tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1); //fixme
	}
}
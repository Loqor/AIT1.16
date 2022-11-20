package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.4.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.client.models.exteriors.BasicBox;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SteveExterior extends BasicBox {
	public final ModelRenderer box;
	public final ModelRenderer mainbodybase;
	public final ModelRenderer door;

	public SteveExterior() {
		texWidth = 139;
		texHeight = 101;

		box = new ModelRenderer(this);
		box.setPos(0.0F, 24.0F, 0.0F);
		

		mainbodybase = new ModelRenderer(this);
		mainbodybase.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(mainbodybase);
		mainbodybase.texOffs(31, 37).addBox(-4.0F, -12.0F, 0.0F, 4.0F, 12.0F, 3.0F, 0.0F, true);
		mainbodybase.texOffs(0, 37).addBox(-4.0F, -32.0F, 0.0F, 8.0F, 8.0F, 5.0F, 0.0F, false);
		mainbodybase.texOffs(0, 55).addBox(-4.0F, -24.0F, 0.0F, 8.0F, 12.0F, 3.0F, 0.0F, false);
		mainbodybase.texOffs(50, 37).addBox(4.0F, -24.0F, 0.0F, 4.0F, 12.0F, 3.0F, 0.0F, true);
		mainbodybase.texOffs(50, 37).addBox(-8.0F, -24.0F, 0.0F, 4.0F, 12.0F, 3.0F, 0.0F, false);
		mainbodybase.texOffs(31, 37).addBox(0.0F, -12.0F, 0.0F, 4.0F, 12.0F, 3.0F, 0.0F, false);

		door = new ModelRenderer(this);
		door.setPos(-8.0F, -18.0F, 0.0F);
		box.addChild(door);
		door.texOffs(0, 88).addBox(8.0F, 6.0F, -1.0F, 4.0F, 12.0F, 1.0F, 0.0F, false);
		door.texOffs(54, 88).addBox(0.0F, -6.0F, -1.0F, 4.0F, 12.0F, 1.0F, 0.0F, false);
		door.texOffs(42, 72).addBox(4.0F, -14.0F, -3.0F, 8.0F, 8.0F, 3.0F, 0.0F, false);
		door.texOffs(27, 88).addBox(4.0F, -6.0F, -1.0F, 8.0F, 12.0F, 1.0F, 0.0F, false);
		door.texOffs(0, 88).addBox(4.0F, 6.0F, -1.0F, 4.0F, 12.0F, 1.0F, 0.0F, false);
		door.texOffs(54, 88).addBox(12.0F, -6.0F, -1.0F, 4.0F, 12.0F, 1.0F, 0.0F, true);
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

	public void render(TardisTileEntity tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, tile.getAlpha());
	}
}
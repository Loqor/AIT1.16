package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.client.renderers.EmissiveModelRenderer;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class BasicBox<T extends Entity> extends EntityModel<T> {
	public final ModelRenderer box;
	public final ModelRenderer right_door;
	public final ModelRenderer left_door;
	public final ModelRenderer base;

	public BasicBox() {
		texWidth = 512;
		texHeight = 512;

		box = new ModelRenderer(this);
		box.setPos(0.0F, -14.0F, 0.0F);

		right_door = new ModelRenderer(this);
		right_door.setPos(14.0F, 6.0F, -16.0F);
		box.addChild(right_door);
		right_door.texOffs(176, 174).addBox(-14.0F, -27.0F, -1.0F, 14.0F, 56.0F, 1.0F, 0.0F, false);
		right_door.texOffs(0, 18).addBox(-13.0F, -8.5F, -2.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		left_door = new ModelRenderer(this);
		left_door.setPos(-14.0F, 6.0F, -16.0F);
		box.addChild(left_door);
		left_door.texOffs(59, 126).addBox(0.0F, -27.0F, -1.0F, 14.0F, 56.0F, 1.0F, 0.0F, false);
		left_door.texOffs(5, 18).addBox(10.0F, -8.0F, -2.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		left_door.texOffs(115, 201).addBox(13.5F, -27.0F, -1.5F, 1.0F, 56.0F, 1.0F, 0.0F, false);

		base = new ModelRenderer(this);
		base.setPos(19.0F, 38.0F, 19.0F);
		box.addChild(base);
		base.texOffs(0, 0).addBox(-38.0F, -3.0F, -38.0F, 38.0F, 3.0F, 38.0F, 0.0F, false);
		base.texOffs(93, 195).addBox(-5.0F, -67.0F, -37.0F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		base.texOffs(76, 191).addBox(-37.0F, -67.0F, -37.0F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		base.texOffs(59, 184).addBox(-5.0F, -67.0F, -5.0F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		base.texOffs(90, 126).addBox(-37.0F, -67.0F, -5.0F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		base.texOffs(0, 86).addBox(-38.0F, -64.0F, -36.0F, 38.0F, 5.0F, 34.0F, 0.0F, false);
		base.texOffs(0, 42).addBox(-36.0F, -64.0F, -38.0F, 34.0F, 5.0F, 38.0F, 0.0F, false);
		base.texOffs(115, 0).addBox(-36.0F, -68.0F, -33.0F, 34.0F, 4.0F, 28.0F, 0.0F, false);
		base.texOffs(111, 77).addBox(-33.0F, -68.0F, -36.0F, 28.0F, 4.0F, 34.0F, 0.0F, false);
		base.texOffs(107, 42).addBox(-35.0F, -69.0F, -35.0F, 32.0F, 2.0F, 32.0F, 0.0F, false);
		base.texOffs(13, 14).addBox(-21.0F, -70.0F, -21.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(-21.5F, -76.0F, -21.5F, 5.0F, 6.0F, 5.0F, 0.0F, false);
		base.texOffs(0, 12).addBox(-21.0F, -77.0F, -21.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		base.texOffs(110, 184).addBox(-36.5F, -59.0F, -19.5F, 1.0F, 56.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 126).addBox(-36.0F, -59.0F, -33.0F, 1.0F, 56.0F, 28.0F, 0.0F, false);
		base.texOffs(112, 126).addBox(-19.5F, -59.0F, -2.5F, 1.0F, 56.0F, 1.0F, 0.0F, false);
		base.texOffs(176, 116).addBox(-33.0F, -59.0F, -3.0F, 28.0F, 56.0F, 1.0F, 0.0F, false);
		base.texOffs(107, 126).addBox(-2.5F, -59.0F, -19.5F, 1.0F, 56.0F, 1.0F, 0.0F, false);
		base.texOffs(117, 116).addBox(-3.0F, -59.0F, -33.0F, 1.0F, 56.0F, 28.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		box.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(TardisTileEntity tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
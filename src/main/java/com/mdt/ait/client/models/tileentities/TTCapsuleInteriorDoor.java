package com.mdt.ait.client.models.tileentities;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TTCapsuleInteriorDoor extends EntityModel<Entity> {
	private final ModelRenderer right_door;
	private final ModelRenderer left_door;
	private final ModelRenderer bb_main;

	public TTCapsuleInteriorDoor() {
		texWidth = 128;
		texHeight = 128;

		right_door = new ModelRenderer(this);
		right_door.setPos(-7.5F, 5.0F, -6.0F);
		right_door.texOffs(42, 25).addBox(-0.5F, -17.0F, 0.0F, 1.0F, 34.0F, 6.0F, 0.0F, false);

		left_door = new ModelRenderer(this);
		left_door.setPos(-7.5F, 5.0F, 6.0F);
		left_door.texOffs(27, 25).addBox(-0.5F, -17.0F, -6.0F, 1.0F, 34.0F, 6.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);
		bb_main.texOffs(57, 62).addBox(-8.0F, -36.0F, 6.0F, 2.0F, 34.0F, 2.0F, 0.0F, false);
		bb_main.texOffs(57, 25).addBox(-8.0F, -36.0F, -8.0F, 2.0F, 34.0F, 2.0F, 0.0F, false);
		bb_main.texOffs(0, 50).addBox(-8.0F, -2.0F, -8.0F, 2.0F, 2.0F, 16.0F, 0.0F, false);
		bb_main.texOffs(27, 0).addBox(-8.0F, -44.0F, -8.0F, 2.0F, 8.0F, 16.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(-8.0F, -36.0F, -6.0F, 1.0F, 34.0F, 12.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		right_door.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		left_door.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
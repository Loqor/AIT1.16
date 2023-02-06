package com.mdt.ait.client.models.tileentities;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FalloutShelterInteriorDoor extends BasicInteriorDoor {
	public final ModelRenderer door;
	public final ModelRenderer frame;

	public FalloutShelterInteriorDoor() {
		texWidth = 128;
		texHeight = 128;

		door = new ModelRenderer(this);
		door.setPos(-5.5F, 8.0F, 6.975F);
		door.texOffs(24, 24).addBox(0.0F, -16.0F, -14.45F, 11.0F, 32.0F, 1.0F, 0.0F, false);

		frame = new ModelRenderer(this);
		frame.setPos(0.0F, 26.0F, 17.55F);
		frame.texOffs(24, 11).addBox(-5.5F, -36.0F, -24.55F, 11.0F, 2.0F, 1.0F, 0.0F, false);
		frame.texOffs(24, 0).addBox(-7.5F, -41.0F, -25.55F, 15.0F, 5.0F, 2.0F, 0.0F, false);
		frame.texOffs(0, 35).addBox(-7.5F, -36.0F, -25.55F, 2.0F, 34.0F, 2.0F, 0.0F, false);
		frame.texOffs(8, 35).addBox(5.5F, -36.0F, -25.55F, 2.0F, 34.0F, 2.0F, 0.0F, false);
		frame.texOffs(0, 0).addBox(-5.5F, -36.0F, -25.55F, 11.0F, 34.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		door.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		frame.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
package com.mdt.ait.client.models.cosmetics;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;


public class MessengerBag extends EntityModel<Entity> {
	private final ModelRenderer bag;
	private final ModelRenderer cube_r1;

	public MessengerBag() {
		texWidth = 32;
		texHeight = 32;

		bag = new ModelRenderer(this);
		bag.setPos(1.0F, 24.0F, 1.0F);
		bag.texOffs(0, 0).addBox(0.5F, -14.0F, -3.475F, 3.0F, 6.0F, 5.0F, 0.001F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		bag.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -0.5236F);
		cube_r1.texOffs(0, 12).addBox(7.0F, -23.75F, -3.5F, 1.0F, 0.0F, 5.0F, 0.0F, false);
		cube_r1.texOffs(13, 12).addBox(7.0F, -23.75F, 1.5F, 1.0F, 13.0F, 0.0F, 0.0F, false);
		cube_r1.texOffs(16, 12).addBox(7.0F, -23.75F, -3.5F, 1.0F, 13.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bag.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
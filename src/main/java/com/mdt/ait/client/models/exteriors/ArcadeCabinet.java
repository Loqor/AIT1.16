package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.mdt.ait.tardis.exterior.model.BasicBoxModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.vector.Vector3f;

public class ArcadeCabinet extends BasicBoxModel {
	public final ModelRenderer box;
	public final ModelRenderer door;
	public final ModelRenderer base;
	public final ModelRenderer cube_r1;
	public final ModelRenderer cube_r2;
	public final ModelRenderer cube_r3;
	public final ModelRenderer cube_r4;
	public final ModelRenderer cube_r5;
	public final ModelRenderer bone;
	public final ModelRenderer cube_r6;
	public final ModelRenderer cube_r7;

	public ArcadeCabinet() {
		texWidth = 256;
		texHeight = 256;

		box = new ModelRenderer(this);
		box.setPos(0.0F, 24.0F, 0.0F);
		

		door = new ModelRenderer(this);
		door.setPos(8.0F, 0.0F, -42.0F);
		box.addChild(door);
		door.texOffs(0, 45).addBox(-21.0F, -65.0F, 26.0F, 26.0F, 1.0F, 32.0F, 0.002F, false);
		door.texOffs(134, 130).addBox(-21.0F, -64.0F, 57.0F, 26.0F, 63.0F, 1.0F, 0.002F, false);
		door.texOffs(90, 0).addBox(-21.0F, -1.0F, 27.0F, 26.0F, 1.0F, 31.0F, 0.002F, false);

		base = new ModelRenderer(this);
		base.setPos(8.0F, -8.5615F, -24.9727F);
		box.addChild(base);
		base.texOffs(35, 112).addBox(-21.0F, -35.4385F, 17.9727F, 26.0F, 4.0F, 4.0F, 0.001F, false);
		base.texOffs(85, 45).addBox(-21.0F, -55.4385F, 35.9727F, 26.0F, 4.0F, 4.0F, 0.001F, false);
		base.texOffs(67, 130).addBox(5.0F, -23.4385F, 8.9727F, 1.0F, 32.0F, 32.0F, 0.002F, false);
		base.texOffs(90, 195).addBox(-21.0F, -23.4385F, 8.9727F, 26.0F, 32.0F, 1.0F, 0.002F, false);
		base.texOffs(0, 79).addBox(-21.0F, 7.5615F, 8.9727F, 26.0F, 0.0F, 32.0F, 0.002F, false);
		base.texOffs(0, 177).addBox(-21.0F, -55.4385F, 39.9727F, 26.0F, 63.0F, 0.0F, 0.002F, false);
		base.texOffs(145, 197).addBox(5.0F, -55.4385F, 29.9727F, 1.0F, 32.0F, 11.0F, 0.002F, false);
		base.texOffs(0, 0).addBox(-22.0F, -67.4385F, 7.9727F, 28.0F, 11.0F, 33.0F, 0.002F, false);
		base.texOffs(123, 33).addBox(-22.0F, -56.4385F, 7.9727F, 28.0F, 1.0F, 1.0F, 0.002F, false);
		base.texOffs(170, 65).addBox(-22.0F, -56.4385F, 8.9727F, 1.0F, 1.0F, 32.0F, 0.002F, false);
		base.texOffs(157, 163).addBox(5.0F, -56.4385F, 8.9727F, 1.0F, 1.0F, 32.0F, 0.002F, false);
		base.texOffs(174, 33).addBox(-22.0F, -55.4385F, 29.9727F, 1.0F, 32.0F, 11.0F, 0.002F, false);
		base.texOffs(0, 112).addBox(-22.0F, -23.4385F, 8.9727F, 1.0F, 32.0F, 32.0F, 0.002F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		base.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.2182F, 0.0F, 0.0F);
		cube_r1.texOffs(0, 13).addBox(-3.0F, -37.5F, 3.0F, 2.0F, 2.0F, 2.0F, -0.25F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, 5.089F, 4.2459F);
		base.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.0873F, 0.0F, 0.0F);
		cube_r2.texOffs(0, 6).addBox(-3.0F, -40.0F, 3.0F, 2.0F, 4.0F, 2.0F, -0.25F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, 5.7429F, 22.1424F);
		base.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.3927F, 0.0F, 0.0F);
		cube_r3.texOffs(0, 0).addBox(-3.5F, -36.5F, 2.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r3.texOffs(9, 6).addBox(-3.0F, -38.35F, 3.075F, 2.0F, 4.0F, 2.0F, -0.25F, false);
		cube_r3.texOffs(13, 0).addBox(-6.5F, -36.75F, 6.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r3.texOffs(9, 13).addBox(-11.5F, -36.75F, 6.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r3.texOffs(8, 17).addBox(-1.0F, -36.25F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r3.texOffs(17, 12).addBox(-16.0F, -36.25F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r3.texOffs(16, 4).addBox(-16.0F, -37.0F, 3.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r3.texOffs(92, 54).addBox(-22.0F, -36.0F, -1.0F, 28.0F, 17.0F, 25.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(-16.0F, 12.6297F, 12.4331F);
		base.addChild(cube_r4);
		setRotationAngle(cube_r4, -0.3927F, 0.0F, 0.0F);
		cube_r4.texOffs(192, 113).addBox(21.0F, -70.0F, -17.0F, 1.0F, 38.0F, 17.0F, -0.002F, false);
		cube_r4.texOffs(53, 195).addBox(-6.0F, -70.0F, -17.0F, 1.0F, 38.0F, 17.0F, -0.002F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(-0.001F, 5.1671F, 35.77F);
		base.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.6981F, 0.0F, 0.0F);
		cube_r5.texOffs(93, 97).addBox(-21.0F, -45.0F, 12.0F, 26.0F, 8.0F, 24.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setPos(-5.5F, 8.5615F, 70.9727F);
		base.addChild(bone);
		

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.0F, 0.0F, -92.0F);
		bone.addChild(cube_r6);
		setRotationAngle(cube_r6, -1.5708F, 0.0F, -1.5708F);
		cube_r6.texOffs(174, 0).addBox(25.5F, -60.0F, -16.75F, 39.0F, 16.0F, 0.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(0.0F, 0.0F, -92.0F);
		bone.addChild(cube_r7);
		setRotationAngle(cube_r7, 1.5708F, 0.0F, -1.5708F);
		cube_r7.texOffs(174, 0).addBox(25.5F, 44.0F, -11.75F, 39.0F, 16.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		matrixStack.pushPose();
		matrixStack.mulPose(Vector3f.YP.rotationDegrees(180f));
		base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		matrixStack.popPose();
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
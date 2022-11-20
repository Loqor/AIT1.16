package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.4.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.client.models.exteriors.BasicBox;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class BoothExterior extends BasicBox {
	public final ModelRenderer box;
	public final ModelRenderer base;
	public final ModelRenderer cube_r1;
	public final ModelRenderer cube_r2;
	public final ModelRenderer cube_r3;
	public final ModelRenderer cube_r4;
	public final ModelRenderer other_doors;
	public final ModelRenderer cube_r5;
	public final ModelRenderer cube_r6;
	public final ModelRenderer door;
	public final ModelRenderer cube_r7;

	public BoothExterior() {
		texWidth = 256;
		texHeight = 256;

		box = new ModelRenderer(this);
		box.setPos(0.0F, 0.0F, 0.0F);
		setRotationAngle(box, 0.0F, 1.5708F, 0.0F);
		

		base = new ModelRenderer(this);
		base.setPos(0.0F, 23.0F, 0.0F);
		box.addChild(base);
		base.texOffs(0, 0).addBox(-2.0F, -16.0F, -10.0F, 4.0F, 14.0F, 1.0F, 0.0F, false);
		base.texOffs(124, 32).addBox(-7.0F, -33.0F, -10.0F, 14.0F, 17.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 18).addBox(-3.0F, -30.5F, -9.75F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		base.texOffs(11, 9).addBox(-3.0F, -26.0F, -8.0F, 6.0F, 7.0F, 1.0F, 0.0F, false);
		base.texOffs(11, 0).addBox(-3.0F, -26.0F, -9.0F, 6.0F, 7.0F, 1.0F, 0.0F, false);
		base.texOffs(15, 18).addBox(1.25F, -25.5F, -7.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		base.texOffs(20, 18).addBox(1.25F, -25.0F, -6.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(-13.0F, -2.0F, -13.0F, 26.0F, 3.0F, 26.0F, 0.0F, false);
		base.texOffs(0, 58).addBox(-11.0F, -47.0F, -11.0F, 22.0F, 3.0F, 22.0F, 0.0F, false);
		base.texOffs(0, 30).addBox(-12.0F, -44.0F, -12.0F, 24.0F, 3.0F, 24.0F, 0.0F, false);
		base.texOffs(26, 142).addBox(-12.0F, -41.0F, -12.0F, 3.0F, 39.0F, 3.0F, 0.0F, false);
		base.texOffs(13, 142).addBox(9.0F, -41.0F, -12.0F, 3.0F, 39.0F, 3.0F, 0.0F, false);
		base.texOffs(140, 60).addBox(9.0F, -41.0F, 9.0F, 3.0F, 39.0F, 3.0F, 0.0F, false);
		base.texOffs(0, 142).addBox(-12.0F, -41.0F, 9.0F, 3.0F, 39.0F, 3.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, -47.0341F, 11.7412F);
		base.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.2618F, 0.0F, 0.0F);
		cube_r1.texOffs(79, 0).addBox(-12.0F, -1.0F, -13.0F, 24.0F, 1.0F, 13.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, -47.0341F, -11.7412F);
		base.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.2618F, 0.0F, 0.0F);
		cube_r2.texOffs(92, 17).addBox(-12.0F, -1.0F, 0.0F, 24.0F, 1.0F, 13.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(-11.7412F, -47.0341F, 0.0F);
		base.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.2618F);
		cube_r3.texOffs(65, 60).addBox(0.0F, -1.0F, -12.0F, 13.0F, 1.0F, 24.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(11.7412F, -47.0341F, 0.0F);
		base.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.2618F);
		cube_r4.texOffs(73, 34).addBox(-13.0F, -1.0F, -12.0F, 13.0F, 1.0F, 24.0F, 0.0F, false);

		other_doors = new ModelRenderer(this);
		other_doors.setPos(0.0F, 0.0F, 0.0F);
		base.addChild(other_doors);
		other_doors.texOffs(117, 86).addBox(-11.0F, -41.0F, -9.0F, 1.0F, 39.0F, 18.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(0.0F, 0.0F, 0.0F);
		other_doors.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, -1.5708F, 0.0F);
		cube_r5.texOffs(39, 84).addBox(-11.0F, -41.0F, -9.0F, 1.0F, 39.0F, 18.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.0F, 0.0F, 0.0F);
		other_doors.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 1.5708F, 0.0F);
		cube_r6.texOffs(78, 86).addBox(-11.0F, -41.0F, -9.0F, 1.0F, 39.0F, 18.0F, 0.0F, false);

		door = new ModelRenderer(this);
		door.setPos(11.0F, -3.0F, -9.0F);
		box.addChild(door);
		door.texOffs(0, 30).addBox(0.0F, 1.0F, 15.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(-11.0F, 26.0F, 9.0F);
		door.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 3.1416F, 0.0F);
		cube_r7.texOffs(0, 84).addBox(-11.0F, -41.0F, -9.0F, 1.0F, 39.0F, 18.0F, 0.0F, false);
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
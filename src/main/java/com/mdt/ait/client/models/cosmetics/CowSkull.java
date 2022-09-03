package com.mdt.ait.client.models.cosmetics;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.GenericHeadModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;

public class CowSkull extends BipedModel<LivingEntity> {
	private final ModelRenderer bipedHead;
	private final ModelRenderer armorHead;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;

	private LivingEntity livingEntity = null;
	private EquipmentSlotType slot = EquipmentSlotType.HEAD;


	public CowSkull(float size) {
		super(size, 0, 16, 16);
		texWidth = 64;
		texHeight = 64;

		bipedHead = new ModelRenderer(this);
		bipedHead.setPos(-8.0635F, 1.9F, -7.4832F);
		setRotationAngle(bipedHead, 0.1309F, 0.0F, 0.0F);
		

		armorHead = new ModelRenderer(this);
		armorHead.setPos(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(armorHead);
		armorHead.texOffs(0, 28).addBox(6.0635F, -6.8499F, 0.1941F, 4.0F, 4.0F, 7.0F, 0.0F, false);
		armorHead.texOffs(0, 0).addBox(7.0635F, -6.8499F, -0.8059F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		armorHead.texOffs(0, 49).addBox(5.0635F, -7.8499F, 3.1941F, 2.0F, 5.0F, 4.0F, 0.0F, false);
		armorHead.texOffs(44, 47).addBox(9.0635F, -7.8499F, 3.1941F, 2.0F, 5.0F, 4.0F, 0.0F, false);
		armorHead.texOffs(23, 28).addBox(5.0635F, -9.0F, 8.9762F, 6.0F, 5.0F, 5.0F, 0.0F, false);
		armorHead.texOffs(39, 32).addBox(10.5635F, -4.8499F, 0.1941F, 1.0F, 2.0F, 7.0F, 0.0F, false);
		armorHead.texOffs(45, 23).addBox(11.0635F, -7.0F, 8.9762F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		armorHead.texOffs(16, 39).addBox(4.5635F, -4.8499F, 0.1941F, 1.0F, 2.0F, 7.0F, 0.0F, false);
		armorHead.texOffs(45, 5).addBox(4.0635F, -7.0F, 8.9762F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		armorHead.texOffs(0, 0).addBox(1.0635F, -19.0F, 11.9762F, 14.0F, 13.0F, 0.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		armorHead.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -0.3927F, 0.0F);
		cube_r1.texOffs(0, 14).addBox(18.5F, -21.0F, 5.3F, 12.0F, 13.0F, 0.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(16.1271F, 0.0F, 0.0F);
		armorHead.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.3927F, 0.0F);
		cube_r2.texOffs(25, 14).addBox(-30.5F, -21.0F, 5.3F, 12.0F, 13.0F, 0.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(-7.1865F, 0.9646F, 3.0749F);
		armorHead.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.3927F, 0.0F, 0.0F);
		cube_r3.texOffs(0, 0).addBox(11.5F, -5.1F, 5.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(18.0F, -5.1F, 5.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(19.0635F, -1.1585F, 2.7186F);
		armorHead.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.3927F, 0.0F, 0.0F);
		cube_r4.texOffs(0, 40).addBox(-14.001F, -6.001F, -2.001F, 2.0F, 3.0F, 5.0F, 0.0F, false);
		cube_r4.texOffs(33, 42).addBox(-10.001F, -6.001F, -2.001F, 2.0F, 3.0F, 5.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(-0.9365F, 0.9113F, 3.3401F);
		armorHead.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.3927F, 0.0F, 0.0F);
		cube_r5.texOffs(0, 28).addBox(5.499F, -7.251F, 6.999F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r5.texOffs(16, 28).addBox(11.499F, -7.251F, 6.999F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r5.texOffs(29, 0).addBox(5.999F, -7.001F, 4.999F, 6.0F, 5.0F, 4.0F, 0.0F, false);
	}

	public void setupAnim(float p_225603_1_, float p_225603_2_, float p_225603_3_) {
		this.bipedHead.yRot = p_225603_2_ * ((float)Math.PI / 180F);
		this.bipedHead.xRot = p_225603_3_ * ((float)Math.PI / 180F);
	}

	public void renderToBuffer(MatrixStack pMatrixStack, IVertexBuilder pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
			this.bipedHead.render(pMatrixStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(MatrixStack pMatrixStack, IVertexBuilder vertexBuffer, int pPackedLight, int noOverlay, int i, int i1, int i2, float v) {
		this.renderToBuffer(pMatrixStack, vertexBuffer, pPackedLight, noOverlay, 1, 1, 1, 1.0F);
	}
}
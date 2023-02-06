package com.mdt.ait.client.models.exteriors;// Made with Blockbench 4.5.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.mdt.ait.tardis.exterior.model.BasicBoxModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class HellBentTTCapsuleExterior extends BasicBoxModel {
	public final ModelRenderer box;
	public final ModelRenderer boti;
	public final ModelRenderer frame;
	public final ModelRenderer bone37;
	public final ModelRenderer bone38;
	public final ModelRenderer bone39;
	public final ModelRenderer bone40;
	public final ModelRenderer bone41;
	public final ModelRenderer bone42;
	public final ModelRenderer bone7;
	public final ModelRenderer bone8;
	public final ModelRenderer bone9;
	public final ModelRenderer bone10;
	public final ModelRenderer bone11;
	public final ModelRenderer bone31;
	public final ModelRenderer bone32;
	public final ModelRenderer bone33;
	public final ModelRenderer bone34;
	public final ModelRenderer bone35;
	public final ModelRenderer bone36;
	public final ModelRenderer bone25;
	public final ModelRenderer bone26;
	public final ModelRenderer bone27;
	public final ModelRenderer bone28;
	public final ModelRenderer bone29;
	public final ModelRenderer bone30;
	public final ModelRenderer bone19;
	public final ModelRenderer bone20;
	public final ModelRenderer bone21;
	public final ModelRenderer bone22;
	public final ModelRenderer bone23;
	public final ModelRenderer bone24;
	public final ModelRenderer bone43;
	public final ModelRenderer bone44;
	public final ModelRenderer bone45;
	public final ModelRenderer bone46;
	public final ModelRenderer bone47;
	public final ModelRenderer bone48;
	public final ModelRenderer bone13;
	public final ModelRenderer bone14;
	public final ModelRenderer bone15;
	public final ModelRenderer bone16;
	public final ModelRenderer bone17;
	public final ModelRenderer bone18;
	public final ModelRenderer bone;
	public final ModelRenderer bone2;
	public final ModelRenderer bone3;
	public final ModelRenderer bone4;
	public final ModelRenderer bone5;
	public final ModelRenderer bone6;
	public final ModelRenderer right_door;
	public final ModelRenderer left_door;

	public HellBentTTCapsuleExterior() {
		texWidth = 256;
		texHeight = 256;

		box = new ModelRenderer(this);
		box.setPos(0.0F, 24.0F, 0.0F);
		

		boti = new ModelRenderer(this);
		boti.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(boti);
		boti.texOffs(80, 130).addBox(-9.0F, -36.0F, -1.0F, 18.0F, 34.0F, 2.0F, 0.0F, false);

		frame = new ModelRenderer(this);
		frame.setPos(0.0F, 0.0F, 0.0F);
		box.addChild(frame);
		

		bone37 = new ModelRenderer(this);
		bone37.setPos(0.0F, 0.0F, 0.0F);
		frame.addChild(bone37);
		setRotationAngle(bone37, 0.0F, -0.5236F, 0.0F);
		bone37.texOffs(0, 66).addBox(-1.0F, -2.0F, 11.7F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone38 = new ModelRenderer(this);
		bone38.setPos(0.0F, 0.0F, 0.0F);
		bone37.addChild(bone38);
		setRotationAngle(bone38, 0.0F, -1.0472F, 0.0F);
		bone38.texOffs(59, 0).addBox(-1.0F, -2.0F, 11.7F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone39 = new ModelRenderer(this);
		bone39.setPos(0.0F, 0.0F, 0.0F);
		bone38.addChild(bone39);
		setRotationAngle(bone39, 0.0F, -1.0472F, 0.0F);
		bone39.texOffs(52, 3).addBox(-1.0F, -2.0F, 11.7F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone40 = new ModelRenderer(this);
		bone40.setPos(0.0F, 0.0F, 0.0F);
		bone39.addChild(bone40);
		setRotationAngle(bone40, 0.0F, -1.0472F, 0.0F);
		bone40.texOffs(3, 52).addBox(-1.0F, -2.0F, 11.7F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone41 = new ModelRenderer(this);
		bone41.setPos(0.0F, 0.0F, 0.0F);
		bone40.addChild(bone41);
		setRotationAngle(bone41, 0.0F, -1.0472F, 0.0F);
		bone41.texOffs(45, 0).addBox(-1.0F, -2.0F, 11.7F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone42 = new ModelRenderer(this);
		bone42.setPos(0.0F, 0.0F, 0.0F);
		bone41.addChild(bone42);
		setRotationAngle(bone42, 0.0F, -1.0472F, 0.0F);
		bone42.texOffs(43, 8).addBox(-1.0F, -2.0F, 11.7F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setPos(0.0F, -2.0F, 0.0F);
		frame.addChild(bone7);
		

		bone8 = new ModelRenderer(this);
		bone8.setPos(0.0F, 0.0F, 0.0F);
		bone7.addChild(bone8);
		setRotationAngle(bone8, 0.0F, -1.0472F, 0.0F);
		

		bone9 = new ModelRenderer(this);
		bone9.setPos(0.0F, 0.0F, 0.0F);
		bone8.addChild(bone9);
		setRotationAngle(bone9, 0.0F, -1.0472F, 0.0F);
		

		bone10 = new ModelRenderer(this);
		bone10.setPos(0.0F, 0.0F, 0.0F);
		bone9.addChild(bone10);
		setRotationAngle(bone10, 0.0F, -1.0472F, 0.0F);
		

		bone11 = new ModelRenderer(this);
		bone11.setPos(0.0F, 0.0F, 0.0F);
		bone10.addChild(bone11);
		setRotationAngle(bone11, 0.0F, -1.0472F, 0.0F);
		

		bone31 = new ModelRenderer(this);
		bone31.setPos(0.0F, -2.0F, 0.0F);
		frame.addChild(bone31);
		setRotationAngle(bone31, 0.0F, -0.5236F, 0.0F);
		bone31.texOffs(26, 127).addBox(-1.0F, -34.0F, 8.875F, 2.0F, 34.0F, 4.0F, 0.0F, false);

		bone32 = new ModelRenderer(this);
		bone32.setPos(0.0F, 0.0F, 0.0F);
		bone31.addChild(bone32);
		setRotationAngle(bone32, 0.0F, -1.0472F, 0.0F);
		bone32.texOffs(125, 90).addBox(-1.0F, -34.0F, 8.875F, 2.0F, 34.0F, 4.0F, 0.0F, false);

		bone33 = new ModelRenderer(this);
		bone33.setPos(0.0F, 0.0F, 0.0F);
		bone32.addChild(bone33);
		setRotationAngle(bone33, 0.0F, -1.0472F, 0.0F);
		bone33.texOffs(69, 130).addBox(-1.0F, -34.0F, 10.875F, 2.0F, 34.0F, 2.0F, 0.0F, false);

		bone34 = new ModelRenderer(this);
		bone34.setPos(0.0F, 0.0F, 0.0F);
		bone33.addChild(bone34);
		setRotationAngle(bone34, 0.0F, -1.0472F, 0.0F);
		bone34.texOffs(123, 129).addBox(-1.0F, -34.0F, 10.875F, 2.0F, 34.0F, 2.0F, 0.0F, false);

		bone35 = new ModelRenderer(this);
		bone35.setPos(0.0F, 0.0F, 0.0F);
		bone34.addChild(bone35);
		setRotationAngle(bone35, 0.0F, -1.0472F, 0.0F);
		bone35.texOffs(13, 123).addBox(-1.0F, -34.0F, 8.875F, 2.0F, 34.0F, 4.0F, 0.0F, false);

		bone36 = new ModelRenderer(this);
		bone36.setPos(0.0F, 0.0F, 0.0F);
		bone35.addChild(bone36);
		setRotationAngle(bone36, 0.0F, -1.0472F, 0.0F);
		bone36.texOffs(0, 118).addBox(-1.0F, -34.0F, 8.875F, 2.0F, 34.0F, 4.0F, 0.0F, false);

		bone25 = new ModelRenderer(this);
		bone25.setPos(0.0F, -36.0F, 0.0F);
		frame.addChild(bone25);
		setRotationAngle(bone25, 0.0F, -0.5236F, 0.0F);
		bone25.texOffs(0, 44).addBox(-0.5F, -8.0F, 12.85F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		bone26 = new ModelRenderer(this);
		bone26.setPos(0.0F, 0.0F, 0.0F);
		bone25.addChild(bone26);
		setRotationAngle(bone26, 0.0F, -1.0472F, 0.0F);
		bone26.texOffs(40, 0).addBox(-0.5F, -8.0F, 12.85F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		bone27 = new ModelRenderer(this);
		bone27.setPos(0.0F, 0.0F, 0.0F);
		bone26.addChild(bone27);
		setRotationAngle(bone27, 0.0F, -1.0472F, 0.0F);
		bone27.texOffs(5, 22).addBox(-0.5F, -8.0F, 12.85F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		bone28 = new ModelRenderer(this);
		bone28.setPos(0.0F, 0.0F, 0.0F);
		bone27.addChild(bone28);
		setRotationAngle(bone28, 0.0F, -1.0472F, 0.0F);
		bone28.texOffs(0, 22).addBox(-0.5F, -8.0F, 12.85F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		bone29 = new ModelRenderer(this);
		bone29.setPos(0.0F, 0.0F, 0.0F);
		bone28.addChild(bone29);
		setRotationAngle(bone29, 0.0F, -1.0472F, 0.0F);
		bone29.texOffs(5, 0).addBox(-0.5F, -8.0F, 12.85F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		bone30 = new ModelRenderer(this);
		bone30.setPos(0.0F, 0.0F, 0.0F);
		bone29.addChild(bone30);
		setRotationAngle(bone30, 0.0F, -1.0472F, 0.0F);
		bone30.texOffs(0, 0).addBox(-0.5F, -8.0F, 12.85F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		bone19 = new ModelRenderer(this);
		bone19.setPos(0.0F, -36.0F, 0.0F);
		frame.addChild(bone19);
		

		bone20 = new ModelRenderer(this);
		bone20.setPos(0.0F, 0.0F, 0.0F);
		bone19.addChild(bone20);
		setRotationAngle(bone20, 0.0F, -1.0472F, 0.0F);
		

		bone21 = new ModelRenderer(this);
		bone21.setPos(0.0F, 0.0F, 0.0F);
		bone20.addChild(bone21);
		setRotationAngle(bone21, 0.0F, -1.0472F, 0.0F);
		

		bone22 = new ModelRenderer(this);
		bone22.setPos(0.0F, 0.0F, 0.0F);
		bone21.addChild(bone22);
		setRotationAngle(bone22, 0.0F, -1.0472F, 0.0F);
		

		bone23 = new ModelRenderer(this);
		bone23.setPos(0.0F, 0.0F, 0.0F);
		bone22.addChild(bone23);
		setRotationAngle(bone23, 0.0F, -1.0472F, 0.0F);
		

		bone24 = new ModelRenderer(this);
		bone24.setPos(0.0F, 0.0F, 0.0F);
		bone23.addChild(bone24);
		setRotationAngle(bone24, 0.0F, -1.0472F, 0.0F);
		

		bone43 = new ModelRenderer(this);
		bone43.setPos(0.0F, -36.0F, 0.0F);
		frame.addChild(bone43);
		bone43.texOffs(40, 53).addBox(-6.5F, -8.0F, -0.775F, 13.0F, 8.0F, 13.0F, 0.0F, false);

		bone44 = new ModelRenderer(this);
		bone44.setPos(0.0F, 0.0F, 0.0F);
		bone43.addChild(bone44);
		setRotationAngle(bone44, 0.0F, -1.0472F, 0.0F);
		bone44.texOffs(0, 44).addBox(-6.5F, -8.0F, -0.775F, 13.0F, 8.0F, 13.0F, 0.0F, false);

		bone45 = new ModelRenderer(this);
		bone45.setPos(0.0F, 0.0F, 0.0F);
		bone44.addChild(bone45);
		setRotationAngle(bone45, 0.0F, -1.0472F, 0.0F);
		bone45.texOffs(40, 31).addBox(-6.5F, -8.0F, -0.775F, 13.0F, 8.0F, 13.0F, 0.0F, false);

		bone46 = new ModelRenderer(this);
		bone46.setPos(0.0F, 0.0F, 0.0F);
		bone45.addChild(bone46);
		setRotationAngle(bone46, 0.0F, -1.0472F, 0.0F);
		bone46.texOffs(40, 9).addBox(-6.5F, -8.0F, -0.775F, 13.0F, 8.0F, 13.0F, 0.0F, false);

		bone47 = new ModelRenderer(this);
		bone47.setPos(0.0F, 0.0F, 0.0F);
		bone46.addChild(bone47);
		setRotationAngle(bone47, 0.0F, -1.0472F, 0.0F);
		bone47.texOffs(0, 22).addBox(-6.5F, -8.0F, -0.775F, 13.0F, 8.0F, 13.0F, 0.0F, false);

		bone48 = new ModelRenderer(this);
		bone48.setPos(0.0F, 0.0F, 0.0F);
		bone47.addChild(bone48);
		setRotationAngle(bone48, 0.0F, -1.0472F, 0.0F);
		bone48.texOffs(0, 0).addBox(-6.5F, -8.0F, -0.775F, 13.0F, 8.0F, 13.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setPos(0.0F, -2.0F, 0.0F);
		frame.addChild(bone13);
		bone13.texOffs(100, 94).addBox(-5.5F, -34.0F, 9.525F, 11.0F, 34.0F, 1.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setPos(0.0F, 0.0F, 0.0F);
		bone13.addChild(bone14);
		setRotationAngle(bone14, 0.0F, -1.0472F, 0.0F);
		bone14.texOffs(75, 94).addBox(-5.5F, -34.0F, 9.525F, 11.0F, 34.0F, 1.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setPos(0.0F, 0.0F, 0.0F);
		bone14.addChild(bone15);
		setRotationAngle(bone15, 0.0F, -1.0472F, 0.0F);
		bone15.texOffs(50, 91).addBox(-5.5F, -34.0F, 9.525F, 11.0F, 34.0F, 1.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setPos(0.0F, 0.0F, 0.0F);
		bone15.addChild(bone16);
		setRotationAngle(bone16, 0.0F, -1.0472F, 0.0F);
		

		bone17 = new ModelRenderer(this);
		bone17.setPos(0.0F, 0.0F, 0.0F);
		bone16.addChild(bone17);
		setRotationAngle(bone17, 0.0F, -1.0472F, 0.0F);
		bone17.texOffs(25, 91).addBox(-5.5F, -34.0F, 9.525F, 11.0F, 34.0F, 1.0F, 0.0F, false);

		bone18 = new ModelRenderer(this);
		bone18.setPos(0.0F, 0.0F, 0.0F);
		bone17.addChild(bone18);
		setRotationAngle(bone18, 0.0F, -1.0472F, 0.0F);
		bone18.texOffs(0, 82).addBox(-5.5F, -34.0F, 9.525F, 11.0F, 34.0F, 1.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setPos(0.0F, 0.0F, 0.0F);
		frame.addChild(bone);
		bone.texOffs(80, 40).addBox(-6.0F, -2.0F, -0.625F, 12.0F, 2.0F, 13.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setPos(0.0F, 0.0F, 0.0F);
		bone.addChild(bone2);
		setRotationAngle(bone2, 0.0F, -1.0472F, 0.0F);
		bone2.texOffs(80, 18).addBox(-6.0F, -2.0F, -0.625F, 12.0F, 2.0F, 13.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setPos(0.0F, 0.0F, 0.0F);
		bone2.addChild(bone3);
		setRotationAngle(bone3, 0.0F, -1.0472F, 0.0F);
		bone3.texOffs(80, 0).addBox(-6.0F, -2.0F, -0.625F, 12.0F, 2.0F, 13.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setPos(0.0F, 0.0F, 0.0F);
		bone3.addChild(bone4);
		setRotationAngle(bone4, 0.0F, -1.0472F, 0.0F);
		bone4.texOffs(76, 78).addBox(-6.0F, -2.0F, -0.625F, 12.0F, 2.0F, 13.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setPos(0.0F, 0.0F, 0.0F);
		bone4.addChild(bone5);
		setRotationAngle(bone5, 0.0F, -1.0472F, 0.0F);
		bone5.texOffs(38, 75).addBox(-6.0F, -2.0F, -0.625F, 12.0F, 2.0F, 13.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setPos(0.0F, 0.0F, 0.0F);
		bone5.addChild(bone6);
		setRotationAngle(bone6, 0.0F, -1.0472F, 0.0F);
		bone6.texOffs(0, 66).addBox(-6.0F, -2.0F, -0.625F, 12.0F, 2.0F, 13.0F, 0.0F, false);

		right_door = new ModelRenderer(this);
		right_door.setPos(5.0F, -23.0F, -10.0F);
		box.addChild(right_door);
		right_door.texOffs(39, 127).addBox(-5.0F, -13.0F, -0.475F, 6.0F, 34.0F, 1.0F, 0.0F, false);

		left_door = new ModelRenderer(this);
		left_door.setPos(-5.0F, -23.0F, -10.0F);
		box.addChild(left_door);
		left_door.texOffs(54, 127).addBox(-1.0F, -13.0F, -0.475F, 6.0F, 34.0F, 1.0F, 0.0F, false);
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
}
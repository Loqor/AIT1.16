package com.mdt.ait.client.models.exteriors;

import com.mdt.ait.client.models.exteriors.BasicBox;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FalloutShelterExterior extends BasicBox {
	public final ModelRenderer BOTI;
	public final ModelRenderer door;
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
	public final ModelRenderer bone12;
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
	public final ModelRenderer glow;
	public final ModelRenderer bone49;
	public final ModelRenderer bone50;
	public final ModelRenderer bone51;
	public final ModelRenderer bone52;
	public final ModelRenderer bone53;
	public final ModelRenderer bone54;

	public FalloutShelterExterior() {
		texWidth = 128;
		texHeight = 128;

		BOTI = new ModelRenderer(this);
		BOTI.setPos(0.0F, 24.0F, 0.0F);
		BOTI.texOffs(2, 92).addBox(-5.5F, -34.025F, -10.0F, 11.0F, 32.0F, 1.0F, 0.0F, false);

		door = new ModelRenderer(this);
		door.setPos(0.0F, 6.0F, -2.0F);
		door.texOffs(24, 54).addBox(-5.5F, -16.0F, -8.475F, 11.0F, 32.0F, 1.0F, 0.0F, false);

		frame = new ModelRenderer(this);
		frame.setPos(0.0F, 24.0F, 0.0F);
		

		bone37 = new ModelRenderer(this);
		bone37.setPos(0.0F, 0.0F, 0.0F);
		frame.addChild(bone37);
		setRotationAngle(bone37, 0.0F, -0.5236F, 0.0F);
		bone37.texOffs(4, 4).addBox(-1.0F, -2.0F, 11.7F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone38 = new ModelRenderer(this);
		bone38.setPos(0.0F, 0.0F, 0.0F);
		bone37.addChild(bone38);
		setRotationAngle(bone38, 0.0F, -1.0472F, 0.0F);
		bone38.texOffs(4, 4).addBox(-1.0F, -2.0F, 11.7F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone39 = new ModelRenderer(this);
		bone39.setPos(0.0F, 0.0F, 0.0F);
		bone38.addChild(bone39);
		setRotationAngle(bone39, 0.0F, -1.0472F, 0.0F);
		bone39.texOffs(4, 4).addBox(-1.0F, -2.0F, 11.7F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone40 = new ModelRenderer(this);
		bone40.setPos(0.0F, 0.0F, 0.0F);
		bone39.addChild(bone40);
		setRotationAngle(bone40, 0.0F, -1.0472F, 0.0F);
		bone40.texOffs(4, 4).addBox(-1.0F, -2.0F, 11.7F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone41 = new ModelRenderer(this);
		bone41.setPos(0.0F, 0.0F, 0.0F);
		bone40.addChild(bone41);
		setRotationAngle(bone41, 0.0F, -1.0472F, 0.0F);
		bone41.texOffs(4, 4).addBox(-1.0F, -2.0F, 11.7F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone42 = new ModelRenderer(this);
		bone42.setPos(0.0F, 0.0F, 0.0F);
		bone41.addChild(bone42);
		setRotationAngle(bone42, 0.0F, -1.0472F, 0.0F);
		bone42.texOffs(4, 4).addBox(-1.0F, -2.0F, 11.7F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setPos(0.0F, -2.0F, 0.0F);
		frame.addChild(bone7);
		bone7.texOffs(24, 47).addBox(-5.5F, -34.0F, 10.525F, 11.0F, 4.0F, 1.0F, 0.0F, false);
		bone7.texOffs(52, 33).addBox(-5.5F, -23.0F, 10.025F, 11.0F, 3.0F, 1.0F, 0.0F, false);
		bone7.texOffs(52, 33).addBox(-5.5F, -14.0F, 10.025F, 11.0F, 3.0F, 1.0F, 0.0F, false);
		bone7.texOffs(24, 42).addBox(-5.5F, -4.0F, 10.025F, 11.0F, 4.0F, 1.0F, 0.0F, false);
		bone7.texOffs(60, 60).addBox(-5.5F, -11.0F, 10.525F, 11.0F, 7.0F, 4.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setPos(0.0F, 0.0F, 0.0F);
		bone7.addChild(bone8);
		setRotationAngle(bone8, 0.0F, -1.0472F, 0.0F);
		bone8.texOffs(24, 47).addBox(-5.5F, -34.0F, 10.525F, 11.0F, 4.0F, 1.0F, 0.0F, false);
		bone8.texOffs(52, 33).addBox(-5.5F, -23.0F, 10.025F, 11.0F, 3.0F, 1.0F, 0.0F, false);
		bone8.texOffs(52, 33).addBox(-5.5F, -14.0F, 10.025F, 11.0F, 3.0F, 1.0F, 0.0F, false);
		bone8.texOffs(24, 42).addBox(-5.5F, -4.0F, 10.025F, 11.0F, 4.0F, 1.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setPos(0.0F, 0.0F, 0.0F);
		bone8.addChild(bone9);
		setRotationAngle(bone9, 0.0F, -1.0472F, 0.0F);
		bone9.texOffs(24, 47).addBox(-5.5F, -34.0F, 10.525F, 11.0F, 4.0F, 1.0F, 0.0F, false);
		bone9.texOffs(52, 33).addBox(-5.5F, -23.0F, 10.025F, 11.0F, 3.0F, 1.0F, 0.0F, false);
		bone9.texOffs(52, 33).addBox(-5.5F, -14.0F, 10.025F, 11.0F, 3.0F, 1.0F, 0.0F, false);
		bone9.texOffs(24, 42).addBox(-5.5F, -4.0F, 10.025F, 11.0F, 4.0F, 1.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setPos(0.0F, 0.0F, 0.0F);
		bone9.addChild(bone10);
		setRotationAngle(bone10, 0.0F, -1.0472F, 0.0F);
		bone10.texOffs(77, 32).addBox(-5.5F, -34.0F, 9.525F, 11.0F, 2.0F, 2.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setPos(0.0F, 0.0F, 0.0F);
		bone10.addChild(bone11);
		setRotationAngle(bone11, 0.0F, -1.0472F, 0.0F);
		bone11.texOffs(24, 47).addBox(-5.5F, -34.0F, 10.525F, 11.0F, 4.0F, 1.0F, 0.0F, false);
		bone11.texOffs(52, 33).addBox(-5.5F, -23.0F, 10.025F, 11.0F, 3.0F, 1.0F, 0.0F, false);
		bone11.texOffs(60, 71).addBox(-3.5F, -22.0F, 10.025F, 7.0F, 10.0F, 4.0F, 0.0F, false);
		bone11.texOffs(76, 0).addBox(-2.5F, -34.0F, 9.025F, 3.0F, 12.0F, 3.0F, 0.0F, false);
		bone11.texOffs(52, 33).addBox(-5.5F, -14.0F, 10.025F, 11.0F, 3.0F, 1.0F, 0.0F, false);
		bone11.texOffs(24, 42).addBox(-5.5F, -4.0F, 10.025F, 11.0F, 4.0F, 1.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setPos(0.0F, 0.0F, 0.0F);
		bone11.addChild(bone12);
		setRotationAngle(bone12, 0.0F, -1.0472F, 0.0F);
		bone12.texOffs(24, 47).addBox(-5.5F, -34.0F, 10.525F, 11.0F, 4.0F, 1.0F, 0.0F, false);
		bone12.texOffs(52, 33).addBox(-5.5F, -23.0F, 10.025F, 11.0F, 3.0F, 1.0F, 0.0F, false);
		bone12.texOffs(52, 33).addBox(-5.5F, -14.0F, 10.025F, 11.0F, 3.0F, 1.0F, 0.0F, false);
		bone12.texOffs(24, 42).addBox(-5.5F, -4.0F, 10.025F, 11.0F, 4.0F, 1.0F, 0.0F, false);

		bone31 = new ModelRenderer(this);
		bone31.setPos(0.0F, -2.0F, 0.0F);
		frame.addChild(bone31);
		setRotationAngle(bone31, 0.0F, -0.5236F, 0.0F);
		bone31.texOffs(48, 54).addBox(-1.0F, -34.0F, 8.875F, 2.0F, 34.0F, 4.0F, 0.0F, false);

		bone32 = new ModelRenderer(this);
		bone32.setPos(0.0F, 0.0F, 0.0F);
		bone31.addChild(bone32);
		setRotationAngle(bone32, 0.0F, -1.0472F, 0.0F);
		bone32.texOffs(48, 54).addBox(-1.0F, -34.0F, 8.875F, 2.0F, 34.0F, 4.0F, 0.0F, false);

		bone33 = new ModelRenderer(this);
		bone33.setPos(0.0F, 0.0F, 0.0F);
		bone32.addChild(bone33);
		setRotationAngle(bone33, 0.0F, -1.0472F, 0.0F);
		bone33.texOffs(50, 56).addBox(-1.0F, -34.0F, 10.875F, 2.0F, 34.0F, 2.0F, 0.0F, false);

		bone34 = new ModelRenderer(this);
		bone34.setPos(0.0F, 0.0F, 0.0F);
		bone33.addChild(bone34);
		setRotationAngle(bone34, 0.0F, -1.0472F, 0.0F);
		bone34.texOffs(50, 56).addBox(-1.0F, -34.0F, 10.875F, 2.0F, 34.0F, 2.0F, 0.0F, false);

		bone35 = new ModelRenderer(this);
		bone35.setPos(0.0F, 0.0F, 0.0F);
		bone34.addChild(bone35);
		setRotationAngle(bone35, 0.0F, -1.0472F, 0.0F);
		bone35.texOffs(48, 54).addBox(-1.0F, -34.0F, 8.875F, 2.0F, 34.0F, 4.0F, 0.0F, false);

		bone36 = new ModelRenderer(this);
		bone36.setPos(0.0F, 0.0F, 0.0F);
		bone35.addChild(bone36);
		setRotationAngle(bone36, 0.0F, -1.0472F, 0.0F);
		bone36.texOffs(48, 54).addBox(-1.0F, -34.0F, 8.875F, 2.0F, 34.0F, 4.0F, 0.0F, false);

		bone25 = new ModelRenderer(this);
		bone25.setPos(0.0F, -36.0F, 0.0F);
		frame.addChild(bone25);
		setRotationAngle(bone25, 0.0F, -0.5236F, 0.0F);
		bone25.texOffs(0, 0).addBox(-0.5F, -8.0F, 12.85F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		bone26 = new ModelRenderer(this);
		bone26.setPos(0.0F, 0.0F, 0.0F);
		bone25.addChild(bone26);
		setRotationAngle(bone26, 0.0F, -1.0472F, 0.0F);
		bone26.texOffs(0, 0).addBox(-0.5F, -8.0F, 12.85F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		bone27 = new ModelRenderer(this);
		bone27.setPos(0.0F, 0.0F, 0.0F);
		bone26.addChild(bone27);
		setRotationAngle(bone27, 0.0F, -1.0472F, 0.0F);
		bone27.texOffs(0, 0).addBox(-0.5F, -8.0F, 12.85F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		bone28 = new ModelRenderer(this);
		bone28.setPos(0.0F, 0.0F, 0.0F);
		bone27.addChild(bone28);
		setRotationAngle(bone28, 0.0F, -1.0472F, 0.0F);
		bone28.texOffs(0, 0).addBox(-0.5F, -8.0F, 12.85F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		bone29 = new ModelRenderer(this);
		bone29.setPos(0.0F, 0.0F, 0.0F);
		bone28.addChild(bone29);
		setRotationAngle(bone29, 0.0F, -1.0472F, 0.0F);
		bone29.texOffs(0, 0).addBox(-0.5F, -8.0F, 12.85F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		bone30 = new ModelRenderer(this);
		bone30.setPos(0.0F, 0.0F, 0.0F);
		bone29.addChild(bone30);
		setRotationAngle(bone30, 0.0F, -1.0472F, 0.0F);
		bone30.texOffs(0, 0).addBox(-0.5F, -8.0F, 12.85F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		bone19 = new ModelRenderer(this);
		bone19.setPos(0.0F, -36.0F, 0.0F);
		frame.addChild(bone19);
		bone19.texOffs(0, 0).addBox(-6.5F, -8.0F, -0.775F, 13.0F, 8.0F, 13.0F, 0.0F, false);

		bone20 = new ModelRenderer(this);
		bone20.setPos(0.0F, 0.0F, 0.0F);
		bone19.addChild(bone20);
		setRotationAngle(bone20, 0.0F, -1.0472F, 0.0F);
		bone20.texOffs(0, 0).addBox(-6.5F, -8.0F, -0.775F, 13.0F, 8.0F, 13.0F, 0.0F, false);

		bone21 = new ModelRenderer(this);
		bone21.setPos(0.0F, 0.0F, 0.0F);
		bone20.addChild(bone21);
		setRotationAngle(bone21, 0.0F, -1.0472F, 0.0F);
		bone21.texOffs(0, 0).addBox(-6.5F, -8.0F, -0.775F, 13.0F, 8.0F, 13.0F, 0.0F, false);

		bone22 = new ModelRenderer(this);
		bone22.setPos(0.0F, 0.0F, 0.0F);
		bone21.addChild(bone22);
		setRotationAngle(bone22, 0.0F, -1.0472F, 0.0F);
		bone22.texOffs(0, 21).addBox(-6.5F, -8.0F, -0.775F, 13.0F, 8.0F, 13.0F, 0.0F, false);

		bone23 = new ModelRenderer(this);
		bone23.setPos(0.0F, 0.0F, 0.0F);
		bone22.addChild(bone23);
		setRotationAngle(bone23, 0.0F, -1.0472F, 0.0F);
		bone23.texOffs(0, 0).addBox(-6.5F, -8.0F, -0.775F, 13.0F, 8.0F, 13.0F, 0.0F, false);

		bone24 = new ModelRenderer(this);
		bone24.setPos(0.0F, 0.0F, 0.0F);
		bone23.addChild(bone24);
		setRotationAngle(bone24, 0.0F, -1.0472F, 0.0F);
		bone24.texOffs(0, 0).addBox(-6.5F, -8.0F, -0.775F, 13.0F, 8.0F, 13.0F, 0.0F, false);

		bone43 = new ModelRenderer(this);
		bone43.setPos(0.0F, -36.0F, 0.0F);
		frame.addChild(bone43);
		bone43.texOffs(0, 0).addBox(-6.5F, -8.0F, -0.775F, 13.0F, 8.0F, 13.0F, 0.0F, false);

		bone44 = new ModelRenderer(this);
		bone44.setPos(0.0F, 0.0F, 0.0F);
		bone43.addChild(bone44);
		setRotationAngle(bone44, 0.0F, -1.0472F, 0.0F);
		bone44.texOffs(0, 0).addBox(-6.5F, -8.0F, -0.775F, 13.0F, 8.0F, 13.0F, 0.0F, false);

		bone45 = new ModelRenderer(this);
		bone45.setPos(0.0F, 0.0F, 0.0F);
		bone44.addChild(bone45);
		setRotationAngle(bone45, 0.0F, -1.0472F, 0.0F);
		bone45.texOffs(0, 0).addBox(-6.5F, -8.0F, -0.775F, 13.0F, 8.0F, 13.0F, 0.0F, false);

		bone46 = new ModelRenderer(this);
		bone46.setPos(0.0F, 0.0F, 0.0F);
		bone45.addChild(bone46);
		setRotationAngle(bone46, 0.0F, -1.0472F, 0.0F);
		bone46.texOffs(0, 21).addBox(-6.5F, -8.0F, -0.775F, 13.0F, 8.0F, 13.0F, 0.0F, false);

		bone47 = new ModelRenderer(this);
		bone47.setPos(0.0F, 0.0F, 0.0F);
		bone46.addChild(bone47);
		setRotationAngle(bone47, 0.0F, -1.0472F, 0.0F);
		bone47.texOffs(0, 0).addBox(-6.5F, -8.0F, -0.775F, 13.0F, 8.0F, 13.0F, 0.0F, false);

		bone48 = new ModelRenderer(this);
		bone48.setPos(0.0F, 0.0F, 0.0F);
		bone47.addChild(bone48);
		setRotationAngle(bone48, 0.0F, -1.0472F, 0.0F);
		bone48.texOffs(0, 0).addBox(-6.5F, -8.0F, -0.775F, 13.0F, 8.0F, 13.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setPos(0.0F, -2.0F, 0.0F);
		frame.addChild(bone13);
		bone13.texOffs(0, 42).addBox(-5.5F, -34.0F, 9.525F, 11.0F, 34.0F, 1.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setPos(0.0F, 0.0F, 0.0F);
		bone13.addChild(bone14);
		setRotationAngle(bone14, 0.0F, -1.0472F, 0.0F);
		bone14.texOffs(0, 42).addBox(-5.5F, -34.0F, 9.525F, 11.0F, 34.0F, 1.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setPos(0.0F, 0.0F, 0.0F);
		bone14.addChild(bone15);
		setRotationAngle(bone15, 0.0F, -1.0472F, 0.0F);
		bone15.texOffs(0, 42).addBox(-5.5F, -34.0F, 9.525F, 11.0F, 34.0F, 1.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setPos(0.0F, 0.0F, 0.0F);
		bone15.addChild(bone16);
		setRotationAngle(bone16, 0.0F, -1.0472F, 0.0F);
		

		bone17 = new ModelRenderer(this);
		bone17.setPos(0.0F, 0.0F, 0.0F);
		bone16.addChild(bone17);
		setRotationAngle(bone17, 0.0F, -1.0472F, 0.0F);
		bone17.texOffs(0, 42).addBox(-5.5F, -34.0F, 9.525F, 11.0F, 34.0F, 1.0F, 0.0F, false);

		bone18 = new ModelRenderer(this);
		bone18.setPos(0.0F, 0.0F, 0.0F);
		bone17.addChild(bone18);
		setRotationAngle(bone18, 0.0F, -1.0472F, 0.0F);
		bone18.texOffs(0, 42).addBox(-5.5F, -34.0F, 9.525F, 11.0F, 34.0F, 1.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setPos(0.0F, 0.0F, 0.0F);
		frame.addChild(bone);
		bone.texOffs(39, 39).addBox(-6.0F, -2.0F, -0.625F, 12.0F, 2.0F, 13.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setPos(0.0F, 0.0F, 0.0F);
		bone.addChild(bone2);
		setRotationAngle(bone2, 0.0F, -1.0472F, 0.0F);
		bone2.texOffs(39, 39).addBox(-6.0F, -2.0F, -0.625F, 12.0F, 2.0F, 13.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setPos(0.0F, 0.0F, 0.0F);
		bone2.addChild(bone3);
		setRotationAngle(bone3, 0.0F, -1.0472F, 0.0F);
		bone3.texOffs(39, 39).addBox(-6.0F, -2.0F, -0.625F, 12.0F, 2.0F, 13.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setPos(0.0F, 0.0F, 0.0F);
		bone3.addChild(bone4);
		setRotationAngle(bone4, 0.0F, -1.0472F, 0.0F);
		bone4.texOffs(39, 39).addBox(-6.0F, -2.0F, -0.625F, 12.0F, 2.0F, 13.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setPos(0.0F, 0.0F, 0.0F);
		bone4.addChild(bone5);
		setRotationAngle(bone5, 0.0F, -1.0472F, 0.0F);
		bone5.texOffs(39, 39).addBox(-6.0F, -2.0F, -0.625F, 12.0F, 2.0F, 13.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setPos(0.0F, 0.0F, 0.0F);
		bone5.addChild(bone6);
		setRotationAngle(bone6, 0.0F, -1.0472F, 0.0F);
		bone6.texOffs(39, 39).addBox(-6.0F, -2.0F, -0.625F, 12.0F, 2.0F, 13.0F, 0.0F, false);

		glow = new ModelRenderer(this);
		glow.setPos(-1.0F, -16.0F, 8.8F);
		glow.texOffs(56, 54).addBox(-4.5F, 0.0F, -21.025F, 11.0F, 3.0F, 1.0F, 0.0F, false);

		bone49 = new ModelRenderer(this);
		bone49.setPos(1.0F, 38.0F, -8.8F);
		glow.addChild(bone49);
		bone49.texOffs(81, 38).addBox(-5.5F, -34.0F, 11.55F, 11.0F, 2.0F, 0.0F, 0.0F, false);

		bone50 = new ModelRenderer(this);
		bone50.setPos(0.0F, 0.0F, 0.0F);
		bone49.addChild(bone50);
		setRotationAngle(bone50, 0.0F, -1.0472F, 0.0F);
		bone50.texOffs(81, 38).addBox(-5.5F, -34.0F, 11.55F, 11.0F, 2.0F, 0.0F, 0.0F, false);

		bone51 = new ModelRenderer(this);
		bone51.setPos(0.0F, 0.0F, 0.0F);
		bone50.addChild(bone51);
		setRotationAngle(bone51, 0.0F, -1.0472F, 0.0F);
		bone51.texOffs(81, 38).addBox(-5.5F, -34.0F, 11.55F, 11.0F, 2.0F, 0.0F, 0.0F, false);

		bone52 = new ModelRenderer(this);
		bone52.setPos(0.0F, 0.0F, 0.0F);
		bone51.addChild(bone52);
		setRotationAngle(bone52, 0.0F, -1.0472F, 0.0F);
		

		bone53 = new ModelRenderer(this);
		bone53.setPos(0.0F, 0.0F, 0.0F);
		bone52.addChild(bone53);
		setRotationAngle(bone53, 0.0F, -1.0472F, 0.0F);
		bone53.texOffs(81, 38).addBox(-5.5F, -34.0F, 11.55F, 11.0F, 2.0F, 0.0F, 0.0F, false);

		bone54 = new ModelRenderer(this);
		bone54.setPos(0.0F, 0.0F, 0.0F);
		bone53.addChild(bone54);
		setRotationAngle(bone54, 0.0F, -1.0472F, 0.0F);
		bone54.texOffs(81, 38).addBox(-5.5F, -34.0F, 11.55F, 11.0F, 2.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		BOTI.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		door.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		frame.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		glow.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
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
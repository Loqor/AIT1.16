package com.mdt.ait.client.models.tileentities;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.TardisCoralTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TardisCoral extends EntityModel<Entity> {
	public final ModelRenderer state1;
	public final ModelRenderer cube_r1;
	public final ModelRenderer cube_r2;
	public final ModelRenderer state2;
	public final ModelRenderer cube_r3;
	public final ModelRenderer cube_r4;
	public final ModelRenderer state3;
	public final ModelRenderer cube_r5;
	public final ModelRenderer cube_r6;
	public final ModelRenderer state4;
	public final ModelRenderer cube_r7;
	public final ModelRenderer cube_r8;
	public final ModelRenderer bone43;
	public final ModelRenderer bone44;
	public final ModelRenderer bone45;
	public final ModelRenderer bone46;
	public final ModelRenderer bone47;
	public final ModelRenderer bone54;
	public final ModelRenderer bone55;
	public final ModelRenderer bone56;
	public final ModelRenderer bone57;
	public final ModelRenderer bone58;
	public final ModelRenderer bone59;
	public final ModelRenderer bone60;
	public final ModelRenderer state5;
	public final ModelRenderer bone30;
	public final ModelRenderer bone31;
	public final ModelRenderer bone32;
	public final ModelRenderer bone33;
	public final ModelRenderer bone34;
	public final ModelRenderer bone35;
	public final ModelRenderer bone48;
	public final ModelRenderer bone49;
	public final ModelRenderer bone50;
	public final ModelRenderer bone51;
	public final ModelRenderer bone52;
	public final ModelRenderer bone53;
	public final ModelRenderer bone36;
	public final ModelRenderer bone37;
	public final ModelRenderer bone38;
	public final ModelRenderer bone39;
	public final ModelRenderer bone40;
	public final ModelRenderer bone41;
	public final ModelRenderer finalstate;
	public final ModelRenderer bone5;
	public final ModelRenderer bone6;
	public final ModelRenderer bone7;
	public final ModelRenderer bone8;
	public final ModelRenderer bone9;
	public final ModelRenderer bone10;
	public final ModelRenderer bone23;
	public final ModelRenderer cube_r9;
	public final ModelRenderer cube_r10;
	public final ModelRenderer cube_r11;
	public final ModelRenderer bone24;
	public final ModelRenderer cube_r12;
	public final ModelRenderer cube_r13;
	public final ModelRenderer cube_r14;
	public final ModelRenderer bone25;
	public final ModelRenderer cube_r15;
	public final ModelRenderer cube_r16;
	public final ModelRenderer cube_r17;
	public final ModelRenderer bone26;
	public final ModelRenderer cube_r18;
	public final ModelRenderer cube_r19;
	public final ModelRenderer cube_r20;
	public final ModelRenderer bone27;
	public final ModelRenderer cube_r21;
	public final ModelRenderer cube_r22;
	public final ModelRenderer cube_r23;
	public final ModelRenderer bone28;
	public final ModelRenderer cube_r24;
	public final ModelRenderer cube_r25;
	public final ModelRenderer cube_r26;
	public final ModelRenderer bone11;
	public final ModelRenderer bone12;
	public final ModelRenderer bone13;
	public final ModelRenderer bone14;
	public final ModelRenderer bone15;
	public final ModelRenderer bone16;
	public final ModelRenderer bone17;
	public final ModelRenderer bone18;
	public final ModelRenderer bone19;
	public final ModelRenderer bone20;
	public final ModelRenderer bone21;
	public final ModelRenderer bone22;

	public TardisCoral() {
		texWidth = 128;
		texHeight = 128;

		state1 = new ModelRenderer(this);
		state1.setPos(0.0F, 24.0F, 0.0F);
		state1.texOffs(0, 0).addBox(-7.0F, -0.025F, -7.0F, 14.0F, 1.0F, 14.0F, 0.005F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		state1.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.7854F, 0.0F);
		cube_r1.texOffs(0, 16).addBox(-9.0F, -10.0F, 0.0F, 18.0F, 10.0F, 1.0F, 0.005F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, 0.0F, 0.0F);
		state1.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -0.7854F, 0.0F);
		cube_r2.texOffs(0, 16).addBox(-9.0F, -10.0F, 0.0F, 18.0F, 10.0F, 1.0F, 0.005F, false);

		state2 = new ModelRenderer(this);
		state2.setPos(0.0F, 24.0F, 0.0F);
		state2.texOffs(0, 0).addBox(-9.0F, -3.025F, -9.0F, 18.0F, 3.0F, 18.0F, 0.005F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, 0.0F, 0.0F);
		state2.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.7854F, 0.0F);
		cube_r3.texOffs(0, 22).addBox(-11.0F, -18.0F, 0.0F, 22.0F, 18.0F, 1.0F, 0.005F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(0.0F, 0.0F, 0.0F);
		state2.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, -0.7854F, 0.0F);
		cube_r4.texOffs(0, 22).addBox(-11.0F, -18.0F, 0.0F, 22.0F, 18.0F, 1.0F, 0.005F, false);

		state3 = new ModelRenderer(this);
		state3.setPos(0.0F, 24.0F, 0.0F);
		state3.texOffs(0, 0).addBox(-9.0F, -17.025F, -9.0F, 18.0F, 17.0F, 18.0F, 0.005F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(0.0F, 0.0F, 0.0F);
		state3.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.7854F, 0.0F);
		cube_r5.texOffs(0, 35).addBox(-11.0F, -30.0F, 0.0F, 22.0F, 30.0F, 1.0F, 0.005F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.0F, 0.0F, 0.0F);
		state3.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, -0.7854F, 0.0F);
		cube_r6.texOffs(0, 35).addBox(-11.0F, -30.0F, 0.0F, 22.0F, 30.0F, 1.0F, 0.005F, false);

		state4 = new ModelRenderer(this);
		state4.setPos(0.0F, 24.0F, 0.0F);
		

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(0.0F, 0.0F, 0.0F);
		state4.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.7854F, 0.0F);
		cube_r7.texOffs(0, 0).addBox(-11.0F, -39.0F, 0.0F, 22.0F, 39.0F, 1.0F, 0.005F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(0.0F, 0.0F, 0.0F);
		state4.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, -0.7854F, 0.0F);
		cube_r8.texOffs(0, 0).addBox(-11.0F, -39.0F, 0.0F, 22.0F, 39.0F, 1.0F, 0.005F, false);

		bone43 = new ModelRenderer(this);
		bone43.setPos(0.0F, -24.025F, 0.0F);
		state4.addChild(bone43);
		bone43.texOffs(0, 41).addBox(-5.5F, -10.0F, 8.5F, 11.0F, 34.0F, 1.0F, 0.005F, false);

		bone44 = new ModelRenderer(this);
		bone44.setPos(0.0F, 0.0F, 0.0F);
		bone43.addChild(bone44);
		setRotationAngle(bone44, 0.0F, -1.0472F, 0.0F);
		bone44.texOffs(0, 41).addBox(-5.5F, -10.0F, 8.5F, 11.0F, 34.0F, 1.0F, 0.005F, false);

		bone45 = new ModelRenderer(this);
		bone45.setPos(0.0F, 0.0F, 0.0F);
		bone44.addChild(bone45);
		setRotationAngle(bone45, 0.0F, -1.0472F, 0.0F);
		bone45.texOffs(0, 41).addBox(-5.5F, -10.0F, 8.5F, 11.0F, 34.0F, 1.0F, 0.005F, false);

		bone46 = new ModelRenderer(this);
		bone46.setPos(0.0F, 0.0F, 0.0F);
		bone45.addChild(bone46);
		setRotationAngle(bone46, 0.0F, -1.0472F, 0.0F);
		bone46.texOffs(0, 41).addBox(-5.5F, -10.0F, 8.5F, 11.0F, 34.0F, 1.0F, 0.005F, false);

		bone47 = new ModelRenderer(this);
		bone47.setPos(0.0F, 0.0F, 0.0F);
		bone46.addChild(bone47);
		setRotationAngle(bone47, 0.0F, -1.0472F, 0.0F);
		bone47.texOffs(0, 41).addBox(-5.5F, -10.0F, 8.5F, 11.0F, 34.0F, 1.0F, 0.005F, false);

		bone54 = new ModelRenderer(this);
		bone54.setPos(0.0F, 0.0F, 0.0F);
		bone47.addChild(bone54);
		setRotationAngle(bone54, 0.0F, -1.0472F, 0.0F);
		bone54.texOffs(0, 41).addBox(-5.5F, -10.0F, 8.5F, 11.0F, 34.0F, 1.0F, 0.005F, false);

		bone55 = new ModelRenderer(this);
		bone55.setPos(0.0F, 22.975F, 0.0F);
		state4.addChild(bone55);
		bone55.texOffs(37, 31).addBox(-5.5F, -23.05F, -0.5F, 11.0F, 1.0F, 10.0F, 0.005F, false);

		bone56 = new ModelRenderer(this);
		bone56.setPos(0.0F, 0.0F, 0.0F);
		bone55.addChild(bone56);
		setRotationAngle(bone56, 0.0F, -1.0472F, 0.0F);
		bone56.texOffs(37, 31).addBox(-5.5F, -23.075F, -0.5F, 11.0F, 1.0F, 10.0F, 0.005F, false);

		bone57 = new ModelRenderer(this);
		bone57.setPos(0.0F, 0.0F, 0.0F);
		bone56.addChild(bone57);
		setRotationAngle(bone57, 0.0F, -1.0472F, 0.0F);
		bone57.texOffs(37, 31).addBox(-5.5F, -23.05F, -0.5F, 11.0F, 1.0F, 10.0F, 0.005F, false);

		bone58 = new ModelRenderer(this);
		bone58.setPos(0.0F, 0.0F, 0.0F);
		bone57.addChild(bone58);
		setRotationAngle(bone58, 0.0F, -1.0472F, 0.0F);
		bone58.texOffs(37, 31).addBox(-5.5F, -23.075F, -0.5F, 11.0F, 1.0F, 10.0F, 0.005F, false);

		bone59 = new ModelRenderer(this);
		bone59.setPos(0.0F, 0.0F, 0.0F);
		bone58.addChild(bone59);
		setRotationAngle(bone59, 0.0F, -1.0472F, 0.0F);
		bone59.texOffs(37, 31).addBox(-5.5F, -23.05F, -0.5F, 11.0F, 1.0F, 10.0F, 0.005F, false);

		bone60 = new ModelRenderer(this);
		bone60.setPos(0.0F, 0.0F, 0.0F);
		bone59.addChild(bone60);
		setRotationAngle(bone60, 0.0F, -1.0472F, 0.0F);
		bone60.texOffs(37, 31).addBox(-5.5F, -23.075F, -0.5F, 11.0F, 1.0F, 10.0F, 0.005F, false);

		state5 = new ModelRenderer(this);
		state5.setPos(0.0F, 24.0F, 0.0F);
		state5.texOffs(0, 0).addBox(-5.5F, -40.025F, -5.5F, 11.0F, 40.0F, 11.0F, 0.005F, false);

		bone30 = new ModelRenderer(this);
		bone30.setPos(0.0F, -24.025F, 0.0F);
		state5.addChild(bone30);
		bone30.texOffs(45, 0).addBox(-5.5F, -15.0F, 8.5F, 11.0F, 39.0F, 1.0F, 0.005F, false);

		bone31 = new ModelRenderer(this);
		bone31.setPos(0.0F, 0.0F, 0.0F);
		bone30.addChild(bone31);
		setRotationAngle(bone31, 0.0F, -1.0472F, 0.0F);
		bone31.texOffs(45, 0).addBox(-5.5F, -15.0F, 8.5F, 11.0F, 39.0F, 1.0F, 0.005F, false);

		bone32 = new ModelRenderer(this);
		bone32.setPos(0.0F, 0.0F, 0.0F);
		bone31.addChild(bone32);
		setRotationAngle(bone32, 0.0F, -1.0472F, 0.0F);
		bone32.texOffs(45, 0).addBox(-5.5F, -15.0F, 8.5F, 11.0F, 39.0F, 1.0F, 0.005F, false);

		bone33 = new ModelRenderer(this);
		bone33.setPos(0.0F, 0.0F, 0.0F);
		bone32.addChild(bone33);
		setRotationAngle(bone33, 0.0F, -1.0472F, 0.0F);
		bone33.texOffs(45, 0).addBox(-5.5F, -15.0F, 8.5F, 11.0F, 39.0F, 1.0F, 0.005F, false);

		bone34 = new ModelRenderer(this);
		bone34.setPos(0.0F, 0.0F, 0.0F);
		bone33.addChild(bone34);
		setRotationAngle(bone34, 0.0F, -1.0472F, 0.0F);
		bone34.texOffs(45, 0).addBox(-5.5F, -15.0F, 8.5F, 11.0F, 39.0F, 1.0F, 0.005F, false);

		bone35 = new ModelRenderer(this);
		bone35.setPos(0.0F, 0.0F, 0.0F);
		bone34.addChild(bone35);
		setRotationAngle(bone35, 0.0F, -1.0472F, 0.0F);
		bone35.texOffs(45, 0).addBox(-5.5F, -15.0F, 8.5F, 11.0F, 39.0F, 1.0F, 0.005F, false);

		bone48 = new ModelRenderer(this);
		bone48.setPos(0.0F, 22.975F, 0.0F);
		state5.addChild(bone48);
		bone48.texOffs(0, 52).addBox(-5.0F, -23.05F, -0.5F, 10.0F, 1.0F, 9.0F, 0.005F, false);

		bone49 = new ModelRenderer(this);
		bone49.setPos(0.0F, 0.0F, 0.0F);
		bone48.addChild(bone49);
		setRotationAngle(bone49, 0.0F, -1.0472F, 0.0F);
		bone49.texOffs(0, 52).addBox(-5.0F, -23.075F, -0.5F, 10.0F, 1.0F, 9.0F, 0.005F, false);

		bone50 = new ModelRenderer(this);
		bone50.setPos(0.0F, 0.0F, 0.0F);
		bone49.addChild(bone50);
		setRotationAngle(bone50, 0.0F, -1.0472F, 0.0F);
		bone50.texOffs(0, 52).addBox(-5.0F, -23.05F, -0.5F, 10.0F, 1.0F, 9.0F, 0.005F, false);

		bone51 = new ModelRenderer(this);
		bone51.setPos(0.0F, 0.0F, 0.0F);
		bone50.addChild(bone51);
		setRotationAngle(bone51, 0.0F, -1.0472F, 0.0F);
		bone51.texOffs(0, 52).addBox(-5.0F, -23.075F, -0.5F, 10.0F, 1.0F, 9.0F, 0.005F, false);

		bone52 = new ModelRenderer(this);
		bone52.setPos(0.0F, 0.0F, 0.0F);
		bone51.addChild(bone52);
		setRotationAngle(bone52, 0.0F, -1.0472F, 0.0F);
		bone52.texOffs(0, 52).addBox(-5.0F, -23.05F, -0.5F, 10.0F, 1.0F, 9.0F, 0.005F, false);

		bone53 = new ModelRenderer(this);
		bone53.setPos(0.0F, 0.0F, 0.0F);
		bone52.addChild(bone53);
		setRotationAngle(bone53, 0.0F, -1.0472F, 0.0F);
		bone53.texOffs(0, 52).addBox(-5.0F, -23.075F, -0.5F, 10.0F, 1.0F, 9.0F, 0.005F, false);

		bone36 = new ModelRenderer(this);
		bone36.setPos(0.0F, -16.025F, 0.0F);
		state5.addChild(bone36);
		bone36.texOffs(36, 43).addBox(-5.0F, -22.975F, -0.5F, 10.0F, 1.0F, 9.0F, 0.005F, false);

		bone37 = new ModelRenderer(this);
		bone37.setPos(0.0F, 0.0F, 0.0F);
		bone36.addChild(bone37);
		setRotationAngle(bone37, 0.0F, -1.0472F, 0.0F);
		bone37.texOffs(36, 43).addBox(-5.0F, -23.0F, -0.5F, 10.0F, 1.0F, 9.0F, 0.005F, false);

		bone38 = new ModelRenderer(this);
		bone38.setPos(0.0F, 0.0F, 0.0F);
		bone37.addChild(bone38);
		setRotationAngle(bone38, 0.0F, -1.0472F, 0.0F);
		bone38.texOffs(36, 43).addBox(-5.0F, -22.975F, -0.5F, 10.0F, 1.0F, 9.0F, 0.005F, false);

		bone39 = new ModelRenderer(this);
		bone39.setPos(0.0F, 0.0F, 0.0F);
		bone38.addChild(bone39);
		setRotationAngle(bone39, 0.0F, -1.0472F, 0.0F);
		bone39.texOffs(36, 43).addBox(-5.0F, -23.0F, -0.5F, 10.0F, 1.0F, 9.0F, 0.005F, false);

		bone40 = new ModelRenderer(this);
		bone40.setPos(0.0F, 0.0F, 0.0F);
		bone39.addChild(bone40);
		setRotationAngle(bone40, 0.0F, -1.0472F, 0.0F);
		bone40.texOffs(36, 43).addBox(-5.0F, -22.975F, -0.5F, 10.0F, 1.0F, 9.0F, 0.005F, false);

		bone41 = new ModelRenderer(this);
		bone41.setPos(0.0F, 0.0F, 0.0F);
		bone40.addChild(bone41);
		setRotationAngle(bone41, 0.0F, -1.0472F, 0.0F);
		bone41.texOffs(36, 43).addBox(-5.0F, -23.0F, -0.5F, 10.0F, 1.0F, 9.0F, 0.005F, false);

		finalstate = new ModelRenderer(this);
		finalstate.setPos(0.0F, 24.0F, 0.0F);
		

		bone5 = new ModelRenderer(this);
		bone5.setPos(0.0F, -24.025F, 0.0F);
		finalstate.addChild(bone5);
		bone5.texOffs(0, 0).addBox(-7.5F, -24.0F, 12.0F, 15.0F, 48.0F, 1.0F, 0.005F, false);

		bone6 = new ModelRenderer(this);
		bone6.setPos(0.0F, 0.0F, 0.0F);
		bone5.addChild(bone6);
		setRotationAngle(bone6, 0.0F, -1.0472F, 0.0F);
		bone6.texOffs(0, 0).addBox(-7.5F, -24.0F, 12.0F, 15.0F, 48.0F, 1.0F, 0.005F, false);

		bone7 = new ModelRenderer(this);
		bone7.setPos(0.0F, 0.0F, 0.0F);
		bone6.addChild(bone7);
		setRotationAngle(bone7, 0.0F, -1.0472F, 0.0F);
		bone7.texOffs(0, 0).addBox(-7.5F, -24.0F, 12.0F, 15.0F, 48.0F, 1.0F, 0.005F, false);

		bone8 = new ModelRenderer(this);
		bone8.setPos(0.0F, 0.0F, 0.0F);
		bone7.addChild(bone8);
		setRotationAngle(bone8, 0.0F, -1.0472F, 0.0F);
		bone8.texOffs(0, 0).addBox(-7.5F, -24.0F, 12.0F, 15.0F, 48.0F, 1.0F, 0.005F, false);

		bone9 = new ModelRenderer(this);
		bone9.setPos(0.0F, 0.0F, 0.0F);
		bone8.addChild(bone9);
		setRotationAngle(bone9, 0.0F, -1.0472F, 0.0F);
		bone9.texOffs(0, 0).addBox(-7.5F, -24.0F, 12.0F, 15.0F, 48.0F, 1.0F, 0.005F, false);

		bone10 = new ModelRenderer(this);
		bone10.setPos(0.0F, 0.0F, 0.0F);
		bone9.addChild(bone10);
		setRotationAngle(bone10, 0.0F, -1.0472F, 0.0F);
		bone10.texOffs(0, 0).addBox(-7.5F, -24.0F, 12.0F, 15.0F, 48.0F, 1.0F, 0.005F, false);

		bone23 = new ModelRenderer(this);
		bone23.setPos(0.0F, -24.025F, 0.0F);
		finalstate.addChild(bone23);
		

		cube_r9 = new ModelRenderer(this);
		cube_r9.setPos(0.0F, -22.0F, 13.0F);
		bone23.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0873F, 0.0F, 0.0F);
		cube_r9.texOffs(33, 14).addBox(-7.5F, 0.0F, -1.0F, 15.0F, 16.0F, 1.0F, 0.005F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setPos(0.0F, -3.0F, 13.0F);
		bone23.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0873F, 0.0F, 0.0F);
		cube_r10.texOffs(33, 32).addBox(-7.5F, 0.0F, -1.0F, 15.0F, 16.0F, 1.0F, 0.005F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setPos(0.0F, 14.0F, 13.0F);
		bone23.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.1745F, 0.0F, 0.0F);
		cube_r11.texOffs(0, 50).addBox(-7.5F, 0.0F, -1.0F, 15.0F, 9.0F, 1.0F, 0.005F, false);

		bone24 = new ModelRenderer(this);
		bone24.setPos(0.0F, 0.0F, 0.0F);
		bone23.addChild(bone24);
		setRotationAngle(bone24, 0.0F, -1.0472F, 0.0F);
		

		cube_r12 = new ModelRenderer(this);
		cube_r12.setPos(0.0F, -22.0F, 13.0F);
		bone24.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0873F, 0.0F, 0.0F);
		cube_r12.texOffs(33, 14).addBox(-7.5F, 0.0F, -1.0F, 15.0F, 16.0F, 1.0F, 0.005F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setPos(0.0F, -3.0F, 13.0F);
		bone24.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0873F, 0.0F, 0.0F);
		cube_r13.texOffs(33, 32).addBox(-7.5F, 0.0F, -1.0F, 15.0F, 16.0F, 1.0F, 0.005F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setPos(0.0F, 14.0F, 13.0F);
		bone24.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.1745F, 0.0F, 0.0F);
		cube_r14.texOffs(0, 50).addBox(-7.5F, 0.0F, -1.0F, 15.0F, 9.0F, 1.0F, 0.005F, false);

		bone25 = new ModelRenderer(this);
		bone25.setPos(0.0F, 0.0F, 0.0F);
		bone24.addChild(bone25);
		setRotationAngle(bone25, 0.0F, -1.0472F, 0.0F);
		

		cube_r15 = new ModelRenderer(this);
		cube_r15.setPos(0.0F, -22.0F, 13.0F);
		bone25.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0873F, 0.0F, 0.0F);
		cube_r15.texOffs(33, 14).addBox(-7.5F, 0.0F, -1.0F, 15.0F, 16.0F, 1.0F, 0.005F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setPos(0.0F, -3.0F, 13.0F);
		bone25.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0873F, 0.0F, 0.0F);
		cube_r16.texOffs(33, 32).addBox(-7.5F, 0.0F, -1.0F, 15.0F, 16.0F, 1.0F, 0.005F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setPos(0.0F, 14.0F, 13.0F);
		bone25.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.1745F, 0.0F, 0.0F);
		cube_r17.texOffs(0, 50).addBox(-7.5F, 0.0F, -1.0F, 15.0F, 9.0F, 1.0F, 0.005F, false);

		bone26 = new ModelRenderer(this);
		bone26.setPos(0.0F, 0.0F, 0.0F);
		bone25.addChild(bone26);
		setRotationAngle(bone26, 0.0F, -1.0472F, 0.0F);
		

		cube_r18 = new ModelRenderer(this);
		cube_r18.setPos(0.0F, -22.0F, 13.0F);
		bone26.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0873F, 0.0F, 0.0F);
		cube_r18.texOffs(33, 14).addBox(-7.5F, 0.0F, -1.0F, 15.0F, 16.0F, 1.0F, 0.005F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setPos(0.0F, -3.0F, 13.0F);
		bone26.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0873F, 0.0F, 0.0F);
		cube_r19.texOffs(33, 32).addBox(-7.5F, 0.0F, -1.0F, 15.0F, 16.0F, 1.0F, 0.005F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setPos(0.0F, 14.0F, 13.0F);
		bone26.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.1745F, 0.0F, 0.0F);
		cube_r20.texOffs(0, 50).addBox(-7.5F, 0.0F, -1.0F, 15.0F, 9.0F, 1.0F, 0.005F, false);

		bone27 = new ModelRenderer(this);
		bone27.setPos(0.0F, 0.0F, 0.0F);
		bone26.addChild(bone27);
		setRotationAngle(bone27, 0.0F, -1.0472F, 0.0F);
		

		cube_r21 = new ModelRenderer(this);
		cube_r21.setPos(0.0F, -22.0F, 13.0F);
		bone27.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0873F, 0.0F, 0.0F);
		cube_r21.texOffs(33, 14).addBox(-7.5F, 0.0F, -1.0F, 15.0F, 16.0F, 1.0F, 0.005F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setPos(0.0F, -3.0F, 13.0F);
		bone27.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0873F, 0.0F, 0.0F);
		cube_r22.texOffs(33, 32).addBox(-7.5F, 0.0F, -1.0F, 15.0F, 16.0F, 1.0F, 0.005F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setPos(0.0F, 14.0F, 13.0F);
		bone27.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.1745F, 0.0F, 0.0F);
		cube_r23.texOffs(0, 50).addBox(-7.5F, 0.0F, -1.0F, 15.0F, 9.0F, 1.0F, 0.005F, false);

		bone28 = new ModelRenderer(this);
		bone28.setPos(0.0F, 0.0F, 0.0F);
		bone27.addChild(bone28);
		setRotationAngle(bone28, 0.0F, -1.0472F, 0.0F);
		

		cube_r24 = new ModelRenderer(this);
		cube_r24.setPos(0.0F, -22.0F, 13.0F);
		bone28.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.0873F, 0.0F, 0.0F);
		cube_r24.texOffs(33, 14).addBox(-7.5F, 0.0F, -1.0F, 15.0F, 16.0F, 1.0F, 0.005F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setPos(0.0F, -3.0F, 13.0F);
		bone28.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0873F, 0.0F, 0.0F);
		cube_r25.texOffs(33, 32).addBox(-7.5F, 0.0F, -1.0F, 15.0F, 16.0F, 1.0F, 0.005F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setPos(0.0F, 14.0F, 13.0F);
		bone28.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.1745F, 0.0F, 0.0F);
		cube_r26.texOffs(0, 50).addBox(-7.5F, 0.0F, -1.0F, 15.0F, 9.0F, 1.0F, 0.005F, false);

		bone11 = new ModelRenderer(this);
		bone11.setPos(0.0F, -24.025F, 0.0F);
		finalstate.addChild(bone11);
		bone11.texOffs(33, 0).addBox(-7.0F, -23.95F, 0.0F, 14.0F, 1.0F, 12.0F, 0.005F, false);

		bone12 = new ModelRenderer(this);
		bone12.setPos(0.0F, 0.0F, 0.0F);
		bone11.addChild(bone12);
		setRotationAngle(bone12, 0.0F, -1.0472F, 0.0F);
		bone12.texOffs(33, 0).addBox(-7.0F, -23.975F, 0.0F, 14.0F, 1.0F, 12.0F, 0.005F, false);

		bone13 = new ModelRenderer(this);
		bone13.setPos(0.0F, 0.0F, 0.0F);
		bone12.addChild(bone13);
		setRotationAngle(bone13, 0.0F, -1.0472F, 0.0F);
		bone13.texOffs(33, 0).addBox(-7.0F, -23.95F, 0.0F, 14.0F, 1.0F, 12.0F, 0.005F, false);

		bone14 = new ModelRenderer(this);
		bone14.setPos(0.0F, 0.0F, 0.0F);
		bone13.addChild(bone14);
		setRotationAngle(bone14, 0.0F, -1.0472F, 0.0F);
		bone14.texOffs(33, 0).addBox(-7.0F, -23.975F, 0.0F, 14.0F, 1.0F, 12.0F, 0.005F, false);

		bone15 = new ModelRenderer(this);
		bone15.setPos(0.0F, 0.0F, 0.0F);
		bone14.addChild(bone15);
		setRotationAngle(bone15, 0.0F, -1.0472F, 0.0F);
		bone15.texOffs(33, 0).addBox(-7.0F, -23.95F, 0.0F, 14.0F, 1.0F, 12.0F, 0.005F, false);

		bone16 = new ModelRenderer(this);
		bone16.setPos(0.0F, 0.0F, 0.0F);
		bone15.addChild(bone16);
		setRotationAngle(bone16, 0.0F, -1.0472F, 0.0F);
		bone16.texOffs(33, 0).addBox(-7.0F, -23.975F, 0.0F, 14.0F, 1.0F, 12.0F, 0.005F, false);

		bone17 = new ModelRenderer(this);
		bone17.setPos(0.0F, 22.975F, 0.0F);
		finalstate.addChild(bone17);
		bone17.texOffs(33, 0).addBox(-7.0F, -23.05F, 0.0F, 14.0F, 1.0F, 12.0F, 0.005F, false);

		bone18 = new ModelRenderer(this);
		bone18.setPos(0.0F, 0.0F, 0.0F);
		bone17.addChild(bone18);
		setRotationAngle(bone18, 0.0F, -1.0472F, 0.0F);
		bone18.texOffs(33, 0).addBox(-7.0F, -23.075F, 0.0F, 14.0F, 1.0F, 12.0F, 0.005F, false);

		bone19 = new ModelRenderer(this);
		bone19.setPos(0.0F, 0.0F, 0.0F);
		bone18.addChild(bone19);
		setRotationAngle(bone19, 0.0F, -1.0472F, 0.0F);
		bone19.texOffs(33, 0).addBox(-7.0F, -23.05F, 0.0F, 14.0F, 1.0F, 12.0F, 0.005F, false);

		bone20 = new ModelRenderer(this);
		bone20.setPos(0.0F, 0.0F, 0.0F);
		bone19.addChild(bone20);
		setRotationAngle(bone20, 0.0F, -1.0472F, 0.0F);
		bone20.texOffs(33, 0).addBox(-7.0F, -23.075F, 0.0F, 14.0F, 1.0F, 12.0F, 0.005F, false);

		bone21 = new ModelRenderer(this);
		bone21.setPos(0.0F, 0.0F, 0.0F);
		bone20.addChild(bone21);
		setRotationAngle(bone21, 0.0F, -1.0472F, 0.0F);
		bone21.texOffs(33, 0).addBox(-7.0F, -23.05F, 0.0F, 14.0F, 1.0F, 12.0F, 0.005F, false);

		bone22 = new ModelRenderer(this);
		bone22.setPos(0.0F, 0.0F, 0.0F);
		bone21.addChild(bone22);
		setRotationAngle(bone22, 0.0F, -1.0472F, 0.0F);
		bone22.texOffs(33, 0).addBox(-7.0F, -23.075F, 0.0F, 14.0F, 1.0F, 12.0F, 0.005F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		state1.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		state2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		state3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		state4.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		state5.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		finalstate.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(TardisCoralTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, i, i1, i2, i3);
	}
}
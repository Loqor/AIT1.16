package com.mdt.ait.client.models.tileentities;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.ToyotaWhirlagigTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ToyotaWhirlagig extends EntityModel<Entity> {
	public final ModelRenderer top;
	public final ModelRenderer cube_r1;
	public final ModelRenderer cube_r2;
	public final ModelRenderer cube_r3;
	public final ModelRenderer cube_r4;
	public final ModelRenderer cube_r5;
	public final ModelRenderer cube_r6;
	public final ModelRenderer cube_r7;
	public final ModelRenderer cube_r8;
	public final ModelRenderer cube_r9;
	public final ModelRenderer cube_r10;
	public final ModelRenderer cube_r11;
	public final ModelRenderer cube_r12;
	public final ModelRenderer cube_r13;
	public final ModelRenderer cube_r14;
	public final ModelRenderer cube_r15;
	public final ModelRenderer middle;
	public final ModelRenderer cube_r16;
	public final ModelRenderer cube_r17;
	public final ModelRenderer cube_r18;
	public final ModelRenderer cube_r19;
	public final ModelRenderer cube_r20;
	public final ModelRenderer cube_r21;
	public final ModelRenderer cube_r22;
	public final ModelRenderer cube_r23;
	public final ModelRenderer cube_r24;
	public final ModelRenderer cube_r25;
	public final ModelRenderer cube_r26;
	public final ModelRenderer cube_r27;
	public final ModelRenderer cube_r28;
	public final ModelRenderer cube_r29;
	public final ModelRenderer cube_r30;
	public final ModelRenderer cube_r31;
	public final ModelRenderer cube_r32;
	public final ModelRenderer bottom;
	public final ModelRenderer cube_r33;
	public final ModelRenderer cube_r34;
	public final ModelRenderer cube_r35;
	public final ModelRenderer cube_r36;
	public final ModelRenderer cube_r37;
	public final ModelRenderer cube_r38;
	public final ModelRenderer cube_r39;
	public final ModelRenderer cube_r40;
	public final ModelRenderer cube_r41;
	public final ModelRenderer cube_r42;
	public final ModelRenderer cube_r43;
	public final ModelRenderer cube_r44;
	public final ModelRenderer cube_r45;
	public final ModelRenderer cube_r46;
	public final ModelRenderer cube_r47;
	public final ModelRenderer bb_main;

	public ToyotaWhirlagig() {
		texWidth = 512;
		texHeight = 512;

		top = new ModelRenderer(this);
		top.setPos(0.0F, 8.0F, 0.0F);
		top.texOffs(107, 44).addBox(-20.0F, -16.0F, 10.632F, 40.0F, 8.0F, 26.0F, 0.003F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		top.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -2.618F, 0.0F);
		cube_r1.texOffs(0, 35).addBox(-1.0F, -16.0F, 39.726F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, 0.0F, 0.0F);
		top.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 2.618F, 0.0F);
		cube_r2.texOffs(11, 35).addBox(-1.0F, -16.0F, 39.726F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, 0.0F, 0.0F);
		top.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 3.1416F, 0.0F);
		cube_r3.texOffs(107, 9).addBox(-20.0F, -16.0F, 10.632F, 40.0F, 8.0F, 26.0F, 0.003F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(0.0F, 0.0F, 0.0F);
		top.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, -1.0472F, 0.0F);
		cube_r4.texOffs(0, 70).addBox(-20.0F, -16.0F, 10.632F, 40.0F, 8.0F, 26.0F, 0.001F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(0.0F, 0.0F, 0.0F);
		top.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, -0.5236F, 0.0F);
		cube_r5.texOffs(0, 0).addBox(-1.0F, -16.0F, 39.726F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.0F, 0.0F, 0.0F);
		top.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 1.0472F, 0.0F);
		cube_r6.texOffs(0, 35).addBox(-20.0F, -16.0F, 10.632F, 40.0F, 8.0F, 26.0F, 0.002F, false);
		cube_r6.texOffs(188, 0).addBox(-16.0F, -7.5F, 28.632F, 32.0F, 0.0F, 8.0F, 0.001F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(0.0F, 0.0F, 0.0F);
		top.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 2.0944F, 0.0F);
		cube_r7.texOffs(0, 0).addBox(-20.0F, -16.0F, 10.632F, 40.0F, 8.0F, 26.0F, 0.001F, false);
		cube_r7.texOffs(194, 79).addBox(-16.0F, -7.5F, 28.632F, 32.0F, 0.0F, 8.0F, 0.001F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(0.0F, 0.0F, 0.0F);
		top.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, -1.5708F, 0.0F);
		cube_r8.texOffs(8, 9).addBox(-1.0F, -16.0F, 39.726F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setPos(0.0F, 0.0F, 0.0F);
		top.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, -2.0944F, 0.0F);
		cube_r9.texOffs(0, 105).addBox(-20.0F, -16.0F, 10.632F, 40.0F, 8.0F, 26.0F, 0.002F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setPos(0.0F, 0.5F, 0.0F);
		top.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, 0.0F);
		cube_r10.texOffs(160, 149).addBox(-16.0F, -8.0F, 28.632F, 32.0F, 0.0F, 8.0F, 0.001F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setPos(0.0F, 0.5F, 0.0F);
		top.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, -1.0472F, 0.0F);
		cube_r11.texOffs(107, 0).addBox(-16.0F, -8.0F, 28.632F, 32.0F, 0.0F, 8.0F, 0.001F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setPos(0.0F, 0.5F, 0.0F);
		top.addChild(cube_r12);
		setRotationAngle(cube_r12, -3.1416F, -1.0472F, 3.1416F);
		cube_r12.texOffs(153, 186).addBox(-16.0F, -8.0F, 28.632F, 32.0F, 0.0F, 8.0F, 0.001F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setPos(0.0F, 0.5F, 0.0F);
		top.addChild(cube_r13);
		setRotationAngle(cube_r13, -3.1416F, 0.0F, 3.1416F);
		cube_r13.texOffs(80, 178).addBox(-16.0F, -8.0F, 28.632F, 32.0F, 0.0F, 8.0F, 0.001F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setPos(0.0F, 0.0F, 0.0F);
		top.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 1.5708F, 0.0F);
		cube_r14.texOffs(0, 47).addBox(-1.0F, -16.0F, 39.726F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setPos(0.0F, 0.0F, 0.0F);
		top.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, 0.5236F, 0.0F);
		cube_r15.texOffs(11, 47).addBox(-1.0F, -16.0F, 39.726F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		middle = new ModelRenderer(this);
		middle.setPos(0.0F, 14.0F, 0.0F);
		middle.texOffs(114, 121).addBox(-15.0F, -14.0F, 7.974F, 30.0F, 8.0F, 19.0F, 0.001F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setPos(0.0F, 0.0F, 0.0F);
		middle.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 0.5236F, 0.0F);
		cube_r16.texOffs(0, 70).addBox(-1.0F, -14.0F, 29.7945F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setPos(0.0F, 0.0F, 0.0F);
		middle.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, -2.0944F, 0.0F);
		cube_r17.texOffs(202, 195).addBox(-12.0F, -5.5F, 18.974F, 24.0F, 0.0F, 8.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setPos(0.0F, 0.0F, 0.0F);
		middle.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 3.1416F, 0.0F);
		cube_r18.texOffs(213, 136).addBox(-12.0F, -5.5F, 18.974F, 24.0F, 0.0F, 8.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setPos(0.0F, 0.0F, 0.0F);
		middle.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, 2.0944F, 0.0F);
		cube_r19.texOffs(214, 9).addBox(-12.0F, -5.5F, 18.974F, 24.0F, 0.0F, 8.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setPos(0.0F, 0.0F, 0.0F);
		middle.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, 1.0472F, 0.0F);
		cube_r20.texOffs(214, 18).addBox(-12.0F, -5.5F, 18.974F, 24.0F, 0.0F, 8.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setPos(0.0F, 0.0F, 0.0F);
		middle.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, 0.0F, 0.0F);
		cube_r21.texOffs(214, 44).addBox(-12.0F, -5.5F, 18.974F, 24.0F, 0.0F, 8.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setPos(0.0F, 0.0F, 0.0F);
		middle.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, -1.0472F, 0.0F);
		cube_r22.texOffs(214, 53).addBox(-12.0F, -5.5F, 18.974F, 24.0F, 0.0F, 8.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setPos(0.0F, 0.0F, 0.0F);
		middle.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, 1.0472F, 0.0F);
		cube_r23.texOffs(114, 86).addBox(-15.0F, -14.0F, 7.974F, 30.0F, 8.0F, 19.0F, 0.003F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setPos(0.0F, 0.0F, 0.0F);
		middle.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.0F, 1.5708F, 0.0F);
		cube_r24.texOffs(16, 0).addBox(-1.0F, -14.0F, 29.7945F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setPos(0.0F, 0.0F, 0.0F);
		middle.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0F, 2.0944F, 0.0F);
		cube_r25.texOffs(0, 168).addBox(-15.0F, -14.0F, 7.974F, 30.0F, 8.0F, 19.0F, 0.002F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setPos(0.0F, 0.0F, 0.0F);
		middle.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, 2.618F, 0.0F);
		cube_r26.texOffs(0, 105).addBox(-1.0F, -14.0F, 29.7945F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setPos(0.0F, 0.0F, 0.0F);
		middle.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.0F, 3.1416F, 0.0F);
		cube_r27.texOffs(160, 158).addBox(-15.0F, -14.0F, 7.974F, 30.0F, 8.0F, 19.0F, 0.001F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setPos(0.0F, 0.0F, 0.0F);
		middle.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, -2.618F, 0.0F);
		cube_r28.texOffs(0, 81).addBox(-1.0F, -14.0F, 29.7945F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setPos(0.0F, 0.0F, 0.0F);
		middle.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, -2.0944F, 0.0F);
		cube_r29.texOffs(80, 149).addBox(-15.0F, -14.0F, 7.974F, 30.0F, 8.0F, 19.0F, 0.003F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setPos(0.0F, 0.0F, 0.0F);
		middle.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, -1.5708F, 0.0F);
		cube_r30.texOffs(16, 79).addBox(-1.0F, -14.0F, 29.7945F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setPos(0.0F, 0.0F, 0.0F);
		middle.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.0F, -0.5236F, 0.0F);
		cube_r31.texOffs(9, 70).addBox(-1.0F, -14.0F, 29.7945F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setPos(0.0F, 0.0F, 0.0F);
		middle.addChild(cube_r32);
		setRotationAngle(cube_r32, 0.0F, -1.0472F, 0.0F);
		cube_r32.texOffs(0, 140).addBox(-15.0F, -14.0F, 7.974F, 30.0F, 8.0F, 19.0F, 0.002F, false);

		bottom = new ModelRenderer(this);
		bottom.setPos(0.0F, 20.0F, 0.0F);
		bottom.texOffs(194, 114).addBox(-10.0F, -12.0F, 5.316F, 20.0F, 8.0F, 13.0F, 0.002F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setPos(0.0F, 0.0F, 0.0F);
		bottom.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.0F, 1.5708F, 0.0F);
		cube_r33.texOffs(0, 12).addBox(-0.5F, -12.0F, 19.863F, 1.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setPos(0.0F, 0.0F, 0.0F);
		bottom.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.0F, 0.5236F, 0.0F);
		cube_r34.texOffs(19, 11).addBox(-0.5F, -12.0F, 19.863F, 1.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setPos(0.0F, 8.5F, 0.0F);
		bottom.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.0F, 0.0F, 0.0F);
		cube_r35.texOffs(214, 27).addBox(-7.0F, -12.0F, 11.316F, 14.0F, 0.0F, 7.0F, 0.003F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setPos(0.0F, 8.5F, 0.0F);
		bottom.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.0F, 1.0472F, 0.0F);
		cube_r36.texOffs(108, 212).addBox(-7.0F, -12.0F, 11.316F, 14.0F, 0.0F, 7.0F, 0.003F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setPos(0.0F, 8.5F, 0.0F);
		bottom.addChild(cube_r37);
		setRotationAngle(cube_r37, -3.1416F, 0.0F, 3.1416F);
		cube_r37.texOffs(144, 217).addBox(-7.0F, -12.0F, 11.316F, 14.0F, 0.0F, 7.0F, 0.003F, false);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setPos(0.0F, 8.5F, 0.0F);
		bottom.addChild(cube_r38);
		setRotationAngle(cube_r38, -3.1416F, 1.0472F, 3.1416F);
		cube_r38.texOffs(214, 62).addBox(-7.0F, -12.0F, 11.316F, 14.0F, 0.0F, 7.0F, 0.003F, false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setPos(0.0F, 8.5F, 0.0F);
		bottom.addChild(cube_r39);
		setRotationAngle(cube_r39, 0.0F, -2.0944F, 0.0F);
		cube_r39.texOffs(0, 218).addBox(-7.0F, -12.0F, 11.316F, 14.0F, 0.0F, 7.0F, 0.003F, false);
		cube_r39.texOffs(202, 204).addBox(-10.0F, -20.5F, 5.316F, 20.0F, 8.0F, 13.0F, 0.001F, false);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setPos(0.0F, 8.5F, 0.0F);
		bottom.addChild(cube_r40);
		setRotationAngle(cube_r40, 0.0F, -1.0472F, 0.0F);
		cube_r40.texOffs(121, 225).addBox(-7.0F, -12.0F, 11.316F, 14.0F, 0.0F, 7.0F, 0.003F, false);
		cube_r40.texOffs(213, 88).addBox(-10.0F, -20.5F, 5.316F, 20.0F, 8.0F, 13.0F, 0.003F, false);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setPos(0.0F, 0.0F, 0.0F);
		bottom.addChild(cube_r41);
		setRotationAngle(cube_r41, 0.0F, 3.1416F, 0.0F);
		cube_r41.texOffs(148, 195).addBox(-10.0F, -12.0F, 5.316F, 20.0F, 8.0F, 13.0F, 0.002F, false);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setPos(0.0F, 0.0F, 0.0F);
		bottom.addChild(cube_r42);
		setRotationAngle(cube_r42, 0.0F, 2.618F, 0.0F);
		cube_r42.texOffs(9, 81).addBox(-0.5F, -12.0F, 19.863F, 1.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r43 = new ModelRenderer(this);
		cube_r43.setPos(0.0F, 0.0F, 0.0F);
		bottom.addChild(cube_r43);
		setRotationAngle(cube_r43, 0.0F, 2.0944F, 0.0F);
		cube_r43.texOffs(0, 196).addBox(-10.0F, -12.0F, 5.316F, 20.0F, 8.0F, 13.0F, 0.003F, false);

		cube_r44 = new ModelRenderer(this);
		cube_r44.setPos(0.0F, 0.0F, 0.0F);
		bottom.addChild(cube_r44);
		setRotationAngle(cube_r44, 0.0F, -2.618F, 0.0F);
		cube_r44.texOffs(9, 105).addBox(-0.5F, -12.0F, 19.863F, 1.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r45 = new ModelRenderer(this);
		cube_r45.setPos(0.0F, 0.0F, 0.0F);
		bottom.addChild(cube_r45);
		setRotationAngle(cube_r45, 0.0F, -1.5708F, 0.0F);
		cube_r45.texOffs(16, 105).addBox(-0.5F, -12.0F, 19.863F, 1.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r46 = new ModelRenderer(this);
		cube_r46.setPos(0.0F, 0.0F, 0.0F);
		bottom.addChild(cube_r46);
		setRotationAngle(cube_r46, 0.0F, 1.0472F, 0.0F);
		cube_r46.texOffs(54, 212).addBox(-10.0F, -12.0F, 5.316F, 20.0F, 8.0F, 13.0F, 0.001F, false);

		cube_r47 = new ModelRenderer(this);
		cube_r47.setPos(0.0F, 0.0F, 0.0F);
		bottom.addChild(cube_r47);
		setRotationAngle(cube_r47, 0.0F, -0.5236F, 0.0F);
		cube_r47.texOffs(107, 9).addBox(-0.5F, -12.0F, 19.863F, 1.0F, 8.0F, 2.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);
		bb_main.texOffs(83, 187).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 8.0F, 16.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(ToyotaWhirlagigTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
package com.mdt.ait.client.models.consoles;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.ConsoleTileEntity;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class DevConsole extends EntityModel<Entity> {
	public final ModelRenderer rotor;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	public final ModelRenderer lever;
	private final ModelRenderer cube_r17;
	public final ModelRenderer sonic_port;
	private final ModelRenderer cube_r18;
	private final ModelRenderer monitor;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	public final ModelRenderer base;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer cube_r32;
	private final ModelRenderer cube_r33;
	private final ModelRenderer cube_r34;
	private final ModelRenderer cube_r35;
	private final ModelRenderer cube_r36;
	private final ModelRenderer cube_r37;
	private final ModelRenderer cube_r38;
	private final ModelRenderer cube_r39;
	private final ModelRenderer cube_r40;
	private final ModelRenderer cube_r41;
	private final ModelRenderer cube_r42;
	private final ModelRenderer cube_r43;
	private final ModelRenderer cube_r44;
	private final ModelRenderer cube_r45;
	private final ModelRenderer cube_r46;
	private final ModelRenderer cube_r47;
	private final ModelRenderer cube_r48;
	private final ModelRenderer cube_r49;
	private final ModelRenderer cube_r50;
	private final ModelRenderer cube_r51;
	private final ModelRenderer cube_r52;
	private final ModelRenderer cube_r53;
	private final ModelRenderer cube_r54;
	private final ModelRenderer cube_r55;
	private final ModelRenderer cube_r56;

	public DevConsole() {
		texWidth = 256;
		texHeight = 256;

		rotor = new ModelRenderer(this);
		rotor.setPos(0.0F, -2.5F, 0.0F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(-1.3632F, -2.9469F, 0.0F);
		rotor.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -1.2217F);
		cube_r1.texOffs(48, 37).addBox(-3.5F, -1.0F, -0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(-1.6284F, -3.2889F, 1.6284F);
		rotor.addChild(cube_r2);
		setRotationAngle(cube_r2, 1.2217F, 0.7854F, -3.1416F);
		cube_r2.texOffs(0, 0).addBox(-0.5F, -1.0F, -3.5F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(1.6284F, -3.2889F, 1.6284F);
		rotor.addChild(cube_r3);
		setRotationAngle(cube_r3, 1.2217F, -0.7854F, 3.1416F);
		cube_r3.texOffs(0, 9).addBox(-0.5F, -1.0F, -3.5F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(-1.6284F, -3.2889F, -1.6284F);
		rotor.addChild(cube_r4);
		setRotationAngle(cube_r4, -1.2217F, -0.7854F, -3.1416F);
		cube_r4.texOffs(0, 21).addBox(-0.5F, -1.0F, -3.5F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(1.6284F, -3.2889F, -1.6284F);
		rotor.addChild(cube_r5);
		setRotationAngle(cube_r5, -1.2217F, 0.7854F, 3.1416F);
		cube_r5.texOffs(0, 30).addBox(-0.5F, -1.0F, -3.5F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.0F, -2.9469F, -1.3632F);
		rotor.addChild(cube_r6);
		setRotationAngle(cube_r6, 1.2217F, 0.0F, 0.0F);
		cube_r6.texOffs(0, 42).addBox(-0.5F, -1.0F, -3.5F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(0.0F, -2.9469F, 1.3632F);
		rotor.addChild(cube_r7);
		setRotationAngle(cube_r7, -1.2217F, 0.0F, 0.0F);
		cube_r7.texOffs(48, 0).addBox(-0.5F, -1.0F, -3.5F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(1.3632F, -2.9469F, 0.0F);
		rotor.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, 1.2217F);
		cube_r8.texOffs(48, 56).addBox(-3.5F, -1.0F, -0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setPos(-1.3632F, 2.9469F, 0.0F);
		rotor.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, 1.2217F);
		cube_r9.texOffs(36, 72).addBox(-3.5F, 0.0F, -0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setPos(1.3632F, 2.9469F, 0.0F);
		rotor.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, -1.2217F);
		cube_r10.texOffs(72, 65).addBox(-3.5F, 0.0F, -0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setPos(0.0F, 2.9469F, 1.3632F);
		rotor.addChild(cube_r11);
		setRotationAngle(cube_r11, 1.2217F, 0.0F, 0.0F);
		cube_r11.texOffs(48, 9).addBox(-0.5F, 0.0F, -3.5F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setPos(0.0F, 2.9469F, -1.3632F);
		rotor.addChild(cube_r12);
		setRotationAngle(cube_r12, -1.2217F, 0.0F, 0.0F);
		cube_r12.texOffs(48, 23).addBox(-0.5F, 0.0F, -3.5F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setPos(1.6284F, 3.2889F, -1.6284F);
		rotor.addChild(cube_r13);
		setRotationAngle(cube_r13, 1.2217F, 0.7854F, -3.1416F);
		cube_r13.texOffs(48, 44).addBox(-0.5F, 0.0F, -3.5F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setPos(-1.6284F, 3.2889F, -1.6284F);
		rotor.addChild(cube_r14);
		setRotationAngle(cube_r14, 1.2217F, -0.7854F, 3.1416F);
		cube_r14.texOffs(0, 51).addBox(-0.5F, 0.0F, -3.5F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setPos(1.6284F, 3.2889F, 1.6284F);
		rotor.addChild(cube_r15);
		setRotationAngle(cube_r15, -1.2217F, -0.7854F, -3.1416F);
		cube_r15.texOffs(0, 63).addBox(-0.5F, 0.0F, -3.5F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setPos(-1.6284F, 3.2889F, 1.6284F);
		rotor.addChild(cube_r16);
		setRotationAngle(cube_r16, -1.2217F, 0.7854F, 3.1416F);
		cube_r16.texOffs(36, 63).addBox(-0.5F, 0.0F, -3.5F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		lever = new ModelRenderer(this);
		lever.setPos(-12.4151F, 6.6519F, -5.0F);
		

		cube_r17 = new ModelRenderer(this);
		cube_r17.setPos(0.0F, 0.0F, 0.0F);
		lever.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 0.0F, 0.3927F);
		cube_r17.texOffs(0, 0).addBox(-4.308F, -0.7262F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		cube_r17.texOffs(72, 73).addBox(-3.808F, -0.2262F, -0.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		sonic_port = new ModelRenderer(this);
		sonic_port.setPos(3.0678F, -10.0981F, 0.0F);
		

		cube_r18 = new ModelRenderer(this);
		cube_r18.setPos(0.0F, 0.0F, 0.0F);
		sonic_port.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 0.0F, 0.1745F);
		cube_r18.texOffs(72, 68).addBox(13.5F, 14.75F, 6.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		monitor = new ModelRenderer(this);
		monitor.setPos(-1.8745F, -1.0041F, 0.0F);
		

		cube_r19 = new ModelRenderer(this);
		cube_r19.setPos(0.0F, 0.0F, 0.0F);
		monitor.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, 0.0F, -1.2217F);
		cube_r19.texOffs(0, 72).addBox(-3.5F, -1.0F, -0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setPos(0.5113F, 1.451F, 0.0F);
		monitor.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, 0.0F, 1.2217F);
		cube_r20.texOffs(48, 53).addBox(-6.5F, 2.0F, -0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setPos(0.5113F, -4.4428F, 0.0F);
		monitor.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, 0.0F, -1.5708F);
		cube_r21.texOffs(96, 23).addBox(-6.0F, -5.25F, -6.0F, 6.0F, 1.0F, 12.0F, 0.0F, false);
		cube_r21.texOffs(96, 0).addBox(-6.5F, -5.0F, -6.5F, 7.0F, 1.0F, 13.0F, 0.0F, false);

		base = new ModelRenderer(this);
		base.setPos(0.5F, 25.0F, 0.0F);
		base.texOffs(137, 105).addBox(-7.5F, -3.0F, -1.0F, 14.0F, 2.0F, 2.0F, 0.0F, false);
		base.texOffs(134, 32).addBox(-1.5F, -3.0F, -7.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);
		base.texOffs(96, 37).addBox(-7.5F, -16.0F, -1.0F, 14.0F, 2.0F, 2.0F, 0.0F, false);
		base.texOffs(96, 44).addBox(-1.5F, -16.0F, -7.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);
		base.texOffs(52, 124).addBox(8.0F, -16.0F, -5.5F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		base.texOffs(52, 107).addBox(-10.0F, -16.0F, -5.5F, 1.0F, 1.0F, 11.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setPos(1.0208F, -35.0981F, 2.6796F);
		base.addChild(cube_r22);
		setRotationAngle(cube_r22, -0.2922F, -1.0215F, 0.339F);
		cube_r22.texOffs(48, 44).addBox(3.0F, 15.0F, -9.5F, 14.0F, 1.0F, 19.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setPos(-2.0208F, -35.0981F, 2.6796F);
		base.addChild(cube_r23);
		setRotationAngle(cube_r23, -0.2922F, 1.0215F, -0.339F);
		cube_r23.texOffs(48, 23).addBox(-17.0F, 15.0F, -9.5F, 14.0F, 1.0F, 19.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setPos(1.0208F, -35.0981F, -2.6796F);
		base.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.2922F, 1.0215F, 0.339F);
		cube_r24.texOffs(48, 2).addBox(3.0F, 15.0F, -9.5F, 14.0F, 1.0F, 19.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setPos(-2.1944F, -35.0981F, -2.9803F);
		base.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.2922F, -1.0215F, -0.339F);
		cube_r25.texOffs(0, 42).addBox(-17.0F, 15.0F, -9.5F, 14.0F, 1.0F, 19.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setPos(-2.1076F, 1.3349F, 2.8299F);
		base.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.2922F, 1.0215F, 0.339F);
		cube_r26.texOffs(0, 84).addBox(-17.0F, -16.0F, -9.5F, 8.0F, 1.0F, 19.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setPos(1.1076F, 1.3349F, 2.8299F);
		base.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.2922F, -1.0215F, -0.339F);
		cube_r27.texOffs(72, 67).addBox(9.0F, -16.0F, -9.5F, 8.0F, 1.0F, 19.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setPos(1.1076F, 1.3349F, -2.8299F);
		base.addChild(cube_r28);
		setRotationAngle(cube_r28, -0.2922F, 1.0215F, -0.339F);
		cube_r28.texOffs(36, 86).addBox(9.0F, -16.0F, -9.5F, 8.0F, 1.0F, 19.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setPos(-2.1076F, 1.3349F, -2.8299F);
		base.addChild(cube_r29);
		setRotationAngle(cube_r29, -0.2922F, -1.0215F, 0.339F);
		cube_r29.texOffs(72, 88).addBox(-17.0F, -16.0F, -9.5F, 8.0F, 1.0F, 19.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setPos(-0.2369F, 0.0F, 0.4103F);
		base.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, -1.0472F, 0.0F);
		cube_r30.texOffs(19, 105).addBox(-10.0F, -16.0F, -5.5F, 1.0F, 1.0F, 11.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setPos(-0.2369F, 0.0F, -0.4103F);
		base.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.0F, 1.0472F, 0.0F);
		cube_r31.texOffs(85, 109).addBox(-10.0F, -16.0F, -5.5F, 1.0F, 1.0F, 11.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setPos(-0.7631F, 0.0F, -0.4103F);
		base.addChild(cube_r32);
		setRotationAngle(cube_r32, 0.0F, -1.0472F, 0.0F);
		cube_r32.texOffs(19, 122).addBox(9.0F, -16.0F, -5.5F, 1.0F, 1.0F, 11.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setPos(-0.7631F, 0.0F, 0.4103F);
		base.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.0F, 1.0472F, 0.0F);
		cube_r33.texOffs(124, 0).addBox(9.0F, -16.0F, -5.5F, 1.0F, 1.0F, 11.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setPos(2.5678F, -35.0981F, 0.0F);
		base.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.0F, 0.0F, 0.1745F);
		cube_r34.texOffs(0, 21).addBox(3.0F, 15.0F, -9.5F, 14.0F, 1.0F, 19.0F, 0.0F, false);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setPos(-3.9151F, -34.3481F, 0.0F);
		base.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.0F, 0.0F, -0.1745F);
		cube_r35.texOffs(48, 32).addBox(-15.0F, 14.0F, -6.5F, 5.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setPos(-3.9151F, -35.0981F, 0.0F);
		base.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.0F, 0.0F, -0.1745F);
		cube_r36.texOffs(0, 0).addBox(-17.0F, 15.0F, -9.5F, 14.0F, 1.0F, 19.0F, 0.0F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setPos(-3.7415F, 1.3349F, 0.0F);
		base.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.0F, 0.0F, 0.1745F);
		cube_r37.texOffs(0, 63).addBox(-17.0F, -16.0F, -9.5F, 8.0F, 1.0F, 19.0F, 0.0F, false);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setPos(2.7415F, 1.3349F, 0.0F);
		base.addChild(cube_r38);
		setRotationAngle(cube_r38, 0.0F, 0.0F, -0.1745F);
		cube_r38.texOffs(36, 65).addBox(9.0F, -16.0F, -9.5F, 8.0F, 1.0F, 19.0F, 0.0F, false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setPos(-3.7568F, -7.4222F, 3.2568F);
		base.addChild(cube_r39);
		setRotationAngle(cube_r39, -1.2217F, 0.7854F, 3.1416F);
		cube_r39.texOffs(118, 105).addBox(-1.0F, 0.0F, -7.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setPos(2.7568F, -7.4222F, 3.2568F);
		base.addChild(cube_r40);
		setRotationAngle(cube_r40, -1.2217F, -0.7854F, -3.1416F);
		cube_r40.texOffs(115, 37).addBox(-1.0F, 0.0F, -7.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setPos(-3.7568F, -7.4222F, -3.2568F);
		base.addChild(cube_r41);
		setRotationAngle(cube_r41, 1.2217F, -0.7854F, 3.1416F);
		cube_r41.texOffs(99, 109).addBox(-1.0F, 0.0F, -7.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setPos(2.7568F, -7.4222F, -3.2568F);
		base.addChild(cube_r42);
		setRotationAngle(cube_r42, 1.2217F, 0.7854F, -3.1416F);
		cube_r42.texOffs(66, 109).addBox(-1.0F, 0.0F, -7.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		cube_r43 = new ModelRenderer(this);
		cube_r43.setPos(-0.5F, -8.1062F, -2.7265F);
		base.addChild(cube_r43);
		setRotationAngle(cube_r43, -1.2217F, 0.0F, 0.0F);
		cube_r43.texOffs(108, 88).addBox(-1.0F, 0.0F, -7.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		cube_r44 = new ModelRenderer(this);
		cube_r44.setPos(-0.5F, -8.1062F, 2.7265F);
		base.addChild(cube_r44);
		setRotationAngle(cube_r44, 1.2217F, 0.0F, 0.0F);
		cube_r44.texOffs(108, 61).addBox(-1.0F, 0.0F, -7.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		cube_r45 = new ModelRenderer(this);
		cube_r45.setPos(2.2265F, -8.1062F, 0.0F);
		base.addChild(cube_r45);
		setRotationAngle(cube_r45, 0.0F, 0.0F, -1.2217F);
		cube_r45.texOffs(108, 78).addBox(-7.0F, 0.0F, -1.0F, 14.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r46 = new ModelRenderer(this);
		cube_r46.setPos(-0.5F, -16.0F, 0.0F);
		base.addChild(cube_r46);
		setRotationAngle(cube_r46, 0.0F, 2.3562F, 0.0F);
		cube_r46.texOffs(33, 107).addBox(-1.0F, 0.0F, -7.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);
		cube_r46.texOffs(127, 54).addBox(-1.0F, 13.0F, -7.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		cube_r47 = new ModelRenderer(this);
		cube_r47.setPos(-0.5F, -16.0F, 0.0F);
		base.addChild(cube_r47);
		setRotationAngle(cube_r47, 0.0F, 0.7854F, 0.0F);
		cube_r47.texOffs(0, 105).addBox(-1.0F, 0.0F, -7.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);
		cube_r47.texOffs(127, 71).addBox(-1.0F, 13.0F, -7.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		cube_r48 = new ModelRenderer(this);
		cube_r48.setPos(-3.2265F, -8.1062F, 0.0F);
		base.addChild(cube_r48);
		setRotationAngle(cube_r48, 0.0F, 0.0F, 1.2217F);
		cube_r48.texOffs(96, 15).addBox(-7.0F, 0.0F, -1.0F, 14.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r49 = new ModelRenderer(this);
		cube_r49.setPos(2.7568F, -9.5778F, 3.2568F);
		base.addChild(cube_r49);
		setRotationAngle(cube_r49, 1.2217F, -0.7854F, 3.1416F);
		cube_r49.texOffs(0, 122).addBox(-1.0F, -2.0F, -7.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		cube_r50 = new ModelRenderer(this);
		cube_r50.setPos(-3.7568F, -9.5778F, 3.2568F);
		base.addChild(cube_r50);
		setRotationAngle(cube_r50, 1.2217F, 0.7854F, -3.1416F);
		cube_r50.texOffs(121, 15).addBox(-1.0F, -2.0F, -7.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		cube_r51 = new ModelRenderer(this);
		cube_r51.setPos(-3.7568F, -9.5778F, -3.2568F);
		base.addChild(cube_r51);
		setRotationAngle(cube_r51, -1.2217F, -0.7854F, -3.1416F);
		cube_r51.texOffs(118, 122).addBox(-1.0F, -2.0F, -7.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		cube_r52 = new ModelRenderer(this);
		cube_r52.setPos(2.7568F, -9.5778F, -3.2568F);
		base.addChild(cube_r52);
		setRotationAngle(cube_r52, -1.2217F, 0.7854F, 3.1416F);
		cube_r52.texOffs(33, 124).addBox(-1.0F, -2.0F, -7.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		cube_r53 = new ModelRenderer(this);
		cube_r53.setPos(-0.5F, -8.8938F, 2.7265F);
		base.addChild(cube_r53);
		setRotationAngle(cube_r53, -1.2217F, 0.0F, 0.0F);
		cube_r53.texOffs(99, 126).addBox(-1.0F, -2.0F, -7.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		cube_r54 = new ModelRenderer(this);
		cube_r54.setPos(-0.5F, -8.8938F, -2.7265F);
		base.addChild(cube_r54);
		setRotationAngle(cube_r54, 1.2217F, 0.0F, 0.0F);
		cube_r54.texOffs(66, 126).addBox(-1.0F, -2.0F, -7.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		cube_r55 = new ModelRenderer(this);
		cube_r55.setPos(2.2265F, -8.8938F, 0.0F);
		base.addChild(cube_r55);
		setRotationAngle(cube_r55, 0.0F, 0.0F, 1.2217F);
		cube_r55.texOffs(127, 88).addBox(-7.0F, -2.0F, -1.0F, 14.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r56 = new ModelRenderer(this);
		cube_r56.setPos(-3.2265F, -8.8938F, 0.0F);
		base.addChild(cube_r56);
		setRotationAngle(cube_r56, 0.0F, 0.0F, -1.2217F);
		cube_r56.texOffs(127, 93).addBox(-7.0F, -2.0F, -1.0F, 14.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		rotor.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		lever.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		sonic_port.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		monitor.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(ConsoleTileEntity tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
	}
}
package com.mdt.ait.client.models.consoles;// Made with Blockbench 4.4.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.client.models.consoles.DevConsole;
import com.mdt.ait.client.renderers.LightModelRenderer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class BorealisConsole extends DevConsole {
	public final ModelRenderer base_console;
	public final ModelRenderer panels;
	public final ModelRenderer bone25;
	public final ModelRenderer bone38;
	public final ModelRenderer bone44;
	public final ModelRenderer bone56;
	public final ModelRenderer bone152;
	public final ModelRenderer bone153;
	public final ModelRenderer bone154;
	public final ModelRenderer bone155;
	public final ModelRenderer bone156;
	public final ModelRenderer bone157;
	public final ModelRenderer bone158;
	public final ModelRenderer collar;
	public final ModelRenderer bone86;
	public final ModelRenderer bone87;
	public final ModelRenderer bone88;
	public final ModelRenderer bone89;
	public final ModelRenderer bone90;
	public final ModelRenderer bone91;
	public final ModelRenderer bone92;
	public final ModelRenderer bone93;
	public final ModelRenderer bone94;
	public final ModelRenderer bone95;
	public final ModelRenderer bone96;
	public final ModelRenderer bone97;
	public final ModelRenderer bone104;
	public final ModelRenderer bone105;
	public final ModelRenderer bone106;
	public final ModelRenderer bone107;
	public final ModelRenderer bone108;
	public final ModelRenderer bone109;
	public final ModelRenderer bone98;
	public final ModelRenderer bone99;
	public final ModelRenderer bone100;
	public final ModelRenderer bone101;
	public final ModelRenderer bone102;
	public final ModelRenderer bone103;
	public final ModelRenderer lower_dividers;
	public final ModelRenderer bone32;
	public final ModelRenderer bone26;
	public final ModelRenderer bone27;
	public final ModelRenderer bone28;
	public final ModelRenderer bone29;
	public final ModelRenderer bone30;
	public final ModelRenderer bone33;
	public final ModelRenderer bone34;
	public final ModelRenderer bone35;
	public final ModelRenderer bone36;
	public final ModelRenderer bone37;
	public final ModelRenderer dividers2;
	public final ModelRenderer bone40;
	public final ModelRenderer bone39;
	public final ModelRenderer bone41;
	public final ModelRenderer bone42;
	public final ModelRenderer bone43;
	public final ModelRenderer dividers;
	public final ModelRenderer bone50;
	public final ModelRenderer bone45;
	public final ModelRenderer bone46;
	public final ModelRenderer bone47;
	public final ModelRenderer bone48;
	public final ModelRenderer bone49;
	public final ModelRenderer bone51;
	public final ModelRenderer bone52;
	public final ModelRenderer bone53;
	public final ModelRenderer bone54;
	public final ModelRenderer bone55;
	public final ModelRenderer bone122;
	public final ModelRenderer bone123;
	public final ModelRenderer bone124;
	public final ModelRenderer bone125;
	public final ModelRenderer bone126;
	public final ModelRenderer bone127;
	public final ModelRenderer bone110;
	public final ModelRenderer bone116;
	public final ModelRenderer bone111;
	public final ModelRenderer bone112;
	public final ModelRenderer bone113;
	public final ModelRenderer bone114;
	public final ModelRenderer bone115;
	public final ModelRenderer bone117;
	public final ModelRenderer bone118;
	public final ModelRenderer bone119;
	public final ModelRenderer bone120;
	public final ModelRenderer bone121;
	public final ModelRenderer bone84;
	public final ModelRenderer bone85;
	public final ModelRenderer bone148;
	public final ModelRenderer bone149;
	public final ModelRenderer bone166;
	public final ModelRenderer bone150;
	public final ModelRenderer bone151;
	public final ModelRenderer bone62;
	public final ModelRenderer bone81;
	public final ModelRenderer bone63;
	public final ModelRenderer bone64;
	public final ModelRenderer bone82;
	public final ModelRenderer bone83;
	public final ModelRenderer bone60;
	public final ModelRenderer bone61;
	public final ModelRenderer bone65;
	public final ModelRenderer bone66;
	public final ModelRenderer bone67;
	public final ModelRenderer bone68;
	public final ModelRenderer bone69;
	public final ModelRenderer bone70;
	public final ModelRenderer bone144;
	public final ModelRenderer bone145;
	public final ModelRenderer bone146;
	public final ModelRenderer bone147;
	public final ModelRenderer bone58;
	public final ModelRenderer bone59;
	public final ModelRenderer bone71;
	public final ModelRenderer bone72;
	public final ModelRenderer bone73;
	public final ModelRenderer bone74;
	public final ModelRenderer bone75;
	public final ModelRenderer bone76;
	public final ModelRenderer bone77;
	public final ModelRenderer bone78;
	public final ModelRenderer bone79;
	public final ModelRenderer bone80;
	public final ModelRenderer bone13;
	public final ModelRenderer bone14;
	public final ModelRenderer bone15;
	public final ModelRenderer bone16;
	public final ModelRenderer bone17;
	public final ModelRenderer bone18;
	public final ModelRenderer bone19;
	public final ModelRenderer bone20;
	public final ModelRenderer bone21;
	public final ModelRenderer bone132;
	public final ModelRenderer bone22;
	public final ModelRenderer bone23;
	public final ModelRenderer bone24;
	public final ModelRenderer bone7;
	public final ModelRenderer bone8;
	public final ModelRenderer bone9;
	public final ModelRenderer bone10;
	public final ModelRenderer bone11;
	public final ModelRenderer bone12;
	public final ModelRenderer bone;
	public final ModelRenderer bone2;
	public final ModelRenderer bone3;
	public final ModelRenderer bone4;
	public final ModelRenderer bone5;
	public final ModelRenderer bone6;
	public final ModelRenderer bone208;
	public final ModelRenderer bone209;
	public final ModelRenderer bone210;
	public final ModelRenderer bone211;
	public final ModelRenderer bone212;
	public final ModelRenderer bone213;
	public final ModelRenderer rotor;
	public final ModelRenderer bone138;
	public final ModelRenderer bone139;
	public final ModelRenderer bone140;
	public final ModelRenderer bone141;
	public final ModelRenderer bone142;
	public final ModelRenderer bone143;
	public final LightModelRenderer glow;
	public final ModelRenderer NORTH2;
	public final ModelRenderer bone31;
	public final ModelRenderer bone178;
	public final ModelRenderer bone179;
	public final ModelRenderer bone180;
	public final ModelRenderer bone181;
	public final ModelRenderer bone182;
	public final ModelRenderer bone183;
	public final ModelRenderer bone184;
	public final ModelRenderer bone185;
	public final ModelRenderer NORTH_WEST2;
	public final ModelRenderer bone186;
	public final ModelRenderer bone187;
	public final ModelRenderer bone189;
	public final ModelRenderer bone190;
	public final ModelRenderer SOUTH_WEST2;
	public final ModelRenderer bone188;
	public final ModelRenderer SOUTH2;
	public final ModelRenderer bone191;
	public final ModelRenderer bone192;
	public final ModelRenderer SOUTH_EAST2;
	public final ModelRenderer bone193;
	public final ModelRenderer bone194;
	public final ModelRenderer bone195;
	public final ModelRenderer bone196;
	public final ModelRenderer bone197;
	public final ModelRenderer NORTH_EAST2;
	public final ModelRenderer bone198;
	public final ModelRenderer bone199;
	public final ModelRenderer bone200;
	public final ModelRenderer bone201;
	public final ModelRenderer bone202;
	public final ModelRenderer bone203;
	public final ModelRenderer bone204;
	public final ModelRenderer bone205;
	public final ModelRenderer bone206;
	public final ModelRenderer bone207;
	public final ModelRenderer NORTH;
	public final ModelRenderer bone136;
	public final ModelRenderer door_control;
	public final ModelRenderer bone137;
	public final ModelRenderer bone159;
	public final ModelRenderer bone160;
	public final ModelRenderer bone161;
	public final ModelRenderer bone162;
	public final ModelRenderer bone163;
	public final ModelRenderer bone164;
	public final ModelRenderer bone165;
	public final ModelRenderer NORTH_WEST;
	public final ModelRenderer bone57;
	public final ModelRenderer bone128;
	public final ModelRenderer bone131;
	public final ModelRenderer bone129;
	public final ModelRenderer bone130;
	public final ModelRenderer SOUTH_WEST;
	public final ModelRenderer bone133;
	public final ModelRenderer bone134;
	public final ModelRenderer bone135;
	public final ModelRenderer SOUTH;
	public final ModelRenderer bone167;
	public final ModelRenderer XYZmod;
	public final ModelRenderer randomiser;
	public final ModelRenderer land_type;
	public final ModelRenderer SOUTH_EAST;
	public final ModelRenderer bone169;
	public final ModelRenderer handbrake;
	public final ModelRenderer throttle;
	public final ModelRenderer bone173;
	public final ModelRenderer bone171;
	public final ModelRenderer bone172;
	public final ModelRenderer bone170;
	public final ModelRenderer NORTH_EAST;
	public final ModelRenderer bone174;
	public final ModelRenderer bone175;
	public final ModelRenderer bone176;
	public final ModelRenderer bone177;

	public BorealisConsole() {
		texWidth = 256;
		texHeight = 256;

		base_console = new ModelRenderer(this);
		base_console.setPos(0.0F, 24.0F, 0.0F);
		

		panels = new ModelRenderer(this);
		panels.setPos(0.0F, -30.0F, 0.0F);
		base_console.addChild(panels);
		

		bone25 = new ModelRenderer(this);
		bone25.setPos(0.0F, -4.0F, -27.8F);
		panels.addChild(bone25);
		setRotationAngle(bone25, 0.48F, 0.0F, 0.0F);
		bone25.texOffs(0, 0).addBox(-15.0F, 1.774F, -2.9235F, 30.0F, 1.0F, 20.0F, 0.0F, false);

		bone38 = new ModelRenderer(this);
		bone38.setPos(0.0F, 0.0F, 0.0F);
		panels.addChild(bone38);
		setRotationAngle(bone38, 0.0F, -1.0472F, 0.0F);
		

		bone44 = new ModelRenderer(this);
		bone44.setPos(0.0F, -4.0F, -27.8F);
		bone38.addChild(bone44);
		setRotationAngle(bone44, 0.48F, 0.0F, 0.0F);
		bone44.texOffs(0, 0).addBox(-15.0F, 1.774F, -2.9235F, 30.0F, 1.0F, 20.0F, 0.0F, false);

		bone56 = new ModelRenderer(this);
		bone56.setPos(0.0F, 0.0F, 0.0F);
		bone38.addChild(bone56);
		setRotationAngle(bone56, 0.0F, -1.0472F, 0.0F);
		

		bone152 = new ModelRenderer(this);
		bone152.setPos(0.0F, -4.0F, -27.8F);
		bone56.addChild(bone152);
		setRotationAngle(bone152, 0.48F, 0.0F, 0.0F);
		bone152.texOffs(0, 0).addBox(-15.0F, 1.774F, -2.9235F, 30.0F, 1.0F, 20.0F, 0.0F, false);

		bone153 = new ModelRenderer(this);
		bone153.setPos(0.0F, 0.0F, 0.0F);
		bone56.addChild(bone153);
		setRotationAngle(bone153, 0.0F, -1.0472F, 0.0F);
		

		bone154 = new ModelRenderer(this);
		bone154.setPos(0.0F, -4.0F, -27.8F);
		bone153.addChild(bone154);
		setRotationAngle(bone154, 0.48F, 0.0F, 0.0F);
		bone154.texOffs(0, 0).addBox(-15.0F, 1.774F, -2.9235F, 30.0F, 1.0F, 20.0F, 0.0F, false);

		bone155 = new ModelRenderer(this);
		bone155.setPos(0.0F, 0.0F, 0.0F);
		bone153.addChild(bone155);
		setRotationAngle(bone155, 0.0F, -1.0472F, 0.0F);
		

		bone156 = new ModelRenderer(this);
		bone156.setPos(0.0F, -4.0F, -27.8F);
		bone155.addChild(bone156);
		setRotationAngle(bone156, 0.48F, 0.0F, 0.0F);
		bone156.texOffs(0, 0).addBox(-15.0F, 1.774F, -2.9235F, 30.0F, 1.0F, 20.0F, 0.0F, false);

		bone157 = new ModelRenderer(this);
		bone157.setPos(0.0F, 0.0F, 0.0F);
		bone155.addChild(bone157);
		setRotationAngle(bone157, 0.0F, -1.0472F, 0.0F);
		

		bone158 = new ModelRenderer(this);
		bone158.setPos(0.0F, -4.0F, -27.8F);
		bone157.addChild(bone158);
		setRotationAngle(bone158, 0.48F, 0.0F, 0.0F);
		bone158.texOffs(0, 0).addBox(-15.0F, 1.774F, -2.9235F, 30.0F, 1.0F, 20.0F, 0.0F, false);

		collar = new ModelRenderer(this);
		collar.setPos(0.0F, 0.0F, 0.0F);
		base_console.addChild(collar);
		

		bone86 = new ModelRenderer(this);
		bone86.setPos(0.0F, -44.5F, 0.0F);
		collar.addChild(bone86);
		setRotationAngle(bone86, 0.0F, -0.5236F, 0.0F);
		bone86.texOffs(96, 130).addBox(-2.0F, -2.0F, -14.3F, 4.0F, 7.0F, 3.0F, 0.0F, false);

		bone87 = new ModelRenderer(this);
		bone87.setPos(0.0F, 0.0F, 0.0F);
		bone86.addChild(bone87);
		setRotationAngle(bone87, 0.0F, -1.0472F, 0.0F);
		bone87.texOffs(96, 130).addBox(-2.0F, -2.0F, -14.3F, 4.0F, 7.0F, 3.0F, 0.0F, false);

		bone88 = new ModelRenderer(this);
		bone88.setPos(0.0F, 0.0F, 0.0F);
		bone87.addChild(bone88);
		setRotationAngle(bone88, 0.0F, -1.0472F, 0.0F);
		bone88.texOffs(96, 130).addBox(-2.0F, -2.0F, -14.3F, 4.0F, 7.0F, 3.0F, 0.0F, false);

		bone89 = new ModelRenderer(this);
		bone89.setPos(0.0F, 0.0F, 0.0F);
		bone88.addChild(bone89);
		setRotationAngle(bone89, 0.0F, -1.0472F, 0.0F);
		bone89.texOffs(96, 130).addBox(-2.0F, -2.0F, -14.3F, 4.0F, 7.0F, 3.0F, 0.0F, false);

		bone90 = new ModelRenderer(this);
		bone90.setPos(0.0F, 0.0F, 0.0F);
		bone89.addChild(bone90);
		setRotationAngle(bone90, 0.0F, -1.0472F, 0.0F);
		bone90.texOffs(96, 130).addBox(-2.0F, -2.0F, -14.3F, 4.0F, 7.0F, 3.0F, 0.0F, false);

		bone91 = new ModelRenderer(this);
		bone91.setPos(0.0F, 0.0F, 0.0F);
		bone90.addChild(bone91);
		setRotationAngle(bone91, 0.0F, -1.0472F, 0.0F);
		bone91.texOffs(96, 130).addBox(-2.0F, -2.0F, -14.3F, 4.0F, 7.0F, 3.0F, 0.0F, false);

		bone92 = new ModelRenderer(this);
		bone92.setPos(0.0F, -43.5F, 0.0F);
		collar.addChild(bone92);
		bone92.texOffs(123, 27).addBox(-5.0F, -2.0F, -12.3F, 10.0F, 6.0F, 3.0F, 0.0F, false);
		bone92.texOffs(128, 20).addBox(-5.5F, -2.975F, -13.275F, 11.0F, 2.0F, 2.0F, 0.0F, false);

		bone93 = new ModelRenderer(this);
		bone93.setPos(0.0F, 0.0F, 0.0F);
		bone92.addChild(bone93);
		setRotationAngle(bone93, 0.0F, -1.0472F, 0.0F);
		bone93.texOffs(123, 27).addBox(-5.0F, -2.0F, -12.3F, 10.0F, 6.0F, 3.0F, 0.0F, false);
		bone93.texOffs(128, 20).addBox(-5.5F, -2.975F, -13.275F, 11.0F, 2.0F, 2.0F, 0.0F, false);

		bone94 = new ModelRenderer(this);
		bone94.setPos(0.0F, 0.0F, 0.0F);
		bone93.addChild(bone94);
		setRotationAngle(bone94, 0.0F, -1.0472F, 0.0F);
		bone94.texOffs(123, 27).addBox(-5.0F, -2.0F, -12.3F, 10.0F, 6.0F, 3.0F, 0.0F, false);
		bone94.texOffs(128, 20).addBox(-5.5F, -2.975F, -13.275F, 11.0F, 2.0F, 2.0F, 0.0F, false);

		bone95 = new ModelRenderer(this);
		bone95.setPos(0.0F, 0.0F, 0.0F);
		bone94.addChild(bone95);
		setRotationAngle(bone95, 0.0F, -1.0472F, 0.0F);
		bone95.texOffs(123, 27).addBox(-5.0F, -2.0F, -12.3F, 10.0F, 6.0F, 3.0F, 0.0F, false);
		bone95.texOffs(128, 20).addBox(-5.5F, -2.975F, -13.275F, 11.0F, 2.0F, 2.0F, 0.0F, false);

		bone96 = new ModelRenderer(this);
		bone96.setPos(0.0F, 0.0F, 0.0F);
		bone95.addChild(bone96);
		setRotationAngle(bone96, 0.0F, -1.0472F, 0.0F);
		bone96.texOffs(123, 27).addBox(-5.0F, -2.0F, -12.3F, 10.0F, 6.0F, 3.0F, 0.0F, false);
		bone96.texOffs(128, 20).addBox(-5.5F, -2.975F, -13.275F, 11.0F, 2.0F, 2.0F, 0.0F, false);

		bone97 = new ModelRenderer(this);
		bone97.setPos(0.0F, 0.0F, 0.0F);
		bone96.addChild(bone97);
		setRotationAngle(bone97, 0.0F, -1.0472F, 0.0F);
		bone97.texOffs(123, 27).addBox(-5.0F, -2.0F, -12.3F, 10.0F, 6.0F, 3.0F, 0.0F, false);
		bone97.texOffs(128, 20).addBox(-5.5F, -2.975F, -13.275F, 11.0F, 2.0F, 2.0F, 0.0F, false);

		bone104 = new ModelRenderer(this);
		bone104.setPos(0.0F, -45.5F, 0.0F);
		collar.addChild(bone104);
		bone104.texOffs(70, 92).addBox(2.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		bone104.texOffs(70, 92).addBox(-4.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		bone105 = new ModelRenderer(this);
		bone105.setPos(0.0F, 0.0F, 0.0F);
		bone104.addChild(bone105);
		setRotationAngle(bone105, 0.0F, -1.0472F, 0.0F);
		bone105.texOffs(70, 92).addBox(2.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		bone105.texOffs(70, 92).addBox(-4.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		bone106 = new ModelRenderer(this);
		bone106.setPos(0.0F, 0.0F, 0.0F);
		bone105.addChild(bone106);
		setRotationAngle(bone106, 0.0F, -1.0472F, 0.0F);
		bone106.texOffs(70, 92).addBox(2.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		bone106.texOffs(70, 92).addBox(-4.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		bone107 = new ModelRenderer(this);
		bone107.setPos(0.0F, 0.0F, 0.0F);
		bone106.addChild(bone107);
		setRotationAngle(bone107, 0.0F, -1.0472F, 0.0F);
		bone107.texOffs(70, 92).addBox(2.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		bone107.texOffs(70, 92).addBox(-4.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		bone108 = new ModelRenderer(this);
		bone108.setPos(0.0F, 0.0F, 0.0F);
		bone107.addChild(bone108);
		setRotationAngle(bone108, 0.0F, -1.0472F, 0.0F);
		bone108.texOffs(70, 92).addBox(2.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		bone108.texOffs(70, 92).addBox(-4.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		bone109 = new ModelRenderer(this);
		bone109.setPos(0.0F, 0.0F, 0.0F);
		bone108.addChild(bone109);
		setRotationAngle(bone109, 0.0F, -1.0472F, 0.0F);
		bone109.texOffs(70, 92).addBox(2.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		bone109.texOffs(70, 92).addBox(-4.0F, 1.0F, -13.05F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		bone98 = new ModelRenderer(this);
		bone98.setPos(0.0F, -43.5F, 0.0F);
		collar.addChild(bone98);
		bone98.texOffs(112, 119).addBox(-6.0F, 2.0F, -13.3F, 12.0F, 2.0F, 3.0F, 0.0F, false);

		bone99 = new ModelRenderer(this);
		bone99.setPos(0.0F, 0.0F, 0.0F);
		bone98.addChild(bone99);
		setRotationAngle(bone99, 0.0F, -1.0472F, 0.0F);
		bone99.texOffs(112, 119).addBox(-6.0F, 2.0F, -13.3F, 12.0F, 2.0F, 3.0F, 0.0F, false);

		bone100 = new ModelRenderer(this);
		bone100.setPos(0.0F, 0.0F, 0.0F);
		bone99.addChild(bone100);
		setRotationAngle(bone100, 0.0F, -1.0472F, 0.0F);
		bone100.texOffs(112, 119).addBox(-6.0F, 2.0F, -13.3F, 12.0F, 2.0F, 3.0F, 0.0F, false);

		bone101 = new ModelRenderer(this);
		bone101.setPos(0.0F, 0.0F, 0.0F);
		bone100.addChild(bone101);
		setRotationAngle(bone101, 0.0F, -1.0472F, 0.0F);
		bone101.texOffs(112, 119).addBox(-6.0F, 2.0F, -13.3F, 12.0F, 2.0F, 3.0F, 0.0F, false);

		bone102 = new ModelRenderer(this);
		bone102.setPos(0.0F, 0.0F, 0.0F);
		bone101.addChild(bone102);
		setRotationAngle(bone102, 0.0F, -1.0472F, 0.0F);
		bone102.texOffs(112, 119).addBox(-6.0F, 2.0F, -13.3F, 12.0F, 2.0F, 3.0F, 0.0F, false);

		bone103 = new ModelRenderer(this);
		bone103.setPos(0.0F, 0.0F, 0.0F);
		bone102.addChild(bone103);
		setRotationAngle(bone103, 0.0F, -1.0472F, 0.0F);
		bone103.texOffs(112, 119).addBox(-6.0F, 2.0F, -13.3F, 12.0F, 2.0F, 3.0F, 0.0F, false);

		lower_dividers = new ModelRenderer(this);
		lower_dividers.setPos(0.0F, -28.0F, 0.0F);
		base_console.addChild(lower_dividers);
		

		bone32 = new ModelRenderer(this);
		bone32.setPos(0.0F, -2.0F, -27.8F);
		lower_dividers.addChild(bone32);
		setRotationAngle(bone32, -0.7854F, 0.0F, 0.0F);
		bone32.texOffs(0, 75).addBox(-17.0F, -0.5858F, -2.5858F, 34.0F, 4.0F, 4.0F, 0.0F, false);

		bone26 = new ModelRenderer(this);
		bone26.setPos(0.0F, 0.0F, 0.0F);
		lower_dividers.addChild(bone26);
		setRotationAngle(bone26, 0.0F, -1.0472F, 0.0F);
		

		bone27 = new ModelRenderer(this);
		bone27.setPos(0.0F, -2.0F, -27.8F);
		bone26.addChild(bone27);
		setRotationAngle(bone27, -0.7854F, 0.0F, 0.0F);
		bone27.texOffs(0, 75).addBox(-17.0F, -0.5858F, -2.5858F, 34.0F, 4.0F, 4.0F, 0.0F, false);

		bone28 = new ModelRenderer(this);
		bone28.setPos(0.0F, 0.0F, 0.0F);
		bone26.addChild(bone28);
		setRotationAngle(bone28, 0.0F, -1.0472F, 0.0F);
		

		bone29 = new ModelRenderer(this);
		bone29.setPos(0.0F, -2.0F, -27.8F);
		bone28.addChild(bone29);
		setRotationAngle(bone29, -0.7854F, 0.0F, 0.0F);
		bone29.texOffs(0, 75).addBox(-17.0F, -0.5858F, -2.5858F, 34.0F, 4.0F, 4.0F, 0.0F, false);

		bone30 = new ModelRenderer(this);
		bone30.setPos(0.0F, 0.0F, 0.0F);
		bone28.addChild(bone30);
		setRotationAngle(bone30, 0.0F, -1.0472F, 0.0F);
		

		bone33 = new ModelRenderer(this);
		bone33.setPos(0.0F, -2.0F, -27.8F);
		bone30.addChild(bone33);
		setRotationAngle(bone33, -0.7854F, 0.0F, 0.0F);
		bone33.texOffs(0, 75).addBox(-17.0F, -0.5858F, -2.5858F, 34.0F, 4.0F, 4.0F, 0.0F, false);

		bone34 = new ModelRenderer(this);
		bone34.setPos(0.0F, 0.0F, 0.0F);
		bone30.addChild(bone34);
		setRotationAngle(bone34, 0.0F, -1.0472F, 0.0F);
		

		bone35 = new ModelRenderer(this);
		bone35.setPos(0.0F, -2.0F, -27.8F);
		bone34.addChild(bone35);
		setRotationAngle(bone35, -0.7854F, 0.0F, 0.0F);
		bone35.texOffs(0, 75).addBox(-17.0F, -0.5858F, -2.5858F, 34.0F, 4.0F, 4.0F, 0.0F, false);

		bone36 = new ModelRenderer(this);
		bone36.setPos(0.0F, 0.0F, 0.0F);
		bone34.addChild(bone36);
		setRotationAngle(bone36, 0.0F, -1.0472F, 0.0F);
		

		bone37 = new ModelRenderer(this);
		bone37.setPos(0.0F, -2.0F, -27.8F);
		bone36.addChild(bone37);
		setRotationAngle(bone37, -0.7854F, 0.0F, 0.0F);
		bone37.texOffs(0, 75).addBox(-17.0F, -0.5858F, -2.5858F, 34.0F, 4.0F, 4.0F, 0.0F, false);

		dividers2 = new ModelRenderer(this);
		dividers2.setPos(0.0F, -30.5F, 0.0F);
		base_console.addChild(dividers2);
		setRotationAngle(dividers2, 0.0F, -0.5236F, 0.0F);
		dividers2.texOffs(67, 44).addBox(-2.0F, -2.0F, -36.3F, 4.0F, 6.0F, 6.0F, 0.0F, false);

		bone40 = new ModelRenderer(this);
		bone40.setPos(0.0F, 0.0F, 0.0F);
		dividers2.addChild(bone40);
		setRotationAngle(bone40, 0.0F, -1.0472F, 0.0F);
		bone40.texOffs(67, 44).addBox(-2.0F, -2.0F, -36.3F, 4.0F, 6.0F, 6.0F, 0.0F, false);

		bone39 = new ModelRenderer(this);
		bone39.setPos(0.0F, 0.0F, 0.0F);
		bone40.addChild(bone39);
		setRotationAngle(bone39, 0.0F, -1.0472F, 0.0F);
		bone39.texOffs(67, 44).addBox(-2.0F, -2.0F, -36.3F, 4.0F, 6.0F, 6.0F, 0.0F, false);

		bone41 = new ModelRenderer(this);
		bone41.setPos(0.0F, 0.0F, 0.0F);
		bone39.addChild(bone41);
		setRotationAngle(bone41, 0.0F, -1.0472F, 0.0F);
		bone41.texOffs(67, 44).addBox(-2.0F, -2.0F, -36.3F, 4.0F, 6.0F, 6.0F, 0.0F, false);

		bone42 = new ModelRenderer(this);
		bone42.setPos(0.0F, 0.0F, 0.0F);
		bone41.addChild(bone42);
		setRotationAngle(bone42, 0.0F, -1.0472F, 0.0F);
		bone42.texOffs(67, 44).addBox(-2.0F, -2.0F, -36.3F, 4.0F, 6.0F, 6.0F, 0.0F, false);

		bone43 = new ModelRenderer(this);
		bone43.setPos(0.0F, 0.0F, 0.0F);
		bone42.addChild(bone43);
		setRotationAngle(bone43, 0.0F, -1.0472F, 0.0F);
		bone43.texOffs(67, 44).addBox(-2.0F, -2.0F, -36.3F, 4.0F, 6.0F, 6.0F, 0.0F, false);

		dividers = new ModelRenderer(this);
		dividers.setPos(0.0F, -30.5F, 0.0F);
		base_console.addChild(dividers);
		setRotationAngle(dividers, 0.0F, -0.5236F, 0.0F);
		

		bone50 = new ModelRenderer(this);
		bone50.setPos(0.0F, -2.0F, -34.3F);
		dividers.addChild(bone50);
		setRotationAngle(bone50, 0.4363F, 0.0F, 0.0F);
		bone50.texOffs(55, 75).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 22.0F, 0.0F, false);
		bone50.texOffs(81, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 22.0F, 0.0F, false);

		bone45 = new ModelRenderer(this);
		bone45.setPos(0.0F, 0.0F, 0.0F);
		dividers.addChild(bone45);
		setRotationAngle(bone45, 0.0F, -1.0472F, 0.0F);
		

		bone46 = new ModelRenderer(this);
		bone46.setPos(0.0F, -2.0F, -34.3F);
		bone45.addChild(bone46);
		setRotationAngle(bone46, 0.4363F, 0.0F, 0.0F);
		bone46.texOffs(55, 75).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 22.0F, 0.0F, false);
		bone46.texOffs(81, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 22.0F, 0.0F, false);

		bone47 = new ModelRenderer(this);
		bone47.setPos(0.0F, 0.0F, 0.0F);
		bone45.addChild(bone47);
		setRotationAngle(bone47, 0.0F, -1.0472F, 0.0F);
		

		bone48 = new ModelRenderer(this);
		bone48.setPos(0.0F, -2.0F, -34.3F);
		bone47.addChild(bone48);
		setRotationAngle(bone48, 0.4363F, 0.0F, 0.0F);
		bone48.texOffs(55, 75).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 22.0F, 0.0F, false);
		bone48.texOffs(81, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 22.0F, 0.0F, false);

		bone49 = new ModelRenderer(this);
		bone49.setPos(0.0F, 0.0F, 0.0F);
		bone47.addChild(bone49);
		setRotationAngle(bone49, 0.0F, -1.0472F, 0.0F);
		

		bone51 = new ModelRenderer(this);
		bone51.setPos(0.0F, -2.0F, -34.3F);
		bone49.addChild(bone51);
		setRotationAngle(bone51, 0.4363F, 0.0F, 0.0F);
		bone51.texOffs(55, 75).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 22.0F, 0.0F, false);
		bone51.texOffs(81, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 22.0F, 0.0F, false);

		bone52 = new ModelRenderer(this);
		bone52.setPos(0.0F, 0.0F, 0.0F);
		bone49.addChild(bone52);
		setRotationAngle(bone52, 0.0F, -1.0472F, 0.0F);
		

		bone53 = new ModelRenderer(this);
		bone53.setPos(0.0F, -2.0F, -34.3F);
		bone52.addChild(bone53);
		setRotationAngle(bone53, 0.4363F, 0.0F, 0.0F);
		bone53.texOffs(55, 75).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 22.0F, 0.0F, false);
		bone53.texOffs(81, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 22.0F, 0.0F, false);

		bone54 = new ModelRenderer(this);
		bone54.setPos(0.0F, 0.0F, 0.0F);
		bone52.addChild(bone54);
		setRotationAngle(bone54, 0.0F, -1.0472F, 0.0F);
		

		bone55 = new ModelRenderer(this);
		bone55.setPos(0.0F, -2.0F, -34.3F);
		bone54.addChild(bone55);
		setRotationAngle(bone55, 0.4363F, 0.0F, 0.0F);
		bone55.texOffs(55, 75).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 22.0F, 0.0F, false);
		bone55.texOffs(81, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 22.0F, 0.0F, false);

		bone122 = new ModelRenderer(this);
		bone122.setPos(0.0F, -44.5F, 0.0F);
		base_console.addChild(bone122);
		setRotationAngle(bone122, 0.0F, -0.5236F, 0.0F);
		bone122.texOffs(106, 0).addBox(-0.5F, -4.0F, -7.3F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		bone123 = new ModelRenderer(this);
		bone123.setPos(0.0F, 0.0F, 0.0F);
		bone122.addChild(bone123);
		setRotationAngle(bone123, 0.0F, -1.0472F, 0.0F);
		bone123.texOffs(106, 0).addBox(-0.5F, -4.0F, -7.3F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		bone124 = new ModelRenderer(this);
		bone124.setPos(0.0F, 0.0F, 0.0F);
		bone123.addChild(bone124);
		setRotationAngle(bone124, 0.0F, -1.0472F, 0.0F);
		bone124.texOffs(106, 0).addBox(-0.5F, -4.0F, -7.3F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		bone125 = new ModelRenderer(this);
		bone125.setPos(0.0F, 0.0F, 0.0F);
		bone124.addChild(bone125);
		setRotationAngle(bone125, 0.0F, -1.0472F, 0.0F);
		bone125.texOffs(106, 0).addBox(-0.5F, -4.0F, -7.3F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		bone126 = new ModelRenderer(this);
		bone126.setPos(0.0F, 0.0F, 0.0F);
		bone125.addChild(bone126);
		setRotationAngle(bone126, 0.0F, -1.0472F, 0.0F);
		bone126.texOffs(106, 0).addBox(-0.5F, -4.0F, -7.3F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		bone127 = new ModelRenderer(this);
		bone127.setPos(0.0F, 0.0F, 0.0F);
		bone126.addChild(bone127);
		setRotationAngle(bone127, 0.0F, -1.0472F, 0.0F);
		bone127.texOffs(106, 0).addBox(-0.5F, -4.0F, -7.3F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		bone110 = new ModelRenderer(this);
		bone110.setPos(0.0F, -44.5F, 0.0F);
		base_console.addChild(bone110);
		setRotationAngle(bone110, 0.0F, -0.5236F, 0.0F);
		

		bone116 = new ModelRenderer(this);
		bone116.setPos(0.0F, -2.0F, -12.3F);
		bone110.addChild(bone116);
		setRotationAngle(bone116, -1.0472F, 0.0F, 0.0F);
		bone116.texOffs(0, 84).addBox(-1.0F, -7.0F, 0.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		bone111 = new ModelRenderer(this);
		bone111.setPos(0.0F, 0.0F, 0.0F);
		bone110.addChild(bone111);
		setRotationAngle(bone111, 0.0F, -1.0472F, 0.0F);
		

		bone112 = new ModelRenderer(this);
		bone112.setPos(0.0F, -2.0F, -12.3F);
		bone111.addChild(bone112);
		setRotationAngle(bone112, -1.0472F, 0.0F, 0.0F);
		bone112.texOffs(0, 84).addBox(-1.0F, -7.0F, 0.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		bone113 = new ModelRenderer(this);
		bone113.setPos(0.0F, 0.0F, 0.0F);
		bone111.addChild(bone113);
		setRotationAngle(bone113, 0.0F, -1.0472F, 0.0F);
		

		bone114 = new ModelRenderer(this);
		bone114.setPos(0.0F, -2.0F, -12.3F);
		bone113.addChild(bone114);
		setRotationAngle(bone114, -1.0472F, 0.0F, 0.0F);
		bone114.texOffs(0, 84).addBox(-1.0F, -7.0F, 0.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		bone115 = new ModelRenderer(this);
		bone115.setPos(0.0F, 0.0F, 0.0F);
		bone113.addChild(bone115);
		setRotationAngle(bone115, 0.0F, -1.0472F, 0.0F);
		

		bone117 = new ModelRenderer(this);
		bone117.setPos(0.0F, -2.0F, -12.3F);
		bone115.addChild(bone117);
		setRotationAngle(bone117, -1.0472F, 0.0F, 0.0F);
		bone117.texOffs(0, 84).addBox(-1.0F, -7.0F, 0.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		bone118 = new ModelRenderer(this);
		bone118.setPos(0.0F, 0.0F, 0.0F);
		bone115.addChild(bone118);
		setRotationAngle(bone118, 0.0F, -1.0472F, 0.0F);
		

		bone119 = new ModelRenderer(this);
		bone119.setPos(0.0F, -2.0F, -12.3F);
		bone118.addChild(bone119);
		setRotationAngle(bone119, -1.0472F, 0.0F, 0.0F);
		bone119.texOffs(0, 84).addBox(-1.0F, -7.0F, 0.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		bone120 = new ModelRenderer(this);
		bone120.setPos(0.0F, 0.0F, 0.0F);
		bone118.addChild(bone120);
		setRotationAngle(bone120, 0.0F, -1.0472F, 0.0F);
		

		bone121 = new ModelRenderer(this);
		bone121.setPos(0.0F, -2.0F, -12.3F);
		bone120.addChild(bone121);
		setRotationAngle(bone121, -1.0472F, 0.0F, 0.0F);
		bone121.texOffs(0, 84).addBox(-1.0F, -7.0F, 0.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		bone84 = new ModelRenderer(this);
		bone84.setPos(0.0F, -4.0F, 0.0F);
		base_console.addChild(bone84);
		bone84.texOffs(106, 10).addBox(-6.5F, -23.5F, -22.8F, 13.0F, 4.0F, 5.0F, 0.0F, false);

		bone85 = new ModelRenderer(this);
		bone85.setPos(0.0F, -22.5F, -20.3F);
		bone84.addChild(bone85);
		setRotationAngle(bone85, 0.4363F, 0.0F, 0.0F);
		bone85.texOffs(86, 75).addBox(-5.5F, -3.0F, -4.5F, 11.0F, 7.0F, 11.0F, 0.0F, false);

		bone148 = new ModelRenderer(this);
		bone148.setPos(0.0F, 0.0F, 0.0F);
		bone84.addChild(bone148);
		setRotationAngle(bone148, 0.0F, -2.0944F, 0.0F);
		bone148.texOffs(106, 10).addBox(-6.5F, -23.5F, -22.8F, 13.0F, 4.0F, 5.0F, 0.0F, false);

		bone149 = new ModelRenderer(this);
		bone149.setPos(0.0F, -22.5F, -20.3F);
		bone148.addChild(bone149);
		setRotationAngle(bone149, 0.4363F, 0.0F, 0.0F);
		bone149.texOffs(86, 75).addBox(-5.5F, -3.0F, -4.5F, 11.0F, 7.0F, 11.0F, 0.0F, false);

		bone166 = new ModelRenderer(this);
		bone166.setPos(0.0F, 3.0F, -4.5F);
		bone149.addChild(bone166);
		setRotationAngle(bone166, 0.6545F, 0.0F, 0.0F);
		bone166.texOffs(120, 71).addBox(-4.5F, -5.0F, 0.0F, 9.0F, 5.0F, 4.0F, 0.0F, false);

		bone150 = new ModelRenderer(this);
		bone150.setPos(0.0F, 0.0F, 0.0F);
		bone148.addChild(bone150);
		setRotationAngle(bone150, 0.0F, -2.0944F, 0.0F);
		bone150.texOffs(106, 10).addBox(-6.5F, -23.5F, -22.8F, 13.0F, 4.0F, 5.0F, 0.0F, false);

		bone151 = new ModelRenderer(this);
		bone151.setPos(0.0F, -22.5F, -20.3F);
		bone150.addChild(bone151);
		setRotationAngle(bone151, 0.4363F, 0.0F, 0.0F);
		bone151.texOffs(86, 75).addBox(-5.5F, -3.0F, -4.5F, 11.0F, 7.0F, 11.0F, 0.0F, false);

		bone62 = new ModelRenderer(this);
		bone62.setPos(0.0F, -4.0F, 0.0F);
		base_console.addChild(bone62);
		setRotationAngle(bone62, 0.0F, -1.0472F, 0.0F);
		bone62.texOffs(73, 126).addBox(-2.5F, -18.5F, -17.8F, 5.0F, 5.0F, 6.0F, 0.0F, false);

		bone81 = new ModelRenderer(this);
		bone81.setPos(14.5803F, -13.5F, -10.15F);
		bone62.addChild(bone81);
		bone81.texOffs(0, 44).addBox(-17.0803F, -9.0F, -12.65F, 5.0F, 9.0F, 5.0F, 0.0F, false);
		bone81.texOffs(74, 116).addBox(-18.0803F, -10.0F, -13.65F, 7.0F, 2.0F, 7.0F, 0.0F, false);

		bone63 = new ModelRenderer(this);
		bone63.setPos(0.0F, 0.0F, 0.0F);
		bone62.addChild(bone63);
		setRotationAngle(bone63, 0.0F, -2.0944F, 0.0F);
		bone63.texOffs(73, 126).addBox(-2.5F, -18.5F, -17.8F, 5.0F, 5.0F, 6.0F, 0.0F, false);

		bone64 = new ModelRenderer(this);
		bone64.setPos(14.5803F, -13.5F, -10.15F);
		bone63.addChild(bone64);
		bone64.texOffs(0, 44).addBox(-17.0803F, -9.0F, -12.65F, 5.0F, 9.0F, 5.0F, 0.0F, false);
		bone64.texOffs(74, 116).addBox(-18.0803F, -10.0F, -13.65F, 7.0F, 2.0F, 7.0F, 0.0F, false);

		bone82 = new ModelRenderer(this);
		bone82.setPos(0.0F, 0.0F, 0.0F);
		bone63.addChild(bone82);
		setRotationAngle(bone82, 0.0F, -2.0944F, 0.0F);
		bone82.texOffs(73, 126).addBox(-2.5F, -18.5F, -17.8F, 5.0F, 5.0F, 6.0F, 0.0F, false);

		bone83 = new ModelRenderer(this);
		bone83.setPos(14.5803F, -13.5F, -10.15F);
		bone82.addChild(bone83);
		bone83.texOffs(0, 44).addBox(-17.0803F, -9.0F, -12.65F, 5.0F, 9.0F, 5.0F, 0.0F, false);
		bone83.texOffs(74, 116).addBox(-18.0803F, -10.0F, -13.65F, 7.0F, 2.0F, 7.0F, 0.0F, false);

		bone60 = new ModelRenderer(this);
		bone60.setPos(0.0F, -26.0F, 0.0F);
		base_console.addChild(bone60);
		

		bone61 = new ModelRenderer(this);
		bone61.setPos(0.0F, -2.0F, -30.8F);
		bone60.addChild(bone61);
		setRotationAngle(bone61, -0.2182F, 0.0F, 0.0F);
		bone61.texOffs(0, 22).addBox(-15.0F, -1.226F, 0.0765F, 30.0F, 1.0F, 20.0F, 0.0F, false);

		bone65 = new ModelRenderer(this);
		bone65.setPos(0.0F, 0.0F, 0.0F);
		bone60.addChild(bone65);
		setRotationAngle(bone65, 0.0F, -1.0472F, 0.0F);
		

		bone66 = new ModelRenderer(this);
		bone66.setPos(0.0F, -2.0F, -30.8F);
		bone65.addChild(bone66);
		setRotationAngle(bone66, -0.2182F, 0.0F, 0.0F);
		bone66.texOffs(0, 22).addBox(-15.0F, -1.226F, 0.0765F, 30.0F, 1.0F, 20.0F, 0.0F, false);

		bone67 = new ModelRenderer(this);
		bone67.setPos(0.0F, 0.0F, 0.0F);
		bone65.addChild(bone67);
		setRotationAngle(bone67, 0.0F, -1.0472F, 0.0F);
		

		bone68 = new ModelRenderer(this);
		bone68.setPos(0.0F, -2.0F, -30.8F);
		bone67.addChild(bone68);
		setRotationAngle(bone68, -0.2182F, 0.0F, 0.0F);
		bone68.texOffs(0, 22).addBox(-15.0F, -1.226F, 0.0765F, 30.0F, 1.0F, 20.0F, 0.0F, false);

		bone69 = new ModelRenderer(this);
		bone69.setPos(0.0F, 0.0F, 0.0F);
		bone67.addChild(bone69);
		setRotationAngle(bone69, 0.0F, -1.0472F, 0.0F);
		

		bone70 = new ModelRenderer(this);
		bone70.setPos(0.0F, -2.0F, -30.8F);
		bone69.addChild(bone70);
		setRotationAngle(bone70, -0.2182F, 0.0F, 0.0F);
		bone70.texOffs(0, 22).addBox(-15.0F, -1.226F, 0.0765F, 30.0F, 1.0F, 20.0F, 0.0F, false);

		bone144 = new ModelRenderer(this);
		bone144.setPos(0.0F, 0.0F, 0.0F);
		bone69.addChild(bone144);
		setRotationAngle(bone144, 0.0F, -1.0472F, 0.0F);
		

		bone145 = new ModelRenderer(this);
		bone145.setPos(0.0F, -2.0F, -30.8F);
		bone144.addChild(bone145);
		setRotationAngle(bone145, -0.2182F, 0.0F, 0.0F);
		bone145.texOffs(0, 22).addBox(-15.0F, -1.226F, 0.0765F, 30.0F, 1.0F, 20.0F, 0.0F, false);

		bone146 = new ModelRenderer(this);
		bone146.setPos(0.0F, 0.0F, 0.0F);
		bone144.addChild(bone146);
		setRotationAngle(bone146, 0.0F, -1.0472F, 0.0F);
		

		bone147 = new ModelRenderer(this);
		bone147.setPos(0.0F, -2.0F, -30.8F);
		bone146.addChild(bone147);
		setRotationAngle(bone147, -0.2182F, 0.0F, 0.0F);
		bone147.texOffs(0, 22).addBox(-15.0F, -1.226F, 0.0765F, 30.0F, 1.0F, 20.0F, 0.0F, false);

		bone58 = new ModelRenderer(this);
		bone58.setPos(0.0F, -28.5F, 0.0F);
		base_console.addChild(bone58);
		setRotationAngle(bone58, 0.0F, -0.5236F, 0.0F);
		

		bone59 = new ModelRenderer(this);
		bone59.setPos(0.0F, 2.0F, -34.3F);
		bone58.addChild(bone59);
		setRotationAngle(bone59, -0.3927F, 0.0F, 0.0F);
		bone59.texOffs(65, 44).addBox(-2.0F, -6.0F, 0.0F, 4.0F, 6.0F, 24.0F, 0.0F, false);

		bone71 = new ModelRenderer(this);
		bone71.setPos(0.0F, 0.0F, 0.0F);
		bone58.addChild(bone71);
		setRotationAngle(bone71, 0.0F, -1.0472F, 0.0F);
		

		bone72 = new ModelRenderer(this);
		bone72.setPos(0.0F, 2.0F, -34.3F);
		bone71.addChild(bone72);
		setRotationAngle(bone72, -0.3927F, 0.0F, 0.0F);
		bone72.texOffs(65, 44).addBox(-2.0F, -6.0F, 0.0F, 4.0F, 6.0F, 24.0F, 0.0F, false);

		bone73 = new ModelRenderer(this);
		bone73.setPos(0.0F, 0.0F, 0.0F);
		bone71.addChild(bone73);
		setRotationAngle(bone73, 0.0F, -1.0472F, 0.0F);
		

		bone74 = new ModelRenderer(this);
		bone74.setPos(0.0F, 2.0F, -34.3F);
		bone73.addChild(bone74);
		setRotationAngle(bone74, -0.3927F, 0.0F, 0.0F);
		bone74.texOffs(65, 44).addBox(-2.0F, -6.0F, 0.0F, 4.0F, 6.0F, 24.0F, 0.0F, false);

		bone75 = new ModelRenderer(this);
		bone75.setPos(0.0F, 0.0F, 0.0F);
		bone73.addChild(bone75);
		setRotationAngle(bone75, 0.0F, -1.0472F, 0.0F);
		

		bone76 = new ModelRenderer(this);
		bone76.setPos(0.0F, 2.0F, -34.3F);
		bone75.addChild(bone76);
		setRotationAngle(bone76, -0.3927F, 0.0F, 0.0F);
		bone76.texOffs(65, 44).addBox(-2.0F, -6.0F, 0.0F, 4.0F, 6.0F, 24.0F, 0.0F, false);

		bone77 = new ModelRenderer(this);
		bone77.setPos(0.0F, 0.0F, 0.0F);
		bone75.addChild(bone77);
		setRotationAngle(bone77, 0.0F, -1.0472F, 0.0F);
		

		bone78 = new ModelRenderer(this);
		bone78.setPos(0.0F, 2.0F, -34.3F);
		bone77.addChild(bone78);
		setRotationAngle(bone78, -0.3927F, 0.0F, 0.0F);
		bone78.texOffs(65, 44).addBox(-2.0F, -6.0F, 0.0F, 4.0F, 6.0F, 24.0F, 0.0F, false);

		bone79 = new ModelRenderer(this);
		bone79.setPos(0.0F, 0.0F, 0.0F);
		bone77.addChild(bone79);
		setRotationAngle(bone79, 0.0F, -1.0472F, 0.0F);
		

		bone80 = new ModelRenderer(this);
		bone80.setPos(0.0F, 2.0F, -34.3F);
		bone79.addChild(bone80);
		setRotationAngle(bone80, -0.3927F, 0.0F, 0.0F);
		bone80.texOffs(65, 44).addBox(-2.0F, -6.0F, 0.0F, 4.0F, 6.0F, 24.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setPos(0.0F, -4.0F, 0.0F);
		base_console.addChild(bone13);
		setRotationAngle(bone13, 0.0F, -0.5236F, 0.0F);
		bone13.texOffs(23, 130).addBox(-1.0F, -16.0F, -15.6832F, 2.0F, 16.0F, 4.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setPos(0.0F, 0.0F, 0.0F);
		bone13.addChild(bone14);
		setRotationAngle(bone14, 0.0F, -1.0472F, 0.0F);
		bone14.texOffs(23, 130).addBox(-1.0F, -16.0F, -15.6832F, 2.0F, 16.0F, 4.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setPos(0.0F, 0.0F, 0.0F);
		bone14.addChild(bone15);
		setRotationAngle(bone15, 0.0F, -1.0472F, 0.0F);
		bone15.texOffs(23, 130).addBox(-1.0F, -16.0F, -15.6832F, 2.0F, 16.0F, 4.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setPos(0.0F, 0.0F, 0.0F);
		bone15.addChild(bone16);
		setRotationAngle(bone16, 0.0F, -1.0472F, 0.0F);
		bone16.texOffs(23, 130).addBox(-1.0F, -16.0F, -15.6832F, 2.0F, 16.0F, 4.0F, 0.0F, false);

		bone17 = new ModelRenderer(this);
		bone17.setPos(0.0F, 0.0F, 0.0F);
		bone16.addChild(bone17);
		setRotationAngle(bone17, 0.0F, -1.0472F, 0.0F);
		bone17.texOffs(23, 130).addBox(-1.0F, -16.0F, -15.6832F, 2.0F, 16.0F, 4.0F, 0.0F, false);

		bone18 = new ModelRenderer(this);
		bone18.setPos(0.0F, 0.0F, 0.0F);
		bone17.addChild(bone18);
		setRotationAngle(bone18, 0.0F, -1.0472F, 0.0F);
		bone18.texOffs(23, 130).addBox(-1.0F, -16.0F, -15.6832F, 2.0F, 16.0F, 4.0F, 0.0F, false);

		bone19 = new ModelRenderer(this);
		bone19.setPos(0.0F, -4.0F, 0.0F);
		base_console.addChild(bone19);
		bone19.texOffs(0, 110).addBox(-6.0F, -20.0F, -11.8F, 12.0F, 20.0F, 1.0F, 0.0F, false);

		bone20 = new ModelRenderer(this);
		bone20.setPos(0.0F, 0.0F, 0.0F);
		bone19.addChild(bone20);
		setRotationAngle(bone20, 0.0F, -1.0472F, 0.0F);
		bone20.texOffs(0, 110).addBox(-6.0F, -20.0F, -11.8F, 12.0F, 20.0F, 1.0F, 0.0F, false);
		bone20.texOffs(0, 22).addBox(-3.0F, -11.0F, -13.8F, 6.0F, 9.0F, 2.0F, 0.0F, false);

		bone21 = new ModelRenderer(this);
		bone21.setPos(0.0F, 0.0F, 0.0F);
		bone20.addChild(bone21);
		setRotationAngle(bone21, 0.0F, -1.0472F, 0.0F);
		bone21.texOffs(0, 110).addBox(-6.0F, -20.0F, -11.8F, 12.0F, 20.0F, 1.0F, 0.0F, false);
		bone21.texOffs(128, 132).addBox(-3.5F, -10.0F, -12.8F, 7.0F, 4.0F, 1.0F, 0.0F, false);

		bone132 = new ModelRenderer(this);
		bone132.setPos(-1.5F, -9.5F, -12.3F);
		bone21.addChild(bone132);
		setRotationAngle(bone132, 0.3491F, 0.0F, 0.0F);
		bone132.texOffs(137, 143).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bone132.texOffs(82, 44).addBox(2.5F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		bone22 = new ModelRenderer(this);
		bone22.setPos(0.0F, 0.0F, 0.0F);
		bone21.addChild(bone22);
		setRotationAngle(bone22, 0.0F, -1.0472F, 0.0F);
		bone22.texOffs(0, 110).addBox(-6.0F, -20.0F, -11.8F, 12.0F, 20.0F, 1.0F, 0.0F, false);
		bone22.texOffs(0, 34).addBox(-3.0F, -6.0F, -14.8F, 6.0F, 2.0F, 3.0F, 0.0F, false);
		bone22.texOffs(81, 0).addBox(-3.0F, -11.0F, -12.05F, 6.0F, 9.0F, 1.0F, 0.0F, false);
		bone22.texOffs(61, 130).addBox(-1.0F, -14.0F, -14.3F, 2.0F, 14.0F, 2.0F, 0.0F, false);

		bone23 = new ModelRenderer(this);
		bone23.setPos(0.0F, 0.0F, 0.0F);
		bone22.addChild(bone23);
		setRotationAngle(bone23, 0.0F, -1.0472F, 0.0F);
		bone23.texOffs(0, 110).addBox(-6.0F, -20.0F, -11.8F, 12.0F, 20.0F, 1.0F, 0.0F, false);

		bone24 = new ModelRenderer(this);
		bone24.setPos(0.0F, 0.0F, 0.0F);
		bone23.addChild(bone24);
		setRotationAngle(bone24, 0.0F, -1.0472F, 0.0F);
		bone24.texOffs(0, 110).addBox(-6.0F, -20.0F, -11.8F, 12.0F, 20.0F, 1.0F, 0.0F, false);
		bone24.texOffs(0, 0).addBox(-3.0F, -11.0F, -13.8F, 6.0F, 9.0F, 2.0F, 0.0F, false);
		bone24.texOffs(16, 44).addBox(-2.0F, -9.0F, -14.8F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone24.texOffs(98, 16).addBox(-0.5F, -4.75F, -14.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setPos(0.0F, 0.0F, 0.0F);
		base_console.addChild(bone7);
		setRotationAngle(bone7, 0.0F, -0.5236F, 0.0F);
		bone7.texOffs(83, 138).addBox(-1.0F, -4.0F, -17.6832F, 2.0F, 4.0F, 4.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setPos(0.0F, 0.0F, 0.0F);
		bone7.addChild(bone8);
		setRotationAngle(bone8, 0.0F, -1.0472F, 0.0F);
		bone8.texOffs(83, 138).addBox(-1.0F, -4.0F, -17.6832F, 2.0F, 4.0F, 4.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setPos(0.0F, 0.0F, 0.0F);
		bone8.addChild(bone9);
		setRotationAngle(bone9, 0.0F, -1.0472F, 0.0F);
		bone9.texOffs(83, 138).addBox(-1.0F, -4.0F, -17.6832F, 2.0F, 4.0F, 4.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setPos(0.0F, 0.0F, 0.0F);
		bone9.addChild(bone10);
		setRotationAngle(bone10, 0.0F, -1.0472F, 0.0F);
		bone10.texOffs(83, 138).addBox(-1.0F, -4.0F, -17.6832F, 2.0F, 4.0F, 4.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setPos(0.0F, 0.0F, 0.0F);
		bone10.addChild(bone11);
		setRotationAngle(bone11, 0.0F, -1.0472F, 0.0F);
		bone11.texOffs(83, 138).addBox(-1.0F, -4.0F, -17.6832F, 2.0F, 4.0F, 4.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setPos(0.0F, 0.0F, 0.0F);
		bone11.addChild(bone12);
		setRotationAngle(bone12, 0.0F, -1.0472F, 0.0F);
		bone12.texOffs(83, 138).addBox(-1.0F, -4.0F, -17.6832F, 2.0F, 4.0F, 4.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setPos(0.0F, 0.0F, 0.0F);
		base_console.addChild(bone);
		bone.texOffs(47, 102).addBox(-8.0F, -4.0F, -15.8F, 16.0F, 4.0F, 4.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setPos(0.0F, 0.0F, 0.0F);
		bone.addChild(bone2);
		setRotationAngle(bone2, 0.0F, -1.0472F, 0.0F);
		bone2.texOffs(47, 102).addBox(-8.0F, -4.0F, -15.8F, 16.0F, 4.0F, 4.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setPos(0.0F, 0.0F, 0.0F);
		bone2.addChild(bone3);
		setRotationAngle(bone3, 0.0F, -1.0472F, 0.0F);
		bone3.texOffs(47, 102).addBox(-8.0F, -4.0F, -15.8F, 16.0F, 4.0F, 4.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setPos(0.0F, 0.0F, 0.0F);
		bone3.addChild(bone4);
		setRotationAngle(bone4, 0.0F, -1.0472F, 0.0F);
		bone4.texOffs(47, 102).addBox(-8.0F, -4.0F, -15.8F, 16.0F, 4.0F, 4.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setPos(0.0F, 0.0F, 0.0F);
		bone4.addChild(bone5);
		setRotationAngle(bone5, 0.0F, -1.0472F, 0.0F);
		bone5.texOffs(47, 102).addBox(-8.0F, -4.0F, -15.8F, 16.0F, 4.0F, 4.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setPos(0.0F, 0.0F, 0.0F);
		bone5.addChild(bone6);
		setRotationAngle(bone6, 0.0F, -1.0472F, 0.0F);
		bone6.texOffs(47, 102).addBox(-8.0F, -4.0F, -15.8F, 16.0F, 4.0F, 4.0F, 0.0F, false);

		bone208 = new ModelRenderer(this);
		bone208.setPos(0.0F, 0.0F, 0.0F);
		base_console.addChild(bone208);
		bone208.texOffs(81, 27).addBox(-7.0F, -1.0F, -11.8F, 14.0F, 1.0F, 13.0F, 0.0F, false);

		bone209 = new ModelRenderer(this);
		bone209.setPos(0.0F, 0.0F, 0.0F);
		bone208.addChild(bone209);
		setRotationAngle(bone209, 0.0F, -1.0472F, 0.0F);
		bone209.texOffs(81, 27).addBox(-7.0F, -1.0F, -11.8F, 14.0F, 1.0F, 13.0F, 0.0F, false);

		bone210 = new ModelRenderer(this);
		bone210.setPos(0.0F, 0.0F, 0.0F);
		bone209.addChild(bone210);
		setRotationAngle(bone210, 0.0F, -1.0472F, 0.0F);
		bone210.texOffs(81, 27).addBox(-7.0F, -1.0F, -11.8F, 14.0F, 1.0F, 13.0F, 0.0F, false);

		bone211 = new ModelRenderer(this);
		bone211.setPos(0.0F, 0.0F, 0.0F);
		bone210.addChild(bone211);
		setRotationAngle(bone211, 0.0F, -1.0472F, 0.0F);
		bone211.texOffs(81, 27).addBox(-7.0F, -1.0F, -11.8F, 14.0F, 1.0F, 13.0F, 0.0F, false);

		bone212 = new ModelRenderer(this);
		bone212.setPos(0.0F, 0.0F, 0.0F);
		bone211.addChild(bone212);
		setRotationAngle(bone212, 0.0F, -1.0472F, 0.0F);
		bone212.texOffs(81, 27).addBox(-7.0F, -1.0F, -11.8F, 14.0F, 1.0F, 13.0F, 0.0F, false);

		bone213 = new ModelRenderer(this);
		bone213.setPos(0.0F, 0.0F, 0.0F);
		bone212.addChild(bone213);
		setRotationAngle(bone213, 0.0F, -1.0472F, 0.0F);
		bone213.texOffs(81, 27).addBox(-7.0F, -1.0F, -11.8F, 14.0F, 1.0F, 13.0F, 0.0F, false);

		rotor = new ModelRenderer(this);
		rotor.setPos(0.0F, 24.0F, 0.0F);
		rotor.texOffs(0, 44).addBox(-11.0F, -42.0F, -11.0F, 22.0F, 1.0F, 22.0F, 0.0F, false);
		rotor.texOffs(52, 111).addBox(-3.5F, -53.5F, -3.5F, 7.0F, 2.0F, 7.0F, 0.0F, false);
		rotor.texOffs(27, 110).addBox(-3.0F, -55.0F, -3.0F, 6.0F, 13.0F, 6.0F, 0.0F, false);
		rotor.texOffs(135, 48).addBox(-2.0F, -56.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		rotor.texOffs(52, 111).addBox(-3.5F, -47.5F, -3.5F, 7.0F, 2.0F, 7.0F, 0.0F, false);
		rotor.texOffs(52, 111).addBox(-3.5F, -50.5F, -3.5F, 7.0F, 2.0F, 7.0F, 0.0F, false);

		bone138 = new ModelRenderer(this);
		bone138.setPos(0.0F, -43.5F, 0.0F);
		rotor.addChild(bone138);
		bone138.texOffs(81, 27).addBox(-1.5F, -7.475F, -8.775F, 3.0F, 9.0F, 3.0F, 0.0F, false);
		bone138.texOffs(97, 0).addBox(-0.5F, -8.975F, -7.775F, 1.0F, 11.0F, 1.0F, 0.0F, false);

		bone139 = new ModelRenderer(this);
		bone139.setPos(0.0F, 0.0F, 0.0F);
		bone138.addChild(bone139);
		setRotationAngle(bone139, 0.0F, -1.0472F, 0.0F);
		bone139.texOffs(81, 27).addBox(-1.5F, -7.475F, -8.775F, 3.0F, 9.0F, 3.0F, 0.0F, false);
		bone139.texOffs(97, 0).addBox(-0.5F, -8.975F, -7.775F, 1.0F, 11.0F, 1.0F, 0.0F, false);

		bone140 = new ModelRenderer(this);
		bone140.setPos(0.0F, 0.0F, 0.0F);
		bone139.addChild(bone140);
		setRotationAngle(bone140, 0.0F, -1.0472F, 0.0F);
		bone140.texOffs(81, 27).addBox(-1.5F, -7.475F, -8.775F, 3.0F, 9.0F, 3.0F, 0.0F, false);
		bone140.texOffs(97, 0).addBox(-0.5F, -8.975F, -7.775F, 1.0F, 11.0F, 1.0F, 0.0F, false);

		bone141 = new ModelRenderer(this);
		bone141.setPos(0.0F, 0.0F, 0.0F);
		bone140.addChild(bone141);
		setRotationAngle(bone141, 0.0F, -1.0472F, 0.0F);
		bone141.texOffs(81, 27).addBox(-1.5F, -7.475F, -8.775F, 3.0F, 9.0F, 3.0F, 0.0F, false);
		bone141.texOffs(97, 0).addBox(-0.5F, -8.975F, -7.775F, 1.0F, 11.0F, 1.0F, 0.0F, false);

		bone142 = new ModelRenderer(this);
		bone142.setPos(0.0F, 0.0F, 0.0F);
		bone141.addChild(bone142);
		setRotationAngle(bone142, 0.0F, -1.0472F, 0.0F);
		bone142.texOffs(81, 27).addBox(-1.5F, -7.475F, -8.775F, 3.0F, 9.0F, 3.0F, 0.0F, false);
		bone142.texOffs(97, 0).addBox(-0.5F, -8.975F, -7.775F, 1.0F, 11.0F, 1.0F, 0.0F, false);

		bone143 = new ModelRenderer(this);
		bone143.setPos(0.0F, 0.0F, 0.0F);
		bone142.addChild(bone143);
		setRotationAngle(bone143, 0.0F, -1.0472F, 0.0F);
		bone143.texOffs(81, 27).addBox(-1.5F, -7.475F, -8.775F, 3.0F, 9.0F, 3.0F, 0.0F, false);
		bone143.texOffs(97, 0).addBox(-0.5F, -8.975F, -7.775F, 1.0F, 11.0F, 1.0F, 0.0F, false);

		glow = new LightModelRenderer(this);
		glow.setPos(0.0F, 24.0F, 0.0F);
		

		NORTH2 = new ModelRenderer(this);
		NORTH2.setPos(0.0F, -30.0F, 0.0F);
		glow.addChild(NORTH2);
		

		bone31 = new ModelRenderer(this);
		bone31.setPos(0.0F, -4.0F, -27.8F);
		NORTH2.addChild(bone31);
		setRotationAngle(bone31, 0.48F, 0.0F, 0.0F);
		bone31.texOffs(145, 54).addBox(-9.5F, 0.524F, -0.4235F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone31.texOffs(145, 54).addBox(-6.75F, 0.524F, -0.4235F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone31.texOffs(145, 54).addBox(7.5F, 0.524F, -0.4235F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone31.texOffs(145, 54).addBox(4.75F, 0.524F, -0.4235F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone31.texOffs(0, 140).addBox(1.0F, 1.024F, 0.5765F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		bone31.texOffs(0, 140).addBox(-2.0F, 1.024F, 0.5765F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		bone178 = new ModelRenderer(this);
		bone178.setPos(-9.0F, 0.524F, 0.0765F);
		bone31.addChild(bone178);
		setRotationAngle(bone178, 0.6109F, 0.0F, 0.0F);
		

		bone179 = new ModelRenderer(this);
		bone179.setPos(-6.25F, 0.524F, 0.0765F);
		bone31.addChild(bone179);
		setRotationAngle(bone179, 0.6109F, 0.0F, 0.0F);
		

		bone180 = new ModelRenderer(this);
		bone180.setPos(5.25F, 0.524F, 0.0765F);
		bone31.addChild(bone180);
		setRotationAngle(bone180, 0.6109F, 0.0F, 0.0F);
		

		bone181 = new ModelRenderer(this);
		bone181.setPos(8.0F, 0.524F, 0.0765F);
		bone31.addChild(bone181);
		setRotationAngle(bone181, 0.6109F, 0.0F, 0.0F);
		

		bone182 = new ModelRenderer(this);
		bone182.setPos(-7.75F, 1.274F, 6.0765F);
		bone31.addChild(bone182);
		setRotationAngle(bone182, 0.0F, 0.0F, 0.6109F);
		bone182.texOffs(37, 98).addBox(0.0F, -0.75F, -2.5F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		bone183 = new ModelRenderer(this);
		bone183.setPos(7.75F, 1.274F, 6.0765F);
		bone31.addChild(bone183);
		setRotationAngle(bone183, 0.0F, 0.0F, -0.6109F);
		bone183.texOffs(37, 98).addBox(-1.0F, -0.75F, -2.5F, 1.0F, 1.0F, 5.0F, 0.0F, true);

		bone184 = new ModelRenderer(this);
		bone184.setPos(-8.75F, 1.274F, 6.0765F);
		bone31.addChild(bone184);
		setRotationAngle(bone184, 0.0F, 0.0F, 0.6109F);
		bone184.texOffs(79, 138).addBox(0.0F, -0.75F, -2.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		bone185 = new ModelRenderer(this);
		bone185.setPos(8.75F, 1.274F, 6.0765F);
		bone31.addChild(bone185);
		setRotationAngle(bone185, 0.0F, 0.0F, -0.6109F);
		bone185.texOffs(79, 138).addBox(-1.0F, -0.75F, -2.5F, 1.0F, 1.0F, 2.0F, 0.0F, true);

		NORTH_WEST2 = new ModelRenderer(this);
		NORTH_WEST2.setPos(0.0F, -30.0F, 0.0F);
		glow.addChild(NORTH_WEST2);
		setRotationAngle(NORTH_WEST2, 0.0F, -1.0472F, 0.0F);
		

		bone186 = new ModelRenderer(this);
		bone186.setPos(0.0F, -4.0F, -27.8F);
		NORTH_WEST2.addChild(bone186);
		setRotationAngle(bone186, 0.48F, 0.0F, 0.0F);
		bone186.texOffs(144, 136).addBox(8.5F, -0.226F, 0.0765F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone187 = new ModelRenderer(this);
		bone187.setPos(0.0F, 1.274F, 6.0765F);
		bone186.addChild(bone187);
		setRotationAngle(bone187, -0.9163F, 0.0F, 0.0F);
		bone187.texOffs(52, 121).addBox(-1.0F, -1.0F, -4.25F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		bone189 = new ModelRenderer(this);
		bone189.setPos(-4.0F, 1.024F, 6.0765F);
		bone186.addChild(bone189);
		setRotationAngle(bone189, 0.0F, 0.0F, 0.3927F);
		bone189.texOffs(94, 119).addBox(-4.0F, 0.0F, -5.0F, 4.0F, 1.0F, 9.0F, 0.0F, false);

		bone190 = new ModelRenderer(this);
		bone190.setPos(4.0F, 1.024F, 6.0765F);
		bone186.addChild(bone190);
		setRotationAngle(bone190, 0.0F, 0.0F, -0.3927F);
		bone190.texOffs(94, 119).addBox(0.0F, 0.0F, -5.0F, 4.0F, 1.0F, 9.0F, 0.0F, true);

		SOUTH_WEST2 = new ModelRenderer(this);
		SOUTH_WEST2.setPos(0.0F, -30.0F, 0.0F);
		glow.addChild(SOUTH_WEST2);
		setRotationAngle(SOUTH_WEST2, 0.0F, -2.0944F, 0.0F);
		

		bone188 = new ModelRenderer(this);
		bone188.setPos(0.0F, -4.0F, -27.8F);
		SOUTH_WEST2.addChild(bone188);
		setRotationAngle(bone188, 0.48F, 0.0F, 0.0F);
		bone188.texOffs(136, 37).addBox(-10.0F, 1.274F, 3.0765F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bone188.texOffs(86, 81).addBox(-1.0F, 1.024F, 1.5765F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		bone188.texOffs(98, 42).addBox(1.0F, 1.024F, 9.0765F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone188.texOffs(9, 132).addBox(-1.5F, 0.024F, 9.0765F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		bone188.texOffs(98, 42).addBox(-2.0F, 1.024F, 9.0765F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone188.texOffs(16, 59).addBox(4.0F, 0.774F, 4.0765F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone188.texOffs(16, 59).addBox(-5.0F, 0.774F, 4.0765F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone188.texOffs(144, 61).addBox(-9.5F, 1.024F, 3.5765F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone188.texOffs(144, 61).addBox(-7.25F, 1.024F, 7.5765F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone188.texOffs(136, 37).addBox(-7.75F, 1.274F, 7.0765F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bone188.texOffs(144, 61).addBox(5.25F, 1.024F, 7.5765F, 2.0F, 1.0F, 2.0F, 0.0F, true);
		bone188.texOffs(136, 37).addBox(4.75F, 1.274F, 7.0765F, 3.0F, 1.0F, 3.0F, 0.0F, true);
		bone188.texOffs(144, 61).addBox(7.5F, 1.024F, 3.5765F, 2.0F, 1.0F, 2.0F, 0.0F, true);
		bone188.texOffs(136, 37).addBox(7.0F, 1.274F, 3.0765F, 3.0F, 1.0F, 3.0F, 0.0F, true);

		SOUTH2 = new ModelRenderer(this);
		SOUTH2.setPos(0.0F, -30.0F, 0.0F);
		glow.addChild(SOUTH2);
		setRotationAngle(SOUTH2, 0.0F, 3.1416F, 0.0F);
		

		bone191 = new ModelRenderer(this);
		bone191.setPos(0.0F, -4.0F, -27.8F);
		SOUTH2.addChild(bone191);
		setRotationAngle(bone191, 0.48F, 0.0F, 0.0F);
		bone191.texOffs(98, 61).addBox(-6.5F, 1.524F, 10.0765F, 13.0F, 1.0F, 3.0F, 0.0F, false);
		bone191.texOffs(32, 130).addBox(-5.0F, 0.274F, 10.5765F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone191.texOffs(32, 130).addBox(-1.0F, 0.274F, 10.5765F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone191.texOffs(32, 130).addBox(3.0F, 0.274F, 10.5765F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone191.texOffs(0, 140).addBox(-2.0F, 1.024F, 3.5765F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		bone191.texOffs(0, 140).addBox(1.0F, 1.024F, 3.5765F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		bone191.texOffs(46, 111).addBox(-9.0F, 1.024F, 0.0765F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		bone192 = new ModelRenderer(this);
		bone192.setPos(-7.5F, 1.274F, 1.5765F);
		bone191.addChild(bone192);
		setRotationAngle(bone192, 0.0F, -0.7854F, 0.0F);
		

		SOUTH_EAST2 = new ModelRenderer(this);
		SOUTH_EAST2.setPos(0.0F, -30.0F, 0.0F);
		glow.addChild(SOUTH_EAST2);
		setRotationAngle(SOUTH_EAST2, 0.0F, 2.0944F, 0.0F);
		

		bone193 = new ModelRenderer(this);
		bone193.setPos(0.0F, -4.0F, -27.8F);
		SOUTH_EAST2.addChild(bone193);
		setRotationAngle(bone193, 0.48F, 0.0F, 0.0F);
		bone193.texOffs(123, 37).addBox(-6.0F, 1.274F, 7.5765F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		bone193.texOffs(101, 94).addBox(2.0F, 0.524F, 7.5765F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone193.texOffs(45, 98).addBox(3.0F, 0.024F, 10.5765F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone193.texOffs(98, 47).addBox(-5.0F, 0.524F, 10.5765F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone193.texOffs(86, 94).addBox(-4.5F, 0.274F, 11.0765F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		bone193.texOffs(131, 86).addBox(5.0F, 1.024F, -0.4235F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		bone193.texOffs(131, 86).addBox(8.0F, 1.024F, -0.4235F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		bone193.texOffs(11, 138).addBox(0.5F, 1.024F, 0.5765F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		bone193.texOffs(131, 86).addBox(-6.0F, 1.024F, -0.4235F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		bone193.texOffs(131, 86).addBox(-9.0F, 1.024F, -0.4235F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		bone194 = new ModelRenderer(this);
		bone194.setPos(3.5F, 0.024F, 11.0765F);
		bone193.addChild(bone194);
		setRotationAngle(bone194, 0.6109F, 0.0F, 0.0F);
		

		bone195 = new ModelRenderer(this);
		bone195.setPos(2.5F, 0.524F, 7.8265F);
		bone193.addChild(bone195);
		setRotationAngle(bone195, 0.6109F, 0.0F, 0.0F);
		

		bone196 = new ModelRenderer(this);
		bone196.setPos(4.0F, 1.024F, 8.8265F);
		bone193.addChild(bone196);
		setRotationAngle(bone196, 0.7854F, 0.0F, 0.0F);
		

		bone197 = new ModelRenderer(this);
		bone197.setPos(-0.75F, 1.774F, 2.5765F);
		bone193.addChild(bone197);
		setRotationAngle(bone197, 0.0F, 0.0F, -0.7854F);
		

		NORTH_EAST2 = new ModelRenderer(this);
		NORTH_EAST2.setPos(0.0F, -30.0F, 0.0F);
		glow.addChild(NORTH_EAST2);
		setRotationAngle(NORTH_EAST2, 0.0F, 1.0472F, 0.0F);
		

		bone198 = new ModelRenderer(this);
		bone198.setPos(0.0F, -4.0F, -27.8F);
		NORTH_EAST2.addChild(bone198);
		setRotationAngle(bone198, 0.48F, 0.0F, 0.0F);
		bone198.texOffs(0, 98).addBox(8.5F, 0.774F, 1.0765F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone198.texOffs(86, 75).addBox(6.5F, 0.774F, 0.0765F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		bone198.texOffs(96, 116).addBox(3.5F, 0.524F, 11.5765F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bone198.texOffs(106, 0).addBox(-5.5F, 0.524F, 1.0765F, 11.0F, 1.0F, 8.0F, 0.0F, false);
		bone198.texOffs(45, 98).addBox(-1.0F, 0.024F, 11.5765F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone199 = new ModelRenderer(this);
		bone199.setPos(-8.5F, 0.774F, 3.0765F);
		bone198.addChild(bone199);
		setRotationAngle(bone199, 0.7854F, 0.0F, 0.0F);
		

		bone200 = new ModelRenderer(this);
		bone200.setPos(-3.5F, 1.524F, 10.8265F);
		bone198.addChild(bone200);
		setRotationAngle(bone200, 0.7854F, 0.0F, 0.0F);
		bone200.texOffs(12, 12).addBox(2.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		bone201 = new ModelRenderer(this);
		bone201.setPos(3.5F, 0.024F, 12.0765F);
		bone198.addChild(bone201);
		setRotationAngle(bone201, 0.6109F, 0.0F, 0.0F);
		

		bone202 = new ModelRenderer(this);
		bone202.setPos(0.0F, -44.5F, 0.0F);
		glow.addChild(bone202);
		bone202.texOffs(41, 68).addBox(-5.0F, 1.0F, -12.55F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		bone203 = new ModelRenderer(this);
		bone203.setPos(0.0F, 0.0F, 0.0F);
		bone202.addChild(bone203);
		setRotationAngle(bone203, 0.0F, -1.0472F, 0.0F);
		bone203.texOffs(41, 68).addBox(-5.0F, 1.0F, -12.55F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		bone204 = new ModelRenderer(this);
		bone204.setPos(0.0F, 0.0F, 0.0F);
		bone203.addChild(bone204);
		setRotationAngle(bone204, 0.0F, -1.0472F, 0.0F);
		bone204.texOffs(41, 68).addBox(-5.0F, 1.0F, -12.55F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		bone205 = new ModelRenderer(this);
		bone205.setPos(0.0F, 0.0F, 0.0F);
		bone204.addChild(bone205);
		setRotationAngle(bone205, 0.0F, -1.0472F, 0.0F);
		bone205.texOffs(41, 68).addBox(-5.0F, 1.0F, -12.55F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		bone206 = new ModelRenderer(this);
		bone206.setPos(0.0F, 0.0F, 0.0F);
		bone205.addChild(bone206);
		setRotationAngle(bone206, 0.0F, -1.0472F, 0.0F);
		bone206.texOffs(41, 68).addBox(-5.0F, 1.0F, -12.55F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		bone207 = new ModelRenderer(this);
		bone207.setPos(0.0F, 0.0F, 0.0F);
		bone206.addChild(bone207);
		setRotationAngle(bone207, 0.0F, -1.0472F, 0.0F);
		bone207.texOffs(41, 68).addBox(-5.0F, 1.0F, -12.55F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		NORTH = new ModelRenderer(this);
		NORTH.setPos(0.0F, -6.0F, 0.0F);
		

		bone136 = new ModelRenderer(this);
		bone136.setPos(0.0F, -4.0F, -27.8F);
		NORTH.addChild(bone136);
		setRotationAngle(bone136, 0.48F, 0.0F, 0.0F);
		bone136.texOffs(130, 108).addBox(4.0F, 1.274F, -0.9235F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		bone136.texOffs(130, 108).addBox(-10.0F, 1.274F, -0.9235F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		bone136.texOffs(41, 92).addBox(-6.0F, 1.274F, 3.0765F, 12.0F, 1.0F, 2.0F, 0.0F, false);
		bone136.texOffs(103, 111).addBox(-5.0F, 0.774F, 7.0765F, 10.0F, 1.0F, 6.0F, 0.0F, false);
		bone136.texOffs(81, 16).addBox(-3.5F, 0.274F, 10.5765F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		bone136.texOffs(45, 138).addBox(-3.0F, 0.774F, 8.5765F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		bone136.texOffs(145, 141).addBox(-0.5F, 0.524F, 8.0765F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bone136.texOffs(41, 84).addBox(-5.0F, 1.274F, 7.0765F, 10.0F, 1.0F, 6.0F, 0.0F, false);
		bone136.texOffs(81, 11).addBox(-3.0F, 1.274F, 0.0765F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		bone136.texOffs(117, 143).addBox(-9.0F, 1.274F, 3.0765F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		bone136.texOffs(8, 144).addBox(-8.0F, 1.274F, 6.0765F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone136.texOffs(117, 143).addBox(7.0F, 1.274F, 3.0765F, 2.0F, 1.0F, 3.0F, 0.0F, true);
		bone136.texOffs(8, 144).addBox(7.0F, 1.274F, 6.0765F, 1.0F, 1.0F, 3.0F, 0.0F, true);

		door_control = new ModelRenderer(this);
		door_control.setPos(0.0F, 4.0F, 29.8F);
		bone136.addChild(door_control);
		door_control.texOffs(96, 142).addBox(-2.5F, -4.476F, -28.7235F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		bone137 = new ModelRenderer(this);
		bone137.setPos(-9.0F, 0.524F, 0.0765F);
		bone136.addChild(bone137);
		setRotationAngle(bone137, 0.6109F, 0.0F, 0.0F);
		bone137.texOffs(67, 44).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone159 = new ModelRenderer(this);
		bone159.setPos(-6.25F, 0.524F, 0.0765F);
		bone136.addChild(bone159);
		setRotationAngle(bone159, 0.6109F, 0.0F, 0.0F);
		bone159.texOffs(67, 44).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone160 = new ModelRenderer(this);
		bone160.setPos(5.25F, 0.524F, 0.0765F);
		bone136.addChild(bone160);
		setRotationAngle(bone160, 0.6109F, 0.0F, 0.0F);
		bone160.texOffs(67, 44).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone161 = new ModelRenderer(this);
		bone161.setPos(8.0F, 0.524F, 0.0765F);
		bone136.addChild(bone161);
		setRotationAngle(bone161, 0.6109F, 0.0F, 0.0F);
		bone161.texOffs(67, 44).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone162 = new ModelRenderer(this);
		bone162.setPos(-7.75F, 1.274F, 6.0765F);
		bone136.addChild(bone162);
		setRotationAngle(bone162, 0.0F, 0.0F, 0.6109F);
		

		bone163 = new ModelRenderer(this);
		bone163.setPos(7.75F, 1.274F, 6.0765F);
		bone136.addChild(bone163);
		setRotationAngle(bone163, 0.0F, 0.0F, -0.6109F);
		

		bone164 = new ModelRenderer(this);
		bone164.setPos(-8.75F, 1.274F, 6.0765F);
		bone136.addChild(bone164);
		setRotationAngle(bone164, 0.0F, 0.0F, 0.6109F);
		

		bone165 = new ModelRenderer(this);
		bone165.setPos(8.75F, 1.274F, 6.0765F);
		bone136.addChild(bone165);
		setRotationAngle(bone165, 0.0F, 0.0F, -0.6109F);
		

		NORTH_WEST = new ModelRenderer(this);
		NORTH_WEST.setPos(0.0F, -6.0F, 0.0F);
		setRotationAngle(NORTH_WEST, 0.0F, -1.0472F, 0.0F);
		

		bone57 = new ModelRenderer(this);
		bone57.setPos(0.0F, -4.0F, -27.8F);
		NORTH_WEST.addChild(bone57);
		setRotationAngle(bone57, 0.48F, 0.0F, 0.0F);
		bone57.texOffs(0, 84).addBox(-7.0F, 1.024F, 0.0765F, 14.0F, 1.0F, 12.0F, 0.0F, false);
		bone57.texOffs(0, 12).addBox(8.0F, 0.524F, -0.9235F, 3.0F, 2.0F, 5.0F, 0.0F, false);
		bone57.texOffs(76, 102).addBox(3.0F, 1.024F, 0.0765F, 4.0F, 1.0F, 12.0F, 0.0F, false);
		bone57.texOffs(133, 101).addBox(-2.5F, -0.976F, 8.5765F, 5.0F, 2.0F, 3.0F, 0.0F, false);

		bone128 = new ModelRenderer(this);
		bone128.setPos(0.0F, 1.274F, 6.0765F);
		bone57.addChild(bone128);
		setRotationAngle(bone128, -0.9163F, 0.0F, 0.0F);
		bone128.texOffs(100, 94).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		bone128.texOffs(98, 42).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, 0.0F, false);
		bone128.texOffs(70, 138).addBox(4.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, 0.0F, false);
		bone128.texOffs(36, 138).addBox(-6.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, 0.0F, false);

		bone131 = new ModelRenderer(this);
		bone131.setPos(9.5F, 1.274F, 4.0765F);
		bone57.addChild(bone131);
		setRotationAngle(bone131, 0.7854F, 0.0F, 0.0F);
		bone131.texOffs(68, 84).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		bone129 = new ModelRenderer(this);
		bone129.setPos(-4.0F, 1.024F, 6.0765F);
		bone57.addChild(bone129);
		setRotationAngle(bone129, 0.0F, 0.0F, 0.3927F);
		

		bone130 = new ModelRenderer(this);
		bone130.setPos(4.0F, 1.024F, 6.0765F);
		bone57.addChild(bone130);
		setRotationAngle(bone130, 0.0F, 0.0F, -0.3927F);
		

		SOUTH_WEST = new ModelRenderer(this);
		SOUTH_WEST.setPos(0.0F, -6.0F, 0.0F);
		setRotationAngle(SOUTH_WEST, 0.0F, -2.0944F, 0.0F);
		

		bone133 = new ModelRenderer(this);
		bone133.setPos(0.0F, -4.0F, -27.8F);
		SOUTH_WEST.addChild(bone133);
		setRotationAngle(bone133, 0.48F, 0.0F, 0.0F);
		bone133.texOffs(0, 68).addBox(-9.0F, 1.524F, -0.9235F, 18.0F, 1.0F, 4.0F, 0.0F, false);
		bone133.texOffs(126, 42).addBox(-5.0F, 1.274F, 1.0765F, 10.0F, 1.0F, 4.0F, 0.0F, false);
		bone133.texOffs(145, 129).addBox(-4.0F, 0.274F, 1.5765F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone133.texOffs(137, 5).addBox(-3.0F, 1.524F, 6.0765F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		bone133.texOffs(116, 125).addBox(-4.5F, 1.024F, 8.0765F, 9.0F, 1.0F, 5.0F, 0.0F, false);
		bone133.texOffs(125, 94).addBox(-4.5F, 1.524F, 8.0765F, 9.0F, 1.0F, 5.0F, 0.0F, false);
		bone133.texOffs(134, 138).addBox(-1.5F, -0.976F, 9.0765F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bone133.texOffs(106, 143).addBox(-7.75F, 1.524F, 4.0765F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		bone133.texOffs(106, 143).addBox(5.75F, 1.524F, 4.0765F, 2.0F, 1.0F, 3.0F, 0.0F, true);
		bone133.texOffs(0, 44).addBox(-6.75F, -0.976F, 8.0765F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone133.texOffs(0, 44).addBox(5.75F, -0.976F, 8.0765F, 1.0F, 3.0F, 1.0F, 0.0F, true);

		bone134 = new ModelRenderer(this);
		bone134.setPos(0.0F, 1.524F, 5.0765F);
		bone133.addChild(bone134);
		setRotationAngle(bone134, 0.7854F, 0.0F, 0.0F);
		bone134.texOffs(111, 132).addBox(-2.5F, -0.5F, -2.0F, 5.0F, 2.0F, 3.0F, 0.0F, false);

		bone135 = new ModelRenderer(this);
		bone135.setPos(3.0F, 0.774F, 2.5765F);
		bone133.addChild(bone135);
		setRotationAngle(bone135, 0.0F, -0.829F, 0.0F);
		bone135.texOffs(145, 129).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		SOUTH = new ModelRenderer(this);
		SOUTH.setPos(0.0F, -6.0F, 0.0F);
		setRotationAngle(SOUTH, 0.0F, 3.1416F, 0.0F);
		

		bone167 = new ModelRenderer(this);
		bone167.setPos(0.0F, -4.0F, -27.8F);
		SOUTH.addChild(bone167);
		setRotationAngle(bone167, 0.48F, 0.0F, 0.0F);
		bone167.texOffs(121, 138).addBox(-1.5F, 1.024F, 10.0765F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bone167.texOffs(108, 138).addBox(-5.5F, 1.024F, 10.0765F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bone167.texOffs(108, 138).addBox(2.5F, 1.024F, 10.0765F, 3.0F, 1.0F, 3.0F, 0.0F, true);
		bone167.texOffs(41, 87).addBox(1.5F, 1.024F, 11.0765F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		bone167.texOffs(41, 87).addBox(-2.5F, 1.024F, 11.0765F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone167.texOffs(32, 130).addBox(-5.0F, 0.274F, 10.5765F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone167.texOffs(32, 130).addBox(-1.0F, 0.274F, 10.5765F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone167.texOffs(32, 130).addBox(3.0F, 0.274F, 10.5765F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone167.texOffs(81, 11).addBox(-3.0F, 1.274F, 3.0765F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		bone167.texOffs(0, 59).addBox(5.0F, 1.274F, -0.9235F, 5.0F, 1.0F, 5.0F, 0.0F, false);
		bone167.texOffs(137, 0).addBox(6.0F, 0.774F, 0.0765F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bone167.texOffs(0, 59).addBox(-10.0F, 1.274F, -0.9235F, 5.0F, 1.0F, 5.0F, 0.0F, false);
		bone167.texOffs(41, 84).addBox(-8.0F, 0.274F, 1.0765F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone167.texOffs(67, 62).addBox(-4.0F, 1.524F, 0.0765F, 8.0F, 1.0F, 2.0F, 0.0F, false);
		bone167.texOffs(41, 92).addBox(-6.0F, 1.274F, 6.0765F, 12.0F, 1.0F, 2.0F, 0.0F, false);

		XYZmod = new ModelRenderer(this);
		XYZmod.setPos(0.0F, 4.0F, 32.8F);
		bone167.addChild(XYZmod);
		XYZmod.texOffs(96, 142).addBox(-2.5F, -4.476F, -28.7235F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		randomiser = new ModelRenderer(this);
		randomiser.setPos(-7.5F, 1.274F, 1.5765F);
		bone167.addChild(randomiser);
		setRotationAngle(randomiser, 0.0F, -0.7854F, 0.0F);
		randomiser.texOffs(138, 10).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		land_type = new ModelRenderer(this);
		land_type.setPos(8.0F, 2.5F, 30.8F);
		bone167.addChild(land_type);
		land_type.texOffs(143, 69).addBox(-2.0F, -3.226F, -29.7235F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		land_type.texOffs(0, 12).addBox(-1.0F, -3.726F, -29.7235F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		SOUTH_EAST = new ModelRenderer(this);
		SOUTH_EAST.setPos(0.0F, -6.0F, 0.0F);
		setRotationAngle(SOUTH_EAST, 0.0F, 2.0944F, 0.0F);
		

		bone169 = new ModelRenderer(this);
		bone169.setPos(0.0F, -4.0F, -27.8F);
		SOUTH_EAST.addChild(bone169);
		setRotationAngle(bone169, 0.48F, 0.0F, 0.0F);
		bone169.texOffs(120, 81).addBox(-5.5F, 1.024F, 10.0765F, 11.0F, 1.0F, 3.0F, 0.0F, false);
		bone169.texOffs(140, 125).addBox(1.0F, 1.024F, 7.0765F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		bone169.texOffs(45, 71).addBox(-6.0F, 1.524F, 7.0765F, 6.0F, 1.0F, 2.0F, 0.0F, false);
		bone169.texOffs(52, 121).addBox(4.0F, 1.274F, -0.9235F, 6.0F, 1.0F, 7.0F, 0.0F, false);
		bone169.texOffs(135, 54).addBox(0.0F, 1.274F, 0.0765F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		bone169.texOffs(0, 59).addBox(0.5F, 0.024F, 2.5765F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone169.texOffs(67, 47).addBox(-1.5F, 0.774F, 7.5765F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone169.texOffs(140, 86).addBox(-2.0F, 1.274F, 0.5765F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		bone169.texOffs(0, 132).addBox(-3.5F, 1.274F, -0.4235F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		bone169.texOffs(0, 132).addBox(2.5F, 1.274F, -0.4235F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		bone169.texOffs(52, 121).addBox(-10.0F, 1.274F, -0.9235F, 6.0F, 1.0F, 7.0F, 0.0F, false);

		handbrake = new ModelRenderer(this);
		handbrake.setPos(-7.0F, 1.524F, 2.5765F);
		bone169.addChild(handbrake);
		setRotationAngle(handbrake, -1.309F, 0.0F, 0.0F);
		handbrake.texOffs(136, 113).addBox(-2.5F, -4.0F, -0.5F, 5.0F, 4.0F, 1.0F, 0.0F, false);

		throttle = new ModelRenderer(this);
		throttle.setPos(0.0F, 4.0F, 32.8F);
		bone169.addChild(throttle);
		throttle.texOffs(96, 142).addBox(4.5F, -4.476F, -32.7235F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		bone173 = new ModelRenderer(this);
		bone173.setPos(-0.75F, 1.774F, 2.5765F);
		bone169.addChild(bone173);
		setRotationAngle(bone173, 0.0F, 0.0F, -0.7854F);
		bone173.texOffs(128, 143).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone171 = new ModelRenderer(this);
		bone171.setPos(3.5F, 0.024F, 11.0765F);
		bone169.addChild(bone171);
		setRotationAngle(bone171, 0.6109F, 0.0F, 0.0F);
		bone171.texOffs(67, 44).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone172 = new ModelRenderer(this);
		bone172.setPos(2.5F, 0.524F, 7.8265F);
		bone169.addChild(bone172);
		setRotationAngle(bone172, 0.6109F, 0.0F, 0.0F);
		bone172.texOffs(67, 44).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone170 = new ModelRenderer(this);
		bone170.setPos(4.0F, 1.024F, 8.8265F);
		bone169.addChild(bone170);
		setRotationAngle(bone170, 0.7854F, 0.0F, 0.0F);
		bone170.texOffs(0, 103).addBox(-2.0F, -0.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		NORTH_EAST = new ModelRenderer(this);
		NORTH_EAST.setPos(0.0F, -6.0F, 0.0F);
		setRotationAngle(NORTH_EAST, 0.0F, 1.0472F, 0.0F);
		

		bone174 = new ModelRenderer(this);
		bone174.setPos(0.0F, -4.0F, -27.8F);
		NORTH_EAST.addChild(bone174);
		setRotationAngle(bone174, 0.48F, 0.0F, 0.0F);
		bone174.texOffs(0, 98).addBox(-6.5F, 1.024F, 0.0765F, 13.0F, 1.0F, 10.0F, 0.0F, false);
		bone174.texOffs(36, 130).addBox(-10.5F, 1.024F, -0.9235F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		bone174.texOffs(49, 141).addBox(-9.5F, 0.274F, 0.0765F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		bone174.texOffs(125, 61).addBox(4.5F, 1.024F, -0.9235F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		bone174.texOffs(67, 57).addBox(-5.5F, 0.774F, 11.0765F, 7.0F, 1.0F, 3.0F, 0.0F, false);
		bone174.texOffs(143, 119).addBox(-5.0F, 0.274F, 11.5765F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		bone174.texOffs(143, 15).addBox(3.0F, 0.774F, 11.0765F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		bone174.texOffs(45, 98).addBox(-1.0F, 0.024F, 11.5765F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone175 = new ModelRenderer(this);
		bone175.setPos(-8.5F, 0.774F, 3.0765F);
		bone174.addChild(bone175);
		setRotationAngle(bone175, 0.7854F, 0.0F, 0.0F);
		bone175.texOffs(0, 103).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone176 = new ModelRenderer(this);
		bone176.setPos(-3.5F, 1.524F, 10.8265F);
		bone174.addChild(bone176);
		setRotationAngle(bone176, 0.7854F, 0.0F, 0.0F);
		bone176.texOffs(0, 103).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone177 = new ModelRenderer(this);
		bone177.setPos(3.5F, 0.024F, 12.0765F);
		bone174.addChild(bone177);
		setRotationAngle(bone177, 0.6109F, 0.0F, 0.0F);
		bone177.texOffs(67, 44).addBox(-4.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		base_console.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rotor.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		glow.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		NORTH.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		NORTH_WEST.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		SOUTH_WEST.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		SOUTH.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		SOUTH_EAST.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		NORTH_EAST.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
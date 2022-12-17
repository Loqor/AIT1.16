package com.mdt.ait.client.models.consoles;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class HudolinConsole extends DevConsole {
	public final ModelRenderer bone208;
	public final ModelRenderer base_console;
	public final ModelRenderer rotor;
	public final ModelRenderer rotor_bottom;
	public final ModelRenderer bone176;
	public final ModelRenderer bone177;
	public final ModelRenderer bone178;
	public final ModelRenderer bone179;
	public final ModelRenderer bone180;
	public final ModelRenderer rotor_bottom2;
	public final ModelRenderer bone161;
	public final ModelRenderer bone162;
	public final ModelRenderer bone163;
	public final ModelRenderer bone164;
	public final ModelRenderer bone165;
	public final ModelRenderer rotor_bottom3;
	public final ModelRenderer bone166;
	public final ModelRenderer bone167;
	public final ModelRenderer bone168;
	public final ModelRenderer bone169;
	public final ModelRenderer bone170;
	public final ModelRenderer rotor_bottom4;
	public final ModelRenderer bone171;
	public final ModelRenderer bone172;
	public final ModelRenderer bone173;
	public final ModelRenderer bone174;
	public final ModelRenderer bone175;
	public final ModelRenderer plinth;
	public final ModelRenderer plinth_supports;
	public final ModelRenderer bone108;
	public final ModelRenderer bone109;
	public final ModelRenderer bone110;
	public final ModelRenderer bone111;
	public final ModelRenderer bone112;
	public final ModelRenderer bone113;
	public final ModelRenderer bone114;
	public final ModelRenderer bone115;
	public final ModelRenderer bone116;
	public final ModelRenderer bone117;
	public final ModelRenderer bone118;
	public final ModelRenderer plinth_supports2;
	public final ModelRenderer bone192;
	public final ModelRenderer bone194;
	public final ModelRenderer bone195;
	public final ModelRenderer bone196;
	public final ModelRenderer bone197;
	public final ModelRenderer bone;
	public final ModelRenderer bone2;
	public final ModelRenderer bone3;
	public final ModelRenderer bone4;
	public final ModelRenderer bone5;
	public final ModelRenderer bone6;
	public final ModelRenderer bone7;
	public final ModelRenderer bone8;
	public final ModelRenderer bone9;
	public final ModelRenderer bone10;
	public final ModelRenderer bone11;
	public final ModelRenderer bone12;
	public final ModelRenderer bone13;
	public final ModelRenderer bone14;
	public final ModelRenderer bone15;
	public final ModelRenderer bone16;
	public final ModelRenderer bone17;
	public final ModelRenderer bone18;
	public final ModelRenderer bone89;
	public final ModelRenderer bone90;
	public final ModelRenderer bone91;
	public final ModelRenderer bone92;
	public final ModelRenderer bone93;
	public final ModelRenderer bone94;
	public final ModelRenderer bone137;
	public final ModelRenderer bone138;
	public final ModelRenderer bone139;
	public final ModelRenderer bone140;
	public final ModelRenderer bone141;
	public final ModelRenderer bone142;
	public final ModelRenderer bone19;
	public final ModelRenderer bone20;
	public final ModelRenderer bone21;
	public final ModelRenderer bone22;
	public final ModelRenderer bone23;
	public final ModelRenderer bone24;
	public final ModelRenderer bone149;
	public final ModelRenderer bone150;
	public final ModelRenderer bone151;
	public final ModelRenderer bone152;
	public final ModelRenderer bone153;
	public final ModelRenderer bone154;
	public final ModelRenderer bone155;
	public final ModelRenderer bone156;
	public final ModelRenderer bone157;
	public final ModelRenderer bone158;
	public final ModelRenderer bone159;
	public final ModelRenderer bone160;
	public final ModelRenderer bone25;
	public final ModelRenderer bone26;
	public final ModelRenderer bone27;
	public final ModelRenderer bone28;
	public final ModelRenderer bone29;
	public final ModelRenderer bone30;
	public final ModelRenderer bone31;
	public final ModelRenderer bone32;
	public final ModelRenderer bone33;
	public final ModelRenderer bone34;
	public final ModelRenderer bone35;
	public final ModelRenderer bone36;
	public final ModelRenderer bone96;
	public final ModelRenderer bone97;
	public final ModelRenderer bone98;
	public final ModelRenderer bone99;
	public final ModelRenderer bone100;
	public final ModelRenderer bone101;
	public final ModelRenderer bone102;
	public final ModelRenderer bone103;
	public final ModelRenderer bone104;
	public final ModelRenderer bone105;
	public final ModelRenderer bone106;
	public final ModelRenderer bone107;
	public final ModelRenderer panels;
	public final ModelRenderer bone68;
	public final ModelRenderer bone69;
	public final ModelRenderer bone70;
	public final ModelRenderer bone52;
	public final ModelRenderer bone49;
	public final ModelRenderer bone50;
	public final ModelRenderer bone51;
	public final ModelRenderer bone53;
	public final ModelRenderer bone54;
	public final ModelRenderer bone55;
	public final ModelRenderer bone56;
	public final ModelRenderer bone57;
	public final ModelRenderer bone58;
	public final ModelRenderer bone59;
	public final ModelRenderer bone60;
	public final ModelRenderer bone61;
	public final ModelRenderer bone62;
	public final ModelRenderer bone63;
	public final ModelRenderer bone64;
	public final ModelRenderer bone65;
	public final ModelRenderer bone66;
	public final ModelRenderer bone67;
	public final ModelRenderer bone95;
	public final ModelRenderer bone209;
	public final ModelRenderer bone43;
	public final ModelRenderer bone71;
	public final ModelRenderer bone38;
	public final ModelRenderer bone72;
	public final ModelRenderer bone39;
	public final ModelRenderer bone40;
	public final ModelRenderer bone41;
	public final ModelRenderer bone42;
	public final ModelRenderer bone73;
	public final ModelRenderer bone74;
	public final ModelRenderer bone75;
	public final ModelRenderer bone76;
	public final ModelRenderer bone181;
	public final ModelRenderer bone182;
	public final ModelRenderer bone183;
	public final ModelRenderer bone193;
	public final ModelRenderer bone184;
	public final ModelRenderer bone185;
	public final ModelRenderer bone186;
	public final ModelRenderer bone187;
	public final ModelRenderer bone188;
	public final ModelRenderer bone189;
	public final ModelRenderer bone190;
	public final ModelRenderer bone191;
	public final ModelRenderer bone37;
	public final ModelRenderer bone44;
	public final ModelRenderer bone45;
	public final ModelRenderer bone46;
	public final ModelRenderer bone47;
	public final ModelRenderer bone48;
	public final ModelRenderer centre_pillar;
	public final ModelRenderer bone119;
	public final ModelRenderer bone120;
	public final ModelRenderer bone121;
	public final ModelRenderer bone122;
	public final ModelRenderer bone123;
	public final ModelRenderer bone124;
	public final ModelRenderer bone77;
	public final ModelRenderer bone78;
	public final ModelRenderer bone79;
	public final ModelRenderer bone80;
	public final ModelRenderer bone81;
	public final ModelRenderer bone82;
	public final ModelRenderer bone131;
	public final ModelRenderer bone132;
	public final ModelRenderer bone133;
	public final ModelRenderer bone134;
	public final ModelRenderer bone135;
	public final ModelRenderer bone136;
	public final ModelRenderer bone125;
	public final ModelRenderer bone126;
	public final ModelRenderer bone127;
	public final ModelRenderer bone128;
	public final ModelRenderer bone129;
	public final ModelRenderer bone130;
	public final ModelRenderer bone83;
	public final ModelRenderer bone84;
	public final ModelRenderer bone85;
	public final ModelRenderer bone86;
	public final ModelRenderer bone87;
	public final ModelRenderer bone88;
	public final ModelRenderer bone143;
	public final ModelRenderer bone144;
	public final ModelRenderer bone145;
	public final ModelRenderer bone146;
	public final ModelRenderer bone147;
	public final ModelRenderer bone148;
	public final ModelRenderer controls;
	public final ModelRenderer north;
	public final ModelRenderer bone198;
	public final ModelRenderer control;
	public final ModelRenderer bone202;
	public final ModelRenderer control2;
	public final ModelRenderer control3;
	public final ModelRenderer control4;
	public final ModelRenderer bone199;
	public final ModelRenderer bone200;
	public final ModelRenderer north_left;
	public final ModelRenderer bone210;
	public final ModelRenderer control5;
	public final ModelRenderer control6;
	public final ModelRenderer control7;
	public final ModelRenderer control8;
	public final ModelRenderer south;
	public final ModelRenderer bone214;
	public final ModelRenderer control_lever2;
	public final ModelRenderer control10;
	public final ModelRenderer control11;
	public final ModelRenderer control12;
	public final ModelRenderer south_right;
	public final ModelRenderer bone216;
	public final ModelRenderer bone221;
	public final ModelRenderer control_lever3;
	public final ModelRenderer control13;
	public final ModelRenderer control14;
	public final ModelRenderer bone217;
	public final ModelRenderer bone218;
	public final ModelRenderer bone219;
	public final ModelRenderer south_left;
	public final ModelRenderer bone211;
	public final ModelRenderer control_lever;
	public final ModelRenderer control9;
	public final ModelRenderer bone212;
	public final ModelRenderer north_right;
	public final ModelRenderer bone203;
	public final ModelRenderer bone201;
	public final ModelRenderer control15;
	public final ModelRenderer bone205;
	public final ModelRenderer bone206;
	public final ModelRenderer bone207;
	public final ModelRenderer control16;
	public final ModelRenderer control17;

	public HudolinConsole() {
		texWidth = 128;
		texHeight = 128;

		bone208 = new ModelRenderer(this);
		bone208.setPos(0.0F, 24.0F, 0.0F);
		

		base_console = new ModelRenderer(this);
		base_console.setPos(0.0F, 0.0F, 0.0F);
		bone208.addChild(base_console);
		

		rotor = new ModelRenderer(this);
		rotor.setPos(0.0F, -1.0F, 0.0F);
		base_console.addChild(rotor);
		

		rotor_bottom = new ModelRenderer(this);
		rotor_bottom.setPos(0.0F, -19.5F, 0.0F);
		rotor.addChild(rotor_bottom);
		rotor_bottom.texOffs(38, 67).addBox(-0.5F, -16.5F, 2.3484F, 1.0F, 12.0F, 2.0F, 0.0F, false);

		bone176 = new ModelRenderer(this);
		bone176.setPos(0.0F, 0.0F, 0.0F);
		rotor_bottom.addChild(bone176);
		setRotationAngle(bone176, 0.0F, -1.0472F, 0.0F);
		bone176.texOffs(39, 30).addBox(-0.5F, -13.5F, 2.3484F, 1.0F, 9.0F, 2.0F, 0.0F, false);

		bone177 = new ModelRenderer(this);
		bone177.setPos(0.0F, 0.0F, 0.0F);
		bone176.addChild(bone177);
		setRotationAngle(bone177, 0.0F, -1.0472F, 0.0F);
		bone177.texOffs(38, 67).addBox(-0.5F, -16.5F, 2.3484F, 1.0F, 12.0F, 2.0F, 0.0F, false);

		bone178 = new ModelRenderer(this);
		bone178.setPos(0.0F, 0.0F, 0.0F);
		bone177.addChild(bone178);
		setRotationAngle(bone178, 0.0F, -1.0472F, 0.0F);
		bone178.texOffs(39, 30).addBox(-0.5F, -13.5F, 2.3484F, 1.0F, 9.0F, 2.0F, 0.0F, false);

		bone179 = new ModelRenderer(this);
		bone179.setPos(0.0F, 0.0F, 0.0F);
		bone178.addChild(bone179);
		setRotationAngle(bone179, 0.0F, -1.0472F, 0.0F);
		bone179.texOffs(38, 67).addBox(-0.5F, -16.5F, 2.3484F, 1.0F, 12.0F, 2.0F, 0.0F, false);

		bone180 = new ModelRenderer(this);
		bone180.setPos(0.0F, 0.0F, 0.0F);
		bone179.addChild(bone180);
		setRotationAngle(bone180, 0.0F, -1.0472F, 0.0F);
		bone180.texOffs(39, 30).addBox(-0.5F, -13.5F, 2.3484F, 1.0F, 9.0F, 2.0F, 0.0F, false);

		rotor_bottom2 = new ModelRenderer(this);
		rotor_bottom2.setPos(0.0F, -32.5F, 0.0F);
		rotor.addChild(rotor_bottom2);
		rotor_bottom2.texOffs(28, 42).addBox(-0.5F, -16.5F, 2.3484F, 1.0F, 12.0F, 2.0F, 0.0F, false);

		bone161 = new ModelRenderer(this);
		bone161.setPos(0.0F, 0.0F, 0.0F);
		rotor_bottom2.addChild(bone161);
		setRotationAngle(bone161, 0.0F, -1.0472F, 0.0F);
		bone161.texOffs(0, 30).addBox(-0.5F, -16.5F, 2.3484F, 1.0F, 9.0F, 2.0F, 0.0F, false);

		bone162 = new ModelRenderer(this);
		bone162.setPos(0.0F, 0.0F, 0.0F);
		bone161.addChild(bone162);
		setRotationAngle(bone162, 0.0F, -1.0472F, 0.0F);
		bone162.texOffs(28, 42).addBox(-0.5F, -16.5F, 2.3484F, 1.0F, 12.0F, 2.0F, 0.0F, false);

		bone163 = new ModelRenderer(this);
		bone163.setPos(0.0F, 0.0F, 0.0F);
		bone162.addChild(bone163);
		setRotationAngle(bone163, 0.0F, -1.0472F, 0.0F);
		bone163.texOffs(0, 30).addBox(-0.5F, -16.5F, 2.3484F, 1.0F, 9.0F, 2.0F, 0.0F, false);

		bone164 = new ModelRenderer(this);
		bone164.setPos(0.0F, 0.0F, 0.0F);
		bone163.addChild(bone164);
		setRotationAngle(bone164, 0.0F, -1.0472F, 0.0F);
		bone164.texOffs(28, 42).addBox(-0.5F, -16.5F, 2.3484F, 1.0F, 12.0F, 2.0F, 0.0F, false);

		bone165 = new ModelRenderer(this);
		bone165.setPos(0.0F, 0.0F, 0.0F);
		bone164.addChild(bone165);
		setRotationAngle(bone165, 0.0F, -1.0472F, 0.0F);
		bone165.texOffs(0, 30).addBox(-0.5F, -16.5F, 2.3484F, 1.0F, 9.0F, 2.0F, 0.0F, false);

		rotor_bottom3 = new ModelRenderer(this);
		rotor_bottom3.setPos(0.0F, -38.5F, 0.0F);
		rotor.addChild(rotor_bottom3);
		setRotationAngle(rotor_bottom3, 0.0F, -0.5236F, 0.0F);
		rotor_bottom3.texOffs(0, 74).addBox(-1.5F, -4.5F, 2.7234F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		bone166 = new ModelRenderer(this);
		bone166.setPos(0.0F, 0.0F, 0.0F);
		rotor_bottom3.addChild(bone166);
		setRotationAngle(bone166, 0.0F, -1.0472F, 0.0F);
		bone166.texOffs(0, 74).addBox(-1.5F, -4.5F, 2.7234F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		bone167 = new ModelRenderer(this);
		bone167.setPos(0.0F, 0.0F, 0.0F);
		bone166.addChild(bone167);
		setRotationAngle(bone167, 0.0F, -1.0472F, 0.0F);
		bone167.texOffs(0, 74).addBox(-1.5F, -4.5F, 2.7234F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		bone168 = new ModelRenderer(this);
		bone168.setPos(0.0F, 0.0F, 0.0F);
		bone167.addChild(bone168);
		setRotationAngle(bone168, 0.0F, -1.0472F, 0.0F);
		bone168.texOffs(0, 74).addBox(-1.5F, -4.5F, 2.7234F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		bone169 = new ModelRenderer(this);
		bone169.setPos(0.0F, 0.0F, 0.0F);
		bone168.addChild(bone169);
		setRotationAngle(bone169, 0.0F, -1.0472F, 0.0F);
		bone169.texOffs(0, 74).addBox(-1.5F, -4.5F, 2.7234F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		bone170 = new ModelRenderer(this);
		bone170.setPos(0.0F, 0.0F, 0.0F);
		bone169.addChild(bone170);
		setRotationAngle(bone170, 0.0F, -1.0472F, 0.0F);
		bone170.texOffs(0, 74).addBox(-1.5F, -4.5F, 2.7234F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		rotor_bottom4 = new ModelRenderer(this);
		rotor_bottom4.setPos(0.0F, -26.5F, 0.0F);
		rotor.addChild(rotor_bottom4);
		setRotationAngle(rotor_bottom4, 0.0F, -0.5236F, 0.0F);
		rotor_bottom4.texOffs(0, 74).addBox(-1.5F, -4.5F, 2.7234F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		bone171 = new ModelRenderer(this);
		bone171.setPos(0.0F, 0.0F, 0.0F);
		rotor_bottom4.addChild(bone171);
		setRotationAngle(bone171, 0.0F, -1.0472F, 0.0F);
		bone171.texOffs(0, 74).addBox(-1.5F, -4.5F, 2.7234F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		bone172 = new ModelRenderer(this);
		bone172.setPos(0.0F, 0.0F, 0.0F);
		bone171.addChild(bone172);
		setRotationAngle(bone172, 0.0F, -1.0472F, 0.0F);
		bone172.texOffs(0, 74).addBox(-1.5F, -4.5F, 2.7234F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		bone173 = new ModelRenderer(this);
		bone173.setPos(0.0F, 0.0F, 0.0F);
		bone172.addChild(bone173);
		setRotationAngle(bone173, 0.0F, -1.0472F, 0.0F);
		bone173.texOffs(0, 74).addBox(-1.5F, -4.5F, 2.7234F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		bone174 = new ModelRenderer(this);
		bone174.setPos(0.0F, 0.0F, 0.0F);
		bone173.addChild(bone174);
		setRotationAngle(bone174, 0.0F, -1.0472F, 0.0F);
		bone174.texOffs(0, 74).addBox(-1.5F, -4.5F, 2.7234F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		bone175 = new ModelRenderer(this);
		bone175.setPos(0.0F, 0.0F, 0.0F);
		bone174.addChild(bone175);
		setRotationAngle(bone175, 0.0F, -1.0472F, 0.0F);
		bone175.texOffs(0, 74).addBox(-1.5F, -4.5F, 2.7234F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		plinth = new ModelRenderer(this);
		plinth.setPos(0.0F, 0.0F, 0.0F);
		base_console.addChild(plinth);
		

		plinth_supports = new ModelRenderer(this);
		plinth_supports.setPos(0.0F, -4.5F, 0.0F);
		plinth.addChild(plinth_supports);
		setRotationAngle(plinth_supports, 0.0F, -0.5236F, 0.0F);
		

		bone108 = new ModelRenderer(this);
		bone108.setPos(0.0F, -2.25F, 5.863F);
		plinth_supports.addChild(bone108);
		setRotationAngle(bone108, 0.6981F, 0.0F, 0.0F);
		bone108.texOffs(38, 30).addBox(-0.499F, -3.0F, -0.5F, 1.0F, 3.0F, 12.0F, 0.025F, false);

		bone109 = new ModelRenderer(this);
		bone109.setPos(0.0F, 0.0F, 0.0F);
		plinth_supports.addChild(bone109);
		setRotationAngle(bone109, 0.0F, -1.0472F, 0.0F);
		

		bone110 = new ModelRenderer(this);
		bone110.setPos(0.0F, -2.25F, 5.863F);
		bone109.addChild(bone110);
		setRotationAngle(bone110, 0.6981F, 0.0F, 0.0F);
		bone110.texOffs(38, 30).addBox(-0.499F, -3.0F, -0.5F, 1.0F, 3.0F, 12.0F, 0.025F, false);

		bone111 = new ModelRenderer(this);
		bone111.setPos(0.0F, 0.0F, 0.0F);
		bone109.addChild(bone111);
		setRotationAngle(bone111, 0.0F, -1.0472F, 0.0F);
		

		bone112 = new ModelRenderer(this);
		bone112.setPos(0.0F, -2.25F, 5.863F);
		bone111.addChild(bone112);
		setRotationAngle(bone112, 0.6981F, 0.0F, 0.0F);
		bone112.texOffs(38, 30).addBox(-0.499F, -3.0F, -0.5F, 1.0F, 3.0F, 12.0F, 0.025F, false);

		bone113 = new ModelRenderer(this);
		bone113.setPos(0.0F, 0.0F, 0.0F);
		bone111.addChild(bone113);
		setRotationAngle(bone113, 0.0F, -1.0472F, 0.0F);
		

		bone114 = new ModelRenderer(this);
		bone114.setPos(0.0F, -2.25F, 5.863F);
		bone113.addChild(bone114);
		setRotationAngle(bone114, 0.6981F, 0.0F, 0.0F);
		bone114.texOffs(38, 30).addBox(-0.499F, -3.0F, -0.5F, 1.0F, 3.0F, 12.0F, 0.025F, false);

		bone115 = new ModelRenderer(this);
		bone115.setPos(0.0F, 0.0F, 0.0F);
		bone113.addChild(bone115);
		setRotationAngle(bone115, 0.0F, -1.0472F, 0.0F);
		

		bone116 = new ModelRenderer(this);
		bone116.setPos(0.0F, -2.25F, 5.863F);
		bone115.addChild(bone116);
		setRotationAngle(bone116, 0.6981F, 0.0F, 0.0F);
		bone116.texOffs(38, 30).addBox(-0.499F, -3.0F, -0.5F, 1.0F, 3.0F, 12.0F, 0.025F, false);

		bone117 = new ModelRenderer(this);
		bone117.setPos(0.0F, 0.0F, 0.0F);
		bone115.addChild(bone117);
		setRotationAngle(bone117, 0.0F, -1.0472F, 0.0F);
		

		bone118 = new ModelRenderer(this);
		bone118.setPos(0.0F, -2.25F, 5.863F);
		bone117.addChild(bone118);
		setRotationAngle(bone118, 0.6981F, 0.0F, 0.0F);
		bone118.texOffs(38, 30).addBox(-0.499F, -3.0F, -0.5F, 1.0F, 3.0F, 12.0F, 0.025F, false);

		plinth_supports2 = new ModelRenderer(this);
		plinth_supports2.setPos(0.0F, -5.25F, 0.0F);
		plinth.addChild(plinth_supports2);
		setRotationAngle(plinth_supports2, 0.0F, -0.5236F, 0.0F);
		

		bone192 = new ModelRenderer(this);
		bone192.setPos(0.0F, 0.0F, 5.863F);
		plinth_supports2.addChild(bone192);
		setRotationAngle(bone192, -0.7854F, 0.0F, 0.0F);
		bone192.texOffs(7, 15).addBox(-0.499F, -3.0F, 4.5F, 1.0F, 3.0F, 2.0F, 0.025F, false);
		bone192.texOffs(62, 50).addBox(-0.499F, 0.0F, -0.5F, 1.0F, 1.0F, 7.0F, 0.025F, false);

		bone194 = new ModelRenderer(this);
		bone194.setPos(0.0F, 0.0F, 0.0F);
		plinth_supports2.addChild(bone194);
		setRotationAngle(bone194, 0.0F, -2.0944F, 0.0F);
		

		bone195 = new ModelRenderer(this);
		bone195.setPos(0.0F, 0.0F, 5.863F);
		bone194.addChild(bone195);
		setRotationAngle(bone195, -0.7854F, 0.0F, 0.0F);
		bone195.texOffs(7, 15).addBox(-0.499F, -3.0F, 4.5F, 1.0F, 3.0F, 2.0F, 0.025F, false);
		bone195.texOffs(62, 50).addBox(-0.499F, 0.0F, -0.5F, 1.0F, 1.0F, 7.0F, 0.025F, false);

		bone196 = new ModelRenderer(this);
		bone196.setPos(0.0F, 0.0F, 0.0F);
		bone194.addChild(bone196);
		setRotationAngle(bone196, 0.0F, -2.0944F, 0.0F);
		

		bone197 = new ModelRenderer(this);
		bone197.setPos(0.0F, 0.0F, 5.863F);
		bone196.addChild(bone197);
		setRotationAngle(bone197, -0.7854F, 0.0F, 0.0F);
		bone197.texOffs(7, 15).addBox(-0.499F, -3.0F, 4.5F, 1.0F, 3.0F, 2.0F, 0.025F, false);
		bone197.texOffs(62, 50).addBox(-0.499F, 0.0F, -0.5F, 1.0F, 1.0F, 7.0F, 0.025F, false);

		bone = new ModelRenderer(this);
		bone.setPos(0.0F, 0.0F, 0.0F);
		plinth.addChild(bone);
		bone.texOffs(52, 30).addBox(-3.5F, -1.0F, 0.06F, 7.0F, 1.0F, 7.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setPos(0.0F, 0.0F, 0.0F);
		bone.addChild(bone2);
		setRotationAngle(bone2, 0.0F, -1.0472F, 0.0F);
		bone2.texOffs(52, 30).addBox(-3.5F, -1.0F, 0.06F, 7.0F, 1.0F, 7.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setPos(0.0F, 0.0F, 0.0F);
		bone2.addChild(bone3);
		setRotationAngle(bone3, 0.0F, -1.0472F, 0.0F);
		bone3.texOffs(52, 30).addBox(-3.5F, -1.0F, 0.06F, 7.0F, 1.0F, 7.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setPos(0.0F, 0.0F, 0.0F);
		bone3.addChild(bone4);
		setRotationAngle(bone4, 0.0F, -1.0472F, 0.0F);
		bone4.texOffs(52, 30).addBox(-3.5F, -1.0F, 0.06F, 7.0F, 1.0F, 7.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setPos(0.0F, 0.0F, 0.0F);
		bone4.addChild(bone5);
		setRotationAngle(bone5, 0.0F, -1.0472F, 0.0F);
		bone5.texOffs(52, 30).addBox(-3.5F, -1.0F, 0.06F, 7.0F, 1.0F, 7.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setPos(0.0F, 0.0F, 0.0F);
		bone5.addChild(bone6);
		setRotationAngle(bone6, 0.0F, -1.0472F, 0.0F);
		bone6.texOffs(52, 30).addBox(-3.5F, -1.0F, 0.06F, 7.0F, 1.0F, 7.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setPos(0.0F, 0.0F, 0.0F);
		plinth.addChild(bone7);
		setRotationAngle(bone7, 0.0F, -0.5236F, 0.0F);
		bone7.texOffs(0, 56).addBox(-0.5F, -1.0F, 6.863F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setPos(0.0F, 0.0F, 0.0F);
		bone7.addChild(bone8);
		setRotationAngle(bone8, 0.0F, -1.0472F, 0.0F);
		bone8.texOffs(0, 56).addBox(-0.5F, -1.0F, 6.863F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setPos(0.0F, 0.0F, 0.0F);
		bone8.addChild(bone9);
		setRotationAngle(bone9, 0.0F, -1.0472F, 0.0F);
		bone9.texOffs(0, 56).addBox(-0.5F, -1.0F, 6.863F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setPos(0.0F, 0.0F, 0.0F);
		bone9.addChild(bone10);
		setRotationAngle(bone10, 0.0F, -1.0472F, 0.0F);
		bone10.texOffs(0, 56).addBox(-0.5F, -1.0F, 6.863F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setPos(0.0F, 0.0F, 0.0F);
		bone10.addChild(bone11);
		setRotationAngle(bone11, 0.0F, -1.0472F, 0.0F);
		bone11.texOffs(0, 56).addBox(-0.5F, -1.0F, 6.863F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setPos(0.0F, 0.0F, 0.0F);
		bone11.addChild(bone12);
		setRotationAngle(bone12, 0.0F, -1.0472F, 0.0F);
		bone12.texOffs(0, 56).addBox(-0.5F, -1.0F, 6.863F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setPos(0.0F, -1.0F, 0.0F);
		plinth.addChild(bone13);
		bone13.texOffs(49, 15).addBox(-3.0F, -3.0F, -0.815F, 6.0F, 3.0F, 7.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setPos(0.0F, 0.0F, 0.0F);
		bone13.addChild(bone14);
		setRotationAngle(bone14, 0.0F, -1.0472F, 0.0F);
		bone14.texOffs(49, 15).addBox(-3.0F, -3.0F, -0.815F, 6.0F, 3.0F, 7.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setPos(0.0F, 0.0F, 0.0F);
		bone14.addChild(bone15);
		setRotationAngle(bone15, 0.0F, -1.0472F, 0.0F);
		bone15.texOffs(49, 15).addBox(-3.0F, -3.0F, -0.815F, 6.0F, 3.0F, 7.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setPos(0.0F, 0.0F, 0.0F);
		bone15.addChild(bone16);
		setRotationAngle(bone16, 0.0F, -1.0472F, 0.0F);
		bone16.texOffs(49, 15).addBox(-3.0F, -3.0F, -0.815F, 6.0F, 3.0F, 7.0F, 0.0F, false);

		bone17 = new ModelRenderer(this);
		bone17.setPos(0.0F, 0.0F, 0.0F);
		bone16.addChild(bone17);
		setRotationAngle(bone17, 0.0F, -1.0472F, 0.0F);
		bone17.texOffs(49, 15).addBox(-3.0F, -3.0F, -0.815F, 6.0F, 3.0F, 7.0F, 0.0F, false);

		bone18 = new ModelRenderer(this);
		bone18.setPos(0.0F, 0.0F, 0.0F);
		bone17.addChild(bone18);
		setRotationAngle(bone18, 0.0F, -1.0472F, 0.0F);
		bone18.texOffs(49, 15).addBox(-3.0F, -3.0F, -0.815F, 6.0F, 3.0F, 7.0F, 0.0F, false);

		bone89 = new ModelRenderer(this);
		bone89.setPos(0.0F, -54.0F, 0.0F);
		plinth.addChild(bone89);
		bone89.texOffs(0, 42).addBox(-3.0F, -10.0F, -0.815F, 6.0F, 7.0F, 7.0F, 0.0F, false);

		bone90 = new ModelRenderer(this);
		bone90.setPos(0.0F, 0.0F, 0.0F);
		bone89.addChild(bone90);
		setRotationAngle(bone90, 0.0F, -1.0472F, 0.0F);
		bone90.texOffs(0, 42).addBox(-3.0F, -10.0F, -0.815F, 6.0F, 7.0F, 7.0F, 0.0F, false);

		bone91 = new ModelRenderer(this);
		bone91.setPos(0.0F, 0.0F, 0.0F);
		bone90.addChild(bone91);
		setRotationAngle(bone91, 0.0F, -1.0472F, 0.0F);
		bone91.texOffs(0, 42).addBox(-3.0F, -10.0F, -0.815F, 6.0F, 7.0F, 7.0F, 0.0F, false);

		bone92 = new ModelRenderer(this);
		bone92.setPos(0.0F, 0.0F, 0.0F);
		bone91.addChild(bone92);
		setRotationAngle(bone92, 0.0F, -1.0472F, 0.0F);
		bone92.texOffs(0, 42).addBox(-3.0F, -10.0F, -0.815F, 6.0F, 7.0F, 7.0F, 0.0F, false);

		bone93 = new ModelRenderer(this);
		bone93.setPos(0.0F, 0.0F, 0.0F);
		bone92.addChild(bone93);
		setRotationAngle(bone93, 0.0F, -1.0472F, 0.0F);
		bone93.texOffs(0, 42).addBox(-3.0F, -10.0F, -0.815F, 6.0F, 7.0F, 7.0F, 0.0F, false);

		bone94 = new ModelRenderer(this);
		bone94.setPos(0.0F, 0.0F, 0.0F);
		bone93.addChild(bone94);
		setRotationAngle(bone94, 0.0F, -1.0472F, 0.0F);
		bone94.texOffs(0, 42).addBox(-3.0F, -10.0F, -0.815F, 6.0F, 7.0F, 7.0F, 0.0F, false);

		bone137 = new ModelRenderer(this);
		bone137.setPos(0.0F, -49.0F, 0.0F);
		plinth.addChild(bone137);
		bone137.texOffs(57, 38).addBox(-3.0F, -5.0F, -0.815F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone138 = new ModelRenderer(this);
		bone138.setPos(0.0F, 0.0F, 0.0F);
		bone137.addChild(bone138);
		setRotationAngle(bone138, 0.0F, -1.0472F, 0.0F);
		bone138.texOffs(57, 38).addBox(-3.0F, -5.0F, -0.815F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone139 = new ModelRenderer(this);
		bone139.setPos(0.0F, 0.0F, 0.0F);
		bone138.addChild(bone139);
		setRotationAngle(bone139, 0.0F, -1.0472F, 0.0F);
		bone139.texOffs(57, 38).addBox(-3.0F, -5.0F, -0.815F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone140 = new ModelRenderer(this);
		bone140.setPos(0.0F, 0.0F, 0.0F);
		bone139.addChild(bone140);
		setRotationAngle(bone140, 0.0F, -1.0472F, 0.0F);
		bone140.texOffs(57, 38).addBox(-3.0F, -5.0F, -0.815F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone141 = new ModelRenderer(this);
		bone141.setPos(0.0F, 0.0F, 0.0F);
		bone140.addChild(bone141);
		setRotationAngle(bone141, 0.0F, -1.0472F, 0.0F);
		bone141.texOffs(57, 38).addBox(-3.0F, -5.0F, -0.815F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone142 = new ModelRenderer(this);
		bone142.setPos(0.0F, 0.0F, 0.0F);
		bone141.addChild(bone142);
		setRotationAngle(bone142, 0.0F, -1.0472F, 0.0F);
		bone142.texOffs(57, 38).addBox(-3.0F, -5.0F, -0.815F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone19 = new ModelRenderer(this);
		bone19.setPos(0.0F, -1.0F, 0.0F);
		plinth.addChild(bone19);
		setRotationAngle(bone19, 0.0F, -0.5236F, 0.0F);
		bone19.texOffs(0, 15).addBox(-0.5F, -3.0F, 5.863F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone20 = new ModelRenderer(this);
		bone20.setPos(0.0F, 0.0F, 0.0F);
		bone19.addChild(bone20);
		setRotationAngle(bone20, 0.0F, -1.0472F, 0.0F);
		bone20.texOffs(0, 15).addBox(-0.5F, -3.0F, 5.863F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone21 = new ModelRenderer(this);
		bone21.setPos(0.0F, 0.0F, 0.0F);
		bone20.addChild(bone21);
		setRotationAngle(bone21, 0.0F, -1.0472F, 0.0F);
		bone21.texOffs(0, 15).addBox(-0.5F, -3.0F, 5.863F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone22 = new ModelRenderer(this);
		bone22.setPos(0.0F, 0.0F, 0.0F);
		bone21.addChild(bone22);
		setRotationAngle(bone22, 0.0F, -1.0472F, 0.0F);
		bone22.texOffs(0, 15).addBox(-0.5F, -3.0F, 5.863F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone23 = new ModelRenderer(this);
		bone23.setPos(0.0F, 0.0F, 0.0F);
		bone22.addChild(bone23);
		setRotationAngle(bone23, 0.0F, -1.0472F, 0.0F);
		bone23.texOffs(0, 15).addBox(-0.5F, -3.0F, 5.863F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone24 = new ModelRenderer(this);
		bone24.setPos(0.0F, 0.0F, 0.0F);
		bone23.addChild(bone24);
		setRotationAngle(bone24, 0.0F, -1.0472F, 0.0F);
		bone24.texOffs(0, 15).addBox(-0.5F, -3.0F, 5.863F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone149 = new ModelRenderer(this);
		bone149.setPos(0.0F, -52.0F, 0.0F);
		plinth.addChild(bone149);
		setRotationAngle(bone149, 0.0F, -0.5236F, 0.0F);
		bone149.texOffs(49, 18).addBox(-0.5F, -2.0F, 5.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone150 = new ModelRenderer(this);
		bone150.setPos(0.0F, 0.0F, 0.0F);
		bone149.addChild(bone150);
		setRotationAngle(bone150, 0.0F, -1.0472F, 0.0F);
		bone150.texOffs(49, 18).addBox(-0.5F, -2.0F, 5.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone151 = new ModelRenderer(this);
		bone151.setPos(0.0F, 0.0F, 0.0F);
		bone150.addChild(bone151);
		setRotationAngle(bone151, 0.0F, -1.0472F, 0.0F);
		bone151.texOffs(49, 18).addBox(-0.5F, -2.0F, 5.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone152 = new ModelRenderer(this);
		bone152.setPos(0.0F, 0.0F, 0.0F);
		bone151.addChild(bone152);
		setRotationAngle(bone152, 0.0F, -1.0472F, 0.0F);
		bone152.texOffs(49, 18).addBox(-0.5F, -2.0F, 5.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone153 = new ModelRenderer(this);
		bone153.setPos(0.0F, 0.0F, 0.0F);
		bone152.addChild(bone153);
		setRotationAngle(bone153, 0.0F, -1.0472F, 0.0F);
		bone153.texOffs(49, 18).addBox(-0.5F, -2.0F, 5.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone154 = new ModelRenderer(this);
		bone154.setPos(0.0F, 0.0F, 0.0F);
		bone153.addChild(bone154);
		setRotationAngle(bone154, 0.0F, -1.0472F, 0.0F);
		bone154.texOffs(49, 18).addBox(-0.5F, -2.0F, 5.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone155 = new ModelRenderer(this);
		bone155.setPos(0.0F, -57.0F, 0.0F);
		plinth.addChild(bone155);
		setRotationAngle(bone155, 0.0F, -0.5236F, 0.0F);
		bone155.texOffs(45, 30).addBox(-0.5F, -7.0F, 5.863F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		bone156 = new ModelRenderer(this);
		bone156.setPos(0.0F, 0.0F, 0.0F);
		bone155.addChild(bone156);
		setRotationAngle(bone156, 0.0F, -1.0472F, 0.0F);
		bone156.texOffs(45, 30).addBox(-0.5F, -7.0F, 5.863F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		bone157 = new ModelRenderer(this);
		bone157.setPos(0.0F, 0.0F, 0.0F);
		bone156.addChild(bone157);
		setRotationAngle(bone157, 0.0F, -1.0472F, 0.0F);
		bone157.texOffs(45, 30).addBox(-0.5F, -7.0F, 5.863F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		bone158 = new ModelRenderer(this);
		bone158.setPos(0.0F, 0.0F, 0.0F);
		bone157.addChild(bone158);
		setRotationAngle(bone158, 0.0F, -1.0472F, 0.0F);
		bone158.texOffs(45, 30).addBox(-0.5F, -7.0F, 5.863F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		bone159 = new ModelRenderer(this);
		bone159.setPos(0.0F, 0.0F, 0.0F);
		bone158.addChild(bone159);
		setRotationAngle(bone159, 0.0F, -1.0472F, 0.0F);
		bone159.texOffs(45, 30).addBox(-0.5F, -7.0F, 5.863F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		bone160 = new ModelRenderer(this);
		bone160.setPos(0.0F, 0.0F, 0.0F);
		bone159.addChild(bone160);
		setRotationAngle(bone160, 0.0F, -1.0472F, 0.0F);
		bone160.texOffs(45, 30).addBox(-0.5F, -7.0F, 5.863F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		bone25 = new ModelRenderer(this);
		bone25.setPos(0.0F, -4.0F, 0.0F);
		plinth.addChild(bone25);
		setRotationAngle(bone25, 0.0F, -0.5236F, 0.0F);
		bone25.texOffs(34, 43).addBox(-0.5F, -8.0F, 3.863F, 1.0F, 8.0F, 2.0F, 0.0F, false);

		bone26 = new ModelRenderer(this);
		bone26.setPos(0.0F, 0.0F, 0.0F);
		bone25.addChild(bone26);
		setRotationAngle(bone26, 0.0F, -1.0472F, 0.0F);
		bone26.texOffs(34, 43).addBox(-0.5F, -8.0F, 3.863F, 1.0F, 8.0F, 2.0F, 0.0F, false);

		bone27 = new ModelRenderer(this);
		bone27.setPos(0.0F, 0.0F, 0.0F);
		bone26.addChild(bone27);
		setRotationAngle(bone27, 0.0F, -1.0472F, 0.0F);
		bone27.texOffs(34, 43).addBox(-0.5F, -8.0F, 3.863F, 1.0F, 8.0F, 2.0F, 0.0F, false);

		bone28 = new ModelRenderer(this);
		bone28.setPos(0.0F, 0.0F, 0.0F);
		bone27.addChild(bone28);
		setRotationAngle(bone28, 0.0F, -1.0472F, 0.0F);
		bone28.texOffs(34, 43).addBox(-0.5F, -8.0F, 3.863F, 1.0F, 8.0F, 2.0F, 0.0F, false);

		bone29 = new ModelRenderer(this);
		bone29.setPos(0.0F, 0.0F, 0.0F);
		bone28.addChild(bone29);
		setRotationAngle(bone29, 0.0F, -1.0472F, 0.0F);
		bone29.texOffs(34, 43).addBox(-0.5F, -8.0F, 3.863F, 1.0F, 8.0F, 2.0F, 0.0F, false);

		bone30 = new ModelRenderer(this);
		bone30.setPos(0.0F, 0.0F, 0.0F);
		bone29.addChild(bone30);
		setRotationAngle(bone30, 0.0F, -1.0472F, 0.0F);
		bone30.texOffs(34, 43).addBox(-0.5F, -8.0F, 3.863F, 1.0F, 8.0F, 2.0F, 0.0F, false);

		bone31 = new ModelRenderer(this);
		bone31.setPos(0.0F, -4.0F, 0.0F);
		plinth.addChild(bone31);
		bone31.texOffs(0, 0).addBox(-2.5F, -8.0F, 3.363F, 5.0F, 8.0F, 1.0F, 0.0F, false);

		bone32 = new ModelRenderer(this);
		bone32.setPos(0.0F, 0.0F, 0.0F);
		bone31.addChild(bone32);
		setRotationAngle(bone32, 0.0F, -1.0472F, 0.0F);
		bone32.texOffs(0, 0).addBox(-2.5F, -8.0F, 3.363F, 5.0F, 8.0F, 1.0F, 0.0F, false);

		bone33 = new ModelRenderer(this);
		bone33.setPos(0.0F, 0.0F, 0.0F);
		bone32.addChild(bone33);
		setRotationAngle(bone33, 0.0F, -1.0472F, 0.0F);
		bone33.texOffs(0, 0).addBox(-2.5F, -8.0F, 3.363F, 5.0F, 8.0F, 1.0F, 0.0F, false);

		bone34 = new ModelRenderer(this);
		bone34.setPos(0.0F, 0.0F, 0.0F);
		bone33.addChild(bone34);
		setRotationAngle(bone34, 0.0F, -1.0472F, 0.0F);
		bone34.texOffs(0, 0).addBox(-2.5F, -8.0F, 3.363F, 5.0F, 8.0F, 1.0F, 0.0F, false);

		bone35 = new ModelRenderer(this);
		bone35.setPos(0.0F, 0.0F, 0.0F);
		bone34.addChild(bone35);
		setRotationAngle(bone35, 0.0F, -1.0472F, 0.0F);
		bone35.texOffs(0, 0).addBox(-2.5F, -8.0F, 3.363F, 5.0F, 8.0F, 1.0F, 0.0F, false);

		bone36 = new ModelRenderer(this);
		bone36.setPos(0.0F, 0.0F, 0.0F);
		bone35.addChild(bone36);
		setRotationAngle(bone36, 0.0F, -1.0472F, 0.0F);
		bone36.texOffs(0, 0).addBox(-2.5F, -8.0F, 3.363F, 5.0F, 8.0F, 1.0F, 0.0F, false);

		bone96 = new ModelRenderer(this);
		bone96.setPos(0.0F, -11.0F, 0.0F);
		plinth.addChild(bone96);
		bone96.texOffs(0, 57).addBox(-3.0F, -3.0F, -0.815F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone97 = new ModelRenderer(this);
		bone97.setPos(0.0F, 0.0F, 0.0F);
		bone96.addChild(bone97);
		setRotationAngle(bone97, 0.0F, -1.0472F, 0.0F);
		bone97.texOffs(0, 57).addBox(-3.0F, -3.025F, -0.815F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone98 = new ModelRenderer(this);
		bone98.setPos(0.0F, 0.0F, 0.0F);
		bone97.addChild(bone98);
		setRotationAngle(bone98, 0.0F, -1.0472F, 0.0F);
		bone98.texOffs(0, 57).addBox(-3.0F, -3.0F, -0.815F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone99 = new ModelRenderer(this);
		bone99.setPos(0.0F, 0.0F, 0.0F);
		bone98.addChild(bone99);
		setRotationAngle(bone99, 0.0F, -1.0472F, 0.0F);
		bone99.texOffs(0, 57).addBox(-3.0F, -3.025F, -0.815F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone100 = new ModelRenderer(this);
		bone100.setPos(0.0F, 0.0F, 0.0F);
		bone99.addChild(bone100);
		setRotationAngle(bone100, 0.0F, -1.0472F, 0.0F);
		bone100.texOffs(0, 57).addBox(-3.0F, -3.0F, -0.815F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone101 = new ModelRenderer(this);
		bone101.setPos(0.0F, 0.0F, 0.0F);
		bone100.addChild(bone101);
		setRotationAngle(bone101, 0.0F, -1.0472F, 0.0F);
		bone101.texOffs(0, 57).addBox(-3.0F, -3.025F, -0.815F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone102 = new ModelRenderer(this);
		bone102.setPos(0.0F, -10.0F, 0.0F);
		plinth.addChild(bone102);
		setRotationAngle(bone102, 0.0F, -0.5236F, 0.0F);
		bone102.texOffs(49, 15).addBox(-0.5F, -4.0F, 5.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone103 = new ModelRenderer(this);
		bone103.setPos(0.0F, 0.0F, 0.0F);
		bone102.addChild(bone103);
		setRotationAngle(bone103, 0.0F, -1.0472F, 0.0F);
		bone103.texOffs(49, 15).addBox(-0.5F, -4.0F, 5.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone104 = new ModelRenderer(this);
		bone104.setPos(0.0F, 0.0F, 0.0F);
		bone103.addChild(bone104);
		setRotationAngle(bone104, 0.0F, -1.0472F, 0.0F);
		bone104.texOffs(49, 15).addBox(-0.5F, -4.0F, 5.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone105 = new ModelRenderer(this);
		bone105.setPos(0.0F, 0.0F, 0.0F);
		bone104.addChild(bone105);
		setRotationAngle(bone105, 0.0F, -1.0472F, 0.0F);
		bone105.texOffs(49, 15).addBox(-0.5F, -4.0F, 5.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone106 = new ModelRenderer(this);
		bone106.setPos(0.0F, 0.0F, 0.0F);
		bone105.addChild(bone106);
		setRotationAngle(bone106, 0.0F, -1.0472F, 0.0F);
		bone106.texOffs(49, 15).addBox(-0.5F, -4.0F, 5.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone107 = new ModelRenderer(this);
		bone107.setPos(0.0F, 0.0F, 0.0F);
		bone106.addChild(bone107);
		setRotationAngle(bone107, 0.0F, -1.0472F, 0.0F);
		bone107.texOffs(49, 15).addBox(-0.5F, -4.0F, 5.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		panels = new ModelRenderer(this);
		panels.setPos(0.0F, -10.0F, 0.0F);
		base_console.addChild(panels);
		

		bone68 = new ModelRenderer(this);
		bone68.setPos(0.0F, -6.0F, 13.6987F);
		panels.addChild(bone68);
		setRotationAngle(bone68, -0.6807F, 0.0F, 0.0F);
		bone68.texOffs(0, 30).addBox(-7.0F, 0.025F, -10.925F, 14.0F, 1.0F, 11.0F, 0.0F, false);

		bone69 = new ModelRenderer(this);
		bone69.setPos(4.6219F, 0.0055F, -7.2982F);
		bone68.addChild(bone69);
		setRotationAngle(bone69, 0.0F, 0.4232F, 0.0F);
		bone69.texOffs(28, 45).addBox(-1.0F, 0.0F, -4.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);

		bone70 = new ModelRenderer(this);
		bone70.setPos(-4.6219F, 0.0055F, -7.2982F);
		bone68.addChild(bone70);
		setRotationAngle(bone70, 0.0F, -0.4232F, 0.0F);
		bone70.texOffs(14, 44).addBox(0.0F, 0.0F, -4.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);

		bone52 = new ModelRenderer(this);
		bone52.setPos(0.0F, 0.0F, 0.0F);
		panels.addChild(bone52);
		setRotationAngle(bone52, 0.0F, -1.0472F, 0.0F);
		

		bone49 = new ModelRenderer(this);
		bone49.setPos(0.0F, -6.0F, 13.6987F);
		bone52.addChild(bone49);
		setRotationAngle(bone49, -0.6807F, 0.0F, 0.0F);
		bone49.texOffs(0, 30).addBox(-7.0F, 0.025F, -10.925F, 14.0F, 1.0F, 11.0F, 0.0F, false);

		bone50 = new ModelRenderer(this);
		bone50.setPos(4.6219F, 0.0055F, -7.2982F);
		bone49.addChild(bone50);
		setRotationAngle(bone50, 0.0F, 0.4232F, 0.0F);
		bone50.texOffs(28, 45).addBox(-1.0F, 0.0F, -4.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);

		bone51 = new ModelRenderer(this);
		bone51.setPos(-4.6219F, 0.0055F, -7.2982F);
		bone49.addChild(bone51);
		setRotationAngle(bone51, 0.0F, -0.4232F, 0.0F);
		bone51.texOffs(14, 44).addBox(0.0F, 0.0F, -4.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);

		bone53 = new ModelRenderer(this);
		bone53.setPos(0.0F, 0.0F, 0.0F);
		bone52.addChild(bone53);
		setRotationAngle(bone53, 0.0F, -1.0472F, 0.0F);
		

		bone54 = new ModelRenderer(this);
		bone54.setPos(0.0F, -6.0F, 13.6987F);
		bone53.addChild(bone54);
		setRotationAngle(bone54, -0.6807F, 0.0F, 0.0F);
		bone54.texOffs(0, 30).addBox(-7.0F, 0.025F, -10.925F, 14.0F, 1.0F, 11.0F, 0.0F, false);

		bone55 = new ModelRenderer(this);
		bone55.setPos(4.6219F, 0.0055F, -7.2982F);
		bone54.addChild(bone55);
		setRotationAngle(bone55, 0.0F, 0.4232F, 0.0F);
		bone55.texOffs(28, 45).addBox(-1.0F, 0.0F, -4.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);

		bone56 = new ModelRenderer(this);
		bone56.setPos(-4.6219F, 0.0055F, -7.2982F);
		bone54.addChild(bone56);
		setRotationAngle(bone56, 0.0F, -0.4232F, 0.0F);
		bone56.texOffs(14, 44).addBox(0.0F, 0.0F, -4.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);

		bone57 = new ModelRenderer(this);
		bone57.setPos(0.0F, 0.0F, 0.0F);
		bone53.addChild(bone57);
		setRotationAngle(bone57, 0.0F, -1.0472F, 0.0F);
		

		bone58 = new ModelRenderer(this);
		bone58.setPos(0.0F, -6.0F, 13.6987F);
		bone57.addChild(bone58);
		setRotationAngle(bone58, -0.6807F, 0.0F, 0.0F);
		bone58.texOffs(0, 30).addBox(-7.0F, 0.025F, -10.925F, 14.0F, 1.0F, 11.0F, 0.0F, false);

		bone59 = new ModelRenderer(this);
		bone59.setPos(4.6219F, 0.0055F, -7.2982F);
		bone58.addChild(bone59);
		setRotationAngle(bone59, 0.0F, 0.4232F, 0.0F);
		bone59.texOffs(28, 45).addBox(-1.0F, 0.0F, -4.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);

		bone60 = new ModelRenderer(this);
		bone60.setPos(-4.6219F, 0.0055F, -7.2982F);
		bone58.addChild(bone60);
		setRotationAngle(bone60, 0.0F, -0.4232F, 0.0F);
		bone60.texOffs(14, 44).addBox(0.0F, 0.0F, -4.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);

		bone61 = new ModelRenderer(this);
		bone61.setPos(0.0F, 0.0F, 0.0F);
		bone57.addChild(bone61);
		setRotationAngle(bone61, 0.0F, -1.0472F, 0.0F);
		

		bone62 = new ModelRenderer(this);
		bone62.setPos(0.0F, -6.0F, 13.6987F);
		bone61.addChild(bone62);
		setRotationAngle(bone62, -0.6807F, 0.0F, 0.0F);
		bone62.texOffs(0, 30).addBox(-7.0F, 0.025F, -10.925F, 14.0F, 1.0F, 11.0F, 0.0F, false);

		bone63 = new ModelRenderer(this);
		bone63.setPos(4.6219F, 0.0055F, -7.2982F);
		bone62.addChild(bone63);
		setRotationAngle(bone63, 0.0F, 0.4232F, 0.0F);
		bone63.texOffs(28, 45).addBox(-1.0F, 0.0F, -4.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);

		bone64 = new ModelRenderer(this);
		bone64.setPos(-4.6219F, 0.0055F, -7.2982F);
		bone62.addChild(bone64);
		setRotationAngle(bone64, 0.0F, -0.4232F, 0.0F);
		bone64.texOffs(14, 44).addBox(0.0F, 0.0F, -4.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);

		bone65 = new ModelRenderer(this);
		bone65.setPos(0.0F, 0.0F, 0.0F);
		bone61.addChild(bone65);
		setRotationAngle(bone65, 0.0F, -1.0472F, 0.0F);
		

		bone66 = new ModelRenderer(this);
		bone66.setPos(0.0F, -6.0F, 13.6987F);
		bone65.addChild(bone66);
		setRotationAngle(bone66, -0.6807F, 0.0F, 0.0F);
		bone66.texOffs(0, 30).addBox(-7.0F, 0.025F, -10.925F, 14.0F, 1.0F, 11.0F, 0.0F, false);

		bone67 = new ModelRenderer(this);
		bone67.setPos(4.6219F, 0.0055F, -7.2982F);
		bone66.addChild(bone67);
		setRotationAngle(bone67, 0.0F, 0.4232F, 0.0F);
		bone67.texOffs(28, 45).addBox(-1.0F, 0.0F, -4.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);

		bone95 = new ModelRenderer(this);
		bone95.setPos(-4.6219F, 0.0055F, -7.2982F);
		bone66.addChild(bone95);
		setRotationAngle(bone95, 0.0F, -0.4232F, 0.0F);
		bone95.texOffs(14, 44).addBox(0.0F, 0.0F, -4.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);

		bone209 = new ModelRenderer(this);
		bone209.setPos(0.0F, -1.0F, 0.0F);
		base_console.addChild(bone209);
		

		bone43 = new ModelRenderer(this);
		bone43.setPos(0.0F, -9.0F, 0.0F);
		bone209.addChild(bone43);
		

		bone71 = new ModelRenderer(this);
		bone71.setPos(0.0F, -6.0F, 18.316F);
		bone43.addChild(bone71);
		setRotationAngle(bone71, 0.0044F, 0.0F, 0.0F);
		bone71.texOffs(0, 0).addBox(-10.0F, 0.0F, -13.0F, 20.0F, 2.0F, 13.0F, 0.0F, false);

		bone38 = new ModelRenderer(this);
		bone38.setPos(0.0F, 0.0F, 0.0F);
		bone43.addChild(bone38);
		setRotationAngle(bone38, 0.0F, -1.0472F, 0.0F);
		

		bone72 = new ModelRenderer(this);
		bone72.setPos(0.0F, -6.0F, 18.316F);
		bone38.addChild(bone72);
		setRotationAngle(bone72, 0.0044F, 0.0F, 0.0F);
		bone72.texOffs(0, 0).addBox(-10.0F, 0.0F, -13.0F, 20.0F, 2.0F, 13.0F, 0.0F, false);

		bone39 = new ModelRenderer(this);
		bone39.setPos(0.0F, 0.0F, 0.0F);
		bone38.addChild(bone39);
		setRotationAngle(bone39, 0.0F, -1.0472F, 0.0F);
		

		bone40 = new ModelRenderer(this);
		bone40.setPos(0.0F, -6.0F, 18.316F);
		bone39.addChild(bone40);
		setRotationAngle(bone40, 0.0044F, 0.0F, 0.0F);
		bone40.texOffs(0, 0).addBox(-10.0F, 0.0F, -13.0F, 20.0F, 2.0F, 13.0F, 0.0F, false);

		bone41 = new ModelRenderer(this);
		bone41.setPos(0.0F, 0.0F, 0.0F);
		bone39.addChild(bone41);
		setRotationAngle(bone41, 0.0F, -1.0472F, 0.0F);
		

		bone42 = new ModelRenderer(this);
		bone42.setPos(0.0F, -6.0F, 18.316F);
		bone41.addChild(bone42);
		setRotationAngle(bone42, 0.0044F, 0.0F, 0.0F);
		bone42.texOffs(0, 0).addBox(-10.0F, 0.0F, -13.0F, 20.0F, 2.0F, 13.0F, 0.0F, false);

		bone73 = new ModelRenderer(this);
		bone73.setPos(0.0F, 0.0F, 0.0F);
		bone41.addChild(bone73);
		setRotationAngle(bone73, 0.0F, -1.0472F, 0.0F);
		

		bone74 = new ModelRenderer(this);
		bone74.setPos(0.0F, -6.0F, 18.316F);
		bone73.addChild(bone74);
		setRotationAngle(bone74, 0.0044F, 0.0F, 0.0F);
		bone74.texOffs(0, 0).addBox(-10.0F, 0.0F, -13.0F, 20.0F, 2.0F, 13.0F, 0.0F, false);

		bone75 = new ModelRenderer(this);
		bone75.setPos(0.0F, 0.0F, 0.0F);
		bone73.addChild(bone75);
		setRotationAngle(bone75, 0.0F, -1.0472F, 0.0F);
		

		bone76 = new ModelRenderer(this);
		bone76.setPos(0.0F, -6.0F, 18.316F);
		bone75.addChild(bone76);
		setRotationAngle(bone76, 0.0044F, 0.0F, 0.0F);
		bone76.texOffs(0, 0).addBox(-10.0F, 0.0F, -13.0F, 20.0F, 2.0F, 13.0F, 0.0F, false);

		bone181 = new ModelRenderer(this);
		bone181.setPos(0.0F, -8.0F, 0.0F);
		bone209.addChild(bone181);
		

		bone182 = new ModelRenderer(this);
		bone182.setPos(0.0F, -5.0F, 16.316F);
		bone181.addChild(bone182);
		setRotationAngle(bone182, 0.2182F, 0.0F, 0.0F);
		bone182.texOffs(0, 15).addBox(-9.0F, -1.0F, -13.0F, 18.0F, 2.0F, 13.0F, 0.0F, false);

		bone183 = new ModelRenderer(this);
		bone183.setPos(0.0F, 0.0F, 0.0F);
		bone181.addChild(bone183);
		setRotationAngle(bone183, 0.0F, -1.0472F, 0.0F);
		

		bone193 = new ModelRenderer(this);
		bone193.setPos(0.0F, -5.0F, 16.316F);
		bone183.addChild(bone193);
		setRotationAngle(bone193, 0.2182F, 0.0F, 0.0F);
		bone193.texOffs(0, 15).addBox(-9.0F, -1.0F, -13.0F, 18.0F, 2.0F, 13.0F, 0.0F, false);

		bone184 = new ModelRenderer(this);
		bone184.setPos(0.0F, 0.0F, 0.0F);
		bone183.addChild(bone184);
		setRotationAngle(bone184, 0.0F, -1.0472F, 0.0F);
		

		bone185 = new ModelRenderer(this);
		bone185.setPos(0.0F, -5.0F, 16.316F);
		bone184.addChild(bone185);
		setRotationAngle(bone185, 0.2182F, 0.0F, 0.0F);
		bone185.texOffs(0, 15).addBox(-9.0F, -1.0F, -13.0F, 18.0F, 2.0F, 13.0F, 0.0F, false);

		bone186 = new ModelRenderer(this);
		bone186.setPos(0.0F, 0.0F, 0.0F);
		bone184.addChild(bone186);
		setRotationAngle(bone186, 0.0F, -1.0472F, 0.0F);
		

		bone187 = new ModelRenderer(this);
		bone187.setPos(0.0F, -5.0F, 16.316F);
		bone186.addChild(bone187);
		setRotationAngle(bone187, 0.2182F, 0.0F, 0.0F);
		bone187.texOffs(0, 15).addBox(-9.0F, -1.0F, -13.0F, 18.0F, 2.0F, 13.0F, 0.0F, false);

		bone188 = new ModelRenderer(this);
		bone188.setPos(0.0F, 0.0F, 0.0F);
		bone186.addChild(bone188);
		setRotationAngle(bone188, 0.0F, -1.0472F, 0.0F);
		

		bone189 = new ModelRenderer(this);
		bone189.setPos(0.0F, -5.0F, 16.316F);
		bone188.addChild(bone189);
		setRotationAngle(bone189, 0.2182F, 0.0F, 0.0F);
		bone189.texOffs(0, 15).addBox(-9.0F, -1.0F, -13.0F, 18.0F, 2.0F, 13.0F, 0.0F, false);

		bone190 = new ModelRenderer(this);
		bone190.setPos(0.0F, 0.0F, 0.0F);
		bone188.addChild(bone190);
		setRotationAngle(bone190, 0.0F, -1.0472F, 0.0F);
		

		bone191 = new ModelRenderer(this);
		bone191.setPos(0.0F, -5.0F, 16.316F);
		bone190.addChild(bone191);
		setRotationAngle(bone191, 0.2182F, 0.0F, 0.0F);
		bone191.texOffs(0, 15).addBox(-9.0F, -1.0F, -13.0F, 18.0F, 2.0F, 13.0F, 0.0F, false);

		bone37 = new ModelRenderer(this);
		bone37.setPos(0.0F, -9.0F, 0.0F);
		bone209.addChild(bone37);
		setRotationAngle(bone37, 0.0F, -0.5236F, 0.0F);
		bone37.texOffs(45, 38).addBox(-0.5F, -6.0F, 19.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone44 = new ModelRenderer(this);
		bone44.setPos(0.0F, 0.0F, 0.0F);
		bone37.addChild(bone44);
		setRotationAngle(bone44, 0.0F, -1.0472F, 0.0F);
		bone44.texOffs(45, 38).addBox(-0.5F, -6.0F, 19.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone45 = new ModelRenderer(this);
		bone45.setPos(0.0F, 0.0F, 0.0F);
		bone44.addChild(bone45);
		setRotationAngle(bone45, 0.0F, -1.0472F, 0.0F);
		bone45.texOffs(45, 38).addBox(-0.5F, -6.0F, 19.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone46 = new ModelRenderer(this);
		bone46.setPos(0.0F, 0.0F, 0.0F);
		bone45.addChild(bone46);
		setRotationAngle(bone46, 0.0F, -1.0472F, 0.0F);
		bone46.texOffs(45, 38).addBox(-0.5F, -6.0F, 19.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone47 = new ModelRenderer(this);
		bone47.setPos(0.0F, 0.0F, 0.0F);
		bone46.addChild(bone47);
		setRotationAngle(bone47, 0.0F, -1.0472F, 0.0F);
		bone47.texOffs(45, 38).addBox(-0.5F, -6.0F, 19.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone48 = new ModelRenderer(this);
		bone48.setPos(0.0F, 0.0F, 0.0F);
		bone47.addChild(bone48);
		setRotationAngle(bone48, 0.0F, -1.0472F, 0.0F);
		bone48.texOffs(45, 38).addBox(-0.5F, -6.0F, 19.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		centre_pillar = new ModelRenderer(this);
		centre_pillar.setPos(0.0F, 0.0F, 0.0F);
		base_console.addChild(centre_pillar);
		

		bone119 = new ModelRenderer(this);
		bone119.setPos(0.0F, -20.0F, 0.0F);
		centre_pillar.addChild(bone119);
		bone119.texOffs(53, 0).addBox(-3.0F, -2.975F, -0.815F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone120 = new ModelRenderer(this);
		bone120.setPos(0.0F, 0.0F, 0.0F);
		bone119.addChild(bone120);
		setRotationAngle(bone120, 0.0F, -1.0472F, 0.0F);
		bone120.texOffs(53, 0).addBox(-3.0F, -2.975F, -0.815F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone121 = new ModelRenderer(this);
		bone121.setPos(0.0F, 0.0F, 0.0F);
		bone120.addChild(bone121);
		setRotationAngle(bone121, 0.0F, -1.0472F, 0.0F);
		bone121.texOffs(53, 0).addBox(-3.0F, -2.975F, -0.815F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone122 = new ModelRenderer(this);
		bone122.setPos(0.0F, 0.0F, 0.0F);
		bone121.addChild(bone122);
		setRotationAngle(bone122, 0.0F, -1.0472F, 0.0F);
		bone122.texOffs(53, 0).addBox(-3.0F, -2.975F, -0.815F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone123 = new ModelRenderer(this);
		bone123.setPos(0.0F, 0.0F, 0.0F);
		bone122.addChild(bone123);
		setRotationAngle(bone123, 0.0F, -1.0472F, 0.0F);
		bone123.texOffs(53, 0).addBox(-3.0F, -2.975F, -0.815F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone124 = new ModelRenderer(this);
		bone124.setPos(0.0F, 0.0F, 0.0F);
		bone123.addChild(bone124);
		setRotationAngle(bone124, 0.0F, -1.0472F, 0.0F);
		bone124.texOffs(53, 0).addBox(-3.0F, -2.975F, -0.815F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone77 = new ModelRenderer(this);
		bone77.setPos(0.0F, -21.75F, 0.0F);
		centre_pillar.addChild(bone77);
		bone77.texOffs(26, 58).addBox(-2.0F, -2.975F, -2.35F, 4.0F, 2.0F, 7.0F, 0.25F, false);

		bone78 = new ModelRenderer(this);
		bone78.setPos(0.0F, 0.0F, 0.0F);
		bone77.addChild(bone78);
		setRotationAngle(bone78, 0.0F, -1.0472F, 0.0F);
		bone78.texOffs(26, 58).addBox(-2.0F, -2.975F, -2.35F, 4.0F, 2.0F, 7.0F, 0.25F, false);

		bone79 = new ModelRenderer(this);
		bone79.setPos(0.0F, 0.0F, 0.0F);
		bone78.addChild(bone79);
		setRotationAngle(bone79, 0.0F, -1.0472F, 0.0F);
		bone79.texOffs(26, 58).addBox(-2.0F, -2.975F, -2.35F, 4.0F, 2.0F, 7.0F, 0.25F, false);

		bone80 = new ModelRenderer(this);
		bone80.setPos(0.0F, 0.0F, 0.0F);
		bone79.addChild(bone80);
		setRotationAngle(bone80, 0.0F, -1.0472F, 0.0F);
		bone80.texOffs(26, 58).addBox(-2.0F, -2.975F, -2.35F, 4.0F, 2.0F, 7.0F, 0.25F, false);

		bone81 = new ModelRenderer(this);
		bone81.setPos(0.0F, 0.0F, 0.0F);
		bone80.addChild(bone81);
		setRotationAngle(bone81, 0.0F, -1.0472F, 0.0F);
		bone81.texOffs(26, 58).addBox(-2.0F, -2.975F, -2.35F, 4.0F, 2.0F, 7.0F, 0.25F, false);

		bone82 = new ModelRenderer(this);
		bone82.setPos(0.0F, 0.0F, 0.0F);
		bone81.addChild(bone82);
		setRotationAngle(bone82, 0.0F, -1.0472F, 0.0F);
		bone82.texOffs(26, 58).addBox(-2.0F, -2.975F, -2.35F, 4.0F, 2.0F, 7.0F, 0.25F, false);

		bone131 = new ModelRenderer(this);
		bone131.setPos(0.0F, -49.25F, 0.0F);
		centre_pillar.addChild(bone131);
		bone131.texOffs(47, 51).addBox(-2.0F, -8.0F, -2.35F, 4.0F, 7.0F, 7.0F, 0.25F, false);

		bone132 = new ModelRenderer(this);
		bone132.setPos(0.0F, 0.0F, 0.0F);
		bone131.addChild(bone132);
		setRotationAngle(bone132, 0.0F, -1.0472F, 0.0F);
		bone132.texOffs(47, 51).addBox(-2.0F, -8.0F, -2.35F, 4.0F, 7.0F, 7.0F, 0.25F, false);

		bone133 = new ModelRenderer(this);
		bone133.setPos(0.0F, 0.0F, 0.0F);
		bone132.addChild(bone133);
		setRotationAngle(bone133, 0.0F, -1.0472F, 0.0F);
		bone133.texOffs(47, 51).addBox(-2.0F, -8.0F, -2.35F, 4.0F, 7.0F, 7.0F, 0.25F, false);

		bone134 = new ModelRenderer(this);
		bone134.setPos(0.0F, 0.0F, 0.0F);
		bone133.addChild(bone134);
		setRotationAngle(bone134, 0.0F, -1.0472F, 0.0F);
		bone134.texOffs(47, 51).addBox(-2.0F, -8.0F, -2.35F, 4.0F, 7.0F, 7.0F, 0.25F, false);

		bone135 = new ModelRenderer(this);
		bone135.setPos(0.0F, 0.0F, 0.0F);
		bone134.addChild(bone135);
		setRotationAngle(bone135, 0.0F, -1.0472F, 0.0F);
		bone135.texOffs(47, 51).addBox(-2.0F, -8.0F, -2.35F, 4.0F, 7.0F, 7.0F, 0.25F, false);

		bone136 = new ModelRenderer(this);
		bone136.setPos(0.0F, 0.0F, 0.0F);
		bone135.addChild(bone136);
		setRotationAngle(bone136, 0.0F, -1.0472F, 0.0F);
		bone136.texOffs(47, 51).addBox(-2.0F, -8.0F, -2.35F, 4.0F, 7.0F, 7.0F, 0.25F, false);

		bone125 = new ModelRenderer(this);
		bone125.setPos(0.0F, -19.0F, 0.0F);
		centre_pillar.addChild(bone125);
		setRotationAngle(bone125, 0.0F, -0.5236F, 0.0F);
		bone125.texOffs(6, 38).addBox(-0.5F, -4.0F, 5.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone126 = new ModelRenderer(this);
		bone126.setPos(0.0F, 0.0F, 0.0F);
		bone125.addChild(bone126);
		setRotationAngle(bone126, 0.0F, -1.0472F, 0.0F);
		bone126.texOffs(6, 38).addBox(-0.5F, -4.0F, 5.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone127 = new ModelRenderer(this);
		bone127.setPos(0.0F, 0.0F, 0.0F);
		bone126.addChild(bone127);
		setRotationAngle(bone127, 0.0F, -1.0472F, 0.0F);
		bone127.texOffs(6, 38).addBox(-0.5F, -4.0F, 5.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone128 = new ModelRenderer(this);
		bone128.setPos(0.0F, 0.0F, 0.0F);
		bone127.addChild(bone128);
		setRotationAngle(bone128, 0.0F, -1.0472F, 0.0F);
		bone128.texOffs(6, 38).addBox(-0.5F, -4.0F, 5.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone129 = new ModelRenderer(this);
		bone129.setPos(0.0F, 0.0F, 0.0F);
		bone128.addChild(bone129);
		setRotationAngle(bone129, 0.0F, -1.0472F, 0.0F);
		bone129.texOffs(6, 38).addBox(-0.5F, -4.0F, 5.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone130 = new ModelRenderer(this);
		bone130.setPos(0.0F, 0.0F, 0.0F);
		bone129.addChild(bone130);
		setRotationAngle(bone130, 0.0F, -1.0472F, 0.0F);
		bone130.texOffs(6, 38).addBox(-0.5F, -4.0F, 5.863F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone83 = new ModelRenderer(this);
		bone83.setPos(0.0F, -19.0F, 0.0F);
		centre_pillar.addChild(bone83);
		setRotationAngle(bone83, 0.0F, -0.5236F, 0.0F);
		bone83.texOffs(9, 21).addBox(-0.5F, -6.0F, 4.368F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone84 = new ModelRenderer(this);
		bone84.setPos(0.0F, 0.0F, 0.0F);
		bone83.addChild(bone84);
		setRotationAngle(bone84, 0.0F, -1.0472F, 0.0F);
		bone84.texOffs(9, 21).addBox(-0.5F, -6.0F, 4.368F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone85 = new ModelRenderer(this);
		bone85.setPos(0.0F, 0.0F, 0.0F);
		bone84.addChild(bone85);
		setRotationAngle(bone85, 0.0F, -1.0472F, 0.0F);
		bone85.texOffs(9, 21).addBox(-0.5F, -6.0F, 4.368F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone86 = new ModelRenderer(this);
		bone86.setPos(0.0F, 0.0F, 0.0F);
		bone85.addChild(bone86);
		setRotationAngle(bone86, 0.0F, -1.0472F, 0.0F);
		bone86.texOffs(9, 21).addBox(-0.5F, -6.0F, 4.368F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone87 = new ModelRenderer(this);
		bone87.setPos(0.0F, 0.0F, 0.0F);
		bone86.addChild(bone87);
		setRotationAngle(bone87, 0.0F, -1.0472F, 0.0F);
		bone87.texOffs(9, 21).addBox(-0.5F, -6.0F, 4.368F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone88 = new ModelRenderer(this);
		bone88.setPos(0.0F, 0.0F, 0.0F);
		bone87.addChild(bone88);
		setRotationAngle(bone88, 0.0F, -1.0472F, 0.0F);
		bone88.texOffs(9, 21).addBox(-0.5F, -6.0F, 4.368F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone143 = new ModelRenderer(this);
		bone143.setPos(0.0F, -46.0F, 0.0F);
		centre_pillar.addChild(bone143);
		setRotationAngle(bone143, 0.0F, -0.5236F, 0.0F);
		bone143.texOffs(6, 30).addBox(-0.5F, -11.0F, 4.368F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		bone144 = new ModelRenderer(this);
		bone144.setPos(0.0F, 0.0F, 0.0F);
		bone143.addChild(bone144);
		setRotationAngle(bone144, 0.0F, -1.0472F, 0.0F);
		bone144.texOffs(6, 30).addBox(-0.5F, -11.0F, 4.368F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		bone145 = new ModelRenderer(this);
		bone145.setPos(0.0F, 0.0F, 0.0F);
		bone144.addChild(bone145);
		setRotationAngle(bone145, 0.0F, -1.0472F, 0.0F);
		bone145.texOffs(6, 30).addBox(-0.5F, -11.0F, 4.368F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		bone146 = new ModelRenderer(this);
		bone146.setPos(0.0F, 0.0F, 0.0F);
		bone145.addChild(bone146);
		setRotationAngle(bone146, 0.0F, -1.0472F, 0.0F);
		bone146.texOffs(6, 30).addBox(-0.5F, -11.0F, 4.368F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		bone147 = new ModelRenderer(this);
		bone147.setPos(0.0F, 0.0F, 0.0F);
		bone146.addChild(bone147);
		setRotationAngle(bone147, 0.0F, -1.0472F, 0.0F);
		bone147.texOffs(6, 30).addBox(-0.5F, -11.0F, 4.368F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		bone148 = new ModelRenderer(this);
		bone148.setPos(0.0F, 0.0F, 0.0F);
		bone147.addChild(bone148);
		setRotationAngle(bone148, 0.0F, -1.0472F, 0.0F);
		bone148.texOffs(6, 30).addBox(-0.5F, -11.0F, 4.368F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		controls = new ModelRenderer(this);
		controls.setPos(0.0F, -10.0F, 0.0F);
		bone208.addChild(controls);
		

		north = new ModelRenderer(this);
		north.setPos(0.0F, 0.0F, 0.0F);
		controls.addChild(north);
		setRotationAngle(north, 0.0F, 3.1416F, 0.0F);
		

		bone198 = new ModelRenderer(this);
		bone198.setPos(0.0F, -9.51F, 0.0F);
		north.addChild(bone198);
		setRotationAngle(bone198, -0.6807F, 0.0F, 0.0F);
		bone198.texOffs(67, 69).addBox(-1.5F, -5.9618F, 5.182F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bone198.texOffs(0, 25).addBox(-2.0F, -5.8868F, 2.932F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		bone198.texOffs(55, 73).addBox(-1.0F, -6.2118F, 5.682F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		control = new ModelRenderer(this);
		control.setPos(1.0F, -0.8868F, -1.4167F);
		bone198.addChild(control);
		control.texOffs(49, 25).addBox(-4.0F, -5.475F, 11.8487F, 6.0F, 1.0F, 2.0F, 0.0F, false);

		bone202 = new ModelRenderer(this);
		bone202.setPos(-0.5F, -5.225F, 12.3487F);
		control.addChild(bone202);
		setRotationAngle(bone202, 0.6807F, 0.0F, 0.0F);
		bone202.texOffs(44, 69).addBox(-3.0F, -0.5F, -1.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);

		control2 = new ModelRenderer(this);
		control2.setPos(3.6F, -5.9618F, 8.432F);
		bone198.addChild(control2);
		control2.texOffs(55, 33).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		control3 = new ModelRenderer(this);
		control3.setPos(-3.6F, -1.8868F, 0.3333F);
		bone198.addChild(control3);
		control3.texOffs(55, 33).addBox(-0.5F, -4.575F, 7.5987F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		control4 = new ModelRenderer(this);
		control4.setPos(2.0F, -1.6368F, -2.4167F);
		bone198.addChild(control4);
		control4.texOffs(55, 35).addBox(-2.5F, -5.325F, 8.5987F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone199 = new ModelRenderer(this);
		bone199.setPos(3.1F, 2.7832F, -3.603F);
		bone198.addChild(bone199);
		bone199.texOffs(73, 33).addBox(-0.5F, -8.745F, 11.035F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone199.texOffs(24, 67).addBox(-0.75F, -8.72F, 9.535F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		bone199.texOffs(44, 72).addBox(1.5F, -8.72F, 10.785F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone199.texOffs(72, 0).addBox(-1.5F, -8.72F, 10.785F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		bone200 = new ModelRenderer(this);
		bone200.setPos(-4.1F, 2.7832F, -3.603F);
		bone198.addChild(bone200);
		bone200.texOffs(73, 33).addBox(-0.5F, -8.745F, 11.035F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone200.texOffs(24, 67).addBox(-0.75F, -8.72F, 9.535F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		bone200.texOffs(44, 72).addBox(1.5F, -8.72F, 10.785F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone200.texOffs(72, 0).addBox(-1.5F, -8.72F, 10.785F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		north_left = new ModelRenderer(this);
		north_left.setPos(0.0F, 0.0F, 0.0F);
		controls.addChild(north_left);
		setRotationAngle(north_left, 0.0F, 2.0944F, 0.0F);
		

		bone210 = new ModelRenderer(this);
		bone210.setPos(0.0F, -9.51F, 0.0F);
		north_left.addChild(bone210);
		setRotationAngle(bone210, -0.6807F, 0.0F, 0.0F);
		bone210.texOffs(73, 30).addBox(-1.0F, -6.8868F, 3.682F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone210.texOffs(53, 9).addBox(-4.0F, -5.8868F, 6.182F, 8.0F, 1.0F, 3.0F, 0.0F, false);
		bone210.texOffs(69, 58).addBox(0.0F, -5.8868F, 9.432F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bone210.texOffs(45, 65).addBox(-6.0F, -6.1368F, 9.432F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		bone210.texOffs(49, 72).addBox(3.0F, -6.3868F, 9.932F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone210.texOffs(55, 31).addBox(-2.0F, -6.1368F, 10.432F, 1.0F, 1.0F, 1.0F, 0.25F, false);
		bone210.texOffs(53, 2).addBox(-2.5F, -6.6368F, 4.182F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone210.texOffs(53, 2).addBox(1.5F, -6.6368F, 4.182F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		control5 = new ModelRenderer(this);
		control5.setPos(0.0F, -1.6368F, -3.4167F);
		bone210.addChild(control5);
		control5.texOffs(53, 4).addBox(-3.5F, -5.0F, 10.5987F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		control6 = new ModelRenderer(this);
		control6.setPos(-3.5F, -1.7868F, 0.8333F);
		bone210.addChild(control6);
		control6.texOffs(34, 53).addBox(1.5F, -5.25F, 9.5987F, 1.0F, 1.0F, 1.0F, -0.25F, false);

		control7 = new ModelRenderer(this);
		control7.setPos(4.0F, -6.3868F, 10.932F);
		bone210.addChild(control7);
		setRotationAngle(control7, 0.0F, -0.7854F, 0.0F);
		control7.texOffs(52, 30).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		control8 = new ModelRenderer(this);
		control8.setPos(-1.0F, -0.9118F, -1.4167F);
		bone210.addChild(control8);
		control8.texOffs(78, 1).addBox(3.25F, -5.0F, 7.5987F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		south = new ModelRenderer(this);
		south.setPos(0.0F, 0.0F, 0.0F);
		controls.addChild(south);
		

		bone214 = new ModelRenderer(this);
		bone214.setPos(0.0F, -9.51F, 0.0F);
		south.addChild(bone214);
		setRotationAngle(bone214, -0.6807F, 0.0F, 0.0F);
		bone214.texOffs(49, 72).addBox(3.5F, -6.3868F, 10.432F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone214.texOffs(49, 72).addBox(-5.5F, -6.3868F, 10.432F, 2.0F, 1.0F, 2.0F, 0.0F, true);
		bone214.texOffs(63, 65).addBox(-2.5F, -6.1368F, 8.932F, 5.0F, 1.0F, 3.0F, 0.0F, false);
		bone214.texOffs(19, 42).addBox(-2.0F, -5.8868F, 7.432F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		bone214.texOffs(61, 73).addBox(-5.25F, -5.8868F, 8.182F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bone214.texOffs(29, 73).addBox(2.75F, -5.8868F, 8.182F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bone214.texOffs(42, 45).addBox(-2.5F, -5.8868F, 5.932F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		bone214.texOffs(19, 46).addBox(-1.0F, -5.8868F, 4.182F, 2.0F, 1.0F, 1.0F, 0.25F, false);

		control_lever2 = new ModelRenderer(this);
		control_lever2.setPos(-1.25F, -6.5118F, 10.182F);
		bone214.addChild(control_lever2);
		setRotationAngle(control_lever2, 0.0F, -0.6981F, 0.0F);
		control_lever2.texOffs(0, 45).addBox(-1.75F, -0.625F, -0.75F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		control_lever2.texOffs(52, 20).addBox(-0.5F, -0.375F, -0.5F, 1.0F, 1.0F, 1.0F, -0.25F, false);

		control10 = new ModelRenderer(this);
		control10.setPos(-2.5F, -1.1368F, 1.3333F);
		bone214.addChild(control10);
		control10.texOffs(52, 17).addBox(2.25F, -5.75F, 7.8487F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		control10.texOffs(52, 17).addBox(3.75F, -5.5F, 7.8487F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		control10.texOffs(52, 17).addBox(3.75F, -5.5F, 9.3487F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		control11 = new ModelRenderer(this);
		control11.setPos(2.0F, -1.6368F, 1.8333F);
		bone214.addChild(control11);
		control11.texOffs(52, 30).addBox(2.0F, -5.25F, 9.0987F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		control12 = new ModelRenderer(this);
		control12.setPos(-2.0F, -1.6368F, 1.8333F);
		bone214.addChild(control12);
		control12.texOffs(52, 30).addBox(-3.0F, -5.25F, 9.0987F, 1.0F, 1.0F, 1.0F, 0.0F, true);

		south_right = new ModelRenderer(this);
		south_right.setPos(0.0F, 0.0F, 0.0F);
		controls.addChild(south_right);
		setRotationAngle(south_right, 0.0F, -1.0472F, 0.0F);
		

		bone216 = new ModelRenderer(this);
		bone216.setPos(0.0F, -9.51F, 0.0F);
		south_right.addChild(bone216);
		setRotationAngle(bone216, -0.6807F, 0.0F, 0.0F);
		bone216.texOffs(71, 49).addBox(-4.0F, -5.8868F, 6.432F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone216.texOffs(17, 71).addBox(3.0F, -5.8868F, 6.432F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone216.texOffs(72, 4).addBox(-1.0F, -6.6118F, 4.432F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone221 = new ModelRenderer(this);
		bone221.setPos(-4.5F, -1.6368F, 3.8333F);
		bone216.addChild(bone221);
		bone221.texOffs(62, 25).addBox(2.0F, -4.5F, 3.8487F, 5.0F, 1.0F, 4.0F, 0.0F, false);

		control_lever3 = new ModelRenderer(this);
		control_lever3.setPos(3.0F, -4.5F, 6.8487F);
		bone221.addChild(control_lever3);
		setRotationAngle(control_lever3, 0.0F, 0.48F, 0.0F);
		control_lever3.texOffs(32, 42).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		control_lever3.texOffs(19, 44).addBox(-1.75F, -0.75F, -0.75F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		control13 = new ModelRenderer(this);
		control13.setPos(0.25F, 0.0F, -2.0F);
		bone221.addChild(control13);
		control13.texOffs(0, 47).addBox(5.25F, -5.0F, 6.3487F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		control13.texOffs(0, 47).addBox(4.0F, -5.0F, 6.3487F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		control14 = new ModelRenderer(this);
		control14.setPos(1.5F, 0.0F, 0.0F);
		bone221.addChild(control14);
		control14.texOffs(0, 47).addBox(2.5F, -5.0F, 6.3487F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		control14.texOffs(0, 47).addBox(4.0F, -5.0F, 6.3487F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone217 = new ModelRenderer(this);
		bone217.setPos(4.5F, -5.8868F, 10.432F);
		bone216.addChild(bone217);
		setRotationAngle(bone217, 0.0F, 0.7854F, 0.0F);
		bone217.texOffs(72, 9).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone218 = new ModelRenderer(this);
		bone218.setPos(-4.5F, -5.8868F, 10.432F);
		bone216.addChild(bone218);
		setRotationAngle(bone218, 0.0F, -0.7854F, 0.0F);
		bone218.texOffs(72, 9).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, true);

		bone219 = new ModelRenderer(this);
		bone219.setPos(2.5F, -5.8618F, 4.432F);
		bone216.addChild(bone219);
		setRotationAngle(bone219, 0.3927F, 0.0F, 0.0F);
		bone219.texOffs(0, 42).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bone219.texOffs(0, 42).addBox(-5.5F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		south_left = new ModelRenderer(this);
		south_left.setPos(0.0F, 0.0F, 0.0F);
		controls.addChild(south_left);
		setRotationAngle(south_left, 0.0F, 1.0472F, 0.0F);
		

		bone211 = new ModelRenderer(this);
		bone211.setPos(0.0F, -9.51F, 0.0F);
		south_left.addChild(bone211);
		setRotationAngle(bone211, -0.6807F, 0.0F, 0.0F);
		bone211.texOffs(71, 53).addBox(-1.0F, -6.6368F, 3.932F, 2.0F, 2.0F, 2.0F, -0.25F, false);
		bone211.texOffs(71, 53).addBox(-3.0F, -6.3868F, 3.932F, 2.0F, 2.0F, 2.0F, -0.25F, false);
		bone211.texOffs(71, 53).addBox(1.0F, -6.3868F, 3.932F, 2.0F, 2.0F, 2.0F, -0.25F, false);
		bone211.texOffs(19, 57).addBox(-0.5F, -6.1368F, 6.682F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		bone211.texOffs(0, 9).addBox(-5.5F, -6.6368F, 9.682F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bone211.texOffs(23, 73).addBox(-5.0F, -7.6368F, 10.182F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone211.texOffs(52, 38).addBox(2.25F, -5.8868F, 9.432F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bone211.texOffs(42, 50).addBox(1.75F, -5.8868F, 5.932F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bone211.texOffs(0, 21).addBox(-4.75F, -5.8868F, 5.932F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bone211.texOffs(0, 15).addBox(-1.5F, -5.8868F, 6.432F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone211.texOffs(52, 34).addBox(2.75F, -6.6368F, 9.832F, 1.0F, 1.0F, 1.0F, -0.25F, false);
		bone211.texOffs(52, 34).addBox(3.85F, -6.6368F, 9.832F, 1.0F, 1.0F, 1.0F, -0.25F, false);
		bone211.texOffs(52, 34).addBox(3.85F, -6.6368F, 10.932F, 1.0F, 1.0F, 1.0F, -0.25F, false);

		control_lever = new ModelRenderer(this);
		control_lever.setPos(-4.0F, -7.3868F, 11.182F);
		bone211.addChild(control_lever);
		setRotationAngle(control_lever, 0.0F, 0.7418F, 0.0F);
		control_lever.texOffs(69, 73).addBox(-2.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		control9 = new ModelRenderer(this);
		control9.setPos(-0.5F, -0.8868F, -1.4167F);
		bone211.addChild(control9);
		control9.texOffs(52, 32).addBox(0.25F, -5.75F, 8.8487F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		control9.texOffs(52, 32).addBox(0.25F, -5.75F, 11.3487F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone212 = new ModelRenderer(this);
		bone212.setPos(3.25F, -6.1368F, 11.432F);
		bone211.addChild(bone212);
		setRotationAngle(bone212, 0.0F, 0.3491F, 0.0F);
		bone212.texOffs(53, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		north_right = new ModelRenderer(this);
		north_right.setPos(0.0F, 0.0F, 0.0F);
		controls.addChild(north_right);
		setRotationAngle(north_right, 0.0F, -2.0944F, 0.0F);
		

		bone203 = new ModelRenderer(this);
		bone203.setPos(0.0F, -9.51F, 0.0F);
		north_right.addChild(bone203);
		setRotationAngle(bone203, -0.6807F, 0.0F, 0.0F);
		bone203.texOffs(72, 4).addBox(-1.0F, -6.6118F, 3.932F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone203.texOffs(68, 19).addBox(-3.25F, -6.1118F, 6.932F, 5.0F, 1.0F, 2.0F, 0.0F, false);
		bone203.texOffs(68, 16).addBox(-3.0F, -6.3618F, 9.182F, 5.0F, 1.0F, 2.0F, 0.0F, false);
		bone203.texOffs(42, 47).addBox(-6.0F, -5.9118F, 10.932F, 12.0F, 1.0F, 2.0F, 0.0F, false);
		bone203.texOffs(78, 5).addBox(-4.75F, -5.8868F, 7.182F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		bone203.texOffs(55, 69).addBox(2.5F, -5.9118F, 8.682F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bone203.texOffs(10, 71).addBox(2.25F, -5.8868F, 6.932F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		bone203.texOffs(68, 13).addBox(-2.5F, -5.8868F, 4.682F, 5.0F, 1.0F, 2.0F, 0.0F, false);
		bone203.texOffs(72, 4).addBox(-3.25F, -6.3618F, 3.682F, 2.0F, 1.0F, 2.0F, -0.25F, false);
		bone203.texOffs(72, 4).addBox(1.25F, -6.3618F, 3.682F, 2.0F, 1.0F, 2.0F, -0.25F, false);

		bone201 = new ModelRenderer(this);
		bone201.setPos(0.0F, -5.4118F, 11.932F);
		bone203.addChild(bone201);
		setRotationAngle(bone201, 0.6807F, 0.0F, 0.0F);
		

		control15 = new ModelRenderer(this);
		control15.setPos(3.5F, 4.975F, -5.8487F);
		bone201.addChild(control15);
		control15.texOffs(13, 67).addBox(-1.5F, -4.975F, 7.5987F, 5.0F, 1.0F, 3.0F, 0.0F, false);

		bone205 = new ModelRenderer(this);
		bone205.setPos(1.0F, -4.975F, 8.0987F);
		control15.addChild(bone205);
		setRotationAngle(bone205, 0.6109F, 0.0F, 0.0F);
		bone205.texOffs(69, 62).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		bone206 = new ModelRenderer(this);
		bone206.setPos(1.0F, -4.975F, 9.0987F);
		control15.addChild(bone206);
		setRotationAngle(bone206, 0.6109F, 0.0F, 0.0F);
		bone206.texOffs(68, 47).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		bone207 = new ModelRenderer(this);
		bone207.setPos(1.0F, -4.975F, 10.0987F);
		control15.addChild(bone207);
		setRotationAngle(bone207, 0.6109F, 0.0F, 0.0F);
		bone207.texOffs(42, 54).addBox(-2.75F, -1.0F, -1.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		control16 = new ModelRenderer(this);
		control16.setPos(-3.5F, -1.75F, 3.25F);
		bone201.addChild(control16);
		control16.texOffs(0, 70).addBox(-1.5F, -0.75F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		control16.texOffs(0, 66).addBox(-2.5F, 1.0F, -1.5F, 5.0F, 1.0F, 3.0F, 0.0F, false);

		control17 = new ModelRenderer(this);
		control17.setPos(0.5F, -1.3868F, 1.0833F);
		bone203.addChild(control17);
		control17.texOffs(9, 9).addBox(-5.5F, -5.975F, 8.5987F, 1.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bone208.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
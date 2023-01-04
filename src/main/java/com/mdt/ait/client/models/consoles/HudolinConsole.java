package com.mdt.ait.client.models.consoles;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class HudolinConsole extends DevConsole {
	private final ModelRenderer console_plinth_one;
	private final ModelRenderer corner_one_r1;
	private final ModelRenderer corner_one_r2;
	private final ModelRenderer corner_one_r3;
	private final ModelRenderer corner_one_r4;
	private final ModelRenderer corner_one_r5;
	private final ModelRenderer corner_one_r6;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer console_plinth_two;
	private final ModelRenderer corner_one_r7;
	private final ModelRenderer corner_one_r8;
	private final ModelRenderer corner_one_r9;
	private final ModelRenderer corner_one_r10;
	private final ModelRenderer corner_one_r11;
	private final ModelRenderer corner_one_r12;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer console_plinth_three;
	private final ModelRenderer corner_one_r13;
	private final ModelRenderer corner_one_r14;
	private final ModelRenderer corner_one_r15;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer clawlegs;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer clawlegs2;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer clawlegs3;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer under_console_struts;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer console_corners;
	private final ModelRenderer corner_r1;
	private final ModelRenderer corner_r2;
	private final ModelRenderer corner_r3;
	private final ModelRenderer corner_r4;
	private final ModelRenderer corner_r5;
	private final ModelRenderer corner_r6;
	private final ModelRenderer console_collar_one;
	private final ModelRenderer corner_one_r16;
	private final ModelRenderer corner_one_r17;
	private final ModelRenderer corner_one_r18;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer console_collar_two;
	private final ModelRenderer corner_one_r19;
	private final ModelRenderer corner_one_r20;
	private final ModelRenderer corner_one_r21;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer panel;
	private final ModelRenderer cube_r28;
	private final ModelRenderer panel2;
	private final ModelRenderer cube_r29;
	private final ModelRenderer panel3;
	private final ModelRenderer cube_r30;
	private final ModelRenderer panel4;
	private final ModelRenderer cube_r31;
	private final ModelRenderer panel5;
	private final ModelRenderer cube_r32;
	private final ModelRenderer panel6;
	private final ModelRenderer cube_r33;
	private final ModelRenderer bone2;
	private final ModelRenderer corner_r7;
	private final ModelRenderer corner_r8;
	private final ModelRenderer bone3;
	private final ModelRenderer corner_r9;
	private final ModelRenderer corner_r10;
	private final ModelRenderer bone4;
	private final ModelRenderer corner_r11;
	private final ModelRenderer corner_r12;
	private final ModelRenderer bone;
	private final ModelRenderer ThrottleBase_r1;
	private final ModelRenderer cube_r34;
	private final ModelRenderer base;
	private final ModelRenderer cube_r35;
	private final ModelRenderer cube_r36;
	private final ModelRenderer cube_r37;
	private final ModelRenderer cube_r38;
	private final ModelRenderer cube_r39;
	private final ModelRenderer bottom_rotor;
	private final ModelRenderer cube_r40;
	private final ModelRenderer cube_r41;
	private final ModelRenderer cube_r42;
	private final ModelRenderer cube_r43;
	private final ModelRenderer cube_r44;
	private final ModelRenderer cube_r45;
	private final ModelRenderer cube_r46;
	private final ModelRenderer top_rotor;
	private final ModelRenderer cube_r47;
	private final ModelRenderer cube_r48;
	private final ModelRenderer cube_r49;
	private final ModelRenderer cube_r50;
	private final ModelRenderer cube_r51;
	private final ModelRenderer upper_console_one;
	private final ModelRenderer corner_one_r22;
	private final ModelRenderer corner_one_r23;
	private final ModelRenderer corner_one_r24;
	private final ModelRenderer cube_r52;
	private final ModelRenderer cube_r53;
	private final ModelRenderer cube_r54;
	private final ModelRenderer upper_console_two;
	private final ModelRenderer corner_one_r25;
	private final ModelRenderer corner_one_r26;
	private final ModelRenderer corner_one_r27;
	private final ModelRenderer cube_r55;
	private final ModelRenderer cube_r56;
	private final ModelRenderer cube_r57;
	private final ModelRenderer ConsoleCollarTwo3;
	private final ModelRenderer corner_one_r28;
	private final ModelRenderer corner_one_r29;
	private final ModelRenderer corner_one_r30;
	private final ModelRenderer cube_r58;
	private final ModelRenderer cube_r59;
	private final ModelRenderer cube_r60;
	private final ModelRenderer ConsoleCollarOne6;
	private final ModelRenderer corner_one_r31;
	private final ModelRenderer corner_one_r32;
	private final ModelRenderer corner_one_r33;
	private final ModelRenderer cube_r61;
	private final ModelRenderer cube_r62;
	private final ModelRenderer cube_r63;
	private final ModelRenderer panel_two_glowies;
	private final ModelRenderer cube_r64;
	private final ModelRenderer panel_three_lights;
	private final ModelRenderer cube_r65;
	private final ModelRenderer bone5;
	private final ModelRenderer cube_r66;
	private final ModelRenderer bone6;
	private final ModelRenderer lights_right_r1;
	private final ModelRenderer dials;
	private final ModelRenderer cube_r67;
	private final ModelRenderer crank_lever;
	private final ModelRenderer base_r1;
	private final ModelRenderer lever_section_1_r1;
	private final ModelRenderer lever_section_2_r1;
	private final ModelRenderer bone7;
	private final ModelRenderer base_r2;
	private final ModelRenderer switches_r1;
	private final ModelRenderer buttons;
	private final ModelRenderer base_r3;
	private final ModelRenderer cube_r68;
	private final ModelRenderer control_two;
	private final ModelRenderer cube_r69;
	private final ModelRenderer control_three;
	private final ModelRenderer cube_r70;
	private final ModelRenderer control_four;
	private final ModelRenderer cube_r71;
	private final ModelRenderer cube_r72;
	private final ModelRenderer bone8;
	private final ModelRenderer cube_r73;
	private final ModelRenderer bone9;
	private final ModelRenderer cube_r74;
	private final ModelRenderer bone10;
	private final ModelRenderer cube_r75;
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r76;
	private final ModelRenderer cube_r77;
	private final ModelRenderer cube_r78;
	private final ModelRenderer cube_r79;
	private final ModelRenderer cube_r80;
	private final ModelRenderer cube_r81;
	private final ModelRenderer cube_r82;
	private final ModelRenderer panel_three_small_lights_r1;

	public HudolinConsole() {
		texWidth = 256;
		texHeight = 256;

		console_plinth_one = new ModelRenderer(this);
		console_plinth_one.setPos(0.0F, -15.8F, 0.0F);
		

		corner_one_r1 = new ModelRenderer(this);
		corner_one_r1.setPos(0.0799F, 40.624F, 0.1534F);
		console_plinth_one.addChild(corner_one_r1);
		setRotationAngle(corner_one_r1, 0.0F, -0.576F, 0.0F);
		corner_one_r1.texOffs(75, 0).addBox(-0.093F, -1.817F, 9.9186F, 1.0F, 1.0F, 1.0F, 0.2F, false);

		corner_one_r2 = new ModelRenderer(this);
		corner_one_r2.setPos(0.0799F, 40.624F, 0.1534F);
		console_plinth_one.addChild(corner_one_r2);
		setRotationAngle(corner_one_r2, 0.0F, -0.4887F, 0.0F);
		corner_one_r2.texOffs(75, 0).addBox(-0.343F, -1.817F, -11.2564F, 1.0F, 1.0F, 1.0F, 0.2F, false);

		corner_one_r3 = new ModelRenderer(this);
		corner_one_r3.setPos(0.0799F, 40.624F, 0.1534F);
		console_plinth_one.addChild(corner_one_r3);
		setRotationAngle(corner_one_r3, 0.0F, 1.5272F, 0.0F);
		corner_one_r3.texOffs(75, 0).addBox(-0.093F, -1.817F, 9.9186F, 1.0F, 1.0F, 1.0F, 0.2F, false);

		corner_one_r4 = new ModelRenderer(this);
		corner_one_r4.setPos(0.0799F, 40.624F, 0.1534F);
		console_plinth_one.addChild(corner_one_r4);
		setRotationAngle(corner_one_r4, -3.1416F, 1.5272F, 3.1416F);
		corner_one_r4.texOffs(75, 0).addBox(-0.043F, -1.817F, -11.2564F, 1.0F, 1.0F, 1.0F, 0.2F, false);

		corner_one_r5 = new ModelRenderer(this);
		corner_one_r5.setPos(0.0799F, 40.624F, 0.1534F);
		console_plinth_one.addChild(corner_one_r5);
		setRotationAngle(corner_one_r5, 0.0F, 0.48F, 0.0F);
		corner_one_r5.texOffs(75, 0).addBox(-0.093F, -1.817F, 9.9186F, 1.0F, 1.0F, 1.0F, 0.2F, false);

		corner_one_r6 = new ModelRenderer(this);
		corner_one_r6.setPos(0.0799F, 40.624F, 0.1534F);
		console_plinth_one.addChild(corner_one_r6);
		setRotationAngle(corner_one_r6, 0.0F, 0.5672F, 0.0F);
		corner_one_r6.texOffs(75, 0).addBox(-0.043F, -1.817F, -11.2564F, 1.0F, 1.0F, 1.0F, 0.2F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 42.064F, 0.0F);
		console_plinth_one.addChild(cube_r1);
		setRotationAngle(cube_r1, -3.1416F, 1.0472F, 3.1416F);
		cube_r1.texOffs(41, 74).addBox(-4.9363F, -3.279F, -10.0349F, 10.0F, 1.0F, 20.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, 42.064F, 0.0F);
		console_plinth_one.addChild(cube_r2);
		setRotationAngle(cube_r2, -3.1416F, -1.0472F, 3.1416F);
		cube_r2.texOffs(41, 74).addBox(-4.9363F, -3.279F, -10.0349F, 10.0F, 1.0F, 20.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, 42.064F, 0.0F);
		console_plinth_one.addChild(cube_r3);
		setRotationAngle(cube_r3, -3.1416F, 0.0F, 3.1416F);
		cube_r3.texOffs(41, 74).addBox(-4.9363F, -3.279F, -10.0349F, 10.0F, 1.0F, 20.0F, 0.0F, false);

		console_plinth_two = new ModelRenderer(this);
		console_plinth_two.setPos(0.0F, -0.7F, 0.0F);
		

		corner_one_r7 = new ModelRenderer(this);
		corner_one_r7.setPos(-0.0626F, 22.575F, 0.0698F);
		console_plinth_two.addChild(corner_one_r7);
		setRotationAngle(corner_one_r7, 0.0F, -0.5236F, 0.0F);
		corner_one_r7.texOffs(147, 77).addBox(-0.45F, -1.0F, -9.0121F, 1.0F, 3.0F, 1.0F, 0.1F, false);

		corner_one_r8 = new ModelRenderer(this);
		corner_one_r8.setPos(-8.3255F, 23.075F, 0.0198F);
		console_plinth_two.addChild(corner_one_r8);
		setRotationAngle(corner_one_r8, 0.0F, 1.5708F, 0.0F);
		corner_one_r8.texOffs(75, 148).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.1F, false);

		corner_one_r9 = new ModelRenderer(this);
		corner_one_r9.setPos(0.0874F, 22.575F, 0.0698F);
		console_plinth_two.addChild(corner_one_r9);
		setRotationAngle(corner_one_r9, 0.0F, -1.5708F, 0.0F);
		corner_one_r9.texOffs(150, 87).addBox(-0.55F, -1.0F, -8.7621F, 1.0F, 3.0F, 1.0F, 0.1F, false);

		corner_one_r10 = new ModelRenderer(this);
		corner_one_r10.setPos(0.0624F, 22.575F, 0.1198F);
		console_plinth_two.addChild(corner_one_r10);
		setRotationAngle(corner_one_r10, 0.0F, 0.5236F, 0.0F);
		corner_one_r10.texOffs(9, 152).addBox(-0.45F, -1.0F, -8.9871F, 1.0F, 3.0F, 1.0F, 0.1F, false);

		corner_one_r11 = new ModelRenderer(this);
		corner_one_r11.setPos(4.17F, 23.075F, 7.2307F);
		console_plinth_two.addChild(corner_one_r11);
		setRotationAngle(corner_one_r11, 0.0F, -2.618F, 0.0F);
		corner_one_r11.texOffs(42, 152).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.1F, false);

		corner_one_r12 = new ModelRenderer(this);
		corner_one_r12.setPos(-4.1862F, 23.075F, 7.3157F);
		console_plinth_two.addChild(corner_one_r12);
		setRotationAngle(corner_one_r12, 0.0F, 2.618F, 0.0F);
		corner_one_r12.texOffs(75, 153).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.1F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(0.0F, 23.7F, 0.0F);
		console_plinth_two.addChild(cube_r4);
		setRotationAngle(cube_r4, -3.1416F, 1.0472F, 3.1416F);
		cube_r4.texOffs(138, 67).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 3.0F, 16.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(0.0F, 23.7F, 0.0F);
		console_plinth_two.addChild(cube_r5);
		setRotationAngle(cube_r5, -3.1416F, -1.0472F, 3.1416F);
		cube_r5.texOffs(0, 142).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 3.0F, 16.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.0F, 23.7F, 0.0F);
		console_plinth_two.addChild(cube_r6);
		setRotationAngle(cube_r6, -3.1416F, 0.0F, 3.1416F);
		cube_r6.texOffs(142, 87).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 3.0F, 16.0F, 0.0F, false);

		console_plinth_three = new ModelRenderer(this);
		console_plinth_three.setPos(0.0F, -15.6F, 0.0F);
		

		corner_one_r13 = new ModelRenderer(this);
		corner_one_r13.setPos(-0.0626F, 23.575F, 0.0698F);
		console_plinth_three.addChild(corner_one_r13);
		setRotationAngle(corner_one_r13, 0.0F, -0.5236F, 0.0F);
		corner_one_r13.texOffs(82, 116).addBox(-0.45F, -1.0F, -9.0121F, 1.0F, 3.0F, 1.0F, 0.1F, false);
		corner_one_r13.texOffs(145, 0).addBox(-0.4482F, -1.0F, 7.837F, 1.0F, 3.0F, 1.0F, 0.1F, false);

		corner_one_r14 = new ModelRenderer(this);
		corner_one_r14.setPos(0.0874F, 23.575F, 0.0698F);
		console_plinth_three.addChild(corner_one_r14);
		setRotationAngle(corner_one_r14, 0.0F, -1.5708F, 0.0F);
		corner_one_r14.texOffs(9, 120).addBox(-0.55F, -1.0F, 7.9129F, 1.0F, 3.0F, 1.0F, 0.1F, false);
		corner_one_r14.texOffs(120, 25).addBox(-0.55F, -1.0F, -8.7621F, 1.0F, 3.0F, 1.0F, 0.1F, false);

		corner_one_r15 = new ModelRenderer(this);
		corner_one_r15.setPos(0.0624F, 23.575F, 0.1198F);
		console_plinth_three.addChild(corner_one_r15);
		setRotationAngle(corner_one_r15, 0.0F, 0.5236F, 0.0F);
		corner_one_r15.texOffs(115, 134).addBox(-0.45F, -1.0F, -8.9871F, 1.0F, 3.0F, 1.0F, 0.1F, false);
		corner_one_r15.texOffs(142, 144).addBox(-0.4982F, -1.0F, 7.712F, 1.0F, 3.0F, 1.0F, 0.1F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(0.0F, 24.7F, 0.0F);
		console_plinth_three.addChild(cube_r7);
		setRotationAngle(cube_r7, -3.1416F, 1.0472F, 3.1416F);
		cube_r7.texOffs(120, 5).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 3.0F, 16.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(0.0F, 24.7F, 0.0F);
		console_plinth_three.addChild(cube_r8);
		setRotationAngle(cube_r8, -3.1416F, -1.0472F, 3.1416F);
		cube_r8.texOffs(82, 134).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 3.0F, 16.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setPos(0.0F, 24.7F, 0.0F);
		console_plinth_three.addChild(cube_r9);
		setRotationAngle(cube_r9, -3.1416F, 0.0F, 3.1416F);
		cube_r9.texOffs(131, 134).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 3.0F, 16.0F, 0.0F, false);

		clawlegs = new ModelRenderer(this);
		clawlegs.setPos(-6.1919F, 28.3721F, 4.0453F);
		

		cube_r10 = new ModelRenderer(this);
		cube_r10.setPos(0.0F, 0.0F, 0.0F);
		clawlegs.addChild(cube_r10);
		setRotationAngle(cube_r10, 3.1416F, -0.5236F, 3.1416F);
		cube_r10.texOffs(120, 154).addBox(5.882F, -6.86F, -0.886F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r10.texOffs(98, 116).addBox(2.902F, -6.92F, -0.901F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setPos(-0.5853F, -7.6123F, 0.2412F);
		clawlegs.addChild(cube_r11);
		setRotationAngle(cube_r11, -2.8274F, -0.4363F, 2.5133F);
		cube_r11.texOffs(49, 127).addBox(-0.5F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setPos(0.2901F, -9.0239F, -0.3154F);
		clawlegs.addChild(cube_r12);
		setRotationAngle(cube_r12, -2.5871F, 0.0F, 1.5646F);
		cube_r12.texOffs(96, 59).addBox(-2.0F, -1.2F, -1.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		clawlegs2 = new ModelRenderer(this);
		clawlegs2.setPos(0.0081F, 28.3721F, -7.1797F);
		setRotationAngle(clawlegs2, 0.0F, -2.0944F, 0.0F);
		

		cube_r13 = new ModelRenderer(this);
		cube_r13.setPos(0.0F, 0.0F, 0.0F);
		clawlegs2.addChild(cube_r13);
		setRotationAngle(cube_r13, 3.1416F, -0.5236F, 3.1416F);
		cube_r13.texOffs(51, 74).addBox(5.882F, -6.86F, -0.886F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r13.texOffs(97, 45).addBox(2.902F, -6.92F, -0.901F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setPos(-0.5853F, -7.6123F, 0.2412F);
		clawlegs2.addChild(cube_r14);
		setRotationAngle(cube_r14, -2.8274F, -0.4363F, 2.5133F);
		cube_r14.texOffs(95, 125).addBox(-0.5F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setPos(0.2901F, -9.0239F, -0.3154F);
		clawlegs2.addChild(cube_r15);
		setRotationAngle(cube_r15, -2.5871F, 0.0F, 1.5646F);
		cube_r15.texOffs(96, 53).addBox(-2.0F, -1.2F, -1.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		clawlegs3 = new ModelRenderer(this);
		clawlegs3.setPos(6.4081F, 28.3721F, 3.8203F);
		setRotationAngle(clawlegs3, 0.0F, 2.0944F, 0.0F);
		

		cube_r16 = new ModelRenderer(this);
		cube_r16.setPos(0.0F, 0.0F, 0.0F);
		clawlegs3.addChild(cube_r16);
		setRotationAngle(cube_r16, 3.1416F, -0.5236F, 3.1416F);
		cube_r16.texOffs(11, 72).addBox(5.882F, -6.86F, -0.886F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r16.texOffs(91, 96).addBox(2.902F, -6.92F, -0.901F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setPos(-0.5853F, -7.6123F, 0.2412F);
		clawlegs3.addChild(cube_r17);
		setRotationAngle(cube_r17, -2.8274F, -0.4363F, 2.5133F);
		cube_r17.texOffs(33, 121).addBox(-0.5F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setPos(0.2901F, -9.0239F, -0.3154F);
		clawlegs3.addChild(cube_r18);
		setRotationAngle(cube_r18, -2.5871F, 0.0F, 1.5646F);
		cube_r18.texOffs(82, 81).addBox(-2.0F, -1.2F, -1.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		under_console_struts = new ModelRenderer(this);
		under_console_struts.setPos(-0.075F, 24.8F, 0.0F);
		

		cube_r19 = new ModelRenderer(this);
		cube_r19.setPos(0.0F, 0.0F, 0.0F);
		under_console_struts.addChild(cube_r19);
		setRotationAngle(cube_r19, -0.6981F, 2.0944F, 0.0F);
		cube_r19.texOffs(0, 110).addBox(-1.137F, -22.28F, -2.62F, 2.0F, 13.0F, 2.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setPos(0.0F, 0.0F, 0.0F);
		under_console_struts.addChild(cube_r20);
		setRotationAngle(cube_r20, -0.6981F, -2.0944F, 0.0F);
		cube_r20.texOffs(120, 0).addBox(-1.037F, -22.28F, -2.62F, 2.0F, 13.0F, 2.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setPos(0.0F, 0.0F, 0.0F);
		under_console_struts.addChild(cube_r21);
		setRotationAngle(cube_r21, -0.6981F, 0.0F, 0.0F);
		cube_r21.texOffs(148, 154).addBox(-1.037F, -22.28F, -2.62F, 2.0F, 13.0F, 2.0F, 0.0F, false);

		console_corners = new ModelRenderer(this);
		console_corners.setPos(0.0F, 29.018F, -10.66F);
		

		corner_r1 = new ModelRenderer(this);
		corner_r1.setPos(-0.1F, -21.218F, 10.66F);
		console_corners.addChild(corner_r1);
		setRotationAngle(corner_r1, 0.0F, -1.0079F, 0.0F);
		corner_r1.texOffs(49, 121).addBox(-24.5574F, -1.0F, -2.4577F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		corner_r2 = new ModelRenderer(this);
		corner_r2.setPos(-0.1F, -21.218F, 10.66F);
		console_corners.addChild(corner_r2);
		setRotationAngle(corner_r2, -3.1416F, 1.0036F, 3.1416F);
		corner_r2.texOffs(112, 108).addBox(-24.5574F, -1.0F, -2.4577F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		corner_r3 = new ModelRenderer(this);
		corner_r3.setPos(-0.1F, -21.218F, 10.66F);
		console_corners.addChild(corner_r3);
		setRotationAngle(corner_r3, -3.1416F, -1.0865F, 3.1416F);
		corner_r3.texOffs(0, 101).addBox(-24.5574F, -1.0F, -2.4577F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		corner_r4 = new ModelRenderer(this);
		corner_r4.setPos(-0.1F, -21.218F, 10.66F);
		console_corners.addChild(corner_r4);
		setRotationAngle(corner_r4, 0.0F, 1.0908F, 0.0F);
		corner_r4.texOffs(56, 101).addBox(-24.5574F, -1.0F, -2.4577F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		corner_r5 = new ModelRenderer(this);
		corner_r5.setPos(23.0F, -21.218F, 10.56F);
		console_corners.addChild(corner_r5);
		setRotationAngle(corner_r5, -3.1416F, 0.0428F, 3.1416F);
		corner_r5.texOffs(112, 102).addBox(-1.475F, -1.0F, -1.55F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		corner_r6 = new ModelRenderer(this);
		corner_r6.setPos(-23.2F, -21.218F, 10.76F);
		console_corners.addChild(corner_r6);
		setRotationAngle(corner_r6, 0.0F, 0.0436F, 0.0F);
		corner_r6.texOffs(82, 125).addBox(-1.475F, -1.0F, -1.55F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		console_collar_one = new ModelRenderer(this);
		console_collar_one.setPos(0.0F, -3.5F, 0.0F);
		

		corner_one_r16 = new ModelRenderer(this);
		corner_one_r16.setPos(-0.0626F, 2.575F, 0.0698F);
		console_collar_one.addChild(corner_one_r16);
		setRotationAngle(corner_one_r16, 0.0F, -0.5236F, 0.0F);
		corner_one_r16.texOffs(162, 4).addBox(-0.45F, -1.0F, -9.0121F, 1.0F, 2.0F, 1.0F, 0.1F, false);
		corner_one_r16.texOffs(162, 0).addBox(-0.4482F, -1.0F, 7.837F, 1.0F, 2.0F, 1.0F, 0.1F, false);

		corner_one_r17 = new ModelRenderer(this);
		corner_one_r17.setPos(0.0874F, 2.575F, 0.0698F);
		console_collar_one.addChild(corner_one_r17);
		setRotationAngle(corner_one_r17, 0.0F, -1.5708F, 0.0F);
		corner_one_r17.texOffs(161, 44).addBox(-0.55F, -1.0F, 7.9129F, 1.0F, 2.0F, 1.0F, 0.1F, false);
		corner_one_r17.texOffs(161, 53).addBox(-0.55F, -1.0F, -8.7621F, 1.0F, 2.0F, 1.0F, 0.1F, false);

		corner_one_r18 = new ModelRenderer(this);
		corner_one_r18.setPos(0.0624F, 2.575F, 0.1198F);
		console_collar_one.addChild(corner_one_r18);
		setRotationAngle(corner_one_r18, 0.0F, 0.5236F, 0.0F);
		corner_one_r18.texOffs(161, 107).addBox(-0.45F, -1.0F, -8.9871F, 1.0F, 2.0F, 1.0F, 0.1F, false);
		corner_one_r18.texOffs(0, 162).addBox(-0.4982F, -1.0F, 7.712F, 1.0F, 2.0F, 1.0F, 0.1F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setPos(0.0F, 3.7F, 0.0F);
		console_collar_one.addChild(cube_r22);
		setRotationAngle(cube_r22, -3.1416F, 1.0472F, 3.1416F);
		cube_r22.texOffs(153, 0).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 2.0F, 16.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setPos(0.0F, 3.7F, 0.0F);
		console_collar_one.addChild(cube_r23);
		setRotationAngle(cube_r23, -3.1416F, -1.0472F, 3.1416F);
		cube_r23.texOffs(66, 154).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 2.0F, 16.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setPos(0.0F, 3.7F, 0.0F);
		console_collar_one.addChild(cube_r24);
		setRotationAngle(cube_r24, -3.1416F, 0.0F, 3.1416F);
		cube_r24.texOffs(115, 154).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 2.0F, 16.0F, 0.0F, false);

		console_collar_two = new ModelRenderer(this);
		console_collar_two.setPos(0.095F, 21.1F, -0.206F);
		

		corner_one_r19 = new ModelRenderer(this);
		corner_one_r19.setPos(-0.1576F, -22.925F, 0.2758F);
		console_collar_two.addChild(corner_one_r19);
		setRotationAngle(corner_one_r19, 0.0F, -0.5236F, 0.0F);
		corner_one_r19.texOffs(161, 30).addBox(-0.5232F, -2.65F, 5.687F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		corner_one_r19.texOffs(161, 25).addBox(-0.5232F, -2.65F, -6.788F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		corner_one_r20 = new ModelRenderer(this);
		corner_one_r20.setPos(-0.1576F, -22.925F, 0.2758F);
		console_collar_two.addChild(corner_one_r20);
		setRotationAngle(corner_one_r20, 0.0F, 0.5236F, 0.0F);
		corner_one_r20.texOffs(157, 158).addBox(-0.4482F, -2.65F, 5.687F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		corner_one_r20.texOffs(158, 128).addBox(-0.4482F, -2.65F, -6.763F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		corner_one_r21 = new ModelRenderer(this);
		corner_one_r21.setPos(-0.1576F, -22.925F, 0.2758F);
		console_collar_two.addChild(corner_one_r21);
		setRotationAngle(corner_one_r21, 0.0F, -1.5708F, 0.0F);
		corner_one_r21.texOffs(75, 158).addBox(-0.5482F, -2.65F, 5.687F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		corner_one_r21.texOffs(99, 154).addBox(-0.5732F, -2.65F, -6.738F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setPos(-0.403F, -21.14F, 0.338F);
		console_collar_two.addChild(cube_r25);
		setRotationAngle(cube_r25, -3.1416F, -2.0944F, 3.1416F);
		cube_r25.texOffs(171, 63).addBox(-2.96F, -4.418F, -6.282F, 6.0F, 3.0F, 12.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setPos(-0.403F, -21.14F, 0.338F);
		console_collar_two.addChild(cube_r26);
		setRotationAngle(cube_r26, -3.1416F, -1.0472F, 3.1416F);
		cube_r26.texOffs(62, 173).addBox(-3.26F, -4.418F, -6.182F, 6.0F, 3.0F, 12.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setPos(-0.403F, -21.14F, 0.338F);
		console_collar_two.addChild(cube_r27);
		setRotationAngle(cube_r27, -3.1416F, 0.0F, 3.1416F);
		cube_r27.texOffs(99, 173).addBox(-3.26F, -4.418F, -5.882F, 6.0F, 3.0F, 12.0F, 0.0F, false);

		panel = new ModelRenderer(this);
		panel.setPos(-0.0371F, 3.5283F, 0.0187F);
		panel.texOffs(60, 21).addBox(-11.0029F, 3.2697F, 6.9223F, 22.0F, 2.0F, 15.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setPos(1.0371F, -1.4283F, -0.8187F);
		panel.addChild(cube_r28);
		setRotationAngle(cube_r28, -0.7418F, 0.0F, 0.0F);
		cube_r28.texOffs(56, 102).addBox(-11.5F, -8.1965F, 2.9073F, 21.0F, 0.0F, 13.0F, 0.0F, false);

		panel2 = new ModelRenderer(this);
		panel2.setPos(-0.0371F, 3.5283F, 0.0187F);
		setRotationAngle(panel2, 0.0F, -1.0472F, 0.0F);
		panel2.texOffs(60, 3).addBox(-11.0029F, 3.2697F, 6.9223F, 22.0F, 2.0F, 15.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setPos(1.0371F, -2.2283F, -0.8187F);
		panel2.addChild(cube_r29);
		setRotationAngle(cube_r29, -0.7418F, 0.0F, 0.0F);
		cube_r29.texOffs(96, 53).addBox(-11.3F, -7.6067F, 3.4478F, 21.0F, 0.0F, 13.0F, 0.0F, false);

		panel3 = new ModelRenderer(this);
		panel3.setPos(-0.0371F, 3.5283F, 0.0187F);
		setRotationAngle(panel3, 0.0F, -2.0944F, 0.0F);
		panel3.texOffs(0, 54).addBox(-11.0029F, 3.2697F, 6.9223F, 22.0F, 2.0F, 15.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setPos(1.0371F, -2.2283F, -0.8187F);
		panel3.addChild(cube_r30);
		setRotationAngle(cube_r30, -0.7418F, 0.0F, 0.0F);
		cube_r30.texOffs(96, 39).addBox(-11.5F, -7.6067F, 3.4478F, 21.0F, 0.0F, 13.0F, 0.0F, false);

		panel4 = new ModelRenderer(this);
		panel4.setPos(-0.0371F, 3.5283F, 0.0187F);
		setRotationAngle(panel4, 0.0F, 3.1416F, 0.0F);
		panel4.texOffs(0, 36).addBox(-11.0029F, 3.2697F, 6.9223F, 22.0F, 2.0F, 15.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setPos(1.0371F, -2.2283F, -0.8187F);
		panel4.addChild(cube_r31);
		setRotationAngle(cube_r31, -0.7418F, 0.0F, 0.0F);
		cube_r31.texOffs(0, 96).addBox(-11.5F, -7.6067F, 3.4478F, 21.0F, 0.0F, 13.0F, 0.0F, false);

		panel5 = new ModelRenderer(this);
		panel5.setPos(-0.0371F, 3.5283F, 0.0187F);
		setRotationAngle(panel5, 0.0F, 2.0944F, 0.0F);
		panel5.texOffs(0, 18).addBox(-11.0029F, 3.2697F, 6.9223F, 22.0F, 2.0F, 15.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setPos(1.0371F, -2.2283F, -0.8187F);
		panel5.addChild(cube_r32);
		setRotationAngle(cube_r32, -0.7418F, 0.0F, 0.0F);
		cube_r32.texOffs(89, 88).addBox(-11.5F, -7.6067F, 3.4478F, 21.0F, 0.0F, 13.0F, 0.0F, false);

		panel6 = new ModelRenderer(this);
		panel6.setPos(-0.0371F, 3.5283F, 0.0187F);
		setRotationAngle(panel6, 0.0F, 1.0472F, 0.0F);
		panel6.texOffs(0, 0).addBox(-11.0029F, 3.2697F, 6.9223F, 22.0F, 2.0F, 15.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setPos(1.0371F, -2.2283F, -0.8187F);
		panel6.addChild(cube_r33);
		setRotationAngle(cube_r33, -0.7418F, 0.0F, 0.0F);
		cube_r33.texOffs(82, 74).addBox(-11.5F, -7.6067F, 3.4478F, 21.0F, 0.0F, 13.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setPos(9.9198F, 3.1201F, 5.6383F);
		setRotationAngle(bone2, 0.0F, 2.0944F, 0.0F);
		

		corner_r7 = new ModelRenderer(this);
		corner_r7.setPos(3.5917F, 0.0608F, 6.0529F);
		bone2.addChild(corner_r7);
		setRotationAngle(corner_r7, 0.9505F, 0.5656F, 1.2216F);
		corner_r7.texOffs(33, 142).addBox(-0.8153F, -6.5131F, -1.1135F, 3.0F, 14.0F, 1.0F, 0.0F, false);

		corner_r8 = new ModelRenderer(this);
		corner_r8.setPos(12.2802F, 2.7799F, -6.2383F);
		bone2.addChild(corner_r8);
		setRotationAngle(corner_r8, 0.0F, 0.0F, 0.9163F);
		corner_r8.texOffs(66, 148).addBox(-12.6048F, 4.064F, -0.0165F, 3.0F, 14.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setPos(-6.3884F, 3.2809F, 11.8912F);
		

		corner_r9 = new ModelRenderer(this);
		corner_r9.setPos(0.0F, 0.8F, 0.0F);
		bone3.addChild(corner_r9);
		setRotationAngle(corner_r9, 0.9505F, 0.5656F, 1.2216F);
		corner_r9.texOffs(152, 25).addBox(-1.45F, -7.0F, -0.9F, 3.0F, 14.0F, 1.0F, 0.0F, false);

		corner_r10 = new ModelRenderer(this);
		corner_r10.setPos(8.6884F, 3.5191F, -12.2912F);
		bone3.addChild(corner_r10);
		setRotationAngle(corner_r10, 0.0F, 0.0F, 0.9163F);
		corner_r10.texOffs(153, 0).addBox(-13.2395F, 3.577F, -0.0915F, 3.0F, 14.0F, 1.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setPos(-6.9884F, 3.2809F, -11.4088F);
		setRotationAngle(bone4, 0.0F, -2.0944F, 0.0F);
		

		corner_r11 = new ModelRenderer(this);
		corner_r11.setPos(0.0F, 0.0F, 0.0F);
		bone4.addChild(corner_r11);
		setRotationAngle(corner_r11, 0.9505F, 0.5656F, 1.2216F);
		corner_r11.texOffs(138, 67).addBox(-0.8153F, -6.5131F, -0.8885F, 3.0F, 14.0F, 1.0F, 0.0F, false);

		corner_r12 = new ModelRenderer(this);
		corner_r12.setPos(8.6884F, 2.7191F, -12.2912F);
		bone4.addChild(corner_r12);
		setRotationAngle(corner_r12, 0.0F, 0.0F, 0.9163F);
		corner_r12.texOffs(0, 142).addBox(-12.6048F, 4.064F, -0.0915F, 3.0F, 14.0F, 1.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setPos(6.6188F, 2.3504F, 12.4767F);
		bone.texOffs(0, 86).addBox(-3.8938F, 4.2336F, 4.7013F, 5.0F, 1.0F, 4.0F, 0.0F, false);
		bone.texOffs(41, 82).addBox(-13.7738F, 3.9336F, 4.6663F, 5.0F, 1.0F, 4.0F, 0.0F, false);
		bone.texOffs(113, 67).addBox(-13.2808F, 2.9736F, 5.1563F, 4.0F, 1.0F, 3.0F, 0.0F, false);
		bone.texOffs(53, 110).addBox(-3.4228F, 4.0536F, 5.1743F, 4.0F, 1.0F, 3.0F, 0.0F, false);

		ThrottleBase_r1 = new ModelRenderer(this);
		ThrottleBase_r1.setPos(-6.9538F, -0.6504F, -2.3367F);
		bone.addChild(ThrottleBase_r1);
		setRotationAngle(ThrottleBase_r1, -0.6981F, 0.0F, 0.0F);
		ThrottleBase_r1.texOffs(161, 35).addBox(-4.66F, -2.7F, 0.82F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setPos(-6.9538F, -0.6504F, -2.3367F);
		bone.addChild(cube_r34);
		setRotationAngle(cube_r34, -0.7418F, 0.0F, 0.0F);
		cube_r34.texOffs(136, 134).addBox(-3.64F, -0.6F, -2.62F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r34.texOffs(136, 134).addBox(2.36F, -0.6F, -2.62F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r34.texOffs(136, 134).addBox(-0.64F, -0.6F, -2.62F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r34.texOffs(96, 67).addBox(-2.74F, -0.6F, -0.02F, 7.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r34.texOffs(82, 88).addBox(-2.74F, -0.6F, 2.7F, 6.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r34.texOffs(134, 0).addBox(3.72F, -0.525F, 2.678F, 3.0F, 0.0F, 2.0F, 0.0F, false);
		cube_r34.texOffs(56, 96).addBox(-7.14F, -0.6F, 5.42F, 15.0F, 2.0F, 2.0F, 0.0F, false);

		base = new ModelRenderer(this);
		base.setPos(0.172F, 20.82F, -0.065F);
		base.texOffs(60, 0).addBox(-3.195F, -11.018F, 5.409F, 6.0F, 12.0F, 1.0F, 0.0F, false);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setPos(0.0F, 0.8F, 0.0F);
		base.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.0F, -1.0472F, 0.0F);
		cube_r35.texOffs(60, 54).addBox(-2.785F, -11.818F, 5.5F, 6.0F, 12.0F, 1.0F, 0.0F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setPos(-0.65F, 0.8F, 0.078F);
		base.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.0F, 1.0516F, 0.0F);
		cube_r36.texOffs(0, 54).addBox(-3.008F, -11.818F, 5.669F, 6.0F, 12.0F, 1.0F, 0.0F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setPos(-0.403F, 0.8F, 0.338F);
		base.addChild(cube_r37);
		setRotationAngle(cube_r37, -3.1416F, 1.0472F, 3.1416F);
		cube_r37.texOffs(0, 36).addBox(-3.035F, -11.818F, 5.5F, 6.0F, 12.0F, 1.0F, 0.0F, false);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setPos(-0.455F, 0.8F, 0.247F);
		base.addChild(cube_r38);
		setRotationAngle(cube_r38, -3.1416F, 0.0F, 3.1416F);
		cube_r38.texOffs(0, 18).addBox(-3.435F, -11.818F, 5.318F, 6.0F, 12.0F, 1.0F, 0.0F, false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setPos(-1.053F, 0.8F, 0.416F);
		base.addChild(cube_r39);
		setRotationAngle(cube_r39, -3.1416F, -1.0516F, 3.1416F);
		cube_r39.texOffs(0, 0).addBox(-3.737F, -11.818F, 4.603F, 6.0F, 12.0F, 1.0F, 0.0F, false);

		bottom_rotor = new ModelRenderer(this);
		bottom_rotor.setPos(-0.075F, 2.0F, -0.325F);
		bottom_rotor.texOffs(30, 183).addBox(2.16F, -15.16F, -1.56F, 1.0F, 16.0F, 1.0F, 0.0F, false);
		bottom_rotor.texOffs(15, 183).addBox(-2.04F, -15.16F, 3.12F, 1.0F, 16.0F, 1.0F, 0.0F, false);
		bottom_rotor.texOffs(124, 174).addBox(-3.174F, -9.84F, -3.765F, 6.0F, 1.0F, 8.0F, 0.0F, false);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setPos(-0.174F, -9.34F, 0.235F);
		bottom_rotor.addChild(cube_r40);
		setRotationAngle(cube_r40, 0.0F, 1.5708F, 0.0F);
		cube_r40.texOffs(99, 154).addBox(-3.0F, -0.5F, -4.0F, 6.0F, 1.0F, 8.0F, 0.0F, false);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setPos(-3.02F, -7.16F, 1.54F);
		bottom_rotor.addChild(cube_r41);
		setRotationAngle(cube_r41, 0.0F, 3.1416F, 0.0F);
		cube_r41.texOffs(5, 183).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 16.0F, 1.0F, 0.0F, false);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setPos(1.18F, -7.16F, 3.62F);
		bottom_rotor.addChild(cube_r42);
		setRotationAngle(cube_r42, 0.0F, -1.5708F, 0.0F);
		cube_r42.texOffs(10, 183).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 16.0F, 1.0F, 0.0F, false);

		cube_r43 = new ModelRenderer(this);
		cube_r43.setPos(2.66F, -7.16F, 1.54F);
		bottom_rotor.addChild(cube_r43);
		setRotationAngle(cube_r43, 0.0F, 1.5708F, 0.0F);
		cube_r43.texOffs(20, 183).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 16.0F, 1.0F, 0.0F, false);

		cube_r44 = new ModelRenderer(this);
		cube_r44.setPos(-3.02F, -7.16F, -1.06F);
		bottom_rotor.addChild(cube_r44);
		setRotationAngle(cube_r44, 0.0F, -1.5708F, 0.0F);
		cube_r44.texOffs(25, 183).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 16.0F, 1.0F, 0.0F, false);

		cube_r45 = new ModelRenderer(this);
		cube_r45.setPos(-1.54F, -7.16F, -3.14F);
		bottom_rotor.addChild(cube_r45);
		setRotationAngle(cube_r45, 0.0F, 1.5708F, 0.0F);
		cube_r45.texOffs(35, 183).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 16.0F, 1.0F, 0.0F, false);

		cube_r46 = new ModelRenderer(this);
		cube_r46.setPos(1.18F, -7.16F, -3.14F);
		bottom_rotor.addChild(cube_r46);
		setRotationAngle(cube_r46, 0.0F, 3.1416F, 0.0F);
		cube_r46.texOffs(40, 183).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 16.0F, 1.0F, 0.0F, false);

		top_rotor = new ModelRenderer(this);
		top_rotor.setPos(-0.325F, -32.0F, -0.325F);
		setRotationAngle(top_rotor, 0.0F, 0.0F, -3.1416F);
		top_rotor.texOffs(0, 183).addBox(-0.7151F, -15.16F, -3.7542F, 1.0F, 16.0F, 1.0F, 0.0F, false);
		top_rotor.texOffs(168, 182).addBox(-3.8004F, -15.16F, -0.2382F, 1.0F, 16.0F, 1.0F, 0.0F, false);
		top_rotor.texOffs(163, 182).addBox(2.5263F, -15.16F, -0.2626F, 1.0F, 16.0F, 1.0F, 0.0F, false);
		top_rotor.texOffs(158, 182).addBox(-0.459F, -15.16F, 3.1284F, 1.0F, 16.0F, 1.0F, 0.0F, false);
		top_rotor.texOffs(115, 134).addBox(-3.174F, -9.84F, -3.765F, 6.0F, 1.0F, 8.0F, 0.0F, false);

		cube_r47 = new ModelRenderer(this);
		cube_r47.setPos(-0.174F, -9.34F, 0.235F);
		top_rotor.addChild(cube_r47);
		setRotationAngle(cube_r47, 0.0F, 1.5708F, 0.0F);
		cube_r47.texOffs(120, 25).addBox(-3.0F, -0.5F, -4.0F, 6.0F, 1.0F, 8.0F, 0.0F, false);

		cube_r48 = new ModelRenderer(this);
		cube_r48.setPos(-2.3112F, -7.16F, 2.48F);
		top_rotor.addChild(cube_r48);
		setRotationAngle(cube_r48, 0.0F, 1.5708F, 0.0F);
		cube_r48.texOffs(129, 0).addBox(-0.5F, -8.0F, -0.4F, 1.0F, 16.0F, 1.0F, 0.0F, false);

		cube_r49 = new ModelRenderer(this);
		cube_r49.setPos(2.347F, -7.16F, 2.9981F);
		top_rotor.addChild(cube_r49);
		setRotationAngle(cube_r49, 0.0F, 1.5708F, 0.0F);
		cube_r49.texOffs(153, 182).addBox(-0.125F, -8.0F, -0.725F, 1.0F, 16.0F, 1.0F, 0.0F, false);

		cube_r50 = new ModelRenderer(this);
		cube_r50.setPos(2.137F, -7.16F, -1.9058F);
		top_rotor.addChild(cube_r50);
		setRotationAngle(cube_r50, 0.0F, 1.5708F, 0.0F);
		cube_r50.texOffs(173, 182).addBox(-0.275F, -8.0F, -0.5F, 1.0F, 16.0F, 1.0F, 0.0F, false);

		cube_r51 = new ModelRenderer(this);
		cube_r51.setPos(-2.5211F, -7.16F, -2.4239F);
		top_rotor.addChild(cube_r51);
		setRotationAngle(cube_r51, 0.0F, 1.5708F, 0.0F);
		cube_r51.texOffs(178, 182).addBox(-0.625F, -8.0F, -0.5F, 1.0F, 16.0F, 1.0F, 0.0F, false);

		upper_console_one = new ModelRenderer(this);
		upper_console_one.setPos(-0.205F, -76.2F, -0.206F);
		setRotationAngle(upper_console_one, 0.0F, 0.0F, -3.1416F);
		

		corner_one_r22 = new ModelRenderer(this);
		corner_one_r22.setPos(-0.1576F, -47.925F, 0.2758F);
		upper_console_one.addChild(corner_one_r22);
		setRotationAngle(corner_one_r22, 0.0F, -0.5236F, 0.0F);
		corner_one_r22.texOffs(60, 21).addBox(-0.5232F, -2.65F, 5.687F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		corner_one_r22.texOffs(69, 21).addBox(-0.5232F, -2.65F, -6.788F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		corner_one_r23 = new ModelRenderer(this);
		corner_one_r23.setPos(-0.1576F, -47.925F, 0.2758F);
		upper_console_one.addChild(corner_one_r23);
		setRotationAngle(corner_one_r23, 0.0F, 0.5236F, 0.0F);
		corner_one_r23.texOffs(82, 74).addBox(-0.4482F, -2.65F, 5.687F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		corner_one_r23.texOffs(90, 74).addBox(-0.4482F, -2.65F, -6.763F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		corner_one_r24 = new ModelRenderer(this);
		corner_one_r24.setPos(-0.1576F, -47.925F, 0.2758F);
		upper_console_one.addChild(corner_one_r24);
		setRotationAngle(corner_one_r24, 0.0F, -1.5708F, 0.0F);
		corner_one_r24.texOffs(0, 94).addBox(-0.5482F, -2.65F, 5.687F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		corner_one_r24.texOffs(8, 94).addBox(-0.5732F, -2.65F, -6.738F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r52 = new ModelRenderer(this);
		cube_r52.setPos(-0.403F, -46.14F, 0.338F);
		upper_console_one.addChild(cube_r52);
		setRotationAngle(cube_r52, -3.1416F, -2.0944F, 3.1416F);
		cube_r52.texOffs(164, 128).addBox(-2.96F, -4.418F, -6.282F, 6.0F, 3.0F, 12.0F, 0.0F, false);

		cube_r53 = new ModelRenderer(this);
		cube_r53.setPos(-0.403F, -46.14F, 0.338F);
		upper_console_one.addChild(cube_r53);
		setRotationAngle(cube_r53, -3.1416F, -1.0472F, 3.1416F);
		cube_r53.texOffs(37, 167).addBox(-3.26F, -4.418F, -6.182F, 6.0F, 3.0F, 12.0F, 0.0F, false);

		cube_r54 = new ModelRenderer(this);
		cube_r54.setPos(-0.403F, -46.14F, 0.338F);
		upper_console_one.addChild(cube_r54);
		setRotationAngle(cube_r54, -3.1416F, 0.0F, 3.1416F);
		cube_r54.texOffs(168, 144).addBox(-3.26F, -4.418F, -5.882F, 6.0F, 3.0F, 12.0F, 0.0F, false);

		upper_console_two = new ModelRenderer(this);
		upper_console_two.setPos(0.0F, -54.5F, 0.0F);
		setRotationAngle(upper_console_two, 3.1416F, 0.0F, 0.0F);
		

		corner_one_r25 = new ModelRenderer(this);
		corner_one_r25.setPos(-0.0626F, -25.425F, 0.0698F);
		upper_console_two.addChild(corner_one_r25);
		setRotationAngle(corner_one_r25, 0.0F, -0.5236F, 0.0F);
		corner_one_r25.texOffs(56, 82).addBox(-0.45F, -1.0F, -9.0121F, 1.0F, 2.0F, 1.0F, 0.1F, false);
		corner_one_r25.texOffs(160, 48).addBox(-0.4482F, -1.0F, 7.837F, 1.0F, 2.0F, 1.0F, 0.1F, false);

		corner_one_r26 = new ModelRenderer(this);
		corner_one_r26.setPos(0.0874F, -25.425F, 0.0698F);
		upper_console_two.addChild(corner_one_r26);
		setRotationAngle(corner_one_r26, 0.0F, -1.5708F, 0.0F);
		corner_one_r26.texOffs(15, 86).addBox(-0.55F, -1.0F, 7.9129F, 1.0F, 2.0F, 1.0F, 0.1F, false);
		corner_one_r26.texOffs(104, 39).addBox(-0.55F, -1.0F, -8.7621F, 1.0F, 2.0F, 1.0F, 0.1F, false);

		corner_one_r27 = new ModelRenderer(this);
		corner_one_r27.setPos(0.0624F, -25.425F, 0.1198F);
		upper_console_two.addChild(corner_one_r27);
		setRotationAngle(corner_one_r27, 0.0F, 0.5236F, 0.0F);
		corner_one_r27.texOffs(144, 35).addBox(-0.45F, -1.0F, -8.9871F, 1.0F, 2.0F, 1.0F, 0.1F, false);
		corner_one_r27.texOffs(150, 92).addBox(-0.4982F, -1.0F, 7.712F, 1.0F, 2.0F, 1.0F, 0.1F, false);

		cube_r55 = new ModelRenderer(this);
		cube_r55.setPos(0.0F, -24.3F, 0.0F);
		upper_console_two.addChild(cube_r55);
		setRotationAngle(cube_r55, -3.1416F, 1.0472F, 3.1416F);
		cube_r55.texOffs(33, 148).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 2.0F, 16.0F, 0.0F, false);

		cube_r56 = new ModelRenderer(this);
		cube_r56.setPos(0.0F, -24.3F, 0.0F);
		upper_console_two.addChild(cube_r56);
		setRotationAngle(cube_r56, -3.1416F, -1.0472F, 3.1416F);
		cube_r56.texOffs(152, 25).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 2.0F, 16.0F, 0.0F, false);

		cube_r57 = new ModelRenderer(this);
		cube_r57.setPos(0.0F, -24.3F, 0.0F);
		upper_console_two.addChild(cube_r57);
		setRotationAngle(cube_r57, -3.1416F, 0.0F, 3.1416F);
		cube_r57.texOffs(152, 44).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 2.0F, 16.0F, 0.0F, false);

		ConsoleCollarTwo3 = new ModelRenderer(this);
		ConsoleCollarTwo3.setPos(0.095F, 21.1F, -0.206F);
		

		corner_one_r28 = new ModelRenderer(this);
		corner_one_r28.setPos(-0.1576F, -50.925F, 0.2758F);
		ConsoleCollarTwo3.addChild(corner_one_r28);
		setRotationAngle(corner_one_r28, 0.0F, -0.5236F, 0.0F);
		corner_one_r28.texOffs(9, 142).addBox(-0.5232F, -7.65F, 5.687F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		corner_one_r28.texOffs(42, 142).addBox(-0.5232F, -7.65F, -6.788F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		corner_one_r29 = new ModelRenderer(this);
		corner_one_r29.setPos(-0.1576F, -50.925F, 0.2758F);
		ConsoleCollarTwo3.addChild(corner_one_r29);
		setRotationAngle(corner_one_r29, 0.0F, 0.5236F, 0.0F);
		corner_one_r29.texOffs(142, 107).addBox(-0.4482F, -7.65F, 5.687F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		corner_one_r29.texOffs(145, 88).addBox(-0.4482F, -7.65F, -6.763F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		corner_one_r30 = new ModelRenderer(this);
		corner_one_r30.setPos(-0.1576F, -50.925F, 0.2758F);
		ConsoleCollarTwo3.addChild(corner_one_r30);
		setRotationAngle(corner_one_r30, 0.0F, -1.5708F, 0.0F);
		corner_one_r30.texOffs(147, 67).addBox(-0.5482F, -7.65F, 5.687F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		corner_one_r30.texOffs(9, 110).addBox(-0.5732F, -7.65F, -6.738F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		cube_r58 = new ModelRenderer(this);
		cube_r58.setPos(-0.403F, -49.14F, 0.338F);
		ConsoleCollarTwo3.addChild(cube_r58);
		setRotationAngle(cube_r58, -3.1416F, -2.0944F, 3.1416F);
		cube_r58.texOffs(158, 107).addBox(-2.96F, -9.418F, -6.282F, 6.0F, 8.0F, 12.0F, 0.0F, false);

		cube_r59 = new ModelRenderer(this);
		cube_r59.setPos(-0.403F, -49.14F, 0.338F);
		ConsoleCollarTwo3.addChild(cube_r59);
		setRotationAngle(cube_r59, -3.1416F, -1.0472F, 3.1416F);
		cube_r59.texOffs(152, 161).addBox(-3.26F, -9.418F, -6.182F, 6.0F, 8.0F, 12.0F, 0.0F, false);

		cube_r60 = new ModelRenderer(this);
		cube_r60.setPos(-0.403F, -49.14F, 0.338F);
		ConsoleCollarTwo3.addChild(cube_r60);
		setRotationAngle(cube_r60, -3.1416F, 0.0F, 3.1416F);
		cube_r60.texOffs(0, 162).addBox(-3.26F, -9.418F, -5.882F, 6.0F, 8.0F, 12.0F, 0.0F, false);

		ConsoleCollarOne6 = new ModelRenderer(this);
		ConsoleCollarOne6.setPos(0.0F, -50.5F, 0.0F);
		setRotationAngle(ConsoleCollarOne6, 3.1416F, 0.0F, 0.0F);
		

		corner_one_r31 = new ModelRenderer(this);
		corner_one_r31.setPos(-0.0626F, -16.425F, 0.0698F);
		ConsoleCollarOne6.addChild(corner_one_r31);
		setRotationAngle(corner_one_r31, 0.0F, -0.5236F, 0.0F);
		corner_one_r31.texOffs(45, 183).addBox(-0.45F, -1.0F, -9.0121F, 1.0F, 11.0F, 1.0F, 0.1F, false);
		corner_one_r31.texOffs(141, 184).addBox(-0.4482F, -1.0F, 7.837F, 1.0F, 11.0F, 1.0F, 0.1F, false);

		corner_one_r32 = new ModelRenderer(this);
		corner_one_r32.setPos(0.0874F, -16.425F, 0.0698F);
		ConsoleCollarOne6.addChild(corner_one_r32);
		setRotationAngle(corner_one_r32, 0.0F, -1.5708F, 0.0F);
		corner_one_r32.texOffs(50, 183).addBox(-0.55F, -1.0F, 7.9129F, 1.0F, 11.0F, 1.0F, 0.1F, false);
		corner_one_r32.texOffs(55, 183).addBox(-0.55F, -1.0F, -8.7621F, 1.0F, 11.0F, 1.0F, 0.1F, false);

		corner_one_r33 = new ModelRenderer(this);
		corner_one_r33.setPos(0.0624F, -16.425F, 0.1198F);
		ConsoleCollarOne6.addChild(corner_one_r33);
		setRotationAngle(corner_one_r33, 0.0F, 0.5236F, 0.0F);
		corner_one_r33.texOffs(183, 182).addBox(-0.45F, -1.0F, -8.9871F, 1.0F, 11.0F, 1.0F, 0.1F, false);
		corner_one_r33.texOffs(136, 184).addBox(-0.4982F, -1.0F, 7.712F, 1.0F, 11.0F, 1.0F, 0.1F, false);

		cube_r61 = new ModelRenderer(this);
		cube_r61.setPos(0.0F, -15.3F, 0.0F);
		ConsoleCollarOne6.addChild(cube_r61);
		setRotationAngle(cube_r61, -3.1416F, 1.0472F, 3.1416F);
		cube_r61.texOffs(109, 102).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 11.0F, 16.0F, 0.0F, false);

		cube_r62 = new ModelRenderer(this);
		cube_r62.setPos(0.0F, -15.3F, 0.0F);
		ConsoleCollarOne6.addChild(cube_r62);
		setRotationAngle(cube_r62, -3.1416F, -1.0472F, 3.1416F);
		cube_r62.texOffs(0, 110).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 11.0F, 16.0F, 0.0F, false);

		cube_r63 = new ModelRenderer(this);
		cube_r63.setPos(0.0F, -15.3F, 0.0F);
		ConsoleCollarOne6.addChild(cube_r63);
		setRotationAngle(cube_r63, -3.1416F, 0.0F, 3.1416F);
		cube_r63.texOffs(49, 116).addBox(-4.044F, -2.218F, -7.996F, 8.0F, 11.0F, 16.0F, 0.0F, false);

		panel_two_glowies = new ModelRenderer(this);
		panel_two_glowies.setPos(1.0F, 1.3F, -0.8F);
		

		cube_r64 = new ModelRenderer(this);
		cube_r64.setPos(0.0F, 0.0F, 0.0F);
		panel_two_glowies.addChild(cube_r64);
		setRotationAngle(cube_r64, -0.7418F, -1.0472F, 0.0F);
		cube_r64.texOffs(109, 213).addBox(-1.8F, -8.1567F, 6.2478F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r64.texOffs(109, 210).addBox(-1.8F, -8.1567F, 11.9478F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r64.texOffs(83, 208).addBox(-6.8F, -8.1567F, 9.6478F, 4.0F, 1.0F, 6.0F, 0.0F, true);
		cube_r64.texOffs(83, 208).addBox(3.2F, -8.1567F, 9.6478F, 4.0F, 1.0F, 6.0F, 0.0F, false);

		panel_three_lights = new ModelRenderer(this);
		panel_three_lights.setPos(1.95F, 0.55F, -0.8F);
		

		cube_r65 = new ModelRenderer(this);
		cube_r65.setPos(0.0F, 0.0F, 0.0F);
		panel_three_lights.addChild(cube_r65);
		setRotationAngle(cube_r65, -0.7418F, -2.0944F, 0.0F);
		cube_r65.texOffs(76, 201).addBox(-2.375F, -7.9067F, 6.5728F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r65.texOffs(76, 201).addBox(3.625F, -7.9067F, 6.5728F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r65.texOffs(76, 201).addBox(0.625F, -7.9067F, 6.5728F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setPos(1.95F, 0.55F, -0.8F);
		

		cube_r66 = new ModelRenderer(this);
		cube_r66.setPos(0.0F, 0.0F, 0.0F);
		bone5.addChild(cube_r66);
		setRotationAngle(cube_r66, -0.7418F, -2.0944F, 0.0F);
		cube_r66.texOffs(81, 192).addBox(6.25F, -8.0067F, 14.0478F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r66.texOffs(77, 198).addBox(5.725F, -7.7067F, 13.5478F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setPos(4.5826F, 4.3344F, -13.8459F);
		

		lights_right_r1 = new ModelRenderer(this);
		lights_right_r1.setPos(-8.2376F, -1.8081F, 1.8456F);
		bone6.addChild(lights_right_r1);
		setRotationAngle(lights_right_r1, -0.829F, 0.0F, 0.0F);
		lights_right_r1.texOffs(101, 120).addBox(5.8F, -2.4F, 0.1F, 4.0F, 3.0F, 0.0F, 0.0F, false);
		lights_right_r1.texOffs(98, 130).addBox(-2.4F, -2.4F, 0.1F, 4.0F, 3.0F, 0.0F, 0.0F, false);

		dials = new ModelRenderer(this);
		dials.setPos(-4.7026F, -3.6492F, 3.3765F);
		bone6.addChild(dials);
		

		cube_r67 = new ModelRenderer(this);
		cube_r67.setPos(0.0F, 0.0F, 0.0F);
		dials.addChild(cube_r67);
		setRotationAngle(cube_r67, -0.829F, 0.0F, 0.0F);
		cube_r67.texOffs(124, 144).addBox(2.2F, -2.1F, 0.4F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		cube_r67.texOffs(124, 144).addBox(-0.8F, -2.1F, 0.4F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		cube_r67.texOffs(124, 144).addBox(-3.8F, -2.1F, 0.4F, 2.0F, 2.0F, 0.0F, 0.0F, false);

		crank_lever = new ModelRenderer(this);
		crank_lever.setPos(4.5826F, 4.3344F, -13.8459F);
		

		base_r1 = new ModelRenderer(this);
		base_r1.setPos(0.0F, 0.0F, 0.0F);
		crank_lever.addChild(base_r1);
		setRotationAngle(base_r1, -0.829F, -0.0107F, 0.0091F);
		base_r1.texOffs(102, 39).addBox(-0.94F, -0.24F, -1.42F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		base_r1.texOffs(127, 69).addBox(-1.44F, -0.74F, -0.42F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		lever_section_1_r1 = new ModelRenderer(this);
		lever_section_1_r1.setPos(0.1139F, 1.0329F, -4.0487F);
		crank_lever.addChild(lever_section_1_r1);
		setRotationAngle(lever_section_1_r1, -0.829F, -0.0107F, 0.0091F);
		lever_section_1_r1.texOffs(97, 39).addBox(-0.5F, -3.5F, 0.3F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		lever_section_2_r1 = new ModelRenderer(this);
		lever_section_2_r1.setPos(0.1272F, 1.3894F, -5.5956F);
		crank_lever.addChild(lever_section_2_r1);
		setRotationAngle(lever_section_2_r1, -0.829F, -0.0107F, 0.0091F);
		lever_section_2_r1.texOffs(53, 116).addBox(-0.5F, -1.9F, 0.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setPos(0.3826F, 4.3344F, -13.8459F);
		

		base_r2 = new ModelRenderer(this);
		base_r2.setPos(0.0F, 0.0F, 0.0F);
		bone7.addChild(base_r2);
		setRotationAngle(base_r2, -0.829F, 0.0F, 0.0F);
		base_r2.texOffs(89, 117).addBox(-1.84F, -4.54F, -0.02F, 3.0F, 7.0F, 0.0F, 0.0F, false);

		switches_r1 = new ModelRenderer(this);
		switches_r1.setPos(-0.3176F, -0.3796F, 0.355F);
		bone7.addChild(switches_r1);
		setRotationAngle(switches_r1, -0.9959F, 0.4981F, -0.6353F);
		switches_r1.texOffs(72, 192).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		buttons = new ModelRenderer(this);
		buttons.setPos(1.115F, 5.9571F, -17.24F);
		

		base_r3 = new ModelRenderer(this);
		base_r3.setPos(4.4676F, -1.6227F, 3.3941F);
		buttons.addChild(base_r3);
		setRotationAngle(base_r3, -0.829F, -0.0107F, 0.0091F);
		base_r3.texOffs(64, 191).addBox(-11.6F, -0.96F, 0.18F, 3.0F, 3.0F, 0.0F, 0.0F, false);

		cube_r68 = new ModelRenderer(this);
		cube_r68.setPos(0.0F, 0.0F, 0.0F);
		buttons.addChild(cube_r68);
		setRotationAngle(cube_r68, -0.829F, 0.0F, 0.0F);
		cube_r68.texOffs(105, 0).addBox(-5.5F, -2.925F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r68.texOffs(105, 0).addBox(-6.8F, -2.925F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r68.texOffs(105, 0).addBox(-5.5F, -4.225F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r68.texOffs(105, 0).addBox(-6.8F, -4.225F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		control_two = new ModelRenderer(this);
		control_two.setPos(1.0F, 1.3F, -0.8F);
		

		cube_r69 = new ModelRenderer(this);
		cube_r69.setPos(0.0F, 0.0F, 0.0F);
		control_two.addChild(cube_r69);
		setRotationAngle(cube_r69, -0.7418F, -1.0472F, 0.0F);
		cube_r69.texOffs(111, 197).addBox(-0.3F, -8.6567F, 8.8478F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r69.texOffs(109, 192).addBox(-1.3F, -8.1567F, 7.8478F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		control_three = new ModelRenderer(this);
		control_three.setPos(1.0F, 1.3F, -0.8F);
		

		cube_r70 = new ModelRenderer(this);
		cube_r70.setPos(0.0F, 0.0F, 0.0F);
		control_three.addChild(cube_r70);
		setRotationAngle(cube_r70, -0.7418F, -2.0944F, 0.0F);
		cube_r70.texOffs(82, 193).addBox(-3.8F, -7.6067F, 7.3478F, 10.0F, 0.0F, 4.0F, 0.0F, false);
		cube_r70.texOffs(81, 194).addBox(4.4F, -8.6067F, 9.1228F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		control_four = new ModelRenderer(this);
		control_four.setPos(1.95F, 0.55F, -0.8F);
		

		cube_r71 = new ModelRenderer(this);
		cube_r71.setPos(0.0F, 0.0F, 0.0F);
		control_four.addChild(cube_r71);
		setRotationAngle(cube_r71, -0.7418F, -2.0944F, 0.0F);
		cube_r71.texOffs(81, 192).addBox(-2.25F, -8.0067F, 14.5478F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r71.texOffs(81, 192).addBox(0.75F, -8.0067F, 14.5478F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r72 = new ModelRenderer(this);
		cube_r72.setPos(-0.95F, 0.75F, 0.0F);
		control_four.addChild(cube_r72);
		setRotationAngle(cube_r72, -0.7418F, -2.0944F, 0.0F);
		cube_r72.texOffs(82, 197).addBox(-4.275F, -7.6067F, 11.8478F, 7.0F, 0.0F, 4.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setPos(12.3022F, 2.4124F, -6.1706F);
		

		cube_r73 = new ModelRenderer(this);
		cube_r73.setPos(0.0F, 0.0F, 0.0F);
		bone8.addChild(cube_r73);
		setRotationAngle(cube_r73, -0.7418F, 2.0944F, 0.0F);
		cube_r73.texOffs(121, 208).addBox(6.0F, 0.8F, 1.475F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r73.texOffs(125, 208).addBox(5.5F, 1.3F, 1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setPos(12.3022F, 2.4124F, -6.1706F);
		

		cube_r74 = new ModelRenderer(this);
		cube_r74.setPos(0.0F, 0.0F, 0.0F);
		bone9.addChild(cube_r74);
		setRotationAngle(cube_r74, -0.7418F, 2.0944F, 0.0F);
		cube_r74.texOffs(121, 208).addBox(-5.8F, 0.8F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r74.texOffs(124, 204).addBox(-6.25F, 1.3F, 1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setPos(12.3022F, 2.4124F, -6.1706F);
		

		cube_r75 = new ModelRenderer(this);
		cube_r75.setPos(0.0F, 0.0F, 0.0F);
		bone10.addChild(cube_r75);
		setRotationAngle(cube_r75, -0.7418F, 2.0944F, 0.0F);
		cube_r75.texOffs(125, 200).addBox(-2.5F, 1.225F, 1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r75.texOffs(121, 208).addBox(-2.0F, 0.8F, 1.475F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r75.texOffs(121, 208).addBox(1.25F, 0.8F, -0.025F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r75.texOffs(121, 208).addBox(2.75F, 0.8F, 1.475F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r75.texOffs(121, 208).addBox(-0.25F, 0.8F, -0.025F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r75.texOffs(121, 208).addBox(1.25F, 0.8F, 1.475F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r75.texOffs(121, 208).addBox(2.75F, 0.8F, -0.025F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r75.texOffs(129, 208).addBox(-3.375F, 1.3F, -1.0F, 8.0F, 1.0F, 5.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);
		

		cube_r76 = new ModelRenderer(this);
		cube_r76.setPos(10.8904F, -23.4301F, 2.2544F);
		bb_main.addChild(cube_r76);
		setRotationAngle(cube_r76, -0.7418F, 1.0472F, 0.0F);
		cube_r76.texOffs(64, 209).addBox(-9.75F, 0.525F, 4.475F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r76.texOffs(64, 209).addBox(1.725F, 0.525F, 4.475F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r76.texOffs(58, 209).addBox(1.25F, 0.6F, 3.75F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r76.texOffs(58, 209).addBox(-10.25F, 0.6F, 3.75F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r77 = new ModelRenderer(this);
		cube_r77.setPos(10.8904F, -23.4301F, 2.2544F);
		bb_main.addChild(cube_r77);
		setRotationAngle(cube_r77, -0.3927F, 1.0472F, 0.0F);
		cube_r77.texOffs(58, 204).addBox(-7.5F, 0.0F, -2.5F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r77.texOffs(58, 204).addBox(-1.5F, 0.0F, -2.5F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r78 = new ModelRenderer(this);
		cube_r78.setPos(1.0F, -22.7F, -0.8F);
		bb_main.addChild(cube_r78);
		setRotationAngle(cube_r78, -0.7418F, 1.0472F, 0.0F);
		cube_r78.texOffs(31, 210).addBox(-2.45F, -6.8567F, 4.6978F, 2.0F, 0.0F, 2.0F, 0.0F, false);
		cube_r78.texOffs(31, 207).addBox(-2.2F, -6.8567F, 6.6978F, 2.0F, 0.0F, 2.0F, 0.0F, false);
		cube_r78.texOffs(34, 204).addBox(-5.7F, -6.8567F, 9.4478F, 9.0F, 0.0F, 5.0F, 0.0F, false);

		cube_r79 = new ModelRenderer(this);
		cube_r79.setPos(9.2366F, -21.7411F, 8.8052F);
		bb_main.addChild(cube_r79);
		setRotationAngle(cube_r79, -0.7418F, 1.0472F, 0.0F);
		cube_r79.texOffs(34, 204).addBox(1.5F, 0.3F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r79.texOffs(34, 204).addBox(-0.5F, 0.3F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r79.texOffs(34, 204).addBox(3.5F, 0.3F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r79.texOffs(34, 204).addBox(5.5F, 0.3F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r79.texOffs(34, 204).addBox(1.5F, 0.3F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r79.texOffs(34, 204).addBox(-0.5F, 0.3F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r79.texOffs(34, 204).addBox(3.5F, 0.3F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r79.texOffs(34, 204).addBox(5.5F, 0.3F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r79.texOffs(34, 204).addBox(3.5F, 0.3F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r79.texOffs(34, 204).addBox(5.5F, 0.3F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r79.texOffs(34, 204).addBox(1.5F, 0.3F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r79.texOffs(34, 204).addBox(-0.5F, 0.3F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r80 = new ModelRenderer(this);
		cube_r80.setPos(12.3022F, -21.5876F, -6.1706F);
		bb_main.addChild(cube_r80);
		setRotationAngle(cube_r80, -0.7418F, 2.0944F, 0.0F);
		cube_r80.texOffs(131, 201).addBox(-1.775F, 1.3F, -6.0F, 5.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r80.texOffs(153, 209).addBox(-3.35F, 1.3F, -2.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r81 = new ModelRenderer(this);
		cube_r81.setPos(-12.7164F, -18.8731F, 7.3501F);
		bb_main.addChild(cube_r81);
		setRotationAngle(cube_r81, 0.1745F, -1.0472F, 0.0F);
		cube_r81.texOffs(108, 205).addBox(-3.0F, -0.6F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r82 = new ModelRenderer(this);
		cube_r82.setPos(1.0F, -22.7F, -0.8F);
		bb_main.addChild(cube_r82);
		setRotationAngle(cube_r82, -0.7418F, -1.0472F, 0.0F);
		cube_r82.texOffs(106, 200).addBox(-3.3F, -8.1567F, 13.3478F, 7.0F, 1.0F, 2.0F, 0.0F, false);

		panel_three_small_lights_r1 = new ModelRenderer(this);
		panel_three_small_lights_r1.setPos(1.0F, -22.7F, -0.8F);
		bb_main.addChild(panel_three_small_lights_r1);
		setRotationAngle(panel_three_small_lights_r1, -0.7418F, -2.0944F, 0.0F);
		panel_three_small_lights_r1.texOffs(82, 202).addBox(-5.625F, -7.6067F, 11.8478F, 1.0F, 0.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		console_plinth_one.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		console_plinth_two.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		console_plinth_three.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		clawlegs.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		clawlegs2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		clawlegs3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		under_console_struts.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		console_corners.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		console_collar_one.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		console_collar_two.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		panel.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		panel2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		panel3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		panel4.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		panel5.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		panel6.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone4.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bottom_rotor.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		top_rotor.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		upper_console_one.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		upper_console_two.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		ConsoleCollarTwo3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		ConsoleCollarOne6.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		panel_two_glowies.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		panel_three_lights.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone5.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone6.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		crank_lever.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone7.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		buttons.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		control_two.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		control_three.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		control_four.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone8.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone9.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone10.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
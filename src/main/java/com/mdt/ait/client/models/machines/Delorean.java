package com.mdt.ait.client.models.machines;// Made with Blockbench 4.5.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.AIT;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.entities.DeloreanEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class Delorean extends EntityModel<DeloreanEntity> {
	public static final ResourceLocation TEXTURE = new ResourceLocation(AIT.MOD_ID, "textures/machines/delorean_machine.png");
	public final ModelRenderer car;
	public final ModelRenderer bone35;
	public final ModelRenderer bone29;
	public final ModelRenderer bone50;
	public final ModelRenderer front_right_wheel_rotate_Z75;
	public final ModelRenderer bluebit_translate_6;
	public final ModelRenderer bone109;
	public final ModelRenderer bone88;
	public final ModelRenderer bone89;
	public final ModelRenderer bone90;
	public final ModelRenderer bone91;
	public final ModelRenderer front_left_wheel_rotate_Z75;
	public final ModelRenderer bluebit1_translate_6;
	public final ModelRenderer bone84;
	public final ModelRenderer bone85;
	public final ModelRenderer bone86;
	public final ModelRenderer bone107;
	public final ModelRenderer bone114;
	public final ModelRenderer back_right_wheel_rotate_Z75;
	public final ModelRenderer bluebit2_translate_6;
	public final ModelRenderer bone110;
	public final ModelRenderer bone94;
	public final ModelRenderer bone95;
	public final ModelRenderer bone96;
	public final ModelRenderer bone106;
	public final ModelRenderer back_left_wheel_rotate_Z75;
	public final ModelRenderer bluebit3_translate_6;
	public final ModelRenderer bone102;
	public final ModelRenderer bone103;
	public final ModelRenderer bone108;
	public final ModelRenderer bone112;
	public final ModelRenderer bone115;
	public final ModelRenderer bone19;
	public final ModelRenderer bone17;
	public final ModelRenderer bone15;
	public final ModelRenderer bone18;
	public final ModelRenderer bone16;
	public final ModelRenderer bone25;
	public final ModelRenderer bone26;
	public final ModelRenderer bone27;
	public final ModelRenderer bone14;
	public final ModelRenderer bone30;
	public final ModelRenderer bone48;
	public final ModelRenderer bone49;
	public final ModelRenderer bone6;
	public final ModelRenderer bone9;
	public final ModelRenderer bone97;
	public final ModelRenderer bone98;
	public final ModelRenderer bone8;
	public final ModelRenderer bone7;
	public final ModelRenderer bone44;
	public final ModelRenderer bone45;
	public final ModelRenderer bone33;
	public final ModelRenderer bone46;
	public final ModelRenderer bone13;
	public final ModelRenderer bone12;
	public final ModelRenderer bone11;
	public final ModelRenderer bone39;
	public final ModelRenderer bone40;
	public final ModelRenderer bone41;
	public final ModelRenderer bone22;
	public final ModelRenderer bone23;
	public final ModelRenderer bone24;
	public final ModelRenderer bone42;
	public final ModelRenderer bone43;
	public final ModelRenderer bone47;
	public final ModelRenderer bone3;
	public final ModelRenderer bone51;
	public final ModelRenderer bone;
	public final ModelRenderer bone2;
	public final ModelRenderer bone4;
	public final ModelRenderer bone21;
	public final ModelRenderer bone34;
	public final ModelRenderer bone20;
	public final ModelRenderer bone36;
	public final ModelRenderer bone28;
	public final ModelRenderer bone31;
	public final ModelRenderer bone32;
	public final ModelRenderer bone92;
	public final ModelRenderer futurestuff;
	public final ModelRenderer bone79;
	public final ModelRenderer bone54;
	public final ModelRenderer bone78;
	public final ModelRenderer bone68;
	public final ModelRenderer bone69;
	public final ModelRenderer bone70;
	public final ModelRenderer bone71;
	public final ModelRenderer bone72;
	public final ModelRenderer bone73;
	public final ModelRenderer bone74;
	public final ModelRenderer bone75;
	public final ModelRenderer bone76;
	public final ModelRenderer bone77;
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
	public final ModelRenderer bone55;
	public final ModelRenderer bone52;
	public final ModelRenderer bone53;
	public final ModelRenderer bone56;
	public final ModelRenderer bone57;
	public final ModelRenderer interior;
	public final ModelRenderer bone5;
	public final ModelRenderer bone10;
	public final ModelRenderer bone104;
	public final ModelRenderer bone105;
	public final ModelRenderer bone37;
	public final ModelRenderer bone38;
	public final ModelRenderer left_door;
	public final ModelRenderer bone87;
	public final ModelRenderer bone82;
	public final ModelRenderer bone93;
	public final ModelRenderer bone100;
	public final ModelRenderer bone80;
	public final ModelRenderer bone83;
	public final ModelRenderer right_door;
	public final ModelRenderer bone101;
	public final ModelRenderer bone111;
	public final ModelRenderer bone113;
	public final ModelRenderer bone116;
	public final ModelRenderer bone117;
	public final ModelRenderer bone118;

	public Delorean() {
		texWidth = 256;
		texHeight = 256;

		car = new ModelRenderer(this);
		car.setPos(-7.0F, 23.0F, -17.0F);
		car.texOffs(84, 24).addBox(-3.5F, -5.0F, -12.0F, 21.0F, 2.0F, 7.0F, 0.0F, false);
		car.texOffs(27, 82).addBox(-4.0F, -7.75F, -13.75F, 22.0F, 1.0F, 1.0F, 0.0F, false);
		car.texOffs(0, 10).addBox(17.4142F, -7.75F, -12.3358F, 2.0F, 1.0F, 8.0F, 0.0F, false);
		car.texOffs(0, 10).addBox(-5.4142F, -7.75F, -12.3358F, 2.0F, 1.0F, 8.0F, 0.0F, true);
		car.texOffs(0, 56).addBox(18.5F, -7.75F, 3.85F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		car.texOffs(0, 56).addBox(-5.5F, -7.75F, 3.85F, 1.0F, 1.0F, 7.0F, 0.0F, true);
		car.texOffs(12, 12).addBox(18.5F, -7.75F, 25.8F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		car.texOffs(12, 12).addBox(-5.5F, -7.75F, 25.8F, 1.0F, 1.0F, 3.0F, 0.0F, true);
		car.texOffs(12, 10).addBox(17.5F, -7.75F, 25.3814F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		car.texOffs(12, 10).addBox(-5.5F, -7.75F, 25.3814F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		car.texOffs(0, 0).addBox(18.4F, -7.75F, 36.825F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		car.texOffs(0, 0).addBox(-5.4F, -7.75F, 36.825F, 1.0F, 1.0F, 9.0F, 0.0F, true);
		car.texOffs(27, 80).addBox(-4.0F, -7.75F, 46.25F, 22.0F, 1.0F, 1.0F, 0.0F, false);
		car.texOffs(52, 98).addBox(-2.0F, -15.9722F, 15.4314F, 18.0F, 1.0F, 1.0F, 0.0F, false);
		car.texOffs(102, 96).addBox(-2.0F, -15.9722F, 25.4314F, 18.0F, 1.0F, 3.0F, 0.0F, false);
		car.texOffs(94, 119).addBox(3.0F, -15.9722F, 16.4314F, 8.0F, 1.0F, 9.0F, 0.0F, false);
		car.texOffs(50, 85).addBox(-3.5F, -14.9722F, 25.4814F, 21.0F, 10.0F, 3.0F, 0.0F, false);
		car.texOffs(65, 45).addBox(-2.5F, -10.9722F, 28.4314F, 19.0F, 1.0F, 13.0F, 0.0F, false);

		bone35 = new ModelRenderer(this);
		bone35.setPos(7.0F, -2.4935F, 38.295F);
		car.addChild(bone35);
		setRotationAngle(bone35, -0.0131F, 0.0F, 0.0F);
		bone35.texOffs(0, 0).addBox(-10.0F, -0.5F, -44.0F, 20.0F, 1.0F, 44.0F, 0.0F, false);
		bone35.texOffs(84, 10).addBox(-8.0F, -5.0F, -10.25F, 16.0F, 4.0F, 10.0F, 0.0F, false);
		bone35.texOffs(27, 66).addBox(-8.0F, -5.0F, -43.25F, 16.0F, 4.0F, 10.0F, 0.0F, false);
		bone35.texOffs(0, 45).addBox(-11.5F, -3.0F, -31.0F, 23.0F, 2.0F, 19.0F, 0.0F, false);

		bone29 = new ModelRenderer(this);
		bone29.setPos(19.4F, -7.25F, 45.825F);
		car.addChild(bone29);
		setRotationAngle(bone29, 0.0F, -0.7854F, 0.0F);
		bone29.texOffs(0, 66).addBox(-1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		bone50 = new ModelRenderer(this);
		bone50.setPos(-5.4F, -7.25F, 45.825F);
		car.addChild(bone50);
		setRotationAngle(bone50, 0.0F, 0.7854F, 0.0F);
		bone50.texOffs(0, 59).addBox(0.0F, -0.5F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		front_right_wheel_rotate_Z75 = new ModelRenderer(this);
		front_right_wheel_rotate_Z75.setPos(-2.75F, -3.0F, 0.0F);
		car.addChild(front_right_wheel_rotate_Z75);
		front_right_wheel_rotate_Z75.texOffs(65, 45).addBox(-2.0F, -4.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, true);
		front_right_wheel_rotate_Z75.texOffs(22, 22).addBox(-2.0F, -1.5F, -4.0F, 3.0F, 3.0F, 8.0F, 0.0F, true);
		front_right_wheel_rotate_Z75.texOffs(0, 77).addBox(1.0F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F, 0.0F, true);

		bluebit_translate_6 = new ModelRenderer(this);
		bluebit_translate_6.setPos(3.75F, 0.5F, -0.5F);
		front_right_wheel_rotate_Z75.addChild(bluebit_translate_6);
		bluebit_translate_6.texOffs(10, 66).addBox(-2.3F, -2.5F, -1.5F, 2.0F, 4.0F, 4.0F, 0.0F, true);
		bluebit_translate_6.texOffs(0, 0).addBox(-3.55F, -2.0F, -1.0F, 1.0F, 3.0F, 3.0F, 0.0F, true);
		bluebit_translate_6.texOffs(37, 8).addBox(-5.8F, -1.5F, -0.5F, 1.0F, 2.0F, 2.0F, 0.0F, true);

		bone109 = new ModelRenderer(this);
		bone109.setPos(-0.55F, 0.0F, 0.0F);
		front_right_wheel_rotate_Z75.addChild(bone109);
		bone109.texOffs(0, 106).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, true);

		bone88 = new ModelRenderer(this);
		bone88.setPos(0.0F, -1.5F, 4.0F);
		front_right_wheel_rotate_Z75.addChild(bone88);
		setRotationAngle(bone88, -0.7854F, 0.0F, 0.0F);
		bone88.texOffs(126, 10).addBox(-1.975F, 0.0F, -3.0F, 3.0F, 2.0F, 3.0F, 0.0F, true);
		bone88.texOffs(36, 25).addBox(-1.975F, 0.0F, -3.5355F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		bone89 = new ModelRenderer(this);
		bone89.setPos(0.0F, -1.5F, -4.0F);
		front_right_wheel_rotate_Z75.addChild(bone89);
		setRotationAngle(bone89, 0.7854F, 0.0F, 0.0F);
		bone89.texOffs(122, 113).addBox(-1.975F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, 0.0F, true);
		bone89.texOffs(36, 22).addBox(-1.975F, 0.0F, 2.5355F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		bone90 = new ModelRenderer(this);
		bone90.setPos(0.0F, 1.5F, -4.0F);
		front_right_wheel_rotate_Z75.addChild(bone90);
		setRotationAngle(bone90, -0.7854F, 0.0F, 0.0F);
		bone90.texOffs(17, 116).addBox(-1.975F, -2.0F, 0.0F, 3.0F, 2.0F, 3.0F, 0.0F, true);
		bone90.texOffs(22, 27).addBox(-1.975F, -2.0F, 2.5355F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		bone91 = new ModelRenderer(this);
		bone91.setPos(0.0F, 1.5F, 4.0F);
		front_right_wheel_rotate_Z75.addChild(bone91);
		setRotationAngle(bone91, 0.7854F, 0.0F, 0.0F);
		bone91.texOffs(11, 77).addBox(-1.975F, -2.0F, -3.0F, 3.0F, 2.0F, 3.0F, 0.0F, true);
		bone91.texOffs(0, 6).addBox(-1.975F, -2.0F, -3.5355F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		front_left_wheel_rotate_Z75 = new ModelRenderer(this);
		front_left_wheel_rotate_Z75.setPos(16.75F, -3.0F, 0.0F);
		car.addChild(front_left_wheel_rotate_Z75);
		front_left_wheel_rotate_Z75.texOffs(65, 45).addBox(-1.0F, -4.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);
		front_left_wheel_rotate_Z75.texOffs(22, 22).addBox(-1.0F, -1.5F, -4.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
		front_left_wheel_rotate_Z75.texOffs(0, 77).addBox(-4.0F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F, 0.0F, false);

		bluebit1_translate_6 = new ModelRenderer(this);
		bluebit1_translate_6.setPos(-3.75F, 0.5F, 0.5F);
		front_left_wheel_rotate_Z75.addChild(bluebit1_translate_6);
		bluebit1_translate_6.texOffs(10, 66).addBox(1.3F, -2.5F, -2.5F, 2.0F, 4.0F, 4.0F, 0.0F, false);
		bluebit1_translate_6.texOffs(0, 0).addBox(3.55F, -2.0F, -2.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		bluebit1_translate_6.texOffs(37, 8).addBox(5.8F, -1.5F, -1.5F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		bone84 = new ModelRenderer(this);
		bone84.setPos(0.55F, 0.0F, 0.0F);
		front_left_wheel_rotate_Z75.addChild(bone84);
		bone84.texOffs(0, 106).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);

		bone85 = new ModelRenderer(this);
		bone85.setPos(0.0F, -1.5F, 4.0F);
		front_left_wheel_rotate_Z75.addChild(bone85);
		setRotationAngle(bone85, -0.7854F, 0.0F, 0.0F);
		bone85.texOffs(126, 10).addBox(-1.025F, 0.0F, -3.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		bone85.texOffs(36, 25).addBox(-1.025F, 0.0F, -3.5355F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		bone86 = new ModelRenderer(this);
		bone86.setPos(0.0F, -1.5F, -4.0F);
		front_left_wheel_rotate_Z75.addChild(bone86);
		setRotationAngle(bone86, 0.7854F, 0.0F, 0.0F);
		bone86.texOffs(122, 113).addBox(-1.025F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		bone86.texOffs(36, 22).addBox(-1.025F, 0.0F, 2.5355F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		bone107 = new ModelRenderer(this);
		bone107.setPos(0.0F, 1.5F, -4.0F);
		front_left_wheel_rotate_Z75.addChild(bone107);
		setRotationAngle(bone107, -0.7854F, 0.0F, 0.0F);
		bone107.texOffs(17, 116).addBox(-1.025F, -2.0F, 0.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		bone107.texOffs(22, 27).addBox(-1.025F, -2.0F, 2.5355F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		bone114 = new ModelRenderer(this);
		bone114.setPos(0.0F, 1.5F, 4.0F);
		front_left_wheel_rotate_Z75.addChild(bone114);
		setRotationAngle(bone114, 0.7854F, 0.0F, 0.0F);
		bone114.texOffs(11, 77).addBox(-1.025F, -2.0F, -3.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		bone114.texOffs(0, 6).addBox(-1.025F, -2.0F, -3.5355F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		back_right_wheel_rotate_Z75 = new ModelRenderer(this);
		back_right_wheel_rotate_Z75.setPos(-3.25F, -3.0F, 33.0F);
		car.addChild(back_right_wheel_rotate_Z75);
		back_right_wheel_rotate_Z75.texOffs(65, 45).addBox(-2.0F, -4.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, true);
		back_right_wheel_rotate_Z75.texOffs(22, 22).addBox(-2.0F, -1.5F, -4.0F, 3.0F, 3.0F, 8.0F, 0.0F, true);
		back_right_wheel_rotate_Z75.texOffs(0, 77).addBox(1.0F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F, 0.0F, true);

		bluebit2_translate_6 = new ModelRenderer(this);
		bluebit2_translate_6.setPos(3.75F, 3.5F, 6.5F);
		back_right_wheel_rotate_Z75.addChild(bluebit2_translate_6);
		bluebit2_translate_6.texOffs(10, 66).addBox(-2.3F, -5.5F, -8.5F, 2.0F, 4.0F, 4.0F, 0.0F, true);
		bluebit2_translate_6.texOffs(0, 0).addBox(-3.55F, -5.0F, -8.0F, 1.0F, 3.0F, 3.0F, 0.0F, true);
		bluebit2_translate_6.texOffs(37, 8).addBox(-5.8F, -4.5F, -7.5F, 1.0F, 2.0F, 2.0F, 0.0F, true);

		bone110 = new ModelRenderer(this);
		bone110.setPos(-0.55F, 0.0F, 0.0F);
		back_right_wheel_rotate_Z75.addChild(bone110);
		bone110.texOffs(0, 106).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, true);

		bone94 = new ModelRenderer(this);
		bone94.setPos(0.0F, -1.5F, 4.0F);
		back_right_wheel_rotate_Z75.addChild(bone94);
		setRotationAngle(bone94, -0.7854F, 0.0F, 0.0F);
		bone94.texOffs(126, 10).addBox(-1.975F, 0.0F, -3.0F, 3.0F, 2.0F, 3.0F, 0.0F, true);
		bone94.texOffs(36, 25).addBox(-1.975F, 0.0F, -3.5355F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		bone95 = new ModelRenderer(this);
		bone95.setPos(0.0F, -1.5F, -4.0F);
		back_right_wheel_rotate_Z75.addChild(bone95);
		setRotationAngle(bone95, 0.7854F, 0.0F, 0.0F);
		bone95.texOffs(122, 113).addBox(-1.975F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, 0.0F, true);
		bone95.texOffs(36, 22).addBox(-1.975F, 0.0F, 2.5355F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		bone96 = new ModelRenderer(this);
		bone96.setPos(0.0F, 1.5F, -4.0F);
		back_right_wheel_rotate_Z75.addChild(bone96);
		setRotationAngle(bone96, -0.7854F, 0.0F, 0.0F);
		bone96.texOffs(17, 116).addBox(-1.975F, -2.0F, 0.0F, 3.0F, 2.0F, 3.0F, 0.0F, true);
		bone96.texOffs(22, 27).addBox(-1.975F, -2.0F, 2.5355F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		bone106 = new ModelRenderer(this);
		bone106.setPos(0.0F, 1.5F, 4.0F);
		back_right_wheel_rotate_Z75.addChild(bone106);
		setRotationAngle(bone106, 0.7854F, 0.0F, 0.0F);
		bone106.texOffs(11, 77).addBox(-1.975F, -2.0F, -3.0F, 3.0F, 2.0F, 3.0F, 0.0F, true);
		bone106.texOffs(0, 6).addBox(-1.975F, -2.0F, -3.5355F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		back_left_wheel_rotate_Z75 = new ModelRenderer(this);
		back_left_wheel_rotate_Z75.setPos(17.25F, -3.0F, 33.0F);
		car.addChild(back_left_wheel_rotate_Z75);
		back_left_wheel_rotate_Z75.texOffs(65, 45).addBox(-1.0F, -4.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);
		back_left_wheel_rotate_Z75.texOffs(22, 22).addBox(-1.0F, -1.5F, -4.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
		back_left_wheel_rotate_Z75.texOffs(0, 77).addBox(-4.0F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F, 0.0F, false);

		bluebit3_translate_6 = new ModelRenderer(this);
		bluebit3_translate_6.setPos(-3.75F, 0.5F, -0.5F);
		back_left_wheel_rotate_Z75.addChild(bluebit3_translate_6);
		bluebit3_translate_6.texOffs(10, 66).addBox(0.3F, -2.5F, -1.5F, 2.0F, 4.0F, 4.0F, 0.0F, false);
		bluebit3_translate_6.texOffs(0, 0).addBox(2.55F, -2.0F, -1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		bluebit3_translate_6.texOffs(37, 8).addBox(4.8F, -1.5F, -0.5F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		bone102 = new ModelRenderer(this);
		bone102.setPos(0.55F, 0.0F, 0.0F);
		back_left_wheel_rotate_Z75.addChild(bone102);
		bone102.texOffs(0, 106).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);

		bone103 = new ModelRenderer(this);
		bone103.setPos(0.0F, -1.5F, 4.0F);
		back_left_wheel_rotate_Z75.addChild(bone103);
		setRotationAngle(bone103, -0.7854F, 0.0F, 0.0F);
		bone103.texOffs(126, 10).addBox(-1.025F, 0.0F, -3.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		bone103.texOffs(36, 25).addBox(-1.025F, 0.0F, -3.5355F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		bone108 = new ModelRenderer(this);
		bone108.setPos(0.0F, -1.5F, -4.0F);
		back_left_wheel_rotate_Z75.addChild(bone108);
		setRotationAngle(bone108, 0.7854F, 0.0F, 0.0F);
		bone108.texOffs(122, 113).addBox(-1.025F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		bone108.texOffs(36, 22).addBox(-1.025F, 0.0F, 2.5355F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		bone112 = new ModelRenderer(this);
		bone112.setPos(0.0F, 1.5F, -4.0F);
		back_left_wheel_rotate_Z75.addChild(bone112);
		setRotationAngle(bone112, -0.7854F, 0.0F, 0.0F);
		bone112.texOffs(17, 116).addBox(-1.025F, -2.0F, 0.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		bone112.texOffs(22, 27).addBox(-1.025F, -2.0F, 2.5355F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		bone115 = new ModelRenderer(this);
		bone115.setPos(0.0F, 1.5F, 4.0F);
		back_left_wheel_rotate_Z75.addChild(bone115);
		setRotationAngle(bone115, 0.7854F, 0.0F, 0.0F);
		bone115.texOffs(11, 77).addBox(-1.025F, -2.0F, -3.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		bone115.texOffs(0, 6).addBox(-1.025F, -2.0F, -3.5355F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		bone19 = new ModelRenderer(this);
		bone19.setPos(18.0F, -7.25F, -13.75F);
		car.addChild(bone19);
		setRotationAngle(bone19, 0.0F, -0.7854F, 0.0F);
		bone19.texOffs(12, 16).addBox(0.0F, -0.5F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		bone17 = new ModelRenderer(this);
		bone17.setPos(-4.0F, -7.25F, -13.75F);
		car.addChild(bone17);
		setRotationAngle(bone17, 0.0F, 0.7854F, 0.0F);
		bone17.texOffs(12, 16).addBox(-2.0F, -0.5F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		bone15 = new ModelRenderer(this);
		bone15.setPos(17.0F, -11.7222F, 7.7814F);
		car.addChild(bone15);
		setRotationAngle(bone15, -1.0647F, 0.0F, 0.0F);
		

		bone18 = new ModelRenderer(this);
		bone18.setPos(1.0F, 0.0F, 0.0F);
		bone15.addChild(bone18);
		setRotationAngle(bone18, 0.0F, 0.0F, -0.2269F);
		bone18.texOffs(84, 10).addBox(-1.0F, -9.0F, 0.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		bone18.texOffs(5, 0).addBox(-1.0F, -2.55F, 0.75F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setPos(-21.0F, 0.0F, 0.0F);
		bone15.addChild(bone16);
		setRotationAngle(bone16, 0.0F, 0.0F, 0.2269F);
		bone16.texOffs(84, 10).addBox(0.0F, -9.0F, 0.0F, 1.0F, 9.0F, 1.0F, 0.0F, true);
		bone16.texOffs(5, 0).addBox(0.0F, -2.55F, 0.75F, 1.0F, 2.0F, 1.0F, 0.0F, true);

		bone25 = new ModelRenderer(this);
		bone25.setPos(7.0F, -16.0F, 28.425F);
		car.addChild(bone25);
		setRotationAngle(bone25, -0.3054F, 0.0F, 0.0F);
		bone25.texOffs(113, 60).addBox(-9.0F, 0.0246F, 0.0144F, 18.0F, 1.0F, 1.0F, 0.0F, false);

		bone26 = new ModelRenderer(this);
		bone26.setPos(9.0F, 0.0278F, -0.1064F);
		bone25.addChild(bone26);
		setRotationAngle(bone26, 0.0F, 0.1309F, 0.0F);
		bone26.texOffs(114, 44).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 15.0F, 0.0F, false);

		bone27 = new ModelRenderer(this);
		bone27.setPos(-9.0F, 0.0278F, -0.1064F);
		bone25.addChild(bone27);
		setRotationAngle(bone27, 0.0F, -0.1309F, 0.0F);
		bone27.texOffs(71, 111).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 15.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setPos(19.25F, -7.75F, 7.9F);
		car.addChild(bone14);
		setRotationAngle(bone14, 0.0F, 0.0F, -0.3054F);
		bone14.texOffs(82, 85).addBox(-2.0F, -4.0F, 17.925F, 2.0F, 4.0F, 16.0F, 0.0F, false);
		bone14.texOffs(22, 0).addBox(-2.0F, -4.0F, 17.5064F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		bone14.texOffs(9, 56).addBox(-2.0F, -4.0F, -0.075F, 2.0F, 4.0F, 3.0F, 0.0F, false);

		bone30 = new ModelRenderer(this);
		bone30.setPos(0.0F, 0.0F, 33.925F);
		bone14.addChild(bone30);
		setRotationAngle(bone30, 0.0F, -0.2618F, 0.0F);
		bone30.texOffs(52, 100).addBox(-2.0F, -4.0F, 0.0F, 2.0F, 4.0F, 5.0F, 0.0F, false);

		bone48 = new ModelRenderer(this);
		bone48.setPos(-5.25F, -7.75F, 7.9F);
		car.addChild(bone48);
		setRotationAngle(bone48, 0.0F, 0.0F, 0.3054F);
		bone48.texOffs(82, 85).addBox(0.0F, -4.0F, 17.925F, 2.0F, 4.0F, 16.0F, 0.0F, true);
		bone48.texOffs(22, 0).addBox(0.0F, -4.0F, 17.5064F, 2.0F, 4.0F, 1.0F, 0.0F, true);
		bone48.texOffs(9, 56).addBox(0.0F, -4.0F, -0.075F, 2.0F, 4.0F, 3.0F, 0.0F, true);

		bone49 = new ModelRenderer(this);
		bone49.setPos(0.0F, 0.0F, 33.925F);
		bone48.addChild(bone49);
		setRotationAngle(bone49, 0.0F, 0.2618F, 0.0F);
		bone49.texOffs(52, 100).addBox(0.0F, -4.0F, 0.0F, 2.0F, 4.0F, 5.0F, 0.0F, true);

		bone6 = new ModelRenderer(this);
		bone6.setPos(19.25F, -7.75F, 7.9F);
		car.addChild(bone6);
		setRotationAngle(bone6, 0.0F, 0.0262F, -0.3752F);
		bone6.texOffs(0, 22).addBox(-1.0F, -2.0F, -20.0F, 1.0F, 2.0F, 20.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setPos(-0.0226F, -2.0713F, -20.0052F);
		bone6.addChild(bone9);
		setRotationAngle(bone9, 0.0698F, 0.0F, 0.0F);
		bone9.texOffs(0, 0).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 20.0F, 0.0F, false);

		bone97 = new ModelRenderer(this);
		bone97.setPos(-5.25F, -7.75F, 7.9F);
		car.addChild(bone97);
		setRotationAngle(bone97, 0.0F, -0.0262F, 0.3752F);
		bone97.texOffs(0, 22).addBox(0.0F, -2.0F, -20.0F, 1.0F, 2.0F, 20.0F, 0.0F, true);

		bone98 = new ModelRenderer(this);
		bone98.setPos(0.0226F, -2.0713F, -20.0052F);
		bone97.addChild(bone98);
		setRotationAngle(bone98, 0.0698F, 0.0F, 0.0F);
		bone98.texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 20.0F, 0.0F, true);

		bone8 = new ModelRenderer(this);
		bone8.setPos(19.5F, -6.75F, 9.0F);
		car.addChild(bone8);
		setRotationAngle(bone8, 0.0F, 0.0F, 0.2618F);
		bone8.texOffs(69, 66).addBox(-1.0F, 0.0F, -4.175F, 1.0F, 3.0F, 6.0F, 0.0F, false);
		bone8.texOffs(22, 22).addBox(-1.0F, 0.0F, 16.825F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		bone8.texOffs(37, 0).addBox(-2.0F, 0.0F, 16.4064F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setPos(-0.1682F, 2.3721F, 0.5F);
		bone8.addChild(bone7);
		setRotationAngle(bone7, 0.0F, 0.0F, -0.2618F);
		bone7.texOffs(0, 66).addBox(-2.0F, 0.0F, -4.5F, 2.0F, 2.0F, 23.0F, 0.0F, false);

		bone44 = new ModelRenderer(this);
		bone44.setPos(-5.5F, -6.75F, 9.0F);
		car.addChild(bone44);
		setRotationAngle(bone44, 0.0F, 0.0F, -0.2618F);
		bone44.texOffs(69, 66).addBox(0.0F, 0.0F, -4.175F, 1.0F, 3.0F, 6.0F, 0.0F, true);
		bone44.texOffs(22, 22).addBox(0.0F, 0.0F, 16.825F, 1.0F, 3.0F, 2.0F, 0.0F, true);
		bone44.texOffs(37, 0).addBox(0.0F, 0.0F, 16.4064F, 2.0F, 3.0F, 1.0F, 0.0F, true);

		bone45 = new ModelRenderer(this);
		bone45.setPos(0.1682F, 2.3721F, 0.5F);
		bone44.addChild(bone45);
		setRotationAngle(bone45, 0.0F, 0.0F, 0.2618F);
		bone45.texOffs(0, 66).addBox(0.0F, 0.0F, -4.5F, 2.0F, 2.0F, 23.0F, 0.0F, true);

		bone33 = new ModelRenderer(this);
		bone33.setPos(19.4F, -6.75F, 37.825F);
		car.addChild(bone33);
		setRotationAngle(bone33, 0.0F, -0.0436F, 0.48F);
		bone33.texOffs(0, 22).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);

		bone46 = new ModelRenderer(this);
		bone46.setPos(-5.4F, -6.75F, 37.825F);
		car.addChild(bone46);
		setRotationAngle(bone46, 0.0F, 0.0436F, -0.48F);
		bone46.texOffs(0, 22).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 8.0F, 0.0F, true);

		bone13 = new ModelRenderer(this);
		bone13.setPos(1.25F, 0.0F, 0.0F);
		car.addChild(bone13);
		bone13.texOffs(22, 8).addBox(14.5F, -8.5F, -3.5F, 4.0F, 1.0F, 7.0F, 0.0F, false);
		bone13.texOffs(116, 54).addBox(13.5F, -6.5F, -5.5F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		bone13.texOffs(0, 40).addBox(13.5F, -4.0F, -5.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		bone13.texOffs(128, 67).addBox(13.5F, -6.5F, 4.5F, 5.0F, 4.0F, 1.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setPos(17.0F, -8.5F, -3.5F);
		bone13.addChild(bone12);
		setRotationAngle(bone12, 0.7854F, 0.0F, 0.0F);
		bone12.texOffs(131, 131).addBox(-2.5F, 0.0F, -2.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		bone12.texOffs(0, 131).addBox(-2.5F, 0.0F, -2.8284F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setPos(17.0F, -8.5F, 3.5F);
		bone13.addChild(bone11);
		setRotationAngle(bone11, -0.7854F, 0.0F, 0.0F);
		bone11.texOffs(121, 130).addBox(-2.5F, 0.0F, 0.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		bone11.texOffs(109, 130).addBox(-2.5F, 0.0F, 0.8284F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		bone39 = new ModelRenderer(this);
		bone39.setPos(12.75F, 0.0F, 0.0F);
		car.addChild(bone39);
		bone39.texOffs(22, 8).addBox(-18.5F, -8.5F, -3.5F, 4.0F, 1.0F, 7.0F, 0.0F, true);
		bone39.texOffs(116, 54).addBox(-18.5F, -6.5F, -5.5F, 5.0F, 3.0F, 1.0F, 0.0F, true);
		bone39.texOffs(0, 40).addBox(-18.5F, -4.0F, -5.5F, 5.0F, 1.0F, 1.0F, 0.0F, true);
		bone39.texOffs(128, 67).addBox(-18.5F, -6.5F, 4.5F, 5.0F, 4.0F, 1.0F, 0.0F, true);

		bone40 = new ModelRenderer(this);
		bone40.setPos(-17.0F, -8.5F, -3.5F);
		bone39.addChild(bone40);
		setRotationAngle(bone40, 0.7854F, 0.0F, 0.0F);
		bone40.texOffs(131, 131).addBox(-1.5F, 0.0F, -2.0F, 4.0F, 1.0F, 2.0F, 0.0F, true);
		bone40.texOffs(0, 131).addBox(-1.5F, 0.0F, -2.8284F, 4.0F, 1.0F, 2.0F, 0.0F, true);

		bone41 = new ModelRenderer(this);
		bone41.setPos(-17.0F, -8.5F, 3.5F);
		bone39.addChild(bone41);
		setRotationAngle(bone41, -0.7854F, 0.0F, 0.0F);
		bone41.texOffs(121, 130).addBox(-1.5F, 0.0F, 0.0F, 4.0F, 1.0F, 2.0F, 0.0F, true);
		bone41.texOffs(109, 130).addBox(-1.5F, 0.0F, 0.8284F, 4.0F, 1.0F, 2.0F, 0.0F, true);

		bone22 = new ModelRenderer(this);
		bone22.setPos(1.5F, 0.0F, 33.0F);
		car.addChild(bone22);
		bone22.texOffs(22, 0).addBox(14.5F, -8.5F, -3.5F, 4.0F, 1.0F, 7.0F, 0.0F, false);
		bone22.texOffs(128, 62).addBox(13.5F, -6.5F, -5.5F, 5.0F, 4.0F, 1.0F, 0.0F, false);
		bone22.texOffs(75, 127).addBox(13.5F, -6.5F, 4.5F, 5.0F, 4.0F, 1.0F, 0.0F, false);

		bone23 = new ModelRenderer(this);
		bone23.setPos(17.0F, -8.5F, -3.5F);
		bone22.addChild(bone23);
		setRotationAngle(bone23, 0.7854F, 0.0F, 0.0F);
		bone23.texOffs(99, 129).addBox(-2.5F, 0.0F, -2.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		bone23.texOffs(87, 129).addBox(-2.5F, 0.0F, -2.8284F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		bone24 = new ModelRenderer(this);
		bone24.setPos(17.0F, -8.5F, 3.5F);
		bone22.addChild(bone24);
		setRotationAngle(bone24, -0.7854F, 0.0F, 0.0F);
		bone24.texOffs(128, 81).addBox(-2.5F, 0.0F, 0.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		bone24.texOffs(72, 80).addBox(-2.5F, 0.0F, 0.8284F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		bone42 = new ModelRenderer(this);
		bone42.setPos(12.5F, 0.0F, 33.0F);
		car.addChild(bone42);
		bone42.texOffs(22, 0).addBox(-18.5F, -8.5F, -3.5F, 4.0F, 1.0F, 7.0F, 0.0F, true);
		bone42.texOffs(128, 62).addBox(-18.5F, -6.5F, -5.5F, 5.0F, 4.0F, 1.0F, 0.0F, true);
		bone42.texOffs(75, 127).addBox(-18.5F, -6.5F, 4.5F, 5.0F, 4.0F, 1.0F, 0.0F, true);

		bone43 = new ModelRenderer(this);
		bone43.setPos(-17.0F, -8.5F, -3.5F);
		bone42.addChild(bone43);
		setRotationAngle(bone43, 0.7854F, 0.0F, 0.0F);
		bone43.texOffs(99, 129).addBox(-1.5F, 0.0F, -2.0F, 4.0F, 1.0F, 2.0F, 0.0F, true);
		bone43.texOffs(87, 129).addBox(-1.5F, 0.0F, -2.8284F, 4.0F, 1.0F, 2.0F, 0.0F, true);

		bone47 = new ModelRenderer(this);
		bone47.setPos(-17.0F, -8.5F, 3.5F);
		bone42.addChild(bone47);
		setRotationAngle(bone47, -0.7854F, 0.0F, 0.0F);
		bone47.texOffs(128, 81).addBox(-1.5F, 0.0F, 0.0F, 4.0F, 1.0F, 2.0F, 0.0F, true);
		bone47.texOffs(72, 80).addBox(-1.5F, 0.0F, 0.8284F, 4.0F, 1.0F, 2.0F, 0.0F, true);

		bone3 = new ModelRenderer(this);
		bone3.setPos(17.975F, -4.5F, -8.5F);
		car.addChild(bone3);
		setRotationAngle(bone3, 0.0F, 0.0F, 0.3491F);
		bone3.texOffs(0, 66).addBox(-1.0F, -3.0F, -4.25F, 1.0F, 3.0F, 8.0F, 0.0F, false);

		bone51 = new ModelRenderer(this);
		bone51.setPos(-3.975F, -4.5F, -8.5F);
		car.addChild(bone51);
		setRotationAngle(bone51, 0.0F, 0.0F, -0.3491F);
		bone51.texOffs(0, 45).addBox(0.0F, -3.0F, -4.25F, 1.0F, 3.0F, 8.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setPos(15.0F, -3.0F, -5.0F);
		car.addChild(bone);
		setRotationAngle(bone, -0.1745F, 0.0F, 0.0F);
		bone.texOffs(84, 0).addBox(-19.0F, -2.0F, -8.0F, 22.0F, 2.0F, 8.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setPos(-7.0F, 0.0F, -8.0F);
		bone.addChild(bone2);
		setRotationAngle(bone2, 0.3927F, 0.0F, 0.0F);
		bone2.texOffs(102, 91).addBox(-12.0F, -3.0F, 0.0F, 22.0F, 3.0F, 2.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setPos(0.0F, -3.0F, 0.0F);
		bone2.addChild(bone4);
		setRotationAngle(bone4, -0.6981F, 0.0F, 0.0F);
		bone4.texOffs(65, 59).addBox(-12.0F, -3.0F, 0.0F, 22.0F, 3.0F, 2.0F, 0.0F, false);

		bone21 = new ModelRenderer(this);
		bone21.setPos(16.0F, -15.9722F, 26.9314F);
		car.addChild(bone21);
		setRotationAngle(bone21, 0.0F, 0.0F, -0.4276F);
		bone21.texOffs(10, 22).addBox(-2.0F, 0.0F, -1.475F, 2.0F, 5.0F, 3.0F, 0.0F, false);

		bone34 = new ModelRenderer(this);
		bone34.setPos(0.0F, 0.0F, 1.5F);
		bone21.addChild(bone34);
		setRotationAngle(bone34, 0.1745F, 0.0F, 0.0F);
		bone34.texOffs(0, 22).addBox(-2.025F, 0.0F, -0.975F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		bone20 = new ModelRenderer(this);
		bone20.setPos(-2.0F, -15.9722F, 26.9314F);
		car.addChild(bone20);
		setRotationAngle(bone20, 0.0F, 0.0F, 0.4276F);
		bone20.texOffs(10, 22).addBox(0.0F, 0.0F, -1.475F, 2.0F, 5.0F, 3.0F, 0.0F, true);

		bone36 = new ModelRenderer(this);
		bone36.setPos(0.0F, 0.0F, 1.5F);
		bone20.addChild(bone36);
		setRotationAngle(bone36, 0.1745F, 0.0F, 0.0F);
		bone36.texOffs(0, 22).addBox(0.025F, 0.0F, -0.975F, 2.0F, 5.0F, 1.0F, 0.0F, true);

		bone28 = new ModelRenderer(this);
		bone28.setPos(7.0F, -11.75F, 41.8394F);
		car.addChild(bone28);
		setRotationAngle(bone28, 0.0873F, 0.0F, 0.0F);
		bone28.texOffs(84, 33).addBox(-11.0F, 0.0F, -0.25F, 22.0F, 5.0F, 5.0F, 0.0F, false);

		bone31 = new ModelRenderer(this);
		bone31.setPos(7.0F, -6.75F, 47.25F);
		car.addChild(bone31);
		setRotationAngle(bone31, -0.5236F, 0.0F, 0.0F);
		bone31.texOffs(102, 85).addBox(-11.0F, 0.0F, -2.0F, 22.0F, 4.0F, 2.0F, 0.0F, false);

		bone32 = new ModelRenderer(this);
		bone32.setPos(0.0F, 4.0F, 0.0F);
		bone31.addChild(bone32);
		setRotationAngle(bone32, -0.9338F, 0.0F, 0.0F);
		bone32.texOffs(0, 91).addBox(-11.0F, 0.0F, -2.0F, 22.0F, 7.0F, 2.0F, 0.0F, false);

		bone92 = new ModelRenderer(this);
		bone92.setPos(7.0F, -9.9791F, -12.1425F);
		car.addChild(bone92);
		setRotationAngle(bone92, 0.0873F, 0.0F, 0.0F);
		bone92.texOffs(64, 64).addBox(-11.0F, 0.0F, 0.0F, 22.0F, 1.0F, 20.0F, 0.0F, false);

		futurestuff = new ModelRenderer(this);
		futurestuff.setPos(0.0F, 23.0F, -17.0F);
		futurestuff.texOffs(88, 118).addBox(-8.0F, -12.9722F, 32.9314F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		futurestuff.texOffs(0, 122).addBox(-3.5F, -12.9722F, 35.4314F, 7.0F, 2.0F, 7.0F, 0.0F, false);
		futurestuff.texOffs(10, 49).addBox(1.5F, -12.4722F, 42.4314F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		futurestuff.texOffs(10, 49).addBox(-2.5F, -12.4722F, 42.4314F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		futurestuff.texOffs(88, 111).addBox(5.0F, -13.9722F, 36.4314F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		futurestuff.texOffs(88, 111).addBox(-9.0F, -13.9722F, 36.4314F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		futurestuff.texOffs(33, 106).addBox(-2.0F, -14.9972F, 32.4064F, 4.0F, 4.0F, 3.0F, 0.0F, false);
		futurestuff.texOffs(22, 16).addBox(0.75F, -12.9722F, 28.9314F, 6.0F, 2.0F, 2.0F, 0.0F, false);
		futurestuff.texOffs(71, 100).addBox(-6.0F, -12.9722F, 28.9314F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		futurestuff.texOffs(22, 5).addBox(-3.0F, -11.9722F, 29.4314F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		futurestuff.texOffs(22, 40).addBox(-10.0F, -12.4722F, 29.4314F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		futurestuff.texOffs(0, 56).addBox(-1.0F, -11.9722F, 28.4314F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		futurestuff.texOffs(10, 66).addBox(2.5F, -13.9722F, 31.4314F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		futurestuff.texOffs(10, 66).addBox(-3.5F, -13.9722F, 31.4314F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		futurestuff.texOffs(21, 122).addBox(-7.5F, -11.9722F, 30.9314F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		futurestuff.texOffs(21, 122).addBox(4.5F, -11.9722F, 30.9314F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		futurestuff.texOffs(21, 122).addBox(-1.5F, -11.9722F, 30.9314F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		futurestuff.texOffs(33, 66).addBox(8.75F, -13.9722F, 29.9314F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		futurestuff.texOffs(27, 66).addBox(8.75F, -13.4722F, 31.4314F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		futurestuff.texOffs(18, 66).addBox(8.75F, -12.9722F, 32.9314F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		futurestuff.texOffs(22, 33).addBox(7.75F, -11.9722F, 29.4314F, 3.0F, 1.0F, 6.0F, 0.0F, false);
		futurestuff.texOffs(27, 84).addBox(-5.0F, -16.9722F, 25.4314F, 10.0F, 1.0F, 3.0F, 0.0F, false);
		futurestuff.texOffs(128, 78).addBox(-2.5F, -17.9722F, 26.4314F, 5.0F, 1.0F, 2.0F, 0.0F, false);
		futurestuff.texOffs(88, 118).addBox(6.0F, -12.9722F, 32.9314F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		bone79 = new ModelRenderer(this);
		bone79.setPos(-10.0F, -10.9722F, 34.9314F);
		futurestuff.addChild(bone79);
		setRotationAngle(bone79, 0.0F, 0.0F, -0.3054F);
		bone79.texOffs(0, 114).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		bone79.texOffs(27, 66).addBox(-0.5489F, -1.4306F, -5.5F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		bone54 = new ModelRenderer(this);
		bone54.setPos(6.0F, -10.9722F, 34.4314F);
		futurestuff.addChild(bone54);
		setRotationAngle(bone54, 0.0F, 0.0F, 0.3491F);
		bone54.texOffs(52, 109).addBox(-5.0F, -2.0F, -1.5F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		bone78 = new ModelRenderer(this);
		bone78.setPos(1.0F, -2.5519F, 45.5112F);
		futurestuff.addChild(bone78);
		setRotationAngle(bone78, 0.1134F, 0.0F, 0.0F);
		bone78.texOffs(128, 75).addBox(-4.0F, -2.0F, -1.75F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		bone68 = new ModelRenderer(this);
		bone68.setPos(15.1F, -18.3972F, 4.0064F);
		futurestuff.addChild(bone68);
		bone68.texOffs(126, 15).addBox(-11.0F, 2.0F, 21.925F, 5.0F, 1.0F, 2.0F, 0.0F, false);

		bone69 = new ModelRenderer(this);
		bone69.setPos(-2.1845F, 11.6697F, 40.0892F);
		bone68.addChild(bone69);
		setRotationAngle(bone69, 0.0F, 0.0F, 0.4189F);
		bone69.texOffs(22, 33).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		bone70 = new ModelRenderer(this);
		bone70.setPos(-15.1F, 15.8453F, 41.5049F);
		bone68.addChild(bone70);
		setRotationAngle(bone70, 0.1134F, 0.0F, 0.0F);
		bone70.texOffs(122, 108).addBox(3.0F, -1.75F, -2.75F, 5.0F, 2.0F, 3.0F, 0.0F, false);
		bone70.texOffs(88, 98).addBox(7.75F, -1.25F, -2.25F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		bone71 = new ModelRenderer(this);
		bone71.setPos(10.75F, -0.2532F, -1.3066F);
		bone70.addChild(bone71);
		setRotationAngle(bone71, 0.0F, 0.0F, -0.7854F);
		bone71.texOffs(38, 39).addBox(0.0F, -0.9968F, -0.9434F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bone71.texOffs(37, 12).addBox(0.4119F, -0.9977F, -0.9434F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		bone72 = new ModelRenderer(this);
		bone72.setPos(11.75F, -1.25F, -2.25F);
		bone70.addChild(bone72);
		bone72.texOffs(37, 4).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		bone73 = new ModelRenderer(this);
		bone73.setPos(-2.85F, 10.6472F, 3.8936F);
		bone68.addChild(bone73);
		setRotationAngle(bone73, 0.0F, 0.0F, -0.3054F);
		bone73.texOffs(18, 117).addBox(-0.6727F, -3.2389F, 21.7814F, 1.0F, 2.0F, 14.0F, 0.0F, false);
		bone73.texOffs(22, 8).addBox(-0.6727F, -1.8247F, 35.1956F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		bone74 = new ModelRenderer(this);
		bone74.setPos(-0.1727F, -3.2389F, 35.0314F);
		bone73.addChild(bone74);
		setRotationAngle(bone74, -0.7854F, 0.0F, 0.0F);
		bone74.texOffs(0, 49).addBox(-0.525F, -0.5303F, 0.5303F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		bone75 = new ModelRenderer(this);
		bone75.setPos(-6.1F, 2.425F, 22.925F);
		bone68.addChild(bone75);
		setRotationAngle(bone75, 0.0F, 0.0F, -0.4276F);
		bone75.texOffs(0, 10).addBox(-0.7328F, -0.3453F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
		bone75.texOffs(10, 45).addBox(-0.7328F, 5.6547F, 1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		bone76 = new ModelRenderer(this);
		bone76.setPos(0.2672F, 7.6547F, 3.0F);
		bone75.addChild(bone76);
		setRotationAngle(bone76, 0.0349F, -0.2618F, 0.0F);
		bone76.texOffs(15, 6).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone77 = new ModelRenderer(this);
		bone77.setPos(0.2672F, 5.6547F, -1.0F);
		bone75.addChild(bone77);
		setRotationAngle(bone77, 0.7854F, 0.0F, 0.0F);
		bone77.texOffs(0, 45).addBox(-1.025F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone77.texOffs(38, 16).addBox(-1.025F, 0.825F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		bone58 = new ModelRenderer(this);
		bone58.setPos(-15.1F, -18.3972F, 4.0064F);
		futurestuff.addChild(bone58);
		bone58.texOffs(126, 15).addBox(6.0F, 2.0F, 21.925F, 5.0F, 1.0F, 2.0F, 0.0F, true);

		bone59 = new ModelRenderer(this);
		bone59.setPos(2.1845F, 11.6697F, 40.0892F);
		bone58.addChild(bone59);
		setRotationAngle(bone59, 0.0F, 0.0F, -0.4189F);
		bone59.texOffs(22, 33).addBox(0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, true);

		bone60 = new ModelRenderer(this);
		bone60.setPos(15.1F, 15.8453F, 41.5049F);
		bone58.addChild(bone60);
		setRotationAngle(bone60, 0.1134F, 0.0F, 0.0F);
		bone60.texOffs(122, 108).addBox(-8.0F, -1.75F, -2.75F, 5.0F, 2.0F, 3.0F, 0.0F, true);
		bone60.texOffs(88, 98).addBox(-10.75F, -1.25F, -2.25F, 3.0F, 1.0F, 2.0F, 0.0F, true);

		bone61 = new ModelRenderer(this);
		bone61.setPos(-10.75F, -0.2532F, -1.3066F);
		bone60.addChild(bone61);
		setRotationAngle(bone61, 0.0F, 0.0F, 0.7854F);
		bone61.texOffs(38, 39).addBox(-1.0F, -0.9968F, -0.9434F, 1.0F, 1.0F, 2.0F, 0.0F, true);
		bone61.texOffs(37, 12).addBox(-1.4119F, -0.9977F, -0.9434F, 1.0F, 1.0F, 2.0F, 0.0F, true);

		bone62 = new ModelRenderer(this);
		bone62.setPos(-11.75F, -1.25F, -2.25F);
		bone60.addChild(bone62);
		bone62.texOffs(37, 4).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

		bone63 = new ModelRenderer(this);
		bone63.setPos(2.85F, 10.6472F, 3.8936F);
		bone58.addChild(bone63);
		setRotationAngle(bone63, 0.0F, 0.0F, 0.3054F);
		bone63.texOffs(18, 117).addBox(-0.3273F, -3.2389F, 21.7814F, 1.0F, 2.0F, 14.0F, 0.0F, true);
		bone63.texOffs(22, 8).addBox(-0.3273F, -1.8247F, 35.1956F, 1.0F, 3.0F, 2.0F, 0.0F, true);

		bone64 = new ModelRenderer(this);
		bone64.setPos(0.1727F, -3.2389F, 35.0314F);
		bone63.addChild(bone64);
		setRotationAngle(bone64, -0.7854F, 0.0F, 0.0F);
		bone64.texOffs(0, 49).addBox(-0.475F, -0.5303F, 0.5303F, 1.0F, 2.0F, 2.0F, 0.0F, true);

		bone65 = new ModelRenderer(this);
		bone65.setPos(6.1F, 2.425F, 22.925F);
		bone58.addChild(bone65);
		setRotationAngle(bone65, 0.0F, 0.0F, 0.4276F);
		bone65.texOffs(0, 10).addBox(-0.2672F, -0.3453F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, true);
		bone65.texOffs(10, 45).addBox(-0.2672F, 5.6547F, 1.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);

		bone66 = new ModelRenderer(this);
		bone66.setPos(-0.2672F, 7.6547F, 3.0F);
		bone65.addChild(bone66);
		setRotationAngle(bone66, 0.0349F, 0.2618F, 0.0F);
		bone66.texOffs(15, 6).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, true);

		bone67 = new ModelRenderer(this);
		bone67.setPos(-0.2672F, 5.6547F, -1.0F);
		bone65.addChild(bone67);
		setRotationAngle(bone67, 0.7854F, 0.0F, 0.0F);
		bone67.texOffs(0, 45).addBox(0.025F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);
		bone67.texOffs(38, 16).addBox(0.025F, 0.825F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);

		bone55 = new ModelRenderer(this);
		bone55.setPos(-6.0F, -10.9722F, 34.4314F);
		futurestuff.addChild(bone55);
		setRotationAngle(bone55, 0.0F, 0.0F, -0.3491F);
		bone55.texOffs(52, 109).addBox(0.0F, -2.0F, -1.5F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		bone52 = new ModelRenderer(this);
		bone52.setPos(6.0F, -13.9722F, 40.4314F);
		futurestuff.addChild(bone52);
		setRotationAngle(bone52, 0.2618F, 0.0F, 0.0F);
		bone52.texOffs(34, 117).addBox(-1.0F, 0.0F, -1.0F, 4.0F, 4.0F, 9.0F, 0.0F, false);
		bone52.texOffs(116, 45).addBox(-2.0F, 0.0F, 3.0F, 1.0F, 4.0F, 5.0F, 0.0F, false);

		bone53 = new ModelRenderer(this);
		bone53.setPos(0.0F, 4.0F, 8.0F);
		bone52.addChild(bone53);
		setRotationAngle(bone53, -0.3927F, 0.0F, 0.0F);
		bone53.texOffs(66, 120).addBox(-2.0F, 0.0F, -3.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);

		bone56 = new ModelRenderer(this);
		bone56.setPos(-6.0F, -13.9722F, 40.4314F);
		futurestuff.addChild(bone56);
		setRotationAngle(bone56, 0.2618F, 0.0F, 0.0F);
		bone56.texOffs(34, 117).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 4.0F, 9.0F, 0.0F, true);
		bone56.texOffs(116, 45).addBox(1.0F, 0.0F, 3.0F, 1.0F, 4.0F, 5.0F, 0.0F, true);

		bone57 = new ModelRenderer(this);
		bone57.setPos(0.0F, 4.0F, 8.0F);
		bone56.addChild(bone57);
		setRotationAngle(bone57, -0.3927F, 0.0F, 0.0F);
		bone57.texOffs(66, 120).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 3.0F, 3.0F, 0.0F, true);

		interior = new ModelRenderer(this);
		interior.setPos(0.0F, 23.0F, -17.0F);
		interior.texOffs(51, 121).addBox(-1.5F, -9.9791F, 16.8575F, 3.0F, 4.0F, 9.0F, 0.0F, false);
		interior.texOffs(71, 111).addBox(-2.5F, -13.9791F, 23.8575F, 5.0F, 3.0F, 2.0F, 0.0F, false);
		interior.texOffs(27, 71).addBox(-5.5F, -13.4791F, 24.3575F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		interior.texOffs(27, 71).addBox(2.5F, -13.4791F, 24.3575F, 3.0F, 2.0F, 2.0F, 0.0F, true);

		bone5 = new ModelRenderer(this);
		bone5.setPos(0.0F, -9.9791F, -12.1425F);
		interior.addChild(bone5);
		setRotationAngle(bone5, 0.0873F, 0.0F, 0.0F);
		bone5.texOffs(0, 100).addBox(-10.5F, 0.0F, 20.0F, 21.0F, 3.0F, 3.0F, 0.0F, false);
		bone5.texOffs(104, 111).addBox(5.5F, 1.0F, 20.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		bone5.texOffs(71, 105).addBox(-11.0F, 1.0F, 19.0F, 22.0F, 5.0F, 1.0F, 0.0F, false);
		bone5.texOffs(0, 33).addBox(-3.0F, 3.0F, 20.0F, 6.0F, 4.0F, 3.0F, 0.0F, false);
		bone5.texOffs(131, 43).addBox(-2.5F, 0.0F, 23.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		bone5.texOffs(128, 72).addBox(-2.5F, 2.0F, 22.5F, 5.0F, 1.0F, 2.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setPos(6.5F, 2.0F, 24.475F);
		bone5.addChild(bone10);
		setRotationAngle(bone10, 0.0F, 0.0F, 0.1309F);
		bone10.texOffs(34, 34).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 1.0F, 0.0F, false);

		bone104 = new ModelRenderer(this);
		bone104.setPos(-0.5F, -9.9791F, -6.1425F);
		interior.addChild(bone104);
		bone104.texOffs(122, 100).addBox(-9.0F, 2.0F, 20.0F, 7.0F, 2.0F, 6.0F, 0.0F, false);

		bone105 = new ModelRenderer(this);
		bone105.setPos(-6.0F, 4.0F, 25.0F);
		bone104.addChild(bone105);
		setRotationAngle(bone105, -0.2618F, 0.0F, 0.0F);
		bone105.texOffs(17, 106).addBox(-2.5F, -8.2588F, -0.0341F, 6.0F, 8.0F, 2.0F, 0.0F, false);

		bone37 = new ModelRenderer(this);
		bone37.setPos(0.5F, -9.9791F, -6.1425F);
		interior.addChild(bone37);
		bone37.texOffs(122, 100).addBox(2.0F, 2.0F, 20.0F, 7.0F, 2.0F, 6.0F, 0.0F, true);

		bone38 = new ModelRenderer(this);
		bone38.setPos(6.0F, 4.0F, 25.0F);
		bone37.addChild(bone38);
		setRotationAngle(bone38, -0.2618F, 0.0F, 0.0F);
		bone38.texOffs(17, 106).addBox(-3.5F, -8.2588F, -0.0341F, 6.0F, 8.0F, 2.0F, 0.0F, true);

		left_door = new ModelRenderer(this);
		left_door.setPos(4.0F, 7.0278F, 4.3105F);
		left_door.texOffs(103, 103).addBox(6.5F, 8.2222F, -10.8791F, 2.0F, 1.0F, 15.0F, 0.025F, false);
		left_door.texOffs(0, 106).addBox(6.0F, 8.2222F, -10.8791F, 1.0F, 1.0F, 15.0F, 0.025F, false);
		left_door.texOffs(119, 120).addBox(0.0F, 0.0F, -4.8791F, 5.0F, 1.0F, 9.0F, 0.0F, false);

		bone87 = new ModelRenderer(this);
		bone87.setPos(8.5F, 9.2222F, -12.3105F);
		left_door.addChild(bone87);
		setRotationAngle(bone87, 0.0F, 0.0F, 0.2618F);
		bone87.texOffs(52, 102).addBox(-2.0F, 0.0F, 1.4314F, 2.0F, 3.0F, 15.0F, 0.0F, false);

		bone82 = new ModelRenderer(this);
		bone82.setPos(8.25F, 8.2222F, -13.4105F);
		left_door.addChild(bone82);
		setRotationAngle(bone82, 0.0F, 0.0F, -0.3054F);
		bone82.texOffs(33, 98).addBox(-2.0F, -4.0F, 2.5314F, 2.0F, 4.0F, 15.0F, 0.0F, false);

		bone93 = new ModelRenderer(this);
		bone93.setPos(-0.5F, -4.65F, 2.5314F);
		bone82.addChild(bone93);
		setRotationAngle(bone93, -1.0123F, 0.0F, 0.0F);
		

		bone100 = new ModelRenderer(this);
		bone100.setPos(0.0F, 0.0F, 0.0F);
		bone93.addChild(bone100);
		setRotationAngle(bone100, 0.0F, 0.0F, -0.0611F);
		bone100.texOffs(11, 0).addBox(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		bone80 = new ModelRenderer(this);
		bone80.setPos(7.5F, 4.75F, -10.5291F);
		left_door.addChild(bone80);
		setRotationAngle(bone80, -0.0873F, -0.5236F, 0.0F);
		bone80.texOffs(118, 100).addBox(-1.0F, -2.0F, 0.0F, 4.0F, 2.0F, 1.0F, 0.0F, true);

		bone83 = new ModelRenderer(this);
		bone83.setPos(5.0F, 0.0F, 4.6209F);
		left_door.addChild(bone83);
		setRotationAngle(bone83, 0.0F, 0.0F, -0.4276F);
		bone83.texOffs(15, 0).addBox(-1.0F, 0.0F, -1.475F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		right_door = new ModelRenderer(this);
		right_door.setPos(-4.0F, 7.0278F, 4.3105F);
		right_door.texOffs(103, 103).addBox(-8.5F, 8.2222F, -10.8791F, 2.0F, 1.0F, 15.0F, 0.025F, true);
		right_door.texOffs(0, 106).addBox(-7.0F, 8.2222F, -10.8791F, 1.0F, 1.0F, 15.0F, 0.025F, true);
		right_door.texOffs(119, 120).addBox(-5.0F, 0.0F, -4.8791F, 5.0F, 1.0F, 9.0F, 0.0F, true);

		bone101 = new ModelRenderer(this);
		bone101.setPos(-8.5F, 9.2222F, -12.3105F);
		right_door.addChild(bone101);
		setRotationAngle(bone101, 0.0F, 0.0F, -0.2618F);
		bone101.texOffs(52, 102).addBox(0.0F, 0.0F, 1.4314F, 2.0F, 3.0F, 15.0F, 0.0F, true);

		bone111 = new ModelRenderer(this);
		bone111.setPos(-8.25F, 8.2222F, -13.4105F);
		right_door.addChild(bone111);
		setRotationAngle(bone111, 0.0F, 0.0F, 0.3054F);
		bone111.texOffs(33, 98).addBox(0.0F, -4.0F, 2.5314F, 2.0F, 4.0F, 15.0F, 0.0F, true);

		bone113 = new ModelRenderer(this);
		bone113.setPos(0.5F, -4.65F, 2.5314F);
		bone111.addChild(bone113);
		setRotationAngle(bone113, -1.0123F, 0.0F, 0.0F);
		

		bone116 = new ModelRenderer(this);
		bone116.setPos(0.0F, 0.0F, 0.0F);
		bone113.addChild(bone116);
		setRotationAngle(bone116, 0.0F, 0.0F, 0.0611F);
		bone116.texOffs(11, 0).addBox(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, true);

		bone117 = new ModelRenderer(this);
		bone117.setPos(-7.5F, 4.75F, -10.5291F);
		right_door.addChild(bone117);
		setRotationAngle(bone117, -0.0873F, 0.5236F, 0.0F);
		bone117.texOffs(118, 100).addBox(-3.0F, -2.0F, 0.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);

		bone118 = new ModelRenderer(this);
		bone118.setPos(-5.0F, 0.0F, 4.6209F);
		right_door.addChild(bone118);
		setRotationAngle(bone118, 0.0F, 0.0F, 0.4276F);
		bone118.texOffs(15, 0).addBox(0.0F, 0.0F, -1.475F, 1.0F, 5.0F, 1.0F, 0.0F, true);
	}

	@Override
	public void setupAnim(DeloreanEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		left_door.zRot = (float) Math.toRadians(entity.doorPosition);
		right_door.zRot = - (float) Math.toRadians(entity.doorPosition);
		if(entity.isActivelyDriving) {
			bone52.y = entity.newYPositions;
			bone56.y = entity.newYPositions;
		}
		if(entity.isNoGravity()) {
			front_left_wheel_rotate_Z75.zRot = 120.5f;
			front_right_wheel_rotate_Z75.zRot = -120.5f;
			back_left_wheel_rotate_Z75.zRot = 120.5f;
			back_right_wheel_rotate_Z75.zRot = -120.5f;
			bluebit_translate_6.x = -3;
			bluebit1_translate_6.x = 2;
			bluebit2_translate_6.x = -3;
			bluebit3_translate_6.x = 3;
			bone52.y = entity.newYPositions;
			bone56.y = entity.newYPositions;
			//car.y = entity.newYPositions;
			//futurestuff.y = entity.newYPositions;
			//interior.y = entity.newYPositions;
			//left_door.y = entity.doorNewYPositions;
			//right_door.y = entity.doorNewYPositions;
		} else {
			front_left_wheel_rotate_Z75.zRot = 0;
			front_right_wheel_rotate_Z75.zRot = 0;
			back_left_wheel_rotate_Z75.zRot = 0;
			back_right_wheel_rotate_Z75.zRot = 0;
			bluebit_translate_6.x = 3.75f;
			bluebit1_translate_6.x = -4.75f;
			bluebit2_translate_6.x = 3.75f;
			bluebit3_translate_6.x = -3.75f;
		}
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		matrixStack.pushPose();
		matrixStack.scale(1.5f, 1.5f, 1.5f);
		matrixStack.translate(0, -0.5f, 0);
		car.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		futurestuff.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		interior.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		left_door.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		right_door.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		matrixStack.popPose();
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
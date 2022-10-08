package com.mdt.ait.client.models.entities;// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.AIT;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.entities.K9Entity;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

public class K9EntityModel extends EntityModel<WolfEntity> {

    public static final ResourceLocation LIGHTING = new ResourceLocation(AIT.MOD_ID, "textures/entity/k9_emission.png");

    public final ModelRenderer Body;
    public final ModelRenderer Base;
    public final ModelRenderer Faces;
    public final ModelRenderer Blank;
    public final ModelRenderer cube_r1;
    public final ModelRenderer cube_r2;
    public final ModelRenderer cube_r3;
    public final ModelRenderer cube_r4;
    public final ModelRenderer cube_r5;
    public final ModelRenderer cube_r6;
    public final ModelRenderer K9;
    public final ModelRenderer cube_r7;
    public final ModelRenderer cube_r8;
    public final ModelRenderer cube_r9;
    public final ModelRenderer cube_r10;
    public final ModelRenderer cube_r11;
    public final ModelRenderer cube_r12;
    public final ModelRenderer Back;
    public final ModelRenderer cube_r13;
    public final ModelRenderer cube_r14;
    public final ModelRenderer cube_r15;
    public final ModelRenderer Front;
    public final ModelRenderer cube_r16;
    public final ModelRenderer cube_r17;
    public final ModelRenderer cube_r18;
    public final ModelRenderer Top;
    public final ModelRenderer cube_r19;
    public final ModelRenderer Tail;
    public final ModelRenderer cube_r20;
    public final ModelRenderer Head;
    public final ModelRenderer cube_r21;
    public final ModelRenderer HeadTwist;
    public final ModelRenderer cube_r22;
    public final ModelRenderer cube_r23;
    public final ModelRenderer cube_r24;
    public final ModelRenderer cube_r25;

    public K9EntityModel() {
        texWidth = 128;
        texHeight = 128;

        Body = new ModelRenderer(this);
        Body.setPos(0.0F, 24.0F, 0.0F);


        Base = new ModelRenderer(this);
        Base.setPos(0.0F, 0.0F, 0.0F);
        Body.addChild(Base);
        Base.texOffs(0, 0).addBox(-7.5F, -3.0F, -10.5F, 15.0F, 3.0F, 21.0F, -0.05F, false);
        Base.texOffs(23, 24).addBox(-7.0F, -2.5F, 10.5F, 14.0F, 2.0F, 2.0F, 0.0F, false);
        Base.texOffs(23, 24).addBox(-7.0F, -2.5F, -12.5F, 14.0F, 2.0F, 2.0F, 0.0F, false);
        Base.texOffs(22, 29).addBox(-9.5F, -2.5F, -10.0F, 2.0F, 2.0F, 20.0F, 0.0F, false);
        Base.texOffs(22, 29).addBox(7.5F, -2.5F, -10.0F, 2.0F, 2.0F, 20.0F, 0.0F, true);

        Faces = new ModelRenderer(this);
        Faces.setPos(0.0F, 0.0F, 0.0F);
        Body.addChild(Faces);


        Blank = new ModelRenderer(this);
        Blank.setPos(0.0F, 0.0F, 0.0F);
        Faces.addChild(Blank);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(-6.5359F, -13.4641F, -6.3647F);
        Blank.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.7854F, 0.0F, 0.2618F);
        cube_r1.texOffs(13, 0).addBox(1.0F, 1.0F, 1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(-5.567F, -17.0801F, -6.2954F);
        Blank.addChild(cube_r2);
        setRotationAngle(cube_r2, -0.2618F, 0.0F, 0.2618F);
        cube_r2.texOffs(0, 24).addBox(1.0F, 2.0F, 1.0F, 2.0F, 4.0F, 2.0F, 0.001F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(-8.0F, -8.0F, 11.0F);
        Blank.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.2618F, 0.0F, 0.2618F);
        cube_r3.texOffs(0, 49).addBox(1.0F, -8.0F, -3.0F, 2.0F, 14.0F, 2.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(-8.0F, -8.0F, -11.125F);
        Blank.addChild(cube_r4);
        setRotationAngle(cube_r4, -0.2618F, 0.0F, 0.2618F);
        cube_r4.texOffs(23, 32).addBox(1.0F, -1.0F, 1.0F, 2.0F, 7.0F, 2.0F, 0.001F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setPos(-4.394F, -13.7305F, 6.9635F);
        Blank.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, 0.0F, 0.2618F);
        cube_r5.texOffs(0, 24).addBox(-0.25F, 6.0F, -16.5F, 2.0F, 6.0F, 19.0F, 0.0F, false);
        cube_r5.texOffs(10, 65).addBox(-0.875F, 1.0F, -15.0F, 2.0F, 5.0F, 16.0F, 0.0F, false);
        cube_r5.texOffs(51, 0).addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 14.0F, -0.01F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setPos(-1.2385F, -7.5223F, -0.0365F);
        Blank.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.0F, 0.0F, -0.3491F);
        cube_r6.texOffs(50, 39).addBox(-5.0F, -2.5F, -8.0F, 2.0F, 2.0F, 16.0F, 0.0F, false);

        K9 = new ModelRenderer(this);
        K9.setPos(0.0F, 0.0F, 0.0F);
        Faces.addChild(K9);


        cube_r7 = new ModelRenderer(this);
        cube_r7.setPos(6.5359F, -13.4641F, -6.3647F);
        K9.addChild(cube_r7);
        setRotationAngle(cube_r7, -0.7854F, 0.0F, -0.2618F);
        cube_r7.texOffs(13, 0).addBox(-3.0F, 1.0F, 1.0F, 2.0F, 5.0F, 2.0F, 0.0F, true);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setPos(5.567F, -17.0801F, -6.2954F);
        K9.addChild(cube_r8);
        setRotationAngle(cube_r8, -0.2618F, 0.0F, -0.2618F);
        cube_r8.texOffs(0, 24).addBox(-3.0F, 2.0F, 1.0F, 2.0F, 4.0F, 2.0F, 0.001F, true);

        cube_r9 = new ModelRenderer(this);
        cube_r9.setPos(8.0F, -8.0F, 11.0F);
        K9.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.2618F, 0.0F, -0.2618F);
        cube_r9.texOffs(0, 49).addBox(-3.0F, -8.0F, -3.0F, 2.0F, 14.0F, 2.0F, 0.0F, true);

        cube_r10 = new ModelRenderer(this);
        cube_r10.setPos(8.0F, -8.0F, -11.125F);
        K9.addChild(cube_r10);
        setRotationAngle(cube_r10, -0.2618F, 0.0F, -0.2618F);
        cube_r10.texOffs(23, 32).addBox(-3.0F, -1.0F, 1.0F, 2.0F, 7.0F, 2.0F, 0.001F, true);

        cube_r11 = new ModelRenderer(this);
        cube_r11.setPos(4.394F, -13.7305F, 6.9635F);
        K9.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.0F, 0.0F, -0.2618F);
        cube_r11.texOffs(0, 24).addBox(-1.75F, 6.0F, -16.5F, 2.0F, 6.0F, 19.0F, 0.0F, true);
        cube_r11.texOffs(0, 49).addBox(-1.125F, 1.0F, -15.0F, 2.0F, 5.0F, 16.0F, 0.0F, true);
        cube_r11.texOffs(51, 0).addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 14.0F, -0.01F, true);

        cube_r12 = new ModelRenderer(this);
        cube_r12.setPos(1.2385F, -7.5223F, -0.0365F);
        K9.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.0F, 0.0F, 0.3491F);
        cube_r12.texOffs(50, 39).addBox(3.0F, -2.5F, -8.0F, 2.0F, 2.0F, 16.0F, 0.0F, true);

        Back = new ModelRenderer(this);
        Back.setPos(0.0F, 0.0F, 0.0F);
        Faces.addChild(Back);
        Back.texOffs(46, 24).addBox(-4.9989F, -14.8553F, -5.9365F, 10.0F, 2.0F, 13.0F, 0.1F, false);

        cube_r13 = new ModelRenderer(this);
        cube_r13.setPos(-0.3511F, -4.914F, -10.3232F);
        Back.addChild(cube_r13);
        setRotationAngle(cube_r13, -0.2618F, 0.0F, 0.0F);
        cube_r13.texOffs(0, 33).addBox(-1.1489F, -3.0F, -1.5F, 3.0F, 1.0F, 2.0F, 0.075F, false);
        cube_r13.texOffs(66, 57).addBox(-6.1489F, -3.5F, -0.5F, 13.0F, 2.0F, 2.0F, -0.05F, false);

        cube_r14 = new ModelRenderer(this);
        cube_r14.setPos(0.0F, -9.0591F, -6.7551F);
        Back.addChild(cube_r14);
        setRotationAngle(cube_r14, -0.8727F, 0.0F, 0.0F);
        cube_r14.texOffs(69, 5).addBox(-6.0F, -1.25F, -1.0F, 12.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r15 = new ModelRenderer(this);
        cube_r15.setPos(0.0F, -5.0F, -10.5F);
        Back.addChild(cube_r15);
        setRotationAngle(cube_r15, -0.2618F, 0.0F, 0.0F);
        cube_r15.texOffs(10, 24).addBox(-1.5F, -9.0F, 1.25F, 3.0F, 3.0F, 1.0F, 0.0F, false);
        cube_r15.texOffs(70, 39).addBox(-5.0F, -9.75F, 2.25F, 10.0F, 4.0F, 1.0F, 0.0F, false);
        cube_r15.texOffs(69, 0).addBox(-6.5F, -1.5F, 0.0F, 13.0F, 4.0F, 1.0F, 0.0F, false);

        Front = new ModelRenderer(this);
        Front.setPos(0.0F, 0.0F, 0.0F);
        Faces.addChild(Front);


        cube_r16 = new ModelRenderer(this);
        cube_r16.setPos(-0.3511F, -4.914F, 10.3232F);
        Front.addChild(cube_r16);
        setRotationAngle(cube_r16, 0.2618F, 0.0F, 0.0F);
        cube_r16.texOffs(51, 16).addBox(-6.1489F, -3.5F, -1.625F, 13.0F, 2.0F, 2.0F, -0.05F, false);
        cube_r16.texOffs(31, 32).addBox(-1.1489F, -3.0F, -0.625F, 3.0F, 1.0F, 2.0F, 0.075F, false);

        cube_r17 = new ModelRenderer(this);
        cube_r17.setPos(0.0239F, -4.66F, 10.5927F);
        Front.addChild(cube_r17);
        setRotationAngle(cube_r17, 0.2618F, 0.0F, 0.0F);
        cube_r17.texOffs(66, 61).addBox(-5.0239F, -10.75F, -1.0F, 10.0F, 1.0F, 1.0F, 0.125F, false);

        cube_r18 = new ModelRenderer(this);
        cube_r18.setPos(0.0F, -5.0F, 10.5F);
        Front.addChild(cube_r18);
        setRotationAngle(cube_r18, 0.2618F, 0.0F, 0.0F);
        cube_r18.texOffs(20, 51).addBox(-6.5F, -9.5F, -1.0F, 13.0F, 12.0F, 1.0F, 0.0F, false);

        Top = new ModelRenderer(this);
        Top.setPos(0.1F, -15.057F, 0.0702F);
        Faces.addChild(Top);
        Top.texOffs(8, 33).addBox(-2.1F, -0.8982F, 5.9298F, 4.0F, 1.0F, 1.0F, 0.125F, false);
        Top.texOffs(27, 65).addBox(-3.1F, -0.8982F, -4.0702F, 6.0F, 1.0F, 8.0F, 0.0F, false);

        cube_r19 = new ModelRenderer(this);
        cube_r19.setPos(1.0F, 0.0F, 0.0F);
        Top.addChild(cube_r19);
        setRotationAngle(cube_r19, 0.3491F, 0.0F, 0.0F);
        cube_r19.texOffs(28, 64).addBox(-4.1F, -0.5F, 1.0F, 6.0F, 1.0F, 3.0F, 0.01F, false);

        Tail = new ModelRenderer(this);
        Tail.setPos(0.0F, -12.0F, -7.25F);
        Body.addChild(Tail);


        cube_r20 = new ModelRenderer(this);
        cube_r20.setPos(0.0F, 7.0F, -3.0F);
        Tail.addChild(cube_r20);
        setRotationAngle(cube_r20, -0.2618F, 0.0F, 0.0F);
        cube_r20.texOffs(0, 11).addBox(-0.5F, -8.0F, -7.5F, 1.0F, 1.0F, 1.0F, 0.25F, false);
        cube_r20.texOffs(0, 24).addBox(-0.5F, -8.0F, -6.5F, 1.0F, 1.0F, 8.0F, 0.0F, false);

        Head = new ModelRenderer(this);
        Head.setPos(0.0F, 13.4921F, 8.1207F);


        cube_r21 = new ModelRenderer(this);
        cube_r21.setPos(-0.5F, 5.5079F, 2.3793F);
        Head.addChild(cube_r21);
        setRotationAngle(cube_r21, 0.6109F, 0.0F, 0.0F);
        cube_r21.texOffs(65, 64).addBox(-1.5F, -7.5F, 1.0F, 4.0F, 4.0F, 7.0F, 0.0F, false);

        HeadTwist = new ModelRenderer(this);
        HeadTwist.setPos(0.0F, -3.0F, 5.0F);
        Head.addChild(HeadTwist);


        cube_r22 = new ModelRenderer(this);
        cube_r22.setPos(0.2371F, -2.3062F, 8.8106F);
        HeadTwist.addChild(cube_r22);
        setRotationAngle(cube_r22, -0.1747F, 0.043F, -0.0076F);
        cube_r22.texOffs(0, 0).addBox(-3.0F, -1.5F, -5.5F, 3.0F, 4.0F, 7.0F, 0.001F, false);

        cube_r23 = new ModelRenderer(this);
        cube_r23.setPos(-0.2371F, -2.3062F, 8.8106F);
        HeadTwist.addChild(cube_r23);
        setRotationAngle(cube_r23, -0.1747F, -0.043F, 0.0076F);
        cube_r23.texOffs(0, 70).addBox(0.0F, -1.5F, -5.5F, 3.0F, 4.0F, 7.0F, 0.0F, false);

        cube_r24 = new ModelRenderer(this);
        cube_r24.setPos(0.0F, -2.0565F, 8.9799F);
        HeadTwist.addChild(cube_r24);
        setRotationAngle(cube_r24, 0.0873F, 0.0F, 0.0F);
        cube_r24.texOffs(0, 11).addBox(-2.5F, -1.5F, -4.5F, 5.0F, 4.0F, 5.0F, -0.001F, false);

        cube_r25 = new ModelRenderer(this);
        cube_r25.setPos(0.0F, -1.4464F, 2.0065F);
        HeadTwist.addChild(cube_r25);
        setRotationAngle(cube_r25, 0.0873F, 0.0F, 0.0F);
        cube_r25.texOffs(0, 0).addBox(-3.0F, -7.5F, -0.5F, 2.0F, 2.0F, 1.0F, 0.125F, false);
        cube_r25.texOffs(0, 3).addBox(1.0F, -7.5F, -0.5F, 2.0F, 2.0F, 1.0F, 0.125F, false);
        cube_r25.texOffs(48, 57).addBox(-3.0F, -5.5F, -3.5F, 6.0F, 8.0F, 6.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(WolfEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        this.HeadTwist.xRot = p_225597_6_ * ((float)Math.PI / 300f);
        this.HeadTwist.yRot = p_225597_5_ * ((float)Math.PI / 300f);
    }


    public void prepareMobModel(WolfEntity p_212843_1_, float p_212843_2_, float p_212843_3_, float p_212843_4_) {
        if (p_212843_1_.isAngry()) {
            this.Tail.yRot = 0.0F;
        } else {
            this.Tail.yRot = MathHelper.cos(p_212843_2_ * 0.6662F) * 1.4F * p_212843_3_;
        }
        if (p_212843_1_.isInSittingPose()){
            this.Body.setPos(0.0F, 25.0F, 0.0F);
            this.Body.xRot = ((float)Math.PI * 180F);
            this.Head.setPos(0.0F, 15F, 7.0F);
        }
        else {
            this.Body.setPos(0.0F, 24F, 0.0F);
            this.Body.xRot = ((float)Math.PI * 180F);
            this.Head.setPos(0.0F, 14F, 7.0F);
        }
    }
    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        matrixStack.pushPose();
        matrixStack.mulPose(new Quaternion(Vector3f.YP, 180, true));
        matrixStack.scale(0.8F, 0.8F, 0.8F);
        matrixStack.translate(0, 0.38, 0);
        Body.render(matrixStack, buffer, packedLight, packedOverlay);
        Head.render(matrixStack, buffer, packedLight, packedOverlay);
        matrixStack.popPose();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
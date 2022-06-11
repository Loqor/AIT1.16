package com.mdt.ait.client.models.tileentities;

import com.mdt.ait.common.tileentities.TSVTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TSV extends EntityModel<Entity> {
    private final ModelRenderer bone;
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
    private final ModelRenderer cube_r17;
    private final ModelRenderer bone2;

    public TSV() {
        texWidth = 256;
        texHeight = 256;

        bone = new ModelRenderer(this);
        bone.setPos(0.0F, -8.0F, 0.0F);
        setRotationAngle(bone, -1.5708F, 0.0F, 0.0F);
        bone.texOffs(194, 154).addBox(-5.0F, -14.0F, 16.5F, 10.0F, 2.0F, 9.0F, 0.01F, false);
        bone.texOffs(45, 67).addBox(-5.0F, -12.0F, 0.0F, 10.0F, 4.0F, 25.0F, 0.0F, false);
        bone.texOffs(45, 46).addBox(-3.0F, -13.5F, 13.75F, 5.0F, 1.0F, 3.0F, 0.0F, false);
        bone.texOffs(0, 150).addBox(-6.0F, -17.0F, 20.25F, 12.0F, 7.0F, 10.0F, 0.0F, false);
        bone.texOffs(0, 0).addBox(-17.0F, -13.0F, -17.25F, 34.0F, 0.0F, 34.0F, 0.0F, false);
        bone.texOffs(14, 11).addBox(26.0F, -13.5F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        bone.texOffs(14, 0).addBox(-27.0F, -13.5F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.3927F, 0.0F);
        cube_r1.texOffs(135, 129).addBox(-6.0F, -17.0F, 20.25F, 12.0F, 7.0F, 10.0F, 0.01F, false);
        cube_r1.texOffs(45, 38).addBox(-3.0F, -13.5F, 13.75F, 5.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r1.texOffs(0, 63).addBox(-5.0F, -12.0F, 0.0F, 10.0F, 4.0F, 25.0F, 0.01F, false);
        cube_r1.texOffs(192, 17).addBox(-5.0F, -14.0F, 16.5F, 10.0F, 2.0F, 9.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 1.1781F, 0.0F);
        cube_r2.texOffs(44, 171).addBox(-4.0F, -16.0F, 26.5F, 11.0F, 4.0F, 9.0F, 0.01F, false);
        cube_r2.texOffs(45, 34).addBox(-3.0F, -13.5F, 13.75F, 5.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r2.texOffs(0, 34).addBox(-5.0F, -12.0F, 0.0F, 10.0F, 4.0F, 25.0F, 0.01F, false);
        cube_r2.texOffs(96, 193).addBox(-5.0F, -14.0F, 16.5F, 10.0F, 2.0F, 9.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 1.9635F, 0.0F);
        cube_r3.texOffs(179, 130).addBox(-7.0F, -16.0F, 26.5F, 11.0F, 4.0F, 9.0F, 0.01F, false);
        cube_r3.texOffs(14, 26).addBox(-3.0F, -13.5F, 13.75F, 5.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r3.texOffs(135, 29).addBox(-5.0F, -12.0F, 0.0F, 10.0F, 4.0F, 25.0F, 0.01F, false);
        cube_r3.texOffs(180, 29).addBox(-5.0F, -14.0F, 16.5F, 10.0F, 2.0F, 9.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 2.3562F, 0.0F);
        cube_r4.texOffs(167, 0).addBox(-6.0F, -17.0F, 20.25F, 12.0F, 7.0F, 10.0F, 0.0F, false);
        cube_r4.texOffs(14, 22).addBox(-3.0F, -13.5F, 13.75F, 5.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r4.texOffs(90, 129).addBox(-5.0F, -12.0F, 0.0F, 10.0F, 4.0F, 25.0F, 0.0F, false);
        cube_r4.texOffs(180, 40).addBox(-5.0F, -14.0F, 16.5F, 10.0F, 2.0F, 9.0F, 0.01F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, 2.7489F, 0.0F);
        cube_r5.texOffs(0, 167).addBox(-6.0F, -17.0F, 20.25F, 12.0F, 7.0F, 10.0F, 0.01F, false);
        cube_r5.texOffs(0, 71).addBox(-3.0F, -13.5F, 13.75F, 5.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r5.texOffs(45, 125).addBox(-5.0F, -12.0F, 0.0F, 10.0F, 4.0F, 25.0F, 0.01F, false);
        cube_r5.texOffs(180, 58).addBox(-5.0F, -14.0F, 16.5F, 10.0F, 2.0F, 9.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.0F, 3.1416F, 0.0F);
        cube_r6.texOffs(166, 165).addBox(-6.0F, -17.0F, 20.25F, 12.0F, 7.0F, 10.0F, 0.0F, false);
        cube_r6.texOffs(45, 67).addBox(-3.0F, -13.5F, 13.75F, 5.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r6.texOffs(0, 121).addBox(-5.0F, -12.0F, 0.0F, 10.0F, 4.0F, 25.0F, 0.0F, false);
        cube_r6.texOffs(180, 69).addBox(-5.0F, -14.0F, 16.5F, 10.0F, 2.0F, 9.0F, 0.01F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.0F, -2.7489F, 0.0F);
        cube_r7.texOffs(122, 165).addBox(-6.0F, -17.0F, 20.25F, 12.0F, 7.0F, 10.0F, 0.01F, false);
        cube_r7.texOffs(0, 63).addBox(-3.0F, -13.5F, 13.75F, 5.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r7.texOffs(122, 0).addBox(-5.0F, -12.0F, 0.0F, 10.0F, 4.0F, 25.0F, 0.01F, false);
        cube_r7.texOffs(106, 182).addBox(-5.0F, -14.0F, 16.5F, 10.0F, 2.0F, 9.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.0F, -2.3562F, 0.0F);
        cube_r8.texOffs(88, 158).addBox(-6.0F, -17.0F, 20.25F, 12.0F, 7.0F, 10.0F, 0.0F, false);
        cube_r8.texOffs(0, 67).addBox(-3.0F, -13.5F, 13.75F, 5.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r8.texOffs(90, 100).addBox(-5.0F, -12.0F, 0.0F, 10.0F, 4.0F, 25.0F, 0.0F, false);
        cube_r8.texOffs(144, 182).addBox(-5.0F, -14.0F, 16.5F, 10.0F, 2.0F, 9.0F, 0.01F, false);

        cube_r9 = new ModelRenderer(this);
        cube_r9.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.0F, -1.9635F, 0.0F);
        cube_r9.texOffs(179, 100).addBox(-4.0F, -16.0F, 26.5F, 11.0F, 4.0F, 9.0F, 0.01F, false);
        cube_r9.texOffs(61, 34).addBox(-3.0F, -13.5F, 13.75F, 5.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r9.texOffs(45, 96).addBox(-5.0F, -12.0F, 0.0F, 10.0F, 4.0F, 25.0F, 0.01F, false);
        cube_r9.texOffs(182, 182).addBox(-5.0F, -14.0F, 16.5F, 10.0F, 2.0F, 9.0F, 0.0F, false);

        cube_r10 = new ModelRenderer(this);
        cube_r10.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.3054F, -1.5708F, 0.0F);
        cube_r10.texOffs(0, 33).addBox(4.0F, -1.0F, 37.0F, 2.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r10.texOffs(0, 22).addBox(-6.0F, -1.0F, 37.0F, 2.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r10.texOffs(135, 117).addBox(-7.0F, -2.0F, 40.0F, 14.0F, 1.0F, 7.0F, 0.0F, false);

        cube_r11 = new ModelRenderer(this);
        cube_r11.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.0F, -1.5708F, 0.0F);
        cube_r11.texOffs(160, 87).addBox(-7.0F, -16.0F, 26.5F, 14.0F, 4.0F, 9.0F, 0.0F, false);
        cube_r11.texOffs(45, 54).addBox(-3.0F, -13.5F, 13.75F, 5.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r11.texOffs(0, 92).addBox(-5.0F, -12.0F, 0.0F, 10.0F, 4.0F, 25.0F, 0.0F, false);
        cube_r11.texOffs(0, 184).addBox(-5.0F, -14.0F, 16.5F, 10.0F, 2.0F, 9.0F, 0.01F, false);

        cube_r12 = new ModelRenderer(this);
        cube_r12.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.0F, -1.1781F, 0.0F);
        cube_r12.texOffs(75, 175).addBox(-7.0F, -16.0F, 26.5F, 11.0F, 4.0F, 9.0F, 0.01F, false);
        cube_r12.texOffs(0, 52).addBox(-3.0F, -13.5F, 13.75F, 5.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r12.texOffs(90, 71).addBox(-5.0F, -12.0F, 0.0F, 10.0F, 4.0F, 25.0F, 0.01F, false);
        cube_r12.texOffs(38, 184).addBox(-5.0F, -14.0F, 16.5F, 10.0F, 2.0F, 9.0F, 0.0F, false);

        cube_r13 = new ModelRenderer(this);
        cube_r13.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r13);
        setRotationAngle(cube_r13, 0.0F, -0.3927F, 0.0F);
        cube_r13.texOffs(150, 148).addBox(-6.0F, -17.0F, 20.25F, 12.0F, 7.0F, 10.0F, 0.01F, false);
        cube_r13.texOffs(0, 48).addBox(-3.0F, -13.5F, 13.75F, 5.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r13.texOffs(77, 9).addBox(-5.0F, -12.0F, 0.0F, 10.0F, 4.0F, 25.0F, 0.01F, false);
        cube_r13.texOffs(184, 143).addBox(-5.0F, -14.0F, 16.5F, 10.0F, 2.0F, 9.0F, 0.0F, false);

        cube_r14 = new ModelRenderer(this);
        cube_r14.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r14);
        setRotationAngle(cube_r14, 0.0F, -0.7854F, 0.0F);
        cube_r14.texOffs(44, 154).addBox(-6.0F, -17.0F, 20.25F, 12.0F, 7.0F, 10.0F, 0.0F, false);
        cube_r14.texOffs(45, 50).addBox(-3.0F, -13.5F, 13.75F, 5.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r14.texOffs(90, 42).addBox(-5.0F, -12.0F, 0.0F, 10.0F, 4.0F, 25.0F, 0.0F, false);
        cube_r14.texOffs(67, 188).addBox(-5.0F, -14.0F, 16.5F, 10.0F, 2.0F, 9.0F, 0.01F, false);

        cube_r15 = new ModelRenderer(this);
        cube_r15.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r15);
        setRotationAngle(cube_r15, 0.0F, 0.7854F, 0.0F);
        cube_r15.texOffs(135, 100).addBox(-6.0F, -17.0F, 20.25F, 12.0F, 7.0F, 10.0F, 0.0F, false);
        cube_r15.texOffs(45, 42).addBox(-3.0F, -13.5F, 13.75F, 5.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r15.texOffs(45, 38).addBox(-5.0F, -12.0F, 0.0F, 10.0F, 4.0F, 25.0F, 0.0F, false);
        cube_r15.texOffs(134, 193).addBox(-5.0F, -14.0F, 16.5F, 10.0F, 2.0F, 9.0F, 0.01F, false);

        cube_r16 = new ModelRenderer(this);
        cube_r16.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r16);
        setRotationAngle(cube_r16, 0.3054F, 1.5708F, 0.0F);
        cube_r16.texOffs(0, 0).addBox(4.0F, -1.0F, 37.0F, 2.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r16.texOffs(0, 11).addBox(-6.0F, -1.0F, 37.0F, 2.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r16.texOffs(102, 0).addBox(-7.0F, -2.0F, 40.0F, 14.0F, 1.0F, 7.0F, 0.0F, false);

        cube_r17 = new ModelRenderer(this);
        cube_r17.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r17);
        setRotationAngle(cube_r17, 0.0F, 1.5708F, 0.0F);
        cube_r17.texOffs(169, 117).addBox(-7.0F, -16.0F, 26.5F, 14.0F, 4.0F, 9.0F, 0.0F, false);
        cube_r17.texOffs(0, 44).addBox(-3.0F, -13.5F, 13.75F, 5.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r17.texOffs(135, 58).addBox(-5.0F, -12.0F, 0.0F, 10.0F, 4.0F, 25.0F, 0.0F, false);
        cube_r17.texOffs(172, 193).addBox(-5.0F, -14.0F, 16.5F, 10.0F, 2.0F, 9.0F, 0.01F, false);

        bone2 = new ModelRenderer(this);
        bone2.setPos(0.0F, -8.0F, 0.0F);
        bone2.texOffs(0, 196).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 32.0F, 16.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        bone.render(matrixStack, buffer, packedLight, packedOverlay);
        bone2.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    public void render(TSVTile tsvtile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay) {
        this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1,1,1,1);
    }

    public void render(TSVTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
        this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
    }
}
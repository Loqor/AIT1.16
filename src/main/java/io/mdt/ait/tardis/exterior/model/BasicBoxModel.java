package io.mdt.ait.tardis.exterior.model;

import com.mdt.ait.common.blocks.FallingTardisEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.mdt.ait.common.tiles.TARDISTileEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class BasicBoxModel<T extends Entity> extends EntityModel<T> {

    public final ModelRenderer box;
    public final ModelRenderer base;
    public final ModelRenderer Posts;
    public final ModelRenderer cube_r1;
    public final ModelRenderer cube_r2;
    public final ModelRenderer cube_r3;
    public final ModelRenderer Walls;
    public final ModelRenderer Wall_r1;
    public final ModelRenderer Wall_r2;
    public final ModelRenderer Roof;
    public final ModelRenderer cube_r4;
    public final ModelRenderer PCB;
    public final ModelRenderer cube_r5;
    public final ModelRenderer cube_r6;
    public final ModelRenderer cube_r7;
    public final ModelRenderer right_door;
    public final ModelRenderer left_door;
    public final ModelRenderer christmas_stuff;
    public final ModelRenderer cube_r8;
    public final ModelRenderer cube_r9;
    public final ModelRenderer cube_r10;
    public final ModelRenderer cube_r11;
    public final ModelRenderer cube_r12;
    public final ModelRenderer cube_r13;
    public final ModelRenderer cube_r14;
    public final ModelRenderer cube_r15;
    public int lightIn;
    public int overlayIn;

    public BasicBoxModel() {
        texWidth = 256;
        texHeight = 256;

        box = new ModelRenderer(this);
        box.setPos(0.0F, 24.0F, 0.0F);


        base = new ModelRenderer(this);
        base.setPos(0.0F, 0.0F, 0.0F);
        box.addChild(base);
        base.texOffs(0, 0).addBox(-19.0F, -4.0F, -19.0F, 38.0F, 4.0F, 38.0F, 0.0F, false);

        Posts = new ModelRenderer(this);
        Posts.setPos(0.0F, 0.0F, 0.0F);
        base.addChild(Posts);
        Posts.texOffs(166, 169).addBox(-18.0F, -62.0F, -18.0F, 4.0F, 58.0F, 4.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, 0.0F, 0.0F);
        Posts.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 1.5708F, 0.0F);
        cube_r1.texOffs(86, 161).addBox(-18.0F, -62.0F, -18.0F, 4.0F, 58.0F, 4.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, 0.0F, 0.0F);
        Posts.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 3.1416F, 0.0F);
        cube_r2.texOffs(102, 161).addBox(-18.0F, -62.0F, -18.0F, 4.0F, 58.0F, 4.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(0.0F, 0.0F, 0.0F);
        Posts.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, -1.5708F, 0.0F);
        cube_r3.texOffs(118, 161).addBox(-18.0F, -62.0F, -18.0F, 4.0F, 58.0F, 4.0F, 0.0F, false);

        Walls = new ModelRenderer(this);
        Walls.setPos(0.0F, 0.0F, 0.0F);
        base.addChild(Walls);
        Walls.texOffs(128, 14).addBox(-16.0F, -56.0F, -14.0F, 1.0F, 52.0F, 28.0F, 0.0F, false);
        Walls.texOffs(138, 161).addBox(-14.0F, -56.0F, -16.0F, 1.0F, 52.0F, 1.0F, 0.0F, false);
        Walls.texOffs(134, 161).addBox(13.0F, -56.0F, -16.0F, 1.0F, 52.0F, 1.0F, 0.0F, false);
        Walls.texOffs(30, 109).addBox(-13.0F, -56.0F, -16.0F, 26.0F, 1.0F, 1.0F, 0.0F, false);

        Wall_r1 = new ModelRenderer(this);
        Wall_r1.setPos(0.0F, 0.0F, 0.0F);
        Walls.addChild(Wall_r1);
        setRotationAngle(Wall_r1, 0.0F, 3.1416F, 0.0F);
        Wall_r1.texOffs(84, 81).addBox(-16.0F, -56.0F, -14.0F, 1.0F, 52.0F, 28.0F, 0.0F, false);

        Wall_r2 = new ModelRenderer(this);
        Wall_r2.setPos(0.0F, 0.0F, 0.0F);
        Walls.addChild(Wall_r2);
        setRotationAngle(Wall_r2, 0.0F, 1.5708F, 0.0F);
        Wall_r2.texOffs(0, 109).addBox(-16.0F, -56.0F, -14.0F, 1.0F, 52.0F, 28.0F, 0.0F, false);

        Roof = new ModelRenderer(this);
        Roof.setPos(0.0F, 0.0F, 0.0F);
        base.addChild(Roof);
        Roof.texOffs(0, 42).addBox(-16.0F, -65.0F, -16.0F, 32.0F, 4.0F, 32.0F, 0.0F, false);
        Roof.texOffs(0, 23).addBox(-17.0F, -64.5F, -17.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
        Roof.texOffs(0, 15).addBox(-17.0F, -64.5F, 13.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
        Roof.texOffs(20, 4).addBox(13.0F, -64.5F, -17.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
        Roof.texOffs(16, 15).addBox(13.0F, -64.5F, 13.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
        Roof.texOffs(0, 78).addBox(-14.0F, -68.0F, -14.0F, 28.0F, 3.0F, 28.0F, 0.0F, false);
        Roof.texOffs(0, 0).addBox(-3.0F, -70.0F, -3.0F, 6.0F, 2.0F, 6.0F, 0.0F, false);
        Roof.texOffs(0, 42).addBox(-2.0F, -75.25F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
        Roof.texOffs(0, 8).addBox(-3.0F, -75.5F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
        Roof.texOffs(16, 23).addBox(-2.0F, -76.5F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(0.0F, -4.0F, 0.0F);
        Roof.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 0.7854F, 0.0F);
        cube_r4.texOffs(0, 53).addBox(-4.5F, -70.75F, 0.0F, 9.0F, 5.0F, 0.0F, 0.0F, false);
        cube_r4.texOffs(0, 53).addBox(0.0F, -70.75F, -4.5F, 0.0F, 5.0F, 9.0F, 0.0F, false);

        PCB = new ModelRenderer(this);
        PCB.setPos(0.0F, 0.0F, 0.0F);
        base.addChild(PCB);
        PCB.texOffs(142, 112).addBox(-17.0F, -61.0F, -19.0F, 34.0F, 5.0F, 4.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setPos(0.0F, 0.0F, 0.0F);
        PCB.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, 1.5708F, 0.0F);
        cube_r5.texOffs(114, 0).addBox(-17.0F, -61.0F, -19.0F, 34.0F, 5.0F, 4.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setPos(0.0F, 0.0F, 0.0F);
        PCB.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.0F, 3.1416F, 0.0F);
        cube_r6.texOffs(114, 94).addBox(-17.0F, -61.0F, -19.0F, 34.0F, 5.0F, 4.0F, 0.0F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setPos(0.0F, 0.0F, 0.0F);
        PCB.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.0F, -1.5708F, 0.0F);
        cube_r7.texOffs(142, 103).addBox(-17.0F, -61.0F, -19.0F, 34.0F, 5.0F, 4.0F, 0.0F, false);

        right_door = new ModelRenderer(this);
        right_door.setPos(13.5F, -29.5F, -15.5F);
        box.addChild(right_door);
        right_door.texOffs(58, 161).addBox(-13.5F, -25.5F, -0.5F, 13.0F, 51.0F, 1.0F, 0.0F, false);
        right_door.texOffs(0, 0).addBox(-12.5F, -6.5F, -1.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        left_door = new ModelRenderer(this);
        left_door.setPos(-13.5F, -29.5F, -15.5F);
        box.addChild(left_door);
        left_door.texOffs(142, 121).addBox(0.5F, -25.5F, -0.5F, 13.0F, 51.0F, 1.0F, 0.0F, false);
        left_door.texOffs(0, 8).addBox(9.5F, -6.5F, -1.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        christmas_stuff = new ModelRenderer(this);
        christmas_stuff.setPos(0.0F, 24.0F, 0.0F);
        christmas_stuff.texOffs(252, 195).addBox(-1.0F, -61.0F, -19.0F, 2.0F, 61.0F, 0.0F, 0.001F, false);
        christmas_stuff.texOffs(252, 193).addBox(19.0F, -61.0F, -1.0F, 0.0F, 61.0F, 2.0F, 0.001F, false);
        christmas_stuff.texOffs(252, 193).addBox(-1.0F, -61.0F, 19.0F, 2.0F, 61.0F, 0.0F, 0.001F, false);
        christmas_stuff.texOffs(252, 193).addBox(-19.0F, -61.0F, -1.0F, 0.0F, 61.0F, 2.0F, 0.001F, false);
        christmas_stuff.texOffs(204, 239).addBox(-12.0F, -38.5F, -19.25F, 24.0F, 16.0F, 0.0F, 0.0F, false);
        christmas_stuff.texOffs(180, 144).addBox(-19.0F, -32.0F, -19.0F, 38.0F, 2.0F, 0.0F, 0.001F, false);
        christmas_stuff.texOffs(180, 106).addBox(19.0F, -32.0F, -19.0F, 0.0F, 2.0F, 38.0F, 0.001F, false);
        christmas_stuff.texOffs(180, 144).addBox(-19.0F, -32.0F, 19.0F, 38.0F, 2.0F, 0.0F, 0.001F, false);
        christmas_stuff.texOffs(180, 106).addBox(-19.0F, -32.0F, -19.0F, 0.0F, 2.0F, 38.0F, 0.001F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setPos(0.0F, -23.144F, -35.064F);
        christmas_stuff.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.6109F, 0.0F, 0.0F);
        cube_r8.texOffs(248, 194).addBox(-1.0F, -9.0F, 66.0F, 2.0F, 9.0F, 0.0F, 0.001F, false);

        cube_r9 = new ModelRenderer(this);
        cube_r9.setPos(0.0F, -11.2147F, -19.1622F);
        christmas_stuff.addChild(cube_r9);
        setRotationAngle(cube_r9, 1.0472F, 0.0F, 0.0F);
        cube_r9.texOffs(248, 203).addBox(-1.0F, -13.0F, 66.0F, 2.0F, 13.0F, 0.0F, 0.001F, false);

        cube_r10 = new ModelRenderer(this);
        cube_r10.setPos(19.1622F, -11.2147F, 0.0F);
        christmas_stuff.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.0F, 0.0F, 1.0472F);
        cube_r10.texOffs(248, 201).addBox(-66.0F, -13.0F, -1.0F, 0.0F, 13.0F, 2.0F, 0.001F, false);

        cube_r11 = new ModelRenderer(this);
        cube_r11.setPos(35.064F, -23.144F, 0.0F);
        christmas_stuff.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.0F, 0.0F, 0.6109F);
        cube_r11.texOffs(248, 192).addBox(-66.0F, -9.0F, -1.0F, 0.0F, 9.0F, 2.0F, 0.001F, false);

        cube_r12 = new ModelRenderer(this);
        cube_r12.setPos(-35.064F, -23.144F, 0.0F);
        christmas_stuff.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.0F, 0.0F, -0.6109F);
        cube_r12.texOffs(248, 192).addBox(66.0F, -9.0F, -1.0F, 0.0F, 9.0F, 2.0F, 0.001F, false);

        cube_r13 = new ModelRenderer(this);
        cube_r13.setPos(-19.1622F, -11.2147F, 0.0F);
        christmas_stuff.addChild(cube_r13);
        setRotationAngle(cube_r13, 0.0F, 0.0F, -1.0472F);
        cube_r13.texOffs(248, 201).addBox(66.0F, -13.0F, -1.0F, 0.0F, 13.0F, 2.0F, 0.001F, false);

        cube_r14 = new ModelRenderer(this);
        cube_r14.setPos(0.0F, -11.2147F, 19.1622F);
        christmas_stuff.addChild(cube_r14);
        setRotationAngle(cube_r14, -1.0472F, 0.0F, 0.0F);
        cube_r14.texOffs(248, 203).addBox(-1.0F, -13.0F, -66.0F, 2.0F, 13.0F, 0.0F, 0.001F, false);

        cube_r15 = new ModelRenderer(this);
        cube_r15.setPos(0.0F, -23.144F, 35.064F);
        christmas_stuff.addChild(cube_r15);
        setRotationAngle(cube_r15, -0.6109F, 0.0F, 0.0F);
        cube_r15.texOffs(248, 194).addBox(-1.0F, -9.0F, -66.0F, 2.0F, 9.0F, 0.0F, 0.001F, false);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        box.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        christmas_stuff.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    public void render(TARDISTileEntity tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
        this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1); // Fixme: alpha
    }

    public void renderFalling(FallingTardisEntity tardisEntity, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
        this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
    }
}

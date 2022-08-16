package com.mdt.ait.client.renderers.tardis;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.exteriors.BakerExterior;
import com.mdt.ait.client.models.exteriors.BasicBox;
import com.mdt.ait.client.models.exteriors.CoralExterior;
import com.mdt.ait.client.models.exteriors.MintExterior;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.enums.EnumMatState;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

public class BasicBoxRenderer extends TileEntityRenderer<TardisTileEntity> {

    private ResourceLocation texture;
    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/basic_tardis_exterior.png");
    public static final ResourceLocation POSTER_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/secret_smith_poster_box.png");
    public static final ResourceLocation MINT_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/mint_tardis_exterior.png");
    public static final ResourceLocation CORAL_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/coral_exterior.png");
    public static final ResourceLocation BAKER_LOCATION  = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/baker_exterior.png");
    public static final ResourceLocation BASIC_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/basic_tardis_emission.png");
    public static final ResourceLocation MINT_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/mint_tardis_emission.png");
    public static final ResourceLocation CORAL_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/coral_tardis_emission.png");
    public static final ResourceLocation POSTER_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/secret_smith_poster_box_emission.png");
    public static final ResourceLocation BAKER_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/baker_tardis_emission.png");

    public BasicBox model;
    private final TileEntityRendererDispatcher rendererDispatcher;
    public float spinny = 0;

    public BasicBoxRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new BasicBox();
        this.rendererDispatcher = rendererDispatcherIn;
        this.texture = LOCATION;
    }

    @Override
    public void render(TardisTileEntity tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        MatrixStackIn.pushPose();
        EnumExteriorType exterior = EnumExteriorType.values()[tile.serializeNBT().getInt("currentexterior")];
        int exteriortype = tile.serializeNBT().getInt("currentexterior");
        EnumMatState materialState = EnumMatState.values()[tile.serializeNBT().getInt("matState")];
        int mattype = tile.serializeNBT().getInt("matState");
        if(materialState != EnumMatState.SOLID) {
            ++spinny;
        } else if (materialState == EnumMatState.SOLID) {
            spinny = 0;
        }
        if (exterior.getSerializedName().equals("basic_box") && exteriortype == 0) {
            this.model = new BasicBox();
            this.smithMintPosterText(MatrixStackIn, Buffer, CombinedLight);
            this.texture = LOCATION;
            this.model.right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
            this.model.left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(BASIC_LM_LOCATION, false)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("mint_box") && exteriortype == 1) {
            this.model = new MintExterior();
            this.smithMintPosterText(MatrixStackIn, Buffer, CombinedLight);
            this.texture = MINT_LOCATION;
            ((MintExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
            ((MintExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(MINT_LM_LOCATION, false)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("coral_box") && exteriortype == 2) {
            this.model = new CoralExterior();
            this.coralText(MatrixStackIn, Buffer, CombinedLight);
            this.texture = CORAL_LOCATION;
            ((CoralExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
            ((CoralExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(CORAL_LM_LOCATION, false)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("poster_box") && exteriortype == 3) {
            this.model = new BasicBox();
            this.smithMintPosterText(MatrixStackIn, Buffer, CombinedLight);
            this.texture = POSTER_LOCATION;
            this.model.right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
            this.model.left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(POSTER_LM_LOCATION, false)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("baker_box") && exteriortype == 4) {
            this.model = new BakerExterior();
            this.texture = BAKER_LOCATION;
            this.BakerText(MatrixStackIn, Buffer, CombinedLight);
            ((BakerExterior)this.model).lamp.yRot = (float) Math.toRadians(spinny);
            ((BakerExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
            ((BakerExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(BAKER_LM_LOCATION, false)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        MatrixStackIn.translate(0.5, 0, 0.5);
        MatrixStackIn.scale(0.65f, 0.65f, 0.65f);
        MatrixStackIn.translate(0, 1.5f, 0);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(this.texture)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }

    public void smithMintPosterText(MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.925f, 2.6f, -0.28f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0f));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("POLICE -=- BOX").getVisualOrderText();
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, CombinedLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(1.28f, 2.6f, 0.925f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, CombinedLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(-0.28f, 2.6f, 0.0900f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, CombinedLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.09f, 2.6f, 1.28f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, CombinedLight);
        MatrixStackIn.popPose();
    }

    public void coralText(MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.925f, 2.6f, -0.30f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0f));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("POLICE -=- BOX").getVisualOrderText();
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, CombinedLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(1.30f, 2.6f, 0.925f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, CombinedLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(-0.30f, 2.6f, 0.0900f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, CombinedLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.09f, 2.6f, 1.30f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, CombinedLight);
        MatrixStackIn.popPose();
    }

    public void BakerText(MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.925f, 2.475f, -0.28f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0f));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("POLICE -=- BOX").getVisualOrderText();
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, CombinedLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(1.28f, 2.475f, 0.925f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, CombinedLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(-0.28f, 2.475f, 0.09f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, CombinedLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.09f, 2.475f, 1.28f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, CombinedLight);
        MatrixStackIn.popPose();
    }
}

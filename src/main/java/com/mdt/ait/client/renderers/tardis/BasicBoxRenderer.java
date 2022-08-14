package com.mdt.ait.client.renderers.tardis;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.exteriors.BasicBox;
import com.mdt.ait.client.models.exteriors.CoralExterior;
import com.mdt.ait.client.models.exteriors.MintExterior;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.enums.EnumMatState;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class BasicBoxRenderer extends TileEntityRenderer<TardisTileEntity> {

    private ResourceLocation texture;
    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/basic_tardis_exterior.png");
    public static final ResourceLocation POSTER_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/secret_smith_poster_box.png");
    public static final ResourceLocation MINT_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/mint_tardis_exterior.png");
    public static final ResourceLocation CORAL_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/coral_exterior.png");
    public static final ResourceLocation BASIC_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/basic_tardis_emission.png");
    public static final ResourceLocation MINT_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/mint_tardis_emission.png");
    public static final ResourceLocation CORAL_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/coral_tardis_emission.png");
    public static final ResourceLocation POSTER_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/secret_smith_poster_box_emission.png");
    public BasicBox model;
    private final TileEntityRendererDispatcher rendererDispatcher;

    public BasicBoxRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new BasicBox();
        this.rendererDispatcher = rendererDispatcherIn;
        this.texture = LOCATION;
    }

    public void theRealRenderer(TardisTileEntity tile, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay, float alpha) {
        MatrixStackIn.pushPose();
        EnumExteriorType exterior = EnumExteriorType.values()[tile.serializeNBT().getInt("currentexterior")];
        int exteriortype = tile.serializeNBT().getInt("currentexterior");
        if (exterior.getSerializedName().equals("basic_box") && exteriortype == 0) {
            this.model = new BasicBox();
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
        MatrixStackIn.translate(0.5, 0, 0.5);
        MatrixStackIn.scale(0.65f, 0.65f, 0.65f);
        MatrixStackIn.translate(0, 1.5f, 0);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(this.texture)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }

    @Override
    public void render(TardisTileEntity tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        EnumMatState materialState = EnumMatState.values()[tile.serializeNBT().getInt("matState")];
        int mattype = tile.serializeNBT().getInt("matState");
        if(materialState == EnumMatState.SOLID) {
            this.theRealRenderer(tile, MatrixStackIn, Buffer, CombinedLight, CombinedOverlay, 1.0F);
        } else if (materialState == EnumMatState.DEMAT) {
            this.theRealRenderer(tile, MatrixStackIn, Buffer, CombinedLight, CombinedOverlay, 0.5F);
        } else if (materialState == EnumMatState.REMAT) {
            this.theRealRenderer(tile, MatrixStackIn, Buffer, CombinedLight, CombinedOverlay, 0.25F);
        }
    }
}

package com.mdt.ait.client.renderers.machines;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.phonebooths.PhoneBooth;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.PhoneBoothBlock;
import com.mdt.ait.common.tileentities.PhoneBoothTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;


public class PhoneBoothRenderer extends TileEntityRenderer<PhoneBoothTile> {

    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/phone_booth.png");
    public static final ResourceLocation LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/phone_booth_emission.png");
    public PhoneBooth model;
    private final TileEntityRendererDispatcher rendererDispatcher;

    public PhoneBoothRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new PhoneBooth();
        this.rendererDispatcher = rendererDispatcherIn;
    }

    @Override
    public void render(PhoneBoothTile tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.5, 0, 0.5);
        MatrixStackIn.translate(0, 1.5f, 0);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(PhoneBoothBlock.FACING).getOpposite().toYRot()));
        MatrixStackIn.mulPose(Vector3f.YN.rotationDegrees(180.0f));
        model.doors.yRot = - (float) Math.toRadians(tile.mainDoorRotation);
        model.secondary.yRot = (float) Math.toRadians(tile.secondaryDoorRotation);
        model.heldPhone.visible = false;
        MatrixStackIn.translate(0, tile.makeBoothFall, 0);
        MatrixStackIn.pushPose();
        MatrixStackIn.scale(1.001f, 1.001f, 1.001f);
        MatrixStackIn.translate(0, 0.005, 0);
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(LM_LOCATION, true)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(LOCATION)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }

    @Override
    public boolean shouldRenderOffScreen(PhoneBoothTile pTe) {
        return true;
    }
}

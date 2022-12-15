package com.mdt.ait.client.renderers.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.tileentities.controls.ToyotaMonitor;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.TypewriterBlock;
import com.mdt.ait.common.tileentities.ToyotaMonitorTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.StringTextComponent;


public class ToyotaMonitorRenderer extends TileEntityRenderer<ToyotaMonitorTile> {

    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/controls/toyota_monitor.png");
    public static final ResourceLocation LIGHT_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/controls/toyota_monitor_emission.png");
    public ToyotaMonitor model;
    private final TileEntityRendererDispatcher rendererDispatcher;
    public final int MaxLight = 15728880;

    public ToyotaMonitorRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new ToyotaMonitor();
        this.rendererDispatcher = rendererDispatcherIn;
    }

    @Override
    public void render(ToyotaMonitorTile tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        this.flightRemaining(tile, MatrixStackIn, Buffer, CombinedLight);
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.5, 0, 0.5);
        MatrixStackIn.scale(1f, 1f, 1f);
        MatrixStackIn.translate(0, 0.75f, 0);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TypewriterBlock.FACING).toYRot()));
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(LOCATION)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(LIGHT_LOCATION, false)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }

    public void flightRemaining(ToyotaMonitorTile tile, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0f, 3f, 0f);
        MatrixStackIn.scale(0.00625f, 0.00625f, 0.00625f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("Flight ticks:" + tile.flightTimeRemaining).getVisualOrderText();
        float tileWidth = 16;
        float objectWidth = fontRenderer.width(irp);
        MatrixStackIn.translate(-(objectWidth / 2f - tileWidth / 2f), -0.35, 0);
        MatrixStackIn.translate(20, 430, -80);
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }
}

package com.mdt.ait.client.renderers.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.tileentities.GratedRamp;
import com.mdt.ait.client.models.tileentities.TSV;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.RampBlock;
import com.mdt.ait.common.blocks.TSVBlock;
import com.mdt.ait.common.tileentities.RampTile;
import com.mdt.ait.common.tileentities.TSVTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;


public class RampRenderer extends TileEntityRenderer<RampTile> {

    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/grated_ramp.png");
    public GratedRamp model;
    private final TileEntityRendererDispatcher rendererDispatcher;
    public float xposface = 0;
    public float zposface = 0;
    public float zpushout = 0;
    public float xpushout = 0;

    public RampRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new GratedRamp();
        this.rendererDispatcher = rendererDispatcherIn;
    }

    public void mathy(RampTile tile) {
        Direction facing = tile.getBlockState().getValue(RampBlock.FACING);
        if(facing == Direction.NORTH) {
            zposface = -1.0f;
            xposface = 0.0f;
            xpushout = 1.08f;
            zpushout = 1f;
        }
        if(facing == Direction.EAST) {
            zposface = 0.0f;
            xposface = 1.0f;
            xpushout = 1f;
            zpushout = 1.08f;
        }
        if(facing == Direction.SOUTH) {
            zposface = 1.0f;
            xposface = 0.0f;
            xpushout = 1.08f;
            zpushout = 1f;
        }
        if(facing == Direction.WEST) {
            zposface = 0.0f;
            xposface = -1.0f;
            xpushout = 1f;
            zpushout = 1.08f;
        }
    }

    @Override
    public void render(RampTile tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        MatrixStackIn.pushPose();
        mathy(tile);
        MatrixStackIn.translate(0.5, 0, 0.5);
        MatrixStackIn.scale(zpushout, 1f, xpushout);
        MatrixStackIn.translate(xposface, 1.5111f, zposface);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(RampBlock.FACING).toYRot()));
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(LOCATION)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }
}

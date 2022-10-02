package com.mdt.ait.client.renderers.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.tileentities.GBTCasing;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.GBTCasingBlock;
import com.mdt.ait.common.blocks.RampBlock;
import com.mdt.ait.common.blocks.TSVBlock;
import com.mdt.ait.common.tileentities.GBTCasingTile;
import com.mdt.ait.common.tileentities.RampTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;


public class GBTCasingRenderer extends TileEntityRenderer<GBTCasingTile> {

    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/gallifreyan_block_transfer_casing.png");
    public GBTCasing model;
    private final TileEntityRendererDispatcher rendererDispatcher;
    public float xposface = 0;
    public float zposface = 0;
    public float zpushout = 0;
    public float xpushout = 0;

    public void mathy(GBTCasingTile tile) {
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

    public GBTCasingRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new GBTCasing();
        this.rendererDispatcher = rendererDispatcherIn;
    }

    @Override
    public void render(GBTCasingTile tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        MatrixStackIn.pushPose();
        if(tile.make_thing_spin) {
            ++tile.spin_value;
            model.spin.yRot = (float) Math.toRadians(tile.spin_value);
        } else {
            tile.spin_value = 0;
        }
        MatrixStackIn.translate(0.5, 0, 0.5);
        mathy(tile);
        MatrixStackIn.scale(1f, 1f, 1f);
        MatrixStackIn.translate(xposface, 1.5f, zposface);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(GBTCasingBlock.FACING).toYRot()));
        IVertexBuilder vertexBuffer = Buffer.getBuffer(RenderType.entityTranslucent(this.LOCATION));
        model.render(tile, MatrixStackIn, vertexBuffer, CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }
}

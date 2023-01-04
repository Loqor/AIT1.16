package com.mdt.ait.client.renderers.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.tileentities.ToyotaWhirlagig;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.ToyotaWhirlagigBlock;
import com.mdt.ait.common.tileentities.ToyotaWhirlagigTile;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.enums.EnumMatState;
import com.mdt.ait.core.init.enums.EnumRotorState;
import com.mdt.ait.tardis.Tardis;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;


public class ToyotaWhirlagigRenderer extends TileEntityRenderer<ToyotaWhirlagigTile> {

    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/block_rotors/toyota_whirlagig.png");
    public static final ResourceLocation LIGHTING = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/block_rotors/toyota_whirlagig_emission.png");
    public ToyotaWhirlagig model;
    private final TileEntityRendererDispatcher rendererDispatcher;

    public ToyotaWhirlagigRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new ToyotaWhirlagig();
        this.rendererDispatcher = rendererDispatcherIn;
    }

    @Override
    public void render(ToyotaWhirlagigTile tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        ++tile.spinny;
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.5, 1.5, 0.5);
        MatrixStackIn.scale(1f, 1f, 1f);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(ToyotaWhirlagigBlock.FACING).toYRot()));
        MatrixStackIn.pushPose();
        model.top.yRot = (float) Math.toRadians(tile.spinny / 8);
        model.bottom.yRot = (float) Math.toRadians(tile.spinny / 8);
        model.top.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(LOCATION)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        model.bottom.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(LOCATION)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.pushPose();
        MatrixStackIn.scale(1.001f, 1.001f, 1.001f);
        model.bottom.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(LIGHTING, true)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        model.top.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(LIGHTING, true)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        model.middle.yRot = - (float) Math.toRadians(tile.spinny / 8);
        model.middle.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(LOCATION)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.pushPose();
        MatrixStackIn.scale(1.001f, 1.001f, 1.001f);
        model.middle.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(LIGHTING, true)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(LOCATION)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.pushPose();
        MatrixStackIn.scale(1.001f, 1.001f, 1.001f);
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(LIGHTING, true)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
        MatrixStackIn.popPose();
        MatrixStackIn.popPose();
    }
}

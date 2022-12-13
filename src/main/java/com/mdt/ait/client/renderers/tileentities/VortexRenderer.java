package com.mdt.ait.client.renderers.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.tileentities.TSV;
import com.mdt.ait.client.models.tileentities.VortexModelTemp;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.TSVBlock;
import com.mdt.ait.common.blocks.VortexBlock;
import com.mdt.ait.common.tileentities.TSVTile;
import com.mdt.ait.common.tileentities.VortexTileTemp;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;


public class VortexRenderer extends TileEntityRenderer<VortexTileTemp> {

    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/temp_vortex.png");
    public VortexModelTemp model;
    private final TileEntityRendererDispatcher rendererDispatcher;

    public VortexRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new VortexModelTemp();
        this.rendererDispatcher = rendererDispatcherIn;
    }

    @Override
    public void render(VortexTileTemp tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        MatrixStackIn.pushPose();
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(VortexBlock.FACING).toYRot()));
        MatrixStackIn.mulPose(Vector3f.YN.rotationDegrees(180.0f));
        model.vortex.zRot = tile.spinning % 60;
        MatrixStackIn.scale(2, 2, 2);
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(LOCATION, true)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }
}

package com.mdt.ait.client.renderers.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.tileentities.ArsEgg;
import com.mdt.ait.client.models.tileentities.TSV;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.ArsEggBlock;
import com.mdt.ait.common.blocks.TSVBlock;
import com.mdt.ait.common.tileentities.ArsEggTile;
import com.mdt.ait.common.tileentities.TSVTile;
import com.mdt.ait.core.init.enums.EnumEggTypes;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;


public class ArsEggRenderer extends TileEntityRenderer<ArsEggTile> {

    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/ars_eggs/ars_egg.png");
    public static final ResourceLocation LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/ars_eggs/ars_egg_emission.png");
    public ArsEgg model;
    private final TileEntityRendererDispatcher rendererDispatcher;

    public ArsEggRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new ArsEgg();
        this.rendererDispatcher = rendererDispatcherIn;
    }

    @Override
    public void render(ArsEggTile tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.5, 0, 0.5);
        MatrixStackIn.translate(0, 1.5f, 0);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(ArsEggBlock.FACING).toYRot()));
        MatrixStackIn.mulPose(Vector3f.YN.rotationDegrees(180.0f));
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(LOCATION)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.pushPose();
        MatrixStackIn.scale(1.005f, 1.005f, 1.005f);
        if(tile.eggExisting == EnumEggTypes.DEACTIVE) {
            model.egg.visible = false;
        } else {
            model.egg.visible = true;
        }
        model.egg.render(MatrixStackIn,Buffer.getBuffer(AITRenderTypes.TardisLightmap(LM_LOCATION, true)), CombinedLight, CombinedOverlay);
        MatrixStackIn.popPose();
        MatrixStackIn.popPose();
    }
}

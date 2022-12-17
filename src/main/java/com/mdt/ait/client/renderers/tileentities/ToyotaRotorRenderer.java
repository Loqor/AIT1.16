package com.mdt.ait.client.renderers.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.tileentities.ToyotaRotor;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.ToyotaRotorBlock;
import com.mdt.ait.common.tileentities.ToyotaRotorTile;
import com.mdt.ait.core.init.enums.EnumRotorState;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;


public class ToyotaRotorRenderer extends TileEntityRenderer<ToyotaRotorTile> {

    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/block_rotors/toyota_rotor.png");
    public static final ResourceLocation LIGHTING = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/block_rotors/toyota_rotor_emission.png");
    public ToyotaRotor model;
    private final TileEntityRendererDispatcher rendererDispatcher;

    public ToyotaRotorRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new ToyotaRotor();
        this.rendererDispatcher = rendererDispatcherIn;
    }

    @Override
    public void render(ToyotaRotorTile tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        //tile.rotorTick = tile.currentState() == EnumRotorState.MOVING ? 0.0f : 0.8f;
            ++tile.spinny;
            if (tile.currentState() == EnumRotorState.MOVING) {
                if (tile.rotorTick < 0f/*1.5f*/) {
                    tile.rotorTick += 0.0005f;
                } else {
                    tile.rotorTick = 0f/*1.5f*/;
                    tile.currentstate = EnumRotorState.STATIC;
                }
            }
            if (tile.currentState() == EnumRotorState.STATIC) {
                if (tile.rotorTick > -0.5f) {
                    tile.rotorTick -= 0.0005f;
                } else {
                    tile.rotorTick = -0.5f;
                    tile.currentstate = EnumRotorState.MOVING;
                }
            }
        //System.out.println(tile.rotorTick);
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.5, 1.5, 0.5);
        MatrixStackIn.scale(1f, 1f, 1f);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(ToyotaRotorBlock.FACING).toYRot()));
        MatrixStackIn.pushPose();
        //if(tile.isInFlight) {
            MatrixStackIn.translate(0, tile.rotorTick / 1.25, 0);
        //}
        model.toppipe.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(LOCATION)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.scale(1.001f, 1.001f, 1.001f);
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(LIGHTING, true)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(LOCATION)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }
}

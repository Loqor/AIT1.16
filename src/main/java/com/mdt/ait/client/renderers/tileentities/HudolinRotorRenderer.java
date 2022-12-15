package com.mdt.ait.client.renderers.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.tileentities.HudolinRotor;
import com.mdt.ait.client.models.tileentities.controls.BasicRotor;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.BasicRotorBlock;
import com.mdt.ait.common.tileentities.BasicRotorTile;
import com.mdt.ait.common.tileentities.HudolinRotorTile;
import com.mdt.ait.core.init.enums.EnumRotorState;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;


public class HudolinRotorRenderer extends TileEntityRenderer<HudolinRotorTile> {

    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/block_rotors/hudolin_rotor.png");
    public static final ResourceLocation LIGHTING = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/block_rotors/hudolin_rotor_emission.png");
    public HudolinRotor model;
    private final TileEntityRendererDispatcher rendererDispatcher;

    public HudolinRotorRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new HudolinRotor();
        this.rendererDispatcher = rendererDispatcherIn;
    }

    @Override
    public void render(HudolinRotorTile tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        //tile.rotorTick = tile.currentState() == EnumRotorState.MOVING ? 0.0f : 0.8f;
            if (tile.currentState() == EnumRotorState.MOVING) {
                if (tile.rotorTick < 0f/*1.5f*/) {
                    tile.rotorTick += 0.0015f;
                } else {
                    tile.rotorTick = 0f/*1.5f*/;
                    tile.currentstate = EnumRotorState.STATIC;
                }
            }
            if (tile.currentState() == EnumRotorState.STATIC) {
                if (tile.rotorTick > -0.6f) {
                    tile.rotorTick -= 0.0015f;
                } else {
                    tile.rotorTick = -0.6f;
                    tile.currentstate = EnumRotorState.MOVING;
                }
            }
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 1.5, 0.5);
            MatrixStackIn.scale(1f, 1f, 1f);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(BasicRotorBlock.FACING).toYRot()));
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0, tile.rotorTick / 1.25, 0);
            model.bottom.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(LOCATION, true)), CombinedLight, CombinedOverlay, 1, 1, 1, 0.9f);
            MatrixStackIn.popPose();
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0, -tile.rotorTick / 1.25, 0);
            model.top.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(LOCATION, true)), CombinedLight, CombinedOverlay, 1, 1, 1, 0.9f);
            MatrixStackIn.popPose();
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(LOCATION)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
    }
}

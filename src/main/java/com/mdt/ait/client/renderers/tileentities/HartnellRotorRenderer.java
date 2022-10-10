package com.mdt.ait.client.renderers.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.tileentities.controls.BasicRotor;
import com.mdt.ait.client.models.tileentities.controls.HartnellRotor;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.HartnellRotorBlock;
import com.mdt.ait.common.blocks.TardisLeverBlock;
import com.mdt.ait.common.tileentities.BasicRotorTile;
import com.mdt.ait.common.tileentities.HartnellRotorTile;
import com.mdt.ait.core.init.enums.EnumRotorState;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;


public class HartnellRotorRenderer extends TileEntityRenderer<HartnellRotorTile> {

    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/hartnell_rotor.png");
    public static final ResourceLocation LIGHTING_1 = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/hartnell_rotor_emission_one.png");
    public static final ResourceLocation LIGHTING_2 = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/hartnell_rotor_emission_two.png");
    public HartnellRotor model;
    private final TileEntityRendererDispatcher rendererDispatcher;
    public ResourceLocation texture;

    public HartnellRotorRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new HartnellRotor();
        this.rendererDispatcher = rendererDispatcherIn;
        this.texture = LIGHTING_1;
    }

    @Override
    public void render(HartnellRotorTile tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        //tile.rotorTick = tile.currentState() == EnumRotorState.MOVING ? 0.0f : 0.8f;
        //if(tile.isTardisInFlight()) {
            ++tile.spinny;
            if (tile.currentState() == EnumRotorState.MOVING) {
                if (tile.rotorTick < 0.8f/*1.5f*/) {
                    tile.rotorTick += 0.0005f;
                } else {
                    tile.rotorTick = 0.8f/*1.5f*/;
                    tile.currentstate = EnumRotorState.STATIC;
                }
                if (tile.rotorTick < 0.8) {
                    this.texture = LIGHTING_1;
                } else {
                    this.texture = LIGHTING_2;
                }
            }
            if (tile.currentState() == EnumRotorState.STATIC) {
                if (tile.rotorTick > 0.0f) {
                    tile.rotorTick -= 0.0005f;
                } else {
                    tile.rotorTick = 0.0f;
                    tile.currentstate = EnumRotorState.MOVING;
                }
            }
        //}
        //System.out.println(tile.rotorTick);
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.5, 0, 0.5);
        MatrixStackIn.scale(1f, 1f, 1f);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(HartnellRotorBlock.FACING).toYRot()));
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0, tile.rotorTick / 1.25, 0);
        MatrixStackIn.pushPose();
        model.rotor.yRot = (float) Math.toRadians(tile.spinny / 64);
        model.rotor.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(LOCATION)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
        model.casing.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(LOCATION)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        model.rotor.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(this.texture, false)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
        MatrixStackIn.translate(0, -1.5, 0);
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(LOCATION)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }
}

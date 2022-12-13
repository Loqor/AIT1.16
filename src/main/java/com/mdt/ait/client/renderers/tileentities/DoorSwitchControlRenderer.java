package com.mdt.ait.client.renderers.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.tileentities.controls.DoorSwitchControl;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.DoorSwitchControlBlock;
import com.mdt.ait.common.tileentities.DoorSwitchControlTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;


public class DoorSwitchControlRenderer extends TileEntityRenderer<DoorSwitchControlTile> {

    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/controls/door_switch.png");
    public DoorSwitchControl model;
    private final TileEntityRendererDispatcher rendererDispatcher;

    public DoorSwitchControlRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new DoorSwitchControl();
        this.rendererDispatcher = rendererDispatcherIn;
    }

    @Override
    public void render(DoorSwitchControlTile tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        MatrixStackIn.pushPose();
        this.model.first.xRot = (float) - Math.toRadians(tile.firstLeverPosition);
        this.model.second.xRot = (float) - Math.toRadians(tile.secondLeverPosition);
        MatrixStackIn.translate(0.5, 0, 0.5);
        MatrixStackIn.scale(1f, 1f, 1f);
        MatrixStackIn.translate(0, 1.5f, 0);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(DoorSwitchControlBlock.FACING).toYRot()));
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(LOCATION)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }
}

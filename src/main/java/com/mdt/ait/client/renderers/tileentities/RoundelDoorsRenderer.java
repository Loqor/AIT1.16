package com.mdt.ait.client.renderers.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.tileentities.ClassicInteriorDoors;
import com.mdt.ait.client.models.tileentities.RoundelDoors;
import com.mdt.ait.client.models.tileentities.RoundelDoorsSecondary;
import com.mdt.ait.client.models.tileentities.TSV;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.RoundelDoorsBlock;
import com.mdt.ait.common.blocks.TSVBlock;
import com.mdt.ait.common.tileentities.RoundelDoorsTile;
import com.mdt.ait.common.tileentities.TSVTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;


public class RoundelDoorsRenderer extends TileEntityRenderer<RoundelDoorsTile> {

    public int spinny;
    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/interior_doors/roundel_doors/roundel_doors.png");
    public static final ResourceLocation DARK_OAK_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/interior_doors/roundel_doors/dark_oak_roundel_doors.png");
    public RoundelDoors model;
    private final TileEntityRendererDispatcher rendererDispatcher;
    public ResourceLocation texture;

    public RoundelDoorsRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new RoundelDoors();
        this.texture = LOCATION;
        this.rendererDispatcher = rendererDispatcherIn;
    }

    @Override
    public void render(RoundelDoorsTile tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.5, 0, 0.5);
        MatrixStackIn.scale(1f, 1f, 1f);
        MatrixStackIn.translate(0, 1.5f, 0);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(RoundelDoorsBlock.FACING).toYRot()));
        MatrixStackIn.mulPose(Vector3f.YN.rotationDegrees(180.0f));
        if(tile.flipDoors) {
            this.model = new RoundelDoorsSecondary();
            ((RoundelDoorsSecondary)this.model).doorright.yRot = - (float) Math.toRadians(tile.doorRotation);
        } else {
            this.model = new RoundelDoors();
            this.model.doorleft.yRot = (float) Math.toRadians(tile.doorRotation);
        }
        if(tile.clickedOnWithBlock.equals("hartnell_mint_a")) {
            this.texture = LOCATION;
        } else if (tile.clickedOnWithBlock.equals("dark_oak_planks")) {
            this.texture = DARK_OAK_LOCATION;
        }
        this.model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(this.texture)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }
}

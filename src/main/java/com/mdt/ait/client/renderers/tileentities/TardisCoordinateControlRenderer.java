package com.mdt.ait.client.renderers.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.tileentities.controls.TardisCoordinateControl;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.TardisCoordinateControlBlock;
import com.mdt.ait.common.tileentities.TardisCoordinateControlTile;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.enums.EnumCoordinateDirectionState;
import com.mdt.ait.core.init.enums.EnumCoordinatePosNegState;
import com.mdt.ait.core.init.enums.EnumCoordinateState;
import com.mdt.ait.tardis.Tardis;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.Direction;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.StringTextComponent;

import java.util.Objects;


public class TardisCoordinateControlRenderer extends TileEntityRenderer<TardisCoordinateControlTile> {

    public static final ResourceLocation BLUE_TEXTURE = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_coordinate_control_blue.png");
    public static final ResourceLocation RED_TEXTURE = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_coordinate_control_red.png");

    public TardisCoordinateControl model;
    private ResourceLocation texture;
    private final TileEntityRendererDispatcher rendererDispatcher;
    public final int MaxLight = 15728880;
    public float rotationForText = 0f;
    public double xpos;
    public double zpos;
    public String x;
    public String y;
    public String z;

    public TardisCoordinateControlRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new TardisCoordinateControl();
        this.rendererDispatcher = rendererDispatcherIn;
        this.texture = BLUE_TEXTURE;
    }

    public void mathy(TardisCoordinateControlTile tile) {
        Direction facing = tile.getBlockState().getValue(TardisCoordinateControlBlock.FACING);
        if(facing == Direction.NORTH) {
            rotationForText = 180f;
            xpos = 0.675;
            zpos = -0.0005;
        }
        if(facing == Direction.EAST) {
            rotationForText = -90f;
            xpos = 1.0005;
            zpos = 0.675;
        }
        if(facing == Direction.SOUTH) {
            rotationForText = 0f;
            xpos = 0.325;
            zpos = 1.0005;
        }
        if(facing == Direction.WEST) {
            rotationForText = 90f;
            xpos = 0.87;
            zpos = 0.1;
        }
    }

    @Override
    public void render(TardisCoordinateControlTile tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        mathy(tile);
        //System.out.println(tile.currentCoordinateDirectionState);
        //double shiftingPositionEx;
        //double shiftingPositionY;
        //double shiftingPositionZ;
        if(tile.currentPosNegState == EnumCoordinatePosNegState.IS_POSITIVE) {
            this.texture = BLUE_TEXTURE;
        }
        if(tile.currentPosNegState == EnumCoordinatePosNegState.IS_NEGATIVE) {
            this.texture = RED_TEXTURE;
        }
        /*if(tile.currentCoordinateState == EnumCoordinateState.X_IS_TRUE) {
            shiftingPositionEx = 0.025;
        } else {
            shiftingPositionEx = 0;
        }
        if(tile.currentCoordinateState == EnumCoordinateState.Y_IS_TRUE) {
            shiftingPositionY = 0.025;
        } else {
            shiftingPositionY = 0;
        }
        if(tile.currentCoordinateState == EnumCoordinateState.Z_IS_TRUE) {
            shiftingPositionZ = 0.025;
        } else {
            shiftingPositionZ = 0;
        }*/
        MatrixStackIn.pushPose();
        if(tile.currentCoordinateDirectionState == EnumCoordinateDirectionState.NORTH) {
            this.whatCoordinatesTextNorth(tile, MatrixStackIn, Buffer, CombinedLight);
            this.whatIncrementTextNorth(tile, MatrixStackIn, Buffer, CombinedLight);
        }
        if(tile.currentCoordinateDirectionState == EnumCoordinateDirectionState.EAST) {
            this.whatCoordinatesTextEast(tile, MatrixStackIn, Buffer, CombinedLight);
            this.whatIncrementTextEast(tile, MatrixStackIn, Buffer, CombinedLight);
        }
        if(tile.currentCoordinateDirectionState == EnumCoordinateDirectionState.SOUTH) {
            this.whatCoordinatesTextSouth(tile, MatrixStackIn, Buffer, CombinedLight);
            this.whatIncrementTextSouth(tile, MatrixStackIn, Buffer, CombinedLight);
        }
        if(tile.currentCoordinateDirectionState == EnumCoordinateDirectionState.WEST) {
            this.whatCoordinatesTextWest(tile, MatrixStackIn, Buffer, CombinedLight);
            this.whatIncrementTextWest(tile, MatrixStackIn, Buffer, CombinedLight);
        }
        MatrixStackIn.translate(0.5, 0, 0.5);
        MatrixStackIn.scale(1f, 1f, 1f);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisCoordinateControlBlock.FACING).toYRot()));
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0, 0/*shiftingPositionEx*/, 0);
        model.x.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(this.texture)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0, 0/*shiftingPositionY*/, 0);
        model.y.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(this.texture)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0, 0/*shiftingPositionZ*/, 0);
        model.z.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(this.texture)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(this.texture)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }

    public void whatCoordinatesTextNorth(TardisCoordinateControlTile tile, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        MatrixStackIn.pushPose();
        MatrixStackIn.scale(0.009375f, 0.009375f, 0.009375f);
        if(tile.currentCoordinateDirectionState == EnumCoordinateDirectionState.NORTH) {
            MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(-180.0f));
            MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(67.5f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-rotationForText));
        }
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent(tile.xPos + ", " + tile.yPos + ", " + tile.zPos).getVisualOrderText();
        float tileWidth = 16;
        float objectWidth = fontRenderer.width(irp);
        MatrixStackIn.translate(-(objectWidth / 2f - tileWidth / 2f), 0.35f, zpos);
        MatrixStackIn.translate(-53, -54, -5);
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }
    public void whatCoordinatesTextEast(TardisCoordinateControlTile tile, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        MatrixStackIn.pushPose();
        MatrixStackIn.scale(0.009375f, 0.009375f, 0.009375f);
        if(tile.currentCoordinateDirectionState == EnumCoordinateDirectionState.EAST) {
            MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.ZN.rotationDegrees(67.5f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(rotationForText));
        }
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent(tile.xPos + ", " + tile.yPos + ", " + tile.zPos).getVisualOrderText();
        float tileWidth = 16;
        float objectWidth = fontRenderer.width(irp);
        MatrixStackIn.translate(xpos, 0.35f, -(objectWidth / 2f - tileWidth / 2f));
        MatrixStackIn.translate(5, -54, 50.5);
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }
    public void whatCoordinatesTextSouth(TardisCoordinateControlTile tile, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        MatrixStackIn.pushPose();
        MatrixStackIn.scale(0.009375f, 0.009375f, 0.009375f);
        if(tile.currentCoordinateDirectionState == EnumCoordinateDirectionState.SOUTH) {
            MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.ZN.rotationDegrees(-67.5f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(rotationForText));
        }
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent(tile.xPos + ", " + tile.yPos + ", " + tile.zPos).getVisualOrderText();
        float tileWidth = 16;
        float objectWidth = fontRenderer.width(irp);
        MatrixStackIn.translate(-(objectWidth / 2f - tileWidth / 2f), 0.35f, zpos);
        MatrixStackIn.translate(50.5, -54, -5);
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }
    public void whatCoordinatesTextWest(TardisCoordinateControlTile tile, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        MatrixStackIn.pushPose();
        MatrixStackIn.scale(0.009375f, 0.009375f, 0.009375f);
        if(tile.currentCoordinateDirectionState == EnumCoordinateDirectionState.WEST) {
            MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.ZN.rotationDegrees(-67.5f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(rotationForText));
        }
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent(tile.xPos + ", " + tile.yPos + ", " + tile.zPos).getVisualOrderText();
        float tileWidth = 16;
        float objectWidth = fontRenderer.width(irp);
        MatrixStackIn.translate(-(objectWidth / 2f - tileWidth / 2f), 0.35f, zpos);
        MatrixStackIn.translate(50.5, -54, -5);
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }

    public void whatIncrementTextNorth(TardisCoordinateControlTile tile, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        MatrixStackIn.pushPose();
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(-180.0f));
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(67.5f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-rotationForText));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("Increment: " + tile.incrementValue).getVisualOrderText();
        float tileWidth = 16;
        float objectWidth = fontRenderer.width(irp);
        MatrixStackIn.translate(-(objectWidth / 2f - tileWidth / 2f), 0.35f, zpos);
        MatrixStackIn.translate(-41.5, -72, -2);
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }
    public void whatIncrementTextEast(TardisCoordinateControlTile tile, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        MatrixStackIn.pushPose();
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.ZN.rotationDegrees(67.5f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(rotationForText));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("Increment: " + tile.incrementValue).getVisualOrderText();
        float tileWidth = 16;
        float objectWidth = fontRenderer.width(irp);
        MatrixStackIn.translate(-(objectWidth / 2f - tileWidth / 2f), 0.35f, zpos);
        MatrixStackIn.translate(39, -72, -2);
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }
    public void whatIncrementTextSouth(TardisCoordinateControlTile tile, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        MatrixStackIn.pushPose();
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.ZN.rotationDegrees(-67.5f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(rotationForText));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("Increment: " + tile.incrementValue).getVisualOrderText();
        float tileWidth = 16;
        float objectWidth = fontRenderer.width(irp);
        MatrixStackIn.translate(-(objectWidth / 2f - tileWidth / 2f), 0.35f, zpos);
        MatrixStackIn.translate(39, -72, -2);
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }
    public void whatIncrementTextWest(TardisCoordinateControlTile tile, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        MatrixStackIn.pushPose();
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.ZN.rotationDegrees(-67.5f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(rotationForText));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("Increment: " + tile.incrementValue).getVisualOrderText();
        float tileWidth = 16;
        float objectWidth = fontRenderer.width(irp);
        MatrixStackIn.translate(-(objectWidth / 2f - tileWidth / 2f), 0.35f, zpos);
        MatrixStackIn.translate(39, -72, -2);
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }
}

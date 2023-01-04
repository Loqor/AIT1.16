package com.mdt.ait.client.renderers.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.exteriors.BakerExterior;
import com.mdt.ait.client.models.tileentities.controls.DimensionSwitchControl;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.DimensionSwitchControlBlock;
import com.mdt.ait.common.blocks.RampBlock;
import com.mdt.ait.common.blocks.TardisLeverBlock;
import com.mdt.ait.common.tileentities.DimensionSwitchControlTile;
import com.mdt.ait.common.tileentities.RampTile;
import com.mdt.ait.core.init.enums.EnumDimensionControlState;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.Direction;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.StringTextComponent;


public class DimensionSwitchControlRenderer extends TileEntityRenderer<DimensionSwitchControlTile> {

    public static final ResourceLocation EARTH = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_dimension_switch_earth.png");
    public static final ResourceLocation NETHER = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_dimension_switch_hell.png");
    public static final ResourceLocation END = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_dimension_switch_end.png");
    public static final ResourceLocation GALLIFREY = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_dimension_switch_gallifrey.png");
    public static final ResourceLocation MONDAS = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_dimension_switch_mondas.png");

    public DimensionSwitchControl model;
    private ResourceLocation texture;
    private final TileEntityRendererDispatcher rendererDispatcher;
    public final int MaxLight = 15728880;
    public String setDimension;
    public float rotationForText = 0f;
    public double xpos;
    public double zpos;

    public DimensionSwitchControlRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new DimensionSwitchControl();
        this.rendererDispatcher = rendererDispatcherIn;
        this.texture = EARTH;
        this.setDimension = "Earth";
    }

    public void mathy(DimensionSwitchControlTile tile) {
        Direction facing = tile.getBlockState().getValue(DimensionSwitchControlBlock.FACING);
        if(facing == Direction.NORTH) {
            rotationForText = 180f;
            xpos = -0.675;
            zpos = -0.0005;
        }
        if(facing == Direction.EAST) {
            rotationForText = -90f;
            xpos = -1.0005;
            zpos = 0.675;
        }
        if(facing == Direction.SOUTH) {
            rotationForText = 0f;
            xpos = -0.325;
            zpos = 1.0005;
        }
        if(facing == Direction.WEST) {
            rotationForText = 90f;
            xpos = 0.0005;
            zpos = 0.325;
        }
    }

    @Override
    public void render(DimensionSwitchControlTile tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        mathy(tile);
        if(tile.currentdimensionstate == EnumDimensionControlState.EARTH) {
            this.texture = EARTH;
            this.setDimension = "Earth";
        }
        if(tile.currentdimensionstate == EnumDimensionControlState.NETHER) {
            this.texture = NETHER;
            this.setDimension = "Nether";
        }
        if(tile.currentdimensionstate == EnumDimensionControlState.END) {
            this.texture = END;
            this.setDimension = "End";
        }
        if(tile.currentdimensionstate == EnumDimensionControlState.GALLIFREY) {
            this.texture = GALLIFREY;
            this.setDimension = "Gallifrey";
        }
        if(tile.currentdimensionstate == EnumDimensionControlState.MONDAS) {
            this.texture = MONDAS;
            this.setDimension = "Mondas";
        }
        ++tile.spinny;
        MatrixStackIn.pushPose();
        this.whatDimensionText(MatrixStackIn, Buffer, CombinedLight);
        MatrixStackIn.translate(0.5, 1.5, 0.5);
        MatrixStackIn.scale(1f, 1f, 1f);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisLeverBlock.FACING).toYRot()));
        MatrixStackIn.pushPose();
        model.planet.yRot = (float) Math.toRadians(tile.spinny / 32);
        //model.planet.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(this.texture)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(this.texture)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }

    public void whatDimensionText(MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(-xpos, 0.45f, zpos);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(rotationForText));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent(this.setDimension).getVisualOrderText();
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }
}

package com.mdt.ait.client.renderers.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.tileentities.TSV;
import com.mdt.ait.client.models.tileentities.TardisCoral;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.TSVBlock;
import com.mdt.ait.common.blocks.TardisCoralBlock;
import com.mdt.ait.common.tileentities.TSVTile;
import com.mdt.ait.common.tileentities.TardisCoralTile;
import com.mdt.ait.core.init.enums.EnumCoralState;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.enums.EnumMatState;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;


public class TardisCoralRenderer extends TileEntityRenderer<TardisCoralTile> {

    public static final ResourceLocation STATE1 = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_coral/tardis_coral_1.png");
    public static final ResourceLocation STATE2 = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_coral/tardis_coral_2.png");
    public static final ResourceLocation STATE3 = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_coral/tardis_coral_3.png");
    public static final ResourceLocation STATE4 = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_coral/tardis_coral_4.png");
    public static final ResourceLocation STATE5 = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_coral/tardis_coral_5.png");
    public static final ResourceLocation STATE_FINAL = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_coral/tardis_coral_final.png");

    public TardisCoral model;
    private final TileEntityRendererDispatcher rendererDispatcher;
    public ResourceLocation coralStateLocation = STATE1;
    public float spinny = 0;

    public TardisCoralRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new TardisCoral();
        this.rendererDispatcher = rendererDispatcherIn;
    }

    @Override
    public void render(TardisCoralTile tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        EnumCoralState coralState = EnumCoralState.values()[tile.serializeNBT().getInt("coralState")];
        int coralstatetype = tile.serializeNBT().getInt("coralState");
        MatrixStackIn.pushPose();
        if(coralState == EnumCoralState.FIRST) {
            this.coralStateLocation = STATE1;
            this.model.state1.visible = true;
            this.model.state2.visible = false;
            this.model.state3.visible = false;
            this.model.state4.visible = false;
            this.model.state5.visible = false;
            this.model.finalstate.visible = false;
        }
        if(coralState == EnumCoralState.SECOND) {
            this.coralStateLocation = STATE2;
            this.model.state1.visible = false;
            this.model.state2.visible = true;
            this.model.state3.visible = false;
            this.model.state4.visible = false;
            this.model.state5.visible = false;
            this.model.finalstate.visible = false;
        }
        if(coralState == EnumCoralState.THIRD) {
            this.coralStateLocation = STATE3;
            this.model.state1.visible = false;
            this.model.state2.visible = false;
            this.model.state3.visible = true;
            this.model.state4.visible = false;
            this.model.state5.visible = false;
            this.model.finalstate.visible = false;
        }
        if(coralState == EnumCoralState.FOURTH) {
            this.coralStateLocation = STATE4;
            this.model.state1.visible = false;
            this.model.state2.visible = false;
            this.model.state3.visible = false;
            this.model.state4.visible = true;
            this.model.state5.visible = false;
            this.model.finalstate.visible = false;
        }
        if(coralState == EnumCoralState.FIFTH) {
            this.coralStateLocation = STATE5;
            this.model.state1.visible = false;
            this.model.state2.visible = false;
            this.model.state3.visible = false;
            this.model.state4.visible = false;
            this.model.state5.visible = true;
            this.model.finalstate.visible = false;
        }
        if(coralState == EnumCoralState.FINAL) {
            this.coralStateLocation = STATE_FINAL;
            this.model.state1.visible = false;
            this.model.state2.visible = false;
            this.model.state3.visible = false;
            this.model.state4.visible = false;
            this.model.state5.visible = false;
            this.model.finalstate.visible = true;
            ++spinny;
        }
        MatrixStackIn.translate(0.5, 0, 0.5);
        MatrixStackIn.scale(1f, 1f, 1f);
        MatrixStackIn.translate(0, 1.5f, 0);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisCoralBlock.FACING).toYRot()));
        MatrixStackIn.mulPose(Vector3f.YN.rotationDegrees(180.0f));
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(coralStateLocation)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }
}

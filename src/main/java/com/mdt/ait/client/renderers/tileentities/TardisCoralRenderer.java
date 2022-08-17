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

    public static final ResourceLocation ONE_TARDIS_CORAL_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_coral_state1.png");
    public static final ResourceLocation TWO_TARDIS_CORAL_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_coral_state2.png");
    public static final ResourceLocation THREE_TARDIS_CORAL_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_coral_state3.png");
    public static final ResourceLocation FOUR_TARDIS_CORAL_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_coral_state4.png");
    public static final ResourceLocation FIVE_TARDIS_CORAL_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_coral_state5.png");
    public static final ResourceLocation SIX_TARDIS_CORAL_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_coral_state6.png");
    public static final ResourceLocation SEVEN_TARDIS_CORAL_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_coral_state7.png");
    public static final ResourceLocation BOTTOM_CORAL_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_coral_state_bottom_emission.png");
    public static final ResourceLocation TOP_CORAL_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/tardis_coral_state_top_emission.png");

    public TardisCoral model;
    private final TileEntityRendererDispatcher rendererDispatcher;
    public ResourceLocation coralStateLocation = ONE_TARDIS_CORAL_LOCATION;
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
        ++spinny;
        MatrixStackIn.pushPose();
        if(coralState == EnumCoralState.FIRST || coralState == EnumCoralState.FINAL) {
            this.coralStateLocation = ONE_TARDIS_CORAL_LOCATION;
            spinny = 0;
        }
        if(coralState == EnumCoralState.SECOND) {
            this.coralStateLocation = TWO_TARDIS_CORAL_LOCATION;
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(1.051f, 1.051f, 1.051f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisCoralBlock.FACING).toYRot()));
            MatrixStackIn.mulPose(Vector3f.YN.rotationDegrees(45.0f));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(BOTTOM_CORAL_LM_LOCATION, false)),
                    CombinedLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if(coralState == EnumCoralState.THIRD) {
            this.coralStateLocation = THREE_TARDIS_CORAL_LOCATION;
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(1.051f, 1.051f, 1.051f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisCoralBlock.FACING).toYRot()));
            MatrixStackIn.mulPose(Vector3f.YN.rotationDegrees(45.0f));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(TOP_CORAL_LM_LOCATION, false)),
                    CombinedLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if(coralState == EnumCoralState.FOURTH) {
            this.coralStateLocation = FOUR_TARDIS_CORAL_LOCATION;
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(1.051f, 1.051f, 1.051f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisCoralBlock.FACING).toYRot()));
            MatrixStackIn.mulPose(Vector3f.YN.rotationDegrees(45.0f));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(TOP_CORAL_LM_LOCATION, false)),
                    CombinedLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if(coralState == EnumCoralState.FIFTH) {
            this.coralStateLocation = FIVE_TARDIS_CORAL_LOCATION;
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(1.051f, 1.051f, 1.051f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisCoralBlock.FACING).toYRot()));
            MatrixStackIn.mulPose(Vector3f.YN.rotationDegrees(45.0f));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(TOP_CORAL_LM_LOCATION, false)),
                    CombinedLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if(coralState == EnumCoralState.SIXTH) {
            this.coralStateLocation = SIX_TARDIS_CORAL_LOCATION;
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(1.051f, 1.051f, 1.051f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisCoralBlock.FACING).toYRot()));
            MatrixStackIn.mulPose(Vector3f.YN.rotationDegrees(45.0f));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(TOP_CORAL_LM_LOCATION, false)),
                    CombinedLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if(coralState == EnumCoralState.SEVENTH) {
            this.coralStateLocation = SEVEN_TARDIS_CORAL_LOCATION;
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(1.051f, 1.051f, 1.051f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisCoralBlock.FACING).toYRot()));
            MatrixStackIn.mulPose(Vector3f.YN.rotationDegrees(45.0f));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(TOP_CORAL_LM_LOCATION, false)),
                    CombinedLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        MatrixStackIn.translate(0.5, 0, 0.5);
        MatrixStackIn.scale(1f, 1f, 1f);
        MatrixStackIn.translate(0, 1.5f, 0);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisCoralBlock.FACING).toYRot()));
        MatrixStackIn.mulPose(Vector3f.YN.rotationDegrees(180.0f));
        if(coralState == EnumCoralState.SEVENTH) {model.bone.yRot = (float) Math.toRadians(spinny);}
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(coralStateLocation)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }
}

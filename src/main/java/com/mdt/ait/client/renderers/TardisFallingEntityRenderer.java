/*package com.mdt.ait.client.renderers;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.exteriors.*;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.FallingTardisEntity;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.enums.EnumMatState;
import com.mdt.ait.tardis.Tardis;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.FallingBlockRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

public class TardisFallingEntityRenderer extends FallingBlockRenderer {

    private ResourceLocation texture;
    private ResourceLocation lm_texture;
    public final int MaxLight = 15728880;

    //Textures
    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/basic_tardis_exterior.png");
    public static final ResourceLocation POSTER_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/secret_smith_poster_box.png");
    public static final ResourceLocation MINT_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/mint_tardis_exterior.png");
    public static final ResourceLocation CORAL_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/coral_exterior.png");
    public static final ResourceLocation BAKER_LOCATION  = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/baker_exterior.png");
    public static final ResourceLocation TT40_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/type_40_tt_capsule_exterior.png");
    public static final ResourceLocation HELLBENT_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/hellbent_tt_capsule.png");
    public static final ResourceLocation NUKA_COLA_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/nuka_cola_exterior.png");
    public static final ResourceLocation SIEGE_MODE_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/siege_mode.png");
    public static final ResourceLocation TRON_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/tron_exterior.png");
    public static final ResourceLocation CUSHING_BASE_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/cushing_exterior.png");
    public static final ResourceLocation CLASSIC_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/classic_exterior.png");
    public static final ResourceLocation HARTNELL_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/hartnell_exterior.png");

    //Lightmaps
    public static final ResourceLocation BASIC_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/basic_tardis_emission.png");
    public static final ResourceLocation MINT_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/mint_tardis_emission.png");
    public static final ResourceLocation CORAL_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/coral_tardis_emission.png");
    public static final ResourceLocation POSTER_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/secret_smith_poster_box_emission.png");
    public static final ResourceLocation BAKER_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/baker_tardis_emission.png");
    public static final ResourceLocation NUKA_COLA_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/nuka_cola_exterior_emission.png");
    public static final ResourceLocation SIEGE_MODE_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/siege_mode_emission.png");
    public static final ResourceLocation TRON_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/tron_exterior_emission.png");
    public static final ResourceLocation CUSHING_BASE_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/cushing_exterior_emission.png");
    public static final ResourceLocation CUSHING_BASE_LM_NW_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/cushing_exterior_emission_no_windows.png");
    public static final ResourceLocation CLASSIC_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/classic_exterior_emission.png");
    public static final ResourceLocation HARTNELL_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/hartnell_exterior_emission.png");

    public BasicBox model;
    private final EntityRendererManager rendererDispatcher;

    public TardisFallingEntityRenderer(EntityRendererManager p_i46177_1_) {
        super(p_i46177_1_);
        this.model = new BasicBox();
        this.rendererDispatcher = p_i46177_1_;
        this.texture = LOCATION;
    }

    @Override
    public void render(FallingTardisEntity entity, float EntityYaw, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int PackedLight) {
        BlockPos entityPos = new BlockPos(entity.getX(), entity.getY(), entity.getZ());
        Tardis tardis = AIT.tardisManager.getTardisFromPosition(entityPos);
        MatrixStackIn.pushPose();
        EnumExteriorType exterior = EnumExteriorType.values()[entity.serializeNBT().getInt("currentexterior")];
        int exteriortype = tile.serializeNBT().getInt("currentexterior");
        EnumMatState materialState = EnumMatState.values()[tile.serializeNBT().getInt("matState")];
        int mattype = tile.serializeNBT().getInt("matState");
        if(materialState != EnumMatState.SOLID) {
            ++tile.spinny;
        } else if (materialState == EnumMatState.SOLID) {
            tile.spinny = 0;
        }
        if (exterior.getSerializedName().equals("basic_box") && exteriortype == 0) {
            this.model = new BasicBox();
            this.smithMintPosterText(MatrixStackIn, Buffer, CombinedLight);
            this.texture = LOCATION;
            this.model.right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
            this.model.left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(BASIC_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("mint_box") && exteriortype == 1) {
            this.model = new MintExterior();
            this.smithMintPosterText(MatrixStackIn, Buffer, CombinedLight);
            this.texture = MINT_LOCATION;
            ((MintExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
            ((MintExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(MINT_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("coral_box") && exteriortype == 2) {
            this.model = new CoralExterior();
            this.coralText(MatrixStackIn, Buffer, CombinedLight);
            this.texture = CORAL_LOCATION;
            ((CoralExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
            ((CoralExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(CORAL_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("poster_box") && exteriortype == 3) {
            this.model = new BasicBox();
            this.smithMintPosterText(MatrixStackIn, Buffer, CombinedLight);
            this.texture = POSTER_LOCATION;
            this.model.right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
            this.model.left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(POSTER_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("baker_box") && exteriortype == 4) {
            this.model = new BakerExterior();
            this.texture = BAKER_LOCATION;
            this.BakerText(MatrixStackIn, Buffer, CombinedLight);
            ((BakerExterior)this.model).lamp.yRot = (float) Math.toRadians(tile.spinny);
            ((BakerExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
            ((BakerExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(BAKER_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("type_40_tt_capsule") && exteriortype == 5) {
            this.model = new Type40TTCapsuleExterior();
            this.texture = TT40_LOCATION;
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            if(tile.currentState() == EnumDoorState.CLOSED) {
                ((Type40TTCapsuleExterior) this.model).door_slat_1.visible = true;
                ((Type40TTCapsuleExterior) this.model).door_slat_2.visible = true;
                ((Type40TTCapsuleExterior) this.model).door_slat_3.visible = true;
                ((Type40TTCapsuleExterior) this.model).door_slat_4.visible = true;
            }
            if(tile.currentState() == EnumDoorState.FIRST) {
                ((Type40TTCapsuleExterior) this.model).door_slat_1.visible = true;
                ((Type40TTCapsuleExterior) this.model).door_slat_2.visible = true;
                ((Type40TTCapsuleExterior) this.model).door_slat_3.visible = false;
                ((Type40TTCapsuleExterior) this.model).door_slat_4.visible = false;
            }
            if(tile.currentState() == EnumDoorState.BOTH) {
                ((Type40TTCapsuleExterior) this.model).door_slat_1.visible = false;
                ((Type40TTCapsuleExterior) this.model).door_slat_2.visible = false;
                ((Type40TTCapsuleExterior) this.model).door_slat_3.visible = false;
                ((Type40TTCapsuleExterior) this.model).door_slat_4.visible = false;
            }
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("hellbent_tt_capsule") && exteriortype == 6) {
            this.model = new HellBentTTCapsuleExterior();
            this.texture = HELLBENT_LOCATION;
            ((HellBentTTCapsuleExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
            ((HellBentTTCapsuleExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(1f, 1f, 1f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("nuka_cola_exterior") && exteriortype == 7) {
            this.model = new NukaColaExterior();
            this.texture = NUKA_COLA_LOCATION;
            ((NukaColaExterior)this.model).door.yRot = (float) Math.toRadians(tile.nukaDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0.325f, 0.5);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.scale(0.23f, 0.23f, 0.23f);
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(NUKA_COLA_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("siege_mode") && exteriortype == 8) {
            this.model = new SiegeMode();
            this.texture = SIEGE_MODE_LOCATION;
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(1f, 1f, 1f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(45.0f));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(SIEGE_MODE_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("arcade_cabinet_exterior") && exteriortype == 9) {
            this.model = new ArcadeCabinet();
            this.texture = TRON_LOCATION;
            MatrixStackIn.translate(0, -0.85, 0);
            MatrixStackIn.pushPose();
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.655f, 0.655f, 0.655f);
            MatrixStackIn.scale(0.875f, 0.875f, 0.875f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.translate(0, 0, -tile.arcadeDoorDistance);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            ((ArcadeCabinet)this.model).door.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(TRON_LOCATION)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.655f, 0.655f, 0.655f);
            MatrixStackIn.scale(0.875f, 0.875f, 0.875f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            ((ArcadeCabinet)this.model).base.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(TRON_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("cushing_exterior") && exteriortype == 10) {
            this.model = new CushingExterior();
            this.cushingText(MatrixStackIn, Buffer, CombinedLight);
            this.texture = CUSHING_BASE_LOCATION;
            ((CushingExterior)this.model).right_door.yRot = -(float) Math.toRadians(tile.rightDoorRotation);
            ((CushingExterior)this.model).left_door.yRot = (float) Math.toRadians(tile.leftDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.scale(0.95f, 0.95f, 0.95f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(CUSHING_BASE_LM_NW_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("classic_exterior") && exteriortype == 11) {
            this.model = new ClassicExterior();
            this.classicText(MatrixStackIn, Buffer, CombinedLight);
            this.texture = CLASSIC_LOCATION;
            ((ClassicExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
            ((ClassicExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.scale(0.85f, 0.9f, 0.85f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(CLASSIC_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("hartnell_exterior") && exteriortype == 12) {
            this.model = new HartnellExterior();
            this.hartnellText(MatrixStackIn, Buffer, CombinedLight);
            this.texture = HARTNELL_LOCATION;
            ((HartnellExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
            ((HartnellExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(HARTNELL_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        MatrixStackIn.translate(0.5, 0, 0.5);
        if(exterior.getSerializedName().equals("type_40_tt_capsule") && exteriortype == 5)
            MatrixStackIn.scale(1.5f, 1.5f, 1.5f);
        if(exterior.getSerializedName().equals("hellbent_tt_capsule") && exteriortype == 6)
            MatrixStackIn.scale(1.25f, 1.25f, 1.25f);
        if(exterior.getSerializedName().equals("nuka_cola_exterior") && exteriortype == 7) {
            MatrixStackIn.scale(0.35f, 0.35f, 0.35f);
        }
        if(exterior.getSerializedName().equals("siege_mode") && exteriortype == 8) {
            MatrixStackIn.scale(1f, 1f, 1f);
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(45.0f));
        }
        if(exterior.getSerializedName().equals("arcade_cabinet_exterior") && exteriortype == 9) {
            MatrixStackIn.scale(0.875f, 0.875f, 0.875f);
        }
        if(exterior.getSerializedName().equals("cushing_exterior") && exteriortype == 10) {
            MatrixStackIn.scale(0.95f, 0.95f, 0.95f);
        }
        if(exterior.getSerializedName().equals("classic_exterior") && exteriortype == 11) {
            MatrixStackIn.scale(0.85f, 0.9f, 0.85f);
        }
        //if(exterior.getSerializedName().equals("arcade_cabinet_exterior") && exteriortype == 9) {
        //    MatrixStackIn.translate(0, -1f, 0);
        //    MatrixStackIn.scale(0.85f, 0.85f, 0.85f);
        //}
        MatrixStackIn.scale(0.65f, 0.65f, 0.65f);
        MatrixStackIn.translate(0, 1.5f, 0);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(this.texture)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }

    public void smithMintPosterText(MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.925f, 2.6f, -0.28f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0f));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("POLICE -=- BOX").getVisualOrderText();
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(1.28f, 2.6f, 0.925f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(-0.28f, 2.6f, 0.0900f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.09f, 2.6f, 1.28f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }

    public void coralText(MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.925f, 2.6f, -0.30f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0f));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("POLICE -=- BOX").getVisualOrderText();
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(1.30f, 2.6f, 0.925f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(-0.30f, 2.6f, 0.0900f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.09f, 2.6f, 1.30f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }

    public void cushingText(MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.925f, 2.825f, -0.375f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0f));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("POLICE -=- BOX").getVisualOrderText();
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(1.375f, 2.825f, 0.925f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(-0.375f, 2.825f, 0.0900f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.09f, 2.825f, 1.375f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }

    public void classicText(MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.925f, 2.725f, -0.28f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0f));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("POLICE -=- BOX").getVisualOrderText();
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(1.28f, 2.725f, 0.925f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(-0.28f, 2.725f, 0.0900f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.09f, 2.725f, 1.28f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }

    public void hartnellText(MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.925f, 2.6775f, -0.28f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0f));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("POLICE -=- BOX").getVisualOrderText();
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(1.28f, 2.6775f, 0.925f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(-0.28f, 2.6775f, 0.0900f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.09f, 2.6775f, 1.28f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }

    public void BakerText(MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.925f, 2.475f, -0.28f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0f));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("POLICE -=- BOX").getVisualOrderText();
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(1.28f, 2.475f, 0.925f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(-0.28f, 2.475f, 0.09f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.09f, 2.475f, 1.28f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }
}*/
//@TODO Make this render all the different types of exteriors; maybe implement the BasicBoxRenderer?

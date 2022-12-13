package com.mdt.ait.client.renderers.tardis;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.exteriors.*;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.enums.EnumMatState;
import com.mdt.ait.core.init.enums.EnumRotorState;
import com.mdt.ait.tardis.Tardis;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.Direction;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.math.vector.Vector4f;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class BasicBoxRenderer extends TileEntityRenderer<TardisTileEntity> {

    private ResourceLocation texture;
    private ResourceLocation lm_texture;
    public final int MaxLight = 15728880;
    protected static final RenderState.CullState CULL = new RenderState.CullState(true);

    //Textures
    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/basic_tardis_exterior.png");
    public static final ResourceLocation POSTER_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/secret_smith_poster_box.png");
    public static final ResourceLocation MINT_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/mint_tardis_exterior.png");
    public static final ResourceLocation CORAL_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/coral_exterior.png");
    public static final ResourceLocation BAKER_LOCATION  = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/baker_exterior.png");
    public static final ResourceLocation TT40_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/type_40_tt_capsule_exterior.png");
    public static final ResourceLocation HELLBENT_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/tt_capsule_exterior.png");
    public static final ResourceLocation NUKA_COLA_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/nuka_cola_exterior.png");
    public static final ResourceLocation SIEGE_MODE_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/siege_mode.png");
    public static final ResourceLocation TRON_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/tron_exterior.png");
    public static final ResourceLocation CUSHING_BASE_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/cushing_exterior.png");
    public static final ResourceLocation CLASSIC_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/classic_exterior.png");
    public static final ResourceLocation HARTNELL_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/hartnell_exterior.png");
    public static final ResourceLocation HUDOLIN_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/hudolin_exterior.png");
    public static final ResourceLocation TX3_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/tx3_capsule.png");
    public static final ResourceLocation TARDIM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/tardim_exterior.png");
    public static final ResourceLocation SHALKA_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/shalka_exterior.png");
    public static final ResourceLocation BOOTH_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/booth_exterior.png");
    public static final ResourceLocation STEVE_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/steve.png");
    public static final ResourceLocation FALLOUT_SHELTER_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/fallout_shelter_exterior.png");
    public static final ResourceLocation RANI_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/rani_exterior.png");
    public static final ResourceLocation CLOCK_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/clock_exterior.png");

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
    public static final ResourceLocation HUDOLIN_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/hudolin_exterior_emission.png");
    public static final ResourceLocation TX3_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/tx3_capsule_emission.png");
    public static final ResourceLocation TARDIM_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/tardim_exterior_emission.png");
    public static final ResourceLocation SHALKA_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/shalka_exterior_emission.png");
    public static final ResourceLocation BOOTH_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/booth_exterior_emission.png");
    public static final ResourceLocation FALLOUT_SHELTER_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/fallout_shelter_exterior_emission.png");
    public static final ResourceLocation RANI_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/rani_exterior_emission.png");

    /*//Outlines
    public static final ResourceLocation TX3_OUTLINE_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/tx3_outline.png");*/

    public BasicBox model;
    private final TileEntityRendererDispatcher rendererDispatcher;

    public BasicBoxRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new BasicBox();
        this.rendererDispatcher = rendererDispatcherIn;
        this.texture = LOCATION;
    }

    @Override
    public void render(TardisTileEntity tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        BlockPos belowTardis = tile.getBlockPos().below(1);
        /*if(tile.getLevel().getBlockState(belowTardis).getBlock() instanceof AirBlock) {
            MatrixStackIn.translate(0, +tile.upDown, 0);
        } else {
            MatrixStackIn.translate(0, 0, 0);
        }
        //ServerWorld level = AIT.server.getLevel(tile.linked_tardis.exterior_dimension);
        /*if(AIT.tardisManager.getBlockUnderTardis(tile.linked_tardis_id, level)) {
            if (tile.currentfloatstate == EnumRotorState.MOVING) {
                if (tile.floatTick < 0.4f/*1.5f*//*) {
                    tile.floatTick += 0.0005f;
                } else {
                    tile.floatTick = 0.8f/*1.5f*//*;
                    tile.currentfloatstate = EnumRotorState.STATIC;
                }
            }
            if (tile.currentfloatstate == EnumRotorState.STATIC) {
                if (tile.floatTick > 0.0f) {
                    tile.floatTick -= 0.0005f;
                } else {
                    tile.floatTick = 0.0f;
                    tile.currentfloatstate = EnumRotorState.MOVING;
                }
            }
        }*/
        MatrixStackIn.pushPose();
        EnumExteriorType exterior = EnumExteriorType.values()[tile.serializeNBT().getInt("currentexterior")];
        EnumDoorState door = EnumDoorState.values()[tile.serializeNBT().getInt("currentstate")];
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
            if(!door.equals(EnumDoorState.CLOSED)) {
                //this.model.right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
                //this.model.left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
                this.model.right_door.visible = false;
                this.model.left_door.visible = false;
            } else {
                this.model.right_door.visible = true;
                this.model.left_door.visible = true;
            }
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
            if(!door.equals(EnumDoorState.CLOSED)) {
                //((MintExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
                //((MintExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
                ((MintExterior)this.model).right_door.visible = false;
                ((MintExterior)this.model).left_door.visible = false;
            } else {
                ((MintExterior)this.model).right_door.visible = true;
                ((MintExterior)this.model).left_door.visible = true;
            }
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
            if(!door.equals(EnumDoorState.CLOSED)) {
                //((CoralExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
                //((CoralExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
                ((CoralExterior)this.model).right_door.visible = false;
                ((CoralExterior)this.model).left_door.visible = false;
            } else {
                ((CoralExterior)this.model).right_door.visible = true;
                ((CoralExterior)this.model).left_door.visible = true;
            }
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
            if(!door.equals(EnumDoorState.CLOSED)) {
                //this.model.right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
                //this.model.left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
                this.model.right_door.visible = false;
                this.model.left_door.visible = false;
            } else {
                this.model.right_door.visible = true;
                this.model.left_door.visible = true;
            }
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
            if(!door.equals(EnumDoorState.CLOSED)) {
                //((BakerExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
                //((BakerExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
                ((BakerExterior)this.model).right_door.visible = false;
                ((BakerExterior)this.model).left_door.visible = false;
            } else {
                ((BakerExterior)this.model).right_door.visible = true;
                ((BakerExterior)this.model).left_door.visible = true;
            }
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
            if(!door.equals(EnumDoorState.CLOSED)) {
                //((HellBentTTCapsuleExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
                //((HellBentTTCapsuleExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
                ((HellBentTTCapsuleExterior)this.model).right_door.visible = false;
                ((HellBentTTCapsuleExterior)this.model).left_door.visible = false;
            } else {
                ((HellBentTTCapsuleExterior)this.model).right_door.visible = true;
                ((HellBentTTCapsuleExterior)this.model).left_door.visible = true;
            }
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.98f, 0.98f, 0.98f);
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
            if(tile.getBlockState().getValue(TardisBlock.FACING) == Direction.NORTH) {
                MatrixStackIn.translate(0, 0, -tile.arcadeDoorDistance);
            }
            if(tile.getBlockState().getValue(TardisBlock.FACING) == Direction.WEST) {
                MatrixStackIn.translate(-tile.arcadeDoorDistance, 0, 0);
            }
            if(tile.getBlockState().getValue(TardisBlock.FACING) == Direction.SOUTH) {
                MatrixStackIn.translate(0, 0, tile.arcadeDoorDistance);
            }
            if(tile.getBlockState().getValue(TardisBlock.FACING) == Direction.EAST) {
                MatrixStackIn.translate(tile.arcadeDoorDistance, 0, 0);
            }
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).getOpposite().toYRot()));
            ((ArcadeCabinet)this.model).door.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(TRON_LOCATION)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.655f, 0.655f, 0.655f);
            MatrixStackIn.scale(0.875f, 0.875f, 0.875f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).getOpposite().toYRot()));
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
            /*if(tile.getBlockUnderTardis()) {
                MatrixStackIn.translate(0, tile.floatTick, 0);
            }*/
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(CUSHING_BASE_LM_NW_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("classic_exterior") && exteriortype == 11) {
            this.model = new ClassicExterior();
            this.classicText(MatrixStackIn, Buffer, CombinedLight);
            this.texture = CLASSIC_LOCATION;
            if(!door.equals(EnumDoorState.CLOSED)) {
                //((ClassicExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
                //((ClassicExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
                ((ClassicExterior)this.model).right_door.visible = false;
                ((ClassicExterior)this.model).left_door.visible = false;
            } else {
                ((ClassicExterior)this.model).right_door.visible = true;
                ((ClassicExterior)this.model).left_door.visible = true;
            }
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.scale(0.9f, 0.85f, 0.9f);
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
            if(!door.equals(EnumDoorState.CLOSED)) {
                //((HartnellExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
                //((HartnellExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
                ((HartnellExterior)this.model).right_door.visible = false;
                ((HartnellExterior)this.model).left_door.visible = false;
            } else {
                ((HartnellExterior)this.model).right_door.visible = true;
                ((HartnellExterior)this.model).left_door.visible = true;
            }
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(HARTNELL_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("hudolin_exterior") && exteriortype == 13) {
            this.model = new HudolinExterior();
            this.hudolinText(MatrixStackIn, Buffer, CombinedLight);
            this.texture = HUDOLIN_LOCATION;
            if(!door.equals(EnumDoorState.CLOSED)) {
                //((HudolinExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
                //((HudolinExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
                ((HudolinExterior)this.model).right_door.visible = false;
                ((HudolinExterior)this.model).left_door.visible = false;
            } else {
                ((HudolinExterior)this.model).right_door.visible = true;
                ((HudolinExterior)this.model).left_door.visible = true;
            }
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(HUDOLIN_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("tx3_exterior") && exteriortype == 14) {
            this.model = new TxThreeCapsule();
            this.texture = TX3_LOCATION;
            ((TxThreeCapsule)this.model).door.yRot = -(float) Math.toRadians(tile.nukaDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.98f, 0.98f, 0.98f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(TX3_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            //MatrixStackIn.pushPose();
            //((TxThreeCapsule)this.model).universe.render(MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(TX3_LOCATION)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            //MatrixStackIn.popPose();
            //MatrixStackIn.pushPose();
            //((TxThreeCapsule)this.model).universe.render(MatrixStackIn, Buffer.getBuffer(RenderType.endPortal(16)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            //MatrixStackIn.popPose();
            //MatrixStackIn.pushPose();
            //((TxThreeCapsule)this.model).universe.render(MatrixStackIn, Buffer.getBuffer(RenderType.endPortal(2)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            //MatrixStackIn.popPose();
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("tardim_exterior") && exteriortype == 15) {
            this.model = new TARDIMExterior();
            this.texture = TARDIM_LOCATION;
            ((TARDIMExterior)this.model).door.yRot = -(float) Math.toRadians(tile.tardimDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.98f, 0.98f, 0.98f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(TARDIM_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("shalka_exterior") && exteriortype == 16) {
            this.model = new ShalkaExterior();
            this.shalkaText(MatrixStackIn, Buffer, CombinedLight);
            this.texture = SHALKA_LOCATION;
            if(!door.equals(EnumDoorState.CLOSED)) {
                //((ShalkaExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
                //((ShalkaExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
                ((ShalkaExterior)this.model).right_door.visible = false;
                ((ShalkaExterior)this.model).left_door.visible = false;
            } else {
                ((ShalkaExterior)this.model).right_door.visible = true;
                ((ShalkaExterior)this.model).left_door.visible = true;
            }
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(SHALKA_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("booth_exterior") && exteriortype == 17) {
            this.model = new BoothExterior();
            this.texture = BOOTH_LOCATION;
            this.boothText(MatrixStackIn, Buffer, CombinedLight);
            ((BoothExterior)this.model).door.yRot = (float) Math.toRadians(tile.nukaDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.98f, 0.98f, 0.98f);
            MatrixStackIn.translate(0, 1.4875f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(BOOTH_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("steve_exterior") && exteriortype == 18) {
            this.model = new SteveExterior();
            this.texture = STEVE_LOCATION;
            ((SteveExterior)this.model).door.yRot = (float) Math.toRadians(tile.nukaDoorRotation);
        }
        if (exterior.getSerializedName().equals("fallout_shelter_exterior") && exteriortype == 19) {
            this.model = new FalloutShelterExterior();
            this.texture = FALLOUT_SHELTER_LOCATION;
            ((FalloutShelterExterior)this.model).door.yRot = (float) Math.toRadians(tile.falloutDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.98f, 0.98f, 0.98f);
            MatrixStackIn.translate(0, 1.4875f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(FALLOUT_SHELTER_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("rani_exterior") && exteriortype == 20) {
            this.model = new RaniExterior();
            this.texture = RANI_LOCATION;
            ((RaniExterior)this.model).door.yRot = (float) Math.toRadians(tile.nukaDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.translate(0, 1.4875f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(RANI_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (exterior.getSerializedName().equals("clock_exterior") && exteriortype == 21) {
            this.model = new ClockExterior();
            this.texture = CLOCK_LOCATION;
            ((ClockExterior)this.model).door.yRot = (float) Math.toRadians(tile.nukaDoorRotation);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
            MatrixStackIn.translate(0, 1.4875f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            MatrixStackIn.popPose();
        }
        MatrixStackIn.translate(0.5, 0, 0.5);
        if(exterior.getSerializedName().equals("type_40_tt_capsule") && exteriortype == 5) {
            MatrixStackIn.scale(1.5f, 1.5f, 1.5f);
        }
        if(exterior.getSerializedName().equals("hellbent_tt_capsule") && exteriortype == 6) {
            MatrixStackIn.scale(1.5f, 1.5f, 1.5f);
        }
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
            MatrixStackIn.scale(0.9f, 0.85f, 0.9f);
        }
        if(exterior.getSerializedName().equals("tx3_exterior") && exteriortype == 14) {
            MatrixStackIn.scale(1.5f, 1.5f, 1.5f);
        }
        if(exterior.getSerializedName().equals("tardim_exterior") && exteriortype == 15) {
            MatrixStackIn.scale(1.5f, 1.5f, 1.5f);
        }
        if(exterior.getSerializedName().equals("booth_exterior") && exteriortype == 17) {
            MatrixStackIn.scale(1.5f, 1.5f, 1.5f);
        }
        if(exterior.getSerializedName().equals("steve_exterior") && exteriortype == 18) {
            MatrixStackIn.scale(1.5f, 1.5f, 1.5f);
        }
        if(exterior.getSerializedName().equals("fallout_shelter_exterior") && exteriortype == 19) {
            MatrixStackIn.scale(1.5f, 1.5f, 1.5f);
        }
        if(exterior.getSerializedName().equals("clock_exterior") && exteriortype == 21) {
            MatrixStackIn.scale(1.5f, 1.5f, 1.5f);
        }
        MatrixStackIn.scale(0.65f, 0.65f, 0.65f);
        MatrixStackIn.translate(0, 1.5f, 0);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(this.texture)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }

    public void smithMintPosterText(MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
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

    public void hudolinText(MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.925f, 2.68f, -0.33f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0f));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("POLICE -=- BOX").getVisualOrderText();
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(1.33f, 2.68f, 0.925f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(-0.33f, 2.68f, 0.0900f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.09f, 2.68f, 1.33f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }

    public void cushingText(MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
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
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.925f, 2.475f, -0.28f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0f));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("POLICE === BOX").getVisualOrderText();
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

    public void hartnellText(MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
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

    public void shalkaText(MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.925f, 2.88f, -0.28f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0f));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("POLICE -=- BOX").getVisualOrderText();
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(1.28f, 2.88f, 0.925f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(-0.28f, 2.88f, 0.0900f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.09f, 2.88f, 1.28f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }

    public void boothText(MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.975f, 2.93f, -0.18f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0f));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("T E L E P H O N E").getVisualOrderText();
        fontRenderer.drawInBatch(irp, -5, 5, 0, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(1.18f, 2.93f, 0.975f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 0, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(-0.18f, 2.93f, 0.04f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 0, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.04f, 2.93f, 1.18f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 0, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
    }
}

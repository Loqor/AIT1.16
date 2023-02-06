package com.mdt.ait.client.renderers.tardis;

import com.mdt.ait.AIT;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.enums.EnumMatState;
import com.mojang.blaze3d.matrix.MatrixStack;
import io.mdt.ait.common.tiles.TARDISTileEntity;
import io.mdt.ait.tardis.exterior.model.BasicBoxModel;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.biome.Biome;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class BasicBoxRenderer extends TileEntityRenderer<TARDISTileEntity> {

    private ResourceLocation texture;
    private ResourceLocation lm_texture;
    public final int MaxLight = 15728880;
    protected static final RenderState.CullState CULL = new RenderState.CullState(true);
    public float spinnn = 0;

    //Textures
    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/basic_exterior.png");
    public static final ResourceLocation POSTER_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/secret_smith_poster_box.png");
    public static final ResourceLocation MINT_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/mint_exterior.png");
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
    public static final ResourceLocation BASIC_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/basic_exterior_emission.png");
    public static final ResourceLocation MINT_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/mint_exterior_emission.png");
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

    //Holiday stuff :)
    public static final ResourceLocation CHRISTMAS_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/holidays/basic_exterior_christmas.png");
    public static final ResourceLocation CHRISTMAS_MINT_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/holidays/mint_exterior_christmas.png");

    //Snow Biome Specific
    public static final ResourceLocation SNOW_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/biomes/snow/basic_exterior_snow.png");
    public static final ResourceLocation SNOW_MINT_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/biomes/snow/mint_exterior_snow.png");

    //Sand Biome Specific
    public static final ResourceLocation SAND_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/biomes/sand/basic_exterior_sand.png");
    public static final ResourceLocation SAND_MINT_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/biomes/sand/mint_exterior_sand.png");
    /*//Outlines
    public static final ResourceLocation TX3_OUTLINE_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/tx3_outline.png");*/

    public BasicBoxModel model;
    private final TileEntityRendererDispatcher rendererDispatcher;

    public BasicBoxRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new BasicBoxModel();
        this.rendererDispatcher = rendererDispatcherIn;
        this.texture = LOCATION;
    }

    @Override
    public void render(TARDISTileEntity tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        BlockPos belowTardis = tile.getBlockPos().below(1);
        ++spinnn;
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
        //MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(spinnn));
        //MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(22.0f));
        //MatrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(22.0f));
        //MatrixStackIn.translate(0, 0, -0.5);
        EnumExteriorType exterior = EnumExteriorType.values()[tile.serializeNBT().getInt("currentexterior")];
        EnumDoorState door = EnumDoorState.values()[tile.serializeNBT().getInt("currentstate")];
        int exteriortype = tile.serializeNBT().getInt("currentexterior");
        EnumMatState materialState = EnumMatState.values()[tile.serializeNBT().getInt("matState")];
        int mattype = tile.serializeNBT().getInt("matState");
        /*if(materialState != EnumMatState.SOLID) {
            ++tile.spinny;
        } else if (materialState == EnumMatState.SOLID) {
            tile.spinny = 0;
        }*/ //FIXME: dis
        if (exterior.getSerializedName().equals("basic_box") && exteriortype == 0) {
            this.model = new BasicBoxModel();
            this.smithMintPosterText(MatrixStackIn, Buffer, CombinedLight);
            LocalDate localdate = LocalDate.now();
            int i = localdate.get(ChronoField.DAY_OF_MONTH);
            int j = localdate.get(ChronoField.MONTH_OF_YEAR);
            if (j == 12 && (i == 24 || i == 25)) {
                this.texture = CHRISTMAS_LOCATION;
                this.model.christmas_stuff.visible = true;
            } else if (tile.getLevel().getBiome(tile.getBlockPos()).getPrecipitation() == Biome.RainType.SNOW) {
                this.texture = SNOW_LOCATION;
                this.model.christmas_stuff.visible = false;
            } else if (tile.getLevel().getBiome(tile.getBlockPos()).getPrecipitation() == Biome.RainType.NONE) {
                if(tile.getLevel().dimension() != tile.getLevel().NETHER ||
                tile.getLevel().dimension() != AITDimensions.GALLIFREY ||
                        tile.getLevel().dimension() != tile.getLevel().END ||
                tile.getLevel().dimension() != AITDimensions.TARDIS_DIMENSION ||
                tile.getLevel().dimension() != AITDimensions.VORTEX_DIMENSION) {
                        this.texture = SAND_LOCATION;
                        this.model.christmas_stuff.visible = false;
                }
            } else {
                this.texture = LOCATION;
                this.model.christmas_stuff.visible = false;
            }
            if(!door.equals(EnumDoorState.CLOSED)) {
                //this.model.right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
                //this.model.left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
                this.model.right_door.visible = false;
                this.model.left_door.visible = false;
            } else {
                this.model.right_door.visible = true;
                this.model.left_door.visible = true;
            }
            MatrixStackIn.translate(0.5f, 0f, 0.5f);
            MatrixStackIn.scale(0.725f, 0.725f, 0.725f);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0, 1.4949, 0);
            MatrixStackIn.scale(1.001f, 1.0001f, 1.001f);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(BASIC_LM_LOCATION, false)), MaxLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }

        MatrixStackIn.translate(0, 1.5f, 0);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(this.texture)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }

    public void smithMintPosterText(MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight) {
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.925f, 2.75f, -0.37f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0f));
        FontRenderer fontRenderer = this.rendererDispatcher.getFont();
        IReorderingProcessor irp = new StringTextComponent("POLICE -=- BOX").getVisualOrderText();
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(1.37f, 2.75f, 0.925f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(-0.37f, 2.75f, 0.09f);
        MatrixStackIn.scale(0.0125f, 0.0125f, 0.0125f);
        MatrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0f));
        fontRenderer.drawInBatch(irp, -5, 5, 16777215, false, MatrixStackIn.last().pose(), Buffer, false, 0, MaxLight);
        MatrixStackIn.popPose();
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.09f, 2.75f, 1.37f);
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

    @Override
    public boolean shouldRenderOffScreen(TARDISTileEntity pTe) {
        return true;
    }
}

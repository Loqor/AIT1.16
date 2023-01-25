package com.mdt.ait.client.renderers.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.exteriors.BasicBox;
import com.mdt.ait.client.models.exteriors.MintExterior;
import com.mdt.ait.client.models.tileentities.*;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.client.renderers.tardis.BasicBoxRenderer;
import com.mdt.ait.common.blocks.BasicInteriorDoorBlock;
import com.mdt.ait.common.tileentities.BasicInteriorDoorTile;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.enums.EnumInteriorDoorType;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.biome.Biome;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class BasicInteriorDoorRenderer extends TileEntityRenderer<BasicInteriorDoorTile> {
    public static final ResourceLocation BASIC = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/interior_doors/basic_interior_doors.png");
    public static final ResourceLocation MINT = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/interior_doors/mint_interior_doors.png");
    public static final ResourceLocation HUDOLIN = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/interior_doors/hudolin_interior_doors.png");
    public static final ResourceLocation CLASSIC = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/interior_doors/classic_interior_doors.png");
    public static final ResourceLocation FALLOUT_SHELTER = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/interior_doors/fallout_shelter_interior_door.png");
    public static final ResourceLocation HELLBENT_CAPSULE = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/interior_doors/tt_capsule_interior_door.png");
    public static final ResourceLocation TARDIM = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/tardim_exterior.png");

    //Snowing/Holidays
    public static final ResourceLocation SNOW_BASIC_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/interior_doors/biomes/basic_interior_doors_snow.png");
    public static final ResourceLocation SNOW_MINT_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/interior_doors/biomes/mint_interior_doors_snow.png");

    public BasicInteriorDoor model;
    private final TileEntityRendererDispatcher rendererDispatcher;
    public ResourceLocation texture;

    public BasicInteriorDoorRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new BasicInteriorDoor();
        this.texture = BASIC;
        this.rendererDispatcher = rendererDispatcherIn;
    }

    @Override
    public void render(BasicInteriorDoorTile tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        MatrixStackIn.pushPose();
        MatrixStackIn.translate(0.5, 0, 0.5);
        //MatrixStackIn.scale(0.65f, 0.65f, 0.65f);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(BasicInteriorDoorBlock.FACING).toYRot()));
        EnumInteriorDoorType interiordoor = EnumInteriorDoorType.values()[tile.serializeNBT().getInt("currentinteriordoor")];
        int interiordoortype = tile.serializeNBT().getInt("currentinteriordoor");
        boolean isitsnowing = tile.serializeNBT().getBoolean("isItSnowing");
        if(interiordoor.getSerializedName().equals("door_basic_exterior") && interiordoortype == 0) {
            this.model = new BasicInteriorDoor();
            LocalDate localdate = LocalDate.now();
            int i = localdate.get(ChronoField.DAY_OF_MONTH);
            int j = localdate.get(ChronoField.MONTH_OF_YEAR);
            if (j == 12 && (i == 24 || i == 25)) {
                this.texture = SNOW_BASIC_LOCATION;
            } else if (isitsnowing) {
                this.texture = SNOW_BASIC_LOCATION;
            } else {
                this.texture = BASIC;
            }
            this.model.right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
            this.model.left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
            MatrixStackIn.translate(0, -1.085f, 0);
            MatrixStackIn.scale(0.725f, 0.725f, 0.725f);
        }
        if(interiordoor.getSerializedName().equals("door_mint_exterior") && interiordoortype == 1) {
            this.model = new BasicInteriorDoor();
            LocalDate localdate = LocalDate.now();
            int i = localdate.get(ChronoField.DAY_OF_MONTH);
            int j = localdate.get(ChronoField.MONTH_OF_YEAR);
            if (j == 12 && (i == 24 || i == 25)) {
                this.texture = SNOW_MINT_LOCATION;
            } else if (isitsnowing) {
                this.texture = SNOW_MINT_LOCATION;
            } else {
                this.texture = MINT;
            }
            this.model.right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
            this.model.left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
            MatrixStackIn.translate(0, -1.085f, 0);
            MatrixStackIn.scale(0.725f, 0.725f, 0.725f);
        }
        if(interiordoor.getSerializedName().equals("door_classic_exterior") && interiordoortype == 11) {
            this.model = new ClassicInteriorDoors();
            this.texture = CLASSIC;
            MatrixStackIn.translate(0, 1.085f, 0);
            MatrixStackIn.scale(0.9f, 0.85f, 0.9f);
            ((ClassicInteriorDoors)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
            ((ClassicInteriorDoors)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
        }
        if(interiordoor.getSerializedName().equals("door_hudolin_exterior") && interiordoortype == 13) {
            this.model = new HudolinInteriorDoors();
            this.texture = HUDOLIN;
            MatrixStackIn.scale(0.65f, 0.65f, 0.65f);
            MatrixStackIn.translate(0, -1.5, 0.1);
            ((HudolinInteriorDoors)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
            ((HudolinInteriorDoors)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
        }
        if(interiordoor.getSerializedName().equals("door_tardim_exterior") && interiordoortype == 15) {
            this.model = new TARDIMInteriorDoor();
            this.texture = TARDIM;
            MatrixStackIn.translate(0, -1.5, 0);
            MatrixStackIn.scale(1f, 1f, 1f);
            if(tile.currentState() != EnumDoorState.CLOSED) {
                ((TARDIMInteriorDoor) this.model).door.visible = false;
            } else {
                ((TARDIMInteriorDoor) this.model).door.visible = true;
            }
        }
        if(interiordoor.getSerializedName().equals("door_hellbent_tt_capsule") && interiordoortype == 6) {
            this.model = new TTCapsuleInteriorDoor();
            this.texture = HELLBENT_CAPSULE;
            MatrixStackIn.scale(1f, 1f, 1f);
            MatrixStackIn.translate(0, -1.5, 0);
            ((TTCapsuleInteriorDoor)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
            ((TTCapsuleInteriorDoor)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
        }
        if(interiordoor.getSerializedName().equals("door_fallout_shelter_exterior") && interiordoortype == 19) {
            this.model = new FalloutShelterInteriorDoor();
            this.texture = FALLOUT_SHELTER;
            MatrixStackIn.scale(1f, 1f, 1f);
            MatrixStackIn.translate(0, -1.5, 0);
            if(tile.currentState() != EnumDoorState.CLOSED) {
                ((FalloutShelterInteriorDoor) this.model).door.x -= 12;
            } else {
                ((FalloutShelterInteriorDoor) this.model).door.x = -5.5F;
            }
        }
        //System.out.println(interiordoor.getSerializedName() + interiordoortype);
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(this.texture)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }
}

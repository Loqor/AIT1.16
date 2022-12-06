package com.mdt.ait.client.renderers.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.tileentities.RecordPlayer;
import com.mdt.ait.common.blocks.RecordPlayerBlock;
import com.mdt.ait.common.tileentities.RecordPlayerTile;
import com.mdt.ait.core.init.enums.EnumRecordPlayerState;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;


public class RecordPlayerRenderer extends TileEntityRenderer<RecordPlayerTile> {

    public static final ResourceLocation ORIGINAL = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/record_player.png");
    public static final ResourceLocation THIRTEEN_RECORD = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/record_player_13.png");
    public static final ResourceLocation CAT_RECORD = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/record_player_cat.png");
    public static final ResourceLocation BLOCKS_RECORD = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/record_player_blocks.png");
    public static final ResourceLocation CHIRP_RECORD = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/record_player_chirp.png");
    public static final ResourceLocation FAR_RECORD = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/record_player_far.png");
    public static final ResourceLocation MALL_RECORD = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/record_player_mall.png");
    public static final ResourceLocation MELLOHI_RECORD = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/record_player_mellohi.png");
    public static final ResourceLocation STAL_RECORD = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/record_player_stal.png");
    public static final ResourceLocation STRAD_RECORD = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/record_player_strad.png");
    public static final ResourceLocation WARD_RECORD = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/record_player_ward.png");
    public static final ResourceLocation ELEVEN_RECORD = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/record_player_11.png");
    public static final ResourceLocation WAIT_RECORD = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/record_player_wait.png");
    public static final ResourceLocation PIGSTEP_RECORD = new ResourceLocation(AIT.MOD_ID, "textures/tileentities/record_player_pigstep.png");
    private ResourceLocation texture;
    public RecordPlayer model;
    private final TileEntityRendererDispatcher rendererDispatcher;
    net.minecraft.client.renderer.ItemRenderer itemRenderer;
    double xposface = 0.0d;
    double yposface = 0.0d;
    double zposface = 0.0d;
    float rotatedisc = 0.0f;
    float rotatethex = 0.0f;

    public RecordPlayerRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new RecordPlayer();
        this.rendererDispatcher = rendererDispatcherIn;
        this.texture = ORIGINAL;
    }

    public void mathy(RecordPlayerTile tile) {
        Direction facing = tile.getBlockState().getValue(RecordPlayerBlock.FACING);
        if(facing == Direction.NORTH) {
            xposface = 0.15d;
            yposface = -0.25d;
            zposface = 1.3d;
            rotatedisc = 0.0f;
            rotatethex = -90.0f;
        }
        if(facing == Direction.EAST) {
            xposface = -1.3d;
            yposface = -0.25d;
            zposface = 0.15d;
            rotatedisc = 90f;
            rotatethex = -90f;
        }
        if(facing == Direction.SOUTH) {
            xposface = -0.15d;
            yposface = -0.25d;
            zposface = -1.3d;
            rotatedisc = 180.0f;
            rotatethex = 90.0f;
        }
        if(facing == Direction.WEST) {
            xposface = 1.3d;
            yposface = -0.25d;
            zposface = -0.15d;
            rotatedisc = -90f;
            rotatethex = 90f;
        }
    }

    @Override
    public void render(RecordPlayerTile tile, float PartialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int CombinedLight, int CombinedOverlay) {
        matrixStack.pushPose();
        mathy(tile);
        matrixStack.translate(0.5, 0, 0.5);
        this.model.lid.xRot = (float) Math.toRadians(tile.recordState);
        matrixStack.scale(1f, 1f, 1f);
        matrixStack.translate(0, 1.5f, 0);
        matrixStack.pushPose();
        if (getParentModel() instanceof RecordPlayer) {
            RecordPlayer model = (RecordPlayer) getParentModel();
            matrixStack.mulPose(Vector3f.YN.rotation(model.record.yRot));
        }
        Direction facing = tile.getBlockState().getValue(RecordPlayerBlock.FACING);
        if(facing == Direction.NORTH || facing == Direction.SOUTH) {
            matrixStack.mulPose(Vector3f.XN.rotationDegrees(rotatethex));
        }
        if(facing == Direction.EAST || facing == Direction.WEST) {
            matrixStack.mulPose(Vector3f.ZN.rotationDegrees(rotatethex));
        }
        if(tile.playerState == EnumRecordPlayerState.PLAYING && tile.isHasRecord) {
            this.model.needle.yRot = (float) Math.toRadians(tile.needleState);
            this.model.record.yRot = (float) Math.toRadians(tile.spindisc);
            //13
            if(tile.record == Items.MUSIC_DISC_13) {
                this.texture = THIRTEEN_RECORD;
            }
            //cat
            if(tile.record == Items.MUSIC_DISC_CAT) {
                this.texture = CAT_RECORD;
            }
            //blocks
            if(tile.record == Items.MUSIC_DISC_BLOCKS) {
                this.texture = BLOCKS_RECORD;
            }
            //chirp
            if(tile.record == Items.MUSIC_DISC_CHIRP) {
                this.texture = CHIRP_RECORD;
            }
            //far
            if(tile.record == Items.MUSIC_DISC_FAR) {
                this.texture = FAR_RECORD;
            }
            //mall
            if(tile.record == Items.MUSIC_DISC_MALL) {
                this.texture = MALL_RECORD;
            }
            //mellohi
            if(tile.record == Items.MUSIC_DISC_MELLOHI) {
                this.texture = MELLOHI_RECORD;
            }
            //stal
            if(tile.record == Items.MUSIC_DISC_STAL) {
                this.texture = STAL_RECORD;
            }
            //strad
            if(tile.record == Items.MUSIC_DISC_STRAD) {
                this.texture = STRAD_RECORD;
            }
            //ward
            if(tile.record == Items.MUSIC_DISC_WARD) {
                this.texture = WARD_RECORD;
            }
            //11
            if(tile.record == Items.MUSIC_DISC_11) {
                this.texture = ELEVEN_RECORD;
            }
            //wait
            if(tile.record == Items.MUSIC_DISC_WAIT) {
                this.texture = WAIT_RECORD;
            }
            //pigstep
            if(tile.record == Items.MUSIC_DISC_PIGSTEP) {
                this.texture = PIGSTEP_RECORD;
            }
            /*this.renderItem(stack, new double[] {xposface, yposface, zposface},
                    Vector3f.YN.rotationDegrees(rotatedisc), matrixStack, buffer, PartialTicks,
                    CombinedOverlay, CombinedLight, 1.5f);*/
        } else {
            this.texture = ORIGINAL;
            this.model.needle.yRot = 0;
        }
        matrixStack.popPose();
        matrixStack.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        matrixStack.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(RecordPlayerBlock.FACING).toYRot()));
        IVertexBuilder vertexBuffer = buffer.getBuffer(RenderType.entityTranslucent(this.texture));
        model.render(tile, matrixStack, vertexBuffer, CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        matrixStack.popPose();
    }

    private void renderItem(ItemStack stack, double[] translation, Quaternion rotation, MatrixStack matrixStack,
                            IRenderTypeBuffer buffer, float partialTicks, int CombinedOverlay, int CombinedLight, float scale) {
        matrixStack.pushPose();
        matrixStack.translate(translation[0], translation[1], translation[2]);
        matrixStack.mulPose(rotation);
        matrixStack.scale(scale, scale, scale);
        IBakedModel itemModel = Minecraft.getInstance().getItemRenderer().getItemModelShaper().getItemModel(stack);
        Minecraft.getInstance().getItemRenderer().render(stack, ItemCameraTransforms.TransformType.GROUND, true, matrixStack, buffer,
                CombinedLight, CombinedOverlay, itemModel);
        matrixStack.popPose();
    }

    public Model getParentModel() {
        return this.model;
    }
}

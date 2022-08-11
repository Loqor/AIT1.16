package com.mdt.ait.client.renderers.consoles;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.consoles.DevConsole;
import com.mdt.ait.client.models.exteriors.BasicBox;
import com.mdt.ait.client.models.exteriors.CoralExterior;
import com.mdt.ait.client.models.exteriors.MintExterior;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.ConsoleBlock;
import com.mdt.ait.common.tileentities.ConsoleTileEntity;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.enums.EnumConsoleType;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class BasicConsoleRenderer extends TileEntityRenderer<ConsoleTileEntity> {

    private ResourceLocation texture;
    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/consoles/dev_console.png");
    //public static final ResourceLocation MINT_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/mint_tardis_exterior.png");
    //public static final ResourceLocation CORAL_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/coral_exterior.png");
    //public static final ResourceLocation BASIC_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/basic_tardis_emission.png");
    //public static final ResourceLocation MINT_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/mint_tardis_emission.png");
    //public static final ResourceLocation CORAL_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/coral_tardis_emission.png");
    public DevConsole model;
    private final TileEntityRendererDispatcher rendererDispatcher;

    public BasicConsoleRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.model = new DevConsole();
        this.rendererDispatcher = rendererDispatcherIn;
        this.texture = LOCATION;
    }

    @Override
    public void render(ConsoleTileEntity tile, float PartialTicks, MatrixStack MatrixStackIn, IRenderTypeBuffer Buffer, int CombinedLight, int CombinedOverlay) {
        EnumConsoleType console = EnumConsoleType.values()[tile.serializeNBT().getInt("currentconsole")];
        int consoletype = tile.serializeNBT().getInt("currentconsole");
        MatrixStackIn.pushPose();
        if (console.getSerializedName().equals("dev_console") && consoletype == 0) {
            this.model = new DevConsole();
            this.texture = LOCATION;
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.6f, 0.6f, 0.6f);
            MatrixStackIn.translate(0, 1.5f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(ConsoleBlock.FACING).toYRot()));
            model.render(tile, MatrixStackIn, Buffer.getBuffer(RenderType.cutoutMipped()), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        //if (exterior.getSerializedName().equals("mint_box") && exteriortype == 1) {
        //    this.model = new MintExterior();
        //    this.texture = MINT_LOCATION;
        //    ((MintExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
        //    ((MintExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
        //    MatrixStackIn.pushPose();
        //    MatrixStackIn.translate(0.5, 0, 0.5);
        //    MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
        //    MatrixStackIn.translate(0, 1.4949f, 0);
        //    MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        //    MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
        //    model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(MINT_LM_LOCATION, false)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        //    MatrixStackIn.popPose();
        //}
        //if (exterior.getSerializedName().equals("coral_box") && exteriortype == 2) {
        //    this.model = new CoralExterior();
        //    this.texture = CORAL_LOCATION;
        //    ((CoralExterior)this.model).right_door.yRot = (float) Math.toRadians(tile.rightDoorRotation);
        //    ((CoralExterior)this.model).left_door.yRot = -(float) Math.toRadians(tile.leftDoorRotation);
        //    MatrixStackIn.pushPose();
        //    MatrixStackIn.translate(0.5, 0, 0.5);
        //    MatrixStackIn.scale(0.651f, 0.651f, 0.651f);
        //    MatrixStackIn.translate(0, 1.4949f, 0);
        //    MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        //    MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(TardisBlock.FACING).toYRot()));
        //    model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(CORAL_LM_LOCATION, false)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        //    MatrixStackIn.popPose();
        //}
        MatrixStackIn.translate(0.5, 0, 0.5);
        MatrixStackIn.scale(0.65f, 0.65f, 0.65f);
        MatrixStackIn.translate(0, 1.5f, 0);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(ConsoleBlock.FACING).toYRot()));
        /*float alpha = 1.0F;
        if(tile.getMatState() != EnumMatState.SOLID){
        }*/
        model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisRenderOver(this.texture)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }
}

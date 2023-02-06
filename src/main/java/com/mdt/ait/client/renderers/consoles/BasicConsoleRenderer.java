package com.mdt.ait.client.renderers.consoles;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.consoles.BorealisConsole;
import com.mdt.ait.client.models.consoles.DevConsole;
import com.mdt.ait.client.models.consoles.HudolinConsole;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.common.blocks.ConsoleBlock;
import com.mdt.ait.common.tileentities.ConsoleTileEntity;
import com.mdt.ait.core.init.enums.EnumConsoleType;
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
    public static final ResourceLocation TEST_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/exteriors/mint_tardis_exterior.png");
    public static final ResourceLocation BOREALIS_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/consoles/borealis_console.png");
    public static final ResourceLocation HUDOLIN_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/consoles/hudolin_console.png");

    public static final ResourceLocation LM_HUDOLIN = new ResourceLocation(AIT.MOD_ID, "textures/consoles/hudolin_console_emission.png");

    //public static final ResourceLocation BOREALIS_LM_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/consoles/borealis_console_emission.png");

    public final int MaxLight = 15728880;
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
        //System.out.println(tile.Throttle.hurt(DamageSource.GENERIC, 0));
        if (console.getSerializedName().equals("borealis_console") && consoletype == 0) {
            this.model = new BorealisConsole();
            this.texture = BOREALIS_LOCATION;
            ((BorealisConsole)this.model).glow.setBright(1.0f);
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.501f, 0.501f, 0.501f);
            MatrixStackIn.translate(0, 1.4949f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(ConsoleBlock.FACING).toYRot()));
            if(tile.throttleHit()) {
                ((BorealisConsole)this.model).handbrake.xRot = -75f;
            } else {
                ((BorealisConsole)this.model).handbrake.xRot = 150f;
            }
            //model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(BOREALIS_LM_LOCATION, true)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
        }
        if (console.getSerializedName().equals("hudolin_console") && consoletype == 1) {
            this.model = new HudolinConsole();
            this.texture = HUDOLIN_LOCATION;
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(0.8f, 0.8f, 0.8f);
            MatrixStackIn.translate(0, 1.5f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(ConsoleBlock.FACING).toYRot()));
            MatrixStackIn.pushPose();
            MatrixStackIn.scale(1.001F, 1.001F, 1.001F);
            model.render(tile, MatrixStackIn, Buffer.getBuffer(AITRenderTypes.TardisLightmap(LM_HUDOLIN, true)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
            MatrixStackIn.popPose();
            MatrixStackIn.popPose();
        }
        if (console.getSerializedName().equals("dev_console") && consoletype == 2) {
            this.model = new DevConsole();
            this.texture = LOCATION;
            MatrixStackIn.pushPose();
            MatrixStackIn.translate(0.5, 0, 0.5);
            MatrixStackIn.scale(1f, 1f, 1f);
            MatrixStackIn.translate(0, 1.5f, 0);
            MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
            MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(ConsoleBlock.FACING).toYRot()));
            MatrixStackIn.popPose();
        }
        MatrixStackIn.translate(0.5, 0, 0.5);
        MatrixStackIn.translate(0, 1.5f, 0);
        MatrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        MatrixStackIn.mulPose(Vector3f.YP.rotationDegrees(tile.getBlockState().getValue(ConsoleBlock.FACING).toYRot()));
        if(console.getSerializedName().equals("borealis_console") && consoletype == 0) {
            MatrixStackIn.scale(0.5f, 0.5f, 0.5f);
            MatrixStackIn.translate(0, 1.5f, 0);
        }
        model.render(tile, MatrixStackIn, Buffer.getBuffer(RenderType.entityCutout(this.texture)), CombinedLight, CombinedOverlay, 1, 1, 1, 1);
        MatrixStackIn.popPose();
    }
}

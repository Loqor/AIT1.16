package com.mdt.ait.client.screen;

import com.mdt.ait.AIT;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.network.NetworkHandler;
import com.mdt.ait.network.packets.tardis_monitor.TardisMonitorC2SExteriorChangePacket;
import com.mdt.ait.tardis.Tardis;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.*;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.UUID;

@OnlyIn(Dist.CLIENT)
public class MonitorScreen extends Screen {
    private static final ResourceLocation MONITOR_GUI = new ResourceLocation(AIT.MOD_ID, "textures/screens/monitor_screen.png");
    private static final ResourceLocation EXTERIOR_SELECTION_TEST = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/exterior_screen_test.png");
    private static final ResourceLocation EXTERIOR_SELECTION_TEST2 = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/exterior_screen_test2.png");
    private static final ResourceLocation BASIC_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/basic_exterior_screen.png");
    private static final ResourceLocation BAKER_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/baker_exterior_screen.png");
    private static final ResourceLocation HELLBENT_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/hellbent_exterior_screen.png");
    private static final ResourceLocation CUSHING_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/cushing_exterior_screen.png");
    private static final ResourceLocation CLASSIC_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/classic_exterior_screen.png");
    private static final ResourceLocation HARTNELL_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/hartnell_exterior_screen.png");
    private static final ResourceLocation HUDOLIN_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/hudolin_exterior_screen.png");
    private static final ResourceLocation TARDIM_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/tardim_exterior_screen.png");
    private static final ResourceLocation FALLOUT_SHELTER_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/fallout_shelter_exterior_screen.png");
    private static final ResourceLocation RANI_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/rani_exterior_screen.png");
    private static final ResourceLocation CLOCK_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/clock_exterior_screen.png");

    private int imageHeight;
    private int imageWidth;
    public UUID tardisID;
    public ResourceLocation SelectedTardis;
    public Tardis tardis;

    public MonitorScreen(ITextComponent label, UUID tardisid) {
        super(label);
        ++this.imageHeight;
        this.imageWidth = 231;
        this.imageHeight = 150;
        this.tardisID = tardisid;
        this.SelectedTardis = BASIC_EXTERIOR_SCREEN;
    }

    //@TODO I know this is confusing, it's basically getting the next exterior type.
    public void switchScreenTexture() {
        Tardis tardis = AIT.tardisManager.getTardis(this.tardisID);
        if (tardis != null) {
            if (tardis.getExteriorType() == EnumExteriorType.BASIC_BOX) {
                this.SelectedTardis = BASIC_EXTERIOR_SCREEN;
            }
            if (tardis.getExteriorType() == EnumExteriorType.MINT_BOX) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.CORAL_BOX) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.POSTER_BOX) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.BAKER_BOX) {
                this.SelectedTardis = BAKER_EXTERIOR_SCREEN;
            }
            if (tardis.getExteriorType() == EnumExteriorType.TYPE_40_TT_CAPSULE) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.HELLBENT_TT_CAPSULE) {
                this.SelectedTardis = HELLBENT_EXTERIOR_SCREEN;
            }
            if (tardis.getExteriorType() == EnumExteriorType.NUKA_COLA_EXTERIOR) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.ARCADE_CABINET_EXTERIOR) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.CUSHING_EXTERIOR) {
                this.SelectedTardis = CUSHING_EXTERIOR_SCREEN;
            }
            if (tardis.getExteriorType() == EnumExteriorType.CLASSIC_EXTERIOR) {
                this.SelectedTardis = CLASSIC_EXTERIOR_SCREEN;
            }
            if (tardis.getExteriorType() == EnumExteriorType.HARTNELL_EXTERIOR) {
                this.SelectedTardis = HARTNELL_EXTERIOR_SCREEN;
            }
            if (tardis.getExteriorType() == EnumExteriorType.HUDOLIN_EXTERIOR) {
                this.SelectedTardis = HUDOLIN_EXTERIOR_SCREEN;
            }
            if (tardis.getExteriorType() == EnumExteriorType.TX3_EXTERIOR) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.TARDIM_EXTERIOR) {
                this.SelectedTardis = TARDIM_EXTERIOR_SCREEN;
            }
            if (tardis.getExteriorType() == EnumExteriorType.SHALKA_EXTERIOR) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.BOOTH_EXTERIOR) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.STEVE_EXTERIOR) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.FALLOUT_SHELTER_EXTERIOR) {
                this.SelectedTardis = FALLOUT_SHELTER_EXTERIOR_SCREEN;
            }
            if (tardis.getExteriorType() == EnumExteriorType.RANI_EXTERIOR) {
                this.SelectedTardis = RANI_EXTERIOR_SCREEN;
            }
            if(tardis.getExteriorType() == EnumExteriorType.CLOCK_EXTERIOR) {
                this.SelectedTardis = CLOCK_EXTERIOR_SCREEN;
            }
        }
    }

    @Override public void render(MatrixStack matrixStack, int pMouseX, int pMouseY, float pPartialTicks) {
        this.renderBackground(matrixStack);
        this.renderTardisSelection(matrixStack);
        super.render(matrixStack, pMouseX, pMouseY, pPartialTicks);
        switchScreenTexture();
    }

    @Override
    public void renderBackground(MatrixStack pMatrixStack) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(MONITOR_GUI);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(pMatrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override protected void init() {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.addButton(
                new Button (i + 207, j + 60, 20, 20,
                        new StringTextComponent(">"),
                        (button) -> onPressRightButton()));
        this.addButton(
                new Button (i + 5, j + 60, 20, 20,
                        new StringTextComponent("<"),
                        (button) -> onPressLeftButton()));
    }

    public void renderTardisSelection(MatrixStack matrixStack) {
        matrixStack.pushPose();
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(this.SelectedTardis);
        int i = (this.width - 64);
        int j = (this.height - 64);
        matrixStack.scale(0.5f, 0.5f, 0.5f);
        this.blit(matrixStack, i  + 16, j - 64, 0, 0, 256, 256);
        matrixStack.popPose();
    }

    private void onPressRightButton() {
        NetworkHandler.CHANNEL.sendToServer(new TardisMonitorC2SExteriorChangePacket(this.tardisID, true));
    }

    private void onPressLeftButton() {
        NetworkHandler.CHANNEL.sendToServer(new TardisMonitorC2SExteriorChangePacket(this.tardisID, false));
    }
}

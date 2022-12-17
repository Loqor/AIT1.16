package com.mdt.ait.client.screen;

import com.mdt.ait.AIT;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.network.NetworkHandler;
import com.mdt.ait.network.packets.tardis_monitor.TardisMonitorC2SExteriorChangePacket;
import com.mdt.ait.tardis.Tardis;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ReadBookScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.UUID;

@OnlyIn(Dist.CLIENT)
public class GallifreyanManualBookScreen extends ReadBookScreen {
    private static final ResourceLocation MONITOR_GUI = new ResourceLocation(AIT.MOD_ID, "textures/screens/monitor_screen.png");

    private int imageHeight;
    private int imageWidth;

    public GallifreyanManualBookScreen(ReadBookScreen.IBookInfo p_i51098_1_) {
        super(p_i51098_1_);
        ++this.imageHeight;
        this.imageWidth = 231;
        this.imageHeight = 150;
    }

    @Override public void render(MatrixStack matrixStack, int pMouseX, int pMouseY, float pPartialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, pMouseX, pMouseY, pPartialTicks);
    }

    @Override
    public void renderBackground(MatrixStack pMatrixStack) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(MONITOR_GUI);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(pMatrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }

    /*@Override protected void init() {
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

    private void onPressRightButton() {

    }

    private void onPressLeftButton() {

    }*/
}

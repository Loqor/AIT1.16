package com.mdt.ait.client.screen;

import com.mdt.ait.AIT;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MonitorScreen extends Screen {
    private static final ResourceLocation MONITOR_GUI = new ResourceLocation(AIT.MOD_ID, "textures/screens/monitor_screen.png");

    private int imageHeight;
    private int imageWidth;

    public MonitorScreen(ITextComponent label) {
        super(label);
        ++this.imageHeight;
        this.imageWidth = 176;
        this.imageHeight = 167;
    }

    @Override public void render(MatrixStack matrixStack, int pMouseX, int pMouseY, float pPartialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, pMouseX, pMouseY, pPartialTicks);
    }

    @Override
    public void renderBackground(MatrixStack pMatrixStack) {
        super.renderBackground(pMatrixStack);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(MONITOR_GUI);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(pMatrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
        //System.out.println("HEIGHT: " + this.imageHeight + " || WIDTH: " + this.imageWidth);
    }

    @Override protected void init() {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.addButton(
                new Button (i + 150, j + 55, 20, 20,
                        new StringTextComponent(">"),
                        (button) -> onPressLeftButton()));
        this.addButton(
                new Button (i + 5, j + 55, 20, 20,
                        new StringTextComponent("<"),
                        (button) -> onPressRightButton()));
    }

    private void onPressRightButton() {

    }

    private void onPressLeftButton() {

    }


}

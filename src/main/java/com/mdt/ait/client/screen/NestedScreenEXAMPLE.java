package com.mdt.ait.client.screen;

import com.mdt.ait.AIT;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.client.gui.widget.Slider;

public class NestedScreenEXAMPLE extends Screen {
    private static final ResourceLocation MONITOR_GUI = new ResourceLocation(AIT.MOD_ID, "textures/screens/base_monitor_gui.png");
    private final Screen oldScreen;
    private int imageHeight;
    private int imageWidth;
    private Slider slider;
    private FontRenderer fontRenderer;

    public NestedScreenEXAMPLE(ITextComponent label, Screen oldScreen) {
        super(label);
        ++this.imageHeight;
        this.imageWidth = 176;
        this.imageHeight = 175;
        this.oldScreen = oldScreen;
    }

    @Override protected void init() {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.addButton(
                slider = MonitorScreen.createSlider(this,i+5,j+60,128,20,new StringTextComponent("Slider 1: "),StringTextComponent.EMPTY,0d,128d,0d,false,true,(button) -> System.out.println())
        );
        slider.updateSlider();
    }
    @Override public void render(MatrixStack matrixStack, int pMouseX, int pMouseY, float pPartialTicks) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.renderBackground(matrixStack);
        super.render(matrixStack, pMouseX, pMouseY, pPartialTicks);
        checkSlider(oldScreen);
    }

    private void checkSlider(Screen screen) {
        if (slider.getValue() == 128d) {
            Minecraft.getInstance().setScreen(screen);
        }
    }


    @Override
    public void renderBackground(MatrixStack pMatrixStack) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(MONITOR_GUI);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(pMatrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }
}

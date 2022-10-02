/*package com.mdt.ait.client.screen;

import com.mdt.ait.AIT;
import com.mdt.aitm.AdventuresInTime;
import com.mdt.aitm.common.container.MonitorContainer;
import com.mdt.aitm.tardis.Tardis;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.qouteall.hiding_in_the_bushes.MyNetwork;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

@OnlyIn(Dist.CLIENT)
public class BagScreen extends ContainerScreen<BagContainer> {
    private static final ResourceLocation BAG_GUI = new ResourceLocation(AIT.MOD_ID, "textures/gui/bag_gui.png");

    public BagScreen(BagContainer container, PlayerInventory inventory, ITextComponent label) {
        super(container, inventory, new TranslationTextComponent("gui.ait.title"));
        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 230;
        this.imageHeight = 219;
    }

    @Override public void render(MatrixStack matrixStack, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, p_230430_2_, p_230430_3_, p_230430_4_);
        this.renderTooltip(matrixStack, p_230430_2_, p_230430_3_);
    }

    @Override
    protected void renderBg(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.textureManager.bind(BAG_GUI);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        this.blit(p_230450_1_, (int) x, y, 0, 0, this.imageWidth, this.imageHeight);
    }

}*/

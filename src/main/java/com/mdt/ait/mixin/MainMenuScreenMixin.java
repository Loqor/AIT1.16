package com.mdt.ait.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.mdt.ait.AIT;

import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.renderer.RenderSkybox;
import net.minecraft.client.renderer.RenderSkyboxCube;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@Mixin(MainMenuScreen.class)
@OnlyIn(Dist.CLIENT)
public class MainMenuScreenMixin {

	private static final RenderSkybox MOD_PANORAMA = new RenderSkybox(new RenderSkyboxCube(new ResourceLocation(AIT.MOD_ID, "textures/gui/ait/title/background/panorama")));

    @Redirect(method = "Lnet/minecraft/client/gui/screen/MainMenuScreen;render(Lcom/mojang/blaze3d/matrix/MatrixStack;IIF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/RenderSkybox;render(FF)V", ordinal = 0))
    private void replacePanorama(RenderSkybox oldPanorama, float pDeltaT, float pAlpha) {
    	boolean isConfigEnabled = true; // Change this when you get a configuration file.
		if (isConfigEnabled) MOD_PANORAMA.render(pDeltaT, pAlpha);
		else oldPanorama.render(pDeltaT, pAlpha);
    }
	
}

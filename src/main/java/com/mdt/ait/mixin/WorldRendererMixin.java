package com.mdt.ait.mixin;

import com.mdt.ait.AIT;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.mdt.ait.client.renderers.ModdedSkyBoxes;
import com.mdt.ait.core.init.AITDimensions;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@Mixin(WorldRenderer.class)
@OnlyIn(Dist.CLIENT)
public class WorldRendererMixin {	
	
	// ONLY USE THIS WITH A DEFAULT SKY RENDERER
    @Redirect(method = "Lnet/minecraft/client/renderer/WorldRenderer;renderSky(Lcom/mojang/blaze3d/matrix/MatrixStack;F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/texture/TextureManager;bind(Lnet/minecraft/util/ResourceLocation;)V", ordinal = 0))
    private void replaceTardisSun(TextureManager textureManager, ResourceLocation oldSun) {
		Minecraft mc = Minecraft.getInstance();
    	RegistryKey<World> dim = mc.level.dimension();
		if (dim.equals(AITDimensions.TARDIS_DIMENSION)) {
			textureManager.bind(ModdedSkyBoxes.EYE_OF_HARMONY);
		} else if (dim != AITDimensions.GALLIFREY) {
			textureManager.bind(oldSun);
		} else {
			textureManager.bind(ModdedSkyBoxes.GALLIFREY_SUN);
		}
    }

}

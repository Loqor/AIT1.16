package com.mdt.ait.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.mdt.ait.AIT;
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

	private static final ResourceLocation GALLIFREY_SUN = new ResourceLocation(AIT.MOD_ID, "textures/skies/gallifreyan_sun.png");
	
	
	// ONLY USE THIS WITH A DEFAULT SKY RENDERER
    @Redirect(method = "Lnet/minecraft/client/renderer/WorldRenderer;renderSky(Lcom/mojang/blaze3d/matrix/MatrixStack;F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/texture/TextureManager;bind(Lnet/minecraft/util/ResourceLocation;)V", ordinal = 0))
    private void replaceSun(TextureManager textureManager, ResourceLocation oldSun) {
		Minecraft mc = Minecraft.getInstance();
    	RegistryKey<World> dim = mc.level.dimension();
    	    	
    	if (dim.equals(AITDimensions.GALLIFREY)) textureManager.bind(GALLIFREY_SUN);
    	else textureManager.bind(oldSun);
    }

}

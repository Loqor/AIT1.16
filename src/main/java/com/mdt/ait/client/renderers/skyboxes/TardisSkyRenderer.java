package com.mdt.ait.client.renderers.skyboxes;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.client.ISkyRenderHandler;

public class TardisSkyRenderer implements ISkyRenderHandler {

	public static final TardisSkyRenderer INSTANCE = new TardisSkyRenderer();
	
	@Override 
	public void render(int ticks, float partialTicks, MatrixStack pMatrixStack, ClientWorld world, Minecraft mc) {
		Tessellator tessellator = Tessellator.getInstance();
	  	BufferBuilder bufferbuilder = tessellator.getBuilder();
	
	  	for(int i = 0; i < 6; ++i) {
	  		pMatrixStack.pushPose();
	  		
	  		if (i == 1) pMatrixStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
	  		if (i == 2) pMatrixStack.mulPose(Vector3f.XP.rotationDegrees(-90.0F));
	  		if (i == 3) pMatrixStack.mulPose(Vector3f.XP.rotationDegrees(180.0F));
	  		if (i == 4) pMatrixStack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
	  		if (i == 5) pMatrixStack.mulPose(Vector3f.ZP.rotationDegrees(-90.0F));
	     	  		
	  		Matrix4f matrix4f = pMatrixStack.last().pose();
	     
	  		bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
	  		bufferbuilder.vertex(matrix4f, -100.0F, -100.0F, -100.0F).uv(0.0F, 0.0F).color(0, 0, 0, 255).endVertex();
	  		bufferbuilder.vertex(matrix4f, -100.0F, -100.0F,  100.0F).uv(0.0F, 0.0F).color(0, 0, 0, 255).endVertex();
	  		bufferbuilder.vertex(matrix4f,  100.0F, -100.0F,  100.0F).uv(0.0F, 0.0F).color(0, 0, 0, 255).endVertex();
	  		bufferbuilder.vertex(matrix4f,  100.0F, -100.0F, -100.0F).uv(0.0F, 0.0F).color(0, 0, 0, 255).endVertex();
	  		tessellator.end();
	     
	  		pMatrixStack.popPose();
	  	}
	}

}

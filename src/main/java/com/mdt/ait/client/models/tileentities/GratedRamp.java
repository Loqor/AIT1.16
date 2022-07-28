package com.mdt.ait.client.models.tileentities;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mdt.ait.common.tileentities.RampTile;
import com.mdt.ait.common.tileentities.TSVTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class GratedRamp extends EntityModel<Entity> {
	public final ModelRenderer ramp;
	private final ModelRenderer cube_r1;

	public GratedRamp() {
		texWidth = 256;
		texHeight = 256;

		ramp = new ModelRenderer(this);
		ramp.setPos(0.001F, 23.917F, -0.3423F);
		ramp.texOffs(49, 49).addBox(-14.001F, 0.083F, -7.4577F, 28.0F, 0.0F, 16.0F, 0.001F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		ramp.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.3491F, 0.0F, 0.0F);
		cube_r1.texOffs(0, 49).addBox(-14.0F, -13.0F, 8.0F, 0.0F, 16.0F, 48.0F, 0.001F, false);
		cube_r1.texOffs(49, 66).addBox(13.998F, -13.0F, 8.0F, 0.0F, 16.0F, 48.0F, 0.001F, false);
		cube_r1.texOffs(0, 0).addBox(-14.002F, 3.0F, 8.0F, 28.0F, 0.0F, 48.0F, 0.001F, false);
	}

	@Override
	public void setupAnim(Entity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
		this.ramp.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
	}

	public void render(RampTile tile, MatrixStack matrixStackIn, IVertexBuilder buffer, int combinedLight, int combinedOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(matrixStackIn, buffer, combinedLight, combinedOverlay, i, i1, i2, i3);
	}
}
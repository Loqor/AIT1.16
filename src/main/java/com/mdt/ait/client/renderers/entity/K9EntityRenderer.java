package com.mdt.ait.client.renderers.entity;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.entities.K9EntityModel;
import com.mdt.ait.client.models.exteriors.BasicBox;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.client.renderers.layers.K9EmissionLayer;
import com.mdt.ait.common.entities.K9Entity;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

import static com.mdt.ait.common.blocks.TardisBlock.FACING;


public class K9EntityRenderer extends MobRenderer {

    public static final ResourceLocation TEXTURE = new ResourceLocation(AIT.MOD_ID, "textures/entity/k9.png");

    public K9EntityRenderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new K9EntityModel(), 0.35f);
        this.addLayer(new K9EmissionLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Entity p_110775_1_) {
        return TEXTURE;
    }
}
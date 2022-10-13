package com.mdt.ait.client.renderers.entity;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.cosmetics.AngelWings;
import com.mdt.ait.client.models.entities.AngelEntityModel;
import com.mdt.ait.client.models.entities.CyberCavalry;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.client.renderers.layers.CyberCavalryEmissionLayer;
import com.mdt.ait.common.items.AngelWingsItem;
import com.mdt.ait.core.init.AITItems;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;


public class AngelEntityRenderer extends MobRenderer {

    public static final ResourceLocation TEXTURE_1 = new ResourceLocation(AIT.MOD_ID, "textures/entity/angels/angel_one.png");

    /*public float wingsTick;
    public float wingsBaseTick;
    public boolean flying = true;
    private AngelEntityModel angelWings;*/

    public AngelEntityRenderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new AngelEntityModel(0), 0.35f);
    }

    /*@Override
    public void render(MobEntity pEntity, float pEntityYaw, float pPartialTicks, MatrixStack pMatrixStack, IRenderTypeBuffer pBuffer, int pPackedLight) {
        Item item = pEntity.getItemBySlot(EquipmentSlotType.CHEST).getItem();
        if (item == AITItems.ANGEL_WINGS.get()) {
            if (this.flying) {
                if (this.wingsTick < 1.25f/*1.5f*//*) {
                    this.wingsTick += 0.0125f;
                } else {
                    this.wingsTick = 1.25f/*1.5f*//*;
                    this.flying = false;
                }
                if (this.wingsBaseTick < 0.25f/*1.5f*//*) {
                    this.wingsBaseTick += 0.0125f;
                } else {
                    this.wingsBaseTick = 0.25f/*1.5f*//*;
                }
            }
            if (!this.flying) {
                if (this.wingsTick > -0.5) {
                    this.wingsTick -= 0.0125f;
                } else {
                    this.wingsTick = -0.5f;
                    this.flying = true;
                }
                if (this.wingsBaseTick > -1) {
                    this.wingsBaseTick -= 0.0125f;
                } else {
                    this.wingsBaseTick = -1f;
                }
            }
        }
        pMatrixStack.pushPose();
        /*if (pEntity.isFallFlying()) {
            this.angelWings.left_tip.yRot = -this.wingsTick;
            this.angelWings.right_tip.yRot = this.wingsTick;
            this.angelWings.left_base.yRot = -this.wingsBaseTick;
            this.angelWings.right_base.yRot = this.wingsBaseTick;
        } else {
            this.angelWings.left_tip.yRot = 0;
            this.angelWings.right_tip.yRot = 0;
            this.angelWings.left_base.yRot = 0;
            this.angelWings.right_base.yRot = 0;
        }*//*
        pMatrixStack.mulPose(Vector3f.XN.rotationDegrees(180.0f));
        pMatrixStack.translate(0, -1.5, 0);
        this.model.renderToBuffer(pMatrixStack, pBuffer.getBuffer(AITRenderTypes.TardisRenderOver(TEXTURE_1)), pPackedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1,1);
        pMatrixStack.popPose();
    }*/

    @Override
    public ResourceLocation getTextureLocation(Entity p_110775_1_) {
        return TEXTURE_1;
    }
}
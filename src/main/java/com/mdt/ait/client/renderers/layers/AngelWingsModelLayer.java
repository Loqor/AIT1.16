package com.mdt.ait.client.renderers.layers;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.cosmetics.AngelWings;
import com.mdt.ait.client.models.cosmetics.MessengerBag;
import com.mdt.ait.common.items.AngelWingsItem;
import com.mdt.ait.core.init.AITItems;
import com.mdt.ait.core.init.enums.EnumRotorState;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class AngelWingsModelLayer<T extends AbstractClientPlayerEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {

    public static final ResourceLocation WHITE_WINGS_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/white_angel_wings.png");

    private static final AngelWings angelWings = new AngelWings();
    public float wingsTick;
    public float wingsBaseTick;
    public boolean flying = true;
    /*public float xWings0;
    public float xWings;
    public float yWings0;
    public float yWings;
    public float zWings0;
    public float zWings;*/

    public AngelWingsModelLayer(IEntityRenderer<T, M> renderer) {
        super(renderer);
    }

    @Override
    public void render(MatrixStack pMatrixStack, IRenderTypeBuffer pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        pMatrixStack.pushPose();
        Item item = pLivingEntity.getItemBySlot(EquipmentSlotType.CHEST).getItem();
        if (item == AITItems.ANGEL_WINGS.get()) {
            if (this.flying) {
                if (this.wingsTick < 1.25f/*1.5f*/) {
                    this.wingsTick += 0.0125f;
                } else {
                    this.wingsTick = 1.25f/*1.5f*/;
                    this.flying = false;
                }
                if (this.wingsBaseTick < 0.25f/*1.5f*/) {
                    this.wingsBaseTick += 0.0125f;
                } else {
                    this.wingsBaseTick = 0.25f/*1.5f*/;
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
            if (getParentModel() instanceof PlayerModel) {
                PlayerModel model = (PlayerModel) getParentModel();
                model.hat.visible = true;
                model.head.visible = true;
                model.body.translateAndRotate(pMatrixStack);
                model.hat.visible = false;
                model.head.visible = false;
            }
            IVertexBuilder vertexBuffer = pBuffer.getBuffer(RenderType.entityTranslucent(this.WHITE_WINGS_LOCATION));
            if (pLivingEntity.isFallFlying()) {
                this.angelWings.left_tip.yRot = -this.wingsTick;
                this.angelWings.right_tip.yRot = this.wingsTick;
                this.angelWings.left_base.yRot = -this.wingsBaseTick;
                this.angelWings.right_base.yRot = this.wingsBaseTick;
            } else {
                this.angelWings.left_tip.yRot = 0;
                this.angelWings.right_tip.yRot = 0;
                this.angelWings.left_base.yRot = 0;
                this.angelWings.right_base.yRot = 0;
            }
            this.angelWings.renderToBuffer(pMatrixStack, vertexBuffer, pPackedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1.0F);
        }
        pMatrixStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return WHITE_WINGS_LOCATION;
    }
    /*double d0 = MathHelper.lerp((double)pPartialTicks, this.xWings0, this.xWings) - MathHelper.lerp((double)pPartialTicks, pLivingEntity.xo, pLivingEntity.getX());
    double d1 = MathHelper.lerp((double)pPartialTicks, this.yWings0, this.yWings) - MathHelper.lerp((double)pPartialTicks, pLivingEntity.yo, pLivingEntity.getY());
    double d2 = MathHelper.lerp((double)pPartialTicks, this.zWings0, this.zWings) - MathHelper.lerp((double)pPartialTicks, pLivingEntity.zo, pLivingEntity.getZ());
    float f = pLivingEntity.yBodyRotO + (pLivingEntity.yBodyRot - pLivingEntity.yBodyRotO);
    double d3 = (double)MathHelper.sin(f * ((float)Math.PI / 180F));
    double d4 = (double)(-MathHelper.cos(f * ((float)Math.PI / 180F)));
    float f1 = (float)d1 * 10.0F;
    f1 = MathHelper.clamp(f1, -6.0F, 32.0F);
    float f2 = (float)(d0 * d3 + d2 * d4) * 100.0F;
    f2 = MathHelper.clamp(f2, 0.0F, 150.0F);
    float f3 = (float)(d0 * d4 - d2 * d3) * 100.0F;
    f3 = MathHelper.clamp(f3, -20.0F, 20.0F);
            if (f2 < 0.0F) {
        f2 = 0.0F;
    }

    float f4 = MathHelper.lerp(pPartialTicks, pLivingEntity.oBob, pLivingEntity.bob);
    f1 = f1 + MathHelper.sin(MathHelper.lerp(pPartialTicks, pLivingEntity.walkDistO, pLivingEntity.walkDist) * 6.0F) * 32.0F * f4;
            if (pLivingEntity.isCrouching()) {
        f1 += 25.0F;
    }

            pMatrixStack.mulPose(Vector3f.XP.rotationDegrees(6.0F + f2 / 2.0F + f1));
            pMatrixStack.mulPose(Vector3f.ZP.rotationDegrees(f3 / 2.0F));
            pMatrixStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - f3 / 2.0F));
}*/
}
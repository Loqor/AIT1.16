package com.mdt.ait.client.renderers.layers;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.cosmetics.ThreeDGlasses;
import com.mdt.ait.common.items.ThreeDGlassesArmorItem;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.UUID;

public class ThreeDGlassesModelLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {

    public static final ResourceLocation LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/3d_glasses.png");
    private static final ThreeDGlasses glasses = new ThreeDGlasses();


    public ThreeDGlassesModelLayer(IEntityRenderer<T, M> renderer) {
        super(renderer);
    }

    @Override
    public void render(MatrixStack pMatrixStack, IRenderTypeBuffer pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        pMatrixStack.pushPose();
        ItemStack glassesItem = pLivingEntity.getItemBySlot(EquipmentSlotType.HEAD);
        PlayerEntity playerEntity = (PlayerEntity) pLivingEntity.getEntity();
        if (glassesItem.getItem() instanceof ThreeDGlassesArmorItem) {
            if (getParentModel() instanceof PlayerModel) {
                PlayerModel model = (PlayerModel) getParentModel();
                model.hat.visible = true;
                model.head.visible = true;
                model.head.translateAndRotate(pMatrixStack);
                model.hat.visible = false;
                model.head.visible = false;
            }
            IVertexBuilder vertexBuffer = pBuffer.getBuffer(RenderType.entityTranslucent(this.LOCATION));
            if(playerEntity.getUUID().equals(UUID.fromString("ba21f64b-35e3-4b4f-b04c-9ceb814ad533"))) {
                pMatrixStack.translate(0, -0.0375, 0);
            }
            pMatrixStack.translate(0, 0, -0.01);
            pMatrixStack.scale(0.75f, 0.75f, 0.75f);
            this.glasses.renderToBuffer(pMatrixStack, vertexBuffer, pPackedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1.0F);
        }
        pMatrixStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return LOCATION;
    }
}
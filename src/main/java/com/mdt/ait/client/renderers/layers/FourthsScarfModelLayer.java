package com.mdt.ait.client.renderers.layers;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.cosmetics.FourthsScarf;
import com.mdt.ait.core.init.AITItems;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
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
import net.minecraft.util.ResourceLocation;

public class FourthsScarfModelLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {

    public static final ResourceLocation FOUR_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/4ths_scarf.png");

    private static final FourthsScarf scarf = new FourthsScarf();

    public FourthsScarfModelLayer(IEntityRenderer<T, M> renderer) {
        super(renderer);
    }

    @Override
    public void render(MatrixStack pMatrixStack, IRenderTypeBuffer pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        pMatrixStack.pushPose();
        Item item = pLivingEntity.getItemBySlot(EquipmentSlotType.CHEST).getItem();
        if (item == AITItems.FOURTHS_SCARF.get()) {
            if (getParentModel() instanceof PlayerModel) {
                PlayerModel model = (PlayerModel) getParentModel();
                model.hat.visible = true;
                model.head.visible = true;
                model.body.translateAndRotate(pMatrixStack);
                model.hat.visible = false;
                model.head.visible = false;
            }
            IVertexBuilder vertexBuffer = pBuffer.getBuffer(RenderType.entityTranslucent(this.FOUR_LOCATION));
            pMatrixStack.scale(1.125f, 1.125f, 1.125f);
            pMatrixStack.translate(0, -0.03125f, 0);
            this.scarf.renderToBuffer(pMatrixStack, vertexBuffer, pPackedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1.0F);
        }
        pMatrixStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return FOUR_LOCATION;
    }
}
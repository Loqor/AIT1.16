package com.mdt.ait.client.renderers.layers;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.cosmetics.CowSkull;
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
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class CowSkullModelLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {

    public static final ResourceLocation COW_SKULL_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/cow_skull.png");

    private static final CowSkull cowSkull = new CowSkull();


    public CowSkullModelLayer(IEntityRenderer<T, M> renderer) {
        super(renderer);
    }


    @Override
    public void render(MatrixStack pMatrixStack, IRenderTypeBuffer pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        Item item = pLivingEntity.getMainHandItem().getItem();
        if (item == AITItems.COW_SKULL.get()) {
            if (getParentModel() instanceof PlayerModel) {
                PlayerModel model = (PlayerModel) getParentModel();
                model.hat.visible = true;
                model.head.visible = true;
                model.head.translateAndRotate(pMatrixStack);
                model.hat.visible = false;
                model.head.visible = false;
            }
            IVertexBuilder vertexBuffer = pBuffer.getBuffer(RenderType.entityTranslucent(COW_SKULL_LOCATION));
            this.cowSkull.renderToBuffer(pMatrixStack, vertexBuffer, pPackedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1.0F);
        }
    }
}
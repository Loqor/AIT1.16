package com.mdt.ait.client.renderers.layers;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.cosmetics.Fez;
import com.mdt.ait.common.items.FezArmorItem;
import com.mdt.ait.core.init.AITItems;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.ArmorStandArmorModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.HandSide;
import net.minecraft.util.ResourceLocation;

public class FezModelLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {

    public static final ResourceLocation WHITE_FEZ_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/fezzes/fez_white.png");
    public static final ResourceLocation GRAY_FEZ_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/fezzes/fez_gray.png");
    public static final ResourceLocation BLACK_FEZ_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/fezzes/fez_black.png");
    public static final ResourceLocation RED_FEZ_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/fezzes/fez_red.png");
    public static final ResourceLocation ORANGE_FEZ_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/fezzes/fez_orange.png");
    public static final ResourceLocation YELLOW_FEZ_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/fezzes/fez_yellow.png");
    public static final ResourceLocation L_GREEN_FEZ_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/fezzes/fez_green_l.png");
    public static final ResourceLocation GREEN_FEZ_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/fezzes/fez_green.png");
    public static final ResourceLocation D_GREEN_FEZ_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/fezzes/fez_green_d.png");
    public static final ResourceLocation L_BLUE_FEZ_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/fezzes/fez_blue_l.png");
    public static final ResourceLocation BLUE_FEZ_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/fezzes/fez_blue.png");
    public static final ResourceLocation D_BLUE_FEZ_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/fezzes/fez_blue_d.png");
    public static final ResourceLocation L_PURPLE_FEZ_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/fezzes/fez_purple_l.png");
    public static final ResourceLocation PURPLE_FEZ_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/fezzes/fez_purple.png");
    public static final ResourceLocation D_PURPLE_FEZ_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/fezzes/fez_purple_d.png");
    public static final ResourceLocation PINK_FEZ_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/fezzes/fez_pink.png");
    public static final ResourceLocation BROWN_FEZ_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/fezzes/fez_brown.png");
    private static final Fez fez = new Fez();

    public ResourceLocation TEXTURE = RED_FEZ_LOCATION;
    public FezArmorItem fezArmorItem;

    public FezModelLayer(IEntityRenderer<T, M> renderer) {
        super(renderer);
    }

    @Override
    public void render(MatrixStack pMatrixStack, IRenderTypeBuffer pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        pMatrixStack.pushPose();
        ItemStack fezItem = pLivingEntity.getItemBySlot(EquipmentSlotType.HEAD);
        if (fezItem.getItem() instanceof FezArmorItem) {
            if (fezItem.getItem() == AITItems.WHITE_FEZ.get()) {
                TEXTURE = WHITE_FEZ_LOCATION;
            }
            if (fezItem.getItem() == AITItems.GRAY_FEZ.get()) {
                TEXTURE = GRAY_FEZ_LOCATION;
            }
            if (fezItem.getItem() == AITItems.BLACK_FEZ.get()) {
                TEXTURE = BLACK_FEZ_LOCATION;
            }
            if (fezItem.getItem() == AITItems.RED_FEZ.get()) {
                TEXTURE = RED_FEZ_LOCATION;
            }
            if (fezItem.getItem() == AITItems.ORANGE_FEZ.get()) {
                TEXTURE = ORANGE_FEZ_LOCATION;
            }
            if (fezItem.getItem() == AITItems.YELLOW_FEZ.get()) {
                TEXTURE = YELLOW_FEZ_LOCATION;
            }
            if (fezItem.getItem() == AITItems.L_GREEN_FEZ.get()) {
                TEXTURE = L_GREEN_FEZ_LOCATION;
            }
            if (fezItem.getItem() == AITItems.GREEN_FEZ.get()) {
                TEXTURE = GREEN_FEZ_LOCATION;
            }
            if (fezItem.getItem() == AITItems.D_GREEN_FEZ.get()) {
                TEXTURE = D_GREEN_FEZ_LOCATION;
            }
            if (fezItem.getItem() == AITItems.L_BLUE_FEZ.get()) {
                TEXTURE = L_BLUE_FEZ_LOCATION;
            }
            if (fezItem.getItem() == AITItems.BLUE_FEZ.get()) {
                TEXTURE = BLUE_FEZ_LOCATION;
            }
            if (fezItem.getItem() == AITItems.D_BLUE_FEZ.get()) {
                TEXTURE = D_BLUE_FEZ_LOCATION;
            }
            if (fezItem.getItem() == AITItems.L_PURPLE_FEZ.get()) {
                TEXTURE = L_PURPLE_FEZ_LOCATION;
            }
            if (fezItem.getItem() == AITItems.PURPLE_FEZ.get()) {
                TEXTURE = PURPLE_FEZ_LOCATION;
            }
            if (fezItem.getItem() == AITItems.D_PURPLE_FEZ.get()) {
                TEXTURE = D_PURPLE_FEZ_LOCATION;
            }
            if (fezItem.getItem() == AITItems.PINK_FEZ.get()) {
                TEXTURE = PINK_FEZ_LOCATION;
            }
            if (fezItem.getItem() == AITItems.BROWN_FEZ.get()) {
                TEXTURE = BROWN_FEZ_LOCATION;
            }
            if (getParentModel() instanceof PlayerModel) {
                PlayerModel model = (PlayerModel) getParentModel();
                model.hat.visible = true;
                model.head.visible = true;
                model.head.translateAndRotate(pMatrixStack);
                model.hat.visible = false;
                model.head.visible = false;

            }
            IVertexBuilder vertexBuffer = pBuffer.getBuffer(RenderType.entityTranslucent(this.TEXTURE));
            pMatrixStack.translate(-0.025, 0.05, 0);
            this.fez.renderToBuffer(pMatrixStack, vertexBuffer, pPackedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1.0F);
        }
        pMatrixStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return TEXTURE;
    }
}
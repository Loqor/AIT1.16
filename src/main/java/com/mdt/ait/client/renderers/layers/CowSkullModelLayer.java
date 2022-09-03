package com.mdt.ait.client.renderers.layers;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.cosmetics.CowSkull;
import com.mdt.ait.core.init.AITItems;
import com.mdt.ait.core.init.events.CommonEventHandler;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import org.antlr.v4.runtime.misc.NotNull;

import java.nio.Buffer;

public class CowSkullModelLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M>  {

    public static final ResourceLocation COW_SKULL_LOCATION = new ResourceLocation(AIT.MOD_ID, "textures/cosmetics/cow_skull.png");

    private final CowSkull cowSkull = new CowSkull(1);


    public ResourceLocation texture = COW_SKULL_LOCATION;



    public final PlayerModel<LivingEntity> playerModel = new PlayerModel<>(1, true);

    public CowSkullModelLayer(IEntityRenderer<T, M> p_i50926_1_) {
        super(p_i50926_1_);
    }


    @Override
    public void render(MatrixStack pMatrixStack, IRenderTypeBuffer pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        Item item = pLivingEntity.getMainHandItem().getItem();
        if(item == AITItems.COW_SKULL.get()) {
            this.cowSkull.prepareMobModel(pLivingEntity, pLimbSwing, pLimbSwingAmount, pPartialTicks);
            this.getParentModel().copyPropertiesTo((EntityModel<T>) cowSkull);
            IVertexBuilder vertexBuffer = pBuffer.getBuffer(RenderType.entityTranslucent(this.texture));
            this.playerModel.setupAnim(pLivingEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
            this.playerModel.renderToBuffer(pMatrixStack, vertexBuffer, pPackedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1.0F);
            this.cowSkull.render(pMatrixStack, vertexBuffer, pPackedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1.0F);
            System.out.println(item);
        }
    }
}
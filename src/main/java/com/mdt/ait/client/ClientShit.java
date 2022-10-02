package com.mdt.ait.client;

import com.mdt.ait.client.renderers.ModdedSkyBoxes;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.AITItems;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderSkybox;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.Dimension;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class ClientShit {

    public static void shit(BipedModel bipedModel, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo callbackInfo) {
        if(livingEntity.getItemBySlot(EquipmentSlotType.HEAD).getItem() == AITItems.COW_SKULL.get()){
            bipedModel.head.visible = false;
            bipedModel.hat.visible = false;
            callbackInfo.cancel();
        }
        /*Item item = livingEntity.getItemBySlot(EquipmentSlotType.HEAD).getItem();
        if(item == AITItems.COW_SKULL.get()){
            System.out.println("uhhh");
            bipedModel.head.visible = false;
            bipedModel.hat.visible = false;
            callbackInfo.cancel();
        }*/
    }
}

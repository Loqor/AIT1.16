package com.mdt.ait.client;

import com.mdt.ait.core.init.AITItems;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class ClientShit {
    public static void shit(BipedModel bipedModel, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo callbackInfo) {
        if(livingEntity.getMainHandItem().getItem() == AITItems.COW_SKULL.get()){
            System.out.println("uhhh");
        }
    }
}

package com.mdt.ait.mixin;

import com.mdt.ait.client.ClientShit;
import com.mdt.ait.core.init.AITItems;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BipedModel.class)
public class PlayerModelMixin {

    @Inject(at = @At("TAIL"), method = "setupAnim(Lnet/minecraft/entity/LivingEntity;FFFFF)V", cancellable = true)
    private void setupAnim(LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo callbackInfo) {
        BipedModel bipedModel = (BipedModel) (Object) this;

        if(livingEntity.getItemBySlot(EquipmentSlotType.HEAD).getItem() == AITItems.COW_SKULL.get()){
            ClientShit.shit(bipedModel, livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, callbackInfo);
        }
    }

}

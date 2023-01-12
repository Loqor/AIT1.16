package com.mdt.ait.client;

import com.mdt.ait.AIT;
import com.mdt.ait.core.init.AITItems;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = AIT.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientThings {

    public static void thing(BipedModel bipedModel, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo callbackInfo) {

        if(livingEntity.getItemBySlot(EquipmentSlotType.HEAD).getItem() == AITItems.COW_SKULL.get()){
            bipedModel.head.visible = false;
            bipedModel.hat.visible = false;
            callbackInfo.cancel();
        }

    }
}

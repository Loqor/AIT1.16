package com.mdt.ait.client;

import com.mdt.ait.AIT;
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

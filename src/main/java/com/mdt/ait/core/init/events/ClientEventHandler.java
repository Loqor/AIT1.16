package com.mdt.ait.core.init.events;

import com.mdt.ait.core.init.AITItems;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ClientEventHandler {

    @SubscribeEvent
    public static void onEntityRenderPre(RenderPlayerEvent.Post event) {
        LivingEntity livingEntity = event.getPlayer();
        Item item = livingEntity.getMainHandItem().getItem();
      //  if (item == AITItems.COW_SKULL.get()) {
            PlayerModel<AbstractClientPlayerEntity> model = event.getRenderer().getModel();
            model.head.visible = false;
            model.hat.visible = false;
      //  }
    }


}

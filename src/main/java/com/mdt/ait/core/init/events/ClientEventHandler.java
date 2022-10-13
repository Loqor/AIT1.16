package com.mdt.ait.core.init.events;

import com.mdt.ait.AIT;
import com.mdt.ait.core.init.AITDimensions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.minecraftforge.client.ISkyRenderHandler;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ClientEventHandler {

    private Minecraft minecraft;

    @SubscribeEvent
    public static void onEntityRenderPre(RenderPlayerEvent.Post event) {
        LivingEntity livingEntity = event.getPlayer();
        Item item = livingEntity.getItemBySlot(EquipmentSlotType.HEAD).getItem();
      //  if (item == AITItems.COW_SKULL.get()) {
            PlayerModel<AbstractClientPlayerEntity> model = event.getRenderer().getModel();
            model.head.visible = false;
            model.hat.visible = false;
      //  }
    }

    /*@SubscribeEvent
    public void renderWorld(RenderWorldLastEvent event) {
        assert Minecraft.getInstance().level != null;
        ClientWorld level = Minecraft.getInstance().level;
        RegistryKey<World> dimension = level.dimension();
        if(dimension == AITDimensions.GALLIFREY) {
            net.minecraftforge.client.ISkyRenderHandler renderHandler = new GallifreySkyRenderer();
            level.effects().setSkyRenderHandler(renderHandler);
        }
    }*/

    /*@SubscribeEvent
    public void onInput(TickEvent.ClientTickEvent event) {
        if (AIT.KEY_OPEN_BAG_GUI.consumeClick()) {
            if (InputMappings.isKeyDown(minecraft.getWindow().getWindow(), GLFW.GLFW_KEY_B)) {
            } else {
                minecraft.setScreen(new BagScreen());
            }
        }
    }*/
}

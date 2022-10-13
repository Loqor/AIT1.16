package com.mdt.ait.core.init;

import com.mdt.ait.AIT;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.awt.event.KeyEvent;

public class AITKeybinds {
    public static KeyBinding hideAngelWings;

    public static void register(final FMLClientSetupEvent event) {
        hideAngelWings = create("hide_angel_wings", KeyEvent.VK_G);

        ClientRegistry.registerKeyBinding(hideAngelWings);
    }

    private static KeyBinding create(String name, int key) {
        return new KeyBinding("key." + AIT.MOD_ID + "." + name, key, "key.category." + AIT.MOD_ID);
    }
}

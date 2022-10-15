package com.mdt.ait.core.init;

import com.mdt.ait.AIT;
import net.minecraft.inventory.container.AbstractRepairContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AITContainerTypes {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister
            .create(ForgeRegistries.CONTAINERS, AIT.MOD_ID);

    /*public static final RegistryObject<ContainerType<MonitorContainer>> MONITOR_CONTAINER_TYPE = CONTAINER_TYPES
            .register("monitor_container", () -> IForgeContainerType.create(MonitorContainer::new));*/

    /*public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, AIT.MOD_ID);

    public static final RegistryObject<ContainerType<MonitorContainer>> MONITOR_CONTAINER_TYPE =
            registerMenuType(MonitorContainer::new, "monitor_container");

    private static <T extends MonitorContainer> RegistryObject<ContainerType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                         String name) {
        return CONTAINER_TYPES.register(name, () -> IForgeContainerType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        CONTAINER_TYPES.register(eventBus);
    }*/
}

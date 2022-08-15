package com.mdt.ait.core.init;

import com.mdt.ait.AIT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AITSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AIT.MOD_ID);

    public static final RegistryObject<SoundEvent> SONIC_SOUND = SOUNDS.register("sonic_sound", () -> new SoundEvent(
            new ResourceLocation(AIT.MOD_ID,"sonic_sound")));
    public static final RegistryObject<SoundEvent> SONIC_ACTIVE = SOUNDS.register("sonic_active", () -> new SoundEvent(
            new ResourceLocation(AIT.MOD_ID, "sonic_active")));
    public static final RegistryObject<SoundEvent> POLICE_BOX_OPEN = SOUNDS.register("police_box_open", () -> new SoundEvent(
            new ResourceLocation(AIT.MOD_ID,"police_box_open")));
    public static final RegistryObject<SoundEvent> POLICE_BOX_CLOSE = SOUNDS.register("police_box_close", () -> new SoundEvent(
            new ResourceLocation(AIT.MOD_ID,"police_box_close")));
    public static final RegistryObject<SoundEvent> TARDIS_FIRST_ENTER = SOUNDS.register("tardis_first_enter", () -> new SoundEvent(
            new ResourceLocation(AIT.MOD_ID, "tardis_first_enter")));
    public static final RegistryObject<SoundEvent> TYPEWRITER_DING = SOUNDS.register("typewriter_ding", () -> new SoundEvent(
            new ResourceLocation(AIT.MOD_ID, "typewriter_ding")));
    public static final RegistryObject<SoundEvent> TARDIS_TAKEOFF = SOUNDS.register("tardis_takeoff", () -> new SoundEvent(
            new ResourceLocation(AIT.MOD_ID, "tardis_takeoff")));
    public static final RegistryObject<SoundEvent> TARDIS_LOCK = SOUNDS.register("tardis_lock", () -> new SoundEvent(
            new ResourceLocation(AIT.MOD_ID, "tardis_lock")));
}

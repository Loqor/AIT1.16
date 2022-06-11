package com.mdt.ait.network.packets;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Consumer;

public class DimensionSyncPacket implements Consumer<NetworkEvent.Context>  {
    public static final DimensionSyncPacket INVALID = new DimensionSyncPacket(null);
    private RegistryKey<World> id;

    public static final Codec<DimensionSyncPacket> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            World.RESOURCE_KEY_CODEC.optionalFieldOf("id", null).forGetter(DimensionSyncPacket::getId)
    ).apply(instance, DimensionSyncPacket::new));

    public DimensionSyncPacket(RegistryKey<World> id) {
        this.id = id;
    }

    @Override
    public void accept(NetworkEvent.Context context) {
        context.enqueueWork(() -> {
            ClientPlayerEntity player = Minecraft.getInstance().player;
            if(player != null)
                if(this.getId() != null) {
                    if(player.connection != null)
                        player.connection.levels().add(this.getId());
                }
        });
    }

    public RegistryKey<World> getId() {
        return this.id;
    }
}

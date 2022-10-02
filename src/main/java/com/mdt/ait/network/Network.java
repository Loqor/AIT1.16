package com.mdt.ait.network;

import com.mdt.ait.AIT;
import com.mdt.ait.network.packets.DimensionSyncPacket;
import com.mdt.ait.network.packets.MonitorExteriorChangePacket;
import com.mojang.serialization.Codec;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTDynamicOps;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Network {
    private static int ID = 0;
    private static final String PROTOCOL_VERSION = Integer.toString(1);
    private static final SimpleChannel NETWORK_CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(AIT.MOD_ID, "main_channel"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

    public static void init() {
        registerCodecPacket(++ID, NETWORK_CHANNEL, DimensionSyncPacket.CODEC, DimensionSyncPacket.INVALID);
    }

    public static <PACKET extends Consumer<NetworkEvent.Context>> void registerCodecPacket(int id, SimpleChannel channel, Codec<PACKET> codec, PACKET defaultPacket){

        final BiConsumer<PACKET, PacketBuffer> encoder = (packet, buffer) -> codec.encodeStart(NBTDynamicOps.INSTANCE, packet)
                .result()
                .ifPresent(nbt -> buffer.writeNbt((CompoundNBT)nbt));
        final Function<PacketBuffer,PACKET> decoder = buffer -> codec.parse(NBTDynamicOps.INSTANCE, buffer.readNbt())
                .result()
                .orElse(defaultPacket);
        final BiConsumer<PACKET, Supplier<NetworkEvent.Context>> handler = (packet, context) -> {
            packet.accept(context.get());
            context.get().setPacketHandled(true);
        };

        final Class<PACKET> packetClass = (Class<PACKET>) (defaultPacket.getClass());

        channel.registerMessage(id, packetClass, encoder, decoder, handler);
        //NETWORK_CHANNEL.registerMessage(id, MonitorExteriorChangePacket.class, MonitorExteriorChangePacket::encode, MonitorExteriorChangePacket::decode, MonitorExteriorChangePacket::handle);
    }

    public static void sendTo(Object msg, ServerPlayerEntity player) {
        if (!(player instanceof FakePlayer)) {
            NETWORK_CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), msg);
        }
    }

    public static void sendToServer(Object msg) {
        NETWORK_CHANNEL.sendToServer(msg);
    }

    public static void sendPacketToAll(Object packet) {
        NETWORK_CHANNEL.send(PacketDistributor.ALL.noArg(), packet);
    }
}

package com.mdt.ait.network.packets;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public interface IPacket {

    void encode(PacketBuffer buffer) ;

    boolean handle(Supplier<NetworkEvent.Context> ctx);
}

package com.mdt.ait.network.packets.delorean;

import com.mdt.ait.network.packets.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.io.IOException;
import java.util.function.Supplier;

public class CDeloreanSteerPacket implements IPacket {
    private boolean forward;
    private boolean backward;

    public CDeloreanSteerPacket(PacketBuffer pBuffer) {}

    public CDeloreanSteerPacket(boolean pForward, boolean pBackward) {
        this.forward = pForward;
        this.backward = pBackward;
    }

    @Override
    public void encode(PacketBuffer buffer) {
        buffer.writeBoolean(this.forward);
        buffer.writeBoolean(this.backward);
    }

    public void decode(PacketBuffer buffer) throws IOException {
        this.forward = buffer.readBoolean();
        this.backward = buffer.readBoolean();
    }

    @Override
    public boolean handle(Supplier<NetworkEvent.Context> ctx) {
        return true;
    }
}

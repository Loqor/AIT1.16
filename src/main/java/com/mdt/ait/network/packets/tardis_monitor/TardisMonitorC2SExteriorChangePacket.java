package com.mdt.ait.network.packets.tardis_monitor;

import com.mdt.ait.AIT;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.network.packets.IPacket;
import com.mdt.ait.tardis.Tardis;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

public class TardisMonitorC2SExteriorChangePacket implements IPacket {

    public EnumExteriorType exteriorType;

    public UUID tardisID;

    public TardisMonitorC2SExteriorChangePacket(EnumExteriorType exteriorType, UUID tardisID) {
        this.exteriorType = exteriorType;
        this.tardisID = tardisID;

    }

    public TardisMonitorC2SExteriorChangePacket(PacketBuffer buffer) {
        this(buffer.readEnum(EnumExteriorType.class), buffer.readUUID());
    }

    @Override
    public void encode(PacketBuffer buffer) {
        buffer.writeEnum(exteriorType);
        buffer.writeUUID(tardisID);
    }

    @Override
    public boolean handle(Supplier<NetworkEvent.Context> ctx) {
        final AtomicBoolean success = new AtomicBoolean(false);
        ctx.get().enqueueWork(() -> {
            Tardis tardis = AIT.tardisManager.getTardis(tardisID);
            tardis.setExteriorType(exteriorType);
            success.set(true);
        });

        ctx.get().setPacketHandled(true);
        return success.get();
    }


}

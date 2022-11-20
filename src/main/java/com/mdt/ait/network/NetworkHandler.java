package com.mdt.ait.network;

import com.mdt.ait.AIT;
import com.mdt.ait.network.packets.delorean.CDeloreanSteerPacket;
import com.mdt.ait.network.packets.tardis_monitor.TardisMonitorC2SExteriorChangePacket;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetworkHandler {

    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(AIT.MOD_ID, "network"), () -> PROTOCOL_VERSION,
            version -> version.equals(PROTOCOL_VERSION), version -> version.equals(PROTOCOL_VERSION));

    public static void init() {
        int index = 0;
        // PLAY_TO_SERVER is C2S/C and PLAY_TO_CLIENT is S2C/S
        CHANNEL.messageBuilder(TardisMonitorC2SExteriorChangePacket.class, index++, NetworkDirection.PLAY_TO_SERVER).encoder(TardisMonitorC2SExteriorChangePacket::encode).decoder(TardisMonitorC2SExteriorChangePacket::new).consumer(TardisMonitorC2SExteriorChangePacket::handle).add();
        //CHANNEL.messageBuilder(CDeloreanSteerPacket.class, index++, NetworkDirection.PLAY_TO_SERVER).encoder(CDeloreanSteerPacket::encode).decoder(CDeloreanSteerPacket::new).consumer(CDeloreanSteerPacket::handle).add();
        //CHANNEL.registerMessage(0, InputMessageC2S.class, InputMessageC2S::encode, InputMessageC2S::decode, InputMessageC2S::handle);
        //CHANNEL.registerMessage(0, InputMessageS2C.class, InputMessageS2C::encode, InputMessageS2C::decode, InputMessageS2C::handle);
        //CHANNEL.registerMessage(0, OpenMonitorScreen.class, InputMessage::encode, InputMessage::decode, InputMessage::handle);

    }
}

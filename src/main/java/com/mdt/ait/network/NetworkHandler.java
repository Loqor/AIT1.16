package com.mdt.ait.network;

import com.mdt.ait.AIT;
import com.mdt.ait.network.packets.IPacket;
import com.mdt.ait.network.packets.keybinds.InputMessage;
import com.mdt.ait.network.packets.tardis_monitor.TardisMonitorC2SExteriorChangePacket;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.HashMap;

public class NetworkHandler {

    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(AIT.MOD_ID, "network"), () -> PROTOCOL_VERSION,
            version -> version.equals(PROTOCOL_VERSION), version -> version.equals(PROTOCOL_VERSION));

    public static void init() {
        int index = 0;
        // PLAY_TO_SERVER is C2S and PLAY_TO_CLIENT is S2C

        CHANNEL.messageBuilder(TardisMonitorC2SExteriorChangePacket.class, index++, NetworkDirection.PLAY_TO_SERVER).encoder(TardisMonitorC2SExteriorChangePacket::encode).decoder(TardisMonitorC2SExteriorChangePacket::new).consumer((TardisMonitorC2SExteriorChangePacket::handle)).add();
        CHANNEL.registerMessage(0, InputMessage.class, InputMessage::encode, InputMessage::decode, InputMessage::handle);

    }
}

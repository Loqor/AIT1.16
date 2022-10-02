package com.mdt.ait.network.packets;

import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.common.tileentities.TypewriterTile;
import net.minecraft.block.Block;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class MonitorExteriorChangePacket {

    private int list = 0;

    public MonitorExteriorChangePacket(int list) {
        this.list = list;
    }

    public static void encode(MonitorExteriorChangePacket msg, PacketBuffer packet) {
        packet.writeInt(msg.list);
    }

    public static <MSG> void handle(MSG msg, Supplier<NetworkEvent.Context> contextSupplier) {
        contextSupplier.get().enqueueWork(() -> {

        });
    }

    //public static <MSG> MSG decode(PacketBuffer packetBuffer) {
    //    packetBuffer;
    //}
}

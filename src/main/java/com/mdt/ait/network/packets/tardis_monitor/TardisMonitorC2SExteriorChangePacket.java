package com.mdt.ait.network.packets.tardis_monitor;

import com.mdt.ait.AIT;
import com.mdt.ait.client.screen.MonitorScreen;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.network.packets.IPacket;
import com.mdt.ait.tardis.Tardis;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

public class TardisMonitorC2SExteriorChangePacket implements IPacket {

    public UUID tardisID;
    public Boolean WHICHSIDE;
    private static final ResourceLocation BASIC_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/basic_exterior_screen.png");

    public TardisMonitorC2SExteriorChangePacket(UUID tardisID, boolean rightleft) {
        this.tardisID = tardisID;
        this.WHICHSIDE = rightleft;
    }

    public TardisMonitorC2SExteriorChangePacket(PacketBuffer buffer) {
        this(buffer.readUUID(), buffer.readBoolean());
    }

    @Override
    public void encode(PacketBuffer buffer) {
        if(tardisID != null) {
            buffer.writeUUID(tardisID);
        }
        buffer.writeBoolean(WHICHSIDE);
    }

    @Override
    public boolean handle(Supplier<NetworkEvent.Context> ctx) {
        final AtomicBoolean success = new AtomicBoolean(false);
        ctx.get().enqueueWork(() -> {
            Tardis tardis = AIT.tardisManager.getTardis(tardisID);
            ServerWorld exteriorWorld = AIT.server.getLevel(tardis.exterior_dimension);
            assert exteriorWorld != null;
            TardisTileEntity tardisTileEntity = (TardisTileEntity) exteriorWorld.getBlockEntity(tardis.exterior_position);
            assert tardisTileEntity != null;
            if(this.WHICHSIDE) {
                tardis.setExteriorType(tardisTileEntity.getNextExterior());
            } else {
                tardis.setExteriorType(tardisTileEntity.getLastExterior());
            }
            tardisTileEntity.syncToClient();
            success.set(true);
        });

        ctx.get().setPacketHandled(true);
        return success.get();
    }


}

package com.mdt.ait.network.packets.tardis_monitor;

import com.mdt.ait.AIT;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.network.packets.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
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
            /*Tardis tardis = AIT.tardisManager.getTardis(tardisID);
            ServerWorld exteriorWorld = AIT.server.getLevel(tardis.exterior_dimension);
            ServerWorld interiorWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
            assert exteriorWorld != null;
            assert interiorWorld != null;
            TardisTileEntity tardisTileEntity = (TardisTileEntity) exteriorWorld.getBlockEntity(tardis.exteriorPosition);
            BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) interiorWorld.getBlockEntity(tardis.interiorDoorPosition);
            assert tardisTileEntity != null;
            if(this.WHICHSIDE) {
                interiorWorld.playSound(null, tardis.interiorDoorPosition, AITSounds.TYPEWRITER_DING.get(), SoundCategory.MASTER, 4f, 1f);
                exteriorWorld.playSound(null, tardis.exteriorPosition, AITSounds.TYPEWRITER_DING.get(), SoundCategory.MASTER, 4f, 1f);
                tardis.setExteriorType(tardisTileEntity.getNextExterior());
            } else {
                interiorWorld.playSound(null, tardis.interiorDoorPosition, AITSounds.TYPEWRITER_DING.get(), SoundCategory.MASTER, 4f, 1f);
                exteriorWorld.playSound(null, tardis.exteriorPosition, AITSounds.TYPEWRITER_DING.get(), SoundCategory.MASTER, 4f, 1f);
                tardis.setExteriorType(tardisTileEntity.getLastExterior());
            }
            tardisTileEntity.syncToClient();
            if(basicInteriorDoorTile != null) {
                basicInteriorDoorTile.syncToClient();
            }
            success.set(true);*/
        });

        ctx.get().setPacketHandled(true);
        return success.get();
    }


}

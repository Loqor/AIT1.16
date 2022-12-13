package com.mdt.ait.network.packets.tardis_monitor;

import com.mdt.ait.AIT;
import com.mdt.ait.client.screen.MonitorScreen;
import com.mdt.ait.common.tileentities.BasicInteriorDoorTile;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.enums.EnumInteriorDoorType;
import com.mdt.ait.network.packets.IPacket;
import com.mdt.ait.tardis.Tardis;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
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
            ServerWorld interiorWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
            assert exteriorWorld != null;
            assert interiorWorld != null;
            TardisTileEntity tardisTileEntity = (TardisTileEntity) exteriorWorld.getBlockEntity(tardis.exterior_position);
            BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) interiorWorld.getBlockEntity(tardis.interior_door_position);
            assert tardisTileEntity != null;
            if(this.WHICHSIDE) {
                if(basicInteriorDoorTile != null) {
                    if (basicInteriorDoorTile.currentState() == EnumDoorState.CLOSED || basicInteriorDoorTile.currentState() == EnumDoorState.LOCKED) {
                        interiorWorld.playSound(null, tardis.interior_door_position, AITSounds.TYPEWRITER_DING.get(), SoundCategory.MASTER, 4f, 1f);
                        exteriorWorld.playSound(null, tardis.exterior_position, AITSounds.TYPEWRITER_DING.get(), SoundCategory.MASTER, 4f, 1f);
                        tardis.setExteriorType(tardisTileEntity.getNextExterior());
                        if (tardisTileEntity.currentExterior().getSerializedName().equals("hudolin_exterior")) {
                            tardis.setInteriorDoorType(basicInteriorDoorTile.currentinteriordoor = EnumInteriorDoorType.DOOR_HUDOLIN_EXTERIOR);
                        }
                        if (tardisTileEntity.currentExterior().getSerializedName().equals("classic_exterior")) {
                            tardis.setInteriorDoorType(basicInteriorDoorTile.currentinteriordoor = EnumInteriorDoorType.DOOR_CLASSIC_EXTERIOR);
                        }
                        if (tardisTileEntity.currentExterior().getSerializedName().equals("fallout_shelter_exterior")) {
                            tardis.setInteriorDoorType(basicInteriorDoorTile.currentinteriordoor = EnumInteriorDoorType.DOOR_FALLOUT_SHELTER_EXTERIOR);
                        }
                        if (tardisTileEntity.currentExterior().getSerializedName().equals("tardim_exterior")) {
                            tardis.setInteriorDoorType(basicInteriorDoorTile.currentinteriordoor = EnumInteriorDoorType.DOOR_TARDIM_EXTERIOR);
                        }
                        if (!tardisTileEntity.currentExterior().getSerializedName().equals("hudolin_exterior")
                                && !tardisTileEntity.currentExterior().getSerializedName().equals("classic_exterior")
                                && !tardisTileEntity.currentExterior().getSerializedName().equals("fallout_shelter_exterior")
                                && !tardisTileEntity.currentExterior().getSerializedName().equals("tardim_exterior")) {
                            tardis.setInteriorDoorType(basicInteriorDoorTile.currentinteriordoor = EnumInteriorDoorType.DOOR_BASIC_BOX);
                        }
                    } else {
                        interiorWorld.playSound(null, tardis.interior_door_position, AITSounds.TYPEWRITER_DING.get(), SoundCategory.MASTER, 4f, 0.25f);
                        exteriorWorld.playSound(null, tardis.exterior_position, AITSounds.TYPEWRITER_DING.get(), SoundCategory.MASTER, 4f, 0.25f);
                    }
                }
            } else {
                if(basicInteriorDoorTile != null) {
                    if (basicInteriorDoorTile.currentState() == EnumDoorState.CLOSED || basicInteriorDoorTile.currentState() == EnumDoorState.LOCKED) {
                        interiorWorld.playSound(null, tardis.interior_door_position, AITSounds.TYPEWRITER_DING.get(), SoundCategory.MASTER, 4f, 1f);
                        exteriorWorld.playSound(null, tardis.exterior_position, AITSounds.TYPEWRITER_DING.get(), SoundCategory.MASTER, 4f, 1f);
                        tardis.setExteriorType(tardisTileEntity.getLastExterior());
                        if (tardisTileEntity.currentExterior().getSerializedName().equals("hudolin_exterior")) {
                            tardis.setInteriorDoorType(basicInteriorDoorTile.currentinteriordoor = EnumInteriorDoorType.DOOR_HUDOLIN_EXTERIOR);
                        }
                        if (tardisTileEntity.currentExterior().getSerializedName().equals("classic_exterior")) {
                            tardis.setInteriorDoorType(basicInteriorDoorTile.currentinteriordoor = EnumInteriorDoorType.DOOR_CLASSIC_EXTERIOR);
                        }
                        if (!tardisTileEntity.currentExterior().getSerializedName().equals("hudolin_exterior") && !tardisTileEntity.currentExterior().getSerializedName().equals("classic_exterior")) {
                            tardis.setInteriorDoorType(basicInteriorDoorTile.currentinteriordoor = EnumInteriorDoorType.DOOR_BASIC_BOX);
                        }
                    } else {
                        interiorWorld.playSound(null, tardis.interior_door_position, AITSounds.TYPEWRITER_DING.get(), SoundCategory.MASTER, 4f, 0.25f);
                        exteriorWorld.playSound(null, tardis.exterior_position, AITSounds.TYPEWRITER_DING.get(), SoundCategory.MASTER, 4f, 0.25f);
                    }
                }
            }
            tardisTileEntity.syncToClient();
            if(basicInteriorDoorTile != null) {
                basicInteriorDoorTile.syncToClient();
            }
            success.set(true);
        });

        ctx.get().setPacketHandled(true);
        return success.get();
    }


}

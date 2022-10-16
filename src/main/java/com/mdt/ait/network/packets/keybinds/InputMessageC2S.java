/*package com.mdt.ait.network.packets.keybinds;

import java.util.function.Supplier;

import com.mdt.ait.AIT;
import com.mdt.ait.common.items.AngelWingsItem;
import com.mdt.ait.core.init.AITItems;
import com.mdt.ait.network.NetworkHandler;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.PacketBuffer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.PacketDistributor;

public class InputMessageC2S {

    public int key;

    public InputMessageC2S() {
    }

    public InputMessageC2S(int key) {
        this.key = key;
    }

    public static void encode(InputMessageC2S message, PacketBuffer buffer) {
        buffer.writeInt(message.key);
    }

    public static InputMessageC2S decode(PacketBuffer buffer) {
        return new InputMessageC2S(buffer.readInt());
    }

    public static void handle(InputMessageC2S message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayerEntity player = context.getSender();
            assert player != null;
            PlayerList playerList = AIT.server.getPlayerList();
            for(ServerPlayerEntity playerFromList : playerList.getPlayers()) {
                if(playerFromList.getLevel().equals(player.getLevel())) {
                    if(player.distanceTo(playerFromList) <= 300) {
                        //NetworkHandler.CHANNEL.sendTo(message, playerFromList.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
                        NetworkHandler.CHANNEL.send(PacketDistributor.TRACKING_CHUNK.with(() -> (Chunk) player.getLevel().getChunk(player.blockPosition())), message);
                    }
                }
            }
        });
        context.setPacketHandled(true);
    }
}*/
/*package com.mdt.ait.network.packets.keybinds;

import com.mdt.ait.common.items.AngelWingsItem;
import com.mdt.ait.core.init.AITItems;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class InputMessageS2C {
    public int key;

    public InputMessageS2C() {
    }

    public InputMessageS2C(int key) {
        this.key = key;
    }

    public static void encode(InputMessageS2C message, PacketBuffer buffer) {
        buffer.writeInt(message.key);
    }

    public static InputMessageS2C decode(PacketBuffer buffer) {
        return new InputMessageS2C(buffer.readInt());
    }

    public static void handle(InputMessageS2C message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayerEntity player = context.getSender();
            assert player != null;
            Item item = player.getItemBySlot(EquipmentSlotType.CHEST).getItem();
            if (item == AITItems.ANGEL_WINGS.get()) {
                if(AngelWingsItem.isThisTrue) {
                    player.displayClientMessage(new TranslationTextComponent
                            ("Wings hidden").setStyle(Style.EMPTY.withColor(TextFormatting.WHITE).withItalic(true)), true);
                    AngelWingsItem.isThisTrue = false;
                } else {
                    player.displayClientMessage(new TranslationTextComponent
                            ("Wings showing").setStyle(Style.EMPTY.withColor(TextFormatting.WHITE).withItalic(true)), true);
                    AngelWingsItem.isThisTrue = true;
                }
            } else {
                AngelWingsItem.isThisTrue = true;
            }
        });
        context.setPacketHandled(true);
    }
}*/

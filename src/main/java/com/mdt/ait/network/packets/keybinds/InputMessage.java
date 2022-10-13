package com.mdt.ait.network.packets.keybinds;

import java.util.function.Supplier;

import com.mdt.ait.client.models.cosmetics.AngelWings;
import com.mdt.ait.common.items.AngelWingsItem;
import com.mdt.ait.core.init.AITItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

public class InputMessage {

    public int key;

    public InputMessage() {
    }

    public InputMessage(int key) {
        this.key = key;
    }

    public static void encode(InputMessage message, PacketBuffer buffer) {
        buffer.writeInt(message.key);
    }

    public static InputMessage decode(PacketBuffer buffer) {
        return new InputMessage(buffer.readInt());
    }

    public static void handle(InputMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
}
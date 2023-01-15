package com.mdt.ait.common.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ArsEggItem extends Item {

    public ArsEggItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable World pWorldIn, List<ITextComponent> pTooltip, ITooltipFlag pFlagIn) {
        super.appendHoverText(pStack, pWorldIn, pTooltip, pFlagIn);
        CompoundNBT nbt = pStack.getOrCreateTag();
        nbt.putString("formatForEgg", "Random bullshit GO!!");
            pTooltip.add(new TranslationTextComponent("Loaded Format: " + nbt.getString("formatForEgg"))
                    .setStyle(Style.EMPTY.withItalic(true).withColor(TextFormatting.AQUA)));
    }
}

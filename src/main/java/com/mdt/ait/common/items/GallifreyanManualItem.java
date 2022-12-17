package com.mdt.ait.common.items;

import com.mdt.ait.client.screen.GallifreyanManualBookScreen;
import com.mdt.ait.client.screen.MonitorScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.ReadBookScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WritableBookItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class GallifreyanManualItem extends WritableBookItem {

    public GallifreyanManualItem(Properties pProperties) {
        super(pProperties);
    }

    /*@Override
    public ActionResult<ItemStack> use(World pLevel, PlayerEntity pPlayer, Hand pHand) {
        ItemStack itemstack = pPlayer.getMainHandItem();
        Minecraft.getInstance().setScreen(new GallifreyanManualBookScreen(new ReadBookScreen.WrittenBookInfo(itemstack)));
        return super.use(pLevel, pPlayer, pHand);
    }*/
}

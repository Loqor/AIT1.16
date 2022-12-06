package com.mdt.ait.common.items;

import com.mdt.ait.common.AITArmorMaterials;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class FourthsScarfArmorItem extends ArmorItem {

    public FourthsScarfArmorItem(AITArmorMaterials scarf, EquipmentSlotType head, Properties tab) {
        super(scarf, head, tab);
    }

    @Override
    public EquipmentSlotType getSlot() {
        return EquipmentSlotType.CHEST;
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return null;
    }

    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return null;
    }


}

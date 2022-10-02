package com.mdt.ait.common.items;

import com.mdt.ait.common.AITArmorMaterials;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class FezArmorItem extends ArmorItem {

    public FezArmorItem(AITArmorMaterials fez, EquipmentSlotType head, Properties tab) {
        super(fez, head, tab);
    }

    @Override
    public EquipmentSlotType getSlot() {
        return EquipmentSlotType.HEAD;
    }

    @Override
    public void inventoryTick(ItemStack pStack, World pLevel, Entity pEntity, int pItemSlot, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pItemSlot, pIsSelected);
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

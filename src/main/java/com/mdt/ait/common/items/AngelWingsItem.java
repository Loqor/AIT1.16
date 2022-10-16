package com.mdt.ait.common.items;

import com.mdt.ait.common.AITArmorMaterials;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class AngelWingsItem extends ArmorItem {

    public AngelWingsItem(AITArmorMaterials wings, EquipmentSlotType chest, Properties tab) {
        super(wings, chest, tab);
    }

    //public static boolean isThisTrue = true;
    // @TODO ADD UPWARDS VELOCITY WHEN PRESSING SPACE, ALSO EVENTUALLY ADD THE AETHER DIMENSION AND TEMPLES FOR ANGELS TO SPAWN IN TO GET THESE WINGS
    // @TODO MAKE THE TARDIS GENERATE GREEKCHARACTERS FOR THE TARDISID
    @Override
    public EquipmentSlotType getSlot() {
        return EquipmentSlotType.CHEST;
    }

    //public boolean getAreWingsVisible(ItemStack stack) {
    //    CompoundNBT nbt = stack.getOrCreateTag();
    //    if(nbt.contains("areWingsVisible")) {
    //        return stack.getTag().getBoolean("areWingsVisible");
    //    }
    //    return false;
    //}


    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.getItem() == Items.FEATHER;
    }

    public static boolean isFlyEnabled(ItemStack pElytraStack) {
        return pElytraStack.getDamageValue() < pElytraStack.getMaxDamage() - 1;
    }

    @Override
    public boolean canElytraFly(ItemStack stack, net.minecraft.entity.LivingEntity entity) {
        //CompoundNBT tag = stack.getOrCreateTag();
        //tag.putBoolean("areWingsVisible", this.isVisible());
        return AngelWingsItem.isFlyEnabled(stack);
    }

    @Override
    public ActionResult<ItemStack> use(World pLevel, PlayerEntity pPlayer, Hand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        EquipmentSlotType equipmentslottype = MobEntity.getEquipmentSlotForItem(itemstack);
        ItemStack itemstack1 = pPlayer.getItemBySlot(equipmentslottype);
        if (itemstack1.isEmpty()) {
            pPlayer.setItemSlot(equipmentslottype, itemstack.copy());
            itemstack.setCount(0);
            return ActionResult.sidedSuccess(itemstack, pLevel.isClientSide());
        } else {
            return ActionResult.fail(itemstack);
        }
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, net.minecraft.entity.LivingEntity entity, int flightTicks) {
        if (!entity.level.isClientSide && (flightTicks + 1) % 20 == 0) {
            stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(net.minecraft.inventory.EquipmentSlotType.CHEST));
        }
        return true;
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

    //public boolean isVisible() {
    //    return isThisTrue;
    //}
}

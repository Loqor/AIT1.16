package com.mdt.ait.common.items;

import com.mdt.ait.AIT;
import com.mdt.ait.core.init.AITSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CyberShockItem extends SwordItem {


    public CyberShockItem(IItemTier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        World world = pTarget.getEntity().level;
        BlockPos bPos = new BlockPos(pAttacker.getX(), pAttacker.getY(), pAttacker.getZ());
        world.playSound(null, bPos, AITSounds.CYBER_SHOCK_SOUND.get(), SoundCategory.HOSTILE, 7, 1);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}

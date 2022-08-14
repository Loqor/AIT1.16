/*package com.mdt.ait.common.controls;


import com.mdt.ait.common.entities.ControlInteractionEntity;
import com.mdt.ait.common.tileentities.ConsoleTileEntity;
import com.mdt.ait.core.init.enums.EnumConsoleInteractionEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.entity.PartEntity;

import javax.annotation.Nullable;
import java.util.UUID;

public abstract class AbstractConsoleInteractionControl implements INBTSerializable<CompoundNBT> {

    EnumConsoleInteractionEntityType control_type;
    public UUID control_id;

    public AbstractConsoleInteractionControl() {
        super();
    }

    public EntitySize getSize() {
        return EntitySize.scalable(1, 1);
    }

    public boolean onRightClicked(PlayerEntity player, ConsoleTileEntity console) {
        return true;
    }

    public boolean onHit(ConsoleTileEntity console, PlayerEntity player) {
        return this.onRightClicked(player, console);
    }

    public abstract ConsoleTileEntity getConsole();

    public abstract Vector3d getPos();

    public abstract void setConsole(ConsoleTileEntity console, ControlInteractionEntity entity);

    public abstract void onPacketUpdate();

    public abstract ControlInteractionEntity getEntity();

    @Nullable
    public PartEntity<?>[] getParts() {
        return new PartEntity[0];
    }
}*/

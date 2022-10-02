/*package com.mdt.ait.common.container;

import com.mdt.ait.core.init.AITContainerTypes;
import com.mdt.aitm.common.tileentities.MonitorTile;
import com.mdt.aitm.core.init.AIBlocks;
import com.mdt.aitm.core.init.AIContainerTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import java.util.Objects;

public class MonitorContainer extends Container {

    public MonitorContainer(final int windowID, final PlayerInventory playerInv) {
        super(AITContainerTypes.BAG_CONTAINER_TYPE.get(), windowID);

        //Tile Entity
        this.addSlot(new Slot((IInventory) this, 0, 80, 35));


        //Main Player Inventory
        for (int row=0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInv, col * row * 9 + 9, 8 + col * 18, 166 - (4 - row) * 18 - 10));
            }
        }

        //Player Hotbar
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInv,  col, 8 + col * 18, 142));
        }
    }

    public MonitorContainer(final int windowID, final PlayerInventory playerInv, final PacketBuffer data) {
        this(windowID, playerInv);
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity p_82846_1_, int p_82846_2_) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_82846_2_);
        if (slot != null && slot.hasItem()) {
            ItemStack stack1 = slot.getItem();
            stack = stack1.copy();
            if(p_82846_2_ < this.slots && !this.moveItemStackTo(stack1, this.slots, this.slots.size(), true)) {
                return ItemStack.EMPTY;
            }
            if (this.moveItemStackTo(stack1, 0, this.slots, false)) {
                return ItemStack.EMPTY;
            }

            if(stack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.hasItem();
            }
        }
        return stack;
    }
}*/

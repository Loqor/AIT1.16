package com.mdt.ait.common.container;

import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.common.tileentities.TypewriterTile;
import com.mdt.ait.core.init.AITBlocks;
import com.mdt.ait.core.init.AITContainerTypes;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import java.util.Objects;

public class MonitorContainer extends Container {
    public TypewriterTile tile_entity;
    private final IWorldPosCallable canInteractWithCallable;

    public MonitorContainer(final int windowID, final PlayerInventory playerInv, final TypewriterTile te) {
        super(AITContainerTypes.MONITOR_CONTAINER_TYPE.get(), windowID);

        this.tile_entity = te;
        this.canInteractWithCallable = IWorldPosCallable.create(te.getLevel(), te.getBlockPos());

        //Tile Entity
        /*this.addSlot(new Slot(te, 0, 80, 35));

        //Main Player Inventory
        for(int i1 = 0; i1 < 3; ++i1) {
            for(int k1 = 0; k1 < 9; ++k1) {
                //this.addSlot(new Slot(playerInv, k1 + i1 * 9 + 9, 8 + k1 * 18, 84 + i1 * 18));
                this.addSlot(new Slot(playerInv, k1 + i1 * 9 + 9, 8 + k1 * 18, 84 + i1 * 18));
            }
        }

        for(int j1 = 0; j1 < 9; ++j1) {
            this.addSlot(new Slot(playerInv, j1, 8 + j1 * 18, 142));
        }*/
    }

    public MonitorContainer(final int windowID, final PlayerInventory playerInv, final PacketBuffer data) {
        this(windowID, playerInv, getTileEntity(playerInv, data));
    }

    private static TypewriterTile getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
        Objects.requireNonNull(playerInv, "Player inventory cannot be null");
        Objects.requireNonNull(data, "Packet Buffer cannot be null");
        final TileEntity te = playerInv.player.level.getBlockEntity(data.readBlockPos());
        if (te instanceof TypewriterTile) {
            return (TypewriterTile) te;
        }
        throw new IllegalStateException("Tile entity is not correct!");
    }

    @Override
    public boolean stillValid(PlayerEntity playerIn) {
        return stillValid(canInteractWithCallable, playerIn, AITBlocks.TYPEWRITER_BLOCK.get());
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity p_82846_1_, int p_82846_2_) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_82846_2_);
        if (slot != null && slot.hasItem()) {
            ItemStack stack1 = slot.getItem();
            stack = stack1.copy();
            if(p_82846_2_ < TypewriterTile.slots && !this.moveItemStackTo(stack1, TypewriterTile.slots, this.slots.size(), true)) {
                return ItemStack.EMPTY;
            }
            if (this.moveItemStackTo(stack1, 0, TypewriterTile.slots, false)) {
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

    public void doLeftButtonFunction() {
        tile_entity.setLastExterior();
    }

    public void doRightButtonFunction() {
        tile_entity.setNextExterior();
    }
}

package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.blocks.TypewriterBlock;
import com.mdt.ait.common.container.MonitorContainer;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.network.Network;
import com.mdt.ait.network.packets.MonitorExteriorChangePacket;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.BeaconContainer;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.*;
import net.minecraft.util.Hand;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.LockCode;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class TypewriterTile extends LockableLootTileEntity {

    public static int slots = 1;
    protected NonNullList<ItemStack> items = NonNullList.withSize(slots, ItemStack.EMPTY);

    public TypewriterTile() {
        super(AITTiles.TYPEWRITER_TILE_ENTITY_TYPE.get());
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("<TARDIS EXTERIOR>").setStyle(Style.EMPTY.withColor(TextFormatting.WHITE));
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new MonitorContainer(id, player, this);
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        super.save(compound);
        if(!this.trySaveLootTable(compound)) {
            ItemStackHelper.saveAllItems(compound, this.items);
        }
        return compound;
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        this.items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(nbt)) {
            ItemStackHelper.loadAllItems(nbt, this.items);
        }
    }

    @Override public int getContainerSize() {
        return 1;
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.items = itemsIn;
    }

    public void setLastExterior() {
        World world = this.getLevel();
        BlockPos bpos = new BlockPos(this.getBlockPos().getX() + 1,
                this.getBlockPos().getY(), this.getBlockPos().getZ());
        Block tardisBlock = world.getBlockState(bpos).getBlock();
        if(tardisBlock instanceof TardisBlock) {
            TileEntity tileEntity = world.getBlockEntity(bpos).getTileEntity();
            ((TardisTileEntity) tileEntity).lastExteriorFromMonitor();
        }
        Network.sendToServer(new MonitorExteriorChangePacket(11));
    }

    public void setNextExterior() {
        World world = this.getLevel();
        BlockPos bpos = new BlockPos(this.getBlockPos().getX() + 1,
                this.getBlockPos().getY(), this.getBlockPos().getZ());
        Block tardisBlock = world.getBlockState(bpos).getBlock();
        if(tardisBlock instanceof TardisBlock) {
            TileEntity tileEntity = world.getBlockEntity(bpos).getTileEntity();
            ((TardisTileEntity) tileEntity).lastExteriorFromMonitor();
        }
        Network.sendToServer(new MonitorExteriorChangePacket(11));
    }
}

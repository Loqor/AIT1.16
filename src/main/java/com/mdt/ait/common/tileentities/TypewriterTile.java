package com.mdt.ait.common.tileentities;

import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.network.depreciated.Network;
import com.mdt.ait.network.depreciated.packets.MonitorExteriorChangePacket;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class TypewriterTile extends TileEntity {

    //public UUID tardisID;

    public TypewriterTile() {
        super(AITTiles.TYPEWRITER_TILE_ENTITY_TYPE.get());
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        //compound.putUUID("tardisID", this.tardisID);
        return super.save(compound);
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        //this.tardisID = nbt.getUUID("tardisID");
        super.load(state, nbt);
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

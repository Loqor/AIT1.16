package com.mdt.ait.common.tileentities;

import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumConsoleType;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;

import javax.annotation.Nonnull;

public class ConsoleTileEntity extends TileEntity implements ITickableTileEntity {
    public ConsoleTileEntity(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    protected EnumConsoleType currentconsole = EnumConsoleType.DEV_CONSOLE;

    public EnumConsoleType getNextConsole() {
        switch (currentconsole) {
            case DEV_CONSOLE:
                return EnumConsoleType.DEV_CONSOLE;
        }
        return EnumConsoleType.DEV_CONSOLE;
    }

    public void setConsole(EnumConsoleType console) {
        this.currentconsole = console;
    }

    public ConsoleTileEntity() {
        super(AITTiles.CONSOLE_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {

    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }

    @Override
    public void load(BlockState pState, CompoundNBT nbt) {
        this.currentconsole = EnumConsoleType.values()[nbt.getInt("currentconsole")];
        super.load(pState, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putInt("currentconsole", this.currentconsole.ordinal());
        return super.save(nbt);
    }

    @Override
    @Nonnull
    public CompoundNBT getUpdateTag() {
        return save(new CompoundNBT());
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(worldPosition, 0, save(new CompoundNBT()));
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
        load(getBlockState(), packet.getTag());
    }

    public void syncToClient() {
        assert level != null;
        level.setBlocksDirty(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition));
        level.sendBlockUpdated(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition), 3);
        setChanged();
    }
}

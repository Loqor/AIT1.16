package com.mdt.ait.common.tileentities;

import com.mdt.ait.common.blocks.ConsoleBlock;
import com.mdt.ait.common.entities.ControlInteractionEntity;
import com.mdt.ait.core.init.AITEntities;
import com.mdt.ait.core.init.AITItems;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumConsoleType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.UUID;

public class ConsoleTileEntity extends TileEntity implements ITickableTileEntity {

    public UUID tardisID;

    public static HashMap<String, UUID> control_names = new HashMap<String, UUID>();

    public boolean isThisConsoleHere = false;

    public ControlInteractionEntity Throttle;
    public ControlInteractionEntity coordinateX;
    public ControlInteractionEntity coordinateY;
    public ControlInteractionEntity coordinateZ;
    public ControlInteractionEntity Increment;
    public ControlInteractionEntity DimControl;
    public ControlInteractionEntity posNeg;
    public ControlInteractionEntity exteriorFacing;
    public ControlInteractionEntity Monitor;

    public ConsoleTileEntity(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    protected EnumConsoleType currentconsole = EnumConsoleType.BOREALIS_CONSOLE;

    public EnumConsoleType getNextConsole() {
        switch (currentconsole) {
            case BOREALIS_CONSOLE:
                return EnumConsoleType.DEV_CONSOLE;
            case DEV_CONSOLE:
                return EnumConsoleType.BOREALIS_CONSOLE;
        }
        return EnumConsoleType.BOREALIS_CONSOLE;
    }

    @Override
    public void onLoad() {
        World world = this.getLevel();
        entitiesMethod(world);
    }

    /*@Override
    public void onChunkUnloaded() {
        World world = this.getLevel();
        entitiesMethod(world);
        super.onChunkUnloaded();
    }*/

    public void setConsole(EnumConsoleType console) {
        this.currentconsole = console;
    }

    public ConsoleTileEntity() {
        super(AITTiles.CONSOLE_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
        //entitiesMethod(this.level);
        //System.out.println(this.Throttle.hurtMarked);
    }

    public void useOnConsole(ItemUseContext context, BlockPos blockpos, BlockState blockstate, Block block) {
        PlayerEntity playerentity = context.getPlayer();
        Item item = playerentity.getMainHandItem().getItem();

        if (block instanceof ConsoleBlock && (item == AITItems.TENNANT_SONIC.get() || item == AITItems.WHITTAKER_SONIC.get()) && playerentity.isCrouching()) {
            currentconsole = getNextConsole();
            syncToClient();
        }
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }

    @Override
    public void load(BlockState pState, CompoundNBT nbt) {
        this.currentconsole = EnumConsoleType.values()[nbt.getInt("currentconsole")];
        if (nbt.contains("tardisID")) {
            this.tardisID = nbt.getUUID("tardisID");
        }
        super.load(pState, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putInt("currentconsole", this.currentconsole.ordinal());
        if (this.tardisID != null) {
            nbt.putUUID("tardisID", this.tardisID);
        }
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

    public void entitiesMethod(World world) {
        if(this.tardisID != null) {
            this.Throttle = new ControlInteractionEntity(AITEntities.THROTTLE_INTERACTION_ENTITY.get(), this.level);
            this.coordinateX = new ControlInteractionEntity(AITEntities.COORDX_INTERACTION_ENTITY.get(), this.level);
            this.coordinateY = new ControlInteractionEntity(AITEntities.COORDY_INTERACTION_ENTITY.get(), this.level);
            this.coordinateZ = new ControlInteractionEntity(AITEntities.COORDZ_INTERACTION_ENTITY.get(), this.level);
            this.Increment = new ControlInteractionEntity(AITEntities.INCREMENT_INTERACTION_ENTITY.get(), this.level);
            this.DimControl = new ControlInteractionEntity(AITEntities.DIMENSIONAL_CONTROL_INTERACTION_ENTITY.get(), this.level);
            this.posNeg = new ControlInteractionEntity(AITEntities.POSITIVE_NEGATIVE_INTERACTION_ENTITY.get(), this.level);
            this.exteriorFacing = new ControlInteractionEntity(AITEntities.EXTERIOR_FACING_INTERACTION_ENTITY.get(), this.level);
            this.Monitor = new ControlInteractionEntity(AITEntities.MONITOR_INTERACTION_ENTITY.get(), this.level);
            if (currentconsole == EnumConsoleType.BOREALIS_CONSOLE) {
                double X = this.worldPosition.getX();
                double Y = this.worldPosition.getY();
                double Z = this.worldPosition.getZ();
                world.addFreshEntity(this.Throttle);
                world.addFreshEntity(this.coordinateX);
                world.addFreshEntity(this.coordinateY);
                world.addFreshEntity(this.coordinateZ);
                world.addFreshEntity(this.Increment);
                world.addFreshEntity(this.DimControl);
                world.addFreshEntity(this.posNeg);
                world.addFreshEntity(this.exteriorFacing);
                world.addFreshEntity(this.Monitor);
                this.Throttle.setPos(X + 1.125, Y + 1.03125, Z + 1);
                this.coordinateX.setPos(X + 0.25, Y + 0.875, Z);
                this.coordinateY.setPos(X + 0.375, Y + 0.875, Z);
                this.coordinateZ.setPos(X + 0.5, Y + 0.875, Z);
                this.Increment.setPos(X + 0.625, Y + 0.875, Z);
                this.DimControl.setPos(X + 0.75, Y + 1.25, Z);
                this.posNeg.setPos(X + 0.125, Y + 0.875, Z);
                this.exteriorFacing.setPos(X + 1, Y + 1.03125, Z);
                this.Monitor.setPos(X + 1, Y + 1.15, Z + 1);
                System.out.println("Is this working?" + world.addFreshEntity(this.Throttle));
                this.Throttle.setControlName("Throttle");
                this.coordinateX.setControlName("X");
                this.coordinateY.setControlName("Y");
                this.coordinateZ.setControlName("Z");
                this.Increment.setControlName("Increment");
                this.DimControl.setControlName("Dimension Switch");
                this.posNeg.setControlName("Positive/Negative");
                this.exteriorFacing.setControlName("Exterior Facing");
                this.Monitor.setControlName("Monitor");
                this.Throttle.setControlTag(this.tardisID.toString(), this.tardisID);
                this.coordinateX.setControlTag(this.tardisID.toString(), this.tardisID);
                this.coordinateY.setControlTag(this.tardisID.toString(), this.tardisID);
                this.coordinateZ.setControlTag(this.tardisID.toString(), this.tardisID);
                this.Increment.setControlTag(this.tardisID.toString(), this.tardisID);
                this.DimControl.setControlTag(this.tardisID.toString(), this.tardisID);
                this.posNeg.setControlTag(this.tardisID.toString(), this.tardisID);
                this.exteriorFacing.setControlTag(this.tardisID.toString(), this.tardisID);
                this.Monitor.setControlTag(this.tardisID.toString(), this.tardisID);
            }
        }
    }

    public boolean throttleHit() {
        return this.Throttle.hasBeenHit;
    }

    public void onPlace(BlockState pState, World world, BlockPos blockPos, BlockState pOldState, boolean pIsMoving) {
        entitiesMethod(world);
    }

    public void onRemove(BlockState pState, World world, BlockPos blockPos) {
        this.Throttle.remove();
        this.coordinateX.remove();
        this.coordinateY.remove();
        this.coordinateZ.remove();
        this.Increment.remove();
        this.DimControl.remove();
        this.posNeg.remove();
        this.exteriorFacing.remove();
        this.Monitor.remove();
    }
}

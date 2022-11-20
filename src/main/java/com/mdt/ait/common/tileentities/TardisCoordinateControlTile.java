package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.DimensionSwitchControlBlock;
import com.mdt.ait.common.blocks.TardisCoordinateControlBlock;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumCoordinateDirectionState;
import com.mdt.ait.core.init.enums.EnumCoordinatePosNegState;
import com.mdt.ait.core.init.enums.EnumCoordinateState;
import com.mdt.ait.core.init.enums.EnumDimensionControlState;
import com.mdt.ait.tardis.Tardis;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;
import java.util.UUID;

public class TardisCoordinateControlTile extends TileEntity implements ITickableTileEntity {

    public UUID tardisID;
    public EnumDimensionControlState currentdimensionstate = EnumDimensionControlState.EARTH;
    public String coordinateDisplay;
    private RegistryKey<World> newDimension;
    public BlockPos newSetPosition;
    public int xPos;
    public int yPos;
    public int zPos;
    public int incrementValue = 1;
    public EnumCoordinateState currentCoordinateState = EnumCoordinateState.NULL;
    public EnumCoordinatePosNegState currentPosNegState = EnumCoordinatePosNegState.IS_POSITIVE;
    public EnumCoordinateDirectionState currentCoordinateDirectionState = EnumCoordinateDirectionState.NORTH;
    public double shiftingPositionEx = 0;
    public double shiftingPositionY = 0;
    public double shiftingPositionZ = 0;
    public double Xx = 0.0625;
    public double Xz = 0.0625;
    public double Yx = 0.0625;
    public double Yz = 0.375;
    public double Zx = 0.0625;
    public double Zz = 0.6875;
    public double IncrementX;
    public double IncrementZ;
    public double width;
    public double height;
    public double incrementWidth;
    public double incrementHeight;

    public TardisCoordinateControlTile() {
        super(AITTiles.TARDIS_COORDINATE_CONTROL_TILE_ENTITY_TYPE.get());
    }

    public void setListedPosition(BlockPos position) {
        xPos = position.getX();
        yPos = position.getY();
        zPos = position.getZ();
        syncToClient();
    }

    public void onPlace() {
        Tardis tardis = AIT.tardisManager.getTardis(tardisID);
        xPos = tardis.exterior_position.getX();
        yPos = tardis.exterior_position.getY();
        zPos = tardis.exterior_position.getZ();
        currentCoordinateDirectionState = coordinateBlockDirectionState();
        this.currentPosNegState = EnumCoordinatePosNegState.IS_POSITIVE;
        changePositionFromControl();
        syncToClient();
    }

    public EnumCoordinatePosNegState getNextPosNegState() {
        switch(currentPosNegState) {
            case IS_POSITIVE:
                return EnumCoordinatePosNegState.IS_NEGATIVE;
            case IS_NEGATIVE:
                return EnumCoordinatePosNegState.IS_POSITIVE;
        }
        return EnumCoordinatePosNegState.IS_POSITIVE;
    }

    public int getNextIncrement() {
        switch(incrementValue) {
            case 1:
                return 10;
            case 10:
                return 100;
            case 100:
                return 1000;
            case 1000:
                return 1;
        }
        return 1;
    }

    public EnumCoordinateDirectionState coordinateBlockDirectionState() {
        switch (getBlockState().getValue(TardisCoordinateControlBlock.FACING)) {
            case NORTH:
                return EnumCoordinateDirectionState.NORTH;
            case EAST:
                return EnumCoordinateDirectionState.EAST;
            case SOUTH:
                return EnumCoordinateDirectionState.SOUTH;
            case WEST:
                return EnumCoordinateDirectionState.WEST;
        }
        return EnumCoordinateDirectionState.NORTH;
    }

    public ActionResultType useOn(World world, PlayerEntity playerEntity, BlockPos blockpos, Hand hand, BlockRayTraceResult pHit) {
        //ServerWorld tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (block instanceof TardisCoordinateControlBlock && hand == Hand.MAIN_HAND) {
            playerEntity.playSound(AITSounds.BUTTON_PRESS.get(), 5, 1);
            double mouseX = pHit.getLocation().x - blockpos.getX();
            double mouseZ = pHit.getLocation().z - blockpos.getZ();
            if(currentCoordinateDirectionState == EnumCoordinateDirectionState.NORTH) {
                this.Xx = 0.6875;
                this.Xz = 0.0625;
                this.Yx = 0.375;
                this.Yz = 0.0625;
                this.Zx = 0.0625;
                this.Zz = 0.0625;
                this.IncrementX = 0.875;
                this.IncrementZ = 0.375;
                this.width = 0.25;
                this.height = 0.25;
                this.incrementWidth = 0.125;
                this.incrementHeight = 0.125;
            }
            if(currentCoordinateDirectionState == EnumCoordinateDirectionState.EAST) {
                this.Xx = 0.0625;
                this.Xz = 0.0625;
                this.Yx = 0.0625;
                this.Yz = 0.375;
                this.Zx = 0.0625;
                this.Zz = 0.6875;
                this.IncrementX = 0.375;
                this.IncrementZ = 1;
                this.width = 0.25;
                this.height = 0.25;
                this.incrementWidth = 0.125;
                this.incrementHeight = 0.125;
            }
            if(currentCoordinateDirectionState == EnumCoordinateDirectionState.SOUTH) {
                this.Xx = 0.0625;
                this.Xz = 1.0625;
                this.Yx = 0.0625;
                this.Yz = 1.375;
                this.Zx = 0.0625;
                this.Zz = 1.6875;
                this.IncrementX = 0.375;
                this.IncrementZ = -0;
                this.width = 0.25;
                this.height = 0.25;
                this.incrementWidth = 0.125;
                this.incrementHeight = 0.125;
            }
            if(currentCoordinateDirectionState == EnumCoordinateDirectionState.WEST) {
                this.Xx = 0.0625;
                this.Xz = 0.0625;
                this.Yx = 0.0625;
                this.Yz = 0.375;
                this.Zx = 0.0625;
                this.Zz = 0.6875;
                this.IncrementX = 0.375;
                this.IncrementZ = 0;
                this.width = 0.25;
                this.height = 0.25;
                this.incrementWidth = 0.125;
                this.incrementHeight = 0.125;
            }
            boolean isHoveredOverX = mouseX >= Xx && mouseZ >= Xz && mouseX <= (Xx + width) && mouseZ <= (Xz + height);
            boolean isHoveredOverY = mouseX >= Yx && mouseZ >= Yz && mouseX <= (Yx + width) && mouseZ <= (Yz + height);
            boolean isHoveredOverZ = mouseX >= Zx && mouseZ >= Zz && mouseX <= (Zx + width) && mouseZ <= (Zz + height);
            boolean isHoveredOverIncrement = mouseX >= IncrementX && mouseZ >= IncrementZ && mouseX <= (IncrementX + incrementWidth) && mouseZ <= (IncrementZ + incrementHeight);
            if(currentPosNegState == EnumCoordinatePosNegState.IS_POSITIVE) {
                if (isHoveredOverX) {
                    xPos += incrementValue;
                    this.shiftingPositionEx = 0.025;
                } else {
                    this.shiftingPositionEx = 0;
                }
                if (isHoveredOverY) {
                    yPos += incrementValue;
                    this.shiftingPositionY = 0.025;
                } else {
                    this.shiftingPositionY = 0;
                }
                if (isHoveredOverZ) {
                    zPos += incrementValue;
                    this.shiftingPositionZ = 0.025;
                } else {
                    this.shiftingPositionZ = 0;
                }
                if (isHoveredOverIncrement) {
                    this.incrementValue = getNextIncrement();
                }
            }
            if(currentPosNegState == EnumCoordinatePosNegState.IS_NEGATIVE) {
                if (isHoveredOverX) {
                    xPos -= incrementValue;
                    this.shiftingPositionEx = 0.025;
                } else {
                    this.shiftingPositionEx = 0;
                }
                if (isHoveredOverY) {
                    yPos -= incrementValue;
                    this.shiftingPositionY = 0.025;
                } else {
                    this.shiftingPositionY = 0;
                }
                if (isHoveredOverZ) {
                    zPos -= incrementValue;
                    this.shiftingPositionZ = 0.025;
                } else {
                    this.shiftingPositionZ = 0;
                }
                if (isHoveredOverIncrement) {
                    this.incrementValue = getNextIncrement();
                }
            }
//                System.out.println(mouseX + " || " + mouseZ);
//                System.out.println("Xstuff: " + Xx + ", " + Xz + " || Ystuff: " + Yx + ", " + Yz + " || Zstuff: " + Zx + ", " + Zz);
//                System.out.println(isHoveredOverX + ", " + isHoveredOverY + ", " + isHoveredOverZ);
//                System.out.println(currentPosNegState);
            if(!(isHoveredOverX && isHoveredOverY && isHoveredOverZ)) {
                if(playerEntity.isCrouching()) {
                    this.currentPosNegState = getNextPosNegState();
                    System.out.println(this.currentPosNegState);
                }
            }
            changePositionFromControl();
            syncToClient();
        }
        return ActionResultType.SUCCESS;
    }


    public void changePositionFromControl() {
        newSetPosition = new BlockPos(xPos, yPos, zPos);
        if (this.tardisID != null) {
            AIT.tardisManager.setTardisTargetBlockPos(tardisID, newSetPosition);
        }
    }

    @Override
    public void tick() {
        if(this.tardisID != null) {
            Tardis tardis = AIT.tardisManager.getTardis(tardisID);
            if (tardis.landed != false) {
                xPos = tardis.exterior_position.getX();
                yPos = tardis.exterior_position.getY();
                zPos = tardis.exterior_position.getZ();
                //currentCoordinateDirectionState = coordinateBlockDirectionState();
                syncToClient();
            }
        }
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(20, 20, 20);
    }

    @Override
    public void load(BlockState pState, CompoundNBT nbt) {
        if (nbt.contains("tardisID")) {
            this.tardisID = nbt.getUUID("tardisID");
        }
        this.xPos = nbt.getInt("xPosition");
        this.yPos = nbt.getInt("yPosition");
        this.zPos = nbt.getInt("zPosition");
        this.incrementValue = nbt.getInt("incrementValue");
        this.currentCoordinateDirectionState = EnumCoordinateDirectionState.values()[nbt.getInt("currentcoordinatedirectionstate")];
        this.currentCoordinateState = EnumCoordinateState.values()[nbt.getInt("currentcoordinatestate")];
        this.currentPosNegState = EnumCoordinatePosNegState.values()[nbt.getInt("currentposnegstate")];
        this.currentdimensionstate = EnumDimensionControlState.values()[nbt.getInt("currentdimensionstate")];
        super.load(pState, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putInt("xPosition", this.xPos);
        nbt.putInt("yPosition", this.yPos);
        nbt.putInt("zPosition", this.zPos);
        nbt.putInt("incrementValue", this.incrementValue);
        nbt.putInt("currentcoordinatedirectionstate", this.currentCoordinateDirectionState.ordinal());
        nbt.putInt("currentcoordinatestate", this.currentCoordinateState.ordinal());
        nbt.putInt("currentposnegstate", this.currentPosNegState.ordinal());
        nbt.putInt("currentdimensionstate", this.currentdimensionstate.ordinal());
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
}

package com.mdt.ait.common.tileentities;

import com.mdt.ait.common.blocks.RoundelDoorsBlock;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.core.init.AITItems;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumDoorState;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;

import static com.mdt.ait.core.init.enums.EnumDoorState.*;
import static com.mdt.ait.core.init.enums.EnumDoorState.BOTH;

public class RoundelDoorsTile extends TileEntity implements ITickableTileEntity {

    public float doorRotation = 0;
    public EnumDoorState currentstate = EnumDoorState.CLOSED;
    public EnumDoorState previousstate = CLOSED;
    public boolean affectBothDoors = false;
    public boolean flipDoors = false;
    public String clickedOnWithBlock = "hartnell_mint_a";

    public EnumDoorState getNextDoorState() {
        if (currentstate == CLOSED) {
            return FIRST;
        }
        if (currentstate == FIRST) {
            return CLOSED;
        }
        return EnumDoorState.CLOSED;
    }

    public RoundelDoorsTile() {
        super(AITTiles.ROUNDEL_DOORS_TILE_ENTITY_TYPE.get());
    }

    public EnumDoorState currentState() {
        return this.currentstate;
    }

    @Override
    public void tick() {
        if (currentState() != previousstate) {
            doorRotation = currentState() == FIRST ? 0.0f : 110.0f;
        }
        if (currentState() != CLOSED) {
            if (doorRotation < 110.0f) {
                doorRotation += 2.5f;
            } else {
                doorRotation = 110.0f;
            }
        } else {
            if (doorRotation > 0.0f) {
                doorRotation -= 10.0f;
            }
        }
        if(currentState() == CLOSED) {
            if(doorRotation == -2.5f) {
                doorRotation = 0.0f;
            }
        }
        previousstate = currentstate;
        BlockPos a = new BlockPos(worldPosition.getX() + 1, worldPosition.getY(), worldPosition.getZ());
        BlockPos b = new BlockPos(worldPosition.getX() - 1, worldPosition.getY(), worldPosition.getZ());
        BlockPos c = new BlockPos(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ() + 1);
        BlockPos d = new BlockPos(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ() - 1);
        assert level != null;
        if(level.getBlockState(a).getBlock() instanceof RoundelDoorsBlock
                || level.getBlockState(b).getBlock() instanceof RoundelDoorsBlock
                || level.getBlockState(c).getBlock() instanceof RoundelDoorsBlock
                || level.getBlockState(d).getBlock() instanceof RoundelDoorsBlock) {
            affectBothDoors = true;
        }
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }

    public void setDoorState(EnumDoorState state) {
        this.currentstate = state;
    }

    public ActionResultType useOn(World world, PlayerEntity pPlayer, BlockPos pPos, Hand pHandIn) {
        BlockState blockstate = world.getBlockState(pPos);
        Block block = blockstate.getBlock();
        if (!world.isClientSide) {
            if (block instanceof RoundelDoorsBlock && pHandIn == Hand.MAIN_HAND && !world.isClientSide) {
                if(pPlayer.getMainHandItem().isEmpty()) {
                    this.setDoorState(this.getNextDoorState());
                    syncToClient();
                    if(affectBothDoors) {
                        BlockPos a = new BlockPos(pPos.getX() + 1, pPos.getY(), pPos.getZ());
                        BlockPos b = new BlockPos(pPos.getX() - 1, pPos.getY(), pPos.getZ());
                        BlockPos c = new BlockPos(pPos.getX(), pPos.getY(), pPos.getZ() + 1);
                        BlockPos d = new BlockPos(pPos.getX(), pPos.getY(), pPos.getZ() - 1);
                        RoundelDoorsTile a1 = (RoundelDoorsTile) world.getBlockEntity(a);
                        RoundelDoorsTile b1 = (RoundelDoorsTile) world.getBlockEntity(b);
                        RoundelDoorsTile c1 = (RoundelDoorsTile) world.getBlockEntity(c);
                        RoundelDoorsTile d1 = (RoundelDoorsTile) world.getBlockEntity(d);
                        //RoundelDoorsBlock a2 = (RoundelDoorsBlock) world.getBlockState(a).getBlock();
                        //RoundelDoorsBlock b2 = (RoundelDoorsBlock) world.getBlockState(b).getBlock();
                        //RoundelDoorsBlock c2 = (RoundelDoorsBlock) world.getBlockState(c).getBlock();
                        //RoundelDoorsBlock d2 = (RoundelDoorsBlock) world.getBlockState(d).getBlock();
                        if (a1 != null) {
                            a1.setDoorState(currentstate);
                            a1.syncToClient();
                        }
                        if (b1 != null) {
                            b1.setDoorState(currentstate);
                            b1.syncToClient();
                        }
                        if (c1 != null) {
                            c1.setDoorState(currentstate);
                            c1.syncToClient();
                        }
                        if (d1 != null) {
                            d1.setDoorState(currentstate);
                            d1.syncToClient();
                        }
                        syncToClient();
                    }
                } else if (pPlayer.isCrouching()) {
                    clickedOnWithBlock = pPlayer.getMainHandItem().getItem().toString();
                    syncToClient();
                }
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public void load(BlockState blockstate, CompoundNBT nbt) {
        this.currentstate = EnumDoorState.values()[nbt.getInt("currentstate")];
        this.doorRotation = nbt.getFloat("door");
        this.affectBothDoors = nbt.getBoolean("affectBothDoors");
        this.flipDoors = nbt.getBoolean("flipDoors");
        this.clickedOnWithBlock = nbt.getString("clickedonwithblock");
        super.load(blockstate, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putInt("currentstate", this.currentstate.ordinal());
        nbt.putFloat("door", this.doorRotation);
        nbt.putBoolean("affectBothDoors", this.affectBothDoors);
        nbt.putBoolean("flipDoors", this.flipDoors);
        nbt.putString("clickedonwithblock", this.clickedOnWithBlock);
        return super.save(nbt);
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

    public void useOnRoundelDoors(ItemUseContext context, BlockPos blockpos, BlockState blockstate, Block block) {
        if(context.getPlayer().isCrouching() && context.getPlayer().getItemInHand(Hand.MAIN_HAND).getItem().equals(AITItems.TENNANT_SONIC.get())) {
            flipDoors = true;
            System.out.println(flipDoors);
            syncToClient();
        }
    }
}

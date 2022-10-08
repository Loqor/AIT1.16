package com.mdt.ait.common.tileentities;

import com.mdt.ait.common.blocks.RecordPlayerBlock;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumRecordPlayerState;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class RecordPlayerTile extends TileEntity implements ITickableTileEntity {

    public RecordPlayerTile() {
        super(AITTiles.RECORD_PLAYER_TILE_ENTITY_TYPE.get());
    }
    public boolean make_thing_spin = false;
    public float spin_value = 0;
    public EnumRecordPlayerState playerState = EnumRecordPlayerState.CLOSED;
    public int runafter = 0;
    public float recordState = 0;
    public float needleState = 0;
    public boolean pigstepRecord = false;
    public float spindisc = 0.0f;

    @Override
    public void tick() {
        if(playerState == EnumRecordPlayerState.CLOSED) {
            if (recordState < -1f) {
                recordState += 10.0f;
            } else {
                recordState = 0f;
            }
            needleState = 0;
        }
        if(playerState == EnumRecordPlayerState.OPEN) {
            if (recordState > -110f) {
                recordState -= 5.0f;
            } else {
                recordState = -110f;
            }
        }
        if(playerState == EnumRecordPlayerState.OPEN) {
            runafter = 1;
            needleState = 0;
            if(runafter == 1) {
                runafter = 0;
            }
        }
        if(playerState == EnumRecordPlayerState.PLAYING) {
            spindisc += 20.0f;
        } else {
            spindisc = 0.0f;
        }
        if(playerState == EnumRecordPlayerState.PLAYING /*&& pigstepRecord*/) {
            if (needleState < 25f) {
                needleState += 1.0f;
            } else {
                needleState = 25f;
            }
        }
    }

    public EnumRecordPlayerState getNextPlayerState() {
        switch (playerState) {
            case CLOSED:
                return EnumRecordPlayerState.OPEN;
            case OPEN:
                return EnumRecordPlayerState.CLOSED;
        }
        return EnumRecordPlayerState.CLOSED;
    }

    public EnumRecordPlayerState getPlayerState() {
        return this.playerState;
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }

    @Override
    public void load(BlockState pState, CompoundNBT nbt) {
        this.playerState = EnumRecordPlayerState.values()[nbt.getInt("playerState")];
        super.load(pState, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putInt("playerState", this.playerState.ordinal());
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

    public ActionResultType useOn(World world, PlayerEntity playerEntity, BlockPos blockpos, Hand hand, BlockRayTraceResult pHit) {
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        Item iteminmainhand = playerEntity.getItemBySlot(EquipmentSlotType.MAINHAND).getItem();
        System.out.println(iteminmainhand);
        if (block instanceof RecordPlayerBlock && hand == Hand.MAIN_HAND && !world.isClientSide && iteminmainhand == Items.AIR) {
            playerState = getNextPlayerState();
            syncToClient();
        }
        if(playerState == EnumRecordPlayerState.OPEN && iteminmainhand == Items.MUSIC_DISC_PIGSTEP) {
            pigstepRecord = true;
            playerState = EnumRecordPlayerState.PLAYING;
            world.playSound(null, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), SoundEvents.MUSIC_DISC_PIGSTEP, SoundCategory.MASTER, 10, 1);
        }
        if(playerState == EnumRecordPlayerState.CLOSED) {

        }
        return ActionResultType.SUCCESS;
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

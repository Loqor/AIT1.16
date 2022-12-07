package com.mdt.ait.common.tileentities;

import com.mdt.ait.common.blocks.RecordPlayerBlock;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumRecordPlayerState;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.IClearable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.JukeboxTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
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
    public boolean isHasRecord = false;
    public Item record;
    public float spindisc = 0.0f;
    public SoundEvent soundToPlay;

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
        if(playerState == EnumRecordPlayerState.PLAYING /*&& isHasRecord*/) {
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
        if(!world.isClientSide) {
            if (!playerEntity.isCrouching() && hand == Hand.MAIN_HAND && !world.isClientSide && iteminmainhand == Items.AIR && !isHasRecord) {
                playerState = getNextPlayerState();
                syncToClient();
            }
            if ((playerState == EnumRecordPlayerState.OPEN || playerState == EnumRecordPlayerState.PLAYING) && playerEntity.isCrouching() && hand == Hand.MAIN_HAND && !world.isClientSide && iteminmainhand == Items.AIR && isHasRecord) {
                playerEntity.addItem(new ItemStack(record));
                playerState = EnumRecordPlayerState.OPEN;
                isHasRecord = false;
                syncToClient();
            }
            if (playerState == EnumRecordPlayerState.OPEN && iteminmainhand.getItem() instanceof MusicDiscItem) {
                //13
                if (iteminmainhand == Items.MUSIC_DISC_13) {
                    record = Items.MUSIC_DISC_13;
                    soundToPlay = SoundEvents.MUSIC_DISC_13;
                }
                //cat
                if (iteminmainhand == Items.MUSIC_DISC_CAT) {
                    record = Items.MUSIC_DISC_CAT;
                    soundToPlay = SoundEvents.MUSIC_DISC_CAT;
                }
                //blocks
                if (iteminmainhand == Items.MUSIC_DISC_BLOCKS) {
                    record = Items.MUSIC_DISC_BLOCKS;
                    soundToPlay = SoundEvents.MUSIC_DISC_BLOCKS;
                }
                //chirp
                if (iteminmainhand == Items.MUSIC_DISC_CHIRP) {
                    record = Items.MUSIC_DISC_CHIRP;
                    soundToPlay = SoundEvents.MUSIC_DISC_CHIRP;
                }
                //far
                if (iteminmainhand == Items.MUSIC_DISC_FAR) {
                    record = Items.MUSIC_DISC_FAR;
                    soundToPlay = SoundEvents.MUSIC_DISC_FAR;
                }
                //mall
                if (iteminmainhand == Items.MUSIC_DISC_MALL) {
                    record = Items.MUSIC_DISC_MALL;
                    soundToPlay = SoundEvents.MUSIC_DISC_MALL;
                }
                //mellohi
                if (iteminmainhand == Items.MUSIC_DISC_MELLOHI) {
                    record = Items.MUSIC_DISC_MELLOHI;
                    soundToPlay = SoundEvents.MUSIC_DISC_MELLOHI;
                }
                //stal
                if (iteminmainhand == Items.MUSIC_DISC_STAL) {
                    record = Items.MUSIC_DISC_STAL;
                    soundToPlay = SoundEvents.MUSIC_DISC_STAL;
                }
                //strad
                if (iteminmainhand == Items.MUSIC_DISC_STRAD) {
                    record = Items.MUSIC_DISC_STRAD;
                    soundToPlay = SoundEvents.MUSIC_DISC_STRAD;
                }
                //ward
                if (iteminmainhand == Items.MUSIC_DISC_WARD) {
                    record = Items.MUSIC_DISC_WARD;
                    soundToPlay = SoundEvents.MUSIC_DISC_WARD;
                }
                //11
                if (iteminmainhand == Items.MUSIC_DISC_11) {
                    record = Items.MUSIC_DISC_11;
                    soundToPlay = SoundEvents.MUSIC_DISC_11;
                }
                //wait
                if (iteminmainhand == Items.MUSIC_DISC_WAIT) {
                    record = Items.MUSIC_DISC_WAIT;
                    soundToPlay = SoundEvents.MUSIC_DISC_WAIT;
                }
                //pigstep
                if (iteminmainhand == Items.MUSIC_DISC_PIGSTEP) {
                    record = Items.MUSIC_DISC_PIGSTEP;
                    soundToPlay = SoundEvents.MUSIC_DISC_PIGSTEP;
                }
                ItemStack itemStack = playerEntity.getMainHandItem();
                itemStack.shrink(1);
                isHasRecord = true;
                playerState = EnumRecordPlayerState.PLAYING;
                world.playSound(null, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), soundToPlay, SoundCategory.MASTER, 10, 1);
            }
            if (playerState == EnumRecordPlayerState.CLOSED || !isHasRecord) {
                if (!world.isClientSide()) {
                    Minecraft.getInstance().getSoundManager().stop();
                }
            }
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

package io.mdt.ait.tardis;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.BasicInteriorDoorBlock;
import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.core.init.AITTiles;
import com.qouteall.immersive_portals.api.PortalAPI;
import com.qouteall.immersive_portals.portal.Portal;
import com.qouteall.immersive_portals.portal.PortalManipulation;
import io.mdt.ait.common.tiles.TARDISTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.world.ForgeChunkManager;

import java.util.UUID;

public class TARDISInteriorDoorTile extends TileEntity implements ITickableTileEntity {

    private TARDIS tardis;
    private float rightDoorRotation = 0;
    private float leftDoorRotation = 0;
    private Portal portal;

    public TARDISInteriorDoorTile() {
        super(AITTiles.BASIC_INTERIOR_DOOR_TILE_ENTITY_TYPE.get());
    }

    public void link(TARDIS tardis) {
        this.tardis = tardis;
    }

    public float getLeftDoorRotation() {
        return leftDoorRotation;
    }

    public float getRightDoorRotation() {
        return rightDoorRotation;
    }

    public DoorState getStateManger() {
        if (this.tardis != null) {
            return this.tardis.getDoor().getState();
        }

        return null;
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        if (this.getLevel() != null && !this.getLevel().isClientSide) {
            ChunkPos chunkPos = new ChunkPos(this.getBlockPos());
            ForgeChunkManager.forceChunk((ServerWorld) this.getLevel(), AIT.MOD_ID, this.getBlockPos(), chunkPos.x, chunkPos.z, false, false);
        }
        syncToClient();
    }

    public void setPortal(Portal portal) {
        this.portal = PortalManipulation.completeBiWayPortal(portal, Portal.entityType);
        this.portal.reloadAndSyncToClient();
        this.syncToClient();
    }

    DoorState.State previousState = DoorState.State.CLOSED;

    @Override
    public void tick() {
        // remove portal if entity removed, probably can implement that in setRemoved()
        // ...


        if (this.getStateManger() != null) {
            DoorState.State state = this.getStateManger().getState();
            if (state != this.previousState) {
                this.rightDoorRotation = state == DoorState.State.FIRST ? 0.0f : 87.5f;
                this.leftDoorRotation = state == DoorState.State.FIRST ? 0.0f : (state == DoorState.State.BOTH ? 0.0f : 87.5f);
            }
            if (state != DoorState.State.CLOSED) {
                if (this.rightDoorRotation < 87.5f) {
                    this.rightDoorRotation += 5.0f;
                } else {
                    this.rightDoorRotation = 87.5f;
                }
            } else {
                if (this.leftDoorRotation > 0.0f && this.rightDoorRotation > 0.0f) {
                    this.leftDoorRotation -= 15.0f;
                    this.rightDoorRotation -= 15.0f;
                }
            }
            if (state == DoorState.State.BOTH) {
                if (this.leftDoorRotation < 87.5f) {
                    this.leftDoorRotation += 5.0f;
                } else {
                    this.leftDoorRotation = 87.5f;
                }
            }
            if(state == DoorState.State.CLOSED) {
                if(this.leftDoorRotation == -2.5f) {
                    this.leftDoorRotation = 0.0f;
                }
                if(this.rightDoorRotation == -2.5f) {
                    this.rightDoorRotation = 0.0f;
                }
            }
            this.previousState = state;
        }
    }

    public void useOn(World world, PlayerEntity player, BlockPos pos) {
        if (!world.isClientSide) {
            DoorState.State state = this.getStateManger().getState();
            if (!this.getStateManger().isLocked()) {
                state = this.getStateManger().next();

                TARDISTileEntity tardisTileEntity = (TARDISTileEntity) AIT.server.getLevel(tardis.getDimension()).getBlockEntity(tardis.getPosition());
                tardisTileEntity.syncToClient();
            } else {
                player.displayClientMessage(new TranslationTextComponent(
                        "Door is locked!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
            }

            System.out.println("playing sound");
            world.playSound(null, pos, state.getSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
            this.syncToClient();
        }
    }

    public void onKey(ItemUseContext context, BlockPos blockpos) {
        PlayerEntity player = context.getPlayer();
        ItemStack itemStack = player.getMainHandItem();
        BlockPos interiorDoorPos = this.tardis.getDoor().getPosition();
        ServerWorld exteriorDimension = AIT.server.getLevel(this.tardis.getDimension());

        TARDISTileEntity tardisTileEntity = (TARDISTileEntity) exteriorDimension.getBlockEntity(this.tardis.getPosition());

        if (tardisTileEntity == null) {
            player.displayClientMessage(new TranslationTextComponent(
                    "TARDIS is in flight!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
            return;
        }

        if (!this.tardis.ownsKey(itemStack)) {
            player.displayClientMessage(new TranslationTextComponent(
                    "This TARDIS is not yours!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
            return;
        }

        this.getStateManger().setLocked(!player.isCrouching());
        TARDISUtil.getTARDISWorld().playSound(null, interiorDoorPos, AITSounds.TARDIS_LOCK.get(), SoundCategory.MASTER, 7, 1);
        this.syncToClient();

        player.displayClientMessage(new TranslationTextComponent(
                this.getStateManger().isLocked() ? "Door is locked!" : "Door is unlocked!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
        level.playSound(null, blockpos, AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
        TARDISUtil.getTARDISWorld().playSound(null, interiorDoorPos, AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
        this.syncToClient();
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        this.leftDoorRotation = nbt.getFloat("left");
        this.rightDoorRotation = nbt.getFloat("right");
        this.portal = (Portal) ((ServerWorld) this.getLevel()).getEntity(nbt.getUUID("portal"));

        super.load(state, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putFloat("left", this.leftDoorRotation);
        nbt.putFloat("right", this.rightDoorRotation);
        nbt.putUUID("portal", this.portal.getUUID());

        return super.save(nbt);
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(this.worldPosition).inflate(10, 10, 10);
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(worldPosition, 0, this.save(new CompoundNBT()));
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
        this.load(this.getBlockState(), packet.getTag());
    }

    public void syncToClient() {
        if (this.level != null) {
            this.level.setBlocksDirty(this.worldPosition, this.level.getBlockState(this.worldPosition), this.level.getBlockState(this.worldPosition));
            this.level.sendBlockUpdated(this.worldPosition, this.level.getBlockState(this.worldPosition), this.level.getBlockState(this.worldPosition), 3);
            this.setChanged();
        }
    }

    public Direction getFacing() {
        return this.getBlockState().getValue(BasicInteriorDoorBlock.FACING);
    }
}

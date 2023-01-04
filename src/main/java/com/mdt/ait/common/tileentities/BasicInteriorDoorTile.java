package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.BasicInteriorDoorBlock;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.entities.K9Entity;
import com.mdt.ait.common.items.TARDISKey;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.AITItems;
import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.*;
import com.mdt.ait.tardis.Tardis;
import com.qouteall.immersive_portals.api.PortalAPI;
import com.qouteall.immersive_portals.portal.Portal;
import com.qouteall.immersive_portals.portal.PortalManipulation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.world.ForgeChunkManager;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.util.UUID;

import static com.mdt.ait.core.init.enums.EnumDoorState.*;
import static com.mdt.ait.core.init.enums.EnumDoorState.CLOSED;

public class BasicInteriorDoorTile extends TileEntity implements ITickableTileEntity {

    public float leftDoorRotation = 0;
    public float rightDoorRotation = 0;

    public UUID tardisID;
    protected Portal portal;
    protected UUID portalUUID;
    public Tardis linked_tardis;
    protected EnumDoorState currentstate = EnumDoorState.CLOSED;
    public EnumInteriorDoorType currentinteriordoor = EnumInteriorDoorType.DOOR_BASIC_BOX;
    public EnumDoorState previousstate = EnumDoorState.CLOSED;
    public boolean lockedState = false;
    public boolean isItSnowing = false;

    public BasicInteriorDoorTile(TileEntityType<TileEntity> entity) {
        super(entity);
    }

    public EnumDoorState currentState() {
        return this.currentstate;
    }

    public EnumInteriorDoorType getNextInteriorDoor() {
        switch (currentinteriordoor) {
            case DOOR_BASIC_BOX:
                return EnumInteriorDoorType.DOOR_MINT_BOX;
            case DOOR_MINT_BOX:
                return EnumInteriorDoorType.DOOR_TARDIM_EXTERIOR;//return EnumInteriorDoorType.CORAL_BOX;
            //case DOOR_CORAL_BOX:
            //    return EnumInteriorDoorType.POSTER_BOX;
            //case DOOR_POSTER_BOX:
            //    return EnumInteriorDoorType.BAKER_BOX;
            //case DOOR_BAKER_BOX:
            //    return EnumInteriorDoorType.TYPE_40_TT_CAPSULE;
            //case DOOR_TYPE_40_TT_CAPSULE:
            //    return EnumInteriorDoorType.HELLBENT_TT_CAPSULE;
            //case DOOR_HELLBENT_TT_CAPSULE:
            //    return EnumInteriorDoorType.NUKA_COLA_EXTERIOR;
            //case DOOR_NUKA_COLA_EXTERIOR:
            //    return EnumInteriorDoorType.ARCADE_CABINET_EXTERIOR;
            //case DOOR_SIEGE_MODE:
            //    return EnumInteriorDoorType.DOOR_BASIC_BOX;
            //case DOOR_ARCADE_CABINET_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_CUSHING_EXTERIOR;
            //case DOOR_CUSHING_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_CLASSIC_EXTERIOR;
            //case DOOR_CLASSIC_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_HARTNELL_EXTERIOR;
            //case DOOR_HARTNELL_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_HUDOLIN_EXTERIOR;
            //case DOOR_HUDOLIN_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_FALLOUT_SHELTER_EXTERIOR;//EnumInteriorDoorType.TX3_EXTERIOR;
            //case DOOR_TX3_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_TARDIM_EXTERIOR;
            case DOOR_TARDIM_EXTERIOR:
                return EnumInteriorDoorType.DOOR_FALLOUT_SHELTER_EXTERIOR;//return EnumInteriorDoorType.DOOR_SHALKA_EXTERIOR;
            //case DOOR_SHALKA_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_BOOTH_EXTERIOR;
            //case DOOR_BOOTH_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_STEVE_EXTERIOR;
            //case DOOR_STEVE_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_FALLOUT_SHELTER_EXTERIOR;
            case DOOR_FALLOUT_SHELTER_EXTERIOR:
                return EnumInteriorDoorType.DOOR_BASIC_BOX;//EnumInteriorDoorType.DOOR_RANI_EXTERIOR;
            //case DOOR_RANI_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_CLOCK_EXTERIOR;
            //case DOOR_CLOCK_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_BASIC_BOX;
        }
        return EnumInteriorDoorType.DOOR_BASIC_BOX;
    }

    public EnumInteriorDoorType getCurrentInteriorDoor() {
        return currentinteriordoor;
    }

    public EnumInteriorDoorType getLastInteriorDoor() {
        switch (currentinteriordoor) {
            case DOOR_BASIC_BOX:
                return EnumInteriorDoorType.DOOR_FALLOUT_SHELTER_EXTERIOR;//EnumInteriorDoorType.DOOR_CLOCK_EXTERIOR;
            case DOOR_MINT_BOX:
                return EnumInteriorDoorType.DOOR_BASIC_BOX;
            //case DOOR_CORAL_BOX:
            //    return EnumInteriorDoorType.DOOR_MINT_BOX;
            //case DOOR_POSTER_BOX:
            //    return EnumInteriorDoorType.DOOR_CORAL_BOX;
            //case DOOR_BAKER_BOX:
            //    return EnumInteriorDoorType.DOOR_POSTER_BOX;
            //case DOOR_TYPE_40_TT_CAPSULE:
            //    return EnumInteriorDoorType.DOOR_BAKER_BOX;
            //case DOOR_HELLBENT_TT_CAPSULE:
            //    return EnumInteriorDoorType.DOOR_TYPE_40_TT_CAPSULE;
            //case DOOR_NUKA_COLA_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_HELLBENT_TT_CAPSULE;
            //case DOOR_SIEGE_MODE:
            //    return EnumInteriorDoorType.DOOR_SIEGE_MODE;
            //case DOOR_ARCADE_CABINET_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_NUKA_COLA_EXTERIOR;
            //case DOOR_CUSHING_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_ARCADE_CABINET_EXTERIOR;
            //case DOOR_CLASSIC_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_CUSHING_EXTERIOR;
            //case DOOR_HARTNELL_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_CLASSIC_EXTERIOR;
            //case DOOR_HUDOLIN_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_BASIC_BOX;//EnumInteriorDoorType.DOOR_HARTNELL_EXTERIOR;
            //case DOOR_TX3_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_HUDOLIN_EXTERIOR;
            case DOOR_TARDIM_EXTERIOR:
                return EnumInteriorDoorType.DOOR_MINT_BOX;//return EnumInteriorDoorType.DOOR_TX3_EXTERIOR;
            //case DOOR_SHALKA_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_TARDIM_EXTERIOR;
            //case DOOR_BOOTH_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_SHALKA_EXTERIOR;
            //case DOOR_STEVE_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_BOOTH_EXTERIOR;
            case DOOR_FALLOUT_SHELTER_EXTERIOR:
                return EnumInteriorDoorType.DOOR_TARDIM_EXTERIOR;
            //case DOOR_RANI_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_FALLOUT_SHELTER_EXTERIOR;
            //case DOOR_CLOCK_EXTERIOR:
            //    return EnumInteriorDoorType.DOOR_RANI_EXTERIOR;
        }
        return EnumInteriorDoorType.DOOR_BASIC_BOX;
    }

    public void setInteriorDoor(EnumInteriorDoorType interiordoor) {
        this.currentinteriordoor = interiordoor;
    }

    public EnumInteriorDoorType getInteriorDoor() {
        return this.currentinteriordoor;
    }

    public void setPortal(Portal portal) {
        if (portal != null) {
            this.portal = PortalManipulation.completeBiWayPortal(portal, Portal.entityType);
            this.portal.reloadAndSyncToClient();
            syncToClient();
        }
    }



    public EnumDoorState getNextDoorState() {
        switch (currentstate) {
            case CLOSED:
                return EnumDoorState.FIRST;
            case FIRST:
                return EnumDoorState.BOTH;
            case BOTH:
                return EnumDoorState.CLOSED;
            case LOCKED:
                return EnumDoorState.CLOSED;
        }
        return EnumDoorState.CLOSED;
    }

    public Direction getFacing() {
       return this.getBlockState().getValue(BasicInteriorDoorBlock.FACING);
    }

    public void setLockedState(Boolean lockedState, EnumDoorState state) {
        this.lockedState = lockedState;
        this.currentstate = state;
    }

    public void keyUsedOnTardisDoor(ItemUseContext context, BlockPos blockpos, BlockState blockstate, Block block) {
        System.out.println(lockedState);
        PlayerEntity playerEntity = context.getPlayer();
        ItemStack itemStack = playerEntity.getMainHandItem();
        Item item = playerEntity.getMainHandItem().getItem();
        ServerWorld tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        BlockPos interiorDoorPos = linked_tardis.interior_door_position;
        ServerWorld exteriorDimension = AIT.server.getLevel(linked_tardis.exterior_dimension);

        if(block instanceof BasicInteriorDoorBlock && item == AITItems.GOLDEN_TARDIS_KEY.get()) {
            TardisTileEntity tardisTileEntity = (TardisTileEntity) exteriorDimension.getBlockEntity(linked_tardis.exterior_position);
            TARDISKey tardisKey1 = (TARDISKey) item;
            System.out.println(TARDISKey.getTardisId(itemStack) + " || " + linked_tardis.tardisID);
            if(tardisTileEntity != null) {
                if (TARDISKey.getTardisId(itemStack).equals(linked_tardis.tardisID)) {
                    lockedState = true;
                    if (tardisTileEntity != null) {
                        tardisTileEntity.setLockedState(true, EnumDoorState.CLOSED);
                        tardisWorld.playSound(null, interiorDoorPos, AITSounds.TARDIS_LOCK.get(), SoundCategory.MASTER, 7, 1);
                        syncToClient();
                    }
            /*if(interiorDoorPos != null) {
                BasicInteriorDoorTile doorTile = (BasicInteriorDoorTile) tardisWorld.getBlockEntity(interiorDoorPos);
                if (doorTile != null) {
                    doorTile.setLockedState(true, EnumDoorState.CLOSED);
                }
            }*/
                    this.currentstate = EnumDoorState.CLOSED;
                    playerEntity.displayClientMessage(new TranslationTextComponent(
                            "Door is locked!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
                    level.playSound(null, blockpos, AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                    tardisWorld.playSound(null, linked_tardis.interior_door_position, AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                    syncToClient();
                } else {
                    playerEntity.displayClientMessage(new TranslationTextComponent(
                            "This TARDIS is not yours!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
                }
            } else {
                playerEntity.displayClientMessage(new TranslationTextComponent(
                        "Tardis is in flight!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
            }
        }
        if (block instanceof BasicInteriorDoorBlock && item == AITItems.GOLDEN_TARDIS_KEY.get() && lockedState == true && playerEntity.isCrouching()) {
            TardisTileEntity tardisTileEntity = (TardisTileEntity) exteriorDimension.getBlockEntity(linked_tardis.exterior_position);
            TARDISKey tardisKey1 = (TARDISKey) item;
            if(TARDISKey.getTardisId(itemStack) != null) {
                if (tardisTileEntity != null) {
                    if (TARDISKey.getTardisId(itemStack).equals(linked_tardis.tardisID)) {
                        lockedState = false;
                        if (tardisTileEntity != null) {
                            tardisTileEntity.setLockedState(false, EnumDoorState.CLOSED);
                            tardisWorld.playSound(null, interiorDoorPos, AITSounds.TARDIS_LOCK.get(), SoundCategory.MASTER, 7, 1);
                            syncToClient();
                        }
                        playerEntity.displayClientMessage(new TranslationTextComponent(
                                "Door is unlocked!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
                        level.playSound(null, blockpos, AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                        tardisWorld.playSound(null, linked_tardis.interior_door_position, AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                        syncToClient();
                    } else {
                        playerEntity.displayClientMessage(new TranslationTextComponent(
                                "This TARDIS is not yours!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
                    }
                } else {
                    playerEntity.displayClientMessage(new TranslationTextComponent(
                            "Tardis is in flight!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
                }
            } else {
                playerEntity.displayClientMessage(new TranslationTextComponent(
                        "Key is not linked!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
            }
        }
            /*if(interiorDoorPos != null) {
                BasicInteriorDoorTile doorTile = (BasicInteriorDoorTile) tardisWorld.getBlockEntity(interiorDoorPos);
                if (doorTile != null) {
                    doorTile.setLockedState(false, EnumDoorState.CLOSED);
                }
            }*/
    }

    public void setDoorState(EnumDoorState state) {
        this.currentstate = state;
    }

    @Override public void tick() {
        if(this.isRemoved()) {
            this.portal.remove();
        }
        //AxisAlignedBB aabb = getTardisInteriorDoorCollider(getBlockState()).bounds();
        //aabb = aabb.inflate(0.8D/16D).move(getBlockPos().getX(), getBlockPos().getY(), getBlockPos().getZ());
        //this.level.getEntities(null, aabb).forEach(this::entityInside);
        if(linked_tardis != null) {
            if (linked_tardis.exterior_dimension != null) {
                ServerWorld world = AIT.server.getLevel(linked_tardis.exterior_dimension);
                if (this.getLevel() != null) {
                    if (!this.getLevel().isClientSide) {
                        if (this.portal == null) {
                            if (this.portalUUID != null) {
                                ServerWorld serverworld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
                                this.portal = (Portal) serverworld.getEntity(this.portalUUID);
                            }
                        } else if (this.getLevel().getEntity(this.portal.getId()) == null) {
                            ServerWorld tardisexteriordim = AIT.server.getLevel(linked_tardis.exterior_dimension);
                            ServerWorld tardisinteriordim = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
                            ChunkPos chunkPos = new ChunkPos(this.getBlockPos());
                            ForgeChunkManager.forceChunk(tardisexteriordim, AIT.MOD_ID, this.getBlockPos(), chunkPos.x, chunkPos.z, true, true);
                            ForgeChunkManager.forceChunk(tardisinteriordim, AIT.MOD_ID, linked_tardis.interior_door_position, chunkPos.x, chunkPos.z, true, true);
                            PortalAPI.spawnServerEntity(this.portal);
                            syncToClient();
                        }
                        if (this.portal != null) {
                            TardisTileEntity tardisTileEntity = (TardisTileEntity) world.getBlockEntity(linked_tardis.exterior_position);
                            if (tardisTileEntity != null) {
                                if (tardisTileEntity != null) {
                                    this.portal.setDestination(new Vector3d(linked_tardis.exterior_position.getX(), linked_tardis.exterior_position.getY(), linked_tardis.exterior_position.getZ()));
                                }
                            }
                        }
                        if (this.currentstate == EnumDoorState.CLOSED) {
                            if (this.portal != null) {
                                this.portal.remove();
                                this.portal = null;
                                this.portalUUID = null;
                            }
                        }
                    }
                }
            }
        }
        if (currentState() != previousstate) {
            rightDoorRotation = currentState() == FIRST ? 0.0f : 87.5f;
            leftDoorRotation = currentState() == FIRST ? 0.0f : (currentState() == BOTH ? 0.0f : 87.5f);
        }
        if (currentState() != CLOSED) {
            if (rightDoorRotation < 87.5f) {
                rightDoorRotation += 5.0f;
            } else {
                rightDoorRotation = 87.5f;
            }
        } else {
            if (leftDoorRotation > 0.0f && rightDoorRotation > 0.0f) {
                leftDoorRotation -= 15.0f;
                rightDoorRotation -= 15.0f;
            }
        }
        if (currentState() == BOTH) {
            if (leftDoorRotation < 87.5f) {
                leftDoorRotation += 5.0f;
            } else {
                leftDoorRotation = 87.5f;
            }
        }
        if(currentState() == CLOSED) {
            if(leftDoorRotation == -2.5f) {
                leftDoorRotation = 0.0f;
            }
            if(rightDoorRotation == -2.5f) {
                rightDoorRotation = 0.0f;
            }
        }
        previousstate = currentState();
    }

    @Override public void setRemoved() {
        super.setRemoved();
        if (this.portal != null) {
            this.portal.remove();
            this.portal = null;
            this.portalUUID = null;
        }
        if(this.getLevel() != null) {
            if(!this.getLevel().isClientSide) {
                ServerWorld overworld = (ServerWorld) this.getLevel();
                ChunkPos chunkPos = new ChunkPos(this.getBlockPos());
                ForgeChunkManager.forceChunk(overworld, AIT.MOD_ID, this.getBlockPos(), chunkPos.x, chunkPos.z, false, false);
            }
        }
        syncToClient();
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }

    //private void entityInside(Entity entity) {
    //    World world = entity.level;
    //    if (!world.isClientSide()) {
    //        if (linked_tardis != null) {
    //            if (currentstate != CLOSED && entity instanceof ServerPlayerEntity) {
    //                ServerWorld exteriorWorld = AIT.server.getLevel(linked_tardis.exterior_dimension);
    //                assert exteriorWorld != null;
    //                ForgeChunkManager.forceChunk(exteriorWorld, AIT.MOD_ID, linked_tardis.exterior_position, 0, 0, true, true);
    //                linked_tardis.teleportToExterior((PlayerEntity) entity);
    //                syncToClient();
    //            }
    //        }
    //    }
    //}

    public Tardis getInteriorID() {
        return linked_tardis;
    }

    private VoxelShape getTardisInteriorDoorCollider(BlockState blockstate) {
        switch(blockstate.getValue(BasicInteriorDoorBlock.FACING)) {
            case NORTH:
                return BasicInteriorDoorBlock.NORTH_AABB;
            case EAST:
                return BasicInteriorDoorBlock.EAST_AABB;
            case SOUTH:
                return BasicInteriorDoorBlock.SOUTH_AABB;
            case WEST:
                return BasicInteriorDoorBlock.WEST_AABB;
            default:
                throw new RuntimeException("Invalid facing direction in getCollisionShape() " +
                        "//HOW THE HECK DID YOU GET HERE??");
        }
    }

    public BasicInteriorDoorTile() {
        super(AITTiles.BASIC_INTERIOR_DOOR_TILE_ENTITY_TYPE.get());
    }

    public ActionResultType useOn(World world, PlayerEntity playerentity, BlockPos blockpos, Hand hand) {
        if (!world.isClientSide) {
            this.linked_tardis = AIT.tardisManager.getTardis(linked_tardis.tardisID);
            if (lockedState != true) {
                BlockState blockstate = world.getBlockState(blockpos);
                Block block = blockstate.getBlock();
                if (block instanceof BasicInteriorDoorBlock && hand == Hand.MAIN_HAND && !world.isClientSide) {
                    this.setDoorState(this.getNextDoorState());
                    linked_tardis.setExteriorDoorState(this.currentstate);
                    TardisTileEntity tardisTileEntity = (TardisTileEntity) AIT.server.getLevel(linked_tardis.exterior_dimension).getBlockEntity(linked_tardis.exterior_position);
                    tardisTileEntity.syncToClient();
                    System.out.println(tardisTileEntity.currentState());
                    if (this.currentstate == EnumDoorState.CLOSED)
                        world.playSound(null, blockpos, AITSounds.POLICE_BOX_CLOSE.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                    if (this.currentstate == EnumDoorState.FIRST)
                        world.playSound(null, blockpos, AITSounds.POLICE_BOX_OPEN.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                    if (this.currentstate == EnumDoorState.BOTH)
                        world.playSound(null, blockpos, AITSounds.POLICE_BOX_OPEN.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                    syncToClient();
                }
            } else {
                this.currentstate = EnumDoorState.CLOSED;
                playerentity.displayClientMessage(new TranslationTextComponent(
                        "Door is locked!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
                world.playSound(null, blockpos, AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                syncToClient();
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Override public void load(BlockState pState, CompoundNBT nbt) {
        if(nbt.contains("portalID")) {
            this.portalUUID = nbt.getUUID("portalID");
        }
        this.currentstate = EnumDoorState.values()[nbt.getInt("currentState")];
        this.isItSnowing = nbt.getBoolean("isItSnowing");
        this.currentinteriordoor = EnumInteriorDoorType.values()[nbt.getInt("currentinteriordoor")];
        this.lockedState = nbt.getBoolean("lockedState");
        this.leftDoorRotation = nbt.getFloat("leftDoorRotation");
        this.rightDoorRotation = nbt.getFloat("rightDoorRotation");
        if (nbt.contains("tardis_id")) {
            this.linked_tardis = AIT.tardisManager.getTardis(nbt.getUUID("tardis_id"));
        }
        super.load(pState, nbt);
    }
    @Override public CompoundNBT save(CompoundNBT nbt) {
        if(this.portal != null) {
            nbt.putUUID("portalID", this.portal.getUUID());
        }
        nbt.putInt("currentState", this.currentstate.ordinal());
        nbt.putBoolean("isItSnowing", this.isItSnowing);
        nbt.putInt("currentinteriordoor", this.currentinteriordoor.ordinal());
        nbt.putFloat("leftDoorRotation", this.leftDoorRotation);
        nbt.putFloat("rightDoorRotation", this.rightDoorRotation);
        if (this.linked_tardis != null) {
            nbt.putUUID("tardis_id", this.linked_tardis.tardisID);
        }
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
}

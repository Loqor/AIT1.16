package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.entities.K9Entity;
import com.mdt.ait.common.items.TARDISKey;
import com.mdt.ait.core.init.*;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.enums.EnumMatState;
import com.mdt.ait.core.init.enums.EnumRotorState;
import com.mdt.ait.tardis.Tardis;
import com.mdt.ait.tardis.special.DematTransit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.dispenser.IPosition;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.world.ForgeChunkManager;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.UUID;

import static com.mdt.ait.common.blocks.TardisBlock.FACING;
import static com.mdt.ait.core.init.enums.EnumDoorState.*;

public class TardisTileEntity extends TileEntity implements ITickableTileEntity {

    /*
    Updated for Tardis Rewrite
     */

    public float leftDoorRotation = 0;
    public float rightDoorRotation = 0;
    public float nukaDoorRotation = 0;
    public int arcadeDoorDistance = 0;

    public boolean isExistingTardis = false;
    public float spinny = 0;
    public int alphaForLightMap = 15728880;
    public EnumRotorState currentfloatstate = EnumRotorState.MOVING;
    public float floatTick;
    protected EnumDoorState currentstate = CLOSED;
    public EnumDoorState previousstate = CLOSED;
    public UUID linked_tardis_id;
    public Tardis linked_tardis;
    protected EnumMatState matState = EnumMatState.SOLID;
    protected EnumExteriorType currentexterior = EnumExteriorType.BASIC_BOX;
    private float alpha = 1;
    private int ticks, pulses;

    public DematTransit dematTransit;
    private int run_once = 0;
    private int run_once_remat = 0;
    public TARDISKey tardisKey;
    public boolean lockedState = false;
    // aaaa

    public EnumExteriorType getNextExterior() {
        switch (currentexterior) {
            case BASIC_BOX:
                return EnumExteriorType.MINT_BOX;
            case MINT_BOX:
                return EnumExteriorType.CORAL_BOX;
            case CORAL_BOX:
                return EnumExteriorType.POSTER_BOX;
            case POSTER_BOX:
                return EnumExteriorType.BAKER_BOX;
            case BAKER_BOX:
                return EnumExteriorType.TYPE_40_TT_CAPSULE;
            case TYPE_40_TT_CAPSULE:
                return EnumExteriorType.HELLBENT_TT_CAPSULE;
            case HELLBENT_TT_CAPSULE:
                return EnumExteriorType.NUKA_COLA_EXTERIOR;
            case NUKA_COLA_EXTERIOR:
                return EnumExteriorType.ARCADE_CABINET_EXTERIOR;
            case SIEGE_MODE:
                return EnumExteriorType.BASIC_BOX;
            case ARCADE_CABINET_EXTERIOR:
                return EnumExteriorType.CUSHING_EXTERIOR;
            case CUSHING_EXTERIOR:
                return EnumExteriorType.CLASSIC_EXTERIOR;
            case CLASSIC_EXTERIOR:
                return EnumExteriorType.HARTNELL_EXTERIOR;
            case HARTNELL_EXTERIOR:
                return EnumExteriorType.HUDOLIN_EXTERIOR;
            case HUDOLIN_EXTERIOR:
                return EnumExteriorType.BASIC_BOX;
        }
        return EnumExteriorType.BASIC_BOX;
    }

    public void setLockedState(Boolean lockedState) {
        this.lockedState = lockedState;
    }

    public EnumExteriorType getLastExterior() {
        switch (currentexterior) {
            case BASIC_BOX:
                return EnumExteriorType.HUDOLIN_EXTERIOR;
            case MINT_BOX:
                return EnumExteriorType.BASIC_BOX;
            case CORAL_BOX:
                ;
                return EnumExteriorType.MINT_BOX;
            case POSTER_BOX:
                return EnumExteriorType.CORAL_BOX;
            case BAKER_BOX:
                return EnumExteriorType.POSTER_BOX;
            case TYPE_40_TT_CAPSULE:
                return EnumExteriorType.BAKER_BOX;
            case HELLBENT_TT_CAPSULE:
                return EnumExteriorType.TYPE_40_TT_CAPSULE;
            case NUKA_COLA_EXTERIOR:
                return EnumExteriorType.HELLBENT_TT_CAPSULE;
            case SIEGE_MODE:
                return EnumExteriorType.SIEGE_MODE;
            case ARCADE_CABINET_EXTERIOR:
                return EnumExteriorType.NUKA_COLA_EXTERIOR;
            case CUSHING_EXTERIOR:
                return EnumExteriorType.ARCADE_CABINET_EXTERIOR;
            case CLASSIC_EXTERIOR:
                return EnumExteriorType.CUSHING_EXTERIOR;
            case HARTNELL_EXTERIOR:
                return EnumExteriorType.CLASSIC_EXTERIOR;
            case HUDOLIN_EXTERIOR:
                return EnumExteriorType.HARTNELL_EXTERIOR;
        }
        return EnumExteriorType.BASIC_BOX;
    }

    public EnumMatState getNextMatState() {
        switch (matState) {
            case SOLID:
                return EnumMatState.DEMAT;
            case DEMAT:
                return EnumMatState.REMAT;
            case REMAT:
                return EnumMatState.SOLID;
        }
        return EnumMatState.SOLID;
    }

    public void setExterior(EnumExteriorType exterior) {
        this.currentexterior = exterior;
    }

    public void setMatState(EnumMatState matState) {
        this.matState = matState;
    }

    public void dematTardis(DematTransit dematTransit) {
        setMatState(EnumMatState.DEMAT);
        this.dematTransit = dematTransit;

    }

    public TardisTileEntity() {
        super(AITTiles.TARDIS_TILE_ENTITY_TYPE.get());
    }

    public TardisTileEntity(TileEntityType entity) {
        super(entity);
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(50, 50, 50);
    }

    public float getAlpha() {
        return alpha;
    }

    public boolean isItDark() {
        Random random = getLevel().random;
        if (level.getBrightness(LightType.SKY, worldPosition) > random.nextInt(32)) {
            return false;
        } else {
            int i = level.isThundering() ? level.getMaxLocalRawBrightness(worldPosition, 10) : level.getMaxLocalRawBrightness(worldPosition);
            return i <= random.nextInt(8);
        }
    }

    @Override
    public void tick() {
        //System.out.println(linked_tardis_id);
        isItDark();
        //System.out.println(currentexterior);
        EnumMatState materialState = EnumMatState.values()[this.serializeNBT().getInt("matState")];
        int mattype = this.serializeNBT().getInt("matState");
        if(materialState == EnumMatState.DEMAT) {
            this.currentstate = EnumDoorState.CLOSED;
            //System.out.println("uh, is this working at all? " + materialState);
            if (ticks % 60 < 30) {
                if (pulses <= 2)
                    this.alpha -= 0.01;
                else this.alpha -= 0.02;
            } else {
                this.alpha += 0.01;
            }

            if (ticks % 60 == 0)
                ++this.pulses;

            ++ticks;
            if (ticks >= 257) {
                this.dematTransit.finishedDematAnimation();
                // Finish
            }
            if(run_once == 0) {
                iDontKnow();
                run_once = 1;
            }
        }
        if(materialState == EnumMatState.REMAT) {
            //System.out.println("uh, is this working at all? " + materialState);
            if (ticks % 60 < 30) {
                if (pulses >= 1.25)
                    this.alpha += 0.01;
                else this.alpha += 0.02;
            } else {
                this.alpha -= 0.01;
            }
            if (ticks % 60 == 0)
                ++this.pulses;
            ++ticks;
            if (ticks >= 180) {
                //ServerWorld forceWorld = AIT.server.getLevel(this.linked_tardis.exterior_dimension);
                //ForgeChunkManager.forceChunk(forceWorld, AIT.MOD_ID, this.linked_tardis.exterior_position, 0, 0, true, true);
                matState = EnumMatState.SOLID;
                System.out.println("Finished");
                this.dematTransit.finished();
                //ForgeChunkManager.forceChunk(forceWorld, AIT.MOD_ID, this.linked_tardis.exterior_position, 0, 0, false, false);
            }
            if(run_once_remat == 0) {
                iDontKnowRemat();
                run_once_remat = 1;
            }
        }
        if(materialState == EnumMatState.SOLID) {
            //System.out.println("uh, is this working at all? " + materialState);
            this.alpha = 1;
            ticks = 0;
            run_once = 0;
            pulses = 0;
            run_once_remat = 0;
        }

        //System.out.println(previousstate + " " + currentState() + " " + getNextDoorState());
        if (currentState() != previousstate) {
            rightDoorRotation = currentState() == FIRST ? 0.0f : 87.5f;
            nukaDoorRotation = currentState() == FIRST ? 0.0f : 44.25f;
            arcadeDoorDistance = currentState() == FIRST ? 0 : 2;
            leftDoorRotation = currentState() == FIRST ? 0.0f : (currentState() == BOTH ? 0.0f : 87.5f);
        }
        if (currentState() != CLOSED) {
            if (rightDoorRotation < 87.5f) {
                rightDoorRotation += 5.0f;
            } else {
                rightDoorRotation = 87.5f;
            }
            if (nukaDoorRotation < 88.5f) {
                nukaDoorRotation += 5.0f;
            } else {
                nukaDoorRotation = 88.5f;
            }
            if (arcadeDoorDistance < 2) {
                arcadeDoorDistance += 1;
            } else {
                arcadeDoorDistance = 2;
            }
            if (currentState() == BOTH) {
                if (leftDoorRotation < 87.5f) {
                    leftDoorRotation += 5.0f;
                } else {
                    leftDoorRotation = 87.5f;
                }
                if(currentexterior == EnumExteriorType.NUKA_COLA_EXTERIOR) {
                    currentstate = CLOSED;
                }
                if(currentexterior == EnumExteriorType.ARCADE_CABINET_EXTERIOR) {
                    currentstate = CLOSED;
                }
            }
        } else {
            if (leftDoorRotation > 0.0f && rightDoorRotation > 0.0f) {
                leftDoorRotation -= 15.0f;
                rightDoorRotation -= 15.0f;
            }
            if(nukaDoorRotation > 0.0f) {
                nukaDoorRotation -= 15.0f;
            }
            if(arcadeDoorDistance > 0) {
                arcadeDoorDistance -= 1;
            }
        }
        if(currentState() == CLOSED) {
            if(leftDoorRotation == -2.5f) {
                leftDoorRotation = 0.0f;
            }
            if(rightDoorRotation == -2.5f) {
                rightDoorRotation = 0.0f;
            }
            if(nukaDoorRotation <= -2.5f) {
                nukaDoorRotation = 0.0f;
            }
            if(arcadeDoorDistance <= -1) {
                arcadeDoorDistance = 0;
            }
        }
        //System.out.println("Right Door Rotation: "+ rightDoorRotation + " || " + "Left Door Rotation: " + leftDoorRotation);
        previousstate = currentState();
    }

    public void iDontKnow() {
        level.playSound(null, worldPosition, AITSounds.TARDIS_TAKEOFF.get(), SoundCategory.MASTER, 1.0F, 1.0F);
    }

    public void iDontKnowRemat() {
        level.playSound(null, worldPosition, AITSounds.TARDIS_LANDING.get(), SoundCategory.MASTER, 1.0F, 1.0F);
    }

    public void setDoorState(EnumDoorState state) {
        this.currentstate = state;
    }

    private VoxelShape getTardisCollider(BlockState blockstate) {
        switch (blockstate.getValue(FACING)) {
            case NORTH:
                return TardisBlock.NORTH_AABB;
            case EAST:
                return TardisBlock.EAST_AABB;
            case SOUTH:
                return TardisBlock.SOUTH_AABB;
            case WEST:
                return TardisBlock.WEST_AABB;
            default:
                throw new RuntimeException("Invalid facing direction in getCollisionShape() " +
                        "//HOW THE HECK DID YOU GET HERE??");
        }
    }

    public EnumDoorState currentState() {
        return this.currentstate;
    }

    public EnumExteriorType currentExterior() {
        return this.currentexterior;
    }

    public EnumDoorState getNextDoorState() {
        switch (currentstate) {
            case CLOSED:
                return FIRST;
            case FIRST:
                return BOTH;
            case BOTH:
                return CLOSED;
            case LOCKED:
                return CLOSED;
        }
        return CLOSED;
    }

    public void setBlock(final BlockState block) {
        this.block = block;
    }

    private BlockState block;

    public ActionResultType useOn(World world, PlayerEntity playerentity, BlockPos blockpos, Hand hand) {
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        ItemStack key = playerentity.getMainHandItem();
        if(this.matState == EnumMatState.SOLID) {
            if(lockedState != true) {
                if (block instanceof TardisBlock && hand == Hand.MAIN_HAND && !world.isClientSide) {
                    this.setDoorState(this.getNextDoorState());
                    linked_tardis.setInteriorDoorState(this.currentstate);
                    if (currentexterior != EnumExteriorType.NUKA_COLA_EXTERIOR) {
                        if (this.currentstate == CLOSED)
                            world.playSound(null, blockpos, AITSounds.POLICE_BOX_CLOSE.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                        if (this.currentstate == FIRST)
                            world.playSound(null, blockpos, AITSounds.POLICE_BOX_OPEN.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                        if (this.currentstate == BOTH)
                            world.playSound(null, blockpos, AITSounds.POLICE_BOX_OPEN.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                        syncToClient();
                    } else {
                        if (currentState() != FIRST)
                            world.playSound(null, blockpos, AITSounds.POLICE_BOX_CLOSE.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                        if (currentState() == FIRST)
                            world.playSound(null, blockpos, AITSounds.POLICE_BOX_OPEN.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                        syncToClient();
                    }
                }
            } else {
                this.currentstate = EnumDoorState.CLOSED;
                playerentity.displayClientMessage(new TranslationTextComponent(
                        "Door is locked!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
                level.playSound(null, blockpos, AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                syncToClient();
            }
        }
        return ActionResultType.SUCCESS;
    }

    public EnumMatState getMatState() {
        return this.matState;
    }

    public void entityInside(Entity entity) {
        World world = entity.level;
        if (linked_tardis == null) {
            if (!world.isClientSide) { // Server side only
                this.linked_tardis = AIT.tardisManager.getTardis(linked_tardis_id);
                System.out.println(this.linked_tardis);
            }
        }
        if (!world.isClientSide()) {
            if ((matState == EnumMatState.REMAT && entity instanceof ServerPlayerEntity) || (currentstate != CLOSED && entity instanceof ServerPlayerEntity)) {
                if (linked_tardis == null) {
                    System.out.println("MMMMM BALL IN THE BAG AND THIS IS NULL"); // HOLY SHIT I FIXED IT
                    return;
                }

                ServerWorld tardis_world = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
                if (tardis_world != null) {
                    ForgeChunkManager.forceChunk(tardis_world, AIT.MOD_ID, linked_tardis.center_position, 0, 0, true, true);
                    linked_tardis.teleportToInterior((PlayerEntity) entity);
                    syncToClient();
                }
            }
        }
    }

    public void useOnTardis(ItemUseContext context, BlockPos blockpos, BlockState blockstate, Block block) {
        PlayerEntity playerentity = context.getPlayer();
        Item item = playerentity.getMainHandItem().getItem();

        if (block instanceof TardisBlock && (item == AITItems.TENNANT_SONIC.get() || item == AITItems.WHITTAKER_SONIC.get()) && playerentity.isCrouching()) {
            currentexterior = getNextExterior();
            AIT.tardisManager.getTardis(linked_tardis_id).setExteriorType(currentExterior());
            syncToClient();
        }
    }

    public void keyUsedOnTardis(ItemUseContext context, BlockPos blockpos, BlockState blockstate, Block block) {
        System.out.println(lockedState);
        PlayerEntity playerEntity = context.getPlayer();
        Item item = playerEntity.getMainHandItem().getItem();
        Tardis tardis = AIT.tardisManager.getTardis(linked_tardis_id);
        ServerWorld tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        BlockPos interiorDoorPos = tardis.interior_door_position;

        if(block instanceof TardisBlock && item == AITItems.GOLDEN_TARDIS_KEY.get()) {
            TARDISKey tardisKey1 = (TARDISKey) item;
            if (tardisKey1.tardisID == linked_tardis_id) {
                lockedState = true;
            /*if(interiorDoorPos != null) {
                BasicInteriorDoorTile doorTile = (BasicInteriorDoorTile) tardisWorld.getBlockEntity(interiorDoorPos);
                if (doorTile != null) {
                    doorTile.setLockedState(true, EnumDoorState.CLOSED);
                }
            }*/
                this.currentstate = CLOSED;
                playerEntity.displayClientMessage(new TranslationTextComponent(
                        "Door is locked!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
                level.playSound(null, blockpos, AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                tardisWorld.playSound(null, tardis.interior_door_position, AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                syncToClient();
            } else {
                playerEntity.displayClientMessage(new TranslationTextComponent(
                        "This TARDIS is not yours!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
            }

        }
        if (block instanceof TardisBlock && item == AITItems.GOLDEN_TARDIS_KEY.get() && lockedState == true && playerEntity.isCrouching()) {
            TARDISKey tardisKey1 = (TARDISKey) item;
            if (tardisKey1.tardisID == linked_tardis_id) {
                lockedState = false;
                playerEntity.displayClientMessage(new TranslationTextComponent(
                        "Door is unlocked!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
                level.playSound(null, blockpos, AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                tardisWorld.playSound(null, tardis.interior_door_position, AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                syncToClient();
            } else {
                playerEntity.displayClientMessage(new TranslationTextComponent(
                        "This TARDIS is not yours!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
            }
            }
            /*if(interiorDoorPos != null) {
                BasicInteriorDoorTile doorTile = (BasicInteriorDoorTile) tardisWorld.getBlockEntity(interiorDoorPos);
                if (doorTile != null) {
                    doorTile.setLockedState(false, EnumDoorState.CLOSED);
                }
            }*/

    }

    public void DematTardis(ItemUseContext context, BlockPos blockpos, BlockState blockstate, Block block) {
        PlayerEntity playerentity = context.getPlayer();
        Item item = playerentity.getMainHandItem().getItem();

        if (block instanceof TardisBlock && item == AITItems.DEMATTER_STICK.get()) {
            matState = getNextMatState();
            syncToClient();
        }
    }

    public void lastExteriorFromMonitor() {
        currentexterior = getLastExterior();
        syncToClient();
    }

    public void nextExteriorFromMonitor() {
        currentexterior = getNextExterior();
        AIT.tardisManager.getTardis(linked_tardis_id).setExteriorType(currentExterior());
        syncToClient();
    }

    @Override
    public void load(BlockState pState, CompoundNBT nbt) {
        this.currentexterior = EnumExteriorType.values()[nbt.getInt("currentexterior")];
        this.currentstate = EnumDoorState.values()[nbt.getInt("currentstate")];
        this.matState = EnumMatState.values()[nbt.getInt("matState")];
        this.currentfloatstate = EnumRotorState.values()[nbt.getInt("currentFloatingState")];
        this.linked_tardis_id = nbt.getUUID("tardisUUID");
        if (level != null) {
            if (!level.isClientSide()) { // Server Side Only
                this.linked_tardis = AIT.tardisManager.getTardis(linked_tardis_id);
            }
        }
        if (this.linked_tardis_id == null) {
            System.out.println("Linked Tardis ID is null");
        }
        this.leftDoorRotation = nbt.getFloat("leftDoorRotation");
        this.rightDoorRotation = nbt.getFloat("rightDoorRotation");
        this.nukaDoorRotation = nbt.getFloat("nukaDoorRotation");
        this.lockedState = nbt.getBoolean("lockedState");
        super.load(pState, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putInt("currentexterior", this.currentexterior.ordinal());
        nbt.putInt("currentstate", this.currentstate.ordinal());
        nbt.putInt("matState", this.matState.ordinal());
        nbt.putInt("currentFloatingState", this.currentfloatstate.ordinal());
        if (this.linked_tardis_id != null) {
            nbt.putUUID("tardisUUID", this.linked_tardis_id);
        }
        nbt.putFloat("leftDoorRotation", this.leftDoorRotation);
        nbt.putFloat("rightDoorRotation", this.rightDoorRotation);
        nbt.putFloat("nukaDoorRotation", this.nukaDoorRotation);
        nbt.putBoolean("lockedState", this.lockedState);
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

package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.AITItems;
import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.enums.EnumMatState;
import com.mdt.ait.tardis.Tardis;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.world.ForgeChunkManager;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import javax.annotation.Nonnull;
import java.util.UUID;

import static com.mdt.ait.common.blocks.TardisBlock.FACING;
import static com.mdt.ait.core.init.enums.EnumDoorState.*;

public class TardisTileEntity extends TileEntity implements ITickableTileEntity {

    /*
    Updated for OldTardis Rewrite
     */

    public float leftDoorRotation = 0;
    public float rightDoorRotation = 0;
    protected EnumDoorState currentstate = CLOSED;
    public EnumDoorState previousstate = CLOSED;
    public UUID linked_tardis_id;
    public Tardis linked_tardis;
    public EnumMatState matState = EnumMatState.SOLID;
    protected EnumExteriorType currentexterior = EnumExteriorType.BASIC_BOX;

    public EnumExteriorType getNextExterior() {
        switch (currentexterior) {
            case BASIC_BOX:
                return EnumExteriorType.MINT_BOX;
            case MINT_BOX:
                return EnumExteriorType.CORAL_BOX;
            case CORAL_BOX:
                return EnumExteriorType.BASIC_BOX;
        }
        return EnumExteriorType.BASIC_BOX;
    }

    public EnumMatState getNextMatState() {
        switch (matState) {
            case DEMAT:
                return EnumMatState.REMAT;
            case REMAT:
                return EnumMatState.SOLID;
            case SOLID:
                return EnumMatState.DEMAT;
        }
        return EnumMatState.SOLID;
    }

    public void setExterior(EnumExteriorType exterior) {
        this.currentexterior = exterior;
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

    @Override
    public void tick() {
        //System.out.println(previousstate + " " + currentState() + " " + getNextDoorState());
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
            if (currentState() == BOTH) {
                if (leftDoorRotation < 87.5f) {
                    leftDoorRotation += 5.0f;
                } else {
                    leftDoorRotation = 87.5f;
                }
            }
        } else {
            if (leftDoorRotation > 0.0f && rightDoorRotation > 0.0f) {
                leftDoorRotation -= 15.0f;
                rightDoorRotation -= 15.0f;
            }
        }
        previousstate = currentState();
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

    public EnumDoorState getNextDoorState() {
        switch (currentstate) {
            case CLOSED:
                return FIRST;
            case FIRST:
                return BOTH;
            case BOTH:
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
        //MinecraftServer pepe = playerentity.getServer();
        //ServerWorld world1 = pepe.getLevel(this.linked_tardis.interior_key);
        //TileEntity interior_door = world1.getBlockEntity(linked_tardis.door_list.get(linked_tardis.door_list.size()-1));
        //System.out.println(interior_door);
        if (block instanceof TardisBlock && hand == Hand.MAIN_HAND && !world.isClientSide) {
            this.setDoorState(this.getNextDoorState());
            //((BasicInteriorDoorTile) interior_door).setDoorState(((BasicInteriorDoorTile) interior_door).getNextDoorState());
            if (this.getNextDoorState() == FIRST)
                world.playSound(null, blockpos, AITSounds.POLICE_BOX_CLOSE.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
            else
                world.playSound(null, blockpos, AITSounds.POLICE_BOX_OPEN.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
            syncToClient();
        }
        return ActionResultType.SUCCESS;
    }

    public EnumMatState getMatState() {
        return this.matState;
    }

    public void entityInside(Entity entity) {
        World world = entity.level;
        if (!world.isClientSide()) {
            if (currentstate != CLOSED && entity instanceof ServerPlayerEntity) {
                if (linked_tardis == null) {
                    System.out.println("MMMMM BALL IN THE BAG AND THIS IS NULL");
                    return;
                }

                ServerWorld world1 = ServerLifecycleHooks.getCurrentServer().getLevel(AITDimensions.TARDIS_DIMENSION);
                if (world1 != null) {
                    //RegistryKey<World> worldy = world.dimension();
                    //linked_tardis.exterior_dim.remove(worldy);
                    //if(linked_tardis.exterior_dim.isEmpty()) {
                    //    linked_tardis.exterior_dim.add(worldy);
                    //    }
                    //}
                    ForgeChunkManager.forceChunk(world1, AIT.MOD_ID, new BlockPos(0, 128, 0), 0, 0, true, true);
                    //System.out.println("YOU\'RE TOUCHING ME AHHHHHHHH");
                    ((ServerPlayerEntity) entity).teleportTo(world1, 2, 129, 7, entity.yRot, entity.xRot);
                    //entity.moveTo(entity.getX(), entity.getY() * 2, entity.getZ());
                    //System.out.println("ServerPlayerEntity stuff");
                    syncToClient();
                }
            }
        }
    }

    public void useOnTardis(ItemUseContext context, BlockPos blockpos, BlockState blockstate, Block block) {
        PlayerEntity playerentity = context.getPlayer();
        Item item = playerentity.getMainHandItem().getItem();

        if (block instanceof TardisBlock && item == AITItems.TENNANT_SONIC.get()) {
            currentexterior = getNextExterior();
            syncToClient();
        }
    }

    public void DematTardis(ItemUseContext context, BlockPos blockpos, BlockState blockstate, Block block) {
        PlayerEntity playerentity = context.getPlayer();
        Item item = playerentity.getMainHandItem().getItem();
        if (block instanceof TardisBlock && item == AITItems.DEMATTER_STICK.get()) {
            matState = getNextMatState();
            syncToClient();
        }
    }

    @Override
    public void load(BlockState pState, CompoundNBT nbt) {
        this.currentexterior = EnumExteriorType.values()[nbt.getInt("currentexterior")];
        this.currentstate = EnumDoorState.values()[nbt.getInt("currentstate")];

        this.linked_tardis_id = nbt.getUUID("tardisUUID");
        if (level != null) {
            if (!level.isClientSide()) { // Server Side Only
                this.linked_tardis = AIT.tardisManager.getTardis(linked_tardis_id);
            }
        }

        this.leftDoorRotation = nbt.getFloat("leftDoorRotation");
        this.rightDoorRotation = nbt.getFloat("rightDoorRotation");
        super.load(pState, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putInt("currentexterior", this.currentexterior.ordinal());
        nbt.putInt("currentstate", this.currentstate.ordinal());
        if (this.linked_tardis_id != null) {
            nbt.putUUID("tardisUUID", this.linked_tardis_id);
        }
        nbt.putFloat("leftDoorRotation", this.leftDoorRotation);
        nbt.putFloat("rightDoorRotation", this.rightDoorRotation);
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

    //public void onPlace(BlockState blockstate, World world, BlockPos bpos, BlockState blockState, boolean bool) {
    //    if(currentstate != CLOSED) {
    //        RegistryKey<World> world1 = world.dimension();
    //        linked_tardis.exterior_dim.add(world1);
    //        syncToClient();
    //    }
    //}

    //public void onRemove(BlockState blockstate, World world, BlockPos bpos, BlockState blockState, boolean bool) {
    //    if(currentstate != CLOSED) {
    //        RegistryKey<World> world1 = world.dimension();
    //        linked_tardis.exterior_dim.remove(world1);
    //        syncToClient();
    //    }
    //}
}

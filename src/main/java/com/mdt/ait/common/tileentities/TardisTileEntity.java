package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.client.models.exteriors.BasicBox;
import com.mdt.ait.client.renderers.tardis.BasicBoxRenderer;
import com.mdt.ait.common.blocks.BasicInteriorDoorBlock;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.entities.K9Entity;
import com.mdt.ait.common.items.TARDISKey;
import com.mdt.ait.core.init.*;
import com.mdt.ait.core.init.enums.*;
import com.mdt.ait.tardis.Tardis;
import com.mdt.ait.tardis.TardisInteriors;
import com.mdt.ait.tardis.special.DematTransit;
import com.qouteall.immersive_portals.api.PortalAPI;
import com.qouteall.immersive_portals.commands.PortalCommand;
import com.qouteall.immersive_portals.my_util.DQuaternion;
import com.qouteall.immersive_portals.portal.Portal;
import com.qouteall.immersive_portals.portal.PortalManipulation;
import com.qouteall.immersive_portals.render.OverlayRendering;
import com.qouteall.immersive_portals.render.PortalEntityRenderer;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.dispenser.IPosition;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.world.ForgeChunkManager;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import org.lwjgl.system.CallbackI;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.UUID;
import java.util.function.ToIntFunction;

import static com.mdt.ait.common.blocks.TardisBlock.FACING;
import static com.mdt.ait.core.init.enums.EnumDoorState.*;

public class TardisTileEntity extends TileEntity implements ITickableTileEntity {

    /*
    Updated for Tardis Rewrite
     */

    public float leftDoorRotation = 0;
    public float rightDoorRotation = 0;
    public float nukaDoorRotation = 0;
    public float falloutDoorRotation = 0;
    public int arcadeDoorDistance = 0;
    public int tardimDoorRotation = 0;

    public boolean isExistingTardis = false;
    public float spinny = 0;
    public EnumInteriorDoorType interiorDoorType = EnumInteriorDoorType.DOOR_BASIC_BOX;
    public float upDown = 0;
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
    protected Portal portal;
    protected UUID portalUUID;
    public double portalWidth = 1.175D;
    public double portalHeight = 2.3D;
    public double portalPosX_Z = 0.5D;
    public double portalPosY = 1.249D;
    public double portalPosOldZ = 0.225D;
    //public double portalX = 0.5D;
    //public double portalY = 1.249D;
    //public double portalZ = 0.15D;

    public DematTransit dematTransit;
    private int run_once = 0;
    private int run_once_remat = 0;
    public TARDISKey tardisKey;
    public boolean lockedState = false;
    // aaaa

    public EnumExteriorType getNextExterior() {
        switch (currentexterior) {
            case BASIC_BOX:
                return EnumExteriorType.MINT_BOX;//return EnumExteriorType.MINT_BOX;
            case MINT_BOX:
                return EnumExteriorType.HELLBENT_TT_CAPSULE;//return EnumExteriorType.CORAL_BOX;
            //case CORAL_BOX:
            //    return EnumExteriorType.POSTER_BOX;
            //case POSTER_BOX:
            //    return EnumExteriorType.BAKER_BOX;
            //case BAKER_BOX:
            //    return EnumExteriorType.TYPE_40_TT_CAPSULE;
            //case TYPE_40_TT_CAPSULE:
            //    return EnumExteriorType.HELLBENT_TT_CAPSULE;
            case HELLBENT_TT_CAPSULE:
                return EnumExteriorType.HUDOLIN_EXTERIOR;//return EnumExteriorType.NUKA_COLA_EXTERIOR;
            //case NUKA_COLA_EXTERIOR:
            //    return EnumExteriorType.ARCADE_CABINET_EXTERIOR;
            //case SIEGE_MODE:
            //    return EnumExteriorType.BASIC_BOX;
            //case ARCADE_CABINET_EXTERIOR:
            //    return EnumExteriorType.CUSHING_EXTERIOR;
            //case CUSHING_EXTERIOR:
            //    return EnumExteriorType.CLASSIC_EXTERIOR;
            //case CLASSIC_EXTERIOR:
            //    return EnumExteriorType.HARTNELL_EXTERIOR;
            //case HARTNELL_EXTERIOR:
            //    return EnumExteriorType.HUDOLIN_EXTERIOR;
            case HUDOLIN_EXTERIOR:
                  return EnumExteriorType.FALLOUT_SHELTER_EXTERIOR;//return EnumExteriorType.TARDIM_EXTERIOR;//return EnumExteriorType.TX3_EXTERIOR;
            //case TX3_EXTERIOR:
            //    return EnumExteriorType.TARDIM_EXTERIOR;
            /*case TARDIM_EXTERIOR:
                return EnumExteriorType.FALLOUT_SHELTER_EXTERIOR;*///return EnumExteriorType.SHALKA_EXTERIOR;
            //case SHALKA_EXTERIOR:
            //    return EnumExteriorType.BOOTH_EXTERIOR;
            //case BOOTH_EXTERIOR:
            //    return EnumExteriorType.STEVE_EXTERIOR;
            //case STEVE_EXTERIOR:
            //    return EnumExteriorType.FALLOUT_SHELTER_EXTERIOR;
            case FALLOUT_SHELTER_EXTERIOR:
                return EnumExteriorType.BASIC_BOX;//return EnumExteriorType.RANI_EXTERIOR;
            //case RANI_EXTERIOR:
            //    return EnumExteriorType.CLOCK_EXTERIOR;
            //case CLOCK_EXTERIOR:
            //    return EnumExteriorType.BASIC_BOX;
        }
        return EnumExteriorType.BASIC_BOX;
    }

    public EnumExteriorType getCurrentExterior() {
        return currentexterior;
    }

    public void setLockedState(Boolean lockedState, EnumDoorState doorstate) {
        this.lockedState = lockedState;
        this.currentstate = doorstate;
    }

    public EnumExteriorType getLastExterior() {
        switch (currentexterior) {
            case BASIC_BOX:
                return EnumExteriorType.FALLOUT_SHELTER_EXTERIOR;//return EnumExteriorType.CLOCK_EXTERIOR;
            case MINT_BOX:
                return EnumExteriorType.BASIC_BOX;
            //case CORAL_BOX:
            //    return EnumExteriorType.MINT_BOX;
            //case POSTER_BOX:
            //    return EnumExteriorType.CORAL_BOX;
            //case BAKER_BOX:
            //    return EnumExteriorType.POSTER_BOX;
            //case TYPE_40_TT_CAPSULE:
            //    return EnumExteriorType.BAKER_BOX;
            case HELLBENT_TT_CAPSULE:
                return EnumExteriorType.MINT_BOX;//return EnumExteriorType.TYPE_40_TT_CAPSULE;
            //case NUKA_COLA_EXTERIOR:
            //    return EnumExteriorType.HELLBENT_TT_CAPSULE;
            //case SIEGE_MODE:
            //    return EnumExteriorType.SIEGE_MODE;
            //case ARCADE_CABINET_EXTERIOR:
            //    return EnumExteriorType.NUKA_COLA_EXTERIOR;
            //case CUSHING_EXTERIOR:
            //    return EnumExteriorType.ARCADE_CABINET_EXTERIOR;
            //case CLASSIC_EXTERIOR:
            //    return EnumExteriorType.CUSHING_EXTERIOR;
            //case HARTNELL_EXTERIOR:
            //    return EnumExteriorType.CLASSIC_EXTERIOR;
            case HUDOLIN_EXTERIOR:
                  return EnumExteriorType.HELLBENT_TT_CAPSULE;//return EnumExteriorType.HARTNELL_EXTERIOR;
            //case TX3_EXTERIOR:
            //    return EnumExteriorType.HUDOLIN_EXTERIOR;
            case TARDIM_EXTERIOR:
                return EnumExteriorType.HUDOLIN_EXTERIOR;//return EnumExteriorType.TX3_EXTERIOR;
            //case SHALKA_EXTERIOR:
            //    return EnumExteriorType.TARDIM_EXTERIOR;
            //case BOOTH_EXTERIOR:
            //    return EnumExteriorType.SHALKA_EXTERIOR;
            //case STEVE_EXTERIOR:
            //    return EnumExteriorType.BOOTH_EXTERIOR;
            case FALLOUT_SHELTER_EXTERIOR:
                return EnumExteriorType.TARDIM_EXTERIOR;//return EnumExteriorType.STEVE_EXTERIOR;
            //case RANI_EXTERIOR:
            //    return EnumExteriorType.FALLOUT_SHELTER_EXTERIOR;
            //case CLOCK_EXTERIOR:
            //    return EnumExteriorType.RANI_EXTERIOR;
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
        return new AxisAlignedBB(worldPosition).inflate(1500, 1500, 1500);
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

    public void spawnPortal() {
        if(this.linked_tardis != null) {
            if (this.getLevel() != null &&
                    !this.getLevel().isClientSide) {
                ServerWorld tardisexteriordim = AIT.server.getLevel(this.getLevel().dimension());
                ServerWorld tardisinteriordim = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
                ChunkPos chunkPos = new ChunkPos(this.getBlockPos());
                ForgeChunkManager.forceChunk(tardisexteriordim, "ait", this.getBlockPos(), chunkPos.x, chunkPos.z, true, true);
                if (this.linked_tardis.interior_door_position != null) {
                    ForgeChunkManager.forceChunk(tardisinteriordim, "ait", this.linked_tardis.interior_door_position, chunkPos.x, chunkPos.z, true, true);
                }
            }
            syncToClient();
            ServerWorld world = ServerLifecycleHooks.getCurrentServer().getLevel(AITDimensions.TARDIS_DIMENSION);
            if (world.getBlockEntity(this.linked_tardis.interior_door_position) instanceof BasicInteriorDoorTile) {
                BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) world.getBlockEntity(this.linked_tardis.interior_door_position);
                Portal portal = Portal.entityType.create(this.getLevel());
                portal.setOriginPos(new Vector3d(this.getBlockPos().getX() + 0.5D, this.getBlockPos().getY(), (this.getBlockPos().getZ() + 1)));
                if (this.currentexterior == EnumExteriorType.BASIC_BOX
                        || this.currentexterior == EnumExteriorType.MINT_BOX
                        || this.currentexterior == EnumExteriorType.CORAL_BOX
                        || this.currentexterior == EnumExteriorType.POSTER_BOX
                        || this.currentexterior == EnumExteriorType.BAKER_BOX
                        || this.currentexterior == EnumExteriorType.TYPE_40_TT_CAPSULE
                        || this.currentexterior == EnumExteriorType.HARTNELL_EXTERIOR
                        || this.currentexterior == EnumExteriorType.HUDOLIN_EXTERIOR) {
                    this.portalWidth = 1.275D;
                    this.portalHeight = 2.5D;
                    this.portalPosX_Z = 0.5D;
                    this.portalPosY = 1.269D;
                    this.portalPosOldZ = 0.22595D;
                }
                if (this.currentexterior == EnumExteriorType.HUDOLIN_EXTERIOR) {
                    this.portalWidth = 1.175D;
                    this.portalHeight = 2.3D;
                    this.portalPosX_Z = 0.5D;
                    this.portalPosY = 1.249D;
                    this.portalPosOldZ = 0.2D;
                }
                if (this.currentexterior == EnumExteriorType.HELLBENT_TT_CAPSULE
                        || this.currentexterior == EnumExteriorType.FALLOUT_SHELTER_EXTERIOR) {
                    this.portalWidth = 0.8D;
                    this.portalHeight = 2D;
                    this.portalPosOldZ = 0.1725D;
                    this.portalPosY = 1.159D;
                }
                if (this.currentexterior == EnumExteriorType.TARDIM_EXTERIOR
                        || this.currentexterior == EnumExteriorType.TX3_EXTERIOR) {
                    this.portalWidth = 1D;
                    this.portalHeight = 2D;
                    this.portalPosY = 1D;
                    this.portalPosOldZ = -0.95D;
                }
                if (this.currentexterior == EnumExteriorType.SHALKA_EXTERIOR
                        || this.currentexterior == EnumExteriorType.BOOTH_EXTERIOR) {
                    this.portalWidth = 1.25;
                    this.portalPosY = 1.3D;
                    this.portalHeight = 2.55D;
                    this.portalPosOldZ = 0.225D;
                }
                if (this.currentexterior == EnumExteriorType.NUKA_COLA_EXTERIOR
                        || this.currentexterior == EnumExteriorType.ARCADE_CABINET_EXTERIOR
                        || this.currentexterior == EnumExteriorType.CLASSIC_EXTERIOR) {
                    this.portalWidth = 1.15D;
                    this.portalHeight = 2.35D;
                    this.portalPosY = 1.249D;
                    this.portalPosOldZ = 0.175D;
                }
                if (this.currentexterior == EnumExteriorType.RANI_EXTERIOR) {
                    this.portalWidth = 0.9D;
                    this.portalHeight = 2.4D;
                    this.portalPosOldZ = 0.025D;
                    this.portalPosY = 1.35D;
                }
                portal.setOrientationAndSize(new Vector3d(1.0D, 0.0D, 0.0D), new Vector3d(0.0D, 1.0D, 0.0D),
                        this.portalWidth, this.portalHeight);
                if (basicInteriorDoorTile != null) {
                    if (this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.NORTH) { /*NORTH*/
                        if (basicInteriorDoorTile.getFacing() == Direction.NORTH) { /*NORTH1PART*/
                            PortalManipulation.setPortalTransformation(portal, AITDimensions.TARDIS_DIMENSION, new Vector3d(
                                    this.linked_tardis.interior_door_position.getX() + 0.5D,
                                    this.linked_tardis.interior_door_position.getY() + this.portalPosY,
                                    this.linked_tardis.interior_door_position.getZ() + 0.865D), new Quaternion(Vector3f.YP, 180.0F, true), 1d);
                        }
                        if (basicInteriorDoorTile.getFacing() == Direction.SOUTH) { /*SOUTH1PART*/
                            PortalManipulation.setPortalTransformation(portal, AITDimensions.TARDIS_DIMENSION, new Vector3d(
                                    this.linked_tardis.interior_door_position.getX() + 0.5D,
                                    this.linked_tardis.interior_door_position.getY() + this.portalPosY,
                                    this.linked_tardis.interior_door_position.getZ() + 0.135D), new Quaternion(Vector3f.YP, 0.0F, true), 1d);
                        }
                        if (basicInteriorDoorTile.getFacing() == Direction.EAST) { /*EAST1PART*/
                            PortalManipulation.setPortalTransformation(portal, AITDimensions.TARDIS_DIMENSION, new Vector3d(
                                    this.linked_tardis.interior_door_position.getX() + 0.135D,
                                    this.linked_tardis.interior_door_position.getY() + this.portalPosY,
                                    this.linked_tardis.interior_door_position.getZ() + 0.5D), new Quaternion(Vector3f.YP, 90.0F, true), 1d);
                        }
                        if (basicInteriorDoorTile.getFacing() == Direction.WEST) { /*WEST1PART*/
                            PortalManipulation.setPortalTransformation(portal, AITDimensions.TARDIS_DIMENSION, new Vector3d(
                                    this.linked_tardis.interior_door_position.getX() + 0.865D,
                                    this.linked_tardis.interior_door_position.getY() + this.portalPosY,
                                    this.linked_tardis.interior_door_position.getZ() + 0.5D), new Quaternion(Vector3f.YP, -90.0F, true), 1d);
                        }
                    }
                    if (this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.SOUTH) { /*SOUTH*/
                        if (basicInteriorDoorTile.getFacing() == Direction.NORTH) { /*NORTH2PART*/
                            PortalManipulation.setPortalTransformation(portal, AITDimensions.TARDIS_DIMENSION, new Vector3d(
                                    this.linked_tardis.interior_door_position.getX() + 0.5D,
                                    this.linked_tardis.interior_door_position.getY() + this.portalPosY,
                                    this.linked_tardis.interior_door_position.getZ() + 0.865D), new Quaternion(Vector3f.YP, 0.0F, true), 1d);
                        }
                        if (basicInteriorDoorTile.getFacing() == Direction.SOUTH) { /*SOUTH2PART*/
                            PortalManipulation.setPortalTransformation(portal, AITDimensions.TARDIS_DIMENSION, new Vector3d(
                                    this.linked_tardis.interior_door_position.getX() + 0.5D,
                                    this.linked_tardis.interior_door_position.getY() + this.portalPosY,
                                    this.linked_tardis.interior_door_position.getZ() + 0.135D), new Quaternion(Vector3f.YP, 180.0F, true), 1d);
                        }
                        if (basicInteriorDoorTile.getFacing() == Direction.EAST) { /*EAST2PART*/
                            PortalManipulation.setPortalTransformation(portal, AITDimensions.TARDIS_DIMENSION, new Vector3d(
                                    this.linked_tardis.interior_door_position.getX() + 0.135D,
                                    this.linked_tardis.interior_door_position.getY() + this.portalPosY,
                                    this.linked_tardis.interior_door_position.getZ() + 0.5D), new Quaternion(Vector3f.YP, -90.0F, true), 1d);
                        }
                        if (basicInteriorDoorTile.getFacing() == Direction.WEST) { /*WEST2PART*/
                            PortalManipulation.setPortalTransformation(portal, AITDimensions.TARDIS_DIMENSION, new Vector3d(
                                    this.linked_tardis.interior_door_position.getX() + 0.865D,
                                    this.linked_tardis.interior_door_position.getY() + this.portalPosY,
                                    this.linked_tardis.interior_door_position.getZ() + 0.5D), new Quaternion(Vector3f.YP, 90.0F, true), 1d);
                        }
                    }
                    if (this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.EAST) { /*EAST*/
                        if (basicInteriorDoorTile.getFacing() == Direction.NORTH) { /*NORTH3PART*/
                            PortalManipulation.setPortalTransformation(portal, AITDimensions.TARDIS_DIMENSION, new Vector3d(
                                    this.linked_tardis.interior_door_position.getX() + 0.5D,
                                    this.linked_tardis.interior_door_position.getY() + this.portalPosY,
                                    this.linked_tardis.interior_door_position.getZ() + 0.865D), new Quaternion(Vector3f.YP, -90.0F, true), 1d);
                        }
                        if (basicInteriorDoorTile.getFacing() == Direction.SOUTH) { /*SOUTH3PART*/
                            PortalManipulation.setPortalTransformation(portal, AITDimensions.TARDIS_DIMENSION, new Vector3d(
                                    this.linked_tardis.interior_door_position.getX() + 0.5D,
                                    this.linked_tardis.interior_door_position.getY() + this.portalPosY,
                                    this.linked_tardis.interior_door_position.getZ() + 0.135D), new Quaternion(Vector3f.YP, 90.0F, true), 1d);
                        }
                        if (basicInteriorDoorTile.getFacing() == Direction.EAST) { /*EAST3PART*/
                            PortalManipulation.setPortalTransformation(portal, AITDimensions.TARDIS_DIMENSION, new Vector3d(
                                    this.linked_tardis.interior_door_position.getX() + 0.135D,
                                    this.linked_tardis.interior_door_position.getY() + this.portalPosY,
                                    this.linked_tardis.interior_door_position.getZ() + 0.5D), new Quaternion(Vector3f.YP, 180.0F, true), 1d);
                        }
                        if (basicInteriorDoorTile.getFacing() == Direction.WEST) { /*WEST3PART*/
                            PortalManipulation.setPortalTransformation(portal, AITDimensions.TARDIS_DIMENSION, new Vector3d(
                                    this.linked_tardis.interior_door_position.getX() + 0.5D,
                                    this.linked_tardis.interior_door_position.getY() + this.portalPosY,
                                    this.linked_tardis.interior_door_position.getZ() + 0.235D), new Quaternion(Vector3f.YP, 0.0F, true), 1d);
                        }
                    }
                    if (this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.WEST) { /*WEST*/
                        if (basicInteriorDoorTile.getFacing() == Direction.NORTH) { /*NORTH4PART*/
                            PortalManipulation.setPortalTransformation(portal, AITDimensions.TARDIS_DIMENSION, new Vector3d(
                                    this.linked_tardis.interior_door_position.getX() + 0.5D,
                                    this.linked_tardis.interior_door_position.getY() + this.portalPosY,
                                    this.linked_tardis.interior_door_position.getZ() + 0.865D), new Quaternion(Vector3f.YP, 90.0F, true), 1d);
                        }
                        if (basicInteriorDoorTile.getFacing() == Direction.SOUTH) { /*SOUTH4PART*/
                            PortalManipulation.setPortalTransformation(portal, AITDimensions.TARDIS_DIMENSION, new Vector3d(
                                    this.linked_tardis.interior_door_position.getX() + 0.5D,
                                    this.linked_tardis.interior_door_position.getY() + this.portalPosY,
                                    this.linked_tardis.interior_door_position.getZ() + 0.135D), new Quaternion(Vector3f.YP, -90.0F, true), 1d);
                        }
                        if (basicInteriorDoorTile.getFacing() == Direction.EAST) { /*EAST4PART*/
                            PortalManipulation.setPortalTransformation(portal, AITDimensions.TARDIS_DIMENSION, new Vector3d(
                                    this.linked_tardis.interior_door_position.getX() + 0.135D,
                                    this.linked_tardis.interior_door_position.getY() + this.portalPosY,
                                    this.linked_tardis.interior_door_position.getZ() + 0.5D), new Quaternion(Vector3f.YP, 0.0F, true), 1d);
                        }
                        if (basicInteriorDoorTile.getFacing() == Direction.WEST) { /*WEST4PART*/
                            PortalManipulation.setPortalTransformation(portal, AITDimensions.TARDIS_DIMENSION, new Vector3d(
                                    this.linked_tardis.interior_door_position.getX() + 0.865D,
                                    this.linked_tardis.interior_door_position.getY() + this.portalPosY,
                                    this.linked_tardis.interior_door_position.getZ() + 0.5D), new Quaternion(Vector3f.YP, 180.0F, true), 1d);
                        }
                    }
                }
                if (this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.NORTH) {
                    PortalManipulation.rotatePortalBody(portal, new Quaternion(Vector3f.YN, 180, true));
                    portal.setOriginPos(new Vector3d(this.getBlockPos().getX() + portalPosX_Z, this.getBlockPos().getY() + portalPosY + upDown, this.getBlockPos().getZ() - portalPosOldZ));
                }
                if (this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.SOUTH) {
                    PortalManipulation.rotatePortalBody(portal, new Quaternion(Vector3f.YN, 0, true));
                    portal.setOriginPos(new Vector3d(this.getBlockPos().getX() + portalPosX_Z, this.getBlockPos().getY() + portalPosY + upDown, this.getBlockPos().getZ() + 1 + portalPosOldZ));
                }
                if (this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.EAST) {
                    PortalManipulation.rotatePortalBody(portal, new Quaternion(Vector3f.YN, -90, true));
                    portal.setOriginPos(new Vector3d(this.getBlockPos().getX() + 1 + portalPosOldZ, this.getBlockPos().getY() + portalPosY + upDown, this.getBlockPos().getZ() + portalPosX_Z));
                }
                if (this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.WEST) {
                    PortalManipulation.rotatePortalBody(portal, new Quaternion(Vector3f.YN, 90, true));
                    portal.setOriginPos(new Vector3d(this.getBlockPos().getX() - portalPosOldZ, this.getBlockPos().getY() + portalPosY + upDown, this.getBlockPos().getZ() + portalPosX_Z));
                }
                syncToClient();
                if (portal.getDestinationWorld() != null) {
                    PortalAPI.spawnServerEntity(portal);
                } else {
                    portal.setDestinationDimension(AITDimensions.TARDIS_DIMENSION);
                    PortalAPI.spawnServerEntity(portal);
                }
                portal.reloadAndSyncToClient();
                this.portal = portal;
                if (world != null &&
                        basicInteriorDoorTile != null &&
                        basicInteriorDoorTile != null &&
                        basicInteriorDoorTile.portal == null) {
                    basicInteriorDoorTile.setPortal(this.portal);
                    basicInteriorDoorTile.syncToClient();
                    syncToClient();
                }
                this.portal = portal;
            }
        }
    }

    @Override
    public void tick() {
        if(this.getLevel() != null) {
            if (!getLevel().isClientSide()) {
                if (linked_tardis != null) {
                    if (linked_tardis.interior_door_position != null) {
                        if (AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION).getBlockEntity(linked_tardis.interior_door_position) instanceof BasicInteriorDoorTile) {
                            BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION).getBlockEntity(linked_tardis.interior_door_position);
                            if (this.currentexterior == EnumExteriorType.BASIC_BOX) {
                                this.interiorDoorType = EnumInteriorDoorType.DOOR_BASIC_BOX;
                            } else if (this.currentexterior == EnumExteriorType.HUDOLIN_EXTERIOR) {
                                this.interiorDoorType = EnumInteriorDoorType.DOOR_HUDOLIN_EXTERIOR;
                            } else if (this.currentexterior == EnumExteriorType.MINT_BOX) {
                                this.interiorDoorType = EnumInteriorDoorType.DOOR_MINT_BOX;
                            } else if (this.currentexterior == EnumExteriorType.TARDIM_EXTERIOR) {
                                this.interiorDoorType = EnumInteriorDoorType.DOOR_TARDIM_EXTERIOR;
                            } else if (this.currentexterior == EnumExteriorType.FALLOUT_SHELTER_EXTERIOR) {
                                this.interiorDoorType = EnumInteriorDoorType.DOOR_FALLOUT_SHELTER_EXTERIOR;
                            } else if (!(this.currentexterior == EnumExteriorType.BASIC_BOX) ||
                                    !(this.currentexterior == EnumExteriorType.MINT_BOX) ||
                                    !(this.currentexterior == EnumExteriorType.TARDIM_EXTERIOR) ||
                                    !(this.currentexterior == EnumExteriorType.FALLOUT_SHELTER_EXTERIOR) ||
                                    !(this.currentexterior == EnumExteriorType.HUDOLIN_EXTERIOR)) {
                                this.interiorDoorType = EnumInteriorDoorType.DOOR_BASIC_BOX;
                            }
                            if (basicInteriorDoorTile != null) {
                                basicInteriorDoorTile.currentinteriordoor = this.interiorDoorType;
                            }
                        }
                    }
                    if (this.currentstate != CLOSED) {
                        if (portalUUID == null) {
                            if (portal == null) {
                                spawnPortal();
                                syncToClient();
                            }
                        }
                    } else {
                        if (rightDoorRotation <= 0.0f ||
                                nukaDoorRotation <= 0.0f ||
                                falloutDoorRotation <= 0.0f ||
                                arcadeDoorDistance <= 0.0f) {
                            if (this.portal != null) {
                                this.portal.remove();
                                this.portal = null;
                                this.portalUUID = null;
                                if (this.linked_tardis != null) {
                                    ServerWorld tardisexteriordim = AIT.server.getLevel(this.linked_tardis.exterior_dimension);
                                    ServerWorld tardisinteriordim = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);

                                    ChunkPos chunkPos = new ChunkPos(this.getBlockPos());
                                    ForgeChunkManager.forceChunk(tardisexteriordim, AIT.MOD_ID, this.linked_tardis.exterior_position, chunkPos.x, chunkPos.z, false, false);
                                    ForgeChunkManager.forceChunk(tardisinteriordim, AIT.MOD_ID, this.linked_tardis.interior_door_position, chunkPos.x, chunkPos.z, false, false);
                                    syncToClient();
                                }
                                syncToClient();
                            }
                        } else {
                            ServerWorld serverWorld = (ServerWorld) this.getLevel();
                            if (portal == null)
                                portal = (Portal) serverWorld.getEntity(portalUUID);
                        }
                    }
                }
            }
        }
        isItDark();
        EnumMatState materialState = EnumMatState.values()[this.serializeNBT().getInt("matState")];
        int mattype = this.serializeNBT().getInt("matState");
        if(materialState == EnumMatState.DEMAT) {
            this.currentstate = EnumDoorState.CLOSED;
            if(run_once == 0) {
                iDontKnow();
                run_once = 1;
            }

            ++ticks;
            if(ticks <= 220) {
                this.alpha -= 0.0045454545454545;
            }
            if(ticks >= 220) {
                if (this.dematTransit != null) {
                    this.dematTransit.finishedDematAnimation();
                }
            }
            /*if (ticks % 60 < 30) {
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
            }*/
        }
        if(materialState == EnumMatState.REMAT) {
            /*if (ticks % 60 < 30) {
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
                if (this.dematTransit != null) {
                    this.dematTransit.finished();
                }

                //ForgeChunkManager.forceChunk(forceWorld, AIT.MOD_ID, this.linked_tardis.exterior_position, 0, 0, false, false);
            }*/
            if(run_once_remat == 0) {
                iDontKnowRemat();
                run_once_remat = 1;
            }

            ++ticks;
            if(ticks <= 180) {
                this.alpha += 0.0055555555555556;
            }
            if(ticks >= 180) {
                matState = EnumMatState.SOLID;
                if (this.dematTransit != null) {
                    this.dematTransit.finished();
                }
            }
        }
        if(materialState == EnumMatState.SOLID) {
            this.alpha = 1;
            ticks = 0;
            run_once = 0;
            pulses = 0;
            run_once_remat = 0;
        }
        if (currentState() != previousstate) {
            rightDoorRotation = currentState() == FIRST ? 0.0f : 87.5f;
            nukaDoorRotation = currentState() == FIRST ? 0.0f : 44.25f;
            falloutDoorRotation = currentState() == FIRST ? 0.0f : 35f;
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
            if (falloutDoorRotation < 70f) {
                falloutDoorRotation += 5.0f;
            } else {
                falloutDoorRotation = 70f;
            }
            if (arcadeDoorDistance < 2) {
                arcadeDoorDistance += 1;
            } else {
                arcadeDoorDistance = 2;
            }
        } else {
            if (leftDoorRotation > 0.0f && rightDoorRotation > 0.0f) {
                leftDoorRotation -= 15.0f;
                rightDoorRotation -= 15.0f;
            }
            if(nukaDoorRotation > 0.0f) {
                nukaDoorRotation -= 15.0f;
            }
            if(falloutDoorRotation > 0.0f) {
                falloutDoorRotation -= 15.0f;
            }
            if(arcadeDoorDistance > 0) {
                arcadeDoorDistance -= 1;
            }
        }
        if (currentState() == BOTH) {
            if (leftDoorRotation < 87.5f) {
                leftDoorRotation += 5.0f;
            } else {
                leftDoorRotation = 87.5f;
            }
            if(currentexterior == EnumExteriorType.NUKA_COLA_EXTERIOR
                    || currentexterior == EnumExteriorType.TX3_EXTERIOR
                    || currentexterior == EnumExteriorType.TARDIM_EXTERIOR
                    || currentexterior == EnumExteriorType.BOOTH_EXTERIOR
                    || currentexterior == EnumExteriorType.ARCADE_CABINET_EXTERIOR
                    || currentexterior == EnumExteriorType.STEVE_EXTERIOR
                    || currentexterior == EnumExteriorType.FALLOUT_SHELTER_EXTERIOR
                    || currentexterior == EnumExteriorType.RANI_EXTERIOR) {
                currentstate = CLOSED;
            }
        }
        tardimDoorRotation = 90;
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
            if(falloutDoorRotation <= -2.5f) {
                falloutDoorRotation = 0.0f;
            }
            if(arcadeDoorDistance <= -1) {
                arcadeDoorDistance = 0;
            }
            tardimDoorRotation = 0;
        }
        //System.out.println("Right Door Rotation: "+ rightDoorRotation + " || " + "Left Door Rotation: " + leftDoorRotation);
        previousstate = currentState();
        /*BlockPos belowTardis = this.getBlockPos().below(1);
            if (this.getLevel().getBlockState(belowTardis).getBlock() instanceof AirBlock) {
                if (currentfloatstate == EnumRotorState.MOVING) {
                    if (upDown < 0.55f) {
                        upDown += 0.00390625f;
                    } else {
                        upDown = 0.55f;
                        currentfloatstate = EnumRotorState.STATIC;
                    }
                }
                if (this.currentfloatstate == EnumRotorState.STATIC) {
                    if (upDown > 0.0f) {
                        upDown -= 0.00390625f;
                    } else {
                        upDown = 0.0f;
                        currentfloatstate = EnumRotorState.MOVING;
                    }
                }
        } else {
                upDown = 0.0f;
            }
        if (this.portal != null) {
            double portalPosition = this.portal.getY();
            if (this.getLevel().getBlockState(belowTardis).getBlock() instanceof AirBlock) {
                if (currentfloatstate == EnumRotorState.MOVING) {
                    if (upDown < 0.55f) {
                        portalPosition += 0.00390625f;
                    } else {
                        portalPosition = (this.getBlockPos().getY() + 1.799D);
                        currentfloatstate = EnumRotorState.STATIC;
                    }
                }
                if (this.currentfloatstate == EnumRotorState.STATIC) {
                    if (upDown > 0.0f) {
                        portalPosition -= 0.00390625f;
                    } else {
                        portalPosition = (this.getBlockPos().getY() + 1.249D);
                        currentfloatstate = EnumRotorState.STATIC;
                    }
                }
                this.portal.moveTo(this.portal.getX(), portalPosition, this.portal.getZ());
            } else {
                this.portal.moveTo(this.portal.getX(), this.portal.getY(), this.portal.getZ());
            }
            System.out.println(upDown + " | | " + portalPosition);
        }*/
        if(!level.isClientSide()) {
            ServerWorld world = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
            if (this.linked_tardis != null) {
                if (this.linked_tardis.interior_door_position != null) {
                    assert world != null;
                    BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) world.getBlockEntity(this.linked_tardis.interior_door_position);
                    if (basicInteriorDoorTile != null) {
                        if (interiorDoorType != basicInteriorDoorTile.getCurrentInteriorDoor()) {
                            interiorDoorType = basicInteriorDoorTile.getInteriorDoor();
                            this.linked_tardis.setInteriorDoorType(interiorDoorType);
                        }
                        if (this.getLevel().getBiome(this.getBlockPos()).getPrecipitation() == Biome.RainType.SNOW) {
                            basicInteriorDoorTile.isItSnowing = true;
                        } else {
                            basicInteriorDoorTile.isItSnowing = false;
                        }
                    }
                }
            }
        }
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
        if(!world.isClientSide) {
            this.linked_tardis = AIT.tardisManager.getTardis(linked_tardis_id);
            BlockState blockstate = world.getBlockState(blockpos);
            Block block = blockstate.getBlock();
            ItemStack key = playerentity.getMainHandItem();
            if (this.matState == EnumMatState.SOLID) {
                if (lockedState != true) {
                    if (this.linked_tardis.currentInterior != TardisInteriors.airInterior) {
                        if (block instanceof TardisBlock && hand == Hand.MAIN_HAND && !world.isClientSide) {
                            ServerWorld tardisDimension = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
                            this.setDoorState(this.getNextDoorState());
                            if (this.linked_tardis.interior_door_position != null) {
                                this.linked_tardis.setInteriorDoorState(this.currentstate);
                            }
                            BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) tardisDimension.getBlockEntity(this.linked_tardis.interior_door_position);
                            if (basicInteriorDoorTile != null) {
                                basicInteriorDoorTile.syncToClient();
                            }
                            if (this.linked_tardis == null) {
                                this.linked_tardis = AIT.tardisManager.getTardis(this.linked_tardis_id);
                            }
                            //ForgeChunkManager.forceChunk(tardisDimension, AIT.MOD_ID, linked_tardis.interior_door_position, tardisDimension.getChunk(linked_tardis.interior_door_position).getPos().x, tardisDimension.getChunk(linked_tardis.interior_door_position).getPos().z, true, true);
                            if (currentexterior != EnumExteriorType.RANI_EXTERIOR) {
                                if (currentexterior != EnumExteriorType.FALLOUT_SHELTER_EXTERIOR) {
                                    if (currentexterior != EnumExteriorType.STEVE_EXTERIOR) {
                                        if (currentexterior != EnumExteriorType.NUKA_COLA_EXTERIOR) {
                                            if (currentexterior != EnumExteriorType.ARCADE_CABINET_EXTERIOR) {
                                                if (currentexterior != EnumExteriorType.TX3_EXTERIOR) {
                                                    if (currentexterior != EnumExteriorType.TARDIM_EXTERIOR) {
                                                        if (currentexterior != EnumExteriorType.BOOTH_EXTERIOR) {
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
                                                    } else {
                                                        if (currentState() != FIRST)
                                                            world.playSound(null, blockpos, SoundEvents.WOODEN_DOOR_CLOSE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                                                        if (currentState() == FIRST)
                                                            world.playSound(null, blockpos, SoundEvents.WOODEN_DOOR_OPEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                                                        syncToClient();
                                                    }
                                                } else {
                                                    if (currentState() != FIRST)
                                                        world.playSound(null, blockpos, AITSounds.POLICE_BOX_CLOSE.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                                                    if (currentState() == FIRST)
                                                        world.playSound(null, blockpos, AITSounds.POLICE_BOX_OPEN.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                                                    syncToClient();
                                                }
                                            } else {
                                                if (currentState() != FIRST)
                                                    world.playSound(null, blockpos, AITSounds.POLICE_BOX_CLOSE.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                                                if (currentState() == FIRST)
                                                    world.playSound(null, blockpos, AITSounds.POLICE_BOX_OPEN.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                                                syncToClient();
                                            }
                                        } else {
                                            if (currentState() != FIRST)
                                                world.playSound(null, blockpos, AITSounds.POLICE_BOX_CLOSE.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                                            if (currentState() == FIRST)
                                                world.playSound(null, blockpos, AITSounds.POLICE_BOX_OPEN.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                                            syncToClient();
                                        }
                                    } else {
                                        if (currentState() != FIRST)
                                            world.playSound(null, blockpos, AITSounds.POLICE_BOX_CLOSE.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                                        if (currentState() == FIRST)
                                            world.playSound(null, blockpos, AITSounds.POLICE_BOX_OPEN.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                                        syncToClient();
                                    }
                                } else {
                                    if (currentState() != FIRST)
                                        world.playSound(null, blockpos, SoundEvents.IRON_DOOR_CLOSE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                                    if (currentState() == FIRST)
                                        world.playSound(null, blockpos, SoundEvents.IRON_DOOR_CLOSE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                                    syncToClient();
                                }
                            } else {
                                if (currentState() != FIRST)
                                    world.playSound(null, blockpos, SoundEvents.GRINDSTONE_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                                if (currentState() == FIRST)
                                    world.playSound(null, blockpos, SoundEvents.GRINDSTONE_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                                syncToClient();
                            }
                        }
                    } else {
                        this.currentstate = EnumDoorState.CLOSED;
                        playerentity.displayClientMessage(new TranslationTextComponent(
                                "Interior does not exist!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
                        level.playSound(null, blockpos, AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                        syncToClient();
                    }
                } else {
                    this.currentstate = EnumDoorState.CLOSED;
                    playerentity.displayClientMessage(new TranslationTextComponent(
                            "Door is locked!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
                    level.playSound(null, blockpos, AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                    syncToClient();
                }
            }
        }
        return ActionResultType.SUCCESS;
    }

    public EnumMatState getMatState() {
        return this.matState;
    }

    //public void entityInside(Entity entity) {
    //    World world = entity.level;
    //    if (linked_tardis == null) {
    //        if (!world.isClientSide) { // Server side only
    //            this.linked_tardis = AIT.tardisManager.getTardis(linked_tardis_id);
    //            System.out.println(this.linked_tardis);
    //        }
    //    }
    //    if (!world.isClientSide()) {
    //        if ((matState == EnumMatState.REMAT && entity instanceof ServerPlayerEntity) || (currentstate != CLOSED && entity instanceof ServerPlayerEntity)) {
    //            if (linked_tardis == null) {
    //                System.out.println("MMMMM BALL IN THE BAG AND THIS IS NULL"); // HOLY SHIT I FIXED IT
    //                syncToClient();
    //                return;
    //            }
//
    //            ServerWorld tardis_world = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
    //            if (tardis_world != null && entity.canChangeDimensions()) {
    //                ForgeChunkManager.forceChunk(tardis_world, AIT.MOD_ID, linked_tardis.center_position, 0, 0, true, true);
    //                if (linked_tardis == null) {
    //                    linked_tardis = AIT.tardisManager.getTardis(linked_tardis_id);
    //                    syncToClient();
    //                }
    //                linked_tardis.teleportToInterior((PlayerEntity) entity);
    //                syncToClient();
    //            }
    //        }
    //    }
    //}

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



    public void useOnTardis(ItemUseContext context, BlockPos blockpos, BlockState blockstate, Block block) {
        PlayerEntity playerentity = context.getPlayer();
        Item item = playerentity.getMainHandItem().getItem();

        if (block instanceof TardisBlock && (item == AITItems.TENNANT_SONIC.get() /*|| item == AITItems.WHITTAKER_SONIC.get()*/) && playerentity.isCrouching()) {
            //currentexterior = getNextExterior();
            //AIT.tardisManager.getTardis(this.linked_tardis_id).setExteriorType(currentExterior());
            this.linked_tardis.currentInterior = TardisInteriors.getInteriorFromName("Air Interior");
            this.linked_tardis.clearInterior();
            syncToClient();
        } else //@TODO fix interior generation system
        if (block instanceof TardisBlock && item == AITItems.WHITTAKER_SONIC.get() && playerentity.isCrouching()) {
            //currentexterior = getNextExterior();
            //AIT.tardisManager.getTardis(this.linked_tardis_id).setExteriorType(currentExterior());
            this.linked_tardis.currentInterior = TardisInteriors.getInteriorFromName("Pristine Interior");
            this.linked_tardis.generateInterior();
            syncToClient();
        }
    }

    public void keyUsedOnTardis(ItemUseContext context, BlockPos blockpos, BlockState blockstate, Block block) {
        //System.out.println(lockedState);
        PlayerEntity playerEntity = context.getPlayer();
        ItemStack itemStack = playerEntity.getMainHandItem();
        Item item = playerEntity.getMainHandItem().getItem();
        if(this.getLevel() != null) {
            if (!this.getLevel().isClientSide) {
                Tardis tardis = AIT.tardisManager.getTardis(this.linked_tardis_id);
                ServerWorld tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
                BlockPos interiorDoorPos = tardis.interior_door_position;

                if (block instanceof TardisBlock && item == AITItems.GOLDEN_TARDIS_KEY.get()) {
                    BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) tardisWorld.getBlockEntity(interiorDoorPos);
                    TARDISKey tardisKey1 = (TARDISKey) item;
                    if (TARDISKey.getTardisId(itemStack) != null) {
                        if (TARDISKey.getTardisId(itemStack).equals(this.linked_tardis_id)) {
                            lockedState = true;
                            if (basicInteriorDoorTile != null) {
                                basicInteriorDoorTile.setLockedState(true, EnumDoorState.CLOSED);
                                tardisWorld.playSound(null, interiorDoorPos, AITSounds.TARDIS_LOCK.get(), SoundCategory.MASTER, 7, 1);
                                syncToClient();
                            }
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
                    } else {
                        playerEntity.displayClientMessage(new TranslationTextComponent(
                                "Key is not linked!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
                    }

                }
                if (block instanceof TardisBlock && item == AITItems.GOLDEN_TARDIS_KEY.get() && lockedState == true && playerEntity.isCrouching()) {
                    BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) tardisWorld.getBlockEntity(interiorDoorPos);
                    TARDISKey tardisKey1 = (TARDISKey) item;
                    if (TARDISKey.getTardisId(itemStack) != null) {
                        if (TARDISKey.getTardisId(itemStack).equals(this.linked_tardis_id)) {
                            lockedState = false;
                            if (basicInteriorDoorTile != null) {
                                basicInteriorDoorTile.setLockedState(false, EnumDoorState.CLOSED);
                                tardisWorld.playSound(null, interiorDoorPos, AITSounds.TARDIS_LOCK.get(), SoundCategory.MASTER, 7, 1);
                                syncToClient();
                            }
                            playerEntity.displayClientMessage(new TranslationTextComponent(
                                    "Door is unlocked!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
                            level.playSound(null, blockpos, AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                            tardisWorld.playSound(null, tardis.interior_door_position, AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                            syncToClient();
                        } else {
                            playerEntity.displayClientMessage(new TranslationTextComponent(
                                    "This TARDIS is not yours!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), true);
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

    public void lastExteriorFromMonitor() {
        currentexterior = getLastExterior();
        syncToClient();
    }

    public void nextExteriorFromMonitor() {
        currentexterior = getNextExterior();
        AIT.tardisManager.getTardis(this.linked_tardis_id).setExteriorType(currentExterior());
        syncToClient();
    }

    @Override
    public void load(BlockState pState, CompoundNBT nbt) {
        if(nbt.contains("portalID")) {
            this.portalUUID = nbt.getUUID("portalID");
        }
        this.currentexterior = EnumExteriorType.values()[nbt.getInt("currentexterior")];
        this.currentstate = EnumDoorState.values()[nbt.getInt("currentstate")];
        this.matState = EnumMatState.values()[nbt.getInt("matState")];
        this.currentfloatstate = EnumRotorState.values()[nbt.getInt("currentFloatingState")];
        this.linked_tardis_id = nbt.getUUID("tardisUUID");
        if (level != null) {
            if (!level.isClientSide()) { // Server Side Only
                if (nbt.contains("tardisUUID")) {
                    this.linked_tardis = AIT.tardisManager.getTardis(nbt.getUUID("tardisUUID"));
                }
            }
        }
        if (this.linked_tardis_id == null) {
            System.out.println("Linked Tardis ID is null");
        }
        this.leftDoorRotation = nbt.getFloat("leftDoorRotation");
        this.rightDoorRotation = nbt.getFloat("rightDoorRotation");
        this.nukaDoorRotation = nbt.getFloat("nukaDoorRotation");
        this.falloutDoorRotation = nbt.getFloat("falloutDoorRotation");
        this.tardimDoorRotation = nbt.getInt("tardimDoorRotation");
        this.lockedState = nbt.getBoolean("lockedState");
        this.portalWidth = nbt.getDouble("portalWidth");
        this.portalHeight = nbt.getDouble("portalHeight");
        this.portalPosX_Z = nbt.getDouble("portalPosX_Z");
        this.portalPosY = nbt.getDouble("portalPosY");
        this.portalPosOldZ = nbt.getDouble("portalPosOldZ");
        this.interiorDoorType = EnumInteriorDoorType.values()[nbt.getInt("interiorDoorType")];
        super.load(pState, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        if(this.portal != null) {
            nbt.putUUID("portalID", this.portal.getUUID());
        }
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
        nbt.putFloat("falloutDoorRotation", this.falloutDoorRotation);
        nbt.putInt("tardimDoorRotation", this.tardimDoorRotation);
        nbt.putBoolean("lockedState", this.lockedState);
        nbt.putDouble("portalWidth", this.portalWidth);
        nbt.putDouble("portalHeight", this.portalHeight);
        nbt.putDouble("portalPosX_Z", this.portalPosX_Z);
        nbt.putDouble("portalPosY", this.portalPosY);
        nbt.putDouble("portalPosOldZ", this.portalPosOldZ);
        nbt.putInt("interiorDoorType", this.interiorDoorType.ordinal());
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

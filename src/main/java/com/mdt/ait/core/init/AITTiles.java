package com.mdt.ait.core.init;

import com.mdt.ait.AIT;
import com.mdt.ait.common.tileentities.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AITTiles {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, AIT.MOD_ID);

    public static final RegistryObject<TileEntityType<TardisTileEntity>> TARDIS_TILE_ENTITY_TYPE = TILE_ENTITIES.register(
            "tardis",
            () -> TileEntityType.Builder.of(TardisTileEntity::new, AITBlocks.TARDIS_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<ConsoleTileEntity>> CONSOLE_TILE_ENTITY_TYPE = TILE_ENTITIES.register(
            "console_tileentity",
            () -> TileEntityType.Builder.of(ConsoleTileEntity::new, AITBlocks.CONSOLE_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<TSVTile>> TSV_TILE_ENTITY_TYPE = TILE_ENTITIES.register(
            "tsv",
            () -> TileEntityType.Builder.of(TSVTile::new, AITBlocks.TSV_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<TypewriterTile>> TYPEWRITER_TILE_ENTITY_TYPE = TILE_ENTITIES.register(
            "typewriter",
            () -> TileEntityType.Builder.of(TypewriterTile::new, AITBlocks.TYPEWRITER_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<RampTile>> RAMP_TILE_ENTITY_TYPE = TILE_ENTITIES.register(
            "ramp",
            () -> TileEntityType.Builder.of(RampTile::new, AITBlocks.RAMP_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<BasicInteriorDoorTile>> BASIC_INTERIOR_DOOR_TILE_ENTITY_TYPE = TILE_ENTITIES.register(
            "interior_door",
            () -> TileEntityType.Builder.of(BasicInteriorDoorTile::new, AITBlocks.INTERIOR_DOOR_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<TardisCoralTile>> TARDIS_CORAL_TILE_ENTITY_TYPE = TILE_ENTITIES.register(
            "tardis_coral",
            () -> TileEntityType.Builder.of(TardisCoralTile::new, AITBlocks.TARDIS_CORAL_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<TardisLeverTile>> TARDIS_LEVER_TILE_ENTITY_TYPE = TILE_ENTITIES.register(
            "tardis_lever",
            () -> TileEntityType.Builder.of(TardisLeverTile::new, AITBlocks.TARDIS_LEVER_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<RoundelFaceTile>> ROUNDEL_FACE_TILE_ENTITY_TYPE = TILE_ENTITIES.register(
            "roundel_face",
            () -> TileEntityType.Builder.of(RoundelFaceTile::new, AITBlocks.ROUNDEL_FACE_BLOCK.get()).build(null));
}

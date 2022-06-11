package com.mdt.ait.core.init;

import com.mdt.ait.AIT;
import com.mdt.ait.common.tileentities.CoralTardisTile;
import com.mdt.ait.common.tileentities.MintTardisTile;
import com.mdt.ait.common.tileentities.TSVTile;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AITTiles {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, AIT.MOD_ID);

    public static final RegistryObject<TileEntityType<TardisTileEntity>> TARDIS_TILE_ENTITY_TYPE = TILE_ENTITIES.register(
            "tardis",
            () -> TileEntityType.Builder.of(TardisTileEntity::new, AITBlocks.TARDIS_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<MintTardisTile>> MINT_TILE_ENTITY_TYPE = TILE_ENTITIES.register(
            "mint_tardis",
            () -> TileEntityType.Builder.of(MintTardisTile::new, AITBlocks.TARDIS_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<CoralTardisTile>> CORAL_TILE_ENTITY_TYPE = TILE_ENTITIES.register(
            "coral_tardis",
            () -> TileEntityType.Builder.of(CoralTardisTile::new, AITBlocks.TARDIS_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<TSVTile>> TSV_TILE_ENTITY_TYPE = TILE_ENTITIES.register(
            "tsv",
            () -> TileEntityType.Builder.of(TSVTile::new, AITBlocks.TSV_BLOCK.get()).build(null));
}

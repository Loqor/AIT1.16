package com.mdt.ait.tardis.interiors;

import com.mdt.ait.core.init.AITBlocks;
import com.mdt.ait.tardis.TardisConfig;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.Constants;

import java.util.concurrent.atomic.AtomicInteger;

public class TardisInterior {
    public static Template interior_template;

    public static String name;

    public static ResourceLocation interiorLocation;

    public static ServerWorld tardisWorld;

    private static BlockPos center_position;

    private static BlockPos interior_door_position;
    public TardisInterior(ResourceLocation interiorLocation, ServerWorld tardisWorld, String interiorName) {
        TardisInterior.interiorLocation = interiorLocation;
        TardisInterior.tardisWorld = tardisWorld;
        TardisInterior.name = interiorName;
        interior_template = tardisWorld.getStructureManager().get(interiorLocation);
        calcPositions();

    }

    public Template getTemplate() {
        return interior_template;
    }

    @Override
    public String toString() {
        return name;
    }

    private CompoundNBT loadTemplateNBT() {
        return this.getTemplate().save(new CompoundNBT());
    }

    private void calcPositions() {
        CompoundNBT tag = this.loadTemplateNBT();
        ListNBT palleteNBTList = tag.getList("palette", Constants.NBT.TAG_COMPOUND);
        ListNBT blockNBTList = tag.getList("blocks", Constants.NBT.TAG_COMPOUND);
        AtomicInteger i = new AtomicInteger();
        AtomicInteger centerBlockNumberState = new AtomicInteger();
        AtomicInteger interiorDoorNumberState = new AtomicInteger();
        System.out.println(AITBlocks.INTERIOR_DOOR_BLOCK.get().getRegistryName().toString());
        palleteNBTList.forEach((inbt -> {
            if (((CompoundNBT) inbt).getString("Name").equals(TardisConfig.tardis_center_block_name)) {
                centerBlockNumberState.set(i.intValue());
            }
            if (((CompoundNBT) inbt).getString("Name").equals(AITBlocks.INTERIOR_DOOR_BLOCK.get().getRegistryName().toString())) {
                interiorDoorNumberState.set(i.intValue());
            }
            i.getAndIncrement();

        }));

        blockNBTList.forEach((inbt -> {
            CompoundNBT nbt = (CompoundNBT) inbt;
            if (nbt.getInt("state") == centerBlockNumberState.get()) {
                ListNBT posList = nbt.getList("pos", Constants.NBT.TAG_INT);
                center_position = new BlockPos(posList.getInt(0),posList.getInt(1),posList.getInt(2));
            }
            if (nbt.getInt("state") == interiorDoorNumberState.get()) {
                System.out.println("Found interior door");
                ListNBT posList = nbt.getList("pos", Constants.NBT.TAG_INT);
                interior_door_position = new BlockPos(posList.getInt(0),posList.getInt(1),posList.getInt(2));
            }

        }));


    }

    public BlockPos getCenterPosition() {
        return center_position;
    }

    public BlockPos getInteriorDoorPosition() {
        return interior_door_position;
    }

    public void placeInterior(ServerWorld destinationWorld, BlockPos destinationBlockPos) {
        interior_template.placeInWorld(destinationWorld, destinationBlockPos, new PlacementSettings(), destinationWorld.getRandom());
    }
}

package io.mdt.ait.tardis.interior;

import io.mdt.ait.NBTSerializeable;
import io.mdt.ait.NBTUnserializeable;
import io.mdt.ait.tardis.TARDISConfig;
import io.mdt.ait.tardis.TARDISUtil;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.Constants;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class TARDISInterior {

    private final String id;
    private final TranslationTextComponent name;
    private final Template template;

    private BlockPos center;
    private BlockPos doorPosition;

    public TARDISInterior(String id, String translation, ResourceLocation location) {
        this.id = id;
        this.name = new TranslationTextComponent(translation);

        this.template = TARDISUtil.getTARDISWorld().getStructureManager().get(location);
        if (this.template == null) {
            System.out.printf("Failed to load interior \"%s\", \"%s\" is not found!%n", this.name.getString(), location.getPath());
            return;
        }

        this.calcPositions();
    }

    // TODO: seems very unoptimized :/
    // possible optimization: count every door and center block, and when the job is done, stop iterating.
    private void calcPositions() {
        CompoundNBT tag = this.template.save(new CompoundNBT());

        AtomicInteger i = new AtomicInteger();
        AtomicInteger centerBlockNumberState = new AtomicInteger();
        AtomicInteger interiorDoorNumberState = new AtomicInteger();
        tag.getList("palette", Constants.NBT.TAG_COMPOUND).forEach((inbt -> {
            CompoundNBT nbt = (CompoundNBT) inbt;
            String name = nbt.getString("Name");

            if (name.equals(TARDISConfig.INTERIOR_CENTER_BLOCK)) {
                centerBlockNumberState.set(i.intValue());
            }

            if (name.equals(TARDISConfig.INTERIOR_DOOR_BLOCK)) {
                interiorDoorNumberState.set(i.intValue());
            }

            i.getAndIncrement();
        }));

        tag.getList("blocks", Constants.NBT.TAG_COMPOUND).forEach((inbt -> {
            CompoundNBT nbt = (CompoundNBT) inbt;
            int state = nbt.getInt("state");

            if (state == centerBlockNumberState.get()) {
                ListNBT posList = nbt.getList("pos", Constants.NBT.TAG_INT);
                center = new BlockPos(posList.getInt(0),posList.getInt(1),posList.getInt(2));
            }

            if (state == interiorDoorNumberState.get()) {
                ListNBT posList = nbt.getList("pos", Constants.NBT.TAG_INT);
                doorPosition = new BlockPos(posList.getInt(0),posList.getInt(1),posList.getInt(2));
            }
        }));
    }

    public void place(ServerWorld world, BlockPos pos) {
        this.template.placeInWorld(world, pos, new PlacementSettings(), new Random());
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name.getString();
    }

    public BlockPos getCenter() {
        return this.center;
    }

    public BlockPos getDoorPosition() {
        return this.doorPosition;
    }

    public static class Serializer implements NBTSerializeable<TARDISInterior>, NBTUnserializeable<TARDISInterior> {

        @Override
        public CompoundNBT serialize(TARDISInterior interior, CompoundNBT nbt) {
            nbt.putString("id", interior.id);
            return nbt;
        }

        @Override
        public TARDISInterior unserialize(CompoundNBT nbt) {
            return TARDISInteriors.get(nbt.getString("id"));
        }
    }
}

package io.mdt.ait.tardis;

import com.mdt.ait.core.init.AITDimensions;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.util.Random;

public class TARDISUtil {

    public static ServerWorld getTARDISWorld() {
        return ServerLifecycleHooks.getCurrentServer().getLevel(AITDimensions.TARDIS_DIMENSION);
    }

    public static int getIndexByPos(BlockPos pos) {
        return (int) Math.ceil(
                (double) TARDISConfig.TARDIS_DIMENSION_START - pos.getX() / (double) TARDISConfig.TARDIS_AREA
        );
    }

    public static boolean canLand(Block landing) {
        boolean canLand = true;
        for (Block block : TARDISConfig.CANT_LAND_ON) {
            if (block.is(landing)) {
                canLand = false;
                break;
            }
        }

        return canLand;
    }

    public static String getRandomName(Random random) {
        return TARDISConfig.TARDIS_NAMES[random.nextInt(TARDISConfig.TARDIS_NAMES.length - 1)];
    }

    public static String getRandomName(int iterations, Random random) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            builder.append(TARDISUtil.getRandomName(random));
        }

        return builder.toString();
    }

    public static BlockPos getTARDISCenter(int i) {
        int xz = TARDISConfig.TARDIS_DIMENSION_START - (TARDISConfig.TARDIS_AREA * i) + ((TARDISConfig.TARDIS_AREA - 1) / 2) + 1;
        return new BlockPos(xz, TARDISConfig.TARDIS_CENTER_Y, xz);
    }
}

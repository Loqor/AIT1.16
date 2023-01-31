package com.mdt.ait.common.tileentities;

import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.tardis.structures.BaseStructure;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.UUID;

public class ARSRemoverTile extends TileEntity implements ITickableTileEntity  {

    int maxTicks, ticks, seconds;
    BlockPos pos;
    World world;
    PlayerEntity player;
    String message;
    boolean countdown = false;
    private BaseStructure structure;
    private Direction direction;

    public ARSRemoverTile() {
        super(AITTiles.ARS_REMOVER_TILE.get());
    }

    /*
    Displays text on the screen with the number and some info below it
    eg:
              2
    room deletion incoming
    1 Second = 20 ticks.
     */
    public void cloisterCountdown(World world, Direction direction, int timer, BlockPos pos, PlayerEntity player, String message, BaseStructure structure) {
        this.structure = structure;
        this.message = message;
        this.player = player;
        this.pos = pos;
        this.direction = direction;
        this.world = world;
        this.maxTicks = timer*40;
        this.ticks = this.maxTicks;
        this.countdown = true;
        System.out.println("Being Cloister Countdown");
    }

    @Override
    public void tick() {
        if (this.countdown) {
            if (ticks >= 0) {
                System.out.println(ticks + " % 40 = " + ticks%40);
                if (ticks % 40 == 0) {
                    this.seconds = ticks / 40;
                    player.sendMessage(new TranslationTextComponent(this.seconds + " " + this.message).setStyle(Style.EMPTY.withColor(TextFormatting.RED).withItalic(true)), UUID.randomUUID());
                    this.world.playSound(null,this.pos, AITSounds.CLOISTER_BELL.get(), SoundCategory.AMBIENT,1f,1f);
                }
                ticks--;
            } else {
                this.structure.deleteStructure((ServerWorld) this.world,this.pos,this.direction,this.player);
                this.countdown = false;
            }
        }
    }
}

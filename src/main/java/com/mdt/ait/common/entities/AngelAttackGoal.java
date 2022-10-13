package com.mdt.ait.common.entities;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class AngelAttackGoal extends MeleeAttackGoal {
    private final AngelEntity Angel;
    private int raiseArmTicks;

    public AngelAttackGoal(AngelEntity p_i46803_1_, double p_i46803_2_, boolean p_i46803_4_) {
        super(p_i46803_1_, p_i46803_2_, p_i46803_4_);
        this.Angel = p_i46803_1_;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void start() {
        super.start();
        this.raiseArmTicks = 0;
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void stop() {
        super.stop();
        this.Angel.setAggressive(false);
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
        super.tick();
        ++this.raiseArmTicks;
        if (this.raiseArmTicks >= 5 && this.getTicksUntilNextAttack() < this.getAttackInterval() / 2) {
            this.Angel.setAggressive(true);
        } else {
            this.Angel.setAggressive(false);
        }

    }
}
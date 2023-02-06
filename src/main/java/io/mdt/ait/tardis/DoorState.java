package io.mdt.ait.tardis;

import com.mdt.ait.core.init.AITSounds;
import net.minecraft.util.SoundEvent;

public class DoorState {

    private final State[] states = new State[] { State.CLOSED, State.FIRST, State.BOTH };
    private int index = 0;
    private boolean isLocked;

    public State getState() {
        return this.isLocked ? State.LOCKED : this.states[index];
    }

    public State next() {
        this.index = this.index + 1 == this.states.length ? 0 : this.index + 1;
        return this.getState();
    }

    public State previous() {
        this.index = this.index == 0 ? this.states.length - 1 : this.index - 1;
        return this.getState();
    }

    public boolean isClosed() {
        return this.isLocked || this.getState() == State.CLOSED;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void lock() {
        this.isLocked = true;
    }

    public void unlock() {
        this.isLocked = false;
    }

    public void setLocked(boolean locked) {
        this.isLocked = locked;
    }

    public State fromRaw(int index) {
        if (index == 3) {
            this.index = 0;
            this.isLocked = true;
        } else {
            this.index = index;
        }

        return this.getState();
    }

    public int getRaw() {
        return !this.isLocked ? this.index : 3;
    }

    public enum State {
        FIRST(AITSounds.POLICE_BOX_OPEN.get()),
        BOTH(AITSounds.POLICE_BOX_OPEN.get()),
        CLOSED(AITSounds.POLICE_BOX_CLOSE.get()),
        LOCKED(AITSounds.TARDIS_LOCK.get());

        private final SoundEvent sound;

        State(SoundEvent sound) {
            this.sound = sound;
        }

        public SoundEvent getSound() {
            return this.sound;
        }
    }
}

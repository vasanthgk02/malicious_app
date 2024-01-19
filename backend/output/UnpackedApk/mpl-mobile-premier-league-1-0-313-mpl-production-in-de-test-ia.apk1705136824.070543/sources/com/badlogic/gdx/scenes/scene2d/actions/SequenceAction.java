package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class SequenceAction extends ParallelAction {
    public int index;

    public boolean act(float f2) {
        int i = this.index;
        Array<Action> array = this.actions;
        if (i >= array.size) {
            return true;
        }
        Pool pool = this.pool;
        this.pool = null;
        try {
            if (((Action) array.get(i)).act(f2)) {
                if (this.actor == null) {
                    return true;
                }
                int i2 = this.index + 1;
                this.index = i2;
                if (i2 >= this.actions.size) {
                    this.pool = pool;
                    return true;
                }
            }
            this.pool = pool;
            return false;
        } finally {
            this.pool = pool;
        }
    }

    public void restart() {
        super.restart();
        this.index = 0;
    }
}

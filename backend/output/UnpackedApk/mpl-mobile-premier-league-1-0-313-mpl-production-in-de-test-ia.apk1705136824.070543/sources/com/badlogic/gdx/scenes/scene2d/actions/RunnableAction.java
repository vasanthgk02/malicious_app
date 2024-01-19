package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.utils.Pool;

public class RunnableAction extends Action {
    public boolean ran;
    public Runnable runnable;

    public boolean act(float f2) {
        if (!this.ran) {
            this.ran = true;
            Pool pool = this.pool;
            this.pool = null;
            try {
                this.runnable.run();
            } finally {
                this.pool = pool;
            }
        }
        return true;
    }

    public void reset() {
        super.reset();
        this.runnable = null;
    }

    public void restart() {
        this.ran = false;
    }
}

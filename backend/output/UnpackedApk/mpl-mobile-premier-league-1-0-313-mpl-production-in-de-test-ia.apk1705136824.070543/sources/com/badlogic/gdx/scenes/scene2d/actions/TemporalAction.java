package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.utils.Pool;

public abstract class TemporalAction extends Action {
    public boolean began;
    public boolean complete;
    public float duration;
    public Interpolation interpolation;
    public boolean reverse;
    public float time;

    public boolean act(float f2) {
        float f3;
        boolean z = true;
        if (this.complete) {
            return true;
        }
        Pool pool = this.pool;
        this.pool = null;
        try {
            if (!this.began) {
                begin();
                this.began = true;
            }
            float f4 = this.time + f2;
            this.time = f4;
            if (f4 < this.duration) {
                z = false;
            }
            this.complete = z;
            if (z) {
                f3 = 1.0f;
            } else {
                f3 = this.time / this.duration;
            }
            if (this.interpolation != null) {
                f3 = this.interpolation.apply(f3);
            }
            if (this.reverse) {
                f3 = 1.0f - f3;
            }
            update(f3);
            boolean z2 = this.complete;
            return this.complete;
        } finally {
            this.pool = pool;
        }
    }

    public abstract void begin();

    public void reset() {
        super.reset();
        this.reverse = false;
        this.interpolation = null;
    }

    public void restart() {
        this.time = 0.0f;
        this.began = false;
        this.complete = false;
    }

    public abstract void update(float f2);
}

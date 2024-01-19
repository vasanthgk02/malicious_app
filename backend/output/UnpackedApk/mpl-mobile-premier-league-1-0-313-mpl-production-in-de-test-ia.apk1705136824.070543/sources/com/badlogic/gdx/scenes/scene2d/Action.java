package com.badlogic.gdx.scenes.scene2d;

import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pool.Poolable;

public abstract class Action implements Poolable {
    public Actor actor;
    public Pool pool;
    public Actor target;

    public abstract boolean act(float f2);

    public void reset() {
        this.actor = null;
        this.target = null;
        this.pool = null;
        restart();
    }

    public void restart() {
    }

    public void setActor(Actor actor2) {
        this.actor = actor2;
        if (this.target == null) {
            setTarget(actor2);
        }
        if (actor2 == null) {
            Pool pool2 = this.pool;
            if (pool2 != null) {
                pool2.free(this);
                this.pool = null;
            }
        }
    }

    public void setTarget(Actor actor2) {
        this.target = actor2;
    }

    public String toString() {
        String name = getClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf != -1) {
            name = name.substring(lastIndexOf + 1);
        }
        return name.endsWith("Action") ? name.substring(0, name.length() - 6) : name;
    }
}

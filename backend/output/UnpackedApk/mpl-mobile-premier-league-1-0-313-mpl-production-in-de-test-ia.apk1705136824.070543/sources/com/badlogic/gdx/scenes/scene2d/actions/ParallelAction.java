package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class ParallelAction extends Action {
    public Array<Action> actions = new Array<>(true, 4);
    public boolean complete;

    public boolean act(float f2) {
        if (this.complete) {
            return true;
        }
        this.complete = true;
        Pool pool = this.pool;
        this.pool = null;
        try {
            Array<Action> array = this.actions;
            int i = array.size;
            for (int i2 = 0; i2 < i && this.actor != null; i2++) {
                Action action = (Action) array.get(i2);
                if (action.actor != null && !action.act(f2)) {
                    this.complete = false;
                }
                if (this.actor == null) {
                    return true;
                }
            }
            boolean z = this.complete;
            this.pool = pool;
            return z;
        } finally {
            this.pool = pool;
        }
    }

    public void reset() {
        super.reset();
        this.actions.clear();
    }

    public void restart() {
        this.complete = false;
        Array<Action> array = this.actions;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((Action) array.get(i2)).restart();
        }
    }

    public void setActor(Actor actor) {
        Array<Action> array = this.actions;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((Action) array.get(i2)).setActor(actor);
        }
        super.setActor(actor);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(super.toString());
        sb.append('(');
        Array<Action> array = this.actions;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(array.get(i2));
        }
        sb.append(')');
        return sb.toString();
    }
}

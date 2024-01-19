package com.badlogic.gdx.scenes.scene2d.actions;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Pool;

public abstract class DelegateAction extends Action {
    public Action action;

    public final boolean act(float f2) {
        Pool pool = this.pool;
        this.pool = null;
        try {
            return delegate(f2);
        } finally {
            this.pool = pool;
        }
    }

    public abstract boolean delegate(float f2);

    public void reset() {
        super.reset();
        this.action = null;
    }

    public void restart() {
        Action action2 = this.action;
        if (action2 != null) {
            action2.restart();
        }
    }

    public void setActor(Actor actor) {
        Action action2 = this.action;
        if (action2 != null) {
            action2.setActor(actor);
        }
        super.setActor(actor);
    }

    public void setTarget(Actor actor) {
        Action action2 = this.action;
        if (action2 != null) {
            action2.setTarget(actor);
        }
        this.target = actor;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (this.action == null) {
            str = "";
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("(");
            outline73.append(this.action);
            outline73.append(")");
            str = outline73.toString();
        }
        sb.append(str);
        return sb.toString();
    }
}

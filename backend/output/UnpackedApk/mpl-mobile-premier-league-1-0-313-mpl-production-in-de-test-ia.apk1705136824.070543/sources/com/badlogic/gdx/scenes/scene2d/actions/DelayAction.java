package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;

public class DelayAction extends DelegateAction {
    public float duration;
    public float time;

    public boolean delegate(float f2) {
        float f3 = this.time;
        float f4 = this.duration;
        if (f3 < f4) {
            float f5 = f3 + f2;
            this.time = f5;
            if (f5 < f4) {
                return false;
            }
            f2 = f5 - f4;
        }
        Action action = this.action;
        if (action == null) {
            return true;
        }
        return action.act(f2);
    }

    public void restart() {
        super.restart();
        this.time = 0.0f;
    }
}

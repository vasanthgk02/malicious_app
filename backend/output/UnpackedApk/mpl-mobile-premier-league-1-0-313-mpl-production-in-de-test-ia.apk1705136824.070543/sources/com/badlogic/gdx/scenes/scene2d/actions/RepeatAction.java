package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;

public class RepeatAction extends DelegateAction {
    public int executedCount;
    public boolean finished;
    public int repeatCount;

    public boolean delegate(float f2) {
        if (this.executedCount == this.repeatCount) {
            return true;
        }
        if (this.action.act(f2)) {
            if (this.finished) {
                return true;
            }
            if (this.repeatCount > 0) {
                this.executedCount++;
            }
            if (this.executedCount == this.repeatCount) {
                return true;
            }
            Action action = this.action;
            if (action != null) {
                action.restart();
            }
        }
        return false;
    }

    public void restart() {
        super.restart();
        this.executedCount = 0;
        this.finished = false;
    }
}

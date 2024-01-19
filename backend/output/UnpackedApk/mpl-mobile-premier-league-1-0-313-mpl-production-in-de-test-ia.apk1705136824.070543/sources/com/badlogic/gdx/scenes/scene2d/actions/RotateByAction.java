package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class RotateByAction extends RelativeTemporalAction {
    public float amount;

    public void updateRelative(float f2) {
        Actor actor = this.target;
        float f3 = this.amount * f2;
        if (actor == null) {
            throw null;
        } else if (f3 != 0.0f) {
            actor.rotation = (actor.rotation + f3) % 360.0f;
        }
    }
}

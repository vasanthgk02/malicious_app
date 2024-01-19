package com.badlogic.gdx.scenes.scene2d.actions;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ScaleToAction extends TemporalAction {
    public float endX;
    public float endY;
    public float startX;
    public float startY;

    public void begin() {
        Actor actor = this.target;
        this.startX = actor.scaleX;
        this.startY = actor.scaleY;
    }

    public void update(float f2) {
        float f3;
        float f4;
        if (f2 == 0.0f) {
            f3 = this.startX;
            f4 = this.startY;
        } else if (f2 == 1.0f) {
            f3 = this.endX;
            f4 = this.endY;
        } else {
            float f5 = this.startX;
            float outline3 = GeneratedOutlineSupport.outline3(this.endX, f5, f2, f5);
            float f6 = this.startY;
            float f7 = outline3;
            f4 = GeneratedOutlineSupport.outline3(this.endY, f6, f2, f6);
            f3 = f7;
        }
        Actor actor = this.target;
        if (actor.scaleX != f3 || actor.scaleY != f4) {
            actor.scaleX = f3;
            actor.scaleY = f4;
            actor.scaleChanged();
        }
    }
}

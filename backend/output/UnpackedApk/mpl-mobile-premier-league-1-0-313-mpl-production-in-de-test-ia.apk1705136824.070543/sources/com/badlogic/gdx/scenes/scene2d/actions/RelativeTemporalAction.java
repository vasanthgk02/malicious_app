package com.badlogic.gdx.scenes.scene2d.actions;

public abstract class RelativeTemporalAction extends TemporalAction {
    public float lastPercent;

    public void begin() {
        this.lastPercent = 0.0f;
    }

    public void update(float f2) {
        updateRelative(f2 - this.lastPercent);
        this.lastPercent = f2;
    }

    public abstract void updateRelative(float f2);
}

package com.badlogic.gdx.scenes.scene2d.actions;

public class MoveByAction extends RelativeTemporalAction {
    public float amountX;
    public float amountY;

    public void updateRelative(float f2) {
        this.target.moveBy(this.amountX * f2, this.amountY * f2);
    }
}

package com.badlogic.gdx.scenes.scene2d;

public class InputEvent extends Event {
    public int button;
    public char character;
    public int keyCode;
    public int pointer;
    public Actor relatedActor;
    public float scrollAmountX;
    public float scrollAmountY;
    public float stageX;
    public float stageY;
    public boolean touchFocus = true;
    public Type type;

    public enum Type {
        touchDown,
        touchUp,
        touchDragged,
        mouseMoved,
        enter,
        exit,
        scrolled,
        keyDown,
        keyUp,
        keyTyped
    }

    public boolean isTouchFocusCancel() {
        return this.stageX == -2.1474836E9f || this.stageY == -2.1474836E9f;
    }

    public void reset() {
        super.reset();
        this.relatedActor = null;
        this.button = -1;
    }

    public String toString() {
        return this.type.toString();
    }
}

package com.badlogic.gdx;

public class InputAdapter {
    public boolean keyDown(int i) {
        return false;
    }

    public boolean keyTyped(char c2) {
        return false;
    }

    public boolean keyUp(int i) {
        return false;
    }

    public boolean mouseMoved(int i, int i2) {
        return false;
    }

    public boolean scrolled(float f2, float f3) {
        return false;
    }

    public boolean touchDown(int i, int i2, int i3, int i4) {
        return false;
    }

    public abstract boolean touchDragged(int i, int i2, int i3);

    public boolean touchUp(int i, int i2, int i3, int i4) {
        return false;
    }
}

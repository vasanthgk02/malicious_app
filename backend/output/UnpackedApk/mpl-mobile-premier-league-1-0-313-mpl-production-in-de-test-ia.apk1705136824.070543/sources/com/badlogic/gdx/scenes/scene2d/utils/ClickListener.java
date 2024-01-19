package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class ClickListener extends InputListener {
    public boolean cancelled;
    public long lastTapTime;
    public boolean over;
    public boolean pressed;
    public int pressedPointer = -1;
    public int tapCount;
    public long tapCountInterval = 400000000;
    public float tapSquareSize = 14.0f;
    public float touchDownX = -1.0f;
    public float touchDownY = -1.0f;
    public long visualPressedTime;

    public abstract void clicked(InputEvent inputEvent, float f2, float f3);

    public void enter(InputEvent inputEvent, float f2, float f3, int i, Actor actor) {
        if (i == -1 && !this.cancelled) {
            this.over = true;
        }
    }

    public void exit(InputEvent inputEvent, float f2, float f3, int i, Actor actor) {
        if (i == -1 && !this.cancelled) {
            this.over = false;
        }
    }

    public boolean isOver(Actor actor, float f2, float f3) {
        boolean z = true;
        Actor hit = actor.hit(f2, f3, true);
        if (hit != null && hit.isDescendantOf(actor)) {
            return true;
        }
        boolean z2 = false;
        if (!(this.touchDownX == -1.0f && this.touchDownY == -1.0f)) {
            if (Math.abs(f2 - this.touchDownX) >= this.tapSquareSize || Math.abs(f3 - this.touchDownY) >= this.tapSquareSize) {
                z = false;
            }
            z2 = z;
        }
        return z2;
    }

    public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
        if (this.pressed) {
            return false;
        }
        if (i == 0 && i2 != 0) {
            return false;
        }
        this.pressed = true;
        this.pressedPointer = i;
        this.touchDownX = f2;
        this.touchDownY = f3;
        this.visualPressedTime = System.currentTimeMillis() + ((long) 100.0f);
        return true;
    }

    public void touchDragged(InputEvent inputEvent, float f2, float f3, int i) {
        if (i == this.pressedPointer && !this.cancelled) {
            boolean isOver = isOver(inputEvent.listenerActor, f2, f3);
            this.pressed = isOver;
            if (!isOver) {
                this.touchDownX = -1.0f;
                this.touchDownY = -1.0f;
            }
        }
    }

    public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
        if (i == this.pressedPointer) {
            if (!this.cancelled) {
                boolean isOver = isOver(inputEvent.listenerActor, f2, f3);
                if (isOver && i == 0 && i2 != 0) {
                    isOver = false;
                }
                if (isOver) {
                    long nanoTime = System.nanoTime();
                    if (nanoTime - this.lastTapTime > this.tapCountInterval) {
                        this.tapCount = 0;
                    }
                    this.tapCount++;
                    this.lastTapTime = nanoTime;
                    clicked(inputEvent, f2, f3);
                }
            }
            this.pressed = false;
            this.pressedPointer = -1;
            this.cancelled = false;
        }
    }
}

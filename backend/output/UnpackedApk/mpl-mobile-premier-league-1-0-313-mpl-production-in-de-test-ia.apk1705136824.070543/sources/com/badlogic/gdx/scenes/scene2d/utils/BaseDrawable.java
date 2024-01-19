package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.graphics.g2d.Batch;

public class BaseDrawable implements Drawable {
    public float bottomHeight;
    public float leftWidth;
    public float minHeight;
    public float minWidth;
    public String name;
    public float rightWidth;
    public float topHeight;

    public void draw(Batch batch, float f2, float f3, float f4, float f5) {
    }

    public float getBottomHeight() {
        return this.bottomHeight;
    }

    public float getLeftWidth() {
        return this.leftWidth;
    }

    public float getMinHeight() {
        return this.minHeight;
    }

    public float getMinWidth() {
        return this.minWidth;
    }

    public float getRightWidth() {
        return this.rightWidth;
    }

    public float getTopHeight() {
        return this.topHeight;
    }

    public void setBottomHeight(float f2) {
        this.bottomHeight = f2;
    }

    public void setLeftWidth(float f2) {
        this.leftWidth = f2;
    }

    public void setMinHeight(float f2) {
        this.minHeight = f2;
    }

    public void setMinWidth(float f2) {
        this.minWidth = f2;
    }

    public void setRightWidth(float f2) {
        this.rightWidth = f2;
    }

    public void setTopHeight(float f2) {
        this.topHeight = f2;
    }

    public String toString() {
        String str = this.name;
        return str == null ? getClass().getSimpleName() : str;
    }
}

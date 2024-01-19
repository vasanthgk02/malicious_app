package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;

public class Widget extends Actor implements Layout {
    public boolean layoutEnabled = true;
    public boolean needsLayout = true;

    public float getMaxHeight() {
        return 0.0f;
    }

    public float getMaxWidth() {
        return 0.0f;
    }

    public float getMinHeight() {
        return getPrefHeight();
    }

    public float getMinWidth() {
        return getPrefWidth();
    }

    public abstract float getPrefHeight();

    public abstract float getPrefWidth();

    public void invalidate() {
        this.needsLayout = true;
    }

    public void invalidateHierarchy() {
        if (this.layoutEnabled) {
            invalidate();
            Group group = this.parent;
            if (group instanceof Layout) {
                ((Layout) group).invalidateHierarchy();
            }
        }
    }

    public abstract void layout();

    public void sizeChanged() {
        invalidate();
    }

    public void validate() {
        if (this.layoutEnabled && this.needsLayout) {
            this.needsLayout = false;
            layout();
        }
    }
}

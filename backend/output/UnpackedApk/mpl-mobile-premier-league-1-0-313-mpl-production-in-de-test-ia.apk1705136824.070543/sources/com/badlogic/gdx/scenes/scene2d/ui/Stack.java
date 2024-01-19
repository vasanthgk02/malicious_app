package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.SnapshotArray;

public class Stack extends WidgetGroup {
    public float maxHeight;
    public float maxWidth;
    public float minHeight;
    public float minWidth;
    public float prefHeight;
    public float prefWidth;
    public boolean sizeInvalid = true;

    public Stack() {
        this.transform = false;
        if (this.width != 150.0f) {
            this.width = 150.0f;
            invalidate();
        }
        setHeight(150.0f);
        this.touchable = Touchable.childrenOnly;
    }

    public final void computeSize() {
        float f2;
        float f3;
        this.sizeInvalid = false;
        this.prefWidth = 0.0f;
        this.prefHeight = 0.0f;
        this.minWidth = 0.0f;
        this.minHeight = 0.0f;
        this.maxWidth = 0.0f;
        this.maxHeight = 0.0f;
        SnapshotArray<Actor> snapshotArray = this.children;
        int i = snapshotArray.size;
        for (int i2 = 0; i2 < i; i2++) {
            Actor actor = (Actor) snapshotArray.get(i2);
            if (actor instanceof Layout) {
                Layout layout = (Layout) actor;
                this.prefWidth = Math.max(this.prefWidth, layout.getPrefWidth());
                this.prefHeight = Math.max(this.prefHeight, layout.getPrefHeight());
                this.minWidth = Math.max(this.minWidth, layout.getMinWidth());
                this.minHeight = Math.max(this.minHeight, layout.getMinHeight());
                f2 = layout.getMaxWidth();
                f3 = layout.getMaxHeight();
            } else {
                this.prefWidth = Math.max(this.prefWidth, actor.width);
                this.prefHeight = Math.max(this.prefHeight, actor.height);
                this.minWidth = Math.max(this.minWidth, actor.width);
                this.minHeight = Math.max(this.minHeight, actor.height);
                f3 = 0.0f;
                f2 = 0.0f;
            }
            if (f2 > 0.0f) {
                float f4 = this.maxWidth;
                if (f4 != 0.0f) {
                    f2 = Math.min(f4, f2);
                }
                this.maxWidth = f2;
            }
            if (f3 > 0.0f) {
                float f5 = this.maxHeight;
                if (f5 != 0.0f) {
                    f3 = Math.min(f5, f3);
                }
                this.maxHeight = f3;
            }
        }
    }

    public float getMaxHeight() {
        if (this.sizeInvalid) {
            computeSize();
        }
        return this.maxHeight;
    }

    public float getMaxWidth() {
        if (this.sizeInvalid) {
            computeSize();
        }
        return this.maxWidth;
    }

    public float getMinHeight() {
        if (this.sizeInvalid) {
            computeSize();
        }
        return this.minHeight;
    }

    public float getMinWidth() {
        if (this.sizeInvalid) {
            computeSize();
        }
        return this.minWidth;
    }

    public float getPrefHeight() {
        if (this.sizeInvalid) {
            computeSize();
        }
        return this.prefHeight;
    }

    public float getPrefWidth() {
        if (this.sizeInvalid) {
            computeSize();
        }
        return this.prefWidth;
    }

    public void invalidate() {
        this.needsLayout = true;
        this.sizeInvalid = true;
    }

    public void layout() {
        if (this.sizeInvalid) {
            computeSize();
        }
        float f2 = this.width;
        float f3 = this.height;
        SnapshotArray<Actor> snapshotArray = this.children;
        int i = snapshotArray.size;
        for (int i2 = 0; i2 < i; i2++) {
            Actor actor = (Actor) snapshotArray.get(i2);
            actor.setBounds(0.0f, 0.0f, f2, f3);
            if (actor instanceof Layout) {
                ((Layout) actor).validate();
            }
        }
    }
}

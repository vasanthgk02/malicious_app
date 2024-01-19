package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

public class WidgetGroup extends Group implements Layout {
    public boolean fillParent;
    public boolean layoutEnabled = true;
    public boolean needsLayout = true;

    public void childrenChanged() {
        invalidateHierarchy();
    }

    public void draw(Batch batch, float f2) {
        validate();
        super.draw(batch, f2);
    }

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
        invalidate();
        Group group = this.parent;
        if (group instanceof Layout) {
            ((Layout) group).invalidateHierarchy();
        }
    }

    public abstract void layout();

    public void sizeChanged() {
        invalidate();
    }

    public void validate() {
        float f2;
        float f3;
        if (this.layoutEnabled) {
            Group group = this.parent;
            if (this.fillParent && group != null) {
                Stage stage = this.stage;
                if (stage == null || group != stage.root) {
                    f2 = group.width;
                    f3 = group.height;
                } else {
                    ScalingViewport scalingViewport = stage.viewport;
                    f2 = scalingViewport.worldWidth;
                    f3 = scalingViewport.worldHeight;
                }
                if (!(this.width == f2 && this.height == f3)) {
                    if (this.width != f2) {
                        this.width = f2;
                        invalidate();
                    }
                    setHeight(f3);
                    invalidate();
                }
            }
            if (this.needsLayout) {
                this.needsLayout = false;
                layout();
                if (this.needsLayout && !(group instanceof WidgetGroup)) {
                    for (int i = 0; i < 5; i++) {
                        this.needsLayout = false;
                        layout();
                        if (!this.needsLayout) {
                            break;
                        }
                    }
                }
            }
        }
    }
}

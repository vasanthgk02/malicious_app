package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.NinePatch;

public class NinePatchDrawable extends BaseDrawable implements TransformDrawable {
    public NinePatch patch;

    public NinePatchDrawable() {
    }

    public void draw(Batch batch, float f2, float f3, float f4, float f5) {
        this.patch.draw(batch, f2, f3, f4, f5);
    }

    public NinePatchDrawable(NinePatch ninePatch) {
        this.patch = ninePatch;
        this.minWidth = ninePatch.getTotalWidth();
        this.minHeight = ninePatch.getTotalHeight();
        this.topHeight = ninePatch.getPadTop();
        this.rightWidth = ninePatch.getPadRight();
        this.bottomHeight = ninePatch.getPadBottom();
        this.leftWidth = ninePatch.getPadLeft();
    }

    public void draw(Batch batch, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.patch.draw(batch, f2, f3, f4, f5, f6, f7, f8, f9, f10);
    }
}

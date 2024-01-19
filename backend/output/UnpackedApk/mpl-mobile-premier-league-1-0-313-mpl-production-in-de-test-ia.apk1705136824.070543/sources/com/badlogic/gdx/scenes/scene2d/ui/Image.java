package com.badlogic.gdx.scenes.scene2d.ui;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TransformDrawable;
import com.badlogic.gdx.utils.Scaling;

public class Image extends Widget {
    public int align = 1;
    public Drawable drawable;
    public float imageHeight;
    public float imageWidth;
    public float imageX;
    public float imageY;
    public Scaling scaling;

    public Image(Texture texture) {
        TextureRegionDrawable textureRegionDrawable = new TextureRegionDrawable(new TextureRegion(texture));
        Scaling scaling2 = Scaling.stretch;
        setDrawable(textureRegionDrawable);
        this.scaling = scaling2;
        this.align = 1;
        setSize(getPrefWidth(), getPrefHeight());
    }

    public void draw(Batch batch, float f2) {
        validate();
        Color color = this.color;
        batch.setColor(color.r, color.g, color.f3307b, color.f3306a * f2);
        float f3 = this.x;
        float f4 = this.y;
        float f5 = this.scaleX;
        float f6 = this.scaleY;
        if (this.drawable instanceof TransformDrawable) {
            float f7 = this.rotation;
            if (!(f5 == 1.0f && f6 == 1.0f && f7 == 0.0f)) {
                float f8 = this.imageX;
                float f9 = f3 + f8;
                float f10 = this.imageY;
                ((TransformDrawable) this.drawable).draw(batch, f9, f4 + f10, this.originX - f8, this.originY - f10, this.imageWidth, this.imageHeight, f5, f6, f7);
                return;
            }
        }
        Drawable drawable2 = this.drawable;
        if (drawable2 != null) {
            drawable2.draw(batch, f3 + this.imageX, f4 + this.imageY, this.imageWidth * f5, this.imageHeight * f6);
        }
    }

    public float getMinHeight() {
        return 0.0f;
    }

    public float getMinWidth() {
        return 0.0f;
    }

    public float getPrefHeight() {
        Drawable drawable2 = this.drawable;
        if (drawable2 != null) {
            return drawable2.getMinHeight();
        }
        return 0.0f;
    }

    public float getPrefWidth() {
        Drawable drawable2 = this.drawable;
        if (drawable2 != null) {
            return drawable2.getMinWidth();
        }
        return 0.0f;
    }

    public void layout() {
        Drawable drawable2 = this.drawable;
        if (drawable2 != null) {
            float minWidth = drawable2.getMinWidth();
            float minHeight = this.drawable.getMinHeight();
            float f2 = this.width;
            float f3 = this.height;
            Vector2 apply = this.scaling.apply(minWidth, minHeight, f2, f3);
            float f4 = apply.x;
            this.imageWidth = f4;
            this.imageHeight = apply.y;
            int i = this.align;
            if ((i & 8) != 0) {
                this.imageX = 0.0f;
            } else if ((i & 16) != 0) {
                this.imageX = (float) ((int) (f2 - f4));
            } else {
                this.imageX = (float) ((int) ((f2 / 2.0f) - (f4 / 2.0f)));
            }
            int i2 = this.align;
            if ((i2 & 2) != 0) {
                this.imageY = (float) ((int) (f3 - this.imageHeight));
            } else if ((i2 & 4) != 0) {
                this.imageY = 0.0f;
            } else {
                this.imageY = (float) ((int) ((f3 / 2.0f) - (this.imageHeight / 2.0f)));
            }
        }
    }

    public void setDrawable(Drawable drawable2) {
        if (this.drawable != drawable2) {
            if (drawable2 == null) {
                invalidateHierarchy();
            } else if (!(getPrefWidth() == drawable2.getMinWidth() && getPrefHeight() == drawable2.getMinHeight())) {
                invalidateHierarchy();
            }
            this.drawable = drawable2;
        }
    }

    public String toString() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        String name = getClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf != -1) {
            name = name.substring(lastIndexOf + 1);
        }
        StringBuilder sb = new StringBuilder();
        GeneratedOutlineSupport.outline102(sb, name.indexOf(36) != -1 ? "Image " : "", name, ": ");
        sb.append(this.drawable);
        return sb.toString();
    }
}

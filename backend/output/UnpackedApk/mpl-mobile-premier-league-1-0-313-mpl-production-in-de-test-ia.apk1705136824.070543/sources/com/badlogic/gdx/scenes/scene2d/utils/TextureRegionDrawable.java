package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureRegionDrawable extends BaseDrawable implements TransformDrawable {
    public TextureRegion region;

    public TextureRegionDrawable() {
    }

    public void draw(Batch batch, float f2, float f3, float f4, float f5) {
        batch.draw(this.region, f2, f3, f4, f5);
    }

    public void setRegion(TextureRegion textureRegion) {
        this.region = textureRegion;
        if (textureRegion != null) {
            this.minWidth = (float) textureRegion.getRegionWidth();
            this.minHeight = (float) textureRegion.getRegionHeight();
        }
    }

    public TextureRegionDrawable(Texture texture) {
        setRegion(new TextureRegion(texture));
    }

    public void draw(Batch batch, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        batch.draw(this.region, f2, f3, f4, f5, f6, f7, f8, f9, f10);
    }

    public TextureRegionDrawable(TextureRegion textureRegion) {
        setRegion(textureRegion);
    }
}

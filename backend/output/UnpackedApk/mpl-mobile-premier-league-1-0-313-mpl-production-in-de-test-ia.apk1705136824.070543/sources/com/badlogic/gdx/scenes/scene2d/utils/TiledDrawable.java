package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TiledDrawable extends TextureRegionDrawable {
    public final Color color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    public float scale = 1.0f;

    public void draw(Batch batch, float f2, float f3, float f4, float f5) {
        float f6;
        int i;
        float packedColor = batch.getPackedColor();
        batch.setColor(batch.getColor().mul(this.color));
        TextureRegion textureRegion = this.region;
        float regionWidth = ((float) textureRegion.getRegionWidth()) * this.scale;
        float regionHeight = ((float) textureRegion.getRegionHeight()) * this.scale;
        int i2 = (int) (f4 / regionWidth);
        int i3 = (int) (f5 / regionHeight);
        float f7 = f4 - (((float) i2) * regionWidth);
        float f8 = f5 - (((float) i3) * regionHeight);
        float f9 = f2;
        float f10 = f3;
        int i4 = 0;
        while (i4 < i2) {
            float f11 = f3;
            for (int i5 = 0; i5 < i3; i5++) {
                batch.draw(textureRegion, f9, f11, regionWidth, regionHeight);
                f11 += regionHeight;
            }
            f9 += regionWidth;
            i4++;
            f10 = f11;
        }
        Texture texture = textureRegion.getTexture();
        float u = textureRegion.getU();
        float v2 = textureRegion.getV2();
        if (f7 > 0.0f) {
            float width = (f7 / (((float) texture.getWidth()) * this.scale)) + u;
            float v = textureRegion.getV();
            f6 = f3;
            int i6 = 0;
            while (i6 < i3) {
                batch.draw(texture, f9, f6, f7, regionHeight, u, v2, width, v);
                f6 += regionHeight;
                i6++;
                i2 = i2;
                i3 = i3;
                Batch batch2 = batch;
            }
            i = i2;
            if (f8 > 0.0f) {
                batch.draw(texture, f9, f6, f7, f8, u, v2, width, v2 - (f8 / (((float) texture.getHeight()) * this.scale)));
            }
        } else {
            i = i2;
            f6 = f10;
        }
        if (f8 > 0.0f) {
            float u2 = textureRegion.getU2();
            float height = v2 - (f8 / (((float) texture.getHeight()) * this.scale));
            float f12 = f2;
            for (int i7 = 0; i7 < i; i7++) {
                batch.draw(texture, f12, f6, regionWidth, f8, u, v2, u2, height);
                f12 += regionWidth;
            }
        }
        batch.setPackedColor(packedColor);
    }

    public void draw(Batch batch, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        throw new UnsupportedOperationException();
    }
}

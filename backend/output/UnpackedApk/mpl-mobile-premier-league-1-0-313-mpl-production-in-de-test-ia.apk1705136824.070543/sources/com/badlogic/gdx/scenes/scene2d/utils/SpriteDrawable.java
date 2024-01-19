package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteDrawable extends BaseDrawable implements TransformDrawable {
    public Sprite sprite;

    public SpriteDrawable() {
    }

    public void draw(Batch batch, float f2, float f3, float f4, float f5) {
        Color color = this.sprite.getColor();
        float floatBits = color.toFloatBits();
        this.sprite.setColor(color.mul(batch.getColor()));
        this.sprite.setRotation(0.0f);
        this.sprite.setScale(1.0f, 1.0f);
        this.sprite.setBounds(f2, f3, f4, f5);
        this.sprite.draw(batch);
        this.sprite.setPackedColor(floatBits);
    }

    public SpriteDrawable(Sprite sprite2) {
        this.sprite = sprite2;
        this.minWidth = sprite2.getWidth();
        this.minHeight = sprite2.getHeight();
    }

    public void draw(Batch batch, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        Color color = this.sprite.getColor();
        float floatBits = color.toFloatBits();
        this.sprite.setColor(color.mul(batch.getColor()));
        this.sprite.setOrigin(f4, f5);
        this.sprite.setRotation(f10);
        this.sprite.setScale(f8, f9);
        this.sprite.setBounds(f2, f3, f6, f7);
        this.sprite.draw(batch);
        this.sprite.setPackedColor(floatBits);
    }
}

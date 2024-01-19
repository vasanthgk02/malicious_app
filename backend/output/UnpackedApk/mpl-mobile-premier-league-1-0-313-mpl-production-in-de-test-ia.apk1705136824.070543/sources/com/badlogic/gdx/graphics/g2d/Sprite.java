package com.badlogic.gdx.graphics.g2d;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import sfs2x.client.entities.invitation.InvitationReply;

public class Sprite extends TextureRegion {
    public static final int SPRITE_SIZE = 20;
    public static final int VERTEX_SIZE = 5;
    public Rectangle bounds;
    public final Color color;
    public boolean dirty;
    public float height;
    public float originX;
    public float originY;
    public float rotation;
    public float scaleX;
    public float scaleY;
    public final float[] vertices;
    public float width;
    public float x;
    public float y;

    public Sprite() {
        this.vertices = new float[20];
        this.color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dirty = true;
        setColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public void draw(Batch batch) {
        batch.draw(this.texture, getVertices(), 0, 20);
    }

    public void flip(boolean z, boolean z2) {
        super.flip(z, z2);
        float[] fArr = this.vertices;
        if (z) {
            float f2 = fArr[3];
            fArr[3] = fArr[13];
            fArr[13] = f2;
            float f3 = fArr[8];
            fArr[8] = fArr[18];
            fArr[18] = f3;
        }
        if (z2) {
            float f4 = fArr[4];
            fArr[4] = fArr[14];
            fArr[14] = f4;
            float f5 = fArr[9];
            fArr[9] = fArr[19];
            fArr[19] = f5;
        }
    }

    public Rectangle getBoundingRectangle() {
        float[] vertices2 = getVertices();
        float f2 = vertices2[0];
        float f3 = vertices2[1];
        float f4 = vertices2[0];
        float f5 = vertices2[1];
        if (f2 > vertices2[5]) {
            f2 = vertices2[5];
        }
        if (f2 > vertices2[10]) {
            f2 = vertices2[10];
        }
        if (f2 > vertices2[15]) {
            f2 = vertices2[15];
        }
        if (f4 < vertices2[5]) {
            f4 = vertices2[5];
        }
        if (f4 < vertices2[10]) {
            f4 = vertices2[10];
        }
        if (f4 < vertices2[15]) {
            f4 = vertices2[15];
        }
        if (f3 > vertices2[6]) {
            f3 = vertices2[6];
        }
        if (f3 > vertices2[11]) {
            f3 = vertices2[11];
        }
        if (f3 > vertices2[16]) {
            f3 = vertices2[16];
        }
        if (f5 < vertices2[6]) {
            f5 = vertices2[6];
        }
        if (f5 < vertices2[11]) {
            f5 = vertices2[11];
        }
        if (f5 < vertices2[16]) {
            f5 = vertices2[16];
        }
        if (this.bounds == null) {
            this.bounds = new Rectangle();
        }
        Rectangle rectangle = this.bounds;
        rectangle.x = f2;
        rectangle.y = f3;
        rectangle.width = f4 - f2;
        rectangle.height = f5 - f3;
        return rectangle;
    }

    public Color getColor() {
        int floatToIntColor = k.floatToIntColor(this.vertices[2]);
        Color color2 = this.color;
        color2.r = ((float) (floatToIntColor & InvitationReply.EXPIRED)) / 255.0f;
        color2.g = ((float) ((floatToIntColor >>> 8) & InvitationReply.EXPIRED)) / 255.0f;
        color2.f3307b = ((float) ((floatToIntColor >>> 16) & InvitationReply.EXPIRED)) / 255.0f;
        color2.f3306a = ((float) ((floatToIntColor >>> 24) & InvitationReply.EXPIRED)) / 255.0f;
        return color2;
    }

    public float getHeight() {
        return this.height;
    }

    public float getOriginX() {
        return this.originX;
    }

    public float getOriginY() {
        return this.originY;
    }

    public float getRotation() {
        return this.rotation;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public float[] getVertices() {
        if (this.dirty) {
            this.dirty = false;
            float[] fArr = this.vertices;
            float f2 = -this.originX;
            float f3 = -this.originY;
            float f4 = this.width + f2;
            float f5 = this.height + f3;
            float f6 = this.x - f2;
            float f7 = this.y - f3;
            if (!(this.scaleX == 1.0f && this.scaleY == 1.0f)) {
                float f8 = this.scaleX;
                f2 *= f8;
                float f9 = this.scaleY;
                f3 *= f9;
                f4 *= f8;
                f5 *= f9;
            }
            float f10 = this.rotation;
            if (f10 != 0.0f) {
                float cosDeg = MathUtils.cosDeg(f10);
                float sinDeg = MathUtils.sinDeg(this.rotation);
                float f11 = f2 * cosDeg;
                float f12 = f2 * sinDeg;
                float f13 = f3 * cosDeg;
                float f14 = f4 * cosDeg;
                float f15 = cosDeg * f5;
                float f16 = f5 * sinDeg;
                float f17 = (f11 - (f3 * sinDeg)) + f6;
                float f18 = f13 + f12 + f7;
                fArr[0] = f17;
                fArr[1] = f18;
                float f19 = (f11 - f16) + f6;
                float f20 = f12 + f15 + f7;
                fArr[5] = f19;
                fArr[6] = f20;
                float f21 = (f14 - f16) + f6;
                float f22 = f15 + (f4 * sinDeg) + f7;
                fArr[10] = f21;
                fArr[11] = f22;
                fArr[15] = (f21 - f19) + f17;
                fArr[16] = f22 - (f20 - f18);
            } else {
                float f23 = f2 + f6;
                float f24 = f3 + f7;
                float f25 = f4 + f6;
                float f26 = f5 + f7;
                fArr[0] = f23;
                fArr[1] = f24;
                fArr[5] = f23;
                fArr[6] = f26;
                fArr[10] = f25;
                fArr[11] = f26;
                fArr[15] = f25;
                fArr[16] = f24;
            }
        }
        return this.vertices;
    }

    public float getWidth() {
        return this.width;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void rotate(float f2) {
        if (f2 != 0.0f) {
            this.rotation += f2;
            this.dirty = true;
        }
    }

    public void rotate90(boolean z) {
        float[] fArr = this.vertices;
        if (z) {
            float f2 = fArr[4];
            fArr[4] = fArr[19];
            fArr[19] = fArr[14];
            fArr[14] = fArr[9];
            fArr[9] = f2;
            float f3 = fArr[3];
            fArr[3] = fArr[18];
            fArr[18] = fArr[13];
            fArr[13] = fArr[8];
            fArr[8] = f3;
            return;
        }
        float f4 = fArr[4];
        fArr[4] = fArr[9];
        fArr[9] = fArr[14];
        fArr[14] = fArr[19];
        fArr[19] = f4;
        float f5 = fArr[3];
        fArr[3] = fArr[8];
        fArr[8] = fArr[13];
        fArr[13] = fArr[18];
        fArr[18] = f5;
    }

    public void scale(float f2) {
        this.scaleX += f2;
        this.scaleY += f2;
        this.dirty = true;
    }

    public void scroll(float f2, float f3) {
        float[] fArr = this.vertices;
        if (f2 != 0.0f) {
            float f4 = (fArr[3] + f2) % 1.0f;
            float width2 = (this.width / ((float) this.texture.getWidth())) + f4;
            this.u = f4;
            this.u2 = width2;
            fArr[3] = f4;
            fArr[8] = f4;
            fArr[13] = width2;
            fArr[18] = width2;
        }
        if (f3 != 0.0f) {
            float f5 = (fArr[9] + f3) % 1.0f;
            float height2 = (this.height / ((float) this.texture.getHeight())) + f5;
            this.v = f5;
            this.v2 = height2;
            fArr[4] = height2;
            fArr[9] = f5;
            fArr[14] = f5;
            fArr[19] = height2;
        }
    }

    public void set(Sprite sprite) {
        if (sprite != null) {
            System.arraycopy(sprite.vertices, 0, this.vertices, 0, 20);
            this.texture = sprite.texture;
            this.u = sprite.u;
            this.v = sprite.v;
            this.u2 = sprite.u2;
            this.v2 = sprite.v2;
            this.x = sprite.x;
            this.y = sprite.y;
            this.width = sprite.width;
            this.height = sprite.height;
            this.regionWidth = sprite.regionWidth;
            this.regionHeight = sprite.regionHeight;
            this.originX = sprite.originX;
            this.originY = sprite.originY;
            this.rotation = sprite.rotation;
            this.scaleX = sprite.scaleX;
            this.scaleY = sprite.scaleY;
            this.color.set(sprite.color);
            this.dirty = sprite.dirty;
            return;
        }
        throw new IllegalArgumentException("sprite cannot be null.");
    }

    public void setAlpha(float f2) {
        Color color2 = this.color;
        color2.f3306a = f2;
        float floatBits = color2.toFloatBits();
        float[] fArr = this.vertices;
        fArr[2] = floatBits;
        fArr[7] = floatBits;
        fArr[12] = floatBits;
        fArr[17] = floatBits;
    }

    public void setBounds(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
        if (!this.dirty) {
            if (this.rotation == 0.0f && this.scaleX == 1.0f && this.scaleY == 1.0f) {
                float f6 = f4 + f2;
                float f7 = f5 + f3;
                float[] fArr = this.vertices;
                fArr[0] = f2;
                fArr[1] = f3;
                fArr[5] = f2;
                fArr[6] = f7;
                fArr[10] = f6;
                fArr[11] = f7;
                fArr[15] = f6;
                fArr[16] = f3;
                return;
            }
            this.dirty = true;
        }
    }

    public void setCenter(float f2, float f3) {
        setPosition(f2 - (this.width / 2.0f), f3 - (this.height / 2.0f));
    }

    public void setCenterX(float f2) {
        setX(f2 - (this.width / 2.0f));
    }

    public void setCenterY(float f2) {
        setY(f2 - (this.height / 2.0f));
    }

    public void setColor(Color color2) {
        this.color.set(color2);
        float floatBits = color2.toFloatBits();
        float[] fArr = this.vertices;
        fArr[2] = floatBits;
        fArr[7] = floatBits;
        fArr[12] = floatBits;
        fArr[17] = floatBits;
    }

    public void setFlip(boolean z, boolean z2) {
        boolean z3 = true;
        boolean z4 = isFlipX() != z;
        if (isFlipY() == z2) {
            z3 = false;
        }
        flip(z4, z3);
    }

    public void setOrigin(float f2, float f3) {
        this.originX = f2;
        this.originY = f3;
        this.dirty = true;
    }

    public void setOriginBasedPosition(float f2, float f3) {
        setPosition(f2 - this.originX, f3 - this.originY);
    }

    public void setOriginCenter() {
        this.originX = this.width / 2.0f;
        this.originY = this.height / 2.0f;
        this.dirty = true;
    }

    public void setPackedColor(float f2) {
        Color.abgr8888ToColor(this.color, f2);
        float[] fArr = this.vertices;
        fArr[2] = f2;
        fArr[7] = f2;
        fArr[12] = f2;
        fArr[17] = f2;
    }

    public void setPosition(float f2, float f3) {
        this.x = f2;
        this.y = f3;
        if (!this.dirty) {
            if (this.rotation == 0.0f && this.scaleX == 1.0f && this.scaleY == 1.0f) {
                float f4 = this.width + f2;
                float f5 = this.height + f3;
                float[] fArr = this.vertices;
                fArr[0] = f2;
                fArr[1] = f3;
                fArr[5] = f2;
                fArr[6] = f5;
                fArr[10] = f4;
                fArr[11] = f5;
                fArr[15] = f4;
                fArr[16] = f3;
                return;
            }
            this.dirty = true;
        }
    }

    public void setRegion(float f2, float f3, float f4, float f5) {
        super.setRegion(f2, f3, f4, f5);
        float[] fArr = this.vertices;
        fArr[3] = f2;
        fArr[4] = f5;
        fArr[8] = f2;
        fArr[9] = f3;
        fArr[13] = f4;
        fArr[14] = f3;
        fArr[18] = f4;
        fArr[19] = f5;
    }

    public void setRotation(float f2) {
        this.rotation = f2;
        this.dirty = true;
    }

    public void setScale(float f2) {
        this.scaleX = f2;
        this.scaleY = f2;
        this.dirty = true;
    }

    public void setSize(float f2, float f3) {
        this.width = f2;
        this.height = f3;
        if (!this.dirty) {
            if (this.rotation == 0.0f && this.scaleX == 1.0f && this.scaleY == 1.0f) {
                float f4 = this.x;
                float f5 = f2 + f4;
                float f6 = this.y;
                float f7 = f3 + f6;
                float[] fArr = this.vertices;
                fArr[0] = f4;
                fArr[1] = f6;
                fArr[5] = f4;
                fArr[6] = f7;
                fArr[10] = f5;
                fArr[11] = f7;
                fArr[15] = f5;
                fArr[16] = f6;
                return;
            }
            this.dirty = true;
        }
    }

    public void setU(float f2) {
        super.setU(f2);
        float[] fArr = this.vertices;
        fArr[3] = f2;
        fArr[8] = f2;
    }

    public void setU2(float f2) {
        super.setU2(f2);
        float[] fArr = this.vertices;
        fArr[13] = f2;
        fArr[18] = f2;
    }

    public void setV(float f2) {
        super.setV(f2);
        float[] fArr = this.vertices;
        fArr[9] = f2;
        fArr[14] = f2;
    }

    public void setV2(float f2) {
        super.setV2(f2);
        float[] fArr = this.vertices;
        fArr[4] = f2;
        fArr[19] = f2;
    }

    public void setX(float f2) {
        this.x = f2;
        if (!this.dirty) {
            if (this.rotation == 0.0f && this.scaleX == 1.0f && this.scaleY == 1.0f) {
                float f3 = this.width + f2;
                float[] fArr = this.vertices;
                fArr[0] = f2;
                fArr[5] = f2;
                fArr[10] = f3;
                fArr[15] = f3;
                return;
            }
            this.dirty = true;
        }
    }

    public void setY(float f2) {
        this.y = f2;
        if (!this.dirty) {
            if (this.rotation == 0.0f && this.scaleX == 1.0f && this.scaleY == 1.0f) {
                float f3 = this.height + f2;
                float[] fArr = this.vertices;
                fArr[1] = f2;
                fArr[6] = f3;
                fArr[11] = f3;
                fArr[16] = f2;
                return;
            }
            this.dirty = true;
        }
    }

    public void translate(float f2, float f3) {
        this.x += f2;
        this.y += f3;
        if (!this.dirty) {
            if (this.rotation == 0.0f && this.scaleX == 1.0f && this.scaleY == 1.0f) {
                float[] fArr = this.vertices;
                fArr[0] = fArr[0] + f2;
                fArr[1] = fArr[1] + f3;
                fArr[5] = fArr[5] + f2;
                fArr[6] = fArr[6] + f3;
                fArr[10] = fArr[10] + f2;
                fArr[11] = fArr[11] + f3;
                fArr[15] = fArr[15] + f2;
                fArr[16] = fArr[16] + f3;
                return;
            }
            this.dirty = true;
        }
    }

    public void translateX(float f2) {
        this.x += f2;
        if (!this.dirty) {
            if (this.rotation == 0.0f && this.scaleX == 1.0f && this.scaleY == 1.0f) {
                float[] fArr = this.vertices;
                fArr[0] = fArr[0] + f2;
                fArr[5] = fArr[5] + f2;
                fArr[10] = fArr[10] + f2;
                fArr[15] = fArr[15] + f2;
                return;
            }
            this.dirty = true;
        }
    }

    public void translateY(float f2) {
        this.y += f2;
        if (!this.dirty) {
            if (this.rotation == 0.0f && this.scaleX == 1.0f && this.scaleY == 1.0f) {
                float[] fArr = this.vertices;
                fArr[1] = fArr[1] + f2;
                fArr[6] = fArr[6] + f2;
                fArr[11] = fArr[11] + f2;
                fArr[16] = fArr[16] + f2;
                return;
            }
            this.dirty = true;
        }
    }

    public void draw(Batch batch, float f2) {
        float f3 = getColor().f3306a;
        setAlpha(f2 * f3);
        draw(batch);
        setAlpha(f3);
    }

    public void setScale(float f2, float f3) {
        this.scaleX = f2;
        this.scaleY = f3;
        this.dirty = true;
    }

    public Sprite(Texture texture) {
        this(texture, 0, 0, texture.getWidth(), texture.getHeight());
    }

    public Sprite(Texture texture, int i, int i2) {
        this(texture, 0, 0, i, i2);
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.color.set(f2, f3, f4, f5);
        float floatBits = this.color.toFloatBits();
        float[] fArr = this.vertices;
        fArr[2] = floatBits;
        fArr[7] = floatBits;
        fArr[12] = floatBits;
        fArr[17] = floatBits;
    }

    public Sprite(Texture texture, int i, int i2, int i3, int i4) {
        this.vertices = new float[20];
        this.color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dirty = true;
        if (texture != null) {
            this.texture = texture;
            setRegion(i, i2, i3, i4);
            setColor(1.0f, 1.0f, 1.0f, 1.0f);
            setSize((float) Math.abs(i3), (float) Math.abs(i4));
            setOrigin(this.width / 2.0f, this.height / 2.0f);
            return;
        }
        throw new IllegalArgumentException("texture cannot be null.");
    }

    public Sprite(TextureRegion textureRegion) {
        this.vertices = new float[20];
        this.color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dirty = true;
        setRegion(textureRegion);
        setColor(1.0f, 1.0f, 1.0f, 1.0f);
        setSize((float) textureRegion.getRegionWidth(), (float) textureRegion.getRegionHeight());
        setOrigin(this.width / 2.0f, this.height / 2.0f);
    }

    public Sprite(TextureRegion textureRegion, int i, int i2, int i3, int i4) {
        this.vertices = new float[20];
        this.color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dirty = true;
        setRegion(textureRegion, i, i2, i3, i4);
        setColor(1.0f, 1.0f, 1.0f, 1.0f);
        setSize((float) Math.abs(i3), (float) Math.abs(i4));
        setOrigin(this.width / 2.0f, this.height / 2.0f);
    }

    public Sprite(Sprite sprite) {
        this.vertices = new float[20];
        this.color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dirty = true;
        set(sprite);
    }
}

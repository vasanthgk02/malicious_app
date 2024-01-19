package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.math.MathUtils;

public class BlendingAttribute extends Attribute {
    public static final String Alias = "blended";
    public static final long Type = Attribute.register(Alias);
    public boolean blended;
    public int destFunction;
    public float opacity;
    public int sourceFunction;

    public BlendingAttribute() {
        this((BlendingAttribute) null);
    }

    public static final boolean is(long j) {
        return (Type & j) == j;
    }

    public int hashCode() {
        return (((((((super.hashCode() * 947) + (this.blended ? 1 : 0)) * 947) + this.sourceFunction) * 947) + this.destFunction) * 947) + Float.floatToRawIntBits(this.opacity);
    }

    public BlendingAttribute(boolean z, int i, int i2, float f2) {
        super(Type);
        this.opacity = 1.0f;
        this.blended = z;
        this.sourceFunction = i;
        this.destFunction = i2;
        this.opacity = f2;
    }

    public int compareTo(Attribute attribute) {
        long j = this.type;
        long j2 = attribute.type;
        if (j != j2) {
            return (int) (j - j2);
        }
        BlendingAttribute blendingAttribute = (BlendingAttribute) attribute;
        boolean z = this.blended;
        int i = 1;
        if (z != blendingAttribute.blended) {
            if (!z) {
                i = -1;
            }
            return i;
        }
        int i2 = this.sourceFunction;
        int i3 = blendingAttribute.sourceFunction;
        if (i2 != i3) {
            return i2 - i3;
        }
        int i4 = this.destFunction;
        int i5 = blendingAttribute.destFunction;
        if (i4 != i5) {
            return i4 - i5;
        }
        if (MathUtils.isEqual(this.opacity, blendingAttribute.opacity)) {
            i = 0;
        } else if (this.opacity >= blendingAttribute.opacity) {
            i = -1;
        }
        return i;
    }

    public BlendingAttribute copy() {
        return new BlendingAttribute(this);
    }

    public BlendingAttribute(int i, int i2, float f2) {
        this(true, i, i2, f2);
    }

    public BlendingAttribute(int i, int i2) {
        this(i, i2, 1.0f);
    }

    public BlendingAttribute(boolean z, float f2) {
        this(z, GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA, f2);
    }

    public BlendingAttribute(float f2) {
        this(true, f2);
    }

    public BlendingAttribute(BlendingAttribute blendingAttribute) {
        this(blendingAttribute == null || blendingAttribute.blended, blendingAttribute == null ? GL20.GL_SRC_ALPHA : blendingAttribute.sourceFunction, blendingAttribute == null ? GL20.GL_ONE_MINUS_SRC_ALPHA : blendingAttribute.destFunction, blendingAttribute == null ? 1.0f : blendingAttribute.opacity);
    }
}

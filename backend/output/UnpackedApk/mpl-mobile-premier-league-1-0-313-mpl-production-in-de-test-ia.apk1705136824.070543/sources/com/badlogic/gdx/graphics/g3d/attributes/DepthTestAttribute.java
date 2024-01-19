package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class DepthTestAttribute extends Attribute {
    public static final String Alias = "depthStencil";
    public static long Mask;
    public static final long Type;
    public int depthFunc;
    public boolean depthMask;
    public float depthRangeFar;
    public float depthRangeNear;

    static {
        long register = Attribute.register(Alias);
        Type = register;
        Mask = register;
    }

    public DepthTestAttribute() {
        this((int) GL20.GL_LEQUAL);
    }

    public static final boolean is(long j) {
        return (j & Mask) != 0;
    }

    public Attribute copy() {
        return new DepthTestAttribute(this);
    }

    public int hashCode() {
        return (((((((super.hashCode() * 971) + this.depthFunc) * 971) + Float.floatToRawIntBits(this.depthRangeNear)) * 971) + Float.floatToRawIntBits(this.depthRangeFar)) * 971) + (this.depthMask ? 1 : 0);
    }

    public DepthTestAttribute(boolean z) {
        this(GL20.GL_LEQUAL, z);
    }

    public int compareTo(Attribute attribute) {
        long j = this.type;
        long j2 = attribute.type;
        if (j != j2) {
            return (int) (j - j2);
        }
        DepthTestAttribute depthTestAttribute = (DepthTestAttribute) attribute;
        int i = this.depthFunc;
        int i2 = depthTestAttribute.depthFunc;
        if (i != i2) {
            return i - i2;
        }
        boolean z = this.depthMask;
        int i3 = -1;
        if (z != depthTestAttribute.depthMask) {
            if (!z) {
                i3 = 1;
            }
            return i3;
        } else if (!MathUtils.isEqual(this.depthRangeNear, depthTestAttribute.depthRangeNear)) {
            if (this.depthRangeNear >= depthTestAttribute.depthRangeNear) {
                i3 = 1;
            }
            return i3;
        } else if (MathUtils.isEqual(this.depthRangeFar, depthTestAttribute.depthRangeFar)) {
            return 0;
        } else {
            if (this.depthRangeFar >= depthTestAttribute.depthRangeFar) {
                i3 = 1;
            }
            return i3;
        }
    }

    public DepthTestAttribute(int i) {
        this(i, true);
    }

    public DepthTestAttribute(int i, boolean z) {
        this(i, 0.0f, 1.0f, z);
    }

    public DepthTestAttribute(int i, float f2, float f3) {
        this(i, f2, f3, true);
    }

    public DepthTestAttribute(int i, float f2, float f3, boolean z) {
        this(Type, i, f2, f3, z);
    }

    public DepthTestAttribute(long j, int i, float f2, float f3, boolean z) {
        super(j);
        if (is(j)) {
            this.depthFunc = i;
            this.depthRangeNear = f2;
            this.depthRangeFar = f3;
            this.depthMask = z;
            return;
        }
        throw new GdxRuntimeException((String) "Invalid type specified");
    }

    public DepthTestAttribute(DepthTestAttribute depthTestAttribute) {
        this(depthTestAttribute.type, depthTestAttribute.depthFunc, depthTestAttribute.depthRangeNear, depthTestAttribute.depthRangeFar, depthTestAttribute.depthMask);
    }
}

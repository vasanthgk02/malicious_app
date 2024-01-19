package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.math.MathUtils;

public class FloatAttribute extends Attribute {
    public static final long AlphaTest = Attribute.register(AlphaTestAlias);
    public static final String AlphaTestAlias = "alphaTest";
    public static final long Shininess = Attribute.register(ShininessAlias);
    public static final String ShininessAlias = "shininess";
    public float value;

    public FloatAttribute(long j) {
        super(j);
    }

    public static FloatAttribute createAlphaTest(float f2) {
        return new FloatAttribute(AlphaTest, f2);
    }

    public static FloatAttribute createShininess(float f2) {
        return new FloatAttribute(Shininess, f2);
    }

    public Attribute copy() {
        return new FloatAttribute(this.type, this.value);
    }

    public int hashCode() {
        return (super.hashCode() * 977) + Float.floatToRawIntBits(this.value);
    }

    public FloatAttribute(long j, float f2) {
        super(j);
        this.value = f2;
    }

    public int compareTo(Attribute attribute) {
        long j = this.type;
        long j2 = attribute.type;
        if (j != j2) {
            return (int) (j - j2);
        }
        float f2 = ((FloatAttribute) attribute).value;
        return MathUtils.isEqual(this.value, f2) ? 0 : this.value < f2 ? -1 : 1;
    }
}

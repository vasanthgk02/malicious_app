package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;

public class IntAttribute extends Attribute {
    public static final long CullFace = Attribute.register(CullFaceAlias);
    public static final String CullFaceAlias = "cullface";
    public int value;

    public IntAttribute(long j) {
        super(j);
    }

    public static IntAttribute createCullFace(int i) {
        return new IntAttribute(CullFace, i);
    }

    public Attribute copy() {
        return new IntAttribute(this.type, this.value);
    }

    public int hashCode() {
        return (super.hashCode() * 983) + this.value;
    }

    public IntAttribute(long j, int i) {
        super(j);
        this.value = i;
    }

    public int compareTo(Attribute attribute) {
        long j = this.type;
        long j2 = attribute.type;
        if (j != j2) {
            return (int) (j - j2);
        }
        return this.value - ((IntAttribute) attribute).value;
    }
}

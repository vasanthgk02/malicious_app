package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;

public class PointLightsAttribute extends Attribute {
    public static final String Alias = "pointLights";
    public static final long Type = Attribute.register(Alias);
    public final Array<PointLight> lights;

    public PointLightsAttribute() {
        super(Type);
        this.lights = new Array<>(true, 1);
    }

    public static final boolean is(long j) {
        return (Type & j) == j;
    }

    public int hashCode() {
        int i;
        int hashCode = super.hashCode();
        ArrayIterator it = this.lights.iterator();
        while (it.hasNext()) {
            PointLight pointLight = (PointLight) it.next();
            int i2 = hashCode * 1231;
            if (pointLight == null) {
                i = 0;
            } else {
                i = pointLight.hashCode();
            }
            hashCode = i2 + i;
        }
        return hashCode;
    }

    public int compareTo(Attribute attribute) {
        long j = this.type;
        long j2 = attribute.type;
        if (j == j2) {
            return 0;
        }
        return j < j2 ? -1 : 1;
    }

    public PointLightsAttribute copy() {
        return new PointLightsAttribute(this);
    }

    public PointLightsAttribute(PointLightsAttribute pointLightsAttribute) {
        this();
        this.lights.addAll(pointLightsAttribute.lights);
    }
}

package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.environment.SpotLight;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;

public class SpotLightsAttribute extends Attribute {
    public static final String Alias = "spotLights";
    public static final long Type = Attribute.register(Alias);
    public final Array<SpotLight> lights;

    public SpotLightsAttribute() {
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
            SpotLight spotLight = (SpotLight) it.next();
            int i2 = hashCode * 1237;
            if (spotLight == null) {
                i = 0;
            } else {
                i = spotLight.hashCode();
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

    public SpotLightsAttribute copy() {
        return new SpotLightsAttribute(this);
    }

    public SpotLightsAttribute(SpotLightsAttribute spotLightsAttribute) {
        this();
        this.lights.addAll(spotLightsAttribute.lights);
    }
}

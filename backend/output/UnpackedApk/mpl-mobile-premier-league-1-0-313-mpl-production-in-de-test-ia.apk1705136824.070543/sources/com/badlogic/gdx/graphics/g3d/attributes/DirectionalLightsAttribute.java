package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;

public class DirectionalLightsAttribute extends Attribute {
    public static final String Alias = "directionalLights";
    public static final long Type = Attribute.register(Alias);
    public final Array<DirectionalLight> lights;

    public DirectionalLightsAttribute() {
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
            DirectionalLight directionalLight = (DirectionalLight) it.next();
            int i2 = hashCode * 1229;
            if (directionalLight == null) {
                i = 0;
            } else {
                i = directionalLight.hashCode();
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

    public DirectionalLightsAttribute copy() {
        return new DirectionalLightsAttribute(this);
    }

    public DirectionalLightsAttribute(DirectionalLightsAttribute directionalLightsAttribute) {
        this();
        this.lights.addAll(directionalLightsAttribute.lights);
    }
}

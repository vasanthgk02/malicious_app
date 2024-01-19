package com.badlogic.gdx.graphics.g3d.environment;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;

public class PointLight extends BaseLight<PointLight> {
    public float intensity;
    public final Vector3 position = new Vector3();

    public boolean equals(Object obj) {
        return (obj instanceof PointLight) && equals((PointLight) obj);
    }

    public PointLight set(PointLight pointLight) {
        return set(pointLight.color, pointLight.position, pointLight.intensity);
    }

    public PointLight setIntensity(float f2) {
        this.intensity = f2;
        return this;
    }

    public PointLight setPosition(float f2, float f3, float f4) {
        Vector3 vector3 = this.position;
        vector3.x = f2;
        vector3.y = f3;
        vector3.z = f4;
        return this;
    }

    public boolean equals(PointLight pointLight) {
        return pointLight != null && (pointLight == this || (this.color.equals(pointLight.color) && this.position.equals(pointLight.position) && this.intensity == pointLight.intensity));
    }

    public PointLight set(Color color, Vector3 vector3, float f2) {
        if (color != null) {
            this.color.set(color);
        }
        if (vector3 != null) {
            this.position.set(vector3);
        }
        this.intensity = f2;
        return this;
    }

    public PointLight set(float f2, float f3, float f4, Vector3 vector3, float f5) {
        this.color.set(f2, f3, f4, 1.0f);
        if (vector3 != null) {
            this.position.set(vector3);
        }
        this.intensity = f5;
        return this;
    }

    public PointLight setPosition(Vector3 vector3) {
        this.position.set(vector3);
        return this;
    }

    public PointLight set(Color color, float f2, float f3, float f4, float f5) {
        if (color != null) {
            this.color.set(color);
        }
        Vector3 vector3 = this.position;
        vector3.x = f2;
        vector3.y = f3;
        vector3.z = f4;
        this.intensity = f5;
        return this;
    }

    public PointLight set(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.color.set(f2, f3, f4, 1.0f);
        Vector3 vector3 = this.position;
        vector3.x = f5;
        vector3.y = f6;
        vector3.z = f7;
        this.intensity = f8;
        return this;
    }
}

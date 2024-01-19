package com.badlogic.gdx.graphics.g3d.environment;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public class SpotLight extends BaseLight<SpotLight> {
    public float cutoffAngle;
    public final Vector3 direction = new Vector3();
    public float exponent;
    public float intensity;
    public final Vector3 position = new Vector3();

    public boolean equals(Object obj) {
        return (obj instanceof SpotLight) && equals((SpotLight) obj);
    }

    public SpotLight set(SpotLight spotLight) {
        return set(spotLight.color, spotLight.position, spotLight.direction, spotLight.intensity, spotLight.cutoffAngle, spotLight.exponent);
    }

    public SpotLight setCutoffAngle(float f2) {
        this.cutoffAngle = f2;
        return this;
    }

    public SpotLight setDirection(float f2, float f3, float f4) {
        Vector3 vector3 = this.direction;
        vector3.x = f2;
        vector3.y = f3;
        vector3.z = f4;
        return this;
    }

    public SpotLight setExponent(float f2) {
        this.exponent = f2;
        return this;
    }

    public SpotLight setIntensity(float f2) {
        this.intensity = f2;
        return this;
    }

    public SpotLight setPosition(float f2, float f3, float f4) {
        Vector3 vector3 = this.position;
        vector3.x = f2;
        vector3.y = f3;
        vector3.z = f4;
        return this;
    }

    public SpotLight setTarget(Vector3 vector3) {
        Vector3 vector32 = this.direction;
        vector32.set(vector3);
        vector32.sub(this.position);
        vector32.nor();
        return this;
    }

    public boolean equals(SpotLight spotLight) {
        return spotLight != null && (spotLight == this || (this.color.equals(spotLight.color) && this.position.equals(spotLight.position) && this.direction.equals(spotLight.direction) && MathUtils.isEqual(this.intensity, spotLight.intensity) && MathUtils.isEqual(this.cutoffAngle, spotLight.cutoffAngle) && MathUtils.isEqual(this.exponent, spotLight.exponent)));
    }

    public SpotLight set(Color color, Vector3 vector3, Vector3 vector32, float f2, float f3, float f4) {
        if (color != null) {
            this.color.set(color);
        }
        if (vector3 != null) {
            this.position.set(vector3);
        }
        if (vector32 != null) {
            Vector3 vector33 = this.direction;
            vector33.set(vector32);
            vector33.nor();
        }
        this.intensity = f2;
        this.cutoffAngle = f3;
        this.exponent = f4;
        return this;
    }

    public SpotLight setDirection(Vector3 vector3) {
        this.direction.set(vector3);
        return this;
    }

    public SpotLight setPosition(Vector3 vector3) {
        this.position.set(vector3);
        return this;
    }

    public SpotLight set(float f2, float f3, float f4, Vector3 vector3, Vector3 vector32, float f5, float f6, float f7) {
        this.color.set(f2, f3, f4, 1.0f);
        if (vector3 != null) {
            this.position.set(vector3);
        }
        if (vector32 != null) {
            Vector3 vector33 = this.direction;
            vector33.set(vector32);
            vector33.nor();
        }
        this.intensity = f5;
        this.cutoffAngle = f6;
        this.exponent = f7;
        return this;
    }

    public SpotLight set(Color color, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        if (color != null) {
            this.color.set(color);
        }
        Vector3 vector3 = this.position;
        vector3.x = f2;
        vector3.y = f3;
        vector3.z = f4;
        Vector3 vector32 = this.direction;
        vector32.x = f5;
        vector32.y = f6;
        vector32.z = f7;
        vector32.nor();
        this.intensity = f8;
        this.cutoffAngle = f9;
        this.exponent = f10;
        return this;
    }

    public SpotLight set(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        this.color.set(f2, f3, f4, 1.0f);
        Vector3 vector3 = this.position;
        vector3.x = f5;
        vector3.y = f6;
        vector3.z = f7;
        Vector3 vector32 = this.direction;
        vector32.x = f8;
        vector32.y = f9;
        vector32.z = f10;
        vector32.nor();
        this.intensity = f11;
        this.cutoffAngle = f12;
        this.exponent = f13;
        return this;
    }
}

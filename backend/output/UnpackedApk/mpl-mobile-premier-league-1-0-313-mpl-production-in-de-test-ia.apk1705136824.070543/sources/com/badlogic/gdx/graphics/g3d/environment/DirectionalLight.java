package com.badlogic.gdx.graphics.g3d.environment;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;

public class DirectionalLight extends BaseLight<DirectionalLight> {
    public final Vector3 direction = new Vector3();

    public boolean equals(Object obj) {
        return (obj instanceof DirectionalLight) && equals((DirectionalLight) obj);
    }

    public DirectionalLight set(DirectionalLight directionalLight) {
        return set(directionalLight.color, directionalLight.direction);
    }

    public DirectionalLight setDirection(float f2, float f3, float f4) {
        Vector3 vector3 = this.direction;
        vector3.x = f2;
        vector3.y = f3;
        vector3.z = f4;
        return this;
    }

    public boolean equals(DirectionalLight directionalLight) {
        return directionalLight != null && (directionalLight == this || (this.color.equals(directionalLight.color) && this.direction.equals(directionalLight.direction)));
    }

    public DirectionalLight set(Color color, Vector3 vector3) {
        if (color != null) {
            this.color.set(color);
        }
        if (vector3 != null) {
            Vector3 vector32 = this.direction;
            vector32.set(vector3);
            vector32.nor();
        }
        return this;
    }

    public DirectionalLight set(float f2, float f3, float f4, Vector3 vector3) {
        this.color.set(f2, f3, f4, 1.0f);
        if (vector3 != null) {
            Vector3 vector32 = this.direction;
            vector32.set(vector3);
            vector32.nor();
        }
        return this;
    }

    public DirectionalLight setDirection(Vector3 vector3) {
        this.direction.set(vector3);
        return this;
    }

    public DirectionalLight set(Color color, float f2, float f3, float f4) {
        if (color != null) {
            this.color.set(color);
        }
        Vector3 vector3 = this.direction;
        vector3.x = f2;
        vector3.y = f3;
        vector3.z = f4;
        vector3.nor();
        return this;
    }

    public DirectionalLight set(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.color.set(f2, f3, f4, 1.0f);
        Vector3 vector3 = this.direction;
        vector3.x = f5;
        vector3.y = f6;
        vector3.z = f7;
        vector3.nor();
        return this;
    }
}

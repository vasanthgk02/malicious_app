package com.badlogic.gdx.math;

import java.io.Serializable;

public class Plane implements Serializable {
    public static final long serialVersionUID = -1240652082930747866L;

    /* renamed from: d  reason: collision with root package name */
    public float f3310d = 0.0f;
    public final Vector3 normal;

    public Plane(Vector3 vector3, float f2) {
        Vector3 vector32 = new Vector3();
        this.normal = vector32;
        vector32.set(vector3);
        vector32.nor();
        this.f3310d = f2;
    }

    public void set(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        Vector3 vector34 = this.normal;
        vector34.set(vector3);
        vector34.sub(vector32);
        vector34.crs(vector32.x - vector33.x, vector32.y - vector33.y, vector32.z - vector33.z);
        vector34.nor();
        this.f3310d = -vector3.dot(this.normal);
    }

    public String toString() {
        return this.normal.toString() + ", " + this.f3310d;
    }
}

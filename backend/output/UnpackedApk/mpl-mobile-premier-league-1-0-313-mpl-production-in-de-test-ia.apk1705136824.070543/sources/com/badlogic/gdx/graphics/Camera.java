package com.badlogic.gdx.graphics;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.math.Frustum;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;

public abstract class Camera {
    public final Matrix4 combined = new Matrix4();
    public final Vector3 direction = new Vector3(0.0f, 0.0f, -1.0f);
    public float far = 100.0f;
    public final Frustum frustum = new Frustum();
    public final Matrix4 invProjectionView = new Matrix4();
    public float near = 1.0f;
    public final Vector3 position = new Vector3();
    public final Matrix4 projection = new Matrix4();
    public final Ray ray = new Ray(new Vector3(), new Vector3());
    public final Vector3 tmpVec = new Vector3();
    public final Vector3 up = new Vector3(0.0f, 1.0f, 0.0f);
    public final Matrix4 view = new Matrix4();
    public float viewportHeight = 0.0f;
    public float viewportWidth = 0.0f;

    public Ray getPickRay(float f2, float f3, float f4, float f5, float f6, float f7) {
        Vector3 vector3 = this.ray.origin;
        vector3.x = f2;
        vector3.y = f3;
        vector3.z = 0.0f;
        unproject(vector3, f4, f5, f6, f7);
        Vector3 vector32 = this.ray.direction;
        vector32.x = f2;
        vector32.y = f3;
        vector32.z = 1.0f;
        unproject(vector32, f4, f5, f6, f7);
        Ray ray2 = this.ray;
        Vector3 vector33 = ray2.direction;
        vector33.sub(ray2.origin);
        vector33.nor();
        return this.ray;
    }

    public void lookAt(float f2, float f3, float f4) {
        Vector3 vector3 = this.tmpVec;
        vector3.x = f2;
        vector3.y = f3;
        vector3.z = f4;
        vector3.sub(this.position);
        vector3.nor();
        if (!this.tmpVec.isZero()) {
            float dot = this.tmpVec.dot(this.up);
            if (Math.abs(dot - 1.0f) < 1.0E-9f) {
                Vector3 vector32 = this.up;
                vector32.set(this.direction);
                vector32.scl(-1.0f);
            } else if (Math.abs(dot + 1.0f) < 1.0E-9f) {
                this.up.set(this.direction);
            }
            this.direction.set(this.tmpVec);
            normalizeUp();
        }
    }

    public void normalizeUp() {
        Vector3 vector3 = this.tmpVec;
        vector3.set(this.direction);
        vector3.crs(this.up);
        Vector3 vector32 = this.up;
        vector32.set(this.tmpVec);
        vector32.crs(this.direction);
        vector32.nor();
    }

    public Vector3 project(Vector3 vector3) {
        Graphics graphics = k.graphics;
        project(vector3, 0.0f, 0.0f, (float) ((AndroidGraphics) graphics).width, (float) ((AndroidGraphics) graphics).height);
        return vector3;
    }

    public void rotate(float f2, float f3, float f4, float f5) {
        this.direction.rotate(f2, f3, f4, f5);
        this.up.rotate(f2, f3, f4, f5);
    }

    public void rotateAround(Vector3 vector3, Vector3 vector32, float f2) {
        this.tmpVec.set(vector3);
        this.tmpVec.sub(this.position);
        translate(this.tmpVec);
        rotate(vector32, f2);
        this.tmpVec.rotate(vector32, f2);
        Vector3 vector33 = this.tmpVec;
        translate(-vector33.x, -vector33.y, -vector33.z);
    }

    public void transform(Matrix4 matrix4) {
        this.position.mul(matrix4);
        rotate(matrix4);
    }

    public void translate(float f2, float f3, float f4) {
        this.position.add(f2, f3, f4);
    }

    public Vector3 unproject(Vector3 vector3, float f2, float f3, float f4, float f5) {
        float f6 = vector3.x;
        float f7 = vector3.y;
        vector3.x = (((f6 - f2) * 2.0f) / f4) - 1.0f;
        vector3.y = ((((((float) ((AndroidGraphics) k.graphics).height) - f7) - f3) * 2.0f) / f5) - 1.0f;
        vector3.z = (vector3.z * 2.0f) - 1.0f;
        vector3.prj(this.invProjectionView);
        return vector3;
    }

    public abstract void update();

    public abstract void update(boolean z);

    public void translate(Vector3 vector3) {
        this.position.add(vector3);
    }

    public void rotate(Vector3 vector3, float f2) {
        this.direction.rotate(vector3, f2);
        this.up.rotate(vector3, f2);
    }

    public void rotate(Matrix4 matrix4) {
        this.direction.rot(matrix4);
        this.up.rot(matrix4);
    }

    public Vector3 project(Vector3 vector3, float f2, float f3, float f4, float f5) {
        vector3.prj(this.combined);
        vector3.x = (((vector3.x + 1.0f) * f4) / 2.0f) + f2;
        vector3.y = (((vector3.y + 1.0f) * f5) / 2.0f) + f3;
        vector3.z = (vector3.z + 1.0f) / 2.0f;
        return vector3;
    }

    public void rotate(Quaternion quaternion) {
        quaternion.transform(this.direction);
        quaternion.transform(this.up);
    }

    public Vector3 unproject(Vector3 vector3) {
        Graphics graphics = k.graphics;
        unproject(vector3, 0.0f, 0.0f, (float) ((AndroidGraphics) graphics).width, (float) ((AndroidGraphics) graphics).height);
        return vector3;
    }

    public Ray getPickRay(float f2, float f3) {
        Graphics graphics = k.graphics;
        return getPickRay(f2, f3, 0.0f, 0.0f, (float) ((AndroidGraphics) graphics).width, (float) ((AndroidGraphics) graphics).height);
    }

    public void lookAt(Vector3 vector3) {
        lookAt(vector3.x, vector3.y, vector3.z);
    }
}

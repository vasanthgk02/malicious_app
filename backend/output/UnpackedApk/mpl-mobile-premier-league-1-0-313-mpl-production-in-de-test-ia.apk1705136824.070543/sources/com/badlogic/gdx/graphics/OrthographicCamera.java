package com.badlogic.gdx.graphics;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class OrthographicCamera extends Camera {
    public final Vector3 tmp = new Vector3();
    public float zoom = 1.0f;

    public OrthographicCamera() {
        this.near = 0.0f;
    }

    public void rotate(float f2) {
        rotate(this.direction, f2);
    }

    public void setToOrtho(boolean z) {
        Graphics graphics = k.graphics;
        setToOrtho(z, (float) ((AndroidGraphics) graphics).width, (float) ((AndroidGraphics) graphics).height);
    }

    public void translate(float f2, float f3) {
        translate(f2, f3, 0.0f);
    }

    public void update() {
        update(true);
    }

    public void translate(Vector2 vector2) {
        translate(vector2.x, vector2.y, 0.0f);
    }

    public void update(boolean z) {
        Matrix4 matrix4 = this.projection;
        float f2 = this.zoom;
        float f3 = this.viewportWidth;
        float f4 = this.viewportHeight;
        float f5 = (-(f4 / 2.0f)) * f2;
        matrix4.setToOrtho(((-f3) * f2) / 2.0f, (f3 / 2.0f) * f2, f5, (f2 * f4) / 2.0f, this.near, this.far);
        Matrix4 matrix42 = this.view;
        Vector3 vector3 = this.position;
        Vector3 vector32 = this.tmp;
        vector32.set(vector3);
        vector32.add(this.direction);
        matrix42.setToLookAt(vector3, vector32, this.up);
        this.combined.set(this.projection);
        Matrix4.mul(this.combined.val, this.view.val);
        if (z) {
            this.invProjectionView.set(this.combined);
            Matrix4.inv(this.invProjectionView.val);
            this.frustum.update(this.invProjectionView);
        }
    }

    public OrthographicCamera(float f2, float f3) {
        this.viewportWidth = f2;
        this.viewportHeight = f3;
        this.near = 0.0f;
        update();
    }

    public void setToOrtho(boolean z, float f2, float f3) {
        if (z) {
            this.up.set(0.0f, -1.0f, 0.0f);
            this.direction.set(0.0f, 0.0f, 1.0f);
        } else {
            this.up.set(0.0f, 1.0f, 0.0f);
            this.direction.set(0.0f, 0.0f, -1.0f);
        }
        Vector3 vector3 = this.position;
        float f4 = this.zoom;
        vector3.set((f4 * f2) / 2.0f, (f4 * f3) / 2.0f, 0.0f);
        this.viewportWidth = f2;
        this.viewportHeight = f3;
        update();
    }
}

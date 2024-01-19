package com.badlogic.gdx.graphics;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

public class PerspectiveCamera extends Camera {
    public float fieldOfView = 67.0f;
    public final Vector3 tmp = new Vector3();

    public PerspectiveCamera() {
    }

    public void update() {
        update(true);
    }

    public void update(boolean z) {
        float f2 = this.viewportWidth / this.viewportHeight;
        Matrix4 matrix4 = this.projection;
        float abs = Math.abs(this.near);
        float abs2 = Math.abs(this.far);
        float f3 = this.fieldOfView;
        matrix4.idt();
        float tan = (float) (1.0d / Math.tan((((double) f3) * 0.017453292519943295d) / 2.0d));
        float f4 = abs - abs2;
        float[] fArr = matrix4.val;
        fArr[0] = tan / f2;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = tan;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = (abs2 + abs) / f4;
        fArr[11] = -1.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = ((abs2 * 2.0f) * abs) / f4;
        fArr[15] = 0.0f;
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

    public PerspectiveCamera(float f2, float f3, float f4) {
        this.fieldOfView = f2;
        this.viewportWidth = f3;
        this.viewportHeight = f4;
        update();
    }
}

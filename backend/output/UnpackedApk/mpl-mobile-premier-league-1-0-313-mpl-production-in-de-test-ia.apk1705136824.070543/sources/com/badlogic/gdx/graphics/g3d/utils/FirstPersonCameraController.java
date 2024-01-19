package com.badlogic.gdx.graphics.g3d.utils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.backends.android.DefaultAndroidInput;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.IntIntMap;

public class FirstPersonCameraController extends InputAdapter {
    public int BACKWARD = 47;
    public int DOWN = 33;
    public int FORWARD = 51;
    public int STRAFE_LEFT = 29;
    public int STRAFE_RIGHT = 32;
    public int UP = 45;
    public final Camera camera;
    public float degreesPerPixel = 0.5f;
    public final IntIntMap keys = new IntIntMap(51, 0.8f);
    public final Vector3 tmp = new Vector3();
    public float velocity = 5.0f;

    public FirstPersonCameraController(Camera camera2) {
        this.camera = camera2;
    }

    public boolean keyDown(int i) {
        this.keys.put(i, i);
        return true;
    }

    public boolean keyUp(int i) {
        IntIntMap intIntMap = this.keys;
        if (i != 0) {
            int locateKey = intIntMap.locateKey(i);
            if (locateKey >= 0) {
                int[] iArr = intIntMap.keyTable;
                int[] iArr2 = intIntMap.valueTable;
                int i2 = iArr2[locateKey];
                int i3 = intIntMap.mask;
                int i4 = locateKey + 1;
                while (true) {
                    int i5 = i4 & i3;
                    int i6 = iArr[i5];
                    if (i6 == 0) {
                        break;
                    }
                    int place = intIntMap.place(i6);
                    if (((i5 - place) & i3) > ((locateKey - place) & i3)) {
                        iArr[locateKey] = i6;
                        iArr2[locateKey] = iArr2[i5];
                        locateKey = i5;
                    }
                    i4 = i5 + 1;
                }
                iArr[locateKey] = 0;
                intIntMap.size--;
            }
        } else if (intIntMap.hasZeroValue) {
            intIntMap.hasZeroValue = false;
            intIntMap.size--;
        }
        return true;
    }

    public void setDegreesPerPixel(float f2) {
        this.degreesPerPixel = f2;
    }

    public void setVelocity(float f2) {
        this.velocity = f2;
    }

    public boolean touchDragged(int i, int i2, int i3) {
        Input input = k.input;
        float f2 = this.degreesPerPixel;
        float f3 = ((float) (-((DefaultAndroidInput) input).deltaX[0])) * f2;
        float f4 = ((float) (-((DefaultAndroidInput) input).deltaY[0])) * f2;
        Camera camera2 = this.camera;
        camera2.direction.rotate(camera2.up, f3);
        Vector3 vector3 = this.tmp;
        vector3.set(this.camera.direction);
        vector3.crs(this.camera.up);
        vector3.nor();
        this.camera.direction.rotate(this.tmp, f4);
        return true;
    }

    public void update() {
        update(((AndroidGraphics) k.graphics).deltaTime);
    }

    public void update(float f2) {
        if (this.keys.containsKey(this.FORWARD)) {
            Vector3 vector3 = this.tmp;
            vector3.set(this.camera.direction);
            vector3.nor().scl(this.velocity * f2);
            this.camera.position.add(this.tmp);
        }
        if (this.keys.containsKey(this.BACKWARD)) {
            Vector3 vector32 = this.tmp;
            vector32.set(this.camera.direction);
            vector32.nor().scl((-f2) * this.velocity);
            this.camera.position.add(this.tmp);
        }
        if (this.keys.containsKey(this.STRAFE_LEFT)) {
            Vector3 vector33 = this.tmp;
            vector33.set(this.camera.direction);
            vector33.crs(this.camera.up);
            vector33.nor().scl((-f2) * this.velocity);
            this.camera.position.add(this.tmp);
        }
        if (this.keys.containsKey(this.STRAFE_RIGHT)) {
            Vector3 vector34 = this.tmp;
            vector34.set(this.camera.direction);
            vector34.crs(this.camera.up);
            vector34.nor().scl(this.velocity * f2);
            this.camera.position.add(this.tmp);
        }
        if (this.keys.containsKey(this.UP)) {
            Vector3 vector35 = this.tmp;
            vector35.set(this.camera.up);
            vector35.nor().scl(this.velocity * f2);
            this.camera.position.add(this.tmp);
        }
        if (this.keys.containsKey(this.DOWN)) {
            Vector3 vector36 = this.tmp;
            vector36.set(this.camera.up);
            vector36.nor().scl((-f2) * this.velocity);
            this.camera.position.add(this.tmp);
        }
        this.camera.update(true);
    }
}

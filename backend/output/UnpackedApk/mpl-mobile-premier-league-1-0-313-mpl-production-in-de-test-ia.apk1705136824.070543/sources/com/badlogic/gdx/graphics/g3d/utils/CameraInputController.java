package com.badlogic.gdx.graphics.g3d.utils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureAdapter;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class CameraInputController extends GestureDetector {
    public int activateKey;
    public boolean activatePressed;
    public boolean alwaysScroll;
    public boolean autoUpdate;
    public int backwardKey;
    public boolean backwardPressed;
    public int button;
    public Camera camera;
    public int forwardButton;
    public int forwardKey;
    public boolean forwardPressed;
    public boolean forwardTarget;
    public final CameraGestureListener gestureListener;
    public boolean multiTouch;
    public float pinchZoomFactor;
    public float rotateAngle;
    public int rotateButton;
    public int rotateLeftKey;
    public boolean rotateLeftPressed;
    public int rotateRightKey;
    public boolean rotateRightPressed;
    public float scrollFactor;
    public boolean scrollTarget;
    public float startX;
    public float startY;
    public Vector3 target;
    public final Vector3 tmpV1;
    public final Vector3 tmpV2;
    public int touched;
    public int translateButton;
    public boolean translateTarget;
    public float translateUnits;

    public static class CameraGestureListener extends GestureAdapter {
        public CameraInputController controller;
        public float previousZoom;

        public boolean fling(float f2, float f3, int i) {
            return false;
        }

        public boolean longPress(float f2, float f3) {
            return false;
        }

        public boolean pan(float f2, float f3, float f4, float f5) {
            return false;
        }

        public boolean pinch(Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24) {
            return false;
        }

        public boolean tap(float f2, float f3, int i, int i2) {
            return false;
        }

        public boolean touchDown(float f2, float f3, int i, int i2) {
            this.previousZoom = 0.0f;
            return false;
        }

        public boolean zoom(float f2, float f3) {
            float f4 = f3 - f2;
            float f5 = f4 - this.previousZoom;
            this.previousZoom = f4;
            Graphics graphics = k.graphics;
            float f6 = (float) ((AndroidGraphics) graphics).width;
            float f7 = (float) ((AndroidGraphics) graphics).height;
            CameraInputController cameraInputController = this.controller;
            if (f6 > f7) {
                f6 = f7;
            }
            return cameraInputController.pinchZoom(f5 / f6);
        }
    }

    public CameraInputController(CameraGestureListener cameraGestureListener, Camera camera2) {
        super(cameraGestureListener);
        this.rotateButton = 0;
        this.rotateAngle = 360.0f;
        this.translateButton = 1;
        this.translateUnits = 10.0f;
        this.forwardButton = 2;
        this.activateKey = 0;
        this.alwaysScroll = true;
        this.scrollFactor = -0.1f;
        this.pinchZoomFactor = 10.0f;
        this.autoUpdate = true;
        this.target = new Vector3();
        this.translateTarget = true;
        this.forwardTarget = true;
        this.scrollTarget = false;
        this.forwardKey = 51;
        this.backwardKey = 47;
        this.rotateRightKey = 29;
        this.rotateLeftKey = 32;
        this.button = -1;
        this.tmpV1 = new Vector3();
        this.tmpV2 = new Vector3();
        this.gestureListener = cameraGestureListener;
        cameraGestureListener.controller = this;
        this.camera = camera2;
    }

    public boolean keyDown(int i) {
        if (i == this.activateKey) {
            this.activatePressed = true;
        }
        if (i == this.forwardKey) {
            this.forwardPressed = true;
        } else if (i == this.backwardKey) {
            this.backwardPressed = true;
        } else if (i == this.rotateRightKey) {
            this.rotateRightPressed = true;
        } else if (i == this.rotateLeftKey) {
            this.rotateLeftPressed = true;
        }
        return false;
    }

    public boolean keyUp(int i) {
        if (i == this.activateKey) {
            this.activatePressed = false;
            this.button = -1;
        }
        if (i == this.forwardKey) {
            this.forwardPressed = false;
        } else if (i == this.backwardKey) {
            this.backwardPressed = false;
        } else if (i == this.rotateRightKey) {
            this.rotateRightPressed = false;
        } else if (i == this.rotateLeftKey) {
            this.rotateLeftPressed = false;
        }
        return false;
    }

    public boolean pinchZoom(float f2) {
        return zoom(this.pinchZoomFactor * f2);
    }

    public boolean process(float f2, float f3, int i) {
        if (i == this.rotateButton) {
            Vector3 vector3 = this.tmpV1;
            vector3.set(this.camera.direction);
            vector3.crs(this.camera.up);
            vector3.y = 0.0f;
            this.camera.rotateAround(this.target, this.tmpV1.nor(), f3 * this.rotateAngle);
            this.camera.rotateAround(this.target, Vector3.Y, f2 * (-this.rotateAngle));
        } else if (i == this.translateButton) {
            Camera camera2 = this.camera;
            Vector3 vector32 = this.tmpV1;
            vector32.set(camera2.direction);
            vector32.crs(this.camera.up);
            Vector3 nor = vector32.nor();
            nor.scl((-f2) * this.translateUnits);
            camera2.translate(nor);
            Camera camera3 = this.camera;
            Vector3 vector33 = this.tmpV2;
            vector33.set(camera3.up);
            vector33.scl((-f3) * this.translateUnits);
            camera3.translate(vector33);
            if (this.translateTarget) {
                Vector3 vector34 = this.target;
                vector34.add(this.tmpV1);
                vector34.add(this.tmpV2);
            }
        } else if (i == this.forwardButton) {
            Camera camera4 = this.camera;
            Vector3 vector35 = this.tmpV1;
            vector35.set(camera4.direction);
            vector35.scl(f3 * this.translateUnits);
            camera4.translate(vector35);
            if (this.forwardTarget) {
                this.target.add(this.tmpV1);
            }
        }
        if (this.autoUpdate) {
            this.camera.update();
        }
        return true;
    }

    public boolean scrolled(float f2, float f3) {
        return zoom(f3 * this.scrollFactor * this.translateUnits);
    }

    public boolean touchDown(int i, int i2, int i3, int i4) {
        int i5 = this.touched | (1 << i3);
        this.touched = i5;
        boolean z = !MathUtils.isPowerOfTwo(i5);
        this.multiTouch = z;
        if (z) {
            this.button = -1;
        } else if (this.button < 0 && (this.activateKey == 0 || this.activatePressed)) {
            this.startX = (float) i;
            this.startY = (float) i2;
            this.button = i4;
        }
        if (super.touchDown(i, i2, i3, i4) || this.activateKey == 0 || this.activatePressed) {
            return true;
        }
        return false;
    }

    public boolean touchDragged(int i, int i2, int i3) {
        boolean z = super.touchDragged(i, i2, i3);
        if (!z) {
            int i4 = this.button;
            if (i4 >= 0) {
                float f2 = (float) i;
                Graphics graphics = k.graphics;
                float f3 = (float) i2;
                this.startX = f2;
                this.startY = f3;
                return process((f2 - this.startX) / ((float) ((AndroidGraphics) graphics).width), (this.startY - f3) / ((float) ((AndroidGraphics) graphics).height), i4);
            }
        }
        return z;
    }

    public boolean touchUp(int i, int i2, int i3, int i4) {
        int i5 = this.touched & ((1 << i3) ^ -1);
        this.touched = i5;
        this.multiTouch = !MathUtils.isPowerOfTwo(i5);
        if (i4 == this.button) {
            this.button = -1;
        }
        if (super.touchUp(i, i2, i3, i4) || this.activatePressed) {
            return true;
        }
        return false;
    }

    public void update() {
        if (this.rotateRightPressed || this.rotateLeftPressed || this.forwardPressed || this.backwardPressed) {
            float f2 = ((AndroidGraphics) k.graphics).deltaTime;
            if (this.rotateRightPressed) {
                Camera camera2 = this.camera;
                camera2.rotate(camera2.up, (-f2) * this.rotateAngle);
            }
            if (this.rotateLeftPressed) {
                Camera camera3 = this.camera;
                camera3.rotate(camera3.up, this.rotateAngle * f2);
            }
            if (this.forwardPressed) {
                Camera camera4 = this.camera;
                Vector3 vector3 = this.tmpV1;
                vector3.set(camera4.direction);
                vector3.scl(this.translateUnits * f2);
                camera4.translate(vector3);
                if (this.forwardTarget) {
                    this.target.add(this.tmpV1);
                }
            }
            if (this.backwardPressed) {
                Camera camera5 = this.camera;
                Vector3 vector32 = this.tmpV1;
                vector32.set(camera5.direction);
                vector32.scl((-f2) * this.translateUnits);
                camera5.translate(vector32);
                if (this.forwardTarget) {
                    this.target.add(this.tmpV1);
                }
            }
            if (this.autoUpdate) {
                this.camera.update();
            }
        }
    }

    public boolean zoom(float f2) {
        if (!this.alwaysScroll && this.activateKey != 0 && !this.activatePressed) {
            return false;
        }
        Camera camera2 = this.camera;
        Vector3 vector3 = this.tmpV1;
        vector3.set(camera2.direction);
        vector3.scl(f2);
        camera2.translate(vector3);
        if (this.scrollTarget) {
            this.target.add(this.tmpV1);
        }
        if (this.autoUpdate) {
            this.camera.update();
        }
        return true;
    }

    public CameraInputController(Camera camera2) {
        this(new CameraGestureListener(), camera2);
    }
}

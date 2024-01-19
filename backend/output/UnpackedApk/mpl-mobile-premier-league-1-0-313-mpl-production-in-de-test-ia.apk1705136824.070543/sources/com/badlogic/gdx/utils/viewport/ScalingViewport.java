package com.badlogic.gdx.utils.viewport;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.HdpiUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Scaling;

public class ScalingViewport {
    public Camera camera;
    public Scaling scaling;
    public int screenHeight;
    public int screenWidth;
    public int screenX;
    public int screenY;
    public final Vector3 tmp = new Vector3();
    public float worldHeight;
    public float worldWidth;

    public ScalingViewport(Scaling scaling2, float f2, float f3) {
        OrthographicCamera orthographicCamera = new OrthographicCamera();
        this.scaling = scaling2;
        this.worldWidth = f2;
        this.worldHeight = f3;
        this.camera = orthographicCamera;
    }

    public void update(int i, int i2, boolean z) {
        Vector2 apply = this.scaling.apply(this.worldWidth, this.worldHeight, (float) i, (float) i2);
        int round = Math.round(apply.x);
        int round2 = Math.round(apply.y);
        int i3 = (i - round) / 2;
        int i4 = (i2 - round2) / 2;
        this.screenX = i3;
        this.screenY = i4;
        this.screenWidth = round;
        this.screenHeight = round2;
        HdpiUtils.glViewport(i3, i4, round, round2);
        Camera camera2 = this.camera;
        float f2 = this.worldWidth;
        camera2.viewportWidth = f2;
        float f3 = this.worldHeight;
        camera2.viewportHeight = f3;
        if (z) {
            camera2.position.set(f2 / 2.0f, f3 / 2.0f, 0.0f);
        }
        this.camera.update();
    }
}

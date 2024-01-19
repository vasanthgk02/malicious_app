package com.badlogic.gdx.graphics.g3d.environment;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Disposable;

public class DirectionalShadowLight extends DirectionalLight implements ShadowMap, Disposable {
    public Camera cam;
    public FrameBuffer fbo;
    public float halfDepth;
    public float halfHeight;
    public final TextureDescriptor textureDesc;
    public final Vector3 tmpV = new Vector3();

    public DirectionalShadowLight(int i, int i2, float f2, float f3, float f4, float f5) {
        this.fbo = new FrameBuffer(Format.RGBA8888, i, i2, true);
        OrthographicCamera orthographicCamera = new OrthographicCamera(f2, f3);
        this.cam = orthographicCamera;
        orthographicCamera.near = f4;
        orthographicCamera.far = f5;
        this.halfHeight = f3 * 0.5f;
        this.halfDepth = GeneratedOutlineSupport.outline3(f5, f4, 0.5f, f4);
        TextureDescriptor textureDescriptor = new TextureDescriptor();
        this.textureDesc = textureDescriptor;
        TextureFilter textureFilter = TextureFilter.Nearest;
        textureDescriptor.magFilter = textureFilter;
        textureDescriptor.minFilter = textureFilter;
        TextureWrap textureWrap = TextureWrap.ClampToEdge;
        textureDescriptor.vWrap = textureWrap;
        textureDescriptor.uWrap = textureWrap;
    }

    public void begin(Camera camera) {
        update(camera);
        begin();
    }

    public void dispose() {
        FrameBuffer frameBuffer = this.fbo;
        if (frameBuffer != null) {
            frameBuffer.dispose();
        }
        this.fbo = null;
    }

    public void end() {
        k.gl.glDisable(GL20.GL_SCISSOR_TEST);
        this.fbo.end();
    }

    public Camera getCamera() {
        return this.cam;
    }

    public TextureDescriptor getDepthMap() {
        this.textureDesc.texture = this.fbo.getColorBufferTexture();
        return this.textureDesc;
    }

    public FrameBuffer getFrameBuffer() {
        return this.fbo;
    }

    public Matrix4 getProjViewTrans() {
        return this.cam.combined;
    }

    public void update(Camera camera) {
        Vector3 vector3 = this.tmpV;
        vector3.set(camera.direction);
        vector3.scl(this.halfHeight);
        update(vector3, camera.direction);
    }

    public void update(Vector3 vector3, Vector3 vector32) {
        Vector3 vector33 = this.cam.position;
        vector33.set(this.direction);
        vector33.scl(-this.halfDepth);
        vector33.add(vector3);
        Vector3 vector34 = this.cam.direction;
        vector34.set(this.direction);
        vector34.nor();
        this.cam.normalizeUp();
        this.cam.update();
    }

    public void begin(Vector3 vector3, Vector3 vector32) {
        update(vector3, vector32);
        begin();
    }

    public void begin() {
        int width = this.fbo.getWidth();
        int height = this.fbo.getHeight();
        this.fbo.begin();
        k.gl.glViewport(0, 0, width, height);
        k.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        k.gl.glClear(16640);
        k.gl.glEnable(GL20.GL_SCISSOR_TEST);
        k.gl.glScissor(1, 1, width - 2, height - 2);
    }
}

package org.opencv.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import org.opencv.R$styleable;

public class CameraGLSurfaceView extends GLSurfaceView {
    public CameraGLRendererBase mRenderer = new Camera2Renderer(this);
    public CameraTextureListener mTexListener;

    public interface CameraTextureListener {
        boolean onCameraTexture(int i, int i2, int i3, int i4);

        void onCameraViewStarted(int i, int i2);

        void onCameraViewStopped();
    }

    public CameraGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.CameraBridgeViewBase);
        int i = obtainStyledAttributes.getInt(R$styleable.CameraBridgeViewBase_camera_id, -1);
        obtainStyledAttributes.recycle();
        setCameraIndex(i);
        setEGLContextClientVersion(2);
        setRenderer(this.mRenderer);
        setRenderMode(0);
    }

    public CameraTextureListener getCameraTextureListener() {
        return this.mTexListener;
    }

    public void onPause() {
        CameraGLRendererBase cameraGLRendererBase = this.mRenderer;
        cameraGLRendererBase.mHaveSurface = false;
        cameraGLRendererBase.updateState();
        cameraGLRendererBase.mCameraHeight = -1;
        cameraGLRendererBase.mCameraWidth = -1;
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        if (this.mRenderer == null) {
            throw null;
        }
    }

    public void setCameraIndex(int i) {
        CameraGLRendererBase cameraGLRendererBase = this.mRenderer;
        synchronized (cameraGLRendererBase) {
            cameraGLRendererBase.mEnabled = false;
            cameraGLRendererBase.updateState();
        }
        cameraGLRendererBase.mCameraIndex = i;
        synchronized (cameraGLRendererBase) {
            cameraGLRendererBase.mEnabled = true;
            cameraGLRendererBase.updateState();
        }
    }

    public void setCameraTextureListener(CameraTextureListener cameraTextureListener) {
        this.mTexListener = cameraTextureListener;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        super.surfaceChanged(surfaceHolder, i, i2, i3);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.mRenderer.mHaveSurface = false;
        super.surfaceDestroyed(surfaceHolder);
    }
}

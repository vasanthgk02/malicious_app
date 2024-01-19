package org.opencv.android;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.badlogic.gdx.graphics.GL20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.opencv.android.CameraGLSurfaceView.CameraTextureListener;

@TargetApi(15)
public abstract class CameraGLRendererBase implements Renderer, OnFrameAvailableListener {
    public int[] FBO = {0};
    public int mCameraHeight = -1;
    public int mCameraIndex = -1;
    public int mCameraWidth = -1;
    public boolean mEnabled = true;
    public int mFBOHeight = -1;
    public int mFBOWidth = -1;
    public boolean mHaveFBO = false;
    public boolean mHaveSurface = false;
    public boolean mIsStarted = false;
    public int mMaxCameraHeight = -1;
    public int mMaxCameraWidth = -1;
    public SurfaceTexture mSTexture;
    public boolean mUpdateST = false;
    public CameraGLSurfaceView mView;
    public int prog2D = -1;
    public int progOES = -1;
    public FloatBuffer tex2D;
    public int[] texCamera = {0};
    public final float[] texCoord2D = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    public final float[] texCoordOES = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    public int[] texDraw = {0};
    public int[] texFBO = {0};
    public FloatBuffer texOES;
    public int vPos2D;
    public int vPosOES;
    public int vTC2D;
    public int vTCOES;
    public FloatBuffer vert;
    public final float[] vertices;

    public CameraGLRendererBase(CameraGLSurfaceView cameraGLSurfaceView) {
        float[] fArr = {-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        this.vertices = fArr;
        this.mView = cameraGLSurfaceView;
        int length = (fArr.length * 32) / 8;
        this.vert = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.texOES = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.tex2D = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.vert.put(this.vertices).position(0);
        this.texOES.put(this.texCoordOES).position(0);
        this.tex2D.put(this.texCoord2D).position(0);
    }

    public static void deleteTex(int[] iArr) {
        if (iArr.length == 1) {
            GLES20.glDeleteTextures(1, iArr, 0);
        }
    }

    public static int loadShader(String str, String str2) {
        int glCreateShader = GLES20.glCreateShader(GL20.GL_VERTEX_SHADER);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, GL20.GL_COMPILE_STATUS, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glGetShaderInfoLog(glCreateShader);
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        int glCreateShader2 = GLES20.glCreateShader(GL20.GL_FRAGMENT_SHADER);
        GLES20.glShaderSource(glCreateShader2, str2);
        GLES20.glCompileShader(glCreateShader2);
        GLES20.glGetShaderiv(glCreateShader2, GL20.GL_COMPILE_STATUS, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glGetShaderInfoLog(glCreateShader2);
            GLES20.glDeleteShader(glCreateShader);
            GLES20.glDeleteShader(glCreateShader2);
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, glCreateShader);
        GLES20.glAttachShader(glCreateProgram, glCreateShader2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glDeleteShader(glCreateShader);
        GLES20.glDeleteShader(glCreateShader2);
        GLES20.glGetProgramiv(glCreateProgram, GL20.GL_LINK_STATUS, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glGetProgramInfoLog(glCreateProgram);
            return 0;
        }
        GLES20.glValidateProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, GL20.GL_VALIDATE_STATUS, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateProgram;
        }
        GLES20.glGetProgramInfoLog(glCreateProgram);
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }

    public abstract void closeCamera();

    public synchronized void doStart() {
        initSurfaceTexture();
        openCamera(this.mCameraIndex);
        this.mIsStarted = true;
        if (this.mCameraWidth > 0 && this.mCameraHeight > 0) {
            setPreviewSize(this.mCameraWidth, this.mCameraHeight);
        }
    }

    public void doStop() {
        synchronized (this) {
            this.mUpdateST = false;
            this.mIsStarted = false;
            this.mHaveFBO = false;
            closeCamera();
            SurfaceTexture surfaceTexture = this.mSTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSTexture = null;
                deleteTex(this.texCamera);
            }
        }
        CameraTextureListener cameraTextureListener = this.mView.getCameraTextureListener();
        if (cameraTextureListener != null) {
            cameraTextureListener.onCameraViewStopped();
        }
    }

    public final void drawTex(int i, boolean z, int i2) {
        int i3 = i;
        int i4 = i2;
        GLES20.glBindFramebuffer(GL20.GL_FRAMEBUFFER, i4);
        if (i4 == 0) {
            GLES20.glViewport(0, 0, this.mView.getWidth(), this.mView.getHeight());
        } else {
            GLES20.glViewport(0, 0, this.mFBOWidth, this.mFBOHeight);
        }
        GLES20.glClear(16384);
        if (z) {
            GLES20.glUseProgram(this.progOES);
            GLES20.glVertexAttribPointer(this.vPosOES, 2, GL20.GL_FLOAT, false, 8, this.vert);
            GLES20.glVertexAttribPointer(this.vTCOES, 2, GL20.GL_FLOAT, false, 8, this.texOES);
        } else {
            GLES20.glUseProgram(this.prog2D);
            GLES20.glVertexAttribPointer(this.vPos2D, 2, GL20.GL_FLOAT, false, 8, this.vert);
            GLES20.glVertexAttribPointer(this.vTC2D, 2, GL20.GL_FLOAT, false, 8, this.tex2D);
        }
        GLES20.glActiveTexture(GL20.GL_TEXTURE0);
        if (z) {
            GLES20.glBindTexture(36197, i3);
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.progOES, "sTexture"), 0);
        } else {
            GLES20.glBindTexture(GL20.GL_TEXTURE_2D, i3);
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.prog2D, "sTexture"), 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
    }

    public final void initFBO(int i, int i2) {
        GLES20.glBindFramebuffer(GL20.GL_FRAMEBUFFER, 0);
        GLES20.glDeleteFramebuffers(1, this.FBO, 0);
        deleteTex(this.texFBO);
        deleteTex(this.texDraw);
        this.mFBOHeight = 0;
        this.mFBOWidth = 0;
        GLES20.glGenTextures(1, this.texDraw, 0);
        GLES20.glBindTexture(GL20.GL_TEXTURE_2D, this.texDraw[0]);
        GLES20.glTexImage2D(GL20.GL_TEXTURE_2D, 0, GL20.GL_RGBA, i, i2, 0, GL20.GL_RGBA, GL20.GL_UNSIGNED_BYTE, null);
        GLES20.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_WRAP_S, GL20.GL_CLAMP_TO_EDGE);
        GLES20.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_WRAP_T, GL20.GL_CLAMP_TO_EDGE);
        GLES20.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MIN_FILTER, GL20.GL_NEAREST);
        GLES20.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MAG_FILTER, GL20.GL_NEAREST);
        GLES20.glGenTextures(1, this.texFBO, 0);
        GLES20.glBindTexture(GL20.GL_TEXTURE_2D, this.texFBO[0]);
        GLES20.glTexImage2D(GL20.GL_TEXTURE_2D, 0, GL20.GL_RGBA, i, i2, 0, GL20.GL_RGBA, GL20.GL_UNSIGNED_BYTE, null);
        GLES20.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_WRAP_S, GL20.GL_CLAMP_TO_EDGE);
        GLES20.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_WRAP_T, GL20.GL_CLAMP_TO_EDGE);
        GLES20.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MIN_FILTER, GL20.GL_NEAREST);
        GLES20.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MAG_FILTER, GL20.GL_NEAREST);
        GLES20.glGenFramebuffers(1, this.FBO, 0);
        GLES20.glBindFramebuffer(GL20.GL_FRAMEBUFFER, this.FBO[0]);
        GLES20.glFramebufferTexture2D(GL20.GL_FRAMEBUFFER, GL20.GL_COLOR_ATTACHMENT0, GL20.GL_TEXTURE_2D, this.texFBO[0], 0);
        GLES20.glGetError();
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(GL20.GL_FRAMEBUFFER);
        this.mFBOWidth = i;
        this.mFBOHeight = i2;
    }

    public final void initSurfaceTexture() {
        SurfaceTexture surfaceTexture = this.mSTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mSTexture = null;
            deleteTex(this.texCamera);
        }
        int[] iArr = this.texCamera;
        if (iArr.length == 1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(36197, iArr[0]);
            GLES20.glTexParameteri(36197, GL20.GL_TEXTURE_WRAP_S, GL20.GL_CLAMP_TO_EDGE);
            GLES20.glTexParameteri(36197, GL20.GL_TEXTURE_WRAP_T, GL20.GL_CLAMP_TO_EDGE);
            GLES20.glTexParameteri(36197, GL20.GL_TEXTURE_MIN_FILTER, GL20.GL_NEAREST);
            GLES20.glTexParameteri(36197, GL20.GL_TEXTURE_MAG_FILTER, GL20.GL_NEAREST);
        }
        SurfaceTexture surfaceTexture2 = new SurfaceTexture(this.texCamera[0]);
        this.mSTexture = surfaceTexture2;
        surfaceTexture2.setOnFrameAvailableListener(this);
    }

    public void onDrawFrame(GL10 gl10) {
        if (this.mHaveFBO) {
            synchronized (this) {
                if (this.mUpdateST) {
                    this.mSTexture.updateTexImage();
                    this.mUpdateST = false;
                }
                GLES20.glClear(16384);
                CameraTextureListener cameraTextureListener = this.mView.getCameraTextureListener();
                if (cameraTextureListener != null) {
                    drawTex(this.texCamera[0], true, this.FBO[0]);
                    if (cameraTextureListener.onCameraTexture(this.texFBO[0], this.texDraw[0], this.mCameraWidth, this.mCameraHeight)) {
                        drawTex(this.texDraw[0], false, 0);
                    } else {
                        drawTex(this.texFBO[0], false, 0);
                    }
                } else {
                    drawTex(this.texCamera[0], true, 0);
                }
            }
        }
    }

    public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.mUpdateST = true;
        this.mView.requestRender();
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.mHaveSurface = true;
        updateState();
        setPreviewSize(i, i2);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glGetString(GL20.GL_VERSION);
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        int loadShader = loadShader("attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}");
        this.progOES = loadShader;
        this.vPosOES = GLES20.glGetAttribLocation(loadShader, "vPosition");
        this.vTCOES = GLES20.glGetAttribLocation(this.progOES, "vTexCoord");
        GLES20.glEnableVertexAttribArray(this.vPosOES);
        GLES20.glEnableVertexAttribArray(this.vTCOES);
        int loadShader2 = loadShader("attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}", "precision mediump float;\nuniform sampler2D sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}");
        this.prog2D = loadShader2;
        this.vPos2D = GLES20.glGetAttribLocation(loadShader2, "vPosition");
        this.vTC2D = GLES20.glGetAttribLocation(this.prog2D, "vTexCoord");
        GLES20.glEnableVertexAttribArray(this.vPos2D);
        GLES20.glEnableVertexAttribArray(this.vTC2D);
    }

    public abstract void openCamera(int i);

    public abstract void setCameraPreviewSize(int i, int i2);

    public void setPreviewSize(int i, int i2) {
        synchronized (this) {
            this.mHaveFBO = false;
            this.mCameraWidth = i;
            this.mCameraHeight = i2;
            setCameraPreviewSize(i, i2);
            initFBO(this.mCameraWidth, this.mCameraHeight);
            this.mHaveFBO = true;
        }
        CameraTextureListener cameraTextureListener = this.mView.getCameraTextureListener();
        if (cameraTextureListener != null) {
            cameraTextureListener.onCameraViewStarted(this.mCameraWidth, this.mCameraHeight);
        }
    }

    public void updateState() {
        boolean z = this.mEnabled && this.mHaveSurface && this.mView.getVisibility() == 0;
        if (z == this.mIsStarted) {
            return;
        }
        if (z) {
            doStart();
        } else {
            doStop();
        }
    }
}

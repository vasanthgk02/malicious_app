package com.badlogic.gdx.backends.android.surfaceview;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View.MeasureSpec;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.Input.OnscreenKeyboardType;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

public class GLSurfaceView20 extends GLSurfaceView {
    public static String TAG = "GL2JNIView";
    public static int targetGLESVersion;
    public OnscreenKeyboardType onscreenKeyboardType = OnscreenKeyboardType.Default;
    public final ResolutionStrategy resolutionStrategy;

    public static class ConfigChooser implements EGLConfigChooser {
        public static int[] s_configAttribs2 = {12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344};
        public int mAlphaSize;
        public int mBlueSize;
        public int mDepthSize;
        public int mGreenSize;
        public int mRedSize;
        public int mStencilSize;
        public int[] mValue = new int[1];

        public ConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, s_configAttribs2, null, 0, iArr);
            int i = iArr[0];
            if (i > 0) {
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                egl10.eglChooseConfig(eGLDisplay, s_configAttribs2, eGLConfigArr, i, iArr);
                for (int i2 = 0; i2 < i; i2++) {
                    EGLConfig eGLConfig = eGLConfigArr[i2];
                    int i3 = egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12325, this.mValue) ? this.mValue[0] : 0;
                    int i4 = egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12326, this.mValue) ? this.mValue[0] : 0;
                    if (i3 >= this.mDepthSize && i4 >= this.mStencilSize) {
                        int i5 = egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12324, this.mValue) ? this.mValue[0] : 0;
                        int i6 = egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12323, this.mValue) ? this.mValue[0] : 0;
                        int i7 = egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12322, this.mValue) ? this.mValue[0] : 0;
                        int i8 = egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12321, this.mValue) ? this.mValue[0] : 0;
                        if (i5 == this.mRedSize && i6 == this.mGreenSize && i7 == this.mBlueSize && i8 == this.mAlphaSize) {
                            return eGLConfig;
                        }
                    }
                }
                return null;
            }
            throw new IllegalArgumentException("No configs match configSpec");
        }
    }

    public static class ContextFactory implements EGLContextFactory {
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            String str = GLSurfaceView20.TAG;
            int i = GLSurfaceView20.targetGLESVersion;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Before eglCreateContext ");
            outline73.append(GLSurfaceView20.targetGLESVersion);
            GLSurfaceView20.checkEglError(outline73.toString(), egl10);
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, GLSurfaceView20.targetGLESVersion, 12344});
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("After eglCreateContext ");
            outline732.append(GLSurfaceView20.targetGLESVersion);
            if ((!GLSurfaceView20.checkEglError(outline732.toString(), egl10) || eglCreateContext == null) && GLSurfaceView20.targetGLESVersion > 2) {
                String str2 = GLSurfaceView20.TAG;
                GLSurfaceView20.targetGLESVersion = 2;
                return createContext(egl10, eGLDisplay, eGLConfig);
            }
            String str3 = GLSurfaceView20.TAG;
            int i2 = GLSurfaceView20.targetGLESVersion;
            return eglCreateContext;
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    public GLSurfaceView20(Context context, ResolutionStrategy resolutionStrategy2, int i) {
        super(context);
        targetGLESVersion = i;
        this.resolutionStrategy = resolutionStrategy2;
        setEGLContextFactory(new ContextFactory());
        ConfigChooser configChooser = new ConfigChooser(8, 8, 8, 0, 16, 0);
        setEGLConfigChooser(configChooser);
    }

    public static boolean checkEglError(String str, EGL10 egl10) {
        boolean z = true;
        while (true) {
            int eglGetError = egl10.eglGetError();
            if (eglGetError == 12288) {
                return z;
            }
            String.format("%s: EGL error: 0x%x", new Object[]{str, Integer.valueOf(eglGetError)});
            z = false;
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (editorInfo != null) {
            editorInfo.imeOptions |= ClientDefaults.MAX_MSG_SIZE;
            int ordinal = this.onscreenKeyboardType.ordinal();
            int i = 3;
            if (ordinal == 1) {
                i = 2;
            } else if (ordinal != 2) {
                i = ordinal != 3 ? ordinal != 4 ? ordinal != 5 ? 144 : 17 : 129 : 33;
            }
            editorInfo.inputType = i;
        }
        return new BaseInputConnection(this, false) {
            public boolean deleteSurroundingText(int i, int i2) {
                if (i != 1 || i2 != 0) {
                    return super.deleteSurroundingText(i, i2);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                KeyEvent keyEvent = new KeyEvent(uptimeMillis, uptimeMillis, 0, 67, 0, 0, -1, 0, 6);
                super.sendKeyEvent(keyEvent);
                KeyEvent keyEvent2 = new KeyEvent(SystemClock.uptimeMillis(), uptimeMillis, 1, 67, 0, 0, -1, 0, 6);
                super.sendKeyEvent(keyEvent2);
                return true;
            }
        };
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onMeasure(int i, int i2) {
        if (((FillResolutionStrategy) this.resolutionStrategy) != null) {
            setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
            return;
        }
        throw null;
    }
}

package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera.Area;

public class Camera2Wrapper implements c {

    /* renamed from: a  reason: collision with root package name */
    public Context f3348a;

    /* renamed from: b  reason: collision with root package name */
    public a f3349b = null;

    /* renamed from: c  reason: collision with root package name */
    public final int f3350c = 100;

    public Camera2Wrapper(Context context) {
        this.f3348a = context;
        initCamera2Jni();
    }

    public static int a(float f2) {
        return (int) Math.min(Math.max((f2 * 2000.0f) - 0.0040893555f, -900.0f), 900.0f);
    }

    private final native void deinitCamera2Jni();

    private final native void initCamera2Jni();

    private final native void nativeFrameReady(Object obj, Object obj2, Object obj3, int i, int i2, int i3);

    private final native void nativeSurfaceTextureReady(Object obj);

    public final void a() {
        deinitCamera2Jni();
        closeCamera2();
    }

    public final void a(Object obj) {
        nativeSurfaceTextureReady(obj);
    }

    public final void a(Object obj, Object obj2, Object obj3, int i, int i2, int i3) {
        nativeFrameReady(obj, obj2, obj3, i, i2, i3);
    }

    public void closeCamera2() {
        a aVar = this.f3349b;
        if (aVar != null) {
            aVar.b();
        }
        this.f3349b = null;
    }

    public int getCamera2Count() {
        if (i.f3501b) {
            return a.a(this.f3348a);
        }
        return 0;
    }

    public int[] getCamera2Resolutions(int i) {
        if (i.f3501b) {
            return a.d(this.f3348a, i);
        }
        return null;
    }

    public int getCamera2SensorOrientation(int i) {
        if (i.f3501b) {
            return a.a(this.f3348a, i);
        }
        return 0;
    }

    public Object getCameraFocusArea(float f2, float f3) {
        int a2 = a(f2);
        int a3 = a(1.0f - f3);
        return new Area(new Rect(a2 - 100, a3 - 100, a2 + 100, a3 + 100), 1000);
    }

    public Rect getFrameSizeCamera2() {
        a aVar = this.f3349b;
        return aVar != null ? aVar.a() : new Rect();
    }

    public boolean initializeCamera2(int i, int i2, int i3, int i4, int i5) {
        if (!i.f3501b || this.f3349b != null || UnityPlayer.currentActivity == null) {
            return false;
        }
        a aVar = new a(this);
        this.f3349b = aVar;
        return aVar.a(this.f3348a, i, i2, i3, i4, i5);
    }

    public boolean isCamera2AutoFocusPointSupported(int i) {
        if (i.f3501b) {
            return a.c(this.f3348a, i);
        }
        return false;
    }

    public boolean isCamera2FrontFacing(int i) {
        if (i.f3501b) {
            return a.b(this.f3348a, i);
        }
        return false;
    }

    public void pauseCamera2() {
        a aVar = this.f3349b;
        if (aVar != null) {
            aVar.d();
        }
    }

    public boolean setAutoFocusPoint(float f2, float f3) {
        if (i.f3501b) {
            a aVar = this.f3349b;
            if (aVar != null) {
                return aVar.a(f2, f3);
            }
        }
        return false;
    }

    public void startCamera2() {
        a aVar = this.f3349b;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void stopCamera2() {
        a aVar = this.f3349b;
        if (aVar != null) {
            aVar.e();
        }
    }
}

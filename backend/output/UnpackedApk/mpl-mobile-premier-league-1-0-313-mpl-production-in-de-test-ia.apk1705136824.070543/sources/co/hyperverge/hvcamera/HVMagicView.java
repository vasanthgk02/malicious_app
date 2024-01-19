package co.hyperverge.hvcamera;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.View.MeasureSpec;
import co.hyperverge.hvcamera.magicfilter.camera.CameraEngine;
import co.hyperverge.hvcamera.magicfilter.camera.b.h;
import java.io.File;
import java.util.List;

public class HVMagicView extends GLSurfaceView {

    /* renamed from: f  reason: collision with root package name */
    public static HVCamHost f2835f = null;
    public static HVMagicView g = null;
    public static int h = 3;
    public static int i = 4;
    public static final String j = HVMagicView.class.getCanonicalName();

    /* renamed from: a  reason: collision with root package name */
    public co.hyperverge.hvcamera.c.a.c f2836a;

    /* renamed from: b  reason: collision with root package name */
    public c f2837b;

    /* renamed from: c  reason: collision with root package name */
    public co.hyperverge.hvcamera.d.a f2838c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2839d = false;

    /* renamed from: e  reason: collision with root package name */
    public ShutterCallback f2840e = new b();

    public interface SensorCallback {
        void onSensorCallback();
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            co.hyperverge.hvcamera.c.a.c cVar = HVMagicView.this.f2836a;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    public class b implements ShutterCallback {
        public void onShutter() {
            try {
                if (HVMagicView.f2835f != null) {
                    HVMagicView.f2835f.flashScreen();
                }
            } catch (Exception e2) {
                String str = HVMagicView.j;
                e2.getMessage();
            }
        }
    }

    public class c extends OrientationEventListener {
        public c(Context context) {
            super(context);
            super.disable();
        }

        public void disable() {
            super.disable();
        }

        public void enable() {
            super.enable();
        }

        public void onOrientationChanged(int i) {
            if (i == -1) {
                i = 0;
            }
            try {
                if (CameraEngine.f2908a) {
                    co.hyperverge.hvcamera.magicfilter.camera.b.f(i);
                } else {
                    co.hyperverge.hvcamera.magicfilter.camera.a.c(i);
                }
            } catch (Throwable th) {
                String str = HVMagicView.j;
                th.getMessage();
            }
        }
    }

    public HVMagicView(Context context, HVCamHost hVCamHost, boolean z) {
        super(context);
        f2835f = hVCamHost;
        hVCamHost.onCamerasFound(Camera.getNumberOfCameras());
        if (CameraEngine.f2908a) {
            co.hyperverge.hvcamera.magicfilter.camera.b.f2920d = context;
            co.hyperverge.hvcamera.magicfilter.camera.b.o = false;
            co.hyperverge.hvcamera.magicfilter.camera.b.k = (CameraManager) context.getSystemService("camera");
            co.hyperverge.hvcamera.magicfilter.camera.b.f2921e = z;
            co.hyperverge.hvcamera.magicfilter.camera.b.g = 1;
        } else {
            co.hyperverge.hvcamera.magicfilter.camera.a.b(z);
        }
        this.f2838c = new co.hyperverge.hvcamera.d.a(context, 9);
        if (!CameraEngine.f2908a) {
            this.f2836a = new co.hyperverge.hvcamera.c.a.a(this);
        } else {
            this.f2836a = new co.hyperverge.hvcamera.c.a.b(this);
        }
        c();
        c cVar = new c(context);
        this.f2837b = cVar;
        cVar.enable();
    }

    public static void c() {
        if (f2835f.getAspectRatio() == 1) {
            h = 3;
            i = 4;
        } else if (f2835f.getAspectRatio() == 2) {
            h = 9;
            i = 16;
        }
    }

    public static int getAspectRatio() {
        return i == 4 ? 1 : 2;
    }

    public static int getmRatioHeight() {
        return i;
    }

    public static int getmRatioWidth() {
        return h;
    }

    public void disableRotation() {
        this.f2837b.disable();
        this.f2839d = true;
        if (CameraEngine.f2908a) {
            co.hyperverge.hvcamera.magicfilter.camera.b.f(0);
        } else {
            co.hyperverge.hvcamera.magicfilter.camera.a.c(0);
        }
    }

    public HVCamHost getCamHost() {
        return f2835f;
    }

    public void nextFlashMode() {
        if (CameraEngine.f2908a) {
            List<Integer> list = co.hyperverge.hvcamera.magicfilter.camera.b.G;
            if (list != null && list.contains(Integer.valueOf(co.hyperverge.hvcamera.magicfilter.camera.b.g))) {
                int indexOf = co.hyperverge.hvcamera.magicfilter.camera.b.G.indexOf(Integer.valueOf(co.hyperverge.hvcamera.magicfilter.camera.b.g));
                int intValue = co.hyperverge.hvcamera.magicfilter.camera.b.G.get(indexOf == co.hyperverge.hvcamera.magicfilter.camera.b.G.size() + -1 ? 0 : indexOf + 1).intValue();
                co.hyperverge.hvcamera.magicfilter.camera.b.g = intValue;
                co.hyperverge.hvcamera.magicfilter.camera.b.g = intValue;
                co.hyperverge.hvcamera.magicfilter.camera.b.c(co.hyperverge.hvcamera.magicfilter.camera.b.y);
                CaptureRequest build = co.hyperverge.hvcamera.magicfilter.camera.b.y.build();
                co.hyperverge.hvcamera.magicfilter.camera.b.C = build;
                try {
                    co.hyperverge.hvcamera.magicfilter.camera.b.B.setRepeatingRequest(build, co.hyperverge.hvcamera.magicfilter.camera.b.N, co.hyperverge.hvcamera.magicfilter.camera.b.x);
                } catch (Exception e2) {
                    e2.getMessage();
                }
                new Handler(Looper.getMainLooper()).post(new h());
                return;
            }
            return;
        }
        co.hyperverge.hvcamera.magicfilter.camera.a.u();
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = MeasureSpec.getSize(i2);
        int size2 = MeasureSpec.getSize(i3);
        int i4 = h;
        if (i4 != 0) {
            int i5 = i;
            if (i5 != 0) {
                setMeasuredDimension(size, (i5 * size) / i4);
                HVCamHost hVCamHost = f2835f;
                if (hVCamHost != null) {
                    hVCamHost.onViewDimensionChange(size, (i * size) / h);
                    return;
                }
                return;
            }
        }
        setMeasuredDimension(size, size2);
        HVCamHost hVCamHost2 = f2835f;
        if (hVCamHost2 != null) {
            hVCamHost2.onViewDimensionChange(size, size2);
        }
    }

    public void onPause() {
        co.hyperverge.hvcamera.c.a.c cVar = this.f2836a;
        if (cVar != null) {
            cVar.d();
        }
        removeCallbacks(null);
        this.f2837b.disable();
        this.f2838c.b();
    }

    public void onResume() {
        super.onResume();
        if (!this.f2839d) {
            this.f2837b.enable();
        }
        this.f2838c.a();
        co.hyperverge.hvcamera.c.a.c cVar = this.f2836a;
        if (cVar != null) {
            cVar.e();
        }
    }

    public void onTouchToFocus(float f2, float f3, AutoFocusCallback autoFocusCallback) {
        this.f2836a.a(f2, f3, (AutoFocusCallback) null);
        co.hyperverge.hvcamera.d.a aVar = this.f2838c;
        aVar.f2900b = true;
        if (!aVar.q && aVar.k.hasMessages(0)) {
            aVar.k.removeCallbacks(aVar.l);
            aVar.k.removeMessages(0);
        }
        aVar.q = true;
        aVar.k.postDelayed(aVar.m, 2500);
    }

    public void setCamHost(HVCamHost hVCamHost) {
        f2835f = hVCamHost;
    }

    public void setFilter(int i2) {
        int i3;
        this.f2836a.a(i2);
        HVCamHost hVCamHost = f2835f;
        Resources resources = getContext().getResources();
        if (i2 != 0) {
            i3 = R$string.filter_none;
        } else {
            i3 = R$string.filter_none;
        }
        hVCamHost.onFilterMode(i2, resources.getString(i3));
    }

    public void setSensorCallback(SensorCallback sensorCallback) {
        this.f2838c.f2902d = sensorCallback;
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        super.surfaceDestroyed(surfaceHolder);
        this.f2836a.b();
    }

    public void takePicture(String str) {
        this.f2838c.b();
        HVCamHost hVCamHost = f2835f;
        if (hVCamHost != null) {
            co.hyperverge.hvcamera.c.a.c cVar = this.f2836a;
            File photoDirectory = hVCamHost.getPhotoDirectory();
            photoDirectory.mkdirs();
            cVar.a(new File(photoDirectory, hVCamHost.getPhotoFilename()), (co.hyperverge.hvcamera.magicfilter.utils.g.a) null, this.f2840e);
        }
    }
}

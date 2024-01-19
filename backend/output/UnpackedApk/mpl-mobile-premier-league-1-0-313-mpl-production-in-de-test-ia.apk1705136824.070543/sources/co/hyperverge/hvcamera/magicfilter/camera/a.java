package co.hyperverge.hvcamera.magicfilter.camera;

import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import co.hyperverge.hvcamera.HVMagicView;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDPrintFieldAttributeObject;

public class a {
    public static List<String> A;
    public static Matrix B = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public static Camera f2912b;

    /* renamed from: c  reason: collision with root package name */
    public static int f2913c = n();

    /* renamed from: d  reason: collision with root package name */
    public static boolean f2914d = false;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f2915e = false;

    /* renamed from: f  reason: collision with root package name */
    public static Parameters f2916f;
    public static List<Integer> g;
    public static int h;
    public static float i;
    public static boolean j = true;
    public static String k;
    public static int l;
    public static byte[][] m = new byte[5][];
    public static byte[][] n = new byte[5][];
    public static int o = 0;
    public static ShutterCallback p;
    public static PictureCallback q;
    public static boolean r = false;
    public static ScheduledExecutorService s;
    public static boolean t;
    public static boolean u;
    public static List<String> v = new ArrayList();
    public static List<String> w = new ArrayList();
    public static final List<String> x;
    public static final List<String> y;
    public static String z;

    public class b implements PreviewCallback {
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00a2 A[Catch:{ Exception -> 0x00ee }] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00d6 A[Catch:{ Exception -> 0x00ee }] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00f6  */
        /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPreviewFrame(byte[] r24, android.hardware.Camera r25) {
            /*
                r23 = this;
                r7 = r24
                java.lang.System.currentTimeMillis()
                if (r7 != 0) goto L_0x0009
                goto L_0x00f2
            L_0x0009:
                android.hardware.Camera$Size r0 = co.hyperverge.hvcamera.magicfilter.camera.a.r()     // Catch:{ Exception -> 0x00ee }
                int r15 = r0.width     // Catch:{ Exception -> 0x00ee }
                android.hardware.Camera$Size r0 = co.hyperverge.hvcamera.magicfilter.camera.a.r()     // Catch:{ Exception -> 0x00ee }
                int r14 = r0.height     // Catch:{ Exception -> 0x00ee }
                int r0 = co.hyperverge.hvcamera.magicfilter.camera.a.o     // Catch:{ Exception -> 0x00ee }
                int r0 = r0 + 45
                r13 = 90
                int r0 = r0 / r13
                int r0 = r0 * 90
                int r12 = r0 % 360
                boolean r0 = co.hyperverge.hvcamera.magicfilter.camera.CameraEngine.isFrontFacingCamera()     // Catch:{ Exception -> 0x00ee }
                if (r0 == 0) goto L_0x002e
                int r0 = 270 - r12
                int r0 = r0 + 360
                int r0 = r0 % 360
            L_0x002c:
                r11 = r0
                goto L_0x0033
            L_0x002e:
                int r0 = r12 + 90
                int r0 = r0 % 360
                goto L_0x002c
            L_0x0033:
                boolean r0 = co.hyperverge.hvcamera.magicfilter.camera.a.r     // Catch:{ Exception -> 0x00ee }
                if (r0 == 0) goto L_0x009b
                co.hyperverge.hvcamera.HVCamHost r0 = co.hyperverge.hvcamera.HVMagicView.f2835f     // Catch:{ Exception -> 0x0091 }
                r0.setScreenFlashOff()     // Catch:{ Exception -> 0x0091 }
                r0 = 0
                co.hyperverge.hvcamera.magicfilter.camera.a.r = r0     // Catch:{ Exception -> 0x0091 }
                java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0091 }
                r8.<init>()     // Catch:{ Exception -> 0x0091 }
                android.graphics.YuvImage r9 = new android.graphics.YuvImage     // Catch:{ Exception -> 0x0091 }
                r3 = 17
                r6 = 0
                r1 = r9
                r2 = r24
                r4 = r15
                r5 = r14
                r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0091 }
                android.graphics.Rect r1 = new android.graphics.Rect     // Catch:{ Exception -> 0x0091 }
                r1.<init>(r0, r0, r15, r14)     // Catch:{ Exception -> 0x0091 }
                r9.compressToJpeg(r1, r13, r8)     // Catch:{ Exception -> 0x0091 }
                byte[] r1 = r8.toByteArray()     // Catch:{ Exception -> 0x0091 }
                int r2 = r1.length     // Catch:{ Exception -> 0x0091 }
                android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeByteArray(r1, r0, r2)     // Catch:{ Exception -> 0x0091 }
                java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0091 }
                r0.<init>()     // Catch:{ Exception -> 0x0091 }
                android.graphics.Matrix r1 = new android.graphics.Matrix     // Catch:{ Exception -> 0x0091 }
                r1.<init>()     // Catch:{ Exception -> 0x0091 }
                float r2 = (float) r11     // Catch:{ Exception -> 0x0091 }
                r1.postRotate(r2)     // Catch:{ Exception -> 0x0091 }
                r9 = 0
                r10 = 0
                r2 = 0
                r3 = r11
                r11 = r15
                r4 = r12
                r12 = r14
                r5 = 90
                r13 = r1
                r1 = r14
                r14 = r2
                android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x008f }
                android.graphics.Bitmap$CompressFormat r6 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x008f }
                r2.compress(r6, r5, r0)     // Catch:{ Exception -> 0x008f }
                co.hyperverge.hvcamera.HVCamHost r2 = co.hyperverge.hvcamera.HVMagicView.f2835f     // Catch:{ Exception -> 0x008f }
                byte[] r0 = r0.toByteArray()     // Catch:{ Exception -> 0x008f }
                r2.onPictureReady(r0)     // Catch:{ Exception -> 0x008f }
                goto L_0x00a0
            L_0x008f:
                r0 = move-exception
                goto L_0x0097
            L_0x0091:
                r0 = move-exception
                r3 = r11
                r4 = r12
                r1 = r14
                r5 = 90
            L_0x0097:
                r0.getMessage()     // Catch:{ Exception -> 0x00ee }
                goto L_0x00a0
            L_0x009b:
                r3 = r11
                r4 = r12
                r1 = r14
                r5 = 90
            L_0x00a0:
                if (r3 == r5) goto L_0x00a9
                r0 = 270(0x10e, float:3.78E-43)
                if (r3 != r0) goto L_0x00a7
                goto L_0x00a9
            L_0x00a7:
                r14 = r1
                goto L_0x00b5
            L_0x00a9:
                android.hardware.Camera$Size r0 = co.hyperverge.hvcamera.magicfilter.camera.a.r()     // Catch:{ Exception -> 0x00ee }
                int r15 = r0.height     // Catch:{ Exception -> 0x00ee }
                android.hardware.Camera$Size r0 = co.hyperverge.hvcamera.magicfilter.camera.a.r()     // Catch:{ Exception -> 0x00ee }
                int r14 = r0.width     // Catch:{ Exception -> 0x00ee }
            L_0x00b5:
                int r0 = co.hyperverge.hvcamera.magicfilter.camera.a.l     // Catch:{ Exception -> 0x00ee }
                int r0 = r0 + 1
                int r0 = r0 % 5
                co.hyperverge.hvcamera.magicfilter.camera.a.l = r0     // Catch:{ Exception -> 0x00ee }
                android.hardware.Camera$Size r0 = co.hyperverge.hvcamera.magicfilter.camera.a.r()     // Catch:{ Exception -> 0x00ee }
                int r0 = r0.width     // Catch:{ Exception -> 0x00ee }
                android.hardware.Camera$Size r1 = co.hyperverge.hvcamera.magicfilter.camera.a.r()     // Catch:{ Exception -> 0x00ee }
                int r1 = r1.height     // Catch:{ Exception -> 0x00ee }
                byte[][] r2 = co.hyperverge.hvcamera.magicfilter.camera.a.m     // Catch:{ Exception -> 0x00ee }
                int r5 = co.hyperverge.hvcamera.magicfilter.camera.a.l     // Catch:{ Exception -> 0x00ee }
                r2 = r2[r5]     // Catch:{ Exception -> 0x00ee }
                co.hyperverge.hvcamera.magicfilter.camera.CameraEngine.rotateNV21a(r7, r0, r1, r3, r2)     // Catch:{ Exception -> 0x00ee }
                co.hyperverge.hvcamera.HVCamHost r0 = co.hyperverge.hvcamera.HVMagicView.f2835f     // Catch:{ Exception -> 0x00ee }
                if (r0 == 0) goto L_0x00f2
                co.hyperverge.hvcamera.HVCamHost r16 = co.hyperverge.hvcamera.HVMagicView.f2835f     // Catch:{ Exception -> 0x00ee }
                byte[][] r0 = co.hyperverge.hvcamera.magicfilter.camera.a.m     // Catch:{ Exception -> 0x00ee }
                int r1 = co.hyperverge.hvcamera.magicfilter.camera.a.l     // Catch:{ Exception -> 0x00ee }
                r17 = r0[r1]     // Catch:{ Exception -> 0x00ee }
                byte[] r22 = androidx.core.widget.CompoundButtonCompat.a(r7, r14, r15, r3)     // Catch:{ Exception -> 0x00ee }
                r18 = r15
                r19 = r14
                r20 = r4
                r21 = r3
                r16.onNewPreviewFrame(r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x00ee }
                goto L_0x00f2
            L_0x00ee:
                r0 = move-exception
                r0.getMessage()
            L_0x00f2:
                android.hardware.Camera r0 = co.hyperverge.hvcamera.magicfilter.camera.a.f2912b
                if (r0 == 0) goto L_0x00f9
                r0.addCallbackBuffer(r7)
            L_0x00f9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hvcamera.magicfilter.camera.a.b.onPreviewFrame(byte[], android.hardware.Camera):void");
        }
    }

    public class c implements Runnable {
        public void run() {
            if (!a.v.contains(Build.MODEL) && !a.w.contains(Build.MODEL)) {
                a.f2912b.cancelAutoFocus();
            }
            a.B();
        }
    }

    public class d implements AutoFocusCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScheduledFuture f2917a;

        public d(ScheduledFuture scheduledFuture) {
            this.f2917a = scheduledFuture;
        }

        public void onAutoFocus(boolean z, Camera camera) {
            if (this.f2917a.cancel(false)) {
                a.B();
            }
        }
    }

    public class e implements Runnable {
        public void run() {
            try {
                if (CameraEngine.f2911e) {
                    Parameters parameters = a.f2912b.getParameters();
                    parameters.setZoom(1);
                    a.f2912b.setParameters(parameters);
                }
                a.f2912b.takePicture(a.p, null, a.q);
            } catch (Exception e2) {
                e2.getMessage();
                try {
                    HVMagicView.f2835f.onPictureFailed();
                } catch (Exception e3) {
                    e3.getMessage();
                }
            }
        }
    }

    public class f implements Runnable {
        public void run() {
            try {
                if (a.z == null) {
                    HVMagicView.f2835f.onFlashNull();
                    return;
                }
                String str = a.z;
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 3551) {
                    if (hashCode != 109935) {
                        if (hashCode != 3005871) {
                            if (hashCode == 110547964) {
                                if (str.equals("torch")) {
                                    c2 = 2;
                                }
                            }
                        } else if (str.equals("auto")) {
                            c2 = 1;
                        }
                    } else if (str.equals(PDPrintFieldAttributeObject.CHECKED_STATE_OFF)) {
                        c2 = 0;
                    }
                } else if (str.equals(PDPrintFieldAttributeObject.CHECKED_STATE_ON)) {
                    c2 = 3;
                }
                if (c2 == 0) {
                    HVMagicView.f2835f.onFlashOff();
                } else if (c2 == 1) {
                    HVMagicView.f2835f.onFlashAuto();
                } else if (c2 == 2) {
                    HVMagicView.f2835f.onFlashTorchOn();
                } else if (c2 == 3) {
                    HVMagicView.f2835f.onFlashOn();
                }
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
    }

    static {
        v.add("SM-J200G");
        v.add("SM-J120G");
        v.add("SM-T285");
        w.add("LLD-AL10");
        w.add("vivo 1814");
        ArrayList arrayList = new ArrayList();
        x = arrayList;
        arrayList.add(PDPrintFieldAttributeObject.CHECKED_STATE_OFF);
        x.add(PDPrintFieldAttributeObject.CHECKED_STATE_ON);
        x.add("torch");
        ArrayList arrayList2 = new ArrayList();
        y = arrayList2;
        arrayList2.add(PDPrintFieldAttributeObject.CHECKED_STATE_OFF);
        y.add("torch");
    }

    public static void B() {
        if (f2912b != null) {
            new Handler(Looper.getMainLooper()).post(new e());
        }
    }

    public static void a(Point point) {
        int i2 = point.x;
    }

    public static int b(int i2) {
        if (i2 > 1000) {
            return 1000;
        }
        return i2 < -1000 ? NotificationManagerCompat.IMPORTANCE_UNSPECIFIED : i2;
    }

    public static void b(boolean z2) {
        s = Executors.newScheduledThreadPool(1);
        if (z2) {
            f2913c = n();
        } else {
            f2913c = 0;
        }
    }

    public static void c(int i2) {
        o = i2 % JpegTranscoderUtils.FULL_ROUND;
        try {
            if (f2912b != null && !j) {
                co.hyperverge.hvcamera.a.a(f2913c, f2912b, i2 % JpegTranscoderUtils.FULL_ROUND);
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public static void e(int i2) {
        if (f2915e) {
            Camera camera = f2912b;
            if (camera != null) {
                float f2 = (float) i2;
                try {
                    i = f2;
                    if (f2 <= ((float) h)) {
                        Parameters parameters = camera.getParameters();
                        parameters.setZoom((int) i);
                        f2912b.setParameters(parameters);
                    }
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
        }
    }

    public static int n() {
        try {
            CameraInfo cameraInfo = new CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == 1) {
                    return i2;
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
        return 0;
    }

    public static int p() {
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(f2913c, cameraInfo);
        return cameraInfo.orientation;
    }

    public static Size r() {
        if (!j) {
            return f2912b.getParameters().getPreviewSize();
        }
        return null;
    }

    public static boolean s() {
        boolean z2 = false;
        try {
            CameraInfo cameraInfo = new CameraInfo();
            Camera.getCameraInfo(f2913c, cameraInfo);
            if (cameraInfo.facing == 1) {
                z2 = true;
            }
            return z2;
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
    }

    public static void u() {
        try {
            if (A != null && z != null) {
                int indexOf = A.indexOf(z);
                String str = A.get(indexOf == A.size() + -1 ? 0 : indexOf + 1);
                z = str;
                try {
                    z = str;
                    Parameters parameters = f2912b.getParameters();
                    parameters.setFlashMode(str);
                    f2912b.setParameters(parameters);
                    new Handler(Looper.getMainLooper()).post(new f());
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
    }

    public static boolean v() {
        try {
            HVMagicView.f2835f.setScreenFlashOff();
        } catch (Exception e2) {
            e2.getMessage();
        } catch (Throwable unused) {
            j = true;
            f2912b = null;
        }
        f2912b.getParameters();
        j = false;
        Camera camera = f2912b;
        if (camera == null) {
            try {
                f2912b = Camera.open(f2913c);
                j = false;
                HVMagicView.c();
                x();
                List<String> supportedFlashModes = f2912b.getParameters().getSupportedFlashModes();
                if (supportedFlashModes != null) {
                    ArrayList arrayList = new ArrayList();
                    for (String next : supportedFlashModes) {
                        if (x.contains(next)) {
                            arrayList.add(next);
                        }
                    }
                    A = arrayList;
                } else {
                    A = null;
                }
                z = f2912b.getParameters().getFlashMode();
                new Handler(Looper.getMainLooper()).post(new f());
                Parameters parameters = f2912b.getParameters();
                f2916f = parameters;
                f2915e = parameters.isZoomSupported();
                h = f2916f.getMaxZoom();
                g = f2916f.getZoomRatios();
                HVMagicView.f2835f.zoomMaxLevel(h);
                if (CameraEngine.f2909b) {
                    for (int i2 = 0; i2 < 5; i2++) {
                        n[i2] = new byte[(((r().width * r().height) * ImageFormat.getBitsPerPixel(17)) / 8)];
                        byte[] bArr = n[i2];
                        Camera camera2 = f2912b;
                        if (camera2 != null) {
                            camera2.addCallbackBuffer(bArr);
                        }
                    }
                    l = 0;
                    for (int i3 = 0; i3 < 5; i3++) {
                        m[i3] = new byte[(r().width * r().height)];
                    }
                    f2912b.setPreviewCallbackWithBuffer(new b());
                }
                return true;
            } catch (RuntimeException e3) {
                if (!TextUtils.isEmpty(e3.getMessage())) {
                    e3.getMessage();
                }
                return false;
            }
        } else {
            try {
                Parameters parameters2 = camera.getParameters();
                f2916f = parameters2;
                f2915e = parameters2.isZoomSupported();
                h = f2916f.getMaxZoom();
                HVMagicView.f2835f.zoomMaxLevel(h);
                return false;
            } catch (Throwable unused2) {
                j = true;
                f2912b = null;
                return v();
            }
        }
    }

    public static void w() {
        if (f2912b != null) {
            boolean z2 = f2914d;
            f2916f = null;
            try {
                f2912b.setPreviewCallback(null);
            } catch (Exception e2) {
                e2.getMessage();
            }
            try {
                f2912b.stopPreview();
            } catch (Exception e3) {
                e3.getMessage();
            }
            try {
                f2912b.release();
            } catch (Exception e4) {
                e4.getMessage();
            }
            f2912b = null;
            j = true;
        }
    }

    public static void x() {
        Size size;
        Parameters parameters = f2912b.getParameters();
        Camera camera = f2912b;
        int i2 = HVMagicView.getmRatioWidth();
        int i3 = HVMagicView.getmRatioHeight();
        float previewMegapixels = HVMagicView.f2835f.getPreviewMegapixels();
        CameraEngine.getCaptureMode();
        List<Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
        Collections.sort(supportedPreviewSizes, new co.hyperverge.hvcamera.a.b((int) (previewMegapixels * 1000000.0f)));
        Iterator<Size> it = supportedPreviewSizes.iterator();
        while (true) {
            if (!it.hasNext()) {
                size = null;
                break;
            }
            size = it.next();
            if (size.width * i2 == size.height * i3) {
                break;
            }
        }
        parameters.setPreviewSize(size.width, size.height);
        Size a2 = co.hyperverge.hvcamera.a.a(f2912b, HVMagicView.getmRatioWidth(), HVMagicView.getmRatioHeight(), HVMagicView.f2835f.getPictureMegapixels(), HVMagicView.f2835f.isShouldCaptureHighResolutionImage());
        parameters.setPictureSize(a2.width, a2.height);
        HVMagicView.f2835f.onPictureSizeSet(a2.width, a2.height);
        co.hyperverge.hvcamera.a.f2842a = -1;
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes.contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
            k = "continuous-picture";
        } else if (supportedFocusModes.contains("auto")) {
            parameters.setFocusMode("auto");
            k = "auto";
        }
        int[] iArr = new int[2];
        parameters.getPreviewFpsRange(iArr);
        if (iArr[0] == iArr[1]) {
            Iterator<int[]> it2 = parameters.getSupportedPreviewFpsRange().iterator();
            while (true) {
                if (it2.hasNext()) {
                    int[] next = it2.next();
                    if (next[0] != next[1]) {
                        parameters.setPreviewFpsRange(next[0], next[1]);
                        break;
                    }
                }
            }
        }
        try {
            if (u) {
                parameters.setAntibanding(PDPrintFieldAttributeObject.CHECKED_STATE_OFF);
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
        if (parameters.isAutoExposureLockSupported()) {
            parameters.setAutoExposureLock(false);
        }
        try {
            f2912b.cancelAutoFocus();
            f2912b.setParameters(parameters);
        } catch (Exception e3) {
            e3.getMessage();
        }
    }

    public static void z() {
        Camera camera = f2912b;
        if (camera != null) {
            camera.startPreview();
            f2912b.cancelAutoFocus();
        }
    }

    public static void a(ShutterCallback shutterCallback, PictureCallback pictureCallback) {
        try {
            Parameters parameters = f2912b.getParameters();
            p = shutterCallback;
            q = pictureCallback;
            if (parameters.getMaxNumFocusAreas() <= 0 || f2913c != 0) {
                B();
                return;
            }
            f2912b.cancelAutoFocus();
            ScheduledFuture<?> schedule = s.schedule(new c(), 1000, TimeUnit.MILLISECONDS);
            if (!w.contains(Build.MODEL)) {
                f2912b.autoFocus(new d(schedule));
            }
        } catch (Exception unused) {
            B();
        }
    }

    public static void a(AutoFocusCallback autoFocusCallback) {
        Parameters parameters;
        try {
            if (f2912b != null) {
                try {
                    f2912b.cancelAutoFocus();
                    parameters = f2912b.getParameters();
                } catch (Throwable th) {
                    th.getMessage();
                    parameters = null;
                }
                if (parameters != null) {
                    if (parameters.getMaxNumMeteringAreas() > 0) {
                        parameters.setMeteringAreas(null);
                    }
                    if (parameters.getMaxNumFocusAreas() > 0) {
                        parameters.setFocusAreas(null);
                    }
                    if (k != null) {
                        parameters.setFocusMode(k);
                    }
                    try {
                        f2912b.cancelAutoFocus();
                        f2912b.setParameters(parameters);
                    } catch (Exception e2) {
                        e2.getMessage();
                    }
                }
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x004b A[Catch:{ Exception -> 0x0058 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0049 A[Catch:{ Exception -> 0x0058 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(double r8) {
        /*
            android.hardware.Camera r0 = f2912b     // Catch:{ Exception -> 0x0058 }
            android.hardware.Camera$Parameters r0 = r0.getParameters()     // Catch:{ Exception -> 0x0058 }
            float r1 = r0.getExposureCompensationStep()     // Catch:{ Exception -> 0x0058 }
            int r2 = r0.getExposureCompensation()     // Catch:{ Exception -> 0x0058 }
            float r2 = (float) r2     // Catch:{ Exception -> 0x0058 }
            int r3 = r0.getMaxExposureCompensation()     // Catch:{ Exception -> 0x0058 }
            int r4 = r0.getMinExposureCompensation()     // Catch:{ Exception -> 0x0058 }
            float r5 = r2 * r1
            float r8 = (float) r8     // Catch:{ Exception -> 0x0058 }
            float r5 = r5 + r8
            float r5 = r5 / r1
            double r8 = (double) r5     // Catch:{ Exception -> 0x0058 }
            double r8 = java.lang.Math.ceil(r8)     // Catch:{ Exception -> 0x0058 }
            int r8 = (int) r8     // Catch:{ Exception -> 0x0058 }
            float r9 = (float) r8     // Catch:{ Exception -> 0x0058 }
            float r1 = r9 - r2
            r5 = 1073741824(0x40000000, float:2.0)
            r6 = 1065353216(0x3f800000, float:1.0)
            int r7 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r7 <= 0) goto L_0x0037
            int r8 = java.lang.Math.round(r2)     // Catch:{ Exception -> 0x0058 }
            float r1 = r1 / r5
            int r9 = java.lang.Math.round(r1)     // Catch:{ Exception -> 0x0058 }
            goto L_0x0046
        L_0x0037:
            float r9 = r2 - r9
            int r9 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r9 <= 0) goto L_0x0047
            int r8 = java.lang.Math.round(r2)     // Catch:{ Exception -> 0x0058 }
            float r1 = r1 / r5
            int r9 = java.lang.Math.round(r1)     // Catch:{ Exception -> 0x0058 }
        L_0x0046:
            int r8 = r8 + r9
        L_0x0047:
            if (r8 >= r4) goto L_0x004b
            r3 = r4
            goto L_0x004f
        L_0x004b:
            if (r8 <= r3) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r3 = r8
        L_0x004f:
            r0.setExposureCompensation(r3)     // Catch:{ Exception -> 0x0058 }
            android.hardware.Camera r8 = f2912b     // Catch:{ Exception -> 0x0058 }
            r8.setParameters(r0)     // Catch:{ Exception -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r8 = move-exception
            r8.getMessage()
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hvcamera.magicfilter.camera.a.a(double):void");
    }
}

package co.hyperverge.hvcamera.magicfilter.camera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.WindowManager;
import androidx.core.widget.CompoundButtonCompat;
import co.hyperverge.hvcamera.HVCamHost;
import co.hyperverge.hvcamera.HVMagicView;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class b {
    public static ImageReader A = null;
    public static CameraCaptureSession B = null;
    public static CaptureRequest C = null;
    public static Surface D = null;
    public static int E = 0;
    public static HandlerThread F = null;
    public static List<Integer> G = null;
    public static boolean H = false;
    public static int I = 0;
    public static int J = 0;
    public static byte[][] K = new byte[5][];
    public static boolean M = false;
    public static CaptureCallback N = new C0050b();
    public static CaptureCallback O = new c();
    public static final SparseIntArray P;
    public static final List<Integer> R;
    public static final List<Integer> S;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f2918b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f2919c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Context f2920d = null;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f2921e = false;

    /* renamed from: f  reason: collision with root package name */
    public static int f2922f = 0;
    public static int g = 0;
    public static float h = -1.0f;
    public static Rect i;
    public static i j;
    public static CameraManager k;
    public static Semaphore l = new Semaphore(1);
    public static CameraDevice m;
    public static int n = -1;
    public static boolean o = false;
    public static final StateCallback p = new a();
    public static float[] q = {-1.0f, -1.0f};
    public static int r;
    public static Size s;
    public static Size t;
    public static boolean u = false;
    public static float v;
    public static float w;
    public static Handler x;
    public static Builder y;
    public static ImageReader z;

    public class a extends StateCallback {
        public void onDisconnected(CameraDevice cameraDevice) {
            b.l.release();
            cameraDevice.close();
            b.m = null;
        }

        public void onError(CameraDevice cameraDevice, int i) {
            b.l.release();
            cameraDevice.close();
            b.m = null;
        }

        public void onOpened(CameraDevice cameraDevice) {
            b.l.release();
            b.m = cameraDevice;
        }
    }

    /* renamed from: co.hyperverge.hvcamera.magicfilter.camera.b$b  reason: collision with other inner class name */
    public class C0050b extends CaptureCallback {
        public final void a(CaptureResult captureResult) {
            int i = b.r;
            if (i == 0) {
                try {
                    b.h = (float) ((Integer) captureResult.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION)).intValue();
                } catch (Exception e2) {
                    e2.getMessage();
                }
                try {
                    int intValue = ((Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE)).intValue();
                    if (intValue != 0) {
                        if (intValue != 1) {
                            if (intValue != 2) {
                                if (intValue != 3) {
                                    if (intValue != 4) {
                                        b.M = false;
                                        return;
                                    }
                                }
                            }
                            if (!b.M) {
                                HVMagicView.f2835f.showCrossHair(b.q[0], b.q[1], true);
                            }
                            b.M = true;
                            return;
                        }
                        HVMagicView.f2835f.showCrossHair(b.q[0], b.q[1], false);
                        b.M = false;
                        return;
                    }
                    b.M = false;
                } catch (Exception unused) {
                }
            } else if (i == 1) {
                Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num == null) {
                    b.r = 4;
                    b.D();
                } else if (4 == num.intValue() || 5 == num.intValue()) {
                    if (4 == num.intValue()) {
                        HVCamHost hVCamHost = HVMagicView.f2835f;
                        float[] fArr = b.q;
                        hVCamHost.showCrossHair(fArr[0], fArr[1], true);
                    } else {
                        HVCamHost hVCamHost2 = HVMagicView.f2835f;
                        float[] fArr2 = b.q;
                        hVCamHost2.showCrossHair(fArr2[0], fArr2[1], false);
                    }
                    b.M = false;
                    Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                    if (num2 == null || num2.intValue() == 2) {
                        b.r = 4;
                        b.D();
                        return;
                    }
                    try {
                        b.c(b.y);
                        b.y.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
                        b.r = 2;
                        b.B.capture(b.y.build(), b.N, b.x);
                    } catch (CameraAccessException e3) {
                        e3.getMessage();
                    }
                } else if (num.intValue() == 3 || num.intValue() == 1) {
                    HVCamHost hVCamHost3 = HVMagicView.f2835f;
                    float[] fArr3 = b.q;
                    hVCamHost3.showCrossHair(fArr3[0], fArr3[1], false);
                } else {
                    b.r = 4;
                    HVCamHost hVCamHost4 = HVMagicView.f2835f;
                    float[] fArr4 = b.q;
                    hVCamHost4.showCrossHair(fArr4[0], fArr4[1], true);
                    b.D();
                }
            } else if (i == 2) {
                Integer num3 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num3 == null || num3.intValue() == 5 || num3.intValue() == 4 || num3.intValue() == 2) {
                    b.r = 3;
                }
            } else if (i == 3) {
                Integer num4 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num4 == null || num4.intValue() != 5) {
                    b.r = 4;
                    b.D();
                }
            }
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            a(totalCaptureResult);
            try {
                HVMagicView.f2835f.onReady();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }

        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            a(captureResult);
        }
    }

    public class c extends CaptureCallback {
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            b.r = 1;
        }
    }

    public class d implements OnImageAvailableListener {
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00dd A[Catch:{ IllegalArgumentException -> 0x0102 }] */
        /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onImageAvailable(android.media.ImageReader r12) {
            /*
                r11 = this;
                android.media.Image r12 = r12.acquireLatestImage()     // Catch:{ Exception -> 0x0107 }
                int r0 = co.hyperverge.hvcamera.magicfilter.camera.b.f2922f     // Catch:{ Exception -> 0x0107 }
                int r0 = r0 + 45
                r1 = 90
                int r0 = r0 / r1
                int r0 = r0 * 90
                int r0 = r0 % 360
                int r2 = co.hyperverge.hvcamera.magicfilter.camera.b.E     // Catch:{ Exception -> 0x0107 }
                r3 = 270(0x10e, float:3.78E-43)
                int r2 = r2 - r3
                int r2 = r2 + r0
                boolean r0 = co.hyperverge.hvcamera.magicfilter.camera.CameraEngine.isFrontFacingCamera()     // Catch:{ Exception -> 0x0107 }
                if (r0 == 0) goto L_0x0038
                java.lang.String r0 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0107 }
                java.lang.String r0 = r0.toLowerCase()     // Catch:{ Exception -> 0x0107 }
                java.lang.String r4 = "rk3399-all"
                boolean r0 = r0.contains(r4)     // Catch:{ Exception -> 0x0107 }
                if (r0 == 0) goto L_0x0031
                int r0 = 90 - r2
                int r0 = r0 + 360
                int r0 = r0 % 360
            L_0x002f:
                r9 = r0
                goto L_0x0052
            L_0x0031:
                int r0 = 270 - r2
                int r0 = r0 + 360
                int r0 = r0 % 360
                goto L_0x002f
            L_0x0038:
                java.lang.String r0 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0107 }
                java.lang.String r0 = r0.toLowerCase()     // Catch:{ Exception -> 0x0107 }
                java.lang.String r4 = "comio x1"
                boolean r0 = r0.contains(r4)     // Catch:{ Exception -> 0x0107 }
                if (r0 == 0) goto L_0x004b
                int r0 = r2 + 90
                int r0 = r0 % 360
                goto L_0x002f
            L_0x004b:
                int r0 = 270 - r2
                int r0 = r0 + 360
                int r0 = r0 % 360
                goto L_0x002f
            L_0x0052:
                java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0107 }
                r0.<init>()     // Catch:{ Exception -> 0x0107 }
                android.media.Image$Plane[] r4 = r12.getPlanes()     // Catch:{ Exception -> 0x0107 }
                r5 = 0
                r4 = r4[r5]     // Catch:{ Exception -> 0x0107 }
                java.nio.ByteBuffer r4 = r4.getBuffer()     // Catch:{ Exception -> 0x0107 }
                int r5 = r4.remaining()     // Catch:{ Exception -> 0x0107 }
                byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0107 }
                r4.get(r5)     // Catch:{ Exception -> 0x0107 }
                android.media.Image$Plane[] r4 = r12.getPlanes()     // Catch:{ Exception -> 0x0107 }
                r6 = 1
                r4 = r4[r6]     // Catch:{ Exception -> 0x0107 }
                java.nio.ByteBuffer r4 = r4.getBuffer()     // Catch:{ Exception -> 0x0107 }
                int r7 = r4.remaining()     // Catch:{ Exception -> 0x0107 }
                byte[] r7 = new byte[r7]     // Catch:{ Exception -> 0x0107 }
                r4.get(r7)     // Catch:{ Exception -> 0x0107 }
                android.media.Image$Plane[] r4 = r12.getPlanes()     // Catch:{ Exception -> 0x0107 }
                r8 = 2
                r4 = r4[r8]     // Catch:{ Exception -> 0x0107 }
                java.nio.ByteBuffer r4 = r4.getBuffer()     // Catch:{ Exception -> 0x0107 }
                int r8 = r4.remaining()     // Catch:{ Exception -> 0x0107 }
                byte[] r8 = new byte[r8]     // Catch:{ Exception -> 0x0107 }
                r4.get(r8)     // Catch:{ Exception -> 0x0107 }
                r0.write(r5)     // Catch:{ Exception -> 0x0107 }
                r0.write(r8)     // Catch:{ Exception -> 0x0107 }
                r0.write(r7)     // Catch:{ Exception -> 0x0107 }
                r12.close()     // Catch:{ Exception -> 0x0107 }
                java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0107 }
                int r12 = co.hyperverge.hvcamera.magicfilter.camera.b.I     // Catch:{ Exception -> 0x0107 }
                int r12 = r12 + r6
                int r12 = r12 % 3
                co.hyperverge.hvcamera.magicfilter.camera.b.I = r12     // Catch:{ Exception -> 0x0107 }
                android.util.Size r12 = co.hyperverge.hvcamera.magicfilter.camera.b.s     // Catch:{ Exception -> 0x0107 }
                int r12 = r12.getWidth()     // Catch:{ Exception -> 0x0107 }
                android.util.Size r4 = co.hyperverge.hvcamera.magicfilter.camera.b.s     // Catch:{ Exception -> 0x0107 }
                int r4 = r4.getHeight()     // Catch:{ Exception -> 0x0107 }
                if (r9 == r1) goto L_0x00bc
                if (r9 != r3) goto L_0x00ba
                goto L_0x00bc
            L_0x00ba:
                r7 = r4
                goto L_0x00c9
            L_0x00bc:
                android.util.Size r12 = co.hyperverge.hvcamera.magicfilter.camera.b.s     // Catch:{ Exception -> 0x0107 }
                int r12 = r12.getHeight()     // Catch:{ Exception -> 0x0107 }
                android.util.Size r1 = co.hyperverge.hvcamera.magicfilter.camera.b.s     // Catch:{ Exception -> 0x0107 }
                int r1 = r1.getWidth()     // Catch:{ Exception -> 0x0107 }
                r7 = r1
            L_0x00c9:
                int r1 = co.hyperverge.hvcamera.magicfilter.camera.b.J     // Catch:{ IllegalArgumentException -> 0x0102 }
                int r1 = r1 + r6
                int r1 = r1 % 5
                co.hyperverge.hvcamera.magicfilter.camera.b.J = r1     // Catch:{ IllegalArgumentException -> 0x0102 }
                byte[][] r1 = co.hyperverge.hvcamera.magicfilter.camera.b.K     // Catch:{ IllegalArgumentException -> 0x0102 }
                int r4 = co.hyperverge.hvcamera.magicfilter.camera.b.J     // Catch:{ IllegalArgumentException -> 0x0102 }
                r1 = r1[r4]     // Catch:{ IllegalArgumentException -> 0x0102 }
                co.hyperverge.hvcamera.magicfilter.camera.CameraEngine.rotateNV21a(r5, r7, r12, r9, r1)     // Catch:{ IllegalArgumentException -> 0x0102 }
                co.hyperverge.hvcamera.magicfilter.camera.b$i r1 = co.hyperverge.hvcamera.magicfilter.camera.b.j     // Catch:{ IllegalArgumentException -> 0x0102 }
                if (r1 == 0) goto L_0x010b
                co.hyperverge.hvcamera.magicfilter.camera.b$i r1 = co.hyperverge.hvcamera.magicfilter.camera.b.j     // Catch:{ IllegalArgumentException -> 0x0102 }
                byte[][] r4 = co.hyperverge.hvcamera.magicfilter.camera.b.K     // Catch:{ IllegalArgumentException -> 0x0102 }
                int r5 = co.hyperverge.hvcamera.magicfilter.camera.b.J     // Catch:{ IllegalArgumentException -> 0x0102 }
                r5 = r4[r5]     // Catch:{ IllegalArgumentException -> 0x0102 }
                int r2 = r2 + 360
                int r4 = co.hyperverge.hvcamera.magicfilter.camera.b.E     // Catch:{ IllegalArgumentException -> 0x0102 }
                int r4 = r4 - r3
                int r4 = r4 + r2
                int r8 = r4 % 360
                byte[] r0 = r0.toByteArray()     // Catch:{ IllegalArgumentException -> 0x0102 }
                byte[] r10 = androidx.core.widget.CompoundButtonCompat.a(r0, r7, r12, r9)     // Catch:{ IllegalArgumentException -> 0x0102 }
                co.hyperverge.hvcamera.c.a.b$e r1 = (co.hyperverge.hvcamera.c.a.b.e) r1     // Catch:{ IllegalArgumentException -> 0x0102 }
                if (r1 == 0) goto L_0x0100
                co.hyperverge.hvcamera.HVCamHost r4 = co.hyperverge.hvcamera.HVMagicView.f2835f     // Catch:{ IllegalArgumentException -> 0x0102 }
                r6 = r12
                r4.onNewPreviewFrame(r5, r6, r7, r8, r9, r10)     // Catch:{ IllegalArgumentException -> 0x0102 }
                goto L_0x010b
            L_0x0100:
                r12 = 0
                throw r12     // Catch:{ IllegalArgumentException -> 0x0102 }
            L_0x0102:
                r12 = move-exception
                r12.getMessage()     // Catch:{ Exception -> 0x0107 }
                goto L_0x010b
            L_0x0107:
                r12 = move-exception
                r12.getMessage()
            L_0x010b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hvcamera.magicfilter.camera.b.d.onImageAvailable(android.media.ImageReader):void");
        }
    }

    public class e implements OnImageAvailableListener {
        public void onImageAvailable(ImageReader imageReader) {
            try {
                Image acquireLatestImage = imageReader.acquireLatestImage();
                ByteBuffer buffer = acquireLatestImage.getPlanes()[0].getBuffer();
                byte[] bArr = new byte[buffer.remaining()];
                buffer.get(bArr);
                if (b.j != null) {
                    if (((co.hyperverge.hvcamera.c.a.b.e) b.j) != null) {
                        HVMagicView.f2835f.onPictureReady(bArr);
                    } else {
                        throw null;
                    }
                }
                acquireLatestImage.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
    }

    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SurfaceTexture f2923a;

        public class a extends CameraCaptureSession.StateCallback {
            public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            }

            public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                if (b.m != null) {
                    b.B = cameraCaptureSession;
                    try {
                        b.y.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
                        b.y.set(CaptureRequest.CONTROL_MODE, Integer.valueOf(1));
                        if (b.n == 1) {
                            b.y.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, Integer.valueOf(1));
                            b.y.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, Integer.valueOf(0));
                        } else {
                            b.y.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, Integer.valueOf(0));
                            b.y.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, Integer.valueOf(1));
                        }
                        if (CameraEngine.f2911e) {
                            b.y.set(CaptureRequest.SCALER_CROP_REGION, b.b(b.w));
                        }
                        b.c(b.y);
                        b.C = b.y.build();
                        b.B.setRepeatingRequest(b.C, b.N, b.x);
                    } catch (CameraAccessException e2) {
                        e2.getMessage();
                    }
                }
            }
        }

        public f(SurfaceTexture surfaceTexture) {
            this.f2923a = surfaceTexture;
        }

        public void run() {
            List list;
            if (b.m != null) {
                try {
                    if (this.f2923a != null) {
                        b.D = new Surface(this.f2923a);
                        this.f2923a.setDefaultBufferSize(b.s.getWidth(), b.s.getHeight());
                        Builder createCaptureRequest = b.m.createCaptureRequest(1);
                        b.y = createCaptureRequest;
                        createCaptureRequest.addTarget(b.D);
                        if (CameraEngine.f2909b) {
                            b.y.addTarget(b.A.getSurface());
                        }
                        b.r = 0;
                        if (CameraEngine.f2909b) {
                            list = Arrays.asList(new Surface[]{b.D, b.z.getSurface(), b.A.getSurface()});
                        } else {
                            list = Arrays.asList(new Surface[]{b.D, b.z.getSurface()});
                        }
                        b.m.createCaptureSession(list, new a(), null);
                    }
                } catch (CameraAccessException e2) {
                    e2.getMessage();
                } catch (IllegalStateException e3) {
                    e3.getMessage();
                } catch (Exception e4) {
                    e4.getMessage();
                }
            }
        }
    }

    public class g extends CaptureCallback {
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            try {
                b.y.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
                b.B.capture(b.y.build(), b.N, b.x);
                b.r = 0;
                b.B.setRepeatingRequest(b.C, b.N, b.x);
            } catch (Exception e2) {
                e2.getMessage();
            }
        }

        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
            super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
            HVMagicView.f2835f.flashScreen();
        }
    }

    public class h implements Runnable {
        public void run() {
            if (b.g > 0) {
                List<Integer> list = b.G;
                if (!(list != null && list.size() == 1 && b.G.get(0).intValue() == 1)) {
                    try {
                        int i = b.g;
                        if (i == 1) {
                            HVMagicView.f2835f.onFlashOff();
                            return;
                        } else if (i == 2) {
                            HVMagicView.f2835f.onFlashAuto();
                            return;
                        } else if (i == 3) {
                            HVMagicView.f2835f.onFlashOn();
                            return;
                        } else {
                            return;
                        }
                    } catch (Exception e2) {
                        e2.getMessage();
                        return;
                    }
                }
            }
            HVMagicView.f2835f.onFlashNull();
        }
    }

    public interface i {
    }

    static {
        new Matrix();
        Integer valueOf = Integer.valueOf(1);
        SparseIntArray sparseIntArray = new SparseIntArray();
        P = sparseIntArray;
        sparseIntArray.append(0, 90);
        P.append(1, 0);
        P.append(2, 270);
        SparseIntArray sparseIntArray2 = P;
        Integer valueOf2 = Integer.valueOf(3);
        sparseIntArray2.append(3, RotationOptions.ROTATE_180);
        ArrayList arrayList = new ArrayList();
        R = arrayList;
        arrayList.add(valueOf2);
        R.add(valueOf);
        ArrayList arrayList2 = new ArrayList();
        S = arrayList2;
        arrayList2.add(valueOf2);
        S.add(valueOf);
    }

    public static void D() {
        try {
            if (f2920d != null) {
                if (m != null) {
                    Builder createCaptureRequest = m.createCaptureRequest(2);
                    createCaptureRequest.addTarget(z.getSurface());
                    createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
                    createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
                    if (y.get(CaptureRequest.CONTROL_AE_REGIONS) != null) {
                        createCaptureRequest.set(CaptureRequest.CONTROL_AE_REGIONS, y.get(CaptureRequest.CONTROL_AE_REGIONS));
                    }
                    if (y.get(CaptureRequest.CONTROL_AF_REGIONS) != null) {
                        createCaptureRequest.set(CaptureRequest.CONTROL_AF_REGIONS, y.get(CaptureRequest.CONTROL_AF_REGIONS));
                    }
                    try {
                        if (H) {
                            createCaptureRequest.set(CaptureRequest.CONTROL_AE_ANTIBANDING_MODE, Integer.valueOf(0));
                        }
                    } catch (Exception e2) {
                        e2.getMessage();
                    }
                    c(createCaptureRequest);
                    CameraCharacteristics cameraCharacteristics = k.getCameraCharacteristics(f2919c);
                    if (CameraEngine.f2911e) {
                        createCaptureRequest.set(CaptureRequest.SCALER_CROP_REGION, b(1.0f));
                    } else if (i != null) {
                        createCaptureRequest.set(CaptureRequest.SCALER_CROP_REGION, i);
                    }
                    createCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(a(cameraCharacteristics, f2922f)));
                    g gVar = new g();
                    B.stopRepeating();
                    B.capture(createCaptureRequest.build(), gVar, null);
                }
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
    }

    public static void E() {
        try {
            if (r != 0) {
                D();
            }
            l.acquire();
            if (B != null) {
                B.close();
                B = null;
            }
            if (m != null) {
                m.close();
                m = null;
            }
            if (z != null) {
                z.close();
                z = null;
            }
            if (A != null) {
                A.close();
                A = null;
            }
            Q();
            l.release();
            o = true;
        } catch (InterruptedException e2) {
            throw new RuntimeException("Interrupted while trying to lock camera closing.", e2);
        } catch (Throwable th) {
            l.release();
            o = true;
            throw th;
        }
    }

    public static int H() {
        ((WindowManager) f2920d.getSystemService("window")).getDefaultDisplay().getRotation();
        if (!Build.MODEL.toLowerCase().contains("comio x1") || f2921e) {
            return RotationOptions.ROTATE_180;
        }
        return 0;
    }

    @SuppressLint({"MissingPermission"})
    public static void N() {
        if (f2921e) {
            f2919c = d(0);
        }
        if (f2919c == null || !f2921e) {
            f2919c = d(1);
        }
        HandlerThread handlerThread = new HandlerThread("CameraBackground");
        F = handlerThread;
        handlerThread.start();
        x = new Handler(F.getLooper());
        try {
            if (l.tryAcquire(2500, TimeUnit.MILLISECONDS)) {
                k.openCamera(f2919c, p, x);
                CameraCharacteristics cameraCharacteristics = k.getCameraCharacteristics(f2919c);
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                HVMagicView.c();
                a((int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES));
                float floatValue = ((Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
                v = floatValue;
                if (floatValue > 1.0f) {
                    u = true;
                }
                float f2 = CameraEngine.f2910d;
                w = f2;
                i = b(f2);
                HVMagicView.f2835f.zoomMaxLevel((int) v);
                U();
                q[0] = -1.0f;
                q[1] = -1.0f;
                int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
                if (iArr != null) {
                    n = -1;
                    int length = iArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (iArr[i2] == 1) {
                            n = 1;
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                ((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue();
                HVMagicView.f2835f.getAspectRatio();
                s = CompoundButtonCompat.a(streamConfigurationMap, HVMagicView.getmRatioWidth(), HVMagicView.getmRatioHeight(), HVMagicView.f2835f.getPreviewMegapixels());
                t = CompoundButtonCompat.a(streamConfigurationMap, HVMagicView.getmRatioWidth(), HVMagicView.getmRatioHeight(), HVMagicView.f2835f.getPictureMegapixels(), HVMagicView.f2835f.isShouldCaptureHighResolutionImage());
                HVMagicView.f2835f.onPictureSizeSet(t.getWidth(), t.getHeight());
                z = ImageReader.newInstance(t.getWidth(), t.getHeight(), 256, 2);
                if (CameraEngine.f2909b) {
                    A = ImageReader.newInstance(s.getWidth(), s.getHeight(), 35, 5);
                    for (int i3 = 0; i3 < 5; i3++) {
                        K[i3] = new byte[(s.getWidth() * s.getHeight())];
                    }
                    A.setOnImageAvailableListener(new d(), x);
                }
                z.setOnImageAvailableListener(new e(), x);
                E = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
                a(cameraCharacteristics, f2922f);
                return;
            }
            throw new RuntimeException("Time out waiting to lock camera opening.");
        } catch (CameraAccessException e2) {
            e2.getMessage();
        } catch (InterruptedException e3) {
            throw new RuntimeException("Interrupted while trying to lock camera opening.", e3);
        } catch (RuntimeException unused) {
            N();
        } catch (Exception e4) {
            e4.getMessage();
        }
    }

    public static void Q() {
        try {
            F.quitSafely();
            try {
                F.join();
                F = null;
                x = null;
            } catch (InterruptedException e2) {
                e2.getMessage();
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
    }

    public static void U() {
        new Handler(Looper.getMainLooper()).post(new h());
    }

    public static void a(Point point) {
        int i2 = point.x;
    }

    public static Rect b(float f2) {
        try {
            return co.hyperverge.hvcamera.magicfilter.utils.a.a(k.getCameraCharacteristics(f2919c), f2, v);
        } catch (CameraAccessException e2) {
            e2.getMessage();
            return new Rect(0, 0, 0, 0);
        }
    }

    public static void c(Builder builder) {
        List<Integer> list = G;
        if (list != null && list.contains(Integer.valueOf(g))) {
            try {
                int i2 = g;
                if (i2 == 1) {
                    builder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
                    builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
                } else if (i2 == 2) {
                    builder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(2));
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        builder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(2));
                    } else {
                        builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(4));
                    }
                } else if (f2918b) {
                    builder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
                    builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(2));
                } else {
                    builder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
                    builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(2));
                }
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
    }

    public static String d(int i2) {
        try {
            for (String str : k.getCameraIdList()) {
                Integer num = (Integer) k.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING);
                if (num != null && num.intValue() == i2) {
                    return str;
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
        return null;
    }

    public static void f(int i2) {
        f2922f = i2 % JpegTranscoderUtils.FULL_ROUND;
    }

    public static void a(int[] iArr) {
        if (iArr != null) {
            ArrayList arrayList = new ArrayList();
            for (int valueOf : iArr) {
                Integer valueOf2 = Integer.valueOf(valueOf);
                if (f2918b) {
                    if (R.contains(valueOf2)) {
                        arrayList.add(valueOf2);
                    }
                } else if (S.contains(valueOf2)) {
                    arrayList.add(valueOf2);
                }
            }
            G = arrayList;
            if (arrayList.size() > 0) {
                g = G.get(0).intValue();
            } else {
                g = -1;
            }
        } else {
            G = null;
            g = -1;
        }
    }

    public static int a(CameraCharacteristics cameraCharacteristics, int i2) {
        boolean z2 = false;
        if (i2 == -1) {
            return 0;
        }
        int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        int i3 = ((i2 + 45) / 90) * 90;
        if (((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
            z2 = true;
        }
        if (z2) {
            i3 = -i3;
        }
        return ((intValue + i3) + JpegTranscoderUtils.FULL_ROUND) % JpegTranscoderUtils.FULL_ROUND;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0066 A[Catch:{ Exception -> 0x0087 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0064 A[Catch:{ Exception -> 0x0087 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(double r7) {
        /*
            android.hardware.camera2.CameraManager r0 = k     // Catch:{ Exception -> 0x0087 }
            java.lang.String r1 = f2919c     // Catch:{ Exception -> 0x0087 }
            android.hardware.camera2.CameraCharacteristics r0 = r0.getCameraCharacteristics(r1)     // Catch:{ Exception -> 0x0087 }
            android.hardware.camera2.CameraCharacteristics$Key r1 = android.hardware.camera2.CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE     // Catch:{ Exception -> 0x0087 }
            java.lang.Object r1 = r0.get(r1)     // Catch:{ Exception -> 0x0087 }
            android.util.Range r1 = (android.util.Range) r1     // Catch:{ Exception -> 0x0087 }
            android.hardware.camera2.CameraCharacteristics$Key r2 = android.hardware.camera2.CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP     // Catch:{ Exception -> 0x0087 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x0087 }
            android.util.Rational r0 = (android.util.Rational) r0     // Catch:{ Exception -> 0x0087 }
            float r0 = r0.floatValue()     // Catch:{ Exception -> 0x0087 }
            float r2 = h     // Catch:{ Exception -> 0x0087 }
            java.lang.Comparable r3 = r1.getUpper()     // Catch:{ Exception -> 0x0087 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ Exception -> 0x0087 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x0087 }
            java.lang.Comparable r1 = r1.getLower()     // Catch:{ Exception -> 0x0087 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0087 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0087 }
            float r4 = r2 * r0
            float r7 = (float) r7     // Catch:{ Exception -> 0x0087 }
            float r4 = r4 + r7
            float r4 = r4 / r0
            double r7 = (double) r4     // Catch:{ Exception -> 0x0087 }
            double r7 = java.lang.Math.ceil(r7)     // Catch:{ Exception -> 0x0087 }
            int r7 = (int) r7     // Catch:{ Exception -> 0x0087 }
            float r8 = (float) r7     // Catch:{ Exception -> 0x0087 }
            float r0 = r8 - r2
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 1065353216(0x3f800000, float:1.0)
            int r6 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r6 <= 0) goto L_0x0052
            int r7 = java.lang.Math.round(r2)     // Catch:{ Exception -> 0x0087 }
            float r0 = r0 / r4
            int r8 = java.lang.Math.round(r0)     // Catch:{ Exception -> 0x0087 }
            goto L_0x0061
        L_0x0052:
            float r8 = r2 - r8
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 <= 0) goto L_0x0062
            int r7 = java.lang.Math.round(r2)     // Catch:{ Exception -> 0x0087 }
            float r0 = r0 / r4
            int r8 = java.lang.Math.round(r0)     // Catch:{ Exception -> 0x0087 }
        L_0x0061:
            int r7 = r7 + r8
        L_0x0062:
            if (r7 >= r1) goto L_0x0066
            r3 = r1
            goto L_0x006a
        L_0x0066:
            if (r7 <= r3) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r3 = r7
        L_0x006a:
            android.hardware.camera2.CameraDevice r7 = m     // Catch:{ Exception -> 0x0087 }
            r8 = 2
            android.hardware.camera2.CaptureRequest$Builder r7 = r7.createCaptureRequest(r8)     // Catch:{ Exception -> 0x0087 }
            android.hardware.camera2.CaptureRequest$Key r8 = android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION     // Catch:{ Exception -> 0x0087 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0087 }
            r7.set(r8, r0)     // Catch:{ Exception -> 0x0087 }
            android.hardware.camera2.CameraCaptureSession r8 = B     // Catch:{ Exception -> 0x0087 }
            android.hardware.camera2.CaptureRequest r7 = r7.build()     // Catch:{ Exception -> 0x0087 }
            r0 = 0
            android.os.Handler r1 = x     // Catch:{ Exception -> 0x0087 }
            r8.capture(r7, r0, r1)     // Catch:{ Exception -> 0x0087 }
            return
        L_0x0087:
            r7 = move-exception
            r7.getMessage()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hvcamera.magicfilter.camera.b.a(double):void");
    }

    public static void c(float f2) {
        boolean z2 = u;
        if (z2 && z2 && f2919c != null && f2 > 0.0f) {
            try {
                if (f2 <= v) {
                    w = f2;
                    if (f2 <= v) {
                        i = b(f2);
                        y.set(CaptureRequest.SCALER_CROP_REGION, b(w));
                        CaptureRequest build = y.build();
                        C = build;
                        try {
                            B.setRepeatingRequest(build, N, x);
                        } catch (CameraAccessException e2) {
                            e2.getMessage();
                        }
                    }
                }
            } catch (Exception e3) {
                e3.getMessage();
            }
        }
    }

    public static void a(Object obj) {
        try {
            q[0] = -1.0f;
            q[1] = -1.0f;
            CameraCharacteristics cameraCharacteristics = k.getCameraCharacteristics(f2919c);
            if (((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0) {
                y.set(CaptureRequest.CONTROL_AF_REGIONS, null);
            }
            if (((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE)).intValue() > 0) {
                y.set(CaptureRequest.CONTROL_AE_REGIONS, null);
            }
            y.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
            B.capture(y.build(), N, x);
            y.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(0));
            y.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
            CaptureRequest build = y.build();
            C = build;
            B.setRepeatingRequest(build, N, x);
        } catch (Exception e2) {
            e2.getMessage();
        }
    }
}

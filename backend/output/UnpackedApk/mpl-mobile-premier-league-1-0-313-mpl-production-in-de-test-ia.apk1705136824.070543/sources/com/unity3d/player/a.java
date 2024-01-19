package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureRequest.Key;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static CameraManager f3476b;

    /* renamed from: c  reason: collision with root package name */
    public static String[] f3477c;

    /* renamed from: e  reason: collision with root package name */
    public static Semaphore f3478e = new Semaphore(1);
    public CaptureCallback A = new CaptureCallback() {
        public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            a.this.a(captureRequest.getTag());
        }

        public final void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            f.Log(5, "Camera2: Capture session failed " + captureRequest.getTag() + " reason " + captureFailure.getReason());
            a.this.a(captureRequest.getTag());
        }

        public final void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
        }

        public final void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i, long j) {
        }
    };
    public final StateCallback B = new StateCallback() {
        public final void onClosed(CameraDevice cameraDevice) {
            a.f3478e.release();
        }

        public final void onDisconnected(CameraDevice cameraDevice) {
            f.Log(5, "Camera2: CameraDevice disconnected.");
            a.this.a(cameraDevice);
            a.f3478e.release();
        }

        public final void onError(CameraDevice cameraDevice, int i) {
            f.Log(6, "Camera2: Error opeining CameraDevice " + i);
            a.this.a(cameraDevice);
            a.f3478e.release();
        }

        public final void onOpened(CameraDevice cameraDevice) {
            a.this.f3480d = cameraDevice;
            a.f3478e.release();
        }
    };
    public final OnImageAvailableListener C = new OnImageAvailableListener() {
        public final void onImageAvailable(ImageReader imageReader) {
            if (a.f3478e.tryAcquire()) {
                Image acquireNextImage = imageReader.acquireNextImage();
                if (acquireNextImage != null) {
                    Plane[] planes = acquireNextImage.getPlanes();
                    if (acquireNextImage.getFormat() == 35 && planes != null && planes.length == 3) {
                        c h = a.this.f3479a;
                        ByteBuffer buffer = planes[0].getBuffer();
                        ByteBuffer buffer2 = planes[1].getBuffer();
                        ByteBuffer buffer3 = planes[2].getBuffer();
                        h.a(buffer, buffer2, buffer3, planes[0].getRowStride(), planes[1].getRowStride(), planes[1].getPixelStride());
                    } else {
                        f.Log(6, "Camera2: Wrong image format.");
                    }
                    if (a.this.s != null) {
                        a.this.s.close();
                    }
                    a.this.s = acquireNextImage;
                }
                a.f3478e.release();
            }
        }
    };
    public final OnFrameAvailableListener D = new OnFrameAvailableListener() {
        public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
            a.this.f3479a.a(surfaceTexture);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public c f3479a = null;

    /* renamed from: d  reason: collision with root package name */
    public CameraDevice f3480d;

    /* renamed from: f  reason: collision with root package name */
    public HandlerThread f3481f;
    public Handler g;
    public Rect h;
    public Rect i;
    public int j;
    public int k;
    public float l = -1.0f;
    public float m = -1.0f;
    public int n;
    public int o;
    public boolean p = false;
    public Range q;
    public ImageReader r = null;
    public Image s;
    public Builder t;
    public CameraCaptureSession u = null;
    public Object v = new Object();
    public int w;
    public SurfaceTexture x;
    public Surface y = null;
    public int z = C0065a.f3489c;

    /* renamed from: com.unity3d.player.a$a  reason: collision with other inner class name */
    public enum C0065a {
        ;

        /* access modifiers changed from: public */
        static {
            f3490d = new int[]{1, 2, 3};
        }
    }

    public a(c cVar) {
        this.f3479a = cVar;
        g();
    }

    public static int a(Context context) {
        return c(context).length;
    }

    public static int a(Context context, int i2) {
        try {
            return ((Integer) b(context).getCameraCharacteristics(c(context)[i2]).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        } catch (CameraAccessException e2) {
            f.Log(6, "Camera2: CameraAccessException " + e2);
            return 0;
        }
    }

    public static int a(Range[] rangeArr, int i2) {
        int i3 = -1;
        double d2 = Double.MAX_VALUE;
        for (int i4 = 0; i4 < rangeArr.length; i4++) {
            int intValue = ((Integer) rangeArr[i4].getLower()).intValue();
            int intValue2 = ((Integer) rangeArr[i4].getUpper()).intValue();
            float f2 = (float) i2;
            if (f2 + 0.1f > ((float) intValue) && f2 - 0.1f < ((float) intValue2)) {
                return i2;
            }
            double min = (double) ((float) Math.min(Math.abs(i2 - intValue), Math.abs(i2 - intValue2)));
            if (min < d2) {
                i3 = i4;
                d2 = min;
            }
        }
        return ((Integer) (i2 > ((Integer) rangeArr[i3].getUpper()).intValue() ? rangeArr[i3].getUpper() : rangeArr[i3].getLower())).intValue();
    }

    public static Rect a(Size[] sizeArr, double d2, double d3) {
        Size[] sizeArr2 = sizeArr;
        double d4 = Double.MAX_VALUE;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < sizeArr2.length; i4++) {
            int width = sizeArr2[i4].getWidth();
            int height = sizeArr2[i4].getHeight();
            double abs = Math.abs(Math.log(d3 / ((double) height))) + Math.abs(Math.log(d2 / ((double) width)));
            if (abs < d4) {
                i2 = width;
                i3 = height;
                d4 = abs;
            }
        }
        return new Rect(0, 0, i2, i3);
    }

    /* access modifiers changed from: private */
    public void a(CameraDevice cameraDevice) {
        synchronized (this.v) {
            this.u = null;
        }
        cameraDevice.close();
        this.f3480d = null;
    }

    /* access modifiers changed from: private */
    public void a(Object obj) {
        if (obj == "Focus") {
            this.p = false;
            synchronized (this.v) {
                if (this.u != null) {
                    try {
                        this.t.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(0));
                        this.t.setTag("Regular");
                        this.u.setRepeatingRequest(this.t.build(), this.A, this.g);
                    } catch (CameraAccessException e2) {
                        f.Log(6, "Camera2: CameraAccessException " + e2);
                    }
                }
            }
        } else if (obj == "Cancel focus") {
            synchronized (this.v) {
                if (this.u != null) {
                    j();
                }
            }
        }
    }

    public static Size[] a(CameraCharacteristics cameraCharacteristics) {
        String str;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            str = "Camera2: configuration map is not available.";
        } else {
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(35);
            if (outputSizes != null && outputSizes.length != 0) {
                return outputSizes;
            }
            str = "Camera2: output sizes for YUV_420_888 format are not avialable.";
        }
        f.Log(6, str);
        return null;
    }

    public static CameraManager b(Context context) {
        if (f3476b == null) {
            f3476b = (CameraManager) context.getSystemService("camera");
        }
        return f3476b;
    }

    private void b(CameraCharacteristics cameraCharacteristics) {
        int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue();
        this.k = intValue;
        if (intValue > 0) {
            Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            this.i = rect;
            float width = ((float) rect.width()) / ((float) this.i.height());
            float width2 = ((float) this.h.width()) / ((float) this.h.height());
            if (width2 > width) {
                this.n = 0;
                this.o = (int) ((((float) this.i.height()) - (((float) this.i.width()) / width2)) / 2.0f);
            } else {
                this.o = 0;
                this.n = (int) ((((float) this.i.width()) - (((float) this.i.height()) * width2)) / 2.0f);
            }
            this.j = Math.min(this.i.width(), this.i.height()) / 20;
        }
    }

    public static boolean b(Context context, int i2) {
        try {
            return ((Integer) b(context).getCameraCharacteristics(c(context)[i2]).get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
        } catch (CameraAccessException e2) {
            f.Log(6, "Camera2: CameraAccessException " + e2);
            return false;
        }
    }

    public static boolean c(Context context, int i2) {
        try {
            return ((Integer) b(context).getCameraCharacteristics(c(context)[i2]).get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0;
        } catch (CameraAccessException e2) {
            f.Log(6, "Camera2: CameraAccessException " + e2);
            return false;
        }
    }

    public static String[] c(Context context) {
        if (f3477c == null) {
            try {
                f3477c = b(context).getCameraIdList();
            } catch (CameraAccessException e2) {
                f.Log(6, "Camera2: CameraAccessException " + e2);
                f3477c = new String[0];
            }
        }
        return f3477c;
    }

    public static int[] d(Context context, int i2) {
        try {
            Size[] a2 = a(b(context).getCameraCharacteristics(c(context)[i2]));
            if (a2 == null) {
                return null;
            }
            int[] iArr = new int[(a2.length * 2)];
            for (int i3 = 0; i3 < a2.length; i3++) {
                int i4 = i3 * 2;
                iArr[i4] = a2[i3].getWidth();
                iArr[i4 + 1] = a2[i3].getHeight();
            }
            return iArr;
        } catch (CameraAccessException e2) {
            f.Log(6, "Camera2: CameraAccessException " + e2);
            return null;
        }
    }

    private void g() {
        HandlerThread handlerThread = new HandlerThread("CameraBackground");
        this.f3481f = handlerThread;
        handlerThread.start();
        this.g = new Handler(this.f3481f.getLooper());
    }

    private void h() {
        this.f3481f.quit();
        try {
            this.f3481f.join(4000);
            this.f3481f = null;
            this.g = null;
        } catch (InterruptedException e2) {
            this.f3481f.interrupt();
            f.Log(6, "Camera2: Interrupted while waiting for the background thread to finish " + e2);
        }
    }

    private void i() {
        try {
            if (!f3478e.tryAcquire(4, TimeUnit.SECONDS)) {
                f.Log(5, "Camera2: Timeout waiting to lock camera for closing.");
                return;
            }
            this.f3480d.close();
            try {
                if (!f3478e.tryAcquire(4, TimeUnit.SECONDS)) {
                    f.Log(5, "Camera2: Timeout waiting to close camera.");
                }
            } catch (InterruptedException e2) {
                f.Log(6, "Camera2: Interrupted while waiting to close camera " + e2);
            }
            this.f3480d = null;
            f3478e.release();
        } catch (InterruptedException e3) {
            f.Log(6, "Camera2: Interrupted while trying to lock camera for closing " + e3);
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        try {
            if (this.k != 0 && this.l >= 0.0f && this.l <= 1.0f && this.m >= 0.0f) {
                if (this.m <= 1.0f) {
                    this.p = true;
                    int height = (int) (((1.0d - ((double) this.m)) * ((double) (this.i.height() - (this.o * 2)))) + ((double) this.o));
                    int max = Math.max(this.j + 1, Math.min((int) ((((float) (this.i.width() - (this.n * 2))) * this.l) + ((float) this.n)), (this.i.width() - this.j) - 1));
                    int max2 = Math.max(this.j + 1, Math.min(height, (this.i.height() - this.j) - 1));
                    Builder builder = this.t;
                    Key key = CaptureRequest.CONTROL_AF_REGIONS;
                    MeteringRectangle meteringRectangle = new MeteringRectangle(max - this.j, max2 - this.j, this.j * 2, this.j * 2, 999);
                    builder.set(key, new MeteringRectangle[]{meteringRectangle});
                    this.t.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
                    this.t.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
                    this.t.setTag("Focus");
                    this.u.capture(this.t.build(), this.A, this.g);
                }
            }
            this.t.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
            this.t.setTag("Regular");
            if (this.u != null) {
                this.u.setRepeatingRequest(this.t.build(), this.A, this.g);
            }
        } catch (CameraAccessException e2) {
            f.Log(6, "Camera2: CameraAccessException " + e2);
        }
    }

    private void k() {
        try {
            if (this.u != null) {
                this.u.stopRepeating();
                this.t.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
                this.t.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(0));
                this.t.setTag("Cancel focus");
                this.u.capture(this.t.build(), this.A, this.g);
            }
        } catch (CameraAccessException e2) {
            f.Log(6, "Camera2: CameraAccessException " + e2);
        }
    }

    public final Rect a() {
        return this.h;
    }

    public final boolean a(float f2, float f3) {
        if (this.k > 0) {
            if (!this.p) {
                this.l = f2;
                this.m = f3;
                synchronized (this.v) {
                    try {
                        if (!(this.u == null || this.z == C0065a.f3488b)) {
                            k();
                        }
                    }
                }
                return true;
            }
            f.Log(5, "Camera2: Setting manual focus point already started.");
        }
        return false;
    }

    public final boolean a(Context context, int i2, int i3, int i4, int i5, int i6) {
        try {
            CameraCharacteristics cameraCharacteristics = f3476b.getCameraCharacteristics(c(context)[i2]);
            if (((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                f.Log(5, "Camera2: only LEGACY hardware level is supported.");
                return false;
            }
            Size[] a2 = a(cameraCharacteristics);
            if (!(a2 == null || a2.length == 0)) {
                this.h = a(a2, (double) i3, (double) i4);
                Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                if (rangeArr == null || rangeArr.length == 0) {
                    f.Log(6, "Camera2: target FPS ranges are not avialable.");
                } else {
                    int a3 = a(rangeArr, i5);
                    this.q = new Range(Integer.valueOf(a3), Integer.valueOf(a3));
                    try {
                        if (!f3478e.tryAcquire(4, TimeUnit.SECONDS)) {
                            f.Log(5, "Camera2: Timeout waiting to lock camera for opening.");
                            return false;
                        }
                        try {
                            f3476b.openCamera(c(context)[i2], this.B, this.g);
                            try {
                                if (!f3478e.tryAcquire(4, TimeUnit.SECONDS)) {
                                    f.Log(5, "Camera2: Timeout waiting to open camera.");
                                    return false;
                                }
                                f3478e.release();
                                this.w = i6;
                                b(cameraCharacteristics);
                                return this.f3480d != null;
                            } catch (InterruptedException e2) {
                                f.Log(6, "Camera2: Interrupted while waiting to open camera " + e2);
                            }
                        } catch (CameraAccessException e3) {
                            f.Log(6, "Camera2: CameraAccessException " + e3);
                            f3478e.release();
                            return false;
                        }
                    } catch (InterruptedException e4) {
                        f.Log(6, "Camera2: Interrupted while trying to lock camera for opening " + e4);
                        return false;
                    }
                }
            }
            return false;
        } catch (CameraAccessException e5) {
            f.Log(6, "Camera2: CameraAccessException " + e5);
            return false;
        }
    }

    public final void b() {
        if (this.f3480d != null) {
            e();
            i();
            this.A = null;
            this.y = null;
            this.x = null;
            Image image = this.s;
            if (image != null) {
                image.close();
                this.s = null;
            }
            ImageReader imageReader = this.r;
            if (imageReader != null) {
                imageReader.close();
                this.r = null;
            }
        }
        h();
    }

    public final void c() {
        List list;
        if (this.r == null) {
            ImageReader newInstance = ImageReader.newInstance(this.h.width(), this.h.height(), 35, 2);
            this.r = newInstance;
            newInstance.setOnImageAvailableListener(this.C, this.g);
            this.s = null;
            if (this.w != 0) {
                SurfaceTexture surfaceTexture = new SurfaceTexture(this.w);
                this.x = surfaceTexture;
                surfaceTexture.setDefaultBufferSize(this.h.width(), this.h.height());
                this.x.setOnFrameAvailableListener(this.D, this.g);
                this.y = new Surface(this.x);
            }
        }
        try {
            if (this.u == null) {
                CameraDevice cameraDevice = this.f3480d;
                if (this.y != null) {
                    list = Arrays.asList(new Surface[]{this.y, this.r.getSurface()});
                } else {
                    list = Arrays.asList(new Surface[]{this.r.getSurface()});
                }
                cameraDevice.createCaptureSession(list, new CameraCaptureSession.StateCallback() {
                    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                        f.Log(6, "Camera2: CaptureSession configuration failed.");
                    }

                    public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
                        if (a.this.f3480d != null) {
                            synchronized (a.this.v) {
                                a.this.u = cameraCaptureSession;
                                try {
                                    a.this.t = a.this.f3480d.createCaptureRequest(1);
                                    if (a.this.y != null) {
                                        a.this.t.addTarget(a.this.y);
                                    }
                                    a.this.t.addTarget(a.this.r.getSurface());
                                    a.this.t.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, a.this.q);
                                    a.this.j();
                                } catch (CameraAccessException e2) {
                                    f.Log(6, "Camera2: CameraAccessException " + e2);
                                }
                            }
                        }
                    }
                }, this.g);
            } else if (this.z == C0065a.f3488b) {
                this.u.setRepeatingRequest(this.t.build(), this.A, this.g);
            }
            this.z = C0065a.f3487a;
        } catch (CameraAccessException e2) {
            f.Log(6, "Camera2: CameraAccessException " + e2);
        }
    }

    public final void d() {
        synchronized (this.v) {
            if (this.u != null) {
                try {
                    this.u.stopRepeating();
                    this.z = C0065a.f3488b;
                } catch (CameraAccessException e2) {
                    f.Log(6, "Camera2: CameraAccessException " + e2);
                }
            }
        }
    }

    public final void e() {
        synchronized (this.v) {
            if (this.u != null) {
                try {
                    this.u.abortCaptures();
                } catch (CameraAccessException e2) {
                    f.Log(6, "Camera2: CameraAccessException " + e2);
                }
                this.u.close();
                this.u = null;
                this.z = C0065a.f3489c;
            }
        }
    }
}

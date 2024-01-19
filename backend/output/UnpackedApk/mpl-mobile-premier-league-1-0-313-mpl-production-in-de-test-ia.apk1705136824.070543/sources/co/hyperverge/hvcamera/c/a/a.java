package co.hyperverge.hvcamera.c.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import co.hyperverge.hvcamera.HVCamHost;
import co.hyperverge.hvcamera.HVMagicView;
import co.hyperverge.hvcamera.magicfilter.camera.CameraEngine;
import co.hyperverge.hvcamera.magicfilter.utils.j;
import com.badlogic.gdx.graphics.GL20;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class a extends c {
    public static final String u = a.class.getCanonicalName();
    public final co.hyperverge.hvcamera.c.b.a.a m = new co.hyperverge.hvcamera.c.b.a.a();
    public SurfaceTexture n;
    public float[] o = new float[16];
    public boolean p;
    public final f q = new f(this);
    public OnFrameAvailableListener r = new b();
    public co.hyperverge.hvcamera.magicfilter.utils.g.a s = new d();
    public g t = new g(this);

    /* renamed from: co.hyperverge.hvcamera.c.a.a$a  reason: collision with other inner class name */
    public class C0045a implements Runnable {
        public void run() {
            HVCamHost hVCamHost = HVMagicView.f2835f;
            if (hVCamHost != null) {
                hVCamHost.onLayoutChange();
            }
        }
    }

    public class b implements OnFrameAvailableListener {
        public b() {
        }

        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            a.this.f2887b.requestRender();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0081 A[Catch:{ Exception -> 0x00cd }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                co.hyperverge.hvcamera.c.a.a r0 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                int r0 = r0.f2888c     // Catch:{ Exception -> 0x00cd }
                r1 = -1
                if (r0 != r1) goto L_0x0027
                co.hyperverge.hvcamera.c.a.a r0 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                int r1 = co.hyperverge.hvcamera.magicfilter.utils.e.a()     // Catch:{ Exception -> 0x00cd }
                r0.f2888c = r1     // Catch:{ Exception -> 0x00cd }
                co.hyperverge.hvcamera.c.a.a r0 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                android.graphics.SurfaceTexture r1 = new android.graphics.SurfaceTexture     // Catch:{ Exception -> 0x00cd }
                co.hyperverge.hvcamera.c.a.a r2 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                int r2 = r2.f2888c     // Catch:{ Exception -> 0x00cd }
                r1.<init>(r2)     // Catch:{ Exception -> 0x00cd }
                r0.n = r1     // Catch:{ Exception -> 0x00cd }
                co.hyperverge.hvcamera.c.a.a r0 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                android.graphics.SurfaceTexture r0 = r0.n     // Catch:{ Exception -> 0x00cd }
                co.hyperverge.hvcamera.c.a.a r1 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                android.graphics.SurfaceTexture$OnFrameAvailableListener r1 = r1.r     // Catch:{ Exception -> 0x00cd }
                r0.setOnFrameAvailableListener(r1)     // Catch:{ Exception -> 0x00cd }
            L_0x0027:
                android.hardware.Camera$Size r0 = co.hyperverge.hvcamera.magicfilter.camera.a.r()     // Catch:{ Exception -> 0x00cd }
                if (r0 != 0) goto L_0x002e
                return
            L_0x002e:
                int r1 = co.hyperverge.hvcamera.magicfilter.camera.a.p()     // Catch:{ Exception -> 0x00cd }
                r2 = 90
                if (r1 == r2) goto L_0x0048
                r2 = 270(0x10e, float:3.78E-43)
                if (r1 != r2) goto L_0x003b
                goto L_0x0048
            L_0x003b:
                co.hyperverge.hvcamera.c.a.a r1 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                int r2 = r0.width     // Catch:{ Exception -> 0x00cd }
                r1.i = r2     // Catch:{ Exception -> 0x00cd }
                co.hyperverge.hvcamera.c.a.a r1 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                int r0 = r0.height     // Catch:{ Exception -> 0x00cd }
                r1.j = r0     // Catch:{ Exception -> 0x00cd }
                goto L_0x0054
            L_0x0048:
                co.hyperverge.hvcamera.c.a.a r1 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                int r2 = r0.height     // Catch:{ Exception -> 0x00cd }
                r1.i = r2     // Catch:{ Exception -> 0x00cd }
                co.hyperverge.hvcamera.c.a.a r1 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                int r0 = r0.width     // Catch:{ Exception -> 0x00cd }
                r1.j = r0     // Catch:{ Exception -> 0x00cd }
            L_0x0054:
                co.hyperverge.hvcamera.c.a.a r0 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                co.hyperverge.hvcamera.c.b.a.a r0 = r0.m     // Catch:{ Exception -> 0x00cd }
                co.hyperverge.hvcamera.c.a.a r1 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                int r1 = r1.i     // Catch:{ Exception -> 0x00cd }
                co.hyperverge.hvcamera.c.a.a r2 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                int r2 = r2.j     // Catch:{ Exception -> 0x00cd }
                r0.h = r1     // Catch:{ Exception -> 0x00cd }
                r0.i = r2     // Catch:{ Exception -> 0x00cd }
                co.hyperverge.hvcamera.c.a.a r0 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                android.graphics.SurfaceTexture r0 = r0.n     // Catch:{ Exception -> 0x00cd }
                android.hardware.Camera r1 = co.hyperverge.hvcamera.magicfilter.camera.a.f2912b     // Catch:{ Exception -> 0x0077 }
                r1.setPreviewTexture(r0)     // Catch:{ Exception -> 0x0077 }
                android.hardware.Camera r0 = co.hyperverge.hvcamera.magicfilter.camera.a.f2912b     // Catch:{ Exception -> 0x0077 }
                r0.startPreview()     // Catch:{ Exception -> 0x0077 }
                r0 = 0
                co.hyperverge.hvcamera.magicfilter.camera.a.c(r0)     // Catch:{ Exception -> 0x0077 }
                goto L_0x007b
            L_0x0077:
                r0 = move-exception
                r0.getMessage()     // Catch:{ Exception -> 0x00cd }
            L_0x007b:
                boolean r0 = co.hyperverge.hvcamera.magicfilter.camera.CameraEngine.getCaptureMode()     // Catch:{ Exception -> 0x00cd }
                if (r0 == 0) goto L_0x00dd
                android.hardware.Camera r0 = co.hyperverge.hvcamera.magicfilter.camera.a.f2912b     // Catch:{ Exception -> 0x00cd }
                int r1 = co.hyperverge.hvcamera.HVMagicView.getmRatioWidth()     // Catch:{ Exception -> 0x00cd }
                int r2 = co.hyperverge.hvcamera.HVMagicView.getmRatioHeight()     // Catch:{ Exception -> 0x00cd }
                co.hyperverge.hvcamera.HVCamHost r3 = co.hyperverge.hvcamera.HVMagicView.f2835f     // Catch:{ Exception -> 0x00cd }
                float r3 = r3.getPictureMegapixels()     // Catch:{ Exception -> 0x00cd }
                co.hyperverge.hvcamera.HVCamHost r4 = co.hyperverge.hvcamera.HVMagicView.f2835f     // Catch:{ Exception -> 0x00cd }
                boolean r4 = r4.isShouldCaptureHighResolutionImage()     // Catch:{ Exception -> 0x00cd }
                android.hardware.Camera$Size r0 = co.hyperverge.hvcamera.a.a(r0, r1, r2, r3, r4)     // Catch:{ Exception -> 0x00cd }
                co.hyperverge.hvcamera.c.a.a r1 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                java.nio.IntBuffer r1 = r1.k     // Catch:{ Exception -> 0x00cd }
                if (r1 == 0) goto L_0x00a8
                co.hyperverge.hvcamera.c.a.a r1 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                java.nio.IntBuffer r1 = r1.k     // Catch:{ Exception -> 0x00cd }
                r1.clear()     // Catch:{ Exception -> 0x00cd }
            L_0x00a8:
                co.hyperverge.hvcamera.c.a.a r1 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                java.nio.IntBuffer r1 = r1.k     // Catch:{ Exception -> 0x00cd }
                if (r1 == 0) goto L_0x00be
                co.hyperverge.hvcamera.c.a.a r1 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                java.nio.IntBuffer r1 = r1.k     // Catch:{ Exception -> 0x00cd }
                int r1 = r1.capacity()     // Catch:{ Exception -> 0x00cd }
                int r2 = r0.height     // Catch:{ Exception -> 0x00cd }
                int r3 = r0.width     // Catch:{ Exception -> 0x00cd }
                int r2 = r2 * r3
                if (r1 >= r2) goto L_0x00dd
            L_0x00be:
                co.hyperverge.hvcamera.c.a.a r1 = co.hyperverge.hvcamera.c.a.a.this     // Catch:{ Exception -> 0x00cd }
                int r2 = r0.height     // Catch:{ Exception -> 0x00cd }
                int r0 = r0.width     // Catch:{ Exception -> 0x00cd }
                int r2 = r2 * r0
                java.nio.IntBuffer r0 = java.nio.IntBuffer.allocate(r2)     // Catch:{ Exception -> 0x00cd }
                r1.k = r0     // Catch:{ Exception -> 0x00cd }
                goto L_0x00dd
            L_0x00cd:
                r0 = move-exception
                java.lang.String r1 = r0.getMessage()
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x00dd
                java.lang.String r1 = co.hyperverge.hvcamera.c.a.a.u
                r0.getMessage()
            L_0x00dd:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hvcamera.c.a.a.c.run():void");
        }
    }

    public class d implements co.hyperverge.hvcamera.magicfilter.utils.g.a {
        public void a(String str) {
            HVCamHost hVCamHost = HVMagicView.f2835f;
            if (hVCamHost != null) {
                hVCamHost.onPictureSaved(new File(str));
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f2849a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f2850b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f2851c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f2852d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ File f2853e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f2854f;

        public e(Bitmap bitmap, boolean z, boolean z2, boolean z3, File file, int i) {
            this.f2849a = bitmap;
            this.f2850b = z;
            this.f2851c = z2;
            this.f2852d = z3;
            this.f2853e = file;
            this.f2854f = i;
        }

        public void run() {
            int i;
            int i2;
            int width = this.f2849a.getWidth();
            int height = this.f2849a.getHeight();
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            GLES20.glGenTextures(1, iArr2, 0);
            GLES20.glBindTexture(GL20.GL_TEXTURE_2D, iArr2[0]);
            GLES20.glTexImage2D(GL20.GL_TEXTURE_2D, 0, GL20.GL_RGBA, width, height, 0, GL20.GL_RGBA, GL20.GL_UNSIGNED_BYTE, null);
            GLES20.glTexParameterf(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MAG_FILTER, 9729.0f);
            GLES20.glTexParameterf(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MIN_FILTER, 9729.0f);
            GLES20.glTexParameterf(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_WRAP_S, 33071.0f);
            GLES20.glTexParameterf(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_WRAP_T, 33071.0f);
            GLES20.glBindFramebuffer(GL20.GL_FRAMEBUFFER, iArr[0]);
            GLES20.glFramebufferTexture2D(GL20.GL_FRAMEBUFFER, GL20.GL_COLOR_ATTACHMENT0, GL20.GL_TEXTURE_2D, iArr2[0], 0);
            GLES20.glViewport(0, 0, width, height);
            a aVar = a.this;
            co.hyperverge.hvcamera.c.b.a.b.a aVar2 = aVar.f2886a;
            aVar2.h = width;
            aVar2.i = height;
            int i3 = aVar.i;
            int i4 = aVar.j;
            aVar2.m = i3;
            aVar2.n = i4;
            if (this.f2850b) {
                i = co.hyperverge.hvcamera.magicfilter.utils.e.a(this.f2849a, -1, true);
            } else {
                i = aVar.f2888c;
            }
            int i5 = i;
            a.this.f2886a.a(i5, this.f2851c, this.f2852d);
            IntBuffer intBuffer = a.this.k;
            if (intBuffer != null) {
                intBuffer.clear();
            }
            IntBuffer intBuffer2 = a.this.k;
            if (intBuffer2 == null || intBuffer2.capacity() < height * width) {
                a.this.k = IntBuffer.allocate(height * width);
            }
            GLES20.glReadPixels(0, 0, width, height, GL20.GL_RGBA, GL20.GL_UNSIGNED_BYTE, a.this.k);
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(IntBuffer.wrap(a.this.k.array()));
            if (co.hyperverge.hvcamera.magicfilter.camera.a.f2912b != null) {
                i2 = 1;
                a.a(a.this, co.hyperverge.hvcamera.magicfilter.camera.a.p(), true, false);
            } else {
                i2 = 1;
            }
            if (this.f2850b) {
                int[] iArr3 = new int[i2];
                iArr3[0] = i5;
                GLES20.glDeleteTextures(i2, iArr3, 0);
            }
            GLES20.glDeleteFramebuffers(i2, iArr, 0);
            GLES20.glDeleteTextures(i2, iArr2, 0);
            a aVar3 = a.this;
            GLES20.glViewport(0, 0, aVar3.g, aVar3.h);
            a aVar4 = a.this;
            co.hyperverge.hvcamera.c.b.a.b.a aVar5 = aVar4.f2886a;
            int i6 = aVar4.i;
            int i7 = aVar4.j;
            aVar5.h = i6;
            aVar5.i = i7;
            File file = this.f2853e;
            int i8 = this.f2854f;
            if (aVar4 != null) {
                new co.hyperverge.hvcamera.magicfilter.utils.g(file, aVar4.s, i8).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[]{createBitmap});
                return;
            }
            throw null;
        }
    }

    public static class f extends HandlerThread {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f2855a;

        /* renamed from: b  reason: collision with root package name */
        public final Handler f2856b;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<a> f2857c;

        /* renamed from: d  reason: collision with root package name */
        public Runnable f2858d = new C0046a();

        /* renamed from: e  reason: collision with root package name */
        public Runnable f2859e = new b();

        /* renamed from: f  reason: collision with root package name */
        public Runnable f2860f = new c();
        public Runnable g = new e();

        /* renamed from: co.hyperverge.hvcamera.c.a.a$f$a  reason: collision with other inner class name */
        public class C0046a implements Runnable {
            public C0046a() {
            }

            public void run() {
                try {
                    f.this.f2856b.removeCallbacksAndMessages(null);
                    ((a) f.this.f2857c.get()).f2887b.removeCallbacks(null);
                    co.hyperverge.hvcamera.magicfilter.camera.a.w();
                } catch (Exception e2) {
                    String str = a.u;
                    e2.getMessage();
                }
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public void run() {
                a aVar = (a) f.this.f2857c.get();
                f.this.f2856b.removeCallbacksAndMessages(null);
                if (aVar != null) {
                    try {
                        co.hyperverge.hvcamera.magicfilter.camera.a.v();
                        if (co.hyperverge.hvcamera.magicfilter.camera.a.f2912b != null) {
                            boolean isFrontFacingCamera = CameraEngine.isFrontFacingCamera();
                            a.a(aVar, co.hyperverge.hvcamera.magicfilter.camera.a.p(), isFrontFacingCamera, !isFrontFacingCamera);
                            f.this.f2856b.post(f.this.g);
                        }
                    } catch (Exception e2) {
                        String str = a.u;
                        e2.getMessage();
                    }
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            public void run() {
                a aVar = (a) f.this.f2857c.get();
                f.this.f2856b.removeCallbacksAndMessages(null);
                if (aVar != null) {
                    try {
                        aVar.f2887b.removeCallbacks(null);
                        co.hyperverge.hvcamera.magicfilter.camera.a.w();
                        co.hyperverge.hvcamera.magicfilter.camera.a.w();
                        if (co.hyperverge.hvcamera.magicfilter.camera.a.f2913c == 0) {
                            co.hyperverge.hvcamera.magicfilter.camera.a.f2913c = 1;
                        } else {
                            co.hyperverge.hvcamera.magicfilter.camera.a.f2913c = 0;
                        }
                        co.hyperverge.hvcamera.magicfilter.camera.a.v();
                        co.hyperverge.hvcamera.magicfilter.camera.a.z();
                        f.this.f2856b.post(f.this.g);
                        HVMagicView.f2835f.onCameraFlipCallback();
                    } catch (Exception e2) {
                        String str = a.u;
                        e2.getMessage();
                    }
                }
            }
        }

        public class e implements Runnable {
            public e() {
            }

            public void run() {
                try {
                    a aVar = (a) f.this.f2857c.get();
                    a.d(aVar);
                    if (aVar.p) {
                        aVar.a(c.l);
                    }
                    aVar.f2887b.requestLayout();
                    HVMagicView hVMagicView = HVMagicView.g;
                    if (hVMagicView != null) {
                        hVMagicView.requestLayout();
                    }
                } catch (Exception e2) {
                    String str = a.u;
                    e2.getMessage();
                }
            }
        }

        public f(a aVar) {
            super("CameraHandler");
            this.f2857c = new WeakReference<>(aVar);
            start();
            this.f2855a = new Handler(getLooper());
            this.f2856b = new Handler(Looper.getMainLooper());
        }
    }

    public class g implements PictureCallback {
        public g(a aVar) {
        }

        public void onPictureTaken(byte[] bArr, Camera camera) {
            try {
                if (HVMagicView.f2835f != null) {
                    co.hyperverge.hvcamera.magicfilter.camera.a.z();
                    HVMagicView.f2835f.onReady();
                    HVMagicView.f2835f.onPictureReady(bArr);
                }
            } catch (Exception e2) {
                String str = a.u;
                e2.getMessage();
            }
        }
    }

    public a(GLSurfaceView gLSurfaceView) {
        super(gLSurfaceView);
        c.l = 0;
    }

    public static void d(a aVar) {
        aVar.f2887b.removeCallbacks(null);
        aVar.f2887b.queueEvent(new c());
    }

    public void a() {
        f fVar = this.q;
        fVar.f2855a.removeCallbacksAndMessages(null);
        fVar.f2855a.post(fVar.f2860f);
    }

    public void b() {
        Buffer buffer = this.k;
        if (buffer != null) {
            if (buffer.isDirect()) {
                try {
                    if (!buffer.getClass().getName().equals("java.nio.DirectByteBuffer")) {
                        Field declaredField = buffer.getClass().getDeclaredField("att");
                        declaredField.setAccessible(true);
                        buffer = (Buffer) declaredField.get(buffer);
                    }
                    Method method = buffer.getClass().getMethod("cleaner", new Class[0]);
                    method.setAccessible(true);
                    Object invoke = method.invoke(buffer, new Object[0]);
                    Method method2 = invoke.getClass().getMethod("clean", new Class[0]);
                    method2.setAccessible(true);
                    method2.invoke(invoke, new Object[0]);
                } catch (Exception e2) {
                    throw new RuntimeException("Could not destroy direct buffer " + buffer, e2);
                }
            }
            this.k = null;
        }
        super.b();
    }

    public void c() {
        super.c();
        co.hyperverge.hvcamera.c.b.a.a aVar = this.m;
        int i = this.g;
        int i2 = this.h;
        aVar.m = i;
        aVar.n = i2;
        if (this.f2886a != null) {
            aVar.c(this.i, this.j);
        } else {
            aVar.j();
        }
    }

    public void e() {
        f fVar = this.q;
        fVar.f2855a.removeCallbacksAndMessages(null);
        fVar.f2855a.post(fVar.f2859e);
    }

    public void onDrawFrame(GL10 gl10) {
        if (this.n != null && co.hyperverge.hvcamera.magicfilter.camera.a.f2912b != null) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            try {
                this.n.updateTexImage();
            } catch (Exception e2) {
                e2.getMessage();
            }
            this.n.getTransformMatrix(this.o);
            co.hyperverge.hvcamera.c.b.a.a aVar = this.m;
            aVar.o = this.o;
            int i = this.f2888c;
            if (this.f2886a == null) {
                aVar.a(i, this.f2889d, this.f2890e);
                return;
            }
            this.f2886a.a(aVar.a(i), this.f2889d, this.f2890e);
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
        this.g = i;
        this.h = i2;
        c();
        new Handler(Looper.getMainLooper()).post(new C0045a());
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glDisable(GL20.GL_DITHER);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glEnable(GL20.GL_CULL_FACE);
        GLES20.glEnable(GL20.GL_DEPTH_TEST);
        this.m.b();
        a(c.l);
        this.p = true;
    }

    public void d() {
        f fVar = this.q;
        fVar.f2855a.removeCallbacksAndMessages(null);
        fVar.f2855a.post(fVar.f2858d);
    }

    public void a(Bitmap bitmap, File file, boolean z, boolean z2, int i) {
        if (this.f2886a == null || c.l == 0) {
            new co.hyperverge.hvcamera.magicfilter.utils.g(file, this.s, i).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[]{bitmap});
            return;
        }
        GLSurfaceView gLSurfaceView = this.f2887b;
        e eVar = new e(bitmap, true, z, z2, file, i);
        gLSurfaceView.queueEvent(eVar);
    }

    public void a(File file, co.hyperverge.hvcamera.magicfilter.utils.g.a aVar, ShutterCallback shutterCallback) {
        g gVar = this.t;
        if (gVar == null) {
            throw null;
        } else if (gVar != null) {
            co.hyperverge.hvcamera.magicfilter.camera.a.a(shutterCallback, gVar);
        } else {
            throw null;
        }
    }

    public static void a(a aVar, int i, boolean z, boolean z2) {
        if (aVar != null) {
            float[] a2 = j.a(co.hyperverge.hvcamera.magicfilter.utils.f.a(i), z, z2);
            aVar.f2890e.clear();
            aVar.f2890e.put(a2).position(0);
            return;
        }
        throw null;
    }

    public void a(float f2, float f3, AutoFocusCallback autoFocusCallback) {
        if (co.hyperverge.hvcamera.magicfilter.camera.a.f2912b != null) {
            if (co.hyperverge.hvcamera.magicfilter.camera.a.s()) {
                f2 = 1.0f - f2;
            }
            int i = ((int) ((f2 - 0.5f) * 2000.0f)) - 100;
            int i2 = i + 200;
            int i3 = ((int) ((f3 - 0.5f) * 2000.0f)) - 100;
            int i4 = i3 + 200;
            int b2 = co.hyperverge.hvcamera.magicfilter.camera.a.b(i);
            int b3 = co.hyperverge.hvcamera.magicfilter.camera.a.b(i2);
            int b4 = co.hyperverge.hvcamera.magicfilter.camera.a.b(i3);
            int b5 = co.hyperverge.hvcamera.magicfilter.camera.a.b(i4);
            co.hyperverge.hvcamera.magicfilter.camera.a.B.reset();
            co.hyperverge.hvcamera.magicfilter.camera.a.B.postRotate(90.0f);
            Matrix matrix = co.hyperverge.hvcamera.magicfilter.camera.a.B;
            matrix.invert(matrix);
            RectF rectF = new RectF((float) b2, (float) b4, (float) b3, (float) b5);
            co.hyperverge.hvcamera.magicfilter.camera.a.B.mapRect(rectF);
            Rect rect = new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
            Parameters parameters = null;
            try {
                co.hyperverge.hvcamera.magicfilter.camera.a.f2912b.cancelAutoFocus();
                parameters = co.hyperverge.hvcamera.magicfilter.camera.a.f2912b.getParameters();
            } catch (Exception e2) {
                e2.getMessage();
            }
            if (parameters != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Area(rect, 1000));
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new Area(rect, 400));
                if (parameters.getMaxNumFocusAreas() > 0) {
                    parameters.setFocusMode("auto");
                    parameters.setFocusAreas(arrayList);
                }
                if (parameters.getMaxNumMeteringAreas() > 0) {
                    parameters.setMeteringAreas(arrayList2);
                }
                try {
                    co.hyperverge.hvcamera.magicfilter.camera.a.f2912b.setParameters(parameters);
                    co.hyperverge.hvcamera.magicfilter.camera.a.f2912b.autoFocus(autoFocusCallback);
                } catch (Exception e3) {
                    e3.getMessage();
                }
            }
        }
    }
}

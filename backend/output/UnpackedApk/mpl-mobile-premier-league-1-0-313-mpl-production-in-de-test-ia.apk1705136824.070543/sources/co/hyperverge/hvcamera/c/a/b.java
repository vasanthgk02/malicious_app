package co.hyperverge.hvcamera.c.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import co.hyperverge.hvcamera.HVCamHost;
import co.hyperverge.hvcamera.HVMagicView;
import co.hyperverge.hvcamera.magicfilter.camera.CameraEngine;
import co.hyperverge.hvcamera.magicfilter.camera.b.i;
import co.hyperverge.hvcamera.magicfilter.utils.j;
import com.badlogic.gdx.graphics.GL20;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.concurrent.Executor;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class b extends c {
    public static final String u = b.class.getCanonicalName();
    public final co.hyperverge.hvcamera.c.b.a.a m = new co.hyperverge.hvcamera.c.b.a.a();
    public SurfaceTexture n;
    public float[] o = new float[16];
    public final g p = new g(this);
    public OnFrameAvailableListener q = new C0047b();
    public co.hyperverge.hvcamera.magicfilter.utils.g.a r = new d();
    public h s = new h(null);
    public i t = new e();

    public class a implements Runnable {
        public void run() {
            HVCamHost hVCamHost = HVMagicView.f2835f;
            if (hVCamHost != null) {
                hVCamHost.onLayoutChange();
            }
        }
    }

    /* renamed from: co.hyperverge.hvcamera.c.a.b$b  reason: collision with other inner class name */
    public class C0047b implements OnFrameAvailableListener {
        public C0047b() {
        }

        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            b.this.f2887b.requestRender();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x007e A[Catch:{ Exception -> 0x00ba }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                co.hyperverge.hvcamera.c.a.b r0 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                int r0 = r0.f2888c     // Catch:{ Exception -> 0x00ba }
                r1 = -1
                if (r0 != r1) goto L_0x0027
                co.hyperverge.hvcamera.c.a.b r0 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                int r1 = co.hyperverge.hvcamera.magicfilter.utils.e.a()     // Catch:{ Exception -> 0x00ba }
                r0.f2888c = r1     // Catch:{ Exception -> 0x00ba }
                co.hyperverge.hvcamera.c.a.b r0 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                android.graphics.SurfaceTexture r1 = new android.graphics.SurfaceTexture     // Catch:{ Exception -> 0x00ba }
                co.hyperverge.hvcamera.c.a.b r2 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                int r2 = r2.f2888c     // Catch:{ Exception -> 0x00ba }
                r1.<init>(r2)     // Catch:{ Exception -> 0x00ba }
                r0.n = r1     // Catch:{ Exception -> 0x00ba }
                co.hyperverge.hvcamera.c.a.b r0 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                android.graphics.SurfaceTexture r0 = r0.n     // Catch:{ Exception -> 0x00ba }
                co.hyperverge.hvcamera.c.a.b r1 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                android.graphics.SurfaceTexture$OnFrameAvailableListener r1 = r1.q     // Catch:{ Exception -> 0x00ba }
                r0.setOnFrameAvailableListener(r1)     // Catch:{ Exception -> 0x00ba }
            L_0x0027:
                android.util.Size r0 = co.hyperverge.hvcamera.magicfilter.camera.b.s     // Catch:{ Exception -> 0x00ba }
                if (r0 != 0) goto L_0x002c
                return
            L_0x002c:
                int r1 = co.hyperverge.hvcamera.magicfilter.camera.b.H()     // Catch:{ Exception -> 0x00ba }
                r2 = 90
                if (r1 == r2) goto L_0x004a
                r2 = 270(0x10e, float:3.78E-43)
                if (r1 != r2) goto L_0x0039
                goto L_0x004a
            L_0x0039:
                co.hyperverge.hvcamera.c.a.b r1 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                int r2 = r0.getWidth()     // Catch:{ Exception -> 0x00ba }
                r1.i = r2     // Catch:{ Exception -> 0x00ba }
                co.hyperverge.hvcamera.c.a.b r1 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                int r0 = r0.getHeight()     // Catch:{ Exception -> 0x00ba }
                r1.j = r0     // Catch:{ Exception -> 0x00ba }
                goto L_0x005a
            L_0x004a:
                co.hyperverge.hvcamera.c.a.b r1 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                int r2 = r0.getHeight()     // Catch:{ Exception -> 0x00ba }
                r1.i = r2     // Catch:{ Exception -> 0x00ba }
                co.hyperverge.hvcamera.c.a.b r1 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                int r0 = r0.getWidth()     // Catch:{ Exception -> 0x00ba }
                r1.j = r0     // Catch:{ Exception -> 0x00ba }
            L_0x005a:
                co.hyperverge.hvcamera.c.a.b r0 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                co.hyperverge.hvcamera.c.b.a.a r0 = r0.m     // Catch:{ Exception -> 0x00ba }
                co.hyperverge.hvcamera.c.a.b r1 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                int r1 = r1.i     // Catch:{ Exception -> 0x00ba }
                co.hyperverge.hvcamera.c.a.b r2 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                int r2 = r2.j     // Catch:{ Exception -> 0x00ba }
                r0.h = r1     // Catch:{ Exception -> 0x00ba }
                r0.i = r2     // Catch:{ Exception -> 0x00ba }
                co.hyperverge.hvcamera.c.a.b r0 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                android.graphics.SurfaceTexture r0 = r0.n     // Catch:{ Exception -> 0x00ba }
                android.os.Handler r1 = co.hyperverge.hvcamera.magicfilter.camera.b.x     // Catch:{ Exception -> 0x00ba }
                co.hyperverge.hvcamera.magicfilter.camera.b$f r2 = new co.hyperverge.hvcamera.magicfilter.camera.b$f     // Catch:{ Exception -> 0x00ba }
                r2.<init>(r0)     // Catch:{ Exception -> 0x00ba }
                r1.post(r2)     // Catch:{ Exception -> 0x00ba }
                boolean r0 = co.hyperverge.hvcamera.magicfilter.camera.CameraEngine.getCaptureMode()     // Catch:{ Exception -> 0x00ba }
                if (r0 == 0) goto L_0x00ca
                android.util.Size r0 = co.hyperverge.hvcamera.magicfilter.camera.b.t     // Catch:{ Exception -> 0x00ba }
                co.hyperverge.hvcamera.c.a.b r1 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                java.nio.IntBuffer r1 = r1.k     // Catch:{ Exception -> 0x00ba }
                if (r1 == 0) goto L_0x008d
                co.hyperverge.hvcamera.c.a.b r1 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                java.nio.IntBuffer r1 = r1.k     // Catch:{ Exception -> 0x00ba }
                r1.clear()     // Catch:{ Exception -> 0x00ba }
            L_0x008d:
                co.hyperverge.hvcamera.c.a.b r1 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                java.nio.IntBuffer r1 = r1.k     // Catch:{ Exception -> 0x00ba }
                if (r1 == 0) goto L_0x00a7
                co.hyperverge.hvcamera.c.a.b r1 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                java.nio.IntBuffer r1 = r1.k     // Catch:{ Exception -> 0x00ba }
                int r1 = r1.capacity()     // Catch:{ Exception -> 0x00ba }
                int r2 = r0.getHeight()     // Catch:{ Exception -> 0x00ba }
                int r3 = r0.getWidth()     // Catch:{ Exception -> 0x00ba }
                int r2 = r2 * r3
                if (r1 >= r2) goto L_0x00ca
            L_0x00a7:
                co.hyperverge.hvcamera.c.a.b r1 = co.hyperverge.hvcamera.c.a.b.this     // Catch:{ Exception -> 0x00ba }
                int r2 = r0.getHeight()     // Catch:{ Exception -> 0x00ba }
                int r0 = r0.getWidth()     // Catch:{ Exception -> 0x00ba }
                int r2 = r2 * r0
                java.nio.IntBuffer r0 = java.nio.IntBuffer.allocate(r2)     // Catch:{ Exception -> 0x00ba }
                r1.k = r0     // Catch:{ Exception -> 0x00ba }
                goto L_0x00ca
            L_0x00ba:
                r0 = move-exception
                java.lang.String r1 = r0.getMessage()
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x00ca
                java.lang.String r1 = co.hyperverge.hvcamera.c.a.b.u
                r0.getMessage()
            L_0x00ca:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hvcamera.c.a.b.c.run():void");
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

    public class e implements i {
    }

    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f2867a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f2868b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f2869c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f2870d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ File f2871e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f2872f;

        public f(Bitmap bitmap, boolean z, boolean z2, boolean z3, File file, int i) {
            this.f2867a = bitmap;
            this.f2868b = z;
            this.f2869c = z2;
            this.f2870d = z3;
            this.f2871e = file;
            this.f2872f = i;
        }

        public void run() {
            int i;
            int i2;
            int width = this.f2867a.getWidth();
            int height = this.f2867a.getHeight();
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
            b bVar = b.this;
            co.hyperverge.hvcamera.c.b.a.b.a aVar = bVar.f2886a;
            aVar.h = width;
            aVar.i = height;
            int i3 = bVar.i;
            int i4 = bVar.j;
            aVar.m = i3;
            aVar.n = i4;
            if (this.f2868b) {
                i = co.hyperverge.hvcamera.magicfilter.utils.e.a(this.f2867a, -1, true);
            } else {
                i = bVar.f2888c;
            }
            int i5 = i;
            b.this.f2886a.a(i5, this.f2869c, this.f2870d);
            IntBuffer intBuffer = b.this.k;
            if (intBuffer != null) {
                intBuffer.clear();
            }
            IntBuffer intBuffer2 = b.this.k;
            if (intBuffer2 == null || intBuffer2.capacity() < height * width) {
                b.this.k = IntBuffer.allocate(height * width);
            }
            GLES20.glReadPixels(0, 0, width, height, GL20.GL_RGBA, GL20.GL_UNSIGNED_BYTE, b.this.k);
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(IntBuffer.wrap(b.this.k.array()));
            if (this.f2868b) {
                i2 = 1;
                GLES20.glDeleteTextures(1, new int[]{i5}, 0);
            } else {
                i2 = 1;
            }
            GLES20.glDeleteFramebuffers(i2, iArr, 0);
            GLES20.glDeleteTextures(i2, iArr2, 0);
            b bVar2 = b.this;
            GLES20.glViewport(0, 0, bVar2.g, bVar2.h);
            b bVar3 = b.this;
            co.hyperverge.hvcamera.c.b.a.b.a aVar2 = bVar3.f2886a;
            int i6 = bVar3.i;
            int i7 = bVar3.j;
            aVar2.h = i6;
            aVar2.i = i7;
            File file = this.f2871e;
            int i8 = this.f2872f;
            if (bVar3 != null) {
                new co.hyperverge.hvcamera.magicfilter.utils.g(file, bVar3.r, i8).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[]{createBitmap});
                return;
            }
            throw null;
        }
    }

    public static class g extends HandlerThread {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f2873a;

        /* renamed from: b  reason: collision with root package name */
        public final Handler f2874b;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<b> f2875c;

        /* renamed from: d  reason: collision with root package name */
        public Runnable f2876d = new a();

        /* renamed from: e  reason: collision with root package name */
        public Runnable f2877e = new C0048b();

        /* renamed from: f  reason: collision with root package name */
        public Runnable f2878f = new c();
        public Runnable g = new e();

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                g.this.f2874b.removeCallbacksAndMessages(null);
                ((b) g.this.f2875c.get()).f2887b.removeCallbacks(null);
                co.hyperverge.hvcamera.magicfilter.camera.b.E();
            }
        }

        /* renamed from: co.hyperverge.hvcamera.c.a.b$g$b  reason: collision with other inner class name */
        public class C0048b implements Runnable {
            public C0048b() {
            }

            public void run() {
                b bVar = (b) g.this.f2875c.get();
                g.this.f2874b.removeCallbacksAndMessages(null);
                if (bVar != null) {
                    co.hyperverge.hvcamera.magicfilter.camera.b.N();
                    b.a(bVar, co.hyperverge.hvcamera.magicfilter.camera.b.H(), true, false);
                    g gVar = g.this;
                    gVar.f2874b.post(gVar.g);
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            public void run() {
                b bVar = (b) g.this.f2875c.get();
                g.this.f2874b.removeCallbacksAndMessages(null);
                if (bVar != null) {
                    try {
                        bVar.f2887b.removeCallbacks(null);
                        co.hyperverge.hvcamera.magicfilter.camera.b.E();
                        co.hyperverge.hvcamera.magicfilter.camera.b.f2921e = !co.hyperverge.hvcamera.magicfilter.camera.b.f2921e;
                        co.hyperverge.hvcamera.magicfilter.camera.b.N();
                        b.a(bVar, co.hyperverge.hvcamera.magicfilter.camera.b.H(), true, false);
                        g.this.f2874b.post(g.this.g);
                        HVMagicView.f2835f.onCameraFlipCallback();
                    } catch (Exception e2) {
                        String str = b.u;
                        e2.getMessage();
                    }
                }
            }
        }

        public class e implements Runnable {
            public e() {
            }

            public void run() {
                b bVar = (b) g.this.f2875c.get();
                b.d(bVar);
                bVar.a(c.l);
                bVar.f2887b.requestLayout();
                HVMagicView hVMagicView = HVMagicView.g;
                if (hVMagicView != null) {
                    hVMagicView.requestLayout();
                }
            }
        }

        public g(b bVar) {
            super("CameraHandler");
            this.f2875c = new WeakReference<>(bVar);
            start();
            this.f2873a = new Handler(getLooper());
            this.f2874b = new Handler(Looper.getMainLooper());
        }
    }

    public class h implements PictureCallback {

        /* renamed from: a  reason: collision with root package name */
        public File f2883a;

        /* renamed from: b  reason: collision with root package name */
        public b f2884b;

        public h(a aVar) {
        }

        public void onPictureTaken(byte[] bArr, Camera camera) {
            if (this.f2883a == null) {
                String str = b.u;
                return;
            }
            HVMagicView.f2835f.onReady();
            co.hyperverge.hvcamera.magicfilter.utils.h hVar = new co.hyperverge.hvcamera.magicfilter.utils.h(this.f2883a, bArr, this.f2884b);
            Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
            Boolean[] boolArr = new Boolean[2];
            boolArr[0] = Boolean.valueOf(b.this.f2886a != null);
            boolArr[1] = Boolean.valueOf(CameraEngine.isFrontFacingCamera());
            hVar.executeOnExecutor(executor, boolArr);
        }
    }

    public b(GLSurfaceView gLSurfaceView) {
        super(gLSurfaceView);
        c.l = 0;
    }

    public static void d(b bVar) {
        bVar.f2887b.removeCallbacks(null);
        bVar.f2887b.queueEvent(new c());
        co.hyperverge.hvcamera.magicfilter.camera.b.j = bVar.t;
    }

    public void a(int i) {
        this.f2887b.queueEvent(new co.hyperverge.hvcamera.c.a.c.a(i));
        this.f2887b.requestRender();
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
        g gVar = this.p;
        gVar.f2873a.removeCallbacksAndMessages(null);
        gVar.f2873a.post(gVar.f2877e);
    }

    public void onDrawFrame(GL10 gl10) {
        if (this.n != null) {
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
        new Handler(Looper.getMainLooper()).post(new a());
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glDisable(GL20.GL_DITHER);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glEnable(GL20.GL_CULL_FACE);
        GLES20.glEnable(GL20.GL_DEPTH_TEST);
        this.m.b();
        a(c.l);
    }

    public void a() {
        g gVar = this.p;
        gVar.f2873a.removeCallbacksAndMessages(null);
        gVar.f2873a.post(gVar.f2878f);
    }

    public void d() {
        g gVar = this.p;
        gVar.f2873a.removeCallbacksAndMessages(null);
        gVar.f2873a.post(gVar.f2876d);
    }

    public void a(Bitmap bitmap, File file, boolean z, boolean z2, int i) {
        if (this.f2886a == null || c.l == 0) {
            new co.hyperverge.hvcamera.magicfilter.utils.g(file, this.r, i).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[]{bitmap});
            return;
        }
        GLSurfaceView gLSurfaceView = this.f2887b;
        f fVar = new f(bitmap, true, z, z2, file, i);
        gLSurfaceView.queueEvent(fVar);
    }

    public void a(File file, co.hyperverge.hvcamera.magicfilter.utils.g.a aVar, ShutterCallback shutterCallback) {
        co.hyperverge.hvcamera.magicfilter.camera.b.j = this.t;
        h hVar = this.s;
        hVar.f2883a = file;
        hVar.f2884b = this;
        try {
            co.hyperverge.hvcamera.magicfilter.camera.b.y.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
            co.hyperverge.hvcamera.magicfilter.camera.b.r = 1;
            co.hyperverge.hvcamera.magicfilter.camera.b.B.capture(co.hyperverge.hvcamera.magicfilter.camera.b.y.build(), co.hyperverge.hvcamera.magicfilter.camera.b.O, co.hyperverge.hvcamera.magicfilter.camera.b.x);
            HVMagicView.f2835f.showCrossHair(co.hyperverge.hvcamera.magicfilter.camera.b.q[0], co.hyperverge.hvcamera.magicfilter.camera.b.q[1], false);
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public static void a(b bVar, int i, boolean z, boolean z2) {
        float[] a2 = j.a(co.hyperverge.hvcamera.magicfilter.utils.f.a(i), z, z2);
        bVar.f2890e.clear();
        bVar.f2890e.put(a2).position(0);
    }

    public void a(float f2, float f3, AutoFocusCallback autoFocusCallback) {
        if (co.hyperverge.hvcamera.magicfilter.camera.b.f2919c != null) {
            float[] fArr = co.hyperverge.hvcamera.magicfilter.camera.b.q;
            fArr[0] = f2;
            fArr[1] = f3;
            if (co.hyperverge.hvcamera.magicfilter.camera.b.f2921e) {
                f2 = 1.0f - f2;
            }
            MeteringRectangle[] a2 = co.hyperverge.hvcamera.magicfilter.utils.a.a(f2, f3, 0.2f, co.hyperverge.hvcamera.magicfilter.camera.b.i, co.hyperverge.hvcamera.magicfilter.camera.b.E);
            MeteringRectangle[] a3 = co.hyperverge.hvcamera.magicfilter.utils.a.a(f2, f3, 0.3f, co.hyperverge.hvcamera.magicfilter.camera.b.i, co.hyperverge.hvcamera.magicfilter.camera.b.E);
            try {
                CameraCharacteristics cameraCharacteristics = co.hyperverge.hvcamera.magicfilter.camera.b.k.getCameraCharacteristics(co.hyperverge.hvcamera.magicfilter.camera.b.f2919c);
                if (((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0) {
                    co.hyperverge.hvcamera.magicfilter.camera.b.y.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
                    co.hyperverge.hvcamera.magicfilter.camera.b.y.set(CaptureRequest.CONTROL_AF_REGIONS, a2);
                }
                if (((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE)).intValue() > 0) {
                    co.hyperverge.hvcamera.magicfilter.camera.b.y.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
                    co.hyperverge.hvcamera.magicfilter.camera.b.y.set(CaptureRequest.CONTROL_AE_REGIONS, a3);
                }
                co.hyperverge.hvcamera.magicfilter.camera.b.y.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
                if (VERSION.SDK_INT >= 23) {
                    co.hyperverge.hvcamera.magicfilter.camera.b.y.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(2));
                }
                co.hyperverge.hvcamera.magicfilter.camera.b.B.capture(co.hyperverge.hvcamera.magicfilter.camera.b.y.build(), co.hyperverge.hvcamera.magicfilter.camera.b.N, co.hyperverge.hvcamera.magicfilter.camera.b.x);
                co.hyperverge.hvcamera.magicfilter.camera.b.y.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
                co.hyperverge.hvcamera.magicfilter.camera.b.y.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
                co.hyperverge.hvcamera.magicfilter.camera.b.B.capture(co.hyperverge.hvcamera.magicfilter.camera.b.y.build(), co.hyperverge.hvcamera.magicfilter.camera.b.N, co.hyperverge.hvcamera.magicfilter.camera.b.x);
                co.hyperverge.hvcamera.magicfilter.camera.b.y.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(0));
                co.hyperverge.hvcamera.magicfilter.camera.b.y.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
                co.hyperverge.hvcamera.magicfilter.camera.b.B.setRepeatingRequest(co.hyperverge.hvcamera.magicfilter.camera.b.y.build(), co.hyperverge.hvcamera.magicfilter.camera.b.N, co.hyperverge.hvcamera.magicfilter.camera.b.x);
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
    }
}

package com.unity3d.player;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import io.antmedia.android.broadcaster.LiveVideoBroadcaster;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class UnityPlayer extends FrameLayout implements e {
    public static Activity currentActivity;

    /* renamed from: a  reason: collision with root package name */
    public e f3399a = new e(this, 0);

    /* renamed from: b  reason: collision with root package name */
    public j f3400b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f3401c = -1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3402d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3403e = true;

    /* renamed from: f  reason: collision with root package name */
    public m f3404f = new m();
    public final ConcurrentLinkedQueue g = new ConcurrentLinkedQueue();
    public BroadcastReceiver h = null;
    public boolean i = false;
    public c j = new c(this, 0);
    public TelephonyManager k;
    public ClipboardManager l;
    public k m;
    public GoogleARCoreApi n = null;
    public a o = new a();
    public Camera2Wrapper p = null;
    public HFPStatus q = null;
    public Uri r = null;
    public NetworkConnectivity s = null;
    public Context t;
    public SurfaceView u;
    public boolean v;
    public boolean w = true;
    public p x;

    public class a implements SensorEventListener {
        public a() {
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
        }
    }

    public enum b {
        ;

        /* access modifiers changed from: public */
        static {
            f3460d = new int[]{1, 2, 3};
        }
    }

    public class c extends PhoneStateListener {
        public c() {
        }

        public /* synthetic */ c(UnityPlayer unityPlayer, byte b2) {
            this();
        }

        public final void onCallStateChanged(int i, String str) {
            UnityPlayer unityPlayer = UnityPlayer.this;
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            unityPlayer.nativeMuteMasterAudio(z);
        }
    }

    public enum d {
        PAUSE,
        RESUME,
        QUIT,
        SURFACE_LOST,
        SURFACE_ACQUIRED,
        FOCUS_LOST,
        FOCUS_GAINED,
        NEXT_FRAME,
        URL_ACTIVATED
    }

    public class e extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public Handler f3468a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3469b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3470c;

        /* renamed from: d  reason: collision with root package name */
        public int f3471d;

        /* renamed from: e  reason: collision with root package name */
        public int f3472e;

        /* renamed from: f  reason: collision with root package name */
        public int f3473f;

        public e() {
            this.f3469b = false;
            this.f3470c = false;
            this.f3471d = b.f3458b;
            this.f3472e = 0;
            this.f3473f = 5;
        }

        public /* synthetic */ e(UnityPlayer unityPlayer, byte b2) {
            this();
        }

        private void a(d dVar) {
            Handler handler = this.f3468a;
            if (handler != null) {
                Message.obtain(handler, 2269, dVar).sendToTarget();
            }
        }

        public final void a() {
            a(d.QUIT);
        }

        public final void a(Runnable runnable) {
            if (this.f3468a != null) {
                a(d.PAUSE);
                Message.obtain(this.f3468a, runnable).sendToTarget();
            }
        }

        public final void b() {
            a(d.RESUME);
        }

        public final void b(Runnable runnable) {
            if (this.f3468a != null) {
                a(d.SURFACE_LOST);
                Message.obtain(this.f3468a, runnable).sendToTarget();
            }
        }

        public final void c() {
            a(d.FOCUS_GAINED);
        }

        public final void c(Runnable runnable) {
            Handler handler = this.f3468a;
            if (handler != null) {
                Message.obtain(handler, runnable).sendToTarget();
                a(d.SURFACE_ACQUIRED);
            }
        }

        public final void d() {
            a(d.FOCUS_LOST);
        }

        public final void d(Runnable runnable) {
            Handler handler = this.f3468a;
            if (handler != null) {
                Message.obtain(handler, runnable).sendToTarget();
            }
        }

        public final void e() {
            a(d.URL_ACTIVATED);
        }

        public final void run() {
            setName("UnityMain");
            Looper.prepare();
            this.f3468a = new Handler(new Callback() {
                private void a() {
                    e eVar = e.this;
                    if (eVar.f3471d == b.f3459c && eVar.f3470c) {
                        UnityPlayer.this.nativeFocusChanged(true);
                        e.this.f3471d = b.f3457a;
                    }
                }

                public final boolean handleMessage(Message message) {
                    if (message.what != 2269) {
                        return false;
                    }
                    d dVar = (d) message.obj;
                    if (dVar == d.NEXT_FRAME) {
                        e eVar = e.this;
                        eVar.f3472e--;
                        UnityPlayer.this.executeGLThreadJobs();
                        e eVar2 = e.this;
                        if (!eVar2.f3469b || !eVar2.f3470c) {
                            return true;
                        }
                        int i = eVar2.f3473f;
                        if (i >= 0) {
                            if (i == 0 && UnityPlayer.this.k()) {
                                UnityPlayer.this.a();
                            }
                            e.this.f3473f--;
                        }
                        if (!UnityPlayer.this.isFinishing() && !UnityPlayer.this.nativeRender()) {
                            UnityPlayer.this.e();
                        }
                    } else if (dVar == d.QUIT) {
                        Looper.myLooper().quit();
                    } else if (dVar == d.RESUME) {
                        e.this.f3469b = true;
                    } else if (dVar == d.PAUSE) {
                        e.this.f3469b = false;
                    } else if (dVar == d.SURFACE_LOST) {
                        e.this.f3470c = false;
                    } else {
                        if (dVar == d.SURFACE_ACQUIRED) {
                            e.this.f3470c = true;
                        } else if (dVar == d.FOCUS_LOST) {
                            e eVar3 = e.this;
                            if (eVar3.f3471d == b.f3457a) {
                                UnityPlayer.this.nativeFocusChanged(false);
                            }
                            e.this.f3471d = b.f3458b;
                        } else if (dVar == d.FOCUS_GAINED) {
                            e.this.f3471d = b.f3459c;
                        } else if (dVar == d.URL_ACTIVATED) {
                            UnityPlayer unityPlayer = UnityPlayer.this;
                            unityPlayer.nativeSetLaunchURL(unityPlayer.getLaunchURL());
                        }
                        a();
                    }
                    e eVar4 = e.this;
                    if (eVar4.f3469b && eVar4.f3472e <= 0) {
                        Message.obtain(eVar4.f3468a, 2269, d.NEXT_FRAME).sendToTarget();
                        e.this.f3472e++;
                    }
                    return true;
                }
            });
            Looper.loop();
        }
    }

    public abstract class f implements Runnable {
        public f() {
        }

        public /* synthetic */ f(UnityPlayer unityPlayer, byte b2) {
            this();
        }

        public abstract void a();

        public final void run() {
            if (!UnityPlayer.this.isFinishing()) {
                a();
            }
        }
    }

    static {
        new l().a();
        try {
            System.loadLibrary("main");
        } catch (UnsatisfiedLinkError e2) {
            f.Log(6, "Failed to load 'libmain.so', the application will terminate.");
            throw e2;
        }
    }

    public UnityPlayer(Context context) {
        super(context);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            currentActivity = activity;
            this.f3401c = activity.getRequestedOrientation();
            this.r = currentActivity.getIntent().getData();
        }
        a(currentActivity);
        this.t = context;
        if (currentActivity != null && k()) {
            k kVar = new k(this.t, com.unity3d.player.k.a.a()[getSplashMode()]);
            this.m = kVar;
            addView(kVar);
        }
        a(this.t.getApplicationInfo());
        if (!m.c()) {
            AlertDialog create = new Builder(this.t).setTitle("Failure to initialize!").setPositiveButton(LiveVideoBroadcaster.OK, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    UnityPlayer.this.e();
                }
            }).setMessage("Your hardware does not support this application, sorry!").create();
            create.setCancelable(false);
            create.show();
            return;
        }
        initJni(context);
        this.f3404f.c(true);
        SurfaceView c2 = c();
        this.u = c2;
        c2.setContentDescription(a(context));
        addView(this.u);
        bringChildToFront(this.m);
        this.v = false;
        m();
        this.k = (TelephonyManager) this.t.getSystemService("phone");
        this.l = (ClipboardManager) this.t.getSystemService("clipboard");
        this.p = new Camera2Wrapper(this.t);
        this.q = new HFPStatus(this.t);
        this.f3399a.start();
    }

    public static void UnitySendMessage(String str, String str2, String str3) {
        if (!m.c()) {
            f.Log(5, "Native libraries not loaded - dropping message for " + str + "." + str2);
            return;
        }
        try {
            nativeUnitySendMessage(str, str2, str3.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public static String a(Context context) {
        return GeneratedOutlineSupport.outline32(context, context.getResources(), "game_view_content_description", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getResources());
    }

    /* access modifiers changed from: private */
    public void a() {
        a((Runnable) new Runnable() {
            public final void run() {
                UnityPlayer unityPlayer = UnityPlayer.this;
                unityPlayer.removeView(unityPlayer.m);
                UnityPlayer.this.m = null;
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(int i2, Surface surface) {
        if (!this.f3402d) {
            b(0, surface);
        }
    }

    public static void a(Activity activity) {
        if (activity != null && activity.getIntent().getBooleanExtra("android.intent.extra.VR_LAUNCH", false) && activity.getWindow() != null) {
            View decorView = activity.getWindow().getDecorView();
            if (decorView != null) {
                decorView.setSystemUiVisibility(7);
            }
        }
    }

    public static void a(ApplicationInfo applicationInfo) {
        if (NativeLoader.load(applicationInfo.nativeLibraryDir)) {
            m.a();
        } else {
            f.Log(6, "NativeLoader.load failure, Unity libraries were not loaded.");
        }
    }

    private void a(View view, View view2) {
        boolean z;
        if (!this.f3404f.d()) {
            pause();
            z = true;
        } else {
            z = false;
        }
        if (view != null) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof UnityPlayer) || ((UnityPlayer) parent) != this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                addView(view);
                bringChildToFront(view);
                view.setVisibility(0);
            }
        }
        if (view2 != null && view2.getParent() == this) {
            view2.setVisibility(8);
            removeView(view2);
        }
        if (z) {
            resume();
        }
    }

    private void a(f fVar) {
        if (!isFinishing()) {
            b((Runnable) fVar);
        }
    }

    private void b(Runnable runnable) {
        if (m.c()) {
            if (Thread.currentThread() == this.f3399a) {
                runnable.run();
            } else {
                this.g.add(runnable);
            }
        }
    }

    public static boolean b() {
        if (currentActivity == null) {
            return false;
        }
        TypedValue typedValue = new TypedValue();
        return currentActivity.getTheme().resolveAttribute(16842840, typedValue, true) && typedValue.type == 18 && typedValue.data != 0;
    }

    private boolean b(final int i2, final Surface surface) {
        if (!m.c() || !this.f3404f.e()) {
            return false;
        }
        final Semaphore semaphore = new Semaphore(0);
        AnonymousClass22 r1 = new Runnable() {
            public final void run() {
                UnityPlayer.this.nativeRecreateGfxState(i2, surface);
                semaphore.release();
            }
        };
        if (i2 == 0) {
            e eVar = this.f3399a;
            if (surface == null) {
                eVar.b(r1);
            } else {
                eVar.c(r1);
            }
        } else {
            r1.run();
        }
        if (surface == null && i2 == 0) {
            try {
                if (!semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                    f.Log(5, "Timeout while trying detaching primary window.");
                }
            } catch (InterruptedException unused) {
                f.Log(5, "UI thread got interrupted while trying to detach the primary window from the Unity Engine.");
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public SurfaceView c() {
        SurfaceView surfaceView = new SurfaceView(this.t);
        if (b()) {
            surfaceView.getHolder().setFormat(-3);
            surfaceView.setZOrderOnTop(true);
        } else {
            surfaceView.getHolder().setFormat(-1);
        }
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                UnityPlayer.this.a(0, surfaceHolder.getSurface());
                UnityPlayer.this.d();
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                UnityPlayer.this.a(0, surfaceHolder.getSurface());
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                UnityPlayer.this.a(0, (Surface) null);
            }
        });
        surfaceView.setFocusable(true);
        surfaceView.setFocusableInTouchMode(true);
        return surfaceView;
    }

    /* access modifiers changed from: private */
    public void d() {
        if (m.c() && this.f3404f.e()) {
            this.f3399a.d(new Runnable() {
                public final void run() {
                    UnityPlayer.this.nativeSendSurfaceChangedEvent();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        Context context = this.t;
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            ((Activity) this.t).finish();
        }
    }

    private void f() {
        reportSoftInputStr(null, 1, true);
        if (this.f3404f.g()) {
            if (m.c()) {
                final Semaphore semaphore = new Semaphore(0);
                this.f3399a.a(isFinishing() ? new Runnable() {
                    public final void run() {
                        UnityPlayer.this.g();
                        semaphore.release();
                    }
                } : new Runnable() {
                    public final void run() {
                        if (UnityPlayer.this.nativePause()) {
                            UnityPlayer.this.v = true;
                            UnityPlayer.this.g();
                            semaphore.release(2);
                            return;
                        }
                        semaphore.release();
                    }
                });
                try {
                    if (!semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                        f.Log(5, "Timeout while trying to pause the Unity Engine.");
                    }
                } catch (InterruptedException unused) {
                    f.Log(5, "UI thread got interrupted while trying to pause the Unity Engine.");
                }
                if (semaphore.drainPermits() > 0) {
                    destroy();
                }
            }
            this.f3404f.d(false);
            this.f3404f.b(true);
            if (this.i) {
                this.k.listen(this.j, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        this.w = nativeDone();
        this.f3404f.c(false);
    }

    private void h() {
        if (this.f3404f.f()) {
            this.f3404f.d(true);
            b((Runnable) new Runnable() {
                public final void run() {
                    UnityPlayer.this.nativeResume();
                }
            });
            this.f3399a.b();
        }
    }

    public static void i() {
        if (m.c()) {
            if (NativeLoader.unload()) {
                m.b();
                return;
            }
            throw new UnsatisfiedLinkError("Unable to unload libraries from libmain.so");
        }
    }

    private final native void initJni(Context context);

    private ApplicationInfo j() {
        return this.t.getPackageManager().getApplicationInfo(this.t.getPackageName(), 128);
    }

    /* access modifiers changed from: private */
    public boolean k() {
        try {
            return j().metaData.getBoolean("unity.splash-enable");
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean l() {
        try {
            return j().metaData.getBoolean("unity.tango-enable");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean loadLibraryStatic(String str) {
        StringBuilder sb;
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            sb = new StringBuilder("Unable to find ");
            sb.append(str);
            f.Log(6, sb.toString());
            return false;
        } catch (Exception e2) {
            sb = new StringBuilder("Unknown error ");
            sb.append(e2);
            f.Log(6, sb.toString());
            return false;
        }
    }

    private void m() {
        Context context = this.t;
        if (context instanceof Activity) {
            ((Activity) context).getWindow().setFlags(1024, 1024);
        }
    }

    private final native boolean nativeDone();

    /* access modifiers changed from: private */
    public final native void nativeFocusChanged(boolean z);

    private final native boolean nativeInjectEvent(InputEvent inputEvent);

    /* access modifiers changed from: private */
    public final native boolean nativeIsAutorotationOn();

    /* access modifiers changed from: private */
    public final native void nativeLowMemory();

    /* access modifiers changed from: private */
    public final native void nativeMuteMasterAudio(boolean z);

    /* access modifiers changed from: private */
    public final native boolean nativePause();

    /* access modifiers changed from: private */
    public final native void nativeRecreateGfxState(int i2, Surface surface);

    /* access modifiers changed from: private */
    public final native boolean nativeRender();

    private final native void nativeRestartActivityIndicator();

    /* access modifiers changed from: private */
    public final native void nativeResume();

    /* access modifiers changed from: private */
    public final native void nativeSendSurfaceChangedEvent();

    /* access modifiers changed from: private */
    public final native void nativeSetInputArea(int i2, int i3, int i4, int i5);

    /* access modifiers changed from: private */
    public final native void nativeSetInputSelection(int i2, int i3);

    /* access modifiers changed from: private */
    public final native void nativeSetInputString(String str);

    /* access modifiers changed from: private */
    public final native void nativeSetKeyboardIsVisible(boolean z);

    /* access modifiers changed from: private */
    public final native void nativeSetLaunchURL(String str);

    /* access modifiers changed from: private */
    public final native void nativeSoftInputCanceled();

    /* access modifiers changed from: private */
    public final native void nativeSoftInputClosed();

    private final native void nativeSoftInputLostFocus();

    public static native void nativeUnitySendMessage(String str, String str2, byte[] bArr);

    public final void a(Runnable runnable) {
        Context context = this.t;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            f.Log(5, "Not running Unity from an Activity; ignored...");
        }
    }

    public void addPhoneCallListener() {
        this.i = true;
        this.k.listen(this.j, 32);
    }

    public boolean addViewToPlayer(View view, boolean z) {
        a(view, (View) z ? this.u : null);
        boolean z2 = true;
        boolean z3 = view.getParent() == this;
        boolean z4 = z && this.u.getParent() == null;
        boolean z5 = this.u.getParent() == this;
        if (!z3 || (!z4 && !z5)) {
            z2 = false;
        }
        if (!z2) {
            if (!z3) {
                f.Log(6, "addViewToPlayer: Failure adding view to hierarchy");
            }
            if (!z4 && !z5) {
                f.Log(6, "addViewToPlayer: Failure removing old view from hierarchy");
            }
        }
        return z2;
    }

    public void configurationChanged(Configuration configuration) {
        SurfaceView surfaceView = this.u;
        if (surfaceView instanceof SurfaceView) {
            surfaceView.getHolder().setSizeFromLayout();
        }
        p pVar = this.x;
        if (pVar != null) {
            pVar.c();
        }
        GoogleVrProxy b2 = GoogleVrApi.b();
        if (b2 != null) {
            b2.c();
        }
    }

    public void destroy() {
        if (GoogleVrApi.b() != null) {
            GoogleVrApi.a();
        }
        Camera2Wrapper camera2Wrapper = this.p;
        if (camera2Wrapper != null) {
            camera2Wrapper.a();
            this.p = null;
        }
        HFPStatus hFPStatus = this.q;
        if (hFPStatus != null) {
            hFPStatus.a();
            this.q = null;
        }
        NetworkConnectivity networkConnectivity = this.s;
        if (networkConnectivity != null) {
            networkConnectivity.b();
            this.s = null;
        }
        this.v = true;
        if (!this.f3404f.d()) {
            pause();
        }
        this.f3399a.a();
        try {
            this.f3399a.join(4000);
        } catch (InterruptedException unused) {
            this.f3399a.interrupt();
        }
        BroadcastReceiver broadcastReceiver = this.h;
        if (broadcastReceiver != null) {
            this.t.unregisterReceiver(broadcastReceiver);
        }
        this.h = null;
        if (m.c()) {
            removeAllViews();
        }
        if (this.w) {
            kill();
        }
        i();
    }

    public void disableLogger() {
        f.f3499a = true;
    }

    public boolean displayChanged(int i2, Surface surface) {
        if (i2 == 0) {
            this.f3402d = surface != null;
            a((Runnable) new Runnable() {
                public final void run() {
                    if (UnityPlayer.this.f3402d) {
                        UnityPlayer unityPlayer = UnityPlayer.this;
                        unityPlayer.removeView(unityPlayer.u);
                        return;
                    }
                    UnityPlayer unityPlayer2 = UnityPlayer.this;
                    unityPlayer2.addView(unityPlayer2.u);
                }
            });
        }
        return b(i2, surface);
    }

    public void executeGLThreadJobs() {
        while (true) {
            Runnable runnable = (Runnable) this.g.poll();
            if (runnable != null) {
                runnable.run();
            } else {
                return;
            }
        }
    }

    public String getClipboardText() {
        ClipData primaryClip = this.l.getPrimaryClip();
        return primaryClip != null ? primaryClip.getItemAt(0).coerceToText(this.t).toString() : "";
    }

    public String getLaunchURL() {
        Uri uri = this.r;
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    public int getNetworkConnectivity() {
        if (!i.f3503d) {
            return 0;
        }
        if (this.s == null) {
            this.s = new NetworkConnectivity(this.t);
        }
        return this.s.a();
    }

    public Bundle getSettings() {
        return Bundle.EMPTY;
    }

    public int getSplashMode() {
        try {
            return j().metaData.getInt("unity.splash-mode");
        } catch (Exception unused) {
            return 0;
        }
    }

    public View getView() {
        return this;
    }

    public void hideSoftInput() {
        reportSoftInputArea(new Rect());
        reportSoftInputIsVisible(false);
        final AnonymousClass5 r0 = new Runnable() {
            public final void run() {
                j jVar = UnityPlayer.this.f3400b;
                if (jVar != null) {
                    jVar.dismiss();
                    UnityPlayer.this.f3400b = null;
                }
            }
        };
        if (i.f3501b) {
            a((f) new f() {
                public final void a() {
                    UnityPlayer.this.a(r0);
                }
            });
        } else {
            a((Runnable) r0);
        }
    }

    public void init(int i2, boolean z) {
    }

    public boolean initializeGoogleAr() {
        if (this.n == null && currentActivity != null && l()) {
            GoogleARCoreApi googleARCoreApi = new GoogleARCoreApi();
            this.n = googleARCoreApi;
            googleARCoreApi.initializeARCore(currentActivity);
            if (!this.f3404f.d()) {
                this.n.resumeARCore();
            }
        }
        return false;
    }

    public boolean initializeGoogleVr() {
        final GoogleVrProxy b2 = GoogleVrApi.b();
        if (b2 == null) {
            GoogleVrApi.a(this);
            b2 = GoogleVrApi.b();
            if (b2 == null) {
                f.Log(6, "Unable to create Google VR subsystem.");
                return false;
            }
        }
        final Semaphore semaphore = new Semaphore(0);
        final AnonymousClass15 r3 = new Runnable() {
            public final void run() {
                UnityPlayer.this.injectEvent(new KeyEvent(0, 4));
                UnityPlayer.this.injectEvent(new KeyEvent(1, 4));
            }
        };
        a((Runnable) new Runnable() {
            public final void run() {
                if (!b2.a(UnityPlayer.currentActivity, UnityPlayer.this.t, UnityPlayer.this.c(), r3)) {
                    f.Log(6, "Unable to initialize Google VR subsystem.");
                }
                Activity activity = UnityPlayer.currentActivity;
                if (activity != null) {
                    b2.a(activity.getIntent());
                }
                semaphore.release();
            }
        });
        try {
            if (semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                return b2.a();
            }
            f.Log(5, "Timeout while trying to initialize Google VR.");
            return false;
        } catch (InterruptedException e2) {
            f.Log(5, "UI thread was interrupted while initializing Google VR. " + e2.getLocalizedMessage());
            return false;
        }
    }

    public boolean injectEvent(InputEvent inputEvent) {
        if (!m.c()) {
            return false;
        }
        return nativeInjectEvent(inputEvent);
    }

    public boolean isFinishing() {
        if (!this.v) {
            Context context = this.t;
            boolean z = (context instanceof Activity) && ((Activity) context).isFinishing();
            this.v = z;
            return z;
        }
    }

    public void kill() {
        Process.killProcess(Process.myPid());
    }

    public boolean loadLibrary(String str) {
        return loadLibraryStatic(str);
    }

    public void lowMemory() {
        if (m.c()) {
            b((Runnable) new Runnable() {
                public final void run() {
                    UnityPlayer.this.nativeLowMemory();
                }
            });
        }
    }

    public void newIntent(Intent intent) {
        this.r = intent.getData();
        this.f3399a.e();
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    public void pause() {
        GoogleARCoreApi googleARCoreApi = this.n;
        if (googleARCoreApi != null) {
            googleARCoreApi.pauseARCore();
        }
        p pVar = this.x;
        if (pVar != null) {
            pVar.a();
        }
        GoogleVrProxy b2 = GoogleVrApi.b();
        if (b2 != null) {
            b2.pauseGvrLayout();
        }
        f();
    }

    public void quit() {
        destroy();
    }

    public void removeViewFromPlayer(View view) {
        a((View) this.u, view);
        boolean z = true;
        boolean z2 = view.getParent() == null;
        boolean z3 = this.u.getParent() == this;
        if (!z2 || !z3) {
            z = false;
        }
        if (!z) {
            if (!z2) {
                f.Log(6, "removeViewFromPlayer: Failure removing view from hierarchy");
            }
            if (!z3) {
                f.Log(6, "removeVireFromPlayer: Failure agging old view to hierarchy");
            }
        }
    }

    public void reportError(String str, String str2) {
        f.Log(6, str + ": " + str2);
    }

    public void reportSoftInputArea(final Rect rect) {
        a((f) new f() {
            public final void a() {
                UnityPlayer unityPlayer = UnityPlayer.this;
                Rect rect = rect;
                unityPlayer.nativeSetInputArea(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    public void reportSoftInputIsVisible(final boolean z) {
        a((f) new f() {
            public final void a() {
                UnityPlayer.this.nativeSetKeyboardIsVisible(z);
            }
        });
    }

    public void reportSoftInputSelection(final int i2, final int i3) {
        a((f) new f() {
            public final void a() {
                UnityPlayer.this.nativeSetInputSelection(i2, i3);
            }
        });
    }

    public void reportSoftInputStr(final String str, final int i2, final boolean z) {
        if (i2 == 1) {
            hideSoftInput();
        }
        a((f) new f() {
            public final void a() {
                if (z) {
                    UnityPlayer.this.nativeSoftInputCanceled();
                } else {
                    String str = str;
                    if (str != null) {
                        UnityPlayer.this.nativeSetInputString(str);
                    }
                }
                if (i2 == 1) {
                    UnityPlayer.this.nativeSoftInputClosed();
                }
            }
        });
    }

    public void requestUserAuthorization(String str) {
        if (i.f3502c && str != null && !str.isEmpty() && currentActivity != null) {
            i.f3504e.a(currentActivity, str);
        }
    }

    public void resume() {
        GoogleARCoreApi googleARCoreApi = this.n;
        if (googleARCoreApi != null) {
            googleARCoreApi.resumeARCore();
        }
        this.f3404f.b(false);
        p pVar = this.x;
        if (pVar != null) {
            pVar.b();
        }
        h();
        nativeRestartActivityIndicator();
        GoogleVrProxy b2 = GoogleVrApi.b();
        if (b2 != null) {
            b2.b();
        }
    }

    public void setCharacterLimit(final int i2) {
        a((Runnable) new Runnable() {
            public final void run() {
                j jVar = UnityPlayer.this.f3400b;
                if (jVar != null) {
                    jVar.a(i2);
                }
            }
        });
    }

    public void setClipboardText(String str) {
        this.l.setPrimaryClip(ClipData.newPlainText("Text", str));
    }

    public void setHideInputField(final boolean z) {
        a((Runnable) new Runnable() {
            public final void run() {
                j jVar = UnityPlayer.this.f3400b;
                if (jVar != null) {
                    jVar.a(z);
                }
            }
        });
    }

    public void setSelection(final int i2, final int i3) {
        a((Runnable) new Runnable() {
            public final void run() {
                j jVar = UnityPlayer.this.f3400b;
                if (jVar != null) {
                    jVar.a(i2, i3);
                }
            }
        });
    }

    public void setSoftInputStr(final String str) {
        a((Runnable) new Runnable() {
            public final void run() {
                j jVar = UnityPlayer.this.f3400b;
                if (jVar != null) {
                    String str = str;
                    if (str != null) {
                        jVar.a(str);
                    }
                }
            }
        });
    }

    public void showSoftInput(String str, int i2, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i3, boolean z5) {
        final String str3 = str;
        final int i4 = i2;
        final boolean z6 = z;
        final boolean z7 = z2;
        final boolean z8 = z3;
        final boolean z9 = z4;
        final String str4 = str2;
        final int i5 = i3;
        final boolean z10 = z5;
        AnonymousClass4 r0 = new Runnable() {
            public final void run() {
                UnityPlayer unityPlayer = UnityPlayer.this;
                j jVar = new j(UnityPlayer.this.t, this, str3, i4, z6, z7, z8, str4, i5, z10);
                unityPlayer.f3400b = jVar;
                UnityPlayer.this.f3400b.show();
            }
        };
        a((Runnable) r0);
    }

    public boolean showVideoPlayer(String str, int i2, int i3, int i4, boolean z, int i5, int i6) {
        if (this.x == null) {
            this.x = new p(this);
        }
        boolean a2 = this.x.a(this.t, str, i2, i3, i4, z, (long) i5, (long) i6, new com.unity3d.player.p.a() {
            public final void a() {
                UnityPlayer.this.x = null;
            }
        });
        if (a2) {
            a((Runnable) new Runnable() {
                public final void run() {
                    if (UnityPlayer.this.nativeIsAutorotationOn() && (UnityPlayer.this.t instanceof Activity)) {
                        ((Activity) UnityPlayer.this.t).setRequestedOrientation(UnityPlayer.this.f3401c);
                    }
                }
            });
        }
        return a2;
    }

    public boolean skipPermissionsDialog() {
        if (!i.f3502c || currentActivity == null) {
            return false;
        }
        return i.f3504e.a(currentActivity);
    }

    public void start() {
    }

    public void stop() {
    }

    public void toggleGyroscopeSensor(boolean z) {
        SensorManager sensorManager = (SensorManager) this.t.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        if (z) {
            sensorManager.registerListener(this.o, defaultSensor, 1);
        } else {
            sensorManager.unregisterListener(this.o);
        }
    }

    public void windowFocusChanged(boolean z) {
        this.f3404f.a(z);
        if (this.f3404f.e()) {
            if (z && this.f3400b != null) {
                nativeSoftInputLostFocus();
                reportSoftInputStr(null, 1, false);
            }
            if (z) {
                this.f3399a.c();
            } else {
                this.f3399a.d();
            }
            h();
        }
    }
}

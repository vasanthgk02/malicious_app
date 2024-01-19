package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import com.unity3d.player.GoogleVrVideo.GoogleVrVideoCallbacks;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

public class GoogleVrProxy extends b implements GoogleVrVideo {

    /* renamed from: f  reason: collision with root package name */
    public boolean f3352f = false;
    public boolean g = false;
    public Runnable h = null;
    public Vector i = new Vector();
    public SurfaceView j = null;
    public a k = new a();
    public Thread l = null;
    public Handler m = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (message.what != 135711) {
                super.handleMessage(message);
                return;
            }
            switch (message.arg1) {
                case 2147483645:
                    Iterator it = GoogleVrProxy.this.i.iterator();
                    while (it.hasNext()) {
                        ((GoogleVrVideoCallbacks) it.next()).onFrameAvailable();
                    }
                    return;
                case 2147483646:
                    Surface surface = (Surface) message.obj;
                    Iterator it2 = GoogleVrProxy.this.i.iterator();
                    while (it2.hasNext()) {
                        ((GoogleVrVideoCallbacks) it2.next()).onSurfaceAvailable(surface);
                    }
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f3363a = false;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3364b = false;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3365c = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3366d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3367e = true;

        /* renamed from: f  reason: collision with root package name */
        public boolean f3368f = false;

        public a() {
        }

        public final boolean a() {
            return this.f3363a && this.f3364b;
        }

        public final void b() {
            this.f3363a = false;
            this.f3364b = false;
            this.f3366d = false;
            this.f3367e = true;
            this.f3368f = false;
        }
    }

    public GoogleVrProxy(e eVar) {
        super("Google VR", eVar);
        initVrJni();
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        this.k.f3366d = z;
    }

    public static boolean a(int i2) {
        return VERSION.SDK_INT >= i2;
    }

    private boolean a(ClassLoader classLoader) {
        try {
            Class<?> loadClass = classLoader.loadClass("com.unity3d.unitygvr.GoogleVR");
            n nVar = new n(loadClass, loadClass.getConstructor(new Class[0]).newInstance(new Object[0]));
            nVar.a((String) "initialize", new Class[]{Activity.class, Context.class, SurfaceView.class, Boolean.TYPE, Handler.class});
            nVar.a((String) "deinitialize", new Class[0]);
            nVar.a((String) "load", new Class[]{Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Runnable.class});
            nVar.a((String) "enable", new Class[]{Boolean.TYPE});
            nVar.a((String) "unload", new Class[0]);
            nVar.a((String) "pause", new Class[0]);
            nVar.a((String) "resume", new Class[0]);
            nVar.a((String) "getGvrLayout", new Class[0]);
            nVar.a((String) "getVideoSurfaceId", new Class[0]);
            nVar.a((String) "getVideoSurface", new Class[0]);
            this.f3491a = nVar;
            return true;
        } catch (Exception e2) {
            reportError("Exception initializing GoogleVR from Unity library. " + e2.getLocalizedMessage());
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean d() {
        return this.k.f3366d;
    }

    private void e() {
        Activity activity = (Activity) this.f3493c;
        if (this.g) {
            a aVar = this.k;
            if (!aVar.f3368f && activity != null) {
                aVar.f3368f = true;
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.HOME");
                intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
                activity.startActivity(intent);
            }
        }
    }

    private final native void initVrJni();

    private final native boolean isQuiting();

    private final native void setVrVideoTransform(float[][] fArr);

    public final void a(Intent intent) {
        if (intent != null && intent.getBooleanExtra("android.intent.extra.VR_LAUNCH", false)) {
            this.g = true;
        }
    }

    public final boolean a() {
        return this.k.f3363a;
    }

    public final boolean a(Activity activity, Context context, SurfaceView surfaceView, Runnable runnable) {
        String str;
        boolean z;
        if (activity == null || context == null || surfaceView == null || runnable == null) {
            str = "Invalid parameters passed to Google VR initiialization.";
        } else {
            this.k.b();
            this.f3493c = context;
            this.h = runnable;
            if (!a(19)) {
                str = "Google VR requires a device that supports an api version of 19 (KitKat) or better.";
            } else if (this.g && !a(24)) {
                str = "Daydream requires a device that supports an api version of 24 (Nougat) or better.";
            } else if (!a(UnityPlayer.class.getClassLoader())) {
                return false;
            } else {
                try {
                    z = ((Boolean) this.f3491a.a((String) "initialize", activity, context, surfaceView, Boolean.valueOf(this.g), this.m)).booleanValue();
                } catch (Exception e2) {
                    reportError("Exception while trying to intialize Unity Google VR Library. " + e2.getLocalizedMessage());
                    z = false;
                }
                if (!z) {
                    str = "Unable to initialize GoogleVR library.";
                } else {
                    this.j = surfaceView;
                    this.k.f3363a = true;
                    this.f3494d = "";
                    return true;
                }
            }
        }
        reportError(str);
        return false;
    }

    public final void b() {
        resumeGvrLayout();
    }

    public final void c() {
        SurfaceView surfaceView = this.j;
        if (surfaceView != null) {
            surfaceView.getHolder().setSizeFromLayout();
        }
    }

    public void deregisterGoogleVrVideoListener(GoogleVrVideoCallbacks googleVrVideoCallbacks) {
        if (this.i.contains(googleVrVideoCallbacks)) {
            googleVrVideoCallbacks.onSurfaceUnavailable();
            this.i.remove(googleVrVideoCallbacks);
        }
    }

    public Object getVideoSurface() {
        if (d() && !this.k.f3367e) {
            try {
                return this.f3491a.a((String) "getVideoSurface", new Object[0]);
            } catch (Exception e2) {
                reportError("Exception caught while Getting GoogleVR Video Surface. " + e2.getLocalizedMessage());
            }
        }
        return null;
    }

    public int getVideoSurfaceId() {
        if (d() && !this.k.f3367e) {
            try {
                return ((Integer) this.f3491a.a((String) "getVideoSurfaceId", new Object[0])).intValue();
            } catch (Exception e2) {
                reportError("Exception caught while getting Video Surface ID from GoogleVR. " + e2.getLocalizedMessage());
            }
        }
        return -1;
    }

    public long loadGoogleVr(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (!this.k.f3363a) {
            return 0;
        }
        AtomicLong atomicLong = new AtomicLong(0);
        this.f3494d = (z || z2) ? "Daydream" : "Cardboard";
        final AtomicLong atomicLong2 = atomicLong;
        final boolean z6 = z;
        final boolean z7 = z2;
        final boolean z8 = z3;
        final boolean z9 = z4;
        final boolean z10 = z5;
        AnonymousClass2 r0 = new Runnable() {
            public final void run() {
                try {
                    atomicLong2.set(((Long) GoogleVrProxy.this.f3491a.a((String) "load", Boolean.valueOf(z6), Boolean.valueOf(z7), Boolean.valueOf(z8), Boolean.valueOf(z9), Boolean.valueOf(z10), GoogleVrProxy.this.h)).longValue());
                    GoogleVrProxy.this.k.f3364b = true;
                } catch (Exception e2) {
                    GoogleVrProxy googleVrProxy = GoogleVrProxy.this;
                    googleVrProxy.reportError("Exception caught while loading GoogleVR. " + e2.getLocalizedMessage());
                    atomicLong2.set(0);
                }
            }
        };
        if (!runOnUiThreadWithSync(r0) || atomicLong.longValue() == 0) {
            reportError("Google VR had a fatal issue while loading. VR will not be available.");
        }
        return atomicLong.longValue();
    }

    public void pauseGvrLayout() {
        if (this.k.a() && !this.k.f3367e) {
            if (d()) {
                Iterator it = this.i.iterator();
                while (it.hasNext()) {
                    ((GoogleVrVideoCallbacks) it.next()).onSurfaceUnavailable();
                }
            }
            n nVar = this.f3491a;
            if (nVar != null) {
                nVar.a((String) "pause", new Object[0]);
            }
            this.k.f3367e = true;
        }
    }

    public void registerGoogleVrVideoListener(GoogleVrVideoCallbacks googleVrVideoCallbacks) {
        if (!this.i.contains(googleVrVideoCallbacks)) {
            this.i.add(googleVrVideoCallbacks);
            Surface surface = (Surface) getVideoSurface();
            if (surface != null) {
                googleVrVideoCallbacks.onSurfaceAvailable(surface);
            }
        }
    }

    public void resumeGvrLayout() {
        if (this.k.a() && this.k.f3367e) {
            n nVar = this.f3491a;
            if (nVar != null) {
                nVar.a((String) "resume", new Object[0]);
            }
            this.k.f3367e = false;
        }
    }

    public void setGoogleVrModeEnabled(final boolean z) {
        if (!(!this.k.a() || this.f3492b == null || this.f3493c == null)) {
            if (!z && isQuiting()) {
                e();
            }
            runOnUiThread(new Runnable() {
                public final void run() {
                    if (z != GoogleVrProxy.this.d()) {
                        try {
                            if (z) {
                                if (!GoogleVrProxy.this.d()) {
                                    if (GoogleVrProxy.this.f3491a == null || GoogleVrProxy.this.f3492b == null || GoogleVrProxy.this.f3492b.addViewToPlayer((View) GoogleVrProxy.this.f3491a.a((String) "getGvrLayout", new Object[0]), true)) {
                                        if (GoogleVrProxy.this.f3491a != null) {
                                            GoogleVrProxy.this.f3491a.a((String) "enable", Boolean.TRUE);
                                        }
                                        GoogleVrProxy.this.a(true);
                                        return;
                                    }
                                    GoogleVrProxy.this.reportError("Unable to add Google VR to view hierarchy.");
                                    return;
                                }
                            }
                            if (!z && GoogleVrProxy.this.d()) {
                                GoogleVrProxy.this.a(false);
                                if (GoogleVrProxy.this.f3491a != null) {
                                    GoogleVrProxy.this.f3491a.a((String) "enable", Boolean.FALSE);
                                }
                                if (!(GoogleVrProxy.this.f3491a == null || GoogleVrProxy.this.f3492b == null)) {
                                    GoogleVrProxy.this.f3492b.removeViewFromPlayer((View) GoogleVrProxy.this.f3491a.a((String) "getGvrLayout", new Object[0]));
                                }
                            }
                        } catch (Exception e2) {
                            GoogleVrProxy googleVrProxy = GoogleVrProxy.this;
                            googleVrProxy.reportError("Exception enabling Google VR on UI Thread. " + e2.getLocalizedMessage());
                        }
                    }
                }
            });
        }
    }

    public void setVideoLocationTransform(float[] fArr) {
        float[][] fArr2 = (float[][]) Array.newInstance(float.class, new int[]{4, 4});
        for (int i2 = 0; i2 < 4; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                fArr2[i2][i3] = fArr[(i2 * 4) + i3];
            }
        }
        setVrVideoTransform(fArr2);
    }

    public void unloadGoogleVr() {
        if (this.k.f3366d) {
            setGoogleVrModeEnabled(false);
        }
        a aVar = this.k;
        if (aVar.f3365c) {
            aVar.f3365c = false;
        }
        this.j = null;
        runOnUiThread(new Runnable() {
            public final void run() {
                try {
                    if (GoogleVrProxy.this.f3491a != null) {
                        GoogleVrProxy.this.f3491a.a((String) "unload", new Object[0]);
                        GoogleVrProxy.this.f3491a.a((String) "deinitialize", new Object[0]);
                        GoogleVrProxy.this.f3491a = null;
                    }
                    GoogleVrProxy.this.k.f3364b = false;
                } catch (Exception e2) {
                    GoogleVrProxy googleVrProxy = GoogleVrProxy.this;
                    googleVrProxy.reportError("Exception unloading Google VR on UI Thread. " + e2.getLocalizedMessage());
                }
            }
        });
    }
}

package com.userexperior.models.recording;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.Window;
import android.view.Window.Callback;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.userexperior.UserExperior;
import com.userexperior.interfaces.recording.b;
import com.userexperior.models.recording.enums.h;
import com.userexperior.provider.UeContentProvider;
import com.userexperior.utilities.l;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.logging.Level;

public class a implements ActivityLifecycleCallbacks {

    /* renamed from: b  reason: collision with root package name */
    public static final String f4053b = a.class.getSimpleName();
    public static String m;
    public static String n;
    public static String o;
    public static String p;
    public static boolean q;
    public static boolean s;

    /* renamed from: a  reason: collision with root package name */
    public long f4054a;

    /* renamed from: c  reason: collision with root package name */
    public LinkedHashMap<String, b> f4055c = new LinkedHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public b f4056d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4057e;

    /* renamed from: f  reason: collision with root package name */
    public CountDownTimer f4058f;
    public CountDownTimer g;
    public Stack<Activity> h;
    public int i = 1;
    public boolean j = false;
    public h k;
    public long l = com.userexperior.c.b.a.f3820a;
    public long r;

    public a(b bVar) {
        this.f4056d = bVar;
        this.h = new Stack<>();
        this.f4057e = true;
    }

    public static void a() {
        q = false;
    }

    private void a(final Activity activity, final h hVar) {
        b bVar = this.f4056d;
        if (bVar != null) {
            bVar.a(new Runnable() {
                public final void run() {
                    String a2 = activity.toString();
                    if (!a.this.f4055c.containsKey(a2)) {
                        b bVar = new b(activity, hVar);
                        a.f4053b;
                        a.this.f4055c.put(a2, bVar);
                        a.f4053b;
                        a.this.c(activity);
                        return;
                    }
                    b bVar2 = (b) a.this.f4055c.get(a2);
                    bVar2.f4073b = hVar;
                    a.f4053b;
                    a.f4053b;
                    StringBuilder sb = new StringBuilder();
                    sb.append(bVar2.f4072a.getLocalClassName());
                    sb.append(" moved to ");
                    sb.append(bVar2.f4073b.toString());
                    a.b(a.this, activity);
                }
            });
        }
    }

    private void a(h hVar, Activity activity, long j2) {
        b bVar = this.f4056d;
        if (bVar != null) {
            final h hVar2 = hVar;
            final Activity activity2 = activity;
            final long j3 = j2;
            AnonymousClass3 r1 = new Runnable() {
                public final void run() {
                    try {
                        if (h.RESUMED == hVar2) {
                            if (a.this.h != null) {
                                a.this.h.push(activity2);
                                a.this.f4056d.a(activity2);
                            }
                        } else if (h.PAUSED == hVar2) {
                            if (a.this.h.size() > 1) {
                                a.this.h.pop();
                                a.this.f4056d.a(a.this.h.empty() ? null : (Activity) a.this.h.peek());
                            } else if (a.this.h.size() == 1) {
                                a.this.h.pop();
                            } else {
                                a.f4053b;
                            }
                        }
                    } catch (Exception e2) {
                        GeneratedOutlineSupport.outline95(e2, new StringBuilder("ex : ALC - log (1) : "), Level.SEVERE);
                    }
                    try {
                        int i = activity2.getResources().getConfiguration().orientation;
                        a.f4053b;
                        StringBuilder sb = new StringBuilder();
                        sb.append(activity2.getClass().getSimpleName());
                        sb.append(" prevOrientation = ");
                        sb.append(a.this.i);
                        sb.append(" currentOrientation = ");
                        sb.append(i);
                        if (a.this.i != i) {
                            if (a.this.k != h.PAUSED) {
                                a.this.j = true;
                            }
                        } else if (hVar2 == h.RESUMED) {
                            a.this.j = false;
                        }
                        a.this.k = hVar2;
                        a.this.i = i;
                        a.this.f4056d.a(hVar2, activity2.getClass().getSimpleName(), j3);
                        a.b(a.this, hVar2);
                    } catch (Exception e3) {
                        GeneratedOutlineSupport.outline95(e3, new StringBuilder("ex : ALC - log (2) : "), Level.SEVERE);
                    }
                }
            };
            bVar.a(r1);
        }
    }

    public static void a(String str) {
        m = str;
    }

    public static void b() {
        s = false;
    }

    private void b(final Activity activity) {
        b bVar = this.f4056d;
        if (bVar != null) {
            bVar.a(new Runnable() {
                public final void run() {
                    String a2 = activity.toString();
                    if (a.this.f4055c.containsKey(a2)) {
                        Window window = ((b) a.this.f4055c.get(a2)).f4072a.getWindow();
                        boolean z = window.getCallback() instanceof WindowCallback;
                        a.f4053b;
                        if (z) {
                            a.f4053b;
                            window.setCallback(((WindowCallback) window.getCallback()).f4038a);
                        } else {
                            StringBuilder sb = new StringBuilder("how come ");
                            sb.append(activity.getLocalClassName());
                            sb.append(" does not hold window callback ?");
                        }
                        a.f4053b;
                        a.f4053b;
                        a.f4053b;
                        a.f4053b;
                        a.this.f4055c.remove(a2);
                        return;
                    }
                    a.f4053b;
                }
            });
        }
    }

    public static /* synthetic */ void b(a aVar, Activity activity) {
        if (!(activity.getWindow().getCallback() instanceof WindowCallback)) {
            aVar.c(activity);
        }
    }

    public static /* synthetic */ void b(a aVar, h hVar) {
        StringBuilder sb = new StringBuilder("state ");
        sb.append(hVar);
        sb.append(" isDeviceRotated ");
        sb.append(aVar.j);
        if (hVar == h.STOPPED) {
            if (aVar.m()) {
                aVar.f4057e = true;
                aVar.f4056d.a();
            }
            return;
        }
        if (hVar == h.RESUMED && aVar.f4057e) {
            aVar.f4057e = false;
            aVar.f4056d.b();
        }
    }

    public static void b(String str) {
        n = str;
    }

    /* access modifiers changed from: private */
    public void c(Activity activity) {
        Window window = activity.getWindow();
        Callback callback = window.getCallback();
        new StringBuilder("original callback ").append(callback.toString());
        window.setCallback(new WindowCallback(callback, activity, this.f4056d, this.f4058f));
    }

    public static String h() {
        return m;
    }

    public static String i() {
        return n;
    }

    public static String j() {
        return o;
    }

    public static String k() {
        return p;
    }

    private boolean m() {
        Iterator<Entry<String, b>> it = this.f4055c.entrySet().iterator();
        new StringBuilder("map size ").append(this.f4055c.size());
        boolean z = true;
        while (z && it.hasNext()) {
            b bVar = (b) it.next().getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(bVar.f4072a.getLocalClassName());
            sb.append(" in ");
            sb.append(bVar.f4073b.toString());
            if (bVar.f4073b != h.STOPPED) {
                z = false;
            }
        }
        return z;
    }

    public final void a(boolean z) {
        if (z) {
            this.l = com.userexperior.c.b.a.f3820a;
        }
        CountDownTimer countDownTimer = this.f4058f;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f4058f.start();
            return;
        }
        new StringBuilder("MAIN --> CREATE with timeLeft = ").append(this.l);
        this.f4058f = new CountDownTimer(this.l) {
            public final void onFinish() {
                if (a.this.f4058f != null) {
                    a.this.f4058f.cancel();
                    a.this.f4056d.e();
                }
            }

            public final void onTick(long j) {
                a.this.l = j;
            }
        }.start();
    }

    public final Activity c() {
        try {
            if (this.h == null || this.h.empty()) {
                return null;
            }
            return this.h.peek();
        } catch (Exception e2) {
            GeneratedOutlineSupport.outline95(e2, new StringBuilder("ex : ALC - gLA "), Level.SEVERE);
            return null;
        }
    }

    public final String d() {
        if (this.f4055c.isEmpty()) {
            return "";
        }
        Iterator<b> it = this.f4055c.values().iterator();
        while (true) {
            String str = "Application";
            while (true) {
                if (!it.hasNext()) {
                    return str;
                }
                Activity activity = it.next().f4072a;
                if (activity != null) {
                    str = activity.getClass().getSimpleName();
                }
            }
        }
    }

    public final void e() {
        CountDownTimer countDownTimer = this.f4058f;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f4058f = null;
        }
    }

    public final void f() {
        if (this.f4054a > 0) {
            CountDownTimer countDownTimer = this.g;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.g.start();
                return;
            }
            new StringBuilder("IDLE --> IDLE Timer Created with timeout = ").append(this.f4054a);
            if (this.f4054a > 0) {
                long j2 = this.f4054a;
                AnonymousClass6 r5 = new CountDownTimer(j2, j2) {
                    public final void onFinish() {
                        if (a.this.g != null) {
                            a.this.g.cancel();
                        }
                        if (a.this.f4056d != null) {
                            a.this.f4056d.f();
                        }
                        a.this.e();
                    }

                    public final void onTick(long j) {
                    }
                };
                this.g = r5.start();
            }
        }
    }

    public final void g() {
        CountDownTimer countDownTimer = this.g;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.g = null;
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        b(activity);
        a(h.CREATED, activity, SystemClock.uptimeMillis());
        a(activity, h.CREATED);
        new StringBuilder("onActivityCreated Total key ").append(this.f4055c.size());
    }

    public void onActivityDestroyed(Activity activity) {
        b(activity);
        a(h.DESTROYED, activity, SystemClock.uptimeMillis());
        new StringBuilder("onActivityDestroyed Total key ").append(this.f4055c.size());
    }

    public void onActivityPaused(Activity activity) {
        a(h.PAUSED, activity, SystemClock.uptimeMillis());
    }

    public void onActivityResumed(final Activity activity) {
        long j2;
        if (!s) {
            Context applicationContext = activity.getApplicationContext();
            long a2 = UeContentProvider.a();
            if (!l.z(applicationContext).equalsIgnoreCase("COLD") || a2 == 0) {
                j2 = System.currentTimeMillis() - this.r;
                l.e(applicationContext, "HOT");
            } else {
                j2 = System.currentTimeMillis() - a2;
            }
            l.a(applicationContext, System.currentTimeMillis());
            UeContentProvider.b();
            Editor edit = applicationContext.getSharedPreferences(UserExperior.TAG, 0).edit();
            edit.putLong("appLaunchLatency", j2);
            edit.apply();
            s = true;
        }
        a(h.RESUMED, activity, SystemClock.uptimeMillis());
        a(activity, h.RESUMED);
        b bVar = this.f4056d;
        if (bVar != null) {
            bVar.a(new Runnable() {
                public final void run() {
                    Activity activity = activity;
                    a.p = activity != null ? activity.getClass().getSimpleName() : "APPLICATION";
                }
            });
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(h.SAVED_INSTANCE_STATE, activity, SystemClock.uptimeMillis());
    }

    public void onActivityStarted(Activity activity) {
        if (!q) {
            this.r = System.currentTimeMillis();
            q = true;
        }
        a(h.STARTED, activity, SystemClock.uptimeMillis());
        a(activity, h.STARTED);
    }

    public void onActivityStopped(Activity activity) {
        if (activity != null) {
            o = activity.getClass().getSimpleName();
            b(activity);
            a(h.STOPPED, activity, SystemClock.uptimeMillis());
            return;
        }
        o = "APPLICATION";
    }
}

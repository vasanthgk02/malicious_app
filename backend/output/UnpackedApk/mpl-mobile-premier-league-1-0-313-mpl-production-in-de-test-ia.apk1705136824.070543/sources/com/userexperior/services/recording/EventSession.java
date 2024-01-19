package com.userexperior.services.recording;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.userexperior.UserExperior;
import com.userexperior.utilities.b;
import com.userexperior.utilities.l;
import java.util.logging.Level;

public class EventSession extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4098a = EventSession.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public boolean f4099b;

    public static void a(Context context) {
        context.startService(new Intent(context, EventSession.class));
    }

    public static void b(Context context) {
        context.stopService(new Intent(context, EventSession.class));
    }

    public static /* synthetic */ void c(EventSession eventSession) {
        if (eventSession.getApplicationContext().getSharedPreferences(UserExperior.TAG, 0).getBoolean("isAppCrashed", false)) {
            l.r(eventSession.getApplicationContext());
            eventSession.stopSelf();
        }
    }

    public static /* synthetic */ void d(EventSession eventSession) {
        Editor edit = eventSession.getApplicationContext().getSharedPreferences(UserExperior.TAG, 0).edit();
        edit.remove("startRecordingTime");
        edit.apply();
        if (l.c(eventSession.getApplicationContext())) {
            l.d(eventSession.getApplicationContext());
        }
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void onCreate() {
        super.onCreate();
        try {
            f g = f.g();
            g.f4139b = getApplication();
            g.g = g.l();
            if (f.f4138a != null && !f.f4138a.isAlive()) {
                f.f4138a.start();
            }
            g.f4142e = i.a((Handler) new g(g));
        } catch (Exception e2) {
            GeneratedOutlineSupport.outline95(e2, new StringBuilder("issue creating es: "), Level.INFO);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f4099b = false;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            new Thread(new Runnable() {
                public final void run() {
                    Process.setThreadPriority(10);
                    if (!EventSession.this.f4099b) {
                        EventSession.this.f4099b = true;
                        b.a(Level.INFO, "ES");
                        EventSession.f4098a;
                        EventSession.c(EventSession.this);
                        EventSession.d(EventSession.this);
                        return;
                    }
                    EventSession.f4098a;
                }
            }).start();
        } catch (Exception e2) {
            GeneratedOutlineSupport.outline95(e2, new StringBuilder("issue at es: "), Level.INFO);
        }
        return 2;
    }
}

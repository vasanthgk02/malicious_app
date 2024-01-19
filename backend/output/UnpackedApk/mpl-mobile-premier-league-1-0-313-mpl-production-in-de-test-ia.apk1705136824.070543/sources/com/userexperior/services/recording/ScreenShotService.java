package com.userexperior.services.recording;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.userexperior.models.recording.enums.f;
import com.userexperior.utilities.j;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;

public class ScreenShotService extends Service {

    /* renamed from: b  reason: collision with root package name */
    public static final String f4101b = ScreenShotService.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f4102a;

    /* renamed from: c  reason: collision with root package name */
    public j f4103c;

    public static void a(Context context, ServiceConnection serviceConnection, Bundle bundle) {
        Intent intent = new Intent(context, ScreenShotService.class);
        intent.setAction(f.INVOKE.toString());
        intent.putExtra("bundle_data", bundle);
        context.bindService(intent, serviceConnection, 1);
        Thread.setDefaultUncaughtExceptionHandler(f.g());
    }

    public IBinder onBind(Intent intent) {
        j.a(getBaseContext(), intent.getBundleExtra("bundle_data").getString("session_base_path"));
        return new Messenger(this.f4103c).getBinder();
    }

    public void onCreate() {
        super.onCreate();
        try {
            this.f4103c = new j(this);
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue(10), new ThreadFactory() {

                /* renamed from: b  reason: collision with root package name */
                public final AtomicInteger f4105b = new AtomicInteger();

                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable, String.format("%s-%d", new Object[]{"ue_b_svr", Integer.valueOf(this.f4105b.incrementAndGet())}));
                    thread.setPriority(1);
                    return thread;
                }
            });
            this.f4102a = threadPoolExecutor;
        } catch (Exception e2) {
            e2.printStackTrace();
            GeneratedOutlineSupport.outline95(e2, new StringBuilder("at ss:onc: "), Level.INFO);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        this.f4102a.shutdownNow();
        return super.onUnbind(intent);
    }
}

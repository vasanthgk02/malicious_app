package com.shield.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import com.shield.android.IIsolatedService.Stub;
import com.shield.android.internal.NativeUtils;
import com.shield.android.internal.f;
import java.io.InputStream;

public class ShieldIsolatedService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public NativeUtils f1683a;

    /* renamed from: b  reason: collision with root package name */
    public final Stub f1684b = new a();

    public class a extends Stub {
        public a() {
        }

        public boolean isMagiskPresent() {
            boolean z = true;
            try {
                String replaceAll = ShieldIsolatedService.a(ShieldIsolatedService.this, new String[]{"system/bin/cat", "/proc/self/mountinfo"}).replaceAll("[^A-Za-z0-9 \\s\\-_.]+", "");
                if (replaceAll.length() > 0 && replaceAll.contains("magisk")) {
                    return true;
                }
            } catch (Exception unused) {
            }
            if (!ShieldIsolatedService.this.f1683a.a()) {
                return false;
            }
            if (!ShieldIsolatedService.this.f1683a.isFoundMagisk() && !ShieldIsolatedService.this.f1683a.isZygiskDetected()) {
                z = false;
            }
            return z;
        }
    }

    public static String a(ShieldIsolatedService shieldIsolatedService, String[] strArr) {
        if (shieldIsolatedService != null) {
            try {
                StringBuilder sb = new StringBuilder();
                byte[] bArr = new byte[1024];
                InputStream inputStream = new ProcessBuilder(strArr).start().getInputStream();
                while (inputStream.read(bArr) != -1) {
                    sb.append(new String(bArr));
                }
                inputStream.close();
                return sb.toString();
            } catch (Exception e2) {
                if (f.a().f1677b && e2.getMessage() != null) {
                    e2.getLocalizedMessage();
                }
                return "";
            }
        } else {
            throw null;
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f1684b;
    }

    public void onCreate() {
        super.onCreate();
        this.f1683a = new NativeUtils(this);
    }

    public void onDestroy() {
        super.onDestroy();
        Process.killProcess(Process.myPid());
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        stopSelf();
    }
}

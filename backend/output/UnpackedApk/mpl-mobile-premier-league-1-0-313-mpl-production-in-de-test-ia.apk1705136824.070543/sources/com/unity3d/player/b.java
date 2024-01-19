package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.apache.fontbox.cmap.CMapParser;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public n f3491a = null;

    /* renamed from: b  reason: collision with root package name */
    public e f3492b = null;

    /* renamed from: c  reason: collision with root package name */
    public Context f3493c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f3494d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f3495e = "";

    public b(String str, e eVar) {
        this.f3495e = str;
        this.f3492b = eVar;
    }

    public void reportError(String str) {
        e eVar = this.f3492b;
        if (eVar != null) {
            eVar.reportError(this.f3495e + " Error [" + this.f3494d + CMapParser.MARK_END_OF_ARRAY, str);
            return;
        }
        f.Log(6, this.f3495e + " Error [" + this.f3494d + "]: " + str);
    }

    public void runOnUiThread(Runnable runnable) {
        Context context = this.f3493c;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
            return;
        }
        f.Log(5, "Not running " + this.f3495e + " from an Activity; Ignoring execution request...");
    }

    public boolean runOnUiThreadWithSync(final Runnable runnable) {
        boolean z = true;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
            return true;
        }
        boolean z2 = false;
        final Semaphore semaphore = new Semaphore(0);
        runOnUiThread(new Runnable() {
            public final void run() {
                try {
                    runnable.run();
                } catch (Exception e2) {
                    b bVar = b.this;
                    bVar.reportError("Exception unloading Google VR on UI Thread. " + e2.getLocalizedMessage());
                } catch (Throwable th) {
                    semaphore.release();
                    throw th;
                }
                semaphore.release();
            }
        });
        try {
            if (!semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                reportError("Timeout waiting for vr state change!");
                z = false;
            }
            z2 = z;
        } catch (InterruptedException e2) {
            reportError("Interrupted while trying to acquire sync lock. " + e2.getLocalizedMessage());
        }
        return z2;
    }
}

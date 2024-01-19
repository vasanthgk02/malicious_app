package com.userexperior.services.recording;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.userexperior.e.h;
import com.userexperior.utilities.b;
import com.userexperior.utilities.l;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;

public class a extends TimerTask {

    /* renamed from: c  reason: collision with root package name */
    public static final String f4106c = a.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public int f4107a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4108b;

    /* renamed from: d  reason: collision with root package name */
    public Activity f4109d;

    /* renamed from: e  reason: collision with root package name */
    public final Messenger f4110e;

    /* renamed from: f  reason: collision with root package name */
    public final Messenger f4111f;
    public int g = 1;
    public final Semaphore h;
    public final Options i = new Options();

    public a(Activity activity, Messenger messenger, Messenger messenger2) {
        this.f4110e = messenger;
        this.f4111f = messenger2;
        a(activity);
        this.g = l.p(com.userexperior.utilities.a.a());
        this.h = new Semaphore(1);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2) {
        if (i2 == 0) {
            if (this.g == 2) {
                Options options = this.i;
                options.inBitmap = h.a(options.inBitmap);
            }
            Bitmap bitmap = this.i.inBitmap;
            int i3 = this.f4107a;
            try {
                if (this.f4110e != null) {
                    try {
                        Messenger messenger = this.f4110e;
                        Message obtain = Message.obtain();
                        obtain.what = 234567;
                        obtain.obj = bitmap;
                        obtain.arg1 = i3;
                        messenger.send(obtain);
                    } catch (DeadObjectException e2) {
                        Level level = Level.SEVERE;
                        b.a(level, "Error CST - saveBMP() -DeadObject- : " + e2.getMessage());
                    }
                }
            } catch (RemoteException e3) {
                Level level2 = Level.SEVERE;
                b.a(level2, "Error CST - saveBMP() -RemoteException- : " + e3.getMessage());
                e3.printStackTrace();
            } catch (Exception e4) {
                Level level3 = Level.SEVERE;
                b.a(level3, "Ex: CST - sBMP " + e4.getMessage());
                e4.printStackTrace();
            }
        }
    }

    public final void a(Activity activity) {
        this.f4109d = activity;
        if (activity != null) {
            new StringBuilder("UE : CP TASK -> setLatestActivity : ").append(activity.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ExcHandler: Error | Exception | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r8 = this;
            java.util.concurrent.Semaphore r0 = r8.h     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            r0.acquire()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            r1 = 1
            r0.setPriority(r1)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            android.os.Messenger r0 = r8.f4111f     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x00bf, Error | Exception | OutOfMemoryError -> 0x00bf }
            if (r0 == 0) goto L_0x003f
            android.os.Messenger r0 = r8.f4111f     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x00bf, Error | Exception | OutOfMemoryError -> 0x00bf }
            android.os.Message r2 = android.os.Message.obtain()     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x00bf, Error | Exception | OutOfMemoryError -> 0x00bf }
            r3 = 234119(0x39287, float:3.2807E-40)
            r2.what = r3     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x00bf, Error | Exception | OutOfMemoryError -> 0x00bf }
            int r3 = r8.f4107a     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x00bf, Error | Exception | OutOfMemoryError -> 0x00bf }
            r2.arg1 = r3     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x00bf, Error | Exception | OutOfMemoryError -> 0x00bf }
            r0.send(r2)     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x00bf, Error | Exception | OutOfMemoryError -> 0x00bf }
            goto L_0x003f
        L_0x0024:
            r0 = move-exception
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            java.lang.String r4 = "Error CST - updateTime(): "
            r3.<init>(r4)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            java.lang.String r4 = r0.getMessage()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            r3.append(r4)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            java.lang.String r3 = r3.toString()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            com.userexperior.utilities.b.a(r2, r3)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            r0.printStackTrace()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
        L_0x003f:
            boolean r0 = r8.f4108b     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            if (r0 != 0) goto L_0x00b5
            android.app.Activity r0 = r8.f4109d     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            android.view.Window r0 = r0.getWindow()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            android.view.View r0 = r0.getDecorView()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            android.view.View r0 = r0.getRootView()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            android.graphics.BitmapFactory$Options r2 = r8.i     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            int r3 = r0.getWidth()     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            int r3 = r3 / 4
            int r4 = r0.getHeight()     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            int r4 = r4 / 4
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r3, r4, r5)     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            r2.inBitmap = r3     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            r2 = 2
            int[] r2 = new int[r2]     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            r0.getLocationInWindow(r2)     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            android.graphics.Rect r3 = new android.graphics.Rect     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            r4 = 0
            r5 = r2[r4]     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            r6 = r2[r1]     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            r4 = r2[r4]     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            int r7 = r0.getWidth()     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            int r4 = r4 + r7
            r2 = r2[r1]     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            int r0 = r0.getHeight()     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            int r2 = r2 + r0
            r3.<init>(r5, r6, r4, r2)     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            r2 = 26
            if (r0 < r2) goto L_0x00b5
            android.app.Activity r0 = r8.f4109d     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            android.view.Window r0 = r0.getWindow()     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            android.graphics.BitmapFactory$Options r2 = r8.i     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            android.graphics.Bitmap r2 = r2.inBitmap     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            com.userexperior.services.recording.-$$Lambda$a$fVChwt2bMRCgXgWoKPkurYXyBGM r4 = new com.userexperior.services.recording.-$$Lambda$a$fVChwt2bMRCgXgWoKPkurYXyBGM     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            r4.<init>()     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            android.os.Handler r5 = new android.os.Handler     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            android.os.Looper r6 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            android.view.PixelCopy.request(r0, r3, r2, r4, r5)     // Catch:{ Exception -> 0x00b1, InternalError -> 0x00ac, OutOfMemoryError -> 0x00a7 }
            goto L_0x00b5
        L_0x00a7:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            goto L_0x00b5
        L_0x00ac:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            goto L_0x00b5
        L_0x00b1:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
        L_0x00b5:
            int r0 = r8.f4107a     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            int r0 = r0 + r1
            r8.f4107a = r0     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            java.util.concurrent.Semaphore r0 = r8.h     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
            r0.release()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x00bf }
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.services.recording.a.run():void");
    }
}

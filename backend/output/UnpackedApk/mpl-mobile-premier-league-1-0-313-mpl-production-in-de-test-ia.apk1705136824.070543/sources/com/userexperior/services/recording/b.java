package com.userexperior.services.recording;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.userexperior.utilities.a;
import com.userexperior.utilities.l;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;

public class b extends TimerTask {

    /* renamed from: c  reason: collision with root package name */
    public static final String f4112c = b.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public int f4113a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4114b;

    /* renamed from: d  reason: collision with root package name */
    public Activity f4115d;

    /* renamed from: e  reason: collision with root package name */
    public final Messenger f4116e;

    /* renamed from: f  reason: collision with root package name */
    public final Messenger f4117f;
    public int g = 1;
    public final Semaphore h;
    public final Options i = new Options();
    public final Options j = new Options();

    public b(Activity activity, Messenger messenger, Messenger messenger2) {
        this.f4116e = messenger;
        this.f4117f = messenger2;
        a(activity);
        this.g = l.p(a.a());
        this.h = new Semaphore(1);
    }

    private <T extends View> ArrayList<T> a(ViewGroup viewGroup, Class<T> cls) {
        ArrayList<T> arrayList = new ArrayList<>();
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                arrayList.addAll(a((ViewGroup) childAt, cls));
                if (!cls.isInstance(childAt)) {
                }
            } else if (!cls.isInstance(childAt)) {
            }
            arrayList.add(childAt);
        }
        return arrayList;
    }

    private <T extends View> ArrayList<T> a(ViewGroup viewGroup, String str) {
        try {
            return a(viewGroup, Class.forName(str));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private void a(Bitmap bitmap, int i2) {
        try {
            if (this.f4116e != null) {
                try {
                    this.f4116e.send(b(bitmap, i2));
                } catch (DeadObjectException e2) {
                    Level level = Level.SEVERE;
                    com.userexperior.utilities.b.a(level, "Error CST - saveBMP() -DeadObject- : " + e2.getMessage());
                }
            }
        } catch (RemoteException e3) {
            Level level2 = Level.SEVERE;
            com.userexperior.utilities.b.a(level2, "Error CST - saveBMP() -RemoteException- : " + e3.getMessage());
            e3.printStackTrace();
        } catch (Exception e4) {
            Level level3 = Level.SEVERE;
            com.userexperior.utilities.b.a(level3, "Ex: CST - sBMP " + e4.getMessage());
            e4.printStackTrace();
        }
    }

    public static Message b(Bitmap bitmap, int i2) {
        Message obtain = Message.obtain();
        obtain.what = 234567;
        obtain.obj = bitmap;
        obtain.arg1 = i2;
        return obtain;
    }

    private <T extends View> T b(ViewGroup viewGroup, String str) {
        ArrayList a2 = a(viewGroup, str);
        if (a2 == null || a2.isEmpty()) {
            return null;
        }
        return (View) a2.get(0);
    }

    public final void a(Activity activity) {
        this.f4115d = activity;
        if (activity != null) {
            new StringBuilder("UE : CP TASK -> setLatestActivity : ").append(activity.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[ExcHandler: Error | Exception | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r6 = this;
            java.util.concurrent.Semaphore r0 = r6.h     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            r0.acquire()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            r1 = 1
            r0.setPriority(r1)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            android.os.Messenger r0 = r6.f4117f     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x0119, Error | Exception | OutOfMemoryError -> 0x0119 }
            if (r0 == 0) goto L_0x003f
            android.os.Messenger r0 = r6.f4117f     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x0119, Error | Exception | OutOfMemoryError -> 0x0119 }
            android.os.Message r2 = android.os.Message.obtain()     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x0119, Error | Exception | OutOfMemoryError -> 0x0119 }
            r3 = 234119(0x39287, float:3.2807E-40)
            r2.what = r3     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x0119, Error | Exception | OutOfMemoryError -> 0x0119 }
            int r3 = r6.f4113a     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x0119, Error | Exception | OutOfMemoryError -> 0x0119 }
            r2.arg1 = r3     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x0119, Error | Exception | OutOfMemoryError -> 0x0119 }
            r0.send(r2)     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x0119, Error | Exception | OutOfMemoryError -> 0x0119 }
            goto L_0x003f
        L_0x0024:
            r0 = move-exception
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            java.lang.String r4 = "Error CST - updateTime(): "
            r3.<init>(r4)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            java.lang.String r4 = r0.getMessage()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            r3.append(r4)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            java.lang.String r3 = r3.toString()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            com.userexperior.utilities.b.a(r2, r3)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            r0.printStackTrace()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
        L_0x003f:
            boolean r0 = r6.f4114b     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            if (r0 != 0) goto L_0x010f
            android.app.Activity r0 = r6.f4115d     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            android.view.Window r0 = r0.getWindow()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            android.view.View r0 = r0.getDecorView()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            android.view.View r0 = r0.getRootView()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            java.lang.String r2 = "io.flutter.view.FlutterView"
            java.lang.String r3 = "io.flutter.embedding.android.FlutterView"
            r4 = r0
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            android.view.View r2 = r6.b(r4, r2)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            android.view.View r0 = r6.b(r0, r3)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            if (r2 == 0) goto L_0x00b2
            android.view.SurfaceView r2 = (android.view.SurfaceView) r2     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            android.app.Activity r0 = r6.f4115d     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            if (r0 == 0) goto L_0x010f
            r2.refreshDrawableState()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            android.graphics.BitmapFactory$Options r0 = r6.j     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            int r3 = r2.getWidth()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            int r3 = r3 / 4
            int r4 = r2.getHeight()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            int r4 = r4 / 4
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r3, r4, r5)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            r0.inBitmap = r3     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            r3 = 24
            if (r0 < r3) goto L_0x00a8
            android.os.HandlerThread r0 = new android.os.HandlerThread     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            java.lang.String r3 = "PixelCopier"
            r0.<init>(r3)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            r0.start()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            android.graphics.BitmapFactory$Options r3 = r6.j     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            android.graphics.Bitmap r3 = r3.inBitmap     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            com.userexperior.services.recording.b$2 r4 = new com.userexperior.services.recording.b$2     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            r4.<init>(r0)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            android.os.Handler r5 = new android.os.Handler     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            android.os.Looper r0 = r0.getLooper()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            r5.<init>(r0)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            android.view.PixelCopy.request(r2, r3, r4, r5)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
        L_0x00a8:
            android.graphics.BitmapFactory$Options r0 = r6.j     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            android.graphics.Bitmap r0 = r0.inBitmap     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            int r2 = r6.f4113a     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            r6.a(r0, r2)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            goto L_0x010f
        L_0x00b2:
            if (r0 == 0) goto L_0x010f
            android.app.Activity r2 = r6.f4115d     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            com.userexperior.services.recording.b$1 r3 = new com.userexperior.services.recording.b$1     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            r2.runOnUiThread(r3)     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            android.graphics.BitmapFactory$Options r0 = r6.i     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            android.graphics.Bitmap r0 = r0.inBitmap     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            if (r0 != 0) goto L_0x00c5
            goto L_0x010f
        L_0x00c5:
            android.graphics.BitmapFactory$Options r0 = r6.i     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            android.graphics.BitmapFactory$Options r2 = r6.i     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            android.graphics.Bitmap r2 = r2.inBitmap     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            android.graphics.BitmapFactory$Options r3 = r6.i     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            android.graphics.Bitmap r3 = r3.inBitmap     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            int r3 = r3.getWidth()     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            int r3 = r3 / 4
            android.graphics.BitmapFactory$Options r4 = r6.i     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            android.graphics.Bitmap r4 = r4.inBitmap     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            int r4 = r4.getHeight()     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            int r4 = r4 / 4
            r5 = 0
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createScaledBitmap(r2, r3, r4, r5)     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            r0.inBitmap = r2     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            int r0 = r6.g     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            r2 = 2
            if (r0 != r2) goto L_0x00f7
            android.graphics.BitmapFactory$Options r0 = r6.i     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            android.graphics.BitmapFactory$Options r2 = r6.i     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            android.graphics.Bitmap r2 = r2.inBitmap     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            android.graphics.Bitmap r2 = com.userexperior.e.h.a(r2)     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            r0.inBitmap = r2     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
        L_0x00f7:
            android.graphics.BitmapFactory$Options r0 = r6.i     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            android.graphics.Bitmap r0 = r0.inBitmap     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            int r2 = r6.f4113a     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            r6.a(r0, r2)     // Catch:{ Exception -> 0x010b, OutOfMemoryError -> 0x0106, InternalError -> 0x0101 }
            goto L_0x010f
        L_0x0101:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            goto L_0x010f
        L_0x0106:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            goto L_0x010f
        L_0x010b:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
        L_0x010f:
            int r0 = r6.f4113a     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            int r0 = r0 + r1
            r6.f4113a = r0     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            java.util.concurrent.Semaphore r0 = r6.h     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
            r0.release()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0119 }
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.services.recording.b.run():void");
    }
}

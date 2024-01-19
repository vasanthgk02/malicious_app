package io.hansel.visualizer.c;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.PixelCopy.OnPixelCopyFinishedListener;
import android.view.Window;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.userjourney.prompts.j0;

public class b {

    public class a implements OnPixelCopyFinishedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f5781a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap f5782b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Window f5783c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HandlerThread f5784d;

        public a(b bVar, c cVar, Bitmap bitmap, Window window, HandlerThread handlerThread) {
            this.f5781a = cVar;
            this.f5782b = bitmap;
            this.f5783c = window;
            this.f5784d = handlerThread;
        }

        public void onPixelCopyFinished(int i) {
            if (i == 0) {
                this.f5781a.a(this.f5782b);
            } else {
                this.f5781a.a("Couldn't create bitmap of the SurfaceView", this.f5783c);
            }
            this.f5784d.interrupt();
        }
    }

    public void a(Activity activity, c cVar) {
        Window window = activity.getWindow();
        j0 c2 = new j0().c(activity);
        Bitmap createBitmap = Bitmap.createBitmap(c2.d(), c2.c(), Config.ARGB_8888);
        HandlerThread handlerThread = new HandlerThread(b.class.getSimpleName());
        handlerThread.start();
        if (VERSION.SDK_INT >= 26) {
            a aVar = new a(this, cVar, createBitmap, window, handlerThread);
            PixelCopy.request(window, createBitmap, aVar, new Handler(handlerThread.getLooper()));
            return;
        }
        try {
            cVar.a("Android version below O", window);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Error in handling PixelCopy result during screen capture for Android N and below", LogGroup.PT);
        }
    }
}

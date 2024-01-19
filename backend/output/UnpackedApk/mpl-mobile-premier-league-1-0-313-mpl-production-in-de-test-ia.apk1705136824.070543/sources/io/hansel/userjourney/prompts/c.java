package io.hansel.userjourney.prompts;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;

public class c implements OnScrollChangedListener, OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public final io.hansel.segments.a f5492a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f5493b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f5494c = new a();

    /* renamed from: d  reason: collision with root package name */
    public boolean f5495d = false;

    /* renamed from: e  reason: collision with root package name */
    public long f5496e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5497f = false;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            c.this.f5497f = false;
            c.this.a();
        }
    }

    public c(io.hansel.segments.a aVar) {
        this.f5492a = aVar;
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f5492a.a();
    }

    private void a(String str) {
        try {
            if (this.f5495d && this.f5492a != null) {
                HSLLogger.d(str, LogGroup.PT);
                this.f5492a.b();
                b();
            }
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Screen scroll not handled ");
            outline73.append(e2.toString());
            HSLLogger.d(outline73.toString());
        }
    }

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f5496e < 100) {
            this.f5493b.removeCallbacks(this.f5494c);
            this.f5493b.postDelayed(this.f5494c, 100);
        }
        if (!this.f5497f) {
            this.f5497f = true;
            this.f5493b.postDelayed(this.f5494c, 100);
        }
        this.f5496e = currentTimeMillis;
    }

    public void a(Activity activity) {
        if (!this.f5495d) {
            this.f5495d = true;
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().getRootView();
            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this);
            viewGroup.getViewTreeObserver().addOnScrollChangedListener(this);
            HSLLogger.d("Activity tracking started");
        }
    }

    public void b(Activity activity) {
        this.f5495d = false;
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().getRootView();
        viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        viewGroup.getViewTreeObserver().removeOnScrollChangedListener(this);
        HSLLogger.d("Activity tracking stopped");
    }

    public void onGlobalLayout() {
        a((String) "Layout changed.");
    }

    public void onScrollChanged() {
        a((String) "Screen scrolled.");
    }
}

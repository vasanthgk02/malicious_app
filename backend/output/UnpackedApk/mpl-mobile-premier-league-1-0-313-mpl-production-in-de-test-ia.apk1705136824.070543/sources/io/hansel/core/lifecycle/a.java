package io.hansel.core.lifecycle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.logger.HSLLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@TargetApi(14)
public abstract class a implements ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<WeakReference<Activity>> f5174a;

    /* renamed from: b  reason: collision with root package name */
    public final List<WeakReference<Activity>> f5175b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5176c = true;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f5177d = Boolean.FALSE;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5178e = false;

    /* renamed from: io.hansel.core.lifecycle.a$a  reason: collision with other inner class name */
    public class C0075a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f5179a;

        public C0075a(Activity activity) {
            this.f5179a = activity;
        }

        public void run() {
            a.this.a(this.f5179a);
        }
    }

    public a() {
        ArrayList<WeakReference<Activity>> arrayList = new ArrayList<>();
        this.f5174a = arrayList;
        this.f5175b = Collections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: private */
    public void a(Activity activity) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("onActivityResumedInternal method invoked with activity ");
        outline73.append(activity != null ? activity.getLocalClassName() : "null");
        HSLLogger.d(outline73.toString());
        b(activity.getLocalClassName());
        if (this.f5176c) {
            this.f5176c = false;
            a(this.f5177d);
            b();
            this.f5177d = Boolean.FALSE;
        } else {
            HSLLogger.d("onActivityResumedInternal method: isInBackground is false.");
        }
        if (this.f5178e) {
            HSLLogger.d("onActivityResumedInternal method: isRotate is true.");
            d();
            this.f5178e = false;
            return;
        }
        c(activity.getLocalClassName());
    }

    public static <T> boolean a(ArrayList<WeakReference<T>> arrayList, T t) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).get() == t) {
                arrayList.remove(i);
                return true;
            }
        }
        return false;
    }

    public void a() {
    }

    public abstract void a(Boolean bool);

    public abstract void a(String str);

    public void b() {
    }

    public abstract void b(String str);

    public abstract void c(String str);

    public boolean c() {
        return this.f5176c;
    }

    public abstract void d();

    public abstract void d(String str);

    public Activity e() {
        if (this.f5175b.isEmpty()) {
            return null;
        }
        for (int size = this.f5175b.size() - 1; size >= 0; size--) {
            Activity activity = (Activity) this.f5175b.get(size).get();
            if (activity != null) {
                return activity;
            }
        }
        return null;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("onActivityCreated method invoked with activity ");
        outline73.append(activity != null ? activity.getLocalClassName() : "null");
        HSLLogger.d(outline73.toString());
        if (bundle != null) {
            this.f5178e = bundle.getBoolean("HanselSaveInstanceState", false);
            bundle.remove("HanselSaveInstanceState");
        } else {
            HSLLogger.d("onActivityCreated: savedInstanceState is null.");
        }
        if (this.f5174a.size() == 0) {
            this.f5177d = Boolean.TRUE;
        }
        this.f5174a.add(new WeakReference(activity));
    }

    public void onActivityDestroyed(Activity activity) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("onActivityDestroyed method invoked with activity ");
        outline73.append(activity != null ? activity.getLocalClassName() : "null");
        HSLLogger.d(outline73.toString());
        String localClassName = activity.getLocalClassName();
        a(this.f5174a, (T) activity);
        d(localClassName);
    }

    public void onActivityPaused(Activity activity) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("onActivityPaused method invoked with activity ");
        outline73.append(activity != null ? activity.getLocalClassName() : "null");
        HSLLogger.d(outline73.toString());
        a(activity.getClass().getSimpleName());
    }

    public void onActivityResumed(Activity activity) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("onActivityResumed method invoked with activity ");
        outline73.append(activity != null ? activity.getLocalClassName() : "null");
        HSLLogger.d(outline73.toString());
        ((ViewGroup) activity.getWindow().getDecorView().getRootView()).post(new C0075a(activity));
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("onActivitySaveInstanceState method invoked with activity ");
        outline73.append(activity != null ? activity.getLocalClassName() : "null");
        HSLLogger.d(outline73.toString());
        bundle.putBoolean("HanselSaveInstanceState", true);
    }

    public void onActivityStarted(Activity activity) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("onActivityStarted method invoked with activity ");
        outline73.append(activity != null ? activity.getLocalClassName() : "null");
        HSLLogger.d(outline73.toString());
    }

    public void onActivityStopped(Activity activity) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("onActivityStopped method invoked with activity ");
        outline73.append(activity != null ? activity.getLocalClassName() : "null");
        HSLLogger.d(outline73.toString());
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        HSLLogger.d("onTrimMemory method invoked.");
        if (i == 20 || i == 80) {
            this.f5176c = true;
            a();
        }
    }
}

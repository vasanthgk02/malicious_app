package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.facebook.appevents.codeless.internal.SensitiveUserDataUtils;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.suggestedevents.ViewOnClickListener.Companion;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/appevents/suggestedevents/ViewObserver;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "isTracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "uiThreadHandler", "Landroid/os/Handler;", "onGlobalLayout", "", "process", "startTracking", "stopTracking", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ViewObserver.kt */
public final class ViewObserver implements OnGlobalLayoutListener {
    public static final ViewObserver Companion = null;
    public static final Map<Integer, ViewObserver> observers = new HashMap();
    public final WeakReference<Activity> activityWeakReference;
    public final AtomicBoolean isTracking = new AtomicBoolean(false);
    public final Handler uiThreadHandler = new Handler(Looper.getMainLooper());

    public ViewObserver(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this.activityWeakReference = new WeakReference<>(activity);
    }

    public static final /* synthetic */ Map access$getObservers$cp() {
        if (CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            return null;
        }
        try {
            return observers;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewObserver.class);
            return null;
        }
    }

    /* renamed from: process$lambda-0  reason: not valid java name */
    public static final void m185process$lambda0(ViewObserver viewObserver) {
        if (!CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            try {
                Intrinsics.checkNotNullParameter(viewObserver, "this$0");
                try {
                    View rootView = AppEventUtility.getRootView((Activity) viewObserver.activityWeakReference.get());
                    Activity activity = (Activity) viewObserver.activityWeakReference.get();
                    if (rootView != null) {
                        if (activity != null) {
                            SuggestedEventViewHierarchy suggestedEventViewHierarchy = SuggestedEventViewHierarchy.INSTANCE;
                            for (View next : SuggestedEventViewHierarchy.getAllClickableViews(rootView)) {
                                if (!SensitiveUserDataUtils.isSensitiveUserData(next)) {
                                    SuggestedEventViewHierarchy suggestedEventViewHierarchy2 = SuggestedEventViewHierarchy.INSTANCE;
                                    String textOfViewRecursively = SuggestedEventViewHierarchy.getTextOfViewRecursively(next);
                                    if ((textOfViewRecursively.length() > 0) && textOfViewRecursively.length() <= 300) {
                                        Companion companion = ViewOnClickListener.Companion;
                                        String localClassName = activity.getLocalClassName();
                                        Intrinsics.checkNotNullExpressionValue(localClassName, "activity.localClassName");
                                        companion.attachListener$facebook_core_release(next, rootView, localClassName);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ViewObserver.class);
            }
        }
    }

    public static final void startTrackingActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        int hashCode = activity.hashCode();
        Map access$getObservers$cp = access$getObservers$cp();
        Integer valueOf = Integer.valueOf(hashCode);
        Object obj = access$getObservers$cp.get(valueOf);
        if (obj == null) {
            obj = new ViewObserver(activity, null);
            access$getObservers$cp.put(valueOf, obj);
        }
        ViewObserver viewObserver = (ViewObserver) obj;
        if (!CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            try {
                if (!CrashShieldHandler.isObjectCrashing(viewObserver)) {
                    if (!viewObserver.isTracking.getAndSet(true)) {
                        View rootView = AppEventUtility.getRootView((Activity) viewObserver.activityWeakReference.get());
                        if (rootView != null) {
                            ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                            if (viewTreeObserver.isAlive()) {
                                viewTreeObserver.addOnGlobalLayoutListener(viewObserver);
                                viewObserver.process();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ViewObserver.class);
            }
        }
    }

    public static final void stopTrackingActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ViewObserver viewObserver = (ViewObserver) access$getObservers$cp().remove(Integer.valueOf(activity.hashCode()));
        if (viewObserver != null && !CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            try {
                if (!CrashShieldHandler.isObjectCrashing(viewObserver)) {
                    if (viewObserver.isTracking.getAndSet(false)) {
                        View rootView = AppEventUtility.getRootView((Activity) viewObserver.activityWeakReference.get());
                        if (rootView != null) {
                            ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                            if (viewTreeObserver.isAlive()) {
                                viewTreeObserver.removeOnGlobalLayoutListener(viewObserver);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ViewObserver.class);
            }
        }
    }

    public void onGlobalLayout() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                process();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void process() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                $$Lambda$nUCensw0nSAvmui3ddkjIj25lYc r0 = new Runnable() {
                    public final void run() {
                        ViewObserver.m185process$lambda0(ViewObserver.this);
                    }
                };
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    m185process$lambda0(ViewObserver.this);
                } else {
                    this.uiThreadHandler.post(r0);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}

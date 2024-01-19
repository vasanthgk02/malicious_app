package com.netcore.android;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.netcore.android.inapp.c;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.utility.g;
import com.userexperior.models.recording.enums.UeCustomType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 22\u00020\u0001:\u00012B\t\b\u0002¢\u0006\u0004\b0\u00101J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\nJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0015\u0010\u0013R,\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u001bR&\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u001dj\b\u0012\u0004\u0012\u00020\u0010`\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001e\u0010)\u001a\n &*\u0004\u0018\u00010%0%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010#¨\u00063"}, d2 = {"Lcom/netcore/android/SMTActivityLifecycleCallback;", "", "Landroid/app/Application;", "application", "", "register$smartech_release", "(Landroid/app/Application;)V", "register", "", "isAppInForeground", "()Z", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getActivity", "()Ljava/lang/ref/WeakReference;", "isLifeCycleCallbackRegistered", "Lcom/netcore/android/f/a;", "listener", "setLifeCycleListener$smartech_release", "(Lcom/netcore/android/f/a;)V", "setLifeCycleListener", "removeLifeCycleListener$smartech_release", "removeLifeCycleListener", "e", "Ljava/lang/ref/WeakReference;", "getCurrentActivity", "setCurrentActivity", "(Ljava/lang/ref/WeakReference;)V", "currentActivity", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "lifeCycleListeners", "d", "Z", "isAppRegisteredForLifecycleCallback", "", "kotlin.jvm.PlatformType", "a", "Ljava/lang/String;", "TAG", "", "b", "I", "activityReferences", "c", "isActivityChangingConfigurations", "<init>", "()V", "Companion", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTActivityLifecycleCallback.kt */
public final class SMTActivityLifecycleCallback {
    public static final Companion Companion = new Companion(null);
    public static volatile SMTActivityLifecycleCallback g;

    /* renamed from: a  reason: collision with root package name */
    public final String f987a;

    /* renamed from: b  reason: collision with root package name */
    public int f988b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f989c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f990d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Activity> f991e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<com.netcore.android.f.a> f992f;

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/netcore/android/SMTActivityLifecycleCallback$Companion;", "", "Lcom/netcore/android/SMTActivityLifecycleCallback;", "buildInstance", "()Lcom/netcore/android/SMTActivityLifecycleCallback;", "getInstance", "instance", "Lcom/netcore/android/SMTActivityLifecycleCallback;", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTActivityLifecycleCallback.kt */
    public static final class Companion {
        public Companion() {
        }

        private final SMTActivityLifecycleCallback buildInstance() {
            return new SMTActivityLifecycleCallback(null);
        }

        public final synchronized SMTActivityLifecycleCallback getInstance() {
            SMTActivityLifecycleCallback access$getInstance$cp;
            SMTActivityLifecycleCallback access$getInstance$cp2;
            access$getInstance$cp = SMTActivityLifecycleCallback.g;
            if (access$getInstance$cp == null) {
                synchronized (SMTActivityLifecycleCallback.class) {
                    access$getInstance$cp2 = SMTActivityLifecycleCallback.g;
                    if (access$getInstance$cp2 == null) {
                        access$getInstance$cp2 = SMTActivityLifecycleCallback.Companion.buildInstance();
                        SMTActivityLifecycleCallback.g = access$getInstance$cp2;
                    }
                }
                access$getInstance$cp = access$getInstance$cp2;
            }
            return access$getInstance$cp;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SMTActivityLifecycleCallback.kt */
    public static final class a implements ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SMTActivityLifecycleCallback f993a;

        public a(SMTActivityLifecycleCallback sMTActivityLifecycleCallback) {
            this.f993a = sMTActivityLifecycleCallback;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            c.g.b().b();
        }

        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Smartech.Companion.getInstance(new WeakReference(activity.getApplicationContext())).onAppForegroundStateChanged$smartech_release(false);
        }

        public void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.f993a.setCurrentActivity(new WeakReference(activity));
            Smartech.Companion.getInstance(new WeakReference(activity.getApplicationContext())).onAppForegroundStateChanged$smartech_release(true);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String access$getTAG$p = this.f993a.f987a;
            Intrinsics.checkNotNullExpressionValue(access$getTAG$p, UeCustomType.TAG);
            sMTLogger.v(access$getTAG$p, "Lifecycle callback - Activity Started");
            SMTActivityLifecycleCallback sMTActivityLifecycleCallback = this.f993a;
            sMTActivityLifecycleCallback.f988b = sMTActivityLifecycleCallback.f988b + 1;
            if (this.f993a.f988b == 1 && !this.f993a.f989c) {
                Smartech.Companion.getInstance(new WeakReference(activity.getApplicationContext())).onAppForeground();
                g.f1302f.b(new WeakReference(activity.getApplicationContext())).a(true);
                for (com.netcore.android.f.a a2 : this.f993a.f992f) {
                    a2.a();
                }
            }
            this.f993a.f989c = false;
        }

        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String access$getTAG$p = this.f993a.f987a;
            Intrinsics.checkNotNullExpressionValue(access$getTAG$p, UeCustomType.TAG);
            sMTLogger.v(access$getTAG$p, "Lifecycle callback - Activity Stopped");
            SMTActivityLifecycleCallback sMTActivityLifecycleCallback = this.f993a;
            boolean z = true;
            if (!activity.isChangingConfigurations()) {
                z = false;
            }
            sMTActivityLifecycleCallback.f989c = z;
            if (this.f993a.f988b > 0) {
                SMTActivityLifecycleCallback sMTActivityLifecycleCallback2 = this.f993a;
                sMTActivityLifecycleCallback2.f988b = sMTActivityLifecycleCallback2.f988b - 1;
            }
            if (this.f993a.f988b == 0 && !this.f993a.f989c) {
                Smartech.Companion.getInstance(new WeakReference(activity.getApplicationContext())).onAppBackground();
                g.f1302f.b(new WeakReference(activity.getApplicationContext())).a(false);
                this.f993a.setCurrentActivity(null);
                String access$getTAG$p2 = this.f993a.f987a;
                Intrinsics.checkNotNullExpressionValue(access$getTAG$p2, UeCustomType.TAG);
                sMTLogger.v(access$getTAG$p2, "Lifecycle callback - App is in background");
                for (com.netcore.android.f.a c2 : this.f993a.f992f) {
                    c2.c();
                }
            }
        }
    }

    public SMTActivityLifecycleCallback() {
        this.f987a = SMTActivityLifecycleCallback.class.getSimpleName();
        this.f992f = new ArrayList<>();
    }

    public static final synchronized SMTActivityLifecycleCallback getInstance() {
        SMTActivityLifecycleCallback instance;
        synchronized (SMTActivityLifecycleCallback.class) {
            instance = Companion.getInstance();
        }
        return instance;
    }

    public final WeakReference<Activity> getActivity() {
        return this.f991e;
    }

    public final WeakReference<Activity> getCurrentActivity() {
        return this.f991e;
    }

    public final boolean isAppInForeground() {
        return this.f988b > 0;
    }

    public final boolean isLifeCycleCallbackRegistered() {
        return this.f990d;
    }

    public final void register$smartech_release(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        if (this.f990d) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f987a;
            Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
            sMTLogger.v(str, "Lifecycle callbacks have already been registered");
            return;
        }
        this.f990d = true;
        application.registerActivityLifecycleCallbacks(new a(this));
        SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
        String str2 = this.f987a;
        Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
        sMTLogger2.i(str2, "Activity Lifecycle Callback successfully registered");
    }

    public final void removeLifeCycleListener$smartech_release(com.netcore.android.f.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "listener");
        this.f992f.remove(aVar);
    }

    public final void setCurrentActivity(WeakReference<Activity> weakReference) {
        this.f991e = weakReference;
    }

    public final void setLifeCycleListener$smartech_release(com.netcore.android.f.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "listener");
        this.f992f.add(aVar);
    }

    public /* synthetic */ SMTActivityLifecycleCallback(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

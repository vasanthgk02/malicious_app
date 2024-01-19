package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.window.core.Version;
import androidx.window.layout.ExtensionInterfaceCompat.ExtensionCallbackInterface;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarInterface.SidecarCallback;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 !2\u00020\u0001:\u0005!\"#$%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0007\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0016\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020 H\u0017R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/window/layout/SidecarCompat;", "Landroidx/window/layout/ExtensionInterfaceCompat;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sidecar", "Landroidx/window/sidecar/SidecarInterface;", "sidecarAdapter", "Landroidx/window/layout/SidecarAdapter;", "(Landroidx/window/sidecar/SidecarInterface;Landroidx/window/layout/SidecarAdapter;)V", "componentCallbackMap", "", "Landroid/app/Activity;", "Landroid/content/ComponentCallbacks;", "extensionCallback", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "getSidecar", "()Landroidx/window/sidecar/SidecarInterface;", "windowListenerRegisteredContexts", "Landroid/os/IBinder;", "getWindowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "activity", "onWindowLayoutChangeListenerAdded", "", "onWindowLayoutChangeListenerRemoved", "register", "windowToken", "registerConfigurationChangeListener", "setExtensionCallback", "unregisterComponentCallback", "validateExtensionInterface", "", "Companion", "DistinctElementCallback", "DistinctSidecarElementCallback", "FirstAttachAdapter", "TranslatingCallback", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SidecarCompat.kt */
public final class SidecarCompat implements ExtensionInterfaceCompat {
    public final Map<Activity, ComponentCallbacks> componentCallbackMap = new LinkedHashMap();
    public ExtensionCallbackInterface extensionCallback;
    public final SidecarInterface sidecar;
    public final SidecarAdapter sidecarAdapter;
    public final Map<IBinder, Activity> windowListenerRegisteredContexts = new LinkedHashMap();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0007H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctElementCallback;", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "callbackInterface", "(Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;)V", "activityWindowLayoutInfo", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "Landroidx/window/layout/WindowLayoutInfo;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "onWindowLayoutChanged", "", "activity", "newLayout", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SidecarCompat.kt */
    public static final class DistinctElementCallback implements ExtensionCallbackInterface {
        public final WeakHashMap<Activity, WindowLayoutInfo> activityWindowLayoutInfo = new WeakHashMap<>();
        public final ExtensionCallbackInterface callbackInterface;
        public final ReentrantLock lock = new ReentrantLock();

        public DistinctElementCallback(ExtensionCallbackInterface extensionCallbackInterface) {
            Intrinsics.checkNotNullParameter(extensionCallbackInterface, "callbackInterface");
            this.callbackInterface = extensionCallbackInterface;
        }

        public void onWindowLayoutChanged(Activity activity, WindowLayoutInfo windowLayoutInfo) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(windowLayoutInfo, "newLayout");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (!Intrinsics.areEqual(windowLayoutInfo, this.activityWindowLayoutInfo.get(activity))) {
                    WindowLayoutInfo put = this.activityWindowLayoutInfo.put(activity, windowLayoutInfo);
                    reentrantLock.unlock();
                    this.callbackInterface.onWindowLayoutChanged(activity, windowLayoutInfo);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctSidecarElementCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "sidecarAdapter", "Landroidx/window/layout/SidecarAdapter;", "callbackInterface", "(Landroidx/window/layout/SidecarAdapter;Landroidx/window/sidecar/SidecarInterface$SidecarCallback;)V", "lastDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "mActivityWindowLayoutInfo", "Ljava/util/WeakHashMap;", "Landroid/os/IBinder;", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "onDeviceStateChanged", "", "newDeviceState", "onWindowLayoutChanged", "token", "newLayout", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SidecarCompat.kt */
    public static final class DistinctSidecarElementCallback implements SidecarCallback {
        public final SidecarCallback callbackInterface;
        public SidecarDeviceState lastDeviceState;
        public final ReentrantLock lock = new ReentrantLock();
        public final WeakHashMap<IBinder, SidecarWindowLayoutInfo> mActivityWindowLayoutInfo = new WeakHashMap<>();
        public final SidecarAdapter sidecarAdapter;

        public DistinctSidecarElementCallback(SidecarAdapter sidecarAdapter2, SidecarCallback sidecarCallback) {
            Intrinsics.checkNotNullParameter(sidecarAdapter2, "sidecarAdapter");
            Intrinsics.checkNotNullParameter(sidecarCallback, "callbackInterface");
            this.sidecarAdapter = sidecarAdapter2;
            this.callbackInterface = sidecarCallback;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
            if (androidx.window.layout.SidecarAdapter.getSidecarDevicePosture$window_release(r2) == androidx.window.layout.SidecarAdapter.getSidecarDevicePosture$window_release(r5)) goto L_0x0027;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onDeviceStateChanged(androidx.window.sidecar.SidecarDeviceState r5) {
            /*
                r4 = this;
                java.lang.String r0 = "newDeviceState"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.util.concurrent.locks.ReentrantLock r0 = r4.lock
                r0.lock()
                androidx.window.layout.SidecarAdapter r1 = r4.sidecarAdapter     // Catch:{ all -> 0x003a }
                androidx.window.sidecar.SidecarDeviceState r2 = r4.lastDeviceState     // Catch:{ all -> 0x003a }
                if (r1 == 0) goto L_0x0038
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r5)     // Catch:{ all -> 0x003a }
                r3 = 1
                if (r1 == 0) goto L_0x0018
                goto L_0x0027
            L_0x0018:
                if (r2 != 0) goto L_0x001b
                goto L_0x0026
            L_0x001b:
                int r1 = androidx.window.layout.SidecarAdapter.getSidecarDevicePosture$window_release(r2)     // Catch:{ all -> 0x003a }
                int r2 = androidx.window.layout.SidecarAdapter.getSidecarDevicePosture$window_release(r5)     // Catch:{ all -> 0x003a }
                if (r1 != r2) goto L_0x0026
                goto L_0x0027
            L_0x0026:
                r3 = 0
            L_0x0027:
                if (r3 == 0) goto L_0x002d
                r0.unlock()
                return
            L_0x002d:
                r4.lastDeviceState = r5     // Catch:{ all -> 0x003a }
                androidx.window.sidecar.SidecarInterface$SidecarCallback r1 = r4.callbackInterface     // Catch:{ all -> 0x003a }
                r1.onDeviceStateChanged(r5)     // Catch:{ all -> 0x003a }
                r0.unlock()
                return
            L_0x0038:
                r5 = 0
                throw r5     // Catch:{ all -> 0x003a }
            L_0x003a:
                r5 = move-exception
                r0.unlock()
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarCompat.DistinctSidecarElementCallback.onDeviceStateChanged(androidx.window.sidecar.SidecarDeviceState):void");
        }

        public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            Intrinsics.checkNotNullParameter(iBinder, "token");
            Intrinsics.checkNotNullParameter(sidecarWindowLayoutInfo, "newLayout");
            synchronized (this.lock) {
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo2 = this.mActivityWindowLayoutInfo.get(iBinder);
                SidecarAdapter sidecarAdapter2 = this.sidecarAdapter;
                if (sidecarAdapter2 != null) {
                    if (!(Intrinsics.areEqual(sidecarWindowLayoutInfo2, sidecarWindowLayoutInfo) ? true : sidecarWindowLayoutInfo2 == null ? false : sidecarAdapter2.isEqualSidecarDisplayFeatures(SidecarAdapter.getSidecarDisplayFeatures(sidecarWindowLayoutInfo2), SidecarAdapter.getSidecarDisplayFeatures(sidecarWindowLayoutInfo)))) {
                        SidecarWindowLayoutInfo put = this.mActivityWindowLayoutInfo.put(iBinder, sidecarWindowLayoutInfo);
                        this.callbackInterface.onWindowLayoutChanged(iBinder, sidecarWindowLayoutInfo);
                        return;
                    }
                    return;
                }
                throw null;
            }
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u00050\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/window/layout/SidecarCompat$FirstAttachAdapter;", "Landroid/view/View$OnAttachStateChangeListener;", "sidecarCompat", "Landroidx/window/layout/SidecarCompat;", "activity", "Landroid/app/Activity;", "(Landroidx/window/layout/SidecarCompat;Landroid/app/Activity;)V", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onViewAttachedToWindow", "", "view", "Landroid/view/View;", "onViewDetachedFromWindow", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SidecarCompat.kt */
    public static final class FirstAttachAdapter implements OnAttachStateChangeListener {
        public final WeakReference<Activity> activityWeakReference;
        public final SidecarCompat sidecarCompat;

        public FirstAttachAdapter(SidecarCompat sidecarCompat2, Activity activity) {
            Intrinsics.checkNotNullParameter(sidecarCompat2, "sidecarCompat");
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.sidecarCompat = sidecarCompat2;
            this.activityWeakReference = new WeakReference<>(activity);
        }

        public void onViewAttachedToWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = (Activity) this.activityWeakReference.get();
            IBinder iBinder = null;
            if (activity != null) {
                Window window = activity.getWindow();
                if (window != null) {
                    LayoutParams attributes = window.getAttributes();
                    if (attributes != null) {
                        iBinder = attributes.token;
                    }
                }
            }
            if (activity != null && iBinder != null) {
                this.sidecarCompat.register(iBinder, activity);
            }
        }

        public void onViewDetachedFromWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017¨\u0006\f"}, d2 = {"Landroidx/window/layout/SidecarCompat$TranslatingCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "(Landroidx/window/layout/SidecarCompat;)V", "onDeviceStateChanged", "", "newDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "onWindowLayoutChanged", "windowToken", "Landroid/os/IBinder;", "newLayout", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SidecarCompat.kt */
    public final class TranslatingCallback implements SidecarCallback {
        public final /* synthetic */ SidecarCompat this$0;

        public TranslatingCallback(SidecarCompat sidecarCompat) {
            Intrinsics.checkNotNullParameter(sidecarCompat, "this$0");
            this.this$0 = sidecarCompat;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0013 A[SYNTHETIC] */
        @android.annotation.SuppressLint({"SyntheticAccessor"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onDeviceStateChanged(androidx.window.sidecar.SidecarDeviceState r7) {
            /*
                r6 = this;
                java.lang.String r0 = "newDeviceState"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                androidx.window.layout.SidecarCompat r0 = r6.this$0
                java.util.Map<android.os.IBinder, android.app.Activity> r0 = r0.windowListenerRegisteredContexts
                java.util.Collection r0 = r0.values()
                androidx.window.layout.SidecarCompat r1 = r6.this$0
                java.util.Iterator r0 = r0.iterator()
            L_0x0013:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x004f
                java.lang.Object r2 = r0.next()
                android.app.Activity r2 = (android.app.Activity) r2
                r3 = 0
                if (r2 != 0) goto L_0x0023
                goto L_0x0030
            L_0x0023:
                android.view.Window r4 = r2.getWindow()
                if (r4 != 0) goto L_0x002a
                goto L_0x0030
            L_0x002a:
                android.view.WindowManager$LayoutParams r4 = r4.getAttributes()
                if (r4 != 0) goto L_0x0032
            L_0x0030:
                r4 = r3
                goto L_0x0034
            L_0x0032:
                android.os.IBinder r4 = r4.token
            L_0x0034:
                if (r4 != 0) goto L_0x0037
                goto L_0x0040
            L_0x0037:
                androidx.window.sidecar.SidecarInterface r5 = r1.sidecar
                if (r5 != 0) goto L_0x003c
                goto L_0x0040
            L_0x003c:
                androidx.window.sidecar.SidecarWindowLayoutInfo r3 = r5.getWindowLayoutInfo(r4)
            L_0x0040:
                androidx.window.layout.ExtensionInterfaceCompat$ExtensionCallbackInterface r4 = r1.extensionCallback
                if (r4 != 0) goto L_0x0045
                goto L_0x0013
            L_0x0045:
                androidx.window.layout.SidecarAdapter r5 = r1.sidecarAdapter
                androidx.window.layout.WindowLayoutInfo r3 = r5.translate(r3, r7)
                r4.onWindowLayoutChanged(r2, r3)
                goto L_0x0013
            L_0x004f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarCompat.TranslatingCallback.onDeviceStateChanged(androidx.window.sidecar.SidecarDeviceState):void");
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            SidecarDeviceState sidecarDeviceState;
            Intrinsics.checkNotNullParameter(iBinder, "windowToken");
            Intrinsics.checkNotNullParameter(sidecarWindowLayoutInfo, "newLayout");
            Activity activity = this.this$0.windowListenerRegisteredContexts.get(iBinder);
            if (activity != null) {
                SidecarCompat sidecarCompat = this.this$0;
                SidecarAdapter sidecarAdapter = sidecarCompat.sidecarAdapter;
                SidecarInterface sidecarInterface = sidecarCompat.sidecar;
                if (sidecarInterface == null) {
                    sidecarDeviceState = null;
                } else {
                    sidecarDeviceState = sidecarInterface.getDeviceState();
                }
                if (sidecarDeviceState == null) {
                    sidecarDeviceState = new SidecarDeviceState();
                }
                WindowLayoutInfo translate = sidecarAdapter.translate(sidecarWindowLayoutInfo, sidecarDeviceState);
                ExtensionCallbackInterface extensionCallbackInterface = this.this$0.extensionCallback;
                if (extensionCallbackInterface != null) {
                    extensionCallbackInterface.onWindowLayoutChanged(activity, translate);
                }
            }
        }
    }

    public SidecarCompat(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SidecarInterface sidecarCompat$window_release = getSidecarCompat$window_release(context);
        SidecarAdapter sidecarAdapter2 = new SidecarAdapter(null, 1);
        Intrinsics.checkNotNullParameter(sidecarAdapter2, "sidecarAdapter");
        this.sidecar = sidecarCompat$window_release;
        this.sidecarAdapter = sidecarAdapter2;
    }

    public static final SidecarInterface getSidecarCompat$window_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SidecarProvider.getSidecarImpl(context.getApplicationContext());
    }

    public static final Version getSidecarVersion() {
        try {
            String apiVersion = SidecarProvider.getApiVersion();
            if (!TextUtils.isEmpty(apiVersion)) {
                return Version.Companion.parse(apiVersion);
            }
            return null;
        } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.window.layout.WindowLayoutInfo getWindowLayoutInfo(android.app.Activity r4) {
        /*
            r3 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.view.Window r4 = r4.getWindow()
            r0 = 0
            if (r4 != 0) goto L_0x000d
            goto L_0x0013
        L_0x000d:
            android.view.WindowManager$LayoutParams r4 = r4.getAttributes()
            if (r4 != 0) goto L_0x0015
        L_0x0013:
            r4 = r0
            goto L_0x0017
        L_0x0015:
            android.os.IBinder r4 = r4.token
        L_0x0017:
            if (r4 != 0) goto L_0x0021
            androidx.window.layout.WindowLayoutInfo r4 = new androidx.window.layout.WindowLayoutInfo
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE
            r4.<init>(r0)
            return r4
        L_0x0021:
            androidx.window.sidecar.SidecarInterface r1 = r3.sidecar
            if (r1 != 0) goto L_0x0027
            r4 = r0
            goto L_0x002b
        L_0x0027:
            androidx.window.sidecar.SidecarWindowLayoutInfo r4 = r1.getWindowLayoutInfo(r4)
        L_0x002b:
            androidx.window.layout.SidecarAdapter r1 = r3.sidecarAdapter
            androidx.window.sidecar.SidecarInterface r2 = r3.sidecar
            if (r2 != 0) goto L_0x0032
            goto L_0x0036
        L_0x0032:
            androidx.window.sidecar.SidecarDeviceState r0 = r2.getDeviceState()
        L_0x0036:
            if (r0 != 0) goto L_0x003d
            androidx.window.sidecar.SidecarDeviceState r0 = new androidx.window.sidecar.SidecarDeviceState
            r0.<init>()
        L_0x003d:
            androidx.window.layout.WindowLayoutInfo r4 = r1.translate(r4, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarCompat.getWindowLayoutInfo(android.app.Activity):androidx.window.layout.WindowLayoutInfo");
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onWindowLayoutChangeListenerAdded(android.app.Activity r2) {
        /*
            r1 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            android.view.Window r0 = r2.getWindow()
            if (r0 != 0) goto L_0x000c
            goto L_0x0012
        L_0x000c:
            android.view.WindowManager$LayoutParams r0 = r0.getAttributes()
            if (r0 != 0) goto L_0x0014
        L_0x0012:
            r0 = 0
            goto L_0x0016
        L_0x0014:
            android.os.IBinder r0 = r0.token
        L_0x0016:
            if (r0 == 0) goto L_0x001c
            r1.register(r0, r2)
            goto L_0x002c
        L_0x001c:
            androidx.window.layout.SidecarCompat$FirstAttachAdapter r0 = new androidx.window.layout.SidecarCompat$FirstAttachAdapter
            r0.<init>(r1, r2)
            android.view.Window r2 = r2.getWindow()
            android.view.View r2 = r2.getDecorView()
            r2.addOnAttachStateChangeListener(r0)
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarCompat.onWindowLayoutChangeListenerAdded(android.app.Activity):void");
    }

    public void onWindowLayoutChangeListenerRemoved(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        IBinder iBinder = null;
        Window window = activity.getWindow();
        if (window != null) {
            LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                iBinder = attributes.token;
            }
        }
        if (iBinder != null) {
            SidecarInterface sidecarInterface = this.sidecar;
            if (sidecarInterface != null) {
                sidecarInterface.onWindowLayoutChangeListenerRemoved(iBinder);
            }
            activity.unregisterComponentCallbacks(this.componentCallbackMap.get(activity));
            this.componentCallbackMap.remove(activity);
            boolean z = this.windowListenerRegisteredContexts.size() == 1;
            this.windowListenerRegisteredContexts.remove(iBinder);
            if (z) {
                SidecarInterface sidecarInterface2 = this.sidecar;
                if (sidecarInterface2 != null) {
                    sidecarInterface2.onDeviceStateListenersChanged(true);
                }
            }
        }
    }

    public final void register(IBinder iBinder, Activity activity) {
        Intrinsics.checkNotNullParameter(iBinder, "windowToken");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.windowListenerRegisteredContexts.put(iBinder, activity);
        SidecarInterface sidecarInterface = this.sidecar;
        if (sidecarInterface != null) {
            sidecarInterface.onWindowLayoutChangeListenerAdded(iBinder);
        }
        if (this.windowListenerRegisteredContexts.size() == 1) {
            SidecarInterface sidecarInterface2 = this.sidecar;
            if (sidecarInterface2 != null) {
                sidecarInterface2.onDeviceStateListenersChanged(false);
            }
        }
        ExtensionCallbackInterface extensionCallbackInterface = this.extensionCallback;
        if (extensionCallbackInterface != null) {
            extensionCallbackInterface.onWindowLayoutChanged(activity, getWindowLayoutInfo(activity));
        }
        if (this.componentCallbackMap.get(activity) == null) {
            SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1 sidecarCompat$registerConfigurationChangeListener$configChangeObserver$1 = new SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1(this, activity);
            this.componentCallbackMap.put(activity, sidecarCompat$registerConfigurationChangeListener$configChangeObserver$1);
            activity.registerComponentCallbacks(sidecarCompat$registerConfigurationChangeListener$configChangeObserver$1);
        }
    }

    public void setExtensionCallback(ExtensionCallbackInterface extensionCallbackInterface) {
        Intrinsics.checkNotNullParameter(extensionCallbackInterface, "extensionCallback");
        this.extensionCallback = new DistinctElementCallback(extensionCallbackInterface);
        SidecarInterface sidecarInterface = this.sidecar;
        if (sidecarInterface != null) {
            sidecarInterface.setSidecarCallback(new DistinctSidecarElementCallback(this.sidecarAdapter, new TranslatingCallback(this)));
        }
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [int] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:58|59|60|61|69|70|71|72|73|(2:75|(2:77|97)(2:78|79))(2:80|81)) */
    /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
        return true;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x0112 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0057 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0059 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0065 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0080 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0082 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008e A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a9 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00aa A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b6 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0141 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0152 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x016a A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0176 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0182 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x018e A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    @android.annotation.SuppressLint({"BanUncheckedReflection"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean validateExtensionInterface() {
        /*
            r8 = this;
            r0 = 1
            r1 = 0
            androidx.window.sidecar.SidecarInterface r2 = r8.sidecar     // Catch:{ all -> 0x019a }
            r3 = 0
            if (r2 != 0) goto L_0x0009
        L_0x0007:
            r2 = r3
            goto L_0x001c
        L_0x0009:
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x019a }
            if (r2 != 0) goto L_0x0010
            goto L_0x0007
        L_0x0010:
            java.lang.String r4 = "setSidecarCallback"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ all -> 0x019a }
            java.lang.Class<androidx.window.sidecar.SidecarInterface$SidecarCallback> r6 = androidx.window.sidecar.SidecarInterface.SidecarCallback.class
            r5[r1] = r6     // Catch:{ all -> 0x019a }
            java.lang.reflect.Method r2 = r2.getMethod(r4, r5)     // Catch:{ all -> 0x019a }
        L_0x001c:
            if (r2 != 0) goto L_0x0020
            r2 = r3
            goto L_0x0024
        L_0x0020:
            java.lang.Class r2 = r2.getReturnType()     // Catch:{ all -> 0x019a }
        L_0x0024:
            java.lang.Class r4 = java.lang.Void.TYPE     // Catch:{ all -> 0x019a }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)     // Catch:{ all -> 0x019a }
            if (r4 == 0) goto L_0x018e
            androidx.window.sidecar.SidecarInterface r2 = r8.sidecar     // Catch:{ all -> 0x019a }
            if (r2 != 0) goto L_0x0031
            goto L_0x0034
        L_0x0031:
            r2.getDeviceState()     // Catch:{ all -> 0x019a }
        L_0x0034:
            androidx.window.sidecar.SidecarInterface r2 = r8.sidecar     // Catch:{ all -> 0x019a }
            if (r2 != 0) goto L_0x0039
            goto L_0x003c
        L_0x0039:
            r2.onDeviceStateListenersChanged(r0)     // Catch:{ all -> 0x019a }
        L_0x003c:
            androidx.window.sidecar.SidecarInterface r2 = r8.sidecar     // Catch:{ all -> 0x019a }
            if (r2 != 0) goto L_0x0042
        L_0x0040:
            r2 = r3
            goto L_0x0055
        L_0x0042:
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x019a }
            if (r2 != 0) goto L_0x0049
            goto L_0x0040
        L_0x0049:
            java.lang.String r4 = "getWindowLayoutInfo"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ all -> 0x019a }
            java.lang.Class<android.os.IBinder> r6 = android.os.IBinder.class
            r5[r1] = r6     // Catch:{ all -> 0x019a }
            java.lang.reflect.Method r2 = r2.getMethod(r4, r5)     // Catch:{ all -> 0x019a }
        L_0x0055:
            if (r2 != 0) goto L_0x0059
            r2 = r3
            goto L_0x005d
        L_0x0059:
            java.lang.Class r2 = r2.getReturnType()     // Catch:{ all -> 0x019a }
        L_0x005d:
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r4 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)     // Catch:{ all -> 0x019a }
            if (r4 == 0) goto L_0x0182
            androidx.window.sidecar.SidecarInterface r2 = r8.sidecar     // Catch:{ all -> 0x019a }
            if (r2 != 0) goto L_0x006b
        L_0x0069:
            r2 = r3
            goto L_0x007e
        L_0x006b:
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x019a }
            if (r2 != 0) goto L_0x0072
            goto L_0x0069
        L_0x0072:
            java.lang.String r4 = "onWindowLayoutChangeListenerAdded"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ all -> 0x019a }
            java.lang.Class<android.os.IBinder> r6 = android.os.IBinder.class
            r5[r1] = r6     // Catch:{ all -> 0x019a }
            java.lang.reflect.Method r2 = r2.getMethod(r4, r5)     // Catch:{ all -> 0x019a }
        L_0x007e:
            if (r2 != 0) goto L_0x0082
            r2 = r3
            goto L_0x0086
        L_0x0082:
            java.lang.Class r2 = r2.getReturnType()     // Catch:{ all -> 0x019a }
        L_0x0086:
            java.lang.Class r4 = java.lang.Void.TYPE     // Catch:{ all -> 0x019a }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)     // Catch:{ all -> 0x019a }
            if (r4 == 0) goto L_0x0176
            androidx.window.sidecar.SidecarInterface r2 = r8.sidecar     // Catch:{ all -> 0x019a }
            if (r2 != 0) goto L_0x0094
        L_0x0092:
            r2 = r3
            goto L_0x00a7
        L_0x0094:
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x019a }
            if (r2 != 0) goto L_0x009b
            goto L_0x0092
        L_0x009b:
            java.lang.String r4 = "onWindowLayoutChangeListenerRemoved"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ all -> 0x019a }
            java.lang.Class<android.os.IBinder> r6 = android.os.IBinder.class
            r5[r1] = r6     // Catch:{ all -> 0x019a }
            java.lang.reflect.Method r2 = r2.getMethod(r4, r5)     // Catch:{ all -> 0x019a }
        L_0x00a7:
            if (r2 != 0) goto L_0x00aa
            goto L_0x00ae
        L_0x00aa:
            java.lang.Class r3 = r2.getReturnType()     // Catch:{ all -> 0x019a }
        L_0x00ae:
            java.lang.Class r2 = java.lang.Void.TYPE     // Catch:{ all -> 0x019a }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r2)     // Catch:{ all -> 0x019a }
            if (r2 == 0) goto L_0x016a
            androidx.window.sidecar.SidecarDeviceState r2 = new androidx.window.sidecar.SidecarDeviceState     // Catch:{ all -> 0x019a }
            r2.<init>()     // Catch:{ all -> 0x019a }
            r3 = 3
            r2.posture = r3     // Catch:{ NoSuchFieldError -> 0x00bf }
            goto L_0x00f2
        L_0x00bf:
            java.lang.Class<androidx.window.sidecar.SidecarDeviceState> r4 = androidx.window.sidecar.SidecarDeviceState.class
            java.lang.String r5 = "setPosture"
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x019a }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ all -> 0x019a }
            r6[r1] = r7     // Catch:{ all -> 0x019a }
            java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch:{ all -> 0x019a }
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ all -> 0x019a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x019a }
            r5[r1] = r6     // Catch:{ all -> 0x019a }
            r4.invoke(r2, r5)     // Catch:{ all -> 0x019a }
            java.lang.Class<androidx.window.sidecar.SidecarDeviceState> r4 = androidx.window.sidecar.SidecarDeviceState.class
            java.lang.String r5 = "getPosture"
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ all -> 0x019a }
            java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch:{ all -> 0x019a }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x019a }
            java.lang.Object r2 = r4.invoke(r2, r5)     // Catch:{ all -> 0x019a }
            if (r2 == 0) goto L_0x0162
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x019a }
            int r2 = r2.intValue()     // Catch:{ all -> 0x019a }
            if (r2 != r3) goto L_0x015a
        L_0x00f2:
            androidx.window.sidecar.SidecarDisplayFeature r2 = new androidx.window.sidecar.SidecarDisplayFeature     // Catch:{ all -> 0x019a }
            r2.<init>()     // Catch:{ all -> 0x019a }
            android.graphics.Rect r3 = r2.getRect()     // Catch:{ all -> 0x019a }
            java.lang.String r4 = "displayFeature.rect"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ all -> 0x019a }
            r2.setRect(r3)     // Catch:{ all -> 0x019a }
            r2.getType()     // Catch:{ all -> 0x019a }
            r2.setType(r0)     // Catch:{ all -> 0x019a }
            androidx.window.sidecar.SidecarWindowLayoutInfo r3 = new androidx.window.sidecar.SidecarWindowLayoutInfo     // Catch:{ all -> 0x019a }
            r3.<init>()     // Catch:{ all -> 0x019a }
            java.util.List r1 = r3.displayFeatures     // Catch:{ NoSuchFieldError -> 0x0112 }
            goto L_0x019b
        L_0x0112:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x019a }
            r4.<init>()     // Catch:{ all -> 0x019a }
            r4.add(r2)     // Catch:{ all -> 0x019a }
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r2 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            java.lang.String r5 = "setDisplayFeatures"
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x019a }
            java.lang.Class<java.util.List> r7 = java.util.List.class
            r6[r1] = r7     // Catch:{ all -> 0x019a }
            java.lang.reflect.Method r2 = r2.getMethod(r5, r6)     // Catch:{ all -> 0x019a }
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ all -> 0x019a }
            r5[r1] = r4     // Catch:{ all -> 0x019a }
            r2.invoke(r3, r5)     // Catch:{ all -> 0x019a }
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r2 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            java.lang.String r5 = "getDisplayFeatures"
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ all -> 0x019a }
            java.lang.reflect.Method r2 = r2.getMethod(r5, r6)     // Catch:{ all -> 0x019a }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x019a }
            java.lang.Object r2 = r2.invoke(r3, r5)     // Catch:{ all -> 0x019a }
            if (r2 == 0) goto L_0x0152
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x019a }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r2)     // Catch:{ all -> 0x019a }
            if (r2 == 0) goto L_0x014a
            goto L_0x019b
        L_0x014a:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x019a }
            java.lang.String r2 = "Invalid display feature getter/setter"
            r0.<init>(r2)     // Catch:{ all -> 0x019a }
            throw r0     // Catch:{ all -> 0x019a }
        L_0x0152:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x019a }
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>"
            r0.<init>(r2)     // Catch:{ all -> 0x019a }
            throw r0     // Catch:{ all -> 0x019a }
        L_0x015a:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x019a }
            java.lang.String r2 = "Invalid device posture getter/setter"
            r0.<init>(r2)     // Catch:{ all -> 0x019a }
            throw r0     // Catch:{ all -> 0x019a }
        L_0x0162:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x019a }
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r2)     // Catch:{ all -> 0x019a }
            throw r0     // Catch:{ all -> 0x019a }
        L_0x016a:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x019a }
            java.lang.String r2 = "Illegal return type for 'onWindowLayoutChangeListenerRemoved': "
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)     // Catch:{ all -> 0x019a }
            r0.<init>(r2)     // Catch:{ all -> 0x019a }
            throw r0     // Catch:{ all -> 0x019a }
        L_0x0176:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x019a }
            java.lang.String r3 = "Illegal return type for 'onWindowLayoutChangeListenerAdded': "
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r2)     // Catch:{ all -> 0x019a }
            r0.<init>(r2)     // Catch:{ all -> 0x019a }
            throw r0     // Catch:{ all -> 0x019a }
        L_0x0182:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x019a }
            java.lang.String r3 = "Illegal return type for 'getWindowLayoutInfo': "
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r2)     // Catch:{ all -> 0x019a }
            r0.<init>(r2)     // Catch:{ all -> 0x019a }
            throw r0     // Catch:{ all -> 0x019a }
        L_0x018e:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x019a }
            java.lang.String r3 = "Illegal return type for 'setSidecarCallback': "
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r2)     // Catch:{ all -> 0x019a }
            r0.<init>(r2)     // Catch:{ all -> 0x019a }
            throw r0     // Catch:{ all -> 0x019a }
        L_0x019a:
            r0 = 0
        L_0x019b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarCompat.validateExtensionInterface():boolean");
    }
}

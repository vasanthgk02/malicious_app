package com.facebook.appevents.aam;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import android.widget.EditText;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/facebook/appevents/aam/MetadataViewObserver;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "isTracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "processedText", "", "", "uiThreadHandler", "Landroid/os/Handler;", "onGlobalFocusChanged", "", "oldView", "Landroid/view/View;", "newView", "process", "view", "processEditText", "runOnUIThread", "runnable", "Ljava/lang/Runnable;", "startTracking", "stopTracking", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: MetadataViewObserver.kt */
public final class MetadataViewObserver implements OnGlobalFocusChangeListener {
    public static final Companion Companion = new Companion(null);
    public static final Map<Integer, MetadataViewObserver> observers = new HashMap();
    public final WeakReference<Activity> activityWeakReference;
    public final AtomicBoolean isTracking;
    public final Set<String> processedText = new LinkedHashSet();
    public final Handler uiThreadHandler = new Handler(Looper.getMainLooper());

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J,\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/aam/MetadataViewObserver$Companion;", "", "()V", "MAX_TEXT_LENGTH", "", "observers", "", "Lcom/facebook/appevents/aam/MetadataViewObserver;", "preNormalize", "", "key", "value", "putUserData", "", "userData", "startTrackingActivity", "activity", "Landroid/app/Activity;", "stopTrackingActivity", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: MetadataViewObserver.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
            if (r5.equals("r5") == false) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
            if (r5.equals("r4") == false) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
            r6 = new kotlin.text.Regex((java.lang.String) "[^a-z]+").replace(r6, "");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final void access$putUserData(com.facebook.appevents.aam.MetadataViewObserver.Companion r3, java.util.Map r4, java.lang.String r5, java.lang.String r6) {
            /*
                int r3 = r5.hashCode()
                r0 = 2
                r1 = 0
                switch(r3) {
                    case 3585: goto L_0x005b;
                    case 3586: goto L_0x0044;
                    case 3587: goto L_0x003b;
                    case 3588: goto L_0x000b;
                    default: goto L_0x0009;
                }
            L_0x0009:
                goto L_0x0081
            L_0x000b:
                java.lang.String r3 = "r6"
                boolean r3 = r5.equals(r3)
                if (r3 != 0) goto L_0x0015
                goto L_0x0081
            L_0x0015:
                java.lang.String r3 = "-"
                boolean r0 = kotlin.text.CharsKt__CharKt.contains$default(r6, r3, r1, r0)
                if (r0 == 0) goto L_0x0081
                kotlin.text.Regex r0 = new kotlin.text.Regex
                r0.<init>(r3)
                java.util.List r3 = r0.split(r6, r1)
                java.lang.String[] r6 = new java.lang.String[r1]
                java.lang.Object[] r3 = r3.toArray(r6)
                if (r3 == 0) goto L_0x0033
                java.lang.String[] r3 = (java.lang.String[]) r3
                r6 = r3[r1]
                goto L_0x0081
            L_0x0033:
                java.lang.NullPointerException r3 = new java.lang.NullPointerException
                java.lang.String r4 = "null cannot be cast to non-null type kotlin.Array<T>"
                r3.<init>(r4)
                throw r3
            L_0x003b:
                java.lang.String r3 = "r5"
                boolean r3 = r5.equals(r3)
                if (r3 != 0) goto L_0x004d
                goto L_0x0081
            L_0x0044:
                java.lang.String r3 = "r4"
                boolean r3 = r5.equals(r3)
                if (r3 != 0) goto L_0x004d
                goto L_0x0081
            L_0x004d:
                kotlin.text.Regex r3 = new kotlin.text.Regex
                java.lang.String r0 = "[^a-z]+"
                r3.<init>(r0)
                java.lang.String r0 = ""
                java.lang.String r6 = r3.replace(r6, r0)
                goto L_0x0081
            L_0x005b:
                java.lang.String r3 = "r3"
                boolean r3 = r5.equals(r3)
                if (r3 != 0) goto L_0x0064
                goto L_0x0081
            L_0x0064:
                java.lang.String r3 = "m"
                boolean r2 = kotlin.text.CharsKt__CharKt.startsWith$default(r6, r3, r1, r0)
                if (r2 != 0) goto L_0x0080
                java.lang.String r2 = "b"
                boolean r2 = kotlin.text.CharsKt__CharKt.startsWith$default(r6, r2, r1, r0)
                if (r2 != 0) goto L_0x0080
                java.lang.String r2 = "ge"
                boolean r6 = kotlin.text.CharsKt__CharKt.startsWith$default(r6, r2, r1, r0)
                if (r6 == 0) goto L_0x007d
                goto L_0x0080
            L_0x007d:
                java.lang.String r6 = "f"
                goto L_0x0081
            L_0x0080:
                r6 = r3
            L_0x0081:
                r4.put(r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.aam.MetadataViewObserver.Companion.access$putUserData(com.facebook.appevents.aam.MetadataViewObserver$Companion, java.util.Map, java.lang.String, java.lang.String):void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x003a A[SYNTHETIC, Splitter:B:12:0x003a] */
        /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void startTrackingActivity(android.app.Activity r5) {
            /*
                r4 = this;
                java.lang.String r0 = "activity"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                int r0 = r5.hashCode()
                java.lang.Class<com.facebook.appevents.aam.MetadataViewObserver> r1 = com.facebook.appevents.aam.MetadataViewObserver.class
                boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)
                r2 = 0
                if (r1 == 0) goto L_0x0013
                goto L_0x001c
            L_0x0013:
                java.util.Map<java.lang.Integer, com.facebook.appevents.aam.MetadataViewObserver> r1 = com.facebook.appevents.aam.MetadataViewObserver.observers     // Catch:{ all -> 0x0016 }
                goto L_0x001d
            L_0x0016:
                r1 = move-exception
                java.lang.Class<com.facebook.appevents.aam.MetadataViewObserver> r3 = com.facebook.appevents.aam.MetadataViewObserver.class
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r3)
            L_0x001c:
                r1 = r2
            L_0x001d:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                java.lang.Object r3 = r1.get(r0)
                if (r3 != 0) goto L_0x002f
                com.facebook.appevents.aam.MetadataViewObserver r3 = new com.facebook.appevents.aam.MetadataViewObserver
                r3.<init>(r5, r2)
                r1.put(r0, r3)
            L_0x002f:
                com.facebook.appevents.aam.MetadataViewObserver r3 = (com.facebook.appevents.aam.MetadataViewObserver) r3
                java.lang.Class<com.facebook.appevents.aam.MetadataViewObserver> r5 = com.facebook.appevents.aam.MetadataViewObserver.class
                boolean r5 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r5)
                if (r5 == 0) goto L_0x003a
                goto L_0x0073
            L_0x003a:
                boolean r5 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r3)     // Catch:{ all -> 0x006d }
                if (r5 == 0) goto L_0x0041
                goto L_0x0073
            L_0x0041:
                java.util.concurrent.atomic.AtomicBoolean r5 = r3.isTracking     // Catch:{ all -> 0x0068 }
                r0 = 1
                boolean r5 = r5.getAndSet(r0)     // Catch:{ all -> 0x0068 }
                if (r5 == 0) goto L_0x004b
                goto L_0x0073
            L_0x004b:
                java.lang.ref.WeakReference<android.app.Activity> r5 = r3.activityWeakReference     // Catch:{ all -> 0x0068 }
                java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x0068 }
                android.app.Activity r5 = (android.app.Activity) r5     // Catch:{ all -> 0x0068 }
                android.view.View r5 = com.facebook.appevents.internal.AppEventUtility.getRootView(r5)     // Catch:{ all -> 0x0068 }
                if (r5 != 0) goto L_0x005a
                goto L_0x0073
            L_0x005a:
                android.view.ViewTreeObserver r5 = r5.getViewTreeObserver()     // Catch:{ all -> 0x0068 }
                boolean r0 = r5.isAlive()     // Catch:{ all -> 0x0068 }
                if (r0 == 0) goto L_0x0073
                r5.addOnGlobalFocusChangeListener(r3)     // Catch:{ all -> 0x0068 }
                goto L_0x0073
            L_0x0068:
                r5 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r5, r3)     // Catch:{ all -> 0x006d }
                goto L_0x0073
            L_0x006d:
                r5 = move-exception
                java.lang.Class<com.facebook.appevents.aam.MetadataViewObserver> r0 = com.facebook.appevents.aam.MetadataViewObserver.class
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r5, r0)
            L_0x0073:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.aam.MetadataViewObserver.Companion.startTrackingActivity(android.app.Activity):void");
        }
    }

    public MetadataViewObserver(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this.activityWeakReference = new WeakReference<>(activity);
        this.isTracking = new AtomicBoolean(false);
    }

    /* renamed from: process$lambda-0  reason: not valid java name */
    public static final void m156process$lambda0(View view, MetadataViewObserver metadataViewObserver) {
        if (!CrashShieldHandler.isObjectCrashing(MetadataViewObserver.class)) {
            try {
                Intrinsics.checkNotNullParameter(view, "$view");
                Intrinsics.checkNotNullParameter(metadataViewObserver, "this$0");
                if (view instanceof EditText) {
                    metadataViewObserver.processEditText(view);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, MetadataViewObserver.class);
            }
        }
    }

    public void onGlobalFocusChanged(View view, View view2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            if (view != null) {
                try {
                    process(view);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
            if (view2 != null) {
                process(view2);
            }
        }
    }

    public final void process(View view) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                $$Lambda$R4imKob1ZhJzclyp9KdknR79d24 r0 = new Runnable(view, this) {
                    public final /* synthetic */ View f$0;
                    public final /* synthetic */ MetadataViewObserver f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void run() {
                        MetadataViewObserver.m156process$lambda0(this.f$0, this.f$1);
                    }
                };
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        r0.run();
                    } else {
                        this.uiThreadHandler.post(r0);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x009f A[Catch:{ all -> 0x0094, all -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a1 A[Catch:{ all -> 0x0094, all -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4 A[Catch:{ all -> 0x0094, all -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d7 A[Catch:{ all -> 0x0094, all -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e2 A[Catch:{ all -> 0x0094, all -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ed A[Catch:{ all -> 0x0094, all -> 0x011c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void processEditText(android.view.View r12) {
        /*
            r11 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r11)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = r12
            android.widget.EditText r0 = (android.widget.EditText) r0     // Catch:{ all -> 0x011c }
            android.text.Editable r0 = r0.getText()     // Catch:{ all -> 0x011c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x011c }
            if (r0 == 0) goto L_0x0114
            java.lang.CharSequence r0 = kotlin.text.CharsKt__CharKt.trim(r0)     // Catch:{ all -> 0x011c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x011c }
            if (r0 == 0) goto L_0x010c
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ all -> 0x011c }
            java.lang.String r1 = "(this as java.lang.String).toLowerCase()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ all -> 0x011c }
            int r1 = r0.length()     // Catch:{ all -> 0x011c }
            if (r1 != 0) goto L_0x002f
            r1 = 1
            goto L_0x0030
        L_0x002f:
            r1 = 0
        L_0x0030:
            if (r1 != 0) goto L_0x010b
            java.util.Set<java.lang.String> r1 = r11.processedText     // Catch:{ all -> 0x011c }
            boolean r1 = r1.contains(r0)     // Catch:{ all -> 0x011c }
            if (r1 != 0) goto L_0x010b
            int r1 = r0.length()     // Catch:{ all -> 0x011c }
            r2 = 100
            if (r1 <= r2) goto L_0x0044
            goto L_0x010b
        L_0x0044:
            java.util.Set<java.lang.String> r1 = r11.processedText     // Catch:{ all -> 0x011c }
            r1.add(r0)     // Catch:{ all -> 0x011c }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x011c }
            r1.<init>()     // Catch:{ all -> 0x011c }
            java.util.List r2 = com.facebook.appevents.aam.MetadataMatcher.getCurrentViewIndicators(r12)     // Catch:{ all -> 0x011c }
            com.facebook.appevents.aam.MetadataRule r3 = com.facebook.appevents.aam.MetadataRule.Companion     // Catch:{ all -> 0x011c }
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ all -> 0x011c }
            java.util.Set r4 = com.facebook.appevents.aam.MetadataRule.access$getRules$cp()     // Catch:{ all -> 0x011c }
            r3.<init>(r4)     // Catch:{ all -> 0x011c }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x011c }
            r4 = 0
            r5 = r4
        L_0x0063:
            boolean r6 = r3.hasNext()     // Catch:{ all -> 0x011c }
            if (r6 == 0) goto L_0x0108
            java.lang.Object r6 = r3.next()     // Catch:{ all -> 0x011c }
            com.facebook.appevents.aam.MetadataRule r6 = (com.facebook.appevents.aam.MetadataRule) r6     // Catch:{ all -> 0x011c }
            java.lang.String r7 = r6.getName()     // Catch:{ all -> 0x011c }
            java.lang.String r8 = "r2"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r7)     // Catch:{ all -> 0x011c }
            if (r7 == 0) goto L_0x0089
            kotlin.text.Regex r7 = new kotlin.text.Regex     // Catch:{ all -> 0x011c }
            java.lang.String r8 = "[^\\d.]"
            r7.<init>(r8)     // Catch:{ all -> 0x011c }
            java.lang.String r8 = ""
            java.lang.String r7 = r7.replace(r0, r8)     // Catch:{ all -> 0x011c }
            goto L_0x008a
        L_0x0089:
            r7 = r0
        L_0x008a:
            boolean r8 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r6)     // Catch:{ all -> 0x011c }
            if (r8 == 0) goto L_0x0091
            goto L_0x0098
        L_0x0091:
            java.lang.String r8 = r6.valRule     // Catch:{ all -> 0x0094 }
            goto L_0x0099
        L_0x0094:
            r8 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r8, r6)     // Catch:{ all -> 0x011c }
        L_0x0098:
            r8 = r4
        L_0x0099:
            int r8 = r8.length()     // Catch:{ all -> 0x011c }
            if (r8 <= 0) goto L_0x00a1
            r8 = 1
            goto L_0x00a2
        L_0x00a1:
            r8 = 0
        L_0x00a2:
            if (r8 == 0) goto L_0x00d8
            boolean r8 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r6)     // Catch:{ all -> 0x011c }
            if (r8 == 0) goto L_0x00ab
            goto L_0x00b2
        L_0x00ab:
            java.lang.String r8 = r6.valRule     // Catch:{ all -> 0x00ae }
            goto L_0x00b3
        L_0x00ae:
            r8 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r8, r6)     // Catch:{ all -> 0x011c }
        L_0x00b2:
            r8 = r4
        L_0x00b3:
            java.lang.Class<com.facebook.appevents.aam.MetadataMatcher> r9 = com.facebook.appevents.aam.MetadataMatcher.class
            boolean r10 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r9)     // Catch:{ all -> 0x011c }
            if (r10 == 0) goto L_0x00bc
            goto L_0x00d4
        L_0x00bc:
            java.lang.String r10 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r10)     // Catch:{ all -> 0x00d0 }
            java.lang.String r10 = "rule"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r10)     // Catch:{ all -> 0x00d0 }
            kotlin.text.Regex r10 = new kotlin.text.Regex     // Catch:{ all -> 0x00d0 }
            r10.<init>(r8)     // Catch:{ all -> 0x00d0 }
            boolean r8 = r10.matches(r7)     // Catch:{ all -> 0x00d0 }
            goto L_0x00d5
        L_0x00d0:
            r8 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r8, r9)     // Catch:{ all -> 0x011c }
        L_0x00d4:
            r8 = 0
        L_0x00d5:
            if (r8 != 0) goto L_0x00d8
            goto L_0x0063
        L_0x00d8:
            java.util.List r8 = r6.getKeyRules()     // Catch:{ all -> 0x011c }
            boolean r8 = com.facebook.appevents.aam.MetadataMatcher.matchIndicator(r2, r8)     // Catch:{ all -> 0x011c }
            if (r8 == 0) goto L_0x00ed
            com.facebook.appevents.aam.MetadataViewObserver$Companion r8 = Companion     // Catch:{ all -> 0x011c }
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x011c }
            com.facebook.appevents.aam.MetadataViewObserver.Companion.access$putUserData(r8, r1, r6, r7)     // Catch:{ all -> 0x011c }
            goto L_0x0063
        L_0x00ed:
            if (r5 != 0) goto L_0x00f3
            java.util.List r5 = com.facebook.appevents.aam.MetadataMatcher.getAroundViewIndicators(r12)     // Catch:{ all -> 0x011c }
        L_0x00f3:
            java.util.List r8 = r6.getKeyRules()     // Catch:{ all -> 0x011c }
            boolean r8 = com.facebook.appevents.aam.MetadataMatcher.matchIndicator(r5, r8)     // Catch:{ all -> 0x011c }
            if (r8 == 0) goto L_0x0063
            com.facebook.appevents.aam.MetadataViewObserver$Companion r8 = Companion     // Catch:{ all -> 0x011c }
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x011c }
            com.facebook.appevents.aam.MetadataViewObserver.Companion.access$putUserData(r8, r1, r6, r7)     // Catch:{ all -> 0x011c }
            goto L_0x0063
        L_0x0108:
            com.facebook.appevents.InternalAppEventsLogger.setInternalUserData(r1)     // Catch:{ all -> 0x011c }
        L_0x010b:
            return
        L_0x010c:
            java.lang.NullPointerException r12 = new java.lang.NullPointerException     // Catch:{ all -> 0x011c }
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r12.<init>(r0)     // Catch:{ all -> 0x011c }
            throw r12     // Catch:{ all -> 0x011c }
        L_0x0114:
            java.lang.NullPointerException r12 = new java.lang.NullPointerException     // Catch:{ all -> 0x011c }
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.CharSequence"
            r12.<init>(r0)     // Catch:{ all -> 0x011c }
            throw r12     // Catch:{ all -> 0x011c }
        L_0x011c:
            r12 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r12, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.aam.MetadataViewObserver.processEditText(android.view.View):void");
    }
}

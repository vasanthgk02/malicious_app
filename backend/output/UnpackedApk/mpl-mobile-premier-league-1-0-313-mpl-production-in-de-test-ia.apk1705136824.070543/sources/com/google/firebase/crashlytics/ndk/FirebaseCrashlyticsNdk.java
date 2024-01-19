package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.crashlytics.internal.persistence.FileStore;

public class FirebaseCrashlyticsNdk implements CrashlyticsNativeComponent {
    public static FirebaseCrashlyticsNdk instance;
    public final CrashpadController controller;
    public String currentSessionId;
    public boolean installHandlerDuringPrepareSession;
    public SignalHandlerInstaller signalHandlerInstaller;

    public interface SignalHandlerInstaller {
        void installHandler();
    }

    public FirebaseCrashlyticsNdk(CrashpadController crashpadController, boolean z) {
        this.controller = crashpadController;
        this.installHandlerDuringPrepareSession = z;
    }

    public static FirebaseCrashlyticsNdk create(Context context, boolean z) {
        FirebaseCrashlyticsNdk firebaseCrashlyticsNdk = new FirebaseCrashlyticsNdk(new CrashpadController(context, new JniNativeApi(context), new FileStore(context)), z);
        instance = firebaseCrashlyticsNdk;
        return firebaseCrashlyticsNdk;
    }

    public static FirebaseCrashlyticsNdk getInstance() {
        FirebaseCrashlyticsNdk firebaseCrashlyticsNdk = instance;
        if (firebaseCrashlyticsNdk != null) {
            return firebaseCrashlyticsNdk;
        }
        throw new NullPointerException("FirebaseCrashlyticsNdk component is not present.");
    }

    public NativeSessionFileProvider getSessionFileProvider(String str) {
        return new SessionFilesProvider(this.controller.getFilesForSession(str));
    }

    public boolean hasCrashDataForCurrentSession() {
        String str = this.currentSessionId;
        return str != null && hasCrashDataForSession(str);
    }

    public boolean hasCrashDataForSession(String str) {
        return this.controller.hasCrashDataForSession(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void installSignalHandler() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.firebase.crashlytics.ndk.FirebaseCrashlyticsNdk$SignalHandlerInstaller r0 = r2.signalHandlerInstaller     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x000c
            com.google.firebase.crashlytics.ndk.FirebaseCrashlyticsNdk$SignalHandlerInstaller r0 = r2.signalHandlerInstaller     // Catch:{ all -> 0x0028 }
            r0.installHandler()     // Catch:{ all -> 0x0028 }
            monitor-exit(r2)
            return
        L_0x000c:
            boolean r0 = r2.installHandlerDuringPrepareSession     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x001a
            com.google.firebase.crashlytics.internal.Logger r0 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x0028 }
            java.lang.String r1 = "Native signal handler already installed; skipping re-install."
            r0.w(r1)     // Catch:{ all -> 0x0028 }
            goto L_0x0026
        L_0x001a:
            com.google.firebase.crashlytics.internal.Logger r0 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x0028 }
            java.lang.String r1 = "Deferring signal handler installation until the FirebaseCrashlyticsNdk session has been prepared"
            r0.d(r1)     // Catch:{ all -> 0x0028 }
            r0 = 1
            r2.installHandlerDuringPrepareSession = r0     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r2)
            return
        L_0x0028:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.ndk.FirebaseCrashlyticsNdk.installSignalHandler():void");
    }

    public /* synthetic */ void lambda$prepareNativeSession$0$FirebaseCrashlyticsNdk(String str, String str2, long j, StaticSessionData staticSessionData) {
        Logger logger = Logger.getLogger();
        logger.d("Initializing native session: " + str);
        if (!this.controller.initialize(str, str2, j, staticSessionData)) {
            Logger logger2 = Logger.getLogger();
            logger2.w("Failed to initialize Crashlytics NDK for session " + str);
        }
    }

    public synchronized void prepareNativeSession(String str, String str2, long j, StaticSessionData staticSessionData) {
        this.currentSessionId = str;
        $$Lambda$FirebaseCrashlyticsNdk$uWXEmlTQlEwiUIn6o2ZyerrhSEM r0 = new SignalHandlerInstaller(str, str2, j, staticSessionData) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ long f$3;
            public final /* synthetic */ StaticSessionData f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r6;
            }

            public final void installHandler() {
                FirebaseCrashlyticsNdk.this.lambda$prepareNativeSession$0$FirebaseCrashlyticsNdk(this.f$1, this.f$2, this.f$3, this.f$4);
            }
        };
        this.signalHandlerInstaller = r0;
        if (this.installHandlerDuringPrepareSession) {
            r0.installHandler();
        }
    }
}

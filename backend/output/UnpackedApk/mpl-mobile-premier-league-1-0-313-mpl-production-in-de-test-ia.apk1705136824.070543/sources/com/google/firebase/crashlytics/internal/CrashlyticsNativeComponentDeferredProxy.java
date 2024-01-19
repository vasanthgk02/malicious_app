package com.google.firebase.crashlytics.internal;

import com.google.firebase.components.OptionalProvider;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

public final class CrashlyticsNativeComponentDeferredProxy implements CrashlyticsNativeComponent {
    public static final NativeSessionFileProvider MISSING_NATIVE_SESSION_FILE_PROVIDER = new MissingNativeSessionFileProvider();
    public final AtomicReference<CrashlyticsNativeComponent> availableNativeComponent = new AtomicReference<>(null);
    public final Deferred<CrashlyticsNativeComponent> deferredNativeComponent;

    public static final class MissingNativeSessionFileProvider implements NativeSessionFileProvider {
        public MissingNativeSessionFileProvider() {
        }

        public File getAppFile() {
            return null;
        }

        public File getBinaryImagesFile() {
            return null;
        }

        public File getDeviceFile() {
            return null;
        }

        public File getMetadataFile() {
            return null;
        }

        public File getMinidumpFile() {
            return null;
        }

        public File getOsFile() {
            return null;
        }

        public File getSessionFile() {
            return null;
        }
    }

    public CrashlyticsNativeComponentDeferredProxy(Deferred<CrashlyticsNativeComponent> deferred) {
        this.deferredNativeComponent = deferred;
        ((OptionalProvider) deferred).whenAvailable(new DeferredHandler() {
            public final void handle(Provider provider) {
                CrashlyticsNativeComponentDeferredProxy.this.lambda$new$0$CrashlyticsNativeComponentDeferredProxy(provider);
            }
        });
    }

    public NativeSessionFileProvider getSessionFileProvider(String str) {
        CrashlyticsNativeComponent crashlyticsNativeComponent = this.availableNativeComponent.get();
        if (crashlyticsNativeComponent == null) {
            return MISSING_NATIVE_SESSION_FILE_PROVIDER;
        }
        return crashlyticsNativeComponent.getSessionFileProvider(str);
    }

    public boolean hasCrashDataForCurrentSession() {
        CrashlyticsNativeComponent crashlyticsNativeComponent = this.availableNativeComponent.get();
        return crashlyticsNativeComponent != null && crashlyticsNativeComponent.hasCrashDataForCurrentSession();
    }

    public boolean hasCrashDataForSession(String str) {
        CrashlyticsNativeComponent crashlyticsNativeComponent = this.availableNativeComponent.get();
        return crashlyticsNativeComponent != null && crashlyticsNativeComponent.hasCrashDataForSession(str);
    }

    public /* synthetic */ void lambda$new$0$CrashlyticsNativeComponentDeferredProxy(Provider provider) {
        Logger.getLogger().d("Crashlytics native component now available.");
        this.availableNativeComponent.set((CrashlyticsNativeComponent) provider.get());
    }

    public void prepareNativeSession(String str, String str2, long j, StaticSessionData staticSessionData) {
        Logger logger = Logger.getLogger();
        logger.v("Deferring native open session: " + str);
        Deferred<CrashlyticsNativeComponent> deferred = this.deferredNativeComponent;
        $$Lambda$CrashlyticsNativeComponentDeferredProxy$lNwtOK8UDFlAPI3wPnIK4eFWxec r1 = new DeferredHandler(str, str2, j, staticSessionData) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ String f$1;
            public final /* synthetic */ long f$2;
            public final /* synthetic */ StaticSessionData f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r5;
            }

            public final void handle(Provider provider) {
                ((CrashlyticsNativeComponent) provider.get()).prepareNativeSession(this.f$0, this.f$1, this.f$2, this.f$3);
            }
        };
        ((OptionalProvider) deferred).whenAvailable(r1);
    }
}

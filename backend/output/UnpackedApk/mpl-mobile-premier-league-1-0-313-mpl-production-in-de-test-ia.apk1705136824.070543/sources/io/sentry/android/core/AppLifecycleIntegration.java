package io.sentry.android.core;

import androidx.lifecycle.ProcessLifecycleOwner;
import io.sentry.IHub;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.util.MainThreadChecker;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.io.IOException;

public final class AppLifecycleIntegration implements Integration, Closeable {
    public final IHandler handler;
    public SentryAndroidOptions options;
    public LifecycleWatcher watcher;

    public AppLifecycleIntegration() {
        this(new MainLooperHandler());
    }

    /* access modifiers changed from: private */
    /* renamed from: addObserver */
    public void lambda$register$0$AppLifecycleIntegration(IHub iHub) {
        SentryAndroidOptions sentryAndroidOptions = this.options;
        if (sentryAndroidOptions != null) {
            LifecycleWatcher lifecycleWatcher = new LifecycleWatcher(iHub, sentryAndroidOptions.getSessionTrackingIntervalMillis(), this.options.isEnableAutoSessionTracking(), this.options.isEnableAppLifecycleBreadcrumbs());
            this.watcher = lifecycleWatcher;
            ProcessLifecycleOwner.sInstance.mRegistry.addObserver(lifecycleWatcher);
            this.options.getLogger().log(SentryLevel.DEBUG, (String) "AppLifecycleIntegration installed.", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: removeObserver */
    public void lambda$close$1$AppLifecycleIntegration() {
        ProcessLifecycleOwner.sInstance.mRegistry.removeObserver(this.watcher);
    }

    public void close() throws IOException {
        if (this.watcher != null) {
            if (MainThreadChecker.isMainThread()) {
                lambda$close$1$AppLifecycleIntegration();
            } else {
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppLifecycleIntegration.this.lambda$close$1$AppLifecycleIntegration();
                    }
                });
            }
            this.watcher = null;
            SentryAndroidOptions sentryAndroidOptions = this.options;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, (String) "AppLifecycleIntegration removed.", new Object[0]);
            }
        }
    }

    public void register(IHub iHub, SentryOptions sentryOptions) {
        Objects.requireNonNull(iHub, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) Objects.requireNonNull(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.options = sentryAndroidOptions;
        sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, (String) "enableSessionTracking enabled: %s", Boolean.valueOf(this.options.isEnableAutoSessionTracking()));
        this.options.getLogger().log(SentryLevel.DEBUG, (String) "enableAppLifecycleBreadcrumbs enabled: %s", Boolean.valueOf(this.options.isEnableAppLifecycleBreadcrumbs()));
        if (this.options.isEnableAutoSessionTracking() || this.options.isEnableAppLifecycleBreadcrumbs()) {
            try {
                Class.forName("androidx.lifecycle.DefaultLifecycleObserver");
                Class.forName("androidx.lifecycle.ProcessLifecycleOwner");
                if (MainThreadChecker.isMainThread()) {
                    lambda$register$0$AppLifecycleIntegration(iHub);
                } else {
                    this.handler.post(new Runnable(iHub) {
                        public final /* synthetic */ IHub f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            AppLifecycleIntegration.this.lambda$register$0$AppLifecycleIntegration(this.f$1);
                        }
                    });
                }
            } catch (ClassNotFoundException e2) {
                sentryOptions.getLogger().log(SentryLevel.INFO, (String) "androidx.lifecycle is not available, AppLifecycleIntegration won't be installed", (Throwable) e2);
            } catch (IllegalStateException e3) {
                sentryOptions.getLogger().log(SentryLevel.ERROR, (String) "AppLifecycleIntegration could not be installed", (Throwable) e3);
            }
        }
    }

    public AppLifecycleIntegration(IHandler iHandler) {
        this.handler = iHandler;
    }
}

package io.sentry;

import io.sentry.util.Objects;
import java.io.Closeable;
import java.io.IOException;
import org.jetbrains.annotations.VisibleForTesting;

public final class ShutdownHookIntegration implements Integration, Closeable {
    public final Runtime runtime;
    public Thread thread;

    public ShutdownHookIntegration(Runtime runtime2) {
        this.runtime = (Runtime) Objects.requireNonNull(runtime2, "Runtime is required");
    }

    public void close() throws IOException {
        Thread thread2 = this.thread;
        if (thread2 != null) {
            this.runtime.removeShutdownHook(thread2);
        }
    }

    @VisibleForTesting
    public Thread getHook() {
        return this.thread;
    }

    public void register(IHub iHub, SentryOptions sentryOptions) {
        Objects.requireNonNull(iHub, "Hub is required");
        Objects.requireNonNull(sentryOptions, "SentryOptions is required");
        if (sentryOptions.isEnableShutdownHook()) {
            Thread thread2 = new Thread(new Runnable(sentryOptions) {
                public final /* synthetic */ SentryOptions f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    IHub.this.flush(this.f$1.getFlushTimeoutMillis());
                }
            });
            this.thread = thread2;
            this.runtime.addShutdownHook(thread2);
            sentryOptions.getLogger().log(SentryLevel.DEBUG, (String) "ShutdownHookIntegration installed.", new Object[0]);
            return;
        }
        sentryOptions.getLogger().log(SentryLevel.INFO, (String) "enableShutdownHook is disabled.", new Object[0]);
    }

    public ShutdownHookIntegration() {
        this(Runtime.getRuntime());
    }
}

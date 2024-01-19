package io.sentry;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public final class NoOpSentryExecutorService implements ISentryExecutorService {
    public static final NoOpSentryExecutorService instance = new NoOpSentryExecutorService();

    public static ISentryExecutorService getInstance() {
        return instance;
    }

    public static /* synthetic */ Object lambda$submit$0() throws Exception {
        return null;
    }

    public void close(long j) {
    }

    public Future<?> submit(Runnable runnable) {
        return new FutureTask($$Lambda$NoOpSentryExecutorService$FQj0tU3z4jMeG2H7DH3WLX5nSg.INSTANCE);
    }
}

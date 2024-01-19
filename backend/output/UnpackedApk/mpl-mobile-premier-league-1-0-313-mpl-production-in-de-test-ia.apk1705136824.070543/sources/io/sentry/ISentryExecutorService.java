package io.sentry;

import java.util.concurrent.Future;

public interface ISentryExecutorService {
    void close(long j);

    Future<?> submit(Runnable runnable);
}

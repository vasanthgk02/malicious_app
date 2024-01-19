package io.sentry.android.core;

public interface IHandler {
    Thread getThread();

    void post(Runnable runnable);
}

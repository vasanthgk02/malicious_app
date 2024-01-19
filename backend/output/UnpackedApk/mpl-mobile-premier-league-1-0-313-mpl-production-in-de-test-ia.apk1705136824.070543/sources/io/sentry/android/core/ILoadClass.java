package io.sentry.android.core;

public interface ILoadClass {
    Class<?> loadClass(String str) throws ClassNotFoundException;
}

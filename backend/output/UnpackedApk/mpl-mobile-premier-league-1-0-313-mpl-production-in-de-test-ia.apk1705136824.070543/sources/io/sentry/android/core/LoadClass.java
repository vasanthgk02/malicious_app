package io.sentry.android.core;

public final class LoadClass implements ILoadClass {
    public Class<?> loadClass(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }
}

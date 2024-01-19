package com.shield.android.internal;

import com.shield.android.Shield.LogLevel;

public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f1667b;

    /* renamed from: a  reason: collision with root package name */
    public final LogLevel f1668a;

    public b(LogLevel logLevel) {
        this.f1668a = logLevel;
    }

    public static b b(LogLevel logLevel) {
        if (f1667b == null) {
            f1667b = new b(logLevel);
        }
        return f1667b;
    }

    public void a(String str, Object... objArr) {
        LogLevel logLevel = LogLevel.INFO;
        boolean z = true;
        if (this.f1668a.ordinal() < 1) {
            z = false;
        }
        if (z && f.a().f1677b) {
            String.format(str, objArr);
        }
    }

    public void a(Throwable th, String str, Object... objArr) {
        LogLevel logLevel = LogLevel.INFO;
        boolean z = true;
        if (this.f1668a.ordinal() < 1) {
            z = false;
        }
        if (z && f.a().f1677b) {
            String.format(str, objArr);
        }
    }
}

package com.netcore.android.logger;

import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\fJ\u001d\u0010\u0016\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\fJ\u001d\u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\fJ\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\fJ\u001d\u0010\u0019\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\fR\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/netcore/android/logger/SMTLogger;", "", "Lcom/netcore/android/logger/SMTPrinter;", "printer", "", "setPrinter$smartech_release", "(Lcom/netcore/android/logger/SMTPrinter;)V", "setPrinter", "", "tag", "message", "internal", "(Ljava/lang/String;Ljava/lang/String;)V", "", "level", "setDebugLevel", "(I)V", "", "value", "setInternal", "(Z)V", "d", "e", "w", "i", "v", "a", "Lcom/netcore/android/logger/SMTPrinter;", "logPrinter", "c", "Z", "mInternalLog", "b", "I", "mDebugLevel", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTLogger.kt */
public final class SMTLogger {
    public static final SMTLogger INSTANCE = new SMTLogger();

    /* renamed from: a  reason: collision with root package name */
    public static SMTPrinter f1264a = new SMTLoggerPrinter();

    /* renamed from: b  reason: collision with root package name */
    public static int f1265b = 7;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f1266c;

    public final void d(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(str2, "message");
        if (f1265b <= 2) {
            f1264a.d(str, str2);
        }
    }

    public final void e(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(str2, "message");
        if (f1265b <= 5) {
            f1264a.e(str, str2);
        }
    }

    public final void i(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(str2, "message");
        if (f1265b <= 3) {
            f1264a.i(str, str2);
        }
    }

    public final void internal(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(str2, "message");
        if (f1266c) {
            f1264a.internal(str, str2);
        }
    }

    public final void setDebugLevel(int i) {
        f1265b = i;
        if (i == 9) {
            f1266c = true;
            f1265b = 1;
        }
    }

    public final void setInternal(boolean z) {
        f1266c = z;
    }

    public final void setPrinter$smartech_release(SMTPrinter sMTPrinter) {
        Intrinsics.checkNotNullParameter(sMTPrinter, "printer");
        f1264a = sMTPrinter;
    }

    public final void v(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(str2, "message");
        if (f1265b <= 1) {
            f1264a.v(str, str2);
        }
    }

    public final void w(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(str2, "message");
        if (f1265b <= 4) {
            f1264a.w(str, str2);
        }
    }
}

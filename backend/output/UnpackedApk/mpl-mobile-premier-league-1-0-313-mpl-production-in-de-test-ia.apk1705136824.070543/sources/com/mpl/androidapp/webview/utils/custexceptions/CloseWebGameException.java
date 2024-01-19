package com.mpl.androidapp.webview.utils.custexceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/mpl/androidapp/webview/utils/custexceptions/CloseWebGameException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "message", "", "(Ljava/lang/String;)V", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CloseWebGameException.kt */
public final class CloseWebGameException extends Exception {
    public CloseWebGameException() {
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CloseWebGameException(String str) {
        // Intrinsics.checkNotNullParameter(str, "message");
        super(str);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CloseWebGameException(String str, Throwable th) {
        // Intrinsics.checkNotNullParameter(str, "message");
        // Intrinsics.checkNotNullParameter(th, "cause");
        super(str, th);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CloseWebGameException(Throwable th) {
        // Intrinsics.checkNotNullParameter(th, "cause");
        super(th);
    }
}

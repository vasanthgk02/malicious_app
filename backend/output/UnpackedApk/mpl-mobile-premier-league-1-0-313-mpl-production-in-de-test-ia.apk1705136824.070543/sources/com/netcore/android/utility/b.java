package com.netcore.android.utility;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

/* compiled from: SMTCommonUtility.kt */
public final class b {
    public static final String a(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$trim");
        boolean z = str.length() > 0;
        if (z) {
            return CharsKt__CharKt.trim(str).toString();
        }
        if (!z) {
            return "";
        }
        throw new NoWhenBranchMatchedException();
    }
}

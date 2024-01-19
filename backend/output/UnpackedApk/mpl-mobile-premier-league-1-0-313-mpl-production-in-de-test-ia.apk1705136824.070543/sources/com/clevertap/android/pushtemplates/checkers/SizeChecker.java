package com.clevertap.android.pushtemplates.checkers;

import com.netcore.android.SMTEventParamKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0012\u0010\u0003\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/clevertap/android/pushtemplates/checkers/SizeChecker;", "T", "Lcom/clevertap/android/pushtemplates/checkers/Checker;", "entity", "size", "", "errorMsg", "", "(Ljava/lang/Object;ILjava/lang/String;)V", "Ljava/lang/Object;", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SizeChecker.kt */
public abstract class SizeChecker<T> implements Checker<T> {
    public T entity;

    public SizeChecker(T t, int i, String str) {
        Intrinsics.checkNotNullParameter(str, SMTEventParamKeys.SMT_EVENT_CRASH_MESSAGE);
        this.entity = t;
    }
}

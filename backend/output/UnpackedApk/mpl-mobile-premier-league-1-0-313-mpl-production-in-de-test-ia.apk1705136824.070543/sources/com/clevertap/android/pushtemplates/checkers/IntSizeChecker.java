package com.clevertap.android.pushtemplates.checkers;

import co.hyperverge.hypersnapsdk.c.k;
import com.netcore.android.SMTEventParamKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0003\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/clevertap/android/pushtemplates/checkers/IntSizeChecker;", "Lcom/clevertap/android/pushtemplates/checkers/SizeChecker;", "", "entity", "size", "errorMsg", "", "(IILjava/lang/String;)V", "getEntity", "()I", "setEntity", "(I)V", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "getSize", "setSize", "check", "", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: IntSizeChecker.kt */
public final class IntSizeChecker extends SizeChecker<Integer> {
    public int entity;
    public String errorMsg;
    public int size;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public IntSizeChecker(int i, int i2, String str) {
        // Intrinsics.checkNotNullParameter(str, SMTEventParamKeys.SMT_EVENT_CRASH_MESSAGE);
        super(Integer.valueOf(i), i2, str);
        this.entity = i;
        this.size = i2;
        this.errorMsg = str;
    }

    public boolean check() {
        int i = this.entity;
        boolean z = false;
        if (i == Integer.MIN_VALUE) {
            k.verbose("Timer End Value not defined. Not showing notification");
            return false;
        }
        if (i <= this.size) {
            z = true;
        }
        if (z) {
            k.verbose(Intrinsics.stringPlus(this.errorMsg, ". Not showing notification"));
        }
        return !z;
    }
}

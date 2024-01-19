package com.clevertap.android.pushtemplates.checkers;

import co.hyperverge.hypersnapsdk.c.k;
import com.netcore.android.SMTEventParamKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/clevertap/android/pushtemplates/checkers/StringSizeChecker;", "Lcom/clevertap/android/pushtemplates/checkers/SizeChecker;", "", "entity", "size", "", "errorMsg", "(Ljava/lang/String;ILjava/lang/String;)V", "getEntity", "()Ljava/lang/String;", "setEntity", "(Ljava/lang/String;)V", "getErrorMsg", "setErrorMsg", "getSize", "()I", "setSize", "(I)V", "check", "", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: StringSizeChecker.kt */
public final class StringSizeChecker extends SizeChecker<String> {
    public String entity;
    public String errorMsg;
    public int size;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public StringSizeChecker(String str, int i, String str2) {
        // Intrinsics.checkNotNullParameter(str2, SMTEventParamKeys.SMT_EVENT_CRASH_MESSAGE);
        super(str, i, str2);
        this.entity = str;
        this.size = i;
        this.errorMsg = str2;
    }

    public boolean check() {
        String str = this.entity;
        int i = -1;
        if (str != null) {
            String obj = CharsKt__CharKt.trim(str).toString();
            if (obj != null) {
                i = obj.length();
            }
        }
        boolean z = i <= this.size;
        if (z) {
            k.verbose(Intrinsics.stringPlus(this.errorMsg, ". Not showing notification"));
        }
        return !z;
    }
}

package com.clevertap.android.pushtemplates.checkers;

import co.hyperverge.hypersnapsdk.c.k;
import com.netcore.android.SMTEventParamKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B%\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/clevertap/android/pushtemplates/checkers/ListSizeChecker;", "Lcom/clevertap/android/pushtemplates/checkers/SizeChecker;", "", "", "entity", "size", "", "errorMsg", "", "(Ljava/util/List;ILjava/lang/String;)V", "getEntity", "()Ljava/util/List;", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "getSize", "()I", "setSize", "(I)V", "check", "", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ListSizeChecker.kt */
public final class ListSizeChecker extends SizeChecker<List<? extends Object>> {
    public final List<Object> entity;
    public String errorMsg;
    public int size;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ListSizeChecker(List<? extends Object> list, int i, String str) {
        // Intrinsics.checkNotNullParameter(str, SMTEventParamKeys.SMT_EVENT_CRASH_MESSAGE);
        super(list, i, str);
        this.entity = list;
        this.size = i;
        this.errorMsg = str;
    }

    public boolean check() {
        List<Object> list = this.entity;
        boolean z = list == null || list.size() < this.size;
        if (z) {
            k.verbose(Intrinsics.stringPlus(this.errorMsg, ". Not showing notification"));
        }
        return !z;
    }
}

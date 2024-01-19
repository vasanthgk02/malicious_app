package com.clevertap.android.pushtemplates.checkers;

import co.hyperverge.hypersnapsdk.c.k;
import com.netcore.android.SMTEventParamKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/clevertap/android/pushtemplates/checkers/JsonArraySizeChecker;", "Lcom/clevertap/android/pushtemplates/checkers/SizeChecker;", "Lorg/json/JSONArray;", "entity", "size", "", "errorMsg", "", "(Lorg/json/JSONArray;ILjava/lang/String;)V", "getEntity", "()Lorg/json/JSONArray;", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "getSize", "()I", "setSize", "(I)V", "check", "", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: JsonArraySizeChecker.kt */
public final class JsonArraySizeChecker extends SizeChecker<JSONArray> {
    public final JSONArray entity;
    public String errorMsg;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JsonArraySizeChecker(JSONArray jSONArray, int i, String str) {
        // Intrinsics.checkNotNullParameter(str, SMTEventParamKeys.SMT_EVENT_CRASH_MESSAGE);
        super(jSONArray, i, str);
        this.entity = jSONArray;
        this.errorMsg = str;
    }

    public boolean check() {
        boolean z = this.entity == null;
        if (z) {
            k.verbose(Intrinsics.stringPlus(this.errorMsg, ". Not showing notification"));
        }
        return !z;
    }
}

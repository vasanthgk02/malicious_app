package com.netcore.android.event;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* compiled from: SMTEventPayload.kt */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final JSONArray f1072a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer[] f1073b;

    public b(JSONArray jSONArray, Integer[] numArr) {
        Intrinsics.checkNotNullParameter(jSONArray, "eventArray");
        Intrinsics.checkNotNullParameter(numArr, "idArray");
        this.f1072a = jSONArray;
        this.f1073b = numArr;
    }

    public final JSONArray a() {
        return this.f1072a;
    }

    public final Integer[] b() {
        return this.f1073b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.f1073b, r3.f1073b) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof com.netcore.android.event.b
            if (r0 == 0) goto L_0x001d
            com.netcore.android.event.b r3 = (com.netcore.android.event.b) r3
            org.json.JSONArray r0 = r2.f1072a
            org.json.JSONArray r1 = r3.f1072a
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.lang.Integer[] r0 = r2.f1073b
            java.lang.Integer[] r3 = r3.f1073b
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r3 = 0
            return r3
        L_0x001f:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.event.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        JSONArray jSONArray = this.f1072a;
        int i = 0;
        int hashCode = (jSONArray != null ? jSONArray.hashCode() : 0) * 31;
        Integer[] numArr = this.f1073b;
        if (numArr != null) {
            i = Arrays.hashCode(numArr);
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SMTEventPayload(eventArray=");
        outline73.append(this.f1072a);
        outline73.append(", idArray=");
        return GeneratedOutlineSupport.outline62(outline73, Arrays.toString(this.f1073b), ")");
    }
}

package com.netcore.android.event;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001e\b\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\t\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJd\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052(\b\u0002\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u001a\u0010\u001a\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\u0007R\u0019\u0010\u0014\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u0014\u0010\u000fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0004R9\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\t8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u000b¨\u0006+"}, d2 = {"Lcom/netcore/android/event/SMTEventRecorderModel;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "component3", "()Ljava/util/HashMap;", "component4", "", "component5", "()Z", "eventId", "eventName", "payload", "eventType", "isEventFromHansel", "copy", "(ILjava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Z)Lcom/netcore/android/event/SMTEventRecorderModel;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "getEventType", "b", "getEventName", "e", "Z", "a", "I", "getEventId", "c", "Ljava/util/HashMap;", "getPayload", "<init>", "(ILjava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Z)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTEventRecorderModel.kt */
public final class SMTEventRecorderModel {

    /* renamed from: a  reason: collision with root package name */
    public final int f1060a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1061b;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, Object> f1062c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1063d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f1064e;

    public SMTEventRecorderModel(int i, String str, HashMap<String, Object> hashMap, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str2, "eventType");
        this.f1060a = i;
        this.f1061b = str;
        this.f1062c = hashMap;
        this.f1063d = str2;
        this.f1064e = z;
    }

    public static /* synthetic */ SMTEventRecorderModel copy$default(SMTEventRecorderModel sMTEventRecorderModel, int i, String str, HashMap<String, Object> hashMap, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = sMTEventRecorderModel.f1060a;
        }
        if ((i2 & 2) != 0) {
            str = sMTEventRecorderModel.f1061b;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            hashMap = sMTEventRecorderModel.f1062c;
        }
        HashMap hashMap2 = hashMap;
        if ((i2 & 8) != 0) {
            str2 = sMTEventRecorderModel.f1063d;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            z = sMTEventRecorderModel.f1064e;
        }
        return sMTEventRecorderModel.copy(i, str3, hashMap2, str4, z);
    }

    public final int component1() {
        return this.f1060a;
    }

    public final String component2() {
        return this.f1061b;
    }

    public final HashMap<String, Object> component3() {
        return this.f1062c;
    }

    public final String component4() {
        return this.f1063d;
    }

    public final boolean component5() {
        return this.f1064e;
    }

    public final SMTEventRecorderModel copy(int i, String str, HashMap<String, Object> hashMap, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str2, "eventType");
        SMTEventRecorderModel sMTEventRecorderModel = new SMTEventRecorderModel(i, str, hashMap, str2, z);
        return sMTEventRecorderModel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        if (r2.f1064e == r3.f1064e) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0035
            boolean r0 = r3 instanceof com.netcore.android.event.SMTEventRecorderModel
            if (r0 == 0) goto L_0x0033
            com.netcore.android.event.SMTEventRecorderModel r3 = (com.netcore.android.event.SMTEventRecorderModel) r3
            int r0 = r2.f1060a
            int r1 = r3.f1060a
            if (r0 != r1) goto L_0x0033
            java.lang.String r0 = r2.f1061b
            java.lang.String r1 = r3.f1061b
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0033
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r2.f1062c
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r3.f1062c
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = r2.f1063d
            java.lang.String r1 = r3.f1063d
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0033
            boolean r0 = r2.f1064e
            boolean r3 = r3.f1064e
            if (r0 != r3) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r3 = 0
            return r3
        L_0x0035:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.event.SMTEventRecorderModel.equals(java.lang.Object):boolean");
    }

    public final int getEventId() {
        return this.f1060a;
    }

    public final String getEventName() {
        return this.f1061b;
    }

    public final String getEventType() {
        return this.f1063d;
    }

    public final HashMap<String, Object> getPayload() {
        return this.f1062c;
    }

    public int hashCode() {
        int i = this.f1060a * 31;
        String str = this.f1061b;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        HashMap<String, Object> hashMap = this.f1062c;
        int hashCode2 = (hashCode + (hashMap != null ? hashMap.hashCode() : 0)) * 31;
        String str2 = this.f1063d;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.f1064e;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final boolean isEventFromHansel() {
        return this.f1064e;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SMTEventRecorderModel(eventId=");
        outline73.append(this.f1060a);
        outline73.append(", eventName=");
        outline73.append(this.f1061b);
        outline73.append(", payload=");
        outline73.append(this.f1062c);
        outline73.append(", eventType=");
        outline73.append(this.f1063d);
        outline73.append(", isEventFromHansel=");
        return GeneratedOutlineSupport.outline66(outline73, this.f1064e, ")");
    }

    public /* synthetic */ SMTEventRecorderModel(int i, String str, HashMap hashMap, String str2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, hashMap, str2, (i2 & 16) != 0 ? false : z);
    }
}

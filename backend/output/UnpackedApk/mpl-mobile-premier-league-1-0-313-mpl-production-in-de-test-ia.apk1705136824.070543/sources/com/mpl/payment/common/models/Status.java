package com.mpl.payment.common.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003JC\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/mpl/payment/common/models/Status;", "", "code", "", "message", "", "reason", "type", "title", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getReason", "getTitle", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: MPLEndpointResultStatus.kt */
public final class Status {
    public final int code;
    public final String message;
    public final String reason;
    public final String title;
    public final String type;

    public Status(int i, String str, String str2, String str3, String str4) {
        this.code = i;
        this.message = str;
        this.reason = str2;
        this.type = str3;
        this.title = str4;
    }

    public static /* synthetic */ Status copy$default(Status status, int i, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = status.code;
        }
        if ((i2 & 2) != 0) {
            str = status.message;
        }
        String str5 = str;
        if ((i2 & 4) != 0) {
            str2 = status.reason;
        }
        String str6 = str2;
        if ((i2 & 8) != 0) {
            str3 = status.type;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            str4 = status.title;
        }
        return status.copy(i, str5, str6, str7, str4);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.reason;
    }

    public final String component4() {
        return this.type;
    }

    public final String component5() {
        return this.title;
    }

    public final Status copy(int i, String str, String str2, String str3, String str4) {
        Status status = new Status(i, str, str2, str3, str4);
        return status;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.title, r3.title) != false) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0039
            boolean r0 = r3 instanceof com.mpl.payment.common.models.Status
            if (r0 == 0) goto L_0x0037
            com.mpl.payment.common.models.Status r3 = (com.mpl.payment.common.models.Status) r3
            int r0 = r2.code
            int r1 = r3.code
            if (r0 != r1) goto L_0x0037
            java.lang.String r0 = r2.message
            java.lang.String r1 = r3.message
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = r2.reason
            java.lang.String r1 = r3.reason
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = r2.type
            java.lang.String r1 = r3.type
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = r2.title
            java.lang.String r3 = r3.title
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r3 = 0
            return r3
        L_0x0039:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.common.models.Status.equals(java.lang.Object):boolean");
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int i = this.code * 31;
        String str = this.message;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.reason;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.type;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.title;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Status(code=");
        outline73.append(this.code);
        outline73.append(", message=");
        outline73.append(this.message);
        outline73.append(", reason=");
        outline73.append(this.reason);
        outline73.append(", type=");
        outline73.append(this.type);
        outline73.append(", title=");
        return GeneratedOutlineSupport.outline62(outline73, this.title, ")");
    }
}

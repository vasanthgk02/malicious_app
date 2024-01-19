package com.mpl.payment.phonepe.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/mpl/payment/phonepe/models/PhonePeExtraInfo;", "", "userAuthToken", "", "deviceId", "phonePeVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getPhonePeVersion", "getUserAuthToken", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhonePeExtraInfo.kt */
public final class PhonePeExtraInfo {
    public final String deviceId;
    public final String phonePeVersion;
    public final String userAuthToken;

    public PhonePeExtraInfo(String str, String str2, String str3) {
        GeneratedOutlineSupport.outline97(str, "userAuthToken", str2, Constant.HEADER_ANDROID_DEVICE_ID, str3, "phonePeVersion");
        this.userAuthToken = str;
        this.deviceId = str2;
        this.phonePeVersion = str3;
    }

    public static /* synthetic */ PhonePeExtraInfo copy$default(PhonePeExtraInfo phonePeExtraInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = phonePeExtraInfo.userAuthToken;
        }
        if ((i & 2) != 0) {
            str2 = phonePeExtraInfo.deviceId;
        }
        if ((i & 4) != 0) {
            str3 = phonePeExtraInfo.phonePeVersion;
        }
        return phonePeExtraInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.userAuthToken;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final String component3() {
        return this.phonePeVersion;
    }

    public final PhonePeExtraInfo copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "userAuthToken");
        Intrinsics.checkNotNullParameter(str2, Constant.HEADER_ANDROID_DEVICE_ID);
        Intrinsics.checkNotNullParameter(str3, "phonePeVersion");
        return new PhonePeExtraInfo(str, str2, str3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.phonePeVersion, r3.phonePeVersion) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof com.mpl.payment.phonepe.models.PhonePeExtraInfo
            if (r0 == 0) goto L_0x0027
            com.mpl.payment.phonepe.models.PhonePeExtraInfo r3 = (com.mpl.payment.phonepe.models.PhonePeExtraInfo) r3
            java.lang.String r0 = r2.userAuthToken
            java.lang.String r1 = r3.userAuthToken
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.deviceId
            java.lang.String r1 = r3.deviceId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.phonePeVersion
            java.lang.String r3 = r3.phonePeVersion
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r3 = 0
            return r3
        L_0x0029:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.phonepe.models.PhonePeExtraInfo.equals(java.lang.Object):boolean");
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getPhonePeVersion() {
        return this.phonePeVersion;
    }

    public final String getUserAuthToken() {
        return this.userAuthToken;
    }

    public int hashCode() {
        String str = this.userAuthToken;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.deviceId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.phonePeVersion;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("PhonePeExtraInfo(userAuthToken=");
        outline73.append(this.userAuthToken);
        outline73.append(", deviceId=");
        outline73.append(this.deviceId);
        outline73.append(", phonePeVersion=");
        return GeneratedOutlineSupport.outline62(outline73, this.phonePeVersion, ")");
    }
}

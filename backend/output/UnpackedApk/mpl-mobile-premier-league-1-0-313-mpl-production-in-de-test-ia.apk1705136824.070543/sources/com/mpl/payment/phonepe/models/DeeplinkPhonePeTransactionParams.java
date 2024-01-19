package com.mpl.payment.phonepe.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant;
import com.mpl.network.modules.engine.MHeader;
import com.netcore.android.notification.SMTNotificationConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J_\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0006HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006("}, d2 = {"Lcom/mpl/payment/phonepe/models/DeeplinkPhonePeTransactionParams;", "", "orderId", "", "deeplink", "phonePeRequestcode", "", "completeDepositUrl", "headers", "", "Lcom/mpl/network/modules/engine/MHeader;", "userAuthToken", "deviceId", "phonePeVersion", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCompleteDepositUrl", "()Ljava/lang/String;", "getDeeplink", "getDeviceId", "getHeaders", "()Ljava/util/List;", "getOrderId", "getPhonePeRequestcode", "()I", "getPhonePeVersion", "getUserAuthToken", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: DeeplinkPhonePeTransactionParams.kt */
public final class DeeplinkPhonePeTransactionParams {
    public final String completeDepositUrl;
    public final String deeplink;
    public final String deviceId;
    public final List<MHeader> headers;
    public final String orderId;
    public final int phonePeRequestcode;
    public final String phonePeVersion;
    public final String userAuthToken;

    public DeeplinkPhonePeTransactionParams(String str, String str2, int i, String str3, List<MHeader> list, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, SMTNotificationConstants.NOTIF_DEEPLINK_KEY);
        Intrinsics.checkNotNullParameter(str3, "completeDepositUrl");
        Intrinsics.checkNotNullParameter(list, Constant.HEADER);
        Intrinsics.checkNotNullParameter(str4, "userAuthToken");
        Intrinsics.checkNotNullParameter(str5, Constant.HEADER_ANDROID_DEVICE_ID);
        Intrinsics.checkNotNullParameter(str6, "phonePeVersion");
        this.orderId = str;
        this.deeplink = str2;
        this.phonePeRequestcode = i;
        this.completeDepositUrl = str3;
        this.headers = list;
        this.userAuthToken = str4;
        this.deviceId = str5;
        this.phonePeVersion = str6;
    }

    public static /* synthetic */ DeeplinkPhonePeTransactionParams copy$default(DeeplinkPhonePeTransactionParams deeplinkPhonePeTransactionParams, String str, String str2, int i, String str3, List list, String str4, String str5, String str6, int i2, Object obj) {
        DeeplinkPhonePeTransactionParams deeplinkPhonePeTransactionParams2 = deeplinkPhonePeTransactionParams;
        int i3 = i2;
        return deeplinkPhonePeTransactionParams.copy((i3 & 1) != 0 ? deeplinkPhonePeTransactionParams2.orderId : str, (i3 & 2) != 0 ? deeplinkPhonePeTransactionParams2.deeplink : str2, (i3 & 4) != 0 ? deeplinkPhonePeTransactionParams2.phonePeRequestcode : i, (i3 & 8) != 0 ? deeplinkPhonePeTransactionParams2.completeDepositUrl : str3, (i3 & 16) != 0 ? deeplinkPhonePeTransactionParams2.headers : list, (i3 & 32) != 0 ? deeplinkPhonePeTransactionParams2.userAuthToken : str4, (i3 & 64) != 0 ? deeplinkPhonePeTransactionParams2.deviceId : str5, (i3 & 128) != 0 ? deeplinkPhonePeTransactionParams2.phonePeVersion : str6);
    }

    public final String component1() {
        return this.orderId;
    }

    public final String component2() {
        return this.deeplink;
    }

    public final int component3() {
        return this.phonePeRequestcode;
    }

    public final String component4() {
        return this.completeDepositUrl;
    }

    public final List<MHeader> component5() {
        return this.headers;
    }

    public final String component6() {
        return this.userAuthToken;
    }

    public final String component7() {
        return this.deviceId;
    }

    public final String component8() {
        return this.phonePeVersion;
    }

    public final DeeplinkPhonePeTransactionParams copy(String str, String str2, int i, String str3, List<MHeader> list, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, SMTNotificationConstants.NOTIF_DEEPLINK_KEY);
        Intrinsics.checkNotNullParameter(str3, "completeDepositUrl");
        Intrinsics.checkNotNullParameter(list, Constant.HEADER);
        String str7 = str4;
        Intrinsics.checkNotNullParameter(str7, "userAuthToken");
        String str8 = str5;
        Intrinsics.checkNotNullParameter(str8, Constant.HEADER_ANDROID_DEVICE_ID);
        String str9 = str6;
        Intrinsics.checkNotNullParameter(str9, "phonePeVersion");
        DeeplinkPhonePeTransactionParams deeplinkPhonePeTransactionParams = new DeeplinkPhonePeTransactionParams(str, str2, i, str3, list, str7, str8, str9);
        return deeplinkPhonePeTransactionParams;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.phonePeVersion, r3.phonePeVersion) != false) goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0057
            boolean r0 = r3 instanceof com.mpl.payment.phonepe.models.DeeplinkPhonePeTransactionParams
            if (r0 == 0) goto L_0x0055
            com.mpl.payment.phonepe.models.DeeplinkPhonePeTransactionParams r3 = (com.mpl.payment.phonepe.models.DeeplinkPhonePeTransactionParams) r3
            java.lang.String r0 = r2.orderId
            java.lang.String r1 = r3.orderId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = r2.deeplink
            java.lang.String r1 = r3.deeplink
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0055
            int r0 = r2.phonePeRequestcode
            int r1 = r3.phonePeRequestcode
            if (r0 != r1) goto L_0x0055
            java.lang.String r0 = r2.completeDepositUrl
            java.lang.String r1 = r3.completeDepositUrl
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0055
            java.util.List<com.mpl.network.modules.engine.MHeader> r0 = r2.headers
            java.util.List<com.mpl.network.modules.engine.MHeader> r1 = r3.headers
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = r2.userAuthToken
            java.lang.String r1 = r3.userAuthToken
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = r2.deviceId
            java.lang.String r1 = r3.deviceId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = r2.phonePeVersion
            java.lang.String r3 = r3.phonePeVersion
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r3 = 0
            return r3
        L_0x0057:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.phonepe.models.DeeplinkPhonePeTransactionParams.equals(java.lang.Object):boolean");
    }

    public final String getCompleteDepositUrl() {
        return this.completeDepositUrl;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final List<MHeader> getHeaders() {
        return this.headers;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final int getPhonePeRequestcode() {
        return this.phonePeRequestcode;
    }

    public final String getPhonePeVersion() {
        return this.phonePeVersion;
    }

    public final String getUserAuthToken() {
        return this.userAuthToken;
    }

    public int hashCode() {
        String str = this.orderId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.deeplink;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.phonePeRequestcode) * 31;
        String str3 = this.completeDepositUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<MHeader> list = this.headers;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        String str4 = this.userAuthToken;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.deviceId;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.phonePeVersion;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("DeeplinkPhonePeTransactionParams(orderId=");
        outline73.append(this.orderId);
        outline73.append(", deeplink=");
        outline73.append(this.deeplink);
        outline73.append(", phonePeRequestcode=");
        outline73.append(this.phonePeRequestcode);
        outline73.append(", completeDepositUrl=");
        outline73.append(this.completeDepositUrl);
        outline73.append(", headers=");
        outline73.append(this.headers);
        outline73.append(", userAuthToken=");
        outline73.append(this.userAuthToken);
        outline73.append(", deviceId=");
        outline73.append(this.deviceId);
        outline73.append(", phonePeVersion=");
        return GeneratedOutlineSupport.outline62(outline73, this.phonePeVersion, ")");
    }
}

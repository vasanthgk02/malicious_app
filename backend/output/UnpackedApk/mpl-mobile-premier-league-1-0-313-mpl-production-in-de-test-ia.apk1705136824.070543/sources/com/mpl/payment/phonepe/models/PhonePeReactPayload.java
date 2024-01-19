package com.mpl.payment.phonepe.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant;
import com.mpl.payment.routing.RoutingConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u001f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/mpl/payment/phonepe/models/PhonePeReactPayload;", "", "completeDepositUrl", "", "phonePeDirectRequestCode", "", "savedPaymentDetails", "Lcom/mpl/payment/phonepe/models/PhonePeReactPayload$SavedPaymentDetail;", "(Ljava/lang/String;ILcom/mpl/payment/phonepe/models/PhonePeReactPayload$SavedPaymentDetail;)V", "getCompleteDepositUrl", "()Ljava/lang/String;", "getPhonePeDirectRequestCode", "()I", "getSavedPaymentDetails", "()Lcom/mpl/payment/phonepe/models/PhonePeReactPayload$SavedPaymentDetail;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "AdditionalDetails", "SavedPaymentDetail", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhonePeReactPayload.kt */
public final class PhonePeReactPayload {
    public final String completeDepositUrl;
    public final int phonePeDirectRequestCode;
    public final SavedPaymentDetail savedPaymentDetails;

    @JsonClass(generateAdapter = true)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/mpl/payment/phonepe/models/PhonePeReactPayload$AdditionalDetails;", "", "userAuthToken", "", "deviceId", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getUserAuthToken", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PhonePeReactPayload.kt */
    public static final class AdditionalDetails {
        public final String deviceId;
        public final String userAuthToken;

        public AdditionalDetails(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "userAuthToken");
            Intrinsics.checkNotNullParameter(str2, Constant.HEADER_ANDROID_DEVICE_ID);
            this.userAuthToken = str;
            this.deviceId = str2;
        }

        public static /* synthetic */ AdditionalDetails copy$default(AdditionalDetails additionalDetails, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = additionalDetails.userAuthToken;
            }
            if ((i & 2) != 0) {
                str2 = additionalDetails.deviceId;
            }
            return additionalDetails.copy(str, str2);
        }

        public final String component1() {
            return this.userAuthToken;
        }

        public final String component2() {
            return this.deviceId;
        }

        public final AdditionalDetails copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "userAuthToken");
            Intrinsics.checkNotNullParameter(str2, Constant.HEADER_ANDROID_DEVICE_ID);
            return new AdditionalDetails(str, str2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual(r2.deviceId, r3.deviceId) != false) goto L_0x001f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x001f
                boolean r0 = r3 instanceof com.mpl.payment.phonepe.models.PhonePeReactPayload.AdditionalDetails
                if (r0 == 0) goto L_0x001d
                com.mpl.payment.phonepe.models.PhonePeReactPayload$AdditionalDetails r3 = (com.mpl.payment.phonepe.models.PhonePeReactPayload.AdditionalDetails) r3
                java.lang.String r0 = r2.userAuthToken
                java.lang.String r1 = r3.userAuthToken
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x001d
                java.lang.String r0 = r2.deviceId
                java.lang.String r3 = r3.deviceId
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
            throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.phonepe.models.PhonePeReactPayload.AdditionalDetails.equals(java.lang.Object):boolean");
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final String getUserAuthToken() {
            return this.userAuthToken;
        }

        public int hashCode() {
            String str = this.userAuthToken;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.deviceId;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("AdditionalDetails(userAuthToken=");
            outline73.append(this.userAuthToken);
            outline73.append(", deviceId=");
            return GeneratedOutlineSupport.outline62(outline73, this.deviceId, ")");
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/mpl/payment/phonepe/models/PhonePeReactPayload$SavedPaymentDetail;", "", "plugin", "", "additionalDetails", "Lcom/mpl/payment/phonepe/models/PhonePeReactPayload$AdditionalDetails;", "(Ljava/lang/String;Lcom/mpl/payment/phonepe/models/PhonePeReactPayload$AdditionalDetails;)V", "getAdditionalDetails", "()Lcom/mpl/payment/phonepe/models/PhonePeReactPayload$AdditionalDetails;", "getPlugin", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PhonePeReactPayload.kt */
    public static final class SavedPaymentDetail {
        public final AdditionalDetails additionalDetails;
        public final String plugin;

        public SavedPaymentDetail(String str, AdditionalDetails additionalDetails2) {
            Intrinsics.checkNotNullParameter(str, "plugin");
            Intrinsics.checkNotNullParameter(additionalDetails2, RoutingConstants.MI_REACT_ADDITIONAL_DETAILS);
            this.plugin = str;
            this.additionalDetails = additionalDetails2;
        }

        public static /* synthetic */ SavedPaymentDetail copy$default(SavedPaymentDetail savedPaymentDetail, String str, AdditionalDetails additionalDetails2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = savedPaymentDetail.plugin;
            }
            if ((i & 2) != 0) {
                additionalDetails2 = savedPaymentDetail.additionalDetails;
            }
            return savedPaymentDetail.copy(str, additionalDetails2);
        }

        public final String component1() {
            return this.plugin;
        }

        public final AdditionalDetails component2() {
            return this.additionalDetails;
        }

        public final SavedPaymentDetail copy(String str, AdditionalDetails additionalDetails2) {
            Intrinsics.checkNotNullParameter(str, "plugin");
            Intrinsics.checkNotNullParameter(additionalDetails2, RoutingConstants.MI_REACT_ADDITIONAL_DETAILS);
            return new SavedPaymentDetail(str, additionalDetails2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual(r2.additionalDetails, r3.additionalDetails) != false) goto L_0x001f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x001f
                boolean r0 = r3 instanceof com.mpl.payment.phonepe.models.PhonePeReactPayload.SavedPaymentDetail
                if (r0 == 0) goto L_0x001d
                com.mpl.payment.phonepe.models.PhonePeReactPayload$SavedPaymentDetail r3 = (com.mpl.payment.phonepe.models.PhonePeReactPayload.SavedPaymentDetail) r3
                java.lang.String r0 = r2.plugin
                java.lang.String r1 = r3.plugin
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x001d
                com.mpl.payment.phonepe.models.PhonePeReactPayload$AdditionalDetails r0 = r2.additionalDetails
                com.mpl.payment.phonepe.models.PhonePeReactPayload$AdditionalDetails r3 = r3.additionalDetails
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
            throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.phonepe.models.PhonePeReactPayload.SavedPaymentDetail.equals(java.lang.Object):boolean");
        }

        public final AdditionalDetails getAdditionalDetails() {
            return this.additionalDetails;
        }

        public final String getPlugin() {
            return this.plugin;
        }

        public int hashCode() {
            String str = this.plugin;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            AdditionalDetails additionalDetails2 = this.additionalDetails;
            if (additionalDetails2 != null) {
                i = additionalDetails2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("SavedPaymentDetail(plugin=");
            outline73.append(this.plugin);
            outline73.append(", additionalDetails=");
            outline73.append(this.additionalDetails);
            outline73.append(")");
            return outline73.toString();
        }
    }

    public PhonePeReactPayload(@Json(name = "complete_deposit_url") String str, int i, SavedPaymentDetail savedPaymentDetail) {
        Intrinsics.checkNotNullParameter(str, "completeDepositUrl");
        Intrinsics.checkNotNullParameter(savedPaymentDetail, "savedPaymentDetails");
        this.completeDepositUrl = str;
        this.phonePeDirectRequestCode = i;
        this.savedPaymentDetails = savedPaymentDetail;
    }

    public static /* synthetic */ PhonePeReactPayload copy$default(PhonePeReactPayload phonePeReactPayload, String str, int i, SavedPaymentDetail savedPaymentDetail, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = phonePeReactPayload.completeDepositUrl;
        }
        if ((i2 & 2) != 0) {
            i = phonePeReactPayload.phonePeDirectRequestCode;
        }
        if ((i2 & 4) != 0) {
            savedPaymentDetail = phonePeReactPayload.savedPaymentDetails;
        }
        return phonePeReactPayload.copy(str, i, savedPaymentDetail);
    }

    public final String component1() {
        return this.completeDepositUrl;
    }

    public final int component2() {
        return this.phonePeDirectRequestCode;
    }

    public final SavedPaymentDetail component3() {
        return this.savedPaymentDetails;
    }

    public final PhonePeReactPayload copy(@Json(name = "complete_deposit_url") String str, int i, SavedPaymentDetail savedPaymentDetail) {
        Intrinsics.checkNotNullParameter(str, "completeDepositUrl");
        Intrinsics.checkNotNullParameter(savedPaymentDetail, "savedPaymentDetails");
        return new PhonePeReactPayload(str, i, savedPaymentDetail);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.savedPaymentDetails, r3.savedPaymentDetails) != false) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0025
            boolean r0 = r3 instanceof com.mpl.payment.phonepe.models.PhonePeReactPayload
            if (r0 == 0) goto L_0x0023
            com.mpl.payment.phonepe.models.PhonePeReactPayload r3 = (com.mpl.payment.phonepe.models.PhonePeReactPayload) r3
            java.lang.String r0 = r2.completeDepositUrl
            java.lang.String r1 = r3.completeDepositUrl
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0023
            int r0 = r2.phonePeDirectRequestCode
            int r1 = r3.phonePeDirectRequestCode
            if (r0 != r1) goto L_0x0023
            com.mpl.payment.phonepe.models.PhonePeReactPayload$SavedPaymentDetail r0 = r2.savedPaymentDetails
            com.mpl.payment.phonepe.models.PhonePeReactPayload$SavedPaymentDetail r3 = r3.savedPaymentDetails
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r3 = 0
            return r3
        L_0x0025:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.phonepe.models.PhonePeReactPayload.equals(java.lang.Object):boolean");
    }

    public final String getCompleteDepositUrl() {
        return this.completeDepositUrl;
    }

    public final int getPhonePeDirectRequestCode() {
        return this.phonePeDirectRequestCode;
    }

    public final SavedPaymentDetail getSavedPaymentDetails() {
        return this.savedPaymentDetails;
    }

    public int hashCode() {
        String str = this.completeDepositUrl;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.phonePeDirectRequestCode) * 31;
        SavedPaymentDetail savedPaymentDetail = this.savedPaymentDetails;
        if (savedPaymentDetail != null) {
            i = savedPaymentDetail.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("PhonePeReactPayload(completeDepositUrl=");
        outline73.append(this.completeDepositUrl);
        outline73.append(", phonePeDirectRequestCode=");
        outline73.append(this.phonePeDirectRequestCode);
        outline73.append(", savedPaymentDetails=");
        outline73.append(this.savedPaymentDetails);
        outline73.append(")");
        return outline73.toString();
    }
}

package com.mpl.payment.phonepe;

import android.app.Activity;
import com.mpl.androidapp.utils.Constant;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.payment.common.TransactionParamsCreator;
import com.mpl.payment.phonepe.models.DeeplinkPhonePeTransactionParams;
import com.mpl.payment.phonepe.models.PhonePeMoneyInPayload;
import com.mpl.payment.phonepe.models.PhonePeReactPayload;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u001b2\u0006\u0010!\u001a\u00020\u0003H\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006&"}, d2 = {"Lcom/mpl/payment/phonepe/PhonePeTransactionParamsCreator;", "Lcom/mpl/payment/common/TransactionParamsCreator;", "moneyInPayloadString", "", "phonePeReactPayloadString", "headers", "", "Lcom/mpl/network/modules/engine/MHeader;", "activity", "Landroid/app/Activity;", "phonePeVersionCode", "moshiInstance", "Lcom/squareup/moshi/Moshi;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Landroid/app/Activity;Ljava/lang/String;Lcom/squareup/moshi/Moshi;)V", "getActivity", "()Landroid/app/Activity;", "getHeaders", "()Ljava/util/List;", "getMoneyInPayloadString", "()Ljava/lang/String;", "getMoshiInstance", "()Lcom/squareup/moshi/Moshi;", "getPhonePeReactPayloadString", "getPhonePeVersionCode", "getDeeplinkParams", "Lcom/mpl/payment/phonepe/models/DeeplinkPhonePeTransactionParams;", "moneyInPayload", "Lcom/mpl/payment/phonepe/models/PhonePeMoneyInPayload;", "phonePeReactPayload", "Lcom/mpl/payment/phonepe/models/PhonePeReactPayload;", "getTransactionParams", "", "moneyInPayloadModelFromJson", "phonePeMoneyInPayloadString", "reactPayloadModelFromJson", "validateMandatoryTransactionParams", "", "Companion", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhonePeTransactionParamsCreator.kt */
public final class PhonePeTransactionParamsCreator implements TransactionParamsCreator {
    public static final Companion Companion = new Companion(null);
    public static final String RESPONSE_TYPE_DEEPLINK = "DEEPLINK";
    public static final String RESPONSE_TYPE_FAILED = "FAILED";
    public static final String RESPONSE_TYPE_PENDING = "PENDING";
    public static final String RESPONSE_TYPE_SUCCESS = "SUCCESS";
    public final Activity activity;
    public final List<MHeader> headers;
    public final String moneyInPayloadString;
    public final Moshi moshiInstance;
    public final String phonePeReactPayloadString;
    public final String phonePeVersionCode;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/mpl/payment/phonepe/PhonePeTransactionParamsCreator$Companion;", "", "()V", "RESPONSE_TYPE_DEEPLINK", "", "RESPONSE_TYPE_FAILED", "RESPONSE_TYPE_PENDING", "RESPONSE_TYPE_SUCCESS", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PhonePeTransactionParamsCreator.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PhonePeTransactionParamsCreator(String str, String str2, List<MHeader> list, Activity activity2, String str3, Moshi moshi) {
        Intrinsics.checkNotNullParameter(str, "moneyInPayloadString");
        Intrinsics.checkNotNullParameter(str2, "phonePeReactPayloadString");
        Intrinsics.checkNotNullParameter(list, Constant.HEADER);
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(str3, "phonePeVersionCode");
        Intrinsics.checkNotNullParameter(moshi, "moshiInstance");
        this.moneyInPayloadString = str;
        this.phonePeReactPayloadString = str2;
        this.headers = list;
        this.activity = activity2;
        this.phonePeVersionCode = str3;
        this.moshiInstance = moshi;
    }

    private final DeeplinkPhonePeTransactionParams getDeeplinkParams(PhonePeMoneyInPayload phonePeMoneyInPayload, PhonePeReactPayload phonePeReactPayload) {
        String deeplink = phonePeMoneyInPayload.getDeeplink();
        boolean z = true;
        if (!(deeplink.length() == 0)) {
            String completeDepositUrl = phonePeReactPayload.getCompleteDepositUrl();
            if (!(completeDepositUrl.length() == 0)) {
                String userAuthToken = phonePeReactPayload.getSavedPaymentDetails().getAdditionalDetails().getUserAuthToken();
                if (!(userAuthToken.length() == 0)) {
                    String deviceId = phonePeReactPayload.getSavedPaymentDetails().getAdditionalDetails().getDeviceId();
                    if (deviceId.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        DeeplinkPhonePeTransactionParams deeplinkPhonePeTransactionParams = new DeeplinkPhonePeTransactionParams(phonePeMoneyInPayload.getOrderId(), deeplink, phonePeReactPayload.getPhonePeDirectRequestCode(), completeDepositUrl, this.headers, userAuthToken, deviceId, this.phonePeVersionCode);
                        return deeplinkPhonePeTransactionParams;
                    }
                    throw new Exception("deviceId can't be empty from react");
                }
                throw new Exception("userAuthToken can't be empty from react");
            }
            throw new Exception("complete deposit url can't be empty from react");
        }
        throw new Exception("deeplink can't be empty from moneyInPayload");
    }

    private final PhonePeMoneyInPayload moneyInPayloadModelFromJson(String str) {
        JsonAdapter<PhonePeMoneyInPayload> adapter = this.moshiInstance.adapter(PhonePeMoneyInPayload.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshiInstance.adapter(Ph…neyInPayload::class.java)");
        PhonePeMoneyInPayload phonePeMoneyInPayload = (PhonePeMoneyInPayload) adapter.fromJson(this.moneyInPayloadString);
        if (phonePeMoneyInPayload != null) {
            return phonePeMoneyInPayload;
        }
        throw new Exception("When Parsing moneyIn payload string, adapter returned null");
    }

    private final PhonePeReactPayload reactPayloadModelFromJson(String str) {
        JsonAdapter<PhonePeReactPayload> adapter = this.moshiInstance.adapter(PhonePeReactPayload.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshiInstance.adapter(Ph…ReactPayload::class.java)");
        PhonePeReactPayload phonePeReactPayload = (PhonePeReactPayload) adapter.fromJson(str);
        if (phonePeReactPayload != null) {
            return phonePeReactPayload;
        }
        throw new Exception("When Parsing react payload string, adapter returned null");
    }

    private final void validateMandatoryTransactionParams(PhonePeMoneyInPayload phonePeMoneyInPayload) {
        boolean z = true;
        if (!(phonePeMoneyInPayload.getOrderId().length() == 0)) {
            if (phonePeMoneyInPayload.getResponseType().length() != 0) {
                z = false;
            }
            if (z) {
                throw new Exception("responseType can't be empty from moneyInPayload");
            }
            return;
        }
        throw new Exception("ORDER_ID cant be empty from moneyInPayload");
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final List<MHeader> getHeaders() {
        return this.headers;
    }

    public final String getMoneyInPayloadString() {
        return this.moneyInPayloadString;
    }

    public final Moshi getMoshiInstance() {
        return this.moshiInstance;
    }

    public final String getPhonePeReactPayloadString() {
        return this.phonePeReactPayloadString;
    }

    public final String getPhonePeVersionCode() {
        return this.phonePeVersionCode;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0046, code lost:
        if (r2.equals("SUCCESS") != false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005e, code lost:
        throw new java.lang.Exception("responseType not recognised, check responsetype from moneyInPayload");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return new com.mpl.payment.phonepe.models.NormalPhonePeTransactionParams(r0.getOrderId(), r0.getResponseType());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0024, code lost:
        if (r2.equals("FAILED") != false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003d, code lost:
        if (r2.equals("PENDING") != false) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getTransactionParams() {
        /*
            r4 = this;
            java.lang.String r0 = r4.moneyInPayloadString
            com.mpl.payment.phonepe.models.PhonePeMoneyInPayload r0 = r4.moneyInPayloadModelFromJson(r0)
            java.lang.String r1 = r4.phonePeReactPayloadString
            com.mpl.payment.phonepe.models.PhonePeReactPayload r1 = r4.reactPayloadModelFromJson(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r4.validateMandatoryTransactionParams(r0)
            java.lang.String r2 = r0.getResponseType()
            int r3 = r2.hashCode()
            switch(r3) {
                case -1149187101: goto L_0x0040;
                case 35394935: goto L_0x0037;
                case 1411860198: goto L_0x0027;
                case 2066319421: goto L_0x001e;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0057
        L_0x001e:
            java.lang.String r1 = "FAILED"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0057
            goto L_0x0048
        L_0x0027:
            java.lang.String r3 = "DEEPLINK"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0057
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            com.mpl.payment.phonepe.models.DeeplinkPhonePeTransactionParams r0 = r4.getDeeplinkParams(r0, r1)
            goto L_0x0056
        L_0x0037:
            java.lang.String r1 = "PENDING"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0057
            goto L_0x0048
        L_0x0040:
            java.lang.String r1 = "SUCCESS"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0057
        L_0x0048:
            com.mpl.payment.phonepe.models.NormalPhonePeTransactionParams r1 = new com.mpl.payment.phonepe.models.NormalPhonePeTransactionParams
            java.lang.String r2 = r0.getOrderId()
            java.lang.String r0 = r0.getResponseType()
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0056:
            return r0
        L_0x0057:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.String r1 = "responseType not recognised, check responsetype from moneyInPayload"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.phonepe.PhonePeTransactionParamsCreator.getTransactionParams():java.lang.Object");
    }
}

package com.mpl.payment.cardverification;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.request.MOKHttpPostRequest;
import com.mpl.network.modules.request.MOKHttpPostRequest.Builder;
import com.mpl.payment.cardverification.models.ChargeCardPayload;
import com.mpl.payment.cardverification.models.PaymentMethodInfo;
import com.mpl.payment.common.AuthTokenProvider;
import com.mpl.payment.common.cardinput.CardInputType;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0006H\u0002R\u0014\u0010\u000e\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006&"}, d2 = {"Lcom/mpl/payment/cardverification/MPLCardVerificationCharger;", "Lcom/mpl/payment/cardverification/VerificationCardCharger;", "headers", "", "Lcom/mpl/network/modules/engine/MHeader;", "cardChargeUrl", "", "cardInputType", "Lcom/mpl/payment/common/cardinput/CardInputType;", "moshi", "Lcom/squareup/moshi/Moshi;", "authTokenProvider", "Lcom/mpl/payment/common/AuthTokenProvider;", "(Ljava/util/List;Ljava/lang/String;Lcom/mpl/payment/common/cardinput/CardInputType;Lcom/squareup/moshi/Moshi;Lcom/mpl/payment/common/AuthTokenProvider;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getAuthTokenProvider", "()Lcom/mpl/payment/common/AuthTokenProvider;", "getCardChargeUrl", "cardChargerListener", "Lcom/mpl/payment/cardverification/CardChargerListener;", "getCardChargerListener", "()Lcom/mpl/payment/cardverification/CardChargerListener;", "setCardChargerListener", "(Lcom/mpl/payment/cardverification/CardChargerListener;)V", "getCardInputType", "()Lcom/mpl/payment/common/cardinput/CardInputType;", "getHeaders", "()Ljava/util/List;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "chargeCard", "", "token", "getPostJson", "processResponse", "response", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: MPLCardVerificationCharger.kt */
public final class MPLCardVerificationCharger implements VerificationCardCharger {
    public final String TAG = "MPLCardVerificationCharger";
    public final AuthTokenProvider authTokenProvider;
    public final String cardChargeUrl;
    public CardChargerListener cardChargerListener;
    public final CardInputType cardInputType;
    public final List<MHeader> headers;
    public final Moshi moshi;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardInputType.values().length];
            $EnumSwitchMapping$0 = iArr;
            CardInputType cardInputType = CardInputType.BRAINTREE_HOSTED_FIELD;
            iArr[0] = 1;
        }
    }

    public MPLCardVerificationCharger(List<MHeader> list, String str, CardInputType cardInputType2, Moshi moshi2, AuthTokenProvider authTokenProvider2) {
        Intrinsics.checkNotNullParameter(list, Constant.HEADER);
        Intrinsics.checkNotNullParameter(str, "cardChargeUrl");
        Intrinsics.checkNotNullParameter(cardInputType2, "cardInputType");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(authTokenProvider2, "authTokenProvider");
        this.headers = list;
        this.cardChargeUrl = str;
        this.cardInputType = cardInputType2;
        this.moshi = moshi2;
        this.authTokenProvider = authTokenProvider2;
    }

    private final String getPostJson(String str) {
        if (this.cardInputType.ordinal() == 0) {
            ChargeCardPayload chargeCardPayload = new ChargeCardPayload(null, new PaymentMethodInfo(str, "killbill-braintree"), null, null, 13, null);
            JsonAdapter<ChargeCardPayload> adapter = this.moshi.adapter(ChargeCardPayload.class);
            Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(ChargeCardPayload::class.java)");
            String json = adapter.toJson(chargeCardPayload);
            Intrinsics.checkNotNullExpressionValue(json, "chargeCardPayloadAdapter.toJson(chargeCardPayload)");
            return json;
        }
        throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " unkown card input type"));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035 A[Catch:{ Exception -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0051 A[Catch:{ Exception -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070 A[Catch:{ Exception -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0078 A[Catch:{ Exception -> 0x00be }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void processResponse(java.lang.String r4) {
        /*
            r3 = this;
            com.squareup.moshi.Moshi r0 = r3.moshi     // Catch:{ Exception -> 0x00be }
            java.lang.Class<com.mpl.payment.cardverification.models.ChargeCardResponse> r1 = com.mpl.payment.cardverification.models.ChargeCardResponse.class
            com.squareup.moshi.JsonAdapter r0 = r0.adapter(r1)     // Catch:{ Exception -> 0x00be }
            java.lang.String r1 = "moshi.adapter(ChargeCardResponse::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x00be }
            java.lang.Object r4 = r0.fromJson(r4)     // Catch:{ Exception -> 0x00be }
            com.mpl.payment.cardverification.models.ChargeCardResponse r4 = (com.mpl.payment.cardverification.models.ChargeCardResponse) r4     // Catch:{ Exception -> 0x00be }
            if (r4 == 0) goto L_0x00a3
            com.mpl.payment.cardverification.models.Status r0 = r4.getStatus()     // Catch:{ Exception -> 0x00be }
            int r0 = r0.getCode()     // Catch:{ Exception -> 0x00be }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L_0x005a
            com.mpl.payment.cardverification.models.Payload r4 = r4.getPayload()     // Catch:{ Exception -> 0x00be }
            if (r4 == 0) goto L_0x0032
            com.mpl.payment.cardverification.models.Data r4 = r4.getData()     // Catch:{ Exception -> 0x00be }
            if (r4 == 0) goto L_0x0032
            java.lang.String r4 = r4.getSessionId()     // Catch:{ Exception -> 0x00be }
            goto L_0x0033
        L_0x0032:
            r4 = 0
        L_0x0033:
            if (r4 != 0) goto L_0x0051
            com.mpl.payment.cardverification.CardChargerListener r4 = r3.cardChargerListener     // Catch:{ Exception -> 0x00be }
            if (r4 == 0) goto L_0x00da
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00be }
            r0.<init>()     // Catch:{ Exception -> 0x00be }
            java.lang.String r1 = r3.TAG     // Catch:{ Exception -> 0x00be }
            r0.append(r1)     // Catch:{ Exception -> 0x00be }
            java.lang.String r1 = " couldn't find session Id"
            r0.append(r1)     // Catch:{ Exception -> 0x00be }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00be }
            r4.onError(r0)     // Catch:{ Exception -> 0x00be }
            goto L_0x00da
        L_0x0051:
            com.mpl.payment.cardverification.CardChargerListener r0 = r3.cardChargerListener     // Catch:{ Exception -> 0x00be }
            if (r0 == 0) goto L_0x00da
            r0.onCardCharged(r4)     // Catch:{ Exception -> 0x00be }
            goto L_0x00da
        L_0x005a:
            com.mpl.payment.cardverification.models.Status r0 = r4.getStatus()     // Catch:{ Exception -> 0x00be }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x00be }
            if (r0 == 0) goto L_0x006d
            boolean r1 = kotlin.text.CharsKt__CharKt.isBlank(r0)     // Catch:{ Exception -> 0x00be }
            if (r1 == 0) goto L_0x006b
            goto L_0x006d
        L_0x006b:
            r1 = 0
            goto L_0x006e
        L_0x006d:
            r1 = 1
        L_0x006e:
            if (r1 != 0) goto L_0x0078
            com.mpl.payment.cardverification.CardChargerListener r4 = r3.cardChargerListener     // Catch:{ Exception -> 0x00be }
            if (r4 == 0) goto L_0x00da
            r4.onError(r0)     // Catch:{ Exception -> 0x00be }
            goto L_0x00da
        L_0x0078:
            com.mpl.payment.cardverification.CardChargerListener r0 = r3.cardChargerListener     // Catch:{ Exception -> 0x00be }
            if (r0 == 0) goto L_0x00da
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00be }
            r1.<init>()     // Catch:{ Exception -> 0x00be }
            java.lang.String r2 = r3.TAG     // Catch:{ Exception -> 0x00be }
            r1.append(r2)     // Catch:{ Exception -> 0x00be }
            java.lang.String r2 = " status code is "
            r1.append(r2)     // Catch:{ Exception -> 0x00be }
            com.mpl.payment.cardverification.models.Status r4 = r4.getStatus()     // Catch:{ Exception -> 0x00be }
            int r4 = r4.getCode()     // Catch:{ Exception -> 0x00be }
            r1.append(r4)     // Catch:{ Exception -> 0x00be }
            java.lang.String r4 = " and message was blank"
            r1.append(r4)     // Catch:{ Exception -> 0x00be }
            java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x00be }
            r0.onError(r4)     // Catch:{ Exception -> 0x00be }
            goto L_0x00da
        L_0x00a3:
            com.mpl.payment.cardverification.CardChargerListener r4 = r3.cardChargerListener     // Catch:{ Exception -> 0x00be }
            if (r4 == 0) goto L_0x00da
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00be }
            r0.<init>()     // Catch:{ Exception -> 0x00be }
            java.lang.String r1 = r3.TAG     // Catch:{ Exception -> 0x00be }
            r0.append(r1)     // Catch:{ Exception -> 0x00be }
            java.lang.String r1 = " issue when decoding response json"
            r0.append(r1)     // Catch:{ Exception -> 0x00be }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00be }
            r4.onError(r0)     // Catch:{ Exception -> 0x00be }
            goto L_0x00da
        L_0x00be:
            r4 = move-exception
            com.mpl.payment.cardverification.CardChargerListener r0 = r3.cardChargerListener
            if (r0 == 0) goto L_0x00da
            java.lang.String r4 = r4.getLocalizedMessage()
            if (r4 == 0) goto L_0x00ca
            goto L_0x00d7
        L_0x00ca:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r1 = r3.TAG
            java.lang.String r2 = " exception when processing /link response"
            java.lang.String r4 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r4, r1, r2)
        L_0x00d7:
            r0.onError(r4)
        L_0x00da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.cardverification.MPLCardVerificationCharger.processResponse(java.lang.String):void");
    }

    public void chargeCard(CardChargerListener cardChargerListener2, String str) {
        Intrinsics.checkNotNullParameter(cardChargerListener2, "cardChargerListener");
        Intrinsics.checkNotNullParameter(str, "token");
        this.cardChargerListener = cardChargerListener2;
        MOKHttpPostRequest build = new Builder().setUrl(this.cardChargeUrl).setHeaders(ArraysKt___ArraysJvmKt.toMutableList((Collection<? extends T>) this.headers)).addHeader(this.authTokenProvider.getAuthHeader()).setPostJsonObject(getPostJson(str)).setRetryOnConnectionFailure(true).setResponseListener(new MPLCardVerificationCharger$chargeCard$serverRequest$1(this, cardChargerListener2)).build();
        Intrinsics.checkNotNullExpressionValue(build, "MOKHttpPostRequest.Build…\n                .build()");
        MClient.executeAsync(build);
    }

    public final AuthTokenProvider getAuthTokenProvider() {
        return this.authTokenProvider;
    }

    public final String getCardChargeUrl() {
        return this.cardChargeUrl;
    }

    public final CardChargerListener getCardChargerListener() {
        return this.cardChargerListener;
    }

    public final CardInputType getCardInputType() {
        return this.cardInputType;
    }

    public final List<MHeader> getHeaders() {
        return this.headers;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final void setCardChargerListener(CardChargerListener cardChargerListener2) {
        this.cardChargerListener = cardChargerListener2;
    }
}

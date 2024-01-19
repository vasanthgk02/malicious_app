package com.braintreepayments.api;

import com.braintreepayments.api.interfaces.ConfigurationListener;
import com.braintreepayments.api.interfaces.PaymentMethodNonceCallback;
import com.braintreepayments.api.models.PaymentMethodBuilder;

public final class TokenizationClient$1 implements ConfigurationListener {
    public final /* synthetic */ PaymentMethodNonceCallback val$callback;
    public final /* synthetic */ BraintreeFragment val$fragment;
    public final /* synthetic */ PaymentMethodBuilder val$paymentMethodBuilder;

    public TokenizationClient$1(PaymentMethodBuilder paymentMethodBuilder, BraintreeFragment braintreeFragment, PaymentMethodNonceCallback paymentMethodNonceCallback) {
        this.val$paymentMethodBuilder = paymentMethodBuilder;
        this.val$fragment = braintreeFragment;
        this.val$callback = paymentMethodNonceCallback;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(3:2|(1:6)|(5:8|9|10|11|43))|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|(1:38)|39|40|42) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x007f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0086 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x008d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0094 */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009b A[Catch:{ JSONException -> 0x00aa }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onConfigurationFetched(com.braintreepayments.api.models.Configuration r11) {
        /*
            r10 = this;
            com.braintreepayments.api.models.PaymentMethodBuilder r0 = r10.val$paymentMethodBuilder
            boolean r0 = r0 instanceof com.braintreepayments.api.models.CardBuilder
            if (r0 == 0) goto L_0x0045
            com.braintreepayments.api.models.GraphQLConfiguration r11 = r11.mGraphQLConfiguration
            java.lang.String r0 = r11.mUrl
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x001d
            java.util.Set<java.lang.String> r11 = r11.mFeatures
            java.lang.String r0 = "tokenize_credit_cards"
            boolean r11 = r11.contains(r0)
            if (r11 == 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r1 = 0
        L_0x001e:
            if (r1 == 0) goto L_0x0045
            com.braintreepayments.api.BraintreeFragment r11 = r10.val$fragment
            com.braintreepayments.api.models.PaymentMethodBuilder r0 = r10.val$paymentMethodBuilder
            com.braintreepayments.api.models.CardBuilder r0 = (com.braintreepayments.api.models.CardBuilder) r0
            com.braintreepayments.api.interfaces.PaymentMethodNonceCallback r1 = r10.val$callback
            java.lang.String r2 = "card.graphql.tokenization.started"
            r11.sendAnalyticsEvent(r2)
            android.content.Context r2 = r11.mContext     // Catch:{ BraintreeException -> 0x0040 }
            com.braintreepayments.api.models.Authorization r3 = r11.mAuthorization     // Catch:{ BraintreeException -> 0x0040 }
            java.lang.String r2 = r0.buildGraphQL(r2, r3)     // Catch:{ BraintreeException -> 0x0040 }
            com.braintreepayments.api.internal.BraintreeGraphQLHttpClient r3 = r11.mGraphQLHttpClient
            com.braintreepayments.api.TokenizationClient$2 r4 = new com.braintreepayments.api.TokenizationClient$2
            r4.<init>(r1, r0, r11)
            r3.post(r2, r4)
            goto L_0x00b6
        L_0x0040:
            r11 = move-exception
            r1.failure(r11)
            goto L_0x00b6
        L_0x0045:
            com.braintreepayments.api.BraintreeFragment r11 = r10.val$fragment
            com.braintreepayments.api.models.PaymentMethodBuilder r0 = r10.val$paymentMethodBuilder
            com.braintreepayments.api.interfaces.PaymentMethodNonceCallback r1 = r10.val$callback
            com.braintreepayments.api.internal.BraintreeHttpClient r11 = r11.mHttpClient
            java.lang.String r2 = "payment_methods/"
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r3 = r0.getApiPath()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = co.hyperverge.hypersnapsdk.c.k.versionedPath(r2)
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            java.lang.String r6 = "_meta"
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00aa }
            r7.<init>()     // Catch:{ JSONException -> 0x00aa }
            java.lang.String r8 = "platform"
            java.lang.String r9 = "android"
            r7.put(r8, r9)     // Catch:{ JSONException -> 0x007f }
        L_0x007f:
            java.lang.String r8 = r0.mSessionId     // Catch:{ JSONException -> 0x00aa }
            java.lang.String r9 = "sessionId"
            r7.put(r9, r8)     // Catch:{ JSONException -> 0x0086 }
        L_0x0086:
            java.lang.String r8 = r0.mSource     // Catch:{ JSONException -> 0x00aa }
            java.lang.String r9 = "source"
            r7.put(r9, r8)     // Catch:{ JSONException -> 0x008d }
        L_0x008d:
            java.lang.String r8 = r0.mIntegration     // Catch:{ JSONException -> 0x00aa }
            java.lang.String r9 = "integration"
            r7.put(r9, r8)     // Catch:{ JSONException -> 0x0094 }
        L_0x0094:
            r3.put(r6, r7)     // Catch:{ JSONException -> 0x00aa }
            boolean r6 = r0.mValidateSet     // Catch:{ JSONException -> 0x00aa }
            if (r6 == 0) goto L_0x00a7
            java.lang.String r6 = "validate"
            boolean r7 = r0.mValidate     // Catch:{ JSONException -> 0x00aa }
            r4.put(r6, r7)     // Catch:{ JSONException -> 0x00aa }
            java.lang.String r6 = "options"
            r5.put(r6, r4)     // Catch:{ JSONException -> 0x00aa }
        L_0x00a7:
            r0.build(r3, r5)     // Catch:{ JSONException -> 0x00aa }
        L_0x00aa:
            java.lang.String r3 = r3.toString()
            com.braintreepayments.api.TokenizationClient$3 r4 = new com.braintreepayments.api.TokenizationClient$3
            r4.<init>(r1, r0)
            r11.post(r2, r3, r4)
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.TokenizationClient$1.onConfigurationFetched(com.braintreepayments.api.models.Configuration):void");
    }
}

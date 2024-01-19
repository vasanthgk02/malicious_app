package com.mpl.payment.juspayhypersdk.amazon.linking;

import androidx.fragment.app.FragmentActivity;
import com.mpl.payment.juspayhypersdk.HyperServiceWrapper;
import com.mpl.payment.juspayhypersdk.amazon.linking.model.AmazonCreateWalletRequest;
import com.mpl.payment.juspayhypersdk.amazon.linking.model.AmazonWalletMplPayload;
import com.mpl.payment.juspayhypersdk.amazon.linking.model.AmazonWalletReactPayload;
import com.mpl.payment.juspayhypersdk.amazon.linking.model.Payload;
import com.mpl.payment.juspayhypersdk.customer.FetchCustomerIdUseCase;
import com.mpl.payment.juspayhypersdk.model.RequestDetails;
import com.mpl.payment.linking.LinkingHandler;
import com.mpl.payment.linking.LinkingListener;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0001'B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u0010&\u001a\u00020\"H\u0002R\u0014\u0010\u000f\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Lcom/mpl/payment/juspayhypersdk/amazon/linking/AmazonWalletLinkingHandler;", "Lcom/mpl/payment/linking/LinkingHandler;", "amazonWalletReactPayload", "Lcom/mpl/payment/juspayhypersdk/amazon/linking/model/AmazonWalletReactPayload;", "amazonWalletMplPayload", "Lcom/mpl/payment/juspayhypersdk/amazon/linking/model/AmazonWalletMplPayload;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "moshi", "Lcom/squareup/moshi/Moshi;", "linkingListener", "Lcom/mpl/payment/linking/LinkingListener;", "fetchCustomerIdUseCase", "Lcom/mpl/payment/juspayhypersdk/customer/FetchCustomerIdUseCase;", "(Lcom/mpl/payment/juspayhypersdk/amazon/linking/model/AmazonWalletReactPayload;Lcom/mpl/payment/juspayhypersdk/amazon/linking/model/AmazonWalletMplPayload;Landroidx/fragment/app/FragmentActivity;Lcom/squareup/moshi/Moshi;Lcom/mpl/payment/linking/LinkingListener;Lcom/mpl/payment/juspayhypersdk/customer/FetchCustomerIdUseCase;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getAmazonWalletMplPayload", "()Lcom/mpl/payment/juspayhypersdk/amazon/linking/model/AmazonWalletMplPayload;", "getAmazonWalletReactPayload", "()Lcom/mpl/payment/juspayhypersdk/amazon/linking/model/AmazonWalletReactPayload;", "getFetchCustomerIdUseCase", "()Lcom/mpl/payment/juspayhypersdk/customer/FetchCustomerIdUseCase;", "getFragmentActivity", "()Landroidx/fragment/app/FragmentActivity;", "getLinkingListener", "()Lcom/mpl/payment/linking/LinkingListener;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "getRequestDetails", "Lcom/mpl/payment/juspayhypersdk/model/RequestDetails;", "performLinking", "", "processResponsePayload", "payload", "Lorg/json/JSONObject;", "sendSuccess", "Companion", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: AmazonWalletLinkingHandler.kt */
public final class AmazonWalletLinkingHandler implements LinkingHandler {
    public static final Companion Companion = new Companion(null);
    public static final String STATUS_SUCCESS = "SUCCESS";
    public final String TAG = "AmazonWalletLinkingHandler";
    public final AmazonWalletMplPayload amazonWalletMplPayload;
    public final AmazonWalletReactPayload amazonWalletReactPayload;
    public final FetchCustomerIdUseCase fetchCustomerIdUseCase;
    public final FragmentActivity fragmentActivity;
    public final LinkingListener linkingListener;
    public final Moshi moshi;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/amazon/linking/AmazonWalletLinkingHandler$Companion;", "", "()V", "STATUS_SUCCESS", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AmazonWalletLinkingHandler.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AmazonWalletLinkingHandler(AmazonWalletReactPayload amazonWalletReactPayload2, AmazonWalletMplPayload amazonWalletMplPayload2, FragmentActivity fragmentActivity2, Moshi moshi2, LinkingListener linkingListener2, FetchCustomerIdUseCase fetchCustomerIdUseCase2) {
        Intrinsics.checkNotNullParameter(amazonWalletReactPayload2, "amazonWalletReactPayload");
        Intrinsics.checkNotNullParameter(amazonWalletMplPayload2, "amazonWalletMplPayload");
        Intrinsics.checkNotNullParameter(fragmentActivity2, "fragmentActivity");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(linkingListener2, "linkingListener");
        Intrinsics.checkNotNullParameter(fetchCustomerIdUseCase2, "fetchCustomerIdUseCase");
        this.amazonWalletReactPayload = amazonWalletReactPayload2;
        this.amazonWalletMplPayload = amazonWalletMplPayload2;
        this.fragmentActivity = fragmentActivity2;
        this.moshi = moshi2;
        this.linkingListener = linkingListener2;
        this.fetchCustomerIdUseCase = fetchCustomerIdUseCase2;
    }

    private final RequestDetails getRequestDetails() {
        Payload payload = new Payload(null, null, this.amazonWalletReactPayload.getClientAuthToken(), this.amazonWalletReactPayload.getSdkWalletIdentifier(), false, 19, null);
        AmazonCreateWalletRequest amazonCreateWalletRequest = new AmazonCreateWalletRequest(null, null, payload, 3, null);
        JsonAdapter<AmazonCreateWalletRequest> adapter = this.moshi.adapter(AmazonCreateWalletRequest.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(AmazonCrea…alletRequest::class.java)");
        String json = adapter.toJson(amazonCreateWalletRequest);
        Intrinsics.checkNotNullExpressionValue(json, "createWalletRequestAdapt…mazonCreateWalletRequest)");
        return new RequestDetails(new JSONObject(json), amazonCreateWalletRequest.getRequestId());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        if (r5 != null) goto L_0x000b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void processResponsePayload(org.json.JSONObject r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0009
            java.lang.String r5 = r5.toString()
            if (r5 == 0) goto L_0x0009
            goto L_0x000b
        L_0x0009:
            java.lang.String r5 = "{}"
        L_0x000b:
            com.squareup.moshi.Moshi r0 = r4.moshi
            java.lang.Class<com.mpl.payment.juspayhypersdk.amazon.linking.model.AmazonCreateWalletResponsePayload> r1 = com.mpl.payment.juspayhypersdk.amazon.linking.model.AmazonCreateWalletResponsePayload.class
            com.squareup.moshi.JsonAdapter r0 = r0.adapter(r1)
            java.lang.String r1 = "moshi.adapter(AmazonCrea…ponsePayload::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Object r0 = r0.fromJson(r5)
            com.mpl.payment.juspayhypersdk.amazon.linking.model.AmazonCreateWalletResponsePayload r0 = (com.mpl.payment.juspayhypersdk.amazon.linking.model.AmazonCreateWalletResponsePayload) r0
            if (r0 == 0) goto L_0x0063
            java.lang.String r1 = r0.getAction()
            java.lang.String r2 = "createWallet"
            r3 = 1
            boolean r1 = kotlin.text.CharsKt__CharKt.equals(r1, r2, r3)
            if (r1 == 0) goto L_0x0040
            java.lang.String r1 = r0.getWallet()
            java.lang.String r2 = "AMAZONPAY"
            boolean r1 = kotlin.text.CharsKt__CharKt.equals(r1, r2, r3)
            if (r1 == 0) goto L_0x0040
            boolean r0 = r0.getLinked()
            if (r0 == 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r3 = 0
        L_0x0041:
            if (r3 == 0) goto L_0x0047
            r4.sendSuccess()
            goto L_0x0062
        L_0x0047:
            com.mpl.payment.linking.LinkingListener r0 = r4.linkingListener
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r4.TAG
            r1.append(r2)
            java.lang.String r2 = " Issue with create wallet response payload from juspay payload is -> "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.onLinkingError(r5)
        L_0x0062:
            return
        L_0x0063:
            java.lang.Exception r5 = new java.lang.Exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r4.TAG
            java.lang.String r2 = " got null response payload when parsing"
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r0, r1, r2)
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.juspayhypersdk.amazon.linking.AmazonWalletLinkingHandler.processResponsePayload(org.json.JSONObject):void");
    }

    private final void sendSuccess() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", "SUCCESS");
        LinkingListener linkingListener2 = this.linkingListener;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        linkingListener2.onLinkingSuccessful(jSONObject2);
    }

    public final AmazonWalletMplPayload getAmazonWalletMplPayload() {
        return this.amazonWalletMplPayload;
    }

    public final AmazonWalletReactPayload getAmazonWalletReactPayload() {
        return this.amazonWalletReactPayload;
    }

    public final FetchCustomerIdUseCase getFetchCustomerIdUseCase() {
        return this.fetchCustomerIdUseCase;
    }

    public final FragmentActivity getFragmentActivity() {
        return this.fragmentActivity;
    }

    public final LinkingListener getLinkingListener() {
        return this.linkingListener;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public void performLinking() {
        RequestDetails requestDetails = getRequestDetails();
        HyperServiceWrapper.process(requestDetails.getRequestPayload(), new AmazonWalletLinkingHandler$performLinking$hyperServiceProcessPayloadListener$1(this), requestDetails.getRequestId(), this.fragmentActivity, this.amazonWalletMplPayload.getMerchantId(), this.amazonWalletMplPayload.getClientId(), this.amazonWalletMplPayload.getEnvironment(), this.fetchCustomerIdUseCase);
    }
}

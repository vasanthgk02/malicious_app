package com.mpl.payment.cardverification;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.cardverification.models.CardVerificationReactPayload;
import com.mpl.payment.common.cardinput.CardInputType;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010#\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u0003H\u0002J\u0018\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020)H\u0002J\u0018\u0010.\u001a\u00020$2\u0006\u0010-\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0010\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020\u0003H\u0002J\u0010\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\u0003H\u0002J\u0010\u00103\u001a\u00020$2\u0006\u00100\u001a\u00020\u0003H\u0002J\b\u00104\u001a\u00020$H\u0002J\u0018\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H\u0002R\u0014\u0010\u000f\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00067"}, d2 = {"Lcom/mpl/payment/cardverification/CardVerificationManager;", "", "reactPayloadString", "", "nonUpgradedCardToken", "paymentMode", "cardInputType", "Lcom/mpl/payment/common/cardinput/CardInputType;", "moshi", "Lcom/squareup/moshi/Moshi;", "threeDSHandlerResolver", "Lcom/mpl/payment/cardverification/ThreeDSHandlerResolver;", "verificationCardCharger", "Lcom/mpl/payment/cardverification/VerificationCardCharger;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/mpl/payment/common/cardinput/CardInputType;Lcom/squareup/moshi/Moshi;Lcom/mpl/payment/cardverification/ThreeDSHandlerResolver;Lcom/mpl/payment/cardverification/VerificationCardCharger;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getCardInputType", "()Lcom/mpl/payment/common/cardinput/CardInputType;", "cardVerificationResultListener", "Lcom/mpl/payment/cardverification/CardVerificationResultListener;", "getCardVerificationResultListener", "()Lcom/mpl/payment/cardverification/CardVerificationResultListener;", "setCardVerificationResultListener", "(Lcom/mpl/payment/cardverification/CardVerificationResultListener;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "getNonUpgradedCardToken", "getPaymentMode", "getReactPayloadString", "getThreeDSHandlerResolver", "()Lcom/mpl/payment/cardverification/ThreeDSHandlerResolver;", "getVerificationCardCharger", "()Lcom/mpl/payment/cardverification/VerificationCardCharger;", "attemptCardVerification", "", "doCardChargeVerification", "token", "doThreeDS", "isCardVerificationOn", "", "getPluginValue", "processBraintree3DSResult", "threeDSResultJsonString", "cardVerificationOn", "processThreeDSSuccess", "send3DSSuccessResult", "nonce", "sendFailedResult", "reason", "sendNoVerificationResult", "sendUserCanceledResult", "sendVerificationNeededResult", "sessionId", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CardVerificationManager.kt */
public final class CardVerificationManager {
    public final String TAG = "CardVerificationManager";
    public final CardInputType cardInputType;
    public CardVerificationResultListener cardVerificationResultListener;
    public final Moshi moshi;
    public final String nonUpgradedCardToken;
    public final String paymentMode;
    public final String reactPayloadString;
    public final ThreeDSHandlerResolver threeDSHandlerResolver;
    public final VerificationCardCharger verificationCardCharger;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CardInputType.values().length];
            $EnumSwitchMapping$0 = iArr;
            CardInputType cardInputType = CardInputType.BRAINTREE_HOSTED_FIELD;
            iArr[0] = 1;
            int[] iArr2 = new int[CardInputType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            CardInputType cardInputType2 = CardInputType.BRAINTREE_HOSTED_FIELD;
            iArr2[0] = 1;
        }
    }

    public CardVerificationManager(String str, String str2, String str3, CardInputType cardInputType2, Moshi moshi2, ThreeDSHandlerResolver threeDSHandlerResolver2, VerificationCardCharger verificationCardCharger2) {
        Intrinsics.checkNotNullParameter(str, "reactPayloadString");
        Intrinsics.checkNotNullParameter(str2, "nonUpgradedCardToken");
        Intrinsics.checkNotNullParameter(str3, "paymentMode");
        Intrinsics.checkNotNullParameter(cardInputType2, "cardInputType");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(threeDSHandlerResolver2, "threeDSHandlerResolver");
        Intrinsics.checkNotNullParameter(verificationCardCharger2, "verificationCardCharger");
        this.reactPayloadString = str;
        this.nonUpgradedCardToken = str2;
        this.paymentMode = str3;
        this.cardInputType = cardInputType2;
        this.moshi = moshi2;
        this.threeDSHandlerResolver = threeDSHandlerResolver2;
        this.verificationCardCharger = verificationCardCharger2;
    }

    private final void doCardChargeVerification(String str) {
        this.verificationCardCharger.chargeCard(new CardVerificationManager$doCardChargeVerification$1(this, str), str);
    }

    private final void doThreeDS(boolean z) {
        this.threeDSHandlerResolver.resolveThreeDSHandler(this.cardInputType).doThreeDSVerification(new CardVerificationManager$doThreeDS$1(this, z));
    }

    private final String getPluginValue() {
        if (this.cardInputType.ordinal() == 0) {
            return "killbill-braintree";
        }
        throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " unknown card input type"));
    }

    private final void processBraintree3DSResult(String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("upgradedNonce");
            boolean z2 = jSONObject.getBoolean("is3dsPossible");
            if (!z) {
                Intrinsics.checkNotNullExpressionValue(string, "upgradedNonce");
                send3DSSuccessResult(string);
            } else if (z2) {
                Intrinsics.checkNotNullExpressionValue(string, "upgradedNonce");
                send3DSSuccessResult(string);
            } else {
                Intrinsics.checkNotNullExpressionValue(string, "upgradedNonce");
                doCardChargeVerification(string);
            }
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = "CardVerificationManager Exception when parsing 3dsResult in processBraintree3DSResult";
            }
            sendFailedResult(message);
        }
    }

    /* access modifiers changed from: private */
    public final void processThreeDSSuccess(boolean z, String str) {
        if (this.cardInputType.ordinal() == 0) {
            processBraintree3DSResult(str, z);
        }
    }

    private final void send3DSSuccessResult(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", "3DS_SUCCESS");
        jSONObject.put("nonce", str);
        jSONObject.put("paymentMode", this.paymentMode);
        jSONObject.put("plugin", getPluginValue());
        CardVerificationResultListener cardVerificationResultListener2 = this.cardVerificationResultListener;
        if (cardVerificationResultListener2 != null) {
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "resultJson.toString()");
            cardVerificationResultListener2.onCardVerificationAttemptSuccess(jSONObject2);
        }
    }

    /* access modifiers changed from: private */
    public final void sendFailedResult(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", "FAILED");
        jSONObject.put("reason", str);
        jSONObject.put("paymentMode", this.paymentMode);
        CardVerificationResultListener cardVerificationResultListener2 = this.cardVerificationResultListener;
        if (cardVerificationResultListener2 != null) {
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "failJson.toString()");
            cardVerificationResultListener2.onCardVerificationAttemptFail(jSONObject2);
        }
    }

    private final void sendNoVerificationResult(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", "NO_VERIFICATION");
        jSONObject.put("nonce", str);
        jSONObject.put("paymentMode", this.paymentMode);
        jSONObject.put("plugin", getPluginValue());
        CardVerificationResultListener cardVerificationResultListener2 = this.cardVerificationResultListener;
        if (cardVerificationResultListener2 != null) {
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "resultJson.toString()");
            cardVerificationResultListener2.onCardVerificationAttemptSuccess(jSONObject2);
        }
    }

    /* access modifiers changed from: private */
    public final void sendUserCanceledResult() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", "USER_CANCELED");
        CardVerificationResultListener cardVerificationResultListener2 = this.cardVerificationResultListener;
        if (cardVerificationResultListener2 != null) {
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "resultJson.toString()");
            cardVerificationResultListener2.onCardVerificationAttemptFail(jSONObject2);
        }
    }

    /* access modifiers changed from: private */
    public final void sendVerificationNeededResult(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", "VERIFICATION_NEEDED");
        jSONObject.put("nonce", str2);
        jSONObject.put("paymentMode", this.paymentMode);
        jSONObject.put("plugin", getPluginValue());
        jSONObject.put("sessionId", str);
        CardVerificationResultListener cardVerificationResultListener2 = this.cardVerificationResultListener;
        if (cardVerificationResultListener2 != null) {
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "resultJson.toString()");
            cardVerificationResultListener2.onCardVerificationAttemptSuccess(jSONObject2);
        }
    }

    public final void attemptCardVerification(CardVerificationResultListener cardVerificationResultListener2) {
        Intrinsics.checkNotNullParameter(cardVerificationResultListener2, "cardVerificationResultListener");
        this.cardVerificationResultListener = cardVerificationResultListener2;
        JsonAdapter<CardVerificationReactPayload> adapter = this.moshi.adapter(CardVerificationReactPayload.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(CardVerifi…ReactPayload::class.java)");
        CardVerificationReactPayload cardVerificationReactPayload = (CardVerificationReactPayload) adapter.fromJson(this.reactPayloadString);
        if (cardVerificationReactPayload == null) {
            sendFailedResult(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " react payload was null"));
        } else if (cardVerificationReactPayload.is3DSOn() && !cardVerificationReactPayload.isCardVerificationOn()) {
            doThreeDS(false);
        } else if (!cardVerificationReactPayload.is3DSOn() && cardVerificationReactPayload.isCardVerificationOn()) {
            doCardChargeVerification(this.nonUpgradedCardToken);
        } else if (cardVerificationReactPayload.is3DSOn() && cardVerificationReactPayload.isCardVerificationOn()) {
            doThreeDS(true);
        } else if (!cardVerificationReactPayload.is3DSOn() && !cardVerificationReactPayload.isCardVerificationOn()) {
            sendNoVerificationResult(this.nonUpgradedCardToken);
        }
    }

    public final CardInputType getCardInputType() {
        return this.cardInputType;
    }

    public final CardVerificationResultListener getCardVerificationResultListener() {
        return this.cardVerificationResultListener;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final String getNonUpgradedCardToken() {
        return this.nonUpgradedCardToken;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final String getReactPayloadString() {
        return this.reactPayloadString;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final ThreeDSHandlerResolver getThreeDSHandlerResolver() {
        return this.threeDSHandlerResolver;
    }

    public final VerificationCardCharger getVerificationCardCharger() {
        return this.verificationCardCharger;
    }

    public final void setCardVerificationResultListener(CardVerificationResultListener cardVerificationResultListener2) {
        this.cardVerificationResultListener = cardVerificationResultListener2;
    }
}

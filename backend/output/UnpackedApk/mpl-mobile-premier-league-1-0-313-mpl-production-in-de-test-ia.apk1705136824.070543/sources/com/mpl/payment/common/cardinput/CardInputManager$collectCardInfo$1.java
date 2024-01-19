package com.mpl.payment.common.cardinput;

import com.mpl.payment.common.cardinput.models.CardInputResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"com/mpl/payment/common/cardinput/CardInputManager$collectCardInfo$1", "Lcom/mpl/payment/common/cardinput/CardTokenizationResultListener;", "onError", "", "message", "", "onTokenizationSuccess", "token", "tokenisationResultJsonString", "onUserCancelled", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CardInputManager.kt */
public final class CardInputManager$collectCardInfo$1 implements CardTokenizationResultListener {
    public final /* synthetic */ CardInputResultListener $cardInputResultListener;
    public final /* synthetic */ CardInputType $cardInputType;
    public final /* synthetic */ String $routingPayloadJsonString;
    public final /* synthetic */ CardInputManager this$0;

    public CardInputManager$collectCardInfo$1(CardInputManager cardInputManager, CardInputType cardInputType, String str, CardInputResultListener cardInputResultListener) {
        this.this$0 = cardInputManager;
        this.$cardInputType = cardInputType;
        this.$routingPayloadJsonString = str;
        this.$cardInputResultListener = cardInputResultListener;
    }

    public void onError(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.$cardInputResultListener.onCardInputError(str);
    }

    public void onTokenizationSuccess(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(str2, "tokenisationResultJsonString");
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (this.this$0.isTokenisedCardDuplicate(jSONObject, this.$cardInputType)) {
                this.this$0.sendDuplicateCardStatus();
                return;
            }
            CardInputResult cardInputResult = new CardInputResult(this.$cardInputType, str2, this.$routingPayloadJsonString, str, this.this$0.getPaymentMode(this.$cardInputType, jSONObject));
            this.$cardInputResultListener.onCardInputSuccessFull(cardInputResult);
        } catch (Exception e2) {
            CardInputResultListener cardInputResultListener = this.$cardInputResultListener;
            String message = e2.getMessage();
            if (message == null) {
                message = this.this$0.getTAG() + " Exception in onTokenizationSuccess";
            }
            cardInputResultListener.onCardInputError(message);
        }
    }

    public void onUserCancelled() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", "USER_CANCELED");
        CardInputResultListener cardInputResultListener = this.$cardInputResultListener;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "failedJson.toString()");
        cardInputResultListener.onCardInputFailed(jSONObject2);
    }
}

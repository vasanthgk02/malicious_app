package com.mpl.payment.cardverification;

import androidx.appcompat.app.AppCompatActivity;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.braintree.BTThreeDSHandler;
import com.mpl.payment.common.cardinput.CardInputType;
import com.mpl.payment.common.cardinput.models.CardInputResult;
import com.mpl.payment.routing.RoutingConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0014\u0010\u000b\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/mpl/payment/cardverification/MPLThreeDSHandlerResolver;", "Lcom/mpl/payment/cardverification/ThreeDSHandlerResolver;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "reactPayloadString", "", "nonUpgradedCardToken", "routingPayloadJsonString", "cardInputResult", "Lcom/mpl/payment/common/cardinput/models/CardInputResult;", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/mpl/payment/common/cardinput/models/CardInputResult;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "getCardInputResult", "()Lcom/mpl/payment/common/cardinput/models/CardInputResult;", "getNonUpgradedCardToken", "getReactPayloadString", "getRoutingPayloadJsonString", "resolveThreeDSHandler", "Lcom/mpl/payment/cardverification/ThreeDSHandler;", "cardInputType", "Lcom/mpl/payment/common/cardinput/CardInputType;", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: MPLThreeDSHandlerResolver.kt */
public final class MPLThreeDSHandlerResolver implements ThreeDSHandlerResolver {
    public final String TAG = "MPLThreeDSHandlerResolver";
    public final AppCompatActivity activity;
    public final CardInputResult cardInputResult;
    public final String nonUpgradedCardToken;
    public final String reactPayloadString;
    public final String routingPayloadJsonString;

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

    public MPLThreeDSHandlerResolver(AppCompatActivity appCompatActivity, String str, String str2, String str3, CardInputResult cardInputResult2) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(str, "reactPayloadString");
        Intrinsics.checkNotNullParameter(str2, "nonUpgradedCardToken");
        Intrinsics.checkNotNullParameter(str3, "routingPayloadJsonString");
        Intrinsics.checkNotNullParameter(cardInputResult2, "cardInputResult");
        this.activity = appCompatActivity;
        this.reactPayloadString = str;
        this.nonUpgradedCardToken = str2;
        this.routingPayloadJsonString = str3;
        this.cardInputResult = cardInputResult2;
    }

    public final AppCompatActivity getActivity() {
        return this.activity;
    }

    public final CardInputResult getCardInputResult() {
        return this.cardInputResult;
    }

    public final String getNonUpgradedCardToken() {
        return this.nonUpgradedCardToken;
    }

    public final String getReactPayloadString() {
        return this.reactPayloadString;
    }

    public final String getRoutingPayloadJsonString() {
        return this.routingPayloadJsonString;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public ThreeDSHandler resolveThreeDSHandler(CardInputType cardInputType) {
        Intrinsics.checkNotNullParameter(cardInputType, "cardInputType");
        if (cardInputType.ordinal() == 0) {
            String string = new JSONObject(this.routingPayloadJsonString).getJSONObject("data").getString("clientToken");
            String string2 = new JSONObject(this.reactPayloadString).getString("amount");
            String string3 = new JSONObject(this.cardInputResult.getTokenizationResultJsonString()).getString("paymentMode");
            AppCompatActivity appCompatActivity = this.activity;
            Intrinsics.checkNotNullExpressionValue(string, "clientToken");
            String str = this.nonUpgradedCardToken;
            Intrinsics.checkNotNullExpressionValue(string2, "amount");
            Intrinsics.checkNotNullExpressionValue(string3, RoutingConstants.MI_REACT_SAVED_CARD_TYPE);
            BTThreeDSHandler bTThreeDSHandler = new BTThreeDSHandler(appCompatActivity, string, str, string2, string3);
            return bTThreeDSHandler;
        }
        throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " Unknown card input type"));
    }
}

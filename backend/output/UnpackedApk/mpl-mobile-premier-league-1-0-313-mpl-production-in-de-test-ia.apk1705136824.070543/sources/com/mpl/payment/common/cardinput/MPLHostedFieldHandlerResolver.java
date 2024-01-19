package com.mpl.payment.common.cardinput;

import android.app.Activity;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.braintree.hostedfields.BTHostedFieldHandler;
import com.mpl.payment.braintree.hostedfields.BtHostedFieldsParams;
import com.mpl.payment.common.MPLInstrumentationListener;
import com.mpl.payment.routing.RoutingConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fH\u0016R\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/mpl/payment/common/cardinput/MPLHostedFieldHandlerResolver;", "Lcom/mpl/payment/common/cardinput/HostedFieldHandlerResolver;", "moshi", "Lcom/squareup/moshi/Moshi;", "activity", "Landroid/app/Activity;", "braintreeRequestCode", "", "mplInstrumentationListener", "Lcom/mpl/payment/common/MPLInstrumentationListener;", "(Lcom/squareup/moshi/Moshi;Landroid/app/Activity;ILcom/mpl/payment/common/MPLInstrumentationListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getActivity", "()Landroid/app/Activity;", "getBraintreeRequestCode", "()I", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "getMplInstrumentationListener", "()Lcom/mpl/payment/common/MPLInstrumentationListener;", "getHostedFieldHandler", "Lcom/mpl/payment/common/cardinput/HostedFieldHandler;", "cardInputType", "Lcom/mpl/payment/common/cardinput/CardInputType;", "payload", "reactPayload", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: MPLHostedFieldHandlerResolver.kt */
public final class MPLHostedFieldHandlerResolver implements HostedFieldHandlerResolver {
    public final String TAG = "HostedFieldHandlerResolverImpl";
    public final Activity activity;
    public final int braintreeRequestCode;
    public final Moshi moshi;
    public final MPLInstrumentationListener mplInstrumentationListener;

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

    public MPLHostedFieldHandlerResolver(Moshi moshi2, Activity activity2, int i, MPLInstrumentationListener mPLInstrumentationListener) {
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(mPLInstrumentationListener, "mplInstrumentationListener");
        this.moshi = moshi2;
        this.activity = activity2;
        this.braintreeRequestCode = i;
        this.mplInstrumentationListener = mPLInstrumentationListener;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final int getBraintreeRequestCode() {
        return this.braintreeRequestCode;
    }

    public HostedFieldHandler getHostedFieldHandler(CardInputType cardInputType, String str, String str2) {
        Intrinsics.checkNotNullParameter(cardInputType, "cardInputType");
        Intrinsics.checkNotNullParameter(str, "payload");
        Intrinsics.checkNotNullParameter(str2, "reactPayload");
        if (cardInputType.ordinal() == 0) {
            JsonAdapter<BtHostedFieldsParams> adapter = this.moshi.adapter(BtHostedFieldsParams.class);
            Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(BtHostedFieldsParams::class.java)");
            BtHostedFieldsParams btHostedFieldsParams = (BtHostedFieldsParams) adapter.fromJson(str);
            if (btHostedFieldsParams != null) {
                JSONObject jSONObject = new JSONObject(str2);
                String string = jSONObject.getString(RoutingConstants.MI_REACT_CARD_SHOULD_SAVE);
                String string2 = jSONObject.getString("isCardVerificationOn");
                Activity activity2 = this.activity;
                int i = this.braintreeRequestCode;
                Intrinsics.checkNotNullExpressionValue(string, "showCardSavingMessage");
                Intrinsics.checkNotNullExpressionValue(string2, "isCardVerificationEnabled");
                BTHostedFieldHandler bTHostedFieldHandler = new BTHostedFieldHandler(btHostedFieldsParams, activity2, i, string, string2, this.mplInstrumentationListener);
                return bTHostedFieldHandler;
            }
            throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " btHostedFieldParams was null"));
        }
        throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " inputType doesn't have a hosted field resolver"));
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final MPLInstrumentationListener getMplInstrumentationListener() {
        return this.mplInstrumentationListener;
    }

    public final String getTAG() {
        return this.TAG;
    }
}

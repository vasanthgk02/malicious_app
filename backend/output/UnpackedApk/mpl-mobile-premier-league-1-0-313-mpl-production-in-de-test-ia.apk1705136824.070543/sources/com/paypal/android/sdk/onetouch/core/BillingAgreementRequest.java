package com.paypal.android.sdk.onetouch.core;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.paypal.android.sdk.onetouch.core.config.BillingAgreementRecipe;
import com.paypal.android.sdk.onetouch.core.config.OtcConfiguration;
import com.paypal.android.sdk.onetouch.core.config.Recipe;
import com.paypal.android.sdk.onetouch.core.enums.RequestTarget;
import java.util.ArrayList;
import java.util.Iterator;

public class BillingAgreementRequest extends CheckoutRequest {
    public static final Creator<BillingAgreementRequest> CREATOR = new Creator<BillingAgreementRequest>() {
        public Object createFromParcel(Parcel parcel) {
            return new BillingAgreementRequest(parcel);
        }

        public Object[] newArray(int i) {
            return new BillingAgreementRequest[i];
        }
    };

    public BillingAgreementRequest() {
    }

    public CheckoutRequest approvalURL(String str) {
        this.mApprovalUrl = str;
        this.mTokenQueryParamKey = "token";
        this.mTokenQueryParamKey = "ba_token";
        return this;
    }

    public Recipe getRecipeToExecute(Context context, OtcConfiguration otcConfiguration) {
        Iterator it = new ArrayList(otcConfiguration.mBillingAgreementRecipesInDecreasingPriorityOrder).iterator();
        while (it.hasNext()) {
            BillingAgreementRecipe billingAgreementRecipe = (BillingAgreementRecipe) it.next();
            RequestTarget requestTarget = RequestTarget.wallet;
            RequestTarget requestTarget2 = billingAgreementRecipe.mTarget;
            if (requestTarget == requestTarget2) {
                if (billingAgreementRecipe.isValidAppTarget(context)) {
                    return billingAgreementRecipe;
                }
            } else if (RequestTarget.browser == requestTarget2 && billingAgreementRecipe.isValidBrowserTarget(context, this.mApprovalUrl)) {
                return billingAgreementRecipe;
            }
        }
        return null;
    }

    public BillingAgreementRequest pairingId(Context context, String str) {
        super.pairingId(context, str);
        return this;
    }

    public BillingAgreementRequest(Parcel parcel) {
        super(parcel);
    }

    /* renamed from: pairingId  reason: collision with other method in class */
    public CheckoutRequest m32pairingId(Context context, String str) {
        super.pairingId(context, str);
        return this;
    }
}

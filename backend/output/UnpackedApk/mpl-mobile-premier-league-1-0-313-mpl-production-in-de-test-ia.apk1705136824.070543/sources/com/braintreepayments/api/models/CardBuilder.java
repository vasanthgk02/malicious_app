package com.braintreepayments.api.models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.braintreepayments.api.exceptions.BraintreeException;
import com.mpl.payment.routing.RoutingConstants;
import com.paynimo.android.payment.UPIFragment;
import com.rudderstack.android.sdk.core.RudderTraits;
import org.json.JSONException;
import org.json.JSONObject;

public class CardBuilder extends BaseCardBuilder<CardBuilder> implements Parcelable {
    public static final Creator<CardBuilder> CREATOR = new Creator<CardBuilder>() {
        public Object createFromParcel(Parcel parcel) {
            return new CardBuilder(parcel);
        }

        public Object[] newArray(int i) {
            return new CardBuilder[i];
        }
    };
    public boolean mAuthenticationInsightRequested;
    public String mMerchantAccountId;

    public CardBuilder() {
    }

    public void build(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        super.build(jSONObject, jSONObject2);
        if (this.mAuthenticationInsightRequested) {
            jSONObject.put("merchantAccountId", this.mMerchantAccountId);
            jSONObject.put("authenticationInsight", this.mAuthenticationInsightRequested);
        }
    }

    public void buildGraphQL(Context context, JSONObject jSONObject, JSONObject jSONObject2) throws BraintreeException, JSONException {
        JSONObject jSONObject3 = jSONObject2.getJSONObject("input");
        if (!TextUtils.isEmpty(this.mMerchantAccountId) || !this.mAuthenticationInsightRequested) {
            if (this.mAuthenticationInsightRequested) {
                jSONObject2.put("authenticationInsightInput", new JSONObject().put("merchantAccountId", this.mMerchantAccountId));
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("mutation TokenizeCreditCard($input: TokenizeCreditCardInput!");
            if (this.mAuthenticationInsightRequested) {
                outline73.append(", $authenticationInsightInput: AuthenticationInsightInput!");
            }
            outline73.append(") {  tokenizeCreditCard(input: $input) {    token    creditCard {      bin      brand      expirationMonth      expirationYear      cardholderName      last4      binData {        prepaid        healthcare        debit        durbinRegulated        commercial        payroll        issuingBank        countryOfIssuance        productId      }    }");
            if (this.mAuthenticationInsightRequested) {
                outline73.append("    authenticationInsight(input: $authenticationInsightInput) {      customerAuthenticationRegulationEnvironment    }");
            }
            outline73.append("  }}");
            jSONObject.put("query", outline73.toString());
            jSONObject.put("operationName", "TokenizeCreditCard");
            JSONObject put = new JSONObject().put(UPIFragment.CONFIG_TYPE_NUMBER, this.mCardnumber).put("expirationMonth", this.mExpirationMonth).put("expirationYear", this.mExpirationYear).put("cvv", this.mCvv).put("cardholderName", this.mCardholderName);
            JSONObject put2 = new JSONObject().put("firstName", this.mFirstName).put("lastName", this.mLastName).put(RudderTraits.COMPANY_KEY, this.mCompany).put("countryCode", this.mCountryCode).put("locality", this.mLocality).put(RoutingConstants.MI_REACT_POSTAL_CODE, this.mPostalCode).put("region", this.mRegion).put("streetAddress", this.mStreetAddress).put("extendedAddress", this.mExtendedAddress);
            if (put2.length() > 0) {
                put.put("billingAddress", put2);
            }
            jSONObject3.put("creditCard", put);
            return;
        }
        throw new BraintreeException("A merchant account ID is required when authenticationInsightRequested is true.");
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mMerchantAccountId);
        parcel.writeByte(this.mAuthenticationInsightRequested ? (byte) 1 : 0);
    }

    public CardBuilder(Parcel parcel) {
        super(parcel);
        this.mMerchantAccountId = parcel.readString();
        this.mAuthenticationInsightRequested = parcel.readByte() > 0;
    }
}

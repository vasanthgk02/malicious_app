package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.braintreepayments.api.exceptions.InvalidArgumentException;
import com.razorpay.BaseConstants;
import in.juspay.hypersdk.core.PaymentConstants.ENVIRONMENT;

public class TokenizationKey extends Authorization implements Parcelable {
    public static final Creator<TokenizationKey> CREATOR = new Creator<TokenizationKey>() {
        public Object createFromParcel(Parcel parcel) {
            return new TokenizationKey(parcel);
        }

        public Object[] newArray(int i) {
            return new TokenizationKey[i];
        }
    };
    public final String mEnvironment;
    public final String mMerchantId;
    public final String mUrl;

    public enum BraintreeEnvironment {
        DEVELOPMENT(BaseConstants.DEVELOPMENT, "http://10.0.2.2:3000/"),
        SANDBOX(ENVIRONMENT.SANDBOX, "https://api.sandbox.braintreegateway.com/"),
        PRODUCTION("production", "https://api.braintreegateway.com/");
        
        public String mEnvironment;
        public String mUrl;

        /* access modifiers changed from: public */
        BraintreeEnvironment(String str, String str2) {
            this.mEnvironment = str;
            this.mUrl = str2;
        }

        public static String getUrl(String str) throws InvalidArgumentException {
            for (BraintreeEnvironment braintreeEnvironment : values()) {
                if (braintreeEnvironment.mEnvironment.equals(str)) {
                    return braintreeEnvironment.mUrl;
                }
            }
            throw new InvalidArgumentException("Tokenization Key contained invalid environment");
        }
    }

    public TokenizationKey(String str) throws InvalidArgumentException {
        super(str);
        String[] split = str.split("_", 3);
        this.mEnvironment = split[0];
        this.mMerchantId = split[2];
        StringBuilder sb = new StringBuilder();
        sb.append(BraintreeEnvironment.getUrl(this.mEnvironment));
        sb.append("merchants/");
        this.mUrl = GeneratedOutlineSupport.outline62(sb, this.mMerchantId, "/client_api/");
    }

    public int describeContents() {
        return 0;
    }

    public String getBearer() {
        return this.mRawValue;
    }

    public String getConfigUrl() {
        return GeneratedOutlineSupport.outline62(new StringBuilder(), this.mUrl, "v1/configuration");
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mRawValue);
        parcel.writeString(this.mEnvironment);
        parcel.writeString(this.mMerchantId);
        parcel.writeString(this.mUrl);
    }

    public TokenizationKey(Parcel parcel) {
        super(parcel);
        this.mEnvironment = parcel.readString();
        this.mMerchantId = parcel.readString();
        this.mUrl = parcel.readString();
    }
}

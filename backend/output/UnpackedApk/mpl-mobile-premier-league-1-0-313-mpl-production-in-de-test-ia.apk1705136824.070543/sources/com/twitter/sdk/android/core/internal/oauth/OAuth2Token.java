package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.AuthToken;

public class OAuth2Token extends AuthToken implements Parcelable {
    public static final Creator<OAuth2Token> CREATOR = new Creator<OAuth2Token>() {
        public Object createFromParcel(Parcel parcel) {
            return new OAuth2Token(parcel, (AnonymousClass1) null);
        }

        public Object[] newArray(int i) {
            return new OAuth2Token[i];
        }
    };
    @SerializedName("access_token")
    public final String accessToken;
    @SerializedName("token_type")
    public final String tokenType;

    public OAuth2Token(String str, String str2) {
        this.tokenType = str;
        this.accessToken = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OAuth2Token oAuth2Token = (OAuth2Token) obj;
        String str = this.accessToken;
        if (str == null ? oAuth2Token.accessToken != null : !str.equals(oAuth2Token.accessToken)) {
            return false;
        }
        String str2 = this.tokenType;
        String str3 = oAuth2Token.tokenType;
        return str2 == null ? str3 == null : str2.equals(str3);
    }

    public int hashCode() {
        String str = this.tokenType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.accessToken;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.tokenType);
        parcel.writeString(this.accessToken);
    }

    public OAuth2Token(Parcel parcel, AnonymousClass1 r2) {
        this.tokenType = parcel.readString();
        this.accessToken = parcel.readString();
    }
}

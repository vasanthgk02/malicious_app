package com.twitter.sdk.android.core.internal.oauth;

import com.google.gson.annotations.SerializedName;

public class GuestAuthToken extends OAuth2Token {
    @SerializedName("guest_token")
    public final String guestToken;

    public GuestAuthToken(String str, String str2, String str3) {
        super(str, str2);
        this.guestToken = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GuestAuthToken.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        String str = this.guestToken;
        String str2 = ((GuestAuthToken) obj).guestToken;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.guestToken;
        return hashCode + (str != null ? str.hashCode() : 0);
    }
}

package com.google.firebase.installations.remote;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.installations.remote.TokenResult.ResponseCode;

public final class AutoValue_TokenResult extends TokenResult {
    public final ResponseCode responseCode;
    public final String token;
    public final long tokenExpirationTimestamp;

    public static final class Builder extends com.google.firebase.installations.remote.TokenResult.Builder {
        public ResponseCode responseCode;
        public String token;
        public Long tokenExpirationTimestamp;

        public TokenResult build() {
            String str = this.tokenExpirationTimestamp == null ? " tokenExpirationTimestamp" : "";
            if (str.isEmpty()) {
                AutoValue_TokenResult autoValue_TokenResult = new AutoValue_TokenResult(this.token, this.tokenExpirationTimestamp.longValue(), this.responseCode, null);
                return autoValue_TokenResult;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.installations.remote.TokenResult.Builder setTokenExpirationTimestamp(long j) {
            this.tokenExpirationTimestamp = Long.valueOf(j);
            return this;
        }
    }

    public AutoValue_TokenResult(String str, long j, ResponseCode responseCode2, AnonymousClass1 r5) {
        this.token = str;
        this.tokenExpirationTimestamp = j;
        this.responseCode = responseCode2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.token;
        if (str != null ? str.equals(((AutoValue_TokenResult) tokenResult).token) : ((AutoValue_TokenResult) tokenResult).token == null) {
            if (this.tokenExpirationTimestamp == ((AutoValue_TokenResult) tokenResult).tokenExpirationTimestamp) {
                ResponseCode responseCode2 = this.responseCode;
                if (responseCode2 != null) {
                }
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        String str = this.token;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.tokenExpirationTimestamp;
        int i2 = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        ResponseCode responseCode2 = this.responseCode;
        if (responseCode2 != null) {
            i = responseCode2.hashCode();
        }
        return i2 ^ i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("TokenResult{token=");
        outline73.append(this.token);
        outline73.append(", tokenExpirationTimestamp=");
        outline73.append(this.tokenExpirationTimestamp);
        outline73.append(", responseCode=");
        outline73.append(this.responseCode);
        outline73.append("}");
        return outline73.toString();
    }
}

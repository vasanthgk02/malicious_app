package com.google.firebase.installations.remote;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.installations.remote.InstallationResponse.ResponseCode;

public final class AutoValue_InstallationResponse extends InstallationResponse {
    public final TokenResult authToken;
    public final String fid;
    public final String refreshToken;
    public final ResponseCode responseCode;
    public final String uri;

    public AutoValue_InstallationResponse(String str, String str2, String str3, TokenResult tokenResult, ResponseCode responseCode2, AnonymousClass1 r6) {
        this.uri = str;
        this.fid = str2;
        this.refreshToken = str3;
        this.authToken = tokenResult;
        this.responseCode = responseCode2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationResponse)) {
            return false;
        }
        InstallationResponse installationResponse = (InstallationResponse) obj;
        String str = this.uri;
        if (str != null ? str.equals(((AutoValue_InstallationResponse) installationResponse).uri) : ((AutoValue_InstallationResponse) installationResponse).uri == null) {
            String str2 = this.fid;
            if (str2 != null ? str2.equals(((AutoValue_InstallationResponse) installationResponse).fid) : ((AutoValue_InstallationResponse) installationResponse).fid == null) {
                String str3 = this.refreshToken;
                if (str3 != null ? str3.equals(((AutoValue_InstallationResponse) installationResponse).refreshToken) : ((AutoValue_InstallationResponse) installationResponse).refreshToken == null) {
                    TokenResult tokenResult = this.authToken;
                    if (tokenResult != null ? tokenResult.equals(((AutoValue_InstallationResponse) installationResponse).authToken) : ((AutoValue_InstallationResponse) installationResponse).authToken == null) {
                        ResponseCode responseCode2 = this.responseCode;
                        if (responseCode2 != null) {
                        }
                    }
                }
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        String str = this.uri;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.fid;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.refreshToken;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        TokenResult tokenResult = this.authToken;
        int hashCode4 = (hashCode3 ^ (tokenResult == null ? 0 : tokenResult.hashCode())) * 1000003;
        ResponseCode responseCode2 = this.responseCode;
        if (responseCode2 != null) {
            i = responseCode2.hashCode();
        }
        return hashCode4 ^ i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("InstallationResponse{uri=");
        outline73.append(this.uri);
        outline73.append(", fid=");
        outline73.append(this.fid);
        outline73.append(", refreshToken=");
        outline73.append(this.refreshToken);
        outline73.append(", authToken=");
        outline73.append(this.authToken);
        outline73.append(", responseCode=");
        outline73.append(this.responseCode);
        outline73.append("}");
        return outline73.toString();
    }
}

package com.freshchat.consumer.sdk.beans.reqres;

public class ValidateJwtIdTokenResponse {
    public boolean userAliasExists;
    public boolean validToken;

    public boolean isUserAliasExists() {
        return this.userAliasExists;
    }

    public boolean isValidToken() {
        return this.validToken;
    }

    public void setUserAliasExists(boolean z) {
        this.userAliasExists = z;
    }

    public void setValidToken(boolean z) {
        this.validToken = z;
    }
}

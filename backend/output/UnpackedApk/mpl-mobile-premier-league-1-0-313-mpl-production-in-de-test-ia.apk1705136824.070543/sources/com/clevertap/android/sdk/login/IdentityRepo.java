package com.clevertap.android.sdk.login;

public interface IdentityRepo {
    IdentitySet getIdentitySet();

    boolean hasIdentity(String str);
}

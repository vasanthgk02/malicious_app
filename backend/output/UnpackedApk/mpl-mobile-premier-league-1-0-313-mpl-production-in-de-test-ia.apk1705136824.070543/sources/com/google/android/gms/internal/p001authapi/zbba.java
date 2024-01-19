package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.common.Feature;

/* renamed from: com.google.android.gms.internal.auth-api.zbba  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbba {
    public static final Feature zba = new Feature("auth_api_credentials_begin_sign_in", 6);
    public static final Feature zbb = new Feature("auth_api_credentials_sign_out", 2);
    public static final Feature zbc = new Feature("auth_api_credentials_authorize", 1);
    public static final Feature zbd = new Feature("auth_api_credentials_revoke_access", 1);
    public static final Feature zbe = new Feature("auth_api_credentials_save_password", 4);
    public static final Feature zbf = new Feature("auth_api_credentials_get_sign_in_intent", 6);
    public static final Feature zbg = new Feature("auth_api_credentials_save_account_linking_token", 3);
    public static final Feature zbh;
    public static final Feature[] zbi;

    static {
        Feature feature = new Feature("auth_api_credentials_get_phone_number_hint_intent", 3);
        zbh = feature;
        zbi = new Feature[]{zba, zbb, zbc, zbd, zbe, zbf, zbg, feature};
    }
}

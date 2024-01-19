package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.mpl.androidapp.utils.Constant;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zad {
    public static final ClientKey zaa = new ClientKey();
    @ShowFirstParty
    public static final ClientKey zab = new ClientKey();
    public static final AbstractClientBuilder zac = new zaa();
    public static final AbstractClientBuilder zad = new zab();
    public static final Api zag = new Api("SignIn.API", zac, zaa);

    static {
        new Scope(Constant.PROFILE);
        new Scope("email");
        new Api("SignIn.INTERNAL_API", zad, zab);
    }
}

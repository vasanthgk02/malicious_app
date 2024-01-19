package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.moduleinstall.ModuleInstallClient;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zay extends GoogleApi implements ModuleInstallClient {
    public static final /* synthetic */ int zab = 0;
    public static final ClientKey zac = new ClientKey();
    public static final AbstractClientBuilder zad;

    static {
        zaq zaq = new zaq();
        zad = zaq;
        new Api("ModuleInstall.API", zaq, zac);
    }
}

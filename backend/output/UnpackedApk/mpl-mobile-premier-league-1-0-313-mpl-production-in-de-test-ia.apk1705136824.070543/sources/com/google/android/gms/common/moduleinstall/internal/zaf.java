package com.google.android.gms.common.moduleinstall.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaf extends zaa implements IInterface {
    public zaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.moduleinstall.internal.IModuleInstallService");
    }

    public final void zag(zae zae, ApiFeatureRequest apiFeatureRequest, zah zah) throws RemoteException {
        Parcel zaa = zaa();
        zac.zae(zaa, zae);
        zac.zad(zaa, null);
        zac.zae(zaa, null);
        zac(2, zaa);
    }
}

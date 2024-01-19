package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.view.View;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import com.google.android.gms.internal.base.zac;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaz extends RemoteCreator {
    public static final zaz zaa = new zaz();

    public zaz() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View zaa(Context context, int i, int i2) throws RemoteCreatorException {
        zaz zaz = zaa;
        try {
            zax zax = new zax(1, i, i2, null);
            ObjectWrapper objectWrapper = new ObjectWrapper(context);
            zam zam = (zam) zaz.getRemoteCreatorInstance(context);
            Parcel zaa2 = zam.zaa();
            zac.zae(zaa2, objectWrapper);
            zac.zad(zaa2, zax);
            Parcel zab = zam.zab(2, zaa2);
            IObjectWrapper asInterface = Stub.asInterface(zab.readStrongBinder());
            zab.recycle();
            return (View) ObjectWrapper.unwrap(asInterface);
        } catch (Exception e2) {
            throw new RemoteCreatorException(GeneratedOutlineSupport.outline43("Could not get button with size ", i, " and color ", i2), e2);
        }
    }

    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return queryLocalInterface instanceof zam ? (zam) queryLocalInterface : new zam(iBinder);
    }
}

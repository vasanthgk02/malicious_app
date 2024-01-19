package com.google.android.gms.internal.p001authapi;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zbs  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public interface zbs extends IInterface {
    void zbb(Status status, Credential credential) throws RemoteException;

    void zbc(Status status) throws RemoteException;

    void zbd(Status status, String str) throws RemoteException;
}

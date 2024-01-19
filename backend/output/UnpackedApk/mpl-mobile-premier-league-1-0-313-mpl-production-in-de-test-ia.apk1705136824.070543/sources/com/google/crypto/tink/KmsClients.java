package com.google.crypto.tink;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class KmsClients {
    public static final CopyOnWriteArrayList<KmsClient> clients = new CopyOnWriteArrayList<>();

    public static KmsClient get(String str) throws GeneralSecurityException {
        Iterator<KmsClient> it = clients.iterator();
        while (it.hasNext()) {
            KmsClient next = it.next();
            if (next.doesSupport(str)) {
                return next;
            }
        }
        throw new GeneralSecurityException(GeneratedOutlineSupport.outline50("No KMS client does support: ", str));
    }
}

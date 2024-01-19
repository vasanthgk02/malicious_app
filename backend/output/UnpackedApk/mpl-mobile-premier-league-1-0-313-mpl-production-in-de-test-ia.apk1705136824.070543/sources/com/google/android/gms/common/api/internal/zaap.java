package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.zab;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaap extends zaav {
    public final /* synthetic */ zaaw zaa;
    public final ArrayList zac;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zaap(zaaw zaaw, ArrayList arrayList) {
        // this.zaa = zaaw;
        super(zaaw);
        this.zac = arrayList;
    }

    public final void zaa() {
        Set set;
        zaaw zaaw = this.zaa;
        zabe zabe = zaaw.zaa.zag;
        ClientSettings clientSettings = zaaw.zar;
        if (clientSettings == null) {
            set = Collections.emptySet();
        } else {
            AbstractSet hashSet = new HashSet(clientSettings.zab);
            Map map = zaaw.zar.zad;
            for (Api api : map.keySet()) {
                if (!zaaw.zaa.zab.containsKey(api.zab)) {
                    hashSet.addAll(((zab) map.get(api)).zaa);
                }
            }
            set = hashSet;
        }
        zabe.zad = set;
        ArrayList arrayList = this.zac;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zaaw zaaw2 = this.zaa;
            ((Client) arrayList.get(i)).getRemoteService(zaaw2.zao, zaaw2.zaa.zag.zad);
        }
    }
}

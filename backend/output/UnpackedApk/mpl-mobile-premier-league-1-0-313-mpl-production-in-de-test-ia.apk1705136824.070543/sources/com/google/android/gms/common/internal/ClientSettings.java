package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@KeepForSdk
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class ClientSettings {
    public final Account zaa;
    public final Set zab;
    public final Set zac;
    public final Map zad;
    public final String zag;
    public final String zah;
    public final SignInOptions zai;
    public Integer zaj;

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public static final class Builder {
        public Account zaa;
        public ArraySet zab;
        public String zac;
        public String zad;
        public SignInOptions zae = SignInOptions.zaa;

        @KeepForSdk
        public ClientSettings build() {
            ClientSettings clientSettings = new ClientSettings(this.zaa, this.zab, null, 0, null, this.zac, this.zad, this.zae);
            return clientSettings;
        }
    }

    public ClientSettings(Account account, Set set, Map map, int i, View view, String str, String str2, SignInOptions signInOptions) {
        this.zaa = account;
        this.zab = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.zad = map == null ? Collections.emptyMap() : map;
        this.zag = str;
        this.zah = str2;
        this.zai = signInOptions == null ? SignInOptions.zaa : signInOptions;
        HashSet hashSet = new HashSet(this.zab);
        for (zab zab2 : this.zad.values()) {
            hashSet.addAll(zab2.zaa);
        }
        this.zac = Collections.unmodifiableSet(hashSet);
    }
}

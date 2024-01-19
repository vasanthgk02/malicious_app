package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.MapCollections.ArrayIterator;
import androidx.collection.MapCollections.KeySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class AvailabilityException extends Exception {
    public final ArrayMap zaa;

    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((KeySet) this.zaa.keySet()).iterator();
        boolean z = true;
        while (true) {
            ArrayIterator arrayIterator = (ArrayIterator) it;
            if (!arrayIterator.hasNext()) {
                break;
            }
            ApiKey apiKey = (ApiKey) arrayIterator.next();
            ConnectionResult connectionResult = (ConnectionResult) this.zaa.get(apiKey);
            Preconditions.checkNotNull(connectionResult);
            z &= !connectionResult.isSuccess();
            String str = apiKey.zab.zac;
            String valueOf = String.valueOf(connectionResult);
            arrayList.add(str + ": " + valueOf);
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("None of the queried APIs are available. ");
        } else {
            sb.append("Some of the queried APIs are unavailable. ");
        }
        sb.append(TextUtils.join("; ", arrayList));
        return sb.toString();
    }
}

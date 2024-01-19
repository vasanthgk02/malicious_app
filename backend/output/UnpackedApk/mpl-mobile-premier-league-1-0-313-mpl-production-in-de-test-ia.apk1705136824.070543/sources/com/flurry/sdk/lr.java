package com.flurry.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class lr extends BroadcastReceiver {

    /* renamed from: b  reason: collision with root package name */
    public boolean f1697b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1698d = false;

    public lr() {
        throw null;
    }

    public final boolean a(Context context) {
        if (!this.f1698d || context == null) {
            return true;
        }
        throw null;
    }

    public final void onReceive(Context context, Intent intent) {
        mi miVar;
        List list;
        a(context);
        if (!this.f1697b) {
            this.f1697b = true;
            if (TextUtils.isEmpty("com.flurry.android.sdk.NetworkStateEvent")) {
                throw new IllegalArgumentException("Event must have a name!");
            } else if (!this.f1698d) {
                synchronized (mi.class) {
                    if (mi.f1700a == null) {
                        mi.f1700a = new mi();
                    }
                    miVar = mi.f1700a;
                }
                if (miVar != null) {
                    synchronized (miVar) {
                        if (TextUtils.isEmpty("com.flurry.android.sdk.NetworkStateEvent")) {
                            list = Collections.emptyList();
                        } else {
                            ArrayList arrayList = new ArrayList();
                            md<String, mw<mh<?>>> mdVar = miVar.f1701b;
                            if (mdVar != null) {
                                List list2 = mdVar.f1699a.get("com.flurry.android.sdk.NetworkStateEvent");
                                if (list2 == null) {
                                    list2 = Collections.emptyList();
                                }
                                Iterator it = list2.iterator();
                                while (it.hasNext()) {
                                    mh mhVar = (mh) ((mw) it.next()).get();
                                    if (mhVar == null) {
                                        it.remove();
                                    } else {
                                        arrayList.add(mhVar);
                                    }
                                }
                                list = arrayList;
                            } else {
                                throw null;
                            }
                        }
                    }
                    Iterator it2 = list.iterator();
                    if (it2.hasNext()) {
                        mh mhVar2 = (mh) it2.next();
                        throw null;
                    }
                    return;
                }
                throw null;
            } else {
                throw null;
            }
        }
    }
}

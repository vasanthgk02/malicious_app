package com.freshchat.consumer.sdk.service.a;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.reqres.CsatResponseRequest;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.a;
import com.freshchat.consumer.sdk.service.d.d;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.t;

public class g extends d {
    public static final String TAG = "com.freshchat.consumer.sdk.service.a.g";

    public g(Context context, a aVar) {
        super(context, aVar);
    }

    public void ds() {
        try {
            a dt = dt();
            ab ch = ch();
            final String dr = dt.dr();
            t tVar = new t();
            tVar.a((CsatResponseRequest) ch.fromJson(dt.getMeta().get("fc_csat_response"), CsatResponseRequest.class));
            d.c(getContext(), tVar, new a() {
                public void a(k kVar) {
                    if (kVar != null) {
                        try {
                            if (kVar.isSuccess()) {
                                String str = g.TAG;
                                ai.d(str, "Csat upload success on backlog " + dr + ". Removing entry");
                                aa.l(g.this.getContext(), dr);
                                return;
                            }
                        } catch (Exception e2) {
                            q.a(e2);
                            return;
                        }
                    }
                    String str2 = g.TAG;
                    ai.d(str2, "Could not upload csat on backlog " + dr + ". Keeping the entry");
                }
            });
        } catch (Exception unused) {
        }
    }
}

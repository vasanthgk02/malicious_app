package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.e.a;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.e.ap;
import com.freshchat.consumer.sdk.service.e.h;
import com.freshchat.consumer.sdk.service.e.k;

public class ak extends a<ap, k> {
    public boolean a(ap apVar) {
        return w.ay(getContext());
    }

    public k b(ap apVar) {
        h hVar = new h(true);
        boolean z = false;
        if (!a(apVar)) {
            hVar.setSuccess(false);
            return hVar;
        } else if (!al.aS(getContext())) {
            hVar.setSuccess(false);
            return hVar;
        } else {
            try {
                z = new a(getContext()).a(apVar.dn(), apVar.fo(), apVar.getReferenceId());
            } catch (DeletedException e2) {
                q.a(e2);
            }
            hVar.setSuccess(z);
            return hVar;
        }
    }
}

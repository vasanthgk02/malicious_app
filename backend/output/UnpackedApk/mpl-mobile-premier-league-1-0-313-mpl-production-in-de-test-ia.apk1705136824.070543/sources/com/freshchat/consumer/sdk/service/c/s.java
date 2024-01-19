package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.e.a;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.n;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.e.h;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.u;

public class s extends a<u, k> {
    public boolean a(u uVar) {
        boolean z = false;
        if (!w.ay(getContext())) {
            return false;
        }
        boolean bl = dw().bl();
        long currentTimeMillis = System.currentTimeMillis();
        if (bl) {
            String cc = dw().cc();
            if (as.isEmpty(cc)) {
                return true;
            }
            long parseLong = Long.parseLong(cc);
            if (currentTimeMillis > parseLong && n.c(parseLong, currentTimeMillis)) {
                z = true;
            }
            return z;
        }
        String gP = dw().gP();
        if (as.isEmpty(gP)) {
            return true;
        }
        long parseLong2 = Long.parseLong(gP);
        if (currentTimeMillis > parseLong2 && n.e(parseLong2, currentTimeMillis)) {
            z = true;
        }
        return z;
    }

    public k b(u uVar) {
        boolean z;
        if (a(uVar)) {
            try {
                if (new a(getContext()).cX()) {
                    e dw = dw();
                    if (dw.bl()) {
                        dw.cd();
                    } else {
                        dw.gQ();
                    }
                }
            } catch (DeletedException | Exception e2) {
                q.a(e2);
            }
            z = true;
        } else {
            z = false;
        }
        return new h(z);
    }
}

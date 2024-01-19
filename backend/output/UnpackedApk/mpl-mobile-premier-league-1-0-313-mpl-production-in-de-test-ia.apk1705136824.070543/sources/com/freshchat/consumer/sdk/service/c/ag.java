package com.freshchat.consumer.sdk.service.c;

import android.os.Bundle;
import com.freshchat.consumer.sdk.b.a;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.j.y;
import com.freshchat.consumer.sdk.service.Status;
import com.freshchat.consumer.sdk.service.e.ah;
import com.freshchat.consumer.sdk.service.e.ai;

public class ag extends a<ah, ai> {
    private Bundle a(ai aiVar) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("RESPONSE", aiVar);
        return bundle;
    }

    private void b(ai aiVar) {
        a.c(getContext(), a(aiVar));
    }

    /* renamed from: a */
    public ai b(ah ahVar) {
        Status status;
        ai aiVar = new ai();
        if (!b(ahVar)) {
            status = Status.ERROR;
        } else if (!al.aS(getContext())) {
            status = Status.NO_INTERNET;
        } else {
            ai a2 = new com.freshchat.consumer.sdk.e.a(getContext()).a(ahVar.iU(), ahVar.getCategoryId(), ahVar.getTags());
            b(a2);
            return a2;
        }
        aiVar.setStatus(status);
        b(aiVar);
        return aiVar;
    }

    public boolean b(ah ahVar) {
        return w.ay(getContext()) && w.az(getContext()) && y.cp(getContext());
    }
}

package com.freshchat.consumer.sdk.service.e;

import android.os.Bundle;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.j.y;
import com.freshchat.consumer.sdk.service.Status;
import com.freshchat.consumer.sdk.service.c.a;

public class al extends a<ak, ai> {
    private void a(String str, ai aiVar) {
        com.freshchat.consumer.sdk.b.a.e(getContext(), b(str, aiVar));
    }

    private Bundle b(String str, ai aiVar) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("RESPONSE", aiVar);
        bundle.putString("SEARCH_TERM", str);
        return bundle;
    }

    /* renamed from: a */
    public ai b(ak akVar) {
        Status status;
        ai aiVar = new ai();
        String iW = akVar.iW();
        if (!b(akVar)) {
            status = Status.ERROR;
        } else if (!com.freshchat.consumer.sdk.j.al.aS(getContext())) {
            status = Status.NO_INTERNET;
        } else {
            ai b2 = new com.freshchat.consumer.sdk.e.a(getContext()).b(akVar.iU(), iW, akVar.getTags());
            a(iW, b2);
            return b2;
        }
        aiVar.setStatus(status);
        a(iW, aiVar);
        return aiVar;
    }

    public boolean b(ak akVar) {
        return w.ay(getContext()) && w.az(getContext()) && y.cp(getContext());
    }
}

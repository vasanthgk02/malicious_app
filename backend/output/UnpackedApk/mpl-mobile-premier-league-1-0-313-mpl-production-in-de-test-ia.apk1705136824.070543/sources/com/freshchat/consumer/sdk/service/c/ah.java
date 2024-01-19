package com.freshchat.consumer.sdk.service.c;

import android.os.Bundle;
import com.freshchat.consumer.sdk.b.a;
import com.freshchat.consumer.sdk.b.m;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.j.y;
import com.freshchat.consumer.sdk.service.Status;
import com.freshchat.consumer.sdk.service.e.am;
import com.freshchat.consumer.sdk.service.e.an;
import com.freshchat.consumer.sdk.service.e.k;

public class ah extends a<am, k> {
    private Bundle a(an anVar) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("RESPONSE", anVar);
        return bundle;
    }

    private void b(an anVar) {
        a.f(getContext(), a(anVar));
    }

    /* renamed from: a */
    public k b(am amVar) {
        Status status;
        an anVar = new an();
        if (!b(amVar)) {
            status = Status.ERROR;
        } else if (!al.aS(getContext())) {
            status = Status.NO_INTERNET;
        } else {
            String faqId = amVar.getFaqId();
            String categoryId = amVar.getCategoryId();
            String value = amVar.iX().getValue();
            String locale = amVar.getLocale();
            String lastUpdatedAt = amVar.getLastUpdatedAt();
            an d2 = new com.freshchat.consumer.sdk.e.a(getContext()).d(categoryId, faqId, value, locale);
            if (d2.getStatus() == Status.SUCCESS) {
                new m(getContext()).c(categoryId, faqId, value, lastUpdatedAt);
            }
            b(d2);
            return d2;
        }
        anVar.setStatus(status);
        b(anVar);
        return anVar;
    }

    public boolean b(am amVar) {
        return w.ay(getContext()) && w.az(getContext()) && y.cp(getContext());
    }
}

package com.freshchat.consumer.sdk.service.c;

import android.os.Bundle;
import com.freshchat.consumer.sdk.b.a;
import com.freshchat.consumer.sdk.beans.FAQFetchRequest;
import com.freshchat.consumer.sdk.beans.reqres.FAQFetchResponse;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.j.y;
import com.freshchat.consumer.sdk.service.Status;

public class af extends a<FAQFetchRequest, FAQFetchResponse> {
    private Bundle a(FAQFetchResponse fAQFetchResponse) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("RESPONSE", fAQFetchResponse);
        return bundle;
    }

    private void b(FAQFetchResponse fAQFetchResponse) {
        a.d(getContext(), a(fAQFetchResponse));
    }

    /* renamed from: a */
    public FAQFetchResponse b(FAQFetchRequest fAQFetchRequest) {
        Status status;
        FAQFetchResponse fAQFetchResponse = new FAQFetchResponse();
        if (!b(fAQFetchRequest)) {
            status = Status.ERROR;
        } else if (!al.aS(getContext())) {
            status = Status.NO_INTERNET;
        } else {
            String categoryId = fAQFetchRequest.getCategoryId();
            FAQFetchResponse l = new com.freshchat.consumer.sdk.e.a(getContext()).l(fAQFetchRequest.getFaqId(), categoryId);
            b(l);
            return l;
        }
        fAQFetchResponse.setStatus(status);
        b(fAQFetchResponse);
        return fAQFetchResponse;
    }

    public boolean b(FAQFetchRequest fAQFetchRequest) {
        return w.ay(getContext()) && w.az(getContext()) && y.cp(getContext());
    }
}

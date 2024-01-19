package com.freshchat.consumer.sdk.service.c;

import android.os.Bundle;
import com.freshchat.consumer.sdk.b.a;
import com.freshchat.consumer.sdk.beans.FAQCategoryFetchRequest;
import com.freshchat.consumer.sdk.beans.FAQCategoryFetchResponse;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.j.y;
import com.freshchat.consumer.sdk.service.Status;

public class ae extends a<FAQCategoryFetchRequest, FAQCategoryFetchResponse> {
    private Bundle a(FAQCategoryFetchResponse fAQCategoryFetchResponse) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("RESPONSE", fAQCategoryFetchResponse);
        return bundle;
    }

    private void b(FAQCategoryFetchResponse fAQCategoryFetchResponse) {
        a.b(getContext(), a(fAQCategoryFetchResponse));
    }

    /* renamed from: a */
    public FAQCategoryFetchResponse b(FAQCategoryFetchRequest fAQCategoryFetchRequest) {
        Status status;
        FAQCategoryFetchResponse fAQCategoryFetchResponse = new FAQCategoryFetchResponse();
        if (!b(fAQCategoryFetchRequest)) {
            status = Status.ERROR;
        } else if (!al.aS(getContext())) {
            status = Status.NO_INTERNET;
        } else {
            FAQCategoryFetchResponse a2 = new com.freshchat.consumer.sdk.e.a(getContext()).a(fAQCategoryFetchRequest.getPageIndex(), fAQCategoryFetchRequest.getTags());
            b(a2);
            return a2;
        }
        fAQCategoryFetchResponse.setStatus(status);
        b(fAQCategoryFetchResponse);
        return fAQCategoryFetchResponse;
    }

    public boolean b(FAQCategoryFetchRequest fAQCategoryFetchRequest) {
        return w.ay(getContext()) && w.az(getContext()) && y.cp(getContext());
    }
}

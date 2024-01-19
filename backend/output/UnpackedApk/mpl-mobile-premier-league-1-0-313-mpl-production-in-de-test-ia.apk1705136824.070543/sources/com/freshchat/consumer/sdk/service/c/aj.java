package com.freshchat.consumer.sdk.service.c;

import android.os.Bundle;
import com.freshchat.consumer.sdk.b.a;
import com.freshchat.consumer.sdk.beans.BotFAQFetchRequest;
import com.freshchat.consumer.sdk.beans.reqres.BotFAQFetchResponse;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.Status;

public class aj extends a<BotFAQFetchRequest, BotFAQFetchResponse> {
    private Bundle a(BotFAQFetchResponse botFAQFetchResponse) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("RESPONSE", botFAQFetchResponse);
        return bundle;
    }

    private void b(BotFAQFetchResponse botFAQFetchResponse) {
        a.g(getContext(), a(botFAQFetchResponse));
    }

    /* renamed from: a */
    public BotFAQFetchResponse b(BotFAQFetchRequest botFAQFetchRequest) {
        Status status;
        BotFAQFetchResponse botFAQFetchResponse = new BotFAQFetchResponse();
        if (!b(botFAQFetchRequest)) {
            status = Status.ERROR;
        } else if (!al.aS(getContext())) {
            status = Status.NO_INTERNET;
        } else {
            BotFAQFetchResponse z = new com.freshchat.consumer.sdk.e.a(getContext()).z(botFAQFetchRequest.getReferenceId(), botFAQFetchRequest.getPlaceholderReferenceId());
            b(z);
            return z;
        }
        botFAQFetchResponse.setStatus(status);
        b(botFAQFetchResponse);
        return botFAQFetchResponse;
    }

    public boolean b(BotFAQFetchRequest botFAQFetchRequest) {
        return w.ay(getContext());
    }
}

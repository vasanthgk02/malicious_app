package com.freshchat.consumer.sdk.service.d;

import android.content.Context;
import com.freshchat.consumer.sdk.j.as;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class b {
    public static String fN = UUID.randomUUID().toString();
    public Context context;
    public a fO;
    public Map<String, String> fP;

    public enum a {
        faqs_launch,
        faq_open_category,
        faq_open_article,
        faq_search,
        faq_upvote_article,
        faq_downvote_article,
        channels_launch,
        conversation_send_message,
        conversation_launch,
        faq_search_launch,
        conversation_deeplink_launch
    }

    public b(Context context2, a aVar) {
        this(context2, aVar, "SDK");
    }

    public b(Context context2, a aVar, String str) {
        this.fP = new HashMap();
        this.context = context2;
        this.fO = aVar;
        g("type", str);
    }

    public void dB() {
    }

    public b g(String str, String str2) {
        if (!as.isEmpty(str) && !as.isEmpty(str2)) {
            this.fP.put(str, str2);
        }
        return this;
    }
}

package com.freshchat.consumer.sdk.j;

import android.os.Bundle;
import com.freshchat.consumer.sdk.ConversationOptions;
import java.util.ArrayList;

public class l {
    public static Bundle a(ConversationOptions conversationOptions) {
        Bundle bundle = new Bundle();
        if (conversationOptions != null) {
            ArrayList arrayList = new ArrayList(conversationOptions.getTags());
            if (k.a(arrayList)) {
                bundle.putStringArrayList("CONVERSATION_TAG_LIST", arrayList);
            }
            if (as.a(conversationOptions.getFilteredViewTitle())) {
                bundle.putString("CONVERSATION_TAG_VIEW_TITLE", conversationOptions.getFilteredViewTitle());
            }
        }
        return bundle;
    }

    public static ConversationOptions c(Bundle bundle) {
        ConversationOptions conversationOptions = new ConversationOptions();
        if (bundle != null && bundle.containsKey("CONVERSATION_TAG_LIST")) {
            conversationOptions.filterByTags(bundle.getStringArrayList("CONVERSATION_TAG_LIST"), bundle.getString("CONVERSATION_TAG_VIEW_TITLE"));
        }
        return conversationOptions;
    }
}

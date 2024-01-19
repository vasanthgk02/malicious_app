package com.freshchat.consumer.sdk;

import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.z;
import java.util.ArrayList;
import java.util.Collection;

public class ConversationOptions implements z {
    public String filteredViewTitle;
    public Collection<String> tags = new ArrayList();

    public ConversationOptions filterByTags(Collection<String> collection, String str) {
        this.tags.clear();
        if (k.a(collection)) {
            this.tags.addAll(k.c(collection));
            this.filteredViewTitle = str;
        }
        return this;
    }

    public String getFilteredViewTitle() {
        return this.filteredViewTitle;
    }

    public Collection<String> getTags() {
        ArrayList arrayList = new ArrayList();
        if (k.a(this.tags)) {
            arrayList.addAll(this.tags);
        }
        return arrayList;
    }
}

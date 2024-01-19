package com.freshchat.consumer.sdk.beans;

import com.freshchat.consumer.sdk.service.e.j;
import java.util.List;

public class FAQCategoryFetchRequest implements j {
    public int pageIndex;
    public List<String> tags;

    public FAQCategoryFetchRequest(int i, List<String> list) {
        this.pageIndex = i;
        this.tags = list;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public List<String> getTags() {
        return this.tags;
    }
}

package com.freshchat.consumer.sdk.beans;

import com.freshchat.consumer.sdk.service.e.j;

public class FAQFetchRequest implements j {
    public String categoryId;
    public String faqId;

    public FAQFetchRequest(String str, String str2) {
        this.faqId = str;
        this.categoryId = str2;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getFaqId() {
        return this.faqId;
    }
}

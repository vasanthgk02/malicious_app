package com.freshchat.consumer.sdk.beans.reqres;

import com.freshchat.consumer.sdk.beans.Conversation;
import java.util.ArrayList;
import java.util.List;

public class ConversationsResponse {
    public List<Conversation> conversations = new ArrayList();
    public int statusCode;

    public List<Conversation> getConversations() {
        return this.conversations;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setConversations(List<Conversation> list) {
        this.conversations = list;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }
}

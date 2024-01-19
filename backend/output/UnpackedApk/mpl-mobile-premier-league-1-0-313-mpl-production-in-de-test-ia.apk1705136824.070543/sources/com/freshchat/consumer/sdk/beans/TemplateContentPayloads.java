package com.freshchat.consumer.sdk.beans;

import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import java.util.List;

public class TemplateContentPayloads {
    public List<MessageFragment> callbacks;
    public List<MessageFragment> description;
    public List<MessageFragment> title;

    public List<MessageFragment> getCallbacks() {
        return this.callbacks;
    }

    public List<MessageFragment> getDescription() {
        return this.description;
    }

    public List<MessageFragment> getTitle() {
        return this.title;
    }
}

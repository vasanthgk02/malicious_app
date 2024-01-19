package com.freshchat.consumer.sdk.beans;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedList;

public class MessageMaskingConfig {
    @SerializedName("androidMessageMasks")
    public LinkedList<MessageMask> messageMasks;

    public LinkedList<MessageMask> getMessageMasks() {
        return this.messageMasks;
    }

    public void setMessageMasks(LinkedList<MessageMask> linkedList) {
        this.messageMasks = linkedList;
    }
}

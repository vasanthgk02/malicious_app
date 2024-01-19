package com.freshchat.consumer.sdk.service.e;

import com.freshchat.consumer.sdk.beans.fragment.CallbackButtonFragment;

public class ap implements j {
    public final String ej;
    public final CallbackButtonFragment jS;
    public final String referenceId;

    public ap(String str, CallbackButtonFragment callbackButtonFragment, String str2) {
        this.ej = str;
        this.jS = callbackButtonFragment;
        this.referenceId = str2;
    }

    public String dn() {
        return this.ej;
    }

    public CallbackButtonFragment fo() {
        return this.jS;
    }

    public String getReferenceId() {
        return this.referenceId;
    }
}

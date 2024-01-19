package com.freshchat.consumer.sdk.beans.fragment;

public class UnknownFragment extends MessageFragment {
    public String rawJsonOfUnsupportedType;

    public UnknownFragment(int i) {
        super(i);
    }

    public String getRawJsonOfUnsupportedType() {
        return this.rawJsonOfUnsupportedType;
    }

    public void setRawJsonOfUnsupportedType(String str) {
        this.rawJsonOfUnsupportedType = str;
    }
}

package com.freshchat.consumer.sdk.beans.fragment;

public class StaticTemplateFragment extends MessageFragment {
    public String label;
    public String placeholderReferenceId;
    public String referenceId;

    public StaticTemplateFragment() {
        super(FragmentType.STATIC_TEMPLATE.asInt());
    }

    public String getLabel() {
        return this.label;
    }

    public String getPlaceholderReferenceId() {
        return this.placeholderReferenceId;
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setPlaceholderReferenceId(String str) {
        this.placeholderReferenceId = str;
    }

    public void setReferenceId(String str) {
        this.referenceId = str;
    }
}

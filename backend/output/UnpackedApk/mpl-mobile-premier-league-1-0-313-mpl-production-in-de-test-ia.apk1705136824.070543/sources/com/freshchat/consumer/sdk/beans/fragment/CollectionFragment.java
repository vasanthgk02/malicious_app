package com.freshchat.consumer.sdk.beans.fragment;

import java.util.List;

public class CollectionFragment extends MessageFragment {
    public List<MessageFragment> fragments;

    public CollectionFragment() {
        super(FragmentType.COLLECTION.asInt());
    }

    public List<MessageFragment> getFragments() {
        return this.fragments;
    }
}

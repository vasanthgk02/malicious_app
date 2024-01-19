package com.freshchat.consumer.sdk.beans.fragment;

import com.android.tools.r8.GeneratedOutlineSupport;

public class AudioFragment extends MessageFragment {
    public int duration;

    public AudioFragment() {
        super(FragmentType.AUDIO.asInt());
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("AudioFragment{duration=");
        outline73.append(this.duration);
        outline73.append("} ");
        outline73.append(super.toString());
        return outline73.toString();
    }
}

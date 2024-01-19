package com.freshchat.consumer.sdk.m;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentManager;

public class w implements OnClickListener {
    public final /* synthetic */ t pp;

    public w(t tVar) {
        this.pp = tVar;
    }

    public void onClick(View view) {
        FragmentManager fragmentManager = this.pp.getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.popBackStack();
        }
    }
}

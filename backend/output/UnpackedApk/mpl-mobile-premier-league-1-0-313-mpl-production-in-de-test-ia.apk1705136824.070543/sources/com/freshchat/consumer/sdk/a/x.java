package com.freshchat.consumer.sdk.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.beans.fragment.StaticTemplateFragment;

public class x implements OnClickListener {
    public final /* synthetic */ StaticTemplateFragment jC;
    public final /* synthetic */ w jD;

    public x(w wVar, StaticTemplateFragment staticTemplateFragment) {
        this.jD = wVar;
        this.jC = staticTemplateFragment;
    }

    public void onClick(View view) {
        this.jD.jA.a(view, this.jC, this.jD.jB);
    }
}

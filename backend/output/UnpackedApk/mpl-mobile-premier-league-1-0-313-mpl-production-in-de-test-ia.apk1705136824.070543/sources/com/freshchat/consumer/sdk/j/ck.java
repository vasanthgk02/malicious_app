package com.freshchat.consumer.sdk.j;

import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.j.cj.a;

public final class ck implements OnClickListener {
    public final /* synthetic */ Message os;
    public final /* synthetic */ a pQ;

    public ck(a aVar, Message message) {
        this.pQ = aVar;
        this.os = message;
    }

    public void onClick(View view) {
        a aVar = this.pQ;
        if (aVar != null) {
            aVar.p(this.os);
        }
    }
}

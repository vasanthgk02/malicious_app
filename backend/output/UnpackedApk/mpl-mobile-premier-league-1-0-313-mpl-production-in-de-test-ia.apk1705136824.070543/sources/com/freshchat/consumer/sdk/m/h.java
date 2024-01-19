package com.freshchat.consumer.sdk.m;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class h implements OnClickListener {
    public final /* synthetic */ f pb;

    public h(f fVar) {
        this.pb = fVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.pb.hM();
    }
}

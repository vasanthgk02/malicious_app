package com.freshchat.consumer.sdk.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Csat;
import com.freshchat.consumer.sdk.j.bg;

public class bo implements OnClickListener {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ boolean kJ;
    public final /* synthetic */ RatingBar sI;
    public final /* synthetic */ boolean so;
    public final /* synthetic */ EditText ta;
    public final /* synthetic */ Csat tb;

    public bo(ConversationDetailActivity conversationDetailActivity, boolean z, RatingBar ratingBar, EditText editText, Csat csat, boolean z2) {
        this.be = conversationDetailActivity;
        this.so = z;
        this.sI = ratingBar;
        this.ta = editText;
        this.tb = csat;
        this.kJ = z2;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        int progress = (!this.so || !i.f(this.sI)) ? 0 : this.sI.getProgress();
        String str = null;
        if (i.f(this.ta)) {
            str = this.ta.getText().toString();
            i.a(this.be.getContext(), (View) this.ta);
        }
        String str2 = str;
        this.be.a(this.tb, this.kJ, progress, str2);
        bg.a(this.be.getContext(), this.be.channelId, this.kJ, progress, str2);
        this.be.aY();
    }
}

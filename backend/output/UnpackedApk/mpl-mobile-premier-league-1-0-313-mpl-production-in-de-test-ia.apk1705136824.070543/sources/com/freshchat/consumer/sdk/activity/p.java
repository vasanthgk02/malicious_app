package com.freshchat.consumer.sdk.activity;

import android.os.CountDownTimer;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.service.e.d.a;

public class p extends CountDownTimer {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ long sn;
    public final /* synthetic */ double sp;
    public final /* synthetic */ long sq;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public p(ConversationDetailActivity conversationDetailActivity, long j, long j2, long j3, double d2, long j4) {
        // this.be = conversationDetailActivity;
        // this.sn = j3;
        // this.sp = d2;
        // this.sq = j4;
        super(j, j2);
    }

    public void onFinish() {
        if (al.aS(this.be.getApplicationContext())) {
            b.a(this.be.getApplicationContext(), as.a(this.be.G().bP()) ? 11 : 12, a.IMMEDIATE);
            ai.d("FRESHCHAT", "Polling for new Messages");
        }
        this.be.b(Math.min((long) (((double) this.sn) * this.sp), this.sq));
    }

    public void onTick(long j) {
    }
}

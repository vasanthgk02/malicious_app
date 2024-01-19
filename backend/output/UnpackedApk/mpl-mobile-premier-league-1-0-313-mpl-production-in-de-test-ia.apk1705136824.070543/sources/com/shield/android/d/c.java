package com.shield.android.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.paynimo.android.payment.util.Constant;

public class c extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final f f1556a;

    public c(f fVar) {
        this.f1556a = fVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (Constant.INTENT_NETWORK_STATUS.equals(intent.getAction())) {
            this.f1556a.a();
        }
    }
}

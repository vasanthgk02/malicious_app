package com.razorpay;

import android.app.Activity;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.Iterator;

public final class h__y_ {
    public static h__y_ G__G_;
    public SmsReceiver a_$P$;
    public ArrayList<Q$$U_> d__1_ = new ArrayList<>();

    public final void G__G_(boolean z) {
        Iterator<Q$$U_> it = this.d__1_.iterator();
        while (it.hasNext()) {
            it.next().setSmsPermission(z);
        }
    }

    public final void Q_$2$(Activity activity) {
        G__G_(false);
        SmsReceiver smsReceiver = this.a_$P$;
        if (smsReceiver != null) {
            try {
                activity.unregisterReceiver(smsReceiver);
            } catch (Exception e2) {
                AnalyticsUtil.reportError(e2, "critical", e2.getMessage());
            }
            this.a_$P$ = null;
        }
    }

    public final void a_$P$(Activity activity) {
        if (this.a_$P$ == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(1000);
            this.a_$P$ = new SmsReceiver(this);
            intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
            activity.registerReceiver(this.a_$P$, intentFilter);
        }
    }
}

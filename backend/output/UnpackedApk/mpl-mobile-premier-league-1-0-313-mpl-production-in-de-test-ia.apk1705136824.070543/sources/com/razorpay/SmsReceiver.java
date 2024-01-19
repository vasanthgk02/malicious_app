package com.razorpay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import java.util.Iterator;

public class SmsReceiver extends BroadcastReceiver {
    public h__y_ Q_$2$;

    public SmsReceiver() {
        this.Q_$2$ = null;
    }

    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            try {
                Object[] objArr = (Object[]) extras.get("pdus");
                if (objArr.length > 0) {
                    SmsMessage createFromPdu = SmsMessage.createFromPdu((byte[]) objArr[0]);
                    String displayOriginatingAddress = createFromPdu.getDisplayOriginatingAddress();
                    String displayMessageBody = createFromPdu.getDisplayMessageBody();
                    if (this.Q_$2$ != null) {
                        Iterator<Q$$U_> it = this.Q_$2$.d__1_.iterator();
                        while (it.hasNext()) {
                            it.next().postSms(displayOriginatingAddress, displayMessageBody);
                        }
                    } else {
                        Intent intent2 = new Intent("com.razorpay.events.SMS_PROCESSED");
                        intent2.putExtra("extra_sender", displayOriginatingAddress);
                        intent2.putExtra("extra_message", displayMessageBody);
                        context.sendBroadcast(intent2);
                    }
                    StringBuilder sb = new StringBuilder("SmsReceiver senderNum: ");
                    sb.append(displayOriginatingAddress);
                    sb.append("; message: ");
                    sb.append(displayMessageBody);
                    sb.toString();
                }
            } catch (Exception e2) {
                AnalyticsUtil.reportError(e2, "critical", e2.getMessage());
                "SmsReceiver Exception smsReceiver".concat(String.valueOf(e2));
            }
        }
    }

    public SmsReceiver(h__y_ h__y_) {
        this.Q_$2$ = h__y_;
    }
}

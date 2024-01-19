package com.razorpay;

import android.app.Activity;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public final class J$$A_ {
    public static String Q_$2$(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 12) {
                sb.append("\\f");
            } else if (charAt != 13) {
                if (charAt != '\"' && charAt != '/' && charAt != '\\') {
                    switch (charAt) {
                        case 8:
                            sb.append("\\b");
                            break;
                        case 9:
                            sb.append("\\t");
                            break;
                        case 10:
                            sb.append("\\n");
                            break;
                        default:
                            if (charAt > 31) {
                                sb.append(charAt);
                                break;
                            } else {
                                sb.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                                break;
                            }
                    }
                } else {
                    sb.append('\\');
                    sb.append(charAt);
                }
            } else {
                sb.append("\\r");
            }
        }
        return sb.toString();
    }

    public static String R$$r_(String str) {
        JSONObject O__Y_ = b__J_.L__R$().O__Y_();
        if (str == null || str.length() < 6) {
            return "unknown";
        }
        Iterator<String> keys = O__Y_.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(O__Y_.getString(next));
                sb.append(".*");
                if (str.matches(sb.toString())) {
                    return next;
                }
            } catch (Exception e2) {
                AnalyticsUtil.reportError(e2, "critical", e2.getLocalizedMessage());
                e2.printStackTrace();
            }
        }
        return "unknown";
    }

    public static void a_$P$(JSONObject jSONObject, Activity activity, final String str, final PaymentCompleteInternalCallback paymentCompleteInternalCallback) {
        final String G__G_ = O__Y_.G__G_(activity, "razorpay_payment_id");
        if (G__G_ != null && !TextUtils.isEmpty(G__G_)) {
            String optString = jSONObject.optString("txnId");
            if (optString == null || TextUtils.isEmpty(optString)) {
                StringBuilder sb = new StringBuilder(BaseConstants.RZP_PAYMENTS_ENDPOINT);
                sb.append(G__G_);
                sb.append("/cancel?key_id=");
                sb.append(str);
                l__d$.R$$r_(sb.toString(), new Callback() {
                    public final void run(K$$z$ k$$z$) {
                        J$$A_.Q_$2$(G__G_, str, 0, paymentCompleteInternalCallback);
                    }
                });
            } else {
                StringBuilder sb2 = new StringBuilder(BaseConstants.RZP_PAYMENTS_ENDPOINT);
                sb2.append(G__G_);
                sb2.append("/status?key_id=");
                sb2.append(str);
                l__d$.R$$r_(sb2.toString(), new Callback(0) {
                    public final void run(K$$z$ k$$z$) {
                        String G__G_2 = k$$z$.G__G_();
                        if ((G__G_2 != null && G__G_2.contains("razorpay_payment_id")) || G__G_2.contains("error")) {
                            paymentCompleteInternalCallback.oncomplete(k$$z$.G__G_());
                        } else if (0 < 12) {
                            new Timer().schedule(new TimerTask() {
                                public final void run() {
                                    AnonymousClass1 r0 = AnonymousClass1.this;
                                    J$$A_.Q_$2$(G__G_, str, 0 + 1, paymentCompleteInternalCallback);
                                }
                            }, 500);
                        } else {
                            paymentCompleteInternalCallback.oncomplete(G__G_2);
                        }
                    }
                });
            }
        }
    }

    public static int a_$P$(String str) {
        if (b__J_.L__R$().B_$q$().has(str.toLowerCase())) {
            try {
                return b__J_.L__R$().B_$q$().getInt(str.toLowerCase());
            } catch (Exception e2) {
                AnalyticsUtil.reportError(e2, AnalyticsConstants.ERROR_EXCEPTION, e2.getLocalizedMessage());
                e2.printStackTrace();
            }
        }
        return -1;
    }

    public static /* synthetic */ void Q_$2$(final String str, final String str2, final int i, final PaymentCompleteInternalCallback paymentCompleteInternalCallback) {
        StringBuilder sb = new StringBuilder(BaseConstants.RZP_PAYMENTS_ENDPOINT);
        sb.append(str);
        sb.append("/status?key_id=");
        sb.append(str2);
        l__d$.R$$r_(sb.toString(), new Callback() {
            public final void run(K$$z$ k$$z$) {
                String G__G_2 = k$$z$.G__G_();
                if ((G__G_2 != null && G__G_2.contains("razorpay_payment_id")) || G__G_2.contains("error")) {
                    paymentCompleteInternalCallback.oncomplete(k$$z$.G__G_());
                } else if (0 < 12) {
                    new Timer().schedule(new TimerTask() {
                        public final void run() {
                            AnonymousClass1 r0 = AnonymousClass1.this;
                            J$$A_.Q_$2$(G__G_, str, 0 + 1, paymentCompleteInternalCallback);
                        }
                    }, 500);
                } else {
                    paymentCompleteInternalCallback.oncomplete(G__G_2);
                }
            }
        });
    }
}

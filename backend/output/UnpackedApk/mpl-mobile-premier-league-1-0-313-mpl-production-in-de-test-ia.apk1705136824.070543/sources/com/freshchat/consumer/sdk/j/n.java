package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class n {
    public static SimpleDateFormat hA;
    public static SimpleDateFormat hB;
    public static SimpleDateFormat kH;
    public static SimpleDateFormat kI;
    public static SimpleDateFormat kX;
    public static SimpleDateFormat pR;
    public static SimpleDateFormat pS;

    public static Date C(long j) {
        return new Date(j);
    }

    public static String I(Context context, String str) {
        if (str != null) {
            try {
                return a(context, new SimpleDateFormat("yyyy-MM-dd", ah.bb(context)).parse(str));
            } catch (ParseException e2) {
                q.a(e2);
            }
        }
        return "";
    }

    public static String a(Context context, long j, boolean z) {
        long fP = fP();
        SimpleDateFormat bq = bq(context);
        if (c(j, fP)) {
            bq = d(j, fP) ? bp(context) : z ? bs(context) : br(context);
        }
        bq.setTimeZone(TimeZone.getDefault());
        return bq.format(new Date(j));
    }

    public static String a(Context context, Date date) {
        if (date != null) {
            try {
                Calendar instance = Calendar.getInstance();
                instance.setTime(date);
                if (a(instance, Calendar.getInstance())) {
                    return context.getString(R.string.freshchat_calendar_today);
                }
                if (b(instance)) {
                    return context.getString(R.string.freshchat_calendar_tomorrow);
                }
                SimpleDateFormat cj = cj(context);
                if (cj != null) {
                    return cj.format(date);
                }
            } catch (Exception e2) {
                q.a(e2);
            }
        }
        return "";
    }

    public static boolean a(Calendar calendar, Calendar calendar2) {
        return calendar.get(5) == calendar2.get(5) && calendar.get(2) == calendar2.get(2) && calendar.get(1) == calendar2.get(1);
    }

    public static String aQ(String str) {
        try {
            long fP = fP();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE", new Locale("EN"));
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str));
            return simpleDateFormat.format(C(fP));
        } catch (Exception e2) {
            q.a(e2);
            return "";
        }
    }

    public static long aR(String str) {
        long fP = fP();
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone(str));
        int i = instance.get(5);
        Calendar calendar = instance;
        calendar.set(instance.get(1), instance.get(2), i, 0, 0, 0);
        return (fP - instance.getTimeInMillis()) / 1000;
    }

    public static boolean b(Calendar calendar) {
        Calendar instance = Calendar.getInstance();
        instance.add(6, 1);
        return a(calendar, instance);
    }

    public static SimpleDateFormat bp(Context context) {
        if (kI == null) {
            try {
                kI = new SimpleDateFormat(context.getString(R.string.freshchat_chat_message_time_other_year), ah.bb(context));
            } catch (Exception unused) {
                kI = bt(context);
            }
        }
        return kI;
    }

    public static SimpleDateFormat bq(Context context) {
        if (hA == null) {
            try {
                hA = new SimpleDateFormat(context.getString(R.string.freshchat_chat_message_time_today), ah.bb(context));
            } catch (Exception unused) {
                hA = bt(context);
            }
        }
        return hA;
    }

    public static SimpleDateFormat br(Context context) {
        if (hB == null) {
            try {
                hB = new SimpleDateFormat(context.getString(R.string.freshchat_chat_message_time_this_year_short), ah.bb(context));
            } catch (Exception unused) {
                hB = bt(context);
            }
        }
        return hB;
    }

    public static SimpleDateFormat bs(Context context) {
        if (kH == null) {
            try {
                kH = new SimpleDateFormat(context.getString(R.string.freshchat_chat_message_time_this_year_long), ah.bb(context));
            } catch (Exception unused) {
                kH = bt(context);
            }
        }
        return kH;
    }

    public static SimpleDateFormat bt(Context context) {
        if (kX == null) {
            try {
                kX = new SimpleDateFormat("dd MMM yyyy',' hh:mm a", ah.bb(context));
            } catch (Exception unused) {
            }
        }
        return kX;
    }

    public static String c(Calendar calendar) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        } catch (Exception e2) {
            q.a(e2);
            return null;
        }
    }

    public static boolean c(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        return (instance.get(5) == instance2.get(5) && instance.get(2) == instance2.get(2) && instance.get(1) == instance2.get(1)) ? false : true;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.text.SimpleDateFormat ci(android.content.Context r3) {
        /*
            java.text.SimpleDateFormat r0 = pR
            if (r0 != 0) goto L_0x002b
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0016 }
            int r1 = com.freshchat.consumer.sdk.R.string.freshchat_chat_calendar_timeslot_format     // Catch:{ Exception -> 0x0016 }
            java.lang.String r1 = r3.getString(r1)     // Catch:{ Exception -> 0x0016 }
            java.util.Locale r2 = com.freshchat.consumer.sdk.j.ah.bb(r3)     // Catch:{ Exception -> 0x0016 }
            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x0016 }
            pR = r0     // Catch:{ Exception -> 0x0016 }
            goto L_0x002b
        L_0x0016:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0024 }
            java.lang.String r1 = "hh:mm a"
            java.util.Locale r3 = com.freshchat.consumer.sdk.j.ah.bb(r3)     // Catch:{ Exception -> 0x0024 }
            r0.<init>(r1, r3)     // Catch:{ Exception -> 0x0024 }
            pR = r0     // Catch:{ Exception -> 0x0024 }
            goto L_0x002b
        L_0x0024:
            java.lang.String r3 = "FRESHCHAT"
            java.lang.String r0 = "Error parsing default calendar time slot template format in getTimeFormatForCalendarTime()"
            com.freshchat.consumer.sdk.j.ai.e(r3, r0)
        L_0x002b:
            java.text.SimpleDateFormat r3 = pR
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.n.ci(android.content.Context):java.text.SimpleDateFormat");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.text.SimpleDateFormat cj(android.content.Context r3) {
        /*
            java.text.SimpleDateFormat r0 = pS
            if (r0 != 0) goto L_0x002b
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0016 }
            int r1 = com.freshchat.consumer.sdk.R.string.freshchat_chat_calendar_date_format     // Catch:{ Exception -> 0x0016 }
            java.lang.String r1 = r3.getString(r1)     // Catch:{ Exception -> 0x0016 }
            java.util.Locale r2 = com.freshchat.consumer.sdk.j.ah.bb(r3)     // Catch:{ Exception -> 0x0016 }
            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x0016 }
            pS = r0     // Catch:{ Exception -> 0x0016 }
            goto L_0x002b
        L_0x0016:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0024 }
            java.lang.String r1 = "EEEE',' dd MMM yyyy"
            java.util.Locale r3 = com.freshchat.consumer.sdk.j.ah.bb(r3)     // Catch:{ Exception -> 0x0024 }
            r0.<init>(r1, r3)     // Catch:{ Exception -> 0x0024 }
            pS = r0     // Catch:{ Exception -> 0x0024 }
            goto L_0x002b
        L_0x0024:
            java.lang.String r3 = "FRESHCHAT"
            java.lang.String r0 = "Error parsing default calendar template format in getDateFormatForCalendarDay()"
            com.freshchat.consumer.sdk.j.ai.e(r3, r0)
        L_0x002b:
            java.text.SimpleDateFormat r3 = pS
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.n.cj(android.content.Context):java.text.SimpleDateFormat");
    }

    public static boolean d(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        return instance.get(1) != instance2.get(1);
    }

    public static boolean e(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        return (instance.get(2) == instance2.get(2) && instance.get(1) == instance2.get(1)) ? false : true;
    }

    public static void ef() {
        kX = null;
        hA = null;
        hB = null;
        kH = null;
        kI = null;
        pS = null;
        pR = null;
    }

    public static long fP() {
        try {
            return new GregorianCalendar(TimeZone.getTimeZone("GMT")).getTimeInMillis();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String i(Context context, long j) {
        return a(context, j, true);
    }

    public static String o(Context context, long j) {
        if (context == null || j <= 0) {
            return null;
        }
        SimpleDateFormat bt = bt(context);
        bt.setTimeZone(TimeZone.getDefault());
        return bt.format(new Date(j));
    }

    public static String p(Context context, long j) {
        SimpleDateFormat ci = ci(context);
        if (ci == null) {
            return "";
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return ci.format(instance.getTime());
    }

    public static String q(Context context, long j) {
        return j > 0 ? a(context, C(j)) : "";
    }

    public static String s(int i) {
        if (i <= 0) {
            return "00:00";
        }
        int i2 = i / 60;
        int abs = Math.abs((i2 * 60) - i);
        StringBuilder sb = new StringBuilder();
        if (i2 < 10) {
            sb.append("0");
        }
        sb.append(i2);
        sb.append(":");
        if (abs < 10) {
            sb.append("0");
        }
        sb.append(abs);
        return sb.toString();
    }
}

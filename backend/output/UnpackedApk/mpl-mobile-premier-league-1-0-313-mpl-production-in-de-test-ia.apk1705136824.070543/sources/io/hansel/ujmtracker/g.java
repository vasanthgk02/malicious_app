package io.hansel.ujmtracker;

import android.content.Context;
import com.netcore.android.event.SMTEventId;
import java.util.HashMap;
import java.util.Iterator;
import org.jboss.netty.channel.ChannelPipelineCoverage;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static g f5320a;

    public static g a() {
        if (f5320a == null) {
            synchronized (g.class) {
                try {
                    if (f5320a == null) {
                        f5320a = new g();
                    }
                }
            }
        }
        return f5320a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079 A[Catch:{ all -> 0x0133 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0088 A[Catch:{ all -> 0x0133 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e5 A[Catch:{ all -> 0x0133 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.HashMap<java.lang.String, java.lang.Object> a(java.util.HashMap<java.lang.String, java.lang.Object> r10) {
        /*
            r9 = this;
            java.lang.String r0 = "Time_spent_nudge"
            java.lang.String r1 = "Multichoice_value"
            java.lang.String r2 = "NPS_Value"
            java.lang.String r3 = "Rating_Value"
            java.lang.String r4 = "Input_text2"
            java.lang.String r5 = "Input_text1"
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.lang.String r7 = "interaction_map_name"
            java.lang.String r8 = "Interaction_Map_Name"
            java.lang.Object r8 = r10.get(r8)     // Catch:{ all -> 0x0133 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0133 }
            r6.put(r7, r8)     // Catch:{ all -> 0x0133 }
            java.lang.String r7 = "nudge_name"
            java.lang.String r8 = "Nudge_Name"
            java.lang.Object r8 = r10.get(r8)     // Catch:{ all -> 0x0133 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0133 }
            r6.put(r7, r8)     // Catch:{ all -> 0x0133 }
            java.lang.String r7 = "nudge_type"
            java.lang.String r8 = "Nudge_Type"
            java.lang.Object r8 = r10.get(r8)     // Catch:{ all -> 0x0133 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0133 }
            r6.put(r7, r8)     // Catch:{ all -> 0x0133 }
            java.lang.String r7 = "app_id"
            java.lang.String r8 = "App_Id"
            java.lang.Object r8 = r10.get(r8)     // Catch:{ all -> 0x0133 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0133 }
            r6.put(r7, r8)     // Catch:{ all -> 0x0133 }
            java.lang.String r7 = "user_id"
            java.lang.String r8 = "User_Id"
            java.lang.Object r8 = r10.get(r8)     // Catch:{ all -> 0x0133 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0133 }
            r6.put(r7, r8)     // Catch:{ all -> 0x0133 }
            java.lang.Object r7 = r10.get(r5)     // Catch:{ all -> 0x0133 }
            if (r7 == 0) goto L_0x0062
            java.lang.Object r4 = r10.get(r5)     // Catch:{ all -> 0x0133 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0133 }
            java.lang.String r5 = "nudge_inputtext"
            goto L_0x0070
        L_0x0062:
            java.lang.Object r5 = r10.get(r4)     // Catch:{ all -> 0x0133 }
            if (r5 == 0) goto L_0x0073
            java.lang.Object r4 = r10.get(r4)     // Catch:{ all -> 0x0133 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0133 }
            java.lang.String r5 = "nudge_inputtext2"
        L_0x0070:
            r6.put(r5, r4)     // Catch:{ all -> 0x0133 }
        L_0x0073:
            java.lang.Object r4 = r10.get(r3)     // Catch:{ all -> 0x0133 }
            if (r4 == 0) goto L_0x0088
            java.lang.Object r2 = r10.get(r3)     // Catch:{ all -> 0x0133 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0133 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x0133 }
        L_0x0083:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0133 }
            goto L_0x0099
        L_0x0088:
            java.lang.Object r3 = r10.get(r2)     // Catch:{ all -> 0x0133 }
            if (r3 == 0) goto L_0x009e
            java.lang.Object r2 = r10.get(r2)     // Catch:{ all -> 0x0133 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0133 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x0133 }
            goto L_0x0083
        L_0x0099:
            java.lang.String r3 = "nudge_rating"
            r6.put(r3, r2)     // Catch:{ all -> 0x0133 }
        L_0x009e:
            java.lang.Object r2 = r10.get(r1)     // Catch:{ all -> 0x0133 }
            if (r2 == 0) goto L_0x00af
            java.lang.String r2 = "nudge_mcq"
            java.lang.Object r1 = r10.get(r1)     // Catch:{ all -> 0x0133 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0133 }
            r6.put(r2, r1)     // Catch:{ all -> 0x0133 }
        L_0x00af:
            java.lang.Object r1 = r10.get(r0)     // Catch:{ all -> 0x0133 }
            if (r1 == 0) goto L_0x00c1
            java.lang.String r1 = "time_spent_nudge"
            java.lang.Object r0 = r10.get(r0)     // Catch:{ all -> 0x0133 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0133 }
            r6.put(r1, r0)     // Catch:{ all -> 0x0133 }
        L_0x00c1:
            java.lang.String r0 = "Button_1_clicked"
            java.lang.Object r0 = r10.get(r0)     // Catch:{ all -> 0x0133 }
            java.lang.String r1 = "nudge_action"
            if (r0 == 0) goto L_0x00e5
            java.lang.String r0 = "Button_1_text"
            java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x0133 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0133 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
            r0.<init>()     // Catch:{ all -> 0x0133 }
            java.lang.String r2 = "button1_clicked|"
            r0.append(r2)     // Catch:{ all -> 0x0133 }
            r0.append(r10)     // Catch:{ all -> 0x0133 }
        L_0x00e0:
            java.lang.String r10 = r0.toString()     // Catch:{ all -> 0x0133 }
            goto L_0x0103
        L_0x00e5:
            java.lang.String r0 = "Button_2_clicked"
            java.lang.Object r0 = r10.get(r0)     // Catch:{ all -> 0x0133 }
            if (r0 == 0) goto L_0x0107
            java.lang.String r0 = "Button_2_text"
            java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x0133 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0133 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
            r0.<init>()     // Catch:{ all -> 0x0133 }
            java.lang.String r2 = "button2_clicked|"
            r0.append(r2)     // Catch:{ all -> 0x0133 }
            r0.append(r10)     // Catch:{ all -> 0x0133 }
            goto L_0x00e0
        L_0x0103:
            r6.put(r1, r10)     // Catch:{ all -> 0x0133 }
            goto L_0x0137
        L_0x0107:
            java.lang.String r0 = "Nudge_autodismiss"
            java.lang.Object r0 = r10.get(r0)     // Catch:{ all -> 0x0133 }
            if (r0 == 0) goto L_0x0112
            java.lang.String r10 = "noaction_autodismissed"
            goto L_0x0103
        L_0x0112:
            java.lang.String r0 = "Nudge_backdrop_clicked"
            java.lang.Object r0 = r10.get(r0)     // Catch:{ all -> 0x0133 }
            if (r0 == 0) goto L_0x011d
            java.lang.String r10 = "backdrop_dismissed"
            goto L_0x0103
        L_0x011d:
            java.lang.String r0 = "Nudge_screen_nav"
            java.lang.Object r0 = r10.get(r0)     // Catch:{ all -> 0x0133 }
            if (r0 == 0) goto L_0x0128
            java.lang.String r10 = "noaction_screenchanged"
            goto L_0x0103
        L_0x0128:
            java.lang.String r0 = "Button_close_clicked"
            java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x0133 }
            if (r10 == 0) goto L_0x0137
            java.lang.String r10 = "close_clicked"
            goto L_0x0103
        L_0x0133:
            r10 = move-exception
            io.hansel.core.logger.HSLLogger.printStackTrace(r10)
        L_0x0137:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.ujmtracker.g.a(java.util.HashMap):java.util.HashMap");
    }

    private void a(Context context) {
        Iterator<HashMap<String, String>> it = k.b(context).iterator();
        while (it.hasNext()) {
            HashMap next = it.next();
            if (((String) next.get("prompt_unique_id_key")) != null) {
                a(context, new HashMap(next));
            }
        }
    }

    private void a(Context context, HashMap<String, Object> hashMap) {
        Object obj = hashMap.get("prompt_unique_id_key");
        hashMap.remove("prompt_unique_id_key");
        h.a().a((String) SMTEventId.EVENT_NH_PROMPT_DISMISS, hashMap);
        if (obj instanceof String) {
            k.c(context, (String) obj);
        }
    }

    private HashMap<String, String> b(HashMap<String, Object> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("interaction_map_name", (String) hashMap.get("Interaction_Map_Name"));
        hashMap2.put("nudge_name", (String) hashMap.get("Nudge_Name"));
        hashMap2.put("nudge_type", (String) hashMap.get("Nudge_Type"));
        hashMap2.put("app_id", (String) hashMap.get("App_Id"));
        hashMap2.put("user_id", (String) hashMap.get("User_Id"));
        hashMap2.put("nudge_action", "noaction_appclosed");
        return hashMap2;
    }

    private void b(Context context, HashMap<String, Object> hashMap) {
        if (d(context)) {
            Boolean bool = (Boolean) hashMap.get("prompt_lis_enabled_key");
            if (bool == null) {
                bool = Boolean.TRUE;
            }
            k.d(context, (String) hashMap.get("prompt_unique_id_key"));
            HashMap<String, Object> a2 = a(hashMap);
            h.a().d("hansel_nudge_event", "hsl", a2);
            if (bool.booleanValue()) {
                i.f5338c.a((String) "hansel_nudge_event", a2);
            }
        }
    }

    private HashMap<String, Object> c(HashMap<String, Object> hashMap) {
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("interaction_map_name", hashMap.get("Interaction_Map_Name"));
        hashMap2.put("nudge_name", hashMap.get("Nudge_Name"));
        hashMap2.put("nudge_type", hashMap.get("Nudge_Type"));
        hashMap2.put("app_id", hashMap.get("App_Id"));
        hashMap2.put("user_id", hashMap.get("User_Id"));
        return hashMap2;
    }

    private void c(Context context) {
        if (d(context)) {
            Iterator<HashMap<String, String>> it = k.c(context).iterator();
            while (it.hasNext()) {
                HashMap next = it.next();
                String str = (String) next.get("prompt_unique_id_key");
                if (str != null) {
                    k.d(context, str);
                    i.f5338c.a((String) "hansel_nudge_event", new HashMap<>(next));
                }
            }
        }
    }

    private void d(Context context, HashMap<String, String> hashMap) {
        k.a(context, hashMap.get("prompt_unique_id_key"), hashMap);
    }

    private boolean d(Context context) {
        if (l.c(context)) {
            String b2 = l.b(context);
            if (b2 == null || b2.equals("prompt") || b2.equals(ChannelPipelineCoverage.ALL)) {
                return true;
            }
        }
        return false;
    }

    public void a(Context context, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        b(context, hashMap2);
        a(context, hashMap);
    }

    public void b(Context context) {
        c(context);
        a(context);
    }

    public void b(Context context, HashMap<String, String> hashMap, HashMap<String, Object> hashMap2) {
        c(context, hashMap2);
        d(context, hashMap);
    }

    public void c(Context context, HashMap<String, Object> hashMap) {
        if (d(context)) {
            Boolean bool = (Boolean) hashMap.get("prompt_lis_enabled_key");
            if (bool == null) {
                bool = Boolean.TRUE;
            }
            if (bool.booleanValue()) {
                k.b(context, (String) hashMap.get("prompt_unique_id_key"), b(hashMap));
                i.f5338c.a((String) "hansel_nudge_show_event", c(hashMap));
            }
        }
    }
}

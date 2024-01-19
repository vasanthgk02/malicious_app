package com.razorpay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.netcore.android.preference.SMTPreferenceConstants;
import org.apache.commons.lang.text.ExtendedMessageFormat;
import org.json.JSONObject;

public final class O__Y_ {
    public static int G__G_ = 1;
    public static SharedPreferences Q_$2$ = null;
    public static int R$$r_ = 0;
    public static int a_$P$ = 180;
    public static Editor d__1_;

    public static SharedPreferences G__G_(Context context) {
        int i = R$$r_ + 27;
        G__G_ = i % 128;
        if (i % 2 == 0) {
        }
        return context.getSharedPreferences("rzp_preferences_storage_bridge", 0);
    }

    @SuppressLint({"CommitPrefEdits"})
    public static Editor Q_$2$(Context context) {
        int i = R$$r_ + 49;
        G__G_ = i % 128;
        int i2 = i % 2;
        if (d__1_ == null) {
            int i3 = R$$r_ + 17;
            G__G_ = i3 % 128;
            if (!(i3 % 2 == 0)) {
                if (Q_$2$ == null) {
                    Q_$2$ = context.getSharedPreferences("rzp_preference_private", 0);
                }
                d__1_ = Q_$2$.edit();
                int i4 = R$$r_ + 87;
                G__G_ = i4 % 128;
                int i5 = i4 % 2;
            } else {
                throw null;
            }
        }
        return d__1_;
    }

    public static Editor R$$r_(Context context) {
        int i = G__G_ + 115;
        R$$r_ = i % 128;
        return context.getSharedPreferences("rzp_preferences_storage_bridge", (i % 2 != 0 ? '_' : ExtendedMessageFormat.QUOTE) != '\'' ? 1 : 0).edit();
    }

    public static void a_$P$(Context context, String str, String str2, String str3) {
        try {
            String randomString = BaseUtils.getRandomString();
            String a_$P$2 = new O_$B_().a_$P$(str2, Q_$2$(true, "\u0013￧\rￚ\n￳\u001b\u001a￘\u000e￘\u0006\u001b\u001d￱\u0007￹\u000b\u0011\u0014￙\u001e\u001d￭￾￸￯\u001b￥￦￮\u001a", 32, 16, 272).intern(), randomString);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", a_$P$2);
            jSONObject.put("iv", randomString);
            jSONObject.put(SMTPreferenceConstants.SMT_SDK_VERSION, str3);
            String jSONObject2 = jSONObject.toString();
            Editor Q_$2$2 = Q_$2$(context);
            Q_$2$2.putString(str, jSONObject2);
            Q_$2$2.commit();
            int i = R$$r_ + 41;
            G__G_ = i % 128;
            if ((i % 2 == 0 ? 15 : 'a') != 'a') {
                throw null;
            }
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, "error", "Unable to encrypt value");
        }
    }

    public static SharedPreferences d__1_(Context context) {
        if (!(Q_$2$ != null)) {
            int i = R$$r_ + 29;
            G__G_ = i % 128;
            int i2 = i % 2;
            Q_$2$ = context.getSharedPreferences("rzp_preference_private", 0);
            int i3 = G__G_ + 3;
            R$$r_ = i3 % 128;
            int i4 = i3 % 2;
        }
        return Q_$2$;
    }

    public static String G__G_(Context context, String str) {
        int i = R$$r_ + 85;
        G__G_ = i % 128;
        int i2 = i % 2;
        if (!(Q_$2$ != null)) {
            Q_$2$ = context.getSharedPreferences("rzp_preference_private", 0);
        }
        String string = Q_$2$.getString(str, null);
        int i3 = G__G_ + 35;
        R$$r_ = i3 % 128;
        if ((i3 % 2 != 0 ? 3 : ':') != 3) {
            return string;
        }
        throw null;
    }

    public static void R$$r_(Context context, String str) {
        try {
            if (Q_$2$ == null) {
                int i = G__G_ + 83;
                R$$r_ = i % 128;
                int i2 = i % 2;
                Q_$2$ = context.getSharedPreferences("rzp_preference_private", 0);
                int i3 = G__G_ + 75;
                R$$r_ = i3 % 128;
                int i4 = i3 % 2;
            }
            if ((!str.equalsIgnoreCase(Q_$2$.getString(SMTPreferenceConstants.SMT_SDK_VERSION, null)) ? (char) 13 : 8) != 8) {
                int i5 = G__G_ + 13;
                R$$r_ = i5 % 128;
                int i6 = i5 % 2;
                Editor Q_$2$2 = Q_$2$(context);
                Q_$2$2.putString("rzp_config_json", null);
                Q_$2$2.commit();
                Editor Q_$2$3 = Q_$2$(context);
                Q_$2$3.putString("rzp_config_version", null);
                Q_$2$3.commit();
                Editor Q_$2$4 = Q_$2$(context);
                Q_$2$4.putString(SMTPreferenceConstants.SMT_SDK_VERSION, str);
                Q_$2$4.commit();
            }
        } catch (NullPointerException unused) {
            Editor Q_$2$5 = Q_$2$(context);
            Q_$2$5.putString("rzp_config_json", null);
            Q_$2$5.commit();
            Editor Q_$2$6 = Q_$2$(context);
            Q_$2$6.putString("rzp_config_version", null);
            Q_$2$6.commit();
            Editor Q_$2$7 = Q_$2$(context);
            Q_$2$7.putString(SMTPreferenceConstants.SMT_SDK_VERSION, str);
            Q_$2$7.commit();
        }
    }

    public static void G__G_(Context context, String str, String str2) {
        int i = G__G_ + 7;
        R$$r_ = i % 128;
        if ((i % 2 != 0 ? 'Z' : 27) != 'Z') {
            Editor Q_$2$2 = Q_$2$(context);
            Q_$2$2.putString(str, str2);
            Q_$2$2.commit();
            return;
        }
        Editor Q_$2$3 = Q_$2$(context);
        Q_$2$3.putString(str, str2);
        Q_$2$3.commit();
        int i2 = 71 / 0;
    }

    public static String Q_$2$(Context context, String str, String str2) {
        try {
            if ((Q_$2$ == null ? (char) 22 : 7) != 7) {
                Q_$2$ = context.getSharedPreferences("rzp_preference_private", 0);
            }
            String string = Q_$2$.getString(str, null);
            if ((string == null ? '9' : 13) != 13) {
                int i = R$$r_ + 25;
                G__G_ = i % 128;
                int i2 = i % 2;
                return null;
            }
            JSONObject jSONObject = new JSONObject(string);
            O_$B_ o_$b_ = new O_$B_();
            if (str2.equals(jSONObject.getString(SMTPreferenceConstants.SMT_SDK_VERSION))) {
                return o_$b_.G__G_(jSONObject.getString("data"), Q_$2$(true, "\u0013￧\rￚ\n￳\u001b\u001a￘\u000e￘\u0006\u001b\u001d￱\u0007￹\u000b\u0011\u0014￙\u001e\u001d￭￾￸￯\u001b￥￦￮\u001a", 32, 16, 272).intern(), jSONObject.getString("iv"));
            }
            int i3 = R$$r_ + 51;
            G__G_ = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = 9 / 0;
            }
            return null;
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, "error", "Unable to decrypt value");
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String Q_$2$(boolean r5, java.lang.String r6, int r7, int r8, int r9) {
        /*
            if (r6 == 0) goto L_0x0006
            char[] r6 = r6.toCharArray()
        L_0x0006:
            char[] r6 = (char[]) r6
            char[] r0 = new char[r7]
            int r1 = R$$r_
            int r1 = r1 + 89
            int r2 = r1 % 128
            G__G_ = r2
            int r1 = r1 % 2
            r1 = 0
            r2 = 0
        L_0x0016:
            r3 = 35
            if (r2 >= r7) goto L_0x001d
            r4 = 35
            goto L_0x001f
        L_0x001d:
            r4 = 60
        L_0x001f:
            if (r4 == r3) goto L_0x0062
            if (r8 <= 0) goto L_0x0030
            char[] r6 = new char[r7]
            java.lang.System.arraycopy(r0, r1, r6, r1, r7)
            int r9 = r7 - r8
            java.lang.System.arraycopy(r6, r1, r0, r9, r8)
            java.lang.System.arraycopy(r6, r8, r0, r1, r9)
        L_0x0030:
            if (r5 == 0) goto L_0x005c
            int r5 = G__G_
            int r5 = r5 + 93
            int r6 = r5 % 128
            R$$r_ = r6
            int r5 = r5 % 2
            r6 = 1
            if (r5 == 0) goto L_0x0043
            char[] r5 = new char[r7]
            r1 = 1
            goto L_0x0045
        L_0x0043:
            char[] r5 = new char[r7]
        L_0x0045:
            r8 = 91
            if (r1 >= r7) goto L_0x004c
            r9 = 91
            goto L_0x004e
        L_0x004c:
            r9 = 69
        L_0x004e:
            if (r9 == r8) goto L_0x0052
            r0 = r5
            goto L_0x005c
        L_0x0052:
            int r8 = r7 - r1
            int r8 = r8 - r6
            char r8 = r0[r8]
            r5[r1] = r8
            int r1 = r1 + 1
            goto L_0x0045
        L_0x005c:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0)
            return r5
        L_0x0062:
            int r3 = R$$r_
            int r3 = r3 + 71
            int r4 = r3 % 128
            G__G_ = r4
            int r3 = r3 % 2
            char r3 = r6[r2]
            int r3 = r3 + r9
            char r3 = (char) r3
            r0[r2] = r3
            char r3 = r0[r2]
            int r4 = a_$P$
            int r3 = r3 - r4
            char r3 = (char) r3
            r0[r2] = r3
            int r2 = r2 + 1
            int r3 = R$$r_
            int r3 = r3 + 9
            int r4 = r3 % 128
            G__G_ = r4
            int r3 = r3 % 2
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: com.razorpay.O__Y_.Q_$2$(boolean, java.lang.String, int, int, int):java.lang.String");
    }
}

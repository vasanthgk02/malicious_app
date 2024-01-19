package com.userexperior.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.userexperior.UserExperior;
import com.userexperior.a.a.f;
import com.userexperior.c.b.a;
import com.userexperior.c.b.c;
import java.util.HashMap;
import java.util.logging.Level;

public final class l {
    public static c a(Context context) {
        return (c) new f().a(context.getSharedPreferences(UserExperior.TAG, 0).getString("currentTaskJSON", null), c.class);
    }

    public static void a(Context context, long j) {
        Editor edit = context.getSharedPreferences(UserExperior.TAG, 0).edit();
        edit.putLong("sst", j);
        edit.apply();
    }

    public static void a(Context context, com.userexperior.models.recording.f fVar) {
        HashMap<String, com.userexperior.models.recording.f> s = s(context);
        if (s == null) {
            s = new HashMap<>();
        }
        String str = fVar.r;
        if (str != null) {
            s.put(str, fVar);
            new StringBuilder("saving... ").append(fVar);
            a(context, s);
        }
    }

    public static void a(Context context, String str) {
        Editor edit = context.getSharedPreferences(UserExperior.TAG, 0).edit();
        edit.putString("configResponse", str);
        edit.apply();
    }

    public static void a(Context context, HashMap<String, com.userexperior.models.recording.f> hashMap) {
        String a2 = new f().a((Object) hashMap);
        Editor edit = context.getSharedPreferences(UserExperior.TAG, 0).edit();
        edit.putString("__ue_sessionDetail_list", a2);
        edit.commit();
    }

    public static void a(Context context, boolean z) {
        Editor edit = context.getSharedPreferences(UserExperior.TAG, 0).edit();
        edit.putBoolean("optOutStatus", z);
        edit.apply();
    }

    public static void b(Context context) {
        Editor edit = context.getSharedPreferences(UserExperior.TAG, 0).edit();
        edit.remove("currentTaskJSON");
        b.a(Level.INFO, "rcto");
        edit.apply();
    }

    public static void b(Context context, String str) {
        Editor edit = context.getSharedPreferences(UserExperior.TAG, 0).edit();
        d.a();
        edit.putString("appSessionID", str);
        edit.putBoolean("isNewAsi", true);
        edit.apply();
    }

    public static void b(Context context, boolean z) {
        Editor edit = context.getSharedPreferences(UserExperior.TAG, 0).edit();
        edit.putBoolean("stopRecFlag", z);
        edit.apply();
    }

    public static com.userexperior.models.recording.f c(Context context, String str) {
        HashMap<String, com.userexperior.models.recording.f> s = s(context);
        if (s == null) {
            return null;
        }
        com.userexperior.models.recording.f fVar = s.get(str);
        StringBuilder sb = new StringBuilder("get session_detail with sessionid = ");
        sb.append(str);
        sb.append(" :");
        sb.append(fVar);
        return fVar;
    }

    public static void c(Context context, boolean z) {
        Editor edit = context.getSharedPreferences(UserExperior.TAG, 0).edit();
        edit.putBoolean("pauseRecFlag", z);
        edit.apply();
    }

    public static boolean c(Context context) {
        return context.getSharedPreferences(UserExperior.TAG, 0).getBoolean("doesANROccurred", false);
    }

    public static void d(Context context) {
        Editor edit = context.getSharedPreferences(UserExperior.TAG, 0).edit();
        edit.remove("doesANROccurred");
        edit.apply();
    }

    public static void d(Context context, String str) {
        HashMap<String, com.userexperior.models.recording.f> s = s(context);
        if (s != null && s.size() != 0) {
            s.remove(str);
            a(context, s);
        }
    }

    public static a e(Context context) {
        f fVar = new f();
        String string = context.getSharedPreferences(UserExperior.TAG, 0).getString("appConfigInstance", null);
        if (string == null) {
            return null;
        }
        if (VERSION.SDK_INT >= 23) {
            c a2 = c.a();
            byte[] decode = Base64.decode(context.getSharedPreferences(UserExperior.TAG, 0).getString("ksiv", null), 0);
            if (!(a2 == null || decode == null)) {
                try {
                    string = a2.a(Base64.decode(string, 0), decode);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }
        return (a) fVar.a(string, a.class);
    }

    public static void e(Context context, String str) {
        Editor edit = context.getSharedPreferences(UserExperior.TAG, 0).edit();
        edit.putString("appLaunchType", str);
        edit.apply();
    }

    public static String f(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(UserExperior.TAG, 0);
        String string = Secure.getString(context.getContentResolver(), "android_id");
        String string2 = sharedPreferences.getString("userDeviceIdOnUEProcess", null);
        return (string2 == null || string2.isEmpty()) ? string : !string2.contains(string) ? GeneratedOutlineSupport.outline52(string2, " | ", string) : string2;
    }

    public static String g(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String h(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(UserExperior.TAG, 0);
        String string = Secure.getString(context.getContentResolver(), "android_id");
        String string2 = sharedPreferences.getString("userDeviceIdOnMainProcess", null);
        return (string2 == null || string2.isEmpty()) ? string : !string2.contains(string) ? GeneratedOutlineSupport.outline52(string2, " | ", string) : string2;
    }

    public static String i(Context context) {
        return context.getSharedPreferences(UserExperior.TAG, 0).getString("userDeviceIdOnMainProcess", null);
    }

    public static long j(Context context) {
        return context.getSharedPreferences(UserExperior.TAG, 0).getLong("sessionEndTime", 0);
    }

    public static void k(Context context) {
        Editor edit = context.getSharedPreferences(UserExperior.TAG, 0).edit();
        edit.remove("sessionEndTime");
        edit.apply();
    }

    public static String l(Context context) {
        return context.getSharedPreferences(UserExperior.TAG, 0).getString("configResponse", null);
    }

    public static int m(Context context) {
        return context.getSharedPreferences(UserExperior.TAG, 0).getInt("lastImageNum", 0);
    }

    public static String n(Context context) {
        return context.getSharedPreferences(UserExperior.TAG, 0).getString("appSessionID", null);
    }

    public static String o(Context context) {
        return context.getSharedPreferences(UserExperior.TAG, 0).getString("captureType", null);
    }

    public static int p(Context context) {
        return context.getSharedPreferences(UserExperior.TAG, 0).getInt("videoColor", 1);
    }

    public static boolean q(Context context) {
        return context.getSharedPreferences(UserExperior.TAG, 0).getBoolean("conditionalCaptureStatus", false);
    }

    public static void r(Context context) {
        Editor edit = context.getSharedPreferences(UserExperior.TAG, 0).edit();
        edit.remove("isAppCrashed");
        edit.apply();
    }

    public static HashMap<String, com.userexperior.models.recording.f> s(Context context) {
        HashMap<String, com.userexperior.models.recording.f> hashMap = null;
        String string = context.getSharedPreferences(UserExperior.TAG, 0).getString("__ue_sessionDetail_list", null);
        if (string != null && string.equals("{}")) {
            return null;
        }
        try {
            hashMap = (HashMap) new f().a(string, new com.userexperior.a.a.c.a<HashMap<String, com.userexperior.models.recording.f>>() {
            }.f3726b);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (hashMap != null) {
            new StringBuilder("session list size = ").append(hashMap.size());
        }
        return hashMap;
    }

    public static boolean t(Context context) {
        return context.getSharedPreferences(UserExperior.TAG, 0).getBoolean("optOutStatus", false);
    }

    public static void u(Context context) {
        Editor edit = context.getSharedPreferences(UserExperior.TAG, 0).edit();
        edit.putBoolean("consent", true);
        edit.apply();
    }

    public static void v(Context context) {
        Editor edit = context.getSharedPreferences(UserExperior.TAG, 0).edit();
        edit.remove("tpToken");
        edit.apply();
    }

    public static int w(Context context) {
        return context.getSharedPreferences(UserExperior.TAG, 0).getInt("videoQuality", 1);
    }

    public static boolean x(Context context) {
        return context.getSharedPreferences(UserExperior.TAG, 0).getBoolean("pauseRecFlag", false);
    }

    public static String y(Context context) {
        return context.getSharedPreferences(UserExperior.TAG, 0).getString("appPlatform", "an");
    }

    public static String z(Context context) {
        return context.getSharedPreferences(UserExperior.TAG, 0).getString("appLaunchType", "HOT");
    }
}

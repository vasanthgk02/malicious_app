package com.userexperior.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.userexperior.UserExperior;
import com.userexperior.c.b.c;
import com.userexperior.models.recording.enums.e;
import com.userexperior.models.recording.enums.g;
import java.io.File;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static String f4284a;

    /* renamed from: b  reason: collision with root package name */
    public static long f4285b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f4286c = ("UnknownTask_" + System.currentTimeMillis());

    public static String a(Context context) {
        String str;
        String f2 = f(context);
        c a2 = l.a(context);
        long j = a2 != null ? a2.f3864a : -1;
        String g = l.g(context);
        if (g == null) {
            g = l.h(context);
        }
        String concat = g != null ? "_".concat(g) : "";
        if (j > 0) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(f2);
            outline73.append(File.separator);
            outline73.append(String.valueOf(j));
            str = outline73.toString();
            f4285b = j;
        } else {
            f4285b = System.currentTimeMillis();
            StringBuilder outline732 = GeneratedOutlineSupport.outline73(f2);
            outline732.append(File.separator);
            outline732.append(f4285b);
            str = outline732.toString();
        }
        String str2 = str + concat + "_newer_sdk";
        a(context, str2);
        return str2;
    }

    public static String a(String str) {
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73(str), File.separator, "events.json");
    }

    public static void a(Context context, long j) {
        Editor edit = context.getSharedPreferences("RecordSettings", 0).edit();
        edit.putLong("durationInSeconds", j);
        edit.apply();
    }

    public static void a(Context context, String str) {
        Editor edit = context.getSharedPreferences("RecordSettings", 0).edit();
        edit.putString("sessionBasePath", str);
        edit.apply();
    }

    public static String b(Context context) {
        String concat = f(context).concat(File.separator).concat("Crash Logs");
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73(concat), File.separator, k(context) + ".log");
    }

    public static String b(String str) {
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73(str), File.separator, "handled_exception.log");
    }

    public static String c(Context context) {
        String concat = f(context).concat(File.separator).concat("Anr Logs");
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73(concat), File.separator, k(context) + "_A.log");
    }

    public static String d(Context context) {
        return f(context).concat(File.separator).concat("Crash Logs");
    }

    public static String e(Context context) {
        return f(context).concat(File.separator).concat("Anr Logs");
    }

    public static String f(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        f4284a = absolutePath;
        return absolutePath.concat(File.separator).concat(UserExperior.TAG);
    }

    public static e g(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("RecordSettings", 0);
        e eVar = e.SCREEN_ONLY;
        int i = sharedPreferences.getInt("record", 0);
        e[] values = e.values();
        e eVar2 = (i >= values.length || i < 0) ? e.SCREEN_ONLY : values[i];
        new StringBuilder("recording ").append(eVar2.toString());
        return eVar2;
    }

    public static g h(Context context) {
        context.getSharedPreferences("RecordSettings", 0);
        int w = l.w(context);
        g gVar = w == 1 ? g.LOW : w == 2 ? g.MEDIUM : g.HIGH;
        new StringBuilder("recording quality ").append(gVar.toString());
        return gVar;
    }

    public static String i(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("RecordSettings", 0);
        return sharedPreferences.getString("sessionBasePath", f(context) + File.separator + f4286c);
    }

    public static Long j(Context context) {
        Long valueOf = Long.valueOf(context.getSharedPreferences("RecordSettings", 0).getLong("durationInSeconds", 0));
        new StringBuilder("GET : durationInSeconds ").append(valueOf);
        return valueOf;
    }

    public static String k(Context context) {
        String str;
        c a2 = l.a(context);
        long j = a2 != null ? a2.f3864a : -1;
        String g = l.g(context);
        if (g == null) {
            g = l.h(context);
        }
        String concat = g != null ? "_".concat(g) : "";
        if (j > 0) {
            str = String.valueOf(j);
        } else {
            int i = (f4285b > 0 ? 1 : (f4285b == 0 ? 0 : -1));
            StringBuilder sb = new StringBuilder();
            sb.append(File.separator);
            sb.append(i > 0 ? f4285b : System.currentTimeMillis());
            str = sb.toString();
        }
        return GeneratedOutlineSupport.outline52(str, concat, "_newer_sdk");
    }
}

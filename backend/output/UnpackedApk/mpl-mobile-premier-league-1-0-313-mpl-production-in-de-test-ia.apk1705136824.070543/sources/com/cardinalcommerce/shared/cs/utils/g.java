package com.cardinalcommerce.shared.cs.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.cardinalcommerce.shared.cs.f.j;
import java.nio.charset.StandardCharsets;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static g f2225a;

    /* renamed from: c  reason: collision with root package name */
    public static a f2226c;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f2227b;

    public g(Context context) {
        this.f2227b = context.getSharedPreferences("com.cardinalcommerce.cardinalmobilesdkcmsdk", 0);
    }

    public static synchronized g a(Context context) {
        g gVar;
        synchronized (g.class) {
            try {
                f2226c = a.e();
                if (f2225a == null) {
                    f2225a = new g(context);
                }
                gVar = f2225a;
            }
        }
        return gVar;
    }

    public void a(String str, String str2) {
        try {
            if (!j.a()) {
                this.f2227b.edit().putString(str, Base64.encodeToString(str2.getBytes(StandardCharsets.UTF_8), 0)).apply();
                return;
            }
            f2226c.a("Cardinal Configure", "Device is jail broken cannot access preferences", null);
        } catch (Exception e2) {
            a aVar = f2226c;
            String valueOf = String.valueOf(10703);
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error while saving/retrieving data from shared preferences \n");
            outline73.append(e2.getLocalizedMessage());
            aVar.b(valueOf, outline73.toString(), null);
        }
    }

    public long b(String str, long j) {
        try {
            return Long.parseLong(b(str, Long.toString(j)));
        } catch (NumberFormatException e2) {
            a aVar = f2226c;
            String valueOf = String.valueOf(10703);
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error while parsing retrieving data from shared preferences \n");
            outline73.append(e2.getLocalizedMessage());
            aVar.b(valueOf, outline73.toString(), null);
            return j;
        }
    }

    public String b(String str, String str2) {
        try {
            if (!j.a()) {
                String string = this.f2227b.getString(str, str2);
                if (string != str2) {
                    return new String(Base64.decode(string, 0), StandardCharsets.UTF_8);
                }
            } else {
                f2226c.a("Cardinal Configure", "Device is jail broken cannot access preferences", null);
            }
        } catch (Exception e2) {
            a aVar = f2226c;
            String valueOf = String.valueOf(10703);
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error while saving/retrieving data from shared preferences \n");
            outline73.append(e2.getLocalizedMessage());
            aVar.b(valueOf, outline73.toString(), null);
        }
        return str2;
    }
}

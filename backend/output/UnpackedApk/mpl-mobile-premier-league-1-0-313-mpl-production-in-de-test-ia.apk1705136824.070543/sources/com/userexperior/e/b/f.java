package com.userexperior.e.b;

import com.userexperior.e.c;
import com.userexperior.e.h;
import com.userexperior.e.m;
import in.juspay.hypersdk.core.InflateView;
import java.util.Map;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;
import org.jboss.netty.handler.codec.http.HttpHeaders.Values;

public final class f {
    public static long a(String str) {
        try {
            return h.b(str).getTime();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static c a(m mVar) {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long j5;
        m mVar2 = mVar;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = mVar2.f4009c;
        String str = map.get("Date");
        long a2 = str != null ? a(str) : 0;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",");
            int i2 = 0;
            j2 = 0;
            j = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals(Values.NO_STORE)) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            z = false;
            j2 = 0;
            j = 0;
        }
        String str3 = map.get("Expires");
        long a3 = str3 != null ? a(str3) : 0;
        String str4 = map.get("Last-Modified");
        long a4 = str4 != null ? a(str4) : 0;
        String str5 = map.get(Names.ETAG);
        if (z) {
            j4 = currentTimeMillis + (j2 * 1000);
            if (i != 0) {
                j5 = j4;
            } else {
                Long.signum(j);
                j5 = (j * 1000) + j4;
            }
            j3 = j5;
        } else {
            j3 = 0;
            if (a2 <= 0 || a3 < a2) {
                j4 = 0;
            } else {
                j4 = currentTimeMillis + (a3 - a2);
                j3 = j4;
            }
        }
        c cVar = new c();
        cVar.f3973a = mVar2.f4008b;
        cVar.f3974b = str5;
        cVar.f3978f = j4;
        cVar.f3977e = j3;
        cVar.f3975c = a2;
        cVar.f3976d = a4;
        cVar.g = map;
        return cVar;
    }

    public static String a(Map<String, String> map) {
        String str = map.get("Content-Type");
        if (str != null) {
            String[] split = str.split(";");
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split(InflateView.SETTER_EQUALS);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return "ISO-8859-1";
    }
}

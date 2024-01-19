package com.xiaomi.push;

import android.util.Pair;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class bb {

    /* renamed from: a  reason: collision with root package name */
    public static Vector<Pair<String, Long>> f4481a = new Vector<>();

    /* renamed from: a  reason: collision with other field name */
    public static ConcurrentHashMap<String, Long> f342a = new ConcurrentHashMap<>();

    public static String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (f4481a) {
            for (int i = 0; i < f4481a.size(); i++) {
                Pair elementAt = f4481a.elementAt(i);
                sb.append((String) elementAt.first);
                sb.append(":");
                sb.append(elementAt.second);
                if (i < f4481a.size() - 1) {
                    sb.append(";");
                }
            }
            f4481a.clear();
        }
        return sb.toString();
    }
}

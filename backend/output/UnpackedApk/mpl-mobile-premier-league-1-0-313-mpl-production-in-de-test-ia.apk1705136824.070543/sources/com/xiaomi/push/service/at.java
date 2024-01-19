package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dc;
import com.xiaomi.push.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class at {

    /* renamed from: a  reason: collision with root package name */
    public static volatile at f4871a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f855a;

    /* renamed from: a  reason: collision with other field name */
    public HashSet<a> f856a = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f4872b;

    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public int f4873a;

        /* renamed from: a  reason: collision with other field name */
        public String f857a;

        public a(int i, String str) {
            this.f4873a = i;
            this.f857a = str;
        }

        public abstract void a();

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.f4873a == ((a) obj).f4873a;
        }

        public int hashCode() {
            return this.f4873a;
        }

        public final void run() {
            a();
        }
    }

    public at(Context context) {
        this.f855a = context.getSharedPreferences("mipush_oc_normal", 0);
        this.f4872b = context.getSharedPreferences("mipush_oc_custom", 0);
    }

    public static at a(Context context) {
        if (f4871a == null) {
            synchronized (at.class) {
                try {
                    if (f4871a == null) {
                        f4871a = new at(context);
                    }
                }
            }
        }
        return f4871a;
    }

    private String a(int i) {
        return GeneratedOutlineSupport.outline41("oc_", i);
    }

    private String a(dc dcVar) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("oc_version_");
        outline73.append(dcVar.a());
        return outline73.toString();
    }

    private void a(Editor editor, Pair<Integer, Object> pair, String str) {
        Object obj = pair.second;
        if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof String) {
            editor.putString(str, (String) obj);
        } else if (obj instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) obj).booleanValue());
        }
    }

    public int a(int i, int i2) {
        try {
            String a2 = a(i);
            return this.f4872b.contains(a2) ? this.f4872b.getInt(a2, 0) : this.f855a.contains(a2) ? this.f855a.getInt(a2, 0) : i2;
        } catch (Exception e2) {
            b.a(i + " oc int error " + e2);
            return i2;
        }
    }

    public int a(dc dcVar, int i) {
        try {
            return this.f855a.getInt(a(dcVar), i);
        } catch (Exception e2) {
            b.a(dcVar + " version error " + e2);
            return i;
        }
    }

    public synchronized void a() {
        this.f856a.clear();
    }

    public synchronized void a(a aVar) {
        if (!this.f856a.contains(aVar)) {
            this.f856a.add(aVar);
        }
    }

    public void a(List<Pair<Integer, Object>> list) {
        if (!k.a(list)) {
            Editor edit = this.f4872b.edit();
            for (Pair next : list) {
                Object obj = next.first;
                if (obj != null) {
                    String a2 = a(((Integer) obj).intValue());
                    if (next.second == null) {
                        edit.remove(a2);
                    } else {
                        a(edit, next, a2);
                    }
                }
            }
            edit.apply();
        }
    }

    public void a(List<Pair<dc, Integer>> list, List<Pair<Integer, Object>> list2) {
        if (k.a(list) || k.a(list2)) {
            b.a((String) "not update oc, because versions or configs are empty");
            return;
        }
        Editor edit = this.f855a.edit();
        edit.clear();
        for (Pair next : list) {
            Object obj = next.first;
            if (!(obj == null || next.second == null)) {
                edit.putInt(a((dc) obj), ((Integer) next.second).intValue());
            }
        }
        for (Pair next2 : list2) {
            Object obj2 = next2.first;
            if (!(obj2 == null || next2.second == null)) {
                a(edit, next2, a(((Integer) obj2).intValue()));
            }
        }
        edit.apply();
    }

    public boolean a(int i, boolean z) {
        try {
            String a2 = a(i);
            return this.f4872b.contains(a2) ? this.f4872b.getBoolean(a2, false) : this.f855a.contains(a2) ? this.f855a.getBoolean(a2, false) : z;
        } catch (Exception e2) {
            b.a(i + " oc boolean error " + e2);
            return z;
        }
    }

    public void b() {
        b.c("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f856a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }
}

package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class x {

    /* renamed from: a  reason: collision with root package name */
    public static volatile x f4384a;

    /* renamed from: a  reason: collision with other field name */
    public Context f232a;

    /* renamed from: a  reason: collision with other field name */
    public List<r> f233a = new ArrayList();

    public x(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f232a = applicationContext;
        if (applicationContext == null) {
            this.f232a = context;
        }
    }

    public static x a(Context context) {
        if (f4384a == null) {
            synchronized (x.class) {
                try {
                    if (f4384a == null) {
                        f4384a = new x(context);
                    }
                }
            }
        }
        return f4384a;
    }

    public int a(String str) {
        synchronized (this.f233a) {
            r rVar = new r();
            rVar.f230a = str;
            if (this.f233a.contains(rVar)) {
                for (r next : this.f233a) {
                    if (next.equals(rVar)) {
                        int i = next.f4378a;
                        return i;
                    }
                }
            }
            return 0;
        }
    }

    public synchronized String a(am amVar) {
        try {
        }
        return this.f232a.getSharedPreferences("mipush_extra", 0).getString(amVar.name(), "");
    }

    public synchronized void a(am amVar, String str) {
        SharedPreferences sharedPreferences = this.f232a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(amVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m385a(String str) {
        synchronized (this.f233a) {
            r rVar = new r();
            rVar.f4378a = 0;
            rVar.f230a = str;
            if (this.f233a.contains(rVar)) {
                this.f233a.remove(rVar);
            }
            this.f233a.add(rVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m386a(String str) {
        synchronized (this.f233a) {
            r rVar = new r();
            rVar.f230a = str;
            return this.f233a.contains(rVar);
        }
    }

    public void b(String str) {
        synchronized (this.f233a) {
            r rVar = new r();
            rVar.f230a = str;
            if (this.f233a.contains(rVar)) {
                Iterator<r> it = this.f233a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    r next = it.next();
                    if (rVar.equals(next)) {
                        rVar = next;
                        break;
                    }
                }
            }
            rVar.f4378a++;
            this.f233a.remove(rVar);
            this.f233a.add(rVar);
        }
    }

    public void c(String str) {
        synchronized (this.f233a) {
            r rVar = new r();
            rVar.f230a = str;
            if (this.f233a.contains(rVar)) {
                this.f233a.remove(rVar);
            }
        }
    }
}

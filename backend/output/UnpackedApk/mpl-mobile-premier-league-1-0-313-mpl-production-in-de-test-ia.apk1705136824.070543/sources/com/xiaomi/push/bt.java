package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.az;
import com.xiaomi.push.service.bd;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class bt {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicInteger f4509a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public static boolean f383a;

    /* renamed from: a  reason: collision with other field name */
    public int f384a = 0;

    /* renamed from: a  reason: collision with other field name */
    public long f385a = -1;

    /* renamed from: a  reason: collision with other field name */
    public bu f386a;

    /* renamed from: a  reason: collision with other field name */
    public ce f387a = null;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f388a;

    /* renamed from: a  reason: collision with other field name */
    public String f389a = "";

    /* renamed from: a  reason: collision with other field name */
    public final Collection<bv> f390a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    public LinkedList<Pair<Integer, Long>> f391a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    public final Map<bx, a> f392a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public final int f4510b = f4509a.getAndIncrement();

    /* renamed from: b  reason: collision with other field name */
    public volatile long f393b = 0;

    /* renamed from: b  reason: collision with other field name */
    public String f394b = "";

    /* renamed from: b  reason: collision with other field name */
    public final Map<bx, a> f395b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public int f4511c = 2;

    /* renamed from: c  reason: collision with other field name */
    public volatile long f396c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f4512d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f4513e = 0;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public bx f4514a;

        /* renamed from: a  reason: collision with other field name */
        public cf f397a;

        public a(bx bxVar, cf cfVar) {
            this.f4514a = bxVar;
            this.f397a = cfVar;
        }

        public void a(bi biVar) {
            this.f4514a.a(biVar);
        }

        public void a(cj cjVar) {
            cf cfVar = this.f397a;
            if (cfVar == null || cfVar.a(cjVar)) {
                this.f4514a.a(cjVar);
            }
        }
    }

    static {
        f383a = false;
        try {
            f383a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        by.a();
    }

    public bt(XMPushService xMPushService, bu buVar) {
        this.f386a = buVar;
        this.f388a = xMPushService;
        b();
    }

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m532a(int i) {
        synchronized (this.f391a) {
            if (i == 1) {
                this.f391a.clear();
            } else {
                this.f391a.add(new Pair(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f391a.size() > 6) {
                    this.f391a.remove(0);
                }
            }
        }
    }

    public int a() {
        return this.f4511c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public bu m533a() {
        return this.f386a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m534a() {
        return this.f386a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<bx, a> m535a() {
        return this.f392a;
    }

    public void a(int i, int i2, Exception exc) {
        int i3 = this.f4511c;
        if (i != i3) {
            b.a(String.format("update the connection status. %1$s -> %2$s : %3$s ", new Object[]{a(i3), a(i), bd.a(i2)}));
        }
        if (y.a((Context) this.f388a)) {
            a(i);
        }
        if (i == 1) {
            this.f388a.a(10);
            if (this.f4511c != 0) {
                b.a((String) "try set connected while not connecting.");
            }
            this.f4511c = i;
            for (bv b2 : this.f390a) {
                b2.b(this);
            }
        } else if (i == 0) {
            if (this.f4511c != 2) {
                b.a((String) "try set connecting while not disconnected.");
            }
            this.f4511c = i;
            for (bv a2 : this.f390a) {
                a2.a(this);
            }
        } else if (i == 2) {
            this.f388a.a(10);
            int i4 = this.f4511c;
            if (i4 == 0) {
                for (bv a3 : this.f390a) {
                    a3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i4 == 1) {
                for (bv a4 : this.f390a) {
                    a4.a(this, i2, exc);
                }
            }
            this.f4511c = i;
        }
    }

    public void a(bv bvVar) {
        if (bvVar != null && !this.f390a.contains(bvVar)) {
            this.f390a.add(bvVar);
        }
    }

    public void a(bx bxVar, cf cfVar) {
        if (bxVar != null) {
            this.f392a.put(bxVar, new a(bxVar, cfVar));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    public abstract void a(cj cjVar);

    public abstract void a(az.b bVar);

    public synchronized void a(String str) {
        if (this.f4511c == 0) {
            b.a("setChallenge hash = " + ac.a(str).substring(0, 8));
            this.f389a = str;
            a(1, 0, null);
        } else {
            b.a((String) "ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(bi[] biVarArr);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m536a() {
        return false;
    }

    public synchronized boolean a(long j) {
        return this.f4513e >= j;
    }

    public String b() {
        return this.f386a.b();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m537b() {
        String str;
        if (this.f386a.a() && this.f387a == null) {
            Class<?> cls = null;
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = Class.forName(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (cls == null) {
                this.f387a = new br(this);
                return;
            }
            try {
                this.f387a = (ce) cls.getConstructor(new Class[]{bt.class, Writer.class, Reader.class}).newInstance(new Object[]{this});
            } catch (Exception e3) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e3);
            }
        }
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(bi biVar);

    public void b(bv bvVar) {
        this.f390a.remove(bvVar);
    }

    public void b(bx bxVar, cf cfVar) {
        if (bxVar != null) {
            this.f395b.put(bxVar, new a(bxVar, cfVar));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m538b() {
        return this.f4511c == 0;
    }

    public synchronized void c() {
        this.f4513e = SystemClock.elapsedRealtime();
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m539c() {
        return this.f4511c == 1;
    }

    public void d() {
        synchronized (this.f391a) {
            this.f391a.clear();
        }
    }
}

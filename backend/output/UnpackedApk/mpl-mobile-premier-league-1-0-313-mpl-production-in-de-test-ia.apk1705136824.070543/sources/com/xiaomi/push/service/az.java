package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.xiaomi.push.service.XMPushService.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class az {

    /* renamed from: a  reason: collision with root package name */
    public static az f4879a;

    /* renamed from: a  reason: collision with other field name */
    public List<a> f859a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public ConcurrentHashMap<String, HashMap<String, b>> f860a = new ConcurrentHashMap<>();

    public interface a {
        void a();
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f4880a = 0;

        /* renamed from: a  reason: collision with other field name */
        public Context f861a;

        /* renamed from: a  reason: collision with other field name */
        public DeathRecipient f862a = null;

        /* renamed from: a  reason: collision with other field name */
        public Messenger f863a;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.service.XMPushService.c f864a = new com.xiaomi.push.service.XMPushService.c(this);

        /* renamed from: a  reason: collision with other field name */
        public XMPushService f865a;

        /* renamed from: a  reason: collision with other field name */
        public final C0069b f866a = new C0069b();

        /* renamed from: a  reason: collision with other field name */
        public c f867a = c.unbind;

        /* renamed from: a  reason: collision with other field name */
        public j f868a;

        /* renamed from: a  reason: collision with other field name */
        public String f869a;

        /* renamed from: a  reason: collision with other field name */
        public final CopyOnWriteArrayList<a> f870a = new CopyOnWriteArrayList<>();

        /* renamed from: a  reason: collision with other field name */
        public boolean f871a;

        /* renamed from: b  reason: collision with root package name */
        public c f4881b = null;

        /* renamed from: b  reason: collision with other field name */
        public String f872b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f873b = false;

        /* renamed from: c  reason: collision with root package name */
        public String f4882c;

        /* renamed from: d  reason: collision with root package name */
        public String f4883d;

        /* renamed from: e  reason: collision with root package name */
        public String f4884e;

        /* renamed from: f  reason: collision with root package name */
        public String f4885f;
        public String g;
        public String h;
        public String i;

        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* renamed from: com.xiaomi.push.service.az$b$b  reason: collision with other inner class name */
        public class C0069b extends j {

            /* renamed from: a  reason: collision with other field name */
            public String f874a;

            /* renamed from: b  reason: collision with root package name */
            public int f4887b;

            /* renamed from: b  reason: collision with other field name */
            public String f875b;

            /* renamed from: c  reason: collision with root package name */
            public int f4888c;

            public C0069b() {
                super(0);
            }

            public j a(int i, int i2, String str, String str2) {
                this.f4887b = i;
                this.f4888c = i2;
                this.f875b = str2;
                this.f874a = str;
                return this;
            }

            public String a() {
                return "notify job";
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m829a() {
                if (b.this.a(this.f4887b, this.f4888c, this.f875b)) {
                    b.this.a(this.f4887b, this.f4888c, this.f874a, this.f875b);
                    return;
                }
                StringBuilder outline73 = GeneratedOutlineSupport.outline73(" ignore notify client :");
                outline73.append(b.this.g);
                com.xiaomi.channel.commonutils.logger.b.b(outline73.toString());
            }
        }

        public class c implements DeathRecipient {

            /* renamed from: a  reason: collision with root package name */
            public final Messenger f4889a;

            /* renamed from: a  reason: collision with other field name */
            public final b f876a;

            public c(b bVar, Messenger messenger) {
                this.f876a = bVar;
                this.f4889a = messenger;
            }

            public void binderDied() {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("peer died, chid = ");
                outline73.append(this.f876a.g);
                com.xiaomi.channel.commonutils.logger.b.b(outline73.toString());
                b.a(b.this).a((j) new bb(this, 0), 0);
                if ("9".equals(this.f876a.g) && "com.xiaomi.xmsf".equals(b.a(b.this).getPackageName())) {
                    b.a(b.this).a((j) new bc(this, 0), 60000);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.f865a = xMPushService;
            a((a) new ba(this));
        }

        public static String a(String str) {
            String str2 = "";
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf != -1) {
                str2 = str.substring(lastIndexOf + 1);
            }
            return str2;
        }

        /* access modifiers changed from: private */
        public void a(int i2, int i3, String str, String str2) {
            c cVar = this.f867a;
            this.f4881b = cVar;
            if (i2 == 2) {
                this.f868a.a(this.f861a, this, i3);
            } else if (i2 == 3) {
                this.f868a.a(this.f861a, this, str2, str);
            } else if (i2 == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.f4880a++;
                } else if (z) {
                    this.f4880a = 0;
                    if (this.f863a != null) {
                        try {
                            this.f863a.send(Message.obtain(null, 16, this.f865a.f791a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f868a.a(this.f865a, this, z, i3, str);
            }
        }

        /* access modifiers changed from: private */
        public boolean a(int i2, int i3, String str) {
            String str2;
            StringBuilder sb;
            c cVar = this.f4881b;
            if (cVar != null) {
                boolean z = this.f873b;
                if (z) {
                    if (cVar == this.f867a) {
                        sb = new StringBuilder();
                        str2 = " status recovered, don't notify client:";
                    } else if (this.f863a == null || !z) {
                        sb = new StringBuilder();
                        str2 = "peer died, ignore notify ";
                    } else {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Peer alive notify status to client:");
                        outline73.append(this.g);
                        com.xiaomi.channel.commonutils.logger.b.b(outline73.toString());
                        return true;
                    }
                    sb.append(str2);
                    sb.append(this.g);
                    com.xiaomi.channel.commonutils.logger.b.b(sb.toString());
                    return false;
                }
            }
            return true;
        }

        private boolean b(int i2, int i3, String str) {
            if (i2 == 1) {
                return this.f867a != c.binded && this.f865a.d() && i3 != 21 && (i3 != 7 || !"wait".equals(str));
            }
            if (i2 == 2) {
                return this.f865a.d();
            }
            if (i2 != 3) {
                return false;
            }
            return !"wait".equals(str);
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((long) ((this.f4880a + 1) * 15))) * 1000;
        }

        public String a(int i2) {
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m828a() {
            try {
                Messenger messenger = this.f863a;
                if (!(messenger == null || this.f862a == null)) {
                    messenger.getBinder().unlinkToDeath(this.f862a, 0);
                }
            } catch (Exception unused) {
            }
            this.f4881b = null;
        }

        public void a(Messenger messenger) {
            a();
            if (messenger != null) {
                try {
                    this.f863a = messenger;
                    this.f873b = true;
                    this.f862a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f862a, 0);
                } catch (Exception e2) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("peer linkToDeath err: ");
                    outline73.append(e2.getMessage());
                    com.xiaomi.channel.commonutils.logger.b.b(outline73.toString());
                    this.f863a = null;
                    this.f873b = false;
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.g);
            }
        }

        public void a(a aVar) {
            this.f870a.add(aVar);
        }

        public void a(c cVar, int i2, int i3, String str, String str2) {
            Iterator<a> it = this.f870a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(this.f867a, cVar, i3);
                }
            }
            c cVar2 = this.f867a;
            int i4 = 0;
            if (cVar2 != cVar) {
                com.xiaomi.channel.commonutils.logger.b.a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", new Object[]{cVar2, cVar, a(i2), bd.a(i3), str, str2, this.g}));
                this.f867a = cVar;
            }
            if (this.f868a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            } else if (cVar != c.binding) {
                if (this.f4881b != null) {
                    boolean z = this.f873b;
                    if (z) {
                        i4 = (this.f863a == null || !z) ? 10100 : 1000;
                    }
                }
                this.f865a.b((j) this.f866a);
                if (b(i2, i3, str2)) {
                    a(i2, i3, str, str2);
                } else {
                    this.f865a.a(this.f866a.a(i2, i3, str, str2), (long) i4);
                }
            }
        }
    }

    public enum c {
        unbind,
        binding,
        binded
    }

    public static synchronized az a() {
        az azVar;
        synchronized (az.class) {
            try {
                if (f4879a == null) {
                    f4879a = new az();
                }
                azVar = f4879a;
            }
        }
        return azVar;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(ColorPropConverter.PREFIX_RESOURCE);
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m821a() {
        return this.f860a.size();
    }

    public synchronized b a(String str, String str2) {
        try {
            HashMap hashMap = this.f860a.get(str);
            if (hashMap == null) {
                return null;
            }
            return (b) hashMap.get(a(str2));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<b> m822a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, b> values : this.f860a.values()) {
            arrayList.addAll(values.values());
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<b> m823a(String str) {
        if (!this.f860a.containsKey(str)) {
            return new ArrayList();
        }
        return ((HashMap) this.f860a.get(str).clone()).values();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<String> m824a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, b> values : this.f860a.values()) {
            for (b bVar : values.values()) {
                if (str.equals(bVar.f869a)) {
                    arrayList.add(bVar.g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m825a() {
        Iterator it = a().iterator();
        while (it.hasNext()) {
            ((b) it.next()).a();
        }
        this.f860a.clear();
    }

    public synchronized void a(Context context) {
        for (HashMap<String, b> values : this.f860a.values()) {
            for (b a2 : values.values()) {
                a2.a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context, int i) {
        for (HashMap<String, b> values : this.f860a.values()) {
            for (b a2 : values.values()) {
                a2.a(c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.f859a.add(aVar);
    }

    public synchronized void a(b bVar) {
        HashMap hashMap = this.f860a.get(bVar.g);
        if (hashMap == null) {
            hashMap = new HashMap();
            this.f860a.put(bVar.g, hashMap);
        }
        hashMap.put(a(bVar.f872b), bVar);
        com.xiaomi.channel.commonutils.logger.b.a("add active client. " + bVar.f869a);
        for (a a2 : this.f859a) {
            a2.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m826a(String str) {
        HashMap hashMap = this.f860a.get(str);
        if (hashMap != null) {
            for (b a2 : hashMap.values()) {
                a2.a();
            }
            hashMap.clear();
            this.f860a.remove(str);
        }
        for (a a3 : this.f859a) {
            a3.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m827a(String str, String str2) {
        HashMap hashMap = this.f860a.get(str);
        if (hashMap != null) {
            b bVar = (b) hashMap.get(a(str2));
            if (bVar != null) {
                bVar.a();
            }
            hashMap.remove(a(str2));
            if (hashMap.isEmpty()) {
                this.f860a.remove(str);
            }
        }
        for (a a2 : this.f859a) {
            a2.a();
        }
    }

    public synchronized void b() {
        this.f859a.clear();
    }
}

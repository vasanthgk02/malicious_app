package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.crimzoncode.tqcontests.util.TQConstants;
import com.facebook.react.bridge.ColorPropConverter;
import com.paynimo.android.payment.util.Constant;
import com.xiaomi.channel.commonutils.android.MIPushProvider;
import com.xiaomi.channel.commonutils.android.Region;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.ac;
import com.xiaomi.push.ak;
import com.xiaomi.push.bc;
import com.xiaomi.push.bi;
import com.xiaomi.push.bp;
import com.xiaomi.push.bt;
import com.xiaomi.push.bu;
import com.xiaomi.push.bv;
import com.xiaomi.push.bx;
import com.xiaomi.push.by;
import com.xiaomi.push.cd;
import com.xiaomi.push.cf;
import com.xiaomi.push.ci;
import com.xiaomi.push.cj;
import com.xiaomi.push.cx;
import com.xiaomi.push.cz;
import com.xiaomi.push.dq;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.ee;
import com.xiaomi.push.ej;
import com.xiaomi.push.u;
import com.xiaomi.push.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class XMPushService extends Service implements bv {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f4812b;

    /* renamed from: a  reason: collision with root package name */
    public int f4813a = 0;

    /* renamed from: a  reason: collision with other field name */
    public long f789a = 0;

    /* renamed from: a  reason: collision with other field name */
    public ContentObserver f790a;

    /* renamed from: a  reason: collision with other field name */
    public Messenger f791a = null;

    /* renamed from: a  reason: collision with other field name */
    public bp f792a;

    /* renamed from: a  reason: collision with other field name */
    public bt f793a;

    /* renamed from: a  reason: collision with other field name */
    public bu f794a;

    /* renamed from: a  reason: collision with other field name */
    public bx f795a = new bx(this);

    /* renamed from: a  reason: collision with other field name */
    public a f796a;

    /* renamed from: a  reason: collision with other field name */
    public f f797a;

    /* renamed from: a  reason: collision with other field name */
    public k f798a;

    /* renamed from: a  reason: collision with other field name */
    public r f799a;

    /* renamed from: a  reason: collision with other field name */
    public t f800a;

    /* renamed from: a  reason: collision with other field name */
    public ax f801a = null;

    /* renamed from: a  reason: collision with other field name */
    public bi f802a;

    /* renamed from: a  reason: collision with other field name */
    public j f803a;

    /* renamed from: a  reason: collision with other field name */
    public o f804a = null;

    /* renamed from: a  reason: collision with other field name */
    public Class f805a = XMJobService.class;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<n> f806a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public Collection<ak> f807a = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    public boolean f808a = false;

    /* renamed from: b  reason: collision with other field name */
    public int f809b = 0;

    public class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with other field name */
        public final Object f810a;

        public a() {
            this.f810a = new Object();
        }

        public /* synthetic */ a(XMPushService xMPushService, bx bxVar) {
            this();
        }

        /* access modifiers changed from: private */
        public void a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (this.f810a) {
                try {
                    this.f810a.notifyAll();
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a("[Alarm] notify lock. " + e2);
                }
            }
        }

        private void a(long j) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.wait in the UI thread!");
                return;
            }
            synchronized (this.f810a) {
                try {
                    this.f810a.wait(j);
                } catch (InterruptedException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a("[Alarm] interrupt from waiting state. " + e2);
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            long currentTimeMillis = System.currentTimeMillis();
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] heartbeat alarm has been triggered.");
            if (!bd.q.equals(intent.getAction())) {
                com.xiaomi.channel.commonutils.logger.b.a((String) "[Alarm] cancel the old ping timer");
                bc.a();
            } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.getInstance(context).startServiceSafely(intent2);
                    a((long) TQConstants.COUNTDOWN_DURATION);
                    com.xiaomi.channel.commonutils.logger.b.a("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable unused) {
                }
            }
        }
    }

    public class b extends j {

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.service.az.b f811a = null;

        public b(com.xiaomi.push.service.az.b bVar) {
            super(9);
            this.f811a = bVar;
        }

        public String a() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("bind the client. ");
            outline73.append(this.f811a.g);
            return outline73.toString();
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m772a() {
            String str;
            try {
                if (!XMPushService.this.d()) {
                    com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                    return;
                }
                com.xiaomi.push.service.az.b a2 = az.a().a(this.f811a.g, this.f811a.f872b);
                if (a2 == null) {
                    str = "ignore bind because the channel " + this.f811a.g + " is removed ";
                } else if (a2.f867a == com.xiaomi.push.service.az.c.unbind) {
                    a2.a(com.xiaomi.push.service.az.c.binding, 0, 0, (String) null, (String) null);
                    XMPushService.a(XMPushService.this).a(a2);
                    return;
                } else {
                    str = "trying duplicate bind, ingore! " + a2.f867a;
                }
                com.xiaomi.channel.commonutils.logger.b.a(str);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("Meet error when trying to bind. " + e2);
                XMPushService.this.a(10, e2);
            } catch (Throwable unused) {
            }
        }
    }

    public static class c extends j {

        /* renamed from: a  reason: collision with root package name */
        public final com.xiaomi.push.service.az.b f4816a;

        public c(com.xiaomi.push.service.az.b bVar) {
            super(12);
            this.f4816a = bVar;
        }

        public String a() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("bind time out. chid=");
            outline73.append(this.f4816a.g);
            return outline73.toString();
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m773a() {
            this.f4816a.a(com.xiaomi.push.service.az.c.unbind, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            return TextUtils.equals(((c) obj).f4816a.g, this.f4816a.g);
        }

        public int hashCode() {
            return this.f4816a.g.hashCode();
        }
    }

    public class d extends j {

        /* renamed from: a  reason: collision with root package name */
        public bi f4817a = null;

        public d(bi biVar) {
            super(8);
            this.f4817a = biVar;
        }

        public String a() {
            return "receive a message.";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m774a() {
            XMPushService.a(XMPushService.this).a(this.f4817a);
        }
    }

    public class e extends j {
        public e() {
            super(1);
        }

        public String a() {
            return "do reconnect..";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m775a() {
            if (XMPushService.this.b()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                    return;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.a((String) "should not connect. quit the job.");
        }
    }

    public class f extends BroadcastReceiver {
        public f() {
        }

        public void onReceive(Context context, Intent intent) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("network changed, ");
            outline73.append(com.xiaomi.channel.commonutils.android.f.a(intent));
            com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
            XMPushService.this.onStart(intent, 1);
        }
    }

    public class g extends j {

        /* renamed from: a  reason: collision with other field name */
        public Exception f813a;

        /* renamed from: b  reason: collision with root package name */
        public int f4821b;

        public g(int i, Exception exc) {
            super(2);
            this.f4821b = i;
            this.f813a = exc;
        }

        public String a() {
            return "disconnect the connection.";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m776a() {
            XMPushService.this.a(this.f4821b, this.f813a);
        }
    }

    public class h extends j {
        public h() {
            super(65535);
        }

        public String a() {
            return "Init Job";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m777a() {
            XMPushService.b(XMPushService.this);
        }
    }

    public class i extends j {

        /* renamed from: a  reason: collision with root package name */
        public Intent f4823a = null;

        public i(Intent intent) {
            super(15);
            this.f4823a = intent;
        }

        public String a() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Handle intent action = ");
            outline73.append(this.f4823a.getAction());
            return outline73.toString();
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m778a() {
            XMPushService.this.d(this.f4823a);
        }
    }

    public static abstract class j extends com.xiaomi.push.service.o.b {
        public j(int i) {
            super(i);
        }

        public abstract String a();

        /* renamed from: a  reason: collision with other method in class */
        public abstract void m779a();

        public void run() {
            int i = this.f4958a;
            if (!(i == 4 || i == 8)) {
                com.xiaomi.channel.commonutils.logger.b.a(com.xiaomi.channel.commonutils.logger.a.f4318a, a());
            }
            a();
        }
    }

    public class k extends BroadcastReceiver {
        public k() {
        }

        public void onReceive(Context context, Intent intent) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("[HB] hold short heartbeat, ");
            outline73.append(com.xiaomi.channel.commonutils.android.f.a(intent));
            com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
            if (intent != null && intent.getExtras() != null) {
                XMPushService.this.onStart(intent, 1);
            }
        }
    }

    public class l extends j {
        public l() {
            super(5);
        }

        public String a() {
            return "ask the job queue to quit";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m780a() {
            XMPushService.a(XMPushService.this).a();
        }
    }

    public class m extends j {

        /* renamed from: a  reason: collision with root package name */
        public cj f4826a = null;

        public m(cj cjVar) {
            super(8);
            this.f4826a = cjVar;
        }

        public String a() {
            return "receive a message.";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m781a() {
            XMPushService.a(XMPushService.this).a(this.f4826a);
        }
    }

    public interface n {
        void a();
    }

    public class o extends j {

        /* renamed from: a  reason: collision with other field name */
        public boolean f816a;

        public o(boolean z) {
            super(4);
            this.f816a = z;
        }

        public String a() {
            return "send ping..";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m782a() {
            if (XMPushService.this.d()) {
                try {
                    XMPushService.a(XMPushService.this).b(this.f816a);
                } catch (cd e2) {
                    com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
                    XMPushService.this.a(10, (Exception) e2);
                }
            }
        }
    }

    public class p extends j {

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.service.az.b f817a = null;

        public p(com.xiaomi.push.service.az.b bVar) {
            super(4);
            this.f817a = bVar;
        }

        public String a() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("rebind the client. ");
            outline73.append(this.f817a.g);
            return outline73.toString();
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m783a() {
            try {
                this.f817a.a(com.xiaomi.push.service.az.c.unbind, 1, 16, (String) null, (String) null);
                XMPushService.a(XMPushService.this).a(this.f817a.g, this.f817a.f872b);
                XMPushService.this.a((j) new b(this.f817a), 300);
            } catch (cd e2) {
                com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
                XMPushService.this.a(10, (Exception) e2);
            }
        }
    }

    public class q extends j {
        public q() {
            super(3);
        }

        public String a() {
            return "reset the connection.";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m784a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.b()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                }
            }
        }
    }

    public class r extends BroadcastReceiver {
        public r() {
        }

        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    public class s extends j {

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.service.az.b f818a = null;

        /* renamed from: a  reason: collision with other field name */
        public String f819a;

        /* renamed from: b  reason: collision with root package name */
        public int f4832b;

        /* renamed from: b  reason: collision with other field name */
        public String f820b;

        public s(com.xiaomi.push.service.az.b bVar, int i, String str, String str2) {
            super(9);
            this.f818a = bVar;
            this.f4832b = i;
            this.f819a = str;
            this.f820b = str2;
        }

        public String a() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("unbind the channel. ");
            outline73.append(this.f818a.g);
            return outline73.toString();
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m785a() {
            if (!(this.f818a.f867a == com.xiaomi.push.service.az.c.unbind || XMPushService.a(XMPushService.this) == null)) {
                try {
                    XMPushService.a(XMPushService.this).a(this.f818a.g, this.f818a.f872b);
                } catch (cd e2) {
                    com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
                    XMPushService.this.a(10, (Exception) e2);
                }
            }
            this.f818a.a(com.xiaomi.push.service.az.c.unbind, this.f4832b, 0, this.f820b, this.f819a);
        }
    }

    public class t extends BroadcastReceiver {
        public t() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!XMPushService.b(XMPushService.this)) {
                XMPushService.this.f808a = true;
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("[HB] wifi changed, ");
            outline73.append(com.xiaomi.channel.commonutils.android.f.a(intent));
            com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
            XMPushService.this.onStart(intent, 1);
        }
    }

    private cj a(cj cjVar, String str, String str2) {
        StringBuilder sb;
        String str3;
        az a2 = az.a();
        List a3 = a2.a(str);
        if (a3.isEmpty()) {
            sb = new StringBuilder();
            str3 = "open channel should be called first before sending a packet, pkg=";
        } else {
            cjVar.o(str);
            str = cjVar.k();
            if (TextUtils.isEmpty(str)) {
                str = (String) a3.get(0);
                cjVar.l(str);
            }
            com.xiaomi.push.service.az.b a4 = a2.a(str, cjVar.m());
            if (!d()) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not connected, chid=";
            } else if (a4 == null || a4.f867a != com.xiaomi.push.service.az.c.binded) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not opened, chid=";
            } else if (TextUtils.equals(str2, a4.i)) {
                return cjVar;
            } else {
                sb = new StringBuilder();
                sb.append("invalid session. ");
                sb.append(str2);
                com.xiaomi.channel.commonutils.logger.b.a(sb.toString());
                return null;
            }
        }
        sb.append(str3);
        sb.append(str);
        com.xiaomi.channel.commonutils.logger.b.a(sb.toString());
        return null;
    }

    private com.xiaomi.push.service.az.b a(String str, Intent intent) {
        com.xiaomi.push.service.az.b a2 = az.a().a(str, intent.getStringExtra(bd.r));
        if (a2 == null) {
            a2 = new com.xiaomi.push.service.az.b(this);
        }
        a2.g = intent.getStringExtra(bd.u);
        a2.f872b = intent.getStringExtra(bd.r);
        a2.f4882c = intent.getStringExtra(bd.w);
        a2.f869a = intent.getStringExtra(bd.C);
        a2.f4884e = intent.getStringExtra(bd.A);
        a2.f4885f = intent.getStringExtra(bd.B);
        a2.f871a = intent.getBooleanExtra(bd.z, false);
        a2.h = intent.getStringExtra(bd.y);
        a2.i = intent.getStringExtra(bd.G);
        a2.f4883d = intent.getStringExtra(bd.x);
        a2.f868a = this.f803a;
        a2.a((Messenger) intent.getParcelableExtra(bd.K));
        a2.f861a = getApplicationContext();
        az.a().a(a2);
        return a2;
    }

    private String a() {
        String a2 = com.xiaomi.channel.commonutils.android.f.a((String) "ro.miui.region");
        return TextUtils.isEmpty(a2) ? com.xiaomi.channel.commonutils.android.f.a((String) "ro.product.locale.region") : a2;
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e2) {
                com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
            }
        }
    }

    private void a(Intent intent) {
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                n.a(getApplicationContext()).a(extras.getString("digest"));
            }
        }
    }

    private void a(Intent intent, int i2) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        dt dtVar = new dt();
        try {
            ee.a(dtVar, byteArrayExtra);
            com.xiaomi.push.o.a(getApplicationContext()).a((com.xiaomi.push.o.a) new b(dtVar, new WeakReference(this), booleanExtra), i2);
        } catch (ej unused) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_ping : send help app ping  error");
        }
    }

    private void a(a aVar) {
        String str;
        StringBuilder sb;
        if (aVar == null || !TextUtils.isEmpty(aVar.b()) || TextUtils.isEmpty(aVar.a())) {
            str = "no need to check country code";
        } else {
            String a2 = "com.xiaomi.xmsf".equals(getPackageName()) ? a() : com.xiaomi.channel.commonutils.android.f.b();
            if (!TextUtils.isEmpty(a2)) {
                String b2 = com.xiaomi.channel.commonutils.android.f.b(a2);
                if (TextUtils.equals(b2, aVar.a())) {
                    aVar.b(a2);
                    sb = new StringBuilder();
                    sb.append("update country code： ");
                    sb.append(a2);
                } else {
                    sb = new StringBuilder();
                    sb.append("not update country code, because not equals ");
                    sb.append(b2);
                }
                com.xiaomi.channel.commonutils.logger.b.a(sb.toString());
                return;
            }
            str = "check no country code";
        }
        com.xiaomi.channel.commonutils.logger.b.b(str);
    }

    public static void a(String str) {
        String str2;
        String str3;
        if (Region.Global.name().equals(str)) {
            ak.a((String) "app.chat.global.xiaomi.net", (String) "app.chat.global.xiaomi.net");
            str2 = "resolver.msg.global.xiaomi.net";
            ak.a(str2, (String) "47.241.174.254:443");
            str3 = "47.241.56.51:443";
        } else if (Region.Europe.name().equals(str)) {
            ak.a((String) "fr.app.chat.global.xiaomi.net", (String) "fr.app.chat.global.xiaomi.net");
            str2 = "fr.resolver.msg.global.xiaomi.net";
            str3 = "fr-resolver-msg-global-xiaomi-n-916220403.eu-central-1.elb.amazonaws.com";
        } else if (Region.Russia.name().equals(str)) {
            ak.a((String) "ru.app.chat.global.xiaomi.net", (String) "ru.app.chat.global.xiaomi.net");
            str2 = "ru.resolver.msg.global.xiaomi.net";
            str3 = "107.155.52.31:443";
        } else if (Region.India.name().equals(str)) {
            ak.a((String) "idmb.app.chat.global.xiaomi.net", (String) "idmb.app.chat.global.xiaomi.net");
            str2 = "mb.resolver.msg.global.xiaomi.net";
            str3 = "resolver-msg-xiaomi-net-665721575.ap-south-1.elb.amazonaws.com";
        } else {
            return;
        }
        ak.a(str2, str3);
    }

    private void a(String str, int i2) {
        Collection<com.xiaomi.push.service.az.b> a2 = az.a().a(str);
        if (a2 != null) {
            for (com.xiaomi.push.service.az.b bVar : a2) {
                if (bVar != null) {
                    s sVar = new s(bVar, i2, null, null);
                    a((j) sVar);
                }
            }
        }
        az.a().a(str);
    }

    /* access modifiers changed from: private */
    public boolean a(Context context) {
        try {
            u.a();
            for (int i2 = 100; i2 > 0; i2--) {
                if (y.b(context)) {
                    com.xiaomi.channel.commonutils.logger.b.a((String) "network connectivity ok.");
                    return true;
                }
                try {
                    Thread.sleep(100);
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return true;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m755a(String str, Intent intent) {
        com.xiaomi.push.service.az.b a2 = az.a().a(str, intent.getStringExtra(bd.r));
        boolean z = false;
        if (a2 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(bd.G);
        String stringExtra2 = intent.getStringExtra(bd.y);
        if (!TextUtils.isEmpty(a2.i) && !TextUtils.equals(stringExtra, a2.i)) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("session changed. old session=");
            GeneratedOutlineSupport.outline103(outline73, a2.i, ", new session=", stringExtra, " chid = ");
            outline73.append(str);
            com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
            z = true;
        }
        if (stringExtra2.equals(a2.h)) {
            return z;
        }
        StringBuilder outline80 = GeneratedOutlineSupport.outline80("security changed. chid = ", str, " sechash = ");
        outline80.append(ac.a(stringExtra2));
        com.xiaomi.channel.commonutils.logger.b.a(outline80.toString());
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    private int[] m756a() {
        if (!TextUtils.isEmpty("")) {
            String[] split = "".split(",");
            if (split != null && split.length >= 2) {
                int[] iArr = new int[2];
                try {
                    iArr[0] = Integer.valueOf(split[0]).intValue();
                    iArr[1] = Integer.valueOf(split[1]).intValue();
                    if (iArr[0] < 0 || iArr[0] > 23 || iArr[1] < 0 || iArr[1] > 23 || iArr[0] == iArr[1]) {
                        return null;
                    }
                    return iArr;
                } catch (NumberFormatException e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("parse falldown time range failure: " + e2);
                }
            }
        }
        return null;
    }

    private String b() {
        u.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        String str = null;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            bf a2 = bf.a(this);
            while (true) {
                if (!TextUtils.isEmpty(str) && a2.a() != 0) {
                    break;
                }
                if (TextUtils.isEmpty(str)) {
                    str = a();
                }
                try {
                    synchronized (obj) {
                        obj.wait(100);
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        com.xiaomi.channel.commonutils.logger.b.a("wait countryCode :" + str + " cost = " + elapsedRealtime2);
        return str;
    }

    private void b(Intent intent) {
        long j2;
        String stringExtra = intent.getStringExtra(bd.C);
        String stringExtra2 = intent.getStringExtra(bd.G);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        az a2 = az.a();
        bi biVar = null;
        if (bundleExtra != null) {
            ci ciVar = (ci) a((cj) new ci(bundleExtra), stringExtra, stringExtra2);
            if (ciVar != null) {
                biVar = bi.a((cj) ciVar, a2.a(ciVar.k(), ciVar.m()).h);
            } else {
                return;
            }
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j2 = Long.parseLong(intent.getStringExtra(bd.r));
                } catch (NumberFormatException unused) {
                    j2 = 0;
                }
                String stringExtra3 = intent.getStringExtra(bd.s);
                String stringExtra4 = intent.getStringExtra(bd.t);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                com.xiaomi.push.service.az.b a3 = a2.a(stringExtra5, String.valueOf(j2));
                if (a3 != null) {
                    bi biVar2 = new bi();
                    try {
                        biVar2.a(Integer.parseInt(stringExtra5));
                    } catch (NumberFormatException unused2) {
                    }
                    biVar2.a((String) "SECMSG", (String) null);
                    if (TextUtils.isEmpty(stringExtra3)) {
                        stringExtra3 = "xiaomi.com";
                    }
                    biVar2.a(j2, stringExtra3, stringExtra4);
                    biVar2.a(intent.getStringExtra("ext_pkt_id"));
                    biVar2.a(byteArrayExtra, a3.h);
                    com.xiaomi.channel.commonutils.logger.b.a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                    biVar = biVar2;
                }
            }
        }
        if (biVar != null) {
            c((j) new bl(this, biVar));
        }
    }

    private void b(boolean z) {
        if (!com.xiaomi.channel.commonutils.android.f.a() && z) {
            ak.b();
        }
    }

    private void c() {
        ak.a().e();
        boolean a2 = a();
        if (i() && a2) {
            ch chVar = new ch(this, 11);
            a((j) chVar);
            r.a((com.xiaomi.push.service.r.a) new ci(this, chVar));
        }
        try {
            if (com.xiaomi.channel.commonutils.android.j.a()) {
                this.f803a.a((Context) this);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
        }
    }

    private void c(Intent intent) {
        String stringExtra = intent.getStringExtra(bd.C);
        String stringExtra2 = intent.getStringExtra(bd.G);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        ci[] ciVarArr = new ci[length];
        intent.getBooleanExtra("ext_encrypt", true);
        int i2 = 0;
        while (i2 < parcelableArrayExtra.length) {
            ciVarArr[i2] = new ci((Bundle) parcelableArrayExtra[i2]);
            ciVarArr[i2] = (ci) a((cj) ciVarArr[i2], stringExtra, stringExtra2);
            if (ciVarArr[i2] != null) {
                i2++;
            } else {
                return;
            }
        }
        az a2 = az.a();
        bi[] biVarArr = new bi[length];
        for (int i3 = 0; i3 < length; i3++) {
            ci ciVar = ciVarArr[i3];
            biVarArr[i3] = bi.a((cj) ciVar, a2.a(ciVar.k(), ciVar.m()).h);
        }
        c((j) new c(this, biVarArr));
    }

    private void c(j jVar) {
        this.f804a.a((com.xiaomi.push.service.o.b) jVar);
    }

    private void c(boolean z) {
        this.f789a = SystemClock.elapsedRealtime();
        if (d()) {
            if (y.a((Context) this)) {
                c((j) new o(z));
                return;
            }
            c((j) new g(17, null));
        }
        a(true);
    }

    private void d() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
            networkInfo = null;
        }
        n.a(getApplicationContext()).a(networkInfo);
        if (networkInfo != null) {
            StringBuilder outline77 = GeneratedOutlineSupport.outline77("[", "type: ");
            outline77.append(networkInfo.getTypeName());
            outline77.append("[");
            outline77.append(networkInfo.getSubtypeName());
            outline77.append("], state: ");
            outline77.append(networkInfo.getState());
            outline77.append("/");
            outline77.append(networkInfo.getDetailedState());
            com.xiaomi.channel.commonutils.logger.b.a("network changed," + outline77.toString());
            State state = networkInfo.getState();
            if (state == State.SUSPENDED || state == State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.a((String) "network changed, no active network");
        }
        cx.a((Context) this);
        this.f792a.d();
        if (y.a((Context) this)) {
            if (d() && g()) {
                c(false);
            }
            if (!d() && !e()) {
                this.f804a.a(1);
                a((j) new e());
            }
        } else {
            a((j) new g(2, null));
        }
        e();
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r15v2, types: [com.xiaomi.push.service.XMPushService$j] */
    /* JADX WARNING: type inference failed for: r15v11, types: [com.xiaomi.push.service.XMPushService$p] */
    /* JADX WARNING: type inference failed for: r15v12, types: [com.xiaomi.push.service.XMPushService$b] */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r0v74, types: [boolean] */
    /* JADX WARNING: type inference failed for: r4v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r4v3, types: [int] */
    /* JADX WARNING: type inference failed for: r4v4, types: [int] */
    /* JADX WARNING: type inference failed for: r2v33, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v34, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v138, types: [com.xiaomi.push.service.cj] */
    /* JADX WARNING: type inference failed for: r2v38, types: [com.xiaomi.push.service.az$b] */
    /* JADX WARNING: type inference failed for: r2v39, types: [com.xiaomi.push.service.az$b] */
    /* JADX WARNING: type inference failed for: r2v41, types: [com.xiaomi.push.service.az$b] */
    /* JADX WARNING: type inference failed for: r15v80, types: [com.xiaomi.push.service.XMPushService$q] */
    /* JADX WARNING: type inference failed for: r15v95 */
    /* JADX WARNING: type inference failed for: r15v96 */
    /* JADX WARNING: type inference failed for: r2v51 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r2v52 */
    /* JADX WARNING: type inference failed for: r0v169, types: [com.xiaomi.push.service.cj] */
    /* JADX WARNING: type inference failed for: r2v53 */
    /* JADX WARNING: type inference failed for: r2v54 */
    /* JADX WARNING: type inference failed for: r15v97 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x076c, code lost:
        if (e() == false) goto L_0x080c;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], int]
      uses: [boolean, ?[int, boolean, OBJECT, ARRAY, byte, short, char], int]
      mth insns count: 601
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x03f7  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0452  */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(android.content.Intent r15) {
        /*
            r14 = this;
            com.xiaomi.push.service.az r0 = com.xiaomi.push.service.az.a()
            java.lang.String r1 = com.xiaomi.push.service.bd.f4901d
            java.lang.String r2 = r15.getAction()
            boolean r1 = r1.equalsIgnoreCase(r2)
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 != 0) goto L_0x0790
            java.lang.String r1 = com.xiaomi.push.service.bd.j
            java.lang.String r5 = r15.getAction()
            boolean r1 = r1.equalsIgnoreCase(r5)
            if (r1 == 0) goto L_0x0021
            goto L_0x0790
        L_0x0021:
            java.lang.String r1 = com.xiaomi.push.service.bd.i
            java.lang.String r5 = r15.getAction()
            boolean r1 = r1.equalsIgnoreCase(r5)
            if (r1 == 0) goto L_0x0087
            java.lang.String r1 = com.xiaomi.push.service.bd.C
            java.lang.String r1 = r15.getStringExtra(r1)
            java.lang.String r3 = com.xiaomi.push.service.bd.u
            java.lang.String r5 = r15.getStringExtra(r3)
            java.lang.String r3 = com.xiaomi.push.service.bd.r
            java.lang.String r6 = r15.getStringExtra(r3)
            java.lang.String r15 = "Service called close channel chid = "
            java.lang.String r3 = " res = "
            java.lang.StringBuilder r15 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r15, r5, r3)
            java.lang.String r3 = com.xiaomi.push.service.az.b.a(r6)
            r15.append(r3)
            java.lang.String r15 = r15.toString()
            com.xiaomi.channel.commonutils.logger.b.a(r15)
            boolean r15 = android.text.TextUtils.isEmpty(r5)
            if (r15 == 0) goto L_0x0073
            java.util.List r15 = r0.a(r1)
            java.util.Iterator r15 = r15.iterator()
        L_0x0063:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x0815
            java.lang.Object r0 = r15.next()
            java.lang.String r0 = (java.lang.String) r0
            r14.a(r0, r2)
            goto L_0x0063
        L_0x0073:
            boolean r15 = android.text.TextUtils.isEmpty(r6)
            if (r15 == 0) goto L_0x007e
            r14.a(r5, r2)
            goto L_0x0815
        L_0x007e:
            r7 = 2
            r8 = 0
            r9 = 0
            r4 = r14
            r4.a(r5, r6, r7, r8, r9)
            goto L_0x0815
        L_0x0087:
            java.lang.String r1 = com.xiaomi.push.service.bd.f4902e
            java.lang.String r2 = r15.getAction()
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x0098
            r14.b(r15)
            goto L_0x0815
        L_0x0098:
            java.lang.String r1 = com.xiaomi.push.service.bd.g
            java.lang.String r2 = r15.getAction()
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x00a9
            r14.c(r15)
            goto L_0x0815
        L_0x00a9:
            java.lang.String r1 = com.xiaomi.push.service.bd.f4903f
            java.lang.String r2 = r15.getAction()
            boolean r1 = r1.equalsIgnoreCase(r2)
            java.lang.String r2 = "ext_packet"
            if (r1 == 0) goto L_0x00ea
            java.lang.String r1 = com.xiaomi.push.service.bd.C
            java.lang.String r1 = r15.getStringExtra(r1)
            java.lang.String r3 = com.xiaomi.push.service.bd.G
            java.lang.String r3 = r15.getStringExtra(r3)
            android.os.Bundle r15 = r15.getBundleExtra(r2)
            com.xiaomi.push.ch r2 = new com.xiaomi.push.ch
            r2.<init>(r15)
            com.xiaomi.push.cj r15 = r14.a(r2, r1, r3)
            if (r15 == 0) goto L_0x0815
            java.lang.String r1 = r15.k()
            java.lang.String r2 = r15.m()
            com.xiaomi.push.service.az$b r0 = r0.a(r1, r2)
            java.lang.String r0 = r0.h
            com.xiaomi.push.bi r15 = com.xiaomi.push.bi.a(r15, r0)
            com.xiaomi.push.service.bl r0 = new com.xiaomi.push.service.bl
            r0.<init>(r14, r15)
            goto L_0x0128
        L_0x00ea:
            java.lang.String r1 = com.xiaomi.push.service.bd.h
            java.lang.String r5 = r15.getAction()
            boolean r1 = r1.equalsIgnoreCase(r5)
            if (r1 == 0) goto L_0x012d
            java.lang.String r1 = com.xiaomi.push.service.bd.C
            java.lang.String r1 = r15.getStringExtra(r1)
            java.lang.String r3 = com.xiaomi.push.service.bd.G
            java.lang.String r3 = r15.getStringExtra(r3)
            android.os.Bundle r15 = r15.getBundleExtra(r2)
            com.xiaomi.push.cl r2 = new com.xiaomi.push.cl
            r2.<init>(r15)
            com.xiaomi.push.cj r15 = r14.a(r2, r1, r3)
            if (r15 == 0) goto L_0x0815
            java.lang.String r1 = r15.k()
            java.lang.String r2 = r15.m()
            com.xiaomi.push.service.az$b r0 = r0.a(r1, r2)
            java.lang.String r0 = r0.h
            com.xiaomi.push.bi r15 = com.xiaomi.push.bi.a(r15, r0)
            com.xiaomi.push.service.bl r0 = new com.xiaomi.push.service.bl
            r0.<init>(r14, r15)
        L_0x0128:
            r14.c(r0)
            goto L_0x0815
        L_0x012d:
            java.lang.String r1 = com.xiaomi.push.service.bd.k
            java.lang.String r2 = r15.getAction()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0193
            java.lang.String r0 = com.xiaomi.push.service.bd.u
            java.lang.String r0 = r15.getStringExtra(r0)
            java.lang.String r1 = com.xiaomi.push.service.bd.r
            java.lang.String r1 = r15.getStringExtra(r1)
            if (r0 == 0) goto L_0x0815
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "request reset connection from chid = "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.xiaomi.channel.commonutils.logger.b.a(r2)
            com.xiaomi.push.service.az r2 = com.xiaomi.push.service.az.a()
            com.xiaomi.push.service.az$b r0 = r2.a(r0, r1)
            if (r0 == 0) goto L_0x0815
            java.lang.String r1 = r0.h
            java.lang.String r2 = com.xiaomi.push.service.bd.y
            java.lang.String r15 = r15.getStringExtra(r2)
            boolean r15 = r1.equals(r15)
            if (r15 == 0) goto L_0x0815
            com.xiaomi.push.service.az$c r15 = r0.f867a
            com.xiaomi.push.service.az$c r0 = com.xiaomi.push.service.az.c.binded
            if (r15 != r0) goto L_0x0815
            com.xiaomi.push.bt r15 = r14.a()
            if (r15 == 0) goto L_0x018c
            long r0 = android.os.SystemClock.elapsedRealtime()
            r2 = 15000(0x3a98, double:7.411E-320)
            long r0 = r0 - r2
            boolean r15 = r15.a(r0)
            if (r15 != 0) goto L_0x0815
        L_0x018c:
            com.xiaomi.push.service.XMPushService$q r15 = new com.xiaomi.push.service.XMPushService$q
            r15.<init>()
            goto L_0x07da
        L_0x0193:
            java.lang.String r1 = com.xiaomi.push.service.bd.l
            java.lang.String r2 = r15.getAction()
            boolean r1 = r1.equals(r2)
            r2 = 0
            if (r1 == 0) goto L_0x0216
            java.lang.String r1 = com.xiaomi.push.service.bd.C
            java.lang.String r1 = r15.getStringExtra(r1)
            java.util.List r3 = r0.a(r1)
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L_0x01b8
            java.lang.String r15 = "open channel should be called first before update info, pkg="
            java.lang.String r15 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r15, r1)
            goto L_0x0340
        L_0x01b8:
            java.lang.String r1 = com.xiaomi.push.service.bd.u
            java.lang.String r1 = r15.getStringExtra(r1)
            java.lang.String r5 = com.xiaomi.push.service.bd.r
            java.lang.String r5 = r15.getStringExtra(r5)
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 == 0) goto L_0x01d0
            java.lang.Object r1 = r3.get(r4)
            java.lang.String r1 = (java.lang.String) r1
        L_0x01d0:
            boolean r3 = android.text.TextUtils.isEmpty(r5)
            if (r3 == 0) goto L_0x01ee
            java.util.Collection r0 = r0.a(r1)
            if (r0 == 0) goto L_0x01f2
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x01f2
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r0 = r0.next()
            r2 = r0
            com.xiaomi.push.service.az$b r2 = (com.xiaomi.push.service.az.b) r2
            goto L_0x01f2
        L_0x01ee:
            com.xiaomi.push.service.az$b r2 = r0.a(r1, r5)
        L_0x01f2:
            if (r2 == 0) goto L_0x0815
            java.lang.String r0 = com.xiaomi.push.service.bd.A
            boolean r0 = r15.hasExtra(r0)
            if (r0 == 0) goto L_0x0204
            java.lang.String r0 = com.xiaomi.push.service.bd.A
            java.lang.String r0 = r15.getStringExtra(r0)
            r2.f4884e = r0
        L_0x0204:
            java.lang.String r0 = com.xiaomi.push.service.bd.B
            boolean r0 = r15.hasExtra(r0)
            if (r0 == 0) goto L_0x0815
            java.lang.String r0 = com.xiaomi.push.service.bd.B
            java.lang.String r15 = r15.getStringExtra(r0)
            r2.f4885f = r15
            goto L_0x0815
        L_0x0216:
            java.lang.String r0 = r15.getAction()
            java.lang.String r1 = "android.intent.action.SCREEN_ON"
            boolean r0 = r1.equals(r0)
            java.lang.String r5 = "android.intent.action.SCREEN_OFF"
            if (r0 != 0) goto L_0x074a
            java.lang.String r0 = r15.getAction()
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0230
            goto L_0x074a
        L_0x0230:
            java.lang.String r0 = r15.getAction()
            java.lang.String r1 = "com.xiaomi.mipush.REGISTER_APP"
            boolean r0 = r1.equals(r0)
            java.lang.String r1 = "com.xiaomi.xmsf"
            java.lang.String r5 = "mipush_payload"
            java.lang.String r6 = "mipush_app_package"
            if (r0 == 0) goto L_0x02b2
            android.content.Context r0 = r14.getApplicationContext()
            com.xiaomi.push.service.bf r0 = com.xiaomi.push.service.bf.a(r0)
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0271
            android.content.Context r0 = r14.getApplicationContext()
            com.xiaomi.push.service.bf r0 = com.xiaomi.push.service.bf.a(r0)
            int r0 = r0.a()
            if (r0 != 0) goto L_0x0271
            java.lang.String r0 = "register without being provisioned. "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r15 = r15.getStringExtra(r6)
            r0.append(r15)
            java.lang.String r15 = r0.toString()
            goto L_0x0340
        L_0x0271:
            byte[] r7 = r15.getByteArrayExtra(r5)
            java.lang.String r5 = r15.getStringExtra(r6)
            java.lang.String r0 = "mipush_region_change"
            boolean r6 = r15.getBooleanExtra(r0, r4)
            java.lang.String r0 = "mipush_env_chanage"
            boolean r0 = r15.getBooleanExtra(r0, r4)
            java.lang.String r2 = "mipush_env_type"
            int r3 = r15.getIntExtra(r2, r3)
            com.xiaomi.push.service.s r15 = com.xiaomi.push.service.s.a(r14)
            r15.d(r5)
            if (r6 != 0) goto L_0x0296
            if (r0 == 0) goto L_0x02ad
        L_0x0296:
            java.lang.String r15 = r14.getPackageName()
            boolean r15 = r1.equals(r15)
            if (r15 != 0) goto L_0x02ad
            com.xiaomi.push.service.cj r15 = new com.xiaomi.push.service.cj
            r2 = 14
            r0 = r15
            r1 = r14
            r4 = r6
            r6 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            goto L_0x07da
        L_0x02ad:
            r14.a(r7, r5)
            goto L_0x0815
        L_0x02b2:
            java.lang.String r0 = r15.getAction()
            java.lang.String r7 = "com.xiaomi.mipush.SEND_MESSAGE"
            boolean r0 = r7.equals(r0)
            java.lang.String r7 = "com.xiaomi.mipush.UNREGISTER_APP"
            if (r0 != 0) goto L_0x0719
            java.lang.String r0 = r15.getAction()
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x02cc
            goto L_0x0719
        L_0x02cc:
            java.lang.String r0 = com.xiaomi.push.service.bg.f4906a
            java.lang.String r7 = r15.getAction()
            boolean r0 = r0.equals(r7)
            r7 = 10
            java.lang.String r8 = "Fail to send Message: "
            java.lang.String r9 = "pref_registered_pkg_names"
            if (r0 == 0) goto L_0x03b5
            java.lang.String r0 = "uninstall_pkg_name"
            java.lang.String r15 = r15.getStringExtra(r0)
            if (r15 == 0) goto L_0x03b4
            java.lang.String r0 = r15.trim()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x02f3
            goto L_0x03b4
        L_0x02f3:
            android.content.pm.PackageManager r0 = r14.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0320 }
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r15, r4)     // Catch:{ NameNotFoundException -> 0x0320 }
            if (r0 == 0) goto L_0x031e
            android.content.pm.ApplicationInfo r1 = r0.applicationInfo     // Catch:{ NameNotFoundException -> 0x0320 }
            if (r1 == 0) goto L_0x031e
            java.lang.String r0 = r0.packageName     // Catch:{ NameNotFoundException -> 0x0320 }
            boolean r0 = com.xiaomi.channel.commonutils.android.c.a(r14, r0)     // Catch:{ NameNotFoundException -> 0x0320 }
            if (r0 == 0) goto L_0x031e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x0320 }
            r0.<init>()     // Catch:{ NameNotFoundException -> 0x0320 }
            java.lang.String r1 = "dual space's app uninstalled "
            r0.append(r1)     // Catch:{ NameNotFoundException -> 0x0320 }
            r0.append(r15)     // Catch:{ NameNotFoundException -> 0x0320 }
            java.lang.String r0 = r0.toString()     // Catch:{ NameNotFoundException -> 0x0320 }
            com.xiaomi.channel.commonutils.logger.b.a(r0)     // Catch:{ NameNotFoundException -> 0x0320 }
            goto L_0x0321
        L_0x031e:
            r3 = 0
            goto L_0x0321
        L_0x0320:
        L_0x0321:
            java.lang.String r0 = "com.xiaomi.channel"
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x0344
            com.xiaomi.push.service.az r0 = com.xiaomi.push.service.az.a()
            java.lang.String r1 = "1"
            java.util.Collection r0 = r0.a(r1)
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0344
            if (r3 == 0) goto L_0x0344
            r14.a(r1, r4)
            java.lang.String r15 = "close the miliao channel as the app is uninstalled."
        L_0x0340:
            com.xiaomi.channel.commonutils.logger.b.a(r15)
            return
        L_0x0344:
            android.content.SharedPreferences r0 = r14.getSharedPreferences(r9, r4)
            java.lang.String r1 = r0.getString(r15, r2)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0815
            if (r3 == 0) goto L_0x0815
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.remove(r15)
            r0.commit()
            boolean r0 = com.xiaomi.push.service.ag.b(r14, r15)
            if (r0 == 0) goto L_0x0367
            com.xiaomi.push.service.ag.b(r14, r15)
        L_0x0367:
            com.xiaomi.push.service.ag.a(r14, r15)
            android.content.Context r0 = r14.getApplicationContext()
            com.xiaomi.push.service.am.a(r0, r15)
            boolean r0 = r14.d()
            if (r0 == 0) goto L_0x0815
            if (r1 == 0) goto L_0x0815
            com.xiaomi.push.dq r0 = com.xiaomi.push.service.ad.a(r15, r1)     // Catch:{ cd -> 0x039c }
            com.xiaomi.push.service.ad.a(r14, r0)     // Catch:{ cd -> 0x039c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ cd -> 0x039c }
            r0.<init>()     // Catch:{ cd -> 0x039c }
            java.lang.String r1 = "uninstall "
            r0.append(r1)     // Catch:{ cd -> 0x039c }
            r0.append(r15)     // Catch:{ cd -> 0x039c }
            java.lang.String r15 = " msg sent"
            r0.append(r15)     // Catch:{ cd -> 0x039c }
            java.lang.String r15 = r0.toString()     // Catch:{ cd -> 0x039c }
            com.xiaomi.channel.commonutils.logger.b.a(r15)     // Catch:{ cd -> 0x039c }
            goto L_0x0815
        L_0x039c:
            r15 = move-exception
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r8)
            java.lang.String r1 = r15.getMessage()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r0)
            r14.a(r7, r15)
            goto L_0x0815
        L_0x03b4:
            return
        L_0x03b5:
            java.lang.String r0 = com.xiaomi.push.service.bg.f4907b
            java.lang.String r10 = r15.getAction()
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0457
            java.lang.String r0 = "data_cleared_pkg_name"
            java.lang.String r15 = r15.getStringExtra(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r15)
            if (r0 == 0) goto L_0x03ce
            return
        L_0x03ce:
            android.content.SharedPreferences r0 = r14.getSharedPreferences(r9, r4)     // Catch:{ all -> 0x03db }
            if (r0 == 0) goto L_0x03f1
            java.lang.String r2 = r0.getString(r15, r2)     // Catch:{ all -> 0x03d9 }
            goto L_0x03f1
        L_0x03d9:
            r1 = move-exception
            goto L_0x03dd
        L_0x03db:
            r1 = move-exception
            r0 = r2
        L_0x03dd:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Fail to get sp or appId : "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.a(r1)
        L_0x03f1:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x0445
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.remove(r15)
            r0.commit()
            boolean r0 = com.xiaomi.push.service.ag.b(r14, r15)
            if (r0 == 0) goto L_0x040a
            com.xiaomi.push.service.ag.b(r14, r15)
        L_0x040a:
            com.xiaomi.push.service.ag.a(r14, r15)
            boolean r0 = r14.d()
            if (r0 == 0) goto L_0x0445
            com.xiaomi.push.dq r0 = com.xiaomi.push.service.ad.b(r15, r2)     // Catch:{ cd -> 0x042f }
            com.xiaomi.push.service.ad.a(r14, r0)     // Catch:{ cd -> 0x042f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ cd -> 0x042f }
            r0.<init>()     // Catch:{ cd -> 0x042f }
            java.lang.String r1 = "send app data cleared Message pkgName is : "
            r0.append(r1)     // Catch:{ cd -> 0x042f }
            r0.append(r15)     // Catch:{ cd -> 0x042f }
            java.lang.String r0 = r0.toString()     // Catch:{ cd -> 0x042f }
            com.xiaomi.channel.commonutils.logger.b.a(r0)     // Catch:{ cd -> 0x042f }
            goto L_0x0445
        L_0x042f:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r8)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r1)
            r14.a(r7, r0)
        L_0x0445:
            com.xiaomi.push.service.am.a(r14, r15)
            android.content.Context r0 = r14.getApplicationContext()
            boolean r0 = com.xiaomi.channel.commonutils.android.f.a(r0)
            if (r0 == 0) goto L_0x0815
            com.xiaomi.push.service.ac.a(r15)
            goto L_0x0815
        L_0x0457:
            java.lang.String r0 = r15.getAction()
            java.lang.String r7 = "com.xiaomi.mipush.CLEAR_NOTIFICATION"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0495
            java.lang.String r0 = com.xiaomi.push.service.bd.C
            java.lang.String r0 = r15.getStringExtra(r0)
            java.lang.String r1 = com.xiaomi.push.service.bd.D
            r2 = -2
            int r1 = r15.getIntExtra(r1, r2)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0815
            r2 = -1
            if (r1 < r2) goto L_0x0484
            java.lang.String r3 = com.xiaomi.push.service.bd.E
            int r15 = r15.getIntExtra(r3, r2)
            com.xiaomi.push.service.ag.a(r14, r0, r1, r15)
            goto L_0x0815
        L_0x0484:
            java.lang.String r1 = com.xiaomi.push.service.bd.I
            java.lang.String r1 = r15.getStringExtra(r1)
            java.lang.String r2 = com.xiaomi.push.service.bd.J
            java.lang.String r15 = r15.getStringExtra(r2)
            com.xiaomi.push.service.ag.a(r14, r0, r1, r15)
            goto L_0x0815
        L_0x0495:
            java.lang.String r0 = r15.getAction()
            java.lang.String r7 = "com.xiaomi.mipush.SET_NOTIFICATION_TYPE"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x04f5
            java.lang.String r0 = com.xiaomi.push.service.bd.C
            java.lang.String r0 = r15.getStringExtra(r0)
            java.lang.String r1 = com.xiaomi.push.service.bd.H
            java.lang.String r1 = r15.getStringExtra(r1)
            java.lang.String r2 = com.xiaomi.push.service.bd.F
            boolean r2 = r15.hasExtra(r2)
            if (r2 == 0) goto L_0x04d0
            java.lang.String r2 = com.xiaomi.push.service.bd.F
            int r4 = r15.getIntExtra(r2, r4)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r0)
            r15.append(r4)
            java.lang.String r15 = r15.toString()
            java.lang.String r15 = com.xiaomi.push.ac.b(r15)
            r3 = 0
            goto L_0x04d4
        L_0x04d0:
            java.lang.String r15 = com.xiaomi.push.ac.b(r0)
        L_0x04d4:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x04ed
            boolean r15 = android.text.TextUtils.equals(r1, r15)
            if (r15 != 0) goto L_0x04e1
            goto L_0x04ed
        L_0x04e1:
            if (r3 == 0) goto L_0x04e8
            com.xiaomi.push.service.ag.b(r14, r0)
            goto L_0x0815
        L_0x04e8:
            com.xiaomi.push.service.ag.b(r14, r0, r4)
            goto L_0x0815
        L_0x04ed:
            java.lang.String r15 = "invalid notification for "
            java.lang.String r15 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r15, r0)
            goto L_0x0812
        L_0x04f5:
            java.lang.String r0 = r15.getAction()
            java.lang.String r3 = "com.xiaomi.mipush.DISABLE_PUSH"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0529
            java.lang.String r15 = r15.getStringExtra(r6)
            boolean r0 = android.text.TextUtils.isEmpty(r15)
            if (r0 != 0) goto L_0x0512
            com.xiaomi.push.service.s r0 = com.xiaomi.push.service.s.a(r14)
            r0.b(r15)
        L_0x0512:
            java.lang.String r15 = r14.getPackageName()
            boolean r15 = r1.equals(r15)
            if (r15 != 0) goto L_0x0815
            r15 = 19
            r14.a(r15, r2)
            r14.e()
            r14.stopSelf()
            goto L_0x0815
        L_0x0529:
            java.lang.String r0 = r15.getAction()
            java.lang.String r2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE"
            boolean r0 = r2.equals(r0)
            java.lang.String r3 = "android.net.conn.CONNECTIVITY_CHANGE"
            java.lang.String r7 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE"
            if (r0 != 0) goto L_0x06a2
            java.lang.String r0 = r15.getAction()
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0545
            goto L_0x06a2
        L_0x0545:
            java.lang.String r0 = r15.getAction()
            java.lang.String r2 = "com.xiaomi.mipush.SEND_TINYDATA"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0553
            goto L_0x0815
        L_0x0553:
            java.lang.String r0 = r15.getAction()
            java.lang.String r2 = "com.xiaomi.push.timer"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x058e
            java.lang.String r15 = "[Alarm] Service called on timer"
            com.xiaomi.channel.commonutils.logger.b.a(r15)
            boolean r15 = r14.j()
            if (r15 == 0) goto L_0x0579
            boolean r15 = com.xiaomi.push.bc.a()
            if (r15 == 0) goto L_0x0585
            java.lang.String r15 = "enter falldown mode, stop alarm"
            com.xiaomi.channel.commonutils.logger.b.a(r15)
            com.xiaomi.push.bc.a()
            goto L_0x0585
        L_0x0579:
            com.xiaomi.push.bc.a(r4)
            boolean r15 = r14.g()
            if (r15 == 0) goto L_0x0585
            r14.c(r4)
        L_0x0585:
            com.xiaomi.push.service.XMPushService$a r15 = r14.f796a
            if (r15 == 0) goto L_0x0815
            r15.a()
            goto L_0x0815
        L_0x058e:
            java.lang.String r0 = r15.getAction()
            java.lang.String r2 = "com.xiaomi.push.check_alive"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x05aa
            java.lang.String r15 = "Service called on check alive."
            com.xiaomi.channel.commonutils.logger.b.a(r15)
            boolean r15 = r14.g()
            if (r15 == 0) goto L_0x0815
            r14.c(r4)
            goto L_0x0815
        L_0x05aa:
            java.lang.String r0 = r15.getAction()
            java.lang.String r2 = "com.xiaomi.mipush.thirdparty"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x05d7
            java.lang.String r0 = "on thirdpart push :"
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r1 = "com.xiaomi.mipush.thirdparty_DESC"
            java.lang.String r1 = r15.getStringExtra(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.a(r0)
            java.lang.String r0 = "com.xiaomi.mipush.thirdparty_LEVEL"
            int r15 = r15.getIntExtra(r0, r4)
            com.xiaomi.push.bc.a(r14, r15)
            goto L_0x0815
        L_0x05d7:
            java.lang.String r0 = r15.getAction()
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x05e6
            r14.d()
            goto L_0x0815
        L_0x05e6:
            java.lang.String r0 = r15.getAction()
            java.lang.String r2 = "miui.net.wifi.DIGEST_INFORMATION_CHANGED"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x05f7
            r14.a(r15)
            goto L_0x0815
        L_0x05f7:
            java.lang.String r0 = r15.getAction()
            java.lang.String r2 = "com.xiaomi.xmsf.USE_INTELLIGENT_HB"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0627
            android.os.Bundle r0 = r15.getExtras()
            if (r0 == 0) goto L_0x0815
            android.os.Bundle r15 = r15.getExtras()
            java.lang.String r0 = "effectivePeriod"
            int r15 = r15.getInt(r0, r4)
            if (r15 <= 0) goto L_0x0815
            r0 = 604800(0x93a80, float:8.47505E-40)
            if (r15 > r0) goto L_0x0815
            android.content.Context r0 = r14.getApplicationContext()
            com.xiaomi.push.service.n r0 = com.xiaomi.push.service.n.a(r0)
            r0.a(r15)
            goto L_0x0815
        L_0x0627:
            java.lang.String r0 = r15.getAction()
            java.lang.String r2 = "action_cr_config"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0635
            goto L_0x0815
        L_0x0635:
            java.lang.String r0 = r15.getAction()
            java.lang.String r2 = "action_help_ping"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x068d
            java.lang.String r0 = "extra_help_ping_switch"
            boolean r0 = r15.getBooleanExtra(r0, r4)
            java.lang.String r2 = "extra_help_ping_frequency"
            int r2 = r15.getIntExtra(r2, r4)
            r3 = 30
            if (r2 < 0) goto L_0x065a
            if (r2 >= r3) goto L_0x065a
            java.lang.String r2 = "aw_ping: frquency need > 30s."
            com.xiaomi.channel.commonutils.logger.b.c(r2)
            r2 = 30
        L_0x065a:
            if (r2 >= 0) goto L_0x065d
            goto L_0x065e
        L_0x065d:
            r4 = r0
        L_0x065e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "aw_ping: receive a aw_ping message. switch: "
            r0.append(r3)
            r0.append(r4)
            java.lang.String r3 = " frequency: "
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.a(r0)
            if (r4 == 0) goto L_0x0815
            if (r2 <= 0) goto L_0x0815
            java.lang.String r0 = r14.getPackageName()
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0815
            r14.a(r15, r2)
            goto L_0x0815
        L_0x068d:
            java.lang.String r0 = com.xiaomi.push.service.bd.n
            java.lang.String r1 = r15.getAction()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0815
            android.content.Context r0 = r14.getApplicationContext()
            com.xiaomi.push.service.m.a(r0, r15)
            goto L_0x0815
        L_0x06a2:
            java.lang.String r10 = r15.getStringExtra(r6)
            byte[] r13 = r15.getByteArrayExtra(r5)
            java.lang.String r0 = "mipush_app_id"
            java.lang.String r11 = r15.getStringExtra(r0)
            java.lang.String r0 = "mipush_app_token"
            java.lang.String r12 = r15.getStringExtra(r0)
            java.lang.String r0 = r15.getAction()
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x06c7
            com.xiaomi.push.service.s r0 = com.xiaomi.push.service.s.a(r14)
            r0.c(r10)
        L_0x06c7:
            java.lang.String r0 = r15.getAction()
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x06df
            com.xiaomi.push.service.s r0 = com.xiaomi.push.service.s.a(r14)
            r0.e(r10)
            com.xiaomi.push.service.s r0 = com.xiaomi.push.service.s.a(r14)
            r0.f(r10)
        L_0x06df:
            if (r13 != 0) goto L_0x06eb
            r15 = 70000003(0x42c1d83, float:2.0232054E-36)
            java.lang.String r0 = "null payload"
            com.xiaomi.push.service.u.a(r14, r10, r13, r15, r0)
            goto L_0x0815
        L_0x06eb:
            com.xiaomi.push.service.u.b(r10, r13)
            com.xiaomi.push.service.t r0 = new com.xiaomi.push.service.t
            r8 = r0
            r9 = r14
            r8.<init>(r9, r10, r11, r12, r13)
            r14.a(r0)
            java.lang.String r15 = r15.getAction()
            boolean r15 = r7.equals(r15)
            if (r15 == 0) goto L_0x0815
            com.xiaomi.push.service.XMPushService$f r15 = r14.f797a
            if (r15 != 0) goto L_0x0815
            com.xiaomi.push.service.XMPushService$f r15 = new com.xiaomi.push.service.XMPushService$f
            r15.<init>()
            r14.f797a = r15
            android.content.IntentFilter r15 = new android.content.IntentFilter
            r15.<init>(r3)
            com.xiaomi.push.service.XMPushService$f r0 = r14.f797a
            r14.registerReceiver(r0, r15)
            goto L_0x0815
        L_0x0719:
            java.lang.String r0 = r15.getStringExtra(r6)
            byte[] r1 = r15.getByteArrayExtra(r5)
            java.lang.String r2 = "com.xiaomi.mipush.MESSAGE_CACHE"
            boolean r2 = r15.getBooleanExtra(r2, r3)
            java.lang.String r15 = r15.getAction()
            boolean r15 = r7.equals(r15)
            if (r15 == 0) goto L_0x0745
            com.xiaomi.push.service.s r15 = com.xiaomi.push.service.s.a(r14)
            r15.a(r0)
            android.content.Context r15 = r14.getApplicationContext()
            boolean r15 = com.xiaomi.channel.commonutils.android.f.a(r15)
            if (r15 == 0) goto L_0x0745
            com.xiaomi.push.service.ac.a(r0)
        L_0x0745:
            r14.a(r0, r1, r2)
            goto L_0x0815
        L_0x074a:
            java.lang.String r0 = r15.getAction()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0770
            boolean r15 = r14.j()
            if (r15 != 0) goto L_0x0815
            java.lang.String r15 = "exit falldown mode, activate alarm."
            com.xiaomi.channel.commonutils.logger.b.a(r15)
            r14.e()
            boolean r15 = r14.d()
            if (r15 != 0) goto L_0x0815
            boolean r15 = r14.e()
            if (r15 != 0) goto L_0x0815
            goto L_0x080c
        L_0x0770:
            java.lang.String r15 = r15.getAction()
            boolean r15 = r5.equals(r15)
            if (r15 == 0) goto L_0x0815
            boolean r15 = r14.j()
            if (r15 == 0) goto L_0x0815
            boolean r15 = com.xiaomi.push.bc.a()
            if (r15 == 0) goto L_0x0815
            java.lang.String r15 = "enter falldown mode, stop alarm."
            com.xiaomi.channel.commonutils.logger.b.a(r15)
            com.xiaomi.push.bc.a()
            goto L_0x0815
        L_0x0790:
            java.lang.String r0 = com.xiaomi.push.service.bd.u
            java.lang.String r0 = r15.getStringExtra(r0)
            java.lang.String r1 = com.xiaomi.push.service.bd.y
            java.lang.String r1 = r15.getStringExtra(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x07a5
            java.lang.String r15 = "security is empty. ignore."
            goto L_0x07f7
        L_0x07a5:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0810
            boolean r1 = r14.a(r0, r15)
            com.xiaomi.push.service.az$b r7 = r14.a(r0, r15)
            boolean r15 = com.xiaomi.push.y.b(r14)
            if (r15 != 0) goto L_0x07c1
            com.xiaomi.push.service.j r15 = r14.f803a
            r0 = 0
            r1 = 2
            r5 = r15
            r8 = 0
            r9 = 2
            goto L_0x0806
        L_0x07c1:
            boolean r15 = r14.d()
            if (r15 == 0) goto L_0x080c
            com.xiaomi.push.service.az$c r15 = r7.f867a
            com.xiaomi.push.service.az$c r0 = com.xiaomi.push.service.az.c.unbind
            if (r15 != r0) goto L_0x07d3
            com.xiaomi.push.service.XMPushService$b r15 = new com.xiaomi.push.service.XMPushService$b
            r15.<init>(r7)
            goto L_0x07da
        L_0x07d3:
            if (r1 == 0) goto L_0x07de
            com.xiaomi.push.service.XMPushService$p r15 = new com.xiaomi.push.service.XMPushService$p
            r15.<init>(r7)
        L_0x07da:
            r14.c(r15)
            goto L_0x0815
        L_0x07de:
            com.xiaomi.push.service.az$c r0 = com.xiaomi.push.service.az.c.binding
            if (r15 != r0) goto L_0x07fb
            java.lang.Object[] r15 = new java.lang.Object[r2]
            java.lang.String r0 = r7.g
            r15[r4] = r0
            java.lang.String r0 = r7.f872b
            java.lang.String r0 = com.xiaomi.push.service.az.b.a(r0)
            r15[r3] = r0
            java.lang.String r0 = "the client is binding. %1$s %2$s."
            java.lang.String r15 = java.lang.String.format(r0, r15)
        L_0x07f7:
            com.xiaomi.channel.commonutils.logger.b.a(r15)
            goto L_0x0815
        L_0x07fb:
            com.xiaomi.push.service.az$c r0 = com.xiaomi.push.service.az.c.binded
            if (r15 != r0) goto L_0x0815
            com.xiaomi.push.service.j r15 = r14.f803a
            r0 = 1
            r1 = 0
            r5 = r15
            r8 = 1
            r9 = 0
        L_0x0806:
            r10 = 0
            r6 = r14
            r5.a(r6, r7, r8, r9, r10)
            goto L_0x0815
        L_0x080c:
            r14.a(r3)
            goto L_0x0815
        L_0x0810:
            java.lang.String r15 = "channel id is empty, do nothing!"
        L_0x0812:
            com.xiaomi.channel.commonutils.logger.b.d(r15)
        L_0x0815:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.d(android.content.Intent):void");
    }

    private void d(boolean z) {
        try {
            if (!com.xiaomi.channel.commonutils.android.j.a()) {
                return;
            }
            if (z) {
                sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (ak a2 : (ak[]) this.f807a.toArray(new ak[0])) {
                    a2.a();
                }
                return;
            }
            sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
        }
    }

    private void e() {
        if (!b()) {
            bc.a();
        } else if (!bc.a()) {
            bc.a(true);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        String str;
        bt btVar = this.f793a;
        if (btVar == null || !btVar.b()) {
            bt btVar2 = this.f793a;
            if (btVar2 == null || !btVar2.c()) {
                this.f794a.b(y.a((Context) this));
                g();
                if (this.f793a == null) {
                    az.a().a((Context) this);
                    d(false);
                }
                return;
            }
            str = "try to connect while is connected.";
        } else {
            str = "try to connect while connecting.";
        }
        com.xiaomi.channel.commonutils.logger.b.d(str);
    }

    /* renamed from: f  reason: collision with other method in class */
    public static boolean m757f() {
        return f4812b;
    }

    private void g() {
        try {
            this.f792a.a(this.f795a, (cf) new ca(this));
            this.f792a.e();
            this.f793a = this.f792a;
        } catch (cd e2) {
            com.xiaomi.channel.commonutils.logger.b.a((String) "fail to create Slim connection", (Throwable) e2);
            this.f792a.b(3, e2);
        }
    }

    /* renamed from: g  reason: collision with other method in class */
    private boolean m758g() {
        if (SystemClock.elapsedRealtime() - this.f789a < 30000) {
            return false;
        }
        return y.c(this);
    }

    private void h() {
    }

    /* renamed from: h  reason: collision with other method in class */
    private boolean m759h() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private void i() {
        synchronized (this.f806a) {
            this.f806a.clear();
        }
    }

    /* renamed from: i  reason: collision with other method in class */
    private boolean m760i() {
        if (!com.xiaomi.channel.commonutils.android.f.a() || !"com.xiaomi.xmsf".equals(getPackageName())) {
            return !s.a((Context) this).b(getPackageName());
        }
        com.xiaomi.channel.commonutils.logger.b.a((String) "current sdk expect region is global");
        return !"China".equals(a.a(getApplicationContext()).a());
    }

    private boolean j() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && k() && !com.xiaomi.channel.commonutils.android.c.c((Context) this) && !com.xiaomi.channel.commonutils.android.c.b(getApplicationContext());
    }

    private boolean k() {
        int intValue = Integer.valueOf(String.format("%tH", new Object[]{new Date()})).intValue();
        int i2 = this.f4813a;
        int i3 = this.f809b;
        if (i2 > i3) {
            if (intValue >= i2 || intValue < i3) {
                return true;
            }
        } else if (i2 < i3 && intValue >= i2 && intValue < i3) {
            return true;
        }
        return false;
    }

    private boolean l() {
        boolean equals = TextUtils.equals(getPackageName(), "com.xiaomi.xmsf");
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public bt m761a() {
        return this.f793a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public j m762a() {
        return new j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m763a() {
        if (SystemClock.elapsedRealtime() - this.f789a >= ((long) by.a()) && y.c(this)) {
            c(true);
        }
    }

    public void a(int i2) {
        this.f804a.a(i2);
    }

    public void a(int i2, Exception exc) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("disconnect ");
        outline73.append(hashCode());
        outline73.append(", ");
        bt btVar = this.f793a;
        outline73.append(btVar == null ? null : Integer.valueOf(btVar.hashCode()));
        com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
        bt btVar2 = this.f793a;
        if (btVar2 != null) {
            btVar2.b(i2, exc);
            this.f793a = null;
        }
        a(7);
        a(4);
        az.a().a((Context) this, i2);
    }

    public void a(bi biVar) {
        bt btVar = this.f793a;
        if (btVar != null) {
            btVar.b(biVar);
            return;
        }
        throw new cd((String) "try send msg while connection is null.");
    }

    public void a(bt btVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
    }

    public void a(bt btVar, int i2, Exception exc) {
        if (!j()) {
            a(false);
        }
    }

    public void a(bt btVar, Exception exc) {
        d(false);
        if (!j()) {
            a(false);
        }
    }

    public void a(j jVar) {
        a(jVar, 0);
    }

    public void a(j jVar, long j2) {
        try {
            this.f804a.a((com.xiaomi.push.service.o.b) jVar, j2);
        } catch (IllegalStateException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("can't execute job err = ");
            outline73.append(e2.getMessage());
            com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
        }
    }

    public void a(n nVar) {
        synchronized (this.f806a) {
            this.f806a.add(nVar);
        }
    }

    public void a(com.xiaomi.push.service.az.b bVar) {
        if (bVar != null) {
            long a2 = bVar.a();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("schedule rebind job in ");
            outline73.append(a2 / 1000);
            com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
            a((j) new b(bVar), a2);
        }
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        com.xiaomi.push.service.az.b a2 = az.a().a(str, str2);
        if (a2 != null) {
            s sVar = new s(a2, i2, str4, str3);
            a((j) sVar);
        }
        az.a().a(str, str2);
    }

    public void a(String str, byte[] bArr, boolean z) {
        Collection a2 = az.a().a((String) "5");
        if (a2.isEmpty()) {
            if (!z) {
                return;
            }
        } else if (((com.xiaomi.push.service.az.b) a2.iterator().next()).f867a == com.xiaomi.push.service.az.c.binded) {
            a((j) new by(this, 4, str, bArr));
            return;
        } else if (!z) {
            return;
        }
        u.b(str, bArr);
    }

    public void a(boolean z) {
        this.f802a.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            u.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.a((String) "register request without payload");
            return;
        }
        dq dqVar = new dq();
        try {
            ee.a(dqVar, bArr);
            if (dqVar.f576a == cz.Registration) {
                du duVar = new du();
                try {
                    ee.a(duVar, dqVar.a());
                    t tVar = new t(this, dqVar.b(), duVar.b(), duVar.c(), bArr);
                    a((j) tVar);
                } catch (ej e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("app register error. " + e2);
                    u.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                u.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.a((String) "register request with invalid payload");
            }
        } catch (ej e3) {
            com.xiaomi.channel.commonutils.logger.b.d("app register fail. " + e3);
            u.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    public void a(bi[] biVarArr) {
        bt btVar = this.f793a;
        if (btVar != null) {
            btVar.a(biVarArr);
            return;
        }
        throw new cd((String) "try send msg while connection is null.");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m764a() {
        String str;
        a a2 = a.a(getApplicationContext());
        String str2 = "";
        boolean a3 = com.xiaomi.channel.commonutils.android.f.a();
        boolean z = false;
        if (!com.xiaomi.channel.commonutils.android.f.a()) {
            try {
                Bundle call = getContentResolver().call(MIPushProvider.a((Context) this), "getUserRegion", null, null);
                if (call != null) {
                    str2 = call.getString("user_region");
                    if (!TextUtils.isEmpty(str2)) {
                        a3 = true;
                        z = call.getBoolean("req_hosts");
                        String c2 = com.xiaomi.channel.commonutils.android.f.c(str2);
                        a2.a(str2);
                        a2.b(c2);
                        if (z) {
                            getContentResolver().call(MIPushProvider.a((Context) this), "reset_req_hosts", null, null);
                        }
                    }
                    com.xiaomi.channel.commonutils.logger.b.a("current region is: " + str2);
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a("set region error: " + e2);
            }
        } else {
            str2 = a2.a();
            com.xiaomi.channel.commonutils.logger.b.a("region of cache is " + str2);
            if (TextUtils.isEmpty(str2)) {
                String b2 = b();
                String b3 = com.xiaomi.channel.commonutils.android.f.b(b2);
                a2.a(b3);
                a2.b(b2);
                str2 = b3;
            } else {
                a(a2);
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            if (Region.Global.name().equals(str2)) {
                bu.a((String) "app.chat.global.xiaomi.net");
            } else {
                if (Region.Europe.name().equals(str2)) {
                    str = "fr.app.chat.global.xiaomi.net";
                } else if (Region.Russia.name().equals(str2)) {
                    str = "ru.app.chat.global.xiaomi.net";
                } else if (Region.India.name().equals(str2)) {
                    str = "idmb.app.chat.global.xiaomi.net";
                }
                bu.a(str);
            }
        } else if ("com.xiaomi.xmsf".equals(getPackageName())) {
            str2 = Region.Global.name();
        }
        if (Region.Global.name().equals(str2)) {
            bu.a((String) "app.chat.global.xiaomi.net");
        }
        b(z);
        a(str2);
        return a3;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m765a(int i2) {
        return this.f804a.a(i2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public j m766b() {
        return this.f803a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m767b() {
        n.a(getApplicationContext()).d();
        Iterator it = new ArrayList(this.f806a).iterator();
        while (it.hasNext()) {
            ((n) it.next()).a();
        }
    }

    public void b(bt btVar) {
        d(true);
        this.f802a.a();
        if (!bc.a() && !j()) {
            com.xiaomi.channel.commonutils.logger.b.a((String) "reconnection successful, reactivate alarm.");
            bc.a(true);
        }
        Iterator it = az.a().a().iterator();
        while (it.hasNext()) {
            a((j) new b((com.xiaomi.push.service.az.b) it.next()));
        }
        if (!this.f808a && com.xiaomi.channel.commonutils.android.f.a(getApplicationContext())) {
            com.xiaomi.push.o.a(getApplicationContext()).a((Runnable) new cb(this));
        }
    }

    public void b(j jVar) {
        this.f804a.a(jVar.f4958a, (com.xiaomi.push.service.o.b) jVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m768b() {
        boolean a2 = y.a((Context) this);
        boolean z = az.a().a() > 0;
        boolean z2 = !c();
        boolean i2 = i();
        boolean z3 = !h();
        boolean z4 = a2 && z && z2 && i2 && z3;
        if (!z4) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", new Object[]{Boolean.valueOf(a2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(i2), Boolean.valueOf(z3)}));
        }
        return z4;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m769c() {
        try {
            Class<?> a2 = com.xiaomi.channel.commonutils.android.j.a(this, "miui.os.Build");
            return a2.getField("IS_CM_CUSTOMIZATION_TEST").getBoolean(null) || a2.getField("IS_CU_CUSTOMIZATION_TEST").getBoolean(null) || a2.getField("IS_CT_CUSTOMIZATION_TEST").getBoolean(null);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m770d() {
        bt btVar = this.f793a;
        return btVar != null && btVar.c();
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m771e() {
        bt btVar = this.f793a;
        return btVar != null && btVar.b();
    }

    public IBinder onBind(Intent intent) {
        return this.f791a.getBinder();
    }

    public void onCreate() {
        super.onCreate();
        com.xiaomi.channel.commonutils.logger.b.a(getApplicationContext());
        com.xiaomi.channel.commonutils.android.j.a((Context) this);
        q a2 = r.a((Context) this);
        if (a2 != null) {
            com.xiaomi.push.j.a(a2.f4967a);
        }
        if (com.xiaomi.channel.commonutils.android.f.a(getApplicationContext())) {
            HandlerThread handlerThread = new HandlerThread("hb-alarm");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.f796a = new a(this, null);
            com.xiaomi.channel.commonutils.android.g.a(this, this.f796a, new IntentFilter(bd.q), "com.xiaomi.xmsf.permission.MIPUSH_RECEIVE", handler, 4);
            f4812b = true;
            handler.post(new cc(this));
        }
        this.f791a = new Messenger(new cd(this));
        be.a(this);
        ce ceVar = new ce(this, null, 5222, "xiaomi.com", null);
        this.f794a = ceVar;
        ceVar.a(true);
        this.f792a = new bp(this, this.f794a);
        this.f803a = a();
        bc.a((Context) this);
        this.f792a.a((bv) this);
        this.f801a = new ax(this);
        this.f802a = new bi(this);
        new k().a();
        this.f804a = new o((String) "Connection Controller Thread");
        az a3 = az.a();
        a3.b();
        a3.a((com.xiaomi.push.service.az.a) new cf(this));
        if (l()) {
            h();
        }
        a((n) new bv(this));
        if (com.xiaomi.channel.commonutils.android.f.a((Context) this)) {
            a((n) new ay());
        }
        a((j) new h());
        this.f807a.add(bp.a((Context) this));
        if (i()) {
            this.f797a = new f();
            registerReceiver(this.f797a, new IntentFilter(Constant.INTENT_NETWORK_STATUS));
        }
        if (com.xiaomi.channel.commonutils.android.f.a(getApplicationContext())) {
            this.f800a = new t();
            com.xiaomi.channel.commonutils.android.g.a(this, this.f800a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null, 2);
            k kVar = new k();
            this.f798a = kVar;
            com.xiaomi.channel.commonutils.android.g.a(this, kVar, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null, 2);
        }
        n.a(getApplicationContext()).a();
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = System.getUriFor("power_supersave_mode_open");
            if (uriFor != null) {
                this.f790a = new cg(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f790a);
                } catch (Throwable th) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("register super-power-mode observer err:");
                    outline73.append(th.getMessage());
                    com.xiaomi.channel.commonutils.logger.b.d(outline73.toString());
                }
            }
            int[] a4 = a();
            if (a4 != null) {
                this.f799a = new r();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                registerReceiver(this.f799a, intentFilter);
                this.f4813a = a4[0];
                this.f809b = a4[1];
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("falldown initialized: ");
                outline732.append(this.f4813a);
                outline732.append(",");
                outline732.append(this.f809b);
                com.xiaomi.channel.commonutils.logger.b.a(outline732.toString());
            }
        }
        String str = "";
        if (a2 != null) {
            try {
                if (!TextUtils.isEmpty(a2.f936a)) {
                    String[] split = a2.f936a.split(ColorPropConverter.PREFIX_RESOURCE);
                    if (split != null && split.length > 0) {
                        str = split[0];
                    }
                }
            } catch (Exception unused) {
            }
        }
        StringBuilder outline733 = GeneratedOutlineSupport.outline73("XMPushService created. pid=");
        outline733.append(Process.myPid());
        outline733.append(", uid=");
        outline733.append(Process.myUid());
        outline733.append(", vc=");
        outline733.append(com.xiaomi.channel.commonutils.android.a.a(getApplicationContext(), getPackageName()));
        outline733.append(", uuid=");
        outline733.append(str);
        com.xiaomi.channel.commonutils.logger.b.e(outline733.toString());
    }

    public void onDestroy() {
        f fVar = this.f797a;
        if (fVar != null) {
            a((BroadcastReceiver) fVar);
            this.f797a = null;
        }
        t tVar = this.f800a;
        if (tVar != null) {
            a((BroadcastReceiver) tVar);
            this.f800a = null;
        }
        k kVar = this.f798a;
        if (kVar != null) {
            a((BroadcastReceiver) kVar);
            this.f798a = null;
        }
        r rVar = this.f799a;
        if (rVar != null) {
            a((BroadcastReceiver) rVar);
            this.f799a = null;
        }
        a aVar = this.f796a;
        if (aVar != null) {
            a((BroadcastReceiver) aVar);
            this.f796a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f790a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f790a);
            } catch (Throwable th) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("unregister super-power-mode err:");
                outline73.append(th.getMessage());
                com.xiaomi.channel.commonutils.logger.b.d(outline73.toString());
            }
        }
        this.f807a.clear();
        this.f804a.b();
        a((j) new bz(this, 2));
        a((j) new l());
        az.a().b();
        az.a().a((Context) this, 15);
        az.a().a();
        this.f792a.b((bv) this);
        bn.a().a();
        bc.a();
        i();
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.a((String) "Service destroyed");
    }

    public void onStart(Intent intent, int i2) {
        i iVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            try {
                com.xiaomi.channel.commonutils.logger.b.a(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", new Object[]{intent.getAction(), intent.getStringExtra(bd.u), intent.getStringExtra(bd.C), intent.getStringExtra("mipush_app_package")}));
            } catch (Throwable th) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("onStart() cause error: ");
                outline73.append(th.getMessage());
                com.xiaomi.channel.commonutils.logger.b.d(outline73.toString());
                return;
            }
        }
        if (!(intent == null || intent.getAction() == null)) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f804a.a()) {
                    com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                    az.a().a((Context) this, 14);
                    stopSelf();
                } else {
                    iVar = new i(intent);
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                iVar = new i(intent);
            }
            a((j) iVar);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            com.xiaomi.channel.commonutils.logger.b.c("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return 1;
    }
}

package io.hansel.ujmtracker.m;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import io.hansel.core.logger.HSLLogger;
import java.util.ArrayList;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public Handler f5373a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d> f5374b = null;

    /* renamed from: c  reason: collision with root package name */
    public long f5375c;

    /* renamed from: d  reason: collision with root package name */
    public h f5376d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d> f5377e;

    /* renamed from: f  reason: collision with root package name */
    public int f5378f;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i == 2) {
                    if (f.this.f5374b != null) {
                        for (int i2 = 0; i2 < f.this.f5374b.size(); i2++) {
                            d dVar = (d) f.this.f5374b.get(i2);
                            f.this.f5377e.remove(dVar);
                            if (dVar.a() == io.hansel.ujmtracker.m.d.a.CSTATE_CACHED) {
                                a.c().b().a(dVar.d());
                            }
                        }
                        f.this.f5378f = 0;
                        f.this.f5374b.clear();
                    }
                    a.c().d().a().sendEmptyMessage(1);
                } else if (i == 3) {
                    f.this.f5378f = 0;
                    if (f.this.f5374b != null) {
                        f.this.f5374b.clear();
                    }
                    a.c().d().a().sendEmptyMessage(-1);
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }

    public class b implements k {
        public b() {
        }

        public void a(String str) {
            try {
                f.this.f5373a.sendEmptyMessage(2);
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }

    public class c implements j {
        public c() {
        }

        public void a() {
            try {
                f.this.f5373a.sendEmptyMessage(3);
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f5382a;

        public d(d dVar) {
            this.f5382a = dVar;
        }

        public void run() {
            try {
                if (this.f5382a.a() != io.hansel.ujmtracker.m.d.a.CSTATE_NOT_CACHED) {
                    f.this.d();
                    f.this.f5377e.add(this.f5382a);
                } else if (f.this.f5376d.a(this.f5382a)) {
                    d b2 = f.this.f5376d.b(this.f5382a);
                    if (b2 != null) {
                        if (f.this.a(b2)) {
                            f.this.d();
                            b2.a(io.hansel.ujmtracker.m.d.a.CSTATE_CACHED);
                            f.this.f5377e.add(b2);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
                if (f.this.f5376d.e().a(f.this)) {
                    a.c().d().a().sendEmptyMessage(0);
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public boolean f5384a;

        public e(boolean z) {
            this.f5384a = z;
        }

        public void run() {
            try {
                f.this.b(this.f5384a);
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }

    public f(h hVar) {
        this.f5376d = hVar;
        this.f5377e = new ArrayList<>();
        this.f5378f = 0;
        HandlerThread handlerThread = new HandlerThread("GroupHandler");
        handlerThread.setPriority(3);
        handlerThread.start();
        this.f5373a = new a(handlerThread.getLooper());
    }

    /* access modifiers changed from: private */
    public boolean a(d dVar) {
        try {
            a.c().b().a(dVar.d(), this.f5376d.b(), this.f5376d.a(dVar.b()), dVar.c(), dVar.e(), dVar.f());
            return true;
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z) {
        ArrayList<d> a2 = this.f5376d.a(this.f5377e, z);
        this.f5374b = a2;
        if (a2.size() == 0) {
            this.f5373a.sendEmptyMessage(3);
            return;
        }
        this.f5375c = System.currentTimeMillis();
        try {
            this.f5376d.a(this.f5374b, (k) new b(), (j) new c());
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        if (e() > this.f5376d.c()) {
            int a2 = this.f5376d.a();
            if (a2 > e()) {
                a2 = e() - this.f5376d.c();
            }
            for (int i = 0; i < a2; i++) {
                d remove = this.f5377e.remove(0);
                if (remove.a() == io.hansel.ujmtracker.m.d.a.CSTATE_CACHED) {
                    try {
                        a.c().b().a(remove.d());
                    } catch (Throwable th) {
                        HSLLogger.printStackTrace(th);
                    }
                }
            }
        }
    }

    public h a() {
        return this.f5376d;
    }

    public synchronized boolean a(boolean z) {
        if (!(z ? b() == 0 : this.f5376d.e().a(this))) {
            return false;
        }
        this.f5378f = 1;
        this.f5373a.post(new e(z));
        return true;
    }

    public int b() {
        return this.f5378f;
    }

    public void b(d dVar) {
        if (dVar != null) {
            this.f5373a.post(new d(dVar));
        }
    }

    public long c() {
        return this.f5375c;
    }

    public int e() {
        return this.f5377e.size();
    }
}

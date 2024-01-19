package io.hansel.visualizer.e.a;

import io.hansel.core.logger.HSLLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public abstract class a extends c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5847a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5848b;

    /* renamed from: c  reason: collision with root package name */
    public Timer f5849c;

    /* renamed from: d  reason: collision with root package name */
    public TimerTask f5850d;

    /* renamed from: e  reason: collision with root package name */
    public long f5851e = 60;

    /* renamed from: io.hansel.visualizer.e.a.a$a  reason: collision with other inner class name */
    public class C0090a extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<b> f5852a = new ArrayList<>();

        public C0090a() {
        }

        public void run() {
            try {
                this.f5852a.clear();
                this.f5852a.addAll(a.this.c());
                long currentTimeMillis = System.currentTimeMillis() - (a.this.f5851e * 1500);
                Iterator<b> it = this.f5852a.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next instanceof d) {
                        d dVar = (d) next;
                        if (dVar.c() < currentTimeMillis) {
                            if (d.t) {
                                HSLLogger.d("Closing connection due to no pong received: " + next.toString());
                            }
                            dVar.a(1006, false);
                        } else {
                            dVar.j();
                        }
                    }
                }
                this.f5852a.clear();
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }

    private void b() {
        Timer timer = this.f5849c;
        if (timer != null) {
            timer.cancel();
            this.f5849c = null;
        }
        TimerTask timerTask = this.f5850d;
        if (timerTask != null) {
            timerTask.cancel();
            this.f5850d = null;
        }
    }

    public void a(boolean z) {
        this.f5848b = z;
    }

    public void b(boolean z) {
        this.f5847a = z;
    }

    public abstract Collection<b> c();

    public boolean d() {
        return this.f5848b;
    }

    public boolean e() {
        return this.f5847a;
    }

    public void f() {
        int i = (this.f5851e > 0 ? 1 : (this.f5851e == 0 ? 0 : -1));
        boolean z = d.t;
        if (i <= 0) {
            if (z) {
                HSLLogger.d("Connection lost timer deactivated");
            }
            return;
        }
        if (z) {
            HSLLogger.d("Connection lost timer started");
        }
        b();
        this.f5849c = new Timer();
        C0090a aVar = new C0090a();
        this.f5850d = aVar;
        Timer timer = this.f5849c;
        long j = 1000 * this.f5851e;
        timer.scheduleAtFixedRate(aVar, j, j);
    }

    public void g() {
        if (this.f5849c != null || this.f5850d != null) {
            if (d.t) {
                HSLLogger.d("Connection lost timer stopped");
            }
            b();
        }
    }
}

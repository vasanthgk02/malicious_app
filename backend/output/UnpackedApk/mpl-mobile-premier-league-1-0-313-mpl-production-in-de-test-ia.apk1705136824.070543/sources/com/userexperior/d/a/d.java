package com.userexperior.d.a;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import com.userexperior.utilities.b;
import java.util.logging.Level;

public final class d extends Thread {

    /* renamed from: c  reason: collision with root package name */
    public static final f f3902c = new f() {
        public final void a(a aVar) {
            throw aVar;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final e f3903d = new e() {
    };

    /* renamed from: e  reason: collision with root package name */
    public static final g f3904e = new g() {
        public final void a(InterruptedException interruptedException) {
            new StringBuilder("Interrupted: ").append(interruptedException.getMessage());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public f f3905a;

    /* renamed from: b  reason: collision with root package name */
    public String f3906b;

    /* renamed from: f  reason: collision with root package name */
    public e f3907f;
    public g g;
    public final Handler h;
    public final int i;
    public boolean j;
    public boolean k;
    public volatile long l;
    public volatile boolean m;
    public final Runnable n;

    public d() {
        this(0);
    }

    public d(byte b2) {
        this.f3905a = f3902c;
        this.f3907f = f3903d;
        this.g = f3904e;
        this.h = new Handler(Looper.getMainLooper());
        this.f3906b = "";
        this.j = false;
        this.k = false;
        this.l = 0;
        this.m = false;
        this.n = new Runnable() {
            public final void run() {
                d.this.l = 0;
                d.this.m = false;
            }
        };
        this.i = 5000;
    }

    public final void run() {
        StringBuilder sb;
        Level level;
        String str;
        try {
            setName("|ANR-WatchDog|");
            long j2 = (long) this.i;
            while (!isInterrupted()) {
                boolean z = this.l == 0;
                this.l += j2;
                if (z) {
                    this.h.post(this.n);
                }
                try {
                    Thread.sleep(j2);
                    if (this.l != 0 && !this.m) {
                        if (this.k || (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger())) {
                            this.f3905a.a(this.f3906b != null ? a.a(this.l, this.f3906b, this.j) : a.a(this.l));
                            j2 = (long) this.i;
                            this.m = true;
                        } else {
                            b.a(Level.INFO, "ANRWatchdog: An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                            this.m = true;
                        }
                    }
                } catch (InterruptedException e2) {
                    this.g.a(e2);
                }
            }
        } catch (Exception e3) {
            level = Level.INFO;
            sb = new StringBuilder("issue at awd :");
            str = e3.getMessage();
            sb.append(str);
            b.a(level, sb.toString());
        } catch (OutOfMemoryError e4) {
            level = Level.INFO;
            sb = new StringBuilder("issue at awd :");
            str = e4.getMessage();
            sb.append(str);
            b.a(level, sb.toString());
        } catch (InternalError e5) {
            level = Level.INFO;
            sb = new StringBuilder("issue at awd :");
            str = e5.getMessage();
            sb.append(str);
            b.a(level, sb.toString());
        }
    }
}

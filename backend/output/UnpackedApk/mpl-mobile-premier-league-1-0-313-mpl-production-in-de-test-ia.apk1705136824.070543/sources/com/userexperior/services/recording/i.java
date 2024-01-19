package com.userexperior.services.recording;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import com.userexperior.models.recording.enums.h;
import com.userexperior.utilities.a;
import com.userexperior.utilities.b;
import com.userexperior.utilities.f;
import com.userexperior.utilities.l;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Timer;
import java.util.logging.Level;
import sfs2x.client.requests.FindRoomsRequest;

public class i implements ServiceConnection {

    /* renamed from: f  reason: collision with root package name */
    public static Activity f4242f;
    public static final String o = i.class.getSimpleName();
    public static i p;
    public static long q;

    /* renamed from: a  reason: collision with root package name */
    public final Messenger f4243a;

    /* renamed from: b  reason: collision with root package name */
    public Messenger f4244b;

    /* renamed from: c  reason: collision with root package name */
    public c f4245c;

    /* renamed from: d  reason: collision with root package name */
    public b f4246d;

    /* renamed from: e  reason: collision with root package name */
    public a f4247e;
    public Timer g;
    public int h = 0;
    public f i;
    public int j = 400;
    public boolean k;
    public final String l;
    public final Context m;
    public int n = 0;
    public final String r = FindRoomsRequest.KEY_FILTERED_ROOMS;
    public final String s = "ca";

    public i(Handler handler) {
        this.f4243a = new Messenger(handler);
        Context a2 = a.a();
        this.m = a2;
        this.l = l.y(a2);
    }

    public static Activity a() {
        return f4242f;
    }

    public static Message a(long j2) {
        Message obtain = Message.obtain();
        obtain.what = 124249;
        obtain.arg1 = (int) j2;
        return obtain;
    }

    public static i a(Handler handler) {
        if (p == null) {
            synchronized (i.class) {
                try {
                    if (p == null) {
                        p = new i(handler);
                    }
                }
            }
        }
        return p;
    }

    public static StringBuilder a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        StringBuilder sb = new StringBuilder();
        sb.append(stringWriter.toString());
        return sb;
    }

    public static void a(String str) {
        f.g().a(h.RESUMED, str, SystemClock.uptimeMillis());
        if (com.userexperior.models.recording.a.h() != null) {
            com.userexperior.models.recording.a.b(com.userexperior.models.recording.a.h());
        }
        com.userexperior.models.recording.a.a(str);
        q = System.currentTimeMillis();
    }

    public static long c() {
        return q;
    }

    public static void d() {
        q = 0;
    }

    public static /* synthetic */ void d(i iVar) {
        b.a(Level.INFO, "R -- S");
        try {
            iVar.g = new Timer();
            if (iVar.l.equalsIgnoreCase(FindRoomsRequest.KEY_FILTERED_ROOMS)) {
                b bVar = new b(f4242f, iVar.f4244b, iVar.f4243a);
                iVar.f4246d = bVar;
                if (iVar.g != null) {
                    iVar.g.schedule(bVar, 0, (long) iVar.j);
                }
            } else if (iVar.l.equalsIgnoreCase("ca")) {
                a aVar = new a(f4242f, iVar.f4244b, iVar.f4243a);
                iVar.f4247e = aVar;
                if (iVar.g != null) {
                    iVar.g.schedule(aVar, 0, (long) iVar.j);
                }
            } else {
                c cVar = new c(f4242f, iVar.f4244b, iVar.f4243a);
                iVar.f4245c = cVar;
                if (iVar.g != null) {
                    iVar.g.schedule(cVar, 0, (long) iVar.j);
                }
            }
        } catch (Exception e2) {
            Level level = Level.SEVERE;
            b.a(level, "Ex : SSC - startRecording : " + e2.getMessage());
            new StringBuilder("Exception while start recording.").append(e2.getMessage());
        }
    }

    public final void a(int i2) {
        if (i2 == 1) {
            try {
                if (this.l.equalsIgnoreCase(FindRoomsRequest.KEY_FILTERED_ROOMS)) {
                    if (this.f4246d != null) {
                        this.f4246d.f4114b = true;
                    }
                } else if (this.l.equalsIgnoreCase("ca")) {
                    if (this.f4247e != null) {
                        this.f4247e.f4108b = true;
                    }
                } else if (this.f4245c != null) {
                    this.f4245c.f4125c = true;
                }
            } catch (Exception e2) {
                Level level = Level.SEVERE;
                b.a(level, "Ex : SSC - pauseRecording : " + e2.getMessage());
                new StringBuilder("Exception while pause recording. Ex : ").append(e2.getMessage());
            }
        } else {
            if (this.g != null) {
                this.g.cancel();
                this.g = null;
            }
            f4242f = null;
            if (this.l.equalsIgnoreCase(FindRoomsRequest.KEY_FILTERED_ROOMS)) {
                if (this.f4246d != null) {
                    this.f4246d.a(f4242f);
                    this.h = this.f4246d.f4113a;
                }
            } else if (this.l.equalsIgnoreCase("ca")) {
                if (this.f4247e != null) {
                    this.f4247e.a(f4242f);
                    this.h = this.f4247e.f4107a;
                }
            } else if (this.f4245c != null) {
                this.f4245c.a(f4242f);
                this.h = this.f4245c.f4124b;
            }
        }
    }

    public final void a(Activity activity) {
        f4242f = activity;
        if (this.l.equalsIgnoreCase(FindRoomsRequest.KEY_FILTERED_ROOMS)) {
            b bVar = this.f4246d;
            if (bVar != null) {
                bVar.a(activity);
            }
        } else if (this.l.equalsIgnoreCase("ca")) {
            a aVar = this.f4247e;
            if (aVar != null) {
                aVar.a(activity);
            }
        } else {
            c cVar = this.f4245c;
            if (cVar != null) {
                cVar.a(activity);
            }
        }
    }

    public final void a(Activity activity, int i2) {
        new StringBuilder("ssc - RESUME RECORDING with activity : ").append(activity);
        try {
            if (this.g == null) {
                this.g = new Timer();
                new StringBuilder("ssc - RESUME RECORDING ").append(this.h);
                String y = l.y(a.a());
                if (y.equalsIgnoreCase(FindRoomsRequest.KEY_FILTERED_ROOMS)) {
                    b bVar = new b(activity, this.f4244b, this.f4243a);
                    this.f4246d = bVar;
                    bVar.f4113a = this.h;
                    if (this.g != null) {
                        this.g.schedule(bVar, (long) i2, (long) this.j);
                    }
                } else if (y.equalsIgnoreCase("ca")) {
                    a aVar = new a(activity, this.f4244b, this.f4243a);
                    this.f4247e = aVar;
                    aVar.f4107a = this.h;
                    if (this.g != null) {
                        this.g.schedule(aVar, (long) i2, (long) this.j);
                    }
                } else {
                    c cVar = new c(activity, this.f4244b, this.f4243a);
                    this.f4245c = cVar;
                    cVar.f4124b = this.h;
                    if (this.g != null) {
                        this.g.schedule(cVar, (long) i2, (long) this.j);
                    }
                }
            } else {
                if (this.l.equalsIgnoreCase(FindRoomsRequest.KEY_FILTERED_ROOMS)) {
                    if (this.f4246d != null) {
                        this.f4246d.f4114b = false;
                    }
                } else if (this.l.equalsIgnoreCase("ca")) {
                    if (this.f4247e != null) {
                        this.f4247e.f4108b = false;
                    }
                } else if (this.f4245c != null) {
                    this.f4245c.f4125c = false;
                }
            }
        } catch (Exception e2) {
            Level level = Level.SEVERE;
            b.a(level, "Ex : SSC - resumeRecording : " + e2.getMessage());
            new StringBuilder("exception while resume recording ").append(e2.getMessage());
        }
    }

    public final void b() {
        f fVar = this.i;
        if (fVar != null) {
            fVar.a();
            this.i = null;
        }
    }

    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        try {
            this.n = 0;
            f.g().a((Runnable) new Runnable() {
                public final void run() {
                    i.this.f4244b = new Messenger(iBinder);
                    if (i.this.l.equalsIgnoreCase(FindRoomsRequest.KEY_FILTERED_ROOMS)) {
                        i.this.f4246d = new b(i.f4242f, i.this.f4244b, i.this.f4243a);
                    } else if (i.this.l.equalsIgnoreCase("ca")) {
                        i.this.f4247e = new a(i.f4242f, i.this.f4244b, i.this.f4243a);
                    } else {
                        i.this.f4245c = new c(i.f4242f, i.this.f4244b, i.this.f4243a);
                    }
                    i.d(i.this);
                }
            });
        } catch (Exception e2) {
            Level level = Level.SEVERE;
            b.a(level, "Ex : SSC - onSrcCon : " + e2.getMessage());
            new StringBuilder("recording can't be started due to exception : ").append(e2.getMessage());
            e2.printStackTrace();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f4244b = null;
        try {
            if (this.g != null) {
                this.g.cancel();
                this.g = null;
            }
            b();
        } catch (Exception e2) {
            Level level = Level.SEVERE;
            b.a(level, "Ex : SSC - onSrcDisc : " + e2.getMessage());
            new StringBuilder("Exception : ").append(e2.getMessage());
        }
    }
}

package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public UnityPlayer f3546a = null;

    /* renamed from: b  reason: collision with root package name */
    public Context f3547b = null;

    /* renamed from: c  reason: collision with root package name */
    public a f3548c;

    /* renamed from: d  reason: collision with root package name */
    public final Semaphore f3549d = new Semaphore(0);

    /* renamed from: e  reason: collision with root package name */
    public final Lock f3550e = new ReentrantLock();

    /* renamed from: f  reason: collision with root package name */
    public o f3551f = null;
    public int g = 2;
    public boolean h = false;
    public boolean i = false;

    public interface a {
        void a();
    }

    public p(UnityPlayer unityPlayer) {
        this.f3546a = unityPlayer;
    }

    /* access modifiers changed from: private */
    public void d() {
        o oVar = this.f3551f;
        if (oVar != null) {
            this.f3546a.removeViewFromPlayer(oVar);
            this.i = false;
            this.f3551f.destroyPlayer();
            this.f3551f = null;
            a aVar = this.f3548c;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public final void a() {
        this.f3550e.lock();
        o oVar = this.f3551f;
        if (oVar != null) {
            if (this.g == 0) {
                oVar.CancelOnPrepare();
            } else if (this.i) {
                boolean a2 = oVar.a();
                this.h = a2;
                if (!a2) {
                    this.f3551f.pause();
                }
            }
        }
        this.f3550e.unlock();
    }

    public final boolean a(Context context, String str, int i2, int i3, int i4, boolean z, long j, long j2, a aVar) {
        this.f3550e.lock();
        this.f3548c = aVar;
        this.f3547b = context;
        this.f3549d.drainPermits();
        this.g = 2;
        final String str2 = str;
        final int i5 = i2;
        final int i6 = i3;
        final int i7 = i4;
        final boolean z2 = z;
        final long j3 = j;
        final long j4 = j2;
        AnonymousClass1 r0 = new Runnable() {
            public final void run() {
                if (p.this.f3551f != null) {
                    f.Log(5, "Video already playing");
                    p.this.g = 2;
                    p.this.f3549d.release();
                    return;
                }
                p pVar = p.this;
                o oVar = new o(p.this.f3547b, str2, i5, i6, i7, z2, j3, j4, new com.unity3d.player.o.a() {
                    public final void a(int i) {
                        p.this.f3550e.lock();
                        p.this.g = i;
                        if (i == 3 && p.this.i) {
                            p.this.runOnUiThread(new Runnable() {
                                public final void run() {
                                    p.this.d();
                                    p.this.f3546a.resume();
                                }
                            });
                        }
                        if (i != 0) {
                            p.this.f3549d.release();
                        }
                        p.this.f3550e.unlock();
                    }
                });
                pVar.f3551f = oVar;
                if (p.this.f3551f != null) {
                    p.this.f3546a.addView(p.this.f3551f);
                }
            }
        };
        runOnUiThread(r0);
        boolean z3 = false;
        try {
            this.f3550e.unlock();
            this.f3549d.acquire();
            this.f3550e.lock();
            if (this.g != 2) {
                z3 = true;
            }
        } catch (InterruptedException unused) {
        }
        runOnUiThread(new Runnable() {
            public final void run() {
                p.this.f3546a.pause();
            }
        });
        runOnUiThread((!z3 || this.g == 3) ? new Runnable() {
            public final void run() {
                p.this.d();
                p.this.f3546a.resume();
            }
        } : new Runnable() {
            public final void run() {
                if (p.this.f3551f != null) {
                    p.this.f3546a.addViewToPlayer(p.this.f3551f, true);
                    p.this.i = true;
                    p.this.f3551f.requestFocus();
                }
            }
        });
        this.f3550e.unlock();
        return z3;
    }

    public final void b() {
        this.f3550e.lock();
        o oVar = this.f3551f;
        if (oVar != null && this.i && !this.h) {
            oVar.start();
        }
        this.f3550e.unlock();
    }

    public final void c() {
        this.f3550e.lock();
        o oVar = this.f3551f;
        if (oVar != null) {
            oVar.updateVideoLayout();
        }
        this.f3550e.unlock();
    }

    public final void runOnUiThread(Runnable runnable) {
        Context context = this.f3547b;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            f.Log(5, "Not running from an Activity; Ignoring execution request...");
        }
    }
}

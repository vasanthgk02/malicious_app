package com.userexperior.e;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

public final class aa {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3933a = z.f4034b;

    /* renamed from: b  reason: collision with root package name */
    public final List<ab> f3934b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f3935c = false;

    public final synchronized void a(String str) {
        long j;
        this.f3935c = true;
        if (this.f3934b.size() == 0) {
            j = 0;
        } else {
            j = this.f3934b.get(this.f3934b.size() - 1).f3938c - this.f3934b.get(0).f3938c;
        }
        if (j > 0) {
            long j2 = this.f3934b.get(0).f3938c;
            z.b("(%-4d ms) %s", Long.valueOf(j), str);
            for (ab next : this.f3934b) {
                long j3 = next.f3938c;
                z.b("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(next.f3937b), next.f3936a);
                j2 = j3;
            }
        }
    }

    public final synchronized void a(String str, long j) {
        if (!this.f3935c) {
            List<ab> list = this.f3934b;
            ab abVar = new ab(str, j, SystemClock.elapsedRealtime());
            list.add(abVar);
        } else {
            throw new IllegalStateException("Marker added to finished log");
        }
    }

    public final void finalize() throws Throwable {
        if (!this.f3935c) {
            a("Request on the loose");
            z.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }
}

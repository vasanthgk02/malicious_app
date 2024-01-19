package com.xiaomi.push;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.push.service.XMPushService.j;
import com.xiaomi.push.service.n;

public class ca extends j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f4532a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ bz f407a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f4533b;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ca(bz bzVar, int i, long j, long j2) {
        // this.f407a = bzVar;
        // this.f4532a = j;
        // this.f4533b = j2;
        super(i);
    }

    public String a() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("check the ping-pong.");
        outline73.append(this.f4533b);
        return outline73.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m566a() {
        Thread.yield();
        if (this.f407a.c() && !this.f407a.a(this.f4532a)) {
            n.a((Context) this.f407a.f4525b).b();
            this.f407a.f4525b.a(22, (Exception) null);
        }
    }
}

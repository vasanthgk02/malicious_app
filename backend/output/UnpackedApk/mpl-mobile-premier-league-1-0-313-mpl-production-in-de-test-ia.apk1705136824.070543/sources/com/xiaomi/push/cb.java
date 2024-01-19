package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.push.service.XMPushService.j;

public class cb extends j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bz f4534a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Exception f408a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4535b;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public cb(bz bzVar, int i, int i2, Exception exc) {
        // this.f4534a = bzVar;
        // this.f4535b = i2;
        // this.f408a = exc;
        super(i);
    }

    public String a() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("shutdown the connection. ");
        outline73.append(this.f4535b);
        outline73.append(", ");
        outline73.append(this.f408a);
        return outline73.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m567a() {
        this.f4534a.f4525b.a(this.f4535b, this.f408a);
    }
}

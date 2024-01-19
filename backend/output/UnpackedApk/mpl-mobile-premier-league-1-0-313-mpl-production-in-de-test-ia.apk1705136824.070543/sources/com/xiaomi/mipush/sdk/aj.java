package com.xiaomi.mipush.sdk;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.bf;
import com.xiaomi.push.y;

public class aj extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ag f4350a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public aj(ag agVar, Handler handler) {
        // this.f4350a = agVar;
        super(handler);
    }

    public void onChange(boolean z) {
        ag agVar = this.f4350a;
        agVar.f211a = Integer.valueOf(bf.a(ag.a(agVar)).a());
        if (ag.a(this.f4350a).intValue() != 0) {
            ag.a(this.f4350a).getContentResolver().unregisterContentObserver(this);
            if (y.a(ag.a(this.f4350a))) {
                this.f4350a.c();
            }
        }
    }
}

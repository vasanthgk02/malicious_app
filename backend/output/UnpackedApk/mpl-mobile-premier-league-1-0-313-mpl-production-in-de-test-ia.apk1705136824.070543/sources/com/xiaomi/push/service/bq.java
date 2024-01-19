package com.xiaomi.push.service;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.bp.a;

public class bq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bp f4923a;

    public bq(bp bpVar) {
        this.f4923a = bpVar;
    }

    public void run() {
        try {
            for (a run : bp.a(this.f4923a).values()) {
                run.run();
            }
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Sync job exception :");
            outline73.append(e2.getMessage());
            b.a(outline73.toString());
        }
        this.f4923a.f897a = false;
    }
}

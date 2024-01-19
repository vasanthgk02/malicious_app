package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bc.a;
import com.xiaomi.push.service.XMJobService;

@TargetApi(21)
public class be implements a {

    /* renamed from: a  reason: collision with root package name */
    public JobScheduler f4484a;

    /* renamed from: a  reason: collision with other field name */
    public Context f347a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f348a = false;

    public be(Context context) {
        this.f347a = context;
        this.f4484a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    public void a() {
        this.f348a = false;
        this.f4484a.cancel(1);
    }

    public void a(long j) {
        Builder builder = new Builder(1, new ComponentName(this.f347a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        JobInfo build = builder.build();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("schedule Job = ");
        outline73.append(build.getId());
        outline73.append(" in ");
        outline73.append(j);
        b.c(outline73.toString());
        this.f4484a.schedule(builder.build());
    }

    public void a(boolean z) {
        if (z || this.f348a) {
            long b2 = (long) by.b();
            if (z) {
                a();
                b2 -= SystemClock.elapsedRealtime() % b2;
            }
            this.f348a = true;
            a(b2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m516a() {
        return this.f348a;
    }
}

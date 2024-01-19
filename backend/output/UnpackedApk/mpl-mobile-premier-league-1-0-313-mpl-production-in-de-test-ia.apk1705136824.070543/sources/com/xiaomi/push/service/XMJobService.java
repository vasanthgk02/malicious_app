package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bc;
import com.xiaomi.push.z;

public class XMJobService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static Service f4809a;

    /* renamed from: a  reason: collision with other field name */
    public IBinder f787a = null;

    @TargetApi(21)
    public static class a extends JobService {

        /* renamed from: a  reason: collision with root package name */
        public Binder f4810a;

        /* renamed from: a  reason: collision with other field name */
        public Handler f788a;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a  reason: collision with other inner class name */
        public static class C0068a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            public JobService f4811a;

            public C0068a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f4811a = jobService;
            }

            public void handleMessage(Message message) {
                if (message.what == 1) {
                    JobParameters jobParameters = (JobParameters) message.obj;
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Job finished ");
                    outline73.append(jobParameters.getJobId());
                    b.a(outline73.toString());
                    this.f4811a.jobFinished(jobParameters, false);
                    if (jobParameters.getJobId() == 1) {
                        bc.a(false);
                    }
                }
            }
        }

        public a(Service service) {
            this.f4810a = null;
            this.f4810a = (Binder) z.a((Object) this, (String) "onBind", new Intent());
            z.a((Object) this, (String) "attachBaseContext", service);
        }

        public boolean onStartJob(JobParameters jobParameters) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Job started ");
            outline73.append(jobParameters.getJobId());
            b.a(outline73.toString());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f788a == null) {
                this.f788a = new C0068a(this);
            }
            Handler handler = this.f788a;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Job stop ");
            outline73.append(jobParameters.getJobId());
            b.a(outline73.toString());
            return false;
        }
    }

    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f787a;
        return iBinder != null ? iBinder : new Binder();
    }

    public void onCreate() {
        super.onCreate();
        this.f787a = new a(this).f4810a;
        f4809a = this;
    }

    public void onDestroy() {
        super.onDestroy();
        f4809a = null;
    }
}

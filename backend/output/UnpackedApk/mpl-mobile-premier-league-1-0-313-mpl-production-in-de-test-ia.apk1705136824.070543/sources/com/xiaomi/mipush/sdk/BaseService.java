package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.logger.b;
import java.lang.ref.WeakReference;

public abstract class BaseService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public a f4323a;

    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<BaseService> f4324a;

        public a(WeakReference<BaseService> weakReference) {
            this.f4324a = weakReference;
        }

        public void a() {
            if (hasMessages(1001)) {
                removeMessages(1001);
            }
            sendEmptyMessageDelayed(1001, 1000);
        }

        public void handleMessage(Message message) {
            if (message.what == 1001) {
                WeakReference<BaseService> weakReference = this.f4324a;
                if (weakReference != null) {
                    BaseService baseService = (BaseService) weakReference.get();
                    if (baseService != null) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("TimeoutHandler ");
                        outline73.append(baseService.toString());
                        outline73.append(" kill self");
                        b.c(outline73.toString());
                        if (!baseService.a()) {
                            baseService.stopSelf();
                            return;
                        }
                        b.c("TimeoutHandler has job");
                        sendEmptyMessageDelayed(1001, 1000);
                    }
                }
            }
        }
    }

    public abstract boolean a();

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.f4323a == null) {
            this.f4323a = new a(new WeakReference(this));
        }
        this.f4323a.a();
    }
}

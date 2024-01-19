package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportContext.Builder;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;

public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    public static /* synthetic */ void lambda$onReceive$0() {
    }

    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        TransportRuntime.initialize(context);
        Builder builder = TransportContext.builder();
        builder.setBackendName(queryParameter);
        builder.setPriority(PriorityMapping.valueOf(intValue));
        if (queryParameter2 != null) {
            ((AutoValue_TransportContext.Builder) builder).extras = Base64.decode(queryParameter2, 0);
        }
        Uploader uploader = TransportRuntime.getInstance().uploader;
        uploader.executor.execute(new Runnable(builder.build(), i, $$Lambda$AlarmManagerSchedulerBroadcastReceiver$QVvx_1dYzoLxHZ6PSGEHXWyk4v4.INSTANCE) {
            public final /* synthetic */ TransportContext f$1;
            public final /* synthetic */ int f$2;
            public final /* synthetic */ Runnable f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                Uploader.this.lambda$upload$1$Uploader(this.f$1, this.f$2, this.f$3);
            }
        });
    }
}

package com.google.firebase.messaging;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzj;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.messaging.WithinAppServiceConnection.BindRequest;

public class WithinAppServiceBinder extends Binder {
    public final IntentHandler intentHandler;

    public interface IntentHandler {
    }

    public WithinAppServiceBinder(IntentHandler intentHandler2) {
        this.intentHandler = intentHandler2;
    }

    public void send(BindRequest bindRequest) {
        if (Binder.getCallingUid() == Process.myUid()) {
            boolean isLoggable = Log.isLoggable("FirebaseMessaging", 3);
            IntentHandler intentHandler2 = this.intentHandler;
            Task access$000 = EnhancedIntentService.this.processIntent(bindRequest.intent);
            zzw zzw = (zzw) access$000;
            zzw.zzb.zza(new zzj($$Lambda$_14QHG018Z6p13d3hzJuGTWnNeo.INSTANCE, new OnCompleteListener() {
                public final void onComplete(Task task) {
                    BindRequest.this.finish();
                }
            }));
            zzw.zzi();
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}

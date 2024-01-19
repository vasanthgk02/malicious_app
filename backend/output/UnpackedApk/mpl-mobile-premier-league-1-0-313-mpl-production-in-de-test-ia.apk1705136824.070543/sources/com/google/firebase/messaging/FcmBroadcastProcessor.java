package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzj;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.messaging.WithinAppServiceConnection.BindRequest;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

@KeepForSdk
public class FcmBroadcastProcessor {
    public static WithinAppServiceConnection fcmServiceConn;
    public static final Object lock = new Object();
    public final Context context;
    public final Executor executor = $$Lambda$_14QHG018Z6p13d3hzJuGTWnNeo.INSTANCE;

    public FcmBroadcastProcessor(Context context2) {
        this.context = context2;
    }

    public static Task<Integer> bindToMessagingService(Context context2, Intent intent) {
        WithinAppServiceConnection withinAppServiceConnection;
        zzw zzw;
        boolean isLoggable = Log.isLoggable("FirebaseMessaging", 3);
        synchronized (lock) {
            if (fcmServiceConn == null) {
                fcmServiceConn = new WithinAppServiceConnection(context2, "com.google.firebase.MESSAGING_EVENT");
            }
            withinAppServiceConnection = fcmServiceConn;
        }
        synchronized (withinAppServiceConnection) {
            Log.isLoggable("FirebaseMessaging", 3);
            BindRequest bindRequest = new BindRequest(intent);
            ScheduledExecutorService scheduledExecutorService = withinAppServiceConnection.scheduledExecutorService;
            ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable() {
                public final void run() {
                    BindRequest.this.lambda$arrangeTimeout$0$WithinAppServiceConnection$BindRequest();
                }
            }, 9000, TimeUnit.MILLISECONDS);
            zzw zzw2 = bindRequest.taskCompletionSource.zza;
            zzw2.zzb.zza(new zzj(scheduledExecutorService, new OnCompleteListener(schedule) {
                public final /* synthetic */ ScheduledFuture f$0;

                {
                    this.f$0 = r1;
                }

                public final void onComplete(Task task) {
                    this.f$0.cancel(false);
                }
            }));
            zzw2.zzi();
            withinAppServiceConnection.intentQueue.add(bindRequest);
            withinAppServiceConnection.flushQueue();
            zzw = bindRequest.taskCompletionSource.zza;
        }
        return zzw.continueWith($$Lambda$_14QHG018Z6p13d3hzJuGTWnNeo.INSTANCE, $$Lambda$FcmBroadcastProcessor$LcCXsLuKfiskG6QsPewNyADqCrE.INSTANCE);
    }

    public static Integer lambda$startMessagingService$0(Context context2, Intent intent) throws Exception {
        int i;
        ComponentName componentName;
        ServiceStarter instance = ServiceStarter.getInstance();
        String str = null;
        if (instance != null) {
            Log.isLoggable("FirebaseMessaging", 3);
            instance.messagingEvents.offer(intent);
            Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
            intent2.setPackage(context2.getPackageName());
            synchronized (instance) {
                if (instance.firebaseMessagingServiceClassName != null) {
                    str = instance.firebaseMessagingServiceClassName;
                } else {
                    ResolveInfo resolveService = context2.getPackageManager().resolveService(intent2, 0);
                    if (resolveService != null) {
                        if (resolveService.serviceInfo != null) {
                            ServiceInfo serviceInfo = resolveService.serviceInfo;
                            if (context2.getPackageName().equals(serviceInfo.packageName)) {
                                if (serviceInfo.name != null) {
                                    if (serviceInfo.name.startsWith(".")) {
                                        instance.firebaseMessagingServiceClassName = context2.getPackageName() + serviceInfo.name;
                                    } else {
                                        instance.firebaseMessagingServiceClassName = serviceInfo.name;
                                    }
                                    str = instance.firebaseMessagingServiceClassName;
                                }
                            }
                        }
                    }
                }
            }
            if (str != null) {
                Log.isLoggable("FirebaseMessaging", 3);
                intent2.setClassName(context2.getPackageName(), str);
            }
            try {
                if (instance.hasWakeLockPermission(context2)) {
                    componentName = WakeLockHolder.startWakefulService(context2, intent2);
                } else {
                    componentName = context2.startService(intent2);
                }
                i = componentName == null ? 404 : -1;
            } catch (SecurityException unused) {
                i = 401;
            } catch (IllegalStateException e2) {
                "Failed to start service while in background: " + e2;
                i = 402;
            }
            return Integer.valueOf(i);
        }
        throw null;
    }

    public static /* synthetic */ Task lambda$startMessagingService$2(Context context2, Intent intent, Task task) throws Exception {
        return (!PlatformVersion.isAtLeastO() || ((Integer) task.getResult()).intValue() != 402) ? task : bindToMessagingService(context2, intent).continueWith($$Lambda$_14QHG018Z6p13d3hzJuGTWnNeo.INSTANCE, $$Lambda$FcmBroadcastProcessor$5Y63K14lse0aDUI3iypzwmhKrc.INSTANCE);
    }

    @KeepForSdk
    public Task<Integer> process(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        boolean z = false;
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        Context context2 = this.context;
        boolean z2 = PlatformVersion.isAtLeastO() && context2.getApplicationInfo().targetSdkVersion >= 26;
        if ((intent.getFlags() & ClientDefaults.MAX_MSG_SIZE) != 0) {
            z = true;
        }
        if (!z2 || z) {
            return Tasks.call(this.executor, new Callable(context2, intent) {
                public final /* synthetic */ Context f$0;
                public final /* synthetic */ Intent f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final Object call() {
                    return FcmBroadcastProcessor.lambda$startMessagingService$0(this.f$0, this.f$1);
                }
            }).continueWithTask(this.executor, new Continuation(context2, intent) {
                public final /* synthetic */ Context f$0;
                public final /* synthetic */ Intent f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final Object then(Task task) {
                    return FcmBroadcastProcessor.lambda$startMessagingService$2(this.f$0, this.f$1, task);
                }
            });
        }
        return bindToMessagingService(context2, intent);
    }
}

package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.internal.cloudmessaging.zza;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
public class Rpc {
    public static int zza;
    public static PendingIntent zzb;
    public static final Executor zzc = zzz.zza;
    public static final Pattern zzd = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");
    public final SimpleArrayMap<String, TaskCompletionSource<Bundle>> zze = new SimpleArrayMap<>();
    public final Context zzf;
    public final zzt zzg;
    public final ScheduledExecutorService zzh;
    public Messenger zzi;
    public Messenger zzj;
    public zzd zzk;

    public Rpc(Context context) {
        this.zzf = context;
        this.zzg = new zzt(context);
        this.zzi = new Messenger(new zzaa(this, Looper.getMainLooper()));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzh = scheduledThreadPoolExecutor;
    }

    public static Task zza(Bundle bundle) throws Exception {
        if (bundle != null && bundle.containsKey("google.messenger")) {
            return Tasks.forResult(null);
        }
        return Tasks.forResult(bundle);
    }

    public static void zzc(Rpc rpc, Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zzc());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zzd) {
                        rpc.zzk = (zzd) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        rpc.zzj = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    String stringExtra = intent2.getStringExtra("registration_id");
                    if (stringExtra == null) {
                        stringExtra = intent2.getStringExtra("unregistered");
                    }
                    if (stringExtra == null) {
                        String stringExtra2 = intent2.getStringExtra("error");
                        if (stringExtra2 == null) {
                            String.valueOf(intent2.getExtras()).length();
                            return;
                        }
                        if (Log.isLoggable("Rpc", 3)) {
                            if (stringExtra2.length() != 0) {
                                "Received InstanceID error ".concat(stringExtra2);
                            } else {
                                new String("Received InstanceID error ");
                            }
                        }
                        if (stringExtra2.startsWith("|")) {
                            String[] split = stringExtra2.split("\\|");
                            if (split.length <= 2 || !"ID".equals(split[1])) {
                                if (stringExtra2.length() != 0) {
                                    "Unexpected structured response ".concat(stringExtra2);
                                } else {
                                    new String("Unexpected structured response ");
                                }
                                return;
                            }
                            String str = split[2];
                            String str2 = split[3];
                            if (str2.startsWith(":")) {
                                str2 = str2.substring(1);
                            }
                            rpc.zzh(str, intent2.putExtra("error", str2).getExtras());
                            return;
                        }
                        synchronized (rpc.zze) {
                            for (int i = 0; i < rpc.zze.mSize; i++) {
                                rpc.zzh((String) rpc.zze.keyAt(i), intent2.getExtras());
                            }
                        }
                        return;
                    }
                    Matcher matcher = zzd.matcher(stringExtra);
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        if (group != null) {
                            Bundle extras = intent2.getExtras();
                            extras.putString("registration_id", group2);
                            rpc.zzh(group, extras);
                        }
                    } else if (Log.isLoggable("Rpc", 3)) {
                        if (stringExtra.length() != 0) {
                            "Unexpected response string: ".concat(stringExtra);
                        } else {
                            new String("Unexpected response string: ");
                        }
                    }
                } else if (Log.isLoggable("Rpc", 3)) {
                    String valueOf = String.valueOf(action);
                    if (valueOf.length() != 0) {
                        "Unexpected response action: ".concat(valueOf);
                    } else {
                        new String("Unexpected response action: ");
                    }
                }
            }
        }
    }

    public final Task<Bundle> zze(Bundle bundle) {
        String num;
        Class<Rpc> cls = Rpc.class;
        synchronized (cls) {
            int i = zza;
            zza = i + 1;
            num = Integer.toString(i);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.zze) {
            this.zze.put(num, taskCompletionSource);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.zzg.zzb() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        Context context = this.zzf;
        synchronized (cls) {
            if (zzb == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                zzb = zza.zza(context, 0, intent2, zza.zza);
            }
            intent.putExtra("app", zzb);
        }
        intent.putExtra("kid", GeneratedOutlineSupport.outline63(new StringBuilder(String.valueOf(num).length() + 5), "|ID|", num, "|"));
        if (Log.isLoggable("Rpc", 3)) {
            String.valueOf(intent.getExtras()).length();
        }
        intent.putExtra("google.messenger", this.zzi);
        if (!(this.zzj == null && this.zzk == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                Messenger messenger = this.zzj;
                if (messenger != null) {
                    messenger.send(obtain);
                } else {
                    zzd zzd2 = this.zzk;
                    Messenger messenger2 = zzd2.zza;
                    if (messenger2 != null) {
                        messenger2.send(obtain);
                    } else {
                        zzd2.zzb.send(obtain);
                    }
                }
            } catch (RemoteException unused) {
                Log.isLoggable("Rpc", 3);
            }
            taskCompletionSource.zza.addOnCompleteListener(zzc, new zzw(this, num, this.zzh.schedule(new zzy(taskCompletionSource), 30, TimeUnit.SECONDS)));
            return taskCompletionSource.zza;
        }
        if (this.zzg.zzb() == 2) {
            this.zzf.sendBroadcast(intent);
        } else {
            this.zzf.startService(intent);
        }
        taskCompletionSource.zza.addOnCompleteListener(zzc, new zzw(this, num, this.zzh.schedule(new zzy(taskCompletionSource), 30, TimeUnit.SECONDS)));
        return taskCompletionSource.zza;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(java.lang.String r3, android.os.Bundle r4) {
        /*
            r2 = this;
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r0 = r2.zze
            monitor-enter(r0)
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r1 = r2.zze     // Catch:{ all -> 0x002b }
            java.lang.Object r1 = r1.remove(r3)     // Catch:{ all -> 0x002b }
            com.google.android.gms.tasks.TaskCompletionSource r1 = (com.google.android.gms.tasks.TaskCompletionSource) r1     // Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x0024
            java.lang.String r4 = "Missing callback for "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x002b }
            int r1 = r3.length()     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x001d
            r4.concat(r3)     // Catch:{ all -> 0x002b }
            goto L_0x0022
        L_0x001d:
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x002b }
            r3.<init>(r4)     // Catch:{ all -> 0x002b }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x0024:
            com.google.android.gms.tasks.zzw r3 = r1.zza     // Catch:{ all -> 0x002b }
            r3.zzb(r4)     // Catch:{ all -> 0x002b }
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.Rpc.zzh(java.lang.String, android.os.Bundle):void");
    }
}

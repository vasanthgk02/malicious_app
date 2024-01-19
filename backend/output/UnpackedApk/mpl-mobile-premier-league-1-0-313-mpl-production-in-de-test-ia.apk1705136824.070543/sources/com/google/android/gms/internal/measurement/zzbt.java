package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import java.lang.reflect.Method;

@TargetApi(24)
/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzbt {
    public static final Method zza;
    public static final Method zzb;

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 6
            java.lang.String r3 = "JobSchedulerCompat"
            r4 = 0
            r5 = 24
            r6 = 0
            if (r1 < r5) goto L_0x002d
            r1 = 4
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class<android.app.job.JobInfo> r7 = android.app.job.JobInfo.class
            r1[r4] = r7     // Catch:{ NoSuchMethodException -> 0x0028 }
            r7 = 1
            r1[r7] = r0     // Catch:{ NoSuchMethodException -> 0x0028 }
            r7 = 2
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0028 }
            r1[r7] = r8     // Catch:{ NoSuchMethodException -> 0x0028 }
            r7 = 3
            r1[r7] = r0     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class<android.app.job.JobScheduler> r0 = android.app.job.JobScheduler.class
            java.lang.String r7 = "scheduleAsPackage"
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r7, r1)     // Catch:{ NoSuchMethodException -> 0x0028 }
            goto L_0x002e
        L_0x0028:
            boolean r0 = android.util.Log.isLoggable(r3, r2)
        L_0x002d:
            r0 = r6
        L_0x002e:
            zza = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r5) goto L_0x0044
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.String r1 = "myUserId"
            java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x003f }
            java.lang.reflect.Method r6 = r0.getDeclaredMethod(r1, r4)     // Catch:{ NoSuchMethodException -> 0x003f }
            goto L_0x0044
        L_0x003f:
            boolean r0 = android.util.Log.isLoggable(r3, r2)
        L_0x0044:
            zzb = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbt.<clinit>():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(android.content.Context r5, android.app.job.JobInfo r6, java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r7 = "jobscheduler"
            java.lang.Object r7 = r5.getSystemService(r7)
            android.app.job.JobScheduler r7 = (android.app.job.JobScheduler) r7
            if (r7 == 0) goto L_0x0067
            java.lang.reflect.Method r8 = zza
            if (r8 == 0) goto L_0x0062
            java.lang.String r8 = "android.permission.UPDATE_DEVICE_STATS"
            int r5 = r5.checkSelfPermission(r8)
            if (r5 == 0) goto L_0x0017
            goto L_0x0062
        L_0x0017:
            java.lang.reflect.Method r5 = zzb
            r8 = 0
            if (r5 == 0) goto L_0x0035
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.Object[] r1 = new java.lang.Object[r8]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x002d }
            java.lang.Object r5 = r5.invoke(r0, r1)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x002d }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x002d }
            if (r5 == 0) goto L_0x0035
            int r5 = r5.intValue()     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x002d }
            goto L_0x0036
        L_0x002d:
            r5 = 6
            java.lang.String r0 = "JobSchedulerCompat"
            boolean r5 = android.util.Log.isLoggable(r0, r5)
        L_0x0035:
            r5 = 0
        L_0x0036:
            java.lang.reflect.Method r0 = zza
            java.lang.String r1 = "com.google.android.gms"
            java.lang.String r2 = "UploadAlarm"
            if (r0 == 0) goto L_0x005d
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005d }
            r3[r8] = r6     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005d }
            r4 = 1
            r3[r4] = r1     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005d }
            r1 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005d }
            r3[r1] = r5     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005d }
            r5 = 3
            r3[r5] = r2     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005d }
            java.lang.Object r5 = r0.invoke(r7, r3)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005d }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005d }
            if (r5 == 0) goto L_0x0061
            int r8 = r5.intValue()     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005d }
            goto L_0x0061
        L_0x005d:
            int r8 = r7.schedule(r6)
        L_0x0061:
            return r8
        L_0x0062:
            int r5 = r7.schedule(r6)
            return r5
        L_0x0067:
            r5 = 0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbt.zza(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}

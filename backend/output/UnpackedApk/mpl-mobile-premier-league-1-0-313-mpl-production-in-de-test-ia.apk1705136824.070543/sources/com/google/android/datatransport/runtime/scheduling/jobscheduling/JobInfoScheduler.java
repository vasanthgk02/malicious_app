package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;

public class JobInfoScheduler implements WorkScheduler {
    public final SchedulerConfig config;
    public final Context context;
    public final EventStore eventStore;

    public JobInfoScheduler(Context context2, EventStore eventStore2, SchedulerConfig schedulerConfig) {
        this.context = context2;
        this.eventStore = eventStore2;
        this.config = schedulerConfig;
    }

    public void schedule(TransportContext transportContext, int i) {
        schedule(transportContext, i, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0091, code lost:
        r11 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void schedule(com.google.android.datatransport.runtime.TransportContext r18, int r19, boolean r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            android.content.ComponentName r3 = new android.content.ComponentName
            android.content.Context r4 = r0.context
            java.lang.Class<com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService> r5 = com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService.class
            r3.<init>(r4, r5)
            android.content.Context r4 = r0.context
            java.lang.String r5 = "jobscheduler"
            java.lang.Object r4 = r4.getSystemService(r5)
            android.app.job.JobScheduler r4 = (android.app.job.JobScheduler) r4
            java.util.zip.Adler32 r5 = new java.util.zip.Adler32
            r5.<init>()
            android.content.Context r6 = r0.context
            java.lang.String r6 = r6.getPackageName()
            java.lang.String r7 = "UTF-8"
            java.nio.charset.Charset r8 = java.nio.charset.Charset.forName(r7)
            byte[] r6 = r6.getBytes(r8)
            r5.update(r6)
            r6 = r1
            com.google.android.datatransport.runtime.AutoValue_TransportContext r6 = (com.google.android.datatransport.runtime.AutoValue_TransportContext) r6
            java.lang.String r8 = r6.backendName
            java.nio.charset.Charset r7 = java.nio.charset.Charset.forName(r7)
            byte[] r7 = r8.getBytes(r7)
            r5.update(r7)
            r7 = 4
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r7)
            com.google.android.datatransport.Priority r9 = r6.priority
            int r9 = com.google.android.datatransport.runtime.util.PriorityMapping.toInt(r9)
            java.nio.ByteBuffer r8 = r8.putInt(r9)
            byte[] r8 = r8.array()
            r5.update(r8)
            byte[] r6 = r6.extras
            if (r6 == 0) goto L_0x005e
            r5.update(r6)
        L_0x005e:
            long r5 = r5.getValue()
            int r6 = (int) r5
            java.lang.String r5 = "JobInfoScheduler"
            java.lang.String r8 = "attemptNumber"
            r9 = 0
            r10 = 1
            if (r20 != 0) goto L_0x009a
            java.util.List r11 = r4.getAllPendingJobs()
            java.util.Iterator r11 = r11.iterator()
        L_0x0073:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0091
            java.lang.Object r12 = r11.next()
            android.app.job.JobInfo r12 = (android.app.job.JobInfo) r12
            android.os.PersistableBundle r13 = r12.getExtras()
            int r13 = r13.getInt(r8)
            int r12 = r12.getId()
            if (r12 != r6) goto L_0x0073
            if (r13 < r2) goto L_0x0091
            r11 = 1
            goto L_0x0092
        L_0x0091:
            r11 = 0
        L_0x0092:
            if (r11 == 0) goto L_0x009a
            java.lang.String r2 = "Upload for context %s is already scheduled. Returning..."
            com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.d(r5, r2, r1)
            return
        L_0x009a:
            com.google.android.datatransport.runtime.scheduling.persistence.EventStore r11 = r0.eventStore
            long r11 = r11.getNextCallTime(r1)
            com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig r13 = r0.config
            android.app.job.JobInfo$Builder r14 = new android.app.job.JobInfo$Builder
            r14.<init>(r6, r3)
            r3 = r1
            com.google.android.datatransport.runtime.AutoValue_TransportContext r3 = (com.google.android.datatransport.runtime.AutoValue_TransportContext) r3
            com.google.android.datatransport.Priority r15 = r3.priority
            r16 = r8
            long r7 = r13.getScheduleDelay(r15, r11, r2)
            r14.setMinimumLatency(r7)
            com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig r13 = (com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig) r13
            java.util.Map<com.google.android.datatransport.Priority, com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$ConfigValue> r7 = r13.values
            java.lang.Object r7 = r7.get(r15)
            com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$ConfigValue r7 = (com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue) r7
            com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue r7 = (com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue) r7
            java.util.Set<com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag> r7 = r7.flags
            com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag r8 = com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.Flag.NETWORK_UNMETERED
            boolean r8 = r7.contains(r8)
            r13 = 2
            if (r8 == 0) goto L_0x00d0
            r14.setRequiredNetworkType(r13)
            goto L_0x00d3
        L_0x00d0:
            r14.setRequiredNetworkType(r10)
        L_0x00d3:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag r8 = com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.Flag.DEVICE_CHARGING
            boolean r8 = r7.contains(r8)
            if (r8 == 0) goto L_0x00de
            r14.setRequiresCharging(r10)
        L_0x00de:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag r8 = com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.Flag.DEVICE_IDLE
            boolean r7 = r7.contains(r8)
            if (r7 == 0) goto L_0x00e9
            r14.setRequiresDeviceIdle(r10)
        L_0x00e9:
            android.os.PersistableBundle r7 = new android.os.PersistableBundle
            r7.<init>()
            r8 = r16
            r7.putInt(r8, r2)
            java.lang.String r8 = r3.backendName
            java.lang.String r15 = "backendName"
            r7.putString(r15, r8)
            com.google.android.datatransport.Priority r8 = r3.priority
            int r8 = com.google.android.datatransport.runtime.util.PriorityMapping.toInt(r8)
            java.lang.String r15 = "priority"
            r7.putInt(r15, r8)
            byte[] r8 = r3.extras
            if (r8 == 0) goto L_0x0112
            java.lang.String r8 = android.util.Base64.encodeToString(r8, r9)
            java.lang.String r15 = "extras"
            r7.putString(r15, r8)
        L_0x0112:
            r14.setExtras(r7)
            r7 = 5
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r9] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            r7[r10] = r1
            com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig r1 = r0.config
            com.google.android.datatransport.Priority r3 = r3.priority
            long r8 = r1.getScheduleDelay(r3, r11, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r8)
            r7[r13] = r1
            r1 = 3
            java.lang.Long r3 = java.lang.Long.valueOf(r11)
            r7[r1] = r3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r19)
            r2 = 4
            r7[r2] = r1
            com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getTag(r5)
            java.lang.String r1 = "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d"
            java.lang.String.format(r1, r7)
            android.app.job.JobInfo r1 = r14.build()
            r4.schedule(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler.schedule(com.google.android.datatransport.runtime.TransportContext, int, boolean):void");
    }
}

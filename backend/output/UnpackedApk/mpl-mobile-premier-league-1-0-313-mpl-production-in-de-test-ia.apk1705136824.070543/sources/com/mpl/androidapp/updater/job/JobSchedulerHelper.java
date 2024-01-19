package com.mpl.androidapp.updater.job;

import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import com.mpl.androidapp.backgroundmanager.BackgroundOperationsJobService;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.Util;

public class JobSchedulerHelper {
    public static final int BACKGROUND_JOB_ID = 2072943318;
    public static final int FUTURE_JOB_ID = 2073423318;
    public static final int SYNC_TASK_ID = 2071864318;
    public static final String TAG = "JobSchedulerHelper";
    public static final int UPLOAD_TASK_ID = 2072344318;

    public static void cancelBackgroundRunningTask(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (getJobInfo(BACKGROUND_JOB_ID, jobScheduler) != null) {
            jobScheduler.cancel(BACKGROUND_JOB_ID);
        }
    }

    public static void checkAllJobScheduled(Context context) {
        for (JobInfo id : ((JobScheduler) context.getSystemService("jobscheduler")).getAllPendingJobs()) {
            switch (id.getId()) {
                case SYNC_TASK_ID /*2071864318*/:
                    MLogger.d(TAG, "checkAllJobScheduled: ", "Delete Assets jobs is running");
                    break;
                case UPLOAD_TASK_ID /*2072344318*/:
                    MLogger.d(TAG, "checkAllJobScheduled: ", "Upload jobs is running");
                    break;
                case BACKGROUND_JOB_ID /*2072943318*/:
                    MLogger.d(TAG, "checkAllJobScheduled: ", "Background notification sync jobs is running");
                    break;
                case FUTURE_JOB_ID /*2073423318*/:
                    MLogger.d(TAG, "checkAllJobScheduled: ", "Future jobs is running");
                    break;
                default:
                    MLogger.d(TAG, "checkAllJobScheduled: ");
                    break;
            }
        }
    }

    public static void createOrResetJobScheduler(Context context) {
        MLogger.d("backgroundService", "createOrResetJobScheduler: ");
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            long timeIntervalForRestartingBackground = MSharedPreferencesUtils.getTimeIntervalForRestartingBackground();
            int intPref = MSharedPreferencesUtils.getIntPref("backgroundServiceJobId", -1, false);
            if (intPref >= 0 || timeIntervalForRestartingBackground >= 0) {
                int i = (timeIntervalForRestartingBackground > 0 ? 1 : (timeIntervalForRestartingBackground == 0 ? 0 : -1));
                if (i < 0) {
                    jobScheduler.cancel(intPref);
                    MSharedPreferencesUtils.putIntPref("backgroundServiceJobId", -1, false);
                    return;
                }
                ComponentName componentName = new ComponentName(context, BackgroundOperationsJobService.class);
                boolean z = intPref < 0 && i > 0;
                JobInfo jobInfo = getJobInfo(intPref, jobScheduler);
                if (!(jobInfo == null || jobInfo.getIntervalMillis() == timeIntervalForRestartingBackground)) {
                    jobScheduler.cancel(intPref);
                    MSharedPreferencesUtils.putIntPref("backgroundServiceJobId", -1, false);
                    z = true;
                }
                if (z) {
                    Builder builder = new Builder(BACKGROUND_JOB_ID, componentName);
                    builder.setRequiredNetworkType(1);
                    builder.setRequiresCharging(false);
                    if (VERSION.SDK_INT >= 24) {
                        builder.setPeriodic(timeIntervalForRestartingBackground, 300000);
                    } else {
                        builder.setPeriodic(timeIntervalForRestartingBackground);
                    }
                    if (VERSION.SDK_INT >= 26) {
                        builder.setRequiresBatteryNotLow(true);
                    }
                    if (Util.hasPermission(context, "android.permission.RECEIVE_BOOT_COMPLETED")) {
                        builder.setPersisted(true);
                    }
                    if (jobScheduler.schedule(builder.build()) == 1) {
                        MLogger.d("backgroundService", "Job scheduled - 2072943318");
                        MSharedPreferencesUtils.putIntPref("backgroundServiceJobId", BACKGROUND_JOB_ID, false);
                    } else {
                        MLogger.d("backgroundService", "Job not scheduled - 2072943318");
                    }
                }
            }
        }
    }

    public static JobInfo getJobInfo(int i, JobScheduler jobScheduler) {
        for (JobInfo next : jobScheduler.getAllPendingJobs()) {
            if (next.getId() == i) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00a2 A[Catch:{ Exception -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00ac A[Catch:{ Exception -> 0x00b6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void scheduleJob(android.content.Context r10) {
        /*
            java.lang.String r0 = "JobSchedulerHelper"
            r1 = 2
            r2 = 0
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x00b6 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b6 }
            r5.<init>()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r6 = "scheduleJob() called with: context = ["
            r5.append(r6)     // Catch:{ Exception -> 0x00b6 }
            r5.append(r10)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r6 = "]"
            r5.append(r6)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00b6 }
            r4[r2] = r5     // Catch:{ Exception -> 0x00b6 }
            com.mpl.androidapp.utils.MLogger.d(r0, r4)     // Catch:{ Exception -> 0x00b6 }
            android.content.ComponentName r4 = new android.content.ComponentName     // Catch:{ Exception -> 0x00b6 }
            android.content.Context r5 = r10.getApplicationContext()     // Catch:{ Exception -> 0x00b6 }
            java.lang.Class<com.mpl.androidapp.updater.job.UpdaterJobService> r6 = com.mpl.androidapp.updater.job.UpdaterJobService.class
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x00b6 }
            android.app.job.JobInfo$Builder r5 = new android.app.job.JobInfo$Builder     // Catch:{ Exception -> 0x00b6 }
            r6 = 2071864318(0x7b7e23fe, float:1.3195734E36)
            r5.<init>(r6, r4)     // Catch:{ Exception -> 0x00b6 }
            android.app.job.JobInfo$Builder r4 = r5.setRequiresCharging(r3)     // Catch:{ Exception -> 0x00b6 }
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.HOURS     // Catch:{ Exception -> 0x00b6 }
            r7 = 30
            long r7 = r5.toMillis(r7)     // Catch:{ Exception -> 0x00b6 }
            android.app.job.JobInfo$Builder r4 = r4.setOverrideDeadline(r7)     // Catch:{ Exception -> 0x00b6 }
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MINUTES     // Catch:{ Exception -> 0x00b6 }
            long r7 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getIntervalTimeForScheduleDeletionFromConfig()     // Catch:{ Exception -> 0x00b6 }
            long r7 = r5.toMillis(r7)     // Catch:{ Exception -> 0x00b6 }
            android.app.job.JobInfo$Builder r4 = r4.setMinimumLatency(r7)     // Catch:{ Exception -> 0x00b6 }
            android.app.job.JobInfo$Builder r4 = r4.setPersisted(r3)     // Catch:{ Exception -> 0x00b6 }
            android.app.job.JobInfo r4 = r4.build()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r5 = "jobscheduler"
            java.lang.Object r10 = r10.getSystemService(r5)     // Catch:{ Exception -> 0x00b6 }
            android.app.job.JobScheduler r10 = (android.app.job.JobScheduler) r10     // Catch:{ Exception -> 0x00b6 }
            if (r10 == 0) goto L_0x009f
            java.util.List r5 = r10.getAllPendingJobs()     // Catch:{ Exception -> 0x00b6 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x00b6 }
        L_0x006d:
            boolean r7 = r5.hasNext()     // Catch:{ Exception -> 0x00b6 }
            if (r7 == 0) goto L_0x0094
            java.lang.Object r7 = r5.next()     // Catch:{ Exception -> 0x00b6 }
            android.app.job.JobInfo r7 = (android.app.job.JobInfo) r7     // Catch:{ Exception -> 0x00b6 }
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r9 = "Job status!"
            r8[r2] = r9     // Catch:{ Exception -> 0x00b6 }
            int r9 = r7.getId()     // Catch:{ Exception -> 0x00b6 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x00b6 }
            r8[r3] = r9     // Catch:{ Exception -> 0x00b6 }
            com.mpl.androidapp.utils.MLogger.d(r0, r8)     // Catch:{ Exception -> 0x00b6 }
            int r7 = r7.getId()     // Catch:{ Exception -> 0x00b6 }
            if (r7 != r6) goto L_0x006d
            r5 = 1
            goto L_0x0095
        L_0x0094:
            r5 = 0
        L_0x0095:
            if (r5 != 0) goto L_0x009f
            r10.cancel(r6)     // Catch:{ Exception -> 0x00b6 }
            int r10 = r10.schedule(r4)     // Catch:{ Exception -> 0x00b6 }
            goto L_0x00a0
        L_0x009f:
            r10 = 0
        L_0x00a0:
            if (r10 != r3) goto L_0x00ac
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r4 = "Job scheduled!"
            r10[r2] = r4     // Catch:{ Exception -> 0x00b6 }
            com.mpl.androidapp.utils.MLogger.d(r0, r10)     // Catch:{ Exception -> 0x00b6 }
            goto L_0x00c2
        L_0x00ac:
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r4 = "Job not scheduled"
            r10[r2] = r4     // Catch:{ Exception -> 0x00b6 }
            com.mpl.androidapp.utils.MLogger.d(r0, r10)     // Catch:{ Exception -> 0x00b6 }
            goto L_0x00c2
        L_0x00b6:
            r10 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r4 = "scheduleJob: "
            r1[r2] = r4
            r1[r3] = r10
            com.mpl.androidapp.utils.MLogger.e(r0, r1)
        L_0x00c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.job.JobSchedulerHelper.scheduleJob(android.content.Context):void");
    }

    public static void startBackgroundTask(Context context) {
        createOrResetJobScheduler(context);
    }
}

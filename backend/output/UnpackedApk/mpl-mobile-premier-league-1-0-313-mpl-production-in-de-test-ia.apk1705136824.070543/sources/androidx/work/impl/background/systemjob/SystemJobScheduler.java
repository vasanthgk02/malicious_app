package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.core.widget.CompoundButtonCompat;
import androidx.room.RoomSQLiteQuery;
import androidx.work.Logger;
import androidx.work.WorkInfo$State;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class SystemJobScheduler implements Scheduler {
    public static final String TAG = Logger.tagWithPrefix("SystemJobScheduler");
    public final Context mContext;
    public final JobScheduler mJobScheduler;
    public final SystemJobInfoConverter mSystemJobInfoConverter;
    public final WorkManagerImpl mWorkManager;

    public SystemJobScheduler(Context context, WorkManagerImpl workManagerImpl) {
        SystemJobInfoConverter systemJobInfoConverter = new SystemJobInfoConverter(context);
        this.mContext = context;
        this.mWorkManager = workManagerImpl;
        this.mJobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        this.mSystemJobInfoConverter = systemJobInfoConverter;
    }

    public static void cancelAll(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            List<JobInfo> pendingJobs = getPendingJobs(context, jobScheduler);
            if (pendingJobs != null && !pendingJobs.isEmpty()) {
                for (JobInfo id : pendingJobs) {
                    cancelJobById(jobScheduler, id.getId());
                }
            }
        }
    }

    public static void cancelJobById(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            Logger.get().error(TAG, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", new Object[]{Integer.valueOf(i)}), th);
        }
    }

    public static List<Integer> getPendingJobIds(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> pendingJobs = getPendingJobs(context, jobScheduler);
        if (pendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo next : pendingJobs) {
            if (str.equals(getWorkSpecIdFromJobInfo(next))) {
                arrayList.add(Integer.valueOf(next.getId()));
            }
        }
        return arrayList;
    }

    public static List<JobInfo> getPendingJobs(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            Logger.get().error(TAG, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo jobInfo : list) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    public static String getWorkSpecIdFromJobInfo(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras != null) {
            try {
                if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                    return extras.getString("EXTRA_WORK_SPEC_ID");
                }
            } catch (NullPointerException unused) {
            }
        }
        return null;
    }

    public static boolean reconcileJobs(Context context, WorkManagerImpl workManagerImpl) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> pendingJobs = getPendingJobs(context, jobScheduler);
        SystemIdInfoDao_Impl systemIdInfoDao_Impl = (SystemIdInfoDao_Impl) workManagerImpl.mWorkDatabase.systemIdInfoDao();
        if (systemIdInfoDao_Impl != null) {
            boolean z = false;
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
            systemIdInfoDao_Impl.__db.assertNotSuspendingTransaction();
            Cursor query = CompoundButtonCompat.query(systemIdInfoDao_Impl.__db, acquire, false, null);
            try {
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(query.getString(0));
                }
                HashSet hashSet = new HashSet(pendingJobs != null ? pendingJobs.size() : 0);
                if (pendingJobs != null && !pendingJobs.isEmpty()) {
                    for (JobInfo next : pendingJobs) {
                        String workSpecIdFromJobInfo = getWorkSpecIdFromJobInfo(next);
                        if (!TextUtils.isEmpty(workSpecIdFromJobInfo)) {
                            hashSet.add(workSpecIdFromJobInfo);
                        } else {
                            cancelJobById(jobScheduler, next.getId());
                        }
                    }
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!hashSet.contains((String) it.next())) {
                            Logger.get().debug(TAG, "Reconciling jobs", new Throwable[0]);
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z) {
                    WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
                    workDatabase.beginTransaction();
                    try {
                        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            ((WorkSpecDao_Impl) workSpecDao).markWorkSpecScheduled((String) it2.next(), -1);
                        }
                        workDatabase.setTransactionSuccessful();
                    } finally {
                        workDatabase.endTransaction();
                    }
                }
                return z;
            } finally {
                query.close();
                acquire.release();
            }
        } else {
            throw null;
        }
    }

    public void cancel(String str) {
        List<Integer> pendingJobIds = getPendingJobIds(this.mContext, this.mJobScheduler, str);
        if (pendingJobIds != null && !pendingJobIds.isEmpty()) {
            for (Integer intValue : pendingJobIds) {
                cancelJobById(this.mJobScheduler, intValue.intValue());
            }
            ((SystemIdInfoDao_Impl) this.mWorkManager.mWorkDatabase.systemIdInfoDao()).removeSystemIdInfo(str);
        }
    }

    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    /* JADX INFO: finally extract failed */
    public void schedule(WorkSpec... workSpecArr) {
        int i;
        int i2;
        WorkDatabase workDatabase = this.mWorkManager.mWorkDatabase;
        IdGenerator idGenerator = new IdGenerator(workDatabase);
        int length = workSpecArr.length;
        int i3 = 0;
        while (i3 < length) {
            WorkSpec workSpec = workSpecArr[i3];
            workDatabase.beginTransaction();
            try {
                WorkSpec workSpec2 = ((WorkSpecDao_Impl) workDatabase.workSpecDao()).getWorkSpec(workSpec.id);
                if (workSpec2 == null) {
                    Logger logger = Logger.get();
                    String str = TAG;
                    logger.warning(str, "Skipping scheduling " + workSpec.id + " because it's no longer in the DB", new Throwable[0]);
                    workDatabase.setTransactionSuccessful();
                } else if (workSpec2.state != WorkInfo$State.ENQUEUED) {
                    Logger logger2 = Logger.get();
                    String str2 = TAG;
                    logger2.warning(str2, "Skipping scheduling " + workSpec.id + " because it is no longer enqueued", new Throwable[0]);
                    workDatabase.setTransactionSuccessful();
                } else {
                    SystemIdInfo systemIdInfo = ((SystemIdInfoDao_Impl) workDatabase.systemIdInfoDao()).getSystemIdInfo(workSpec.id);
                    if (systemIdInfo != null) {
                        i = systemIdInfo.systemId;
                    } else {
                        i = idGenerator.nextJobSchedulerIdWithRange(this.mWorkManager.mConfiguration.mMinJobSchedulerId, this.mWorkManager.mConfiguration.mMaxJobSchedulerId);
                    }
                    if (systemIdInfo == null) {
                        ((SystemIdInfoDao_Impl) this.mWorkManager.mWorkDatabase.systemIdInfoDao()).insertSystemIdInfo(new SystemIdInfo(workSpec.id, i));
                    }
                    scheduleInternal(workSpec, i);
                    if (VERSION.SDK_INT == 23) {
                        List<Integer> pendingJobIds = getPendingJobIds(this.mContext, this.mJobScheduler, workSpec.id);
                        if (pendingJobIds != null) {
                            int indexOf = pendingJobIds.indexOf(Integer.valueOf(i));
                            if (indexOf >= 0) {
                                pendingJobIds.remove(indexOf);
                            }
                            if (!pendingJobIds.isEmpty()) {
                                i2 = pendingJobIds.get(0).intValue();
                            } else {
                                i2 = idGenerator.nextJobSchedulerIdWithRange(this.mWorkManager.mConfiguration.mMinJobSchedulerId, this.mWorkManager.mConfiguration.mMaxJobSchedulerId);
                            }
                            scheduleInternal(workSpec, i2);
                        }
                    }
                    workDatabase.setTransactionSuccessful();
                }
                workDatabase.endTransaction();
                i3++;
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (android.os.Build.VERSION.SDK_INT < 26) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void scheduleInternal(androidx.work.impl.model.WorkSpec r17, int r18) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            androidx.work.impl.background.systemjob.SystemJobInfoConverter r0 = r1.mSystemJobInfoConverter
            if (r0 == 0) goto L_0x01a4
            androidx.work.Constraints r3 = r2.constraints
            androidx.work.NetworkType r4 = r3.mRequiredNetworkType
            int r5 = r4.ordinal()
            r6 = 26
            r7 = 24
            r8 = 2
            r9 = 3
            r10 = 1
            r11 = 0
            if (r5 == 0) goto L_0x0049
            if (r5 == r10) goto L_0x0047
            if (r5 == r8) goto L_0x0045
            if (r5 == r9) goto L_0x0029
            r12 = 4
            if (r5 == r12) goto L_0x0024
            goto L_0x002f
        L_0x0024:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r6) goto L_0x002f
            goto L_0x004a
        L_0x0029:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r7) goto L_0x002f
            r12 = 3
            goto L_0x004a
        L_0x002f:
            androidx.work.Logger r5 = androidx.work.Logger.get()
            java.lang.String r12 = androidx.work.impl.background.systemjob.SystemJobInfoConverter.TAG
            java.lang.Object[] r13 = new java.lang.Object[r10]
            r13[r11] = r4
            java.lang.String r4 = "API version too low. Cannot convert network type value %s"
            java.lang.String r4 = java.lang.String.format(r4, r13)
            java.lang.Throwable[] r13 = new java.lang.Throwable[r11]
            r5.debug(r12, r4, r13)
            goto L_0x0047
        L_0x0045:
            r12 = 2
            goto L_0x004a
        L_0x0047:
            r12 = 1
            goto L_0x004a
        L_0x0049:
            r12 = 0
        L_0x004a:
            android.os.PersistableBundle r4 = new android.os.PersistableBundle
            r4.<init>()
            java.lang.String r5 = r2.id
            java.lang.String r13 = "EXTRA_WORK_SPEC_ID"
            r4.putString(r13, r5)
            boolean r5 = r17.isPeriodic()
            java.lang.String r13 = "EXTRA_IS_PERIODIC"
            r4.putBoolean(r13, r5)
            android.app.job.JobInfo$Builder r5 = new android.app.job.JobInfo$Builder
            android.content.ComponentName r0 = r0.mWorkServiceComponent
            r13 = r18
            r5.<init>(r13, r0)
            android.app.job.JobInfo$Builder r0 = r5.setRequiredNetworkType(r12)
            boolean r5 = r3.mRequiresCharging
            android.app.job.JobInfo$Builder r0 = r0.setRequiresCharging(r5)
            boolean r5 = r3.mRequiresDeviceIdle
            android.app.job.JobInfo$Builder r0 = r0.setRequiresDeviceIdle(r5)
            android.app.job.JobInfo$Builder r0 = r0.setExtras(r4)
            boolean r4 = r3.mRequiresDeviceIdle
            if (r4 != 0) goto L_0x008e
            androidx.work.BackoffPolicy r4 = r2.backoffPolicy
            androidx.work.BackoffPolicy r5 = androidx.work.BackoffPolicy.LINEAR
            if (r4 != r5) goto L_0x0088
            r4 = 0
            goto L_0x0089
        L_0x0088:
            r4 = 1
        L_0x0089:
            long r14 = r2.backoffDelayDuration
            r0.setBackoffCriteria(r14, r4)
        L_0x008e:
            long r4 = r17.calculateNextRunTime()
            long r14 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r14
            r14 = 0
            long r4 = java.lang.Math.max(r4, r14)
            int r12 = android.os.Build.VERSION.SDK_INT
            r9 = 28
            if (r12 > r9) goto L_0x00a7
            r0.setMinimumLatency(r4)
            goto L_0x00b2
        L_0x00a7:
            int r9 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x00af
            r0.setMinimumLatency(r4)
            goto L_0x00b2
        L_0x00af:
            r0.setImportantWhileForeground(r10)
        L_0x00b2:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r7) goto L_0x00ee
            androidx.work.ContentUriTriggers r4 = r3.mContentUriTriggers
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x00c0
            r4 = 1
            goto L_0x00c1
        L_0x00c0:
            r4 = 0
        L_0x00c1:
            if (r4 == 0) goto L_0x00ee
            androidx.work.ContentUriTriggers r4 = r3.mContentUriTriggers
            java.util.Set<androidx.work.ContentUriTriggers$Trigger> r4 = r4.mTriggers
            java.util.Iterator r4 = r4.iterator()
        L_0x00cb:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00e4
            java.lang.Object r5 = r4.next()
            androidx.work.ContentUriTriggers$Trigger r5 = (androidx.work.ContentUriTriggers.Trigger) r5
            boolean r7 = r5.mTriggerForDescendants
            android.app.job.JobInfo$TriggerContentUri r9 = new android.app.job.JobInfo$TriggerContentUri
            android.net.Uri r5 = r5.mUri
            r9.<init>(r5, r7)
            r0.addTriggerContentUri(r9)
            goto L_0x00cb
        L_0x00e4:
            long r4 = r3.mTriggerContentUpdateDelay
            r0.setTriggerContentUpdateDelay(r4)
            long r4 = r3.mTriggerMaxContentDelay
            r0.setTriggerContentMaxDelay(r4)
        L_0x00ee:
            r0.setPersisted(r11)
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r6) goto L_0x00ff
            boolean r4 = r3.mRequiresBatteryNotLow
            r0.setRequiresBatteryNotLow(r4)
            boolean r3 = r3.mRequiresStorageNotLow
            r0.setRequiresStorageNotLow(r3)
        L_0x00ff:
            android.app.job.JobInfo r0 = r0.build()
            androidx.work.Logger r3 = androidx.work.Logger.get()
            java.lang.String r4 = TAG
            java.lang.Object[] r5 = new java.lang.Object[r8]
            java.lang.String r6 = r2.id
            r5[r11] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r18)
            r5[r10] = r6
            java.lang.String r6 = "Scheduling work ID %s Job ID %s"
            java.lang.String r5 = java.lang.String.format(r6, r5)
            java.lang.Throwable[] r6 = new java.lang.Throwable[r11]
            r3.debug(r4, r5, r6)
            android.app.job.JobScheduler r3 = r1.mJobScheduler     // Catch:{ IllegalStateException -> 0x013f, all -> 0x0126 }
            r3.schedule(r0)     // Catch:{ IllegalStateException -> 0x013f, all -> 0x0126 }
            goto L_0x013e
        L_0x0126:
            r0 = move-exception
            androidx.work.Logger r3 = androidx.work.Logger.get()
            java.lang.String r4 = TAG
            java.lang.Object[] r5 = new java.lang.Object[r10]
            r5[r11] = r2
            java.lang.String r2 = "Unable to schedule %s"
            java.lang.String r2 = java.lang.String.format(r2, r5)
            java.lang.Throwable[] r5 = new java.lang.Throwable[r10]
            r5[r11] = r0
            r3.error(r4, r2, r5)
        L_0x013e:
            return
        L_0x013f:
            r0 = move-exception
            android.content.Context r2 = r1.mContext
            android.app.job.JobScheduler r3 = r1.mJobScheduler
            java.util.List r2 = getPendingJobs(r2, r3)
            if (r2 == 0) goto L_0x014f
            int r2 = r2.size()
            goto L_0x0150
        L_0x014f:
            r2 = 0
        L_0x0150:
            java.util.Locale r3 = java.util.Locale.getDefault()
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4[r11] = r2
            androidx.work.impl.WorkManagerImpl r2 = r1.mWorkManager
            androidx.work.impl.WorkDatabase r2 = r2.mWorkDatabase
            androidx.work.impl.model.WorkSpecDao r2 = r2.workSpecDao()
            androidx.work.impl.model.WorkSpecDao_Impl r2 = (androidx.work.impl.model.WorkSpecDao_Impl) r2
            java.util.List r2 = r2.getScheduledWork()
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r2 = r2.size()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4[r10] = r2
            androidx.work.impl.WorkManagerImpl r2 = r1.mWorkManager
            androidx.work.Configuration r2 = r2.mConfiguration
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 23
            if (r5 != r6) goto L_0x0185
            int r2 = r2.mMaxSchedulerLimit
            int r2 = r2 / r8
            goto L_0x0187
        L_0x0185:
            int r2 = r2.mMaxSchedulerLimit
        L_0x0187:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4[r8] = r2
            java.lang.String r2 = "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d."
            java.lang.String r2 = java.lang.String.format(r3, r2, r4)
            androidx.work.Logger r3 = androidx.work.Logger.get()
            java.lang.String r4 = TAG
            java.lang.Throwable[] r5 = new java.lang.Throwable[r11]
            r3.error(r4, r2, r5)
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            r3.<init>(r2, r0)
            throw r3
        L_0x01a4:
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobScheduler.scheduleInternal(androidx.work.impl.model.WorkSpec, int):void");
    }
}

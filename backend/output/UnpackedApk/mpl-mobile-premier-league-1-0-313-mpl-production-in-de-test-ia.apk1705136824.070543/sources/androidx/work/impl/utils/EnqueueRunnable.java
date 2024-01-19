package androidx.work.impl.utils;

import androidx.work.Constraints;
import androidx.work.Data.Builder;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.Operation.State.FAILURE;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.HashSet;

public class EnqueueRunnable implements Runnable {
    public static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");
    public final OperationImpl mOperation = new OperationImpl();
    public final WorkContinuationImpl mWorkContinuation;

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl) {
        this.mWorkContinuation = workContinuationImpl;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r13v20, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r13v21, types: [java.util.List] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0212  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean processContinuation(androidx.work.impl.WorkContinuationImpl r22) {
        /*
            r0 = r22
            java.util.List<androidx.work.impl.WorkContinuationImpl> r1 = r0.mParents
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0041
            java.util.Iterator r1 = r1.iterator()
            r4 = 0
        L_0x000d:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0042
            java.lang.Object r5 = r1.next()
            androidx.work.impl.WorkContinuationImpl r5 = (androidx.work.impl.WorkContinuationImpl) r5
            boolean r6 = r5.mEnqueued
            if (r6 != 0) goto L_0x0023
            boolean r5 = processContinuation(r5)
            r4 = r4 | r5
            goto L_0x000d
        L_0x0023:
            androidx.work.Logger r6 = androidx.work.Logger.get()
            java.lang.String r7 = TAG
            java.lang.Object[] r8 = new java.lang.Object[r2]
            java.util.List<java.lang.String> r5 = r5.mIds
            java.lang.String r9 = ", "
            java.lang.String r5 = android.text.TextUtils.join(r9, r5)
            r8[r3] = r5
            java.lang.String r5 = "Already enqueued work ids (%s)."
            java.lang.String r5 = java.lang.String.format(r5, r8)
            java.lang.Throwable[] r8 = new java.lang.Throwable[r3]
            r6.warning(r7, r5, r8)
            goto L_0x000d
        L_0x0041:
            r4 = 0
        L_0x0042:
            java.util.Set r1 = androidx.work.impl.WorkContinuationImpl.prerequisitesFor(r22)
            androidx.work.impl.WorkManagerImpl r5 = r0.mWorkManagerImpl
            java.util.List<? extends androidx.work.WorkRequest> r6 = r0.mWork
            java.lang.String[] r7 = new java.lang.String[r3]
            java.util.AbstractCollection r1 = (java.util.AbstractCollection) r1
            java.lang.Object[] r1 = r1.toArray(r7)
            java.lang.String[] r1 = (java.lang.String[]) r1
            java.lang.String r7 = r0.mName
            androidx.work.ExistingWorkPolicy r8 = r0.mExistingWorkPolicy
            long r9 = java.lang.System.currentTimeMillis()
            androidx.work.impl.WorkDatabase r11 = r5.mWorkDatabase
            if (r1 == 0) goto L_0x0065
            int r12 = r1.length
            if (r12 <= 0) goto L_0x0065
            r12 = 1
            goto L_0x0066
        L_0x0065:
            r12 = 0
        L_0x0066:
            if (r12 == 0) goto L_0x00b6
            int r13 = r1.length
            r14 = 0
            r15 = 1
            r16 = 0
            r17 = 0
        L_0x006f:
            if (r14 >= r13) goto L_0x00bb
            r3 = r1[r14]
            androidx.work.impl.model.WorkSpecDao r19 = r11.workSpecDao()
            r2 = r19
            androidx.work.impl.model.WorkSpecDao_Impl r2 = (androidx.work.impl.model.WorkSpecDao_Impl) r2
            androidx.work.impl.model.WorkSpec r2 = r2.getWorkSpec(r3)
            if (r2 != 0) goto L_0x009a
            androidx.work.Logger r1 = androidx.work.Logger.get()
            java.lang.String r2 = TAG
            r5 = 1
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r5 = 0
            r6[r5] = r3
            java.lang.String r3 = "Prerequisite %s doesn't exist; not enqueuing"
            java.lang.String r3 = java.lang.String.format(r3, r6)
            java.lang.Throwable[] r6 = new java.lang.Throwable[r5]
            r1.error(r2, r3, r6)
            goto L_0x0103
        L_0x009a:
            androidx.work.WorkInfo$State r2 = r2.state
            androidx.work.WorkInfo$State r3 = androidx.work.WorkInfo$State.SUCCEEDED
            if (r2 != r3) goto L_0x00a2
            r3 = 1
            goto L_0x00a3
        L_0x00a2:
            r3 = 0
        L_0x00a3:
            r15 = r15 & r3
            androidx.work.WorkInfo$State r3 = androidx.work.WorkInfo$State.FAILED
            if (r2 != r3) goto L_0x00ab
            r16 = 1
            goto L_0x00b1
        L_0x00ab:
            androidx.work.WorkInfo$State r3 = androidx.work.WorkInfo$State.CANCELLED
            if (r2 != r3) goto L_0x00b1
            r17 = 1
        L_0x00b1:
            int r14 = r14 + 1
            r2 = 1
            r3 = 0
            goto L_0x006f
        L_0x00b6:
            r15 = 1
            r16 = 0
            r17 = 0
        L_0x00bb:
            boolean r2 = android.text.TextUtils.isEmpty(r7)
            r3 = 1
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x00c7
            if (r12 != 0) goto L_0x00c7
            r3 = 1
            goto L_0x00c8
        L_0x00c7:
            r3 = 0
        L_0x00c8:
            if (r3 == 0) goto L_0x0204
            androidx.work.impl.model.WorkSpecDao r3 = r11.workSpecDao()
            androidx.work.impl.model.WorkSpecDao_Impl r3 = (androidx.work.impl.model.WorkSpecDao_Impl) r3
            java.util.List r3 = r3.getWorkSpecIdAndStatesForName(r7)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            boolean r13 = r3.isEmpty()
            if (r13 != 0) goto L_0x0204
            androidx.work.ExistingWorkPolicy r13 = androidx.work.ExistingWorkPolicy.APPEND
            if (r8 == r13) goto L_0x0135
            androidx.work.ExistingWorkPolicy r13 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r8 != r13) goto L_0x00e5
            goto L_0x0135
        L_0x00e5:
            androidx.work.ExistingWorkPolicy r13 = androidx.work.ExistingWorkPolicy.KEEP
            if (r8 != r13) goto L_0x0109
            java.util.Iterator r8 = r3.iterator()
        L_0x00ed:
            boolean r13 = r8.hasNext()
            if (r13 == 0) goto L_0x0109
            java.lang.Object r13 = r8.next()
            androidx.work.impl.model.WorkSpec$IdAndState r13 = (androidx.work.impl.model.WorkSpec.IdAndState) r13
            androidx.work.WorkInfo$State r13 = r13.state
            androidx.work.WorkInfo$State r14 = androidx.work.WorkInfo$State.ENQUEUED
            if (r13 == r14) goto L_0x0103
            androidx.work.WorkInfo$State r14 = androidx.work.WorkInfo$State.RUNNING
            if (r13 != r14) goto L_0x00ed
        L_0x0103:
            r20 = r4
            r1 = 1
            r3 = 0
            goto L_0x036a
        L_0x0109:
            androidx.work.impl.utils.CancelWorkRunnable$3 r8 = new androidx.work.impl.utils.CancelWorkRunnable$3
            r13 = 0
            r8.<init>(r7, r13)
            r8.run()
            androidx.work.impl.model.WorkSpecDao r8 = r11.workSpecDao()
            java.util.Iterator r3 = r3.iterator()
        L_0x011a:
            boolean r13 = r3.hasNext()
            if (r13 == 0) goto L_0x012f
            java.lang.Object r13 = r3.next()
            androidx.work.impl.model.WorkSpec$IdAndState r13 = (androidx.work.impl.model.WorkSpec.IdAndState) r13
            java.lang.String r13 = r13.id
            r14 = r8
            androidx.work.impl.model.WorkSpecDao_Impl r14 = (androidx.work.impl.model.WorkSpecDao_Impl) r14
            r14.delete(r13)
            goto L_0x011a
        L_0x012f:
            r20 = r4
            r0 = 1
            r3 = 0
            goto L_0x0208
        L_0x0135:
            androidx.work.impl.model.DependencyDao r12 = r11.dependencyDao()
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x0142:
            boolean r14 = r3.hasNext()
            if (r14 == 0) goto L_0x01c1
            java.lang.Object r14 = r3.next()
            androidx.work.impl.model.WorkSpec$IdAndState r14 = (androidx.work.impl.model.WorkSpec.IdAndState) r14
            r19 = r3
            java.lang.String r3 = r14.id
            r20 = r4
            r4 = r12
            androidx.work.impl.model.DependencyDao_Impl r4 = (androidx.work.impl.model.DependencyDao_Impl) r4
            r21 = r12
            if (r4 == 0) goto L_0x01bf
            java.lang.String r12 = "SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?"
            r0 = 1
            androidx.room.RoomSQLiteQuery r12 = androidx.room.RoomSQLiteQuery.acquire(r12, r0)
            if (r3 != 0) goto L_0x0168
            r12.bindNull(r0)
            goto L_0x016b
        L_0x0168:
            r12.bindString(r0, r3)
        L_0x016b:
            androidx.room.RoomDatabase r0 = r4.__db
            r0.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r0 = r4.__db
            r3 = 0
            r4 = 0
            android.database.Cursor r4 = androidx.core.widget.CompoundButtonCompat.query(r0, r12, r3, r4)
            boolean r0 = r4.moveToFirst()     // Catch:{ all -> 0x01b7 }
            if (r0 == 0) goto L_0x0186
            int r0 = r4.getInt(r3)     // Catch:{ all -> 0x01b7 }
            if (r0 == 0) goto L_0x0186
            r0 = 1
            goto L_0x0187
        L_0x0186:
            r0 = 0
        L_0x0187:
            r4.close()
            r12.release()
            if (r0 != 0) goto L_0x01ae
            androidx.work.WorkInfo$State r0 = r14.state
            androidx.work.WorkInfo$State r4 = androidx.work.WorkInfo$State.SUCCEEDED
            if (r0 != r4) goto L_0x0197
            r0 = 1
            goto L_0x0198
        L_0x0197:
            r0 = 0
        L_0x0198:
            r0 = r0 & r15
            androidx.work.WorkInfo$State r4 = r14.state
            androidx.work.WorkInfo$State r12 = androidx.work.WorkInfo$State.FAILED
            if (r4 != r12) goto L_0x01a2
            r16 = 1
            goto L_0x01a8
        L_0x01a2:
            androidx.work.WorkInfo$State r12 = androidx.work.WorkInfo$State.CANCELLED
            if (r4 != r12) goto L_0x01a8
            r17 = 1
        L_0x01a8:
            java.lang.String r4 = r14.id
            r13.add(r4)
            r15 = r0
        L_0x01ae:
            r0 = r22
            r3 = r19
            r4 = r20
            r12 = r21
            goto L_0x0142
        L_0x01b7:
            r0 = move-exception
            r4.close()
            r12.release()
            throw r0
        L_0x01bf:
            r0 = 0
            throw r0
        L_0x01c1:
            r20 = r4
            r3 = 0
            androidx.work.ExistingWorkPolicy r0 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r8 != r0) goto L_0x01f6
            if (r17 != 0) goto L_0x01cc
            if (r16 == 0) goto L_0x01f6
        L_0x01cc:
            androidx.work.impl.model.WorkSpecDao r0 = r11.workSpecDao()
            androidx.work.impl.model.WorkSpecDao_Impl r0 = (androidx.work.impl.model.WorkSpecDao_Impl) r0
            java.util.List r4 = r0.getWorkSpecIdAndStatesForName(r7)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x01dc:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x01ee
            java.lang.Object r8 = r4.next()
            androidx.work.impl.model.WorkSpec$IdAndState r8 = (androidx.work.impl.model.WorkSpec.IdAndState) r8
            java.lang.String r8 = r8.id
            r0.delete(r8)
            goto L_0x01dc
        L_0x01ee:
            java.util.List r13 = java.util.Collections.emptyList()
            r16 = 0
            r17 = 0
        L_0x01f6:
            java.lang.Object[] r0 = r13.toArray(r1)
            r1 = r0
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r0 = r1.length
            if (r0 <= 0) goto L_0x0202
            r12 = 1
            goto L_0x0207
        L_0x0202:
            r12 = 0
            goto L_0x0207
        L_0x0204:
            r20 = r4
            r3 = 0
        L_0x0207:
            r0 = 0
        L_0x0208:
            java.util.Iterator r4 = r6.iterator()
        L_0x020c:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0366
            java.lang.Object r6 = r4.next()
            androidx.work.WorkRequest r6 = (androidx.work.WorkRequest) r6
            androidx.work.impl.model.WorkSpec r8 = r6.mWorkSpec
            if (r12 == 0) goto L_0x0231
            if (r15 != 0) goto L_0x0231
            if (r16 == 0) goto L_0x0225
            androidx.work.WorkInfo$State r13 = androidx.work.WorkInfo$State.FAILED
            r8.state = r13
            goto L_0x023e
        L_0x0225:
            if (r17 == 0) goto L_0x022c
            androidx.work.WorkInfo$State r13 = androidx.work.WorkInfo$State.CANCELLED
            r8.state = r13
            goto L_0x023e
        L_0x022c:
            androidx.work.WorkInfo$State r13 = androidx.work.WorkInfo$State.BLOCKED
            r8.state = r13
            goto L_0x023e
        L_0x0231:
            boolean r13 = r8.isPeriodic()
            if (r13 != 0) goto L_0x023a
            r8.periodStartTime = r9
            goto L_0x023e
        L_0x023a:
            r13 = 0
            r8.periodStartTime = r13
        L_0x023e:
            int r13 = android.os.Build.VERSION.SDK_INT
            r14 = 23
            if (r13 < r14) goto L_0x024c
            r14 = 25
            if (r13 > r14) goto L_0x024c
            tryDelegateConstrainedWorkSpec(r8)
            goto L_0x027e
        L_0x024c:
            int r13 = android.os.Build.VERSION.SDK_INT
            r14 = 22
            if (r13 > r14) goto L_0x027e
            java.lang.String r13 = "androidx.work.impl.background.gcm.GcmScheduler"
            java.lang.Class r13 = java.lang.Class.forName(r13)     // Catch:{ ClassNotFoundException -> 0x0278 }
            java.util.List<androidx.work.impl.Scheduler> r14 = r5.mSchedulers     // Catch:{ ClassNotFoundException -> 0x0278 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ ClassNotFoundException -> 0x0278 }
        L_0x025e:
            boolean r18 = r14.hasNext()     // Catch:{ ClassNotFoundException -> 0x0278 }
            if (r18 == 0) goto L_0x0278
            java.lang.Object r18 = r14.next()     // Catch:{ ClassNotFoundException -> 0x0278 }
            androidx.work.impl.Scheduler r18 = (androidx.work.impl.Scheduler) r18     // Catch:{ ClassNotFoundException -> 0x0278 }
            java.lang.Class r3 = r18.getClass()     // Catch:{ ClassNotFoundException -> 0x0278 }
            boolean r3 = r13.isAssignableFrom(r3)     // Catch:{ ClassNotFoundException -> 0x0278 }
            if (r3 == 0) goto L_0x0276
            r3 = 1
            goto L_0x0279
        L_0x0276:
            r3 = 0
            goto L_0x025e
        L_0x0278:
            r3 = 0
        L_0x0279:
            if (r3 == 0) goto L_0x027e
            tryDelegateConstrainedWorkSpec(r8)
        L_0x027e:
            androidx.work.WorkInfo$State r3 = r8.state
            androidx.work.WorkInfo$State r13 = androidx.work.WorkInfo$State.ENQUEUED
            if (r3 != r13) goto L_0x0285
            r0 = 1
        L_0x0285:
            androidx.work.impl.model.WorkSpecDao r3 = r11.workSpecDao()
            androidx.work.impl.model.WorkSpecDao_Impl r3 = (androidx.work.impl.model.WorkSpecDao_Impl) r3
            androidx.room.RoomDatabase r13 = r3.__db
            r13.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r13 = r3.__db
            r13.beginTransaction()
            androidx.room.EntityInsertionAdapter<androidx.work.impl.model.WorkSpec> r13 = r3.__insertionAdapterOfWorkSpec     // Catch:{ all -> 0x035f }
            r13.insert(r8)     // Catch:{ all -> 0x035f }
            androidx.room.RoomDatabase r8 = r3.__db     // Catch:{ all -> 0x035f }
            r8.setTransactionSuccessful()     // Catch:{ all -> 0x035f }
            androidx.room.RoomDatabase r3 = r3.__db
            r3.endTransaction()
            if (r12 == 0) goto L_0x02e3
            int r3 = r1.length
            r8 = 0
        L_0x02a8:
            if (r8 >= r3) goto L_0x02e3
            r13 = r1[r8]
            androidx.work.impl.model.Dependency r14 = new androidx.work.impl.model.Dependency
            r18 = r0
            java.lang.String r0 = r6.getStringId()
            r14.<init>(r0, r13)
            androidx.work.impl.model.DependencyDao r0 = r11.dependencyDao()
            r13 = r0
            androidx.work.impl.model.DependencyDao_Impl r13 = (androidx.work.impl.model.DependencyDao_Impl) r13
            androidx.room.RoomDatabase r0 = r13.__db
            r0.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r0 = r13.__db
            r0.beginTransaction()
            androidx.room.EntityInsertionAdapter<androidx.work.impl.model.Dependency> r0 = r13.__insertionAdapterOfDependency     // Catch:{ all -> 0x02dc }
            r0.insert(r14)     // Catch:{ all -> 0x02dc }
            androidx.room.RoomDatabase r0 = r13.__db     // Catch:{ all -> 0x02dc }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x02dc }
            androidx.room.RoomDatabase r0 = r13.__db
            r0.endTransaction()
            int r8 = r8 + 1
            r0 = r18
            goto L_0x02a8
        L_0x02dc:
            r0 = move-exception
            androidx.room.RoomDatabase r1 = r13.__db
            r1.endTransaction()
            throw r0
        L_0x02e3:
            r18 = r0
            java.util.Set<java.lang.String> r0 = r6.mTags
            java.util.Iterator r0 = r0.iterator()
        L_0x02eb:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0327
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            androidx.work.impl.model.WorkTagDao r8 = r11.workTagDao()
            androidx.work.impl.model.WorkTag r13 = new androidx.work.impl.model.WorkTag
            java.lang.String r14 = r6.getStringId()
            r13.<init>(r3, r14)
            androidx.work.impl.model.WorkTagDao_Impl r8 = (androidx.work.impl.model.WorkTagDao_Impl) r8
            androidx.room.RoomDatabase r3 = r8.__db
            r3.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r3 = r8.__db
            r3.beginTransaction()
            androidx.room.EntityInsertionAdapter<androidx.work.impl.model.WorkTag> r3 = r8.__insertionAdapterOfWorkTag     // Catch:{ all -> 0x0320 }
            r3.insert(r13)     // Catch:{ all -> 0x0320 }
            androidx.room.RoomDatabase r3 = r8.__db     // Catch:{ all -> 0x0320 }
            r3.setTransactionSuccessful()     // Catch:{ all -> 0x0320 }
            androidx.room.RoomDatabase r3 = r8.__db
            r3.endTransaction()
            goto L_0x02eb
        L_0x0320:
            r0 = move-exception
            androidx.room.RoomDatabase r1 = r8.__db
            r1.endTransaction()
            throw r0
        L_0x0327:
            if (r2 == 0) goto L_0x035a
            androidx.work.impl.model.WorkNameDao r0 = r11.workNameDao()
            androidx.work.impl.model.WorkName r3 = new androidx.work.impl.model.WorkName
            java.lang.String r6 = r6.getStringId()
            r3.<init>(r7, r6)
            r6 = r0
            androidx.work.impl.model.WorkNameDao_Impl r6 = (androidx.work.impl.model.WorkNameDao_Impl) r6
            androidx.room.RoomDatabase r0 = r6.__db
            r0.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r0 = r6.__db
            r0.beginTransaction()
            androidx.room.EntityInsertionAdapter<androidx.work.impl.model.WorkName> r0 = r6.__insertionAdapterOfWorkName     // Catch:{ all -> 0x0353 }
            r0.insert(r3)     // Catch:{ all -> 0x0353 }
            androidx.room.RoomDatabase r0 = r6.__db     // Catch:{ all -> 0x0353 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x0353 }
            androidx.room.RoomDatabase r0 = r6.__db
            r0.endTransaction()
            goto L_0x035a
        L_0x0353:
            r0 = move-exception
            androidx.room.RoomDatabase r1 = r6.__db
            r1.endTransaction()
            throw r0
        L_0x035a:
            r0 = r18
            r3 = 0
            goto L_0x020c
        L_0x035f:
            r0 = move-exception
            androidx.room.RoomDatabase r1 = r3.__db
            r1.endTransaction()
            throw r0
        L_0x0366:
            r1 = 1
            r3 = r0
            r0 = r22
        L_0x036a:
            r0.mEnqueued = r1
            r0 = r20 | r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.processContinuation(androidx.work.impl.WorkContinuationImpl):boolean");
    }

    public static void tryDelegateConstrainedWorkSpec(WorkSpec workSpec) {
        Constraints constraints = workSpec.constraints;
        if (constraints.mRequiresBatteryNotLow || constraints.mRequiresStorageNotLow) {
            String str = workSpec.workerClassName;
            Builder builder = new Builder();
            builder.putAll(workSpec.input.mValues);
            builder.mValues.put("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            workSpec.workerClassName = ConstraintTrackingWorker.class.getName();
            workSpec.input = builder.build();
        }
    }

    public void run() {
        WorkDatabase workDatabase;
        try {
            WorkContinuationImpl workContinuationImpl = this.mWorkContinuation;
            if (workContinuationImpl == null) {
                throw null;
            } else if (!WorkContinuationImpl.hasCycles(workContinuationImpl, new HashSet())) {
                workDatabase = this.mWorkContinuation.mWorkManagerImpl.mWorkDatabase;
                workDatabase.beginTransaction();
                boolean processContinuation = processContinuation(this.mWorkContinuation);
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                if (processContinuation) {
                    PackageManagerHelper.setComponentEnabled(this.mWorkContinuation.mWorkManagerImpl.mContext, RescheduleReceiver.class, true);
                    WorkManagerImpl workManagerImpl = this.mWorkContinuation.mWorkManagerImpl;
                    Schedulers.schedule(workManagerImpl.mConfiguration, workManagerImpl.mWorkDatabase, workManagerImpl.mSchedulers);
                }
                this.mOperation.setState(Operation.SUCCESS);
            } else {
                throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", new Object[]{this.mWorkContinuation}));
            }
        } catch (Throwable th) {
            this.mOperation.setState(new FAILURE(th));
        }
    }
}

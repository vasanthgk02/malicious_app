package androidx.work.impl.workers;

import android.content.Context;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.core.widget.CompoundButtonCompat;
import androidx.room.RoomSQLiteQuery;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker.Result;
import androidx.work.ListenableWorker.Result.Success;
import androidx.work.Logger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTagDao_Impl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DiagnosticsWorker extends Worker {
    public static final String TAG = Logger.tagWithPrefix("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    /* JADX INFO: finally extract failed */
    public static String workSpecRows(WorkNameDao workNameDao, WorkTagDao workTagDao, SystemIdInfoDao systemIdInfoDao, List<WorkSpec> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", new Object[]{VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id"}));
        for (WorkSpec next : list) {
            SystemIdInfo systemIdInfo = ((SystemIdInfoDao_Impl) systemIdInfoDao).getSystemIdInfo(next.id);
            Object valueOf = systemIdInfo != null ? Integer.valueOf(systemIdInfo.systemId) : null;
            String str = next.id;
            WorkNameDao_Impl workNameDao_Impl = (WorkNameDao_Impl) workNameDao;
            if (workNameDao_Impl != null) {
                RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT name FROM workname WHERE work_spec_id=?", 1);
                if (str == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindString(1, str);
                }
                workNameDao_Impl.__db.assertNotSuspendingTransaction();
                Cursor query = CompoundButtonCompat.query(workNameDao_Impl.__db, acquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(query.getString(0));
                    }
                    query.close();
                    acquire.release();
                    sb.append(String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", new Object[]{next.id, next.workerClassName, valueOf, next.state.name(), TextUtils.join(",", arrayList), TextUtils.join(",", ((WorkTagDao_Impl) workTagDao).getTagsForWorkSpecId(next.id))}));
                } catch (Throwable th) {
                    query.close();
                    acquire.release();
                    throw th;
                }
            } else {
                throw null;
            }
        }
        return sb.toString();
    }

    public Result doWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        SystemIdInfoDao systemIdInfoDao;
        WorkTagDao workTagDao;
        WorkNameDao workNameDao;
        int i;
        WorkDatabase workDatabase = WorkManagerImpl.getInstance(getApplicationContext()).mWorkDatabase;
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkNameDao workNameDao2 = workDatabase.workNameDao();
        WorkTagDao workTagDao2 = workDatabase.workTagDao();
        SystemIdInfoDao systemIdInfoDao2 = workDatabase.systemIdInfoDao();
        long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1);
        WorkSpecDao_Impl workSpecDao_Impl = (WorkSpecDao_Impl) workSpecDao;
        if (workSpecDao_Impl != null) {
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
            acquire.bindLong(1, currentTimeMillis);
            workSpecDao_Impl.__db.assertNotSuspendingTransaction();
            Cursor query = CompoundButtonCompat.query(workSpecDao_Impl.__db, acquire, false, null);
            try {
                int columnIndexOrThrow = CompoundButtonCompat.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow2 = CompoundButtonCompat.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow3 = CompoundButtonCompat.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow4 = CompoundButtonCompat.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow5 = CompoundButtonCompat.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow6 = CompoundButtonCompat.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow7 = CompoundButtonCompat.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow8 = CompoundButtonCompat.getColumnIndexOrThrow(query, "content_uri_triggers");
                int columnIndexOrThrow9 = CompoundButtonCompat.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow10 = CompoundButtonCompat.getColumnIndexOrThrow(query, "state");
                SystemIdInfoDao systemIdInfoDao3 = systemIdInfoDao2;
                int columnIndexOrThrow11 = CompoundButtonCompat.getColumnIndexOrThrow(query, "worker_class_name");
                WorkNameDao workNameDao3 = workNameDao2;
                int columnIndexOrThrow12 = CompoundButtonCompat.getColumnIndexOrThrow(query, "input_merger_class_name");
                WorkTagDao workTagDao3 = workTagDao2;
                int columnIndexOrThrow13 = CompoundButtonCompat.getColumnIndexOrThrow(query, "input");
                WorkSpecDao workSpecDao2 = workSpecDao;
                int columnIndexOrThrow14 = CompoundButtonCompat.getColumnIndexOrThrow(query, "output");
                roomSQLiteQuery = acquire;
                try {
                    int columnIndexOrThrow15 = CompoundButtonCompat.getColumnIndexOrThrow(query, "initial_delay");
                    int columnIndexOrThrow16 = CompoundButtonCompat.getColumnIndexOrThrow(query, "interval_duration");
                    int columnIndexOrThrow17 = CompoundButtonCompat.getColumnIndexOrThrow(query, "flex_duration");
                    int columnIndexOrThrow18 = CompoundButtonCompat.getColumnIndexOrThrow(query, "run_attempt_count");
                    int columnIndexOrThrow19 = CompoundButtonCompat.getColumnIndexOrThrow(query, "backoff_policy");
                    int columnIndexOrThrow20 = CompoundButtonCompat.getColumnIndexOrThrow(query, "backoff_delay_duration");
                    int columnIndexOrThrow21 = CompoundButtonCompat.getColumnIndexOrThrow(query, "period_start_time");
                    int columnIndexOrThrow22 = CompoundButtonCompat.getColumnIndexOrThrow(query, "minimum_retention_duration");
                    int columnIndexOrThrow23 = CompoundButtonCompat.getColumnIndexOrThrow(query, "schedule_requested_at");
                    int columnIndexOrThrow24 = CompoundButtonCompat.getColumnIndexOrThrow(query, "run_in_foreground");
                    int i2 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string = query.getString(columnIndexOrThrow9);
                        int i3 = columnIndexOrThrow9;
                        String string2 = query.getString(columnIndexOrThrow11);
                        int i4 = columnIndexOrThrow11;
                        Constraints constraints = new Constraints();
                        int i5 = columnIndexOrThrow;
                        constraints.mRequiredNetworkType = CompoundButtonCompat.intToNetworkType(query.getInt(columnIndexOrThrow));
                        constraints.mRequiresCharging = query.getInt(columnIndexOrThrow2) != 0;
                        constraints.mRequiresDeviceIdle = query.getInt(columnIndexOrThrow3) != 0;
                        constraints.mRequiresBatteryNotLow = query.getInt(columnIndexOrThrow4) != 0;
                        constraints.mRequiresStorageNotLow = query.getInt(columnIndexOrThrow5) != 0;
                        int i6 = columnIndexOrThrow2;
                        constraints.mTriggerContentUpdateDelay = query.getLong(columnIndexOrThrow6);
                        constraints.mTriggerMaxContentDelay = query.getLong(columnIndexOrThrow7);
                        constraints.mContentUriTriggers = CompoundButtonCompat.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8));
                        WorkSpec workSpec = new WorkSpec(string, string2);
                        workSpec.state = CompoundButtonCompat.intToState(query.getInt(columnIndexOrThrow10));
                        workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                        workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                        int i7 = i2;
                        workSpec.output = Data.fromByteArray(query.getBlob(i7));
                        i2 = i7;
                        int i8 = columnIndexOrThrow15;
                        workSpec.initialDelay = query.getLong(i8);
                        int i9 = columnIndexOrThrow13;
                        int i10 = columnIndexOrThrow16;
                        workSpec.intervalDuration = query.getLong(i10);
                        int i11 = columnIndexOrThrow12;
                        int i12 = columnIndexOrThrow3;
                        int i13 = columnIndexOrThrow17;
                        workSpec.flexDuration = query.getLong(i13);
                        int i14 = columnIndexOrThrow18;
                        workSpec.runAttemptCount = query.getInt(i14);
                        int i15 = columnIndexOrThrow19;
                        int i16 = i10;
                        workSpec.backoffPolicy = CompoundButtonCompat.intToBackoffPolicy(query.getInt(i15));
                        columnIndexOrThrow17 = i13;
                        int i17 = i12;
                        int i18 = columnIndexOrThrow20;
                        workSpec.backoffDelayDuration = query.getLong(i18);
                        int i19 = i14;
                        int i20 = i15;
                        int i21 = columnIndexOrThrow21;
                        workSpec.periodStartTime = query.getLong(i21);
                        int i22 = i18;
                        columnIndexOrThrow21 = i21;
                        int i23 = columnIndexOrThrow22;
                        workSpec.minimumRetentionDuration = query.getLong(i23);
                        int i24 = i19;
                        int i25 = columnIndexOrThrow23;
                        workSpec.scheduleRequestedAt = query.getLong(i25);
                        int i26 = columnIndexOrThrow24;
                        workSpec.runInForeground = query.getInt(i26) != 0;
                        workSpec.constraints = constraints;
                        arrayList.add(workSpec);
                        columnIndexOrThrow23 = i25;
                        columnIndexOrThrow24 = i26;
                        columnIndexOrThrow13 = i9;
                        columnIndexOrThrow12 = i11;
                        columnIndexOrThrow16 = i16;
                        columnIndexOrThrow18 = i24;
                        columnIndexOrThrow11 = i4;
                        columnIndexOrThrow = i5;
                        columnIndexOrThrow15 = i8;
                        columnIndexOrThrow22 = i23;
                        columnIndexOrThrow9 = i3;
                        columnIndexOrThrow2 = i6;
                        int i27 = i20;
                        columnIndexOrThrow20 = i22;
                        columnIndexOrThrow3 = i17;
                        columnIndexOrThrow19 = i27;
                    }
                    query.close();
                    roomSQLiteQuery.release();
                    WorkSpecDao_Impl workSpecDao_Impl2 = (WorkSpecDao_Impl) workSpecDao2;
                    List<WorkSpec> runningWork = workSpecDao_Impl2.getRunningWork();
                    List<WorkSpec> allEligibleWorkSpecsForScheduling = workSpecDao_Impl2.getAllEligibleWorkSpecsForScheduling(200);
                    if (!arrayList.isEmpty()) {
                        i = 0;
                        Logger.get().info(TAG, "Recently completed work:\n\n", new Throwable[0]);
                        systemIdInfoDao = systemIdInfoDao3;
                        workNameDao = workNameDao3;
                        workTagDao = workTagDao3;
                        Logger.get().info(TAG, workSpecRows(workNameDao, workTagDao, systemIdInfoDao, arrayList), new Throwable[0]);
                    } else {
                        systemIdInfoDao = systemIdInfoDao3;
                        workNameDao = workNameDao3;
                        workTagDao = workTagDao3;
                        i = 0;
                    }
                    if (!((ArrayList) runningWork).isEmpty()) {
                        Logger.get().info(TAG, "Running work:\n\n", new Throwable[i]);
                        Logger.get().info(TAG, workSpecRows(workNameDao, workTagDao, systemIdInfoDao, runningWork), new Throwable[i]);
                    }
                    if (!((ArrayList) allEligibleWorkSpecsForScheduling).isEmpty()) {
                        Logger.get().info(TAG, "Enqueued work:\n\n", new Throwable[i]);
                        Logger.get().info(TAG, workSpecRows(workNameDao, workTagDao, systemIdInfoDao, allEligibleWorkSpecsForScheduling), new Throwable[i]);
                    }
                    return new Success();
                } catch (Throwable th) {
                    th = th;
                    query.close();
                    roomSQLiteQuery.release();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                roomSQLiteQuery = acquire;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } else {
            throw null;
        }
    }
}

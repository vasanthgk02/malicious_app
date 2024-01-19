package androidx.work.impl.model;

import android.database.Cursor;
import androidx.core.widget.CompoundButtonCompat;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkInfo$State;
import androidx.work.impl.model.WorkSpec.IdAndState;
import com.facebook.react.bridge.ColorPropConverter;
import java.util.ArrayList;
import java.util.List;

public final class WorkSpecDao_Impl implements WorkSpecDao {
    public final RoomDatabase __db;
    public final EntityInsertionAdapter<WorkSpec> __insertionAdapterOfWorkSpec;
    public final SharedSQLiteStatement __preparedStmtOfDelete;
    public final SharedSQLiteStatement __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    public final SharedSQLiteStatement __preparedStmtOfMarkWorkSpecScheduled;
    public final SharedSQLiteStatement __preparedStmtOfResetScheduledState;
    public final SharedSQLiteStatement __preparedStmtOfResetWorkSpecRunAttemptCount;
    public final SharedSQLiteStatement __preparedStmtOfSetOutput;
    public final SharedSQLiteStatement __preparedStmtOfSetPeriodStartTime;

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWorkSpec = new EntityInsertionAdapter<WorkSpec>(this, roomDatabase) {
            /* JADX WARNING: type inference failed for: r3v1 */
            /* JADX WARNING: type inference failed for: r3v2, types: [byte[]] */
            /* JADX WARNING: type inference failed for: r4v20, types: [java.io.ObjectOutputStream] */
            /* JADX WARNING: type inference failed for: r3v4, types: [byte[]] */
            /* JADX WARNING: type inference failed for: r3v7, types: [java.io.ObjectOutputStream] */
            /* JADX WARNING: type inference failed for: r4v21 */
            /* JADX WARNING: type inference failed for: r4v22, types: [java.io.ObjectOutputStream] */
            /* JADX WARNING: type inference failed for: r3v8 */
            /* JADX WARNING: type inference failed for: r3v17 */
            /* JADX WARNING: type inference failed for: r4v25 */
            /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v1
              assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY], byte[]]
              uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], byte[], java.io.ObjectOutputStream, ?[OBJECT, ARRAY]]
              mth insns count: 169
            	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
             */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x0179 A[SYNTHETIC, Splitter:B:62:0x0179] */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x0191  */
            /* JADX WARNING: Removed duplicated region for block: B:73:0x0197  */
            /* JADX WARNING: Removed duplicated region for block: B:76:0x01a1 A[SYNTHETIC, Splitter:B:76:0x01a1] */
            /* JADX WARNING: Unknown variable types count: 3 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void bind(androidx.sqlite.db.SupportSQLiteStatement r17, java.lang.Object r18) {
                /*
                    r16 = this;
                    r1 = r17
                    r0 = r18
                    androidx.work.impl.model.WorkSpec r0 = (androidx.work.impl.model.WorkSpec) r0
                    java.lang.String r2 = r0.id
                    r3 = 1
                    if (r2 != 0) goto L_0x000f
                    r1.bindNull(r3)
                    goto L_0x0012
                L_0x000f:
                    r1.bindString(r3, r2)
                L_0x0012:
                    androidx.work.WorkInfo$State r2 = r0.state
                    int r2 = androidx.core.widget.CompoundButtonCompat.stateToInt(r2)
                    long r4 = (long) r2
                    r2 = 2
                    r1.bindLong(r2, r4)
                    java.lang.String r4 = r0.workerClassName
                    r5 = 3
                    if (r4 != 0) goto L_0x0026
                    r1.bindNull(r5)
                    goto L_0x0029
                L_0x0026:
                    r1.bindString(r5, r4)
                L_0x0029:
                    java.lang.String r4 = r0.inputMergerClassName
                    r6 = 4
                    if (r4 != 0) goto L_0x0032
                    r1.bindNull(r6)
                    goto L_0x0035
                L_0x0032:
                    r1.bindString(r6, r4)
                L_0x0035:
                    androidx.work.Data r4 = r0.input
                    byte[] r4 = androidx.work.Data.toByteArrayInternal(r4)
                    r7 = 5
                    if (r4 != 0) goto L_0x0042
                    r1.bindNull(r7)
                    goto L_0x0045
                L_0x0042:
                    r1.bindBlob(r7, r4)
                L_0x0045:
                    androidx.work.Data r4 = r0.output
                    byte[] r4 = androidx.work.Data.toByteArrayInternal(r4)
                    r7 = 6
                    if (r4 != 0) goto L_0x0052
                    r1.bindNull(r7)
                    goto L_0x0055
                L_0x0052:
                    r1.bindBlob(r7, r4)
                L_0x0055:
                    r4 = 7
                    long r7 = r0.initialDelay
                    r1.bindLong(r4, r7)
                    r4 = 8
                    long r7 = r0.intervalDuration
                    r1.bindLong(r4, r7)
                    r4 = 9
                    long r7 = r0.flexDuration
                    r1.bindLong(r4, r7)
                    r4 = 10
                    int r7 = r0.runAttemptCount
                    long r7 = (long) r7
                    r1.bindLong(r4, r7)
                    androidx.work.BackoffPolicy r4 = r0.backoffPolicy
                    int r7 = r4.ordinal()
                    java.lang.String r8 = " to int"
                    java.lang.String r9 = "Could not convert "
                    if (r7 == 0) goto L_0x0099
                    if (r7 != r3) goto L_0x0081
                    r4 = 1
                    goto L_0x009a
                L_0x0081:
                    java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    r1.append(r9)
                    r1.append(r4)
                    r1.append(r8)
                    java.lang.String r1 = r1.toString()
                    r0.<init>(r1)
                    throw r0
                L_0x0099:
                    r4 = 0
                L_0x009a:
                    r7 = 11
                    long r11 = (long) r4
                    r1.bindLong(r7, r11)
                    r4 = 12
                    long r11 = r0.backoffDelayDuration
                    r1.bindLong(r4, r11)
                    r4 = 13
                    long r11 = r0.periodStartTime
                    r1.bindLong(r4, r11)
                    r4 = 14
                    long r11 = r0.minimumRetentionDuration
                    r1.bindLong(r4, r11)
                    r4 = 15
                    long r11 = r0.scheduleRequestedAt
                    r1.bindLong(r4, r11)
                    boolean r4 = r0.runInForeground
                    r7 = 16
                    long r11 = (long) r4
                    r1.bindLong(r7, r11)
                    androidx.work.Constraints r0 = r0.constraints
                    r4 = 22
                    r7 = 21
                    r11 = 20
                    r12 = 19
                    r13 = 18
                    r14 = 17
                    if (r0 == 0) goto L_0x01b4
                    androidx.work.NetworkType r10 = r0.mRequiredNetworkType
                    int r15 = r10.ordinal()
                    if (r15 == 0) goto L_0x0102
                    if (r15 == r3) goto L_0x0100
                    if (r15 == r2) goto L_0x00ff
                    if (r15 == r5) goto L_0x00fd
                    if (r15 != r6) goto L_0x00e5
                    goto L_0x0103
                L_0x00e5:
                    java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    r1.append(r9)
                    r1.append(r10)
                    r1.append(r8)
                    java.lang.String r1 = r1.toString()
                    r0.<init>(r1)
                    throw r0
                L_0x00fd:
                    r3 = 3
                    goto L_0x0100
                L_0x00ff:
                    r3 = 2
                L_0x0100:
                    r6 = r3
                    goto L_0x0103
                L_0x0102:
                    r6 = 0
                L_0x0103:
                    long r2 = (long) r6
                    r1.bindLong(r14, r2)
                    boolean r2 = r0.mRequiresCharging
                    long r2 = (long) r2
                    r1.bindLong(r13, r2)
                    boolean r2 = r0.mRequiresDeviceIdle
                    long r2 = (long) r2
                    r1.bindLong(r12, r2)
                    boolean r2 = r0.mRequiresBatteryNotLow
                    long r2 = (long) r2
                    r1.bindLong(r11, r2)
                    boolean r2 = r0.mRequiresStorageNotLow
                    long r2 = (long) r2
                    r1.bindLong(r7, r2)
                    long r2 = r0.mTriggerContentUpdateDelay
                    r1.bindLong(r4, r2)
                    long r2 = r0.mTriggerMaxContentDelay
                    r4 = 23
                    r1.bindLong(r4, r2)
                    androidx.work.ContentUriTriggers r0 = r0.mContentUriTriggers
                    int r2 = r0.size()
                    r3 = 0
                    if (r2 != 0) goto L_0x0135
                    goto L_0x018f
                L_0x0135:
                    java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
                    r2.<init>()
                    java.io.ObjectOutputStream r4 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0173 }
                    r4.<init>(r2)     // Catch:{ IOException -> 0x0173 }
                    int r3 = r0.size()     // Catch:{ IOException -> 0x016e, all -> 0x016b }
                    r4.writeInt(r3)     // Catch:{ IOException -> 0x016e, all -> 0x016b }
                    java.util.Set<androidx.work.ContentUriTriggers$Trigger> r0 = r0.mTriggers     // Catch:{ IOException -> 0x016e, all -> 0x016b }
                    java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x016e, all -> 0x016b }
                L_0x014c:
                    boolean r3 = r0.hasNext()     // Catch:{ IOException -> 0x016e, all -> 0x016b }
                    if (r3 == 0) goto L_0x0167
                    java.lang.Object r3 = r0.next()     // Catch:{ IOException -> 0x016e, all -> 0x016b }
                    androidx.work.ContentUriTriggers$Trigger r3 = (androidx.work.ContentUriTriggers.Trigger) r3     // Catch:{ IOException -> 0x016e, all -> 0x016b }
                    android.net.Uri r5 = r3.mUri     // Catch:{ IOException -> 0x016e, all -> 0x016b }
                    java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x016e, all -> 0x016b }
                    r4.writeUTF(r5)     // Catch:{ IOException -> 0x016e, all -> 0x016b }
                    boolean r3 = r3.mTriggerForDescendants     // Catch:{ IOException -> 0x016e, all -> 0x016b }
                    r4.writeBoolean(r3)     // Catch:{ IOException -> 0x016e, all -> 0x016b }
                    goto L_0x014c
                L_0x0167:
                    r4.close()     // Catch:{ IOException -> 0x017d }
                    goto L_0x0182
                L_0x016b:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x019f
                L_0x016e:
                    r0 = move-exception
                    r3 = r4
                    goto L_0x0174
                L_0x0171:
                    r0 = move-exception
                    goto L_0x019d
                L_0x0173:
                    r0 = move-exception
                L_0x0174:
                    r0.printStackTrace()     // Catch:{ all -> 0x0171 }
                    if (r3 == 0) goto L_0x0182
                    r3.close()     // Catch:{ IOException -> 0x017d }
                    goto L_0x0182
                L_0x017d:
                    r0 = move-exception
                    r3 = r0
                    r3.printStackTrace()
                L_0x0182:
                    r2.close()     // Catch:{ IOException -> 0x0186 }
                    goto L_0x018b
                L_0x0186:
                    r0 = move-exception
                    r3 = r0
                    r3.printStackTrace()
                L_0x018b:
                    byte[] r3 = r2.toByteArray()
                L_0x018f:
                    if (r3 != 0) goto L_0x0197
                    r2 = 24
                    r1.bindNull(r2)
                    goto L_0x01d0
                L_0x0197:
                    r2 = 24
                    r1.bindBlob(r2, r3)
                    goto L_0x01d0
                L_0x019d:
                    r1 = r0
                    r4 = r3
                L_0x019f:
                    if (r4 == 0) goto L_0x01aa
                    r4.close()     // Catch:{ IOException -> 0x01a5 }
                    goto L_0x01aa
                L_0x01a5:
                    r0 = move-exception
                    r3 = r0
                    r3.printStackTrace()
                L_0x01aa:
                    r2.close()     // Catch:{ IOException -> 0x01ae }
                    goto L_0x01b3
                L_0x01ae:
                    r0 = move-exception
                    r2 = r0
                    r2.printStackTrace()
                L_0x01b3:
                    throw r1
                L_0x01b4:
                    r1.bindNull(r14)
                    r1.bindNull(r13)
                    r1.bindNull(r12)
                    r1.bindNull(r11)
                    r1.bindNull(r7)
                    r1.bindNull(r4)
                    r0 = 23
                    r1.bindNull(r0)
                    r2 = 24
                    r1.bindNull(r2)
                L_0x01d0:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDao_Impl.AnonymousClass1.bind(androidx.sqlite.db.SupportSQLiteStatement, java.lang.Object):void");
            }

            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(this, roomDatabase) {
            public String createQuery() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.__preparedStmtOfSetOutput = new SharedSQLiteStatement(this, roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.__preparedStmtOfSetPeriodStartTime = new SharedSQLiteStatement(this, roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET period_start_time=? WHERE id=?";
            }
        };
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new SharedSQLiteStatement(this, roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new SharedSQLiteStatement(this, roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.__preparedStmtOfMarkWorkSpecScheduled = new SharedSQLiteStatement(this, roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.__preparedStmtOfResetScheduledState = new SharedSQLiteStatement(this, roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        new SharedSQLiteStatement(this, roomDatabase) {
            public String createQuery() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
    }

    public void delete(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDelete.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDelete.release(acquire);
        }
    }

    public List<WorkSpec> getAllEligibleWorkSpecsForScheduling(int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        acquire.bindLong(1, (long) i);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
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
            int columnIndexOrThrow11 = CompoundButtonCompat.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CompoundButtonCompat.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CompoundButtonCompat.getColumnIndexOrThrow(query, "input");
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
                    int i7 = columnIndexOrThrow3;
                    constraints.mTriggerContentUpdateDelay = query.getLong(columnIndexOrThrow6);
                    constraints.mTriggerMaxContentDelay = query.getLong(columnIndexOrThrow7);
                    constraints.mContentUriTriggers = CompoundButtonCompat.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = CompoundButtonCompat.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    int i8 = i2;
                    workSpec.output = Data.fromByteArray(query.getBlob(i8));
                    int i9 = i6;
                    i2 = i8;
                    int i10 = columnIndexOrThrow15;
                    workSpec.initialDelay = query.getLong(i10);
                    int i11 = columnIndexOrThrow12;
                    int i12 = columnIndexOrThrow16;
                    workSpec.intervalDuration = query.getLong(i12);
                    int i13 = i10;
                    int i14 = columnIndexOrThrow4;
                    int i15 = columnIndexOrThrow17;
                    workSpec.flexDuration = query.getLong(i15);
                    int i16 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = query.getInt(i16);
                    int i17 = columnIndexOrThrow19;
                    int i18 = i12;
                    workSpec.backoffPolicy = CompoundButtonCompat.intToBackoffPolicy(query.getInt(i17));
                    columnIndexOrThrow17 = i15;
                    int i19 = i14;
                    int i20 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = query.getLong(i20);
                    int i21 = i16;
                    int i22 = i17;
                    int i23 = columnIndexOrThrow21;
                    workSpec.periodStartTime = query.getLong(i23);
                    int i24 = i20;
                    columnIndexOrThrow21 = i23;
                    int i25 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = query.getLong(i25);
                    int i26 = i21;
                    int i27 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = query.getLong(i27);
                    int i28 = columnIndexOrThrow24;
                    workSpec.runInForeground = query.getInt(i28) != 0;
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow23 = i27;
                    columnIndexOrThrow24 = i28;
                    columnIndexOrThrow2 = i9;
                    columnIndexOrThrow12 = i11;
                    columnIndexOrThrow15 = i13;
                    columnIndexOrThrow16 = i18;
                    columnIndexOrThrow18 = i26;
                    columnIndexOrThrow9 = i3;
                    columnIndexOrThrow11 = i4;
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow22 = i25;
                    columnIndexOrThrow3 = i7;
                    int i29 = i22;
                    columnIndexOrThrow20 = i24;
                    columnIndexOrThrow4 = i19;
                    columnIndexOrThrow19 = i29;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
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
    }

    public List<String> getAllUnfinishedWork() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<WorkSpec> getEligibleWorkForScheduling(int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        acquire.bindLong(1, (long) i);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
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
            int columnIndexOrThrow11 = CompoundButtonCompat.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CompoundButtonCompat.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CompoundButtonCompat.getColumnIndexOrThrow(query, "input");
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
                    int i7 = columnIndexOrThrow3;
                    constraints.mTriggerContentUpdateDelay = query.getLong(columnIndexOrThrow6);
                    constraints.mTriggerMaxContentDelay = query.getLong(columnIndexOrThrow7);
                    constraints.mContentUriTriggers = CompoundButtonCompat.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = CompoundButtonCompat.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    int i8 = i2;
                    workSpec.output = Data.fromByteArray(query.getBlob(i8));
                    int i9 = i6;
                    i2 = i8;
                    int i10 = columnIndexOrThrow15;
                    workSpec.initialDelay = query.getLong(i10);
                    int i11 = columnIndexOrThrow12;
                    int i12 = columnIndexOrThrow16;
                    workSpec.intervalDuration = query.getLong(i12);
                    int i13 = i10;
                    int i14 = columnIndexOrThrow4;
                    int i15 = columnIndexOrThrow17;
                    workSpec.flexDuration = query.getLong(i15);
                    int i16 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = query.getInt(i16);
                    int i17 = columnIndexOrThrow19;
                    int i18 = i12;
                    workSpec.backoffPolicy = CompoundButtonCompat.intToBackoffPolicy(query.getInt(i17));
                    columnIndexOrThrow17 = i15;
                    int i19 = i14;
                    int i20 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = query.getLong(i20);
                    int i21 = i16;
                    int i22 = i17;
                    int i23 = columnIndexOrThrow21;
                    workSpec.periodStartTime = query.getLong(i23);
                    int i24 = i20;
                    columnIndexOrThrow21 = i23;
                    int i25 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = query.getLong(i25);
                    int i26 = i21;
                    int i27 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = query.getLong(i27);
                    int i28 = columnIndexOrThrow24;
                    workSpec.runInForeground = query.getInt(i28) != 0;
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow23 = i27;
                    columnIndexOrThrow24 = i28;
                    columnIndexOrThrow2 = i9;
                    columnIndexOrThrow12 = i11;
                    columnIndexOrThrow15 = i13;
                    columnIndexOrThrow16 = i18;
                    columnIndexOrThrow18 = i26;
                    columnIndexOrThrow9 = i3;
                    columnIndexOrThrow11 = i4;
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow22 = i25;
                    columnIndexOrThrow3 = i7;
                    int i29 = i22;
                    columnIndexOrThrow20 = i24;
                    columnIndexOrThrow4 = i19;
                    columnIndexOrThrow19 = i29;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
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
    }

    public List<WorkSpec> getRunningWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
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
            int columnIndexOrThrow11 = CompoundButtonCompat.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CompoundButtonCompat.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CompoundButtonCompat.getColumnIndexOrThrow(query, "input");
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
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    int i2 = columnIndexOrThrow9;
                    String string2 = query.getString(columnIndexOrThrow11);
                    int i3 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i4 = columnIndexOrThrow;
                    constraints.mRequiredNetworkType = CompoundButtonCompat.intToNetworkType(query.getInt(columnIndexOrThrow));
                    constraints.mRequiresCharging = query.getInt(columnIndexOrThrow2) != 0;
                    constraints.mRequiresDeviceIdle = query.getInt(columnIndexOrThrow3) != 0;
                    constraints.mRequiresBatteryNotLow = query.getInt(columnIndexOrThrow4) != 0;
                    constraints.mRequiresStorageNotLow = query.getInt(columnIndexOrThrow5) != 0;
                    int i5 = columnIndexOrThrow2;
                    int i6 = columnIndexOrThrow3;
                    constraints.mTriggerContentUpdateDelay = query.getLong(columnIndexOrThrow6);
                    constraints.mTriggerMaxContentDelay = query.getLong(columnIndexOrThrow7);
                    constraints.mContentUriTriggers = CompoundButtonCompat.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = CompoundButtonCompat.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    int i7 = i;
                    workSpec.output = Data.fromByteArray(query.getBlob(i7));
                    int i8 = i5;
                    i = i7;
                    int i9 = columnIndexOrThrow15;
                    workSpec.initialDelay = query.getLong(i9);
                    int i10 = columnIndexOrThrow13;
                    int i11 = columnIndexOrThrow16;
                    workSpec.intervalDuration = query.getLong(i11);
                    int i12 = i9;
                    int i13 = columnIndexOrThrow4;
                    int i14 = columnIndexOrThrow17;
                    workSpec.flexDuration = query.getLong(i14);
                    int i15 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = query.getInt(i15);
                    int i16 = columnIndexOrThrow19;
                    int i17 = i11;
                    workSpec.backoffPolicy = CompoundButtonCompat.intToBackoffPolicy(query.getInt(i16));
                    columnIndexOrThrow17 = i14;
                    int i18 = i13;
                    int i19 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = query.getLong(i19);
                    int i20 = i15;
                    int i21 = i16;
                    int i22 = columnIndexOrThrow21;
                    workSpec.periodStartTime = query.getLong(i22);
                    int i23 = i19;
                    columnIndexOrThrow21 = i22;
                    int i24 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = query.getLong(i24);
                    int i25 = i20;
                    int i26 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = query.getLong(i26);
                    int i27 = columnIndexOrThrow24;
                    workSpec.runInForeground = query.getInt(i27) != 0;
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow23 = i26;
                    columnIndexOrThrow24 = i27;
                    columnIndexOrThrow2 = i8;
                    columnIndexOrThrow13 = i10;
                    columnIndexOrThrow15 = i12;
                    columnIndexOrThrow16 = i17;
                    columnIndexOrThrow18 = i25;
                    columnIndexOrThrow9 = i2;
                    columnIndexOrThrow11 = i3;
                    columnIndexOrThrow = i4;
                    columnIndexOrThrow22 = i24;
                    columnIndexOrThrow3 = i6;
                    int i28 = i21;
                    columnIndexOrThrow20 = i23;
                    columnIndexOrThrow4 = i18;
                    columnIndexOrThrow19 = i28;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
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
    }

    public List<WorkSpec> getScheduledWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
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
            int columnIndexOrThrow11 = CompoundButtonCompat.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CompoundButtonCompat.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CompoundButtonCompat.getColumnIndexOrThrow(query, "input");
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
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    int i2 = columnIndexOrThrow9;
                    String string2 = query.getString(columnIndexOrThrow11);
                    int i3 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i4 = columnIndexOrThrow;
                    constraints.mRequiredNetworkType = CompoundButtonCompat.intToNetworkType(query.getInt(columnIndexOrThrow));
                    constraints.mRequiresCharging = query.getInt(columnIndexOrThrow2) != 0;
                    constraints.mRequiresDeviceIdle = query.getInt(columnIndexOrThrow3) != 0;
                    constraints.mRequiresBatteryNotLow = query.getInt(columnIndexOrThrow4) != 0;
                    constraints.mRequiresStorageNotLow = query.getInt(columnIndexOrThrow5) != 0;
                    int i5 = columnIndexOrThrow2;
                    int i6 = columnIndexOrThrow3;
                    constraints.mTriggerContentUpdateDelay = query.getLong(columnIndexOrThrow6);
                    constraints.mTriggerMaxContentDelay = query.getLong(columnIndexOrThrow7);
                    constraints.mContentUriTriggers = CompoundButtonCompat.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = CompoundButtonCompat.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    int i7 = i;
                    workSpec.output = Data.fromByteArray(query.getBlob(i7));
                    int i8 = i5;
                    i = i7;
                    int i9 = columnIndexOrThrow15;
                    workSpec.initialDelay = query.getLong(i9);
                    int i10 = columnIndexOrThrow13;
                    int i11 = columnIndexOrThrow16;
                    workSpec.intervalDuration = query.getLong(i11);
                    int i12 = i9;
                    int i13 = columnIndexOrThrow4;
                    int i14 = columnIndexOrThrow17;
                    workSpec.flexDuration = query.getLong(i14);
                    int i15 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = query.getInt(i15);
                    int i16 = columnIndexOrThrow19;
                    int i17 = i11;
                    workSpec.backoffPolicy = CompoundButtonCompat.intToBackoffPolicy(query.getInt(i16));
                    columnIndexOrThrow17 = i14;
                    int i18 = i13;
                    int i19 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = query.getLong(i19);
                    int i20 = i15;
                    int i21 = i16;
                    int i22 = columnIndexOrThrow21;
                    workSpec.periodStartTime = query.getLong(i22);
                    int i23 = i19;
                    columnIndexOrThrow21 = i22;
                    int i24 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = query.getLong(i24);
                    int i25 = i20;
                    int i26 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = query.getLong(i26);
                    int i27 = columnIndexOrThrow24;
                    workSpec.runInForeground = query.getInt(i27) != 0;
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow23 = i26;
                    columnIndexOrThrow24 = i27;
                    columnIndexOrThrow2 = i8;
                    columnIndexOrThrow13 = i10;
                    columnIndexOrThrow15 = i12;
                    columnIndexOrThrow16 = i17;
                    columnIndexOrThrow18 = i25;
                    columnIndexOrThrow9 = i2;
                    columnIndexOrThrow11 = i3;
                    columnIndexOrThrow = i4;
                    columnIndexOrThrow22 = i24;
                    columnIndexOrThrow3 = i6;
                    int i28 = i21;
                    columnIndexOrThrow20 = i23;
                    columnIndexOrThrow4 = i18;
                    columnIndexOrThrow19 = i28;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
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
    }

    public WorkInfo$State getState(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        WorkInfo$State workInfo$State = null;
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            if (query.moveToFirst()) {
                workInfo$State = CompoundButtonCompat.intToState(query.getInt(0));
            }
            return workInfo$State;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getUnfinishedWorkWithName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getUnfinishedWorkWithTag(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public WorkSpec getWorkSpec(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        WorkSpec workSpec;
        String str2 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE id=?", 1);
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
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
            int columnIndexOrThrow11 = CompoundButtonCompat.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CompoundButtonCompat.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CompoundButtonCompat.getColumnIndexOrThrow(query, "input");
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
                if (query.moveToFirst()) {
                    String string = query.getString(columnIndexOrThrow9);
                    String string2 = query.getString(columnIndexOrThrow11);
                    int i = columnIndexOrThrow24;
                    Constraints constraints = new Constraints();
                    constraints.mRequiredNetworkType = CompoundButtonCompat.intToNetworkType(query.getInt(columnIndexOrThrow));
                    constraints.mRequiresCharging = query.getInt(columnIndexOrThrow2) != 0;
                    constraints.mRequiresDeviceIdle = query.getInt(columnIndexOrThrow3) != 0;
                    constraints.mRequiresBatteryNotLow = query.getInt(columnIndexOrThrow4) != 0;
                    constraints.mRequiresStorageNotLow = query.getInt(columnIndexOrThrow5) != 0;
                    constraints.mTriggerContentUpdateDelay = query.getLong(columnIndexOrThrow6);
                    constraints.mTriggerMaxContentDelay = query.getLong(columnIndexOrThrow7);
                    constraints.mContentUriTriggers = CompoundButtonCompat.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8));
                    WorkSpec workSpec2 = new WorkSpec(string, string2);
                    workSpec2.state = CompoundButtonCompat.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec2.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec2.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    workSpec2.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow14));
                    workSpec2.initialDelay = query.getLong(columnIndexOrThrow15);
                    workSpec2.intervalDuration = query.getLong(columnIndexOrThrow16);
                    workSpec2.flexDuration = query.getLong(columnIndexOrThrow17);
                    workSpec2.runAttemptCount = query.getInt(columnIndexOrThrow18);
                    workSpec2.backoffPolicy = CompoundButtonCompat.intToBackoffPolicy(query.getInt(columnIndexOrThrow19));
                    workSpec2.backoffDelayDuration = query.getLong(columnIndexOrThrow20);
                    workSpec2.periodStartTime = query.getLong(columnIndexOrThrow21);
                    workSpec2.minimumRetentionDuration = query.getLong(columnIndexOrThrow22);
                    workSpec2.scheduleRequestedAt = query.getLong(columnIndexOrThrow23);
                    workSpec2.runInForeground = query.getInt(i) != 0;
                    workSpec2.constraints = constraints;
                    workSpec = workSpec2;
                } else {
                    workSpec = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return workSpec;
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
    }

    public List<IdAndState> getWorkSpecIdAndStatesForName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CompoundButtonCompat.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CompoundButtonCompat.getColumnIndexOrThrow(query, "state");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                IdAndState idAndState = new IdAndState();
                idAndState.id = query.getString(columnIndexOrThrow);
                idAndState.state = CompoundButtonCompat.intToState(query.getInt(columnIndexOrThrow2));
                arrayList.add(idAndState);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public int incrementWorkSpecRunAttemptCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.release(acquire);
        }
    }

    public int markWorkSpecScheduled(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfMarkWorkSpecScheduled.acquire();
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfMarkWorkSpecScheduled.release(acquire);
        }
    }

    public int resetWorkSpecRunAttemptCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetWorkSpecRunAttemptCount.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetWorkSpecRunAttemptCount.release(acquire);
        }
    }

    public void setOutput(String str, Data data) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetOutput.acquire();
        byte[] byteArrayInternal = Data.toByteArrayInternal(data);
        if (byteArrayInternal == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindBlob(1, byteArrayInternal);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetOutput.release(acquire);
        }
    }

    public void setPeriodStartTime(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetPeriodStartTime.acquire();
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetPeriodStartTime.release(acquire);
        }
    }

    public int setState(WorkInfo$State workInfo$State, String... strArr) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE workspec SET state=");
        sb.append(ColorPropConverter.PREFIX_ATTR);
        sb.append(" WHERE id IN (");
        StringUtil.appendPlaceholders(sb, strArr.length);
        sb.append(")");
        SupportSQLiteStatement compileStatement = this.__db.compileStatement(sb.toString());
        compileStatement.bindLong(1, (long) CompoundButtonCompat.stateToInt(workInfo$State));
        int i = 2;
        for (String str : strArr) {
            if (str == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindString(i, str);
            }
            i++;
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = compileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
        }
    }
}

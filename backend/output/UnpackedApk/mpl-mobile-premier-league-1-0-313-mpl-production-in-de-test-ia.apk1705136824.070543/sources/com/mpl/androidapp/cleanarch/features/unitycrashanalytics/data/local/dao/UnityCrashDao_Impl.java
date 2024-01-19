package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.dao;

import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.entity.UnityCrashData;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class UnityCrashDao_Impl implements UnityCrashDao {
    public final RoomDatabase __db;
    public final EntityDeletionOrUpdateAdapter<UnityCrashData> __deletionAdapterOfUnityCrashData;
    public final EntityInsertionAdapter<UnityCrashData> __insertionAdapterOfUnityCrashData;
    public final SharedSQLiteStatement __preparedStmtOfDeleteTableEntries;

    public UnityCrashDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfUnityCrashData = new EntityInsertionAdapter<UnityCrashData>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `unity_crash_info` (`id`,`battleId`,`data`,`message`) VALUES (?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, UnityCrashData unityCrashData) {
                supportSQLiteStatement.bindLong(1, (long) unityCrashData.getId());
                if (unityCrashData.getBattleId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, unityCrashData.getBattleId());
                }
                if (unityCrashData.getData() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, unityCrashData.getData());
                }
                if (unityCrashData.getMessage() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, unityCrashData.getMessage());
                }
            }
        };
        this.__deletionAdapterOfUnityCrashData = new EntityDeletionOrUpdateAdapter<UnityCrashData>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `unity_crash_info` WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, UnityCrashData unityCrashData) {
                supportSQLiteStatement.bindLong(1, (long) unityCrashData.getId());
            }
        };
        this.__preparedStmtOfDeleteTableEntries = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM unity_crash_info";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public Object deleteTableEntries(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = UnityCrashDao_Impl.this.__preparedStmtOfDeleteTableEntries.acquire();
                UnityCrashDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    UnityCrashDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    UnityCrashDao_Impl.this.__db.endTransaction();
                    UnityCrashDao_Impl.this.__preparedStmtOfDeleteTableEntries.release(acquire);
                }
            }
        }, continuation);
    }

    public Object getUnityCrashData(int i, Continuation<? super UnityCrashData> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM unity_crash_info WHERE id = ?", 1);
        acquire.bindLong(1, (long) i);
        return CoroutinesRoom.execute(this.__db, false, new CancellationSignal(), new Callable<UnityCrashData>() {
            /* JADX WARNING: type inference failed for: r3v0 */
            /* JADX WARNING: type inference failed for: r3v1, types: [com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.entity.UnityCrashData] */
            /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.String] */
            /* JADX WARNING: type inference failed for: r5v2, types: [com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.entity.UnityCrashData] */
            /* JADX WARNING: type inference failed for: r3v3 */
            /* JADX WARNING: type inference failed for: r3v4, types: [java.lang.String] */
            /* JADX WARNING: type inference failed for: r3v5 */
            /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v0
              assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY], java.lang.String]
              uses: [com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.entity.UnityCrashData, java.lang.String]
              mth insns count: 38
            	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
             */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.entity.UnityCrashData call() throws java.lang.Exception {
                /*
                    r7 = this;
                    com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.dao.UnityCrashDao_Impl r0 = com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.dao.UnityCrashDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    androidx.room.RoomSQLiteQuery r1 = r0
                    r2 = 0
                    r3 = 0
                    android.database.Cursor r0 = androidx.core.widget.CompoundButtonCompat.query(r0, r1, r2, r3)
                    java.lang.String r1 = "id"
                    int r1 = androidx.core.widget.CompoundButtonCompat.getColumnIndexOrThrow(r0, r1)     // Catch:{ all -> 0x0062 }
                    java.lang.String r2 = "battleId"
                    int r2 = androidx.core.widget.CompoundButtonCompat.getColumnIndexOrThrow(r0, r2)     // Catch:{ all -> 0x0062 }
                    java.lang.String r4 = "data"
                    int r4 = androidx.core.widget.CompoundButtonCompat.getColumnIndexOrThrow(r0, r4)     // Catch:{ all -> 0x0062 }
                    java.lang.String r5 = "message"
                    int r5 = androidx.core.widget.CompoundButtonCompat.getColumnIndexOrThrow(r0, r5)     // Catch:{ all -> 0x0062 }
                    boolean r6 = r0.moveToFirst()     // Catch:{ all -> 0x0062 }
                    if (r6 == 0) goto L_0x0059
                    int r1 = r0.getInt(r1)     // Catch:{ all -> 0x0062 }
                    boolean r6 = r0.isNull(r2)     // Catch:{ all -> 0x0062 }
                    if (r6 == 0) goto L_0x0038
                    r2 = r3
                    goto L_0x003c
                L_0x0038:
                    java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0062 }
                L_0x003c:
                    boolean r6 = r0.isNull(r4)     // Catch:{ all -> 0x0062 }
                    if (r6 == 0) goto L_0x0044
                    r4 = r3
                    goto L_0x0048
                L_0x0044:
                    java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x0062 }
                L_0x0048:
                    boolean r6 = r0.isNull(r5)     // Catch:{ all -> 0x0062 }
                    if (r6 == 0) goto L_0x004f
                    goto L_0x0053
                L_0x004f:
                    java.lang.String r3 = r0.getString(r5)     // Catch:{ all -> 0x0062 }
                L_0x0053:
                    com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.entity.UnityCrashData r5 = new com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.entity.UnityCrashData     // Catch:{ all -> 0x0062 }
                    r5.<init>(r1, r2, r4, r3)     // Catch:{ all -> 0x0062 }
                    r3 = r5
                L_0x0059:
                    r0.close()
                    androidx.room.RoomSQLiteQuery r0 = r0
                    r0.release()
                    return r3
                L_0x0062:
                    r1 = move-exception
                    r0.close()
                    androidx.room.RoomSQLiteQuery r0 = r0
                    r0.release()
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.dao.UnityCrashDao_Impl.AnonymousClass7.call():com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.entity.UnityCrashData");
            }
        }, continuation);
    }

    public Object insertUnityCrashData(final UnityCrashData unityCrashData, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                UnityCrashDao_Impl.this.__db.beginTransaction();
                try {
                    UnityCrashDao_Impl.this.__insertionAdapterOfUnityCrashData.insert(unityCrashData);
                    UnityCrashDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    UnityCrashDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object removeUnityCrashData(final UnityCrashData unityCrashData, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                UnityCrashDao_Impl.this.__db.beginTransaction();
                try {
                    UnityCrashDao_Impl.this.__deletionAdapterOfUnityCrashData.handle(unityCrashData);
                    UnityCrashDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    UnityCrashDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }
}

package com.mpl.androidapp.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.core.widget.CompoundButtonCompat;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mpl.androidapp.database.entity.GameAssetResource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class GameAssetsDao_Impl implements GameAssetsDao {
    public final RoomDatabase __db;
    public final EntityDeletionOrUpdateAdapter<GameAssetResource> __deletionAdapterOfGameAssetResource;
    public final EntityInsertionAdapter<GameAssetResource> __insertionAdapterOfGameAssetResource;
    public final SharedSQLiteStatement __preparedStmtOfDeleteGameAssetResourceById;
    public final SharedSQLiteStatement __preparedStmtOfUpdateGameAssetResource;
    public final SharedSQLiteStatement __preparedStmtOfUpdateGameAssetResourceForUserVisit;

    public GameAssetsDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfGameAssetResource = new EntityInsertionAdapter<GameAssetResource>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `game_resources` (`gameId`,`name`,`downloadId`,`downloadFileName`,`downloadFilePath`,`optScreenUserVisit`) VALUES (?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, GameAssetResource gameAssetResource) {
                if (gameAssetResource.getGameId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, gameAssetResource.getGameId());
                }
                if (gameAssetResource.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, gameAssetResource.getName());
                }
                supportSQLiteStatement.bindLong(3, gameAssetResource.getDownloadId());
                if (gameAssetResource.getDownloadFileName() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, gameAssetResource.getDownloadFileName());
                }
                if (gameAssetResource.getDownloadFilePath() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, gameAssetResource.getDownloadFilePath());
                }
                supportSQLiteStatement.bindLong(6, gameAssetResource.getOptScreenUserVisit() ? 1 : 0);
            }
        };
        this.__deletionAdapterOfGameAssetResource = new EntityDeletionOrUpdateAdapter<GameAssetResource>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `game_resources` WHERE `gameId` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, GameAssetResource gameAssetResource) {
                if (gameAssetResource.getGameId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, gameAssetResource.getGameId());
                }
            }
        };
        this.__preparedStmtOfUpdateGameAssetResource = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE game_resources SET downloadId = ? WHERE gameId = ?";
            }
        };
        this.__preparedStmtOfUpdateGameAssetResourceForUserVisit = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE game_resources SET optScreenUserVisit = ? WHERE gameId = ?";
            }
        };
        this.__preparedStmtOfDeleteGameAssetResourceById = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM game_resources WHERE gameId = ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public void deleteGameAssetResourceById(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteGameAssetResourceById.acquire();
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
            this.__preparedStmtOfDeleteGameAssetResourceById.release(acquire);
        }
    }

    public Object getAllGameAssetResourceList(Continuation<? super List<GameAssetResource>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM game_resources", 0);
        return CoroutinesRoom.execute(this.__db, false, new CancellationSignal(), new Callable<List<GameAssetResource>>() {
            public List<GameAssetResource> call() throws Exception {
                String str;
                String str2;
                String str3;
                String str4;
                Cursor query = CompoundButtonCompat.query(GameAssetsDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CompoundButtonCompat.getColumnIndexOrThrow(query, "gameId");
                    int columnIndexOrThrow2 = CompoundButtonCompat.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow3 = CompoundButtonCompat.getColumnIndexOrThrow(query, "downloadId");
                    int columnIndexOrThrow4 = CompoundButtonCompat.getColumnIndexOrThrow(query, "downloadFileName");
                    int columnIndexOrThrow5 = CompoundButtonCompat.getColumnIndexOrThrow(query, "downloadFilePath");
                    int columnIndexOrThrow6 = CompoundButtonCompat.getColumnIndexOrThrow(query, "optScreenUserVisit");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (query.isNull(columnIndexOrThrow)) {
                            str = null;
                        } else {
                            str = query.getString(columnIndexOrThrow);
                        }
                        if (query.isNull(columnIndexOrThrow2)) {
                            str2 = null;
                        } else {
                            str2 = query.getString(columnIndexOrThrow2);
                        }
                        long j = query.getLong(columnIndexOrThrow3);
                        if (query.isNull(columnIndexOrThrow4)) {
                            str3 = null;
                        } else {
                            str3 = query.getString(columnIndexOrThrow4);
                        }
                        if (query.isNull(columnIndexOrThrow5)) {
                            str4 = null;
                        } else {
                            str4 = query.getString(columnIndexOrThrow5);
                        }
                        GameAssetResource gameAssetResource = new GameAssetResource(str, str2, j, str3, str4, query.getInt(columnIndexOrThrow6) != 0);
                        arrayList.add(gameAssetResource);
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    public Object getGameAssetResourceById(String str, Continuation<? super GameAssetResource> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM game_resources WHERE gameId = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return CoroutinesRoom.execute(this.__db, false, new CancellationSignal(), new Callable<GameAssetResource>() {
            /* JADX WARNING: type inference failed for: r4v0 */
            /* JADX WARNING: type inference failed for: r4v1, types: [com.mpl.androidapp.database.entity.GameAssetResource] */
            /* JADX WARNING: type inference failed for: r4v2, types: [java.lang.String] */
            /* JADX WARNING: type inference failed for: r4v3 */
            /* JADX WARNING: type inference failed for: r16v0, types: [java.lang.String] */
            /* JADX WARNING: type inference failed for: r10v2, types: [com.mpl.androidapp.database.entity.GameAssetResource] */
            /* JADX WARNING: type inference failed for: r4v5 */
            /* JADX WARNING: type inference failed for: r10v3, types: [com.mpl.androidapp.database.entity.GameAssetResource] */
            /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v0
              assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.mpl.androidapp.database.entity.GameAssetResource, java.lang.String]
              uses: [com.mpl.androidapp.database.entity.GameAssetResource, ?[OBJECT, ARRAY]]
              mth insns count: 57
            	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
             */
            /* JADX WARNING: Unknown variable types count: 2 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.mpl.androidapp.database.entity.GameAssetResource call() throws java.lang.Exception {
                /*
                    r18 = this;
                    r1 = r18
                    com.mpl.androidapp.database.dao.GameAssetsDao_Impl r0 = com.mpl.androidapp.database.dao.GameAssetsDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    androidx.room.RoomSQLiteQuery r2 = r0
                    r3 = 0
                    r4 = 0
                    android.database.Cursor r2 = androidx.core.widget.CompoundButtonCompat.query(r0, r2, r3, r4)
                    java.lang.String r0 = "gameId"
                    int r0 = androidx.core.widget.CompoundButtonCompat.getColumnIndexOrThrow(r2, r0)     // Catch:{ all -> 0x008e }
                    java.lang.String r5 = "name"
                    int r5 = androidx.core.widget.CompoundButtonCompat.getColumnIndexOrThrow(r2, r5)     // Catch:{ all -> 0x008e }
                    java.lang.String r6 = "downloadId"
                    int r6 = androidx.core.widget.CompoundButtonCompat.getColumnIndexOrThrow(r2, r6)     // Catch:{ all -> 0x008e }
                    java.lang.String r7 = "downloadFileName"
                    int r7 = androidx.core.widget.CompoundButtonCompat.getColumnIndexOrThrow(r2, r7)     // Catch:{ all -> 0x008e }
                    java.lang.String r8 = "downloadFilePath"
                    int r8 = androidx.core.widget.CompoundButtonCompat.getColumnIndexOrThrow(r2, r8)     // Catch:{ all -> 0x008e }
                    java.lang.String r9 = "optScreenUserVisit"
                    int r9 = androidx.core.widget.CompoundButtonCompat.getColumnIndexOrThrow(r2, r9)     // Catch:{ all -> 0x008e }
                    boolean r10 = r2.moveToFirst()     // Catch:{ all -> 0x008e }
                    if (r10 == 0) goto L_0x0085
                    boolean r10 = r2.isNull(r0)     // Catch:{ all -> 0x008e }
                    if (r10 == 0) goto L_0x0042
                    r11 = r4
                    goto L_0x0047
                L_0x0042:
                    java.lang.String r0 = r2.getString(r0)     // Catch:{ all -> 0x008e }
                    r11 = r0
                L_0x0047:
                    boolean r0 = r2.isNull(r5)     // Catch:{ all -> 0x008e }
                    if (r0 == 0) goto L_0x004f
                    r12 = r4
                    goto L_0x0054
                L_0x004f:
                    java.lang.String r0 = r2.getString(r5)     // Catch:{ all -> 0x008e }
                    r12 = r0
                L_0x0054:
                    long r13 = r2.getLong(r6)     // Catch:{ all -> 0x008e }
                    boolean r0 = r2.isNull(r7)     // Catch:{ all -> 0x008e }
                    if (r0 == 0) goto L_0x0060
                    r15 = r4
                    goto L_0x0065
                L_0x0060:
                    java.lang.String r0 = r2.getString(r7)     // Catch:{ all -> 0x008e }
                    r15 = r0
                L_0x0065:
                    boolean r0 = r2.isNull(r8)     // Catch:{ all -> 0x008e }
                    if (r0 == 0) goto L_0x006e
                L_0x006b:
                    r16 = r4
                    goto L_0x0073
                L_0x006e:
                    java.lang.String r4 = r2.getString(r8)     // Catch:{ all -> 0x008e }
                    goto L_0x006b
                L_0x0073:
                    int r0 = r2.getInt(r9)     // Catch:{ all -> 0x008e }
                    if (r0 == 0) goto L_0x007d
                    r3 = 1
                    r17 = 1
                    goto L_0x007f
                L_0x007d:
                    r17 = 0
                L_0x007f:
                    com.mpl.androidapp.database.entity.GameAssetResource r4 = new com.mpl.androidapp.database.entity.GameAssetResource     // Catch:{ all -> 0x008e }
                    r10 = r4
                    r10.<init>(r11, r12, r13, r15, r16, r17)     // Catch:{ all -> 0x008e }
                L_0x0085:
                    r2.close()
                    androidx.room.RoomSQLiteQuery r0 = r0
                    r0.release()
                    return r4
                L_0x008e:
                    r0 = move-exception
                    r2.close()
                    androidx.room.RoomSQLiteQuery r2 = r0
                    r2.release()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.database.dao.GameAssetsDao_Impl.AnonymousClass11.call():com.mpl.androidapp.database.entity.GameAssetResource");
            }
        }, continuation);
    }

    public Object insertGameAssetResource(final GameAssetResource gameAssetResource, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                GameAssetsDao_Impl.this.__db.beginTransaction();
                try {
                    GameAssetsDao_Impl.this.__insertionAdapterOfGameAssetResource.insert(gameAssetResource);
                    GameAssetsDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    GameAssetsDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object removeGameAssetResource(final GameAssetResource gameAssetResource, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                GameAssetsDao_Impl.this.__db.beginTransaction();
                try {
                    GameAssetsDao_Impl.this.__deletionAdapterOfGameAssetResource.handle(gameAssetResource);
                    GameAssetsDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    GameAssetsDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object updateGameAssetResource(final String str, final long j, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = GameAssetsDao_Impl.this.__preparedStmtOfUpdateGameAssetResource.acquire();
                acquire.bindLong(1, j);
                String str = str;
                if (str == null) {
                    acquire.bindNull(2);
                } else {
                    acquire.bindString(2, str);
                }
                GameAssetsDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    GameAssetsDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    GameAssetsDao_Impl.this.__db.endTransaction();
                    GameAssetsDao_Impl.this.__preparedStmtOfUpdateGameAssetResource.release(acquire);
                }
            }
        }, continuation);
    }

    public Object updateGameAssetResourceForUserVisit(final String str, final boolean z, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = GameAssetsDao_Impl.this.__preparedStmtOfUpdateGameAssetResourceForUserVisit.acquire();
                acquire.bindLong(1, z ? 1 : 0);
                String str = str;
                if (str == null) {
                    acquire.bindNull(2);
                } else {
                    acquire.bindString(2, str);
                }
                GameAssetsDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    GameAssetsDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    GameAssetsDao_Impl.this.__db.endTransaction();
                    GameAssetsDao_Impl.this.__preparedStmtOfUpdateGameAssetResourceForUserVisit.release(acquire);
                }
            }
        }, continuation);
    }
}

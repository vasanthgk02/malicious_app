package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.implementation;

import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.dao.UnityCrashDao;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.database.UnityCrashDatabase;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.entity.UnityCrashData;
import com.mpl.androidapp.utils.MLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/implementation/UnityCrashDbServiceImpl;", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/dao/UnityCrashDao;", "db", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/database/UnityCrashDatabase;", "(Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/database/UnityCrashDatabase;)V", "getDb", "()Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/database/UnityCrashDatabase;", "setDb", "deleteTableEntries", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUnityCrashData", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/entity/UnityCrashData;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUnityCrashData", "unityCrashData", "(Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/entity/UnityCrashData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeUnityCrashData", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnityCrashDbServiceImpl.kt */
public class UnityCrashDbServiceImpl implements UnityCrashDao {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "UnityCrashImpl";
    public UnityCrashDatabase db;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/implementation/UnityCrashDbServiceImpl$Companion;", "", "()V", "TAG", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UnityCrashDbServiceImpl.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UnityCrashDbServiceImpl(UnityCrashDatabase unityCrashDatabase) {
        Intrinsics.checkNotNullParameter(unityCrashDatabase, "db");
        this.db = unityCrashDatabase;
    }

    public static Object deleteTableEntries$suspendImpl(UnityCrashDbServiceImpl unityCrashDbServiceImpl, Continuation continuation) {
        MLogger.d(TAG, "deleteTableEntries");
        Object deleteTableEntries = unityCrashDbServiceImpl.getDb().unityCrashDao().deleteTableEntries(continuation);
        if (deleteTableEntries == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return deleteTableEntries;
        }
        return Unit.INSTANCE;
    }

    public static Object insertUnityCrashData$suspendImpl(UnityCrashDbServiceImpl unityCrashDbServiceImpl, UnityCrashData unityCrashData, Continuation continuation) {
        MLogger.d(TAG, "unityCrashData");
        Object insertUnityCrashData = unityCrashDbServiceImpl.getDb().unityCrashDao().insertUnityCrashData(unityCrashData, continuation);
        if (insertUnityCrashData == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return insertUnityCrashData;
        }
        return Unit.INSTANCE;
    }

    public static Object removeUnityCrashData$suspendImpl(UnityCrashDbServiceImpl unityCrashDbServiceImpl, UnityCrashData unityCrashData, Continuation continuation) {
        MLogger.d(TAG, "removeUnityCrashData");
        Object removeUnityCrashData = unityCrashDbServiceImpl.getDb().unityCrashDao().removeUnityCrashData(unityCrashData, continuation);
        if (removeUnityCrashData == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return removeUnityCrashData;
        }
        return Unit.INSTANCE;
    }

    public Object deleteTableEntries(Continuation<? super Unit> continuation) {
        return deleteTableEntries$suspendImpl(this, continuation);
    }

    public final UnityCrashDatabase getDb() {
        return this.db;
    }

    public Object getUnityCrashData(int i, Continuation<? super UnityCrashData> continuation) {
        return MLogger.d(TAG, "getUnityCrashData");
    }

    public Object insertUnityCrashData(UnityCrashData unityCrashData, Continuation<? super Unit> continuation) {
        return insertUnityCrashData$suspendImpl(this, unityCrashData, continuation);
    }

    public Object removeUnityCrashData(UnityCrashData unityCrashData, Continuation<? super Unit> continuation) {
        return removeUnityCrashData$suspendImpl(this, unityCrashData, continuation);
    }

    public final void setDb(UnityCrashDatabase unityCrashDatabase) {
        Intrinsics.checkNotNullParameter(unityCrashDatabase, "<set-?>");
        this.db = unityCrashDatabase;
    }
}

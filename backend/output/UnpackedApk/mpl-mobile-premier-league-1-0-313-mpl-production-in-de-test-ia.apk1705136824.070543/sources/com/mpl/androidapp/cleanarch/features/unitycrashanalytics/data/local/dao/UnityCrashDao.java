package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.dao;

import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.entity.UnityCrashData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/dao/UnityCrashDao;", "", "deleteTableEntries", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUnityCrashData", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/entity/UnityCrashData;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUnityCrashData", "unityCrashData", "(Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/entity/UnityCrashData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeUnityCrashData", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnityCrashDao.kt */
public interface UnityCrashDao {
    Object deleteTableEntries(Continuation<? super Unit> continuation);

    Object getUnityCrashData(int i, Continuation<? super UnityCrashData> continuation);

    Object insertUnityCrashData(UnityCrashData unityCrashData, Continuation<? super Unit> continuation);

    Object removeUnityCrashData(UnityCrashData unityCrashData, Continuation<? super Unit> continuation);
}

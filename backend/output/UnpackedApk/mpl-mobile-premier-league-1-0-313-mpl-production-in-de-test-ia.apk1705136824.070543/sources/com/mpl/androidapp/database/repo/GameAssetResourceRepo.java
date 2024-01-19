package com.mpl.androidapp.database.repo;

import com.mpl.androidapp.database.AssetsDatabase;
import com.mpl.androidapp.database.dao.GameAssetsDao;
import com.mpl.androidapp.database.dao.GameAssetsDao.DefaultImpls;
import com.mpl.androidapp.database.entity.GameAssetResource;
import com.mpl.androidapp.utils.MLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J!\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo;", "", "db", "Lcom/mpl/androidapp/database/AssetsDatabase;", "(Lcom/mpl/androidapp/database/AssetsDatabase;)V", "getDb", "()Lcom/mpl/androidapp/database/AssetsDatabase;", "setDb", "deleteGameAssetBasedOnId", "", "gameId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGameAssetResource", "Lcom/mpl/androidapp/database/entity/GameAssetResource;", "getGameAssetResourceList", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertGameAssetResource", "gameAssetResource", "(Lcom/mpl/androidapp/database/entity/GameAssetResource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeGameAssetResource", "updateGameAssetResource", "downloadId", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateGameAssetResourceForUserVisit", "id", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameAssetResourceRepo.kt */
public class GameAssetResourceRepo {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "GameAssetResourceRepo";
    public AssetsDatabase db;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo$Companion;", "", "()V", "TAG", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GameAssetResourceRepo.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GameAssetResourceRepo(AssetsDatabase assetsDatabase) {
        Intrinsics.checkNotNullParameter(assetsDatabase, "db");
        this.db = assetsDatabase;
    }

    public static /* synthetic */ Object deleteGameAssetBasedOnId$suspendImpl(GameAssetResourceRepo gameAssetResourceRepo, String str, Continuation continuation) {
        MLogger.d(TAG, "GetGameAssetResource");
        gameAssetResourceRepo.getDb().gameAssetsDao().deleteGameAssetResourceById(str);
        return Unit.INSTANCE;
    }

    public static Object insertGameAssetResource$suspendImpl(GameAssetResourceRepo gameAssetResourceRepo, GameAssetResource gameAssetResource, Continuation continuation) {
        MLogger.d(TAG, "insertGameAssetResource");
        Object insertGameAssetResource = gameAssetResourceRepo.getDb().gameAssetsDao().insertGameAssetResource(gameAssetResource, continuation);
        if (insertGameAssetResource == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return insertGameAssetResource;
        }
        return Unit.INSTANCE;
    }

    public static Object removeGameAssetResource$suspendImpl(GameAssetResourceRepo gameAssetResourceRepo, GameAssetResource gameAssetResource, Continuation continuation) {
        MLogger.d(TAG, "deleteGameAssetResource");
        Object removeGameAssetResource = gameAssetResourceRepo.getDb().gameAssetsDao().removeGameAssetResource(gameAssetResource, continuation);
        if (removeGameAssetResource == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return removeGameAssetResource;
        }
        return Unit.INSTANCE;
    }

    public static Object updateGameAssetResource$suspendImpl(GameAssetResourceRepo gameAssetResourceRepo, String str, long j, Continuation continuation) {
        MLogger.d(TAG, "GetGameAssetResource");
        Object updateGameAssetResource = gameAssetResourceRepo.getDb().gameAssetsDao().updateGameAssetResource(str, j, continuation);
        if (updateGameAssetResource == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return updateGameAssetResource;
        }
        return Unit.INSTANCE;
    }

    public static Object updateGameAssetResourceForUserVisit$suspendImpl(GameAssetResourceRepo gameAssetResourceRepo, String str, Continuation continuation) {
        MLogger.d(TAG, "getGameDownloadById");
        GameAssetsDao gameAssetsDao = gameAssetResourceRepo.getDb().gameAssetsDao();
        Intrinsics.checkNotNullExpressionValue(gameAssetsDao, "db.gameAssetsDao()");
        Object updateGameAssetResourceForUserVisit$default = DefaultImpls.updateGameAssetResourceForUserVisit$default(gameAssetsDao, str, false, continuation, 2, null);
        if (updateGameAssetResourceForUserVisit$default == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return updateGameAssetResourceForUserVisit$default;
        }
        return Unit.INSTANCE;
    }

    public Object deleteGameAssetBasedOnId(String str, Continuation<? super Unit> continuation) {
        return deleteGameAssetBasedOnId$suspendImpl(this, str, continuation);
    }

    public final AssetsDatabase getDb() {
        return this.db;
    }

    public Object getGameAssetResource(String str, Continuation<? super GameAssetResource> continuation) {
        return MLogger.d(TAG, "GetGameAssetResource");
    }

    public Object getGameAssetResourceList(Continuation<? super List<GameAssetResource>> continuation) {
        return MLogger.d(TAG, "GetGameAssetResourceList");
    }

    public Object insertGameAssetResource(GameAssetResource gameAssetResource, Continuation<? super Unit> continuation) {
        return insertGameAssetResource$suspendImpl(this, gameAssetResource, continuation);
    }

    public Object removeGameAssetResource(GameAssetResource gameAssetResource, Continuation<? super Unit> continuation) {
        return removeGameAssetResource$suspendImpl(this, gameAssetResource, continuation);
    }

    public final void setDb(AssetsDatabase assetsDatabase) {
        Intrinsics.checkNotNullParameter(assetsDatabase, "<set-?>");
        this.db = assetsDatabase;
    }

    public Object updateGameAssetResource(String str, long j, Continuation<? super Unit> continuation) {
        return updateGameAssetResource$suspendImpl(this, str, j, continuation);
    }

    public Object updateGameAssetResourceForUserVisit(String str, Continuation<? super Unit> continuation) {
        return updateGameAssetResourceForUserVisit$suspendImpl(this, str, continuation);
    }
}

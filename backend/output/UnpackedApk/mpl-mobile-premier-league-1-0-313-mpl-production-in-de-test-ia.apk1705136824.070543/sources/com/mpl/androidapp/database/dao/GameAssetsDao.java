package com.mpl.androidapp.database.dao;

import com.mpl.androidapp.database.entity.GameAssetResource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J#\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0016H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/mpl/androidapp/database/dao/GameAssetsDao;", "", "deleteGameAssetResourceById", "", "gameId", "", "getAllGameAssetResourceList", "", "Lcom/mpl/androidapp/database/entity/GameAssetResource;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGameAssetResourceById", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertGameAssetResource", "gameAssetResource", "(Lcom/mpl/androidapp/database/entity/GameAssetResource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeGameAssetResource", "updateGameAssetResource", "downloadId", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateGameAssetResourceForUserVisit", "hasUserVisited", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameAssetsDao.kt */
public interface GameAssetsDao {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GameAssetsDao.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object updateGameAssetResourceForUserVisit$default(GameAssetsDao gameAssetsDao, String str, boolean z, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                return gameAssetsDao.updateGameAssetResourceForUserVisit(str, z, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateGameAssetResourceForUserVisit");
        }
    }

    void deleteGameAssetResourceById(String str);

    Object getAllGameAssetResourceList(Continuation<? super List<GameAssetResource>> continuation);

    Object getGameAssetResourceById(String str, Continuation<? super GameAssetResource> continuation);

    Object insertGameAssetResource(GameAssetResource gameAssetResource, Continuation<? super Unit> continuation);

    Object removeGameAssetResource(GameAssetResource gameAssetResource, Continuation<? super Unit> continuation);

    Object updateGameAssetResource(String str, long j, Continuation<? super Unit> continuation);

    Object updateGameAssetResourceForUserVisit(String str, boolean z, Continuation<? super Unit> continuation);
}

package com.mpl.androidapp.spacemanagment;

import android.content.Context;
import com.mpl.androidapp.utils.MLogger;
import io.reactivex.Single;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleFromCallable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class GamesUseCase {
    public static final String TAG = "GameSpaceManagement";

    public static /* synthetic */ Map lambda$getGamesUseCase$0(Map[] mapArr, GamesRepository gamesRepository, Context context) throws Exception {
        try {
            mapArr[0] = gamesRepository.getInstalledApps(context, false);
        } catch (Exception e2) {
            MLogger.d("GameSpaceManagement", e2.getMessage());
        }
        return mapArr[0];
    }

    public Single<Map> getGamesUseCase(Context context) {
        GamesRepositoryImpl gamesRepositoryImpl = new GamesRepositoryImpl();
        $$Lambda$GamesUseCase$_XJZMqyuJlBFmK3WT0bn6pBXy8M r2 = new Callable(new Map[]{new HashMap()}, gamesRepositoryImpl, context) {
            public final /* synthetic */ Map[] f$0;
            public final /* synthetic */ GamesRepository f$1;
            public final /* synthetic */ Context f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object call() {
                return GamesUseCase.lambda$getGamesUseCase$0(this.f$0, this.f$1, this.f$2);
            }
        };
        ObjectHelper.requireNonNull(r2, "callable is null");
        return new SingleFromCallable(r2);
    }
}

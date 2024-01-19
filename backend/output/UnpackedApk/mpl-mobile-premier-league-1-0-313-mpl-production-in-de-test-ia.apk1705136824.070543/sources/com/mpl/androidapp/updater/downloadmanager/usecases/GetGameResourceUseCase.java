package com.mpl.androidapp.updater.downloadmanager.usecases;

import com.mpl.androidapp.database.entity.GameAssetResource;
import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates;
import com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001724\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0001:\u0001\u0017B\u0019\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ?\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/usecases/GetGameResourceUseCase;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/SuspendUseCase;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "gameAssetResourceRepo", "Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getGameAssetResourceRepo", "()Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo;", "execute", "parameters", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGameResource", "Lcom/mpl/androidapp/database/entity/GameAssetResource;", "gameId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GetGameResourceUseCase.kt */
public class GetGameResourceUseCase extends SuspendUseCase<HashMap<String, String>, UseCaseResult<? extends QueryDownloadStates>> {
    public static final Companion Companion = new Companion(null);
    public static final String INVALID_GAME_ID = "Invalid Game Id";
    public final CoroutineDispatcher dispatcher;
    public final GameAssetResourceRepo gameAssetResourceRepo;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/usecases/GetGameResourceUseCase$Companion;", "", "()V", "INVALID_GAME_ID", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GetGameResourceUseCase.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GetGameResourceUseCase(GameAssetResourceRepo gameAssetResourceRepo2, @IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        // Intrinsics.checkNotNullParameter(gameAssetResourceRepo2, "gameAssetResourceRepo");
        // Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        super(coroutineDispatcher);
        this.gameAssetResourceRepo = gameAssetResourceRepo2;
        this.dispatcher = coroutineDispatcher;
    }

    public static Object execute$suspendImpl(GetGameResourceUseCase getGameResourceUseCase, HashMap hashMap, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(TweetUtils.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        TypeUtilsKt.runBlocking(getGameResourceUseCase.getDispatcher(), new GetGameResourceUseCase$execute$2$1(hashMap, getGameResourceUseCase, cancellableContinuationImpl, null));
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(continuation, "frame");
        }
        return result;
    }

    /* access modifiers changed from: private */
    public final Object getGameResource(String str, Continuation<? super GameAssetResource> continuation) {
        return TypeUtilsKt.withContext(getDispatcher(), new GetGameResourceUseCase$getGameResource$2(this, str, null), continuation);
    }

    public Object execute(HashMap<String, String> hashMap, Continuation<? super UseCaseResult<? extends QueryDownloadStates>> continuation) {
        return execute$suspendImpl(this, hashMap, continuation);
    }

    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final GameAssetResourceRepo getGameAssetResourceRepo() {
        return this.gameAssetResourceRepo;
    }
}

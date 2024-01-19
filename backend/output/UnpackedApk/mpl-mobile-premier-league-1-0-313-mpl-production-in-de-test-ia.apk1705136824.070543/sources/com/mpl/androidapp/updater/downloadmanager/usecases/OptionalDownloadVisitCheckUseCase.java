package com.mpl.androidapp.updater.downloadmanager.usecases;

import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates;
import com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/usecases/OptionalDownloadVisitCheckUseCase;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/SuspendUseCase;", "", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "gameAssetResourceRepo", "Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getGameAssetResourceRepo", "()Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo;", "execute", "gameId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OptionalDownloadVisitCheckUseCase.kt */
public class OptionalDownloadVisitCheckUseCase extends SuspendUseCase<String, UseCaseResult<? extends QueryDownloadStates>> {
    public final CoroutineDispatcher dispatcher;
    public final GameAssetResourceRepo gameAssetResourceRepo;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public OptionalDownloadVisitCheckUseCase(GameAssetResourceRepo gameAssetResourceRepo2, @IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        // Intrinsics.checkNotNullParameter(gameAssetResourceRepo2, "gameAssetResourceRepo");
        // Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        super(coroutineDispatcher);
        this.gameAssetResourceRepo = gameAssetResourceRepo2;
        this.dispatcher = coroutineDispatcher;
    }

    public static Object execute$suspendImpl(OptionalDownloadVisitCheckUseCase optionalDownloadVisitCheckUseCase, String str, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(TweetUtils.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        TypeUtilsKt.runBlocking(optionalDownloadVisitCheckUseCase.getDispatcher(), new OptionalDownloadVisitCheckUseCase$execute$2$1(optionalDownloadVisitCheckUseCase, str, cancellableContinuationImpl, null));
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(continuation, "frame");
        }
        return result;
    }

    public Object execute(String str, Continuation<? super UseCaseResult<? extends QueryDownloadStates>> continuation) {
        return execute$suspendImpl(this, str, continuation);
    }

    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final GameAssetResourceRepo getGameAssetResourceRepo() {
        return this.gameAssetResourceRepo;
    }
}

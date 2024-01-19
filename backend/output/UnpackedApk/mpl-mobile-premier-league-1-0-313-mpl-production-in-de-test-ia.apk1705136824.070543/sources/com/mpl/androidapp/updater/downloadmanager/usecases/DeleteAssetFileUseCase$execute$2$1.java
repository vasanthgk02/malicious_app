package com.mpl.androidapp.updater.downloadmanager.usecases;

import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.DeleteAssetFile;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.usecases.DeleteAssetFileUseCase$execute$2$1", f = "DeleteAssetFileUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: DeleteAssetFileUseCase.kt */
public final class DeleteAssetFileUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends QueryDownloadStates>> $coroutine;
    public final /* synthetic */ HashMap<String, String> $parameters;
    public int label;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeleteAssetFileUseCase$execute$2$1(HashMap<String, String> hashMap, CancellableContinuation<? super UseCaseResult<? extends QueryDownloadStates>> cancellableContinuation, Continuation<? super DeleteAssetFileUseCase$execute$2$1> continuation) {
        // this.$parameters = hashMap;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeleteAssetFileUseCase$execute$2$1(this.$parameters, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeleteAssetFileUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            try {
                String str = this.$parameters.get(Constants.DOWNLOADER_DOWNLOAD_PATH);
                String str2 = this.$parameters.get(Constants.DOWNLOADER_FILE_NAME);
                if (str == null || str2 == null) {
                    this.$coroutine.resumeWith(new Error(new Exception("Invalid File Uri")));
                    return Unit.INSTANCE;
                }
                File file = new File(str, str2);
                if (file.exists()) {
                    file.delete();
                    this.$coroutine.resumeWith(new Success(DeleteAssetFile.INSTANCE));
                } else {
                    this.$coroutine.resumeWith(new Error(new Exception("File does not exists")));
                }
                return Unit.INSTANCE;
            } catch (Exception e2) {
                this.$coroutine.resumeWith(new Error(e2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

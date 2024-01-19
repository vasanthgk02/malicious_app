package com.mpl.androidapp.filehandling.downloadservice.usecases;

import com.mpl.androidapp.utils.MLogger;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.filehandling.downloadservice.usecases.DeleteExistingFileUseCase$deleteFileFromDevice$2", f = "DeleteExistingFileUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: DeleteExistingFileUseCase.kt */
public final class DeleteExistingFileUseCase$deleteFileFromDevice$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ String $clientPath;
    public final /* synthetic */ String $fileName;
    public int label;
    public final /* synthetic */ DeleteExistingFileUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeleteExistingFileUseCase$deleteFileFromDevice$2(DeleteExistingFileUseCase deleteExistingFileUseCase, String str, String str2, Continuation<? super DeleteExistingFileUseCase$deleteFileFromDevice$2> continuation) {
        // this.this$0 = deleteExistingFileUseCase;
        // this.$clientPath = str;
        // this.$fileName = str2;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeleteExistingFileUseCase$deleteFileFromDevice$2(this.this$0, this.$clientPath, this.$fileName, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeleteExistingFileUseCase$deleteFileFromDevice$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            File externalFilesDir = this.this$0.getContext().getExternalFilesDir(this.$clientPath);
            if (externalFilesDir == null) {
                return null;
            }
            File file = new File(externalFilesDir.getAbsolutePath(), this.$fileName);
            if (file.exists()) {
                file.delete();
                MLogger.i("DownloadingFileFromServer", "File is existing, So we deleted it");
            } else {
                MLogger.i("DownloadingFileFromServer", "File does not exist");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

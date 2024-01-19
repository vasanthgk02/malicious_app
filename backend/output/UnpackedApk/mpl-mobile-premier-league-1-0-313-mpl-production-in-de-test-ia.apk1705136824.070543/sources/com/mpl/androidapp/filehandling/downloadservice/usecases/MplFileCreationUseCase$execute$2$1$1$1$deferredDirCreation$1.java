package com.mpl.androidapp.filehandling.downloadservice.usecases;

import com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.filehandling.downloadservice.usecases.MplFileCreationUseCase$execute$2$1$1$1$deferredDirCreation$1", f = "MplFileCreationUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: MplFileCreationUseCase.kt */
public final class MplFileCreationUseCase$execute$2$1$1$1$deferredDirCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends GenericFileDownloadStates>> $coroutine;
    public final /* synthetic */ File $dirFile;
    public final /* synthetic */ String $fileName;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ MplFileCreationUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MplFileCreationUseCase$execute$2$1$1$1$deferredDirCreation$1(File file, String str, MplFileCreationUseCase mplFileCreationUseCase, CancellableContinuation<? super UseCaseResult<? extends GenericFileDownloadStates>> cancellableContinuation, Continuation<? super MplFileCreationUseCase$execute$2$1$1$1$deferredDirCreation$1> continuation) {
        // this.$dirFile = file;
        // this.$fileName = str;
        // this.this$0 = mplFileCreationUseCase;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MplFileCreationUseCase$execute$2$1$1$1$deferredDirCreation$1 mplFileCreationUseCase$execute$2$1$1$1$deferredDirCreation$1 = new MplFileCreationUseCase$execute$2$1$1$1$deferredDirCreation$1(this.$dirFile, this.$fileName, this.this$0, this.$coroutine, continuation);
        mplFileCreationUseCase$execute$2$1$1$1$deferredDirCreation$1.L$0 = obj;
        return mplFileCreationUseCase$execute$2$1$1$1$deferredDirCreation$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((MplFileCreationUseCase$execute$2$1$1$1$deferredDirCreation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r0 = r5.label
            if (r0 != 0) goto L_0x0054
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            java.lang.Object r6 = r5.L$0
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            java.io.File r6 = r5.$dirFile
            java.lang.String r0 = r5.$fileName
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0020 }
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ all -> 0x0020 }
            r2.<init>(r6, r0)     // Catch:{ all -> 0x0020 }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x001e }
            goto L_0x0026
        L_0x001e:
            r6 = move-exception
            goto L_0x0022
        L_0x0020:
            r6 = move-exception
            r2 = r1
        L_0x0022:
            java.lang.Object r6 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r6)
        L_0x0026:
            com.mpl.androidapp.filehandling.downloadservice.usecases.MplFileCreationUseCase r0 = r5.this$0
            kotlinx.coroutines.CancellableContinuation<com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult<? extends com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates>> r3 = r5.$coroutine
            java.lang.Throwable r4 = kotlin.Result.m884exceptionOrNullimpl(r6)
            if (r4 == 0) goto L_0x0035
            java.lang.String r4 = "Unable to create the file to be downloaded"
            r0.unSuccessfulUseCase(r3, r4)
        L_0x0035:
            com.mpl.androidapp.filehandling.downloadservice.usecases.MplFileCreationUseCase r0 = r5.this$0
            kotlinx.coroutines.CancellableContinuation<com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult<? extends com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates>> r3 = r5.$coroutine
            boolean r4 = r6 instanceof kotlin.Result.Failure
            r4 = r4 ^ 1
            if (r4 == 0) goto L_0x004e
            r4 = r6
            kotlin.Unit r4 = (kotlin.Unit) r4
            if (r2 == 0) goto L_0x0048
            r0.successfulUseCase(r3, r2)
            goto L_0x004e
        L_0x0048:
            java.lang.String r6 = "fileCreated"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            throw r1
        L_0x004e:
            kotlin.Result r0 = new kotlin.Result
            r0.<init>(r6)
            return r0
        L_0x0054:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.filehandling.downloadservice.usecases.MplFileCreationUseCase$execute$2$1$1$1$deferredDirCreation$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

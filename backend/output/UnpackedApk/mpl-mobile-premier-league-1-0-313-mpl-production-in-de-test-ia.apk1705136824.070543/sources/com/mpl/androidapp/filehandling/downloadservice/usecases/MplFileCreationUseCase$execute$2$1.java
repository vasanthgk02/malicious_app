package com.mpl.androidapp.filehandling.downloadservice.usecases;

import com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput;
import com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.filehandling.downloadservice.usecases.MplFileCreationUseCase$execute$2$1", f = "MplFileCreationUseCase.kt", l = {35}, m = "invokeSuspend")
/* compiled from: MplFileCreationUseCase.kt */
public final class MplFileCreationUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends GenericFileDownloadStates>> $coroutine;
    public final /* synthetic */ FeatureFileDownloadInput $parameters;
    public int label;
    public final /* synthetic */ MplFileCreationUseCase this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.mpl.androidapp.filehandling.downloadservice.usecases.MplFileCreationUseCase$execute$2$1$1", f = "MplFileCreationUseCase.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.mpl.androidapp.filehandling.downloadservice.usecases.MplFileCreationUseCase$execute$2$1$1  reason: invalid class name */
    /* compiled from: MplFileCreationUseCase.kt */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(featureFileDownloadInput, mplFileCreationUseCase, cancellableContinuation, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                TweetUtils.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                boolean isInternalStorage = featureFileDownloadInput.isInternalStorage();
                String fileDestination = featureFileDownloadInput.getFileDestination();
                String fileName = featureFileDownloadInput.getFileName();
                if (isInternalStorage) {
                    File externalFilesDir = mplFileCreationUseCase.getContext().getExternalFilesDir(fileDestination);
                    if (externalFilesDir != null) {
                        MplFileCreationUseCase$execute$2$1$1$1$deferredDirCreation$1 mplFileCreationUseCase$execute$2$1$1$1$deferredDirCreation$1 = new MplFileCreationUseCase$execute$2$1$1$1$deferredDirCreation$1(externalFilesDir, fileName, mplFileCreationUseCase, cancellableContinuation, null);
                        TypeUtilsKt.async$default(coroutineScope, null, null, mplFileCreationUseCase$execute$2$1$1$1$deferredDirCreation$1, 3, null);
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MplFileCreationUseCase$execute$2$1(FeatureFileDownloadInput featureFileDownloadInput, MplFileCreationUseCase mplFileCreationUseCase, CancellableContinuation<? super UseCaseResult<? extends GenericFileDownloadStates>> cancellableContinuation, Continuation<? super MplFileCreationUseCase$execute$2$1> continuation) {
        // this.$parameters = featureFileDownloadInput;
        // this.this$0 = mplFileCreationUseCase;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MplFileCreationUseCase$execute$2$1(this.$parameters, this.this$0, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MplFileCreationUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            CoroutineDispatcher coroutineDispatcher = Dispatchers.IO;
            final FeatureFileDownloadInput featureFileDownloadInput = this.$parameters;
            final MplFileCreationUseCase mplFileCreationUseCase = this.this$0;
            final CancellableContinuation<UseCaseResult<? extends GenericFileDownloadStates>> cancellableContinuation = this.$coroutine;
            AnonymousClass1 r1 = new AnonymousClass1(null);
            this.label = 1;
            if (TypeUtilsKt.withContext(coroutineDispatcher, r1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            try {
                TweetUtils.throwOnFailure(obj);
            } catch (Exception e2) {
                String message = e2.getMessage();
                if (message != null) {
                    this.this$0.unSuccessfulUseCase(this.$coroutine, message);
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}

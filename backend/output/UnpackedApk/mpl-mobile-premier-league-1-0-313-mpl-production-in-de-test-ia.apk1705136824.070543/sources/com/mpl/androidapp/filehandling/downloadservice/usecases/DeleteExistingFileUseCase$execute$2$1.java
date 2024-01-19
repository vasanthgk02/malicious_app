package com.mpl.androidapp.filehandling.downloadservice.usecases;

import com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput;
import com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.filehandling.downloadservice.usecases.DeleteExistingFileUseCase$execute$2$1", f = "DeleteExistingFileUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: DeleteExistingFileUseCase.kt */
public final class DeleteExistingFileUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends GenericFileDownloadStates>> $coroutine;
    public final /* synthetic */ FeatureFileDownloadInput $parameters;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ DeleteExistingFileUseCase this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.mpl.androidapp.filehandling.downloadservice.usecases.DeleteExistingFileUseCase$execute$2$1$1", f = "DeleteExistingFileUseCase.kt", l = {42}, m = "invokeSuspend")
    /* renamed from: com.mpl.androidapp.filehandling.downloadservice.usecases.DeleteExistingFileUseCase$execute$2$1$1  reason: invalid class name */
    /* compiled from: DeleteExistingFileUseCase.kt */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(deleteExistingFileUseCase, fileDestination, fileName, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int i = this.label;
            if (i == 0) {
                TweetUtils.throwOnFailure(obj);
                DeleteExistingFileUseCase deleteExistingFileUseCase = deleteExistingFileUseCase;
                String str = fileDestination;
                String str2 = fileName;
                this.label = 1;
                if (deleteExistingFileUseCase.deleteFileFromDevice(str, str2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else if (i == 1) {
                TweetUtils.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeleteExistingFileUseCase$execute$2$1(FeatureFileDownloadInput featureFileDownloadInput, DeleteExistingFileUseCase deleteExistingFileUseCase, CancellableContinuation<? super UseCaseResult<? extends GenericFileDownloadStates>> cancellableContinuation, Continuation<? super DeleteExistingFileUseCase$execute$2$1> continuation) {
        // this.$parameters = featureFileDownloadInput;
        // this.this$0 = deleteExistingFileUseCase;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeleteExistingFileUseCase$execute$2$1 deleteExistingFileUseCase$execute$2$1 = new DeleteExistingFileUseCase$execute$2$1(this.$parameters, this.this$0, this.$coroutine, continuation);
        deleteExistingFileUseCase$execute$2$1.L$0 = obj;
        return deleteExistingFileUseCase$execute$2$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeleteExistingFileUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            try {
                boolean isInternalStorage = this.$parameters.isInternalStorage();
                final String fileDestination = this.$parameters.getFileDestination();
                final String fileName = this.$parameters.getFileName();
                if (!(!isInternalStorage || fileDestination == null || fileName == null)) {
                    final DeleteExistingFileUseCase deleteExistingFileUseCase = this.this$0;
                    Deferred async$default = TypeUtilsKt.async$default(coroutineScope, null, null, new AnonymousClass1(null), 3, null);
                    final DeleteExistingFileUseCase deleteExistingFileUseCase2 = this.this$0;
                    final CancellableContinuation<UseCaseResult<? extends GenericFileDownloadStates>> cancellableContinuation = this.$coroutine;
                    async$default.invokeOnCompletion(new Function1<Throwable, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Throwable) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Throwable th) {
                            deleteExistingFileUseCase2.successfulUseCase(cancellableContinuation);
                        }
                    });
                }
            } catch (Exception e2) {
                this.this$0.unSuccessfulUseCase(this.$coroutine, e2.getMessage());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

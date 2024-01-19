package com.mpl.androidapp.filehandling.downloadservice.usecases;

import android.content.Context;
import com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput;
import com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates;
import com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates.DeleteFileInStorage;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u001eB\u001b\b\u0007\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ!\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0017\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\u00020\u00112\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u001bH\u0002J&\u0010\u001c\u001a\u00020\u00112\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0013H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/usecases/DeleteExistingFileUseCase;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/SuspendUseCase;", "Lcom/mpl/androidapp/filehandling/downloadservice/models/FeatureFileDownloadInput;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates;", "context", "Landroid/content/Context;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "deleteFileFromDevice", "", "clientPath", "", "fileName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "parameters", "(Lcom/mpl/androidapp/filehandling/downloadservice/models/FeatureFileDownloadInput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "successfulUseCase", "coroutine", "Lkotlinx/coroutines/CancellableContinuation;", "unSuccessfulUseCase", "message", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeleteExistingFileUseCase.kt */
public final class DeleteExistingFileUseCase extends SuspendUseCase<FeatureFileDownloadInput, UseCaseResult<? extends GenericFileDownloadStates>> {
    public static final Companion Companion = new Companion(null);
    public static final String MSG_FILE_DOES_NOT_EXIST = "File does not exit to perform deletion";
    public static final String MSG_FILE_PATH_EMPTY = "The file path passed is empty";
    public Context context;
    public final CoroutineDispatcher dispatcher;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/usecases/DeleteExistingFileUseCase$Companion;", "", "()V", "MSG_FILE_DOES_NOT_EXIST", "", "MSG_FILE_PATH_EMPTY", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DeleteExistingFileUseCase.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeleteExistingFileUseCase(Context context2, @IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        // Intrinsics.checkNotNullParameter(context2, "context");
        // Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        super(coroutineDispatcher);
        this.context = context2;
        this.dispatcher = coroutineDispatcher;
    }

    /* access modifiers changed from: private */
    public final Object deleteFileFromDevice(String str, String str2, Continuation<? super Unit> continuation) {
        return TypeUtilsKt.withContext(Dispatchers.Default, new DeleteExistingFileUseCase$deleteFileFromDevice$2(this, str, str2, null), continuation);
    }

    /* access modifiers changed from: private */
    public final void successfulUseCase(CancellableContinuation<? super UseCaseResult<? extends GenericFileDownloadStates>> cancellableContinuation) {
        cancellableContinuation.resumeWith(new Success(DeleteFileInStorage.INSTANCE));
    }

    /* access modifiers changed from: private */
    public final void unSuccessfulUseCase(CancellableContinuation<? super UseCaseResult<? extends GenericFileDownloadStates>> cancellableContinuation, String str) {
        cancellableContinuation.resumeWith(TweetUtils.createFailure(new Exception(str)));
    }

    public final Context getContext() {
        return this.context;
    }

    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public Object execute(FeatureFileDownloadInput featureFileDownloadInput, Continuation<? super UseCaseResult<? extends GenericFileDownloadStates>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(TweetUtils.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(getDispatcher()), null, null, new DeleteExistingFileUseCase$execute$2$1(featureFileDownloadInput, this, cancellableContinuationImpl, null), 3, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(continuation, "frame");
        }
        return result;
    }
}

package com.mpl.androidapp.filehandling.downloadservice.features;

import android.content.Context;
import android.widget.Toast;
import com.google.gson.Gson;
import com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput;
import com.mpl.androidapp.filehandling.downloadservice.models.GenericFileDownloadOutput;
import com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates;
import com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates.ErrorState;
import com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates.InitialState;
import com.mpl.androidapp.filehandling.downloadservice.usecases.CheckConnectivityUseCase;
import com.mpl.androidapp.filehandling.downloadservice.usecases.DeleteExistingFileUseCase;
import com.mpl.androidapp.filehandling.downloadservice.usecases.InitDownloadManagerUseCase;
import com.mpl.androidapp.filehandling.downloadservice.usecases.MplFileCreationUseCase;
import com.mpl.androidapp.filehandling.downloadservice.usecases.ValidateInputParamsUseCase;
import com.mpl.androidapp.miniprofile.extensions.StringExtKt;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.utils.MLogger;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element.DefaultImpls;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001GBK\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0011\u0010.\u001a\u00020/H@ø\u0001\u0000¢\u0006\u0002\u00100J\u0011\u00101\u001a\u00020/H@ø\u0001\u0000¢\u0006\u0002\u00100J\u0011\u00102\u001a\u00020/H@ø\u0001\u0000¢\u0006\u0002\u00100J\u0019\u00103\u001a\u00020/2\u0006\u00104\u001a\u000205H@ø\u0001\u0000¢\u0006\u0002\u00106J\b\u00107\u001a\u00020/H\u0002J6\u00108\u001a\u00020-2\b\u00109\u001a\u0004\u0018\u0001052\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010-2\b\u0010>\u001a\u0004\u0018\u00010-H\u0002J\u0016\u0010?\u001a\u00020/2\u0006\u0010&\u001a\u00020'2\u0006\u0010@\u001a\u00020\u0014J\u000e\u0010A\u001a\u00020/2\u0006\u0010\u0013\u001a\u00020\u0014J\u0019\u0010B\u001a\u00020/2\u0006\u0010C\u001a\u00020DH@ø\u0001\u0000¢\u0006\u0002\u0010EJ\u0011\u0010F\u001a\u00020/H@ø\u0001\u0000¢\u0006\u0002\u00100R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006H"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/features/GenericFileDownloadFeature;", "Lkotlinx/coroutines/CoroutineScope;", "checkConnectivityUseCase", "Lcom/mpl/androidapp/filehandling/downloadservice/usecases/CheckConnectivityUseCase;", "validateInputParamsUseCase", "Lcom/mpl/androidapp/filehandling/downloadservice/usecases/ValidateInputParamsUseCase;", "deleteExistingFileUseCase", "Lcom/mpl/androidapp/filehandling/downloadservice/usecases/DeleteExistingFileUseCase;", "mplFileCreationUseCase", "Lcom/mpl/androidapp/filehandling/downloadservice/usecases/MplFileCreationUseCase;", "initDownloadManagerUseCase", "Lcom/mpl/androidapp/filehandling/downloadservice/usecases/InitDownloadManagerUseCase;", "gson", "Lcom/google/gson/Gson;", "context", "Landroid/content/Context;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/mpl/androidapp/filehandling/downloadservice/usecases/CheckConnectivityUseCase;Lcom/mpl/androidapp/filehandling/downloadservice/usecases/ValidateInputParamsUseCase;Lcom/mpl/androidapp/filehandling/downloadservice/usecases/DeleteExistingFileUseCase;Lcom/mpl/androidapp/filehandling/downloadservice/usecases/MplFileCreationUseCase;Lcom/mpl/androidapp/filehandling/downloadservice/usecases/InitDownloadManagerUseCase;Lcom/google/gson/Gson;Landroid/content/Context;Lkotlinx/coroutines/CoroutineDispatcher;)V", "callback", "Lcom/mpl/androidapp/filehandling/downloadservice/features/GenericFileDownloadFeature$GenericFileDownloadFeatureCallback;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "fileDownloadStates", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates;", "getGson", "()Lcom/google/gson/Gson;", "setGson", "(Lcom/google/gson/Gson;)V", "input", "Lcom/mpl/androidapp/filehandling/downloadservice/models/FeatureFileDownloadInput;", "getInput", "()Lcom/mpl/androidapp/filehandling/downloadservice/models/FeatureFileDownloadInput;", "setInput", "(Lcom/mpl/androidapp/filehandling/downloadservice/models/FeatureFileDownloadInput;)V", "urlToDownloadFile", "", "checkForConnectivity", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "creatingPlaceholderFileForDownload", "deleteExistingFile", "initiateDownload", "fileCreated", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDestroyCoroutine", "prepareResponseStatus", "file", "status", "", "isConnectivityPresent", "feature", "responseMsg", "runFeature", "view", "setCallback", "useCaseError", "result", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult$Error;", "(Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateInputParams", "GenericFileDownloadFeatureCallback", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GenericFileDownloadFeature.kt */
public final class GenericFileDownloadFeature implements CoroutineScope {
    public GenericFileDownloadFeatureCallback callback;
    public final CheckConnectivityUseCase checkConnectivityUseCase;
    public Context context;
    public final DeleteExistingFileUseCase deleteExistingFileUseCase;
    public final CoroutineExceptionHandler exceptionHandler = new GenericFileDownloadFeature$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
    public MutableStateFlow<GenericFileDownloadStates> fileDownloadStates = StateFlowKt.MutableStateFlow(InitialState.INSTANCE);
    public Gson gson;
    public final InitDownloadManagerUseCase initDownloadManagerUseCase;
    public FeatureFileDownloadInput input;
    public final CoroutineDispatcher ioDispatcher;
    public final MplFileCreationUseCase mplFileCreationUseCase;
    public String urlToDownloadFile;
    public final ValidateInputParamsUseCase validateInputParamsUseCase;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/features/GenericFileDownloadFeature$GenericFileDownloadFeatureCallback;", "", "genericFileDownloadStatus", "", "response", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GenericFileDownloadFeature.kt */
    public interface GenericFileDownloadFeatureCallback {
        void genericFileDownloadStatus(String str);
    }

    public GenericFileDownloadFeature(CheckConnectivityUseCase checkConnectivityUseCase2, ValidateInputParamsUseCase validateInputParamsUseCase2, DeleteExistingFileUseCase deleteExistingFileUseCase2, MplFileCreationUseCase mplFileCreationUseCase2, InitDownloadManagerUseCase initDownloadManagerUseCase2, Gson gson2, Context context2, @IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(checkConnectivityUseCase2, "checkConnectivityUseCase");
        Intrinsics.checkNotNullParameter(validateInputParamsUseCase2, "validateInputParamsUseCase");
        Intrinsics.checkNotNullParameter(deleteExistingFileUseCase2, "deleteExistingFileUseCase");
        Intrinsics.checkNotNullParameter(mplFileCreationUseCase2, "mplFileCreationUseCase");
        Intrinsics.checkNotNullParameter(initDownloadManagerUseCase2, "initDownloadManagerUseCase");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        this.checkConnectivityUseCase = checkConnectivityUseCase2;
        this.validateInputParamsUseCase = validateInputParamsUseCase2;
        this.deleteExistingFileUseCase = deleteExistingFileUseCase2;
        this.mplFileCreationUseCase = mplFileCreationUseCase2;
        this.initDownloadManagerUseCase = initDownloadManagerUseCase2;
        this.gson = gson2;
        this.context = context2;
        this.ioDispatcher = coroutineDispatcher;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object checkForConnectivity(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$checkForConnectivity$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$checkForConnectivity$1 r0 = (com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$checkForConnectivity$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$checkForConnectivity$1 r0 = new com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$checkForConnectivity$1
            r0.<init>(r12, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 == r5) goto L_0x003b
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r13)
            goto L_0x00ca
        L_0x002e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0036:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r13)
            goto L_0x00cd
        L_0x003b:
            java.lang.Object r2 = r0.L$0
            com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature r2 = (com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature) r2
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r13)
            r6 = r2
            goto L_0x0057
        L_0x0044:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r13)
            com.mpl.androidapp.filehandling.downloadservice.usecases.CheckConnectivityUseCase r13 = r12.checkConnectivityUseCase
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r0.L$0 = r12
            r0.label = r5
            java.lang.Object r13 = r13.invoke(r2, r0)
            if (r13 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r6 = r12
        L_0x0057:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r13 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r13
            boolean r2 = r13 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            r7 = 0
            if (r2 == 0) goto L_0x00b9
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r13 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r13
            java.lang.Object r13 = r13.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r13 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r13
            java.lang.Object r13 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r13)
            com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates r13 = (com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates) r13
            if (r13 != 0) goto L_0x006f
            goto L_0x00cd
        L_0x006f:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates> r2 = r6.fileDownloadStates
            r2.setValue(r13)
            com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates$IsConnectedToInternet r13 = (com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates.IsConnectedToInternet) r13
            java.lang.Object[] r2 = new java.lang.Object[r5]
            r3 = 0
            boolean r5 = r13.isConnected()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            java.lang.String r8 = "Is device connected to internet => "
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r5)
            r2[r3] = r5
            java.lang.String r3 = "DownloadingFileFromServer"
            com.mpl.androidapp.utils.MLogger.i(r3, r2)
            boolean r13 = r13.isConnected()
            if (r13 == 0) goto L_0x009f
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r13 = r6.validateInputParams(r0)
            if (r13 != r1) goto L_0x00cd
            return r1
        L_0x009f:
            com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$GenericFileDownloadFeatureCallback r13 = r6.callback
            if (r13 != 0) goto L_0x00a4
            goto L_0x00cd
        L_0x00a4:
            r7 = 0
            r8 = 0
            r9 = 0
            com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput r0 = r6.getInput()
            java.lang.String r10 = r0.getFeatureName()
            java.lang.String r11 = "Not connected to internet"
            java.lang.String r0 = r6.prepareResponseStatus(r7, r8, r9, r10, r11)
            r13.genericFileDownloadStatus(r0)
            goto L_0x00cd
        L_0x00b9:
            boolean r2 = r13 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r2 == 0) goto L_0x00cd
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r13 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r13
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r13 = r6.useCaseError(r13, r0)
            if (r13 != r1) goto L_0x00ca
            return r1
        L_0x00ca:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x00cd:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature.checkForConnectivity(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object creatingPlaceholderFileForDownload(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$creatingPlaceholderFileForDownload$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$creatingPlaceholderFileForDownload$1 r0 = (com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$creatingPlaceholderFileForDownload$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$creatingPlaceholderFileForDownload$1 r0 = new com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$creatingPlaceholderFileForDownload$1
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 == r5) goto L_0x003b
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)
            goto L_0x00b3
        L_0x002e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0036:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)
            goto L_0x00b6
        L_0x003b:
            java.lang.Object r2 = r0.L$0
            com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature r2 = (com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature) r2
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)
            goto L_0x0058
        L_0x0043:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)
            com.mpl.androidapp.filehandling.downloadservice.usecases.MplFileCreationUseCase r10 = r9.mplFileCreationUseCase
            com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput r2 = r9.getInput()
            r0.L$0 = r9
            r0.label = r5
            java.lang.Object r10 = r10.invoke(r2, r0)
            if (r10 != r1) goto L_0x0057
            return r1
        L_0x0057:
            r2 = r9
        L_0x0058:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r10 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r10
            boolean r6 = r10 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            r7 = 0
            if (r6 == 0) goto L_0x00a2
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r10 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r10
            java.lang.Object r10 = r10.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r10 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r10
            java.lang.Object r10 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r10)
            com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates r10 = (com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates) r10
            if (r10 != 0) goto L_0x0070
            goto L_0x00b6
        L_0x0070:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates> r3 = r2.fileDownloadStates
            r3.setValue(r10)
            com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates$FilePlaceHolderForDownload r10 = (com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates.FilePlaceHolderForDownload) r10
            java.io.File r3 = r10.getFileCreated()
            boolean r3 = r3.isFile()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r6 = 0
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            java.lang.String r8 = "The file in the internal storage => "
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r3)
            r5[r6] = r3
            java.lang.String r3 = "DownloadingFileFromServer"
            com.mpl.androidapp.utils.MLogger.i(r3, r5)
            java.io.File r10 = r10.getFileCreated()
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r10 = r2.initiateDownload(r10, r0)
            if (r10 != r1) goto L_0x00b6
            return r1
        L_0x00a2:
            boolean r4 = r10 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r4 == 0) goto L_0x00b6
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r10 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r10
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r10 = r2.useCaseError(r10, r0)
            if (r10 != r1) goto L_0x00b3
            return r1
        L_0x00b3:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00b6:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature.creatingPlaceholderFileForDownload(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object deleteExistingFile(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$deleteExistingFile$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$deleteExistingFile$1 r0 = (com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$deleteExistingFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$deleteExistingFile$1 r0 = new com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$deleteExistingFile$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 == r5) goto L_0x003a
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x009e
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0036:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x00a1
        L_0x003a:
            java.lang.Object r2 = r0.L$0
            com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature r2 = (com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature) r2
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x0057
        L_0x0042:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            com.mpl.androidapp.filehandling.downloadservice.usecases.DeleteExistingFileUseCase r9 = r8.deleteExistingFileUseCase
            com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput r2 = r8.getInput()
            r0.L$0 = r8
            r0.label = r5
            java.lang.Object r9 = r9.invoke(r2, r0)
            if (r9 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r2 = r8
        L_0x0057:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r9
            boolean r6 = r9 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            r7 = 0
            if (r6 == 0) goto L_0x008d
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r9
            java.lang.Object r9 = r9.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r9
            java.lang.Object r9 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r9)
            com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates r9 = (com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates) r9
            if (r9 != 0) goto L_0x006f
            goto L_0x00a1
        L_0x006f:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates> r3 = r2.fileDownloadStates
            r3.setValue(r9)
            com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates$DeleteFileInStorage r9 = (com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates.DeleteFileInStorage) r9
            java.lang.Object[] r9 = new java.lang.Object[r5]
            r3 = 0
            java.lang.String r5 = "The file in the internal storage, if present is deleted"
            r9[r3] = r5
            java.lang.String r3 = "DownloadingFileFromServer"
            com.mpl.androidapp.utils.MLogger.i(r3, r9)
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r9 = r2.creatingPlaceholderFileForDownload(r0)
            if (r9 != r1) goto L_0x00a1
            return r1
        L_0x008d:
            boolean r4 = r9 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r4 == 0) goto L_0x00a1
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r9
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r9 = r2.useCaseError(r9, r0)
            if (r9 != r1) goto L_0x009e
            return r1
        L_0x009e:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x00a1:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature.deleteExistingFile(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object initiateDownload(java.io.File r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$initiateDownload$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$initiateDownload$1 r0 = (com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$initiateDownload$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$initiateDownload$1 r0 = new com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$initiateDownload$1
            r0.<init>(r12, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r5) goto L_0x0034
            if (r2 != r4) goto L_0x002c
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r14)
            goto L_0x00b9
        L_0x002c:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0034:
            java.lang.Object r13 = r0.L$0
            com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature r13 = (com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature) r13
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r14)
            r6 = r13
            goto L_0x005d
        L_0x003d:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r14)
            com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput r14 = r12.input
            if (r14 == 0) goto L_0x00c2
            java.lang.String r14 = r12.urlToDownloadFile
            if (r14 == 0) goto L_0x00c2
            com.mpl.androidapp.filehandling.downloadservice.models.CustomFileDownloadInput r2 = new com.mpl.androidapp.filehandling.downloadservice.models.CustomFileDownloadInput
            if (r14 == 0) goto L_0x00bc
            r2.<init>(r13, r14)
            com.mpl.androidapp.filehandling.downloadservice.usecases.InitDownloadManagerUseCase r13 = r12.initDownloadManagerUseCase
            r0.L$0 = r12
            r0.label = r5
            java.lang.Object r14 = r13.invoke(r2, r0)
            if (r14 != r1) goto L_0x005c
            return r1
        L_0x005c:
            r6 = r12
        L_0x005d:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r14 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r14
            boolean r13 = r14 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r13 == 0) goto L_0x00a8
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r14 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r14
            java.lang.Object r13 = r14.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r13 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r13
            java.lang.Object r13 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r13)
            com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates r13 = (com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates) r13
            if (r13 != 0) goto L_0x0074
            goto L_0x00c2
        L_0x0074:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates> r14 = r6.fileDownloadStates
            r14.setValue(r13)
            com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates$DownloadSuccessful r13 = (com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates.DownloadSuccessful) r13
            java.io.File r7 = r13.getFileDownloaded()
            java.lang.Object[] r13 = new java.lang.Object[r5]
            r14 = 0
            java.lang.String r0 = "The file in the internal storage => "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r7)
            r13[r14] = r0
            java.lang.String r14 = "DownloadingFileFromServer"
            com.mpl.androidapp.utils.MLogger.i(r14, r13)
            com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$GenericFileDownloadFeatureCallback r13 = r6.callback
            if (r13 != 0) goto L_0x0094
            goto L_0x00c2
        L_0x0094:
            r8 = 1
            r9 = 1
            com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput r14 = r6.getInput()
            java.lang.String r10 = r14.getFeatureName()
            java.lang.String r11 = "file created"
            java.lang.String r14 = r6.prepareResponseStatus(r7, r8, r9, r10, r11)
            r13.genericFileDownloadStatus(r14)
            goto L_0x00c2
        L_0x00a8:
            boolean r13 = r14 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r13 == 0) goto L_0x00c2
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r14 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r14
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r13 = r6.useCaseError(r14, r0)
            if (r13 != r1) goto L_0x00b9
            return r1
        L_0x00b9:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x00bc:
            java.lang.String r13 = "urlToDownloadFile"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r13)
            throw r3
        L_0x00c2:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature.initiateDownload(java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void onDestroyCoroutine() {
        MLogger.i("DownloadingFileFromServer", "Co-routine is canceled");
        TypeUtilsKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    private final String prepareResponseStatus(File file, boolean z, boolean z2, String str, String str2) {
        String str3;
        if (this.input == null || str == null || str2 == null) {
            return StringExtKt.getEMPTY(StringCompanionObject.INSTANCE);
        }
        String str4 = getInput().getFileDestination() + '/' + getInput().getFileName();
        Gson gson2 = this.gson;
        if (file == null) {
            str3 = null;
        } else {
            str3 = file.getAbsolutePath();
        }
        GenericFileDownloadOutput genericFileDownloadOutput = new GenericFileDownloadOutput(z, str4, str, z2, str2, String.valueOf(str3));
        String json = gson2.toJson((Object) genericFileDownloadOutput);
        Intrinsics.checkNotNullExpressionValue(json, "{\n            val filePa…th.toString()))\n        }");
        return json;
    }

    /* access modifiers changed from: private */
    public final Object useCaseError(Error error, Continuation<? super Unit> continuation) {
        String valueOf = String.valueOf(error.getException().getMessage());
        Toast.makeText(getContext(), "Hi", 1).show();
        this.fileDownloadStates.setValue(new ErrorState(valueOf));
        MLogger.e("DownloadingFileFromServer", Intrinsics.stringPlus("Error in file download:->", valueOf));
        GenericFileDownloadFeatureCallback genericFileDownloadFeatureCallback = this.callback;
        if (genericFileDownloadFeatureCallback != null) {
            genericFileDownloadFeatureCallback.genericFileDownloadStatus(prepareResponseStatus(null, false, true, getInput().getFeatureName(), valueOf));
        }
        onDestroyCoroutine();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object validateInputParams(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$validateInputParams$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$validateInputParams$1 r0 = (com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$validateInputParams$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$validateInputParams$1 r0 = new com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$validateInputParams$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 == r5) goto L_0x003b
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x00a9
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0036:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x00ac
        L_0x003b:
            java.lang.Object r2 = r0.L$0
            com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature r2 = (com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature) r2
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x005c
        L_0x0043:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput r9 = r8.input
            if (r9 == 0) goto L_0x00ac
            com.mpl.androidapp.filehandling.downloadservice.usecases.ValidateInputParamsUseCase r9 = r8.validateInputParamsUseCase
            com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput r2 = r8.getInput()
            r0.L$0 = r8
            r0.label = r5
            java.lang.Object r9 = r9.invoke(r2, r0)
            if (r9 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r2 = r8
        L_0x005c:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r9
            boolean r6 = r9 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            r7 = 0
            if (r6 == 0) goto L_0x0098
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r9
            java.lang.Object r9 = r9.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r9
            java.lang.Object r9 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r9)
            com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates r9 = (com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates) r9
            if (r9 != 0) goto L_0x0074
            goto L_0x00ac
        L_0x0074:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates> r3 = r2.fileDownloadStates
            r3.setValue(r9)
            com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates$ValidInputs r9 = (com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates.ValidInputs) r9
            java.lang.Object[] r3 = new java.lang.Object[r5]
            r5 = 0
            java.lang.String r6 = "Inputs are valid"
            r3[r5] = r6
            java.lang.String r5 = "DownloadingFileFromServer"
            com.mpl.androidapp.utils.MLogger.i(r5, r3)
            java.lang.String r9 = r9.getUrl()
            r2.urlToDownloadFile = r9
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r9 = r2.deleteExistingFile(r0)
            if (r9 != r1) goto L_0x00ac
            return r1
        L_0x0098:
            boolean r4 = r9 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r4 == 0) goto L_0x00ac
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r9
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r9 = r2.useCaseError(r9, r0)
            if (r9 != r1) goto L_0x00a9
            return r1
        L_0x00a9:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x00ac:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature.validateInputParams(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Context getContext() {
        return this.context;
    }

    public CoroutineContext getCoroutineContext() {
        return DefaultImpls.plus((JobSupport) TypeUtilsKt.SupervisorJob$default(null, 1), this.ioDispatcher).plus(this.exceptionHandler);
    }

    public final Gson getGson() {
        return this.gson;
    }

    public final FeatureFileDownloadInput getInput() {
        FeatureFileDownloadInput featureFileDownloadInput = this.input;
        if (featureFileDownloadInput != null) {
            return featureFileDownloadInput;
        }
        Intrinsics.throwUninitializedPropertyAccessException("input");
        throw null;
    }

    public final void runFeature(FeatureFileDownloadInput featureFileDownloadInput, GenericFileDownloadFeatureCallback genericFileDownloadFeatureCallback) {
        Intrinsics.checkNotNullParameter(featureFileDownloadInput, "input");
        Intrinsics.checkNotNullParameter(genericFileDownloadFeatureCallback, "view");
        setInput(featureFileDownloadInput);
        setCallback(genericFileDownloadFeatureCallback);
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(Dispatchers.getMain()), null, null, new GenericFileDownloadFeature$runFeature$1(this, null), 3, null);
    }

    public final void setCallback(GenericFileDownloadFeatureCallback genericFileDownloadFeatureCallback) {
        Intrinsics.checkNotNullParameter(genericFileDownloadFeatureCallback, "callback");
        this.callback = genericFileDownloadFeatureCallback;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final void setGson(Gson gson2) {
        Intrinsics.checkNotNullParameter(gson2, "<set-?>");
        this.gson = gson2;
    }

    public final void setInput(FeatureFileDownloadInput featureFileDownloadInput) {
        Intrinsics.checkNotNullParameter(featureFileDownloadInput, "<set-?>");
        this.input = featureFileDownloadInput;
    }
}

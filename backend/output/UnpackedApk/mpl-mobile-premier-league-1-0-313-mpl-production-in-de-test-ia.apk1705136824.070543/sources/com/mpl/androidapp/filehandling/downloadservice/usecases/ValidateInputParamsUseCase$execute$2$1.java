package com.mpl.androidapp.filehandling.downloadservice.usecases;

import com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput;
import com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.filehandling.downloadservice.usecases.ValidateInputParamsUseCase$execute$2$1", f = "ValidateInputParamsUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: ValidateInputParamsUseCase.kt */
public final class ValidateInputParamsUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends GenericFileDownloadStates>> $coroutine;
    public final /* synthetic */ FeatureFileDownloadInput $parameters;
    public int label;
    public final /* synthetic */ ValidateInputParamsUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ValidateInputParamsUseCase$execute$2$1(FeatureFileDownloadInput featureFileDownloadInput, ValidateInputParamsUseCase validateInputParamsUseCase, CancellableContinuation<? super UseCaseResult<? extends GenericFileDownloadStates>> cancellableContinuation, Continuation<? super ValidateInputParamsUseCase$execute$2$1> continuation) {
        // this.$parameters = featureFileDownloadInput;
        // this.this$0 = validateInputParamsUseCase;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ValidateInputParamsUseCase$execute$2$1(this.$parameters, this.this$0, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ValidateInputParamsUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b A[Catch:{ Exception -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b A[Catch:{ Exception -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049 A[Catch:{ Exception -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0058 A[ADDED_TO_REGION, Catch:{ Exception -> 0x00a4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r0 = r4.label
            if (r0 != 0) goto L_0x00af
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r5)
            com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput r5 = r4.$parameters     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r5 = r5.getBaseUrl()     // Catch:{ Exception -> 0x00a4 }
            com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput r0 = r4.$parameters     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x00a4 }
            com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput r1 = r4.$parameters     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r1 = r1.getFileName()     // Catch:{ Exception -> 0x00a4 }
            r2 = 0
            r3 = 1
            if (r5 == 0) goto L_0x0028
            int r5 = r5.length()     // Catch:{ Exception -> 0x00a4 }
            if (r5 != 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r5 = 0
            goto L_0x0029
        L_0x0028:
            r5 = 1
        L_0x0029:
            if (r5 == 0) goto L_0x003b
            com.mpl.androidapp.filehandling.downloadservice.usecases.ValidateInputParamsUseCase r5 = r4.this$0     // Catch:{ Exception -> 0x00a4 }
            kotlinx.coroutines.CancellableContinuation<com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult<? extends com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates>> r0 = r4.$coroutine     // Catch:{ Exception -> 0x00a4 }
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = "Invalid base url"
            r1.<init>(r2)     // Catch:{ Exception -> 0x00a4 }
            r5.failureUseCase(r0, r1)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00ac
        L_0x003b:
            if (r0 == 0) goto L_0x0046
            int r5 = r0.length()     // Catch:{ Exception -> 0x00a4 }
            if (r5 != 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r5 = 0
            goto L_0x0047
        L_0x0046:
            r5 = 1
        L_0x0047:
            if (r5 == 0) goto L_0x0058
            com.mpl.androidapp.filehandling.downloadservice.usecases.ValidateInputParamsUseCase r5 = r4.this$0     // Catch:{ Exception -> 0x00a4 }
            kotlinx.coroutines.CancellableContinuation<com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult<? extends com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates>> r0 = r4.$coroutine     // Catch:{ Exception -> 0x00a4 }
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = "Invalid file path"
            r1.<init>(r2)     // Catch:{ Exception -> 0x00a4 }
            r5.failureUseCase(r0, r1)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00ac
        L_0x0058:
            if (r1 == 0) goto L_0x0060
            int r5 = r1.length()     // Catch:{ Exception -> 0x00a4 }
            if (r5 != 0) goto L_0x0061
        L_0x0060:
            r2 = 1
        L_0x0061:
            if (r2 == 0) goto L_0x0072
            com.mpl.androidapp.filehandling.downloadservice.usecases.ValidateInputParamsUseCase r5 = r4.this$0     // Catch:{ Exception -> 0x00a4 }
            kotlinx.coroutines.CancellableContinuation<com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult<? extends com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates>> r0 = r4.$coroutine     // Catch:{ Exception -> 0x00a4 }
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = "Invalid file name"
            r1.<init>(r2)     // Catch:{ Exception -> 0x00a4 }
            r5.failureUseCase(r0, r1)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00ac
        L_0x0072:
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x00a4 }
            com.mpl.androidapp.filehandling.downloadservice.utils.DownloadServiceUtils r0 = com.mpl.androidapp.filehandling.downloadservice.utils.DownloadServiceUtils.INSTANCE     // Catch:{ Exception -> 0x00a4 }
            com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput r1 = r4.$parameters     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r1 = r1.getBaseUrl()     // Catch:{ Exception -> 0x00a4 }
            com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput r2 = r4.$parameters     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = r2.getPath()     // Catch:{ Exception -> 0x00a4 }
            com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput r3 = r4.$parameters     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r3 = r3.getFileName()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r0 = r0.urlConstruction(r1, r2, r3)     // Catch:{ Exception -> 0x00a4 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x00a4 }
            java.net.URI r5 = r5.toURI()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r0 = "URL(urlConstruction(base…Name)).toURI().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)     // Catch:{ Exception -> 0x00a4 }
            com.mpl.androidapp.filehandling.downloadservice.usecases.ValidateInputParamsUseCase r0 = r4.this$0     // Catch:{ Exception -> 0x00a4 }
            kotlinx.coroutines.CancellableContinuation<com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult<? extends com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates>> r1 = r4.$coroutine     // Catch:{ Exception -> 0x00a4 }
            r0.successUseCase(r1, r5)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00ac
        L_0x00a4:
            r5 = move-exception
            com.mpl.androidapp.filehandling.downloadservice.usecases.ValidateInputParamsUseCase r0 = r4.this$0
            kotlinx.coroutines.CancellableContinuation<com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult<? extends com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates>> r1 = r4.$coroutine
            r0.failureUseCase(r1, r5)
        L_0x00ac:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x00af:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.filehandling.downloadservice.usecases.ValidateInputParamsUseCase$execute$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

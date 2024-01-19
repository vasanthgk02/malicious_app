package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import com.mpl.androidapp.database.entity.GameAssetResource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$checkIfNotificationToBeDisplayed$2", f = "QueryDownload.kt", l = {396, 401, 411, 413}, m = "invokeSuspend")
/* compiled from: QueryDownload.kt */
public final class QueryDownload$checkIfNotificationToBeDisplayed$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ GameAssetResource $gameResource;
    public int label;
    public final /* synthetic */ QueryDownload this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public QueryDownload$checkIfNotificationToBeDisplayed$2(QueryDownload queryDownload, GameAssetResource gameAssetResource, Continuation<? super QueryDownload$checkIfNotificationToBeDisplayed$2> continuation) {
        // this.this$0 = queryDownload;
        // this.$gameResource = gameAssetResource;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QueryDownload$checkIfNotificationToBeDisplayed$2(this.this$0, this.$gameResource, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QueryDownload$checkIfNotificationToBeDisplayed$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0083 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r7.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0028
            if (r1 == r5) goto L_0x0024
            if (r1 == r4) goto L_0x0020
            if (r1 == r3) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            goto L_0x001b
        L_0x0013:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001b:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x009d
        L_0x0020:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x0077
        L_0x0024:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x0040
        L_0x0028:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r8 = r7.this$0
            com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitCheckUseCase r8 = r8.optionalDownloadVisitCheckUseCase
            com.mpl.androidapp.database.entity.GameAssetResource r1 = r7.$gameResource
            java.lang.String r1 = r1.getGameId()
            r7.label = r5
            java.lang.Object r8 = r8.invoke(r1, r7)
            if (r8 != r0) goto L_0x0040
            return r0
        L_0x0040:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r8
            boolean r1 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r1 == 0) goto L_0x008c
            java.lang.Object[] r1 = new java.lang.Object[r5]
            r2 = 0
            java.lang.String r5 = "checkIfNotificationToBeDisplayed success case"
            r1[r2] = r5
            java.lang.String r2 = "DownloadOfAssets"
            com.mpl.androidapp.utils.MLogger.d(r2, r1)
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r8
            java.lang.Object r8 = r8.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r8
            java.lang.Object r8 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r8)
            if (r8 == 0) goto L_0x0084
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$UserVisitToOptionalDownload r8 = (com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.UserVisitToOptionalDownload) r8
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$checkIfNotificationToBeDisplayed$2$1 r2 = new com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$checkIfNotificationToBeDisplayed$2$1
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r5 = r7.this$0
            r6 = 0
            r2.<init>(r5, r8, r6)
            r7.label = r4
            java.lang.Object r8 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.withContext(r1, r2, r7)
            if (r8 != r0) goto L_0x0077
            return r0
        L_0x0077:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r8 = r7.this$0
            com.mpl.androidapp.database.entity.GameAssetResource r1 = r7.$gameResource
            r7.label = r3
            java.lang.Object r8 = r8.downloadCompleteCleanup(r1, r7)
            if (r8 != r0) goto L_0x009d
            return r0
        L_0x0084:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.UserVisitToOptionalDownload"
            r8.<init>(r0)
            throw r8
        L_0x008c:
            boolean r1 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r1 == 0) goto L_0x009d
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r1 = r7.this$0
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r8
            r7.label = r2
            java.lang.Object r8 = r1.useCaseError(r8, r7)
            if (r8 != r0) goto L_0x009d
            return r0
        L_0x009d:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$checkIfNotificationToBeDisplayed$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

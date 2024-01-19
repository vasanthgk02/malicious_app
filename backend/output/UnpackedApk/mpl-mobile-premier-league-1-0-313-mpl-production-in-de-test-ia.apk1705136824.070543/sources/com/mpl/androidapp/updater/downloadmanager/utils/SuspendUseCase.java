package com.mpl.androidapp.updater.downloadmanager.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u000b\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u0000H¤@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f2\u0006\u0010\f\u001a\u00028\u0000HBø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/utils/SuspendUseCase;", "P", "R", "", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "tag", "", "getTag", "()Ljava/lang/String;", "execute", "parameters", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SuspendUseCase.kt */
public abstract class SuspendUseCase<P, R> {
    public final CoroutineDispatcher coroutineDispatcher;
    public final String tag;

    public SuspendUseCase(CoroutineDispatcher coroutineDispatcher2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "coroutineDispatcher");
        this.coroutineDispatcher = coroutineDispatcher2;
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
        this.tag = simpleName;
    }

    public abstract Object execute(P p, Continuation<? super R> continuation) throws RuntimeException;

    public final String getTag() {
        return this.tag;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(P r6, kotlin.coroutines.Continuation<? super com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult<? extends R>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase$invoke$1 r0 = (com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase$invoke$1 r0 = new com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase$invoke$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)     // Catch:{ Exception -> 0x0027 }
            goto L_0x0045
        L_0x0027:
            r6 = move-exception
            goto L_0x0048
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0031:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = r5.coroutineDispatcher     // Catch:{ Exception -> 0x0027 }
            com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase$invoke$2 r2 = new com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase$invoke$2     // Catch:{ Exception -> 0x0027 }
            r4 = 0
            r2.<init>(r5, r6, r4)     // Catch:{ Exception -> 0x0027 }
            r0.label = r3     // Catch:{ Exception -> 0x0027 }
            java.lang.Object r7 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.withContext(r7, r2, r0)     // Catch:{ Exception -> 0x0027 }
            if (r7 != r1) goto L_0x0045
            return r1
        L_0x0045:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r7     // Catch:{ Exception -> 0x0027 }
            goto L_0x004d
        L_0x0048:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r7 = new com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error
            r7.<init>(r6)
        L_0x004d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase.invoke(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

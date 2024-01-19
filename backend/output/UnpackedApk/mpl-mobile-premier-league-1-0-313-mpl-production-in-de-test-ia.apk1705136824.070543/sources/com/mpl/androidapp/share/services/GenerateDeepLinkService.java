package com.mpl.androidapp.share.services;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\u00102\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/mpl/androidapp/share/services/GenerateDeepLinkService;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "appFlyersApiService", "", "callback", "Lcom/mpl/androidapp/share/services/GenerateDeepLinkServiceImpl;", "payload", "", "(Lcom/mpl/androidapp/share/services/GenerateDeepLinkServiceImpl;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateDeepLink", "Lkotlin/Pair;", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GenerateDeepLinkService.kt */
public final class GenerateDeepLinkService {
    public static final Companion Companion = new Companion(null);
    public static final String DEFAULT_SHARE_TEXT = "Now watch game streams on MPL!\n\nBig prizes, Pro Players competing and Live streamed on MPL app.";
    public static final String SOMETHING_WENT_WRONG = "Something went wrong";
    public static final String TAG;
    public Context context;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/share/services/GenerateDeepLinkService$Companion;", "", "()V", "DEFAULT_SHARE_TEXT", "", "SOMETHING_WENT_WRONG", "TAG", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GenerateDeepLinkService.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String simpleName = GenerateDeepLinkService.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "GenerateDeepLinkService::class.java.simpleName");
        TAG = simpleName;
    }

    public GenerateDeepLinkService(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object generateDeepLink(java.lang.String r4, kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Boolean, java.lang.String>> r5) {
        /*
            r3 = this;
            kotlin.coroutines.SafeContinuation r0 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r1 = com.twitter.sdk.android.tweetui.TweetUtils.intercepted(r5)
            r0.<init>(r1)
            com.mpl.androidapp.share.services.GenerateDeepLinkService$generateDeepLink$2$value$1 r1 = new com.mpl.androidapp.share.services.GenerateDeepLinkService$generateDeepLink$2$value$1
            r1.<init>(r0)
            android.content.Context r2 = r3.getContext()
            com.mpl.androidapp.utils.CommonUtils.createAppsFlyerReferralLink(r2, r4, r1)
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.UNDECIDED
            if (r4 != r1) goto L_0x002a
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater<kotlin.coroutines.SafeContinuation<?>, java.lang.Object> r4 = kotlin.coroutines.SafeContinuation.RESULT
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            boolean r4 = r4.compareAndSet(r0, r1, r2)
            if (r4 == 0) goto L_0x0028
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            goto L_0x0035
        L_0x0028:
            java.lang.Object r4 = r0.result
        L_0x002a:
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.RESUMED
            if (r4 != r0) goto L_0x0031
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            goto L_0x0035
        L_0x0031:
            boolean r0 = r4 instanceof kotlin.Result.Failure
            if (r0 != 0) goto L_0x003f
        L_0x0035:
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r4 != r0) goto L_0x003e
            java.lang.String r0 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
        L_0x003e:
            return r4
        L_0x003f:
            kotlin.Result$Failure r4 = (kotlin.Result.Failure) r4
            java.lang.Throwable r4 = r4.exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.share.services.GenerateDeepLinkService.generateDeepLink(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object appFlyersApiService(GenerateDeepLinkServiceImpl generateDeepLinkServiceImpl, String str, Continuation<? super Unit> continuation) {
        Unit unit = null;
        try {
            TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(Dispatchers.IO), null, null, new GenerateDeepLinkService$appFlyersApiService$2(generateDeepLinkServiceImpl, this, str, null), 3, null);
        } catch (Exception e2) {
            if (generateDeepLinkServiceImpl != null) {
                generateDeepLinkServiceImpl.deepLinkApiFailure(String.valueOf(e2.getMessage()));
                unit = Unit.INSTANCE;
            }
            if (unit == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return unit;
            }
        }
        return Unit.INSTANCE;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }
}

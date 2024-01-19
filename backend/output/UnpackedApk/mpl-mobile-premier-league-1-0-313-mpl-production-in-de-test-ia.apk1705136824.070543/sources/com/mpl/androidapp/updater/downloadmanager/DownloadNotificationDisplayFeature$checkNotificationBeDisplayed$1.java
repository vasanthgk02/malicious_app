package com.mpl.androidapp.updater.downloadmanager;

import com.mpl.androidapp.notification.ApkDownloadNotificationData;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.UserVisitToOptionalDownload;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitCheckUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.DownloadNotificationDisplayFeature$checkNotificationBeDisplayed$1", f = "DownloadNotificationDisplayFeature.kt", l = {109, 114, 123}, m = "invokeSuspend")
/* compiled from: DownloadNotificationDisplayFeature.kt */
public final class DownloadNotificationDisplayFeature$checkNotificationBeDisplayed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ApkDownloadNotificationData $apkDownloadNotificationData;
    public final /* synthetic */ String $gameId;
    public final /* synthetic */ int $progress;
    public int label;
    public final /* synthetic */ DownloadNotificationDisplayFeature this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.DownloadNotificationDisplayFeature$checkNotificationBeDisplayed$1$1", f = "DownloadNotificationDisplayFeature.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.mpl.androidapp.updater.downloadmanager.DownloadNotificationDisplayFeature$checkNotificationBeDisplayed$1$1  reason: invalid class name */
    /* compiled from: DownloadNotificationDisplayFeature.kt */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(downloadNotificationDisplayFeature, apkDownloadNotificationData, i2, str2, continuation);
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                TweetUtils.throwOnFailure(obj);
                DownloadNotificationDisplayFeatureCallback access$getCallback$p = downloadNotificationDisplayFeature.callback;
                if (access$getCallback$p != null) {
                    access$getCallback$p.showNotification(apkDownloadNotificationData);
                }
                if (i2 == 100) {
                    downloadNotificationDisplayFeature.deleteFeature(str2);
                    downloadNotificationDisplayFeature.cleanUp();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DownloadNotificationDisplayFeature$checkNotificationBeDisplayed$1(DownloadNotificationDisplayFeature downloadNotificationDisplayFeature, String str, ApkDownloadNotificationData apkDownloadNotificationData, int i, Continuation<? super DownloadNotificationDisplayFeature$checkNotificationBeDisplayed$1> continuation) {
        // this.this$0 = downloadNotificationDisplayFeature;
        // this.$gameId = str;
        // this.$apkDownloadNotificationData = apkDownloadNotificationData;
        // this.$progress = i;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DownloadNotificationDisplayFeature$checkNotificationBeDisplayed$1 downloadNotificationDisplayFeature$checkNotificationBeDisplayed$1 = new DownloadNotificationDisplayFeature$checkNotificationBeDisplayed$1(this.this$0, this.$gameId, this.$apkDownloadNotificationData, this.$progress, continuation);
        return downloadNotificationDisplayFeature$checkNotificationBeDisplayed$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadNotificationDisplayFeature$checkNotificationBeDisplayed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            OptionalDownloadVisitCheckUseCase access$getOptionalDownloadVisitCheckUseCase$p = this.this$0.optionalDownloadVisitCheckUseCase;
            String str = this.$gameId;
            this.label = 1;
            obj = access$getOptionalDownloadVisitCheckUseCase$p.invoke(str, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            TweetUtils.throwOnFailure(obj);
        } else if (i == 2 || i == 3) {
            TweetUtils.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        UseCaseResult useCaseResult = (UseCaseResult) obj;
        if (useCaseResult instanceof Success) {
            Object data = UseCaseResultKt.getData((UseCaseResult) ((Success) useCaseResult).getValue());
            if (data != null) {
                UserVisitToOptionalDownload userVisitToOptionalDownload = (UserVisitToOptionalDownload) data;
                if (userVisitToOptionalDownload.isVisitTrue()) {
                    this.this$0.queryDownloadState.setValue(userVisitToOptionalDownload);
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    final DownloadNotificationDisplayFeature downloadNotificationDisplayFeature = this.this$0;
                    final ApkDownloadNotificationData apkDownloadNotificationData = this.$apkDownloadNotificationData;
                    final int i2 = this.$progress;
                    final String str2 = this.$gameId;
                    AnonymousClass1 r4 = new AnonymousClass1(null);
                    this.label = 2;
                    if (TypeUtilsKt.withContext(main, r4, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.UserVisitToOptionalDownload");
            }
        } else if (useCaseResult instanceof Error) {
            this.label = 3;
            if (this.this$0.useCaseError((Error) useCaseResult, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}

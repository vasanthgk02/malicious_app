package com.mpl.androidapp.notification.usecases;

import android.content.Context;
import android.os.Bundle;
import com.mpl.androidapp.notification.features.DeepLinkScreens;
import com.mpl.androidapp.notification.features.NotificationFeatureNames;
import com.mpl.androidapp.notification.models.NotificationLaunchIntentInput;
import com.mpl.androidapp.notification.states.MPLNotificationStates;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.CharsKt__CharKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001c2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u001cB\u001b\b\u0007\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/mpl/androidapp/notification/usecases/BuildLaunchIntentUseCase;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/SuspendUseCase;", "Lcom/mpl/androidapp/notification/models/NotificationLaunchIntentInput;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates;", "context", "Landroid/content/Context;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "execute", "parameters", "(Lcom/mpl/androidapp/notification/models/NotificationLaunchIntentInput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setScreenNavigation", "", "featureName", "", "bundle", "Landroid/os/Bundle;", "gameId", "", "tournamentId", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BuildLaunchIntentUseCase.kt */
public final class BuildLaunchIntentUseCase extends SuspendUseCase<NotificationLaunchIntentInput, UseCaseResult<? extends MPLNotificationStates>> {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_ACTION = "action";
    public static final String KEY_ACTION_PARAMS = "actionParams";
    public static final String VAL_OPEN_DEEP_LINK = "OPEN_DEEP_LINK";
    public Context context;
    public final CoroutineDispatcher dispatcher;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/notification/usecases/BuildLaunchIntentUseCase$Companion;", "", "()V", "KEY_ACTION", "", "KEY_ACTION_PARAMS", "VAL_OPEN_DEEP_LINK", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BuildLaunchIntentUseCase.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public BuildLaunchIntentUseCase(Context context2, @IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        // Intrinsics.checkNotNullParameter(context2, "context");
        // Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        super(coroutineDispatcher);
        this.context = context2;
        this.dispatcher = coroutineDispatcher;
    }

    /* access modifiers changed from: private */
    public final void setScreenNavigation(String str, Bundle bundle, int i, int i2) {
        DeepLinkScreens.INSTANCE.deepLinkTournamentDetails(i2);
        String deepLinkGamesTab = DeepLinkScreens.INSTANCE.deepLinkGamesTab(i);
        DeepLinkScreens.INSTANCE.deepLinkRummyGameList(i);
        DeepLinkScreens.INSTANCE.deepLinkLobbyDetails(i2);
        DeepLinkScreens.INSTANCE.deepLinkHome();
        if (CharsKt__CharKt.equals(str, (String) NotificationFeatureNames.NOTIFICATION_UGC_FEATURE_TAG, true)) {
            bundle.putString("actionParams", deepLinkGamesTab);
        }
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

    public Object execute(NotificationLaunchIntentInput notificationLaunchIntentInput, Continuation<? super UseCaseResult<? extends MPLNotificationStates>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(TweetUtils.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        TypeUtilsKt.runBlocking(getDispatcher(), new BuildLaunchIntentUseCase$execute$2$1(notificationLaunchIntentInput, this, cancellableContinuationImpl, null));
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(continuation, "frame");
        }
        return result;
    }
}

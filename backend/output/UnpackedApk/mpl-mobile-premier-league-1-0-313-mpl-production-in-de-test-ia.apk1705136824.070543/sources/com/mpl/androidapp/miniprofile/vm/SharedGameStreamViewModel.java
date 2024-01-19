package com.mpl.androidapp.miniprofile.vm;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build;
import androidx.core.widget.CompoundButtonCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.Gson;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.miniprofile.ct.C.BroadcastReacted;
import com.mpl.androidapp.miniprofile.ct.C.Config;
import com.mpl.androidapp.miniprofile.ct.C.OrientationChanged;
import com.mpl.androidapp.miniprofile.kotlin.model.Broadcast;
import com.mpl.androidapp.miniprofile.kotlin.model.GameBroadcastConfig;
import com.mpl.androidapp.miniprofile.kotlin.model.ProfileConfig;
import com.mpl.androidapp.miniprofile.kotlin.model.ResponseWrapper;
import com.mpl.androidapp.miniprofile.models.MiniProfileParams;
import com.mpl.androidapp.miniprofile.models.ProfileDetails;
import com.mpl.androidapp.utils.MLogger;
import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.actions.configs.HanselConfigs;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0001\u001a\u00020\u00132\u0007\u0010\u0001\u001a\u00020&H\u0002J\b\u0010\u0001\u001a\u00030\u0001J\b\u00106\u001a\u00020&H\u0002J\t\u0010\u0001\u001a\u00020\u0010H\u0014J\u0007\u0010\u0001\u001a\u00020\u0010J\u001b\u0010\u0001\u001a\u00020\u00102\u0007\u0010\u0001\u001a\u00020\u00132\t\b\u0002\u0010\u0001\u001a\u00020.J\u0010\u0010\u0001\u001a\u00020\u00102\u0007\u0010\u0001\u001a\u00020\u0013J\u001b\u0010\u0001\u001a\u00020\u00102\u0007\u0010\u0001\u001a\u00020\u00132\t\b\u0002\u0010\u0001\u001a\u00020.J\u0010\u0010\u0001\u001a\u00020\u00102\u0007\u0010\u0001\u001a\u00020\u0013J\u0010\u0010\u0001\u001a\u00020\u00102\u0007\u0010\u0001\u001a\u00020&J\u0010\u0010\u0001\u001a\u00020\u00102\u0007\u0010\u0001\u001a\u00020\u0013J\u0007\u0010\u0001\u001a\u00020\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR'\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\u00068FX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\f\u0010\tR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u0004R\u001a\u0010\u001e\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\tR\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\tR\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\tR\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020&0\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\tR\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u0006¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\tR\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020&0\u0006¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\tR\u001a\u00102\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020&0\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\tR\u001a\u00107\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020&0\u0006¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\tR\u001a\u0010:\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00103\"\u0004\b;\u00105R\u001a\u0010<\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00103\"\u0004\b>\u00105R\u001a\u0010?\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0018\"\u0004\bA\u0010\u001aR\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\tR\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020&0\u0006¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\tR\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\tR\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020&0\u0006¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\tR\u0017\u0010J\u001a\b\u0012\u0004\u0012\u00020&0\u0006¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\tR\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020&0\u0006¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\tR\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\tR \u0010P\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\t\"\u0004\bR\u0010SR\u0017\u0010T\u001a\b\u0012\u0004\u0012\u00020U0\u0006¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\tR\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\tR\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020&0\u0006¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010\tR\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0\u0006¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\tR\u0017\u0010^\u001a\b\u0012\u0004\u0012\u00020&0\u0006¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\tR\u0017\u0010`\u001a\b\u0012\u0004\u0012\u00020&0\u0006¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\tR\u0017\u0010b\u001a\b\u0012\u0004\u0012\u00020U0\u0006¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\tR\u0017\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006¢\u0006\b\n\u0000\u001a\u0004\be\u0010\tR\u0017\u0010f\u001a\b\u0012\u0004\u0012\u00020&0\u0006¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\tR\u0017\u0010h\u001a\b\u0012\u0004\u0012\u00020&0\u0006¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\tR\u0017\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00160k¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0017\u0010n\u001a\b\u0012\u0004\u0012\u00020&0\u0006¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\tR\u0017\u0010p\u001a\b\u0012\u0004\u0012\u00020&0\u0006¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\tR\u001a\u0010r\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001a\u0010w\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010t\"\u0004\by\u0010vR\u001a\u0010z\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010t\"\u0004\b|\u0010vR\u0017\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\tR\u0018\u0010\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\tR\u0019\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\t¨\u0006\u0001"}, d2 = {"Lcom/mpl/androidapp/miniprofile/vm/SharedGameStreamViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "broadcastDetails", "Landroidx/lifecycle/MutableLiveData;", "Lcom/mpl/androidapp/miniprofile/kotlin/model/Broadcast;", "getBroadcastDetails", "()Landroidx/lifecycle/MutableLiveData;", "broadcastDetailsLiveData", "Lcom/mpl/androidapp/miniprofile/kotlin/model/ResponseWrapper;", "getBroadcastDetailsLiveData", "broadcastDetailsLiveData$delegate", "Lkotlin/Lazy;", "broadcastDetailsLoading", "", "getBroadcastDetailsLoading", "closeTournamentDetails", "", "getCloseTournamentDetails", "configHeartThrottle", "", "getConfigHeartThrottle", "()J", "setConfigHeartThrottle", "(J)V", "getContext", "()Landroid/content/Context;", "setContext", "currentBroadcastId", "getCurrentBroadcastId", "()Ljava/lang/String;", "setCurrentBroadcastId", "(Ljava/lang/String;)V", "currentPositionLiveData", "getCurrentPositionLiveData", "externalShareVisibility", "", "getExternalShareVisibility", "gameBroadcastConfig", "Lcom/mpl/androidapp/miniprofile/kotlin/model/GameBroadcastConfig;", "getGameBroadcastConfig", "globalChatEnabledV2Config", "getGlobalChatEnabledV2Config", "heartCntByBtnClicks", "", "getHeartCntByBtnClicks", "internalShareVisibility", "getInternalShareVisibility", "isChatEnabled", "()Z", "setChatEnabled", "(Z)V", "isFeatureEnabled", "isGameStatsEnabled", "setGameStatsEnabled", "isSegmentsEnabledFromConfig", "isUserNameEnabledInConfig", "setUserNameEnabledInConfig", "isheartCntInitialValueSet", "getIsheartCntInitialValueSet", "setIsheartCntInitialValueSet", "launchTime", "getLaunchTime", "setLaunchTime", "onActionMenuSelected", "getOnActionMenuSelected", "onChangeQualityClicked", "getOnChangeQualityClicked", "onCloseIconClicked", "getOnCloseIconClicked", "onFullScreenButtonClicked", "getOnFullScreenButtonClicked", "onRotateScreenClicked", "getOnRotateScreenClicked", "playerLoaded", "getPlayerLoaded", "recommendedVideoClicked", "getRecommendedVideoClicked", "sendCTADeepLink", "getSendCTADeepLink", "setSendCTADeepLink", "(Landroidx/lifecycle/MutableLiveData;)V", "sendChatToPlayer", "Lcom/mpl/androidapp/miniprofile/models/ProfileDetails;", "getSendChatToPlayer", "shareText", "getShareText", "shareVisibility", "getShareVisibility", "showBottomSheetPlayerMiniProfile", "Lcom/mpl/androidapp/miniprofile/models/MiniProfileParams;", "getShowBottomSheetPlayerMiniProfile", "showChatButton", "getShowChatButton", "showChatLiveData", "getShowChatLiveData", "showCompleteProfile", "getShowCompleteProfile", "showMessageFragment", "getShowMessageFragment", "showPlayers", "getShowPlayers", "showRecommendedVideos", "getShowRecommendedVideos", "showUgcSnippetsFragment", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getShowUgcSnippetsFragment", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "startStreamsScreen", "getStartStreamsScreen", "startTournamentDetails", "getStartTournamentDetails", "totalHeartsSent", "getTotalHeartsSent", "()I", "setTotalHeartsSent", "(I)V", "totalHeartsSentInSession", "getTotalHeartsSentInSession", "setTotalHeartsSentInSession", "totalMessagesSentInSession", "getTotalMessagesSentInSession", "setTotalMessagesSentInSession", "tournamentDetailsInReact", "getTournamentDetailsInReact", "updateFollowedUsrOnPlayersListIfOpened", "getUpdateFollowedUsrOnPlayersListIfOpened", "vodGeneratedListener", "getVodGeneratedListener", "getOrientation", "chatShowed", "getProfileConfig", "Lcom/mpl/androidapp/miniprofile/kotlin/model/ProfileConfig;", "onCleared", "resetBroadcastVariables", "sendHeartCountEvent", "status", "aggregatedCount", "sendHeartFailureEvent", "sendMessageCountEvent", "sendMessageFailureEvent", "sendOrientationChangedEvent", "sendProfileFollowedEvent", "entryPoint", "setGameBroadcastConfig", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SharedGameStreamViewModel.kt */
public final class SharedGameStreamViewModel extends ViewModel {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "SharedGameStreamViewModel";
    public final MutableLiveData<Broadcast> broadcastDetails = new MutableLiveData<>();
    public final Lazy broadcastDetailsLiveData$delegate = TweetUtils.lazy((Function0<? extends T>) SharedGameStreamViewModel$broadcastDetailsLiveData$2.INSTANCE);
    public final MutableLiveData<Unit> broadcastDetailsLoading = new MutableLiveData<>();
    public final MutableLiveData<String> closeTournamentDetails = new MutableLiveData<>();
    public long configHeartThrottle;
    public Context context;
    public String currentBroadcastId = "";
    public final MutableLiveData<Unit> currentPositionLiveData = new MutableLiveData<>();
    public final MutableLiveData<Boolean> externalShareVisibility = new MutableLiveData<>();
    public final MutableLiveData<GameBroadcastConfig> gameBroadcastConfig = new MutableLiveData<>();
    public final MutableLiveData<Boolean> globalChatEnabledV2Config = new MutableLiveData<>();
    public final MutableLiveData<Integer> heartCntByBtnClicks = new MutableLiveData<>();
    public final MutableLiveData<Boolean> internalShareVisibility = new MutableLiveData<>();
    public boolean isChatEnabled;
    public final MutableLiveData<Boolean> isFeatureEnabled = new MutableLiveData<>();
    public boolean isGameStatsEnabled;
    public final MutableLiveData<Boolean> isSegmentsEnabledFromConfig = new MutableLiveData<>();
    public boolean isUserNameEnabledInConfig;
    public boolean isheartCntInitialValueSet;
    public long launchTime = System.currentTimeMillis();
    public final MutableLiveData<Broadcast> onActionMenuSelected = new MutableLiveData<>();
    public final MutableLiveData<Boolean> onChangeQualityClicked = new MutableLiveData<>();
    public final MutableLiveData<Unit> onCloseIconClicked = new MutableLiveData<>();
    public final MutableLiveData<Boolean> onFullScreenButtonClicked = new MutableLiveData<>();
    public final MutableLiveData<Boolean> onRotateScreenClicked = new MutableLiveData<>();
    public final MutableLiveData<Boolean> playerLoaded = new MutableLiveData<>();
    public final MutableLiveData<Broadcast> recommendedVideoClicked = new MutableLiveData<>();
    public MutableLiveData<String> sendCTADeepLink = new MutableLiveData<>();
    public final MutableLiveData<ProfileDetails> sendChatToPlayer = new MutableLiveData<>();
    public final MutableLiveData<String> shareText = new MutableLiveData<>();
    public final MutableLiveData<Boolean> shareVisibility = new MutableLiveData<>();
    public final MutableLiveData<MiniProfileParams> showBottomSheetPlayerMiniProfile = new MutableLiveData<>();
    public final MutableLiveData<Boolean> showChatButton = new MutableLiveData<>();
    public final MutableLiveData<Boolean> showChatLiveData = new MutableLiveData<>();
    public final MutableLiveData<ProfileDetails> showCompleteProfile = new MutableLiveData<>();
    public final MutableLiveData<Unit> showMessageFragment = new MutableLiveData<>();
    public final MutableLiveData<Boolean> showPlayers = new MutableLiveData<>();
    public final MutableLiveData<Boolean> showRecommendedVideos = new MutableLiveData<>();
    public final MutableSharedFlow<Long> showUgcSnippetsFragment = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7);
    public final MutableLiveData<Boolean> startStreamsScreen = new MutableLiveData<>();
    public final MutableLiveData<Boolean> startTournamentDetails = new MutableLiveData<>();
    public int totalHeartsSent;
    public int totalHeartsSentInSession;
    public int totalMessagesSentInSession;
    public final MutableLiveData<Broadcast> tournamentDetailsInReact = new MutableLiveData<>();
    public final MutableLiveData<String> updateFollowedUsrOnPlayersListIfOpened = new MutableLiveData<>();
    public final MutableLiveData<Unit> vodGeneratedListener = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/miniprofile/vm/SharedGameStreamViewModel$Companion;", "", "()V", "TAG", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SharedGameStreamViewModel.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SharedGameStreamViewModel(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    /* access modifiers changed from: private */
    public final String getOrientation(boolean z) {
        return z ? OrientationChanged.ORIENTATION_IMMERSIVE : OrientationChanged.ORIENTATION_LANDSCAPE;
    }

    public static /* synthetic */ void sendHeartCountEvent$default(SharedGameStreamViewModel sharedGameStreamViewModel, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = sharedGameStreamViewModel.totalHeartsSentInSession;
        }
        sharedGameStreamViewModel.sendHeartCountEvent(str, i);
    }

    public static /* synthetic */ void sendMessageCountEvent$default(SharedGameStreamViewModel sharedGameStreamViewModel, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = sharedGameStreamViewModel.totalMessagesSentInSession;
        }
        sharedGameStreamViewModel.sendMessageCountEvent(str, i);
    }

    public final MutableLiveData<Broadcast> getBroadcastDetails() {
        return this.broadcastDetails;
    }

    public final MutableLiveData<ResponseWrapper<Broadcast>> getBroadcastDetailsLiveData() {
        return (MutableLiveData) this.broadcastDetailsLiveData$delegate.getValue();
    }

    public final MutableLiveData<Unit> getBroadcastDetailsLoading() {
        return this.broadcastDetailsLoading;
    }

    public final MutableLiveData<String> getCloseTournamentDetails() {
        return this.closeTournamentDetails;
    }

    public final long getConfigHeartThrottle() {
        return this.configHeartThrottle;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getCurrentBroadcastId() {
        return this.currentBroadcastId;
    }

    public final MutableLiveData<Unit> getCurrentPositionLiveData() {
        return this.currentPositionLiveData;
    }

    public final MutableLiveData<Boolean> getExternalShareVisibility() {
        return this.externalShareVisibility;
    }

    public final MutableLiveData<GameBroadcastConfig> getGameBroadcastConfig() {
        return this.gameBroadcastConfig;
    }

    public final MutableLiveData<Boolean> getGlobalChatEnabledV2Config() {
        return this.globalChatEnabledV2Config;
    }

    public final MutableLiveData<Integer> getHeartCntByBtnClicks() {
        return this.heartCntByBtnClicks;
    }

    public final MutableLiveData<Boolean> getInternalShareVisibility() {
        return this.internalShareVisibility;
    }

    public final boolean getIsheartCntInitialValueSet() {
        return this.isheartCntInitialValueSet;
    }

    public final long getLaunchTime() {
        return this.launchTime;
    }

    public final MutableLiveData<Broadcast> getOnActionMenuSelected() {
        return this.onActionMenuSelected;
    }

    public final MutableLiveData<Boolean> getOnChangeQualityClicked() {
        return this.onChangeQualityClicked;
    }

    public final MutableLiveData<Unit> getOnCloseIconClicked() {
        return this.onCloseIconClicked;
    }

    public final MutableLiveData<Boolean> getOnFullScreenButtonClicked() {
        return this.onFullScreenButtonClicked;
    }

    public final MutableLiveData<Boolean> getOnRotateScreenClicked() {
        return this.onRotateScreenClicked;
    }

    public final MutableLiveData<Boolean> getPlayerLoaded() {
        return this.playerLoaded;
    }

    public final ProfileConfig getProfileConfig() {
        try {
            JSONObject normalConfig = ConfigManager.getNormalConfig();
            if (normalConfig != null) {
                Object fromJson = new Gson().fromJson(normalConfig.getString(Config.ZK_KEY_USER_NAME_ENABLED_KEY).toString(), ProfileConfig.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "{\n            val profil…ig::class.java)\n        }");
                return (ProfileConfig) fromJson;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        } catch (Exception unused) {
            MLogger.e(TAG, "ProfileConfig is null");
            ProfileConfig profileConfig = new ProfileConfig(false, false, false, 7, null);
            return profileConfig;
        }
    }

    public final MutableLiveData<Broadcast> getRecommendedVideoClicked() {
        return this.recommendedVideoClicked;
    }

    public final MutableLiveData<String> getSendCTADeepLink() {
        return this.sendCTADeepLink;
    }

    public final MutableLiveData<ProfileDetails> getSendChatToPlayer() {
        return this.sendChatToPlayer;
    }

    public final MutableLiveData<String> getShareText() {
        return this.shareText;
    }

    public final MutableLiveData<Boolean> getShareVisibility() {
        return this.shareVisibility;
    }

    public final MutableLiveData<MiniProfileParams> getShowBottomSheetPlayerMiniProfile() {
        return this.showBottomSheetPlayerMiniProfile;
    }

    public final MutableLiveData<Boolean> getShowChatButton() {
        return this.showChatButton;
    }

    public final MutableLiveData<Boolean> getShowChatLiveData() {
        return this.showChatLiveData;
    }

    public final MutableLiveData<ProfileDetails> getShowCompleteProfile() {
        return this.showCompleteProfile;
    }

    public final MutableLiveData<Unit> getShowMessageFragment() {
        return this.showMessageFragment;
    }

    public final MutableLiveData<Boolean> getShowPlayers() {
        return this.showPlayers;
    }

    public final MutableLiveData<Boolean> getShowRecommendedVideos() {
        return this.showRecommendedVideos;
    }

    public final MutableSharedFlow<Long> getShowUgcSnippetsFragment() {
        return this.showUgcSnippetsFragment;
    }

    public final MutableLiveData<Boolean> getStartStreamsScreen() {
        return this.startStreamsScreen;
    }

    public final MutableLiveData<Boolean> getStartTournamentDetails() {
        return this.startTournamentDetails;
    }

    public final int getTotalHeartsSent() {
        return this.totalHeartsSent;
    }

    public final int getTotalHeartsSentInSession() {
        return this.totalHeartsSentInSession;
    }

    public final int getTotalMessagesSentInSession() {
        return this.totalMessagesSentInSession;
    }

    public final MutableLiveData<Broadcast> getTournamentDetailsInReact() {
        return this.tournamentDetailsInReact;
    }

    public final MutableLiveData<String> getUpdateFollowedUsrOnPlayersListIfOpened() {
        return this.updateFollowedUsrOnPlayersListIfOpened;
    }

    public final MutableLiveData<Unit> getVodGeneratedListener() {
        return this.vodGeneratedListener;
    }

    public final boolean isChatEnabled() {
        return this.isChatEnabled;
    }

    /* renamed from: isFeatureEnabled  reason: collision with other method in class */
    public final MutableLiveData<Boolean> m19isFeatureEnabled() {
        return this.isFeatureEnabled;
    }

    public final boolean isGameStatsEnabled() {
        return this.isGameStatsEnabled;
    }

    public final MutableLiveData<Boolean> isSegmentsEnabledFromConfig() {
        return this.isSegmentsEnabledFromConfig;
    }

    public final boolean isUserNameEnabledInConfig() {
        return this.isUserNameEnabledInConfig;
    }

    public void onCleared() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("onCleared -> [MessageCount : ");
        outline73.append(this.totalMessagesSentInSession);
        outline73.append(", HeartCount : ");
        MLogger.d(TAG, GeneratedOutlineSupport.outline56(outline73, this.totalHeartsSentInSession, ']'));
        sendHeartCountEvent$default(this, "Success", 0, 2, null);
        sendMessageCountEvent$default(this, "Success", 0, 2, null);
        super.onCleared();
    }

    public final void resetBroadcastVariables() {
        this.launchTime = System.currentTimeMillis();
        this.totalHeartsSentInSession = 0;
        this.isheartCntInitialValueSet = false;
    }

    public final void sendHeartCountEvent(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "status");
        GameBroadcastConfig gameBroadcastConfig2 = (GameBroadcastConfig) this.gameBroadcastConfig.getValue();
        if (gameBroadcastConfig2 != null && gameBroadcastConfig2.getBroadcastChat().getChatEnabled() && i > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("Status", str);
            hashMap.put(BroadcastReacted.PROPERTY_REACTIONS, Integer.valueOf(i));
        }
    }

    public final void sendHeartFailureEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "status");
        sendHeartCountEvent(str, -1);
    }

    public final void sendMessageCountEvent(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "status");
        GameBroadcastConfig gameBroadcastConfig2 = (GameBroadcastConfig) this.gameBroadcastConfig.getValue();
        if (gameBroadcastConfig2 != null && gameBroadcastConfig2.getBroadcastChat().getChatEnabled() && i > 0) {
            MLogger.d(TAG, "Clever tap event sent");
            HashMap hashMap = new HashMap();
            hashMap.put("Status", str);
            hashMap.put("Count", Integer.valueOf(i));
        }
    }

    public final void sendMessageFailureEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "status");
        sendMessageCountEvent(str, -1);
    }

    public final void sendOrientationChangedEvent(boolean z) {
        TypeUtilsKt.launch$default(CompoundButtonCompat.getViewModelScope(this), Dispatchers.IO, null, new SharedGameStreamViewModel$sendOrientationChangedEvent$1(this, z, null), 2, null);
    }

    public final void sendProfileFollowedEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "entryPoint");
        TypeUtilsKt.launch$default(CompoundButtonCompat.getViewModelScope(this), Dispatchers.IO, null, new SharedGameStreamViewModel$sendProfileFollowedEvent$1(str, null), 2, null);
    }

    public final void setChatEnabled(boolean z) {
        this.isChatEnabled = z;
    }

    public final void setConfigHeartThrottle(long j) {
        this.configHeartThrottle = j;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final void setCurrentBroadcastId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentBroadcastId = str;
    }

    public final void setGameBroadcastConfig() {
        TypeUtilsKt.launch$default(CompoundButtonCompat.getViewModelScope(this), null, null, new SharedGameStreamViewModel$setGameBroadcastConfig$1(this, null), 3, null);
    }

    public final void setGameStatsEnabled(boolean z) {
        this.isGameStatsEnabled = z;
    }

    public final void setIsheartCntInitialValueSet(boolean z) {
        this.isheartCntInitialValueSet = z;
    }

    public final void setLaunchTime(long j) {
        this.launchTime = j;
    }

    public final void setSendCTADeepLink(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.sendCTADeepLink = mutableLiveData;
    }

    public final void setTotalHeartsSent(int i) {
        this.totalHeartsSent = i;
    }

    public final void setTotalHeartsSentInSession(int i) {
        this.totalHeartsSentInSession = i;
    }

    public final void setTotalMessagesSentInSession(int i) {
        this.totalMessagesSentInSession = i;
    }

    public final void setUserNameEnabledInConfig(boolean z) {
        this.isUserNameEnabledInConfig = z;
    }

    /* access modifiers changed from: private */
    public final boolean isFeatureEnabled() {
        boolean z = ConfigManager.getHanselConfig() != null && ConfigManager.getHanselConfig().optBoolean(Config.HANSEL_KEY_FEATURE_ENABLED, false);
        int integer = HanselConfigs.getInteger(Config.HANSEL_KEY_FEATURE_MIN_RAM, -1);
        Object fromJson = new Gson().fromJson(HanselConfigs.getJSONArray(Config.HANSEL_KEY_FEATURE_BLACKLISTED_DEVICES, new JSONArray()).toString(), new SharedGameStreamViewModel$isFeatureEnabled$type$1().getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(blacklis…esArray.toString(), type)");
        List list = (List) fromJson;
        MLogger.d(TAG, "FeatureEnabled : " + z + ", MinRam : " + integer + ", BlackListedDevices : " + r4);
        Object systemService = this.context.getSystemService("activity");
        if (systemService != null) {
            MemoryInfo memoryInfo = new MemoryInfo();
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            long j = memoryInfo.totalMem / ((long) 1048576);
            String str = Build.MANUFACTURER + ' ' + Build.MODEL;
            if (!z || j <= ((long) integer) || list.contains(str)) {
                return false;
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }
}

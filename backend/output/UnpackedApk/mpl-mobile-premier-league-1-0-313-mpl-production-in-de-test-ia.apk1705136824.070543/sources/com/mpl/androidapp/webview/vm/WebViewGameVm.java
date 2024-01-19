package com.mpl.androidapp.webview.vm;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import androidx.core.widget.CompoundButtonCompat;
import com.google.gson.Gson;
import com.mpl.androidapp.miniprofile.base.BaseViewModel;
import com.mpl.androidapp.share.MplShareFeature;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.webview.ct.WebViewGamesGamesCt;
import com.mpl.androidapp.webview.repositories.WebFlowRepository;
import com.mpl.androidapp.webview.services.WebFlowServiceImpl;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.CloseScreenWithDialog;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.DisplayLoader;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.ErrorState;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.InitSessionRequestParams;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.InitialState;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.NoConnectivity;
import com.mpl.androidapp.webview.usecases.PrepHelpDeskDeepLinkUseCase;
import com.mpl.androidapp.webview.usecases.PrepPaymentPageDeepLinkUseCase;
import com.mpl.androidapp.webview.usecases.PrepUrlForWebViewLoadingUseCase;
import com.mpl.androidapp.webview.utils.custexceptions.CloseWebGameException;
import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.CharsKt__CharKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001`B?\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0016\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020*J\u0010\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020(H\u0002J\u0018\u0010?\u001a\u00020:2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\u001cJ\u0006\u0010C\u001a\u00020:J.\u0010D\u001a\u00020:2\b\u0010E\u001a\u0004\u0018\u00010\u001c2\b\u0010F\u001a\u0004\u0018\u00010\u001c2\b\u0010G\u001a\u0004\u0018\u00010\u001c2\b\u0010H\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010I\u001a\u00020:2\b\u0010J\u001a\u0004\u0018\u00010\u001cJ\u000e\u0010K\u001a\u00020*2\u0006\u0010L\u001a\u00020\u001cJ\u0019\u0010M\u001a\u00020:2\u0006\u0010!\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010NJ\u0019\u0010O\u001a\u00020:2\u0006\u0010P\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010QJ\u0019\u0010R\u001a\u00020:2\u0006\u0010S\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010QJ\u0010\u0010T\u001a\u00020:2\u0006\u0010U\u001a\u00020\u001cH\u0016J\u0010\u0010V\u001a\u00020:2\u0006\u0010S\u001a\u00020\u001cH\u0016J\u000e\u0010W\u001a\u00020:2\u0006\u0010X\u001a\u00020\u001cJ\u0010\u0010Y\u001a\u00020:2\u0006\u0010Z\u001a\u00020*H\u0002J\u0010\u0010[\u001a\u00020:2\u0006\u0010>\u001a\u00020(H\u0002J\u0019\u0010\\\u001a\u00020:2\u0006\u0010]\u001a\u00020^H@ø\u0001\u0000¢\u0006\u0002\u0010_R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001a\u0010$\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\u000e\u00103\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u001406¢\u0006\b\n\u0000\u001a\u0004\b7\u00108\u0002\u0004\n\u0002\b\u0019¨\u0006a"}, d2 = {"Lcom/mpl/androidapp/webview/vm/WebViewGameVm;", "Lcom/mpl/androidapp/miniprofile/base/BaseViewModel;", "Lcom/mpl/androidapp/webview/services/WebFlowServiceImpl;", "context", "Landroid/app/Application;", "gson", "Lcom/google/gson/Gson;", "repository", "Lcom/mpl/androidapp/webview/repositories/WebFlowRepository;", "prepHelpDeskDeepLinkUseCase", "Lcom/mpl/androidapp/webview/usecases/PrepHelpDeskDeepLinkUseCase;", "prepPaymentPageDeepLinkUseCase", "Lcom/mpl/androidapp/webview/usecases/PrepPaymentPageDeepLinkUseCase;", "prepUrlForWebViewLoadingUseCase", "Lcom/mpl/androidapp/webview/usecases/PrepUrlForWebViewLoadingUseCase;", "mplShareFeature", "Lcom/mpl/androidapp/share/MplShareFeature;", "(Landroid/app/Application;Lcom/google/gson/Gson;Lcom/mpl/androidapp/webview/repositories/WebFlowRepository;Lcom/mpl/androidapp/webview/usecases/PrepHelpDeskDeepLinkUseCase;Lcom/mpl/androidapp/webview/usecases/PrepPaymentPageDeepLinkUseCase;Lcom/mpl/androidapp/webview/usecases/PrepUrlForWebViewLoadingUseCase;Lcom/mpl/androidapp/share/MplShareFeature;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "battleId", "", "getBattleId", "()I", "setBattleId", "(I)V", "gameIcon", "", "getGameIcon", "()Ljava/lang/String;", "setGameIcon", "(Ljava/lang/String;)V", "gameId", "getGameId", "setGameId", "gameName", "getGameName", "setGameName", "internalRouteObject", "Lorg/json/JSONObject;", "isInternalRouteObjectSet", "", "isLoaderLoadedFirstTime", "()Z", "setLoaderLoadedFirstTime", "(Z)V", "isSingleLaunch", "letGameHandleBackNav", "getLetGameHandleBackNav", "setLetGameHandleBackNav", "lobbyId", "reactGameValueReceived", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "callSessionApi", "", "jsonPostParam", "isConnectedToNetwork", "checkIsListingGames", "reactData", "getDataFromPreviousScreen", "intent", "Landroid/content/Intent;", "key", "initializeStates", "initiateShare", "launchFrom", "screenName", "shareMessage", "platform", "performAction", "action", "performValidationForUrlPayload", "url", "prepHelpDeskDeepLink", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepPaymentDeepLink", "amount", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareLoadingUrlUseCase", "data", "sessionApiFailure", "message", "sessionApiSuccess", "setGameData", "value", "setLoaderVisibility", "isVisible", "setViewModelData", "useCaseError", "result", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult$Error;", "(Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebViewGameVm.kt */
public final class WebViewGameVm extends BaseViewModel implements WebFlowServiceImpl {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_BATTLE_ID = "battleId";
    public static final String KEY_COMMON_GAME_NAME = "WebViewGames";
    public static final String KEY_GAME_ICON = "gameIcon";
    public static final String KEY_GAME_ID = "gameId";
    public static final String KEY_GAME_LOBBY_ID = "lobbyId";
    public static final String KEY_GAME_NAME = "gameName";
    public static final String KEY_GAME_SESSION_ID = "sessionId";
    public static final String KEY_INTERNAL_ROUTE_OBJECT = "internalRouteObject";
    public static final String KEY_LOBBY_ID = "LobbyId";
    public static final String KEY_PAYLOAD = "payload";
    public static final String KEY_REDIRECTION_URL = "redirectionUrl";
    public static final String KEY_WEB_GAME_LOBBY_ID = "lobbyId";
    public static final String NOT_CONNECTED_TO_INTERNET = "Not connected to internet";
    public static final Integer[] proboGameIds = {Integer.valueOf(2048), Integer.valueOf(1002048)};
    public final MutableStateFlow<WebViewGameActivityStates> _viewState;
    public int battleId;
    public String gameIcon = "";
    public int gameId;
    public String gameName = "";
    public final Gson gson;
    public JSONObject internalRouteObject = new JSONObject();
    public boolean isInternalRouteObjectSet;
    public boolean isLoaderLoadedFirstTime;
    public boolean isSingleLaunch;
    public boolean letGameHandleBackNav;
    public int lobbyId;
    public MplShareFeature mplShareFeature;
    public PrepHelpDeskDeepLinkUseCase prepHelpDeskDeepLinkUseCase;
    public PrepPaymentPageDeepLinkUseCase prepPaymentPageDeepLinkUseCase;
    public PrepUrlForWebViewLoadingUseCase prepUrlForWebViewLoadingUseCase;
    public JSONObject reactGameValueReceived = new JSONObject();
    public WebFlowRepository repository;
    public final StateFlow<WebViewGameActivityStates> viewState;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/mpl/androidapp/webview/vm/WebViewGameVm$Companion;", "", "()V", "KEY_BATTLE_ID", "", "KEY_COMMON_GAME_NAME", "KEY_GAME_ICON", "KEY_GAME_ID", "KEY_GAME_LOBBY_ID", "KEY_GAME_NAME", "KEY_GAME_SESSION_ID", "KEY_INTERNAL_ROUTE_OBJECT", "KEY_LOBBY_ID", "KEY_PAYLOAD", "KEY_REDIRECTION_URL", "KEY_WEB_GAME_LOBBY_ID", "NOT_CONNECTED_TO_INTERNET", "proboGameIds", "", "", "getProboGameIds", "()[Ljava/lang/Integer;", "[Ljava/lang/Integer;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameVm.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Integer[] getProboGameIds() {
            return WebViewGameVm.proboGameIds;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WebViewGameVm(Application application, Gson gson2, WebFlowRepository webFlowRepository, PrepHelpDeskDeepLinkUseCase prepHelpDeskDeepLinkUseCase2, PrepPaymentPageDeepLinkUseCase prepPaymentPageDeepLinkUseCase2, PrepUrlForWebViewLoadingUseCase prepUrlForWebViewLoadingUseCase2, MplShareFeature mplShareFeature2) {
        // Intrinsics.checkNotNullParameter(application, "context");
        // Intrinsics.checkNotNullParameter(gson2, "gson");
        // Intrinsics.checkNotNullParameter(webFlowRepository, "repository");
        // Intrinsics.checkNotNullParameter(prepHelpDeskDeepLinkUseCase2, "prepHelpDeskDeepLinkUseCase");
        // Intrinsics.checkNotNullParameter(prepPaymentPageDeepLinkUseCase2, "prepPaymentPageDeepLinkUseCase");
        // Intrinsics.checkNotNullParameter(prepUrlForWebViewLoadingUseCase2, "prepUrlForWebViewLoadingUseCase");
        // Intrinsics.checkNotNullParameter(mplShareFeature2, "mplShareFeature");
        super(application);
        this.gson = gson2;
        this.repository = webFlowRepository;
        this.prepHelpDeskDeepLinkUseCase = prepHelpDeskDeepLinkUseCase2;
        this.prepPaymentPageDeepLinkUseCase = prepPaymentPageDeepLinkUseCase2;
        this.prepUrlForWebViewLoadingUseCase = prepUrlForWebViewLoadingUseCase2;
        this.mplShareFeature = mplShareFeature2;
        MutableStateFlow<WebViewGameActivityStates> MutableStateFlow = StateFlowKt.MutableStateFlow(InitialState.INSTANCE);
        this._viewState = MutableStateFlow;
        this.viewState = TypeUtilsKt.asStateFlow(MutableStateFlow);
    }

    private final void checkIsListingGames(JSONObject jSONObject) {
        this.isSingleLaunch = !jSONObject.has(KEY_BATTLE_ID);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object prepHelpDeskDeepLink(int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.mpl.androidapp.webview.vm.WebViewGameVm$prepHelpDeskDeepLink$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.mpl.androidapp.webview.vm.WebViewGameVm$prepHelpDeskDeepLink$1 r0 = (com.mpl.androidapp.webview.vm.WebViewGameVm$prepHelpDeskDeepLink$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.webview.vm.WebViewGameVm$prepHelpDeskDeepLink$1 r0 = new com.mpl.androidapp.webview.vm.WebViewGameVm$prepHelpDeskDeepLink$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 == r4) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x0086
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            java.lang.Object r6 = r0.L$0
            com.mpl.androidapp.webview.vm.WebViewGameVm r6 = (com.mpl.androidapp.webview.vm.WebViewGameVm) r6
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x0050
        L_0x003a:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            com.mpl.androidapp.webview.usecases.PrepHelpDeskDeepLinkUseCase r7 = r5.prepHelpDeskDeepLinkUseCase
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = r7.invoke(r2, r0)
            if (r7 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r6 = r5
        L_0x0050:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r7
            boolean r2 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r2 == 0) goto L_0x0074
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r7
            java.lang.Object r7 = r7.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r7
            java.lang.Object r7 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r7)
            if (r7 == 0) goto L_0x006c
            com.mpl.androidapp.webview.states.WebViewGameActivityStates$HelpDeskRedirect r7 = (com.mpl.androidapp.webview.states.WebViewGameActivityStates.HelpDeskRedirect) r7
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.webview.states.WebViewGameActivityStates> r6 = r6._viewState
            r6.setValue(r7)
            goto L_0x0089
        L_0x006c:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "null cannot be cast to non-null type com.mpl.androidapp.webview.states.WebViewGameActivityStates.HelpDeskRedirect"
            r6.<init>(r7)
            throw r6
        L_0x0074:
            boolean r2 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r2 == 0) goto L_0x0089
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r7
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.useCaseError(r7, r0)
            if (r6 != r1) goto L_0x0086
            return r1
        L_0x0086:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0089:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.webview.vm.WebViewGameVm.prepHelpDeskDeepLink(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object prepPaymentDeepLink(java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.mpl.androidapp.webview.vm.WebViewGameVm$prepPaymentDeepLink$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.mpl.androidapp.webview.vm.WebViewGameVm$prepPaymentDeepLink$1 r0 = (com.mpl.androidapp.webview.vm.WebViewGameVm$prepPaymentDeepLink$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.webview.vm.WebViewGameVm$prepPaymentDeepLink$1 r0 = new com.mpl.androidapp.webview.vm.WebViewGameVm$prepPaymentDeepLink$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 == r4) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x0081
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            java.lang.Object r6 = r0.L$0
            com.mpl.androidapp.webview.vm.WebViewGameVm r6 = (com.mpl.androidapp.webview.vm.WebViewGameVm) r6
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x004b
        L_0x003a:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            com.mpl.androidapp.webview.usecases.PrepPaymentPageDeepLinkUseCase r7 = r5.prepPaymentPageDeepLinkUseCase
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = r7.invoke(r6, r0)
            if (r7 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r6 = r5
        L_0x004b:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r7
            boolean r2 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r2 == 0) goto L_0x006f
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r7
            java.lang.Object r7 = r7.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r7
            java.lang.Object r7 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r7)
            if (r7 == 0) goto L_0x0067
            com.mpl.androidapp.webview.states.WebViewGameActivityStates$PaymentRedirect r7 = (com.mpl.androidapp.webview.states.WebViewGameActivityStates.PaymentRedirect) r7
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.webview.states.WebViewGameActivityStates> r6 = r6._viewState
            r6.setValue(r7)
            goto L_0x0084
        L_0x0067:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "null cannot be cast to non-null type com.mpl.androidapp.webview.states.WebViewGameActivityStates.PaymentRedirect"
            r6.<init>(r7)
            throw r6
        L_0x006f:
            boolean r2 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r2 == 0) goto L_0x0084
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r7
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.useCaseError(r7, r0)
            if (r6 != r1) goto L_0x0081
            return r1
        L_0x0081:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0084:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.webview.vm.WebViewGameVm.prepPaymentDeepLink(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object prepareLoadingUrlUseCase(java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.mpl.androidapp.webview.vm.WebViewGameVm$prepareLoadingUrlUseCase$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.mpl.androidapp.webview.vm.WebViewGameVm$prepareLoadingUrlUseCase$1 r0 = (com.mpl.androidapp.webview.vm.WebViewGameVm$prepareLoadingUrlUseCase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.webview.vm.WebViewGameVm$prepareLoadingUrlUseCase$1 r0 = new com.mpl.androidapp.webview.vm.WebViewGameVm$prepareLoadingUrlUseCase$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 == r4) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x00c3
        L_0x002b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0033:
            java.lang.Object r7 = r0.L$0
            com.mpl.androidapp.webview.vm.WebViewGameVm r7 = (com.mpl.androidapp.webview.vm.WebViewGameVm) r7
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x008d
        L_0x003b:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            boolean r2 = r6.isInternalRouteObjectSet
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r5 = "IS_INTERNAL_ROUTE_OBJECT_SET"
            r8.put(r5, r2)
            org.json.JSONObject r2 = r6.internalRouteObject
            java.lang.String r5 = "INTERNAL_ROUTE_OBJECT"
            r8.put(r5, r2)
            java.lang.String r2 = "API_RESPONSE_OBJECT"
            r8.put(r2, r7)
            int r7 = r6.lobbyId
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r7)
            java.lang.String r7 = "API_LOBBY_ID"
            r8.put(r7, r2)
            int r7 = r6.getBattleId()
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r7)
            java.lang.String r7 = "API_BATTLE_ID"
            r8.put(r7, r2)
            boolean r7 = r6.isSingleLaunch
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.String r2 = "API_IS_SINGLE_LAUNCH"
            r8.put(r2, r7)
            com.mpl.androidapp.webview.usecases.PrepUrlForWebViewLoadingUseCase r7 = r6.prepUrlForWebViewLoadingUseCase
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r8 = r7.invoke(r8, r0)
            if (r8 != r1) goto L_0x008c
            return r1
        L_0x008c:
            r7 = r6
        L_0x008d:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r8
            boolean r2 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r2 == 0) goto L_0x00b1
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r8
            java.lang.Object r8 = r8.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r8
            java.lang.Object r8 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r8)
            if (r8 == 0) goto L_0x00a9
            com.mpl.androidapp.webview.states.WebViewGameActivityStates$StartLoadingWebView r8 = (com.mpl.androidapp.webview.states.WebViewGameActivityStates.StartLoadingWebView) r8
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.webview.states.WebViewGameActivityStates> r7 = r7._viewState
            r7.setValue(r8)
            goto L_0x00c6
        L_0x00a9:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "null cannot be cast to non-null type com.mpl.androidapp.webview.states.WebViewGameActivityStates.StartLoadingWebView"
            r7.<init>(r8)
            throw r7
        L_0x00b1:
            boolean r2 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r2 == 0) goto L_0x00c6
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r8
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = r7.useCaseError(r8, r0)
            if (r7 != r1) goto L_0x00c3
            return r1
        L_0x00c3:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x00c6:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.webview.vm.WebViewGameVm.prepareLoadingUrlUseCase(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void setLoaderVisibility(boolean z) {
        this._viewState.setValue(new DisplayLoader(z));
    }

    private final void setViewModelData(JSONObject jSONObject) {
        if (jSONObject.has("gameId")) {
            Object obj = jSONObject.get("gameId");
            if (obj != null) {
                this.gameId = ((Integer) obj).intValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
        if (jSONObject.has(KEY_BATTLE_ID)) {
            Object obj2 = jSONObject.get(KEY_BATTLE_ID);
            if (obj2 != null) {
                this.battleId = ((Integer) obj2).intValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
        if (jSONObject.has("LobbyId")) {
            Object obj3 = jSONObject.get("LobbyId");
            if (obj3 != null) {
                this.lobbyId = ((Integer) obj3).intValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
        if (jSONObject.has(KEY_INTERNAL_ROUTE_OBJECT)) {
            this.isInternalRouteObjectSet = true;
            Object obj4 = jSONObject.get(KEY_INTERNAL_ROUTE_OBJECT);
            if (obj4 != null) {
                this.internalRouteObject = (JSONObject) obj4;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
        }
        if (jSONObject.has("gameName")) {
            Object obj5 = jSONObject.get("gameName");
            if (obj5 != null) {
                this.gameName = (String) obj5;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (jSONObject.has(KEY_GAME_ICON)) {
            Object obj6 = jSONObject.get(KEY_GAME_ICON);
            if (obj6 != null) {
                this.gameIcon = (String) obj6;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    /* access modifiers changed from: private */
    public final Object useCaseError(Error error, Continuation<? super Unit> continuation) {
        if (error.getException() instanceof CloseWebGameException) {
            this._viewState.setValue(new CloseScreenWithDialog(String.valueOf(error.getException().getMessage())));
        } else {
            this._viewState.setValue(new ErrorState(String.valueOf(error.getException().getMessage())));
        }
        return Unit.INSTANCE;
    }

    public final void callSessionApi(JSONObject jSONObject, boolean z) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonPostParam");
        if (z) {
            setLoaderVisibility(true);
            this.repository.getSessionToken(this, jSONObject);
            return;
        }
        this._viewState.setValue(NoConnectivity.INSTANCE);
    }

    public final int getBattleId() {
        return this.battleId;
    }

    public final void getDataFromPreviousScreen(Intent intent, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        TypeUtilsKt.launch$default(CompoundButtonCompat.getViewModelScope(this), null, null, new WebViewGameVm$getDataFromPreviousScreen$1(intent, str, this, null), 3, null);
    }

    public final String getGameIcon() {
        return this.gameIcon;
    }

    public final int getGameId() {
        return this.gameId;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final boolean getLetGameHandleBackNav() {
        return this.letGameHandleBackNav;
    }

    public final StateFlow<WebViewGameActivityStates> getViewState() {
        return this.viewState;
    }

    public final void initializeStates() {
        TypeUtilsKt.launch$default(CompoundButtonCompat.getViewModelScope(this), null, null, new WebViewGameVm$initializeStates$1(this, null), 3, null);
    }

    public final void initiateShare(String str, String str2, String str3, String str4) {
        CoroutineScope viewModelScope = CompoundButtonCompat.getViewModelScope(this);
        MainCoroutineDispatcher main = Dispatchers.getMain();
        WebViewGameVm$initiateShare$1 webViewGameVm$initiateShare$1 = new WebViewGameVm$initiateShare$1(str, str2, str3, str4, this, null);
        TypeUtilsKt.launch$default(viewModelScope, main, null, webViewGameVm$initiateShare$1, 2, null);
    }

    public final boolean isLoaderLoadedFirstTime() {
        return this.isLoaderLoadedFirstTime;
    }

    public final void performAction(String str) {
        TypeUtilsKt.launch$default(CompoundButtonCompat.getViewModelScope(this), Dispatchers.getMain(), null, new WebViewGameVm$performAction$1(str, this, null), 2, null);
    }

    public final boolean performValidationForUrlPayload(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        if (!TweetUtils.contains(proboGameIds, Integer.valueOf(this.gameId))) {
            return true;
        }
        boolean equals = CharsKt__CharKt.equals(Uri.parse(str).getQueryParameter("source_name"), (String) "probo_mpl", false);
        if (!CharsKt__CharKt.contains$default((CharSequence) str, (CharSequence) "source_name", false, 2) || !equals) {
            return false;
        }
        return true;
    }

    public void sessionApiFailure(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        WebViewGamesGamesCt.sendEventSessionApiStatus$default(WebViewGamesGamesCt.INSTANCE, this.gameId, false, false, str, 4, null);
        setLoaderVisibility(false);
        TypeUtilsKt.launch$default(CompoundButtonCompat.getViewModelScope(this), null, null, new WebViewGameVm$sessionApiFailure$1(this, str, null), 3, null);
    }

    public void sessionApiSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "data");
        TypeUtilsKt.launch$default(CompoundButtonCompat.getViewModelScope(this), null, null, new WebViewGameVm$sessionApiSuccess$1(this, str, null), 3, null);
    }

    public final void setBattleId(int i) {
        this.battleId = i;
    }

    public final void setGameData(String str) {
        Intrinsics.checkNotNullParameter(str, HSLCriteriaBuilder.VALUE);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.reactGameValueReceived = jSONObject;
            MLogger.d("WebViewGames", Intrinsics.stringPlus("react response in string: ", jSONObject));
            checkIsListingGames(this.reactGameValueReceived);
            setViewModelData(this.reactGameValueReceived);
            this._viewState.setValue(new InitSessionRequestParams(this.reactGameValueReceived));
        } catch (Throwable th) {
            MLogger.d("WebViewGames", Intrinsics.stringPlus("Error While Parsing Json: ", th.getMessage()));
            this._viewState.setValue(new ErrorState(String.valueOf(th.getMessage())));
        }
    }

    public final void setGameIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameIcon = str;
    }

    public final void setGameId(int i) {
        this.gameId = i;
    }

    public final void setGameName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameName = str;
    }

    public final void setLetGameHandleBackNav(boolean z) {
        this.letGameHandleBackNav = z;
    }

    public final void setLoaderLoadedFirstTime(boolean z) {
        this.isLoaderLoadedFirstTime = z;
    }
}

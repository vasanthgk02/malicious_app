package com.mpl.androidapp.webview.view.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.mpl.androidapp.databinding.ActivityWebviewGameBinding;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.webview.base.WebViewBaseActivity;
import com.mpl.androidapp.webview.ct.WebViewDownTimeLogs;
import com.mpl.androidapp.webview.ct.WebViewGamesGamesCt;
import com.mpl.androidapp.webview.models.SessionRoot;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.ChangeOrientation;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.CloseScreen;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.CloseScreenWithDialog;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.DisplayLoader;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.ErrorState;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.GetDataFromPreviousScreen;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.HandleBackNavigation;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.HelpDeskRedirect;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.InitSessionRequestParams;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.InitialState;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.NoConnectivity;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.PaymentRedirect;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.ReInitState;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.ReloadState;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.StartLoadingWebView;
import com.mpl.androidapp.webview.view.customviews.WebViewGamesContainer;
import com.mpl.androidapp.webview.view.dialogs.WebViewGameConnDialog;
import com.mpl.androidapp.webview.view.dialogs.WebViewGameExitDialog.Callback;
import com.mpl.androidapp.webview.view.dialogs.WebViewGameOneActionExitDialog;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001IB\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0002J\b\u0010\u001f\u001a\u00020\rH\u0002J0\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\u00112\b\u0010\"\u001a\u0004\u0018\u00010\u00112\b\u0010#\u001a\u0004\u0018\u00010\u00112\b\u0010$\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u001aH\u0016J\b\u0010'\u001a\u00020\rH\u0016J\b\u0010(\u001a\u00020\rH\u0016J\u0012\u0010)\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\b\u0010,\u001a\u00020\rH\u0014J\u0012\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010/\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u00101\u001a\u00020\r2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u00105\u001a\u00020\rH\u0002J\b\u00106\u001a\u00020\rH\u0002J\u0010\u00107\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\u001c\u00108\u001a\u00020\r2\b\u00109\u001a\u0004\u0018\u00010\u00112\b\u0010:\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020\rH\u0002J\u0010\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020\rH\u0002J\b\u0010C\u001a\u00020\rH\u0016J\u0010\u0010D\u001a\u00020\r2\u0006\u0010E\u001a\u00020\u0011H\u0002J\u0010\u0010F\u001a\u00020\r2\u0006\u0010G\u001a\u00020HH\u0002R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/mpl/androidapp/webview/view/activities/WebViewGameActivity;", "Lcom/mpl/androidapp/webview/base/WebViewBaseActivity;", "Lcom/mpl/androidapp/databinding/ActivityWebviewGameBinding;", "Lcom/mpl/androidapp/webview/view/dialogs/WebViewGameExitDialog$Callback;", "Lcom/mpl/androidapp/webview/view/dialogs/WebViewGameConnDialog$Callback;", "Lcom/mpl/androidapp/webview/view/customviews/WebViewGamesContainer$Callback;", "Lcom/mpl/androidapp/webview/view/dialogs/WebViewGameOneActionExitDialog$Callback;", "()V", "viewModel", "Lcom/mpl/androidapp/webview/vm/WebViewGameVm;", "webViewEventSession", "Lcom/mpl/androidapp/webview/ct/WebViewDownTimeLogs;", "closeGame", "", "closeWeb", "closeWebViewWithReason", "failReason", "", "failUrl", "connectivityDialogDisplay", "connectivityDialogOkAction", "ctEventForWebViewLoading", "timeTaken", "", "displayLoader", "visible", "", "errorDialogDisplay", "message", "handleBackNavigation", "initScreen", "initViewModel", "initiateShare", "gameName", "screenName", "shareMessage", "platform", "isWebViewLoading", "isLoading", "onBackPressed", "onConditionExit", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "openDeepLink", "actionParams", "performAction", "action", "prepareSessionApiParams", "reactDataForWebGame", "Lorg/json/JSONObject;", "publishEventToCtForError", "reInitWebView", "reloadWebView", "sendClevertapEvent", "sendEvent", "eventName", "eventProps", "setGameUrl", "sessionRoot", "Lcom/mpl/androidapp/webview/models/SessionRoot;", "setUpCallbacks", "setViewState", "it", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "setupObserver", "showNavigationToMplDialog", "startLoadingWebView", "url", "startReactScreen", "intent", "Landroid/content/Intent;", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebViewGameActivity.kt */
public final class WebViewGameActivity extends WebViewBaseActivity<ActivityWebviewGameBinding> implements Callback, WebViewGameConnDialog.Callback, WebViewGamesContainer.Callback, WebViewGameOneActionExitDialog.Callback {
    public static final Companion Companion = new Companion(null);
    public static final String DATA_PARAMS_WEB_GAME = "dataParamsWebGame";
    public static final String MESSAGE_NO_CONNECTIVITY = "No Connectivity";
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public WebViewGameVm viewModel;
    public final WebViewDownTimeLogs webViewEventSession = new WebViewDownTimeLogs();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/mpl/androidapp/webview/view/activities/WebViewGameActivity$Companion;", "", "()V", "DATA_PARAMS_WEB_GAME", "", "MESSAGE_NO_CONNECTIVITY", "getLaunchingIntent", "Landroid/content/Intent;", "activity", "Landroid/app/Activity;", "params", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameActivity.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent getLaunchingIntent(Activity activity, String str) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(str, CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
            Intent intent = new Intent(activity, WebViewGameActivity.class);
            MLogger.d("WebViewGames", "Preparing web-view launch intent");
            intent.putExtra(WebViewGameActivity.DATA_PARAMS_WEB_GAME, str);
            intent.addFlags(65536);
            intent.addFlags(131072);
            return intent;
        }
    }

    public WebViewGameActivity() {
        super(AnonymousClass1.INSTANCE);
    }

    private final void connectivityDialogDisplay() {
        WebViewGamesGamesCt webViewGamesGamesCt = WebViewGamesGamesCt.INSTANCE;
        WebViewGameVm webViewGameVm = this.viewModel;
        if (webViewGameVm != null) {
            int gameId = webViewGameVm.getGameId();
            WebViewGameVm webViewGameVm2 = this.viewModel;
            if (webViewGameVm2 != null) {
                webViewGamesGamesCt.sendEventForGameConnectionLost(String.valueOf(webViewGameVm2.getBattleId()), gameId, "WebViewGames");
                ((ActivityWebviewGameBinding) getBinding()).webViewGamesContainerId.loaderVisibility(false);
                showConnectivityDialog(MESSAGE_NO_CONNECTIVITY, this);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        throw null;
    }

    private final void displayLoader(boolean z) {
        WebViewGameVm webViewGameVm = this.viewModel;
        if (webViewGameVm == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            throw null;
        } else if (!webViewGameVm.isLoaderLoadedFirstTime()) {
            WebViewGamesContainer webViewGamesContainer = ((ActivityWebviewGameBinding) getBinding()).webViewGamesContainerId;
            ((ActivityWebviewGameBinding) getBinding()).webViewGamesContainerId.loaderVisibility(z);
            webViewGamesContainer.setLoaderVisibility(z);
            if (!z) {
                WebViewGameVm webViewGameVm2 = this.viewModel;
                if (webViewGameVm2 != null) {
                    webViewGameVm2.setLoaderLoadedFirstTime(true);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    throw null;
                }
            }
        }
    }

    private final void errorDialogDisplay(String str) {
        WebViewGamesGamesCt webViewGamesGamesCt = WebViewGamesGamesCt.INSTANCE;
        WebViewGameVm webViewGameVm = this.viewModel;
        if (webViewGameVm != null) {
            webViewGamesGamesCt.sendCtEventForWebFlowGame(true, false, str, webViewGameVm.getGameId());
            ((ActivityWebviewGameBinding) getBinding()).webViewGamesContainerId.loaderVisibility(false);
            showErrorDialogToExit(str, this);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        throw null;
    }

    private final void handleBackNavigation() {
        WebViewGameVm webViewGameVm = this.viewModel;
        if (webViewGameVm != null) {
            webViewGameVm.setLetGameHandleBackNav(true);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            throw null;
        }
    }

    private final void initScreen() {
        setWakelock(true);
        setUpCallbacks();
        WebViewGameVm webViewGameVm = this.viewModel;
        if (webViewGameVm != null) {
            webViewGameVm.getDataFromPreviousScreen(getIntent(), DATA_PARAMS_WEB_GAME);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            throw null;
        }
    }

    private final void initViewModel() {
        ViewModel viewModel2 = new ViewModelProvider(this).get(WebViewGameVm.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this).…ebViewGameVm::class.java)");
        this.viewModel = (WebViewGameVm) viewModel2;
    }

    private final void prepareSessionApiParams(JSONObject jSONObject) {
        WebViewDownTimeLogs webViewDownTimeLogs = this.webViewEventSession;
        long currentTimeMillis = System.currentTimeMillis();
        webViewDownTimeLogs.setTileClickEnd(currentTimeMillis);
        webViewDownTimeLogs.setSessionStart(currentTimeMillis);
        WebViewGamesGamesCt webViewGamesGamesCt = WebViewGamesGamesCt.INSTANCE;
        WebViewGameVm webViewGameVm = this.viewModel;
        if (webViewGameVm != null) {
            webViewGamesGamesCt.sendEventSessionApiInitiation(webViewGameVm.getGameId());
            LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new WebViewGameActivity$prepareSessionApiParams$2(this, jSONObject, null));
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        throw null;
    }

    private final void reInitWebView() {
        ((ActivityWebviewGameBinding) getBinding()).webViewGamesContainerId.destroyWebView();
        if (isConnectedToNetwork()) {
            initScreen();
        } else {
            showConnectivityDialog(WebViewGameVm.NOT_CONNECTED_TO_INTERNET, this);
        }
    }

    private final void reloadWebView() {
        ((ActivityWebviewGameBinding) getBinding()).webViewGamesContainerId.reloadWebView();
    }

    private final void sendClevertapEvent(String str) {
        WebViewGamesGamesCt webViewGamesGamesCt = WebViewGamesGamesCt.INSTANCE;
        WebViewGameVm webViewGameVm = this.viewModel;
        if (webViewGameVm != null) {
            webViewGamesGamesCt.sendCtEventForWebFlowGame(true, false, str, webViewGameVm.getGameId());
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            throw null;
        }
    }

    private final String setGameUrl(SessionRoot sessionRoot) {
        return sessionRoot.getRedirectionUrl();
    }

    private final void setUpCallbacks() {
        ((ActivityWebviewGameBinding) getBinding()).webViewGamesContainerId.setCallback(this);
    }

    /* access modifiers changed from: private */
    public final void setViewState(WebViewGameActivityStates webViewGameActivityStates) {
        if (webViewGameActivityStates instanceof GetDataFromPreviousScreen) {
            WebViewGameVm webViewGameVm = this.viewModel;
            if (webViewGameVm != null) {
                webViewGameVm.setGameData(((GetDataFromPreviousScreen) webViewGameActivityStates).getValue());
                WebViewGamesContainer webViewGamesContainer = ((ActivityWebviewGameBinding) getBinding()).webViewGamesContainerId;
                WebViewGameVm webViewGameVm2 = this.viewModel;
                if (webViewGameVm2 != null) {
                    String gameName = webViewGameVm2.getGameName();
                    WebViewGameVm webViewGameVm3 = this.viewModel;
                    if (webViewGameVm3 != null) {
                        webViewGamesContainer.setDataForUI(gameName, webViewGameVm3.getGameIcon());
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                throw null;
            }
        } else if (webViewGameActivityStates instanceof ErrorState) {
            errorDialogDisplay(((ErrorState) webViewGameActivityStates).getErrorMessage());
        } else if (webViewGameActivityStates instanceof CloseScreenWithDialog) {
            errorDialogDisplay(((CloseScreenWithDialog) webViewGameActivityStates).getMessage());
        } else if (webViewGameActivityStates instanceof InitialState) {
            initScreen();
        } else if (webViewGameActivityStates instanceof ChangeOrientation) {
            changeOrientation(((ChangeOrientation) webViewGameActivityStates).getMode());
        } else if (webViewGameActivityStates instanceof CloseScreen) {
            closeGame();
        } else if (webViewGameActivityStates instanceof HelpDeskRedirect) {
            startReactScreen(((HelpDeskRedirect) webViewGameActivityStates).getIntent());
        } else if (webViewGameActivityStates instanceof PaymentRedirect) {
            startReactScreen(((PaymentRedirect) webViewGameActivityStates).getIntent());
        } else if (webViewGameActivityStates instanceof ReloadState) {
            reloadWebView();
        } else if (webViewGameActivityStates instanceof HandleBackNavigation) {
            handleBackNavigation();
        } else if (webViewGameActivityStates instanceof InitSessionRequestParams) {
            prepareSessionApiParams(((InitSessionRequestParams) webViewGameActivityStates).getReactDataForWebGame());
        } else if (webViewGameActivityStates instanceof DisplayLoader) {
            displayLoader(((DisplayLoader) webViewGameActivityStates).isVisible());
        } else if (webViewGameActivityStates instanceof StartLoadingWebView) {
            startLoadingWebView(((StartLoadingWebView) webViewGameActivityStates).getUrl());
        } else if (webViewGameActivityStates instanceof NoConnectivity) {
            connectivityDialogDisplay();
        } else if (webViewGameActivityStates instanceof ReInitState) {
            reInitWebView();
        }
    }

    private final void setupObserver() {
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new WebViewGameActivity$setupObserver$1(this, null));
    }

    private final void startLoadingWebView(String str) {
        WebViewGameVm webViewGameVm = this.viewModel;
        if (webViewGameVm != null) {
            boolean performValidationForUrlPayload = webViewGameVm.performValidationForUrlPayload(str);
            WebViewGamesGamesCt webViewGamesGamesCt = WebViewGamesGamesCt.INSTANCE;
            WebViewGameVm webViewGameVm2 = this.viewModel;
            if (webViewGameVm2 != null) {
                WebViewGamesGamesCt.sendEventSessionApiStatus$default(webViewGamesGamesCt, webViewGameVm2.getGameId(), true, performValidationForUrlPayload, null, 8, null);
                if (performValidationForUrlPayload) {
                    WebViewDownTimeLogs webViewDownTimeLogs = this.webViewEventSession;
                    long currentTimeMillis = System.currentTimeMillis();
                    webViewDownTimeLogs.setSessionEnd(currentTimeMillis);
                    webViewDownTimeLogs.setWebStart(currentTimeMillis);
                    ((ActivityWebviewGameBinding) getBinding()).webViewGamesContainerId.loadWebViewFromUrl(str);
                    return;
                }
                errorDialogDisplay("InvalidUrl");
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        throw null;
    }

    private final void startReactScreen(Intent intent) {
        startActivity(intent);
        finish();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public void closeGame() {
        finish();
    }

    public void closeWeb() {
        finish();
    }

    public void closeWebViewWithReason(String str, String str2) {
    }

    public void connectivityDialogOkAction() {
        if (isConnectedToNetwork()) {
            WebViewGameVm webViewGameVm = this.viewModel;
            if (webViewGameVm != null) {
                webViewGameVm.initializeStates();
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                throw null;
            }
        } else {
            connectivityDialogDisplay();
        }
    }

    public void ctEventForWebViewLoading(long j) {
        WebViewGamesGamesCt webViewGamesGamesCt = WebViewGamesGamesCt.INSTANCE;
        WebViewGameVm webViewGameVm = this.viewModel;
        if (webViewGameVm != null) {
            webViewGamesGamesCt.sendTimeTakenEventForGameLoading(j, webViewGameVm.getGameId(), "WebViewGames");
            this.webViewEventSession.setWebEnd(System.currentTimeMillis());
            this.webViewEventSession.setFinalTime();
            WebViewGamesGamesCt webViewGamesGamesCt2 = WebViewGamesGamesCt.INSTANCE;
            WebViewGameVm webViewGameVm2 = this.viewModel;
            if (webViewGameVm2 != null) {
                webViewGamesGamesCt2.sendEventWebViewTransition(webViewGameVm2.getGameId(), this.webViewEventSession.getClkDurationFinal(), this.webViewEventSession.getSessionApiFinal(), this.webViewEventSession.getWebLoadFinal());
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                throw null;
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            throw null;
        }
    }

    public void initiateShare(String str, String str2, String str3, String str4) {
        WebViewGameVm webViewGameVm = this.viewModel;
        if (webViewGameVm != null) {
            webViewGameVm.initiateShare(str, str2, str3, str4);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            throw null;
        }
    }

    public void isWebViewLoading(boolean z) {
        displayLoader(z);
    }

    public void onBackPressed() {
        WebViewGamesContainer webViewGamesContainer = ((ActivityWebviewGameBinding) getBinding()).webViewGamesContainerId;
        WebViewGameVm webViewGameVm = this.viewModel;
        if (webViewGameVm == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            throw null;
        } else if (webViewGameVm.getLetGameHandleBackNav()) {
            webViewGamesContainer.handleNavigationUsingWebView();
        } else {
            webViewGamesContainer.handleNavigationUsingDevice();
        }
    }

    public void onConditionExit() {
        finish();
    }

    public void onCreate(Bundle bundle) {
        toggleSystemUI(true);
        super.onCreate(bundle);
        WebViewDownTimeLogs webViewDownTimeLogs = this.webViewEventSession;
        webViewDownTimeLogs.resetTimes();
        webViewDownTimeLogs.setTileClickStart(System.currentTimeMillis());
        initViewModel();
        setupObserver();
        WebViewGameVm webViewGameVm = this.viewModel;
        if (webViewGameVm != null) {
            webViewGameVm.initializeStates();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            throw null;
        }
    }

    public void onDestroy() {
        setWakelock(false);
        ((ActivityWebviewGameBinding) getBinding()).webViewGamesContainerId.closeWebView();
        toggleSystemUI(false);
        this.webViewEventSession.resetTimes();
        super.onDestroy();
    }

    public void openDeepLink(String str) {
    }

    public void performAction(String str) {
        WebViewGameVm webViewGameVm = this.viewModel;
        if (webViewGameVm != null) {
            webViewGameVm.performAction(str);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            throw null;
        }
    }

    public void publishEventToCtForError(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        sendClevertapEvent(str);
    }

    public void sendEvent(String str, String str2) {
        CleverTapAnalyticsUtils.sendEvent(str, str2);
    }

    public void showNavigationToMplDialog() {
        showExitDialog(this);
    }
}

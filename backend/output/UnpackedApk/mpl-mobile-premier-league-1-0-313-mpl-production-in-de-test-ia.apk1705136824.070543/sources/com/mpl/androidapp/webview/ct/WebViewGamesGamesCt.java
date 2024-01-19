package com.mpl.androidapp.webview.ct;

import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.webview.ct.EventConstants.WebGameEndToEndFlow;
import com.mpl.androidapp.webview.ct.EventConstants.WebViewSessionApiInitiation;
import com.mpl.androidapp.webview.ct.EventConstants.WebViewSessionApiStatus;
import com.mpl.androidapp.webview.ct.EventConstants.WebViewTransition;
import com.mpl.androidapp.webview.ct.EventConstants.ZltGameLoading;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\"\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ*\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\tJ4\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\t2\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0017j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001`\u0018H\u0002J&\u0010\u0019\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bJ \u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\tJ|\u0010 \u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\t2\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u00062\b\b\u0002\u0010$\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020\u00062\b\b\u0002\u0010&\u001a\u00020\u00062\b\b\u0002\u0010'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u00062\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u00062\b\b\u0002\u0010+\u001a\u00020\u0006¨\u0006,"}, d2 = {"Lcom/mpl/androidapp/webview/ct/WebViewGamesGamesCt;", "", "()V", "sendCtEventForWebFlowGame", "", "isException", "", "isGameCallback", "message", "", "gameId", "", "sendEventForGameConnectionLost", "battleId", "gameName", "sendEventSessionApiInitiation", "sendEventSessionApiStatus", "isSuccess", "sessionUrl", "failureReason", "sendEventToCleverTapAndKafka", "eventName", "properties", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "sendEventWebViewTransition", "tileClickDuration", "", "sessionApiDuration", "webLoadDuration", "sendTimeTakenEventForGameLoading", "timeTaken", "sendWebGameEndToEndFlow", "errorMessage", "gameTileClicked", "assetDownloadInitiated", "assetDownloadSuccessful", "assetDownloadFailure", "assetAlreadyDownloaded", "gameApiInitiated", "gameApiSuccessful", "gameApiFailure", "webGameLoadInitiated", "webGameLoadSuccessful", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebViewGamesGamesCt.kt */
public final class WebViewGamesGamesCt {
    public static final WebViewGamesGamesCt INSTANCE = new WebViewGamesGamesCt();

    public static /* synthetic */ void sendCtEventForWebFlowGame$default(WebViewGamesGamesCt webViewGamesGamesCt, boolean z, boolean z2, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = "";
        }
        webViewGamesGamesCt.sendCtEventForWebFlowGame(z, z2, str, i);
    }

    public static /* synthetic */ void sendEventForGameConnectionLost$default(WebViewGamesGamesCt webViewGamesGamesCt, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        webViewGamesGamesCt.sendEventForGameConnectionLost(str, i, str2);
    }

    public static /* synthetic */ void sendEventSessionApiStatus$default(WebViewGamesGamesCt webViewGamesGamesCt, int i, boolean z, boolean z2, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            str = "";
        }
        webViewGamesGamesCt.sendEventSessionApiStatus(i, z, z2, str);
    }

    private final void sendEventToCleverTapAndKafka(String str, HashMap<String, Object> hashMap) {
        MLogger.d("MindiGame", "sendEventToCleverTapAndKafka");
        CleverTapAnalyticsUtils.sendEvent(str, hashMap);
    }

    public static /* synthetic */ void sendTimeTakenEventForGameLoading$default(WebViewGamesGamesCt webViewGamesGamesCt, long j, int i, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = "";
        }
        webViewGamesGamesCt.sendTimeTakenEventForGameLoading(j, i, str);
    }

    public static /* synthetic */ void sendWebGameEndToEndFlow$default(WebViewGamesGamesCt webViewGamesGamesCt, int i, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i2, Object obj) {
        int i3 = i2;
        String str2 = (i3 & 2) != 0 ? "" : str;
        boolean z11 = false;
        boolean z12 = (i3 & 4) != 0 ? false : z;
        boolean z13 = (i3 & 8) != 0 ? false : z2;
        boolean z14 = (i3 & 16) != 0 ? false : z3;
        boolean z15 = (i3 & 32) != 0 ? false : z4;
        boolean z16 = (i3 & 64) != 0 ? false : z5;
        boolean z17 = (i3 & 128) != 0 ? false : z6;
        boolean z18 = (i3 & 256) != 0 ? false : z7;
        boolean z19 = (i3 & 512) != 0 ? false : z8;
        boolean z20 = (i3 & 1024) != 0 ? false : z9;
        if ((i3 & 2048) == 0) {
            z11 = z10;
        }
        webViewGamesGamesCt.sendWebGameEndToEndFlow(i, str2, z12, z13, z14, z15, z16, z17, z18, z19, z20, z11);
    }

    public final void sendCtEventForWebFlowGame(boolean z, boolean z2, String str, int i) {
        Intrinsics.checkNotNullParameter(str, "message");
        HashMap hashMap = new HashMap();
        hashMap.put("Is callback from game", Boolean.valueOf(z2));
        hashMap.put("Log message", str);
        hashMap.put("Is it an exception", Boolean.valueOf(z));
        hashMap.put("Game ID", Integer.valueOf(i));
        hashMap.put("platform", "android");
    }

    public final void sendEventForGameConnectionLost(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, WebViewGameVm.KEY_BATTLE_ID);
        Intrinsics.checkNotNullParameter(str2, "gameName");
        HashMap hashMap = new HashMap();
        hashMap.put("Game name", str2);
        hashMap.put("BattleId", str);
        hashMap.put("gameId", Integer.valueOf(i));
        sendEventToCleverTapAndKafka("USER_CONNECTION_LOST", hashMap);
    }

    public final void sendEventSessionApiInitiation(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("Game Id", Integer.valueOf(i));
        hashMap.put("Platform", "android");
        CleverTapAnalyticsUtils.sendEvent((String) WebViewSessionApiInitiation.EVENT_NAME, hashMap);
    }

    public final void sendEventSessionApiStatus(int i, boolean z, boolean z2, String str) {
        Intrinsics.checkNotNullParameter(str, "failureReason");
        HashMap hashMap = new HashMap();
        hashMap.put("Game Id", Integer.valueOf(i));
        hashMap.put("Platform", "android");
        hashMap.put(WebViewSessionApiStatus.PROPERTY_SESSION_URL_VALID, Boolean.valueOf(z2));
        hashMap.put(WebViewSessionApiStatus.PROPERTY_IS_SUCCESS, Boolean.valueOf(z));
        hashMap.put(WebViewSessionApiStatus.PROPERTY_FAILURE_MESSAGE, str);
        CleverTapAnalyticsUtils.sendEvent((String) WebViewSessionApiStatus.EVENT_NAME, hashMap);
    }

    public final void sendEventWebViewTransition(int i, long j, long j2, long j3) {
        HashMap hashMap = new HashMap();
        hashMap.put("Game Id", Integer.valueOf(i));
        hashMap.put("Platform", "android");
        hashMap.put(WebViewTransition.PROPERTY_TILE_CLICK_DURATION, Long.valueOf(j));
        hashMap.put(WebViewTransition.PROPERTY_SESSION_API_DURATION, Long.valueOf(j2));
        hashMap.put(WebViewTransition.PROPERTY_WEB_LOAD_DURATION, Long.valueOf(j3));
        CleverTapAnalyticsUtils.sendEvent((String) WebViewTransition.EVENT_NAME, hashMap);
    }

    public final void sendTimeTakenEventForGameLoading(long j, int i, String str) {
        Intrinsics.checkNotNullParameter(str, "gameName");
        HashMap hashMap = new HashMap();
        hashMap.put("Game Name", str);
        hashMap.put(ZltGameLoading.PROPERTY_TIME_TAKEN, Long.valueOf(j));
        hashMap.put("Game Id", Integer.valueOf(i));
        hashMap.put("Platform", "android");
        sendEventToCleverTapAndKafka(ZltGameLoading.EVENT_NAME, hashMap);
    }

    public final void sendWebGameEndToEndFlow(int i, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        HashMap hashMap = new HashMap();
        hashMap.put("gameId", Integer.valueOf(i));
        hashMap.put("platform", "android");
        hashMap.put(WebGameEndToEndFlow.PROPERTY_ERROR_MESSAGE, str);
        hashMap.put(WebGameEndToEndFlow.PROPERTY_GAME_TILE_CLICKED, Boolean.valueOf(z));
        hashMap.put(WebGameEndToEndFlow.PROPERTY_ASSET_DOWNLOAD_INITIATED, Boolean.valueOf(z2));
        hashMap.put(WebGameEndToEndFlow.PROPERTY_ASSET_DOWNLOAD_SUCCESSFUL, Boolean.valueOf(z3));
        hashMap.put(WebGameEndToEndFlow.PROPERTY_ASSET_DOWNLOAD_FAILURE, Boolean.valueOf(z4));
        hashMap.put(WebGameEndToEndFlow.PROPERTY_ASSET_ALREADY_DOWNLOADED, Boolean.valueOf(z5));
        hashMap.put(WebGameEndToEndFlow.PROPERTY_GAME_API_INITIATED, Boolean.valueOf(z6));
        hashMap.put(WebGameEndToEndFlow.PROPERTY_GAME_API_SUCCESSFUL, Boolean.valueOf(z7));
        hashMap.put(WebGameEndToEndFlow.PROPERTY_GAME_API_FAILURE, Boolean.valueOf(z8));
        hashMap.put(WebGameEndToEndFlow.PROPERTY_WEB_GAME_LOAD_INITIATED, Boolean.valueOf(z9));
        hashMap.put(WebGameEndToEndFlow.PROPERTY_WEB_GAME_LOAD_SUCCESSFUL, Boolean.valueOf(z10));
        CleverTapAnalyticsUtils.sendEvent((String) WebGameEndToEndFlow.EVENT_NAME, hashMap);
    }
}

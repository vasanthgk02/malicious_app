package com.mpl.androidapp.game.androidgames.ct;

import com.mpl.androidapp.game.androidgames.ct.EventConstants.AndroidGames;
import com.mpl.androidapp.game.androidgames.ct.EventConstants.BattleReconnectionConcluded;
import com.mpl.androidapp.game.androidgames.ct.EventConstants.BattleReconnectionInitiated;
import com.mpl.androidapp.game.androidgames.ct.EventConstants.MindiCardGame;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J4\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000fj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001`\u0010H\u0002J0\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u0016"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/ct/AndroidGamesCt;", "", "()V", "sendEventForBattleReconnectionConcluded", "", "battleId", "", "gameId", "", "gameName", "sendEventForBattleReconnectionInitiated", "sendEventForGameConnectionLost", "sendEventToCleverTapAndKafka", "eventName", "properties", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "sendGeneralEventsForCloudfeatherGames", "isException", "", "isMindiCallBack", "message", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidGamesCt.kt */
public final class AndroidGamesCt {
    public static final AndroidGamesCt INSTANCE = new AndroidGamesCt();

    private final void sendEventToCleverTapAndKafka(String str, HashMap<String, Object> hashMap) {
        MLogger.d("MindiGame", "sendEventToCleverTapAndKafka");
        CleverTapAnalyticsUtils.sendEvent(str, hashMap);
    }

    public static /* synthetic */ void sendGeneralEventsForCloudfeatherGames$default(AndroidGamesCt androidGamesCt, boolean z, boolean z2, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = "";
        }
        androidGamesCt.sendGeneralEventsForCloudfeatherGames(z, z2, str, str2, i);
    }

    public final void sendEventForBattleReconnectionConcluded(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, WebViewGameVm.KEY_BATTLE_ID);
        Intrinsics.checkNotNullParameter(str2, "gameName");
        HashMap hashMap = new HashMap();
        hashMap.put("Game name", str2);
        hashMap.put("BattleId", str);
        hashMap.put("gameId", Integer.valueOf(i));
        sendEventToCleverTapAndKafka(BattleReconnectionConcluded.EVENT_NAME, hashMap);
    }

    public final void sendEventForBattleReconnectionInitiated(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, WebViewGameVm.KEY_BATTLE_ID);
        Intrinsics.checkNotNullParameter(str2, "gameName");
        HashMap hashMap = new HashMap();
        hashMap.put("Game name", str2);
        hashMap.put("BattleId", str);
        hashMap.put("gameId", Integer.valueOf(i));
        sendEventToCleverTapAndKafka(BattleReconnectionInitiated.EVENT_NAME, hashMap);
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

    public final void sendGeneralEventsForCloudfeatherGames(boolean z, boolean z2, String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, WebViewGameVm.KEY_BATTLE_ID);
        HashMap hashMap = new HashMap();
        hashMap.put("Game name", AndroidGames.GAME_NAME_MINDI);
        hashMap.put("Is callback from game", Boolean.valueOf(z2));
        hashMap.put("Log message", str);
        hashMap.put("Is it an exception", Boolean.valueOf(z));
        hashMap.put("BattleId", str2);
        hashMap.put("gameId", Integer.valueOf(i));
        sendEventToCleverTapAndKafka(MindiCardGame.EVENT_NAME, hashMap);
    }
}

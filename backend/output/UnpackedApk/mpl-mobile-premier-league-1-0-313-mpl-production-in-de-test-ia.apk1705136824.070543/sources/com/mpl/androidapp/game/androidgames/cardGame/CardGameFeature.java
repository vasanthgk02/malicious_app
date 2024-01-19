package com.mpl.androidapp.game.androidgames.cardGame;

import android.content.Context;
import android.os.Bundle;
import com.cfg.mendikot.app.CFGMendikot;
import com.cfg.mendikot.app.SDKConfig;
import com.google.gson.Gson;
import com.mpl.androidapp.game.androidgames.cardGame.implementations.CardGameClose;
import com.mpl.androidapp.game.androidgames.cardGame.implementations.CardGameCloseImpl;
import com.mpl.androidapp.game.androidgames.cardGame.implementations.CardGameConfigImpl;
import com.mpl.androidapp.game.androidgames.cardGame.implementations.CardGameOpen;
import com.mpl.androidapp.game.androidgames.cardGame.implementations.CardGameOpenImpl;
import com.mpl.androidapp.game.androidgames.cardGame.implementations.CardGameValidateData;
import com.mpl.androidapp.game.androidgames.cardGame.implementations.CardGameValidateDataImpl;
import com.mpl.androidapp.game.androidgames.cardGame.implementations.InitilizeMindiConfig;
import com.mpl.androidapp.game.androidgames.cardGame.models.GameConfigInput;
import com.mpl.androidapp.game.androidgames.ct.CloudFeatherCtEventImpl;
import com.mpl.androidapp.game.androidgames.ct.EventConstants.AndroidGames;
import com.mpl.androidapp.game.androidgames.data.GameData;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import com.unity3d.player.UnityPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00013B/\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0006\u0010\"\u001a\u00020\u0017J\u0018\u0010#\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0016J \u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\nH\u0016J \u0010(\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\nH\u0016J \u0010)\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\nH\u0016J \u0010*\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\nH\u0016J(\u0010.\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\nH\u0002J\u0010\u00102\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\nH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/cardGame/CardGameFeature;", "Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameValidateData;", "Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/InitilizeMindiConfig;", "Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameOpen;", "Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameClose;", "context", "Landroid/content/Context;", "cardGameInstance", "Lcom/cfg/mendikot/app/CFGMendikot;", "gameData", "", "cardSdkConfig", "Lcom/cfg/mendikot/app/SDKConfig;", "gson", "Lcom/google/gson/Gson;", "(Landroid/content/Context;Lcom/cfg/mendikot/app/CFGMendikot;Ljava/lang/String;Lcom/cfg/mendikot/app/SDKConfig;Lcom/google/gson/Gson;)V", "gameDataResource", "Lcom/mpl/androidapp/game/androidgames/data/GameData;", "getGameDataResource", "()Lcom/mpl/androidapp/game/androidgames/data/GameData;", "setGameDataResource", "(Lcom/mpl/androidapp/game/androidgames/data/GameData;)V", "cardGameSdkInitialized", "", "closeCardGame", "data", "endedTheCardGame", "bundle", "Landroid/os/Bundle;", "message", "gameConnectionLost", "gameFatalCallback", "gameReConnected", "gameReConnectionStarted", "launchMindikotGame", "leftTheCardGame", "messageEventCardGameCloseImpl", "isException", "", "isMindiCallBack", "messageEventCardGameOpenImpl", "messageEventCardGameValidateDataImpl", "messageEventInitilizeMindiConfig", "mindiGameCallback", "openCardGame", "battleId", "prepareGameConfigInput", "Lcom/mpl/androidapp/game/androidgames/cardGame/models/GameConfigInput;", "sendDataToUnity", "dataToSend", "showUnityPopUp", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardGameFeature.kt */
public final class CardGameFeature implements CardGameValidateData, InitilizeMindiConfig, CardGameOpen, CardGameClose {
    public static final String BATTLE_ID = "BattleId";
    public static final Companion Companion = new Companion(null);
    public static final String GAME_DOWNLOAD_PATH = "Download/mplgameassets/";
    public static final String KEY_CONNECT_TIMEOUT = "CONNECT_TIMEOUT";
    public static final String KEY_DATA = "data";
    public static final String KEY_GAME_ID = "gameID";
    public static final String KEY_LEAVE_DATA = "leaveTable";
    public static final String KEY_RECONNECTION_INTERVAL = "RECONNECTION_INTERVAL";
    public static final String RESULT_FUNCTION_GAME = "SendResultFromNativeGame";
    public CFGMendikot cardGameInstance;
    public SDKConfig cardSdkConfig;
    public Context context;
    public String gameData;
    public GameData gameDataResource;
    public Gson gson;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/cardGame/CardGameFeature$Companion;", "", "()V", "BATTLE_ID", "", "GAME_DOWNLOAD_PATH", "KEY_CONNECT_TIMEOUT", "KEY_DATA", "KEY_GAME_ID", "KEY_LEAVE_DATA", "KEY_RECONNECTION_INTERVAL", "RESULT_FUNCTION_GAME", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardGameFeature.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CardGameFeature(Context context2, CFGMendikot cFGMendikot, String str, SDKConfig sDKConfig, Gson gson2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(cFGMendikot, "cardGameInstance");
        Intrinsics.checkNotNullParameter(sDKConfig, "cardSdkConfig");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.context = context2;
        this.cardGameInstance = cFGMendikot;
        this.gameData = str;
        this.cardSdkConfig = sDKConfig;
        this.gson = gson2;
    }

    private final GameConfigInput prepareGameConfigInput(Context context2, SDKConfig sDKConfig, GameData gameData2, CFGMendikot cFGMendikot) {
        return new GameConfigInput(context2, sDKConfig, gameData2, cFGMendikot);
    }

    private final void sendDataToUnity(String str) {
        UnityPlayer.UnitySendMessage("MPL", RESULT_FUNCTION_GAME, str);
    }

    private final void showUnityPopUp(String str) {
        this.cardGameInstance.closeGame();
        UnityPlayer.UnitySendMessage("MPL", RESULT_FUNCTION_GAME, "");
    }

    public void cardGameSdkInitialized(GameData gameData2) {
        Intrinsics.checkNotNullParameter(gameData2, "gameDataResource");
        new CardGameOpenImpl(gameData2, this).invoke();
    }

    public void closeCardGame(String str) {
        Intrinsics.checkNotNullParameter(str, "data");
        this.cardGameInstance.closeGame();
        sendDataToUnity(str);
    }

    public void endedTheCardGame(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, Constant.BUNDLE_DIR_NAME);
        Intrinsics.checkNotNullParameter(str, "message");
        new CloudFeatherCtEventImpl().battleGeneralGameEvent(false, true, str, getGameDataResource(), "MindiGame");
        new CardGameCloseImpl(bundle, this.gameData, this, this.gson).invoke();
    }

    public void gameConnectionLost(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        new CloudFeatherCtEventImpl().battleConnectionLostEvent(str, getGameDataResource(), AndroidGames.GAME_NAME_MINDI, "MindiGame");
        showUnityPopUp(str);
    }

    public void gameFatalCallback(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        new CloudFeatherCtEventImpl().battleGeneralGameEvent(false, true, str, getGameDataResource(), "MindiGame");
        showUnityPopUp(str);
    }

    public void gameReConnected(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        new CloudFeatherCtEventImpl().battleReconnectionConcludedEvent(str, getGameDataResource(), AndroidGames.GAME_NAME_MINDI, "MindiGame");
    }

    public void gameReConnectionStarted(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        new CloudFeatherCtEventImpl().battleReconnectionInitiatedEvent(str, getGameDataResource(), AndroidGames.GAME_NAME_MINDI, "MindiGame");
    }

    public final GameData getGameDataResource() {
        GameData gameData2 = this.gameDataResource;
        if (gameData2 != null) {
            return gameData2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gameDataResource");
        throw null;
    }

    public final void launchMindikotGame() {
        setGameDataResource(new CardGameValidateDataImpl(this.gameData, this.gson, this).invoke());
        CardGameConfigImpl cardGameConfigImpl = new CardGameConfigImpl(prepareGameConfigInput(this.context, this.cardSdkConfig, getGameDataResource(), this.cardGameInstance));
        cardGameConfigImpl.initOnClickInterface(this);
        cardGameConfigImpl.initMindikotSdk();
    }

    public void leftTheCardGame(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, Constant.BUNDLE_DIR_NAME);
        Intrinsics.checkNotNullParameter(str, "message");
        new CloudFeatherCtEventImpl().battleGeneralGameEvent(false, true, str, getGameDataResource(), "MindiGame");
    }

    public void messageEventCardGameCloseImpl(boolean z, boolean z2, String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        new CloudFeatherCtEventImpl().battleGeneralGameEvent(z, z2, str, getGameDataResource(), "MindiGame");
    }

    public void messageEventCardGameOpenImpl(boolean z, boolean z2, String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        new CloudFeatherCtEventImpl().battleGeneralGameEvent(z, z2, str, getGameDataResource(), "MindiGame");
    }

    public void messageEventCardGameValidateDataImpl(boolean z, boolean z2, String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        new CloudFeatherCtEventImpl().battleGeneralGameEvent(z, z2, str, getGameDataResource(), "MindiGame");
    }

    public void messageEventInitilizeMindiConfig(boolean z, boolean z2, String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        new CloudFeatherCtEventImpl().battleGeneralGameEvent(z, z2, str, getGameDataResource(), "MindiGame");
    }

    public void mindiGameCallback(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        new CloudFeatherCtEventImpl().battleGeneralGameEvent(false, true, str, getGameDataResource(), "MindiGame");
    }

    public void openCardGame(String str) {
        Intrinsics.checkNotNullParameter(str, WebViewGameVm.KEY_BATTLE_ID);
        this.cardGameInstance.openGame(str);
    }

    public final void setGameDataResource(GameData gameData2) {
        Intrinsics.checkNotNullParameter(gameData2, "<set-?>");
        this.gameDataResource = gameData2;
    }
}

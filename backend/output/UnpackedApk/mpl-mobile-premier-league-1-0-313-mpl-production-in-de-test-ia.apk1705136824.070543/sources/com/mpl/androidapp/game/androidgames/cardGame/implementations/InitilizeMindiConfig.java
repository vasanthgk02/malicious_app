package com.mpl.androidapp.game.androidgames.cardGame.implementations;

import android.os.Bundle;
import com.mpl.androidapp.game.androidgames.data.GameData;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\nH&J&\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\t\u001a\u00020\nH&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u0016"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/InitilizeMindiConfig;", "", "cardGameSdkInitialized", "", "gameDataResource", "Lcom/mpl/androidapp/game/androidgames/data/GameData;", "endedTheCardGame", "bundleData", "Landroid/os/Bundle;", "message", "", "gameConnectionLost", "gameFatalCallback", "gameReConnected", "gameReConnectionStarted", "leftTheCardGame", "name", "messageEventInitilizeMindiConfig", "isException", "", "isMindiCallBack", "mindiGameCallback", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardGameConfigImpl.kt */
public interface InitilizeMindiConfig {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardGameConfigImpl.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void messageEventInitilizeMindiConfig$default(InitilizeMindiConfig initilizeMindiConfig, boolean z, boolean z2, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                if ((i & 2) != 0) {
                    z2 = false;
                }
                if ((i & 4) != 0) {
                    str = "";
                }
                initilizeMindiConfig.messageEventInitilizeMindiConfig(z, z2, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: messageEventInitilizeMindiConfig");
        }
    }

    void cardGameSdkInitialized(GameData gameData);

    void endedTheCardGame(Bundle bundle, String str);

    void gameConnectionLost(String str);

    void gameFatalCallback(String str);

    void gameReConnected(String str);

    void gameReConnectionStarted(String str);

    void leftTheCardGame(Bundle bundle, String str);

    void messageEventInitilizeMindiConfig(boolean z, boolean z2, String str);

    void mindiGameCallback(String str);
}

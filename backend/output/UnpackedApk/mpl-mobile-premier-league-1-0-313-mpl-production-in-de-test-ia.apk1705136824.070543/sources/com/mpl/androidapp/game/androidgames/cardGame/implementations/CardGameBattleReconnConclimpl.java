package com.mpl.androidapp.game.androidgames.cardGame.implementations;

import com.mpl.androidapp.game.androidgames.ct.AndroidGamesCt;
import com.mpl.androidapp.game.androidgames.data.GameData;
import com.mpl.androidapp.utils.MLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u000eH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameBattleReconnConclimpl;", "", "message", "", "gameData", "Lcom/mpl/androidapp/game/androidgames/data/GameData;", "gameName", "(Ljava/lang/String;Lcom/mpl/androidapp/game/androidgames/data/GameData;Ljava/lang/String;)V", "getGameData", "()Lcom/mpl/androidapp/game/androidgames/data/GameData;", "getGameName", "()Ljava/lang/String;", "getMessage", "invoke", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardGameBattleReconnConclimpl.kt */
public final class CardGameBattleReconnConclimpl {
    public final GameData gameData;
    public final String gameName;
    public final String message;

    public CardGameBattleReconnConclimpl(String str, GameData gameData2, String str2) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(gameData2, "gameData");
        Intrinsics.checkNotNullParameter(str2, "gameName");
        this.message = str;
        this.gameData = gameData2;
        this.gameName = str2;
    }

    public final GameData getGameData() {
        return this.gameData;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void invoke() {
        try {
            MLogger.d("MindiGame", "----------------------------------------------------");
            MLogger.d("MindiGame", this.message);
            MLogger.d("MindiGame", "----------------------------------------------------");
            String battleId = this.gameData.getBattleId();
            if (battleId != null) {
                AndroidGamesCt.INSTANCE.sendEventForBattleReconnectionConcluded(battleId, getGameData().getGameId(), getGameName());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

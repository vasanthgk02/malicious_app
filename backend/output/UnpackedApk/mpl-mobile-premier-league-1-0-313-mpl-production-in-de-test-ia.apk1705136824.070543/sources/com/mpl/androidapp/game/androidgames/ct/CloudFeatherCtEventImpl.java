package com.mpl.androidapp.game.androidgames.ct;

import com.mpl.androidapp.game.androidgames.data.GameData;
import com.mpl.androidapp.utils.MLogger;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J.\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006J&\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J&\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006¨\u0006\u0011"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/ct/CloudFeatherCtEventImpl;", "", "()V", "battleConnectionLostEvent", "", "message", "", "gameData", "Lcom/mpl/androidapp/game/androidgames/data/GameData;", "gameName", "tag", "battleGeneralGameEvent", "isException", "", "isGameEventCallBack", "battleReconnectionConcludedEvent", "battleReconnectionInitiatedEvent", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CloudFeatherCtEventImpl.kt */
public final class CloudFeatherCtEventImpl {
    public final void battleConnectionLostEvent(String str, GameData gameData, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(gameData, "gameData");
        Intrinsics.checkNotNullParameter(str2, "gameName");
        Intrinsics.checkNotNullParameter(str3, InlineAnimation.TAG);
        try {
            MLogger.d(str3, "----------------------------------------------------");
            MLogger.d(str3, str);
            MLogger.d(str3, "----------------------------------------------------");
            String battleId = gameData.getBattleId();
            if (battleId != null) {
                AndroidGamesCt.INSTANCE.sendEventForGameConnectionLost(battleId, gameData.getGameId(), str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void battleGeneralGameEvent(boolean z, boolean z2, String str, GameData gameData, String str2) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(gameData, "gameData");
        Intrinsics.checkNotNullParameter(str2, InlineAnimation.TAG);
        try {
            MLogger.d(str2, "----------------------------------------------------");
            MLogger.d(str2, str);
            MLogger.d(str2, "----------------------------------------------------");
            String battleId = gameData.getBattleId();
            if (battleId != null) {
                AndroidGamesCt.INSTANCE.sendGeneralEventsForCloudfeatherGames(z, z2, str, battleId, gameData.getGameId());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void battleReconnectionConcludedEvent(String str, GameData gameData, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(gameData, "gameData");
        Intrinsics.checkNotNullParameter(str2, "gameName");
        Intrinsics.checkNotNullParameter(str3, InlineAnimation.TAG);
        try {
            MLogger.d(str3, "----------------------------------------------------");
            MLogger.d(str3, str);
            MLogger.d(str3, "----------------------------------------------------");
            String battleId = gameData.getBattleId();
            if (battleId != null) {
                AndroidGamesCt.INSTANCE.sendEventForBattleReconnectionConcluded(battleId, gameData.getGameId(), str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void battleReconnectionInitiatedEvent(String str, GameData gameData, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(gameData, "gameData");
        Intrinsics.checkNotNullParameter(str2, "gameName");
        Intrinsics.checkNotNullParameter(str3, InlineAnimation.TAG);
        try {
            MLogger.d(str3, "----------------------------------------------------");
            MLogger.d(str3, str);
            MLogger.d(str3, "----------------------------------------------------");
            String battleId = gameData.getBattleId();
            if (battleId != null) {
                AndroidGamesCt.INSTANCE.sendEventForBattleReconnectionInitiated(battleId, gameData.getGameId(), str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

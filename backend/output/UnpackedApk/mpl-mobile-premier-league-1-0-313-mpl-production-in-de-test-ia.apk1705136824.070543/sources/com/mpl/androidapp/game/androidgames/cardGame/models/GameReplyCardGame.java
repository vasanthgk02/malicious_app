package com.mpl.androidapp.game.androidgames.cardGame.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/cardGame/models/GameReplyCardGame;", "", "data", "Lcom/mpl/androidapp/game/androidgames/cardGame/models/MindiGameEndRespose;", "battleId", "", "(Lcom/mpl/androidapp/game/androidgames/cardGame/models/MindiGameEndRespose;Ljava/lang/String;)V", "getBattleId", "()Ljava/lang/String;", "getData", "()Lcom/mpl/androidapp/game/androidgames/cardGame/models/MindiGameEndRespose;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameReplyCardGame.kt */
public final class GameReplyCardGame {
    public final String battleId;
    public final MindiGameEndRespose data;

    public GameReplyCardGame(MindiGameEndRespose mindiGameEndRespose, String str) {
        Intrinsics.checkNotNullParameter(mindiGameEndRespose, "data");
        Intrinsics.checkNotNullParameter(str, WebViewGameVm.KEY_BATTLE_ID);
        this.data = mindiGameEndRespose;
        this.battleId = str;
    }

    public static /* synthetic */ GameReplyCardGame copy$default(GameReplyCardGame gameReplyCardGame, MindiGameEndRespose mindiGameEndRespose, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            mindiGameEndRespose = gameReplyCardGame.data;
        }
        if ((i & 2) != 0) {
            str = gameReplyCardGame.battleId;
        }
        return gameReplyCardGame.copy(mindiGameEndRespose, str);
    }

    public final MindiGameEndRespose component1() {
        return this.data;
    }

    public final String component2() {
        return this.battleId;
    }

    public final GameReplyCardGame copy(MindiGameEndRespose mindiGameEndRespose, String str) {
        Intrinsics.checkNotNullParameter(mindiGameEndRespose, "data");
        Intrinsics.checkNotNullParameter(str, WebViewGameVm.KEY_BATTLE_ID);
        return new GameReplyCardGame(mindiGameEndRespose, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameReplyCardGame)) {
            return false;
        }
        GameReplyCardGame gameReplyCardGame = (GameReplyCardGame) obj;
        return Intrinsics.areEqual(this.data, gameReplyCardGame.data) && Intrinsics.areEqual(this.battleId, gameReplyCardGame.battleId);
    }

    public final String getBattleId() {
        return this.battleId;
    }

    public final MindiGameEndRespose getData() {
        return this.data;
    }

    public int hashCode() {
        return this.battleId.hashCode() + (this.data.hashCode() * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GameReplyCardGame(data=");
        outline73.append(this.data);
        outline73.append(", battleId=");
        return GeneratedOutlineSupport.outline59(outline73, this.battleId, ')');
    }
}

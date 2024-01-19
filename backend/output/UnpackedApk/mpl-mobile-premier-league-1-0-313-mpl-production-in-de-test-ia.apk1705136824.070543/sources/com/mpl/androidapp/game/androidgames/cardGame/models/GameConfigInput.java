package com.mpl.androidapp.game.androidgames.cardGame.models;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.cfg.mendikot.app.CFGMendikot;
import com.cfg.mendikot.app.SDKConfig;
import com.mpl.androidapp.game.androidgames.data.GameData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/cardGame/models/GameConfigInput;", "", "context", "Landroid/content/Context;", "sdkConfig", "Lcom/cfg/mendikot/app/SDKConfig;", "gameDataResource", "Lcom/mpl/androidapp/game/androidgames/data/GameData;", "cardGameInstance", "Lcom/cfg/mendikot/app/CFGMendikot;", "(Landroid/content/Context;Lcom/cfg/mendikot/app/SDKConfig;Lcom/mpl/androidapp/game/androidgames/data/GameData;Lcom/cfg/mendikot/app/CFGMendikot;)V", "getCardGameInstance", "()Lcom/cfg/mendikot/app/CFGMendikot;", "getContext", "()Landroid/content/Context;", "getGameDataResource", "()Lcom/mpl/androidapp/game/androidgames/data/GameData;", "getSdkConfig", "()Lcom/cfg/mendikot/app/SDKConfig;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameConfigInput.kt */
public final class GameConfigInput {
    public final CFGMendikot cardGameInstance;
    public final Context context;
    public final GameData gameDataResource;
    public final SDKConfig sdkConfig;

    public GameConfigInput(Context context2, SDKConfig sDKConfig, GameData gameData, CFGMendikot cFGMendikot) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(sDKConfig, "sdkConfig");
        Intrinsics.checkNotNullParameter(gameData, "gameDataResource");
        Intrinsics.checkNotNullParameter(cFGMendikot, "cardGameInstance");
        this.context = context2;
        this.sdkConfig = sDKConfig;
        this.gameDataResource = gameData;
        this.cardGameInstance = cFGMendikot;
    }

    public static /* synthetic */ GameConfigInput copy$default(GameConfigInput gameConfigInput, Context context2, SDKConfig sDKConfig, GameData gameData, CFGMendikot cFGMendikot, int i, Object obj) {
        if ((i & 1) != 0) {
            context2 = gameConfigInput.context;
        }
        if ((i & 2) != 0) {
            sDKConfig = gameConfigInput.sdkConfig;
        }
        if ((i & 4) != 0) {
            gameData = gameConfigInput.gameDataResource;
        }
        if ((i & 8) != 0) {
            cFGMendikot = gameConfigInput.cardGameInstance;
        }
        return gameConfigInput.copy(context2, sDKConfig, gameData, cFGMendikot);
    }

    public final Context component1() {
        return this.context;
    }

    public final SDKConfig component2() {
        return this.sdkConfig;
    }

    public final GameData component3() {
        return this.gameDataResource;
    }

    public final CFGMendikot component4() {
        return this.cardGameInstance;
    }

    public final GameConfigInput copy(Context context2, SDKConfig sDKConfig, GameData gameData, CFGMendikot cFGMendikot) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(sDKConfig, "sdkConfig");
        Intrinsics.checkNotNullParameter(gameData, "gameDataResource");
        Intrinsics.checkNotNullParameter(cFGMendikot, "cardGameInstance");
        return new GameConfigInput(context2, sDKConfig, gameData, cFGMendikot);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameConfigInput)) {
            return false;
        }
        GameConfigInput gameConfigInput = (GameConfigInput) obj;
        return Intrinsics.areEqual(this.context, gameConfigInput.context) && Intrinsics.areEqual(this.sdkConfig, gameConfigInput.sdkConfig) && Intrinsics.areEqual(this.gameDataResource, gameConfigInput.gameDataResource) && Intrinsics.areEqual(this.cardGameInstance, gameConfigInput.cardGameInstance);
    }

    public final CFGMendikot getCardGameInstance() {
        return this.cardGameInstance;
    }

    public final Context getContext() {
        return this.context;
    }

    public final GameData getGameDataResource() {
        return this.gameDataResource;
    }

    public final SDKConfig getSdkConfig() {
        return this.sdkConfig;
    }

    public int hashCode() {
        int hashCode = this.sdkConfig.hashCode();
        int hashCode2 = this.gameDataResource.hashCode();
        return this.cardGameInstance.hashCode() + ((hashCode2 + ((hashCode + (this.context.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GameConfigInput(context=");
        outline73.append(this.context);
        outline73.append(", sdkConfig=");
        outline73.append(this.sdkConfig);
        outline73.append(", gameDataResource=");
        outline73.append(this.gameDataResource);
        outline73.append(", cardGameInstance=");
        outline73.append(this.cardGameInstance);
        outline73.append(')');
        return outline73.toString();
    }
}

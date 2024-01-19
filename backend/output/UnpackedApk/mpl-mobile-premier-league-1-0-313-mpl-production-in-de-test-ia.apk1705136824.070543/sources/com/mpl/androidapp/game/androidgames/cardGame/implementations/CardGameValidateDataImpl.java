package com.mpl.androidapp.game.androidgames.cardGame.implementations;

import com.google.gson.Gson;
import com.mpl.androidapp.game.androidgames.data.GameData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\t\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameValidateDataImpl;", "", "gameData", "", "gson", "Lcom/google/gson/Gson;", "listener", "Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameValidateData;", "(Ljava/lang/String;Lcom/google/gson/Gson;Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameValidateData;)V", "exceptionLog", "", "messageLog", "invoke", "Lcom/mpl/androidapp/game/androidgames/data/GameData;", "normalLog", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardGameValidateDataImpl.kt */
public final class CardGameValidateDataImpl {
    public static final Companion Companion = new Companion(null);
    public static final String MESSAGE_ERROR_FROM_EXCEPTION = "Error in parsing the game data from unity:: ";
    public static final String MESSAGE_INVALID_INPUT_FROM_UNITY = "Game data object received from the unity is not in proper model format";
    public String gameData;
    public final Gson gson;
    public final CardGameValidateData listener;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameValidateDataImpl$Companion;", "", "()V", "MESSAGE_ERROR_FROM_EXCEPTION", "", "MESSAGE_INVALID_INPUT_FROM_UNITY", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardGameValidateDataImpl.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CardGameValidateDataImpl(String str, Gson gson2, CardGameValidateData cardGameValidateData) {
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.gameData = str;
        this.gson = gson2;
        this.listener = cardGameValidateData;
    }

    private final void exceptionLog(String str) {
        CardGameValidateData cardGameValidateData = this.listener;
        if (cardGameValidateData != null) {
            cardGameValidateData.messageEventCardGameValidateDataImpl(true, false, str);
        }
    }

    private final void normalLog(String str) {
        CardGameValidateData cardGameValidateData = this.listener;
        if (cardGameValidateData != null) {
            cardGameValidateData.messageEventCardGameValidateDataImpl(false, false, str);
        }
    }

    public final GameData invoke() {
        GameData gameData2;
        if (this.gameData == null) {
            gameData2 = null;
        } else {
            try {
                Object fromJson = this.gson.fromJson(this.gameData, new CardGameValidateDataImpl$invoke$1$type$1().getType());
                Intrinsics.checkNotNullExpressionValue(fromJson, "{\n            val type =…gameData, type)\n        }");
                gameData2 = (GameData) fromJson;
            } catch (Exception e2) {
                exceptionLog(MESSAGE_ERROR_FROM_EXCEPTION);
                e2.printStackTrace();
                gameData2 = new GameData(0, null, null, null, null, null, false, 127, null);
            }
        }
        if (gameData2 != null) {
            return gameData2;
        }
        normalLog(MESSAGE_INVALID_INPUT_FROM_UNITY);
        GameData gameData3 = new GameData(0, null, null, null, null, null, false, 127, null);
        return gameData3;
    }

    public /* synthetic */ CardGameValidateDataImpl(String str, Gson gson2, CardGameValidateData cardGameValidateData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, gson2, (i & 4) != 0 ? null : cardGameValidateData);
    }
}

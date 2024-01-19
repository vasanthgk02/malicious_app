package com.mpl.androidapp.game.androidgames.cardGame.implementations;

import com.mpl.androidapp.game.androidgames.data.GameData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\t\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameOpenImpl;", "", "gameDataResource", "Lcom/mpl/androidapp/game/androidgames/data/GameData;", "listener", "Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameOpen;", "(Lcom/mpl/androidapp/game/androidgames/data/GameData;Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameOpen;)V", "exceptionLog", "", "messageLog", "", "invoke", "normalLog", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardGameOpenImpl.kt */
public final class CardGameOpenImpl {
    public static final Companion Companion = new Companion(null);
    public static final String MESSAGE_BATTLE_ID_EMPTY = "Battle ID is empty so cannot launch the game";
    public static final String MESSAGE_BATTLE_ID_NULL = "Battle ID is null so cannot launch the game";
    public static final String MESSAGE_ERROR_IN_OPENING_GAME_DATA = "Error in opening the game data:: ";
    public final GameData gameDataResource;
    public final CardGameOpen listener;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameOpenImpl$Companion;", "", "()V", "MESSAGE_BATTLE_ID_EMPTY", "", "MESSAGE_BATTLE_ID_NULL", "MESSAGE_ERROR_IN_OPENING_GAME_DATA", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardGameOpenImpl.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CardGameOpenImpl(GameData gameData, CardGameOpen cardGameOpen) {
        Intrinsics.checkNotNullParameter(gameData, "gameDataResource");
        this.gameDataResource = gameData;
        this.listener = cardGameOpen;
    }

    private final void exceptionLog(String str) {
        CardGameOpen cardGameOpen = this.listener;
        if (cardGameOpen != null) {
            cardGameOpen.messageEventCardGameOpenImpl(true, false, str);
        }
    }

    private final void normalLog(String str) {
        CardGameOpen cardGameOpen = this.listener;
        if (cardGameOpen != null) {
            cardGameOpen.messageEventCardGameOpenImpl(false, false, str);
        }
    }

    public final void invoke() {
        Unit unit;
        try {
            String battleId = this.gameDataResource.getBattleId();
            Unit unit2 = null;
            if (battleId != null) {
                if (battleId.length() > 0) {
                    CardGameOpen cardGameOpen = this.listener;
                    if (cardGameOpen != null) {
                        cardGameOpen.openCardGame(battleId);
                        unit = Unit.INSTANCE;
                    }
                } else {
                    normalLog(MESSAGE_BATTLE_ID_EMPTY);
                    unit = Unit.INSTANCE;
                }
                unit2 = unit;
            }
            if (unit2 == null) {
                normalLog(MESSAGE_BATTLE_ID_NULL);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            exceptionLog(Intrinsics.stringPlus(MESSAGE_ERROR_IN_OPENING_GAME_DATA, e2.getMessage()));
        }
    }

    public /* synthetic */ CardGameOpenImpl(GameData gameData, CardGameOpen cardGameOpen, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(gameData, (i & 2) != 0 ? null : cardGameOpen);
    }
}

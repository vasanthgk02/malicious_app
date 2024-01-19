package com.mpl.androidapp.game.androidgames.cardGame.implementations;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J&\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameClose;", "", "closeCardGame", "", "gameData", "", "messageEventCardGameCloseImpl", "isException", "", "isMindiCallBack", "message", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardGameCloseImpl.kt */
public interface CardGameClose {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardGameCloseImpl.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void messageEventCardGameCloseImpl$default(CardGameClose cardGameClose, boolean z, boolean z2, String str, int i, Object obj) {
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
                cardGameClose.messageEventCardGameCloseImpl(z, z2, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: messageEventCardGameCloseImpl");
        }
    }

    void closeCardGame(String str);

    void messageEventCardGameCloseImpl(boolean z, boolean z2, String str);
}

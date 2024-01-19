package com.mpl.androidapp.game.androidgames.cardGame.implementations;

import android.os.Bundle;
import com.google.gson.Gson;
import com.mpl.androidapp.game.androidgames.cardGame.CardGameFeature;
import com.mpl.androidapp.game.androidgames.cardGame.models.GameReplyCardGame;
import com.mpl.androidapp.game.androidgames.cardGame.models.MindiGameEndRespose;
import com.mpl.androidapp.utils.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002J\t\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameCloseImpl;", "", "bundle", "Landroid/os/Bundle;", "gameData", "", "listener", "Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameClose;", "gson", "Lcom/google/gson/Gson;", "(Landroid/os/Bundle;Ljava/lang/String;Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameClose;Lcom/google/gson/Gson;)V", "canCardGameBeClosed", "", "exceptionLog", "", "messageLog", "getGameDataFromBundle", "getGameIdFromBundle", "invoke", "isGameDataAvailable", "isGameIdAvailable", "normalLog", "prepareFinalUnityData", "id", "data", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardGameCloseImpl.kt */
public final class CardGameCloseImpl {
    public static final Companion Companion = new Companion(null);
    public static final String MESSAGE_DATA_EMPTY_FROM_MINDI = "Empty Data is received from Mindi Card Game";
    public static final String MESSAGE_ERROR_BUNDLE_HAS_NO_DATA_OBJECT = "Bundle does not contain the data object:: ";
    public static final String MESSAGE_ERROR_BUNDLE_HAS_NO_KEY = "Bundle does not contain the key:: ";
    public static final String MESSAGE_ERROR_OPENING_GAME_DATA = "Error in closing the game data:: ";
    public static final String MESSAGE_FLOW_FROM_LEAVE_GAME_OPTION = "User has clicked leave option before game ends";
    public static final String MESSAGE_GAME_DATA_IS_EMPTY_FROM_MINDI = "Game data is received is empty from mindi";
    public static final String MESSAGE_GAME_DATA_NULL = "Game data object received from the unity is null:: ";
    public static final String MESSAGE_GAME_ID_IS_EMPTY_FROM_MINDI = "Game id is received is empty from mindi";
    public static final String MESSAGE_NO_PROPER_DATA = "No proper data is available so game cannot be closed";
    public final Bundle bundle;
    public final String gameData;
    public final Gson gson;
    public final CardGameClose listener;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameCloseImpl$Companion;", "", "()V", "MESSAGE_DATA_EMPTY_FROM_MINDI", "", "MESSAGE_ERROR_BUNDLE_HAS_NO_DATA_OBJECT", "MESSAGE_ERROR_BUNDLE_HAS_NO_KEY", "MESSAGE_ERROR_OPENING_GAME_DATA", "MESSAGE_FLOW_FROM_LEAVE_GAME_OPTION", "MESSAGE_GAME_DATA_IS_EMPTY_FROM_MINDI", "MESSAGE_GAME_DATA_NULL", "MESSAGE_GAME_ID_IS_EMPTY_FROM_MINDI", "MESSAGE_NO_PROPER_DATA", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardGameCloseImpl.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CardGameCloseImpl(Bundle bundle2, String str, CardGameClose cardGameClose, Gson gson2) {
        Intrinsics.checkNotNullParameter(bundle2, Constant.BUNDLE_DIR_NAME);
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.bundle = bundle2;
        this.gameData = str;
        this.listener = cardGameClose;
        this.gson = gson2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean canCardGameBeClosed() {
        /*
            r5 = this;
            boolean r0 = r5.isGameIdAvailable()
            r1 = 0
            if (r0 != 0) goto L_0x000d
            java.lang.String r0 = "Bundle does not contain the key:: gameID"
            r5.normalLog(r0)
            return r1
        L_0x000d:
            boolean r0 = r5.isGameDataAvailable()
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = "Bundle does not contain the data object:: data"
            r5.normalLog(r0)
            return r1
        L_0x0019:
            java.lang.String r0 = r5.getGameIdFromBundle()
            r2 = 1
            if (r0 != 0) goto L_0x0022
        L_0x0020:
            r0 = 0
            goto L_0x002e
        L_0x0022:
            int r0 = r0.length()
            if (r0 != 0) goto L_0x002a
            r0 = 1
            goto L_0x002b
        L_0x002a:
            r0 = 0
        L_0x002b:
            if (r0 != r2) goto L_0x0020
            r0 = 1
        L_0x002e:
            if (r0 == 0) goto L_0x0036
            java.lang.String r0 = "Game id is received is empty from mindi"
            r5.normalLog(r0)
            return r1
        L_0x0036:
            java.lang.String r0 = r5.getGameDataFromBundle()
            if (r0 != 0) goto L_0x003e
        L_0x003c:
            r0 = 0
            goto L_0x004a
        L_0x003e:
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0046
            r0 = 1
            goto L_0x0047
        L_0x0046:
            r0 = 0
        L_0x0047:
            if (r0 != r2) goto L_0x003c
            r0 = 1
        L_0x004a:
            if (r0 == 0) goto L_0x0052
            java.lang.String r0 = "Game data is received is empty from mindi"
            r5.normalLog(r0)
            return r1
        L_0x0052:
            java.lang.String r0 = r5.getGameDataFromBundle()
            if (r0 != 0) goto L_0x005a
        L_0x0058:
            r0 = 0
            goto L_0x0064
        L_0x005a:
            r3 = 2
            java.lang.String r4 = "leaveTable"
            boolean r0 = kotlin.text.CharsKt__CharKt.contains$default(r0, r4, r1, r3)
            if (r0 != r2) goto L_0x0058
            r0 = 1
        L_0x0064:
            if (r0 == 0) goto L_0x006c
            java.lang.String r0 = "User has clicked leave option before game ends"
            r5.normalLog(r0)
            return r1
        L_0x006c:
            boolean r0 = r5.isGameIdAvailable()
            if (r0 == 0) goto L_0x0079
            boolean r0 = r5.isGameDataAvailable()
            if (r0 == 0) goto L_0x0079
            return r2
        L_0x0079:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.game.androidgames.cardGame.implementations.CardGameCloseImpl.canCardGameBeClosed():boolean");
    }

    private final void exceptionLog(String str) {
        CardGameClose cardGameClose = this.listener;
        if (cardGameClose != null) {
            cardGameClose.messageEventCardGameCloseImpl(true, false, str);
        }
    }

    private final String getGameDataFromBundle() {
        return this.bundle.getString("data");
    }

    private final String getGameIdFromBundle() {
        return this.bundle.getString(CardGameFeature.KEY_GAME_ID);
    }

    private final boolean isGameDataAvailable() {
        return this.bundle.containsKey("data");
    }

    private final boolean isGameIdAvailable() {
        return this.bundle.containsKey(CardGameFeature.KEY_GAME_ID);
    }

    private final void normalLog(String str) {
        CardGameClose cardGameClose = this.listener;
        if (cardGameClose != null) {
            cardGameClose.messageEventCardGameCloseImpl(false, false, str);
        }
    }

    private final String prepareFinalUnityData(String str, String str2) {
        MindiGameEndRespose mindiGameEndRespose = (MindiGameEndRespose) this.gson.fromJson(str2, MindiGameEndRespose.class);
        Intrinsics.checkNotNullExpressionValue(mindiGameEndRespose, "mindiGameResponse");
        return this.gson.toJson((Object) new GameReplyCardGame(mindiGameEndRespose, str)).toString();
    }

    public final void invoke() {
        try {
            if (canCardGameBeClosed()) {
                String gameIdFromBundle = getGameIdFromBundle();
                if (gameIdFromBundle != null) {
                    String gameDataFromBundle = getGameDataFromBundle();
                    if (gameDataFromBundle != null) {
                        String prepareFinalUnityData = prepareFinalUnityData(gameIdFromBundle, gameDataFromBundle);
                        CardGameClose cardGameClose = this.listener;
                        if (cardGameClose != null) {
                            cardGameClose.closeCardGame(prepareFinalUnityData);
                        }
                    }
                }
            } else {
                normalLog(MESSAGE_NO_PROPER_DATA);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            exceptionLog(Intrinsics.stringPlus(MESSAGE_ERROR_OPENING_GAME_DATA, e2.getMessage()));
        }
    }

    public /* synthetic */ CardGameCloseImpl(Bundle bundle2, String str, CardGameClose cardGameClose, Gson gson2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bundle2, str, (i & 4) != 0 ? null : cardGameClose, gson2);
    }
}

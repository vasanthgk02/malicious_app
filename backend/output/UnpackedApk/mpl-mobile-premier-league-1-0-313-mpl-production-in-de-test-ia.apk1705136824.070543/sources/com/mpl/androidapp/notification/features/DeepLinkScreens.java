package com.mpl.androidapp.notification.features;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007¨\u0006\u000e"}, d2 = {"Lcom/mpl/androidapp/notification/features/DeepLinkScreens;", "", "()V", "deepLinkGameItemDetails", "", "battleID", "gameId", "", "deepLinkGamesTab", "deepLinkHome", "deepLinkLobbyDetails", "tournamentId", "deepLinkRummyGameList", "deepLinkTournamentDetails", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeepLinkScreens.kt */
public final class DeepLinkScreens {
    public static final DeepLinkScreens INSTANCE = new DeepLinkScreens();

    public final String deepLinkGameItemDetails(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "battleID");
        return "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"GameItemDetails\",\"param\":{\"battleId\":\"" + str + "\",\"gameId\":" + i + "}}}";
    }

    public final String deepLinkGamesTab(int i) {
        return GeneratedOutlineSupport.outline42("{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"GamesTab\",\"param\":{\"id\":", i, "}}}");
    }

    public final String deepLinkHome() {
        return "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"Home\",\"param\":{}}}";
    }

    public final String deepLinkLobbyDetails(int i) {
        return GeneratedOutlineSupport.outline42("{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"LobbyDetails\",\"param\":{\"id\":", i, "}}}");
    }

    public final String deepLinkRummyGameList(int i) {
        return GeneratedOutlineSupport.outline42("{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"RummyGameList\",\"param\":{\"id\":", i, "}}}");
    }

    public final String deepLinkTournamentDetails(int i) {
        return GeneratedOutlineSupport.outline42("{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"TournamentDetails\",\"param\":{\"id\":", i, "}}}");
    }
}

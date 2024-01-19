package com.mpl.androidapp.notification.features;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/mpl/androidapp/notification/features/GameIdConditions;", "", "()V", "gamesTabScreenGames", "", "gameId", "", "gamesTournamentDetailScreen", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameIdConditions.kt */
public final class GameIdConditions {
    public static final GameIdConditions INSTANCE = new GameIdConditions();

    public final boolean gamesTabScreenGames(int i) {
        return i == 1000044 || i == 1000054 || i == 1000056 || i == 1000058 || i == 1000063 || i == 1000068 || i == 1000077;
    }

    public final boolean gamesTournamentDetailScreen(int i) {
        return i < 1000000;
    }
}

package com.mpl.androidapp.miniprofile.repository;

import com.google.gson.Gson;
import com.mpl.androidapp.miniprofile.service.FollowPlayerService;
import com.mpl.androidapp.miniprofile.service.FollowPlayerServiceImpl;
import com.mpl.androidapp.miniprofile.service.GameStatsService;
import com.mpl.androidapp.miniprofile.service.GameStatsServiceImpl;
import com.mpl.androidapp.miniprofile.service.ProfileDetailsService;
import com.mpl.androidapp.miniprofile.service.ProfileDetailsServiceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u0006\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0012J\u001e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/mpl/androidapp/miniprofile/repository/SendHeartRepository;", "", "playersListService", "Lcom/mpl/androidapp/miniprofile/service/ProfileDetailsService;", "followPlayerService", "Lcom/mpl/androidapp/miniprofile/service/FollowPlayerService;", "gameStatsService", "Lcom/mpl/androidapp/miniprofile/service/GameStatsService;", "(Lcom/mpl/androidapp/miniprofile/service/ProfileDetailsService;Lcom/mpl/androidapp/miniprofile/service/FollowPlayerService;Lcom/mpl/androidapp/miniprofile/service/GameStatsService;)V", "followPlayer", "", "view", "Lcom/mpl/androidapp/miniprofile/service/FollowPlayerServiceImpl;", "gson", "Lcom/google/gson/Gson;", "userId", "", "Lcom/mpl/androidapp/miniprofile/service/GameStatsServiceImpl;", "", "profileDetails", "Lcom/mpl/androidapp/miniprofile/service/ProfileDetailsServiceImpl;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SendHeartRepository.kt */
public final class SendHeartRepository {
    public final FollowPlayerService followPlayerService;
    public final GameStatsService gameStatsService;
    public final ProfileDetailsService playersListService;

    public SendHeartRepository(ProfileDetailsService profileDetailsService, FollowPlayerService followPlayerService2, GameStatsService gameStatsService2) {
        Intrinsics.checkNotNullParameter(profileDetailsService, "playersListService");
        Intrinsics.checkNotNullParameter(followPlayerService2, "followPlayerService");
        Intrinsics.checkNotNullParameter(gameStatsService2, "gameStatsService");
        this.playersListService = profileDetailsService;
        this.followPlayerService = followPlayerService2;
        this.gameStatsService = gameStatsService2;
    }

    public final void followPlayer(FollowPlayerServiceImpl followPlayerServiceImpl, Gson gson, String str) {
        Intrinsics.checkNotNullParameter(followPlayerServiceImpl, "view");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(str, "userId");
        this.followPlayerService.followPlayersApi(followPlayerServiceImpl, gson, str);
    }

    public final void gameStatsService(GameStatsServiceImpl gameStatsServiceImpl, Gson gson, int i) {
        Intrinsics.checkNotNullParameter(gameStatsServiceImpl, "view");
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.gameStatsService.gameStatsApi(gameStatsServiceImpl, gson, i);
    }

    public final void profileDetails(ProfileDetailsServiceImpl profileDetailsServiceImpl, Gson gson, String str) {
        Intrinsics.checkNotNullParameter(profileDetailsServiceImpl, "view");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(str, "userId");
        this.playersListService.profileDetailsApi(profileDetailsServiceImpl, gson, str);
    }
}

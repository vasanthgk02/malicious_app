package com.mpl.androidapp.miniprofile.service;

import com.mpl.androidapp.miniprofile.models.GameStatsPayload;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/mpl/androidapp/miniprofile/service/GameStatsServiceImpl;", "", "gameStatsApiResponseFailure", "", "message", "", "gameStatsApiResponseSuccess", "payload", "Lcom/mpl/androidapp/miniprofile/models/GameStatsPayload;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameStatsService.kt */
public interface GameStatsServiceImpl {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GameStatsService.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void gameStatsApiResponseFailure$default(GameStatsServiceImpl gameStatsServiceImpl, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = "";
                }
                gameStatsServiceImpl.gameStatsApiResponseFailure(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: gameStatsApiResponseFailure");
        }
    }

    void gameStatsApiResponseFailure(String str);

    void gameStatsApiResponseSuccess(GameStatsPayload gameStatsPayload);
}

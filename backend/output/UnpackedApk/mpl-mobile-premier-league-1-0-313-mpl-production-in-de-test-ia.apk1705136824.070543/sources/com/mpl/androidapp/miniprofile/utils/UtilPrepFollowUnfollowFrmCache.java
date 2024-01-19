package com.mpl.androidapp.miniprofile.utils;

import com.mpl.androidapp.miniprofile.models.Player;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0006\u0010\u0012\u001a\u00020\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/mpl/androidapp/miniprofile/utils/UtilPrepFollowUnfollowFrmCache;", "", "playerId", "", "(Ljava/lang/String;)V", "playersList", "", "Lcom/mpl/androidapp/miniprofile/models/Player;", "(Ljava/util/List;)V", "getPlayerId", "()Ljava/lang/String;", "setPlayerId", "getPlayersList", "()Ljava/util/List;", "setPlayersList", "getDataFromCache", "Lorg/json/JSONArray;", "prepFollowUnFollowLst", "updateFollowCache", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UtilPrepFollowUnfollowFrmCache.kt */
public final class UtilPrepFollowUnfollowFrmCache {
    public String playerId;
    public List<Player> playersList;

    public UtilPrepFollowUnfollowFrmCache(List<Player> list) {
        Intrinsics.checkNotNullParameter(list, "playersList");
        this.playersList = list;
        this.playerId = "";
    }

    private final JSONArray getDataFromCache() throws Exception {
        try {
            String stringPref = MSharedPreferencesUtils.getStringPref(Constants.FOLLOW_CACHE_KEY, "", true);
            Intrinsics.checkNotNullExpressionValue(stringPref, "getStringPref(FOLLOW_CACHE_KEY, \"\", true)");
            JSONArray jSONArray = new JSONArray(stringPref);
            jSONArray.toString();
            return jSONArray;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final String getPlayerId() {
        return this.playerId;
    }

    public final List<Player> getPlayersList() {
        return this.playersList;
    }

    public final List<Player> prepFollowUnFollowLst() {
        try {
            for (Player player : this.playersList) {
                String jSONArray = getDataFromCache().toString();
                Intrinsics.checkNotNullExpressionValue(jSONArray, "getDataFromCache().toString()");
                player.setFollowing(CharsKt__CharKt.contains$default((CharSequence) jSONArray, (CharSequence) String.valueOf(player.getId()), false, 2));
            }
            return this.playersList;
        } catch (Exception e2) {
            e2.printStackTrace();
            return new ArrayList();
        }
    }

    public final void setPlayerId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playerId = str;
    }

    public final void setPlayersList(List<Player> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.playersList = list;
    }

    public final void updateFollowCache() {
        JSONArray dataFromCache = getDataFromCache();
        Integer valueOf = Integer.valueOf(this.playerId);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(playerId)");
        String jSONArray = dataFromCache.put(valueOf.intValue()).toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray, "getDataFromCache().put(I…eOf(playerId)).toString()");
        MSharedPreferencesUtils.putStringPref(Constants.FOLLOW_CACHE_KEY, jSONArray, true);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public UtilPrepFollowUnfollowFrmCache(String str) {
        // Intrinsics.checkNotNullParameter(str, Constants.PLAYER_ID_KEY);
        this((List<Player>) new ArrayList<Player>());
        this.playerId = str;
    }
}

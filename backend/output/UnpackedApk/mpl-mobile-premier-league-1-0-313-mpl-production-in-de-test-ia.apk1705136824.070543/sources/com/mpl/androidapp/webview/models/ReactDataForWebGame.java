package com.mpl.androidapp.webview.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/mpl/androidapp/webview/models/ReactDataForWebGame;", "", "gameId", "", "battleId", "isSingleLaunch", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getBattleId", "()Ljava/lang/String;", "getGameId", "()Z", "setSingleLaunch", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReactDataForWebGame.kt */
public final class ReactDataForWebGame {
    @SerializedName("battleId")
    public final String battleId;
    @SerializedName("gameId")
    public final String gameId;
    public boolean isSingleLaunch;

    public ReactDataForWebGame() {
        this(null, null, false, 7, null);
    }

    public ReactDataForWebGame(String str, String str2, boolean z) {
        this.gameId = str;
        this.battleId = str2;
        this.isSingleLaunch = z;
    }

    public static /* synthetic */ ReactDataForWebGame copy$default(ReactDataForWebGame reactDataForWebGame, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reactDataForWebGame.gameId;
        }
        if ((i & 2) != 0) {
            str2 = reactDataForWebGame.battleId;
        }
        if ((i & 4) != 0) {
            z = reactDataForWebGame.isSingleLaunch;
        }
        return reactDataForWebGame.copy(str, str2, z);
    }

    public final String component1() {
        return this.gameId;
    }

    public final String component2() {
        return this.battleId;
    }

    public final boolean component3() {
        return this.isSingleLaunch;
    }

    public final ReactDataForWebGame copy(String str, String str2, boolean z) {
        return new ReactDataForWebGame(str, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReactDataForWebGame)) {
            return false;
        }
        ReactDataForWebGame reactDataForWebGame = (ReactDataForWebGame) obj;
        return Intrinsics.areEqual(this.gameId, reactDataForWebGame.gameId) && Intrinsics.areEqual(this.battleId, reactDataForWebGame.battleId) && this.isSingleLaunch == reactDataForWebGame.isSingleLaunch;
    }

    public final String getBattleId() {
        return this.battleId;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public int hashCode() {
        String str = this.gameId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.battleId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.isSingleLaunch;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public final boolean isSingleLaunch() {
        return this.isSingleLaunch;
    }

    public final void setSingleLaunch(boolean z) {
        this.isSingleLaunch = z;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ReactDataForWebGame(gameId=");
        outline73.append(this.gameId);
        outline73.append(", battleId=");
        outline73.append(this.battleId);
        outline73.append(", isSingleLaunch=");
        return GeneratedOutlineSupport.outline65(outline73, this.isSingleLaunch, ')');
    }

    public /* synthetic */ ReactDataForWebGame(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z);
    }
}

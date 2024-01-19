package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/Players;", "", "players", "", "Lcom/mpl/androidapp/miniprofile/models/Player;", "totalCount", "", "(Ljava/util/List;I)V", "getPlayers", "()Ljava/util/List;", "getTotalCount", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Players.kt */
public final class Players {
    @SerializedName("players")
    public final List<Player> players;
    @SerializedName("totalCount")
    public final int totalCount;

    public Players(List<Player> list, int i) {
        Intrinsics.checkNotNullParameter(list, "players");
        this.players = list;
        this.totalCount = i;
    }

    public static /* synthetic */ Players copy$default(Players players2, List<Player> list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = players2.players;
        }
        if ((i2 & 2) != 0) {
            i = players2.totalCount;
        }
        return players2.copy(list, i);
    }

    public final List<Player> component1() {
        return this.players;
    }

    public final int component2() {
        return this.totalCount;
    }

    public final Players copy(List<Player> list, int i) {
        Intrinsics.checkNotNullParameter(list, "players");
        return new Players(list, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Players)) {
            return false;
        }
        Players players2 = (Players) obj;
        return Intrinsics.areEqual(this.players, players2.players) && this.totalCount == players2.totalCount;
    }

    public final List<Player> getPlayers() {
        return this.players;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public int hashCode() {
        return (this.players.hashCode() * 31) + this.totalCount;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Players(players=");
        outline73.append(this.players);
        outline73.append(", totalCount=");
        return GeneratedOutlineSupport.outline56(outline73, this.totalCount, ')');
    }
}

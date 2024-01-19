package com.mpl.androidapp.game.androidgames.cardGame.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/cardGame/models/Teams;", "", "IsWinner", "", "Prize", "", "Users", "", "Lcom/mpl/androidapp/game/androidgames/cardGame/models/Users;", "(ZFLjava/util/List;)V", "getIsWinner", "()Z", "getPrize", "()F", "getUsers", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Teams.kt */
public final class Teams {
    public final boolean IsWinner;
    public final float Prize;
    public final List<Users> Users;

    public Teams(boolean z, float f2, List<Users> list) {
        Intrinsics.checkNotNullParameter(list, "Users");
        this.IsWinner = z;
        this.Prize = f2;
        this.Users = list;
    }

    public static /* synthetic */ Teams copy$default(Teams teams, boolean z, float f2, List<Users> list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = teams.IsWinner;
        }
        if ((i & 2) != 0) {
            f2 = teams.Prize;
        }
        if ((i & 4) != 0) {
            list = teams.Users;
        }
        return teams.copy(z, f2, list);
    }

    public final boolean component1() {
        return this.IsWinner;
    }

    public final float component2() {
        return this.Prize;
    }

    public final List<Users> component3() {
        return this.Users;
    }

    public final Teams copy(boolean z, float f2, List<Users> list) {
        Intrinsics.checkNotNullParameter(list, "Users");
        return new Teams(z, f2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Teams)) {
            return false;
        }
        Teams teams = (Teams) obj;
        return this.IsWinner == teams.IsWinner && Intrinsics.areEqual(Float.valueOf(this.Prize), Float.valueOf(teams.Prize)) && Intrinsics.areEqual(this.Users, teams.Users);
    }

    public final boolean getIsWinner() {
        return this.IsWinner;
    }

    public final float getPrize() {
        return this.Prize;
    }

    public final List<Users> getUsers() {
        return this.Users;
    }

    public int hashCode() {
        boolean z = this.IsWinner;
        if (z) {
            z = true;
        }
        int floatToIntBits = Float.floatToIntBits(this.Prize);
        return this.Users.hashCode() + ((floatToIntBits + ((z ? 1 : 0) * true)) * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Teams(IsWinner=");
        outline73.append(this.IsWinner);
        outline73.append(", Prize=");
        outline73.append(this.Prize);
        outline73.append(", Users=");
        outline73.append(this.Users);
        outline73.append(')');
        return outline73.toString();
    }
}

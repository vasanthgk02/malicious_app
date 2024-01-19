package com.mpl.androidapp.game.androidgames.cardGame.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/cardGame/models/MindiGameEndRespose;", "", "Teams", "Ljava/util/ArrayList;", "Lcom/mpl/androidapp/game/androidgames/cardGame/models/Teams;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getTeams", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MindiGameEndRespose.kt */
public final class MindiGameEndRespose {
    public final ArrayList<Teams> Teams;

    public MindiGameEndRespose(ArrayList<Teams> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "Teams");
        this.Teams = arrayList;
    }

    public static /* synthetic */ MindiGameEndRespose copy$default(MindiGameEndRespose mindiGameEndRespose, ArrayList<Teams> arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = mindiGameEndRespose.Teams;
        }
        return mindiGameEndRespose.copy(arrayList);
    }

    public final ArrayList<Teams> component1() {
        return this.Teams;
    }

    public final MindiGameEndRespose copy(ArrayList<Teams> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "Teams");
        return new MindiGameEndRespose(arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MindiGameEndRespose) && Intrinsics.areEqual(this.Teams, ((MindiGameEndRespose) obj).Teams);
    }

    public final ArrayList<Teams> getTeams() {
        return this.Teams;
    }

    public int hashCode() {
        return this.Teams.hashCode();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MindiGameEndRespose(Teams=");
        outline73.append(this.Teams);
        outline73.append(')');
        return outline73.toString();
    }
}

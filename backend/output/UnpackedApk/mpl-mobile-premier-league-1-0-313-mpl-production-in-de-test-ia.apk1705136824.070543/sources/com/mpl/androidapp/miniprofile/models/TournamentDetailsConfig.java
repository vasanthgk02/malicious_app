package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/TournamentDetailsConfig;", "", "showChatButton", "", "showPlayers", "showRecommendedBroadcasts", "(ZZZ)V", "getShowChatButton", "()Z", "getShowPlayers", "getShowRecommendedBroadcasts", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TournamentDetailsConfig.kt */
public final class TournamentDetailsConfig {
    public final boolean showChatButton;
    public final boolean showPlayers;
    public final boolean showRecommendedBroadcasts;

    public TournamentDetailsConfig() {
        this(false, false, false, 7, null);
    }

    public TournamentDetailsConfig(boolean z, boolean z2, boolean z3) {
        this.showChatButton = z;
        this.showPlayers = z2;
        this.showRecommendedBroadcasts = z3;
    }

    public static /* synthetic */ TournamentDetailsConfig copy$default(TournamentDetailsConfig tournamentDetailsConfig, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = tournamentDetailsConfig.showChatButton;
        }
        if ((i & 2) != 0) {
            z2 = tournamentDetailsConfig.showPlayers;
        }
        if ((i & 4) != 0) {
            z3 = tournamentDetailsConfig.showRecommendedBroadcasts;
        }
        return tournamentDetailsConfig.copy(z, z2, z3);
    }

    public final boolean component1() {
        return this.showChatButton;
    }

    public final boolean component2() {
        return this.showPlayers;
    }

    public final boolean component3() {
        return this.showRecommendedBroadcasts;
    }

    public final TournamentDetailsConfig copy(boolean z, boolean z2, boolean z3) {
        return new TournamentDetailsConfig(z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TournamentDetailsConfig)) {
            return false;
        }
        TournamentDetailsConfig tournamentDetailsConfig = (TournamentDetailsConfig) obj;
        return this.showChatButton == tournamentDetailsConfig.showChatButton && this.showPlayers == tournamentDetailsConfig.showPlayers && this.showRecommendedBroadcasts == tournamentDetailsConfig.showRecommendedBroadcasts;
    }

    public final boolean getShowChatButton() {
        return this.showChatButton;
    }

    public final boolean getShowPlayers() {
        return this.showPlayers;
    }

    public final boolean getShowRecommendedBroadcasts() {
        return this.showRecommendedBroadcasts;
    }

    public int hashCode() {
        boolean z = this.showChatButton;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z2 = this.showPlayers;
        if (z2) {
            z2 = true;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.showRecommendedBroadcasts;
        if (!z3) {
            i = z3;
        }
        return i3 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("TournamentDetailsConfig(showChatButton=");
        outline73.append(this.showChatButton);
        outline73.append(", showPlayers=");
        outline73.append(this.showPlayers);
        outline73.append(", showRecommendedBroadcasts=");
        return GeneratedOutlineSupport.outline65(outline73, this.showRecommendedBroadcasts, ')');
    }

    public /* synthetic */ TournamentDetailsConfig(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3);
    }
}

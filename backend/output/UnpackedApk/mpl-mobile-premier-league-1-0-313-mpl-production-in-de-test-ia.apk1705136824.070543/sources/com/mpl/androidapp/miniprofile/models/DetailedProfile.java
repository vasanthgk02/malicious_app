package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003Js\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u0006/"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/DetailedProfile;", "", "battlesPlayed", "", "gameCount", "", "Lcom/mpl/androidapp/miniprofile/models/GameCount;", "gamesPlayed", "profileViews", "Lcom/mpl/androidapp/miniprofile/models/ProfileViews;", "totalCash", "totalHeart", "totalReferrals", "totalTokens", "tournamentsPlayed", "tournamentsWon", "(ILjava/util/List;ILcom/mpl/androidapp/miniprofile/models/ProfileViews;IIIIII)V", "getBattlesPlayed", "()I", "getGameCount", "()Ljava/util/List;", "getGamesPlayed", "getProfileViews", "()Lcom/mpl/androidapp/miniprofile/models/ProfileViews;", "getTotalCash", "getTotalHeart", "getTotalReferrals", "getTotalTokens", "getTournamentsPlayed", "getTournamentsWon", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DetailedProfile.kt */
public final class DetailedProfile {
    @SerializedName("battlesPlayed")
    public final int battlesPlayed;
    @SerializedName("gameCount")
    public final List<GameCount> gameCount;
    @SerializedName("gamesPlayed")
    public final int gamesPlayed;
    @SerializedName("profileViews")
    public final ProfileViews profileViews;
    @SerializedName("totalCash")
    public final int totalCash;
    @SerializedName("totalHeart")
    public final int totalHeart;
    @SerializedName("totalReferrals")
    public final int totalReferrals;
    @SerializedName("totalTokens")
    public final int totalTokens;
    @SerializedName("tournamentsPlayed")
    public final int tournamentsPlayed;
    @SerializedName("tournamentsWon")
    public final int tournamentsWon;

    public DetailedProfile(int i, List<GameCount> list, int i2, ProfileViews profileViews2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(list, "gameCount");
        Intrinsics.checkNotNullParameter(profileViews2, "profileViews");
        this.battlesPlayed = i;
        this.gameCount = list;
        this.gamesPlayed = i2;
        this.profileViews = profileViews2;
        this.totalCash = i3;
        this.totalHeart = i4;
        this.totalReferrals = i5;
        this.totalTokens = i6;
        this.tournamentsPlayed = i7;
        this.tournamentsWon = i8;
    }

    public static /* synthetic */ DetailedProfile copy$default(DetailedProfile detailedProfile, int i, List list, int i2, ProfileViews profileViews2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Object obj) {
        DetailedProfile detailedProfile2 = detailedProfile;
        int i10 = i9;
        return detailedProfile.copy((i10 & 1) != 0 ? detailedProfile2.battlesPlayed : i, (i10 & 2) != 0 ? detailedProfile2.gameCount : list, (i10 & 4) != 0 ? detailedProfile2.gamesPlayed : i2, (i10 & 8) != 0 ? detailedProfile2.profileViews : profileViews2, (i10 & 16) != 0 ? detailedProfile2.totalCash : i3, (i10 & 32) != 0 ? detailedProfile2.totalHeart : i4, (i10 & 64) != 0 ? detailedProfile2.totalReferrals : i5, (i10 & 128) != 0 ? detailedProfile2.totalTokens : i6, (i10 & 256) != 0 ? detailedProfile2.tournamentsPlayed : i7, (i10 & 512) != 0 ? detailedProfile2.tournamentsWon : i8);
    }

    public final int component1() {
        return this.battlesPlayed;
    }

    public final int component10() {
        return this.tournamentsWon;
    }

    public final List<GameCount> component2() {
        return this.gameCount;
    }

    public final int component3() {
        return this.gamesPlayed;
    }

    public final ProfileViews component4() {
        return this.profileViews;
    }

    public final int component5() {
        return this.totalCash;
    }

    public final int component6() {
        return this.totalHeart;
    }

    public final int component7() {
        return this.totalReferrals;
    }

    public final int component8() {
        return this.totalTokens;
    }

    public final int component9() {
        return this.tournamentsPlayed;
    }

    public final DetailedProfile copy(int i, List<GameCount> list, int i2, ProfileViews profileViews2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(list, "gameCount");
        ProfileViews profileViews3 = profileViews2;
        Intrinsics.checkNotNullParameter(profileViews3, "profileViews");
        DetailedProfile detailedProfile = new DetailedProfile(i, list, i2, profileViews3, i3, i4, i5, i6, i7, i8);
        return detailedProfile;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DetailedProfile)) {
            return false;
        }
        DetailedProfile detailedProfile = (DetailedProfile) obj;
        return this.battlesPlayed == detailedProfile.battlesPlayed && Intrinsics.areEqual(this.gameCount, detailedProfile.gameCount) && this.gamesPlayed == detailedProfile.gamesPlayed && Intrinsics.areEqual(this.profileViews, detailedProfile.profileViews) && this.totalCash == detailedProfile.totalCash && this.totalHeart == detailedProfile.totalHeart && this.totalReferrals == detailedProfile.totalReferrals && this.totalTokens == detailedProfile.totalTokens && this.tournamentsPlayed == detailedProfile.tournamentsPlayed && this.tournamentsWon == detailedProfile.tournamentsWon;
    }

    public final int getBattlesPlayed() {
        return this.battlesPlayed;
    }

    public final List<GameCount> getGameCount() {
        return this.gameCount;
    }

    public final int getGamesPlayed() {
        return this.gamesPlayed;
    }

    public final ProfileViews getProfileViews() {
        return this.profileViews;
    }

    public final int getTotalCash() {
        return this.totalCash;
    }

    public final int getTotalHeart() {
        return this.totalHeart;
    }

    public final int getTotalReferrals() {
        return this.totalReferrals;
    }

    public final int getTotalTokens() {
        return this.totalTokens;
    }

    public final int getTournamentsPlayed() {
        return this.tournamentsPlayed;
    }

    public final int getTournamentsWon() {
        return this.tournamentsWon;
    }

    public int hashCode() {
        int hashCode = this.gameCount.hashCode();
        return ((((((((((((this.profileViews.hashCode() + ((((hashCode + (this.battlesPlayed * 31)) * 31) + this.gamesPlayed) * 31)) * 31) + this.totalCash) * 31) + this.totalHeart) * 31) + this.totalReferrals) * 31) + this.totalTokens) * 31) + this.tournamentsPlayed) * 31) + this.tournamentsWon;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("DetailedProfile(battlesPlayed=");
        outline73.append(this.battlesPlayed);
        outline73.append(", gameCount=");
        outline73.append(this.gameCount);
        outline73.append(", gamesPlayed=");
        outline73.append(this.gamesPlayed);
        outline73.append(", profileViews=");
        outline73.append(this.profileViews);
        outline73.append(", totalCash=");
        outline73.append(this.totalCash);
        outline73.append(", totalHeart=");
        outline73.append(this.totalHeart);
        outline73.append(", totalReferrals=");
        outline73.append(this.totalReferrals);
        outline73.append(", totalTokens=");
        outline73.append(this.totalTokens);
        outline73.append(", tournamentsPlayed=");
        outline73.append(this.tournamentsPlayed);
        outline73.append(", tournamentsWon=");
        return GeneratedOutlineSupport.outline56(outline73, this.tournamentsWon, ')');
    }
}

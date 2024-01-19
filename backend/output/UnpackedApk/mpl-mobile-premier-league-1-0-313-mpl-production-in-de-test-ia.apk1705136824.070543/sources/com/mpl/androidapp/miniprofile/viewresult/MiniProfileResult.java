package com.mpl.androidapp.miniprofile.viewresult;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.miniprofile.models.GameStatsPayload;
import com.mpl.androidapp.miniprofile.models.ProfileDetails;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/mpl/androidapp/miniprofile/viewresult/MiniProfileResult;", "", "()V", "ErrorState", "GameStatusSuccess", "LoadingState", "ProfileDetailsSuccessState", "ScreenSuccessFollowState", "Lcom/mpl/androidapp/miniprofile/viewresult/MiniProfileResult$LoadingState;", "Lcom/mpl/androidapp/miniprofile/viewresult/MiniProfileResult$ErrorState;", "Lcom/mpl/androidapp/miniprofile/viewresult/MiniProfileResult$ProfileDetailsSuccessState;", "Lcom/mpl/androidapp/miniprofile/viewresult/MiniProfileResult$ScreenSuccessFollowState;", "Lcom/mpl/androidapp/miniprofile/viewresult/MiniProfileResult$GameStatusSuccess;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MiniProfileResult.kt */
public abstract class MiniProfileResult {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/miniprofile/viewresult/MiniProfileResult$ErrorState;", "Lcom/mpl/androidapp/miniprofile/viewresult/MiniProfileResult;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MiniProfileResult.kt */
    public static final class ErrorState extends MiniProfileResult {
        public static final ErrorState INSTANCE = new ErrorState();

        public ErrorState() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/mpl/androidapp/miniprofile/viewresult/MiniProfileResult$GameStatusSuccess;", "Lcom/mpl/androidapp/miniprofile/viewresult/MiniProfileResult;", "gameStatsPayload", "Lcom/mpl/androidapp/miniprofile/models/GameStatsPayload;", "(Lcom/mpl/androidapp/miniprofile/models/GameStatsPayload;)V", "getGameStatsPayload", "()Lcom/mpl/androidapp/miniprofile/models/GameStatsPayload;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MiniProfileResult.kt */
    public static final class GameStatusSuccess extends MiniProfileResult {
        public final GameStatsPayload gameStatsPayload;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public GameStatusSuccess(GameStatsPayload gameStatsPayload2) {
            // Intrinsics.checkNotNullParameter(gameStatsPayload2, "gameStatsPayload");
            super(null);
            this.gameStatsPayload = gameStatsPayload2;
        }

        public static /* synthetic */ GameStatusSuccess copy$default(GameStatusSuccess gameStatusSuccess, GameStatsPayload gameStatsPayload2, int i, Object obj) {
            if ((i & 1) != 0) {
                gameStatsPayload2 = gameStatusSuccess.gameStatsPayload;
            }
            return gameStatusSuccess.copy(gameStatsPayload2);
        }

        public final GameStatsPayload component1() {
            return this.gameStatsPayload;
        }

        public final GameStatusSuccess copy(GameStatsPayload gameStatsPayload2) {
            Intrinsics.checkNotNullParameter(gameStatsPayload2, "gameStatsPayload");
            return new GameStatusSuccess(gameStatsPayload2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GameStatusSuccess) && Intrinsics.areEqual(this.gameStatsPayload, ((GameStatusSuccess) obj).gameStatsPayload);
        }

        public final GameStatsPayload getGameStatsPayload() {
            return this.gameStatsPayload;
        }

        public int hashCode() {
            return this.gameStatsPayload.hashCode();
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("GameStatusSuccess(gameStatsPayload=");
            outline73.append(this.gameStatsPayload);
            outline73.append(')');
            return outline73.toString();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/miniprofile/viewresult/MiniProfileResult$LoadingState;", "Lcom/mpl/androidapp/miniprofile/viewresult/MiniProfileResult;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MiniProfileResult.kt */
    public static final class LoadingState extends MiniProfileResult {
        public static final LoadingState INSTANCE = new LoadingState();

        public LoadingState() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/mpl/androidapp/miniprofile/viewresult/MiniProfileResult$ProfileDetailsSuccessState;", "Lcom/mpl/androidapp/miniprofile/viewresult/MiniProfileResult;", "profileDetails", "Lcom/mpl/androidapp/miniprofile/models/ProfileDetails;", "(Lcom/mpl/androidapp/miniprofile/models/ProfileDetails;)V", "getProfileDetails", "()Lcom/mpl/androidapp/miniprofile/models/ProfileDetails;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MiniProfileResult.kt */
    public static final class ProfileDetailsSuccessState extends MiniProfileResult {
        public final ProfileDetails profileDetails;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public ProfileDetailsSuccessState(ProfileDetails profileDetails2) {
            // Intrinsics.checkNotNullParameter(profileDetails2, "profileDetails");
            super(null);
            this.profileDetails = profileDetails2;
        }

        public static /* synthetic */ ProfileDetailsSuccessState copy$default(ProfileDetailsSuccessState profileDetailsSuccessState, ProfileDetails profileDetails2, int i, Object obj) {
            if ((i & 1) != 0) {
                profileDetails2 = profileDetailsSuccessState.profileDetails;
            }
            return profileDetailsSuccessState.copy(profileDetails2);
        }

        public final ProfileDetails component1() {
            return this.profileDetails;
        }

        public final ProfileDetailsSuccessState copy(ProfileDetails profileDetails2) {
            Intrinsics.checkNotNullParameter(profileDetails2, "profileDetails");
            return new ProfileDetailsSuccessState(profileDetails2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ProfileDetailsSuccessState) && Intrinsics.areEqual(this.profileDetails, ((ProfileDetailsSuccessState) obj).profileDetails);
        }

        public final ProfileDetails getProfileDetails() {
            return this.profileDetails;
        }

        public int hashCode() {
            return this.profileDetails.hashCode();
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("ProfileDetailsSuccessState(profileDetails=");
            outline73.append(this.profileDetails);
            outline73.append(')');
            return outline73.toString();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/miniprofile/viewresult/MiniProfileResult$ScreenSuccessFollowState;", "Lcom/mpl/androidapp/miniprofile/viewresult/MiniProfileResult;", "isSuccess", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MiniProfileResult.kt */
    public static final class ScreenSuccessFollowState extends MiniProfileResult {
        public final boolean isSuccess;

        public ScreenSuccessFollowState(boolean z) {
            super(null);
            this.isSuccess = z;
        }

        public static /* synthetic */ ScreenSuccessFollowState copy$default(ScreenSuccessFollowState screenSuccessFollowState, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = screenSuccessFollowState.isSuccess;
            }
            return screenSuccessFollowState.copy(z);
        }

        public final boolean component1() {
            return this.isSuccess;
        }

        public final ScreenSuccessFollowState copy(boolean z) {
            return new ScreenSuccessFollowState(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ScreenSuccessFollowState) && this.isSuccess == ((ScreenSuccessFollowState) obj).isSuccess;
        }

        public int hashCode() {
            boolean z = this.isSuccess;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isSuccess() {
            return this.isSuccess;
        }

        public String toString() {
            return GeneratedOutlineSupport.outline65(GeneratedOutlineSupport.outline73("ScreenSuccessFollowState(isSuccess="), this.isSuccess, ')');
        }
    }

    public MiniProfileResult() {
    }

    public /* synthetic */ MiniProfileResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

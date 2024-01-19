package com.mpl.androidapp.miniprofile.view.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.mpl.androidapp.R;
import com.mpl.androidapp.databinding.BroadcastMiniProfileViewBinding;
import com.mpl.androidapp.databinding.CustomViewStatsContainerBinding;
import com.mpl.androidapp.miniprofile.extensions.ImageViewExtKt;
import com.mpl.androidapp.miniprofile.extensions.ViewExtKt;
import com.mpl.androidapp.miniprofile.models.GameStatsPayload;
import com.mpl.androidapp.miniprofile.models.ProfileDetails;
import com.mpl.androidapp.miniprofile.utils.UtilMiniProfileBasicInfo;
import com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J6\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/mpl/androidapp/miniprofile/view/customviews/MiniProfileView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attributes", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "loggedInUser", "mBinding", "Lcom/mpl/androidapp/databinding/BroadcastMiniProfileViewBinding;", "isUserAccountDeleted", "", "details", "Lcom/mpl/androidapp/miniprofile/models/ProfileDetails;", "otherUserMessageFollow", "listener", "Landroid/view/View$OnClickListener;", "otherUserViewProfile", "setDataForProfile", "profileDetails", "chatEnabled", "", "userNameEnabledInConfig", "showKycVerifiedStatus", "gameStatsEnable", "gameStats", "Lcom/mpl/androidapp/miniprofile/models/GameStatsPayload;", "setGameStats", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MiniProfileView.kt */
public final class MiniProfileView extends ConstraintLayout {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "MiniProfileView";
    public Map<Integer, View> _$_findViewCache;
    public int loggedInUser;
    public BroadcastMiniProfileViewBinding mBinding;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/miniprofile/view/customviews/MiniProfileView$Companion;", "", "()V", "TAG", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MiniProfileView.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MiniProfileView(Context context) {
        // Intrinsics.checkNotNullParameter(context, "context");
        this(context, null, 0, 6, null);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MiniProfileView(Context context, AttributeSet attributeSet) {
        // Intrinsics.checkNotNullParameter(context, "context");
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ MiniProfileView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setGameStats(GameStatsPayload gameStatsPayload) {
        CustomViewStatsContainerBinding customViewStatsContainerBinding = this.mBinding.gameStatsId;
        customViewStatsContainerBinding.txtContestsPlayedValueId.setText(String.valueOf(gameStatsPayload.getTotalGamesPlayed()));
        if (gameStatsPayload.getTotalGamesWon() == 0) {
            customViewStatsContainerBinding.txtWinRateValueId.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        } else {
            customViewStatsContainerBinding.txtWinRateValueId.setText(Intrinsics.stringPlus(String.valueOf((int) Math.ceil((((double) gameStatsPayload.getTotalGamesWon()) / ((double) gameStatsPayload.getTotalGamesPlayed())) * ((double) 100))), "%"));
        }
        customViewStatsContainerBinding.txtCashWonValueId.setText(String.valueOf(gameStatsPayload.getTotalCashWon()));
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final void isUserAccountDeleted(ProfileDetails profileDetails) {
        Intrinsics.checkNotNullParameter(profileDetails, "details");
        boolean profileAccountDeleted = profileDetails.getBasicUser().getProfileAccountDeleted();
        BroadcastMiniProfileViewBinding broadcastMiniProfileViewBinding = this.mBinding;
        if (profileAccountDeleted) {
            ConstraintLayout constraintLayout = broadcastMiniProfileViewBinding.profileDeletedContainerId;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "profileDeletedContainerId");
            ViewExtKt.setVisibleOrGone(constraintLayout, true);
            ConstraintLayout constraintLayout2 = broadcastMiniProfileViewBinding.profileActiveContainerId;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "profileActiveContainerId");
            ViewExtKt.setVisibleOrGone(constraintLayout2, false);
            broadcastMiniProfileViewBinding.miniProfileNameAccDel.setText(profileDetails.getBasicUser().getDisplayName());
            broadcastMiniProfileViewBinding.miniProfileDescAccDel.setText(profileDetails.getBasicUser().getUserName());
            return;
        }
        ConstraintLayout constraintLayout3 = broadcastMiniProfileViewBinding.profileDeletedContainerId;
        Intrinsics.checkNotNullExpressionValue(constraintLayout3, "profileDeletedContainerId");
        ViewExtKt.setVisibleOrGone(constraintLayout3, false);
        ConstraintLayout constraintLayout4 = broadcastMiniProfileViewBinding.profileActiveContainerId;
        Intrinsics.checkNotNullExpressionValue(constraintLayout4, "profileActiveContainerId");
        ViewExtKt.setVisibleOrGone(constraintLayout4, true);
    }

    public final void otherUserMessageFollow(OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        this.mBinding.viewProfileRightBtnActionId.setOnClickListener(onClickListener);
    }

    public final void otherUserViewProfile(OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        this.mBinding.viewProfileLeftBtnActionId.setOnClickListener(onClickListener);
    }

    public final void setDataForProfile(ProfileDetails profileDetails, boolean z, boolean z2, boolean z3, boolean z4, GameStatsPayload gameStatsPayload) {
        Intrinsics.checkNotNullParameter(profileDetails, "profileDetails");
        Intrinsics.checkNotNullParameter(gameStatsPayload, "gameStats");
        UtilMiniProfileBasicInfo utilMiniProfileBasicInfo = new UtilMiniProfileBasicInfo(profileDetails, this.loggedInUser);
        MLogger.d(SharedGameStreamViewModel.TAG, Intrinsics.stringPlus("IS USER NAME ENABLED IN BOTH HANSEL AND ZK-> ", Boolean.valueOf(z2)));
        if (z2) {
            this.mBinding.miniProfilePersonName.setText(utilMiniProfileBasicInfo.getProfileDetails().getBasicUser().getUserName());
            this.mBinding.miniProfileDisplayName.setText(utilMiniProfileBasicInfo.getProfileDetails().getBasicUser().getDisplayName());
            ImageView imageView = this.mBinding.miniProfileBadge;
            Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.miniProfileBadge");
            ViewExtKt.setMarginLeft(imageView, (int) getContext().getResources().getDimension(R.dimen.gb_spacing_small_8dp));
        } else {
            this.mBinding.miniProfilePersonName.setText(utilMiniProfileBasicInfo.getProfileDetails().getBasicUser().getDisplayName());
            this.mBinding.miniProfileDisplayName.setVisibility(8);
        }
        if (!z3 || !profileDetails.getExtendedFields().getKycVerified()) {
            this.mBinding.kycBadgeId.setVisibility(8);
        } else {
            this.mBinding.kycBadgeId.setVisibility(0);
            if (z2) {
                ImageView imageView2 = this.mBinding.kycBadgeId;
                Intrinsics.checkNotNullExpressionValue(imageView2, "mBinding.kycBadgeId");
                ViewExtKt.setMarginLeft(imageView2, (int) getContext().getResources().getDimension(R.dimen.gb_spacing_small_8dp));
            }
        }
        if (z4) {
            this.mBinding.gameStatsId.txtContestsPlayedValueId.setCompoundDrawablesRelativeWithIntrinsicBounds(0, (int) R.drawable.ic_contests_played_icon, 0, 0);
            this.mBinding.gameStatsId.winRateContainerValueId.setVisibility(0);
            this.mBinding.gameStatsId.txtContestsPlayedDisplayId.setText(getContext().getResources().getString(R.string.games_played));
            setGameStats(gameStatsPayload);
        } else {
            this.mBinding.gameStatsId.winRateContainerValueId.setVisibility(8);
            this.mBinding.gameStatsId.txtContestsPlayedValueId.setCompoundDrawablesRelativeWithIntrinsicBounds((int) R.drawable.ic_contests_played_icon, 0, 0, 0);
            this.mBinding.gameStatsId.txtContestsPlayedDisplayId.setText(getContext().getResources().getString(R.string.games_played));
            this.mBinding.gameStatsId.txtContestsPlayedValueId.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.gb_margin_10));
            this.mBinding.gameStatsId.txtContestsPlayedValueId.setText(String.valueOf(profileDetails.getDetailedProfile().getGamesPlayed()));
        }
        ImageView imageView3 = this.mBinding.miniProfileImgViewId;
        Intrinsics.checkNotNullExpressionValue(imageView3, "mBinding.miniProfileImgViewId");
        String avatar = utilMiniProfileBasicInfo.getAvatar();
        BaseRequestOptions error = ((RequestOptions) new RequestOptions().placeholder((int) R.drawable.ic_avatar_default)).error((int) R.drawable.ic_avatar_default);
        Intrinsics.checkNotNullExpressionValue(error, "RequestOptions()\n       …awable.ic_avatar_default)");
        ImageViewExtKt.customRequestParam(imageView3, avatar, (RequestOptions) error);
        Integer badge = utilMiniProfileBasicInfo.getBadge();
        if (badge != null) {
            this.mBinding.miniProfileBadge.setImageResource(badge.intValue());
        }
        if (utilMiniProfileBasicInfo.isLoggedInUser()) {
            CustomMediumTextView customMediumTextView = this.mBinding.viewProfileLeftBtnActionId;
            Intrinsics.checkNotNullExpressionValue(customMediumTextView, "mBinding.viewProfileLeftBtnActionId");
            ViewExtKt.setVisibleOrGone(customMediumTextView, true);
            CustomMediumTextView customMediumTextView2 = this.mBinding.viewProfileRightBtnActionId;
            Intrinsics.checkNotNullExpressionValue(customMediumTextView2, "mBinding.viewProfileRightBtnActionId");
            ViewExtKt.setVisibleOrGone(customMediumTextView2, false);
        } else {
            if (utilMiniProfileBasicInfo.isFollowing()) {
                this.mBinding.viewProfileRightBtnActionId.setText(getContext().getText(R.string.gb_message));
            } else {
                this.mBinding.viewProfileRightBtnActionId.setText(getContext().getText(R.string.gb_follow));
            }
            if (profileDetails.getFollowDetails().getFollowing()) {
                CustomMediumTextView customMediumTextView3 = this.mBinding.viewProfileRightBtnActionId;
                Intrinsics.checkNotNullExpressionValue(customMediumTextView3, "mBinding.viewProfileRightBtnActionId");
                ViewExtKt.setVisibleOrGone(customMediumTextView3, z);
            } else {
                CustomMediumTextView customMediumTextView4 = this.mBinding.viewProfileRightBtnActionId;
                Intrinsics.checkNotNullExpressionValue(customMediumTextView4, "mBinding.viewProfileRightBtnActionId");
                ViewExtKt.setVisibleOrGone(customMediumTextView4, true);
            }
        }
        this.mBinding.followersValueId.setText(utilMiniProfileBasicInfo.followers());
        this.mBinding.followingValueId.setText(utilMiniProfileBasicInfo.following());
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MiniProfileView(Context context, AttributeSet attributeSet, int i) {
        // Intrinsics.checkNotNullParameter(context, "context");
        super(context, attributeSet, i);
        BroadcastMiniProfileViewBinding inflate = BroadcastMiniProfileViewBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this, true)");
        this.mBinding = inflate;
        this.loggedInUser = MSharedPreferencesUtils.getUserIdInNormalPref(context);
        this._$_findViewCache = new LinkedHashMap();
    }
}

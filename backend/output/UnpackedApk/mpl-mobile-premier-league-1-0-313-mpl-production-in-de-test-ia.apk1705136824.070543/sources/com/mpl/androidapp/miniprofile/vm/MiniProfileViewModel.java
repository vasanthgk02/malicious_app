package com.mpl.androidapp.miniprofile.vm;

import android.content.Context;
import androidx.core.widget.CompoundButtonCompat;
import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import com.mpl.androidapp.miniprofile.models.GameStatsPayload;
import com.mpl.androidapp.miniprofile.models.ProfileDetails;
import com.mpl.androidapp.miniprofile.repository.SendHeartRepository;
import com.mpl.androidapp.miniprofile.service.FollowPlayerServiceImpl;
import com.mpl.androidapp.miniprofile.service.GameStatsServiceImpl;
import com.mpl.androidapp.miniprofile.service.ProfileDetailsServiceImpl;
import com.mpl.androidapp.miniprofile.utils.UtilMiniProfileBasicInfo;
import com.mpl.androidapp.miniprofile.viewresult.MiniProfileResult;
import com.mpl.androidapp.miniprofile.viewresult.MiniProfileResult.LoadingState;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001DB\u0017\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u00020(H\u0002J\u0010\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020*H\u0016J\u0010\u00100\u001a\u00020(2\u0006\u00101\u001a\u00020\u000eH\u0016J\u0010\u00102\u001a\u00020(2\u0006\u00103\u001a\u000204H\u0016J\u0006\u00105\u001a\u00020(J\u0016\u00106\u001a\u00020(2\u0006\u00107\u001a\u0002082\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u00109\u001a\u00020*2\u0006\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020*J\u0018\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010?\u001a\u00020(H\u0002J\u0018\u0010@\u001a\u00020(2\u0006\u0010/\u001a\u00020*2\u0006\u0010A\u001a\u00020\u000eH\u0016J\u0018\u0010B\u001a\u00020(2\u0006\u0010/\u001a\u00020*2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010C\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u000eXD¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0010¨\u0006E"}, d2 = {"Lcom/mpl/androidapp/miniprofile/vm/MiniProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/mpl/androidapp/miniprofile/service/ProfileDetailsServiceImpl;", "Lcom/mpl/androidapp/miniprofile/service/FollowPlayerServiceImpl;", "Lcom/mpl/androidapp/miniprofile/service/GameStatsServiceImpl;", "sendHeartRepository", "Lcom/mpl/androidapp/miniprofile/repository/SendHeartRepository;", "gson", "Lcom/google/gson/Gson;", "(Lcom/mpl/androidapp/miniprofile/repository/SendHeartRepository;Lcom/google/gson/Gson;)V", "_miniProfileUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/mpl/androidapp/miniprofile/viewresult/MiniProfileResult;", "eventId", "", "getEventId", "()Ljava/lang/String;", "setEventId", "(Ljava/lang/String;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "miniProfileUiState", "Lkotlinx/coroutines/flow/StateFlow;", "getMiniProfileUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "profileDetails", "Lcom/mpl/androidapp/miniprofile/models/ProfileDetails;", "getProfileDetails", "()Lcom/mpl/androidapp/miniprofile/models/ProfileDetails;", "setProfileDetails", "(Lcom/mpl/androidapp/miniprofile/models/ProfileDetails;)V", "profileId", "getProfileId", "setProfileId", "screenType", "getScreenType", "setScreenType", "tag", "getTag", "callProfileApi", "", "connectivityAvailable", "", "miniProfileApis", "Lcom/mpl/androidapp/miniprofile/vm/MiniProfileApis;", "errorState", "followPlayerResponse", "success", "gameStatsApiResponseFailure", "message", "gameStatsApiResponseSuccess", "payload", "Lcom/mpl/androidapp/miniprofile/models/GameStatsPayload;", "getGameStats", "initiateProfileViewedEvent", "context", "Landroid/content/Context;", "isGameStatsEnabled", "gameStatsEnabledInZk", "gameStatsEnabledInHansel", "isLoggedInUser", "loggedInUser", "", "loadingState", "profileInfoApiFailureResponse", "responseString", "profileInfoApiSuccessResponse", "profileType", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MiniProfileViewModel.kt */
public final class MiniProfileViewModel extends ViewModel implements ProfileDetailsServiceImpl, FollowPlayerServiceImpl, GameStatsServiceImpl {
    public static final Companion Companion = new Companion(null);
    public static final String EVENT_NAME_PROFILE_VIEWED = "Profile Viewed";
    public static final String PROPERTY_BATTLES_PLAYED = "Battles Played";
    public static final String PROPERTY_CASH_WON = "Cash Won";
    public static final String PROPERTY_ENTRY_POINT = "Entry Point";
    public static final String PROPERTY_FOLLOWERS_COUNT = "Followers Count";
    public static final String PROPERTY_GAME_ID = "Game ID";
    public static final String PROPERTY_IS_MINI_CARD = "Is Mini Card";
    public static final String PROPERTY_MPL_USER_ID = "MPL User ID";
    public static final String PROPERTY_PROFILE_OWNER_DISPLAY_NAME = "Profile Owner DisplayName";
    public static final String PROPERTY_PROFILE_OWNER_USER_ID = "Profile Owner UserID";
    public static final String PROPERTY_PROFILE_OWNER_USER_NAME = "Profile Owner Username";
    public static final String PROPERTY_PROFILE_TYPE = "Profile Type";
    public static final String PROPERTY_PROFILE_VIEWS = "Profile Views";
    public static final String PROPERTY_PUBLISHER_USER_ID = "Publisher User Id";
    public static final String PROPERTY_SCREEN_NAME = "Screen Name";
    public static final String PROPERTY_TOURNAMENTS_PLAYED = "Tournaments Played";
    public static final String PROPERTY_VIEWER_ID = "Viewer ID";
    public static final String PUBLIC_PROFILE_TAG = "Public Profile";
    public static final String UNITY_INSTRUMENTATION_DEEPLINK = "Unity results page";
    public static final String USER_PROFILE_TAG = "User Profile";
    public final MutableStateFlow<MiniProfileResult> _miniProfileUiState;
    public String eventId = "";
    public final CoroutineExceptionHandler exceptionHandler;
    public final Gson gson;
    public final StateFlow<MiniProfileResult> miniProfileUiState;
    public ProfileDetails profileDetails;
    public String profileId = "";
    public String screenType = "";
    public final SendHeartRepository sendHeartRepository;
    public final String tag = "MiniProfileViewModel";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/mpl/androidapp/miniprofile/vm/MiniProfileViewModel$Companion;", "", "()V", "EVENT_NAME_PROFILE_VIEWED", "", "PROPERTY_BATTLES_PLAYED", "PROPERTY_CASH_WON", "PROPERTY_ENTRY_POINT", "PROPERTY_FOLLOWERS_COUNT", "PROPERTY_GAME_ID", "PROPERTY_IS_MINI_CARD", "PROPERTY_MPL_USER_ID", "PROPERTY_PROFILE_OWNER_DISPLAY_NAME", "PROPERTY_PROFILE_OWNER_USER_ID", "PROPERTY_PROFILE_OWNER_USER_NAME", "PROPERTY_PROFILE_TYPE", "PROPERTY_PROFILE_VIEWS", "PROPERTY_PUBLISHER_USER_ID", "PROPERTY_SCREEN_NAME", "PROPERTY_TOURNAMENTS_PLAYED", "PROPERTY_VIEWER_ID", "PUBLIC_PROFILE_TAG", "UNITY_INSTRUMENTATION_DEEPLINK", "USER_PROFILE_TAG", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MiniProfileViewModel.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MiniProfileViewModel(SendHeartRepository sendHeartRepository2, Gson gson2) {
        Intrinsics.checkNotNullParameter(sendHeartRepository2, "sendHeartRepository");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.sendHeartRepository = sendHeartRepository2;
        this.gson = gson2;
        MutableStateFlow<MiniProfileResult> MutableStateFlow = StateFlowKt.MutableStateFlow(LoadingState.INSTANCE);
        this._miniProfileUiState = MutableStateFlow;
        this.miniProfileUiState = TypeUtilsKt.asStateFlow(MutableStateFlow);
        this.exceptionHandler = new MiniProfileViewModel$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this);
    }

    /* access modifiers changed from: private */
    public final void errorState() {
        TypeUtilsKt.launch$default(CompoundButtonCompat.getViewModelScope(this), Dispatchers.getMain(), null, new MiniProfileViewModel$errorState$1(this, null), 2, null);
    }

    private final boolean isLoggedInUser(int i, ProfileDetails profileDetails2) {
        return new UtilMiniProfileBasicInfo(profileDetails2, i).isLoggedInUser();
    }

    /* access modifiers changed from: private */
    public final void loadingState() {
        TypeUtilsKt.launch$default(CompoundButtonCompat.getViewModelScope(this), Dispatchers.getMain(), null, new MiniProfileViewModel$loadingState$1(this, null), 2, null);
    }

    private final String profileType(int i, ProfileDetails profileDetails2) {
        return new UtilMiniProfileBasicInfo(profileDetails2, i).isLoggedInUser() ? USER_PROFILE_TAG : PUBLIC_PROFILE_TAG;
    }

    public final void callProfileApi(boolean z, MiniProfileApis miniProfileApis) {
        Intrinsics.checkNotNullParameter(miniProfileApis, "miniProfileApis");
        TypeUtilsKt.launch$default(CompoundButtonCompat.getViewModelScope(this), Dispatchers.IO.plus(this.exceptionHandler), null, new MiniProfileViewModel$callProfileApi$1(z, this, miniProfileApis, null), 2, null);
    }

    public void followPlayerResponse(boolean z) {
        TypeUtilsKt.launch$default(CompoundButtonCompat.getViewModelScope(this), Dispatchers.getMain(), null, new MiniProfileViewModel$followPlayerResponse$1(this, z, null), 2, null);
    }

    public void gameStatsApiResponseFailure(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        MLogger.d(this.tag, str);
        errorState();
    }

    public void gameStatsApiResponseSuccess(GameStatsPayload gameStatsPayload) {
        Intrinsics.checkNotNullParameter(gameStatsPayload, "payload");
        MLogger.d(this.tag, gameStatsPayload);
        TypeUtilsKt.launch$default(CompoundButtonCompat.getViewModelScope(this), Dispatchers.getMain(), null, new MiniProfileViewModel$gameStatsApiResponseSuccess$1(this, gameStatsPayload, null), 2, null);
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final void getGameStats() {
        this.sendHeartRepository.gameStatsService(this, this.gson, getProfileDetails().getBasicUser().getId());
    }

    public final StateFlow<MiniProfileResult> getMiniProfileUiState() {
        return this.miniProfileUiState;
    }

    public final ProfileDetails getProfileDetails() {
        ProfileDetails profileDetails2 = this.profileDetails;
        if (profileDetails2 != null) {
            return profileDetails2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("profileDetails");
        throw null;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final String getScreenType() {
        return this.screenType;
    }

    public final String getTag() {
        return this.tag;
    }

    public final void initiateProfileViewedEvent(Context context, ProfileDetails profileDetails2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(profileDetails2, "profileDetails");
        int userIdInNormalPref = MSharedPreferencesUtils.getUserIdInNormalPref(context);
        String userName = MSharedPreferencesUtils.getUserName();
        String displayName = MSharedPreferencesUtils.getUserInfo().getDisplayName();
        String profileType = profileType(userIdInNormalPref, profileDetails2);
        boolean isLoggedInUser = isLoggedInUser(userIdInNormalPref, profileDetails2);
        HashMap hashMap = new HashMap();
        hashMap.put(PROPERTY_PUBLISHER_USER_ID, Integer.valueOf(profileDetails2.getBasicUser().getId()));
        hashMap.put("Screen Name", profileType);
        hashMap.put(PROPERTY_PROFILE_TYPE, profileType);
        hashMap.put(PROPERTY_VIEWER_ID, Integer.valueOf(userIdInNormalPref));
        hashMap.put("MPL User ID", Integer.valueOf(userIdInNormalPref));
        if (isLoggedInUser) {
            hashMap.put(PROPERTY_PROFILE_OWNER_USER_ID, Integer.valueOf(userIdInNormalPref));
            Intrinsics.checkNotNullExpressionValue(userName, "loggedInUserName");
            hashMap.put(PROPERTY_PROFILE_OWNER_USER_NAME, userName);
            Intrinsics.checkNotNullExpressionValue(displayName, "loggedInDisplayName");
            hashMap.put(PROPERTY_PROFILE_OWNER_DISPLAY_NAME, displayName);
        } else {
            hashMap.put(PROPERTY_PROFILE_OWNER_USER_ID, Integer.valueOf(profileDetails2.getBasicUser().getId()));
            hashMap.put(PROPERTY_PROFILE_OWNER_USER_NAME, profileDetails2.getBasicUser().getUserName());
            hashMap.put(PROPERTY_PROFILE_OWNER_DISPLAY_NAME, profileDetails2.getBasicUser().getDisplayName());
        }
        hashMap.put(PROPERTY_TOURNAMENTS_PLAYED, Integer.valueOf(profileDetails2.getDetailedProfile().getTournamentsPlayed()));
        hashMap.put(PROPERTY_BATTLES_PLAYED, Integer.valueOf(profileDetails2.getDetailedProfile().getBattlesPlayed()));
        hashMap.put(PROPERTY_CASH_WON, Integer.valueOf(profileDetails2.getDetailedProfile().getTotalCash()));
        hashMap.put(PROPERTY_FOLLOWERS_COUNT, Integer.valueOf(profileDetails2.getFollowDetails().getFollowerCount()));
        hashMap.put(PROPERTY_PROFILE_VIEWS, profileDetails2.getDetailedProfile().getProfileViews());
        hashMap.put("Entry Point", this.screenType);
        hashMap.put(PROPERTY_IS_MINI_CARD, Boolean.TRUE);
        hashMap.put("Game ID", this.eventId);
        CleverTapAnalyticsUtils.sendEvent((String) EVENT_NAME_PROFILE_VIEWED, hashMap);
    }

    public final boolean isGameStatsEnabled(boolean z, boolean z2) {
        return z && z2;
    }

    public void profileInfoApiFailureResponse(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "responseString");
        MLogger.d(this.tag, str);
        errorState();
    }

    public void profileInfoApiSuccessResponse(boolean z, ProfileDetails profileDetails2) {
        Intrinsics.checkNotNullParameter(profileDetails2, "profileDetails");
        TypeUtilsKt.launch$default(CompoundButtonCompat.getViewModelScope(this), Dispatchers.getMain(), null, new MiniProfileViewModel$profileInfoApiSuccessResponse$1(this, profileDetails2, null), 2, null);
    }

    public final void setEventId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.eventId = str;
    }

    public final void setProfileDetails(ProfileDetails profileDetails2) {
        Intrinsics.checkNotNullParameter(profileDetails2, "<set-?>");
        this.profileDetails = profileDetails2;
    }

    public final void setProfileId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.profileId = str;
    }

    public final void setScreenType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.screenType = str;
    }
}

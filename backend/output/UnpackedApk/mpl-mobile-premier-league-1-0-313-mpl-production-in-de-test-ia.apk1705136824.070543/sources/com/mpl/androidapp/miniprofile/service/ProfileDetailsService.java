package com.mpl.androidapp.miniprofile.service;

import com.google.gson.Gson;
import com.mpl.androidapp.miniprofile.kotlin.model.ProfileInfo;
import com.mpl.androidapp.miniprofile.models.ProfileDetails;
import com.mpl.androidapp.miniprofile.service.utils.MplHeaders;
import com.mpl.androidapp.miniprofile.service.utils.MplNetworkCallParams;
import com.mpl.androidapp.miniprofile.service.utils.MplQueryParams;
import com.mpl.androidapp.miniprofile.utils.InlineFunctionUtils;
import com.mpl.androidapp.utils.Constant.ApiEndPoints;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.NetworkCallParams;
import com.mpl.androidapp.utils.NetworkUtils;
import com.mpl.network.modules.engine.MHeader;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ \u0010\r\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u001c\u0010\u0011\u001a\u00020\u000e2\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001e\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/mpl/androidapp/miniprofile/service/ProfileDetailsService;", "", "()V", "url", "", "getProfileDetails", "Lcom/mpl/androidapp/miniprofile/models/ProfileDetails;", "serverResponse", "gson", "Lcom/google/gson/Gson;", "getServerResponseCode", "", "getServerResponseMessage", "handleCallback", "", "callback", "Lcom/mpl/androidapp/miniprofile/service/ProfileDetailsServiceImpl;", "logException", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "printLogToConsole", "", "headers", "", "Lcom/mpl/network/modules/engine/MHeader;", "callParams", "Lcom/mpl/androidapp/utils/NetworkCallParams;", "profileDetailsApi", "userId", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProfileDetailsService.kt */
public final class ProfileDetailsService {
    public static final Companion Companion = new Companion(null);
    public static final String SOMETHING_WENT_WRONG = "Something went wrong";
    public static final String TAG;
    public String url = Intrinsics.stringPlus(MBuildConfigUtils.getMainUrl(), ApiEndPoints.PROFILE_DETAILS);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/mpl/androidapp/miniprofile/service/ProfileDetailsService$Companion;", "", "()V", "SOMETHING_WENT_WRONG", "", "TAG", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProfileDetailsService.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String simpleName = ProfileDetailsService.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "ProfileDetailsService::class.java.simpleName");
        TAG = simpleName;
    }

    /* access modifiers changed from: private */
    public final boolean logException(Exception exc, ProfileDetailsServiceImpl profileDetailsServiceImpl) {
        String message = exc.getMessage();
        if (message == null) {
            return false;
        }
        MLogger.d(TAG, Intrinsics.stringPlus("Exception: ", message));
        profileDetailsServiceImpl.profileInfoApiFailureResponse(false, message);
        return true;
    }

    private final void printLogToConsole(List<MHeader> list, NetworkCallParams networkCallParams) {
        boolean z;
        InlineFunctionUtils inlineFunctionUtils = InlineFunctionUtils.INSTANCE;
        Object[] objArr = {list, networkCallParams};
        int i = 0;
        while (true) {
            if (i >= 2) {
                z = true;
                break;
            }
            if (!(objArr[i] != null)) {
                z = false;
                break;
            }
            i++;
        }
        if (z) {
            ArrayList arrayList = (ArrayList) TweetUtils.filterNotNull(objArr);
            Object obj = arrayList.get(0);
            Object obj2 = arrayList.get(1);
            MLogger.d(TAG, Intrinsics.stringPlus("Headers: ", obj));
            MLogger.d(TAG, Intrinsics.stringPlus("NetworkParams: ", obj2));
        }
    }

    public final ProfileDetails getProfileDetails(String str, Gson gson) {
        Intrinsics.checkNotNullParameter(str, "serverResponse");
        Intrinsics.checkNotNullParameter(gson, "gson");
        return ((ProfileInfo) gson.fromJson(str, ProfileInfo.class)).getPayload();
    }

    public final int getServerResponseCode(String str, Gson gson) {
        Intrinsics.checkNotNullParameter(str, "serverResponse");
        Intrinsics.checkNotNullParameter(gson, "gson");
        return ((ProfileInfo) gson.fromJson(str, ProfileInfo.class)).getStatus().getCode();
    }

    public final String getServerResponseMessage(String str, Gson gson) {
        Intrinsics.checkNotNullParameter(str, "serverResponse");
        Intrinsics.checkNotNullParameter(gson, "gson");
        return ((ProfileInfo) gson.fromJson(str, ProfileInfo.class)).getStatus().getMessage();
    }

    public final boolean handleCallback(String str, Gson gson, ProfileDetailsServiceImpl profileDetailsServiceImpl) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(profileDetailsServiceImpl, "callback");
        if (str != null) {
            String serverResponseMessage = getServerResponseMessage(str, gson);
            if (getServerResponseCode(str, gson) == 200) {
                profileDetailsServiceImpl.profileInfoApiSuccessResponse(true, getProfileDetails(str, gson));
                return true;
            }
            profileDetailsServiceImpl.profileInfoApiFailureResponse(false, serverResponseMessage);
        } else {
            profileDetailsServiceImpl.profileInfoApiFailureResponse(false, "Something went wrong");
        }
        return false;
    }

    public final void profileDetailsApi(ProfileDetailsServiceImpl profileDetailsServiceImpl, Gson gson, String str) {
        Intrinsics.checkNotNullParameter(profileDetailsServiceImpl, "callback");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(str, "userId");
        try {
            String accessUserToken = MSharedPreferencesUtils.getAccessUserToken();
            MplHeaders mplHeaders = new MplHeaders();
            Intrinsics.checkNotNullExpressionValue(accessUserToken, "tolken");
            List<MHeader> prepareHeader = mplHeaders.prepareHeader(accessUserToken);
            NetworkCallParams buildNetWorkParamsWithQuery = new MplNetworkCallParams(this.url, prepareHeader, new MplQueryParams(str).prepareProfileDetails()).buildNetWorkParamsWithQuery();
            printLogToConsole(prepareHeader, buildNetWorkParamsWithQuery);
            NetworkUtils.doGetRequest(buildNetWorkParamsWithQuery, new ProfileDetailsService$profileDetailsApi$1(this, gson, profileDetailsServiceImpl), "server_Event");
        } catch (Exception e2) {
            logException(e2, profileDetailsServiceImpl);
        }
    }
}

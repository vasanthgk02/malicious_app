package com.mpl.androidapp.miniprofile.service;

import com.google.gson.Gson;
import com.mpl.androidapp.miniprofile.models.FollowPlayer;
import com.mpl.androidapp.miniprofile.models.FollowRoot;
import com.mpl.androidapp.miniprofile.utils.InlineFunctionUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.NetworkCallParams;
import com.mpl.network.modules.engine.MHeader;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ \u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u001c\u0010\u0012\u001a\u00020\u00112\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001e\u0010\u0016\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¨\u0006\u001d"}, d2 = {"Lcom/mpl/androidapp/miniprofile/service/FollowPlayerService;", "", "()V", "followPlayersApi", "", "callback", "Lcom/mpl/androidapp/miniprofile/service/FollowPlayerServiceImpl;", "gson", "Lcom/google/gson/Gson;", "userId", "", "getProfileDetails", "Lcom/mpl/androidapp/miniprofile/models/FollowRoot;", "serverResponse", "getServerResponseCode", "", "handleCallback", "", "logException", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "printLogToConsole", "headers", "", "Lcom/mpl/network/modules/engine/MHeader;", "callParams", "Lcom/mpl/androidapp/utils/NetworkCallParams;", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FollowPlayerService.kt */
public final class FollowPlayerService {
    public static final Companion Companion = new Companion(null);
    public static final String SOMETHING_WENT_WRONG = "Something went wrong";
    public static final String TAG;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/mpl/androidapp/miniprofile/service/FollowPlayerService$Companion;", "", "()V", "SOMETHING_WENT_WRONG", "", "TAG", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FollowPlayerService.kt */
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

    private final boolean logException(Exception exc, FollowPlayerServiceImpl followPlayerServiceImpl) {
        String message = exc.getMessage();
        if (message == null) {
            return false;
        }
        MLogger.d(TAG, Intrinsics.stringPlus("Exception: ", message));
        followPlayerServiceImpl.followPlayerResponse(false);
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

    public final void followPlayersApi(FollowPlayerServiceImpl followPlayerServiceImpl, Gson gson, String str) {
        Intrinsics.checkNotNullParameter(followPlayerServiceImpl, "callback");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(str, "userId");
    }

    public final FollowRoot getProfileDetails(String str, Gson gson) {
        Intrinsics.checkNotNullParameter(str, "serverResponse");
        Intrinsics.checkNotNullParameter(gson, "gson");
        return ((FollowPlayer) gson.fromJson(str, FollowPlayer.class)).getPayload();
    }

    public final int getServerResponseCode(String str, Gson gson) {
        Intrinsics.checkNotNullParameter(str, "serverResponse");
        Intrinsics.checkNotNullParameter(gson, "gson");
        return ((FollowPlayer) gson.fromJson(str, FollowPlayer.class)).getStatus().getCode();
    }

    public final boolean handleCallback(String str, Gson gson, FollowPlayerServiceImpl followPlayerServiceImpl) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(followPlayerServiceImpl, "callback");
        if (str != null) {
            int serverResponseCode = getServerResponseCode(str, gson);
            FollowRoot profileDetails = getProfileDetails(str, gson);
            if (serverResponseCode == 200) {
                followPlayerServiceImpl.followPlayerResponse(profileDetails.getSuccess());
                return profileDetails.getSuccess();
            }
            followPlayerServiceImpl.followPlayerResponse(profileDetails.getSuccess());
            return profileDetails.getSuccess();
        }
        followPlayerServiceImpl.followPlayerResponse(false);
        return false;
    }
}

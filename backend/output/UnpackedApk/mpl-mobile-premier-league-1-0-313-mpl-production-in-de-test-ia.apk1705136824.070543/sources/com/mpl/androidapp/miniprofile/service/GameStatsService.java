package com.mpl.androidapp.miniprofile.service;

import com.google.gson.Gson;
import com.mpl.androidapp.miniprofile.models.GameStatsPayload;
import com.mpl.androidapp.miniprofile.models.GameStatsResponse;
import com.mpl.androidapp.miniprofile.service.utils.MplHeaders;
import com.mpl.androidapp.miniprofile.service.utils.MplNetworkCallParams;
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
import java.util.IdentityHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ \u0010\u0012\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u001c\u0010\u0013\u001a\u00020\u00062\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u00162\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001c\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001e\u0010\u0019\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/mpl/androidapp/miniprofile/service/GameStatsService;", "", "()V", "url", "", "gameStatsApi", "", "callback", "Lcom/mpl/androidapp/miniprofile/service/GameStatsServiceImpl;", "gson", "Lcom/google/gson/Gson;", "userId", "", "gameStatsResponse", "Lcom/mpl/androidapp/miniprofile/models/GameStatsPayload;", "serverResponse", "getServerResponseCode", "getServerResponseMessage", "handleCallback", "logException", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "prepareQueryParams", "Ljava/util/IdentityHashMap;", "printLogToConsole", "headers", "", "Lcom/mpl/network/modules/engine/MHeader;", "callParams", "Lcom/mpl/androidapp/utils/NetworkCallParams;", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameStatsService.kt */
public final class GameStatsService {
    public static final Companion Companion = new Companion(null);
    public static final String SOMETHING_WENT_WRONG = "Something went wrong";
    public static final String TAG;
    public String url = Intrinsics.stringPlus(MBuildConfigUtils.getMainUrl(), ApiEndPoints.GAME_STATS);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/mpl/androidapp/miniprofile/service/GameStatsService$Companion;", "", "()V", "SOMETHING_WENT_WRONG", "", "TAG", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GameStatsService.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String simpleName = GameStatsService.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "GameStatsService::class.java.simpleName");
        TAG = simpleName;
    }

    /* access modifiers changed from: private */
    public final void logException(Exception exc, GameStatsServiceImpl gameStatsServiceImpl) {
        String message = exc.getMessage();
        if (message != null) {
            MLogger.d(TAG, Intrinsics.stringPlus("Exception: ", message));
            gameStatsServiceImpl.gameStatsApiResponseFailure(message);
        }
    }

    private final IdentityHashMap<String, String> prepareQueryParams(int i) {
        IdentityHashMap<String, String> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put("userId", String.valueOf(i));
        return identityHashMap;
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

    public final void gameStatsApi(GameStatsServiceImpl gameStatsServiceImpl, Gson gson, int i) {
        Intrinsics.checkNotNullParameter(gameStatsServiceImpl, "callback");
        Intrinsics.checkNotNullParameter(gson, "gson");
        try {
            String accessUserToken = MSharedPreferencesUtils.getAccessUserToken();
            MplHeaders mplHeaders = new MplHeaders();
            Intrinsics.checkNotNullExpressionValue(accessUserToken, "tolken");
            List<MHeader> prepareHeader = mplHeaders.prepareHeader(accessUserToken);
            NetworkCallParams buildNetWorkParamsWithQuery = new MplNetworkCallParams(this.url, prepareHeader, prepareQueryParams(i)).buildNetWorkParamsWithQuery();
            printLogToConsole(prepareHeader, buildNetWorkParamsWithQuery);
            NetworkUtils.doGetRequest(buildNetWorkParamsWithQuery, new GameStatsService$gameStatsApi$1(this, gson, gameStatsServiceImpl), "server_Event");
        } catch (Exception e2) {
            logException(e2, gameStatsServiceImpl);
        }
    }

    public final GameStatsPayload gameStatsResponse(String str, Gson gson) {
        Intrinsics.checkNotNullParameter(str, "serverResponse");
        Intrinsics.checkNotNullParameter(gson, "gson");
        return ((GameStatsResponse) gson.fromJson(str, GameStatsResponse.class)).getPayload();
    }

    public final int getServerResponseCode(String str, Gson gson) {
        Intrinsics.checkNotNullParameter(str, "serverResponse");
        Intrinsics.checkNotNullParameter(gson, "gson");
        return ((GameStatsResponse) gson.fromJson(str, GameStatsResponse.class)).getStatus().getCode();
    }

    public final String getServerResponseMessage(String str, Gson gson) {
        Intrinsics.checkNotNullParameter(str, "serverResponse");
        Intrinsics.checkNotNullParameter(gson, "gson");
        return ((GameStatsResponse) gson.fromJson(str, GameStatsResponse.class)).getStatus().getMessage();
    }

    public final void handleCallback(String str, Gson gson, GameStatsServiceImpl gameStatsServiceImpl) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(gameStatsServiceImpl, "callback");
        if (str != null) {
            String serverResponseMessage = getServerResponseMessage(str, gson);
            if (getServerResponseCode(str, gson) == 200) {
                gameStatsServiceImpl.gameStatsApiResponseSuccess(gameStatsResponse(str, gson));
            } else {
                gameStatsServiceImpl.gameStatsApiResponseFailure(serverResponseMessage);
            }
        } else {
            gameStatsServiceImpl.gameStatsApiResponseFailure("Something went wrong");
        }
    }
}

package com.mpl.androidapp.webview.services;

import com.google.gson.Gson;
import com.mpl.androidapp.miniprofile.service.utils.MplHeaders;
import com.mpl.androidapp.miniprofile.service.utils.MplNetworkCallParams;
import com.mpl.androidapp.miniprofile.utils.InlineFunctionUtils;
import com.mpl.androidapp.utils.Constant.ApiEndPoints;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.NetworkCallParams;
import com.mpl.androidapp.utils.NetworkUtils;
import com.mpl.androidapp.webview.models.SessionResponse;
import com.mpl.androidapp.webview.models.SessionRoot;
import com.mpl.network.modules.engine.MHeader;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003J\u0016\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003J \u0010\u0015\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fJ\u001c\u0010\u0017\u001a\u00020\u00162\n\u0010\u0018\u001a\u00060\u0019j\u0002`\u001a2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001e\u0010\u001b\u001a\u00020\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/mpl/androidapp/webview/services/WebFlowGamesService;", "", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "getGson", "()Lcom/google/gson/Gson;", "url", "", "callApi", "", "callback", "Lcom/mpl/androidapp/webview/services/WebFlowServiceImpl;", "requestObject", "Lorg/json/JSONObject;", "getProfileDetails", "Lcom/mpl/androidapp/webview/models/SessionRoot;", "serverResponse", "getServerResponseCode", "", "getServerResponseMessage", "handleCallback", "", "logException", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "printLogToConsole", "headers", "", "Lcom/mpl/network/modules/engine/MHeader;", "callParams", "Lcom/mpl/androidapp/utils/NetworkCallParams;", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebFlowGamesService.kt */
public final class WebFlowGamesService {
    public static final Companion Companion = new Companion(null);
    public static final String SOMETHING_WENT_WRONG = "Something went wrong";
    public final Gson gson;
    public String url = Intrinsics.stringPlus(MBuildConfigUtils.getMainUrl(), ApiEndPoints.PARTNER_SESSION_TOLKEN);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/webview/services/WebFlowGamesService$Companion;", "", "()V", "SOMETHING_WENT_WRONG", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebFlowGamesService.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WebFlowGamesService(Gson gson2) {
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.gson = gson2;
    }

    /* access modifiers changed from: private */
    public final boolean logException(Exception exc, WebFlowServiceImpl webFlowServiceImpl) {
        String message = exc.getMessage();
        if (message == null) {
            return false;
        }
        MLogger.d("WebViewGames", Intrinsics.stringPlus("Exception: ", message));
        webFlowServiceImpl.sessionApiFailure(String.valueOf(exc.getMessage()));
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
            MLogger.d("WebViewGames", Intrinsics.stringPlus("Headers: ", obj));
            MLogger.d("WebViewGames", Intrinsics.stringPlus("NetworkParams: ", obj2));
        }
    }

    public final void callApi(WebFlowServiceImpl webFlowServiceImpl, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(webFlowServiceImpl, "callback");
        Intrinsics.checkNotNullParameter(jSONObject, "requestObject");
        try {
            String accessUserToken = MSharedPreferencesUtils.getAccessUserToken();
            MplHeaders mplHeaders = new MplHeaders();
            Intrinsics.checkNotNullExpressionValue(accessUserToken, "tolken");
            List<MHeader> prepareHeader = mplHeaders.prepareHeader(accessUserToken);
            NetworkCallParams buildNetWorkParams = new MplNetworkCallParams(jSONObject, this.url, prepareHeader).buildNetWorkParams();
            printLogToConsole(prepareHeader, buildNetWorkParams);
            NetworkUtils.doPostRequest(buildNetWorkParams, new WebFlowGamesService$callApi$1(this, webFlowServiceImpl), "server_Event");
        } catch (Exception e2) {
            logException(e2, webFlowServiceImpl);
        }
    }

    public final Gson getGson() {
        return this.gson;
    }

    public final SessionRoot getProfileDetails(String str, Gson gson2) {
        Intrinsics.checkNotNullParameter(str, "serverResponse");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        return ((SessionResponse) gson2.fromJson(str, SessionResponse.class)).getPayload();
    }

    public final int getServerResponseCode(String str, Gson gson2) {
        Intrinsics.checkNotNullParameter(str, "serverResponse");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        return ((SessionResponse) gson2.fromJson(str, SessionResponse.class)).getStatus().getCode();
    }

    public final String getServerResponseMessage(String str, Gson gson2) {
        Intrinsics.checkNotNullParameter(str, "serverResponse");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        return ((SessionResponse) gson2.fromJson(str, SessionResponse.class)).getStatus().getMessage();
    }

    public final boolean handleCallback(String str, Gson gson2, WebFlowServiceImpl webFlowServiceImpl) {
        Intrinsics.checkNotNullParameter(gson2, "gson");
        Intrinsics.checkNotNullParameter(webFlowServiceImpl, "callback");
        if (str != null) {
            int serverResponseCode = getServerResponseCode(str, gson2);
            String serverResponseMessage = getServerResponseMessage(str, gson2);
            SessionRoot profileDetails = getProfileDetails(str, gson2);
            if (serverResponseCode == 200) {
                MLogger.d("WebViewGames", Intrinsics.stringPlus("WebFlowResponse: ", profileDetails));
                webFlowServiceImpl.sessionApiSuccess(str);
                return true;
            }
            webFlowServiceImpl.sessionApiFailure(serverResponseMessage);
        } else {
            webFlowServiceImpl.sessionApiFailure("Null response from server");
        }
        return false;
    }
}

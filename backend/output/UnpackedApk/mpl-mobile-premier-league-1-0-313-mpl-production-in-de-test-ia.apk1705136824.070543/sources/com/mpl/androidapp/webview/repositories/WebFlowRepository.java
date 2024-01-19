package com.mpl.androidapp.webview.repositories;

import com.mpl.androidapp.webview.services.WebFlowGamesService;
import com.mpl.androidapp.webview.services.WebFlowServiceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/mpl/androidapp/webview/repositories/WebFlowRepository;", "", "webFlowGamesService", "Lcom/mpl/androidapp/webview/services/WebFlowGamesService;", "(Lcom/mpl/androidapp/webview/services/WebFlowGamesService;)V", "getSessionToken", "", "view", "Lcom/mpl/androidapp/webview/services/WebFlowServiceImpl;", "jsonObject", "Lorg/json/JSONObject;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebFlowRepository.kt */
public final class WebFlowRepository {
    public final WebFlowGamesService webFlowGamesService;

    public WebFlowRepository(WebFlowGamesService webFlowGamesService2) {
        Intrinsics.checkNotNullParameter(webFlowGamesService2, "webFlowGamesService");
        this.webFlowGamesService = webFlowGamesService2;
    }

    public final void getSessionToken(WebFlowServiceImpl webFlowServiceImpl, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(webFlowServiceImpl, "view");
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        this.webFlowGamesService.callApi(webFlowServiceImpl, jSONObject);
    }
}

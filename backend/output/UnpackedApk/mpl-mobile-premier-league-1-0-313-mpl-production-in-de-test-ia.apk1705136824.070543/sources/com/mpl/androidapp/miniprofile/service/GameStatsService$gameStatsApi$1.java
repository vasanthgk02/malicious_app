package com.mpl.androidapp.miniprofile.service;

import com.google.gson.Gson;
import com.mpl.network.modules.listeners.IResponseListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.paho.android.service.MqttServiceConstants;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"com/mpl/androidapp/miniprofile/service/GameStatsService$gameStatsApi$1", "Lcom/mpl/network/modules/listeners/IResponseListener;", "", "onResponseFail", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onResponseSuccess", "serverResponse", "progressResponse", "bytesRead", "", "contentLength", "done", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameStatsService.kt */
public final class GameStatsService$gameStatsApi$1 extends IResponseListener<String> {
    public final /* synthetic */ GameStatsServiceImpl $callback;
    public final /* synthetic */ Gson $gson;
    public final /* synthetic */ GameStatsService this$0;

    public GameStatsService$gameStatsApi$1(GameStatsService gameStatsService, Gson gson, GameStatsServiceImpl gameStatsServiceImpl) {
        this.this$0 = gameStatsService;
        this.$gson = gson;
        this.$callback = gameStatsServiceImpl;
    }

    public void onResponseFail(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, MqttServiceConstants.TRACE_EXCEPTION);
        this.this$0.logException(exc, this.$callback);
    }

    public void progressResponse(long j, long j2, boolean z) {
    }

    public void onResponseSuccess(String str) {
        this.this$0.handleCallback(str, this.$gson, this.$callback);
    }
}

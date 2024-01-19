package com.mpl.androidapp.appsanity;

import android.net.TrafficStats;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.mpl.androidapp.Featurestag;
import com.mpl.androidapp.analytics.ExternalAnalytics;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.network.modules.utils.MException;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\u000f\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J \u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/mpl/androidapp/appsanity/APIHealthCheckerImpl;", "Lcom/mpl/androidapp/appsanity/APIHealthChecker;", "()V", "TAG", "", "getNetworkSpeed", "", "appSanityModel", "Lcom/mpl/androidapp/appsanity/APPSanityModel;", "initAppSanity", "url", "isAPIResponseTimedOut", "", "processAPIHealthStatusFromFailedResponse", "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "processAPIHealthStatusFromSuccessFullResponse", "response", "processPositiveErrorResponse", "sendAPIHealthStatusToKafka", "code", "", "error", "sendAPITimedOutStatus", "setEndAppSanityParams", "setStartAppSanityParams", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: APIHealthCheckerImpl.kt */
public final class APIHealthCheckerImpl implements APIHealthChecker {
    public final String TAG = Featurestag.APP_SANITY;

    private final long getNetworkSpeed(APPSanityModel aPPSanityModel) {
        long j = 0;
        try {
            long endTime = aPPSanityModel.getEndTime() - aPPSanityModel.getStartTime();
            if (endTime == 0) {
                return 0;
            }
            j = ((aPPSanityModel.getCurrTotalRxByte() - aPPSanityModel.getPrevTotalRxByte()) * ((long) 1000)) / (endTime * ((long) 1024));
            MLogger.i(this.TAG, Intrinsics.stringPlus("network speed :", Long.valueOf(j)));
            return j;
        } catch (Exception e2) {
            String str = this.TAG;
            MLogger.i(str, "getNetworkSpeed: " + e2 + ".message");
        }
    }

    private final boolean isAPIResponseTimedOut(APPSanityModel aPPSanityModel) {
        return aPPSanityModel.getEndTime() - aPPSanityModel.getStartTime() >= RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS;
    }

    private final void processPositiveErrorResponse(APPSanityModel aPPSanityModel, String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("status");
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("code", 0);
                if (!(200 <= optInt && optInt < 300)) {
                    String optString = optJSONObject.optString("message", "");
                    Intrinsics.checkNotNullExpressionValue(optString, "error");
                    sendAPIHealthStatusToKafka(aPPSanityModel, optInt, optString);
                }
            }
        } catch (Exception e2) {
            String str2 = this.TAG;
            MLogger.i(str2, "processPositiveErrorResponse : " + e2 + ".message");
        }
    }

    private final void sendAPIHealthStatusToKafka(APPSanityModel aPPSanityModel, int i, String str) {
        try {
            String url = aPPSanityModel.getUrl();
            String str2 = "";
            if (url != null) {
                if (!CharsKt__CharKt.equals(url, str2, true)) {
                    String mainUrl = MBuildConfigUtils.getMainUrl();
                    Intrinsics.checkNotNullExpressionValue(mainUrl, "getMainUrl()");
                    str2 = CharsKt__CharKt.replace$default(url, mainUrl, str2, false, 4);
                }
            }
            long networkSpeed = getNetworkSpeed(aPPSanityModel);
            String str3 = this.TAG;
            MLogger.i(str3, "apiEnd : " + str2 + " network  " + networkSpeed + ", error code " + i + ", errDesc " + str);
            HashMap hashMap = new HashMap(4);
            hashMap.putAll(CleverTapAnalyticsUtils.commonPropertiesForEvents(false));
            ExternalAnalytics.INSTANCE.sendKafkaEvent(AppSanityConstant.EVENT_API_ERROR, hashMap);
        } catch (Exception e2) {
            MLogger.i(this.TAG, e2.getMessage());
        }
    }

    private final void sendAPITimedOutStatus(APPSanityModel aPPSanityModel) {
        sendAPIHealthStatusToKafka(aPPSanityModel, 0, AppSanityConstant.ERROR_TIME_OUT);
    }

    public APPSanityModel initAppSanity(String str) {
        APPSanityModel aPPSanityModel = new APPSanityModel(str);
        setStartAppSanityParams(aPPSanityModel);
        return aPPSanityModel;
    }

    public void processAPIHealthStatusFromFailedResponse(APPSanityModel aPPSanityModel, Exception exc) {
        Intrinsics.checkNotNullParameter(aPPSanityModel, "appSanityModel");
        if (exc != null) {
            int i = exc instanceof MException ? ((MException) exc).errorCode : -1;
            String message = exc.getMessage();
            if (message == null) {
                message = AppSanityConstant.ERROR_MESSAGE_NOT_AVAILABLE;
            }
            sendAPIHealthStatusToKafka(aPPSanityModel, i, message);
        }
    }

    public void processAPIHealthStatusFromSuccessFullResponse(APPSanityModel aPPSanityModel, String str) {
        Intrinsics.checkNotNullParameter(aPPSanityModel, "appSanityModel");
        if (str != null) {
            try {
                processPositiveErrorResponse(aPPSanityModel, str);
                if (isAPIResponseTimedOut(aPPSanityModel)) {
                    sendAPITimedOutStatus(aPPSanityModel);
                }
            } catch (Exception e2) {
                MLogger.e(this.TAG, e2.getMessage());
            }
        }
    }

    public void setEndAppSanityParams(APPSanityModel aPPSanityModel) {
        Intrinsics.checkNotNullParameter(aPPSanityModel, "appSanityModel");
        aPPSanityModel.setEndTime(System.currentTimeMillis());
        aPPSanityModel.setCurrTotalRxByte(TrafficStats.getTotalRxBytes());
    }

    public void setStartAppSanityParams(APPSanityModel aPPSanityModel) {
        Intrinsics.checkNotNullParameter(aPPSanityModel, "appSanityModel");
        aPPSanityModel.setStartTime(System.currentTimeMillis());
        aPPSanityModel.setPrevTotalRxByte(TrafficStats.getTotalRxBytes());
    }
}

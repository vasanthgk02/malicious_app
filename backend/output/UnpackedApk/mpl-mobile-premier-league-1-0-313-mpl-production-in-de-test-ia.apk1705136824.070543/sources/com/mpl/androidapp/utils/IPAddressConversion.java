package com.mpl.androidapp.utils;

import android.text.TextUtils;
import com.mpl.androidapp.appsanity.APIHealthCheckerImpl;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.request.MOKHttpPostRequest;
import com.mpl.network.modules.request.MOKHttpPostRequest.Builder;
import com.mpl.network.modules.request.RequestPriority;
import com.razorpay.AnalyticsConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/utils/IPAddressConversion;", "", "()V", "TAG", "", "country", "getCountry", "()Ljava/lang/String;", "setCountry", "(Ljava/lang/String;)V", "state", "getState", "setState", "constructJSONBody", "getIPLocation", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IPAddressConversion.kt */
public final class IPAddressConversion {
    public static final IPAddressConversion INSTANCE = new IPAddressConversion();
    public static final String TAG = "IPAddressConversion";
    public static String country = AnalyticsConstants.NOT_AVAILABLE;
    public static String state = AnalyticsConstants.NOT_AVAILABLE;

    private final String constructJSONBody() {
        try {
            JSONObject jSONObject = new JSONObject();
            String ipAddress = CommonUtils.getIpAddress();
            if (!TextUtils.isEmpty(ipAddress)) {
                jSONObject.put(Constant.IP_ADDRESS, ipAddress);
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
            return jSONObject2;
        } catch (JSONException e2) {
            MLogger.e("IPAddressConversion", "constructJSONBody() ", e2);
            return "";
        } catch (Exception e3) {
            MLogger.e("IPAddressConversion", "constructJSONBody() ", e3);
            return "";
        }
    }

    public final String getCountry() {
        return country;
    }

    public final void getIPLocation() {
        MLogger.d("IPAddressConversion", "getIPLocation(): ");
        List<MHeader> commonHeaders = CommonUtils.getCommonHeaders();
        commonHeaders.add(new MHeader("Authorization", Intrinsics.stringPlus("Bearer ", MSharedPreferencesUtils.getAccessUserToken())));
        String stringPlus = Intrinsics.stringPlus(Constant.SET_BASE_URL, "/ipAddress/");
        APIHealthCheckerImpl aPIHealthCheckerImpl = new APIHealthCheckerImpl();
        MOKHttpPostRequest build = new Builder().setRequestPriority(RequestPriority.HIGH).setUrl(stringPlus).setConnectTimeout(10000).setReadTimeout(10000).setWriteTimeout(10000).setPingInterval(10000).setHeaders(commonHeaders).setRetryOnConnectionFailure(true).setPostJsonObject(constructJSONBody()).setResponseListener(new IPAddressConversion$getIPLocation$mRequest$1(aPIHealthCheckerImpl, aPIHealthCheckerImpl.initAppSanity(stringPlus))).build();
        Intrinsics.checkNotNullExpressionValue(build, "val apiHealthChecker: AP…  })\n            .build()");
        MClient.executeAsync(build);
    }

    public final String getState() {
        return state;
    }

    public final void setCountry(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        country = str;
    }

    public final void setState(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        state = str;
    }
}

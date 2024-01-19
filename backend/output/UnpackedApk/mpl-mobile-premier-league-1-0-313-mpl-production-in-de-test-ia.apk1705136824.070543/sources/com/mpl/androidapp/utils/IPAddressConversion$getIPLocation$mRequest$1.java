package com.mpl.androidapp.utils;

import com.mpl.androidapp.appsanity.APIHealthChecker;
import com.mpl.androidapp.appsanity.APPSanityModel;
import com.mpl.androidapp.miniprofile.extensions.StringExtKt;
import com.mpl.androidapp.react.modules.NetworkModule;
import com.mpl.androidapp.updater.util.UpdaterConstant;
import com.mpl.network.modules.listeners.IResponseListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"com/mpl/androidapp/utils/IPAddressConversion$getIPLocation$mRequest$1", "Lcom/mpl/network/modules/listeners/IResponseListener;", "Lorg/json/JSONObject;", "onResponseFail", "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onResponseSuccess", "json", "progressResponse", "p0", "", "p1", "p2", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IPAddressConversion.kt */
public final class IPAddressConversion$getIPLocation$mRequest$1 extends IResponseListener<JSONObject> {
    public final /* synthetic */ APIHealthChecker $apiHealthChecker;
    public final /* synthetic */ APPSanityModel $appSanityModel;

    public IPAddressConversion$getIPLocation$mRequest$1(APIHealthChecker aPIHealthChecker, APPSanityModel aPPSanityModel) {
        this.$apiHealthChecker = aPIHealthChecker;
        this.$appSanityModel = aPPSanityModel;
    }

    public void onResponseFail(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "ex");
        MLogger.d(IResponseListener.TAG, UpdaterConstant.FAILURE);
        APIHealthChecker aPIHealthChecker = this.$apiHealthChecker;
        if (aPIHealthChecker != null) {
            aPIHealthChecker.setEndAppSanityParams(this.$appSanityModel);
        }
    }

    public void progressResponse(long j, long j2, boolean z) {
        MLogger.d(IResponseListener.TAG, "progressResponse() ");
    }

    public void onResponseSuccess(JSONObject jSONObject) {
        JSONObject jSONObject2;
        APIHealthChecker aPIHealthChecker = this.$apiHealthChecker;
        if (aPIHealthChecker != null) {
            aPIHealthChecker.setEndAppSanityParams(this.$appSanityModel);
        }
        if (jSONObject == null) {
            jSONObject2 = null;
        } else {
            jSONObject2 = jSONObject.optJSONObject("status");
        }
        if (jSONObject2 == null || jSONObject.optJSONObject("payload") == null) {
            MLogger.d(IResponseListener.TAG, UpdaterConstant.FAILURE);
        } else if (jSONObject.optJSONObject("status").optInt("code") == 200) {
            JSONObject optJSONObject = jSONObject.optJSONObject("payload");
            if (optJSONObject != null && optJSONObject.has("country")) {
                IPAddressConversion iPAddressConversion = IPAddressConversion.INSTANCE;
                String string = optJSONObject.getString("country");
                Intrinsics.checkNotNullExpressionValue(string, "payload.getString(\"country\")");
                iPAddressConversion.setCountry(string);
                MLogger.d("IPAddressConversion", Intrinsics.stringPlus("country == ", IPAddressConversion.INSTANCE.getCountry()));
                if (StringExtKt.equalsIgnoreCase(IPAddressConversion.INSTANCE.getCountry(), "null")) {
                    IPAddressConversion.INSTANCE.setCountry("Not Detected");
                }
            }
            if (optJSONObject != null && optJSONObject.has("state")) {
                IPAddressConversion iPAddressConversion2 = IPAddressConversion.INSTANCE;
                String string2 = optJSONObject.getString("state");
                Intrinsics.checkNotNullExpressionValue(string2, "payload.getString(\"state\")");
                iPAddressConversion2.setState(string2);
                MLogger.d("IPAddressConversion", Intrinsics.stringPlus("state == ", IPAddressConversion.INSTANCE.getState()));
                if (StringExtKt.equalsIgnoreCase(IPAddressConversion.INSTANCE.getState(), "null")) {
                    IPAddressConversion.INSTANCE.setState("Not Detected");
                }
            }
        } else {
            MLogger.d(IResponseListener.TAG, UpdaterConstant.FAILURE, jSONObject);
        }
        if (jSONObject != null) {
            NetworkModule.processResponse(null, jSONObject.toString());
            APIHealthChecker aPIHealthChecker2 = this.$apiHealthChecker;
            if (aPIHealthChecker2 != null) {
                aPIHealthChecker2.processAPIHealthStatusFromSuccessFullResponse(this.$appSanityModel, jSONObject.toString());
            }
        }
    }
}

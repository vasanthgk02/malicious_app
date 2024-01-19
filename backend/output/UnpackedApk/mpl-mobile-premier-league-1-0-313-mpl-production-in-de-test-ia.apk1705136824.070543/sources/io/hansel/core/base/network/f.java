package io.hansel.core.base.network;

import android.content.Context;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.network.request.HSLServerRequest;
import io.hansel.hanselsdk.HanselRequestType;
import io.hansel.hanselsdk.HanselSyncStateListenerInternal;
import java.io.InputStream;
import sfs2x.client.requests.CreateRoomRequest;

public class f extends StatusCodeResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    public final IMessageBroker f5107a;

    /* renamed from: b  reason: collision with root package name */
    public final HanselSyncStateListenerInternal f5108b;

    public f(Context context, IMessageBroker iMessageBroker, HanselSyncStateListenerInternal hanselSyncStateListenerInternal) {
        super(context);
        this.f5107a = iMessageBroker;
        this.f5108b = hanselSyncStateListenerInternal;
    }

    private void a(Context context, CoreJSONObject coreJSONObject) {
        String str = "sel";
        int i = 10;
        String str2 = "";
        if (coreJSONObject != null) {
            str = coreJSONObject.optString("type", str);
            i = coreJSONObject.optInt("t", 10);
            str2 = coreJSONObject.optString("key", str2);
        }
        HSLInternalUtils.setStringInSharedPreferences(context, "ha_type", str);
        HSLInternalUtils.setIntInSharedPreferences(context, "ha_time", i);
        HSLInternalUtils.setStringInSharedPreferences(context, "ha_key", str2);
    }

    private void a(CoreJSONObject coreJSONObject) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        String str = null;
        if (coreJSONObject != null) {
            str = coreJSONObject.optString("get_data");
            obj4 = coreJSONObject.optString("add_events");
            obj3 = coreJSONObject.optString("localization");
            obj2 = coreJSONObject.optString("dil_data");
            obj = coreJSONObject.optString("h_a");
        } else {
            obj = null;
            obj4 = null;
            obj3 = null;
            obj2 = null;
        }
        this.f5107a.publishEvent(EventsConstants.AEP_GET_DATA.name(), str);
        this.f5107a.publishEvent(EventsConstants.AEP_ADD_EVENTS.name(), obj4);
        this.f5107a.publishEvent(EventsConstants.AEP_LOCALIZATION.name(), obj3);
        this.f5107a.publishEvent(EventsConstants.AEP_DIL.name(), obj2);
        this.f5107a.publishEvent(EventsConstants.AEP_TRACK_EVENTS.name(), obj);
    }

    private void b(Context context, CoreJSONObject coreJSONObject) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = false;
        if (coreJSONObject != null) {
            boolean optBoolean = coreJSONObject.optBoolean("ujm", false);
            z4 = coreJSONObject.optBoolean("loc", false);
            z3 = coreJSONObject.optBoolean("dil", false);
            z2 = coreJSONObject.optBoolean("ha", false);
            z = coreJSONObject.optBoolean("lis", false);
            z5 = optBoolean;
        } else {
            z = false;
            z4 = false;
            z3 = false;
            z2 = false;
        }
        HSLInternalUtils.setBooleanInSharedPreferences(context, "is_ujm_enabled", z5);
        HSLInternalUtils.setBooleanInSharedPreferences(context, "is_loc_enabled", z4);
        HSLInternalUtils.setBooleanInSharedPreferences(context, "is_dil_enabled", z3);
        HSLInternalUtils.setBooleanInSharedPreferences(context, "is_analytics_enabled", z2);
        HSLInternalUtils.setBooleanInSharedPreferences(context, "is_lis_enabled", z);
    }

    private void c(Context context, CoreJSONObject coreJSONObject) {
        HSLInternalUtils.setStringInSharedPreferences(context, "lis_type_sp_key", coreJSONObject != null ? coreJSONObject.optString("type") : "prompt");
    }

    public long getTTL() {
        return HSLInternalUtils.getLongFromSharedPreferences(this.context, HSLInternalUtils.KEY_INITSDK_REQUEST_SILENCE_INTERVAL);
    }

    public void onError(Throwable th) {
        HSLLogger.printStackTraceMin(th, "Init Response Sync Unsuccessful");
        this.f5108b.onHanselSynced(HanselRequestType.init, false);
    }

    public void onParseResponse(HSLServerRequest hSLServerRequest, CoreJSONObject coreJSONObject) {
        CoreJSONObject requestParams = hSLServerRequest.getRequestParams();
        CoreJSONArray optJSONArray = requestParams != null ? requestParams.optJSONArray("ua") : null;
        CoreJSONArray optJSONArray2 = coreJSONObject.optJSONArray("blocked_patches");
        long optLong = (coreJSONObject.optLong("ttl") * 60000) + System.currentTimeMillis();
        HSLInternalUtils.setLongInSharedPreferences(this.context, "hansel_request_failure_ttl", coreJSONObject.optLong("failure_ttl", 15));
        HSLInternalUtils.setLongInSharedPreferences(this.context, HSLInternalUtils.KEY_INITSDK_REQUEST_SILENCE_INTERVAL, optLong);
        HSLInternalUtils.clearKey(this.context, HSLInternalUtils.KEY_INITSDK_IS_PUSH_INITIATED);
        String optString = coreJSONObject.optString(CreateRoomRequest.KEY_ROOMVARS);
        boolean z = optString.isEmpty() || !optString.equals(HSLInternalUtils.getStringFromSharedPreferences(this.context, HSLInternalUtils.KEY_PATCH_LIST_VERSION));
        b(this.context, coreJSONObject.optJSONObject("sub"));
        a(coreJSONObject.optJSONObject("api_endpoints"));
        a(this.context, coreJSONObject.optJSONObject("h_a"));
        c(this.context, coreJSONObject.optJSONObject("lis"));
        this.f5107a.publishEvent(EventsConstants.SAVE_VENDOR_LIMITS.name(), coreJSONObject.optJSONArray("v"));
        CoreJSONArray optJSONArray3 = coreJSONObject.optJSONArray("sel");
        if (z) {
            HSLLogger.i("ini");
            HSLLogger.i("hsl-tg-" + (HSLInternalUtils.isInTestGroup(this.context) ? 1 : 0));
            HSLInternalUtils.setStringInSharedPreferences(this.context, HSLInternalUtils.KEY_PATCH_LIST_VERSION, optString);
            CoreJSONObject coreJSONObject2 = new CoreJSONObject();
            coreJSONObject2.put((String) "patch_def_list", (Object) coreJSONObject.optJSONArray("patch_def_list"));
            coreJSONObject2.put((String) "blocked_patches", (Object) optJSONArray2);
            coreJSONObject2.put((String) "serverEvaluatedList", (Object) optJSONArray3);
            coreJSONObject2.put((String) "originalFiltersArray", (Object) optJSONArray);
            this.f5107a.publishEvent(EventsConstants.CODE_PATCH_NEW_PRIMARY.name(), coreJSONObject2);
            CoreJSONObject coreJSONObject3 = new CoreJSONObject();
            coreJSONObject3.put((String) "visualizer_patch_def_list", (Object) coreJSONObject.optJSONArray("visualizer_patch_def_list"));
            coreJSONObject3.put((String) "blocked_patches", (Object) optJSONArray2);
            this.f5107a.publishEvent(EventsConstants.VISUALISER_PATCH_NEW_PRIMARY.name(), coreJSONObject3);
        }
        ((a) hSLServerRequest).a();
        HSLLogger.i("Init Response Sync Successful");
        this.f5108b.onHanselSynced(HanselRequestType.init, true);
    }

    public void parseResponse(HSLServerRequest hSLServerRequest, InputStream inputStream, int i) {
    }

    public void saveTTL(long j) {
        HSLInternalUtils.setLongInSharedPreferences(this.context, HSLInternalUtils.KEY_INITSDK_REQUEST_SILENCE_INTERVAL, j);
    }
}

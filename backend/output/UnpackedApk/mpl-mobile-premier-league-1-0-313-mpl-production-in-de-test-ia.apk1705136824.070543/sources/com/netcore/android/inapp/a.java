package com.netcore.android.inapp;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.SMTEventParamKeys;
import com.netcore.android.Smartech;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.network.SMTEnumHttpMethodType;
import com.netcore.android.network.SMTNetworkManager;
import com.netcore.android.network.SMTRequestQueue;
import com.netcore.android.network.SMTResponseListener;
import com.netcore.android.network.models.SMTInAppResponse;
import com.netcore.android.network.models.SMTRequest.Builder;
import com.netcore.android.network.models.SMTRequest.SMTApiTypeID;
import com.netcore.android.network.models.SMTResponse;
import com.netcore.android.preference.SMTGUIDPreferenceHelper;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.netcore.android.preference.SMTPreferenceHelper.Companion;
import com.netcore.android.smartechbase.communication.HanselInterface;
import com.paynimo.android.payment.util.Constant;
import com.userexperior.models.recording.enums.UeCustomType;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SMTInAppApiService.kt */
public final class a implements SMTResponseListener {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f1174c;

    /* renamed from: d  reason: collision with root package name */
    public static final C0008a f1175d = new C0008a(null);

    /* renamed from: a  reason: collision with root package name */
    public final String f1176a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<Context> f1177b;

    /* renamed from: com.netcore.android.inapp.a$a  reason: collision with other inner class name */
    /* compiled from: SMTInAppApiService.kt */
    public static final class C0008a {
        public C0008a() {
        }

        private final a a(WeakReference<Context> weakReference) {
            return new a(weakReference, null);
        }

        public final a b(WeakReference<Context> weakReference) {
            a aVar;
            Intrinsics.checkNotNullParameter(weakReference, "context");
            a a2 = a.f1174c;
            if (a2 != null) {
                return a2;
            }
            synchronized (a.class) {
                try {
                    a a3 = a.f1174c;
                    if (a3 != null) {
                        aVar = a3;
                    } else {
                        aVar = a.f1175d.a(weakReference);
                        a.f1174c = aVar;
                    }
                }
            }
            return aVar;
        }

        public /* synthetic */ C0008a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(WeakReference<Context> weakReference) {
        this.f1177b = weakReference;
        this.f1176a = a.class.getSimpleName();
    }

    private final JSONArray b() {
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        try {
            Context context = (Context) this.f1177b.get();
            if (context != null) {
                Companion companion = SMTPreferenceHelper.Companion;
                Intrinsics.checkNotNullExpressionValue(context, "it");
                hashMap.put("appid", companion.getAppPreferenceInstance(context, null).getString("app_id"));
                String string = companion.getAppPreferenceInstance(context, null).getString(SMTPreferenceConstants.SMT_USER_IDENTITY);
                if (string.length() > 0) {
                    hashMap.put("identity", string);
                } else {
                    hashMap.put("guid", SMTGUIDPreferenceHelper.Companion.getAppPreferenceInstance(context, null).getString(SMTPreferenceConstants.SMT_GUID, ""));
                }
            }
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1176a;
            GeneratedOutlineSupport.outline96(str, UeCustomType.TAG, e2, sMTLogger, str);
        }
        JSONArray put = jSONArray.put(new JSONObject(hashMap));
        Intrinsics.checkNotNullExpressionValue(put, "jsonArray.put(JSONObject(hashMap))");
        return put;
    }

    private final String c() {
        return "user_attr";
    }

    private final String d() {
        Context context = (Context) this.f1177b.get();
        if (context == null) {
            return "";
        }
        Companion companion = SMTPreferenceHelper.Companion;
        Intrinsics.checkNotNullExpressionValue(context, "it");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "it.applicationContext");
        return companion.getAppPreferenceInstance(applicationContext, null).getString(SMTPreferenceConstants.SMT_BASE_URL_INAPP_LIST_SEG);
    }

    public final void e() {
        SMTNetworkManager.Companion.getInstance(SMTRequestQueue.Companion.getInstance()).processRequest(new Builder().setHttpMethod(SMTEnumHttpMethodType.GET).setBaseUrl(d()).setEndPoint(c()).setParams(b()).setApiId(SMTApiTypeID.LIST_SEGMENT).setResponseListener(this).build());
    }

    public void onResponseFailure(SMTResponse sMTResponse) {
        Intrinsics.checkNotNullParameter(sMTResponse, Constant.TAG_RESPONSE);
        Smartech.Companion.getInstance(this.f1177b).setInAppRuleListStatus$smartech_release(true);
    }

    public void onResponseSuccess(SMTResponse sMTResponse) {
        Intrinsics.checkNotNullParameter(sMTResponse, Constant.TAG_RESPONSE);
        a(sMTResponse);
    }

    public /* synthetic */ a(WeakReference weakReference, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference);
    }

    private final void a(SMTResponse sMTResponse) {
        if (sMTResponse != null) {
            try {
                SMTInAppResponse sMTInAppResponse = (SMTInAppResponse) sMTResponse;
                Smartech.Companion companion = Smartech.Companion;
                Smartech instance = companion.getInstance(this.f1177b);
                if (sMTInAppResponse.getInAppListSegmentData() != null) {
                    Context context = (Context) this.f1177b.get();
                    if (context != null) {
                        Companion companion2 = SMTPreferenceHelper.Companion;
                        Intrinsics.checkNotNullExpressionValue(context, "it");
                        companion2.getAppPreferenceInstance(context, null).setString(SMTPreferenceConstants.SMT_LIST_SEGMENT_DATA, String.valueOf(sMTInAppResponse.getInAppListSegmentData()));
                        com.netcore.android.inapp.c.a aVar = c.g;
                        List<String> a2 = aVar.b().a(context, (String) "listIds");
                        List<String> a3 = aVar.b().a(context, (String) "segIds");
                        HanselInterface hanselInstance$smartech_release = companion.getInstance(this.f1177b).getHanselInstance$smartech_release();
                        if (hanselInstance$smartech_release != null) {
                            hanselInstance$smartech_release.setListAndSegmentsForUser(a2, a3);
                        }
                        List<Integer> systemInAppEventList$smartech_release = instance.getSystemInAppEventList$smartech_release();
                        SMTLogger sMTLogger = SMTLogger.INSTANCE;
                        String str = this.f1176a;
                        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
                        sMTLogger.internal(str, "event list size : " + systemInAppEventList$smartech_release.size() + ' ');
                        Intrinsics.checkNotNullParameter(systemInAppEventList$smartech_release, "<this>");
                        ArraysKt___ArraysJvmKt.toList(ArraysKt___ArraysJvmKt.toMutableSet(systemInAppEventList$smartech_release));
                        for (Integer intValue : systemInAppEventList$smartech_release) {
                            int intValue2 = intValue.intValue();
                            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                            String str2 = this.f1176a;
                            Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
                            sMTLogger2.internal(str2, "event id : " + intValue2 + ' ');
                            HashMap hashMap = new HashMap();
                            hashMap.put(SMTEventParamKeys.SMT_EVENT_ID, Integer.valueOf(intValue2));
                            c.g.b().a(hashMap);
                        }
                        instance.clearSystemEventList$smartech_release();
                    }
                }
                instance.setInAppRuleListStatus$smartech_release(true);
            } catch (Exception e2) {
                SMTLogger sMTLogger3 = SMTLogger.INSTANCE;
                String str3 = this.f1176a;
                GeneratedOutlineSupport.outline96(str3, UeCustomType.TAG, e2, sMTLogger3, str3);
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type com.netcore.android.network.models.SMTInAppResponse");
        }
    }
}

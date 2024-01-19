package com.netcore.android.event;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.netcore.android.e.b;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.network.SMTEnumHttpMethodType;
import com.netcore.android.network.models.SMTRequest;
import com.netcore.android.network.models.SMTRequest.Builder;
import com.netcore.android.network.models.SMTRequest.SMTApiTypeID;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.userexperior.models.recording.enums.UeCustomType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SMTEventsBatchProcessor.kt */
public final class f {

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f1084d;

    /* renamed from: e  reason: collision with root package name */
    public static SMTPreferenceHelper f1085e;

    /* renamed from: f  reason: collision with root package name */
    public static HandlerThread f1086f;
    public static final a g = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public final String f1087a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f1088b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<Context> f1089c;

    /* compiled from: SMTEventsBatchProcessor.kt */
    public static final class a {
        public a() {
        }

        private final f a(Context context) {
            f.f1085e = SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null);
            f.f1086f = new HandlerThread("EventBatchProcessor_Thread");
            HandlerThread b2 = f.f1086f;
            if (b2 != null) {
                b2.start();
                HandlerThread b3 = f.f1086f;
                if (b3 != null) {
                    f.a(new Handler(b3.getLooper()));
                    return new f(new WeakReference(context), null);
                }
                Intrinsics.throwUninitializedPropertyAccessException("mHandlerThread");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mHandlerThread");
            throw null;
        }

        public final f b(Context context) {
            f fVar;
            Intrinsics.checkNotNullParameter(context, "context");
            f a2 = f.f1084d;
            if (a2 != null) {
                return a2;
            }
            synchronized (f.class) {
                f a3 = f.f1084d;
                if (a3 != null) {
                    fVar = a3;
                } else {
                    fVar = f.g.a(context);
                    f.f1084d = fVar;
                }
            }
            return fVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f(WeakReference<Context> weakReference) {
        this.f1089c = weakReference;
        this.f1087a = f.class.getSimpleName();
        this.f1088b = new Object();
    }

    public static final /* synthetic */ void a(Handler handler) {
    }

    private final String c() {
        String str;
        Context context = (Context) this.f1089c.get();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "it");
            str = new SMTEventCommonDataDump(context).getURLParameters();
        } else {
            str = "";
        }
        return GeneratedOutlineSupport.outline50("app/v1/track_appact?", str);
    }

    public final synchronized b b(WeakReference<Context> weakReference, g gVar) {
        b bVar;
        Intrinsics.checkNotNullParameter(weakReference, "context");
        Intrinsics.checkNotNullParameter(gVar, "state");
        synchronized (this.f1088b) {
            SMTPreferenceHelper sMTPreferenceHelper = f1085e;
            if (sMTPreferenceHelper != null) {
                sMTPreferenceHelper.getBoolean(SMTPreferenceConstants.IS_INIT_API_CALL_SUCCESSFUL, false);
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String str = this.f1087a;
                Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
                sMTLogger.v(str, "Creating batch request");
                JSONArray jSONArray = new JSONArray();
                ArrayList arrayList = new ArrayList();
                Context context = (Context) weakReference.get();
                if (context != null) {
                    SMTPreferenceHelper sMTPreferenceHelper2 = f1085e;
                    if (sMTPreferenceHelper2 != null) {
                        HashMap<String, String> a2 = b.f1030c.b(weakReference).a(sMTPreferenceHelper2.getInt(SMTPreferenceConstants.BATCH_SIZE), 0);
                        if (a2.size() > 0) {
                            Intrinsics.checkNotNullExpressionValue(context, "it");
                            jSONArray.put(new JSONObject(new SMTEventCommonDataDump(context).getPayloadParams()));
                            try {
                                for (Entry next : a2.entrySet()) {
                                    jSONArray.put(new JSONObject((String) next.getValue()));
                                    arrayList.add(Integer.valueOf(Integer.parseInt((String) next.getKey())));
                                }
                            } catch (Exception e2) {
                                SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                                String str2 = this.f1087a;
                                Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
                                sMTLogger2.e(str2, "error while creating batch: " + e2);
                            }
                            b b2 = b.f1030c.b(weakReference);
                            Object[] array = arrayList.toArray(new Integer[0]);
                            if (array != null) {
                                b2.a((Integer[]) array, "syncStatus", 2);
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                        throw null;
                    }
                }
                SMTLogger sMTLogger3 = SMTLogger.INSTANCE;
                String str3 = this.f1087a;
                Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
                sMTLogger3.i(str3, "Batch Details Size: " + jSONArray.length() + " and Batch details: " + jSONArray);
                Object[] array2 = arrayList.toArray(new Integer[0]);
                if (array2 != null) {
                    bVar = new b(jSONArray, (Integer[]) array2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                throw null;
            }
        }
        return bVar;
    }

    public /* synthetic */ f(WeakReference weakReference, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference);
    }

    public final SMTRequest a(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        Builder params = new Builder().setHttpMethod(SMTEnumHttpMethodType.POST).setEndPoint(c()).setApiId(SMTApiTypeID.BATCH_PROCESSING_API).setParams(jSONArray);
        SMTPreferenceHelper sMTPreferenceHelper = f1085e;
        if (sMTPreferenceHelper != null) {
            return params.setBaseUrl(sMTPreferenceHelper.getString(SMTPreferenceConstants.SMT_BASE_URL_TRACKAPPACT)).build();
        }
        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        throw null;
    }

    public final boolean a(WeakReference<Context> weakReference, g gVar) {
        Intrinsics.checkNotNullParameter(weakReference, "context");
        Intrinsics.checkNotNullParameter(gVar, "state");
        SMTPreferenceHelper sMTPreferenceHelper = f1085e;
        if (sMTPreferenceHelper != null) {
            return b.f1030c.b(weakReference).b(sMTPreferenceHelper.getInt(SMTPreferenceConstants.BATCH_SIZE));
        }
        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        throw null;
    }
}

package co.hyperverge.hypersnapsdk.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import co.hyperverge.hypersnapsdk.HyperSnapSDK;
import co.hyperverge.hypersnapsdk.a.b;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.c.o;
import co.hyperverge.hypersnapsdk.c.q;
import co.hyperverge.hypersnapsdk.f.i;
import co.hyperverge.hypersnapsdk.model.LivenessResponse;
import co.hyperverge.hypersnapsdk.objects.HVDocConfig;
import co.hyperverge.hypersnapsdk.objects.HVError;
import co.hyperverge.hypersnapsdk.objects.HVFaceConfig;
import co.hyperverge.hypersnapsdk.objects.HVResponse;
import co.hyperverge.hypersnapsdk.objects.HyperKYCConfigs;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.google.gson.Gson;
import com.midtrans.sdk.gopaycheckout.analytics.AnalyticsEvent;
import com.netcore.android.SMTEventParamKeys;
import com.razorpay.AnalyticsConstants;
import com.rudderstack.android.sdk.core.RudderClient;
import com.rudderstack.android.sdk.core.RudderConfig.Builder;
import com.rudderstack.android.sdk.core.RudderProperty;
import com.rudderstack.android.sdk.core.RudderTraits;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: HVRudderstackManager */
public class a implements b {

    /* renamed from: b  reason: collision with root package name */
    public static a f2953b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f2954c;

    /* renamed from: d  reason: collision with root package name */
    public final RudderClient f2955d;

    /* renamed from: e  reason: collision with root package name */
    public HVFaceConfig f2956e;

    /* renamed from: f  reason: collision with root package name */
    public HVDocConfig f2957f;

    public a(Context context) {
        this.f2954c = context;
        this.f2955d = RudderClient.getInstance(context, i.d(context) ? "26VyOHNZNHTMaXcvQKbAvPRfFy8" : "1zROhc3quLhmAyHhEtkZgjGkhTC", new Builder().withDataPlaneUrl("https://hypervergekrba.dataplane.rudderstack.com").withTrackLifecycleEvents(false).withRecordScreenViews(false).build());
    }

    public void B() {
    }

    public void C() {
        b("Document - Retake Screen Launched", "DocEvent", null);
    }

    public void D() {
        b("Document - Instructions Launched", "DocEvent", null);
    }

    public final Map<String, Object> E() {
        HashMap hashMap = new HashMap();
        try {
            String i = o.i();
            if (HyperSnapSDK.getInstance() != null) {
                String name = HyperSnapSDK.f2946b.getHyperSnapRegion().name();
                if (HyperSnapSDK.getInstance() != null) {
                    String appId = HyperSnapSDK.f2946b.getAppId();
                    String a2 = i.a();
                    hashMap.put("transactionId", i);
                    hashMap.put("region", name);
                    hashMap.put(SMTEventParamKeys.SMT_APP_ID, appId);
                    hashMap.put("sdkVersion", "3.6.38");
                    hashMap.put("abiArch", a2);
                    if (HyperSnapSDK.getInstance() != null) {
                        HyperKYCConfigs hyperKYCConfigs = HyperSnapSDK.f2946b.getHyperKYCConfigs();
                        if (hyperKYCConfigs != null) {
                            HashMap<String, String> hyperKYCValueMap = hyperKYCConfigs.getHyperKYCValueMap();
                            for (String next : hyperKYCValueMap.values()) {
                                hashMap.put(next, hyperKYCValueMap.get(next));
                            }
                        }
                        if (HyperSnapSDK.getInstance() != null) {
                            hashMap.put("hyperSnapSDKConfig", HyperSnapSDK.f2946b);
                            return hashMap;
                        }
                        throw null;
                    }
                    throw null;
                }
                throw null;
            }
            throw null;
        } catch (Exception e2) {
            i.a((Throwable) e2);
            n.m().b(this.f2954c).a(e2);
        }
    }

    public void a(LivenessResponse livenessResponse, HVFaceConfig hVFaceConfig, long j) {
    }

    public void a(HVError hVError, LivenessResponse livenessResponse, HVFaceConfig hVFaceConfig) {
    }

    public void a(HVFaceConfig hVFaceConfig) {
        this.f2956e = hVFaceConfig;
    }

    public void a(String str, int i) {
    }

    public void b() {
    }

    public void b(HVDocConfig hVDocConfig) {
    }

    public void b(HVFaceConfig hVFaceConfig) {
    }

    public void b(String str, int i) {
    }

    public final void b(String str, String str2, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        Map<String, Object> E = E();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("hvFaceConfig", this.f2956e);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(HVDocConfig.KEY, this.f2957f);
        hashMap.putAll(E);
        char c2 = 65535;
        int hashCode = str2.hashCode();
        if (hashCode != 120891692) {
            if (hashCode != 208551453) {
                if (hashCode == 882304098 && str2.equals("DocEvent")) {
                    c2 = 2;
                }
            } else if (str2.equals("FaceEvent")) {
                c2 = 1;
            }
        } else if (str2.equals("NetworkEvent")) {
            c2 = 0;
        }
        if (c2 == 0) {
            hashMap.putAll(hashMap2);
            hashMap.putAll(hashMap3);
        } else if (c2 == 1) {
            hashMap.putAll(hashMap2);
        } else if (c2 == 2) {
            hashMap.putAll(hashMap3);
        }
        RudderProperty rudderProperty = new RudderProperty();
        rudderProperty.putValue(hashMap);
        rudderProperty.putValue("hv_event", str);
        if (!i.d(this.f2954c)) {
            new Gson().toJson((Object) rudderProperty);
        } else {
            this.f2955d.screen("MobileSDK", rudderProperty);
        }
    }

    public final String c(String str) {
        try {
            return str.substring(str.lastIndexOf(".") + 1);
        } catch (Exception e2) {
            i.a((Throwable) e2);
            return null;
        }
    }

    public void c(HVDocConfig hVDocConfig) {
    }

    public void c(HVFaceConfig hVFaceConfig) {
    }

    public final String d(String str) {
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            decodeFile.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
            long length = (long) byteArrayOutputStream.toByteArray().length;
            return (((double) length) / 1024.0d) + " KB";
        } catch (Exception e2) {
            i.a((Throwable) e2);
            return null;
        }
    }

    public void e() {
        c("Sensor Data Post Successful", null, null);
    }

    public void f() {
        c("Document - Picker Screen Close Clicked", "DocEvent", null);
    }

    public void g(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        c("Document - Picker Screen Load Success", "DocEvent", hashMap);
    }

    public void h(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        c("Camera Permission Granted", null, hashMap);
    }

    public void i(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        c("Document - Picker Screen Document Upload Button Clicked", "DocEvent", hashMap);
    }

    public void j() {
        q qVar = new q();
        HashMap hashMap = new HashMap();
        hashMap.put("Initialisation Timestamp", Long.valueOf(qVar.a()));
        hashMap.put("IP Address", i.a(true));
        String str = UUID.randomUUID() + "_HyperSnapSDKInitialised";
        hashMap.putAll(E());
        RudderProperty rudderProperty = new RudderProperty();
        rudderProperty.putValue(hashMap);
        rudderProperty.putValue("hv_event", "HyperSnapSDK Initialised");
        RudderTraits rudderTraits = new RudderTraits();
        rudderTraits.put(AnalyticsConstants.PROPERTIES, rudderProperty);
        if (!i.d(this.f2954c)) {
            new Gson().toJson((Object) rudderTraits);
        } else {
            this.f2955d.identify(str, rudderTraits, null);
        }
    }

    public void k() {
        b("Document - Picker Screen Launched", "DocEvent", null);
    }

    public void l(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        c("Selfie - Instructions Screen Proceed Button Clicked", "FaceEvent", hashMap);
    }

    public void m() {
        c("Camera Permission Requested", null, null);
    }

    public void n(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        c("Selfie - Instructions Screen Load Success", "FaceEvent", hashMap);
    }

    public void o() {
        b("Selfie - Retake Screen Launched", "FaceEvent", null);
    }

    public void p() {
        c("Document - Review Screen Back Pressed", "DocEvent", null);
    }

    public void q() {
        c("Selfie - Capture Flip Camera Button Clicked", "FaceEvent", null);
    }

    public void r() {
        c("Selfie - Capture Screen Back Pressed", "FaceEvent", null);
    }

    public void t() {
        b("Document - Capture Screen Launched", "DocEvent", null);
    }

    public void u() {
        b("Selfie - Capture Screen Launched", "FaceEvent", null);
    }

    public void v() {
    }

    public void w() {
    }

    public void x() {
        c("Document - Capture Flash Button Clicked", "DocEvent", null);
    }

    public void y() {
        c("Selfie - Retake Screen Back Pressed", "FaceEvent", null);
    }

    public void a() {
        b("Selfie - Instructions Screen Launched", "FaceEvent", null);
    }

    public void e(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        c("Selfie - Capture Screen Capture Button Clicked", "FaceEvent", hashMap);
    }

    public void f(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        c("Document - Review Screen Load Success", "DocEvent", hashMap);
    }

    public void k(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        c("Document - Instructions Screen Load Success", "DocEvent", hashMap);
    }

    public void m(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        c("Document - Picker Screen Document Capture Button Clicked", "DocEvent", hashMap);
    }

    public void a(HVError hVError, HVFaceConfig hVFaceConfig, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Error Code", Integer.valueOf(hVError.getErrorCode()));
        hashMap.put(AnalyticsEvent.ERROR_MESSAGE, hVError.getErrorMessage());
        hashMap.put("Time Spent", Long.valueOf(j));
        c("Selfie - Capture Screen Capture Failed", "FaceEvent", hashMap);
    }

    public final void c(String str, String str2, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, Object> E = E();
        HashMap hashMap = new HashMap();
        hashMap.put("hvFaceConfig", this.f2956e);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(HVDocConfig.KEY, this.f2957f);
        map.putAll(E);
        if (str2 != null) {
            char c2 = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != 120891692) {
                if (hashCode != 208551453) {
                    if (hashCode == 882304098 && str2.equals("DocEvent")) {
                        c2 = 2;
                    }
                } else if (str2.equals("FaceEvent")) {
                    c2 = 1;
                }
            } else if (str2.equals("NetworkEvent")) {
                c2 = 0;
            }
            if (c2 == 0) {
                map.putAll(hashMap);
                map.putAll(hashMap2);
            } else if (c2 == 1) {
                map.putAll(hashMap);
            } else if (c2 == 2) {
                map.putAll(hashMap2);
            }
        }
        RudderProperty rudderProperty = new RudderProperty();
        rudderProperty.putValue(map);
        rudderProperty.putValue("hv_event", str);
        if (!i.d(this.f2954c)) {
            new Gson().toJson((Object) rudderProperty);
        } else {
            this.f2955d.track("MobileSDK", rudderProperty);
        }
    }

    public void g(HVError hVError) {
        HashMap hashMap = new HashMap();
        hashMap.put("Error Code", Integer.valueOf(hVError.getErrorCode()));
        hashMap.put(AnalyticsEvent.ERROR_MESSAGE, hVError.getErrorMessage());
        c("Document - Review Screen Load Failure", "DocEvent", hashMap);
    }

    public void h(HVError hVError) {
        HashMap hashMap = new HashMap();
        hashMap.put("Error Code", Integer.valueOf(hVError.getErrorCode()));
        hashMap.put(AnalyticsEvent.ERROR_MESSAGE, hVError.getErrorMessage());
        c("Selfie - Capture Screen Load Failure", "FaceEvent", hashMap);
    }

    public void i(HVError hVError) {
        HashMap hashMap = new HashMap();
        hashMap.put("Error Code", Integer.valueOf(hVError.getErrorCode()));
        hashMap.put(AnalyticsEvent.ERROR_MESSAGE, hVError.getErrorMessage());
        c("Document - Instructions Screen Load Failure", "DocEvent", hashMap);
    }

    public void l() {
        b("Document - Review Screen Launched", "DocEvent", null);
    }

    public void n() {
        c("Selfie - Capture Screen Close Clicked", "FaceEvent", null);
    }

    public void e(HVError hVError) {
        HashMap hashMap = new HashMap();
        hashMap.put("Error Code", Integer.valueOf(hVError.getErrorCode()));
        hashMap.put(AnalyticsEvent.ERROR_MESSAGE, hVError.getErrorMessage());
        c("Document - Retake Screen Load Failure", "DocEvent", hashMap);
    }

    public void a(HVFaceConfig hVFaceConfig, String str, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        hashMap.put("imageSize", d(str));
        hashMap.put("imageFormat", c(str));
        c("Selfie - Capture Screen Capture Saved", "FaceEvent", hashMap);
    }

    public void d(HVError hVError) {
        HashMap hashMap = new HashMap();
        hashMap.put("Error Code", Integer.valueOf(hVError.getErrorCode()));
        hashMap.put(AnalyticsEvent.ERROR_MESSAGE, hVError.getErrorMessage());
        c("Selfie - Instructions Screen Load Failure", "FaceEvent", hashMap);
    }

    public void h() {
        c("Document - Capture Screen Close Clicked", "DocEvent", null);
    }

    public void i() {
        c("Document - Capture Screen Back Pressed", "DocEvent", null);
    }

    public void d(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        c("Selfie - Capture Screen Load Success", "FaceEvent", hashMap);
    }

    public void a(String str, long j, long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j2));
        long length = new File(str).length();
        hashMap.put("videoSize", (length / 1024) + "KB");
        hashMap.put("videoFormat", c(str));
        hashMap.put("videoDuration", Long.valueOf(j));
        c("Selfie - Video Record Successful", "FaceEvent", hashMap);
    }

    public void d(HVDocConfig hVDocConfig, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        hashMap.put("documentSide", hVDocConfig.getDocumentSide());
        c("Document - Capture Screen Capture Button Clicked", "DocEvent", hashMap);
    }

    public void j(HVError hVError) {
        HashMap hashMap = new HashMap();
        hashMap.put("Error Code", Integer.valueOf(hVError.getErrorCode()));
        hashMap.put(AnalyticsEvent.ERROR_MESSAGE, hVError.getErrorMessage());
        c("Selfie - Retake Screen Load Failure", "FaceEvent", hashMap);
    }

    public void b(HVError hVError, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        hashMap.put("Error Code", Integer.valueOf(hVError.getErrorCode()));
        hashMap.put(AnalyticsEvent.ERROR_MESSAGE, hVError.getErrorMessage());
        c("Camera Permission Denied", null, hashMap);
    }

    public void d() {
        c("Document - Retake Screen Back Pressed", "DocEvent", null);
    }

    public void j(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        c("Document - Capture Screen Load Success", "DocEvent", hashMap);
    }

    public void c(HVError hVError) {
        HashMap hashMap = new HashMap();
        hashMap.put("Error Code", Integer.valueOf(hVError.getErrorCode()));
        hashMap.put(AnalyticsEvent.ERROR_MESSAGE, hVError.getErrorMessage());
        c("Sensor Data Post Failure", "FaceEvent", hashMap);
    }

    public void a(HVError hVError, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Error Code", Integer.valueOf(hVError.getErrorCode()));
        hashMap.put(AnalyticsEvent.ERROR_MESSAGE, hVError.getErrorMessage());
        hashMap.put("Time Spent", Long.valueOf(j));
        c("Selfie - Video Record Failed", "FaceEvent", hashMap);
    }

    public void b(HVFaceConfig hVFaceConfig, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        c("Selfie - Capture Screen Capture Successful", "FaceEvent", hashMap);
    }

    public void c(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        c("Selfie - Retake Screen Load Success", "FaceEvent", hashMap);
    }

    public void a(HVFaceConfig hVFaceConfig, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        hashMap.put("numberOfFaceRetryAttempts", Integer.valueOf(o.a(hVFaceConfig.getLivenessEndpoint(), "")));
        c("Selfie - Retake Screen Retake Button Clicked", "FaceEvent", hashMap);
    }

    public void b(HVError hVError) {
        HashMap hashMap = new HashMap();
        hashMap.put("Error Code", Integer.valueOf(hVError.getErrorCode()));
        hashMap.put(AnalyticsEvent.ERROR_MESSAGE, hVError.getErrorMessage());
        c("Document - Capture Screen Load Failure", "DocEvent", hashMap);
    }

    public void c(HVDocConfig hVDocConfig, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        hashMap.put("documentSide", hVDocConfig.getDocumentSide());
        hashMap.put("numberOfDocRetryAttempts", Integer.valueOf(o.a(hVDocConfig.ocrEndpoint, hVDocConfig.getSuffixForDocument())));
        c("Document - Retake Screen Retake Button Clicked", "DocEvent", hashMap);
    }

    public void a(String str, String str2) {
        c("Selfie - Capture API Post", "FaceEvent", GeneratedOutlineSupport.outline88("apiUrl", str, NetworkingModule.CONTENT_TYPE_HEADER_NAME, "formdata"));
    }

    public void b(HVDocConfig hVDocConfig, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        c("Document - Capture Screen Capture Successful", "DocEvent", hashMap);
    }

    public void a(LivenessResponse livenessResponse, String str, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("statusCode", Integer.valueOf(livenessResponse.statusCode));
        hashMap.put("responseTime", Long.valueOf(j));
        hashMap.put("imageSize", d(str));
        hashMap.put("imageFormat", c(str));
        c("Selfie - Capture API Response Received", "FaceEvent", hashMap);
    }

    public void b(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        c("Document - Retake Screen Load Success", "DocEvent", hashMap);
    }

    public void b(String str, String str2) {
        c("Document - Capture API Post", "DocEvent", GeneratedOutlineSupport.outline88("apiUrl", str, NetworkingModule.CONTENT_TYPE_HEADER_NAME, "formdata"));
    }

    public void a(LivenessResponse livenessResponse, HVError hVError) {
        HashMap hashMap = new HashMap();
        hashMap.put("Error Code", Integer.valueOf(hVError.getErrorCode()));
        hashMap.put(AnalyticsEvent.ERROR_MESSAGE, hVError.getErrorMessage());
        c("Selfie - Capture API Call Failed", "FaceEvent", hashMap);
    }

    public void a(HVDocConfig hVDocConfig) {
        this.f2957f = hVDocConfig;
    }

    public void a(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        c("Document - Instructions Screen Proceed Button Clicked", "DocEvent", hashMap);
    }

    public void a(HVError hVError, HVDocConfig hVDocConfig, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        hashMap.put("Error Code", Integer.valueOf(hVError.getErrorCode()));
        hashMap.put(AnalyticsEvent.ERROR_MESSAGE, hVError.getErrorMessage());
        c("Document - Capture Failed", "DocEvent", hashMap);
    }

    public void a(HVDocConfig hVDocConfig, String str, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        hashMap.put("imageSize", d(str));
        hashMap.put("imageFormat", c(str));
        c("Document - Capture Saved", "DocEvent", hashMap);
    }

    public void a(HVDocConfig hVDocConfig, int i, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        hashMap.put("documentSide", hVDocConfig.getDocumentSide());
        hashMap.put("numberOfDocRetakeAttempts", Integer.valueOf(i));
        c("Document - Review Screen Confirm Button Clicked", "DocEvent", hashMap);
    }

    public void a(HVDocConfig hVDocConfig, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Time Spent", Long.valueOf(j));
        hashMap.put("documentSide", hVDocConfig.getDocumentSide());
        c("Document - Review Screen Retake Button Clicked", "DocEvent", hashMap);
    }

    public void a(HVResponse hVResponse, String str, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("Attempts", Integer.valueOf(hVResponse.getAttemptsCount()));
        hashMap.put("action", hVResponse.getAction());
        hashMap.put("responseTime", Long.valueOf(j));
        hashMap.put("imageSize", d(str));
        hashMap.put("imageFormat", c(str));
        c("Document - Capture API Response Received", "DocEvent", hashMap);
    }

    public void a(HVResponse hVResponse, HVError hVError) {
        HashMap hashMap = new HashMap();
        hashMap.put("Error Code", Integer.valueOf(hVError.getErrorCode()));
        hashMap.put(AnalyticsEvent.ERROR_MESSAGE, hVError.getErrorMessage());
        c("Document - Capture API Call Failed", "DocEvent", hashMap);
    }
}

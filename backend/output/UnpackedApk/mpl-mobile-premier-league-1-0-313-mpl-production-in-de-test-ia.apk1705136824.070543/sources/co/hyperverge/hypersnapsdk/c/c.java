package co.hyperverge.hypersnapsdk.c;

import android.content.Context;
import co.hyperverge.hypersnapsdk.f.i;
import co.hyperverge.hypersnapsdk.listeners.APICompletionCallback;
import co.hyperverge.hypersnapsdk.objects.HVDocConfig;
import co.hyperverge.hypersnapsdk.objects.HVError;
import co.hyperverge.hypersnapsdk.objects.HVResponse;
import com.mpl.androidapp.login.LoginReactModule;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DocOCRHelper */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f3085b;

    /* renamed from: c  reason: collision with root package name */
    public HVDocConfig f3086c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f3087d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f3088e = new JSONObject();

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f3089f = new JSONObject();
    public String g;
    public String h;
    public b i;

    /* compiled from: DocOCRHelper */
    public class a implements APICompletionCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f3090a;

        public a(b bVar) {
            this.f3090a = bVar;
        }

        public void onResult(HVError hVError, HVResponse hVResponse) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            if (hVResponse != null) {
                jSONObject = hVResponse.getApiResult();
                jSONObject2 = hVResponse.getApiHeaders();
            }
            JSONObject jSONObject3 = jSONObject;
            if (jSONObject3 == null) {
                try {
                    this.f3090a.a(false, "Some issue with the image capture. Please try again.", null, null, jSONObject2, hVError);
                } catch (Exception e2) {
                    i.a((Throwable) e2);
                    this.f3090a.a(false, "", null, jSONObject3, jSONObject2, null);
                }
            } else {
                c.this.a(jSONObject3.getJSONObject(LoginReactModule.RESULT), jSONObject3, jSONObject2, hVError);
            }
        }
    }

    /* compiled from: DocOCRHelper */
    public interface b {
        void a(boolean z, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, HVError hVError);
    }

    public void a(Context context, String str, String str2, HVDocConfig hVDocConfig, b bVar) {
        this.f3088e = hVDocConfig.getOcrParams();
        this.f3089f = hVDocConfig.getOcrHeaders();
        this.f3086c = hVDocConfig;
        this.i = bVar;
        try {
            this.f3088e.put("expectedDocumentSide", hVDocConfig.getSuffixForDocument());
            if (!o.i().isEmpty() && !this.f3089f.has("transactionId")) {
                this.f3089f.put("transactionId", o.i());
            }
        } catch (JSONException e2) {
            i.a((Throwable) e2);
        }
        HVDocConfig hVDocConfig2 = this.f3086c;
        JSONObject c2 = o.c(hVDocConfig2.ocrEndpoint, hVDocConfig2.getSuffixForDocument());
        this.f3087d = c2;
        Iterator<String> keys = c2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f3088e.put(next, String.valueOf(this.f3087d.getInt(next)));
            } catch (JSONException e3) {
                i.a((Throwable) e3);
            }
        }
        new q();
        a aVar = new a(bVar);
        if (!this.f3086c.isShouldReadQR() || str2 == null) {
            co.hyperverge.hypersnapsdk.b.a.a().a(context, hVDocConfig.ocrEndpoint, str, null, null, this.f3088e, this.f3089f, aVar);
            return;
        }
        co.hyperverge.hypersnapsdk.b.a.a().a(context, hVDocConfig.ocrEndpoint, str, str2, hVDocConfig, this.f3088e, this.f3089f, aVar);
    }

    public void a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, HVError hVError) {
        try {
            if (jSONObject.has("summary")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("summary");
                HVDocConfig hVDocConfig = this.f3086c;
                String d2 = o.d(hVDocConfig.ocrEndpoint, hVDocConfig.getSuffixForDocument());
                if (jSONObject4.has("action")) {
                    this.g = jSONObject4.getString("action");
                }
                if (jSONObject4.has("retakeMessage")) {
                    this.h = jSONObject4.getString("retakeMessage");
                }
                if (!this.f3086c.isShouldEnableRetries()) {
                    this.i.a(false, this.h, this.g, jSONObject2, jSONObject3, null);
                } else if (!this.g.equalsIgnoreCase("retake")) {
                    this.i.a(false, this.h, this.g, jSONObject2, jSONObject3, null);
                } else if (d2 != null) {
                    this.i.a(true, this.h, this.g, jSONObject2, jSONObject3, null);
                } else {
                    this.i.a(false, this.h, this.g, jSONObject2, jSONObject3, new HVError(17, "Please call startSession before making OCR call within SDK. Transaction ID is empty"));
                }
            } else {
                this.i.a(false, this.h, this.g, jSONObject2, jSONObject3, hVError);
            }
        } catch (Exception e2) {
            if (!k.a(i.a((Throwable) e2))) {
                i.a((Throwable) e2);
            }
        }
    }
}

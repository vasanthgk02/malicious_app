package com.amazon.apay.hardened.worker;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import androidx.work.ListenableWorker.Result;
import androidx.work.ListenableWorker.Result.Failure;
import androidx.work.ListenableWorker.Result.Success;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import c.c;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.netcore.android.SMTEventParamKeys;
import com.reactnativecommunity.webview.RNCWebViewManager;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.xiaomi.mipush.sdk.Constants;
import d.a;
import e.b;
import in.juspay.hypersdk.core.PaymentConstants;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

public class RecordPublishWorker extends Worker {

    /* renamed from: a  reason: collision with root package name */
    public c f3257a;

    /* renamed from: b  reason: collision with root package name */
    public String f3258b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3259c;

    public RecordPublishWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        boolean z = false;
        this.f3257a = new c(context.getSharedPreferences("APAY_RECORDS", 0));
        this.f3258b = workerParameters.mInputData.getString("STACK_TRACE");
        Object obj = workerParameters.mInputData.mValues.get("UNCAUGHT_EXCEPTION");
        this.f3259c = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    public final a a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        hashMap.put("x-amz-client-id", this.f3257a.a(PaymentConstants.CLIENT_ID_CAMEL));
        hashMap.put("x-amz-source", "Android");
        hashMap.put("x-amz-user-ip", b.a(true));
        hashMap.put("x-amz-user-agent", "Android/H.1.0.3");
        hashMap.put("x-amz-algorithm", "AWS4-HMAC-SHA384");
        hashMap.put("x-amz-expires", "900");
        hashMap.put("x-amz-date", simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())));
        a aVar = new a();
        aVar.f4999a = RNCWebViewManager.HTTP_METHOD_POST;
        aVar.f5000b = "amazonpay.amazon.in";
        aVar.f5001c = "/v2/sdk/records";
        aVar.f5002d = hashMap;
        aVar.f5003e = jSONObject;
        return aVar;
    }

    public Result doWork() {
        try {
            JSONObject a2 = a();
            a a3 = a(a2);
            String a4 = e.a.a((String) "ZVFaSkpzenM4SXEyTlVuSjhsakRvSXYwWkdock5VcUNkdnplYkJGWQ", a3);
            Map<String, String> map = a3.f5002d;
            map.put("Authorization", "AMZ QXMAIU6QMPRBNQPL:" + a4);
            if (TweetUtils.b("https://amazonpay.amazon.in/v2/postRecords", a2.toString(), a3.f5002d).getData().getInt(APayConstants.RESPONSE_CODE) == 200) {
                return new Success();
            }
            Timber.TREE_OF_SOULS.e("Failed to publish records. Clearing all records...", new Object[0]);
            this.f3257a.a();
            return new Failure();
        } catch (JSONException unused) {
            Timber.TREE_OF_SOULS.e("Failed to publish records. Clearing all records...", new Object[0]);
            this.f3257a.a();
            return new Failure();
        }
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("events", new JSONArray(this.f3257a.a("events")));
        jSONObject2.put("id", this.f3257a.a("operationId"));
        jSONObject2.put("name", this.f3257a.a("operation"));
        jSONObject.put("operation", jSONObject2);
        jSONObject.put(PaymentConstants.MERCHANT_ID_CAMEL, this.f3257a.a(PaymentConstants.CLIENT_ID_CAMEL));
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(SMTEventParamKeys.SMT_APP_ID, this.f3257a.a(SMTEventParamKeys.SMT_APP_ID));
        jSONObject3.put(Constants.PHONE_BRAND, Build.BRAND);
        jSONObject3.put("device", Build.DEVICE);
        jSONObject3.put("id", Build.ID);
        jSONObject3.put("kuberSdkVersion", "H.1.0.3");
        jSONObject3.put("mShopAppVersion", this.f3257a.a("amazonShoppingIndiaAppVersion"));
        jSONObject3.put("model", Build.MODEL);
        jSONObject3.put("product", Build.PRODUCT);
        jSONObject3.put("releaseVersion", VERSION.RELEASE);
        jSONObject3.put("sdkVersion", VERSION.SDK);
        jSONObject.put("fingerprintInfo", jSONObject3);
        String str = this.f3258b;
        jSONObject.put("error", (str == null || str.length() <= 0) ? null : this.f3258b);
        jSONObject.put("isCrashLog", this.f3259c);
        Timber.TREE_OF_SOULS.d("Payload: %s", jSONObject);
        return jSONObject;
    }
}

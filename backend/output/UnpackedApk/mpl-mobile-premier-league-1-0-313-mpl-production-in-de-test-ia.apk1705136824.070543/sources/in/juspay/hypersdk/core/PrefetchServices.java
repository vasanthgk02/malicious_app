package in.juspay.hypersdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.widget.FrameLayout;
import com.squareup.picasso.Utils;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.core.Labels.HyperSdk;
import in.juspay.hypersdk.core.PaymentConstants.LogCategory;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.LifeCycle;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONObject;

public class PrefetchServices {
    public static final String LOG_TAG = "PrefetchServices";
    public static DuiInterface duiInterface;
    public static JuspayServices preFetchJuspayServices;
    public static JSONObject prefetchBundleParams;

    public static JuspayServices createJuspayService(Context context, FrameLayout frameLayout) {
        return new JuspayServices(context, null, false, frameLayout);
    }

    public static void exitPreFetch() {
        SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.PREFETCH, "begin_exitPreFetch", Boolean.TRUE);
        JuspayServices juspayServices = preFetchJuspayServices;
        if (juspayServices != null) {
            juspayServices.destroy();
        } else {
            SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.PREFETCH, "juspayServices_is_null", Boolean.TRUE);
        }
        SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.PREFETCH, Utils.VERB_COMPLETED, Boolean.TRUE);
    }

    public static void preFetch(final Context context, final JSONObject jSONObject) {
        JuspayCoreLib.setApplicationContext(context.getApplicationContext());
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    PrefetchServices.preFetch(context, jSONObject);
                }
            });
            return;
        }
        try {
            jSONObject.put("pre_fetch", BaseParser.TRUE);
            jSONObject.put("use_local_assets", context.getResources().getBoolean(R.bool.use_local_assets));
            prefetchBundleParams = jSONObject;
            JuspayServices createJuspayService = createJuspayService(context, null);
            preFetchJuspayServices = createJuspayService;
            createJuspayService.start(jSONObject);
            HyperFragment.firstTimeSetup(context, preFetchJuspayServices);
            HyperFragment.prefetchBootLoaderFile(context, jSONObject, preFetchJuspayServices);
            DynamicUI dynamicUI = preFetchJuspayServices.getDynamicUI();
            JBridge jBridge = new JBridge(preFetchJuspayServices, null, null);
            duiInterface = jBridge;
            dynamicUI.addJavascriptInterface(jBridge, JBridge.LOG_TAG);
            dynamicUI.loadBaseHtml();
        } catch (Exception e2) {
            SdkTracker.trackAndLogBootException(LOG_TAG, LogCategory.LIFECYCLE, LifeCycle.HYPER_SDK, HyperSdk.PREFETCH, "Exception happened in PREFETCH", e2);
        }
    }

    public static void prefetchOnEvent() {
        String format = String.format("window.onMerchantEvent('%s',atob('%s'));", new Object[]{HyperSdk.PREFETCH, Base64.encodeToString(prefetchBundleParams.toString().getBytes(), 2)});
        DuiInterface duiInterface2 = duiInterface;
        if (duiInterface2 != null) {
            duiInterface2.invokeCustomFnInDUIWebview(format);
        } else {
            JuspayLogger.e(LOG_TAG, "duiInterface not Found on Merchant Event");
        }
    }
}

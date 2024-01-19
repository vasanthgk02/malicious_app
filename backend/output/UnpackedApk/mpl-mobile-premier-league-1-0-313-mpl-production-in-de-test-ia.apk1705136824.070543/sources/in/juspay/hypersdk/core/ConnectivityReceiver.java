package in.juspay.hypersdk.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Keep;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.paynimo.android.payment.util.Constant;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

public class ConnectivityReceiver extends BroadcastReceiver implements JuspayDuiHook {
    public static final String LOG_TAG = ConnectivityReceiver.class.getSimpleName();
    public final Map<Activity, Boolean> attachedMap = new WeakHashMap();
    public HyperFragment browserFragment;
    public JuspayServices juspayServices;

    @Keep
    public ConnectivityReceiver() {
    }

    public ConnectivityReceiver(HyperFragment hyperFragment) {
        this.browserFragment = hyperFragment;
        this.juspayServices = hyperFragment.getJuspayServices();
    }

    public void attach(Activity activity) {
        Boolean bool = this.attachedMap.get(activity);
        if (bool == null || !bool.booleanValue()) {
            activity.registerReceiver(this, new IntentFilter(Constant.INTENT_NETWORK_STATUS));
            JuspayServices juspayServices2 = this.juspayServices;
            String str = LOG_TAG;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Attaching the ");
            outline73.append(LOG_TAG);
            juspayServices2.sdkDebug(str, outline73.toString());
            this.attachedMap.put(activity, Boolean.TRUE);
        }
    }

    public void detach(Activity activity) {
        Boolean bool = this.attachedMap.get(activity);
        if (bool != null && bool.booleanValue()) {
            activity.unregisterReceiver(this);
            JuspayServices juspayServices2 = this.juspayServices;
            String str = LOG_TAG;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Detaching the ");
            outline73.append(LOG_TAG);
            juspayServices2.sdkDebug(str, outline73.toString());
            this.attachedMap.put(activity, Boolean.FALSE);
        }
    }

    public String execute(Activity activity, String str, JSONObject jSONObject, String str2) {
        if (this.browserFragment.getContext() == null) {
            return "error";
        }
        HyperFragment hyperFragment = this.browserFragment;
        return String.valueOf(hyperFragment.isNetworkAvailable(hyperFragment.getContext()));
    }

    public void onReceive(Context context, Intent intent) {
        if (this.browserFragment.getDuiInterface() != null && this.browserFragment.getContext() != null) {
            DuiInterface duiInterface = this.browserFragment.getDuiInterface();
            HyperFragment hyperFragment = this.browserFragment;
            duiInterface.invokeFnInDUIWebview("onNetworkChange", String.valueOf(hyperFragment.isNetworkAvailable(hyperFragment.getContext())));
        }
    }
}

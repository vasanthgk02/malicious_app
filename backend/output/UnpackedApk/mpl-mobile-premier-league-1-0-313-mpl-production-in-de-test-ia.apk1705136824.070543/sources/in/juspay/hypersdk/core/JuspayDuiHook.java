package in.juspay.hypersdk.core;

import android.app.Activity;
import org.json.JSONObject;

public interface JuspayDuiHook {
    void attach(Activity activity);

    void detach(Activity activity);

    String execute(Activity activity, String str, JSONObject jSONObject, String str2);
}

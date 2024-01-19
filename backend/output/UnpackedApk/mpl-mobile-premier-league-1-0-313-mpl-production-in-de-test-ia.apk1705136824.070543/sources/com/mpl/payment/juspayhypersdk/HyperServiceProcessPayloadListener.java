package com.mpl.payment.juspayhypersdk;

import java.util.HashMap;
import org.json.JSONObject;

public interface HyperServiceProcessPayloadListener {
    void onCleverTapEvent(String str, HashMap<String, Object> hashMap);

    void onError(String str);

    void onPayloadExtracted(JSONObject jSONObject);
}

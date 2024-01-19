package in.juspay.hypersdk.mystique;

import org.json.JSONObject;

public interface PropHandler {
    boolean handleProp(String str, JSONObject jSONObject, Object obj);
}

package co.hyperverge.facedetection;

import org.json.JSONException;
import org.json.JSONObject;

public class HVFace {
    public String faceLocation;

    public HVFace(String str, String str2) {
    }

    public void setFaceLocation(float f2, float f3, float f4, float f5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ltx", (double) f2);
            jSONObject.put("lty", (double) f3);
            jSONObject.put("width", (double) (f4 - f2));
            jSONObject.put("height", (double) (f5 - f3));
            jSONObject.put("rbx", (double) f4);
            jSONObject.put("rby", (double) f5);
        } catch (JSONException e2) {
            e2.getMessage();
        }
        this.faceLocation = jSONObject.toString();
    }
}

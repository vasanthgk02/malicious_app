package co.hyperverge.hypersnapsdk.objects;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;
import org.json.JSONObject;

public class HVResponse extends HVBaseResponse {
    public List<HVBaseResponse> retakeAttemptResponses;

    public HVResponse() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof HVResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HVResponse)) {
            return false;
        }
        HVResponse hVResponse = (HVResponse) obj;
        if (!hVResponse.canEqual(this)) {
            return false;
        }
        List<HVBaseResponse> retakeAttemptResponses2 = getRetakeAttemptResponses();
        List<HVBaseResponse> retakeAttemptResponses3 = hVResponse.getRetakeAttemptResponses();
        return retakeAttemptResponses2 != null ? retakeAttemptResponses2.equals(retakeAttemptResponses3) : retakeAttemptResponses3 == null;
    }

    public List<HVBaseResponse> getRetakeAttemptResponses() {
        return this.retakeAttemptResponses;
    }

    public int hashCode() {
        List<HVBaseResponse> retakeAttemptResponses2 = getRetakeAttemptResponses();
        return (retakeAttemptResponses2 == null ? 43 : retakeAttemptResponses2.hashCode()) + 59;
    }

    public void setRetakeAttemptResponses(List<HVBaseResponse> list) {
        this.retakeAttemptResponses = list;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("HVResponse(retakeAttemptResponses=");
        outline73.append(getRetakeAttemptResponses());
        outline73.append(")");
        return outline73.toString();
    }

    public HVResponse(JSONObject jSONObject, JSONObject jSONObject2, String str, String str2) {
        super(jSONObject, jSONObject2, str, str2);
    }
}

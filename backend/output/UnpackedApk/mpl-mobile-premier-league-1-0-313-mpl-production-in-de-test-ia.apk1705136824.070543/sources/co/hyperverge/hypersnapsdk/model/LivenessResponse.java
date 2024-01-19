package co.hyperverge.hypersnapsdk.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.json.JSONObject;

public class LivenessResponse extends BaseResponse {
    public JSONObject headers;
    public String livenessError = null;
    public String requestID;
    public JSONObject response;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LivenessResponse)) {
            return false;
        }
        LivenessResponse livenessResponse = (LivenessResponse) obj;
        if (livenessResponse != null) {
            JSONObject jSONObject = this.response;
            JSONObject jSONObject2 = livenessResponse.response;
            if (jSONObject != null ? !jSONObject.equals(jSONObject2) : jSONObject2 != null) {
                return false;
            }
            JSONObject jSONObject3 = this.headers;
            JSONObject jSONObject4 = livenessResponse.headers;
            if (jSONObject3 != null ? !jSONObject3.equals(jSONObject4) : jSONObject4 != null) {
                return false;
            }
            String str = this.livenessError;
            String str2 = livenessResponse.livenessError;
            if (str != null ? !str.equals(str2) : str2 != null) {
                return false;
            }
            String str3 = this.requestID;
            String str4 = livenessResponse.requestID;
            return str3 != null ? str3.equals(str4) : str4 == null;
        }
        throw null;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        JSONObject jSONObject = this.response;
        int i4 = 43;
        if (jSONObject == null) {
            i = 43;
        } else {
            i = jSONObject.hashCode();
        }
        JSONObject jSONObject2 = this.headers;
        int i5 = (i + 59) * 59;
        if (jSONObject2 == null) {
            i2 = 43;
        } else {
            i2 = jSONObject2.hashCode();
        }
        int i6 = i5 + i2;
        String str = this.livenessError;
        int i7 = i6 * 59;
        if (str == null) {
            i3 = 43;
        } else {
            i3 = str.hashCode();
        }
        int i8 = i7 + i3;
        String str2 = this.requestID;
        int i9 = i8 * 59;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        return i9 + i4;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("LivenessResponse(response=");
        outline73.append(this.response);
        outline73.append(", headers=");
        outline73.append(this.headers);
        outline73.append(", livenessError=");
        outline73.append(this.livenessError);
        outline73.append(", requestID=");
        return GeneratedOutlineSupport.outline62(outline73, this.requestID, ")");
    }
}

package co.hyperverge.hypersnapsdk.objects;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import org.json.JSONObject;

public class HVBaseResponse {
    public String action;
    public JSONObject apiHeaders;
    public JSONObject apiResult;
    public int attemptsCount;
    public String fullImageURI;
    public String imageURI;
    public String retakeMessage;
    public String videoUri;
    public String waterMarkCroppedImageUri;
    public String waterMarkFullImageUri;

    public HVBaseResponse() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof HVBaseResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HVBaseResponse)) {
            return false;
        }
        HVBaseResponse hVBaseResponse = (HVBaseResponse) obj;
        if (!hVBaseResponse.canEqual(this) || getAttemptsCount() != hVBaseResponse.getAttemptsCount()) {
            return false;
        }
        String imageURI2 = getImageURI();
        String imageURI3 = hVBaseResponse.getImageURI();
        if (imageURI2 != null ? !imageURI2.equals(imageURI3) : imageURI3 != null) {
            return false;
        }
        String retakeMessage2 = getRetakeMessage();
        String retakeMessage3 = hVBaseResponse.getRetakeMessage();
        if (retakeMessage2 != null ? !retakeMessage2.equals(retakeMessage3) : retakeMessage3 != null) {
            return false;
        }
        String action2 = getAction();
        String action3 = hVBaseResponse.getAction();
        if (action2 != null ? !action2.equals(action3) : action3 != null) {
            return false;
        }
        JSONObject apiResult2 = getApiResult();
        JSONObject apiResult3 = hVBaseResponse.getApiResult();
        if (apiResult2 != null ? !apiResult2.equals(apiResult3) : apiResult3 != null) {
            return false;
        }
        JSONObject apiHeaders2 = getApiHeaders();
        JSONObject apiHeaders3 = hVBaseResponse.getApiHeaders();
        if (apiHeaders2 != null ? !apiHeaders2.equals(apiHeaders3) : apiHeaders3 != null) {
            return false;
        }
        String fullImageURI2 = getFullImageURI();
        String fullImageURI3 = hVBaseResponse.getFullImageURI();
        if (fullImageURI2 != null ? !fullImageURI2.equals(fullImageURI3) : fullImageURI3 != null) {
            return false;
        }
        String waterMarkFullImageUri2 = getWaterMarkFullImageUri();
        String waterMarkFullImageUri3 = hVBaseResponse.getWaterMarkFullImageUri();
        if (waterMarkFullImageUri2 != null ? !waterMarkFullImageUri2.equals(waterMarkFullImageUri3) : waterMarkFullImageUri3 != null) {
            return false;
        }
        String waterMarkCroppedImageUri2 = getWaterMarkCroppedImageUri();
        String waterMarkCroppedImageUri3 = hVBaseResponse.getWaterMarkCroppedImageUri();
        if (waterMarkCroppedImageUri2 != null ? !waterMarkCroppedImageUri2.equals(waterMarkCroppedImageUri3) : waterMarkCroppedImageUri3 != null) {
            return false;
        }
        String videoUri2 = getVideoUri();
        String videoUri3 = hVBaseResponse.getVideoUri();
        return videoUri2 != null ? videoUri2.equals(videoUri3) : videoUri3 == null;
    }

    public String getAction() {
        return this.action;
    }

    public JSONObject getApiHeaders() {
        return this.apiHeaders;
    }

    public JSONObject getApiResult() {
        return this.apiResult;
    }

    public int getAttemptsCount() {
        return this.attemptsCount;
    }

    public String getFullImageURI() {
        return this.fullImageURI;
    }

    public String getImageURI() {
        return this.imageURI;
    }

    public String getRetakeMessage() {
        return this.retakeMessage;
    }

    public String getVideoUri() {
        return this.videoUri;
    }

    public String getWaterMarkCroppedImageUri() {
        return this.waterMarkCroppedImageUri;
    }

    public String getWaterMarkFullImageUri() {
        return this.waterMarkFullImageUri;
    }

    public int hashCode() {
        String imageURI2 = getImageURI();
        int i = 43;
        int attemptsCount2 = ((getAttemptsCount() + 59) * 59) + (imageURI2 == null ? 43 : imageURI2.hashCode());
        String retakeMessage2 = getRetakeMessage();
        int hashCode = (attemptsCount2 * 59) + (retakeMessage2 == null ? 43 : retakeMessage2.hashCode());
        String action2 = getAction();
        int hashCode2 = (hashCode * 59) + (action2 == null ? 43 : action2.hashCode());
        JSONObject apiResult2 = getApiResult();
        int hashCode3 = (hashCode2 * 59) + (apiResult2 == null ? 43 : apiResult2.hashCode());
        JSONObject apiHeaders2 = getApiHeaders();
        int hashCode4 = (hashCode3 * 59) + (apiHeaders2 == null ? 43 : apiHeaders2.hashCode());
        String fullImageURI2 = getFullImageURI();
        int hashCode5 = (hashCode4 * 59) + (fullImageURI2 == null ? 43 : fullImageURI2.hashCode());
        String waterMarkFullImageUri2 = getWaterMarkFullImageUri();
        int hashCode6 = (hashCode5 * 59) + (waterMarkFullImageUri2 == null ? 43 : waterMarkFullImageUri2.hashCode());
        String waterMarkCroppedImageUri2 = getWaterMarkCroppedImageUri();
        int hashCode7 = (hashCode6 * 59) + (waterMarkCroppedImageUri2 == null ? 43 : waterMarkCroppedImageUri2.hashCode());
        String videoUri2 = getVideoUri();
        int i2 = hashCode7 * 59;
        if (videoUri2 != null) {
            i = videoUri2.hashCode();
        }
        return i2 + i;
    }

    public boolean isVideoRecorded() {
        return !k.a(this.videoUri);
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setApiHeaders(JSONObject jSONObject) {
        this.apiHeaders = jSONObject;
    }

    public void setApiResult(JSONObject jSONObject) {
        this.apiResult = jSONObject;
    }

    public void setAttemptsCount(int i) {
        this.attemptsCount = i;
    }

    public void setFullImageURI(String str) {
        this.fullImageURI = str;
    }

    public void setImageURI(String str) {
        this.imageURI = str;
    }

    public void setRetakeMessage(String str) {
        this.retakeMessage = str;
    }

    public void setVideoUri(String str) {
        this.videoUri = str;
    }

    public void setWaterMarkCroppedImageUri(String str) {
        this.waterMarkCroppedImageUri = str;
    }

    public void setWaterMarkFullImageUri(String str) {
        this.waterMarkFullImageUri = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("HVBaseResponse(imageURI=");
        outline73.append(getImageURI());
        outline73.append(", attemptsCount=");
        outline73.append(getAttemptsCount());
        outline73.append(", retakeMessage=");
        outline73.append(getRetakeMessage());
        outline73.append(", action=");
        outline73.append(getAction());
        outline73.append(", apiResult=");
        outline73.append(getApiResult());
        outline73.append(", apiHeaders=");
        outline73.append(getApiHeaders());
        outline73.append(", fullImageURI=");
        outline73.append(getFullImageURI());
        outline73.append(", waterMarkFullImageUri=");
        outline73.append(getWaterMarkFullImageUri());
        outline73.append(", waterMarkCroppedImageUri=");
        outline73.append(getWaterMarkCroppedImageUri());
        outline73.append(", videoUri=");
        outline73.append(getVideoUri());
        outline73.append(")");
        return outline73.toString();
    }

    public HVBaseResponse(JSONObject jSONObject, JSONObject jSONObject2, String str, String str2) {
        this.apiResult = jSONObject;
        this.apiHeaders = jSONObject2;
        this.imageURI = str;
        this.action = str2;
        this.attemptsCount = 0;
    }
}

package co.hyperverge.hypersnapsdk.objects;

import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.f.i;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class HVFaceConfig extends HVBaseConfig implements Serializable {
    public static final String TAG = HVFaceConfig.class.getCanonicalName();
    public static HVFaceConfig faceConfigInstance;
    public boolean allowFaceTilt = true;
    public int autoCaptureDuration = 1500;
    public double bitrateM = 1.0d;
    public float bottomPadding = 0.0f;
    public String clientID = "";
    public int cropImageWaterMarkTextSizePx = 20;
    public String customLoaderClass = null;
    public String customUIStrings;
    public boolean dataLogging = true;
    public String faceCaptureSubtitle;
    public String faceCaptureTitle;
    public int fps = 30;
    public int fullImageWaterMarkTextSizePx = 45;
    public String headers;
    public float leftPadding = 0.0f;
    public String livenessEndpoint;
    public LivenessMode mode = LivenessMode.TEXTURELIVENESS;
    public int numberOfFrames = 50;
    public String params;
    public float rightPadding = 0.0f;
    public boolean shouldAddWaterMark = false;
    public boolean shouldAutoCapture = false;
    public boolean shouldHandleRetries = true;
    public boolean shouldRecordVideo = false;
    public boolean shouldReturnFullImageUrl = false;
    public boolean shouldSetPadding = false;
    public boolean shouldShowInstructionPage = false;
    public boolean shouldUseBackCamera = false;
    public boolean shouldUseDefaultZoom = false;
    public boolean shouldUseEnhancedCameraFeatures = false;
    public boolean shouldUseFlip = false;
    public boolean shouldUseZoom = false;
    public int statusTypeFace;
    public int subtitleTypeface;
    public int titleTypeface;
    public float topPadding = 0.0f;
    public boolean useBothImagesSignature = false;
    public boolean useFlash = false;
    public int waterMarkColor = -65536;

    public enum LivenessMode {
        NONE,
        TEXTURELIVENESS
    }

    public static HVFaceConfig getFaceConfigInstance() {
        return faceConfigInstance;
    }

    public static void setFaceConfigInstance(HVFaceConfig hVFaceConfig) {
        faceConfigInstance = hVFaceConfig;
    }

    public int getAutoCaptureDuration() {
        return this.autoCaptureDuration;
    }

    public double getBitrateM() {
        return this.bitrateM;
    }

    public float getBottomPadding() {
        return this.bottomPadding;
    }

    public String getClientID() {
        return this.clientID;
    }

    public int getCropImageWaterMarkTextSizePx() {
        return this.cropImageWaterMarkTextSizePx;
    }

    public String getCustomLoaderClass() {
        return this.customLoaderClass;
    }

    public JSONObject getCustomUIStrings() {
        JSONObject jSONObject = new JSONObject();
        if (this.customUIStrings == null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.customUIStrings);
        } catch (JSONException e2) {
            i.a((Throwable) e2);
            if (n.m().i == null) {
                return jSONObject;
            }
            n.m().i.a(e2);
            return jSONObject;
        }
    }

    public String getFaceCaptureSubtitle() {
        return this.faceCaptureSubtitle;
    }

    public String getFaceCaptureTitle() {
        return this.faceCaptureTitle;
    }

    public int getFps() {
        return this.fps;
    }

    public int getFullImageWaterMarkTextSizePx() {
        return this.fullImageWaterMarkTextSizePx;
    }

    public JSONObject getHeaders() {
        JSONObject jSONObject = new JSONObject();
        if (this.headers == null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.headers);
        } catch (JSONException e2) {
            i.a((Throwable) e2);
            if (n.m().i == null) {
                return jSONObject;
            }
            n.m().i.a(e2);
            return jSONObject;
        }
    }

    public float getLeftPadding() {
        return this.leftPadding;
    }

    public String getLivenessEndpoint() {
        String str = this.livenessEndpoint;
        if (str != null && !str.trim().isEmpty()) {
            return this.livenessEndpoint;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(n.m().h);
        if (n.m() != null) {
            sb.append("photo/liveness");
            return sb.toString();
        }
        throw null;
    }

    public JSONObject getLivenessParams() {
        JSONObject jSONObject = new JSONObject();
        if (this.params == null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.params);
        } catch (JSONException e2) {
            i.a((Throwable) e2);
            if (n.m().i == null) {
                return jSONObject;
            }
            n.m().i.a(e2);
            return jSONObject;
        }
    }

    public LivenessMode getMode() {
        return this.mode;
    }

    public int getNumberOfFrames() {
        return this.numberOfFrames;
    }

    public float getRightPadding() {
        return this.rightPadding;
    }

    public boolean getShouldUseBackCamera() {
        return this.shouldUseBackCamera;
    }

    public int getStatusTypeFace() {
        return this.statusTypeFace;
    }

    public String getStringMode() {
        LivenessMode livenessMode = this.mode;
        if (livenessMode == LivenessMode.NONE) {
            return "NONE";
        }
        return livenessMode == LivenessMode.TEXTURELIVENESS ? "TEXTURELIVENESS" : "";
    }

    public int getSubtitleTypeface() {
        return this.subtitleTypeface;
    }

    public int getTitleTypeface() {
        return this.titleTypeface;
    }

    public float getTopPadding() {
        return this.topPadding;
    }

    public int getWaterMarkColor() {
        return this.waterMarkColor;
    }

    @Deprecated
    public boolean isDataLogging() {
        return true;
    }

    public boolean isShouldAddWaterMark() {
        return this.shouldAddWaterMark;
    }

    public boolean isShouldAutoCapture() {
        if (this.shouldAutoCapture) {
            Map<String, Boolean> j = n.m().j();
            if (j != null && j.containsKey("selfie-auto-capture")) {
                this.shouldAutoCapture = j.get("selfie-auto-capture").booleanValue();
            }
        }
        return this.shouldAutoCapture;
    }

    public boolean isShouldHandleRetries() {
        return this.shouldHandleRetries;
    }

    public boolean isShouldRecordVideo() {
        if (this.shouldRecordVideo) {
            Map<String, Boolean> j = n.m().j();
            if (j != null && j.containsKey("video-recording")) {
                this.shouldRecordVideo = j.get("video-recording").booleanValue();
            }
        }
        return this.shouldRecordVideo;
    }

    public boolean isShouldReturnFullImageUrl() {
        return this.shouldReturnFullImageUrl;
    }

    public boolean isShouldSetPadding() {
        return this.shouldSetPadding;
    }

    public boolean isShouldShowInstructionPage() {
        return this.shouldShowInstructionPage;
    }

    public boolean isShouldUseDefaultZoom() {
        boolean z = this.shouldUseDefaultZoom;
        if (!z) {
            return z;
        }
        if (n.m() != null) {
            Map<String, Boolean> j = n.m().j();
            return (j == null || !j.containsKey("default-zoom")) ? true : j.get("default-zoom").booleanValue();
        }
        throw null;
    }

    public boolean isShouldUseEnhancedCameraFeatures() {
        return this.shouldUseEnhancedCameraFeatures;
    }

    public boolean isShouldUseFlip() {
        return this.shouldUseFlip;
    }

    public boolean isShouldUseZoom() {
        return this.shouldUseZoom;
    }

    public boolean isUseBothImagesSignature() {
        return this.useBothImagesSignature;
    }

    public boolean isUseFlash() {
        return this.useFlash;
    }

    public void setAllowFaceTilt(boolean z) {
        this.allowFaceTilt = z;
    }

    public void setAutoCaptureDuration(int i) {
        this.autoCaptureDuration = i;
    }

    public void setBitrateM(double d2) {
        this.bitrateM = d2;
    }

    public void setClientID(String str) {
        this.clientID = str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PaymentConstants.CLIENT_ID_CAMEL, this.clientID);
            setLivenessAPIParameters(jSONObject);
        } catch (JSONException e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
    }

    public void setCropImageWaterMarkTextSizePx(int i) {
        this.cropImageWaterMarkTextSizePx = i;
    }

    public void setCustomLoadingScreen(String str) {
        this.customLoaderClass = str;
    }

    public void setCustomUIStrings(JSONObject jSONObject) {
        this.customUIStrings = jSONObject.toString();
    }

    public void setDisableFaceDetection(boolean z) {
        n.m().f3129d = !z;
    }

    public void setFaceCaptureSubtitle(String str) {
        this.faceCaptureSubtitle = str;
    }

    public void setFaceCaptureTitle(String str) {
        this.faceCaptureTitle = str;
    }

    public void setFps(int i) {
        this.fps = i;
    }

    public void setFullImageWaterMarkTextSizePx(int i) {
        this.fullImageWaterMarkTextSizePx = i;
    }

    public void setLivenessAPIHeaders(JSONObject jSONObject) {
        this.headers = jSONObject.toString();
    }

    public void setLivenessAPIParameters(JSONObject jSONObject) {
        this.params = jSONObject.toString();
    }

    public void setLivenessEndpoint(String str) {
        this.livenessEndpoint = str;
    }

    public void setLivenessMode(LivenessMode livenessMode) {
        this.mode = livenessMode;
    }

    public void setNumberOfFrames(int i) {
        this.numberOfFrames = i;
    }

    public void setPadding(float f2, float f3, float f4, float f5) {
        this.leftPadding = f2;
        this.rightPadding = f3;
        this.topPadding = f4;
        this.bottomPadding = f5;
    }

    public void setShouldAddWaterMark(boolean z) {
        this.shouldAddWaterMark = z;
    }

    public void setShouldAutoCapture(boolean z) {
        this.shouldAutoCapture = z;
    }

    @Deprecated
    public void setShouldEnableDataLogging(boolean z) {
    }

    public void setShouldEnablePadding(boolean z) {
        this.shouldSetPadding = z;
        if (z) {
            setPadding(0.2f, 0.2f, 0.3f, 0.1f);
        }
    }

    public void setShouldHandleRetries(boolean z) {
        this.shouldHandleRetries = z;
    }

    public void setShouldRecordVideo(boolean z) {
        this.shouldRecordVideo = z;
    }

    public void setShouldReturnFullImageUrl(boolean z) {
        this.shouldReturnFullImageUrl = z;
    }

    public void setShouldShowCameraSwitchButton(boolean z) {
        this.shouldUseFlip = z;
    }

    public void setShouldShowInstructionPage(boolean z) {
        this.shouldShowInstructionPage = z;
    }

    public void setShouldUseBackCamera(boolean z) {
        this.shouldUseBackCamera = z;
    }

    public void setShouldUseDefaultZoom(boolean z) {
        this.shouldUseDefaultZoom = z;
    }

    public void setShouldUseEnhancedCameraFeatures(boolean z) {
        this.shouldUseEnhancedCameraFeatures = z;
    }

    @Deprecated
    public void setShouldUseZoom(boolean z) {
        this.shouldUseZoom = z;
    }

    public void setStatusTypeFace(int i) {
        this.statusTypeFace = i;
    }

    public void setSubtitleTypeface(int i) {
        this.subtitleTypeface = i;
    }

    public void setTitleTypeface(int i) {
        this.titleTypeface = i;
    }

    public void setUseBothImagesSignatureCalc(boolean z) {
        this.useBothImagesSignature = z;
    }

    public void setWaterMarkColor(int i) {
        this.waterMarkColor = i;
    }

    public boolean shouldCheckForFaceTilt() {
        return !this.allowFaceTilt;
    }
}

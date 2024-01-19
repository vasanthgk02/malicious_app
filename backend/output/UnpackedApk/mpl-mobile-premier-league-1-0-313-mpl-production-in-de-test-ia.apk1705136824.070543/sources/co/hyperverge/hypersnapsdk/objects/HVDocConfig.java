package co.hyperverge.hypersnapsdk.objects;

import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.f.i;
import com.razorpay.AnalyticsConstants;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class HVDocConfig extends HVBaseConfig implements Serializable {
    public static final String KEY = "hvDocConfig";
    public static final String TAG = HVDocConfig.class.getCanonicalName();
    public int allowedTiltPitch = 10;
    public int allowedTiltRoll = 10;
    public String customUIStrings;
    public int descTypeface;
    public String docCaptureDescription;
    public String docCaptureSubText;
    public String docCaptureSubtitle;
    public String docCaptureTitle;
    public String docReviewDescription;
    public String docReviewSubtitle;
    public String docReviewTitle;
    public Document document = Document.CARD;
    public DocumentSide documentSide = DocumentSide.FRONT;
    public boolean enableDocumentUpload = false;
    public int hintTypeface;
    public String ocrEndpoint;
    public String ocrHeaders;
    public String ocrParams;
    public float padding = 0.0f;
    public int reviewScreenConfirmButtonTypeface;
    public int reviewScreenDescTypeface;
    public int reviewScreenRetakeButtonTypeface;
    public int reviewScreenSubtitleTypeface;
    public int reviewScreenTitleTypeface;
    public boolean shouldAllowPhoneTilt = true;
    public boolean shouldDoIpToGeo = false;
    public boolean shouldDoOCR = false;
    public boolean shouldEnableRetries;
    public boolean shouldExportPDF = false;
    public boolean shouldReadQR = false;
    public boolean shouldSetPadding = true;
    public boolean shouldShowFlashIcon = false;
    public boolean shouldShowInstructionPage = false;
    public boolean shouldShowReviewScreen = false;
    public int subtitleTypeface;
    public int titleTypeface;

    public enum Document {
        CARD(0.625f) {
            public void setAspectRatio(float f2) {
            }
        },
        A4(1.5f) {
            public void setAspectRatio(float f2) {
            }
        },
        PASSPORT(0.6666667f) {
            public void setAspectRatio(float f2) {
            }
        },
        OTHER(0.5f) {
            public void setAspectRatio(float f2) {
                this.aspectRatio = f2;
            }
        };
        
        public float aspectRatio;

        public float getAspectRatio() {
            return this.aspectRatio;
        }

        public abstract void setAspectRatio(float f2);

        /* access modifiers changed from: public */
        Document(float f2) {
            this.aspectRatio = f2;
        }
    }

    public enum DocumentSide {
        FRONT,
        BACK
    }

    public int getAllowedTiltPitch() {
        return this.allowedTiltPitch;
    }

    public int getAllowedTiltRoll() {
        return this.allowedTiltRoll;
    }

    public String getCapturePageSubtitleText() {
        return this.docCaptureSubtitle;
    }

    public String getCapturePageTitleText() {
        return this.docCaptureTitle;
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

    public int getDescTypeface() {
        return this.descTypeface;
    }

    public String getDocCaptureDescription() {
        return this.docCaptureDescription;
    }

    public String getDocCaptureSubText() {
        return this.docCaptureSubText;
    }

    public String getDocReviewDescription() {
        return this.docReviewDescription;
    }

    public String getDocReviewSubtitle() {
        return this.docReviewSubtitle;
    }

    public String getDocReviewTitle() {
        return this.docReviewTitle;
    }

    public Document getDocument() {
        return this.document;
    }

    public DocumentSide getDocumentSide() {
        return this.documentSide;
    }

    public int getHintTypeface() {
        return this.hintTypeface;
    }

    public JSONObject getOcrHeaders() {
        try {
            if (this.ocrHeaders != null) {
                return new JSONObject(this.ocrHeaders);
            }
            return new JSONObject();
        } catch (Exception unused) {
            return new JSONObject();
        }
    }

    public JSONObject getOcrParams() {
        try {
            if (this.ocrParams != null) {
                return new JSONObject(this.ocrParams);
            }
            return new JSONObject();
        } catch (Exception e2) {
            i.a((Throwable) e2);
            return new JSONObject();
        }
    }

    public int getReviewScreenConfirmButtonTypeface() {
        return this.reviewScreenConfirmButtonTypeface;
    }

    public int getReviewScreenDescTypeface() {
        return this.reviewScreenDescTypeface;
    }

    public int getReviewScreenRetakeButtonTypeface() {
        return this.reviewScreenRetakeButtonTypeface;
    }

    public int getReviewScreenSubtitleTypeface() {
        return this.reviewScreenSubtitleTypeface;
    }

    public int getReviewScreenTitleTypeface() {
        return this.reviewScreenTitleTypeface;
    }

    public int getSubtitleTypeface() {
        return this.subtitleTypeface;
    }

    public String getSuffixForDocument() {
        return this.documentSide == DocumentSide.FRONT ? "front" : AnalyticsConstants.BACK;
    }

    public int getTitleTypeface() {
        return this.titleTypeface;
    }

    public boolean isDocumentUploadEnabled() {
        return this.enableDocumentUpload;
    }

    public boolean isShouldAllowPhoneTilt() {
        return this.shouldAllowPhoneTilt;
    }

    public boolean isShouldDoIpToGeo() {
        return this.shouldDoIpToGeo;
    }

    public boolean isShouldDoOCR() {
        return this.shouldDoOCR;
    }

    public boolean isShouldEnableRetries() {
        return this.shouldEnableRetries;
    }

    public boolean isShouldExportPDF() {
        return this.shouldExportPDF;
    }

    public boolean isShouldReadQR() {
        return this.shouldReadQR;
    }

    public boolean isShouldSetPadding() {
        return this.shouldSetPadding;
    }

    public boolean isShouldShowFlashIcon() {
        return this.shouldShowFlashIcon;
    }

    public boolean isShouldShowInstructionPage() {
        return this.shouldShowInstructionPage;
    }

    public void setCustomUIStrings(JSONObject jSONObject) {
        this.customUIStrings = jSONObject.toString();
    }

    public void setDescTypeFace(int i) {
        this.descTypeface = i;
    }

    public void setDocCaptureDescription(String str) {
        this.docCaptureDescription = str;
    }

    public void setDocCaptureSubText(String str) {
        this.docCaptureSubText = str;
    }

    public void setDocCaptureSubtitle(String str) {
        this.docCaptureSubtitle = str;
    }

    public void setDocCaptureTitle(String str) {
        this.docCaptureTitle = str;
    }

    public void setDocReviewDescription(String str) {
        this.docReviewDescription = str;
    }

    public void setDocReviewSubtitle(String str) {
        this.docReviewSubtitle = str;
    }

    public void setDocReviewTitle(String str) {
        this.docReviewTitle = str;
    }

    public void setDocumentType(Document document2) {
        this.document = document2;
    }

    public void setEnableDocumentUpload(boolean z) {
        this.enableDocumentUpload = z;
    }

    public void setHintTypeface(int i) {
        this.hintTypeface = i;
    }

    public void setOCRDetails(String str, DocumentSide documentSide2, String str2, String str3) {
        this.ocrEndpoint = str;
        this.ocrParams = str2;
        this.ocrHeaders = str3;
        this.documentSide = documentSide2;
        this.shouldEnableRetries = true;
        this.shouldDoOCR = true;
    }

    public void setPadding(float f2) {
        this.shouldSetPadding = true;
        this.padding = f2;
    }

    public void setPhoneTiltConstraints(int i, int i2) {
        this.allowedTiltRoll = i;
        this.allowedTiltPitch = i2;
    }

    public void setReviewScreenConfirmButtonTypeface(int i) {
        this.reviewScreenConfirmButtonTypeface = i;
    }

    public void setReviewScreenDescTypeface(int i) {
        this.reviewScreenDescTypeface = i;
    }

    public void setReviewScreenRetakeButtonTypeface(int i) {
        this.reviewScreenRetakeButtonTypeface = i;
    }

    public void setReviewScreenSubtitleTypeface(int i) {
        this.reviewScreenSubtitleTypeface = i;
    }

    public void setReviewScreenTitleTypeface(int i) {
        this.reviewScreenTitleTypeface = i;
    }

    public void setShouldAddPadding(boolean z) {
        this.shouldSetPadding = z;
        if (z) {
            setPadding(0.2f);
        }
    }

    public void setShouldAllowPhoneTilt(boolean z) {
        this.shouldAllowPhoneTilt = z;
    }

    public void setShouldEnableRetries(boolean z) {
        this.shouldEnableRetries = z;
    }

    public void setShouldExportPDF(boolean z) {
        this.shouldExportPDF = z;
    }

    public void setShouldReadQR(boolean z) {
        this.shouldReadQR = z;
    }

    public void setShouldShowFlashIcon(boolean z) {
        this.shouldShowFlashIcon = z;
    }

    public void setShouldShowInstructionPage(boolean z) {
        this.shouldShowInstructionPage = z;
    }

    public void setShouldShowReviewScreen(boolean z) {
        this.shouldShowReviewScreen = z;
    }

    public void setSubtitleTypeFace(int i) {
        this.subtitleTypeface = i;
    }

    public void setTitleTypeFace(int i) {
        this.titleTypeface = i;
    }

    public boolean shouldShowReviewScreen() {
        return this.shouldShowReviewScreen;
    }
}

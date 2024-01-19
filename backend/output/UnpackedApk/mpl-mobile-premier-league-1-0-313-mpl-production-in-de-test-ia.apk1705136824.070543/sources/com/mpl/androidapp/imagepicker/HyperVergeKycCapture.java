package com.mpl.androidapp.imagepicker;

import android.app.Activity;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.mpl.androidapp.utils.LocaleHelper;
import com.mpl.payment.gopay.GopayLinkingHandler;
import com.netcore.android.SMTEventParamKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\"\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J$\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/mpl/androidapp/imagepicker/HyperVergeKycCapture;", "Lcom/mpl/androidapp/imagepicker/KycIdProvider;", "appId", "", "appKey", "docType", "activity", "Landroid/app/Activity;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "getAppId", "()Ljava/lang/String;", "captureIds", "", "documentType", "idCaptureListener", "Lcom/mpl/androidapp/imagepicker/IdCaptureListener;", "getAadhaarBackStrings", "Lcom/mpl/androidapp/imagepicker/HyperVergeKycCapture$DocCaptureStrings;", "getAadhaarFrontStrings", "getCurrentLanguage", "getDocCaptureStrings", "getPanStrings", "sendFailStatus", "errorMessage", "errorCode", "", "sendSuccessStatus", "path", "size", "Companion", "DocCaptureStrings", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HyperVergeKycCapture.kt */
public final class HyperVergeKycCapture implements KycIdProvider {
    public static final String BN = "bn";
    public static final Companion Companion = new Companion(null);
    public static final String DOC_DESC_BACK_BN = "নিশ্চিত করুন যে লাইটিং ভাল আছে এবং ডকুমেন্টে কোনও গ্লেয়ার নেই। সমস্ত তথ্য স্পষ্টভাবে পঠনযোগ্য।";
    public static final String DOC_DESC_BACK_EN = "Make sure lighting is good and there are no glares on the document. \n All information is clearly readable.";
    public static final String DOC_DESC_BACK_GU = "ખાતરી કરો કે લાઈટિંગ સારી છે અને ડોક્યુમેન્ટ પર કોઈપણ વધારે પ્રકાશ નથી. બધી માહિતી સ્પષ્ટ રીતે વાંચી શકાય તેવી છે.";
    public static final String DOC_DESC_BACK_HI = "सुनिश्चित करें कि लाइटिंग अच्छी है और दस्तावेज़ पर कोई चमक नहीं हैं। सभी जानकारी स्पष्ट रूप से पठनीय है।";
    public static final String DOC_DESC_BACK_MR = "खात्री करा की प्रकाशयोजना चांगली आहे आणि डॉक्युमेंटवर कोणतीही चमक नाही. सर्व माहिती स्पष्टपणे वाचण्यायोग्य आहे.";
    public static final String DOC_DESC_BACK_TA = "லைட்டிங் நன்றாக இருப்பதையும், ஆவணத்தில் கண்ணை கூசும் காட்சிகள் இல்லை என்பதையும் உறுதிப்படுத்திக் கொள்ளுங்கள்.";
    public static final String DOC_DESC_BACK_TE = "లైటింగ్ బాగుందని మరియు డాక్యుమెంట్ మీద ఎలాంటి మెరుపులు లేవని నిర్ధారించుకోండి. మొత్తం సమాచారం స్పష్టంగా చదవదగినది.";
    public static final String DOC_DESC_FRONT_BN = "নিশ্চিত করুন যে ভালো লাইটিং আছে এবং ডকুমেন্টে কোনো গ্লেয়ার নেই। নাম, ID নম্বর এবং DOB স্পষ্টভাবে দৃশ্যমান হওয়া উচিত।";
    public static final String DOC_DESC_FRONT_EN = "Make sure lighting is good and there are no glares on the document.\n Name, ID number and DOB should be clearly visible.";
    public static final String DOC_DESC_FRONT_GU = "ખાતરી કરો કે લાઈટિંગ સારી છે અને ડોક્યુમેન્ટ પર કોઈપણ વધારે પ્રકાશ નથી.  નામ, ID નંબર અને DOB સ્પષ્ટ રીતે દેખાવા જોઈએ.";
    public static final String DOC_DESC_FRONT_HI = "सुनिश्चित करें कि लाइटिंग अच्छी है और दस्तावेज़ पर कोई चमक नहीं हैं।  नाम, ID नंबर और DOB स्पष्ट दिखने चाहिए।";
    public static final String DOC_DESC_FRONT_MR = "खात्री करा की प्रकाशयोजना चांगली आहे आणि डॉक्युमेंटवर कोणतीही चमक नाही. नाव, ID क्रमांक आणि DOB स्पष्टपणे दिसण्यायोग्य असायला पाहिजे.";
    public static final String DOC_DESC_FRONT_TA = "லைட்டிங் நன்றாக இருப்பதையும், ஆவணத்தில் கண்ணை கூசும் காட்சிகள் இல்லை என்பதையும் உறுதிப்படுத்திக் கொள்ளுங்கள். பெயர், ID எண் மற்றும் DOB தெளிவாகத் தெரிய வேண்டும்.";
    public static final String DOC_DESC_FRONT_TE = "లైటింగ్ బాగుందని మరియు డాక్యుమెంట్‌ మీద ఎలాంటి మెరుపులు లేవని నిర్ధారించుకోండి. పేరు, ID నంబర్ మరియు DOB స్పష్టంగా కనిపించాలి.";
    public static final String DOC_SUBTEXT_BACK_BN = "পেছনের দিক";
    public static final String DOC_SUBTEXT_BACK_EN = "Back Side";
    public static final String DOC_SUBTEXT_BACK_GU = "પાછળની બાજુ";
    public static final String DOC_SUBTEXT_BACK_HI = "पीछे का हिस्‍सा";
    public static final String DOC_SUBTEXT_BACK_MR = "मागील बाजू";
    public static final String DOC_SUBTEXT_BACK_TE = "వెనుక వైపు";
    public static final String DOC_SUBTEXT_FRONT_BN = "সামনের দিক";
    public static final String DOC_SUBTEXT_FRONT_EN = "Front Side";
    public static final String DOC_SUBTEXT_FRONT_GU = "આગળની બાજુ";
    public static final String DOC_SUBTEXT_FRONT_HI = "सामने का हिस्‍सा";
    public static final String DOC_SUBTEXT_FRONT_MR = "पुढील बाजू";
    public static final String DOC_SUBTEXT_FRONT_TE = "ముందు వైపు";
    public static final String DOC_TITLE_AADHAAR_BACK_BN = "আপনার আধারের পিছনের দিক";
    public static final String DOC_TITLE_AADHAAR_BACK_EN = "BACK side of your Aadhaar";
    public static final String DOC_TITLE_AADHAAR_BACK_GU = "તમારા આધારની પાછળની બાજુ";
    public static final String DOC_TITLE_AADHAAR_BACK_HI = "आपके आधार के पीछे का हिस्‍सा";
    public static final String DOC_TITLE_AADHAAR_BACK_MR = "आपल्या आधारची मागील बाजू";
    public static final String DOC_TITLE_AADHAAR_BACK_TA = "உங்கள் ஆதாரின் பின் பக்கம்";
    public static final String DOC_TITLE_AADHAAR_BACK_TE = "మీ ఆధార్ వెనుక వైపు";
    public static final String DOC_TITLE_AADHAAR_FRONT_BN = "আপনার আধারের সামনের দিক";
    public static final String DOC_TITLE_AADHAAR_FRONT_EN = "FRONT side of your Aadhaar";
    public static final String DOC_TITLE_AADHAAR_FRONT_GU = "તમારા આધારની આગળની બાજુ";
    public static final String DOC_TITLE_AADHAAR_FRONT_HI = "आपके आधार के सामने का हिस्‍सा";
    public static final String DOC_TITLE_AADHAAR_FRONT_MR = "आपल्या आधारची पुढील बाजू";
    public static final String DOC_TITLE_AADHAAR_FRONT_TA = "உங்கள் ஆதாரின் முன் பக்கம்";
    public static final String DOC_TITLE_AADHAAR_FRONT_TE = "మీ ఆధార్ ముందు వైపు";
    public static final String DOC_TITLE_PAN_BN = "আপনার প্যানের সামনের দিক";
    public static final String DOC_TITLE_PAN_EN = "FRONT side of your PAN";
    public static final String DOC_TITLE_PAN_GU = "તમારા પાનની આગળની બાજુ";
    public static final String DOC_TITLE_PAN_HI = "पैन के सामने का हिस्‍सा";
    public static final String DOC_TITLE_PAN_MR = "आपल्या पॅनची पुढील बाजू";
    public static final String DOC_TITLE_PAN_TA = "உங்கள் பானின் முன் பக்கம்";
    public static final String DOC_TITLE_PAN_TE = "మీ పాన్ ముందు వైపు";
    public static final String DOC_TYPE_AADHAAR_BACK = "AADHAAR_BACK";
    public static final String DOC_TYPE_AADHAAR_FRONT = "AADHAAR_FRONT";
    public static final String DOC_TYPE_PAN = "PAN";
    public static final String EN = "en";
    public static final String GU = "gu";
    public static final String HI = "hi";
    public static final String HN = "hn";
    public static final String MR = "mr";
    public static final String TA = "ta";
    public static final String TE = "te";
    public final Activity activity;
    public final String appId;
    public final String appKey;
    public final String docType;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b:\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/mpl/androidapp/imagepicker/HyperVergeKycCapture$Companion;", "", "()V", "BN", "", "DOC_DESC_BACK_BN", "DOC_DESC_BACK_EN", "DOC_DESC_BACK_GU", "DOC_DESC_BACK_HI", "DOC_DESC_BACK_MR", "DOC_DESC_BACK_TA", "DOC_DESC_BACK_TE", "DOC_DESC_FRONT_BN", "DOC_DESC_FRONT_EN", "DOC_DESC_FRONT_GU", "DOC_DESC_FRONT_HI", "DOC_DESC_FRONT_MR", "DOC_DESC_FRONT_TA", "DOC_DESC_FRONT_TE", "DOC_SUBTEXT_BACK_BN", "DOC_SUBTEXT_BACK_EN", "DOC_SUBTEXT_BACK_GU", "DOC_SUBTEXT_BACK_HI", "DOC_SUBTEXT_BACK_MR", "DOC_SUBTEXT_BACK_TE", "DOC_SUBTEXT_FRONT_BN", "DOC_SUBTEXT_FRONT_EN", "DOC_SUBTEXT_FRONT_GU", "DOC_SUBTEXT_FRONT_HI", "DOC_SUBTEXT_FRONT_MR", "DOC_SUBTEXT_FRONT_TE", "DOC_TITLE_AADHAAR_BACK_BN", "DOC_TITLE_AADHAAR_BACK_EN", "DOC_TITLE_AADHAAR_BACK_GU", "DOC_TITLE_AADHAAR_BACK_HI", "DOC_TITLE_AADHAAR_BACK_MR", "DOC_TITLE_AADHAAR_BACK_TA", "DOC_TITLE_AADHAAR_BACK_TE", "DOC_TITLE_AADHAAR_FRONT_BN", "DOC_TITLE_AADHAAR_FRONT_EN", "DOC_TITLE_AADHAAR_FRONT_GU", "DOC_TITLE_AADHAAR_FRONT_HI", "DOC_TITLE_AADHAAR_FRONT_MR", "DOC_TITLE_AADHAAR_FRONT_TA", "DOC_TITLE_AADHAAR_FRONT_TE", "DOC_TITLE_PAN_BN", "DOC_TITLE_PAN_EN", "DOC_TITLE_PAN_GU", "DOC_TITLE_PAN_HI", "DOC_TITLE_PAN_MR", "DOC_TITLE_PAN_TA", "DOC_TITLE_PAN_TE", "DOC_TYPE_AADHAAR_BACK", "DOC_TYPE_AADHAAR_FRONT", "DOC_TYPE_PAN", "EN", "GU", "HI", "HN", "MR", "TA", "TE", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HyperVergeKycCapture.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/mpl/androidapp/imagepicker/HyperVergeKycCapture$DocCaptureStrings;", "", "docTitle", "", "docDescription", "docSubtext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDocDescription", "()Ljava/lang/String;", "getDocSubtext", "getDocTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HyperVergeKycCapture.kt */
    public static final class DocCaptureStrings {
        public final String docDescription;
        public final String docSubtext;
        public final String docTitle;

        public DocCaptureStrings() {
            this(null, null, null, 7, null);
        }

        public DocCaptureStrings(String str, String str2, String str3) {
            this.docTitle = str;
            this.docDescription = str2;
            this.docSubtext = str3;
        }

        public static /* synthetic */ DocCaptureStrings copy$default(DocCaptureStrings docCaptureStrings, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = docCaptureStrings.docTitle;
            }
            if ((i & 2) != 0) {
                str2 = docCaptureStrings.docDescription;
            }
            if ((i & 4) != 0) {
                str3 = docCaptureStrings.docSubtext;
            }
            return docCaptureStrings.copy(str, str2, str3);
        }

        public final String component1() {
            return this.docTitle;
        }

        public final String component2() {
            return this.docDescription;
        }

        public final String component3() {
            return this.docSubtext;
        }

        public final DocCaptureStrings copy(String str, String str2, String str3) {
            return new DocCaptureStrings(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DocCaptureStrings)) {
                return false;
            }
            DocCaptureStrings docCaptureStrings = (DocCaptureStrings) obj;
            return Intrinsics.areEqual(this.docTitle, docCaptureStrings.docTitle) && Intrinsics.areEqual(this.docDescription, docCaptureStrings.docDescription) && Intrinsics.areEqual(this.docSubtext, docCaptureStrings.docSubtext);
        }

        public final String getDocDescription() {
            return this.docDescription;
        }

        public final String getDocSubtext() {
            return this.docSubtext;
        }

        public final String getDocTitle() {
            return this.docTitle;
        }

        public int hashCode() {
            String str = this.docTitle;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.docDescription;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.docSubtext;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("DocCaptureStrings(docTitle=");
            outline73.append(this.docTitle);
            outline73.append(", docDescription=");
            outline73.append(this.docDescription);
            outline73.append(", docSubtext=");
            outline73.append(this.docSubtext);
            outline73.append(')');
            return outline73.toString();
        }

        public /* synthetic */ DocCaptureStrings(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }
    }

    public HyperVergeKycCapture(String str, String str2, String str3, Activity activity2) {
        Intrinsics.checkNotNullParameter(str, SMTEventParamKeys.SMT_APP_ID);
        Intrinsics.checkNotNullParameter(str2, "appKey");
        Intrinsics.checkNotNullParameter(str3, "docType");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.appId = str;
        this.appKey = str2;
        this.docType = str3;
        this.activity = activity2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        if (r0.equals(HN) == false) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007c, code lost:
        if (r0.equals(HI) == false) goto L_0x00bb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.mpl.androidapp.imagepicker.HyperVergeKycCapture.DocCaptureStrings getAadhaarBackStrings() {
        /*
            r7 = this;
            java.lang.String r0 = r7.getCurrentLanguage()
            int r1 = r0.hashCode()
            r2 = 3148(0xc4c, float:4.411E-42)
            if (r1 == r2) goto L_0x00b3
            r2 = 3241(0xca9, float:4.542E-42)
            java.lang.String r3 = "Back Side"
            if (r1 == r2) goto L_0x00a0
            r2 = 3310(0xcee, float:4.638E-42)
            if (r1 == r2) goto L_0x008b
            r2 = 3329(0xd01, float:4.665E-42)
            if (r1 == r2) goto L_0x0076
            r2 = 3334(0xd06, float:4.672E-42)
            if (r1 == r2) goto L_0x006d
            r2 = 3493(0xda5, float:4.895E-42)
            if (r1 == r2) goto L_0x0058
            r2 = 3693(0xe6d, float:5.175E-42)
            if (r1 == r2) goto L_0x0043
            r2 = 3697(0xe71, float:5.18E-42)
            if (r1 == r2) goto L_0x002c
            goto L_0x00bb
        L_0x002c:
            java.lang.String r1 = "te"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0036
            goto L_0x00bb
        L_0x0036:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "మీ ఆధార్ వెనుక వైపు"
            java.lang.String r2 = "లైటింగ్ బాగుందని మరియు డాక్యుమెంట్ మీద ఎలాంటి మెరుపులు లేవని నిర్ధారించుకోండి. మొత్తం సమాచారం స్పష్టంగా చదవదగినది."
            java.lang.String r3 = "వెనుక వైపు"
            r0.<init>(r1, r2, r3)
            goto L_0x00d2
        L_0x0043:
            java.lang.String r1 = "ta"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x004d
            goto L_0x00bb
        L_0x004d:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "உங்கள் ஆதாரின் பின் பக்கம்"
            java.lang.String r2 = "லைட்டிங் நன்றாக இருப்பதையும், ஆவணத்தில் கண்ணை கூசும் காட்சிகள் இல்லை என்பதையும் உறுதிப்படுத்திக் கொள்ளுங்கள்."
            r0.<init>(r1, r2, r3)
            goto L_0x00d2
        L_0x0058:
            java.lang.String r1 = "mr"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0061
            goto L_0x00bb
        L_0x0061:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "आपल्या आधारची मागील बाजू"
            java.lang.String r2 = "खात्री करा की प्रकाशयोजना चांगली आहे आणि डॉक्युमेंटवर कोणतीही चमक नाही. सर्व माहिती स्पष्टपणे वाचण्यायोग्य आहे."
            java.lang.String r3 = "मागील बाजू"
            r0.<init>(r1, r2, r3)
            goto L_0x00d2
        L_0x006d:
            java.lang.String r1 = "hn"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x007f
            goto L_0x00bb
        L_0x0076:
            java.lang.String r1 = "hi"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x007f
            goto L_0x00bb
        L_0x007f:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "आपके आधार के पीछे का हिस्‍सा"
            java.lang.String r2 = "सुनिश्चित करें कि लाइटिंग अच्छी है और दस्तावेज़ पर कोई चमक नहीं हैं। सभी जानकारी स्पष्ट रूप से पठनीय है।"
            java.lang.String r3 = "पीछे का हिस्‍सा"
            r0.<init>(r1, r2, r3)
            goto L_0x00d2
        L_0x008b:
            java.lang.String r1 = "gu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0094
            goto L_0x00bb
        L_0x0094:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "તમારા આધારની પાછળની બાજુ"
            java.lang.String r2 = "ખાતરી કરો કે લાઈટિંગ સારી છે અને ડોક્યુમેન્ટ પર કોઈપણ વધારે પ્રકાશ નથી. બધી માહિતી સ્પષ્ટ રીતે વાંચી શકાય તેવી છે."
            java.lang.String r3 = "પાછળની બાજુ"
            r0.<init>(r1, r2, r3)
            goto L_0x00d2
        L_0x00a0:
            java.lang.String r1 = "en"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00a9
            goto L_0x00bb
        L_0x00a9:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "BACK side of your Aadhaar"
            java.lang.String r2 = "Make sure lighting is good and there are no glares on the document. \n All information is clearly readable."
            r0.<init>(r1, r2, r3)
            goto L_0x00d2
        L_0x00b3:
            java.lang.String r1 = "bn"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c7
        L_0x00bb:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 7
            r6 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x00d2
        L_0x00c7:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "আপনার আধারের পিছনের দিক"
            java.lang.String r2 = "নিশ্চিত করুন যে লাইটিং ভাল আছে এবং ডকুমেন্টে কোনও গ্লেয়ার নেই। সমস্ত তথ্য স্পষ্টভাবে পঠনযোগ্য।"
            java.lang.String r3 = "পেছনের দিক"
            r0.<init>(r1, r2, r3)
        L_0x00d2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.imagepicker.HyperVergeKycCapture.getAadhaarBackStrings():com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        if (r0.equals(HN) == false) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007c, code lost:
        if (r0.equals(HI) == false) goto L_0x00bb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.mpl.androidapp.imagepicker.HyperVergeKycCapture.DocCaptureStrings getAadhaarFrontStrings() {
        /*
            r7 = this;
            java.lang.String r0 = r7.getCurrentLanguage()
            int r1 = r0.hashCode()
            r2 = 3148(0xc4c, float:4.411E-42)
            if (r1 == r2) goto L_0x00b3
            r2 = 3241(0xca9, float:4.542E-42)
            java.lang.String r3 = "Front Side"
            if (r1 == r2) goto L_0x00a0
            r2 = 3310(0xcee, float:4.638E-42)
            if (r1 == r2) goto L_0x008b
            r2 = 3329(0xd01, float:4.665E-42)
            if (r1 == r2) goto L_0x0076
            r2 = 3334(0xd06, float:4.672E-42)
            if (r1 == r2) goto L_0x006d
            r2 = 3493(0xda5, float:4.895E-42)
            if (r1 == r2) goto L_0x0058
            r2 = 3693(0xe6d, float:5.175E-42)
            if (r1 == r2) goto L_0x0043
            r2 = 3697(0xe71, float:5.18E-42)
            if (r1 == r2) goto L_0x002c
            goto L_0x00bb
        L_0x002c:
            java.lang.String r1 = "te"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0036
            goto L_0x00bb
        L_0x0036:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "మీ ఆధార్ ముందు వైపు"
            java.lang.String r2 = "లైటింగ్ బాగుందని మరియు డాక్యుమెంట్‌ మీద ఎలాంటి మెరుపులు లేవని నిర్ధారించుకోండి. పేరు, ID నంబర్ మరియు DOB స్పష్టంగా కనిపించాలి."
            java.lang.String r3 = "ముందు వైపు"
            r0.<init>(r1, r2, r3)
            goto L_0x00d2
        L_0x0043:
            java.lang.String r1 = "ta"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x004d
            goto L_0x00bb
        L_0x004d:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "உங்கள் ஆதாரின் முன் பக்கம்"
            java.lang.String r2 = "லைட்டிங் நன்றாக இருப்பதையும், ஆவணத்தில் கண்ணை கூசும் காட்சிகள் இல்லை என்பதையும் உறுதிப்படுத்திக் கொள்ளுங்கள். பெயர், ID எண் மற்றும் DOB தெளிவாகத் தெரிய வேண்டும்."
            r0.<init>(r1, r2, r3)
            goto L_0x00d2
        L_0x0058:
            java.lang.String r1 = "mr"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0061
            goto L_0x00bb
        L_0x0061:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "आपल्या आधारची पुढील बाजू"
            java.lang.String r2 = "खात्री करा की प्रकाशयोजना चांगली आहे आणि डॉक्युमेंटवर कोणतीही चमक नाही. नाव, ID क्रमांक आणि DOB स्पष्टपणे दिसण्यायोग्य असायला पाहिजे."
            java.lang.String r3 = "पुढील बाजू"
            r0.<init>(r1, r2, r3)
            goto L_0x00d2
        L_0x006d:
            java.lang.String r1 = "hn"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x007f
            goto L_0x00bb
        L_0x0076:
            java.lang.String r1 = "hi"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x007f
            goto L_0x00bb
        L_0x007f:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "आपके आधार के सामने का हिस्‍सा"
            java.lang.String r2 = "सुनिश्चित करें कि लाइटिंग अच्छी है और दस्तावेज़ पर कोई चमक नहीं हैं।  नाम, ID नंबर और DOB स्पष्ट दिखने चाहिए।"
            java.lang.String r3 = "सामने का हिस्‍सा"
            r0.<init>(r1, r2, r3)
            goto L_0x00d2
        L_0x008b:
            java.lang.String r1 = "gu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0094
            goto L_0x00bb
        L_0x0094:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "તમારા આધારની આગળની બાજુ"
            java.lang.String r2 = "ખાતરી કરો કે લાઈટિંગ સારી છે અને ડોક્યુમેન્ટ પર કોઈપણ વધારે પ્રકાશ નથી.  નામ, ID નંબર અને DOB સ્પષ્ટ રીતે દેખાવા જોઈએ."
            java.lang.String r3 = "આગળની બાજુ"
            r0.<init>(r1, r2, r3)
            goto L_0x00d2
        L_0x00a0:
            java.lang.String r1 = "en"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00a9
            goto L_0x00bb
        L_0x00a9:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "FRONT side of your Aadhaar"
            java.lang.String r2 = "Make sure lighting is good and there are no glares on the document.\n Name, ID number and DOB should be clearly visible."
            r0.<init>(r1, r2, r3)
            goto L_0x00d2
        L_0x00b3:
            java.lang.String r1 = "bn"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c7
        L_0x00bb:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 7
            r6 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x00d2
        L_0x00c7:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "আপনার আধারের সামনের দিক"
            java.lang.String r2 = "নিশ্চিত করুন যে ভালো লাইটিং আছে এবং ডকুমেন্টে কোনো গ্লেয়ার নেই। নাম, ID নম্বর এবং DOB স্পষ্টভাবে দৃশ্যমান হওয়া উচিত।"
            java.lang.String r3 = "সামনের দিক"
            r0.<init>(r1, r2, r3)
        L_0x00d2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.imagepicker.HyperVergeKycCapture.getAadhaarFrontStrings():com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings");
    }

    private final String getCurrentLanguage() {
        String language = LocaleHelper.getLanguage(this.activity.getApplicationContext());
        return language == null ? EN : language;
    }

    private final DocCaptureStrings getDocCaptureStrings() {
        String str = this.docType;
        int hashCode = str.hashCode();
        if (hashCode != -1193923208) {
            if (hashCode != 78973) {
                if (hashCode == 1647298456 && str.equals(DOC_TYPE_AADHAAR_FRONT)) {
                    return getAadhaarFrontStrings();
                }
            } else if (str.equals(DOC_TYPE_PAN)) {
                return getPanStrings();
            }
        } else if (str.equals(DOC_TYPE_AADHAAR_BACK)) {
            return getAadhaarBackStrings();
        }
        DocCaptureStrings docCaptureStrings = new DocCaptureStrings(null, null, null, 7, null);
        return docCaptureStrings;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        if (r0.equals(HN) == false) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007c, code lost:
        if (r0.equals(HI) == false) goto L_0x00bb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.mpl.androidapp.imagepicker.HyperVergeKycCapture.DocCaptureStrings getPanStrings() {
        /*
            r7 = this;
            java.lang.String r0 = r7.getCurrentLanguage()
            int r1 = r0.hashCode()
            r2 = 3148(0xc4c, float:4.411E-42)
            if (r1 == r2) goto L_0x00b3
            r2 = 3241(0xca9, float:4.542E-42)
            java.lang.String r3 = "Front Side"
            if (r1 == r2) goto L_0x00a0
            r2 = 3310(0xcee, float:4.638E-42)
            if (r1 == r2) goto L_0x008b
            r2 = 3329(0xd01, float:4.665E-42)
            if (r1 == r2) goto L_0x0076
            r2 = 3334(0xd06, float:4.672E-42)
            if (r1 == r2) goto L_0x006d
            r2 = 3493(0xda5, float:4.895E-42)
            if (r1 == r2) goto L_0x0058
            r2 = 3693(0xe6d, float:5.175E-42)
            if (r1 == r2) goto L_0x0043
            r2 = 3697(0xe71, float:5.18E-42)
            if (r1 == r2) goto L_0x002c
            goto L_0x00bb
        L_0x002c:
            java.lang.String r1 = "te"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0036
            goto L_0x00bb
        L_0x0036:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "మీ పాన్ ముందు వైపు"
            java.lang.String r2 = "లైటింగ్ బాగుందని మరియు డాక్యుమెంట్‌ మీద ఎలాంటి మెరుపులు లేవని నిర్ధారించుకోండి. పేరు, ID నంబర్ మరియు DOB స్పష్టంగా కనిపించాలి."
            java.lang.String r3 = "ముందు వైపు"
            r0.<init>(r1, r2, r3)
            goto L_0x00d2
        L_0x0043:
            java.lang.String r1 = "ta"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x004d
            goto L_0x00bb
        L_0x004d:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "உங்கள் பானின் முன் பக்கம்"
            java.lang.String r2 = "லைட்டிங் நன்றாக இருப்பதையும், ஆவணத்தில் கண்ணை கூசும் காட்சிகள் இல்லை என்பதையும் உறுதிப்படுத்திக் கொள்ளுங்கள். பெயர், ID எண் மற்றும் DOB தெளிவாகத் தெரிய வேண்டும்."
            r0.<init>(r1, r2, r3)
            goto L_0x00d2
        L_0x0058:
            java.lang.String r1 = "mr"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0061
            goto L_0x00bb
        L_0x0061:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "आपल्या पॅनची पुढील बाजू"
            java.lang.String r2 = "खात्री करा की प्रकाशयोजना चांगली आहे आणि डॉक्युमेंटवर कोणतीही चमक नाही. नाव, ID क्रमांक आणि DOB स्पष्टपणे दिसण्यायोग्य असायला पाहिजे."
            java.lang.String r3 = "पुढील बाजू"
            r0.<init>(r1, r2, r3)
            goto L_0x00d2
        L_0x006d:
            java.lang.String r1 = "hn"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x007f
            goto L_0x00bb
        L_0x0076:
            java.lang.String r1 = "hi"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x007f
            goto L_0x00bb
        L_0x007f:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "पैन के सामने का हिस्‍सा"
            java.lang.String r2 = "सुनिश्चित करें कि लाइटिंग अच्छी है और दस्तावेज़ पर कोई चमक नहीं हैं।  नाम, ID नंबर और DOB स्पष्ट दिखने चाहिए।"
            java.lang.String r3 = "सामने का हिस्‍सा"
            r0.<init>(r1, r2, r3)
            goto L_0x00d2
        L_0x008b:
            java.lang.String r1 = "gu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0094
            goto L_0x00bb
        L_0x0094:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "તમારા પાનની આગળની બાજુ"
            java.lang.String r2 = "ખાતરી કરો કે લાઈટિંગ સારી છે અને ડોક્યુમેન્ટ પર કોઈપણ વધારે પ્રકાશ નથી.  નામ, ID નંબર અને DOB સ્પષ્ટ રીતે દેખાવા જોઈએ."
            java.lang.String r3 = "આગળની બાજુ"
            r0.<init>(r1, r2, r3)
            goto L_0x00d2
        L_0x00a0:
            java.lang.String r1 = "en"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00a9
            goto L_0x00bb
        L_0x00a9:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "FRONT side of your PAN"
            java.lang.String r2 = "Make sure lighting is good and there are no glares on the document.\n Name, ID number and DOB should be clearly visible."
            r0.<init>(r1, r2, r3)
            goto L_0x00d2
        L_0x00b3:
            java.lang.String r1 = "bn"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c7
        L_0x00bb:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 7
            r6 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x00d2
        L_0x00c7:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings
            java.lang.String r1 = "আপনার প্যানের সামনের দিক"
            java.lang.String r2 = "নিশ্চিত করুন যে ভালো লাইটিং আছে এবং ডকুমেন্টে কোনো গ্লেয়ার নেই। নাম, ID নম্বর এবং DOB স্পষ্টভাবে দৃশ্যমান হওয়া উচিত।"
            java.lang.String r3 = "সামনের দিক"
            r0.<init>(r1, r2, r3)
        L_0x00d2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.imagepicker.HyperVergeKycCapture.getPanStrings():com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings");
    }

    /* access modifiers changed from: private */
    public final void sendFailStatus(IdCaptureListener idCaptureListener, String str, int i) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", GopayLinkingHandler.STATUS_FAIL);
        jSONObject.put("reason", str);
        jSONObject.put("code", i);
        if (idCaptureListener != null) {
            idCaptureListener.onIdCaptureFail(jSONObject.toString());
        }
    }

    /* access modifiers changed from: private */
    public final void sendSuccessStatus(IdCaptureListener idCaptureListener, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", "SUCCESS");
        jSONObject.put("path", str);
        if (str2 == null) {
            str2 = "0";
        }
        jSONObject.put(Response.SIZE, str2);
        if (idCaptureListener != null) {
            idCaptureListener.onIdCaptureFail(jSONObject.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void captureIds(java.lang.String r13, com.mpl.androidapp.imagepicker.IdCaptureListener r14) {
        /*
            r12 = this;
            co.hyperverge.hypersnapsdk.HyperSnapSDK r13 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()
            boolean r13 = r13.f2949f
            r0 = 0
            if (r13 != 0) goto L_0x039a
            android.app.Activity r13 = r12.activity
            android.content.Context r13 = r13.getApplicationContext()
            java.lang.String r1 = r12.appId
            java.lang.String r2 = r12.appKey
            co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region r3 = co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region.India
            co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Product r4 = co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Product.FACEID
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r5 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            r5.setAppId(r1)
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r1 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            r1.setAppKey(r2)
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r1 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            r1.setHyperSnapRegion(r3)
            co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region r1 = co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region.India
            if (r3 != r1) goto L_0x0032
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r1 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region r2 = co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region.INDIA
            r1.setHyperSnapRegion(r2)
            goto L_0x003d
        L_0x0032:
            co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region r1 = co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region.AsiaPacific
            if (r3 != r1) goto L_0x003d
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r1 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region r2 = co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region.ASIA_PACIFIC
            r1.setHyperSnapRegion(r2)
        L_0x003d:
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r1 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            r1.setHyperSnapProduct(r4)
            r1 = 0
            boolean r2 = co.hyperverge.hypersnapsdk.c.k.a(r1)
            if (r2 != 0) goto L_0x004e
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r2 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            r2.setAccessToken(r1)
        L_0x004e:
            co.hyperverge.hypersnapsdk.HyperSnapSDK r2 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r3 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            if (r2 == 0) goto L_0x0399
            okhttp3.Cache r4 = new okhttp3.Cache
            android.content.Context r5 = r13.getApplicationContext()
            java.io.File r5 = r5.getCacheDir()
            r6 = 5242880(0x500000, double:2.590327E-317)
            r4.<init>(r5, r6)
            co.hyperverge.hypersnapsdk.HyperSnapSDK.f2948e = r4
            co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b = r3
            r2.g = r1
            r4 = 6
            r5 = 1
            if (r3 != 0) goto L_0x0076
            java.lang.String r6 = "HyperSnapSDKConfig object should not be null"
            r2.a(r6, r4)
            goto L_0x00cd
        L_0x0076:
            java.lang.String r6 = r3.getAppId()
            boolean r6 = co.hyperverge.hypersnapsdk.c.k.a(r6)
            if (r6 == 0) goto L_0x0086
            java.lang.String r6 = "appId is compulsory"
            r2.a(r6, r4)
            goto L_0x00cd
        L_0x0086:
            java.lang.String r6 = r3.getAppKey()
            boolean r6 = co.hyperverge.hypersnapsdk.c.k.a(r6)
            java.lang.String r7 = r3.getAccessToken()
            boolean r7 = co.hyperverge.hypersnapsdk.c.k.a(r7)
            if (r6 == 0) goto L_0x00a0
            if (r7 == 0) goto L_0x00a0
            java.lang.String r6 = "Either appKey or accessToken are empty/null; Set either of them"
            r2.a(r6, r4)
            goto L_0x00cd
        L_0x00a0:
            if (r6 != 0) goto L_0x00aa
            if (r7 != 0) goto L_0x00aa
            java.lang.String r6 = "Set either appKey or appId, not both"
            r2.a(r6, r4)
            goto L_0x00cd
        L_0x00aa:
            boolean r4 = r3.isShouldUseLocation()
            if (r4 == 0) goto L_0x00cf
            java.lang.String r4 = "android.permission.ACCESS_FINE_LOCATION"
            int r4 = androidx.core.content.ContextCompat.checkSelfPermission(r13, r4)
            java.lang.String r6 = "android.permission.ACCESS_COARSE_LOCATION"
            int r6 = androidx.core.content.ContextCompat.checkSelfPermission(r13, r6)
            if (r4 == 0) goto L_0x00c3
            if (r6 != 0) goto L_0x00c1
            goto L_0x00c3
        L_0x00c1:
            r4 = 0
            goto L_0x00c4
        L_0x00c3:
            r4 = 1
        L_0x00c4:
            if (r4 != 0) goto L_0x00cf
            r4 = 8
            java.lang.String r6 = "Location permission not available while location config is set to true"
            r2.a(r6, r4)
        L_0x00cd:
            r4 = 0
            goto L_0x00d0
        L_0x00cf:
            r4 = 1
        L_0x00d0:
            if (r4 == 0) goto L_0x038d
            co.hyperverge.hypersnapsdk.c.n r4 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.c.n r6 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r7 = r6.i
            if (r7 != 0) goto L_0x00e5
            co.hyperverge.hypersnapsdk.service.a.a r7 = new co.hyperverge.hypersnapsdk.service.a.a
            r7.<init>(r13)
            r6.i = r7
        L_0x00e5:
            co.hyperverge.hypersnapsdk.service.a.b r6 = r6.i
            r4.i = r6
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r4 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.lang.String r7 = r4.getAppId()
            java.lang.String r8 = "hv_app_id"
            r6.put(r8, r7)
            java.lang.String r7 = "hv_hs_sdk_version"
            java.lang.String r8 = "3.6.38"
            r6.put(r7, r8)
            co.hyperverge.hypersnapsdk.objects.HyperKYCConfigs r4 = r4.getHyperKYCConfigs()
            if (r4 == 0) goto L_0x0126
            java.util.HashMap r4 = r4.getHyperKYCValueMap()
            java.util.Collection r7 = r4.values()
            java.util.Iterator r7 = r7.iterator()
        L_0x0112:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0126
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r4.get(r8)
            r6.put(r8, r9)
            goto L_0x0112
        L_0x0126:
            boolean r4 = co.hyperverge.hypersnapsdk.f.i.d(r13)
            if (r4 == 0) goto L_0x018e
            co.hyperverge.crashguard.CrashGuard r4 = co.hyperverge.crashguard.CrashGuard.getInstance(r13)     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r7 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            co.hyperverge.hypersnapsdk.objects.HyperKYCConfigs r7 = r7.getHyperKYCConfigs()     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            if (r7 == 0) goto L_0x0147
            java.lang.String r8 = r7.getSentryEndPoint()     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            if (r8 != 0) goto L_0x0147
            java.lang.String r7 = r7.getSentryEndPoint()     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            goto L_0x0149
        L_0x0147:
            java.lang.String r7 = "https://5f0c7fd2678f44beba342ffbd306984e@o435277.ingest.sentry.io/api/6019750/store/"
        L_0x0149:
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r8 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            co.hyperverge.hypersnapsdk.objects.HyperKYCConfigs r8 = r8.getHyperKYCConfigs()     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            if (r8 == 0) goto L_0x0160
            java.lang.String r9 = r8.getSentryKey()     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            if (r9 != 0) goto L_0x0160
            java.lang.String r8 = r8.getSentryKey()     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            goto L_0x0162
        L_0x0160:
            java.lang.String r8 = "5f0c7fd2678f44beba342ffbd306984e"
        L_0x0162:
            co.hyperverge.crashguard.CrashGuard$Config r9 = new co.hyperverge.crashguard.CrashGuard$Config     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r10 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            co.hyperverge.hypersnapsdk.objects.HyperKYCConfigs r10 = r10.getHyperKYCConfigs()     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            if (r10 == 0) goto L_0x017b
            java.lang.String r11 = r10.getSentryFilter()     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            if (r11 != 0) goto L_0x017b
            java.lang.String r10 = r10.getSentryFilter()     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            goto L_0x017d
        L_0x017b:
            java.lang.String r10 = "co.hyperverge"
        L_0x017d:
            java.util.List r10 = java.util.Collections.singletonList(r10)     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            r9.<init>(r10, r6)     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            r4.init(r7, r8, r9)     // Catch:{ Exception -> 0x018a, NoClassDefFoundError -> 0x0188 }
            goto L_0x018e
        L_0x0188:
            r4 = move-exception
            goto L_0x018b
        L_0x018a:
            r4 = move-exception
        L_0x018b:
            co.hyperverge.hypersnapsdk.f.i.a(r4)
        L_0x018e:
            co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region r4 = r3.getHyperSnapRegion()
            co.hyperverge.hypersnapsdk.c.n r6 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ NameNotFoundException -> 0x01a7 }
            android.content.pm.PackageManager r7 = r13.getPackageManager()     // Catch:{ NameNotFoundException -> 0x01a7 }
            java.lang.String r8 = r13.getPackageName()     // Catch:{ NameNotFoundException -> 0x01a7 }
            android.content.pm.PackageInfo r7 = r7.getPackageInfo(r8, r0)     // Catch:{ NameNotFoundException -> 0x01a7 }
            java.lang.String r7 = r7.versionName     // Catch:{ NameNotFoundException -> 0x01a7 }
            r6.f3128b = r7     // Catch:{ NameNotFoundException -> 0x01a7 }
            goto L_0x01bf
        L_0x01a7:
            r6 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r6)
            co.hyperverge.hypersnapsdk.c.n r7 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r8 = r7.i
            if (r8 != 0) goto L_0x01ba
            co.hyperverge.hypersnapsdk.service.a.a r8 = new co.hyperverge.hypersnapsdk.service.a.a
            r8.<init>(r13)
            r7.i = r8
        L_0x01ba:
            co.hyperverge.hypersnapsdk.service.a.b r7 = r7.i
            r7.a(r6)
        L_0x01bf:
            co.hyperverge.hypersnapsdk.c.n r6 = co.hyperverge.hypersnapsdk.c.n.m()
            r13.getPackageName()
            if (r6 == 0) goto L_0x038c
            co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region r6 = co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region.INDIA
            if (r4 != r6) goto L_0x01dc
            co.hyperverge.hypersnapsdk.c.n r4 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.c.n r6 = co.hyperverge.hypersnapsdk.c.n.m()
            if (r6 == 0) goto L_0x01db
            java.lang.String r6 = "https://ind-faceid.hyperverge.co/v1/"
            r4.h = r6
            goto L_0x0210
        L_0x01db:
            throw r1
        L_0x01dc:
            co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region r6 = co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region.ASIA_PACIFIC
            java.lang.String r7 = "https://apac-faceid.hyperverge.co/v2/"
            if (r4 != r6) goto L_0x01f0
            co.hyperverge.hypersnapsdk.c.n r4 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.c.n r6 = co.hyperverge.hypersnapsdk.c.n.m()
            if (r6 == 0) goto L_0x01ef
            r4.h = r7
            goto L_0x0210
        L_0x01ef:
            throw r1
        L_0x01f0:
            co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region r6 = co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region.AFRICA
            if (r4 != r6) goto L_0x0204
            co.hyperverge.hypersnapsdk.c.n r4 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.c.n r6 = co.hyperverge.hypersnapsdk.c.n.m()
            if (r6 == 0) goto L_0x0203
            java.lang.String r6 = "https://zaf-face.hyperverge.co/v2/"
            r4.h = r6
            goto L_0x0210
        L_0x0203:
            throw r1
        L_0x0204:
            co.hyperverge.hypersnapsdk.c.n r4 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.c.n r6 = co.hyperverge.hypersnapsdk.c.n.m()
            if (r6 == 0) goto L_0x038b
            r4.h = r7
        L_0x0210:
            java.lang.String r4 = "HyperSnapSP"
            android.content.SharedPreferences r4 = r13.getSharedPreferences(r4, r0)
            co.hyperverge.hypersnapsdk.c.o.f3131b = r4
            android.content.SharedPreferences$Editor r4 = r4.edit()
            co.hyperverge.hypersnapsdk.c.o.f3132c = r4
            boolean r4 = r3.isShouldUseRemoteConfig()
            if (r4 == 0) goto L_0x025a
            okhttp3.Cache r4 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2948e
            co.hyperverge.hypersnapsdk.b.g.c r6 = co.hyperverge.hypersnapsdk.b.g.c.f3040b
            if (r6 != 0) goto L_0x0231
            co.hyperverge.hypersnapsdk.b.g.c r6 = new co.hyperverge.hypersnapsdk.b.g.c
            r6.<init>(r4)
            co.hyperverge.hypersnapsdk.b.g.c.f3040b = r6
        L_0x0231:
            co.hyperverge.hypersnapsdk.b.g.c r4 = co.hyperverge.hypersnapsdk.b.g.c.f3040b
            java.lang.String r6 = r3.getAppId()
            co.hyperverge.hypersnapsdk.HyperSnapSDK$c r7 = new co.hyperverge.hypersnapsdk.HyperSnapSDK$c
            r7.<init>()
            if (r4 == 0) goto L_0x0259
            java.lang.String r8 = "https://s3-ap-south-1.amazonaws.com/hv-central-config/sdk-client-config/hypersnapsdk/v1/"
            java.lang.String r9 = ".json"
            java.lang.String r6 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r8, r6, r9)
            okhttp3.Cache r8 = r4.f3043e
            co.hyperverge.hypersnapsdk.b.g.d r8 = co.hyperverge.hypersnapsdk.b.g.a.a(r8)
            retrofit2.Call r6 = r8.b(r6)
            co.hyperverge.hypersnapsdk.b.g.c$a r8 = new co.hyperverge.hypersnapsdk.b.g.c$a
            r8.<init>(r0, r7)
            r6.enqueue(r8)
            goto L_0x0264
        L_0x0259:
            throw r1
        L_0x025a:
            co.hyperverge.hypersnapsdk.c.n r4 = co.hyperverge.hypersnapsdk.c.n.m()
            r4.a()
            r2.c()
        L_0x0264:
            boolean r4 = r2.f2949f
            if (r4 != 0) goto L_0x02b7
            android.content.Context r4 = r13.getApplicationContext()     // Catch:{ NoClassDefFoundError -> 0x0299, MissingLibraryException -> 0x0279, UnsatisfiedLinkError -> 0x0277 }
            r6 = 2
            co.hyperverge.facedetection.FaceDetectorApi.initialize(r4, r6)     // Catch:{ NoClassDefFoundError -> 0x0299, MissingLibraryException -> 0x0279, UnsatisfiedLinkError -> 0x0277 }
            co.hyperverge.hypersnapsdk.c.n r4 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ NoClassDefFoundError -> 0x0299, MissingLibraryException -> 0x0279, UnsatisfiedLinkError -> 0x0277 }
            r4.f3129d = r5     // Catch:{ NoClassDefFoundError -> 0x0299, MissingLibraryException -> 0x0279, UnsatisfiedLinkError -> 0x0277 }
            goto L_0x02b7
        L_0x0277:
            r4 = move-exception
            goto L_0x027a
        L_0x0279:
            r4 = move-exception
        L_0x027a:
            co.hyperverge.hypersnapsdk.f.i.a(r4)
            co.hyperverge.hypersnapsdk.c.n r6 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r7 = r6.i
            if (r7 != 0) goto L_0x028c
            co.hyperverge.hypersnapsdk.service.a.a r7 = new co.hyperverge.hypersnapsdk.service.a.a
            r7.<init>(r13)
            r6.i = r7
        L_0x028c:
            co.hyperverge.hypersnapsdk.service.a.b r6 = r6.i
            r6.a(r4)
            co.hyperverge.hypersnapsdk.c.n r4 = co.hyperverge.hypersnapsdk.c.n.m()
            if (r4 == 0) goto L_0x0298
            goto L_0x02b7
        L_0x0298:
            throw r1
        L_0x0299:
            r4 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r4)
            co.hyperverge.hypersnapsdk.c.n r6 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r7 = r6.i
            if (r7 != 0) goto L_0x02ac
            co.hyperverge.hypersnapsdk.service.a.a r7 = new co.hyperverge.hypersnapsdk.service.a.a
            r7.<init>(r13)
            r6.i = r7
        L_0x02ac:
            co.hyperverge.hypersnapsdk.service.a.b r6 = r6.i
            r6.a(r4)
            co.hyperverge.hypersnapsdk.c.n r4 = co.hyperverge.hypersnapsdk.c.n.m()
            r4.f3129d = r0
        L_0x02b7:
            boolean r3 = r3.isShouldActivateDeviceBlocklist()
            if (r3 == 0) goto L_0x02da
            co.hyperverge.hypersnapsdk.c.a r3 = co.hyperverge.hypersnapsdk.c.a.f3061b
            if (r3 != 0) goto L_0x02c8
            co.hyperverge.hypersnapsdk.c.a r3 = new co.hyperverge.hypersnapsdk.c.a
            r3.<init>()
            co.hyperverge.hypersnapsdk.c.a.f3061b = r3
        L_0x02c8:
            co.hyperverge.hypersnapsdk.c.a r3 = co.hyperverge.hypersnapsdk.c.a.f3061b
            java.lang.String r4 = r3.f3063d
            if (r4 != 0) goto L_0x02da
            co.hyperverge.hypersnapsdk.f.j.b r4 = r3.f3062c
            co.hyperverge.hypersnapsdk.c.a$a r6 = new co.hyperverge.hypersnapsdk.c.a$a
            r6.<init>(r13)
            java.util.concurrent.ThreadPoolExecutor r3 = r4.f3189d
            r3.submit(r6)
        L_0x02da:
            co.hyperverge.hypersnapsdk.c.k.a(r13)
            android.content.SharedPreferences r3 = co.hyperverge.hypersnapsdk.c.o.f3131b
            java.lang.String r4 = "userRandomNumber"
            r6 = 1000(0x3e8, float:1.401E-42)
            int r3 = r3.getInt(r4, r6)
            if (r3 != r6) goto L_0x02fa
            r3 = 100
            int r3 = co.hyperverge.hypersnapsdk.f.i.b(r3)
            android.content.SharedPreferences$Editor r6 = co.hyperverge.hypersnapsdk.c.o.c()
            android.content.SharedPreferences$Editor r4 = r6.putInt(r4, r3)
            r4.apply()
        L_0x02fa:
            co.hyperverge.hypersnapsdk.c.n r4 = co.hyperverge.hypersnapsdk.c.n.m()
            r6 = 30
            if (r3 >= r6) goto L_0x0304
            r3 = 1
            goto L_0x0305
        L_0x0304:
            r3 = 0
        L_0x0305:
            r4.o = r3
            co.hyperverge.hypersnapsdk.c.n r3 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ Exception -> 0x0324, NoClassDefFoundError -> 0x0322 }
            boolean r3 = r3.o     // Catch:{ Exception -> 0x0324, NoClassDefFoundError -> 0x0322 }
            if (r3 == 0) goto L_0x0342
            co.hyperverge.hypersnapsdk.c.n r3 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ Exception -> 0x0324, NoClassDefFoundError -> 0x0322 }
            co.hyperverge.hypersnapsdk.a.a r4 = new co.hyperverge.hypersnapsdk.a.a     // Catch:{ Exception -> 0x0324, NoClassDefFoundError -> 0x0322 }
            r4.<init>(r13)     // Catch:{ Exception -> 0x0324, NoClassDefFoundError -> 0x0322 }
            r3.j = r4     // Catch:{ Exception -> 0x0324, NoClassDefFoundError -> 0x0322 }
            co.hyperverge.hypersnapsdk.c.n r3 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ Exception -> 0x0324, NoClassDefFoundError -> 0x0322 }
            if (r3 == 0) goto L_0x0321
            goto L_0x0342
        L_0x0321:
            throw r1     // Catch:{ Exception -> 0x0324, NoClassDefFoundError -> 0x0322 }
        L_0x0322:
            r3 = move-exception
            goto L_0x0325
        L_0x0324:
            r3 = move-exception
        L_0x0325:
            co.hyperverge.hypersnapsdk.f.i.a(r3)
            co.hyperverge.hypersnapsdk.c.n r4 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r6 = r4.i
            if (r6 != 0) goto L_0x0337
            co.hyperverge.hypersnapsdk.service.a.a r6 = new co.hyperverge.hypersnapsdk.service.a.a
            r6.<init>(r13)
            r4.i = r6
        L_0x0337:
            co.hyperverge.hypersnapsdk.service.a.b r4 = r4.i
            r4.a(r3)
            co.hyperverge.hypersnapsdk.c.n r3 = co.hyperverge.hypersnapsdk.c.n.m()
            if (r3 == 0) goto L_0x038a
        L_0x0342:
            co.hyperverge.hypersnapsdk.c.n r3 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.d.a r4 = new co.hyperverge.hypersnapsdk.service.d.a
            r4.<init>(r13)
            r3.l = r4
            r2.f2949f = r5
            co.hyperverge.hypersnapsdk.listeners.InitializerCallback r2 = r2.g
            if (r2 == 0) goto L_0x036d
            r2.onSuccess()
            co.hyperverge.hypersnapsdk.HyperSnapSDK r2 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()
            if (r2 == 0) goto L_0x036c
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r2 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            boolean r2 = r2.isShouldUseRemoteConfig()
            if (r2 == 0) goto L_0x036d
            co.hyperverge.hypersnapsdk.e.a r2 = co.hyperverge.hypersnapsdk.e.a.a()
            if (r2 == 0) goto L_0x036b
            goto L_0x036d
        L_0x036b:
            throw r1
        L_0x036c:
            throw r1
        L_0x036d:
            co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()
            boolean r1 = r1.o
            if (r1 == 0) goto L_0x038d
            co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.a.b r2 = r1.j
            if (r2 != 0) goto L_0x0384
            co.hyperverge.hypersnapsdk.a.a r2 = new co.hyperverge.hypersnapsdk.a.a
            r2.<init>(r13)
            r1.j = r2
        L_0x0384:
            co.hyperverge.hypersnapsdk.a.b r13 = r1.j
            r13.j()
            goto L_0x038d
        L_0x038a:
            throw r1
        L_0x038b:
            throw r1
        L_0x038c:
            throw r1
        L_0x038d:
            java.lang.Object[] r13 = new java.lang.Object[r5]
            java.lang.String r1 = "HyperSnapSdk initialised."
            r13[r0] = r1
            java.lang.String r1 = "KYC_ID_CAPTURE"
            com.mpl.androidapp.utils.MLogger.d(r1, r13)
            goto L_0x039a
        L_0x0399:
            throw r1
        L_0x039a:
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$captureIds$docCaptureCompletionHandler$1 r13 = new com.mpl.androidapp.imagepicker.HyperVergeKycCapture$captureIds$docCaptureCompletionHandler$1
            r13.<init>(r12, r14)
            co.hyperverge.hypersnapsdk.objects.HVDocConfig r14 = new co.hyperverge.hypersnapsdk.objects.HVDocConfig
            r14.<init>()
            r14.setShouldShowReviewScreen(r0)
            com.mpl.androidapp.imagepicker.HyperVergeKycCapture$DocCaptureStrings r0 = r12.getDocCaptureStrings()
            java.lang.String r1 = r0.getDocTitle()
            if (r1 != 0) goto L_0x03b2
            goto L_0x03b5
        L_0x03b2:
            r14.setDocCaptureTitle(r1)
        L_0x03b5:
            java.lang.String r1 = r0.getDocDescription()
            if (r1 != 0) goto L_0x03bc
            goto L_0x03bf
        L_0x03bc:
            r14.setDocCaptureDescription(r1)
        L_0x03bf:
            java.lang.String r0 = r0.getDocSubtext()
            if (r0 != 0) goto L_0x03c6
            goto L_0x03c9
        L_0x03c6:
            r14.setDocCaptureSubText(r0)
        L_0x03c9:
            android.app.Activity r0 = r12.activity
            co.hyperverge.hypersnapsdk.activities.HVDocsActivity.start(r0, r14, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.imagepicker.HyperVergeKycCapture.captureIds(java.lang.String, com.mpl.androidapp.imagepicker.IdCaptureListener):void");
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final String getAppId() {
        return this.appId;
    }
}

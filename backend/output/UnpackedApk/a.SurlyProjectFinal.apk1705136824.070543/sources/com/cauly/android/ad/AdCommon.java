package com.cauly.android.ad;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import com.inmobi.androidsdk.impl.Constants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AdCommon {
    static final String AD_CONFIG_ADDRESS = "xconf.cauly.co.kr";
    static final String AD_CONFIG_PAGE = "caulyXconf";
    static final String AD_CONFIG_PORT = "5220";
    static final String AD_CSI_ADDRESS = "csi.cauly.co.kr";
    static final String AD_CSI_PAGE = "csi";
    static final String AD_CSI_PORT = "1109";
    static final String AD_SERVER_ADDRESS = "ad.cauly.co.kr";
    static final int AD_SERVER_CONNECT_TIMEOUT = 10000;
    static final String AD_SERVER_PAGE = "caulyImpress";
    static final String AD_SERVER_PORT = "11000";
    static final int AD_SERVER_READ_TIMEOUT = 10000;
    static final String A_CH = "vItZm";
    static final String A_SP = "@#_";
    static final String AdCompanyName = "Ads By Cauly";
    static final String CLICK_SERVER_ADDRESS = "click.cauly.co.kr";
    static final int CLICK_SERVER_CONNECT_TIMEOUT = 5000;
    static final String CLICK_SERVER_PAGE = "caulyClick";
    static final String CLICK_SERVER_PORT = "15000";
    static final int CLICK_SERVER_READ_TIMEOUT = 5000;
    static final String CaulyNameTag = "Cauly Ads";
    static final int Clear = 0;
    static final String Debug = (String.valueOf(A_SP.substring(2, 3)) + A_CH.substring(2, 4));
    static final String Error = (String.valueOf(A_SP.substring(0, 1)) + A_CH.substring(4, 5) + 7 + A_CH.substring(0, 2) + 55 + 0 + A_SP.substring(1, 2));
    static final int LAYOUT_HEIGHT = 48;
    static String LIMIT_CPM = "0";
    static String LIMIT_XCONF = "0";
    static final String PLATFORM = "Android";
    static final String REAL_IMPRESS_LOG_SERVER_ADDRESS = "ad.cauly.co.kr";
    static final String REAL_IMPRESS_LOG_SERVER_PAGE = "CaulyImpressInform";
    static final String REAL_IMPRESS_LOG_SERVER_PORT = "11000";
    static int REQ_SEQ = 0;
    static int REU_SEQ = 0;
    static final String SDK_TYPE = "composite";
    static final String SDK_VERSION = "1.4.9";
    static final String SSL_AD_SERVER_ADDRESS = "ad.cauly.co.kr";
    static final String SSL_AD_SERVER_PAGE = "caulyImpress";
    static final String SSL_AD_SERVER_PORT = "11100";
    static final String SSL_CLICK_SERVER_ADDRESS = "click.cauly.co.kr";
    static final String SSL_CLICK_SERVER_PAGE = "caulyClick";
    static final String SSL_CLICK_SERVER_PORT = "15100";
    String adType;
    String age;
    String allowcall;
    String appCode;
    String gender;
    String gpsInfo;
    String lang;
    String manufacturer;
    String model;
    String network;
    String provider;
    String scode;
    String version;

    /* access modifiers changed from: 0000 */
    public void initCommon(String adType2, String appCode2, String gender2, String age2, String gpsInfo2, String scode2, String version2, String lang2, String provider2, String manufacturer2, String model2, String allowcall2, String network2) {
        this.adType = adType2;
        this.appCode = appCode2;
        this.gender = gender2;
        this.age = age2;
        this.gpsInfo = gpsInfo2;
        this.scode = scode2;
        this.version = version2;
        this.lang = lang2;
        this.provider = provider2;
        this.manufacturer = manufacturer2;
        this.model = model2;
        this.allowcall = allowcall2;
        this.network = network2;
    }

    static String urlEncoder(String _url) {
        String convert = null;
        try {
            return URLEncoder.encode(_url, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return convert;
        }
    }

    static String nullChk(String inval) {
        String resultStr;
        if (inval == null) {
            resultStr = Constants.QA_SERVER_URL;
        } else if (inval.equals("null")) {
            resultStr = Constants.QA_SERVER_URL;
        } else {
            resultStr = inval;
        }
        return resultStr.trim();
    }

    static String BackgroundImage(String color) {
        if ("black,blue,brown,gray,green,lblue,pink,purple,red".contains(color)) {
            return "a_" + color + ".png";
        }
        return "a_black.png";
    }

    static String Change_Icon(String type) {
        if (type.equalsIgnoreCase("app")) {
            return "btn_market.png";
        }
        if (type.equalsIgnoreCase("skt")) {
            return "btn_tstore.png";
        }
        if (type.equalsIgnoreCase("call")) {
            return "btn_call.png";
        }
        return "btn_site.png";
    }

    static int[] Change_Icon_Background(String color) {
        if (color.equalsIgnoreCase("blue")) {
            return new int[]{-12822882, -10648094};
        }
        if (color.equalsIgnoreCase("brown")) {
            return new int[]{-10599382, -7181499};
        }
        if (color.equalsIgnoreCase("gray")) {
            return new int[]{-8158333, -5131855};
        }
        if (color.equalsIgnoreCase("green")) {
            return new int[]{-10122995, -6107107};
        }
        if (color.equalsIgnoreCase("lblue")) {
            return new int[]{-14441540, -8925484};
        }
        if (color.equalsIgnoreCase("pink")) {
            return new int[]{-1544564, -416832};
        }
        if (color.equalsIgnoreCase("purple")) {
            return new int[]{-12238215, -9541193};
        }
        if (color.equalsIgnoreCase("red")) {
            return new int[]{-8060414, -3800574};
        }
        return new int[]{-16250872, -8684677};
    }

    static String byteArrayToHex(byte[] ba) {
        String hexNumber;
        if (ba == null || ba.length == 0) {
            return null;
        }
        StringBuffer sb = new StringBuffer(ba.length * 2);
        for (int x = 0; x < ba.length; x++) {
            sb.append(hexNumber.substring(("0" + Integer.toHexString(ba[x] & 255)).length() - 2));
        }
        return sb.toString();
    }

    static String makeKey(String keyStr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            if (keyStr.length() > i) {
                sb.append(keyStr.substring(i, i + 1));
            } else {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    static String encrypt(String message, String keyStr) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(makeKey(keyStr).getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, skeySpec);
        return byteArrayToHex(cipher.doFinal(message.getBytes()));
    }

    static void Impress_Info(String sdkType, String adsCd, String version2, String sdkVersion, String platform, String code, String model2, String scode2, String iserial, String retry, String retry_reason) {
        String tmp_url;
        String tmp_url2 = Constants.QA_SERVER_URL;
        if (!nullChk(sdkType).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url2 = String.valueOf(tmp_url2) + "sdk_type=" + sdkType;
        }
        if (!nullChk(adsCd).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url2 = String.valueOf(tmp_url2) + "ads_cd=" + adsCd;
        }
        if (!nullChk(version2).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url2 = String.valueOf(tmp_url2) + "version=" + version2;
        }
        if (!nullChk(sdkVersion).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url2 = String.valueOf(tmp_url2) + "sdk_version=" + sdkVersion;
        }
        if (!nullChk(platform).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url2 = String.valueOf(tmp_url2) + "platform=" + platform;
        }
        if (!nullChk(code).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url2 = String.valueOf(tmp_url2) + "code=" + code;
        }
        if (!nullChk(model2).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url2 = String.valueOf(tmp_url2) + "model=" + model2;
        }
        if (!nullChk(scode2).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url2 = String.valueOf(tmp_url2) + "scode=" + scode2;
        }
        if (!nullChk(iserial).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url = String.valueOf(tmp_url2) + "iserial=" + iserial;
        } else {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url = String.valueOf(tmp_url2) + "iserial=000000000000000000000000000000";
        }
        if (!nullChk(retry).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url.equals(Constants.QA_SERVER_URL)) {
                tmp_url = String.valueOf(tmp_url) + "&";
            }
            tmp_url = String.valueOf(tmp_url) + "retry=" + retry;
        }
        if (nullChk(retry).equals("Y") && !nullChk(retry_reason).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url.equals(Constants.QA_SERVER_URL)) {
                tmp_url = String.valueOf(tmp_url) + "&";
            }
            tmp_url = String.valueOf(tmp_url) + "retry_reason=" + retry_reason;
        }
        if (!tmp_url.equals(Constants.QA_SERVER_URL)) {
            tmp_url = String.valueOf(tmp_url) + "&";
        }
        connect("http://ad.cauly.co.kr:11000/CaulyImpressInform?" + (String.valueOf(tmp_url) + "visible=Y"));
    }

    static void AdNetwork_Info(String sdkType, String adsCd, String version2, String sdkVersion, String platform, String code, String model2, String scode2, String iserial, String adShape, String payType, String partner) {
        String tmp_url;
        String tmp_url2 = Constants.QA_SERVER_URL;
        if (!nullChk(sdkType).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url2 = String.valueOf(tmp_url2) + "sdk_type=" + sdkType;
        }
        if (!nullChk(adsCd).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url2 = String.valueOf(tmp_url2) + "ads_cd=" + adsCd;
        }
        if (!nullChk(version2).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url2 = String.valueOf(tmp_url2) + "version=" + version2;
        }
        if (!nullChk(sdkVersion).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url2 = String.valueOf(tmp_url2) + "sdk_version=" + sdkVersion;
        }
        if (!nullChk(platform).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url2 = String.valueOf(tmp_url2) + "platform=" + platform;
        }
        if (!nullChk(code).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url2 = String.valueOf(tmp_url2) + "code=" + code;
        }
        if (!nullChk(model2).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url2 = String.valueOf(tmp_url2) + "model=" + model2;
        }
        if (!nullChk(scode2).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url2 = String.valueOf(tmp_url2) + "scode=" + scode2;
        }
        if (!nullChk(iserial).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url = String.valueOf(tmp_url2) + "iserial=" + iserial;
        } else {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url = String.valueOf(tmp_url2) + "iserial=000000000000000000000000000000";
        }
        if (!nullChk(adShape).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url.equals(Constants.QA_SERVER_URL)) {
                tmp_url = String.valueOf(tmp_url) + "&";
            }
            tmp_url = String.valueOf(tmp_url) + "ad_shape=" + adShape;
        }
        if (!nullChk(payType).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url.equals(Constants.QA_SERVER_URL)) {
                tmp_url = String.valueOf(tmp_url) + "&";
            }
            tmp_url = String.valueOf(tmp_url) + "pay_type=" + payType;
        }
        if (!nullChk(partner).equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url.equals(Constants.QA_SERVER_URL)) {
                tmp_url = String.valueOf(tmp_url) + "&";
            }
            tmp_url = String.valueOf(tmp_url) + "partner=" + partner;
        }
        connect("http://ad.cauly.co.kr:11000/CaulyImpressInform?" + tmp_url);
    }

    static void Download_Info(String scode2, String appcode) {
        connect("http://downinfo.cauly.co.kr:1130/CCaulyAppDownInfo?action=stack_appdown_info&scode=" + scode2 + "&appid=" + appcode);
    }

    static void Ad_Log_Info(String platform, String iserial, String reason, boolean xconf) {
        String tmp_url;
        String tmp_url2 = Constants.QA_SERVER_URL;
        if (!platform.equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url2 = String.valueOf(tmp_url2) + "platform=" + platform;
        }
        if (xconf) {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url = String.valueOf(tmp_url2) + "xconf=Y";
        } else {
            if (!tmp_url2.equals(Constants.QA_SERVER_URL)) {
                tmp_url2 = String.valueOf(tmp_url2) + "&";
            }
            tmp_url = String.valueOf(tmp_url2) + "xconf=N";
        }
        if (!iserial.equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url.equals(Constants.QA_SERVER_URL)) {
                tmp_url = String.valueOf(tmp_url) + "&";
            }
            tmp_url = String.valueOf(tmp_url) + "iserial=" + iserial;
        }
        if (!reason.equals(Constants.QA_SERVER_URL)) {
            if (!tmp_url.equals(Constants.QA_SERVER_URL)) {
                tmp_url = String.valueOf(tmp_url) + "&";
            }
            tmp_url = String.valueOf(tmp_url) + "reason=" + reason;
        }
        connect("http://csi.cauly.co.kr:1109/csi?" + tmp_url);
    }

    static int connect(String clickurl) {
        try {
            URL url = new URL(clickurl);
            try {
                URLConnection conn = url.openConnection();
                conn.setConnectTimeout(3000);
                conn.setReadTimeout(3000);
                conn.connect();
                url.openStream().close();
            } catch (IOException e) {
            }
        } catch (MalformedURLException e2) {
        }
        return -1;
    }

    static String generateRandomCODE(int size) {
        int ID_SIZE = size;
        StringBuffer id = new StringBuffer();
        Random r = new Random(new Date().getTime());
        for (int x = 0; x < ID_SIZE; x++) {
            int index = r.nextInt(62);
            if (index < 10) {
                id.append((char) (index + LAYOUT_HEIGHT));
            } else if (10 > index || index >= 36) {
                id.append((char) ((index - 36) + 97));
            } else {
                id.append((char) ((index - 10) + 65));
            }
        }
        return id.toString();
    }

    static void alertError(String errorMessage) {
        Log.e(CaulyNameTag, errorMessage);
        throw new IllegalArgumentException(errorMessage);
    }

    static void recursiveRecycle(View root) {
        if (root != null) {
            root.setBackgroundDrawable(null);
            if (root instanceof ViewGroup) {
                unbindViewGroupReferences((ViewGroup) root);
            }
        }
    }

    static void unbindViewGroupReferences(ViewGroup viewGroup) {
        if (viewGroup != null) {
            int nrOfChildren = viewGroup.getChildCount();
            for (int i = 0; i < nrOfChildren; i++) {
                View view = viewGroup.getChildAt(i);
                unbindViewReferences(view);
                if (view instanceof ViewGroup) {
                    unbindViewGroupReferences((ViewGroup) view);
                }
            }
            try {
                viewGroup.removeAllViews();
            } catch (Throwable th) {
            }
        }
    }

    static void unbindViewReferences(View view) {
        if (view != null) {
            try {
                view.setOnClickListener(null);
            } catch (Throwable th) {
            }
            try {
                view.setOnCreateContextMenuListener(null);
            } catch (Throwable th2) {
            }
            try {
                view.setOnFocusChangeListener(null);
            } catch (Throwable th3) {
            }
            try {
                view.setOnKeyListener(null);
            } catch (Throwable th4) {
            }
            try {
                view.setOnLongClickListener(null);
            } catch (Throwable th5) {
            }
            try {
                view.setOnClickListener(null);
            } catch (Throwable th6) {
            }
            Drawable d = view.getBackground();
            if (d != null) {
                d.setCallback(null);
            }
            if (view instanceof ImageView) {
                ImageView imageView = (ImageView) view;
                Drawable d2 = imageView.getDrawable();
                if (d2 != null) {
                    d2.setCallback(null);
                }
                imageView.setImageDrawable(null);
                imageView.setBackgroundDrawable(null);
            }
            if (view instanceof TextView) {
                ((TextView) view).setText(null);
            }
            if (view instanceof WebView) {
                ((WebView) view).destroyDrawingCache();
                ((WebView) view).destroy();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public String getAdType() {
        return this.adType;
    }

    /* access modifiers changed from: 0000 */
    public void setAdType(String adType2) {
        this.adType = adType2;
    }

    /* access modifiers changed from: 0000 */
    public String getAppCode() {
        return this.appCode;
    }

    /* access modifiers changed from: 0000 */
    public void setAppCode(String appCode2) {
        this.appCode = appCode2;
    }

    /* access modifiers changed from: 0000 */
    public String getGender() {
        return this.gender;
    }

    /* access modifiers changed from: 0000 */
    public void setGender(String gender2) {
        this.gender = gender2;
    }

    /* access modifiers changed from: 0000 */
    public String getAge() {
        return this.age;
    }

    /* access modifiers changed from: 0000 */
    public void setAge(String age2) {
        this.age = age2;
    }

    /* access modifiers changed from: 0000 */
    public String getGpsInfo() {
        return this.gpsInfo;
    }

    /* access modifiers changed from: 0000 */
    public void setGpsInfo(String gpsInfo2) {
        this.gpsInfo = gpsInfo2;
    }

    /* access modifiers changed from: 0000 */
    public String getScode() {
        return this.scode;
    }

    /* access modifiers changed from: 0000 */
    public void setScode(String scode2) {
        this.scode = scode2;
    }

    /* access modifiers changed from: 0000 */
    public String getVersion() {
        return this.version;
    }

    /* access modifiers changed from: 0000 */
    public void setVersion(String version2) {
        this.version = version2;
    }

    /* access modifiers changed from: 0000 */
    public String getLang() {
        return this.lang;
    }

    /* access modifiers changed from: 0000 */
    public void setLang(String lang2) {
        this.lang = lang2;
    }

    /* access modifiers changed from: 0000 */
    public String getProvider() {
        return this.provider;
    }

    /* access modifiers changed from: 0000 */
    public void setProvider(String provider2) {
        this.provider = provider2;
    }

    /* access modifiers changed from: 0000 */
    public String getManufacturer() {
        return this.manufacturer;
    }

    /* access modifiers changed from: 0000 */
    public void setManufacturer(String manufacturer2) {
        this.manufacturer = manufacturer2;
    }

    /* access modifiers changed from: 0000 */
    public String getModel() {
        return this.model;
    }

    /* access modifiers changed from: 0000 */
    public void setModel(String model2) {
        this.model = model2;
    }

    /* access modifiers changed from: 0000 */
    public String getAllowcall() {
        return this.allowcall;
    }

    /* access modifiers changed from: 0000 */
    public void setAllowcall(String allowcall2) {
        this.allowcall = allowcall2;
    }

    /* access modifiers changed from: 0000 */
    public String getNetwork() {
        return this.network;
    }

    /* access modifiers changed from: 0000 */
    public void setNetwork(String network2) {
        this.network = network2;
    }
}

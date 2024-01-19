package in.juspay.hypersdk.core;

import android.util.Base64;
import android.webkit.JavascriptInterface;

public class AcsInterface {
    public static final String LOG_TAG = "AcsInterface";
    public final DynamicUI dui;
    public final DuiInterface duiInterface;

    public AcsInterface(HyperFragment hyperFragment, JuspayServices juspayServices) {
        this.dui = juspayServices.getDynamicUI();
        this.duiInterface = hyperFragment.getDuiInterface();
    }

    private boolean isFunctionAllowedToInvoke(String str) {
        return str.matches("^[a-zA-Z0-9]*$");
    }

    @JavascriptInterface
    public String getDataFromSharedPrefs(String str) {
        DuiInterface duiInterface2 = this.duiInterface;
        return duiInterface2 != null ? duiInterface2.getDataFromSharedPrefs(str, "") : "__failed";
    }

    @JavascriptInterface
    public String getResourceByName(String str) {
        DuiInterface duiInterface2 = this.duiInterface;
        return duiInterface2 != null ? duiInterface2.getResourceByName(str) : "__failed";
    }

    @JavascriptInterface
    public String getSessionAttribute(String str) {
        DuiInterface duiInterface2 = this.duiInterface;
        return duiInterface2 != null ? duiInterface2.getSessionAttribute(str, "") : "__failed";
    }

    @JavascriptInterface
    public String getSessionInfo() {
        DuiInterface duiInterface2 = this.duiInterface;
        return duiInterface2 != null ? duiInterface2.getSessionInfo() : "__failed";
    }

    @JavascriptInterface
    public void invoke(String str, String str2) {
        if (isFunctionAllowedToInvoke(str)) {
            String format = String.format("window[\"onEvent'\"]('%s',atob('%s'))", new Object[]{str, Base64.encodeToString(str2.getBytes(), 2)});
            DynamicUI dynamicUI = this.dui;
            if (dynamicUI != null) {
                dynamicUI.addJsToWebView(format);
            }
        }
    }

    @JavascriptInterface
    public void invoke(String str, String str2, String str3) {
        if (isFunctionAllowedToInvoke(str)) {
            String format = String.format("window[\"onEvent'\"]('%s',atob('%s'),'%s')", new Object[]{str, Base64.encodeToString(str2.getBytes(), 2), str3});
            DynamicUI dynamicUI = this.dui;
            if (dynamicUI != null) {
                dynamicUI.addJsToWebView(format);
            }
        }
    }

    @JavascriptInterface
    public boolean isOnline() {
        DuiInterface duiInterface2 = this.duiInterface;
        if (duiInterface2 != null) {
            return duiInterface2.isOnline();
        }
        return true;
    }
}

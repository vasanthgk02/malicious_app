package in.juspay.hypersdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Keep;
import in.juspay.hypersdk.core.JuspayLogger;
import org.apache.commons.net.ftp.FTPReply;

public class JuspayWebView extends WebView {
    public static final String LOG_TAG = JuspayWebView.class.getSimpleName();
    public Integer keyboardInputType = null;
    public int keyboardStickinessTime = 300;
    public long lastKeyboardTypeSetTime = 0;
    public WebChromeClient webChromeClient;
    public WebViewClient webViewClient;

    public JuspayWebView(Context context) {
        super(context);
    }

    public JuspayWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public JuspayWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public JuspayWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public JuspayWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
    }

    public void addJsToWebView(String str) {
        addJsToWebView(str, null);
    }

    public void addJsToWebView(String str, ValueCallback valueCallback) {
        evaluateJavascript(str, valueCallback);
    }

    public WebChromeClient getWebChromeClient() {
        return this.webChromeClient;
    }

    public WebViewClient getWebViewClient() {
        return this.webViewClient;
    }

    @Keep
    public void loadData(String str, String str2, String str3) {
        super.loadData(str, str2, str3);
    }

    @Keep
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        JuspayLogger.d(LOG_TAG, "Creating input connection");
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (this.keyboardInputType != null && System.currentTimeMillis() - this.lastKeyboardTypeSetTime <= ((long) this.keyboardStickinessTime)) {
            editorInfo.inputType |= this.keyboardInputType.intValue();
        }
        int i = editorInfo.inputType;
        if ((i & 1) == 1) {
            editorInfo.inputType = i | 224;
        }
        return onCreateInputConnection;
    }

    public void requestNumericKeyboardShow() {
        this.keyboardInputType = Integer.valueOf(2);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        setLastKeyboardTypeSetTime();
        inputMethodManager.restartInput(this);
        inputMethodManager.showSoftInput(this, 1);
    }

    public void requestPasswordKeyboardShow() {
        this.keyboardInputType = Integer.valueOf(FTPReply.DATA_CONNECTION_OPEN);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        setLastKeyboardTypeSetTime();
        inputMethodManager.restartInput(this);
        inputMethodManager.showSoftInput(this, 1);
    }

    public void requestPhoneKeyboardShow() {
        this.keyboardInputType = Integer.valueOf(3);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        setLastKeyboardTypeSetTime();
        inputMethodManager.restartInput(this);
        inputMethodManager.showSoftInput(this, 1);
    }

    public void setDefaultWebChromeClient(WebChromeClient webChromeClient2) {
        super.setWebChromeClient(webChromeClient2);
    }

    public void setDefaultWebViewClient(WebViewClient webViewClient2) {
        super.setWebViewClient(webViewClient2);
    }

    public void setLastKeyboardTypeSetTime() {
        this.lastKeyboardTypeSetTime = System.currentTimeMillis();
    }

    public void setWebChromeClient(WebChromeClient webChromeClient2) {
        this.webChromeClient = webChromeClient2;
        super.setWebChromeClient(webChromeClient2);
    }

    public void setWebViewClient(WebViewClient webViewClient2) {
        this.webViewClient = webViewClient2;
        super.setWebViewClient(webViewClient2);
    }
}

package com.twitter.sdk.android.core.identity;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

public class OAuthWebChromeClient extends WebChromeClient {
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return true;
    }
}

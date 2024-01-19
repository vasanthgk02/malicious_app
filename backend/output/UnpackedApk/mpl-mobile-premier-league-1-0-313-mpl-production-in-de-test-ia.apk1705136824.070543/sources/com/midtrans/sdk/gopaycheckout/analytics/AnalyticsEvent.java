package com.midtrans.sdk.gopaycheckout.analytics;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/analytics/AnalyticsEvent;", "", "()V", "CREATE_TRANSACTION_ERROR", "", "CREATE_TRANSACTION_SUCCESS", "CREATE_TRANSACTION_WEBVIEW_OPENED", "ENQUIRE_ACCOUNT_ERROR", "ENQUIRE_ACCOUNT_SUCCESS", "ERROR_CLASS", "ERROR_MESSAGE", "HTTP_ERROR_CODE", "HTTP_ERROR_MESSAGE_CLIENT_ERROR", "HTTP_ERROR_MESSAGE_KEY", "HTTP_ERROR_MESSAGE_NO_CONTENT_ERROR", "LINK_ACCOUNT_ERROR", "LINK_ACCOUNT_SUCCESS", "LINK_ACCOUNT_WEBVIEW_OPENED", "UNLINK_ACCOUNT_ERROR", "UNLINK_ACCOUNT_SUCCESS", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class AnalyticsEvent {
    public static final String CREATE_TRANSACTION_ERROR = "Create Transaction Error";
    public static final String CREATE_TRANSACTION_SUCCESS = "Create Transaction Success";
    public static final String CREATE_TRANSACTION_WEBVIEW_OPENED = "Create Transaction Webview is Opened";
    public static final String ENQUIRE_ACCOUNT_ERROR = "Enquire Account Error";
    public static final String ENQUIRE_ACCOUNT_SUCCESS = "Enquire Account Success";
    public static final String ERROR_CLASS = "Error Class";
    public static final String ERROR_MESSAGE = "Error Message";
    public static final String HTTP_ERROR_CODE = "Http Error Code";
    public static final String HTTP_ERROR_MESSAGE_CLIENT_ERROR = "Receive non-200 HTTP code";
    public static final String HTTP_ERROR_MESSAGE_KEY = "Http Error Message";
    public static final String HTTP_ERROR_MESSAGE_NO_CONTENT_ERROR = "Receive no content";
    public static final AnalyticsEvent INSTANCE = new AnalyticsEvent();
    public static final String LINK_ACCOUNT_ERROR = "Link Account Error";
    public static final String LINK_ACCOUNT_SUCCESS = "Link Account Success";
    public static final String LINK_ACCOUNT_WEBVIEW_OPENED = "Link Account Webview is Opened";
    public static final String UNLINK_ACCOUNT_ERROR = "Unlink Account Error";
    public static final String UNLINK_ACCOUNT_SUCCESS = "Unlink Account Success";
}

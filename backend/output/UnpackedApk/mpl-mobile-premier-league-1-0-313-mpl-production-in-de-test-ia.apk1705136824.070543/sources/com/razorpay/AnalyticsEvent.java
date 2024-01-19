package com.razorpay;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

@Keep
@KeepClassMembers
public enum AnalyticsEvent {
    CALLING_ON_SUCCESS(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.MERCHANT_CB_ONSUCCESS, AnalyticsConstants.CALLING),
    MERCHANT_ON_SUCCESS_CALLED(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.MERCHANT_CB_ONSUCCESS, AnalyticsConstants.CALLED),
    CALLING_ON_ERROR(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.MERCHANT_CB_ONERROR, AnalyticsConstants.CALLING),
    MERCHANT_ON_ERROR_CALLED(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.MERCHANT_CB_ONERROR, AnalyticsConstants.CALLED),
    EXTERNAL_WALLET_SELECTED(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.MERCHANT_CB_EXTERNAL, AnalyticsConstants.SELECTED),
    CALLING_EXTERNAL_WALLET_SELECTED(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.MERCHANT_CB_EXTERNAL, AnalyticsConstants.CALLING),
    MERCHANT_EXTERNAL_WALLET_SELECTED_CALLED(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.MERCHANT_CB_EXTERNAL, AnalyticsConstants.CALLED),
    HANDOVER_ERROR(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.MERCHANT_CB_HANDOVER, "fail"),
    CHECKOUT_LOADED(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.CHECKOUT, AnalyticsConstants.LOADED),
    INTERNAL_DESTROY_METHOD_CALLED(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.CHECKOUT, AnalyticsConstants.DESTROY),
    ACTIVITY_ONDESTROY_CALLED(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.CHECKOUT_ACTIVITY, AnalyticsConstants.DESTROY),
    CHECKOUT_SOFT_BACK_PRESSED(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.BACK, AnalyticsConstants.SOFT),
    CHECKOUT_HARD_BACK_PRESSED(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.BACK, AnalyticsConstants.HARD),
    CHECKOUT_PAYMENT_COMPLETE(AnalyticsConstants.CHECKOUT_SOURCE, "payment", AnalyticsConstants.COMPLETE),
    CHECKOUT_INIT(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.CHECKOUT_ACTIVITY_INIT, AnalyticsConstants.START),
    CHECKOUT_SUBMIT(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.CHECKOUT, AnalyticsConstants.SUBMIT),
    CARD_SAVING_START(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.CARDSAVING, AnalyticsConstants.START),
    CARD_SAVING_END(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.CARDSAVING, AnalyticsConstants.END),
    MULTIPLE_TOKEN_EVENT(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.CARDSAVING, AnalyticsConstants.MULTIPLE_TOKENS),
    SHARE_PREFERENCES_SECURITY_EXCEPTION(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.CARDSAVING, AnalyticsConstants.DEPRECATED),
    WEB_VIEW_JS_ERROR(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.JS_CONSOLE, "error"),
    WEB_VIEW_SSL_ERROR(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.WEBVIEW, AnalyticsConstants.SSL_ERROR),
    ALERT_PAYMENT_CONTINUE(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.BACK_ALERT, AnalyticsConstants.PAYMENT_CONTINUE),
    ALERT_PAYMENT_CANCELLED(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.BACK_ALERT, AnalyticsConstants.PAYMENT_CANCELLED),
    PAYMENT_ID_ATTACHED(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.PAYMENT_ID, AnalyticsConstants.ATTACHED),
    WEB_VIEW_UNEXPECTED_NULL(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.WEBVIEW, "null"),
    WEB_VIEW_PRIMARY_TO_SECONDARY_SWITCH(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.WEBVIEW, AnalyticsConstants.PRIMARY_TO_SECONDARY),
    WEB_VIEW_SECONDARY_TO_PRIMARY_SWITCH(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.WEBVIEW, AnalyticsConstants.SECONDARY_TO_PRIMARY),
    NATIVE_INTENT_CALLED(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.INTENT, AnalyticsConstants.CALLED),
    NATIVE_INTENT_ONACTIVITY_RESULT(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.INTENT, AnalyticsConstants.RESULT_TO_RECEIVED),
    CHECKOUT_TLS_ERROR(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.TLS, "error"),
    CHECKOUT_PLUGIN_PROCESS_PAYMENT_CALLED(AnalyticsConstants.AMAZONPAY_CH_SOURCE, AnalyticsConstants.PROCCESS_PAYMENT, AnalyticsConstants.CALLED),
    CHECKOUT_PLUGIN_INTERNAL_CALLBACK_SUCCESS(AnalyticsConstants.AMAZONPAY_CH_SOURCE, AnalyticsConstants.INTERNAL_CALLBACK, "success"),
    CHECKOUT_PLUGIN_INTERNAL_CALLBACK_ERROR(AnalyticsConstants.AMAZONPAY_CH_SOURCE, AnalyticsConstants.INTERNAL_CALLBACK, "error"),
    CHECKOUT_PLUGIN_INTERNAL_CALLBACK_ERROR_EXCEPTION(AnalyticsConstants.AMAZONPAY_CH_SOURCE, AnalyticsConstants.INTERNAL_CALLBACK, AnalyticsConstants.ERROR_EXCEPTION),
    CHECKOUT_PLUGIN_CALLING_PROCESS_PAYMENT(AnalyticsConstants.AMAZONPAY_CH_SOURCE, AnalyticsConstants.RAZORPAY_AMAZON, AnalyticsConstants.CALLIN_PROCESS_PAYMENT),
    CHECKOUT_PLUGIN_CALLING_PROCESS_PAYMENT_EXCEPTION(AnalyticsConstants.AMAZONPAY_CH_SOURCE, AnalyticsConstants.RAZORPAY_AMAZON, AnalyticsConstants.PROCESS_PAYMENT_EXCEPTION),
    CHECKOUT_PLUGIN_ON_ERROR_CALLED(AnalyticsConstants.AMAZONPAY_CH_SOURCE, AnalyticsConstants.ON_ERROR, AnalyticsConstants.CALLED),
    GOOGLEPAY_CHECK_REGISTER_CALLED(AnalyticsConstants.GOOGLEPAY_SOURCE, AnalyticsConstants.CHK_REGISTER, AnalyticsConstants.CALLED),
    PRELOAD_START(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.PRELOAD, AnalyticsConstants.START),
    PRELOAD_COMPLETE(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.PRELOAD, AnalyticsConstants.COMPLETE),
    PRELOAD_ABORT(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.PRELOAD, AnalyticsConstants.ABORT),
    MAGIC_PAYMENT_FLOW_START(AnalyticsConstants.MAGIC_SOURCE, "payment", AnalyticsConstants.START),
    MAGIC_PAYMENT_FLOW_END(AnalyticsConstants.MAGIC_SOURCE, "payment", AnalyticsConstants.END),
    MAGIC_PAGE_FINISH(AnalyticsConstants.MAGIC_SOURCE, AnalyticsConstants.MAGIC, AnalyticsConstants.PAGE_FINISH),
    MAGIC_SHOW_WEBVIEW(AnalyticsConstants.MAGIC_SOURCE, AnalyticsConstants.WEBVIEW, AnalyticsConstants.SHOW),
    MAGIC_SHOW_WEBVIEW_CLICKED(AnalyticsConstants.MAGIC_SOURCE, AnalyticsConstants.SHOW_WEBVIEW, AnalyticsConstants.CLICKED),
    MAGIC_RESET(AnalyticsConstants.MAGIC_SOURCE, AnalyticsConstants.MAGIC, AnalyticsConstants.RESET),
    MAGIC_TIMER_CALLBACK(AnalyticsConstants.MAGIC_SOURCE, AnalyticsConstants.TIMER, AnalyticsConstants.CALLBACK_RECEIVED),
    MAGIC_OTP_EXTRACT(AnalyticsConstants.MAGIC_SOURCE, "otp", AnalyticsConstants.EXTRACT),
    MAGIC_OTP_SHOW(AnalyticsConstants.MAGIC_SOURCE, "otp", AnalyticsConstants.SHOW),
    MAGIC_OTP_RESEND_CLICKED(AnalyticsConstants.MAGIC_SOURCE, AnalyticsConstants.OTP_RESEND, AnalyticsConstants.CLICKED),
    MAGIC_OTP_MANUAL_VIEW_CLICKED(AnalyticsConstants.MAGIC_SOURCE, AnalyticsConstants.OTP_MANUAL_VIEW, AnalyticsConstants.CLICKED),
    MAGIC_USE_MANUAL_OTP_CLICKED(AnalyticsConstants.MAGIC_SOURCE, AnalyticsConstants.OTP_MANUAL_USE, AnalyticsConstants.CLICKED),
    MAGIC_USE_OTP_CLICKED(AnalyticsConstants.MAGIC_SOURCE, AnalyticsConstants.OTP_USE, AnalyticsConstants.CLICKED),
    MAGIC_CHOICE_OTP_CLICKED(AnalyticsConstants.MAGIC_SOURCE, AnalyticsConstants.CHOICE_OTP, AnalyticsConstants.CLICKED),
    MAGIC_CHOICE_PASSWORD_CLICKED(AnalyticsConstants.MAGIC_SOURCE, AnalyticsConstants.CHOICE_PASSWORD, AnalyticsConstants.CLICKED),
    MAGIC_SET_PAGE_TYPE(AnalyticsConstants.MAGIC_SOURCE, AnalyticsConstants.PAGE_TYPE, ""),
    MAGIC_INIT_END(AnalyticsConstants.MAGIC_SOURCE, AnalyticsConstants.INIT, AnalyticsConstants.END),
    SMS_PERMISSION_ALREADY_GRANTED(AnalyticsConstants.RZPASSIST_SOURCE, AnalyticsConstants.PERMISSION_SMS, AnalyticsConstants.ALREADY_GRANTED),
    SMS_PERMISSION_ALREADY_NOT_GRANTED(AnalyticsConstants.RZPASSIST_SOURCE, AnalyticsConstants.PERMISSION_SMS, AnalyticsConstants.ALREADY_NOT_GRANTED),
    SMS_PERMISSION_ALREADY_GRANTED_BY_MERCHANT(AnalyticsConstants.RZPASSIST_SOURCE, AnalyticsConstants.PERMISSION_SMS, AnalyticsConstants.ALREADY_GRANTED_BY_MERCHANT),
    SMS_PERMISSION_ALREADY_ASKED(AnalyticsConstants.RZPASSIST_SOURCE, AnalyticsConstants.PERMISSION_SMS, AnalyticsConstants.ALREADY_ASKED),
    SMS_PERMISSION_ALREADY_NOT_ASKED(AnalyticsConstants.RZPASSIST_SOURCE, AnalyticsConstants.PERMISSION_SMS, AnalyticsConstants.ALREADY_NOT_ASKED),
    SMS_PERMISSION_NOW_GRANTED(AnalyticsConstants.RZPASSIST_SOURCE, AnalyticsConstants.PERMISSION_SMS, AnalyticsConstants.NOW_GRANTED),
    SMS_PERMISSION_NOW_DENIED(AnalyticsConstants.RZPASSIST_SOURCE, AnalyticsConstants.PERMISSION_SMS, AnalyticsConstants.NOW_DENIED),
    PAGE_LOAD_START(AnalyticsConstants.RZPASSIST_SOURCE, AnalyticsConstants.RZPASSIST, AnalyticsConstants.PAGE_START),
    PAGE_LOAD_FINISH(AnalyticsConstants.RZPASSIST_SOURCE, AnalyticsConstants.RZPASSIST, AnalyticsConstants.PAGE_FINISH),
    CHECKOUT_PAGE_LOAD_START(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.RZPASSIST, AnalyticsConstants.CHECKOUT_PAGE_START),
    CHECKOUT_PAGE_LOAD_FINISH(AnalyticsConstants.CHECKOUT_SOURCE, AnalyticsConstants.RZPASSIST, AnalyticsConstants.CHECKOUT_PAGE_FINISH),
    OTP_RECEIVED(AnalyticsConstants.RZPASSIST_SOURCE, AnalyticsConstants.RZPASSIST, AnalyticsConstants.OTP_RECEIVE),
    ERROR_LOGGED(AnalyticsConstants.RZPASSIST_SOURCE, "error", AnalyticsConstants.LOG),
    PAGE_NOT_IDENTIFIED(AnalyticsConstants.RZPASSIST_SOURCE, AnalyticsConstants.PAGE_TYPE, AnalyticsConstants.UNIDENTIFIED),
    AUTO_READ_OTP_SMS_RETRIEVER_API_TASK("", AnalyticsConstants.TASK, AnalyticsConstants.CALLED),
    AUTO_READ_OTP_SMS_RETRIEVER_API_RECEIVED_SMS("", AnalyticsConstants.SMS_RECIEVED, AnalyticsConstants.CALLED),
    AUTO_READ_OTP_SMS_RETRIEVER_API_SHOWED_ONE_TIME_CONSENT("", AnalyticsConstants.CONSENT_SHOWED, AnalyticsConstants.CALLED),
    AUTO_READ_OTP_SMS_RETRIEVER_API_OTP_POPULATION_JS("", AnalyticsConstants.POPULATION, AnalyticsConstants.CALLED),
    AUTO_READ_OTP_SMS_RETRIEVER_API_CONSENT_DECLINED("", AnalyticsConstants.ALREADY_NOT_GRANTED, AnalyticsConstants.CALLED),
    AUTO_READ_OTP_SMS_RETRIEVER_API_TIMEOUT("", AnalyticsConstants.TIMEOUT, AnalyticsConstants.CALLED),
    JS_EVENT("", "", ""),
    FETCH_PREFERENCES_CALLED(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.PREFERENCES, "call"),
    FETCH_PREFERENCES_CACHE_HIT(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.PREFERENCES, AnalyticsConstants.CACHE_HIT),
    FETCH_PREFERENCES_CACHE_MISS(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.PREFERENCES, AnalyticsConstants.CACHE_MISS),
    FETCH_PREFERENCES_CALL_SUCCESS(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.PREFERENCES, AnalyticsConstants.CALL_SUCCESS),
    FETCH_PREFERENCES_METHODS_CALL_FAIL(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.PREFERENCES, AnalyticsConstants.CALL_FAIL),
    CUSTOM_UI_INIT_END(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.INIT, AnalyticsConstants.END),
    CUSTOM_UI_PAYMENT_COMPLETE(AnalyticsConstants.CUSTOM_UI_SOURCE, "payment", AnalyticsConstants.COMPLETE),
    CUSTOM_UI_SUBMIT_START(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.SUBMIT, AnalyticsConstants.START),
    CUSTOM_UI_BACK_PRESSED_SOFT(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.BACK, AnalyticsConstants.SOFT),
    CUSTOM_UI_BACK_PRESSED_HARD(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.BACK, AnalyticsConstants.HARD),
    CUSTOM_UI_PAYMENT_ID_ATTACHED(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.PAYMENT_ID, AnalyticsConstants.ATTACHED),
    CUSTOM_UI_MERCHANT_KEY_CHANGED(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.MERCHANT_KEY, "changed"),
    CUSTOM_UI_GET_APPS_SUPPORTING_UPI(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.UPI_APPS, AnalyticsConstants.CALLED),
    CUSTOM_UI_GET_APPS_SUPPORTING_UPI_CALLBACK(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.UPI_APPS_CALLBACK, AnalyticsConstants.CALLED),
    CUSTOM_UI_SHOULD_SHOW_UPI_INTENT_METHOD(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.SHOULD_SHOW_UPI_INTENT, AnalyticsConstants.CALLED),
    CUSTOM_UI_UPI_APP_PASSED(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.UPI_APP_NAME, AnalyticsConstants.PASSED),
    CUSTOM_UI_NATIVE_INTENT_CALLED(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.INTENT, AnalyticsConstants.CALLED),
    CUSTOM_UI_NATIVE_INTENT_ONACTIVITY_RESULT(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.INTENT, AnalyticsConstants.RESULT_TO_RECEIVED),
    CUSTOM_UI_UPI_INTENT_APPS_PREFERENCE_PASSED(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.UPI_APPS_PREFERENCE, AnalyticsConstants.PASSED),
    CUSTOM_UI_CUSTOM_APP_CHOOSER_SHOWN(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.CUSTOM_APP_CHOOSER, AnalyticsConstants.SHOWN),
    CUSTOM_UI_UPI_MERCHANT_PASSED_APP_LAUNCHED(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.MERCHANT_PASSED_APP, AnalyticsConstants.LAUNCHED),
    CUSTOM_UI_UPI_APP_LAUNCHED(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.UPI_APP_FROM_CUSTOM_CHOOSER, AnalyticsConstants.LAUNCHED),
    CUSTOM_UI_UPI_INTENT_APPS_PREFERRED_ORDER_PASSED(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.UPI_PREFERRED_APPS_ORDER, AnalyticsConstants.PASSED),
    CUSTOM_UI_UPI_INTENT_APPS_OTHER_ORDER_PASSED(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.UPI_OTHER_APPS_ORDER, AnalyticsConstants.PASSED),
    CUSTOM_UI_VALIDATE_VPA_CALLED(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.VALIDATE_VPA, AnalyticsConstants.CALLED),
    CUSTOM_UI_TLS_ERROR(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.TLS, "error"),
    CUSTOM_UI_PLUGIN_INTERNAL_CALLBACK_SUCCESS(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.INTERNAL_CALLBACK, "success"),
    CUSTOM_UI_PLUGIN_INTERNAL_CALLBACK_ERROR(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.INTERNAL_CALLBACK, "error"),
    CUSTOM_UI_PLUGIN_INTERNAL_CALLBACK_ERROR_EXCEPTION(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.INTERNAL_CALLBACK, AnalyticsConstants.ERROR_EXCEPTION),
    CUSTOMUI_INTERNAL_CALLBACK_SUCCESS(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.INTERNAL_CALLBACK, "success"),
    CUSTOMUI_INTERNAL_CALLBACK_ERROR(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.INTERNAL_CALLBACK, "error"),
    CUSTOMUI_INTERNAL_CALLBACK_ERROR_EXCEPTION(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.INTERNAL_CALLBACK, AnalyticsConstants.ERROR_EXCEPTION),
    CUSTOMUI_METHOD_AMAZONPAY_PASSED(AnalyticsConstants.CUSTOM_UI_SOURCE, AnalyticsConstants.PAYMENT_METHOD, AnalyticsConstants.AMAZONPAY_PASSED),
    AMAZON_PROCESS_SIGN_ENCRYPT_RESPONSE_CALLED(AnalyticsConstants.AMAZONPAY_SOURCE, "cb:sign_encrypt_response", AnalyticsConstants.CALLED),
    AMAZON_PROCESS_SIGN_ENCRYPT_RESPONSE_EXCEPTION(AnalyticsConstants.AMAZONPAY_SOURCE, "cb:sign_encrypt_response", AnalyticsConstants.EXCEPTION),
    AMAZON_PROCESS_VERIFY_SIGNATURE_CALLED(AnalyticsConstants.AMAZONPAY_SOURCE, "cb:sign_encrypt_response", AnalyticsConstants.CALLED),
    AMAZON_PROCESS_VERIFY_SIGNATURE_EXCEPTION(AnalyticsConstants.AMAZONPAY_SOURCE, "cb:sign_encrypt_response", AnalyticsConstants.EXCEPTION),
    AMAZON_PROCESS_VERIFY_SIGNATURE_INTERNAL_SUCCESS_CALLED(AnalyticsConstants.AMAZONPAY_SOURCE, "cb:sign_encrypt_response", AnalyticsConstants.CALLING_INTERNAL_SUCCESS),
    AMAZON_PROCESS_VERIFY_SIGNATURE_INTERNAL_ERROR_CALLED(AnalyticsConstants.AMAZONPAY_SOURCE, "cb:sign_encrypt_response", AnalyticsConstants.CALLING_INTERNAL_ERROR),
    AMAZON_PROCESS_PAYMENT_CALLED(AnalyticsConstants.AMAZONPAY_SOURCE, AnalyticsConstants.PROCCESS_PAYMENT, AnalyticsConstants.CALLED),
    AMAZON_INTERNAL_CALLBACK_SUCCESS(AnalyticsConstants.AMAZONPAY_SOURCE, AnalyticsConstants.INTERNAL_CALLBACK, "success"),
    AMAZON_INTERNAL_CALLBACK_ERROR(AnalyticsConstants.AMAZONPAY_SOURCE, AnalyticsConstants.INTERNAL_CALLBACK, "error"),
    AMAZON_PWAIN_CALLBACK_SUCCESS(AnalyticsConstants.AMAZONPAY_SOURCE, AnalyticsConstants.PWAIN_CALLBACK, "success"),
    AMAZON_PWAIN_CALLBACK_FAILURE(AnalyticsConstants.AMAZONPAY_SOURCE, AnalyticsConstants.PWAIN_CALLBACK, AnalyticsConstants.FAILURE),
    AMAZON_PWAIN_CALLBACK_PAYMENT_VALIDATION_FAILURE(AnalyticsConstants.AMAZONPAY_SOURCE, AnalyticsConstants.PWAIN_CALLBACK, AnalyticsConstants.PAYMENT_VALIDATION_FAILURE),
    AMAZON_PWAIN_CALLBACK_MERCHANT_BACKEND_ERROR(AnalyticsConstants.AMAZONPAY_SOURCE, AnalyticsConstants.PWAIN_CALLBACK, AnalyticsConstants.MERCHANT_BACKEND_ERROR),
    AMAZON_PWAIN_CALLBACK_MOBILE_SDK_ERROR(AnalyticsConstants.AMAZONPAY_SOURCE, AnalyticsConstants.PWAIN_CALLBACK, AnalyticsConstants.MOBILE_SDK_ERROR),
    AMAZON_PWAIN_CALLBACK_NETWORK_UNAVAILABLE(AnalyticsConstants.AMAZONPAY_SOURCE, AnalyticsConstants.PWAIN_CALLBACK, AnalyticsConstants.NETWORK_UNAVAILABLE),
    AMAZON_PWAIN_CALLBACK_ON_CANCEL(AnalyticsConstants.AMAZONPAY_SOURCE, AnalyticsConstants.PWAIN_CALLBACK, AnalyticsConstants.ON_CANCEL),
    GOOGLEPAY_PROCESS_PAYMENT_PAYLOAD_CALLED(AnalyticsConstants.GOOGLEPAY_SOURCE, AnalyticsConstants.PROCCESS_PAYMENT_PAYLAOD, AnalyticsConstants.CALLED),
    GOOGLEPAY_PROCESS_PAYMENT_PAYLOAD_ERROR(AnalyticsConstants.GOOGLEPAY_SOURCE, AnalyticsConstants.PROCCESS_PAYMENT_PAYLAOD, "error"),
    GOOGLEPAY_PROCESS_PAYMENT_CALLED(AnalyticsConstants.GOOGLEPAY_SOURCE, AnalyticsConstants.PROCCESS_PAYMENT, AnalyticsConstants.CALLED),
    GOOGLEPAY_PAYMENT_CALLBACK_SUCCESS(AnalyticsConstants.GOOGLEPAY_SOURCE, AnalyticsConstants.GOOGLEPAY_CALLBACK, "success"),
    GOOGLEPAY_PAYMENT_CALLBACK_CANCELLED(AnalyticsConstants.GOOGLEPAY_SOURCE, AnalyticsConstants.GOOGLEPAY_CALLBACK, AnalyticsConstants.ON_CANCEL),
    GOOGLEPAY_PAYMENT_IS_REGISTERED_CALLED(AnalyticsConstants.GOOGLEPAY_SOURCE, AnalyticsConstants.UPI_IS_REGISTERED, AnalyticsConstants.CALLED),
    GOOGLEPAY_VERIFY_PAYMENT_CALLED(AnalyticsConstants.GOOGLEPAY_SOURCE, "cb:sign_encrypt_response", AnalyticsConstants.CALLED),
    GOOGLEPAY_VERIFY_PAYMENT_SUCCESS_CALLED(AnalyticsConstants.GOOGLEPAY_SOURCE, "cb:sign_encrypt_response", "success"),
    GOOGLEPAY_VERIFY_PAYMENT_ERROR_CALLED(AnalyticsConstants.GOOGLEPAY_SOURCE, "cb:sign_encrypt_response", "error"),
    GOOGLEPAY_VERIFY_PAYMENT_EXCEPTION(AnalyticsConstants.GOOGLEPAY_SOURCE, "cb:sign_encrypt_response", AnalyticsConstants.EXCEPTION);
    
    public String eventName;

    /* access modifiers changed from: public */
    AnalyticsEvent(String str, String str2, String str3) {
        this.eventName = constructEventName(str, str2, str3);
    }

    public static String constructEventName(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("_");
        sb.append(str3);
        return sb.toString();
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final void setEventName(String str) {
        this.eventName = str;
    }
}

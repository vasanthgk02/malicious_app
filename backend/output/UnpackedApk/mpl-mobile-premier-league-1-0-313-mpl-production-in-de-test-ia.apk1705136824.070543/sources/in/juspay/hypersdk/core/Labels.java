package in.juspay.hypersdk.core;

import androidx.annotation.Keep;

public class Labels {

    public static class Android {
        public static final String BACK_PRESSED = "on_back_pressed";
        public static final String FRAGMENT_OPERATION = "fragment_operation";
        public static final String ON_ACTIVITY_RESULT = "on_activity_result";
        public static final String ON_CREATE_VIEW = "on_create_view";
        public static final String ON_DESTROY = "on_destroy";
        public static final String ON_EVENT = "on_event";
        public static final String ON_PAUSE = "on_pause";
        public static final String ON_RESUME = "on_resume";
        public static final String ON_SAVE_INSTANCE_STATE = "on_saved_instance_state";
        public static final String ON_STOP = "on_stop";
        public static final String RESET_WEBVIEW = "reset_webview";
    }

    public static class Device {
        public static final String ACCOUNT = "account";
        public static final String DATA = "data";
        public static final String IDENTIFIERS = "identifiers";
        public static final String MEMORY = "memory";
        public static final String PHONE_STATE = "phone_state";
        public static final String SESSION_INFO = "session_info";
    }

    @Keep
    public static class HyperSdk {
        public static final String AUTO_FALLBACK = "auto_fallback";
        public static final String EVENT = "on_event";
        public static final String EXCEPTION_HANDLER = "hyper_exception_handler";
        public static final String EXIT_APP = "exit_app";
        public static final String EXIT_SDK_ERROR = "exit_sdk_error";
        public static final String FIRST_TIME_SETUP = "first_time_setup";
        public static final String HYPER_FRAGMENT = "hyper_fragment";
        public static final String HYPER_SERVICE = "hyper_service";
        public static final String INITIATE = "initiate";
        public static final String MYSTIQUE = "mystique";
        public static final String ON_DUI_READY = "on_dui_ready";
        public static final String PREFETCH = "prefetch";
        public static final String PROCESS = "process";
        public static final String PROCESS_QUEUE = "process_queue";
        public static final String PROCESS_WAIT_QUEUE = "process_wait_queue";
        public static final String RUN_IN_JUSPAY_BROWSER = "run_in_juspay_browser";
        public static final String TERMINATE = "terminate";
        public static final String TERMINATE_PROCESS = "terminate_process";
    }

    public static class Network {
        public static final String BEFORE_REQUEST = "before_request";
        public static final String NETWORK_CALL = "network_call";
    }

    public static class SDK {
        public static final String AMAZON_UTILS = "amazon_utils";
        public static final String CUSTOM_TAB = "custom_tab";
        public static final String GPAY_UTILS = "gpay_utils";
        public static final String PAYMENT_UTILS = "payment_utils";
        public static final String PAYPAL_UTILS = "paypal_utils";
        public static final String PAYTM_UTILS = "paytm_utils";
        public static final String PHONEPE_UTILS = "phonepe_utils";
        public static final String RECEIVER_CALLBACK = "receiver_callback";
        public static final String SMS_CONSENT = "SMS_CONSENT";
        public static final String WEBVIEW_CLIENT = "webview_client";
    }

    public static class SafeModeSDK {
        public static final String BROADCAST_RECEIVING_ERROR = "broadcast_receiving_error";
        public static final String LOG_EVENT_RECEIVING_ERROR = "log_event_receiving_error";
        public static final String RESULT_RECEIVING_ERROR = "result_receiving_error";
        public static final String START_ERROR = "start_error";
    }

    public static class System {
        public static final String ADD_WEBVIEW = "add_web_view";
        public static final String BROADCAST_RECEIVER = "broadcast_receiver";
        public static final String CLIPBOARD = "clip_board";
        public static final String FILE_PROVIDER_SERVICE = "file_provider_service";
        public static final String GODEL_SERVICE_CONNECTION = "godel_service_connection";
        public static final String GODEL_SERVICE_RESPONSE_HANDLER = "godel_service_response_handler";
        public static final String GODEL_WEBVIEW_WHITELIST = "godel_webview_whitelist";
        public static final String HELPER = "helper";
        public static final String INITIALISE_JUSPAY_WEBVIEW = "initialise_juspay_webview";
        public static final String IS_NETWORK_AVAILABLE = "is_network_available";
        public static final String JBRIDGE = "jbridge";
        public static final String JUSPAY_TRUST_MANAGER = "juspay_trust_manager";
        public static final String JUSPAY_WEBVIEW_CLIENT = "juspay_webview_client";
        public static final String KEYBOARD = "keyboard";
        public static final String LOAD_PAGE = "load_page";
        public static final String LOG_PUSHER = "log_pusher";
        public static final String LOG_SESSIONISER = "log_sessioniser";
        public static final String MPIN_UTIL = "mpin_util";
        public static final String ON_BROWSER_READY = "on_browser_ready";
        public static final String ON_DUI_RELEASED = "on_dui_released";
        public static final String ON_REQUEST_PERMISSION_RESULT = "on_request_permission_result";
        public static final String ON_WEBVIEW_READY = "on_webview_ready";
        public static final String PAYMENT_SESSION_INFO = "payment_session_info";
        public static final String PERMISSION = "permission";
        public static final String READ_SMS_PERMISSION = "read_sms_permission";
        public static final String REMOTE_ASSET_SERVICE = "remote_asset_service";
        public static final String RUN_IN_JUSPAY_WEBVIEW = "run_in_juspay_webview";
        public static final String SDK_CRASHED = "sdk_crashed";
        public static final String SESSION_INFO = "session_info";
        public static final String SHARED_PREF = "SharedPref";
        public static final String UTIL = "util";
    }

    public static class User {
        public static final String ACS_INTERFACE = "acs_interface";
        public static final String SHOULD_DISABLE_GODEL = "should_disable_godel";
    }
}

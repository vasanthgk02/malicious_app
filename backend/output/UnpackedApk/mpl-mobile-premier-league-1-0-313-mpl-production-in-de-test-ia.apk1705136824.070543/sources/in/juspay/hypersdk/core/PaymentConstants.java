package in.juspay.hypersdk.core;

import androidx.annotation.Keep;

public class PaymentConstants {
    public static final String ACS = "payments/in.juspay.godel/v1-acs.jsa";
    @Keep
    public static final Boolean ADD_MANDATE_PARAMS = Boolean.FALSE;
    public static final String AMOUNT = "amount";
    public static final String ASSET_MANAGE = "jp_asset_manage";
    public static final String ATTR_HASH_IN_DISK = "hashInDisk";
    public static final String BANK = "bank";
    public static final String BETA_ASSETS = "betaAssets";
    @Keep
    public static final String BLOCKED_WALLETS = "udf_disabled_methods";
    public static String BUILD_ID = "";
    public static final String CANCEL_TRANSACTION = "CancelTransaction";
    @Keep
    public static final int CAN_OPEN_SDK = 7;
    @Keep
    public static final String CLIENT_AUTH_TOKEN = "session_token";
    public static final String CLIENT_EMAIL = "customer_email";
    public static final String CLIENT_ID = "client_id";
    public static final String CLIENT_ID_CAMEL = "clientId";
    public static final String CLIENT_MOBILE_NO = "customer_phone_number";
    public static final String CLIPBOARD = "CLIPBOARD";
    @Keep
    public static final String CUSTOMER_EMAIL = "customer_email";
    @Keep
    public static final String CUSTOMER_ID = "customer_id";
    @Keep
    public static final String CUSTOMER_MOBILE = "customer_phone_number";
    public static final String DELIVER_SMS = "DELIVER_SMS";
    public static final String DESCRIPTION = "display_note";
    @Keep
    public static final String END_URLS = "endUrls";
    @Keep
    public static final String ENV = "environment";
    public static final String FRAGMENT_VIEW_GROUPS = "fragmentViewGroups";
    public static final String GALLERY = "GALLERY";
    public static final String GODEL = "GODEL";
    public static final String GODEL_BUILD_VERSION = "godel_build_version";
    public static final String GODEL_VERSION = "godel_version";
    @Keep
    public static int GPAY_CONSTANT = 2;
    @Keep
    public static final int GPAY_REQUEST_CODE = 114;
    @Keep
    public static final Boolean IS_SIGNATURE_BASED = Boolean.TRUE;
    @Keep
    public static final String ITEM_COUNT = "itemCount";
    public static final String JP_BLOCKED_HASH = "jp_blocked_hash";
    public static final String JP_HASH_AND_STATUS = "jp_hash_and_status";
    public static final String LOG_VERSION = "2.0.1";
    @Keep
    public static final String MCC = "mcc";
    @Keep
    public static final String MERCHANT_CHANNEL_ID = "merchant_channel_id";
    public static final String MERCHANT_ID = "merchant_id";
    public static final String MERCHANT_ID_CAMEL = "merchantId";
    @Keep
    public static final String MERCHANT_KEY_ID = "merchant_key_id";
    public static final String NETWORK_STATUS = "NETWORK_STATUS";
    @Keep
    public static final String OFFER_APPLIED = "offer_applied";
    @Keep
    public static final String OFFER_CODE = "offer_code";
    @Keep
    public static final String OFFER_DETAILS = "offer_details";
    @Keep
    public static final String OFFER_DISCOUNT = "offer_discount";
    @Keep
    public static final String OFFER_PAYMENT_CARD_ISSUER = "offer_payment_card_issuer";
    @Keep
    public static final String OFFER_PAYMENT_CARD_TYPE = "offer_payment_card_type";
    @Keep
    public static final String OFFER_PAYMENT_METHOD = "offer_payment_method";
    @Keep
    public static final String OFFER_PAYMENT_METHOD_TYPE = "offer_payment_method_type";
    @Keep
    public static final String ORDER_CREATE_RESP = "__order_create_response_";
    @Keep
    public static final String ORDER_DETAILS = "order_details";
    public static final String ORDER_ID = "order_id";
    public static final String PACKAGE_NAME = "package_name";
    @Keep
    public static final String PAYLOAD = "payload";
    @Keep
    public static final String PAYMENT_LOCKING = "payment_locking";
    @Keep
    public static final String PAYMENT_PAGE_TITLE = "udf_title";
    @Keep
    public static final String POST_DATA = "postData";
    public static final String PROJECT_ID = "project_id";
    public static final String REMARKS = "remarks";
    public static final String REQUEST_PERMISSION_PREFIX = "ReqPermi";
    public static final int REQUEST_SMS_PERMISSION = 7;
    public static final String SAFETYNET_API_KEY = "safetynet_api_key";
    public static final String SAFETYNET_API_RESP = "safetynet_api_resp";
    public static final String SAFETY_NET_REQUEST = "SAFETY_NET_REQUEST";
    @Keep
    public static final String SAVED_PAYMENT_METHODS = "saved_payment_methods_";
    public static final String SCREEN_ORIENTATION = "screenOrientation";
    public static final String SDK_CONFIG = "sdk_meta";
    @Keep
    public static final String SDK_META = "sdk_meta";
    public static final String SDK_NAME = "sdkName";
    public static final String SDK_VERSION = "sdkVersion";
    public static final String SEND_SMS = "SEND_SMS";
    public static final String SERVICE = "service";
    @Keep
    public static final String SESSION_TOKEN = "juspay_session_token";
    @Keep
    public static final String SIGNATURE = "signature";
    @Keep
    public static final String SIGNATURE_PAYLOAD = "signature_payload";
    public static final String SIGNATURE_PAYLOAD_CAMEL = "signaturePayload";
    public static final String SMS_CONSENT = "SMS_CONSENT";
    public static final String SMS_RECEIVE = "SMS_RECEIVE";
    public static final String TEST_MODE = "test_mode";
    @Keep
    public static final String TIMESTAMP = "timestamp";
    public static final String TRANSACTION_ID = "transaction_id";
    @Keep
    public static final String UDF1 = "udf1";
    @Keep
    public static final String UDF10 = "udf10";
    @Keep
    public static final String UDF2 = "udf2";
    @Keep
    public static final String UDF3 = "udf3";
    @Keep
    public static final String UDF4 = "udf4";
    @Keep
    public static final String UDF5 = "udf5";
    @Keep
    public static final String UDF6 = "udf6";
    @Keep
    public static final String UDF7 = "udf7";
    @Keep
    public static final String UDF8 = "udf8";
    @Keep
    public static final String UDF9 = "udf9";
    @Keep
    public static final String URL = "url";
    public static final String VERIFY_ASSETS = "verifyAssets";
    public static final String VIES_CORE_DEVICE_VALIDATION = "VIES_CORE_DEVICE_VALIDATION";
    public static final String VIES_CORE_DISENROLL = "VIES_CORE_DISENROLL";
    public static final String VIES_CORE_PAY = "VIES_CORE_PAY";
    public static final String VIES_CORE_UPDATE_ENROLL = "VIES_CORE_UPDATE_ENROLL";
    public static final String VIES_DELETE_CARD = "VIES_DELETE_CARD";
    public static final String VIES_DISENROLL = "VIES_DISENROLL";
    public static final String VIES_ELIGIBILITY = "VIES_ELIGIBILITY";
    public static final String VIES_GET_MAX_AMOUNT = "VIES_GET_MAX_AMOUNT";
    public static final String VIES_PAY = "VIES_PAY";
    @Keep
    public static final String VIES_SERVICE = "in.juspay.vies";
    @Keep
    public static final String WIDGET_ADD_CARD = "addCard";
    @Keep
    public static final String WIDGET_ADD_WALLETS = "addAndLinkWallet";
    @Keep
    public static final String WIDGET_DELINK_WALLET = "delinkWallet";
    @Keep
    public static final String WIDGET_NAME = "widget_key";
    @Keep
    public static final String WIDGET_NETBANKING = "nb";
    @Keep
    public static final String WIDGET_PAYMENT_PAGE = "paymentPage";
    @Keep
    public static final String WIDGET_UPI = "upi";

    @Keep
    public abstract class Category {
        public static final String ACS = "acs";
        public static final String CONFIG = "config";
        public static final String GODEL = "godel";
        public static final String JS = "JS";
        public static final String SDK = "sdk";
        public static final String UBER = "uber";
        public static final String UI = "ui";

        public Category() {
        }
    }

    @Keep
    public abstract class ENVIRONMENT {
        public static final String DEV = "dev";
        public static final String PRE_PROD = "pre_prod";
        public static final String PRODUCTION = "prod";
        public static final String SANDBOX = "sandbox";

        public ENVIRONMENT() {
        }
    }

    public static class Event {
        public static final String API = "apirequest";
        public static final String ERROR = "error";
        public static final String FALLBACK = "fallback";
        public static final String INFO = "info";
        public static final String SCREEN = "screen";
    }

    @Keep
    public class Events {
        public static final String PAYMENT_ATTEMPT = "paymentAttempt";
        public static final String UPDATE_ORDER = "updateOrder";

        public Events() {
        }
    }

    public abstract class GodelOffReasons {
        public static final String CONFIG_DOWNLOAD_FAILED = "CONFIG_DOWNLOAD_FAILED";
        public static final String FEATURE_DISABLED = "FEATURE_DISABLED";
        public static final String JS_FILES_CORRUPTED = "JS_FILES_CORRUPTED";
        public static final String LOWER_ANDROID_OS = "LOWER_ANDROID_OS";
        public static final String LOW_ON_MEMORY = "LOW_ON_MEMORY";
        public static final String ON_GODEL_EXCEPTION = "ON_GODEL_EXCEPTION";
        public static final String ON_GODEL_EXCEPTION_STICKINESS = "ON_GODEL_EXCEPTION_STICKINESS";
        public static final String REMOTES_KEY_NOT_FOUND_IN_CONFIG = "REMOTES_KEY_NOT_FOUND_IN_CONFIG";
        public static final String TELEPHONY_NOT_FOUND = "TELEPHONY_NOT_FOUND";
        public static final String WEBLAB_KEY_NOT_FOUND_IN_CONFIG = "WEBLAB_KEY_NOT_FOUND_IN_CONFIG";

        public GodelOffReasons() {
        }
    }

    @Keep
    public abstract class LogCategory {
        public static final String ACTION = "action";
        public static final String API_CALL = "api_call";
        public static final String CONTEXT = "context";
        public static final String LIFECYCLE = "lifecycle";

        public LogCategory() {
        }
    }

    @Keep
    public static class LogLevel {
        public static final String CRITICAL = "critical";
        public static final String DEBUG = "debug";
        public static final String ERROR = "error";
        public static final String INFO = "info";
        public static final String WARNING = "warning";
    }

    @Keep
    public abstract class SubCategory {

        public abstract class Action {
            public static final String DUI = "dynamic_ui";
            public static final String SYSTEM = "system";
            public static final String USER = "user";

            public Action() {
            }
        }

        public abstract class ApiCall {
            public static final String NETWORK = "network";
            public static final String SDK = "external_sdk";

            public ApiCall() {
            }
        }

        public abstract class Context {
            public static final String DEVICE = "device";

            public Context() {
            }
        }

        @Keep
        public abstract class LifeCycle {
            public static final String ANDROID = "android";
            public static final String HYPER_SDK = "hypersdk";

            public LifeCycle() {
            }
        }

        public SubCategory() {
        }
    }

    public static void setBuildId(String str) {
        BUILD_ID = str;
    }
}

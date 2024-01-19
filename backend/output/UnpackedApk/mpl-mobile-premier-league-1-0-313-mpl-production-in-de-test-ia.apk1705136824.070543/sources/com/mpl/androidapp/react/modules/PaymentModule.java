package com.mpl.androidapp.react.modules;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.config.PaymentConfigProviderImpl;
import com.mpl.androidapp.imagepicker.HyperVergeKycCapture;
import com.mpl.androidapp.imagepicker.IdCaptureListener;
import com.mpl.androidapp.imagepicker.IdologyKycIdCapture;
import com.mpl.androidapp.imagepicker.KycIdProvider;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.react.PaymentCallBackListener;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.ApiEndPoints;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MPLAuthTokenProvider;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.payment.cardverification.CardVerificationManager;
import com.mpl.payment.cardverification.CardVerificationResultListener;
import com.mpl.payment.cardverification.MPLCardVerificationCharger;
import com.mpl.payment.cardverification.MPLThreeDSHandlerResolver;
import com.mpl.payment.common.AuthTokenProvider;
import com.mpl.payment.common.MPLInstrumentationListener;
import com.mpl.payment.common.cardinput.CardInputManager;
import com.mpl.payment.common.cardinput.CardInputResultListener;
import com.mpl.payment.common.cardinput.MPLEndpointCardInputRouter;
import com.mpl.payment.common.cardinput.MPLHostedFieldHandlerResolver;
import com.mpl.payment.common.cardinput.models.CardInputResult;
import com.mpl.payment.common.config.PaymentConfig;
import com.mpl.payment.common.upi.UpiAppListener;
import com.mpl.payment.gopay.GopayLinkingHandler;
import com.mpl.payment.juspayhypersdk.HyperServiceProcessPayloadListener;
import com.mpl.payment.juspayhypersdk.HyperServiceWrapper;
import com.mpl.payment.juspayhypersdk.JusPayUpiAppListProvider;
import com.mpl.payment.juspayhypersdk.customer.FetchCustomerIdUseCase;
import com.mpl.payment.linking.LinkingListener;
import com.mpl.payment.linking.MPLLinkingHandlerResolver;
import com.mpl.payment.linking.PaymentMethodLinker;
import com.mpl.payment.linking.ReactParamLinkingRouter;
import com.mpl.payment.paytm.PaymentTransactionCallbacks;
import com.mpl.payment.paytm.PaytmPayment;
import com.mpl.payment.razorpay.RazorPayGpayUpiActivity;
import com.mpl.payment.razorpay.RazorpayConstants;
import com.mpl.payment.routing.PaymentResultListener;
import com.mpl.payment.routing.PaymentRouter;
import com.mpl.payment.routing.PaymentRouter.PaymentRouterBuilder;
import com.mpl.payment.routing.RoutingConstants;
import com.mpl.payment.unlinking.PaymentMethodUnlinker;
import com.mpl.payment.unlinking.ReactParamUnLinkFlowResolver;
import com.mpl.payment.unlinking.ReactParamUnlinkingRouter;
import com.mpl.payment.unlinking.UnlinkingListener;
import com.mpl.payment.utils.Constants;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Moshi.Builder;
import com.xiaomi.mipush.sdk.MiPushMessage;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.PaymentConstants.ENVIRONMENT;
import in.juspay.services.HyperServices;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "AllPayment")
public class PaymentModule extends ReactContextBaseJavaModule {
    public static final int BRAINTREE_REQUEST_CODE = 2394;
    public static final int BT_HOSTED_FIELDS_REQUEST_CODE_V2 = 2397;
    public static final int JUSPAY_REQUEST_CODE = 2389;
    public static final String KYC_ERROR_CODE = "KYC_ERROR";
    public static final int PHONE_PE_DIRECT_REQUEST_CODE = 2395;
    public static final int RAZORPAY_REQUEST_CODE = 2392;
    public static final int SDK_PRESENT_CHECK = 2390;
    public static final String TAG = "AllPayment";
    public static final int TPSL_REQUEST_CODE = 2393;
    public Dialog alertDialog;
    public AuthTokenProvider authTokenProvider = new MPLAuthTokenProvider();
    public CardInputManager cardInputManager = null;
    public final ReactApplicationContext mContext;
    public Promise mGopayPromise;
    public PaymentRouter mPaymentRouter;
    public Promise mPromise;
    public final PaymentTransactionCallbacks mTransactionCallbacks = new PaymentTransactionCallbacks() {
        public void clientAuthenticationFailed(String str) {
            PaymentModule.this.mPromise.reject((String) Constant.CLIENT_AUTHENTICATION_FAILED, str);
            MLogger.e("AllPayment", "clientAuthenticationFailed inErrorMessage", str);
        }

        public void networkNotAvailable() {
            PaymentModule.this.mPromise.reject((String) Constant.NETWORK_NOT_AVAILABLE, (String) "Active Network is not present.");
            MLogger.e("AllPayment", Constant.NETWORK_NOT_AVAILABLE);
        }

        public void onBackPressedCancelTransaction() {
            PaymentModule.this.mPromise.reject((String) Constant.ON_BACK_PRESSED_CANCEL_TRANSACTION, (String) "User press back button.");
            MLogger.e("AllPayment", "onBackPressedCancelTransaction inErrorMessage");
        }

        public void onErrorLoadingWebPage(int i, String str, String str2) {
            Promise access$000 = PaymentModule.this.mPromise;
            access$000.reject((String) Constant.ON_ERROR_LOADING_WEB_PAGE, str + " Failed Url is " + str2);
            MLogger.e("AllPayment", "onErrorLoadingWebPage inErrorMessage", str);
        }

        public void onPaymentFail(Exception exc) {
            MLogger.d("AllPayment", "onPaymentFail() called with: e = [" + exc + CMapParser.MARK_END_OF_ARRAY);
            PaymentModule.this.mPromise.reject((String) Constant.ON_PAYMENT_FAIL, exc.toString());
        }

        public void onTransactionCancel(String str, Bundle bundle) {
            PaymentModule.this.mPromise.reject((String) Constant.ON_TRANSACTION_CANCEL, str);
            MLogger.e("AllPayment", "onTransactionCancel inErrorMessage", str);
        }

        public void onTransactionResponse(Bundle bundle) {
            boolean z = true;
            MLogger.d("AllPayment", "onTransactionResponse: ");
            if (bundle != null) {
                if (!bundle.containsKey("isFirstCallSuccess") || !bundle.getBoolean("isFirstCallSuccess", false)) {
                    z = false;
                }
                if (!z) {
                    JSONObject jSONObject = new JSONObject();
                    for (String str : bundle.keySet()) {
                        try {
                            jSONObject.put(str, JSONObject.wrap(bundle.get(str)));
                        } catch (JSONException e2) {
                            FirebaseCrashlytics.getInstance().recordException(e2);
                            PaymentModule.this.mPromise.reject((String) Constant.ON_PAYMENT_FAIL, e2.toString());
                        }
                    }
                    PaymentModule.this.mPromise.resolve(jSONObject.toString());
                    return;
                }
                return;
            }
            PaymentModule.this.mPromise.reject((String) Constant.ON_PAYMENT_FAIL, (String) "Empty response from server");
        }

        public void someUIErrorOccurred(String str) {
            PaymentModule.this.mPromise.reject((String) Constant.SOME_UI_ERROR_OCCURRED, str);
            MLogger.e("AllPayment", "someUIErrorOccurred inErrorMessage", str);
        }
    };
    public Moshi moshi = new Builder().build();
    public final MPLInstrumentationListener mplIntrumentationListener = new MPLInstrumentationListener() {
        public void onClevertapEvent(String str, String str2) {
            CleverTapAnalyticsUtils.sendEvent(str, str2);
        }

        public void onClevertapEvent(String str, HashMap<String, Object> hashMap) {
            CleverTapAnalyticsUtils.sendEvent(str, hashMap);
        }
    };
    public OnActivityResultModel onActivityResultModel;
    public PaymentCallBackListener paymentCallBackListener = new PaymentCallBackListener() {
        public boolean onBackPressed() {
            return HyperServiceWrapper.onBackPressed();
        }

        public void processResponce(Activity activity, int i, int i2, Intent intent) {
            MLogger.d("AllPayment", "processResponce: ", Integer.valueOf(i), Integer.valueOf(i2));
            PaymentModule.this.processOnActivityResult(activity, i, i2, intent);
        }
    };

    public static class OnActivityResultModel {
        public Intent data;
        public int requestCode;
        public int resultCode;

        public OnActivityResultModel(int i, int i2, Intent intent) {
            this.requestCode = i;
            this.resultCode = i2;
            this.data = intent;
        }
    }

    public PaymentModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(new ActivityEventListener() {
            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                MLogger.d("AllPayment", "onActivityResult: ", Integer.valueOf(i), Integer.valueOf(i2));
                PaymentModule.this.processOnActivityResult(activity, i, i2, intent);
            }

            public void onNewIntent(Intent intent) {
                MLogger.d("AllPayment", "onNewIntent: ");
            }
        });
        reactApplicationContext.addLifecycleEventListener(new LifecycleEventListener() {
            public void onHostDestroy() {
                MLogger.d("AllPayment", "onHostDestroy: ");
            }

            public void onHostPause() {
                MLogger.d("AllPayment", "onHostPause: ");
            }

            public void onHostResume() {
                MLogger.d("AllPayment", "onHostResume: ");
                PaymentModule.this.deliverOnActivityResultAfterOnResume();
            }
        });
        PaymentConfig.INSTANCE.setPaymentConfigProvider(new PaymentConfigProviderImpl());
    }

    /* access modifiers changed from: private */
    public void deliverOnActivityResultAfterOnResume() {
        OnActivityResultModel onActivityResultModel2 = this.onActivityResultModel;
        if (onActivityResultModel2 != null) {
            int i = onActivityResultModel2.requestCode;
            if (i == 2397) {
                CardInputManager cardInputManager2 = this.cardInputManager;
                if (cardInputManager2 != null) {
                    cardInputManager2.forwardOnActivityResult(i, onActivityResultModel2.resultCode, onActivityResultModel2.data);
                    this.onActivityResultModel = null;
                    this.cardInputManager = null;
                    return;
                }
                MLogger.d("AllPayment", "CardInputManagerWas null couldn't send Result to activity");
            }
        }
    }

    private String getAppIdForHyperVerge() {
        if (ConfigManager.getNormalConfig() != null) {
            return ConfigManager.getNormalConfig().optString("hyperVergeAppId", null);
        }
        return null;
    }

    private String getAppKeyForHyperVerge() {
        if (ConfigManager.getNormalConfig() != null) {
            return ConfigManager.getNormalConfig().optString("hyperVergeAppKey", null);
        }
        return null;
    }

    private String getJuspayClientId() {
        return ConfigManager.getNormalConfig() != null ? ConfigManager.getNormalConfig().optString("android.juspay.init.clientId", "mplgaming") : "mplgaming";
    }

    private String getJuspayEnvironment() {
        return MBuildConfigUtils.isSandboxMoneyInEnable() ? ENVIRONMENT.SANDBOX : ENVIRONMENT.PRODUCTION;
    }

    private String getJuspayMerchantId() {
        return ConfigManager.getNormalConfig() != null ? ConfigManager.getNormalConfig().optString("android.juspay.init.merchantId", "mplgaming") : "mplgaming";
    }

    private JusPayUpiAppListProvider getJuspayUpiAppListProvider() {
        return new JusPayUpiAppListProvider.Builder().withClientId(getJuspayClientId()).withMerchantId(getJuspayMerchantId()).withEnvironment(getJuspayEnvironment()).withFragmentActivty((FragmentActivity) getCurrentActivity()).withMPLInstrumentationListener(this.mplIntrumentationListener).withFetchCustomerIdUseCase(getFetchCustomerIdUseCase()).withMoshi(this.moshi).build();
    }

    /* access modifiers changed from: private */
    public void sendEventToCleverTap(String str, HashMap<String, Object> hashMap) {
        CleverTapAnalyticsUtils.sendEvent(str, hashMap);
    }

    /* access modifiers changed from: private */
    public void startCardVerification(String str, CardInputResult cardInputResult, final Promise promise) {
        try {
            if (getCurrentActivity() == null || !(getCurrentActivity() instanceof AppCompatActivity)) {
                promise.reject((Throwable) new Exception("Activity null or not appcompatactivity"));
                MLogger.d("AllPayment", "Activity null or not appcompatactivity");
                return;
            }
            MPLThreeDSHandlerResolver mPLThreeDSHandlerResolver = new MPLThreeDSHandlerResolver((AppCompatActivity) getCurrentActivity(), str, cardInputResult.getNonUpgradedCardToken(), cardInputResult.getRoutingPayloadJsonString(), cardInputResult);
            ArrayList arrayList = (ArrayList) CommonUtils.getCommonHeaders();
            arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
            MPLCardVerificationCharger mPLCardVerificationCharger = new MPLCardVerificationCharger(arrayList, MBuildConfigUtils.getMainUrl() + ApiEndPoints.CARD_CHARGE, cardInputResult.getCardInputType(), this.moshi, this.authTokenProvider);
            CardVerificationManager cardVerificationManager = new CardVerificationManager(str, cardInputResult.getNonUpgradedCardToken(), cardInputResult.getPaymentMode(), cardInputResult.getCardInputType(), this.moshi, mPLThreeDSHandlerResolver, mPLCardVerificationCharger);
            cardVerificationManager.attemptCardVerification(new CardVerificationResultListener() {
                public void onCardVerificationAttemptFail(String str) {
                    promise.resolve(str);
                    MLogger.d("AllPayment", str);
                }

                public void onCardVerificationAttemptSuccess(String str) {
                    promise.resolve(str);
                    MLogger.d("AllPayment", str);
                }
            });
        } catch (Exception e2) {
            String message = e2.getMessage() != null ? e2.getMessage() : "Exception when verifying card";
            MLogger.d("AllPayment", message);
            promise.reject((Throwable) new Exception(message));
        }
    }

    @ReactMethod
    public void checkSdkPresent(String str, final Promise promise) {
        if (getCurrentActivity() == null || !(getCurrentActivity() instanceof MPLReactContainerActivity)) {
            promise.reject((String) "fail", (String) "Current activity null or is not MPLReactContainerActivity");
            return;
        }
        ((MPLReactContainerActivity) getCurrentActivity()).setPaymentListener(this.paymentCallBackListener);
        try {
            final JSONObject jSONObject = new JSONObject();
            final String uuid = UUID.randomUUID().toString();
            final AnonymousClass7 r5 = new HyperServiceProcessPayloadListener() {
                public void onCleverTapEvent(String str, HashMap<String, Object> hashMap) {
                    PaymentModule.this.sendEventToCleverTap(str, hashMap);
                }

                public void onError(String str) {
                    promise.reject((String) "fail", str);
                    MLogger.d("AllPayment", GeneratedOutlineSupport.outline50("checkSdkPresent response-->", str));
                }

                public void onPayloadExtracted(JSONObject jSONObject) {
                    promise.resolve(jSONObject.toString());
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("checkSdkPresent response-->");
                    outline73.append(jSONObject.toString());
                    MLogger.d("AllPayment", outline73.toString());
                }
            };
            jSONObject.put(HyperServices.REQUEST_ID, uuid);
            jSONObject.put("service", Constants.JUSPAY_SERVICE_NAME);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("action", "isDeviceReady");
            jSONObject2.put("sdkPresent", "ANDROID_PHONEPE");
            jSONObject.put("payload", jSONObject2);
            MLogger.d("AllPayment", "checkPhonePeSdk: Playload Prepared---> " + jSONObject.toString());
            final String juspayMerchantId = getJuspayMerchantId();
            final String juspayClientId = getJuspayClientId();
            final String juspayEnvironment = getJuspayEnvironment();
            Activity currentActivity = getCurrentActivity();
            AnonymousClass8 r2 = new Runnable() {
                public void run() {
                    HyperServiceWrapper.process(jSONObject, r5, uuid, (FragmentActivity) PaymentModule.this.getCurrentActivity(), juspayMerchantId, juspayClientId, juspayEnvironment, PaymentModule.this.getFetchCustomerIdUseCase());
                }
            };
            currentActivity.runOnUiThread(r2);
        } catch (Exception e2) {
            Object[] objArr = new Object[1];
            objArr[0] = e2.getMessage() != null ? e2.getMessage() : "Exception in checkSdkPresent";
            MLogger.d(MLogger.TAG, objArr);
            promise.reject((String) "fail", (String) "Exception in checkSdkPresent");
        }
    }

    public FetchCustomerIdUseCase getFetchCustomerIdUseCase() {
        return new FetchCustomerIdUseCase(MBuildConfigUtils.getMainUrl() + ApiEndPoints.PARTNER_DETAILS, CommonUtils.getCommonHeaders(), this.authTokenProvider, this.moshi);
    }

    @ReactMethod
    public void getIdPictureForKyc(String str, String str2, final Promise promise) {
        KycIdProvider kycIdProvider = null;
        char c2 = 65535;
        try {
            int hashCode = str.hashCode();
            if (hashCode != -1985460011) {
                if (hashCode == -1909625271) {
                    if (str.equals("IDOLOGY")) {
                        c2 = 1;
                    }
                }
            } else if (str.equals("HYPERVERGE")) {
                c2 = 0;
            }
            if (c2 == 0) {
                String appIdForHyperVerge = getAppIdForHyperVerge();
                String appKeyForHyperVerge = getAppKeyForHyperVerge();
                if (appIdForHyperVerge == null || appKeyForHyperVerge == null) {
                    MLogger.d("KYC_ID_CAPTURE", "Check configs for appid and appkey");
                    promise.reject((String) KYC_ERROR_CODE, (String) "Check configs for appid and appkey");
                    return;
                }
                kycIdProvider = new HyperVergeKycCapture(appIdForHyperVerge, appKeyForHyperVerge, str2, getCurrentActivity());
            } else if (c2 == 1) {
                kycIdProvider = new IdologyKycIdCapture(getCurrentActivity());
            }
            if (kycIdProvider != null) {
                kycIdProvider.captureIds(str2, new IdCaptureListener() {
                    public void onError(String str) {
                        MLogger.d("KYC_ID_CAPTURE", GeneratedOutlineSupport.outline50("KYC ID CAPTURE ERROR --> ", str));
                        promise.reject((Throwable) new Exception(str));
                    }

                    public void onIdCaptureFail(String str) {
                        MLogger.d("KYC_ID_CAPTURE", GeneratedOutlineSupport.outline50("KYC ID CAPTURE FAILED --> ", str));
                        promise.resolve(str);
                    }

                    public void onIdCaptureSuccess(String str) {
                        MLogger.d("KYC_ID_CAPTURE", GeneratedOutlineSupport.outline50("KYC ID CAPTURE SUCCESS --> ", str));
                        promise.resolve(str);
                    }
                });
            } else {
                promise.reject((String) KYC_ERROR_CODE, "No provider found for " + str);
            }
        } catch (Exception e2) {
            String str3 = "KYC_EXCEPTION";
            if (!(("EXCEPTION->" + e2) == null || e2.getMessage() == null)) {
                str3 = e2.getMessage();
            }
            promise.reject((String) KYC_ERROR_CODE, str3);
            HashMap hashMap = new HashMap();
            hashMap.put("Error message", str3);
            sendEventToCleverTap("Kyc camera sdk error", hashMap);
        }
    }

    public String getName() {
        return "PaymentModule";
    }

    @ReactMethod
    public void getPackageVersionCode(String str, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || str == null) {
            promise.reject((Throwable) new Exception("Package name or currentActivity was null"));
            return;
        }
        int packageVersionCode = CommonUtils.getPackageVersionCode(str, currentActivity);
        if (packageVersionCode != 0) {
            promise.resolve(packageVersionCode + "");
            return;
        }
        promise.reject((Throwable) new Exception("App package not found on phone"));
    }

    @ReactMethod
    public void getUpiAppList(final Promise promise) {
        MLogger.d("AllPayment", "getUpiAppList called");
        if (getCurrentActivity() instanceof FragmentActivity) {
            JusPayUpiAppListProvider juspayUpiAppListProvider = getJuspayUpiAppListProvider();
            juspayUpiAppListProvider.addUpiListener(new UpiAppListener() {
                public void onAppListReceived(ArrayList<String> arrayList) {
                    try {
                        JSONArray jSONArray = new JSONArray(arrayList);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("upiAppList", jSONArray);
                        MLogger.d("AllPayment", "sending response to react--->" + jSONObject.toString());
                        promise.resolve(jSONObject.toString());
                    } catch (JSONException e2) {
                        Object[] objArr = new Object[1];
                        objArr[0] = e2.getMessage() != null ? e2.getMessage() : "JSONException";
                        MLogger.d("AllPayment", objArr);
                        promise.reject((Throwable) new Exception("Exception when creating response in getupiAppList"));
                    }
                }

                public void onError(String str) {
                    MLogger.d("AllPayment", GeneratedOutlineSupport.outline50("failed to get upi list---->", str));
                    promise.reject((Throwable) new Exception(str));
                }
            });
            juspayUpiAppListProvider.getValidUpiApps();
            return;
        }
        MLogger.d("AllPayment", "Current Activity not a FragmentActivity!");
        promise.reject((Throwable) new Exception("Current Activity not a FragmentActivity!"));
    }

    @ReactMethod
    public void isUpiRegistered(String str, Promise promise) {
        boolean z;
        MLogger.d("AllPayment", "isUpiRegistered: ", str);
        if (str != null && str.contains("phonepe")) {
            str = MBuildConfigUtils.isSandboxMoneyInEnable() ? "com.phonepe.app.preprod" : "com.phonepe.app";
        }
        Uri parse = Uri.parse(String.format("%s://%s", new Object[]{"upi", "pay"}));
        Intent intent = new Intent();
        intent.setData(parse);
        PackageManager packageManager = this.mContext.getPackageManager();
        if (packageManager != null) {
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null) {
                z = false;
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    String str2 = resolveInfo.activityInfo.packageName;
                    if (str2 != null && !str2.isEmpty() && str != null && str.matches(str2)) {
                        z = true;
                    }
                }
                MLogger.d("AllPayment", "isUpiRegistered: ", Boolean.valueOf(z));
                promise.resolve(Boolean.valueOf(z));
            }
        }
        z = false;
        MLogger.d("AllPayment", "isUpiRegistered: ", Boolean.valueOf(z));
        promise.resolve(Boolean.valueOf(z));
    }

    @ReactMethod
    public void linkInstrument(String str, final Promise promise) {
        try {
            String juspayMerchantId = getJuspayMerchantId();
            String juspayClientId = getJuspayClientId();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PaymentConstants.MERCHANT_ID_CAMEL, juspayMerchantId);
            jSONObject.put(PaymentConstants.CLIENT_ID_CAMEL, juspayClientId);
            jSONObject.put(PaymentConstants.ENV, getJuspayEnvironment());
            String jSONObject2 = jSONObject.toString();
            ReactParamLinkingRouter reactParamLinkingRouter = new ReactParamLinkingRouter(this.moshi, str);
            if (getCurrentActivity() != null) {
                MPLLinkingHandlerResolver mPLLinkingHandlerResolver = new MPLLinkingHandlerResolver(this.moshi, str, jSONObject2, getCurrentActivity(), getFetchCustomerIdUseCase());
                new PaymentMethodLinker(reactParamLinkingRouter, mPLLinkingHandlerResolver, new LinkingListener() {
                    public void onCleverTapEvent(String str, HashMap<String, Object> hashMap) {
                        PaymentModule.this.sendEventToCleverTap(str, hashMap);
                    }

                    public void onLinkingError(String str) {
                        MLogger.d("AllPayment", GeneratedOutlineSupport.outline50("In onLinkingError-->", str));
                        promise.reject((Throwable) new Exception(str));
                    }

                    public void onLinkingFailed(String str) {
                        MLogger.d("AllPayment", GeneratedOutlineSupport.outline50("In onLinkingFailed-->", str));
                        promise.resolve(str);
                    }

                    public void onLinkingSuccessful(String str) {
                        MLogger.d("AllPayment", GeneratedOutlineSupport.outline50("In onLinkingSuccessful-->", str));
                        promise.resolve(str);
                    }
                }).linkPaymentMethod();
                return;
            }
            MLogger.d("AllPayment", "Current activity was null when linking");
            promise.reject((Throwable) new Exception("Current activity was null when linking"));
        } catch (Exception e2) {
            MLogger.d("AllPayment", GeneratedOutlineSupport.outline50("Exception when linking--->", e2.getMessage() != null ? e2.getMessage() : "Exception when linking"));
            promise.reject((Throwable) e2);
        }
    }

    @ReactMethod
    public void makePayment(String str, String str2, String str3, String str4, String str5, String str6, Promise promise) {
        try {
            MLogger.d("AllPayment", "makePayment() called with: url = [" + str + "], paymentPGatWay = [" + str2 + "], amount = [" + str3 + "], token = [" + str4 + "], number = [" + str5 + CMapParser.MARK_END_OF_ARRAY);
            this.mPromise = promise;
            if (!this.mContext.hasCurrentActivity() || this.mContext.getCurrentActivity() == null) {
                MLogger.e("AllPayment", "Current Activity is null");
                promise.reject((String) "Activity is null", (String) "Activity is null");
                return;
            }
            PaytmPayment.Builder addHeader = new PaytmPayment.Builder().setContext(this.mContext.getCurrentActivity()).setNumber(str5).setPaymentGatWay(str2).setAmount(str3).setTransactionCallbacks(this.mTransactionCallbacks).setUrl(str).addHeader("Accept", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE).addHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE);
            PaytmPayment build = addHeader.addHeader("Authorization", "Bearer " + str4).setHeader(CommonUtils.getCommonHeaders()).build();
            if (str6 == null || TextUtils.isEmpty(str6)) {
                build.initiatePayment();
            } else {
                build.initiatePayment(str6);
            }
        } catch (Exception unused) {
        }
    }

    @ReactMethod
    public void makePaymentGoPay(String str, Promise promise) {
        promise.resolve("not in use");
    }

    @ReactMethod
    public void makePaymentRazorPay(String str, Promise promise) {
        String str2;
        String str3;
        String str4 = "";
        MLogger.d("AllPayment", "makePaymentRazorPay: ", str);
        this.mPromise = promise;
        try {
            if (getCurrentActivity() != null) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("amount", 0);
                String optString = jSONObject.optString("pg", str4);
                String optString2 = jSONObject.optString("url", str4);
                String optString3 = jSONObject.optString("payload", str4);
                if (TextUtils.isEmpty(optString3) || !CommonUtils.isJSONValid(optString3)) {
                    str3 = str4;
                    str2 = str3;
                } else {
                    JSONObject jSONObject2 = new JSONObject(optString3);
                    str3 = jSONObject2.optString("opName");
                    str2 = jSONObject2.optString("paymentMethod");
                }
                if (jSONObject.has(MiPushMessage.KEY_EXTRA) && jSONObject.optString(MiPushMessage.KEY_EXTRA) != null && !TextUtils.isEmpty(jSONObject.optString(MiPushMessage.KEY_EXTRA))) {
                    str4 = jSONObject.optString(MiPushMessage.KEY_EXTRA);
                }
                if (TextUtils.isEmpty(str3)) {
                    promise.reject((String) "fail", (String) "opName empty");
                } else if ("gpayUpiHsTxn".equalsIgnoreCase(str3)) {
                    Intent intent = new Intent(getCurrentActivity(), RazorPayGpayUpiActivity.class);
                    intent.putExtra(RazorpayConstants.BUNDLE_RP_WV_ACTIVITY_AMOUNT, String.valueOf(optInt));
                    intent.putExtra(RazorpayConstants.BUNDLE_RP_WV_ACTIVITY_PG, optString);
                    intent.putExtra(RazorpayConstants.BUNDLE_RP_WV_URL, optString2);
                    intent.putExtra(RazorpayConstants.BUNDLE_RP_WV_BANK, str2);
                    intent.putExtra(RazorpayConstants.BUNDLE_RP_WV_AUTH, "Bearer " + MSharedPreferencesUtils.getAccessUserToken());
                    intent.putExtra(RazorpayConstants.BUNDLE_RP_WV_ISLOGENABLED, MBuildConfigUtils.isLogEnabled());
                    intent.putExtra(RazorpayConstants.BUNDLE_RP_WV_TRANSACTION_TYPE, str3);
                    intent.putExtra(RazorpayConstants.BUNDLE_RP_WV_COUPON_DATA, str4);
                    getCurrentActivity().startActivityForResult(intent, RAZORPAY_REQUEST_CODE);
                } else {
                    promise.reject((String) "fail", "opName unknown, opName is--->" + str3);
                }
            } else {
                MLogger.e("AllPayment", "Current Activity is null");
                promise.reject((String) "fail", (String) "Activity is null");
            }
        } catch (Exception e2) {
            MLogger.e("AllPayment", "makePaymentRazorPay", e2);
            promise.reject((String) "fail", (String) "Parsing Exception");
        }
    }

    @ReactMethod
    public void makePaymentUPoint(String str, Promise promise) throws JSONException {
        promise.resolve("not in use");
    }

    @ReactMethod
    public void makeV2Payment(String str, Promise promise) {
        this.mPromise = promise;
        if (getCurrentActivity() != null && (getCurrentActivity() instanceof MPLReactContainerActivity)) {
            ((MPLReactContainerActivity) getCurrentActivity()).setPaymentListener(this.paymentCallBackListener);
        }
        boolean z = true;
        MLogger.d("AllPayment", GeneratedOutlineSupport.outline50("In makeV2Payment reactJsonPayload is---->", str));
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("https://dweb.mpl.live/");
            jSONObject.put("endUrls", jSONArray);
            if (MBuildConfigUtils.isSandboxMoneyInEnable()) {
                z = false;
            }
            jSONObject.put("isProduction", z);
            jSONObject.put("isSanboxMoneyInEnabled", MBuildConfigUtils.isSandboxMoneyInEnable());
            jSONObject.put("requestCode", JUSPAY_REQUEST_CODE);
            jSONObject.put("tpsl_realtime_status_url", MBuildConfigUtils.getMainUrl() + ApiEndPoints.MONEY_PAYMENT_TPSL_STATUS);
            jSONObject.put("complete_deposit_url", MBuildConfigUtils.getMainUrl() + ApiEndPoints.COMPLETE_DEPOSIT);
            jSONObject.put("isLoggingEnabled", MBuildConfigUtils.isLogEnabled());
            jSONObject.put("phonePeDirectRequestCode", PHONE_PE_DIRECT_REQUEST_CODE);
            String juspayMerchantId = getJuspayMerchantId();
            String juspayClientId = getJuspayClientId();
            String juspayEnvironment = getJuspayEnvironment();
            jSONObject.put(RoutingConstants.ANDROID_REACT_JUSPAY_MERCHANT_ID, juspayMerchantId);
            jSONObject.put(RoutingConstants.ANDROID_REACT_JUSPAY_CLIENT_ID, juspayClientId);
            jSONObject.put(RoutingConstants.ANDROID_REACT_JUSPAY_ENVIRONMENT, juspayEnvironment);
            PaymentRouter build = new PaymentRouterBuilder().setActivity(getCurrentActivity()).setRazorpayRequestCode(RAZORPAY_REQUEST_CODE).setTpslRequestCode(TPSL_REQUEST_CODE).setBraintreeRequestCode(BRAINTREE_REQUEST_CODE).setPaymentResultListener(new PaymentResultListener() {
                public void onCleverTapEvent(String str, HashMap<String, Object> hashMap) {
                    PaymentModule.this.sendEventToCleverTap(str, hashMap);
                }

                public void onMoneyInFailed(String str) {
                    PaymentModule.this.mPromise.reject((String) "fail", str);
                    MLogger.d("AllPayment", GeneratedOutlineSupport.outline50("onMoneyInFailed------>", str));
                }

                public void onMoneyInVpnDetected(String str) {
                    NetworkModule.processResponse(null, str);
                    PaymentModule.this.mPromise.reject((String) "fail", (String) "status error. status 5000 received from miv2");
                }

                public void onPaymentFailed(String str) {
                    PaymentModule.this.mPromise.resolve(str);
                    MLogger.d("AllPayment", GeneratedOutlineSupport.outline50("onPaymentFailed------>", str));
                }

                public void onPaymentSuccessful(String str) {
                    if (TextUtils.isEmpty(str) || !str.contains("isFirstCallSuccess")) {
                        PaymentModule.this.mPromise.resolve(str);
                    } else {
                        MLogger.d("AllPayment", "onPaymentSuccessful: juspay response ");
                    }
                    MLogger.d("AllPayment", GeneratedOutlineSupport.outline50("onPaymentSuccessful------>", str));
                }

                public void onPaymentFailed(Exception exc) {
                    PaymentModule.this.mPromise.reject((Throwable) exc);
                    MLogger.d("AllPayment", "onPaymentFailed------>");
                }
            }).addHeader("Accept", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE).addHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE).setHeaders((ArrayList) CommonUtils.getCommonHeaders()).setAuthTokenProvider(this.authTokenProvider).setFetchCustomerIdUseCase(getFetchCustomerIdUseCase()).build();
            this.mPaymentRouter = build;
            build.processPayment(jSONObject.toString());
        } catch (Exception e2) {
            this.mPromise.reject((String) "fail", e2.getMessage());
        }
    }

    public void processOnActivityResult(Activity activity, int i, int i2, Intent intent) {
        MLogger.d("AllPayment", "processOnActivityResult: ");
        if (i == 2393) {
            PaymentRouter paymentRouter = this.mPaymentRouter;
            if (paymentRouter != null) {
                paymentRouter.onActivityResultForwarder(i, i2, intent);
                return;
            }
            Promise promise = this.mPromise;
            if (promise != null) {
                promise.reject((String) "fail", (String) "payment router null");
            }
        } else if (i == 2392) {
            Promise promise2 = this.mPromise;
            if (promise2 == null) {
                return;
            }
            if (intent == null) {
                promise2.reject((String) "fail", (String) "razorpay onActivity data empty");
            } else if (i2 == -1) {
                Bundle extras = intent.getExtras();
                int i3 = extras.getInt(RazorpayConstants.RESULT_RP_WV_RESULT_TYPE, 0);
                String string = extras.getString(RazorpayConstants.RESULT_RP_WV_RESULT_STRING);
                if (i3 == 1) {
                    this.mPromise.reject((String) "fail", string);
                    MLogger.d("AllPayment", GeneratedOutlineSupport.outline50("payment failed genric error--->", string));
                } else if (i3 == 2) {
                    String string2 = extras.getString(RazorpayConstants.RESULT_RP_WV_RESULT_MPL_ORDER_ID);
                    MLogger.d("AllPayment", GeneratedOutlineSupport.outline50("Razorpay payment failed, razorpay error ", string2));
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("status", GopayLinkingHandler.STATUS_FAIL);
                        jSONObject.put("orderId", string2);
                        jSONObject.put("error", string);
                        jSONObject.put("mplPlugin", RoutingConstants.MI_PLUGIN_VALUE_RAZORPAY);
                        this.mPromise.resolve(jSONObject.toString());
                    } catch (Exception unused) {
                        this.mPromise.reject((String) "fail", (String) "Failed to parse activity result");
                    }
                } else if (i3 == 3) {
                    String string3 = extras.getString(RazorpayConstants.RESULT_RP_WV_RESULT_MPL_ORDER_ID);
                    MLogger.d("AllPayment", GeneratedOutlineSupport.outline50("payment success ", string3));
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("status", "SUCCESS");
                        jSONObject2.put("orderId", string3);
                        jSONObject2.put("mplPlugin", RoutingConstants.MI_PLUGIN_VALUE_RAZORPAY);
                        this.mPromise.resolve(jSONObject2.toString());
                    } catch (Exception unused2) {
                        this.mPromise.reject((String) "fail", (String) "Failed to parse activity result");
                    }
                } else {
                    Promise promise3 = this.mPromise;
                    promise3.reject((String) "fail", "razorpay result type not found, result type is-->" + i3);
                }
            } else if (i2 == 0) {
                promise2.reject((String) "fail", (String) "razorpay results cancelled");
            }
        } else if (i == 2394 || i == 2395) {
            PaymentRouter paymentRouter2 = this.mPaymentRouter;
            if (paymentRouter2 != null) {
                paymentRouter2.onActivityResultForwarder(i, i2, intent);
                return;
            }
            Promise promise4 = this.mPromise;
            if (promise4 != null) {
                promise4.reject((String) "fail", (String) "payment router null");
            }
        } else if (i == 2397) {
            this.onActivityResultModel = new OnActivityResultModel(i, i2, intent);
        }
    }

    @ReactMethod
    public void unlinkInstrument(final String str, final Promise promise) {
        try {
            ReactParamUnlinkingRouter reactParamUnlinkingRouter = new ReactParamUnlinkingRouter(str, this.moshi);
            Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                new PaymentMethodUnlinker(reactParamUnlinkingRouter, new ReactParamUnLinkFlowResolver(currentActivity, str, this.moshi), new UnlinkingListener() {
                    public void onUnlinkingError(String str) {
                        MLogger.d("AllPayment", GeneratedOutlineSupport.outline50("In onLinkingError-->", str));
                        promise.reject((Throwable) new Exception(str));
                    }

                    public void onUnlinkingFailed(String str) {
                        MLogger.d("AllPayment", GeneratedOutlineSupport.outline50("in  onUnlinkingFailed", str));
                        promise.resolve(str);
                    }

                    public void onUnlinkingSuccessful(String str) {
                        MLogger.d("AllPayment", GeneratedOutlineSupport.outline50("in onUnlinkingSuccessful-->", str));
                        promise.resolve(str);
                    }
                }).unlinkPaymentMethod();
                return;
            }
            MLogger.d("AllPayment", "Current activity was null when unlinking");
            promise.reject((Throwable) new Exception("Current activity was null when unlinking"));
        } catch (Exception e2) {
            MLogger.d("AllPayment", GeneratedOutlineSupport.outline50("Exception when unlinking--->", e2.getMessage() != null ? e2.getMessage() : "Exception when unlinking"));
            promise.reject((Throwable) e2);
        }
    }

    @ReactMethod
    public void verifyCard(final String str, final Promise promise) {
        try {
            ArrayList arrayList = (ArrayList) CommonUtils.getCommonHeaders();
            arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
            MPLEndpointCardInputRouter mPLEndpointCardInputRouter = new MPLEndpointCardInputRouter(MBuildConfigUtils.getMainUrl() + ApiEndPoints.CARD_INPUT_ROUTING, str, arrayList, this.moshi, this.authTokenProvider);
            CardInputManager cardInputManager2 = new CardInputManager(mPLEndpointCardInputRouter, new MPLHostedFieldHandlerResolver(this.moshi, getCurrentActivity(), BT_HOSTED_FIELDS_REQUEST_CODE_V2, this.mplIntrumentationListener), str, this.moshi);
            this.cardInputManager = cardInputManager2;
            cardInputManager2.startCardCollection(new CardInputResultListener() {
                public void onCardInputError(String str) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("status", "FAILED");
                        jSONObject.put("reason", str);
                        promise.resolve(jSONObject.toString());
                        MLogger.d("AllPayment", jSONObject.toString());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }

                public void onCardInputFailed(String str) {
                    promise.resolve(str);
                }

                public void onCardInputSuccessFull(CardInputResult cardInputResult) {
                    PaymentModule.this.startCardVerification(str, cardInputResult, promise);
                }
            });
        } catch (Exception e2) {
            String message = e2.getMessage() != null ? e2.getMessage() : "Exception when imputing card for verification";
            MLogger.d("AllPayment", message);
            promise.reject((Throwable) new Exception(message));
        }
    }
}

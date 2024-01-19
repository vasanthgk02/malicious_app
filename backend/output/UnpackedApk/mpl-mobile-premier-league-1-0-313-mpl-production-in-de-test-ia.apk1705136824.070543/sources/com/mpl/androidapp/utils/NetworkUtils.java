package com.mpl.androidapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.crimzoncode.tqcontests.util.TQConstants;
import com.facebook.react.bridge.ColorPropConverter;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.appsanity.APIHealthChecker;
import com.mpl.androidapp.appsanity.APIHealthCheckerImpl;
import com.mpl.androidapp.appsanity.APPSanityModel;
import com.mpl.androidapp.deviceinfo.DeviceInfo;
import com.mpl.androidapp.react.modules.NetworkModule;
import com.mpl.androidapp.updater.repo.DownloadHelper;
import com.mpl.androidapp.updater.util.GEUtil;
import com.mpl.androidapp.updater.util.StatusType;
import com.mpl.androidapp.updater.util.UpdaterConstant;
import com.mpl.androidapp.utils.Constant.ApiEndPoints;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.network.modules.request.MOKHttpPostRequest;
import com.mpl.network.modules.request.MOkHttpDownloadRequest;
import com.mpl.network.modules.request.MOkHttpGetRequest.Builder;
import com.mpl.network.modules.request.RequestPriority;
import com.mpl.network.modules.utils.MException;
import com.razorpay.AnalyticsConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkUtils {
    public static final String TAG = "NetworkUtils";

    public static void cancelRequest(String str) {
        MClient.cancelCallWithTag(str);
    }

    public static void doGetRequest(NetworkCallParams networkCallParams, final IResponseListener<String> iResponseListener, String str) {
        final APIHealthCheckerImpl aPIHealthCheckerImpl = new APIHealthCheckerImpl();
        final APPSanityModel initAppSanity = aPIHealthCheckerImpl.initAppSanity(networkCallParams.getUrl());
        Builder tag = new Builder().setUrl(networkCallParams.getUrl()).setHeaders(networkCallParams.getHeaders()).setQueryParams(networkCallParams.getQueryParams()).setResponseListener(new IResponseListener<String>() {
            public void onProcessHeader(ArrayList<MHeader> arrayList) {
                IResponseListener iResponseListener = iResponseListener;
                if (iResponseListener != null) {
                    iResponseListener.onProcessHeader(arrayList);
                }
            }

            public void onResponseFail(Exception exc) {
                APIHealthChecker aPIHealthChecker = APIHealthChecker.this;
                if (aPIHealthChecker != null) {
                    aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                }
                IResponseListener iResponseListener = iResponseListener;
                if (iResponseListener != null) {
                    iResponseListener.onResponseFail(exc);
                }
                APIHealthChecker aPIHealthChecker2 = APIHealthChecker.this;
                if (aPIHealthChecker2 != null) {
                    aPIHealthChecker2.processAPIHealthStatusFromFailedResponse(initAppSanity, exc);
                }
            }

            public void progressResponse(long j, long j2, boolean z) {
                IResponseListener iResponseListener = iResponseListener;
                if (iResponseListener != null) {
                    iResponseListener.progressResponse(j, j2, z);
                }
            }

            public void onResponseSuccess(String str) {
                APIHealthChecker aPIHealthChecker = APIHealthChecker.this;
                if (aPIHealthChecker != null) {
                    aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                }
                IResponseListener iResponseListener = iResponseListener;
                if (iResponseListener != null) {
                    iResponseListener.onResponseSuccess(str);
                }
                NetworkModule.processResponse(null, str);
                APIHealthChecker aPIHealthChecker2 = APIHealthChecker.this;
                if (aPIHealthChecker2 != null) {
                    aPIHealthChecker2.processAPIHealthStatusFromSuccessFullResponse(initAppSanity, str);
                }
            }
        }).setTag(str);
        tag.setConnectTimeout(Math.max(networkCallParams.getConnectionTimeOut(), 10000));
        tag.setReadTimeout(Math.max(networkCallParams.getReadTimeOut(), 10000));
        tag.setWriteTimeout(Math.max(networkCallParams.getWriteTimeOut(), 10000));
        tag.setPingInterval(Math.max(networkCallParams.getPingInterval(), 10000));
        tag.setRetryOnConnectionFailure(networkCallParams.isRetryOption());
        if (!TextUtils.isEmpty(networkCallParams.getHost())) {
            tag.setHost(networkCallParams.getHost());
        }
        if (networkCallParams.getPriority() == 1) {
            tag.setRequestPriority(RequestPriority.LOW);
        } else {
            tag.setRequestPriority(RequestPriority.HIGH);
        }
        if (!TextUtils.isEmpty(networkCallParams.getScheme())) {
            tag.setScheme(networkCallParams.getScheme());
        }
        if (networkCallParams.getPort() > 0) {
            tag.setPort(networkCallParams.getPort());
        }
        MClient.executeAsync(tag.build());
    }

    public static void doPostRequest(NetworkCallParams networkCallParams, final IResponseListener<String> iResponseListener, String str) {
        final APIHealthCheckerImpl aPIHealthCheckerImpl = new APIHealthCheckerImpl();
        final APPSanityModel initAppSanity = aPIHealthCheckerImpl.initAppSanity(networkCallParams.getUrl());
        MOKHttpPostRequest.Builder tag = new MOKHttpPostRequest.Builder().setUrl(networkCallParams.getUrl()).setHeaders(networkCallParams.getHeaders()).setQueryParams(networkCallParams.getQueryParams()).setResponseListener(new IResponseListener<String>() {
            public void onProcessHeader(ArrayList<MHeader> arrayList) {
                iResponseListener.onProcessHeader(arrayList);
            }

            public void onResponseFail(Exception exc) {
                APIHealthChecker aPIHealthChecker = APIHealthChecker.this;
                if (aPIHealthChecker != null) {
                    aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                }
                iResponseListener.onResponseFail(exc);
                APIHealthChecker aPIHealthChecker2 = APIHealthChecker.this;
                if (aPIHealthChecker2 != null) {
                    aPIHealthChecker2.processAPIHealthStatusFromFailedResponse(initAppSanity, exc);
                }
            }

            public void progressResponse(long j, long j2, boolean z) {
            }

            public void onResponseSuccess(String str) {
                APIHealthChecker aPIHealthChecker = APIHealthChecker.this;
                if (aPIHealthChecker != null) {
                    aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                }
                iResponseListener.onResponseSuccess(str);
                NetworkModule.processResponse(null, str);
                APIHealthChecker aPIHealthChecker2 = APIHealthChecker.this;
                if (aPIHealthChecker2 != null) {
                    aPIHealthChecker2.processAPIHealthStatusFromSuccessFullResponse(initAppSanity, str);
                }
            }
        }).setTag(str);
        tag.setConnectTimeout(Math.max(networkCallParams.getConnectionTimeOut(), 10000));
        tag.setReadTimeout(Math.max(networkCallParams.getReadTimeOut(), 10000));
        tag.setWriteTimeout(Math.max(networkCallParams.getWriteTimeOut(), 10000));
        tag.setPingInterval(Math.max(networkCallParams.getPingInterval(), 10000));
        tag.setRetryOnConnectionFailure(networkCallParams.isRetryOption());
        if (!TextUtils.isEmpty(networkCallParams.getHost())) {
            tag.setHost(networkCallParams.getHost());
        }
        if (networkCallParams.getPriority() == 1) {
            tag.setRequestPriority(RequestPriority.LOW);
        } else {
            tag.setRequestPriority(RequestPriority.HIGH);
        }
        if (!TextUtils.isEmpty(networkCallParams.getScheme())) {
            tag.setScheme(networkCallParams.getScheme());
        }
        if (networkCallParams.getPort() > 0) {
            tag.setPort(networkCallParams.getPort());
        }
        if (!TextUtils.isEmpty(networkCallParams.getRequestBody())) {
            tag.setPostJsonObject(networkCallParams.getRequestBody());
        }
        if (!TextUtils.isEmpty(networkCallParams.getContent())) {
            tag.setBytes(networkCallParams.getContent().getBytes());
        }
        if (!TextUtils.isEmpty(networkCallParams.getFilePath())) {
            tag.setFile(new File(networkCallParams.getFilePath()));
        }
        if (TextUtils.isEmpty(networkCallParams.getRequestBody()) && TextUtils.isEmpty(networkCallParams.getContent()) && TextUtils.isEmpty(networkCallParams.getFilePath())) {
            MLogger.d(TAG, "All types are empty for post request so sending empty json body for post");
            tag.setPostJsonObject("{}");
        }
        MClient.executeAsync(tag.build());
    }

    public static void doUserInfoPostRequest(NetworkCallParams networkCallParams, List<MHeader> list, final IResponseListener<String> iResponseListener, String str) {
        final APIHealthCheckerImpl aPIHealthCheckerImpl = new APIHealthCheckerImpl();
        final APPSanityModel initAppSanity = aPIHealthCheckerImpl.initAppSanity(networkCallParams.getUrl());
        MOKHttpPostRequest.Builder tag = new MOKHttpPostRequest.Builder().setUrl(networkCallParams.getUrl()).setHeaders(list).setQueryParams(networkCallParams.getQueryParams()).setResponseListener(new IResponseListener<String>() {
            public void onProcessHeader(ArrayList<MHeader> arrayList) {
                iResponseListener.onProcessHeader(arrayList);
            }

            public void onResponseFail(Exception exc) {
                APIHealthChecker aPIHealthChecker = APIHealthChecker.this;
                if (aPIHealthChecker != null) {
                    aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                }
                iResponseListener.onResponseFail(exc);
                APIHealthChecker aPIHealthChecker2 = APIHealthChecker.this;
                if (aPIHealthChecker2 != null) {
                    aPIHealthChecker2.processAPIHealthStatusFromFailedResponse(initAppSanity, exc);
                }
            }

            public void progressResponse(long j, long j2, boolean z) {
            }

            public void onResponseSuccess(String str) {
                APIHealthChecker aPIHealthChecker = APIHealthChecker.this;
                if (aPIHealthChecker != null) {
                    aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                }
                iResponseListener.onResponseSuccess(str);
                NetworkModule.processResponse(null, str);
                APIHealthChecker aPIHealthChecker2 = APIHealthChecker.this;
                if (aPIHealthChecker2 != null) {
                    aPIHealthChecker2.processAPIHealthStatusFromSuccessFullResponse(initAppSanity, str);
                }
            }
        }).setTag(str);
        tag.setConnectTimeout(Math.max(networkCallParams.getConnectionTimeOut(), 10000));
        tag.setReadTimeout(Math.max(networkCallParams.getReadTimeOut(), 10000));
        tag.setWriteTimeout(Math.max(networkCallParams.getWriteTimeOut(), 10000));
        tag.setPingInterval(Math.max(networkCallParams.getPingInterval(), 10000));
        tag.setRetryOnConnectionFailure(networkCallParams.isRetryOption());
        if (!TextUtils.isEmpty(networkCallParams.getHost())) {
            tag.setHost(networkCallParams.getHost());
        }
        if (networkCallParams.getPriority() == 1) {
            tag.setRequestPriority(RequestPriority.LOW);
        } else {
            tag.setRequestPriority(RequestPriority.HIGH);
        }
        if (!TextUtils.isEmpty(networkCallParams.getScheme())) {
            tag.setScheme(networkCallParams.getScheme());
        }
        if (networkCallParams.getPort() > 0) {
            tag.setPort(networkCallParams.getPort());
        }
        if (!TextUtils.isEmpty(networkCallParams.getRequestBody())) {
            tag.setPostJsonObject(networkCallParams.getRequestBody());
        }
        if (!TextUtils.isEmpty(networkCallParams.getContent())) {
            tag.setBytes(networkCallParams.getContent().getBytes());
        }
        if (!TextUtils.isEmpty(networkCallParams.getFilePath())) {
            tag.setFile(new File(networkCallParams.getFilePath()));
        }
        if (TextUtils.isEmpty(networkCallParams.getRequestBody()) && TextUtils.isEmpty(networkCallParams.getContent()) && TextUtils.isEmpty(networkCallParams.getFilePath())) {
            MLogger.d(TAG, "All types are empty for post request so sending empty json body for post");
            tag.setPostJsonObject("{}");
        }
        MClient.executeAsync(tag.build());
    }

    public static void downloadFile(NetworkCallParams networkCallParams, final IResponseListener<String> iResponseListener) {
        File file = new File(networkCallParams.getDestinationFilePath());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                MLogger.printStackTrace(e2);
            }
        }
        final APIHealthCheckerImpl aPIHealthCheckerImpl = new APIHealthCheckerImpl();
        final APPSanityModel initAppSanity = aPIHealthCheckerImpl.initAppSanity(networkCallParams.getUrl());
        MOkHttpDownloadRequest.Builder responseListener = new MOkHttpDownloadRequest.Builder().setUrl(networkCallParams.getUrl()).setHeaders(networkCallParams.getHeaders()).setQueryParams(networkCallParams.getQueryParams()).setDestFile(file).setDestFileName(networkCallParams.getDestinationFileName()).setResponseListener(new IResponseListener<String>() {
            public void onProcessHeader(ArrayList<MHeader> arrayList) {
                IResponseListener iResponseListener = iResponseListener;
                if (iResponseListener != null) {
                    iResponseListener.onProcessHeader(arrayList);
                }
            }

            public void onResponseFail(Exception exc) {
                APIHealthChecker aPIHealthChecker = APIHealthChecker.this;
                if (aPIHealthChecker != null) {
                    aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                }
                IResponseListener iResponseListener = iResponseListener;
                if (iResponseListener != null) {
                    iResponseListener.onResponseFail(exc);
                }
                APIHealthChecker aPIHealthChecker2 = APIHealthChecker.this;
                if (aPIHealthChecker2 != null) {
                    aPIHealthChecker2.processAPIHealthStatusFromFailedResponse(initAppSanity, exc);
                }
            }

            public void progressResponse(long j, long j2, boolean z) {
                IResponseListener iResponseListener = iResponseListener;
                if (iResponseListener != null) {
                    iResponseListener.progressResponse(j, j2, z);
                }
            }

            public void onResponseSuccess(String str) {
                APIHealthChecker aPIHealthChecker = APIHealthChecker.this;
                if (aPIHealthChecker != null) {
                    aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                }
                IResponseListener iResponseListener = iResponseListener;
                if (iResponseListener != null) {
                    iResponseListener.onResponseSuccess(str);
                }
                NetworkModule.processResponse(null, str);
                APIHealthChecker aPIHealthChecker2 = APIHealthChecker.this;
                if (aPIHealthChecker2 != null) {
                    aPIHealthChecker2.processAPIHealthStatusFromSuccessFullResponse(initAppSanity, str);
                }
            }
        });
        if (!TextUtils.isEmpty(networkCallParams.getTag())) {
            responseListener.setTag(networkCallParams.getTag());
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("post_request_");
            outline73.append(System.currentTimeMillis());
            responseListener.setTag(outline73.toString());
        }
        if (networkCallParams.getConnectionTimeOut() > 0) {
            responseListener.setConnectTimeout(networkCallParams.getConnectionTimeOut());
        } else {
            responseListener.setConnectTimeout(10000);
        }
        if (networkCallParams.getReadTimeOut() > 0) {
            responseListener.setReadTimeout(networkCallParams.getReadTimeOut());
        } else {
            responseListener.setReadTimeout(10000);
        }
        if (networkCallParams.getWriteTimeOut() > 0) {
            responseListener.setWriteTimeout(networkCallParams.getWriteTimeOut());
        } else {
            responseListener.setWriteTimeout(10000);
        }
        if (networkCallParams.getPingInterval() > 0) {
            responseListener.setPingInterval(networkCallParams.getPingInterval());
        } else {
            responseListener.setPingInterval(10000);
        }
        responseListener.setRetryOnConnectionFailure(networkCallParams.isRetryOption());
        if (!TextUtils.isEmpty(networkCallParams.getHost())) {
            responseListener.setHost(networkCallParams.getHost());
        }
        if (networkCallParams.getPriority() == 1) {
            responseListener.setRequestPriority(RequestPriority.LOW);
        } else {
            responseListener.setRequestPriority(RequestPriority.HIGH);
        }
        if (!TextUtils.isEmpty(networkCallParams.getScheme())) {
            responseListener.setScheme(networkCallParams.getScheme());
        }
        if (networkCallParams.getPort() > 0) {
            responseListener.setPort(networkCallParams.getPort());
        }
        MClient.executeAsync(responseListener.build());
    }

    public static void downloadMPLProApp(Context context, JSONObject jSONObject, IResponseListener<String> iResponseListener) {
        MLogger.d(TAG, "downloadMPLProApp: ", jSONObject);
        try {
            String optString = jSONObject.optString("appDownloadVersion", String.valueOf(MBuildConfigUtils.getInstalledAppVersionCode() + UpdaterConstant.APK_MIN_VERSION_CODE_ID));
            String optString2 = jSONObject.optString("appDownloadUrl", "");
            if (!TextUtils.isEmpty(optString2)) {
                File file = new File(GEUtil.getGameDirInternalStoragePath(context), "ProApp");
                if (!file.exists()) {
                    file.mkdir();
                }
                File file2 = new File(file, optString + ".apk");
                try {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file2.createNewFile();
                } catch (IOException e2) {
                    MLogger.printStackTrace(e2);
                }
                downloadFile(new NetworkCallParams.Builder().setUrl(optString2).setDestinationFilePath(file2.getAbsolutePath()).setDestinationFileName(file2.getName()).build(), iResponseListener);
            }
        } catch (Exception e3) {
            MLogger.printStackTrace(e3);
        }
    }

    public static JSONObject getApiResponse(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        if (!isResponseSuccess(str)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
            try {
                if (jSONObject.optJSONObject("payload") != null) {
                    jSONObject = jSONObject.optJSONObject("payload");
                }
            } catch (Exception e2) {
                e = e2;
                jSONObject2 = jSONObject;
                MLogger.e(TAG, "getApiResponse: ", e);
                jSONObject = jSONObject2;
                return jSONObject;
            }
        } catch (Exception e3) {
            e = e3;
            MLogger.e(TAG, "getApiResponse: ", e);
            jSONObject = jSONObject2;
            return jSONObject;
        }
        return jSONObject;
    }

    public static void getChatToken(boolean z, IResponseListener<String> iResponseListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Bearer ");
        outline73.append(MSharedPreferencesUtils.getAccessUserToken());
        arrayList.add(new MHeader("Authorization", outline73.toString()));
        NetworkCallParams.Builder builder = new NetworkCallParams.Builder();
        doGetRequest(builder.setUrl(MBuildConfigUtils.getMainUrl() + String.format(ApiEndPoints.CHAT_TOKEN, new Object[]{Boolean.valueOf(z)})).setConnectionTimeOut(10000).setWriteTimeOut(10000).setReadTimeOut(10000).setMHeaders(arrayList).setRetryOption(true).build(), iResponseListener, Constant.CHAT_TOKEN);
    }

    public static NetworkCallParams.Builder getDefaultNetworkParams(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
            arrayList.add(new MHeader("Authorization", "Bearer " + MSharedPreferencesUtils.getAccessUserToken()));
        } catch (Exception unused) {
        }
        NetworkCallParams.Builder builder = new NetworkCallParams.Builder();
        return builder.setUrl(MBuildConfigUtils.getMainUrl() + str).setConnectionTimeOut(10000).setWriteTimeOut(10000).setReadTimeOut(10000).setMHeaders(arrayList).setRetryOption(true);
    }

    public static String getNetworkClass(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return AnalyticsConstants.NETWORK_2G;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return AnalyticsConstants.NETWORK_3G;
                    case 13:
                    case 18:
                    case 19:
                        return AnalyticsConstants.NETWORK_4G;
                    case 20:
                        return "5G";
                    default:
                        return ColorPropConverter.PREFIX_ATTR;
                }
            }
        }
        return ColorPropConverter.PREFIX_ATTR;
    }

    public static void getThirdPartyAuth(String str, IResponseListener<String> iResponseListener) {
        NetworkCallParams build = getDefaultNetworkParams(str).build();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("thirdparty_token_");
        outline73.append(System.currentTimeMillis());
        doPostRequest(build, iResponseListener, outline73.toString());
    }

    public static void isInternalUser(IResponseListener<String> iResponseListener) {
        NetworkCallParams build = getDefaultNetworkParams(ApiEndPoints.CHECK_INTERNAL_USER).build();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("is_internal_user_");
        outline73.append(System.currentTimeMillis());
        doGetRequest(build, iResponseListener, outline73.toString());
    }

    public static boolean isResponseSuccess(String str) {
        boolean z = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optJSONObject("status") == null || jSONObject.optJSONObject("status").optInt("code") != 200 || jSONObject.optJSONObject("payload") == null) {
                z = false;
            }
            return z;
        } catch (JSONException e2) {
            MLogger.e(TAG, "isResponseSuccess: ", e2);
            return false;
        }
    }

    public static boolean isValidResponse(String str) {
        boolean z = true;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optJSONObject("status") == null || jSONObject.optJSONObject("status").optInt("code") != 200) {
                z = false;
            }
            return z;
        } catch (Exception e2) {
            MLogger.e(TAG, "isValidResponse: ", e2);
            return false;
        }
    }

    public static void loginMPLInBackground(final Context context, String str, final IResponseListener<String> iResponseListener) {
        try {
            MLogger.d(TAG, "loginMPLInBackground:[START] ");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("authToken", str);
            jSONObject.put("ctId", MPLApplication.getMplAnalytics().getCleverTapId());
            jSONObject.put(Constant.ONE_SIGNAL_PUSH_TOKEN, MSharedPreferencesUtils.getOneSignalPushToken());
            jSONObject.put("deviceInfo", new DeviceInfo(context).getDeviceInfo(context));
            jSONObject.put("appInfo", new DeviceInfo(context).getAppInfo(context));
            jSONObject.put("imei", new DeviceInfo(context).getImeiInfo(context));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
            MLogger.d(TAG, "loginMPLInBackground: ", jSONObject);
            NetworkCallParams.Builder builder = new NetworkCallParams.Builder();
            doPostRequest(builder.setUrl(MBuildConfigUtils.getMainUrl() + ApiEndPoints.VERIFY_OTP_TOKEN).setConnectionTimeOut(10000).setWriteTimeOut(10000).setReadTimeOut(10000).setMHeaders(arrayList).setRetryOption(true).setMRequestBody(jSONObject.toString()).build(), new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    MLogger.e(IResponseListener.TAG, "onResponseFail:loginMPLInBackground ", exc);
                    iResponseListener.onResponseFail(exc);
                    NetworkUtils.showErrorDialog(context, exc.getMessage());
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    MLogger.d(IResponseListener.TAG, "onResponseSuccess:loginMPLInBackground ");
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("status")) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("status");
                            if (!optJSONObject.has("code") || optJSONObject.optInt("code", 0) != 200) {
                                if (!optJSONObject.has("code") || optJSONObject.optInt("code", 0) != 400) {
                                    if (optJSONObject.has("message")) {
                                        NetworkUtils.showErrorDialog(context, optJSONObject.getString("message"));
                                    } else {
                                        NetworkUtils.showErrorDialog(context, jSONObject.toString());
                                    }
                                    iResponseListener.onResponseFail(new MException((String) "Unable To login"));
                                } else {
                                    iResponseListener.onResponseFail(new MException((String) "Unable To login"));
                                }
                            } else if (jSONObject.has("payload")) {
                                JSONObject optJSONObject2 = jSONObject.optJSONObject("payload");
                                NetworkUtils.saveLoginResponse(context, optJSONObject2);
                                jSONObject = optJSONObject2;
                            } else {
                                NetworkUtils.showErrorDialog(context, jSONObject.toString());
                                iResponseListener.onResponseFail(new MException((String) "Unable To login"));
                            }
                        } else {
                            NetworkUtils.showErrorDialog(context, jSONObject.toString());
                            iResponseListener.onResponseFail(new MException((String) "Unable To login"));
                        }
                        MLogger.d(IResponseListener.TAG, "onResponseSuccess:loginMPLInBackground ", jSONObject);
                        iResponseListener.onResponseSuccess(str);
                        NetworkModule.processResponse(null, str);
                    } catch (Exception e2) {
                        MLogger.e(IResponseListener.TAG, "onResponseSuccess:loginMPLInBackground ", e2);
                        NetworkUtils.showErrorDialog(context, e2.getMessage());
                    }
                }
            }, "verify_otp");
        } catch (Exception e2) {
            MLogger.e(TAG, "verifyOtp: ", e2);
            iResponseListener.onResponseFail(e2);
        }
    }

    public static void makeConfigCallInBackGround(Context context, IResponseListener<String> iResponseListener) {
        if (MBuildConfigUtils.isGlobalApp()) {
            DownloadHelper.getInstance().preLoginCallWithListener(context, StatusType.BACKGROUND_API_CALL, iResponseListener);
            return;
        }
        DownloadHelper.getInstance().checkUpdateAvailable(context, StatusType.BACKGROUND_API_CALL, false, null, false);
    }

    public static void saveLoginResponse(Context context, JSONObject jSONObject) {
        MLogger.d(TAG, "saveLoginResponse: ", jSONObject);
        MSharedPreferencesUtils.saveBooleanInNormalPref(context, "isBackgroundLoginSuccess", true);
        if (jSONObject.has("tokens") && jSONObject.optJSONObject("tokens") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("tokens");
            if (optJSONObject != null) {
                if (optJSONObject.has("accessToken")) {
                    MSharedPreferencesUtils.putStringPref("accessToken", optJSONObject.optString("accessToken", null), true);
                }
                if (optJSONObject.has("refreshToken")) {
                    MSharedPreferencesUtils.putStringPref("refreshToken", optJSONObject.optString("refreshToken", ""), true);
                }
                if (optJSONObject.has(Constant.JWT_TOKEN)) {
                    MSharedPreferencesUtils.putStringPref(Constant.JWT_TOKEN, optJSONObject.optString(Constant.JWT_TOKEN, ""), true);
                }
            }
        }
        if (jSONObject.has(Constant.PRIVATE_DATA) && !TextUtils.isEmpty(jSONObject.optString(Constant.PRIVATE_DATA, ""))) {
            MSharedPreferencesUtils.putStringPref(Constant.PRIVATE_DATA, jSONObject.optString(Constant.PRIVATE_DATA, ""), true);
        }
        if (jSONObject.has(Constant.PROFILE) && jSONObject.optJSONObject(Constant.PROFILE) != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject(Constant.PROFILE);
            if (optJSONObject2 != null) {
                try {
                    optJSONObject2.put(Constant.APPSFLYER_IS_NEW_USER, jSONObject.optBoolean(Constant.APPSFLYER_IS_NEW_USER, false));
                    MSharedPreferencesUtils.setIsNewUser(context, jSONObject.optBoolean(Constant.APPSFLYER_IS_NEW_USER, false));
                } catch (Exception e2) {
                    MLogger.e(TAG, "saveLoginResponse: ", e2);
                }
            }
            MSharedPreferencesUtils.putStringPref(Constant.PROFILE, optJSONObject2.toString(), true);
        }
        if (jSONObject.has("countryInfo") && jSONObject.optJSONObject("countryInfo") != null) {
            CountryUtils.saveCountryDataAfterLogin(jSONObject.optJSONObject("countryInfo"));
        }
        CommonUtils.processAfterLoginJobs(context);
    }

    public static void sendingSessionData(String str) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            int userIdInNormalPref = MSharedPreferencesUtils.getUserIdInNormalPref(MPLApplication.getInstance());
            String stringInNormalPref = MSharedPreferencesUtils.getStringInNormalPref(MPLApplication.getInstance(), "appSessionUniqueID", "");
            jSONObject.put("userId", userIdInNormalPref);
            jSONObject.put("userActivity", str);
            jSONObject.put("sessionId", stringInNormalPref);
            String format = new SimpleDateFormat(TQConstants.SERVER_DATE_FORMAT).format(Util.getCurrentTime());
            if ("App Launch".equalsIgnoreCase(str)) {
                jSONObject.put("activityStart", format);
                jSONObject.put("activityEnd", "");
            } else {
                jSONObject.put("activityStart", "");
                jSONObject.put("activityEnd", format);
            }
            jSONArray.put(jSONObject);
            doPostRequest(getDefaultNetworkParams(ApiEndPoints.SESSION_DATA).setMRequestBody(jSONArray.toString()).build(), new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    MLogger.d(IResponseListener.TAG, "onResponseFail: ", exc.getMessage());
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    MLogger.d(IResponseListener.TAG, "onResponseSuccess: ", str);
                    NetworkModule.processResponse(null, str);
                }
            }, "session_data");
        } catch (Exception unused) {
        }
    }

    public static void showErrorDialog(Context context, String str) {
        MLogger.e(TAG, "showErrorDialog: ", str);
    }
}

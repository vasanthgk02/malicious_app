package com.mpl.androidapp.react.modules;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.Toast;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.mpl.androidapp.appsanity.APIHealthChecker;
import com.mpl.androidapp.appsanity.APIHealthCheckerImpl;
import com.mpl.androidapp.appsanity.APPSanityModel;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.updater.repo.DownloadHelper;
import com.mpl.androidapp.updater.util.StatusType;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.NetworkCallParams;
import com.mpl.androidapp.utils.NetworkCallParams.SendingFilePath;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.network.modules.request.MOKHttpPostRequest;
import com.mpl.network.modules.request.MOkHttpDownloadRequest;
import com.mpl.network.modules.request.MOkHttpGetRequest.Builder;
import com.mpl.network.modules.request.MOkHttpUploadRequest;
import com.mpl.network.modules.request.MRequest;
import com.mpl.network.modules.request.RequestPriority;
import com.mpl.network.modules.utils.MException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "NetworkModule")
public class NetworkModule extends ReactContextBaseJavaModule {
    public static final String TAG = "NetworkModule";
    public static long sRefreshTokenFetchTime;

    public NetworkModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public static Map<String, String> jsonToMap(String str) throws JSONException {
        HashMap hashMap = new HashMap();
        if (CommonUtils.isJSONValid(str)) {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
        }
        return hashMap;
    }

    private NetworkCallParams parseRequestedParams(String str, long j) {
        ArrayList arrayList = new ArrayList();
        IdentityHashMap identityHashMap = new IdentityHashMap();
        IdentityHashMap identityHashMap2 = new IdentityHashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject(Constant.HEADER);
            if (optJSONObject != null) {
                optJSONObject.remove("Authorization");
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    arrayList.add(new MHeader(next, optJSONObject.getString(next)));
                }
            }
            arrayList.add(new MHeader("Authorization", "Bearer " + MSharedPreferencesUtils.getAccessUserToken()));
            JSONObject optJSONObject2 = jSONObject.optJSONObject("query");
            JSONObject optJSONObject3 = jSONObject.optJSONObject(Constant.BODY);
            JSONObject optJSONObject4 = jSONObject.optJSONObject(Constant.MULTI_PART_PARAMS);
            if (optJSONObject2 != null) {
                Iterator<String> keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    identityHashMap.put(next2, optJSONObject2.getString(next2));
                }
            }
            if (optJSONObject4 != null) {
                Iterator<String> keys3 = optJSONObject4.keys();
                while (keys3.hasNext()) {
                    String next3 = keys3.next();
                    identityHashMap2.put(next3, optJSONObject4.getString(next3));
                }
            }
            NetworkCallParams networkCallParams = (NetworkCallParams) new Gson().fromJson(str, NetworkCallParams.class);
            networkCallParams.setHeaders(arrayList);
            networkCallParams.setQueryParams(identityHashMap);
            networkCallParams.setMultiPartParams(identityHashMap2);
            if (optJSONObject3 != null) {
                networkCallParams.setRequestBody(optJSONObject3.toString());
            }
            networkCallParams.setStartingTime(j);
            return networkCallParams;
        } catch (JSONException e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
            MLogger.e(TAG, e2);
            return null;
        }
    }

    private MRequest prepareRequest(NetworkCallParams networkCallParams, Promise promise) {
        String str;
        if (TextUtils.isEmpty(networkCallParams.getUrl())) {
            str = Constant.MAIN_URL;
        } else {
            str = networkCallParams.getUrl();
        }
        if (!TextUtils.isEmpty(networkCallParams.getPathSegment())) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
            outline73.append(networkCallParams.getPathSegment());
            str = outline73.toString();
        }
        final APIHealthCheckerImpl aPIHealthCheckerImpl = new APIHealthCheckerImpl();
        final APPSanityModel initAppSanity = aPIHealthCheckerImpl.initAppSanity(str);
        Pair[] pairArr = null;
        if (Constant.GET.equalsIgnoreCase(networkCallParams.getRequestType())) {
            Builder headers = new Builder().setUrl(str).setQueryParams(networkCallParams.getQueryParams()).setHeaders(networkCallParams.getHeaders());
            final Promise promise2 = promise;
            final NetworkCallParams networkCallParams2 = networkCallParams;
            AnonymousClass1 r1 = new IResponseListener<String>() {
                public void onProcessHeader(ArrayList<MHeader> arrayList) {
                    NetworkModule.this.processHeader(arrayList, networkCallParams2);
                }

                public void onResponseFail(Exception exc) {
                    if (exc != null) {
                        try {
                            MLogger.d(IResponseListener.TAG, "onResponseFail: ", exc);
                            MLogger.d(IResponseListener.TAG, "onResponseFail: ", exc.getLocalizedMessage());
                            MLogger.d(IResponseListener.TAG, "onResponseFail: ", exc.getMessage());
                            if (aPIHealthCheckerImpl != null) {
                                aPIHealthCheckerImpl.setEndAppSanityParams(initAppSanity);
                            }
                            if (exc instanceof MException) {
                                MException mException = (MException) exc;
                                String message = mException.getMessage();
                                NetworkModule.this.processHeader(mException.getHeaders(), networkCallParams2);
                                if (!TextUtils.isEmpty(message) && CommonUtils.isJSONValid(message)) {
                                    JSONObject optJSONObject = new JSONObject(message).optJSONObject("status");
                                    if (NetworkModule.this.getReactApplicationContext() != null && optJSONObject != null && optJSONObject.has("code") && optJSONObject.optInt("code") == 401) {
                                        NetworkModule.this.showLogoutAuthorize();
                                    }
                                }
                                promise2.reject(String.valueOf(mException.getErrorCode()), message);
                            } else {
                                promise2.reject(String.valueOf(1000), exc.toString());
                            }
                        } catch (Exception e2) {
                            APIHealthChecker aPIHealthChecker = aPIHealthCheckerImpl;
                            if (aPIHealthChecker != null) {
                                aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                            }
                            MLogger.e(IResponseListener.TAG, "onResponseFail: ", e2);
                            promise2.reject(String.valueOf(1000), (String) "Error in Fetching Response");
                            APIHealthChecker aPIHealthChecker2 = aPIHealthCheckerImpl;
                            if (aPIHealthChecker2 != null) {
                                aPIHealthChecker2.processAPIHealthStatusFromFailedResponse(initAppSanity, exc);
                                return;
                            }
                            return;
                        }
                    } else {
                        promise2.reject(String.valueOf(1000), (String) "Error in Fetching Response");
                    }
                    MLogger.i(IResponseListener.TAG, "Calculated timing for ", networkCallParams2.getPathSegment(), " is ", Long.valueOf(System.currentTimeMillis() - networkCallParams2.getStartingTime()), " ms");
                    if (MBuildConfigUtils.isLogEnabled() && NetworkModule.this.getCurrentActivity() != null && !TextUtils.isEmpty(networkCallParams2.getUrl()) && networkCallParams2.getUrl().contains("submitscore")) {
                        Toast makeText = Toast.makeText(NetworkModule.this.getCurrentActivity(), "Submit Score Failed", 1);
                        makeText.setGravity(48, 0, 0);
                        makeText.show();
                    }
                    if (aPIHealthCheckerImpl != null) {
                        aPIHealthCheckerImpl.processAPIHealthStatusFromFailedResponse(initAppSanity, exc);
                    }
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    promise2.resolve(str);
                    try {
                        MLogger.i(IResponseListener.TAG, "Calculated  timing for in Success in Success ", networkCallParams2.getPathSegment(), " is ", Long.valueOf(System.currentTimeMillis() - networkCallParams2.getStartingTime()), " ms");
                        if (aPIHealthCheckerImpl != null) {
                            aPIHealthCheckerImpl.setEndAppSanityParams(initAppSanity);
                        }
                        if (networkCallParams2 != null && networkCallParams2.getPathSegment() != null && !TextUtils.isEmpty(networkCallParams2.getPathSegment()) && networkCallParams2.getPathSegment().contains("home/config")) {
                            CommonUtils.saveHomeConfigResponse(str);
                        }
                        if (MBuildConfigUtils.isLogEnabled() && NetworkModule.this.getCurrentActivity() != null && !TextUtils.isEmpty(networkCallParams2.getUrl()) && networkCallParams2.getUrl().contains("submitscore")) {
                            JSONObject optJSONObject = new JSONObject(str).optJSONObject("status");
                            if (optJSONObject != null && optJSONObject.optInt("code") == 500) {
                                Toast makeText = Toast.makeText(NetworkModule.this.getCurrentActivity(), "Submit Score Failed", 1);
                                makeText.setGravity(48, 0, 0);
                                makeText.show();
                            }
                        }
                        NetworkModule.processResponse(networkCallParams2, str);
                        if (aPIHealthCheckerImpl != null) {
                            aPIHealthCheckerImpl.processAPIHealthStatusFromSuccessFullResponse(initAppSanity, str);
                        }
                    } catch (Exception e2) {
                        MLogger.e(IResponseListener.TAG, "onResponseSuccess: ", e2);
                    }
                }
            };
            Builder responseListener = headers.setResponseListener(r1);
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("get_request_");
            outline732.append(System.currentTimeMillis());
            Builder tag = responseListener.setTag(outline732.toString());
            tag.setConnectTimeout(Math.max(networkCallParams.getConnectionTimeOut(), 10000));
            tag.setReadTimeout(Math.max(networkCallParams.getReadTimeOut(), 10000));
            tag.setWriteTimeout(Math.max(networkCallParams.getWriteTimeOut(), 10000));
            tag.setPingInterval(Math.max(networkCallParams.getPingInterval(), 10000));
            if (networkCallParams.getPriority() == 1) {
                tag.setRequestPriority(RequestPriority.LOW);
            } else {
                tag.setRequestPriority(RequestPriority.HIGH);
            }
            tag.setRetryOnConnectionFailure(networkCallParams.isRetryOption());
            if (!TextUtils.isEmpty(networkCallParams.getHost())) {
                tag.setHost(networkCallParams.getHost());
            }
            if (!TextUtils.isEmpty(networkCallParams.getScheme())) {
                tag.setScheme(networkCallParams.getScheme());
            }
            if (networkCallParams.getPort() > 0) {
                tag.setPort(networkCallParams.getPort());
            }
            return tag.build();
        } else if ("post".equalsIgnoreCase(networkCallParams.getRequestType())) {
            MOKHttpPostRequest.Builder queryParams = new MOKHttpPostRequest.Builder().setUrl(str).setHeaders(networkCallParams.getHeaders()).setQueryParams(networkCallParams.getQueryParams());
            final Promise promise3 = promise;
            final NetworkCallParams networkCallParams3 = networkCallParams;
            AnonymousClass2 r12 = new IResponseListener<String>() {
                public void onProcessHeader(ArrayList<MHeader> arrayList) {
                    NetworkModule.this.processHeader(arrayList, networkCallParams3);
                }

                public void onResponseFail(Exception exc) {
                    if (exc != null) {
                        try {
                            MLogger.d(IResponseListener.TAG, "onResponseFail: ", exc);
                            MLogger.d(IResponseListener.TAG, "onResponseFail: ", exc.getLocalizedMessage());
                            MLogger.d(IResponseListener.TAG, "onResponseFail: ", exc.getMessage());
                            if (aPIHealthCheckerImpl != null) {
                                aPIHealthCheckerImpl.setEndAppSanityParams(initAppSanity);
                            }
                            if (exc instanceof MException) {
                                MException mException = (MException) exc;
                                String message = mException.getMessage();
                                NetworkModule.this.processHeader(mException.getHeaders(), networkCallParams3);
                                if (!TextUtils.isEmpty(message) && CommonUtils.isJSONValid(message)) {
                                    JSONObject optJSONObject = new JSONObject(message).optJSONObject("status");
                                    if (NetworkModule.this.getReactApplicationContext() != null && optJSONObject != null && optJSONObject.has("code") && optJSONObject.optInt("code") == 401) {
                                        NetworkModule.this.showLogoutAuthorize();
                                    }
                                }
                                promise3.reject(String.valueOf(mException.getErrorCode()), message);
                            } else {
                                promise3.reject(String.valueOf(1000), exc.toString());
                            }
                        } catch (Exception e2) {
                            MLogger.e(IResponseListener.TAG, "onResponseFail: ", e2);
                            APIHealthChecker aPIHealthChecker = aPIHealthCheckerImpl;
                            if (aPIHealthChecker != null) {
                                aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                            }
                            promise3.reject(String.valueOf(1000), (String) "Error in Fetching Response");
                            APIHealthChecker aPIHealthChecker2 = aPIHealthCheckerImpl;
                            if (aPIHealthChecker2 != null) {
                                aPIHealthChecker2.processAPIHealthStatusFromFailedResponse(initAppSanity, e2);
                                return;
                            }
                            return;
                        }
                    } else {
                        promise3.reject(String.valueOf(1000), (String) "Error in Fetching Response");
                    }
                    MLogger.i(IResponseListener.TAG, "Calculated  timing for in Fail ", networkCallParams3.getPathSegment(), " is ", Long.valueOf(System.currentTimeMillis() - networkCallParams3.getStartingTime()), " ms");
                    if (aPIHealthCheckerImpl != null) {
                        aPIHealthCheckerImpl.processAPIHealthStatusFromFailedResponse(initAppSanity, exc);
                    }
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    promise3.resolve(str);
                    try {
                        MLogger.i(IResponseListener.TAG, "Calculated timing for ", networkCallParams3.getPathSegment(), " is ", Long.valueOf(System.currentTimeMillis() - networkCallParams3.getStartingTime()), " ms");
                        if (aPIHealthCheckerImpl != null) {
                            aPIHealthCheckerImpl.setEndAppSanityParams(initAppSanity);
                        }
                        if (networkCallParams3 != null && networkCallParams3.getPathSegment() != null && !TextUtils.isEmpty(networkCallParams3.getPathSegment()) && networkCallParams3.getPathSegment().contains("home/config")) {
                            CommonUtils.saveHomeConfigResponse(str);
                        }
                        NetworkModule.processResponse(networkCallParams3, str);
                        if (aPIHealthCheckerImpl != null) {
                            aPIHealthCheckerImpl.processAPIHealthStatusFromSuccessFullResponse(initAppSanity, str);
                        }
                    } catch (Exception unused) {
                    }
                }
            };
            MOKHttpPostRequest.Builder responseListener2 = queryParams.setResponseListener(r12);
            StringBuilder outline733 = GeneratedOutlineSupport.outline73("post_request_");
            outline733.append(System.currentTimeMillis());
            MOKHttpPostRequest.Builder tag2 = responseListener2.setTag(outline733.toString());
            tag2.setConnectTimeout(Math.max(networkCallParams.getConnectionTimeOut(), 10000));
            tag2.setReadTimeout(Math.max(networkCallParams.getReadTimeOut(), 10000));
            tag2.setWriteTimeout(Math.max(networkCallParams.getWriteTimeOut(), 10000));
            tag2.setPingInterval(Math.max(networkCallParams.getPingInterval(), 10000));
            tag2.setRetryOnConnectionFailure(networkCallParams.isRetryOption());
            if (!TextUtils.isEmpty(networkCallParams.getHost())) {
                tag2.setHost(networkCallParams.getHost());
            }
            if (networkCallParams.getPriority() == 1) {
                tag2.setRequestPriority(RequestPriority.LOW);
            } else {
                tag2.setRequestPriority(RequestPriority.HIGH);
            }
            if (!TextUtils.isEmpty(networkCallParams.getScheme())) {
                tag2.setScheme(networkCallParams.getScheme());
            }
            if (networkCallParams.getPort() > 0) {
                tag2.setPort(networkCallParams.getPort());
            }
            if (!TextUtils.isEmpty(networkCallParams.getRequestBody())) {
                tag2.setPostJsonObject(networkCallParams.getRequestBody());
            }
            if (!TextUtils.isEmpty(networkCallParams.getContent())) {
                tag2.setBytes(networkCallParams.getContent().getBytes());
            }
            if (!TextUtils.isEmpty(networkCallParams.getFilePath())) {
                tag2.setFile(new File(networkCallParams.getFilePath()));
            }
            if (TextUtils.isEmpty(networkCallParams.getRequestBody()) && TextUtils.isEmpty(networkCallParams.getContent()) && TextUtils.isEmpty(networkCallParams.getFilePath())) {
                MLogger.d(TAG, "All types are empty for post request so sending empty json body for post");
                tag2.setPostJsonObject("{}");
            }
            return tag2.build();
        } else if (Constant.UPLOAD.equalsIgnoreCase(networkCallParams.getRequestType())) {
            MOkHttpUploadRequest.Builder queryParams2 = new MOkHttpUploadRequest.Builder().setUrl(str).setHeaders(networkCallParams.getHeaders()).setQueryParams(networkCallParams.getQueryParams());
            final Promise promise4 = promise;
            final NetworkCallParams networkCallParams4 = networkCallParams;
            AnonymousClass3 r13 = new IResponseListener<String>() {
                public void onProcessHeader(ArrayList<MHeader> arrayList) {
                    NetworkModule.this.processHeader(arrayList, networkCallParams4);
                }

                public void onResponseFail(Exception exc) {
                    if (exc != null) {
                        try {
                            MLogger.d(IResponseListener.TAG, "onResponseFail: ", exc);
                            MLogger.d(IResponseListener.TAG, "onResponseFail: ", exc.getLocalizedMessage());
                            MLogger.d(IResponseListener.TAG, "onResponseFail: ", exc.getMessage());
                            if (aPIHealthCheckerImpl != null) {
                                aPIHealthCheckerImpl.setEndAppSanityParams(initAppSanity);
                            }
                            if (exc instanceof MException) {
                                MException mException = (MException) exc;
                                String message = mException.getMessage();
                                NetworkModule.this.processHeader(mException.getHeaders(), networkCallParams4);
                                if (!TextUtils.isEmpty(message) && CommonUtils.isJSONValid(message)) {
                                    JSONObject optJSONObject = new JSONObject(message).optJSONObject("status");
                                    if (NetworkModule.this.getReactApplicationContext() != null && optJSONObject != null && optJSONObject.has("code") && optJSONObject.optInt("code") == 401) {
                                        NetworkModule.this.showLogoutAuthorize();
                                    }
                                }
                                promise4.reject(String.valueOf(mException.getErrorCode()), message);
                            } else {
                                promise4.reject(String.valueOf(1000), exc.toString());
                            }
                        } catch (Exception e2) {
                            MLogger.e(IResponseListener.TAG, "onResponseFail: ", e2);
                            APIHealthChecker aPIHealthChecker = aPIHealthCheckerImpl;
                            if (aPIHealthChecker != null) {
                                aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                            }
                            promise4.reject(String.valueOf(1000), (String) "Error in Fetching Response");
                            APIHealthChecker aPIHealthChecker2 = aPIHealthCheckerImpl;
                            if (aPIHealthChecker2 != null) {
                                aPIHealthChecker2.processAPIHealthStatusFromFailedResponse(initAppSanity, exc);
                                return;
                            }
                            return;
                        }
                    } else {
                        promise4.reject(String.valueOf(1000), (String) "Error in Fetching Response");
                    }
                    MLogger.i(IResponseListener.TAG, "Calculated timing for ", networkCallParams4.getPathSegment(), " is ", Long.valueOf(System.currentTimeMillis() - networkCallParams4.getStartingTime()), " ms");
                    if (aPIHealthCheckerImpl != null) {
                        aPIHealthCheckerImpl.processAPIHealthStatusFromFailedResponse(initAppSanity, exc);
                    }
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    promise4.resolve(str);
                    try {
                        MLogger.i(IResponseListener.TAG, "Calculated timing for ", networkCallParams4.getPathSegment(), " is ", Long.valueOf(System.currentTimeMillis() - networkCallParams4.getStartingTime()), " ms");
                        if (aPIHealthCheckerImpl != null) {
                            aPIHealthCheckerImpl.setEndAppSanityParams(initAppSanity);
                        }
                        if (networkCallParams4 != null && networkCallParams4.getPathSegment() != null && !TextUtils.isEmpty(networkCallParams4.getPathSegment()) && networkCallParams4.getPathSegment().contains("home/config")) {
                            CommonUtils.saveHomeConfigResponse(str);
                        }
                        NetworkModule.processResponse(networkCallParams4, str);
                        if (aPIHealthCheckerImpl != null) {
                            aPIHealthCheckerImpl.processAPIHealthStatusFromSuccessFullResponse(initAppSanity, str);
                        }
                    } catch (Exception unused) {
                    }
                }
            };
            MOkHttpUploadRequest.Builder responseListener3 = queryParams2.setResponseListener(r13);
            StringBuilder outline734 = GeneratedOutlineSupport.outline73("post_request_");
            outline734.append(System.currentTimeMillis());
            MOkHttpUploadRequest.Builder tag3 = responseListener3.setTag(outline734.toString());
            tag3.setConnectTimeout(Math.max(networkCallParams.getConnectionTimeOut(), 10000));
            tag3.setReadTimeout(Math.max(networkCallParams.getReadTimeOut(), 10000));
            tag3.setWriteTimeout(Math.max(networkCallParams.getWriteTimeOut(), 10000));
            tag3.setPingInterval(Math.max(networkCallParams.getPingInterval(), 10000));
            tag3.setRetryOnConnectionFailure(networkCallParams.isRetryOption());
            if (networkCallParams.getPriority() == 1) {
                tag3.setRequestPriority(RequestPriority.LOW);
            } else {
                tag3.setRequestPriority(RequestPriority.HIGH);
            }
            if (!TextUtils.isEmpty(networkCallParams.getHost())) {
                tag3.setHost(networkCallParams.getHost());
            }
            if (!TextUtils.isEmpty(networkCallParams.getScheme())) {
                tag3.setScheme(networkCallParams.getScheme());
            }
            if (networkCallParams.getPort() > 0) {
                tag3.setPort(networkCallParams.getPort());
            }
            if (!TextUtils.isEmpty(networkCallParams.getRequestBody())) {
                try {
                    tag3.setFormPostParams(jsonToMap(networkCallParams.getRequestBody()));
                } catch (JSONException unused) {
                }
            }
            if (!TextUtils.isEmpty(networkCallParams.getRequestBody())) {
                tag3.setPostJsonObject(networkCallParams.getRequestBody());
            }
            if (networkCallParams.getMultiPartParams() != null && networkCallParams.getMultiPartParams().size() > 0) {
                tag3.setFormPostParams(networkCallParams.getMultiPartParams());
            }
            if (!TextUtils.isEmpty(networkCallParams.getContent())) {
                tag3.setBytes(networkCallParams.getContent().getBytes());
            }
            if (networkCallParams.getSendingFilePath() != null && networkCallParams.getSendingFilePath().size() > 0) {
                int size = networkCallParams.getSendingFilePath().size();
                pairArr = new Pair[size];
                List<SendingFilePath> sendingFilePath = networkCallParams.getSendingFilePath();
                for (int i = 0; i < sendingFilePath.size(); i++) {
                    pairArr[i] = new Pair(sendingFilePath.get(i).getHeaderName(), new File(sendingFilePath.get(i).getFilePath()));
                }
                if (size > 0) {
                    tag3.setUploadingFiles(pairArr);
                }
            }
            if (TextUtils.isEmpty(networkCallParams.getRequestBody()) && TextUtils.isEmpty(networkCallParams.getContent()) && (pairArr == null || pairArr.length == 0)) {
                MLogger.d(TAG, "All types are empty for post request so sending empty json body for post");
                tag3.setPostJsonObject("{}");
            }
            return tag3.build();
        } else if (!Constant.DOWNLOAD.equalsIgnoreCase(networkCallParams.getRequestType())) {
            return null;
        } else {
            MOkHttpDownloadRequest.Builder queryParams3 = new MOkHttpDownloadRequest.Builder().setUrl(str).setHeaders(networkCallParams.getHeaders()).setQueryParams(networkCallParams.getQueryParams());
            final Promise promise5 = promise;
            final NetworkCallParams networkCallParams5 = networkCallParams;
            AnonymousClass4 r14 = new IResponseListener<String>() {
                public void onProcessHeader(ArrayList<MHeader> arrayList) {
                    NetworkModule.this.processHeader(arrayList, networkCallParams5);
                }

                public void onResponseFail(Exception exc) {
                    if (exc != null) {
                        try {
                            MLogger.d(IResponseListener.TAG, "onResponseFail: ", exc);
                            MLogger.d(IResponseListener.TAG, "onResponseFail: ", exc.getLocalizedMessage());
                            MLogger.d(IResponseListener.TAG, "onResponseFail: ", exc.getMessage());
                            if (aPIHealthCheckerImpl != null) {
                                aPIHealthCheckerImpl.setEndAppSanityParams(initAppSanity);
                            }
                            if (exc instanceof MException) {
                                MException mException = (MException) exc;
                                String message = mException.getMessage();
                                NetworkModule.this.processHeader(mException.getHeaders(), networkCallParams5);
                                if (!TextUtils.isEmpty(message) && CommonUtils.isJSONValid(message)) {
                                    JSONObject optJSONObject = new JSONObject(message).optJSONObject("status");
                                    if (NetworkModule.this.getReactApplicationContext() != null && optJSONObject != null && optJSONObject.has("code") && optJSONObject.optInt("code") == 401) {
                                        NetworkModule.this.showLogoutAuthorize();
                                    }
                                }
                                promise5.reject(String.valueOf(mException.getErrorCode()), message);
                            } else {
                                promise5.reject(String.valueOf(1000), exc.toString());
                            }
                        } catch (Exception e2) {
                            MLogger.e(IResponseListener.TAG, "onResponseFail: ", e2);
                            APIHealthChecker aPIHealthChecker = aPIHealthCheckerImpl;
                            if (aPIHealthChecker != null) {
                                aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                            }
                            promise5.reject(String.valueOf(1000), (String) "Error in Fetching Response");
                            APIHealthChecker aPIHealthChecker2 = aPIHealthCheckerImpl;
                            if (aPIHealthChecker2 != null) {
                                aPIHealthChecker2.processAPIHealthStatusFromFailedResponse(initAppSanity, e2);
                                return;
                            }
                            return;
                        }
                    } else {
                        promise5.reject(String.valueOf(1000), (String) "Error in Fetching Response");
                    }
                    MLogger.i(IResponseListener.TAG, "Calculated timing for ", networkCallParams5.getPathSegment(), " is ", Long.valueOf(System.currentTimeMillis() - networkCallParams5.getStartingTime()), " ms");
                    if (aPIHealthCheckerImpl != null) {
                        aPIHealthCheckerImpl.processAPIHealthStatusFromFailedResponse(initAppSanity, exc);
                    }
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    promise5.resolve(str);
                    try {
                        MLogger.i(IResponseListener.TAG, "Calculated timing for ", networkCallParams5.getPathSegment(), " is ", Long.valueOf(System.currentTimeMillis() - networkCallParams5.getStartingTime()), " ms");
                        if (aPIHealthCheckerImpl != null) {
                            aPIHealthCheckerImpl.setEndAppSanityParams(initAppSanity);
                        }
                        if (networkCallParams5 != null && networkCallParams5.getPathSegment() != null && !TextUtils.isEmpty(networkCallParams5.getPathSegment()) && networkCallParams5.getPathSegment().contains("home/config")) {
                            CommonUtils.saveHomeConfigResponse(str);
                        }
                        NetworkModule.processResponse(networkCallParams5, str);
                        if (aPIHealthCheckerImpl != null) {
                            aPIHealthCheckerImpl.processAPIHealthStatusFromSuccessFullResponse(initAppSanity, str);
                        }
                    } catch (Exception unused) {
                    }
                }
            };
            MOkHttpDownloadRequest.Builder responseListener4 = queryParams3.setResponseListener(r14);
            StringBuilder outline735 = GeneratedOutlineSupport.outline73("post_request_");
            outline735.append(System.currentTimeMillis());
            MOkHttpDownloadRequest.Builder tag4 = responseListener4.setTag(outline735.toString());
            tag4.setConnectTimeout(Math.max(networkCallParams.getConnectionTimeOut(), 10000));
            tag4.setReadTimeout(Math.max(networkCallParams.getReadTimeOut(), 10000));
            tag4.setWriteTimeout(Math.max(networkCallParams.getWriteTimeOut(), 10000));
            tag4.setPingInterval(Math.max(networkCallParams.getPingInterval(), 10000));
            if (networkCallParams.getPriority() == 1) {
                tag4.setRequestPriority(RequestPriority.LOW);
            } else {
                tag4.setRequestPriority(RequestPriority.HIGH);
            }
            tag4.setRetryOnConnectionFailure(networkCallParams.isRetryOption());
            if (!TextUtils.isEmpty(networkCallParams.getHost())) {
                tag4.setHost(networkCallParams.getHost());
            }
            if (!TextUtils.isEmpty(networkCallParams.getScheme())) {
                tag4.setScheme(networkCallParams.getScheme());
            }
            if (networkCallParams.getPort() > 0) {
                tag4.setPort(networkCallParams.getPort());
            }
            tag4.setDestFile(new File(networkCallParams.getDestinationFilePath()));
            tag4.setDestFileName(networkCallParams.getDestinationFileName());
            return tag4.build();
        }
    }

    public static void processResponse(NetworkCallParams networkCallParams, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optJSONObject("status") != null && jSONObject.optJSONObject("status").optInt("code", 0) == 5000) {
                Bundle bundle = new Bundle();
                bundle.putString("title", jSONObject.optJSONObject("status").optString("title", ""));
                bundle.putString("message", jSONObject.optJSONObject("status").optString("message", ""));
                if (!(jSONObject.optJSONObject("payload") == null || jSONObject.optJSONObject("payload").optJSONObject("vpnData") == null)) {
                    bundle.putString("vpnData", jSONObject.optJSONObject("payload").optJSONObject("vpnData").toString());
                }
                if (MPLReactContainerActivity.resultReceiver != null) {
                    MPLReactContainerActivity.resultReceiver.send(24, bundle);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void showLogoutAuthorize() {
        MSharedPreferencesUtils.showLogoutAuthorize();
    }

    @ReactMethod
    public void fetch(String str, Promise promise) {
        MLogger.d(TAG, "fetch() called with: params = [" + str + "], promise = [" + promise + CMapParser.MARK_END_OF_ARRAY);
        try {
            NetworkCallParams parseRequestedParams = parseRequestedParams(str, System.currentTimeMillis());
            MRequest mRequest = null;
            if (parseRequestedParams != null) {
                mRequest = prepareRequest(parseRequestedParams, promise);
            }
            if (mRequest != null) {
                MClient.executeAsync(mRequest);
            } else {
                promise.reject(String.valueOf(1000), (String) "Not Able to create request");
            }
        } catch (Exception unused) {
            promise.reject(String.valueOf(1000), (String) "Not Able to create request");
        }
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void getPostLoginConfig(Promise promise) {
        MLogger.d(TAG, "getPostLoginConfig: ");
        ConfigManager.setPostLoginCalledFromReact(true);
        DownloadHelper.getInstance().checkUpdateAvailable(getReactApplicationContext(), StatusType.CHECKING_UPDATE, true, promise, true);
    }

    public void processHeader(ArrayList<MHeader> arrayList, NetworkCallParams networkCallParams) {
        if (arrayList != null) {
            try {
                if (arrayList.size() > 0) {
                    Iterator<MHeader> it = arrayList.iterator();
                    while (it.hasNext()) {
                        MHeader next = it.next();
                        MLogger.d(TAG, "onProcessHeader:downtime " + next.toString());
                        if (next.getKey().equalsIgnoreCase("x-mpl-downtime") && CommonUtils.isJSONValid(next.getValue())) {
                            JSONObject jSONObject = new JSONObject(next.getValue());
                            MLogger.d(TAG, jSONObject.optString("title", ""));
                            MLogger.d(TAG, jSONObject.optString("message", ""));
                            Bundle bundle = new Bundle();
                            bundle.putString("title", jSONObject.optString("title", ""));
                            bundle.putString("message", jSONObject.optString("message", ""));
                            if (MPLReactContainerActivity.resultReceiver != null) {
                                MPLReactContainerActivity.resultReceiver.send(15, bundle);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                MLogger.e(TAG, "onProcessHeader: ", e2);
                return;
            }
        }
        MLogger.i(TAG, "Calculated  timing for in Header ", networkCallParams.getPathSegment(), " is ", Long.valueOf(System.currentTimeMillis() - networkCallParams.getStartingTime()), " ms");
    }
}

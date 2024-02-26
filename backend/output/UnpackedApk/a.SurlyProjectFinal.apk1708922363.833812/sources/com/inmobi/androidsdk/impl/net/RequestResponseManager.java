package com.inmobi.androidsdk.impl.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.inmobi.androidsdk.IMAdRequest.ErrorCode;
import com.inmobi.androidsdk.impl.AdException;
import com.inmobi.androidsdk.impl.AdUnit;
import com.inmobi.androidsdk.impl.Constants;
import com.inmobi.androidsdk.impl.UserInfo;
import com.inmobi.androidsdk.impl.XMLParser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public final class RequestResponseManager {
    private Context context;
    private String newAdActionType = null;

    public enum ActionType {
        AdRequest,
        AdRequest_Interstitial,
        DeviceInfoUpload,
        AdClick
    }

    public RequestResponseManager(Context ctx) {
        this.context = ctx;
    }

    public AdUnit requestAd(String urlString, UserInfo clientInfo, ActionType requestType) throws AdException {
        try {
            String postBody = HttpRequestBuilder.buildPostBody(clientInfo, requestType);
            Log.v(Constants.LOGGING_TAG, URLDecoder.decode(postBody));
            HttpURLConnection connection = setupConnection(urlString, clientInfo, requestType);
            postData(connection, postBody);
            return retrieveAd(connection, clientInfo);
        } catch (IOException e) {
            Log.w(Constants.LOGGING_TAG, "Exception occured while requesting an ad" + e);
            e.printStackTrace();
            return null;
        }
    }

    public void asyncRequestAd(final UserInfo userInfo, final ActionType requestType, final HttpRequestCallback httpCallback) {
        new Thread() {
            public void run() {
                try {
                    String adServerUrl = RequestResponseManager.this.getAdServerURL(userInfo);
                    if (Constants.DEBUG) {
                        Log.d(Constants.LOGGING_TAG, "Ad Serving URL: " + adServerUrl);
                    }
                    String postBody = HttpRequestBuilder.buildPostBody(userInfo, requestType);
                    Log.v(Constants.LOGGING_TAG, postBody);
                    HttpURLConnection connection = RequestResponseManager.this.setupConnection(adServerUrl, userInfo, requestType);
                    RequestResponseManager.this.postData(connection, postBody);
                    httpCallback.notifyResult(0, RequestResponseManager.this.retrieveAd(connection, userInfo));
                } catch (AdException e) {
                    if (Constants.DEBUG) {
                        Log.d(Constants.LOGGING_TAG, "Exception Retriving Ad", e);
                    }
                    switch (e.getCode()) {
                        case 100:
                            httpCallback.notifyResult(1, ErrorCode.NO_FILL);
                            return;
                        case 200:
                            httpCallback.notifyResult(1, ErrorCode.INTERNAL_ERROR);
                            return;
                        case AdException.INVALID_REQUEST /*300*/:
                            httpCallback.notifyResult(1, ErrorCode.INVALID_REQUEST);
                            return;
                        case AdException.SANDBOX_OOF /*400*/:
                            httpCallback.notifyResult(1, ErrorCode.INVALID_REQUEST);
                            return;
                        case AdException.SANDBOX_BADIP /*500*/:
                            httpCallback.notifyResult(1, ErrorCode.INVALID_REQUEST);
                            return;
                        case AdException.SANDBOX_UAND /*600*/:
                            httpCallback.notifyResult(1, ErrorCode.INVALID_REQUEST);
                            return;
                        case AdException.SANDBOX_UA /*700*/:
                            httpCallback.notifyResult(1, ErrorCode.INVALID_REQUEST);
                            return;
                        default:
                            return;
                    }
                } catch (IOException e2) {
                    if (Constants.DEBUG) {
                        Log.d(Constants.LOGGING_TAG, "Exception Retriving Ad", e2);
                    }
                    httpCallback.notifyResult(1, ErrorCode.NETWORK_ERROR);
                } catch (Exception e3) {
                    if (Constants.DEBUG) {
                        Log.d(Constants.LOGGING_TAG, "Exception Retriving Ad", e3);
                    }
                    httpCallback.notifyResult(1, ErrorCode.INTERNAL_ERROR);
                }
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public String getAdServerURL(UserInfo userInfo) {
        if (userInfo.isTestMode()) {
            return Constants.AD_TEST_SERVER_URL;
        }
        String adServerUrl = getCachedUrl();
        if (adServerUrl == null) {
            return Constants.AD_SERVER_URL;
        }
        return adServerUrl;
    }

    public String initiateClick(String urlString, UserInfo clientInfo, List<?> extraData) throws IOException {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, ">>> Enter initiateClick, clickURL: " + urlString);
        }
        String adActionType = null;
        if (extraData != null && !extraData.isEmpty() && "x-mkhoj-adactiontype".equals(extraData.get(0))) {
            adActionType = (String) extraData.get(1);
        }
        HttpURLConnection connection = setupConnection(urlString, clientInfo, ActionType.AdClick);
        if (adActionType != null && !clientInfo.isTestMode()) {
            connection.setRequestProperty("x-mkhoj-adactionType", adActionType);
        }
        return getRedirectionURLText(connection, urlString);
    }

    public void uploadDeviceInfo(String urlString, UserInfo clientInfo, ActionType requestType) throws IOException {
        String postBody = HttpRequestBuilder.buildPostBody(clientInfo, requestType);
        HttpURLConnection connection = setupConnection(urlString, clientInfo, requestType);
        postData(connection, postBody);
        BufferedReader reader = null;
        try {
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            try {
                connection.getResponseCode();
                closeResource(reader2);
            } catch (Throwable th) {
                th = th;
                reader = reader2;
                closeResource(reader);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeResource(reader);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public HttpURLConnection setupConnection(String urlString, UserInfo userInfo, ActionType typeOfClick) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();
        setConnectionParams(connection, userInfo, typeOfClick);
        return connection;
    }

    /* access modifiers changed from: private */
    public void postData(HttpURLConnection connection, String postBody) throws IOException {
        connection.setRequestProperty("Content-Length", Integer.toString(postBody.length()));
        BufferedWriter writer = null;
        try {
            BufferedWriter writer2 = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            try {
                writer2.write(postBody);
                closeResource(writer2);
            } catch (Throwable th) {
                th = th;
                writer = writer2;
                closeResource(writer);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeResource(writer);
            throw th;
        }
    }

    private void closeResource(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException exception) {
                Log.d(Constants.LOGGING_TAG, "Exception closing resource: " + resource, exception);
            }
        }
    }

    private static void setConnectionParams(HttpURLConnection connection, UserInfo userInfo, ActionType typeOfClick) throws ProtocolException {
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setConnectTimeout(30000);
        connection.setReadTimeout(30000);
        connection.setRequestProperty("user-agent", userInfo.getPhoneDefaultUserAgent());
        connection.setRequestProperty("x-mkhoj-testmode", userInfo.isTestMode() ? "YES" : "NO");
        connection.setUseCaches(false);
        if (typeOfClick == ActionType.AdClick) {
            connection.setRequestMethod("GET");
        } else {
            connection.setRequestMethod("POST");
        }
        connection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
        if (userInfo.isTestMode()) {
            connection.setRequestProperty("x-mkhoj-adactiontype", userInfo.getTestModeAdActionType() != null ? userInfo.getTestModeAdActionType() : "web");
        }
    }

    /* access modifiers changed from: private */
    public AdUnit retrieveAd(HttpURLConnection connection, UserInfo userInfoRef) throws AdException, IOException {
        String deviceInfoUpURL = null;
        BufferedReader reader = null;
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "Http Status Code: " + connection.getResponseCode());
        }
        if (connection.getResponseCode() == 200) {
            try {
                BufferedReader reader2 = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                try {
                    StringBuilder adResponseStrBuff = new StringBuilder();
                    while (true) {
                        String line = reader2.readLine();
                        if (line == null) {
                            break;
                        }
                        adResponseStrBuff.append(line).append("\n");
                    }
                    String adResponse = adResponseStrBuff.toString();
                    if (Constants.DEBUG) {
                        Log.d(Constants.LOGGING_TAG, "Ad Response: " + adResponse);
                    }
                    Map<String, List<String>> responseHeader = connection.getHeaderFields();
                    if (responseHeader != null) {
                        if (responseHeader.containsKey("x-mkhoj-ph")) {
                            List<String> extraInfo = responseHeader.get("x-mkhoj-ph");
                            if (extraInfo != null && extraInfo.size() == 1) {
                                deviceInfoUpURL = extraInfo.get(0).trim();
                            }
                        }
                        if (responseHeader.containsKey(Constants.AD_SERVER_CACHED_URL)) {
                            List<String> cachedUrlInfo = responseHeader.get(Constants.AD_SERVER_CACHED_URL);
                            String cachedUrlLife = null;
                            String cachedUrl = null;
                            if (cachedUrlInfo != null && cachedUrlInfo.size() == 1) {
                                cachedUrl = cachedUrlInfo.get(0).trim();
                                if (responseHeader.containsKey(Constants.AD_SERVER_CACHED_LIFE)) {
                                    List<String> cachedUrlLifeInfo = responseHeader.get(Constants.AD_SERVER_CACHED_LIFE);
                                    if (cachedUrlLifeInfo != null && cachedUrlLifeInfo.size() == 1) {
                                        cachedUrlLife = cachedUrlLifeInfo.get(0).trim();
                                    }
                                }
                            }
                            storeCachedUrl(cachedUrl, cachedUrlLife);
                        }
                    }
                    AdUnit newAd = new XMLParser().buildAdUnitFromResponseData(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(adResponse.getBytes()), "UTF-8")));
                    if (Constants.DEBUG) {
                        Log.d(Constants.LOGGING_TAG, "Retrived AdUnit: " + newAd);
                    }
                    setAdditionalAdInfo(newAd, userInfoRef, deviceInfoUpURL);
                    connection.disconnect();
                    closeResource(reader2);
                    return newAd;
                } catch (Throwable th) {
                    th = th;
                    reader = reader2;
                }
            } catch (Throwable th2) {
                th = th2;
                connection.disconnect();
                closeResource(reader);
                throw th;
            }
        } else {
            Log.v(Constants.LOGGING_TAG, "Invalid Request. This may be because of invalid appId or appId might not be in 'active' state.");
            throw new AdException("Server did not return 200.", AdException.INVALID_REQUEST);
        }
    }

    private void setAdditionalAdInfo(AdUnit newAd, UserInfo userInfoRef, String deviceInfoUpURL) {
        if (newAd != null) {
            newAd.setSendDeviceInfo(true);
            newAd.setDeviceInfoUploadUrl(deviceInfoUpURL);
        }
    }

    private String getRedirectionURLText(HttpURLConnection conn, String urlString) {
        String url = null;
        HttpURLConnection.setFollowRedirects(false);
        try {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "HTTP Response code: " + conn.getResponseCode());
            }
            if (0 == 0 || urlString.equalsIgnoreCase(null)) {
                url = conn.getURL().toString();
            }
        } catch (IOException ioException) {
            Log.d(Constants.LOGGING_TAG, "Exception getting response code for redirection URL", ioException);
        }
        if (url == null || urlString.equalsIgnoreCase(url)) {
            url = conn.getHeaderField("location");
        }
        Map<String, List<String>> responseHeader = conn.getHeaderFields();
        if (responseHeader != null && responseHeader.containsKey("action-name")) {
            List<String> newAdActionList = responseHeader.get("action-name");
            if (newAdActionList != null && newAdActionList.size() == 1) {
                setNewAdActionType(newAdActionList.get(0).trim());
            }
        }
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "Redirection URL: " + url);
        }
        return url;
    }

    private String getCachedUrl() {
        SharedPreferences prefs = this.context.getSharedPreferences("InMobi_Prefs_key", 0);
        String cachedServerUrl = prefs.getString(Constants.AD_SERVER_CACHED_URL, null);
        if (cachedServerUrl != null) {
            if (Calendar.getInstance().getTimeInMillis() - prefs.getLong(Constants.CACHED_AD_SERVER_TIMESTAMP, 0) <= prefs.getLong(Constants.AD_SERVER_CACHED_LIFE, 0)) {
                return cachedServerUrl;
            }
        }
        return null;
    }

    private void storeCachedUrl(String cachedUrl, String cachedUrlLife) {
        long cachedUrlLifeNum;
        Editor editor = this.context.getSharedPreferences("InMobi_Prefs_key", 0).edit();
        if (cachedUrl != null) {
            editor.putString(Constants.AD_SERVER_CACHED_URL, cachedUrl);
        }
        if (cachedUrlLife != null) {
            try {
                cachedUrlLifeNum = Long.parseLong(cachedUrlLife) * 1000;
            } catch (NumberFormatException e) {
                cachedUrlLifeNum = Constants.CACHED_AD_SERVER_LIFE;
            }
            editor.putLong(Constants.AD_SERVER_CACHED_LIFE, cachedUrlLifeNum);
        } else {
            editor.putLong(Constants.AD_SERVER_CACHED_LIFE, Constants.CACHED_AD_SERVER_LIFE);
        }
        editor.putLong(Constants.CACHED_AD_SERVER_TIMESTAMP, Calendar.getInstance().getTimeInMillis());
        editor.commit();
    }

    public String getNewAdActionType() {
        return this.newAdActionType;
    }

    public void setNewAdActionType(String newAdActionType2) {
        this.newAdActionType = newAdActionType2;
    }

    public void asyncPing(final String url) {
        new Thread() {
            public void run() {
                HttpURLConnection connection = null;
                try {
                    if (Constants.DEBUG) {
                        Log.d(Constants.LOGGING_TAG, "Pinging URL: " + url);
                    }
                    HttpURLConnection connection2 = (HttpURLConnection) new URL(url).openConnection();
                    connection2.setConnectTimeout(20000);
                    connection2.setRequestMethod("GET");
                    if (Constants.DEBUG) {
                        Log.d(Constants.LOGGING_TAG, "Async Ping Connection Response Code: " + connection2.getResponseCode());
                    }
                    if (connection2 != null) {
                        connection2.disconnect();
                    }
                } catch (Exception e) {
                    if (Constants.DEBUG) {
                        Log.d(Constants.LOGGING_TAG, "Error doing async Ping.", e);
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                } catch (Throwable th) {
                    if (connection != null) {
                        connection.disconnect();
                    }
                    throw th;
                }
            }
        }.start();
    }
}

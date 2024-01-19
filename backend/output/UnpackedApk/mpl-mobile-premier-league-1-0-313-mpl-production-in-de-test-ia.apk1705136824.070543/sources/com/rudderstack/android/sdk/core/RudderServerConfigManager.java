package com.rudderstack.android.sdk.core;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.gson.Gson;
import com.rudderstack.android.sdk.core.util.Utils;
import com.rudderstack.android.sdk.core.util.Utils.NetworkResponses;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class RudderServerConfigManager {
    public static final String RUDDER_SERVER_CONFIG_FILE_NAME = "RudderServerConfig";
    public static Context context;
    public static RudderServerConfigManager instance;
    public static ReentrantLock lock = new ReentrantLock();
    public static RudderPreferenceManager preferenceManger;
    public static RudderConfig rudderConfig;
    public static RudderServerConfig serverConfig;
    public Map<String, Object> integrationsMap = null;
    public NetworkResponses receivedError = NetworkResponses.SUCCESS;

    public RudderServerConfigManager(Application application, String str, RudderConfig rudderConfig2) {
        preferenceManger = RudderPreferenceManager.getInstance(application);
        rudderConfig = rudderConfig2;
        context = application.getApplicationContext();
        fetchConfig(str);
    }

    /* access modifiers changed from: private */
    public void downloadConfig(String str) {
        RudderLogger.logDebug(String.format("Downloading server config for writeKey: %s", new Object[]{str}));
        boolean z = false;
        int i = 0;
        while (!z && i <= 3) {
            try {
                String str2 = rudderConfig.getControlPlaneUrl() + "sourceConfig?p=android&v=" + Constants.RUDDER_LIBRARY_VERSION + "&bv=" + VERSION.SDK_INT;
                RudderLogger.logDebug(String.format(Locale.US, "RudderServerConfigManager: downloadConfig: configUrl: %s", new Object[]{str2}));
                HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str2).openConnection()));
                httpURLConnection.setRequestMethod(HttpGetRequest.METHOD_GET);
                StringBuilder sb = new StringBuilder();
                sb.append("Basic ");
                sb.append(Base64.encodeToString((str + ":").getBytes("UTF-8"), 0));
                httpURLConnection.setRequestProperty("Authorization", sb.toString());
                httpURLConnection.connect();
                RudderLogger.logDebug(String.format(Locale.US, "RudderServerConfigManager: downloadConfig: response status code: %d", new Object[]{Integer.valueOf(httpURLConnection.getResponseCode())}));
                if (httpURLConnection.getResponseCode() == 200) {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    for (int read = bufferedInputStream.read(); read != -1; read = bufferedInputStream.read()) {
                        byteArrayOutputStream.write((byte) read);
                    }
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    try {
                        RudderLogger.logDebug(String.format(Locale.US, "RudderServerConfigManager: downloadConfig: configJson: %s", new Object[]{byteArrayOutputStream2}));
                        preferenceManger.updateLastUpdatedTime();
                        saveRudderServerConfig((RudderServerConfig) new Gson().fromJson(byteArrayOutputStream2, RudderServerConfig.class));
                        RudderLogger.logInfo("RudderServerConfigManager: downloadConfig: server config download successful");
                        z = true;
                    } catch (Exception e2) {
                        i++;
                        try {
                            RudderLogger.logError("RudderServerConfigManager: downloadConfig: Failed to parse RudderServerConfig Object, retrying in " + i + "s");
                            e2.printStackTrace();
                            try {
                                Thread.sleep((long) (i * 1000));
                            } catch (InterruptedException e3) {
                                RudderLogger.logError((Exception) e3);
                            }
                            z = false;
                        } catch (Exception e4) {
                            e = e4;
                            z = false;
                            RudderLogger.logError(e);
                            i++;
                            RudderLogger.logInfo("downloadConfig: Retrying to download in " + i + "s");
                            try {
                                Thread.sleep((long) (i * 1000));
                            } catch (InterruptedException e5) {
                                RudderLogger.logError((Exception) e5);
                            }
                        }
                    }
                } else {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getErrorStream());
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                    for (int read2 = bufferedInputStream2.read(); read2 != -1; read2 = bufferedInputStream2.read()) {
                        byteArrayOutputStream3.write((byte) read2);
                    }
                    RudderLogger.logError("ServerError for FetchingConfig: " + byteArrayOutputStream3.toString());
                    if (byteArrayOutputStream3.toString().equals("{\"message\":\"Invalid write key\"}")) {
                        this.receivedError = NetworkResponses.WRITE_KEY_ERROR;
                        return;
                    }
                    i++;
                    RudderLogger.logInfo("downloadConfig: Retrying to download in " + i + "s");
                    this.receivedError = NetworkResponses.ERROR;
                    Thread.sleep((long) (i * 1000));
                }
            } catch (Exception e6) {
                e = e6;
                RudderLogger.logError(e);
                i++;
                RudderLogger.logInfo("downloadConfig: Retrying to download in " + i + "s");
                Thread.sleep((long) (i * 1000));
            }
        }
        if (!z) {
            RudderLogger.logDebug("Server config download failed.Using the last saved config from storage");
        }
    }

    private void fetchConfig(final String str) {
        if (TextUtils.isEmpty(str)) {
            this.receivedError = NetworkResponses.WRITE_KEY_ERROR;
            return;
        }
        Thread thread = new Thread(new Runnable() {
            public void run() {
                RudderServerConfigManager.this.downloadConfig(str);
                RudderServerConfigManager.lock.lock();
                RudderServerConfigManager.serverConfig = RudderServerConfigManager.this.getRudderServerConfig();
                if (RudderServerConfigManager.serverConfig == null) {
                    RudderLogger.logDebug("Server config retrieval failed.No config found in storage");
                    RudderLogger.logError(String.format("Failed to fetch server config for writeKey: %s", new Object[]{str}));
                }
                RudderServerConfigManager.lock.unlock();
            }
        });
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Download Thread Id:");
        outline73.append(thread.getId());
        RudderLogger.logVerbose(outline73.toString());
        thread.start();
    }

    private boolean isServerConfigOutDated() {
        long lastUpdatedTime = preferenceManger.getLastUpdatedTime();
        boolean z = true;
        RudderLogger.logDebug(String.format(Locale.US, "Last updated config time: %d", new Object[]{Long.valueOf(lastUpdatedTime)}));
        RudderLogger.logDebug(String.format(Locale.US, "ServerConfigInterval: %d", new Object[]{Integer.valueOf(rudderConfig.getConfigRefreshInterval())}));
        if (lastUpdatedTime == -1) {
            return true;
        }
        if (System.currentTimeMillis() - lastUpdatedTime <= ((long) (rudderConfig.getConfigRefreshInterval() * 60 * 60 * 1000))) {
            z = false;
        }
        return z;
    }

    public RudderServerConfig getConfig() {
        lock.lock();
        RudderServerConfig rudderServerConfig = serverConfig;
        lock.unlock();
        return rudderServerConfig;
    }

    public NetworkResponses getError() {
        return this.receivedError;
    }

    public Map<String, Object> getIntegrations() {
        if (this.integrationsMap == null) {
            this.integrationsMap = new HashMap();
            for (RudderServerDestination next : serverConfig.source.destinations) {
                if (!this.integrationsMap.containsKey(next.destinationDefinition.definitionName)) {
                    this.integrationsMap.put(next.destinationDefinition.definitionName, Boolean.valueOf(next.isDestinationEnabled));
                }
            }
        }
        return this.integrationsMap;
    }

    public RudderServerConfig getRudderServerConfig() {
        RudderServerConfig rudderServerConfig = null;
        try {
            if (Utils.fileExists(context, RUDDER_SERVER_CONFIG_FILE_NAME)) {
                FileInputStream openFileInput = context.openFileInput(RUDDER_SERVER_CONFIG_FILE_NAME);
                ObjectInputStream objectInputStream = new ObjectInputStream(openFileInput);
                RudderServerConfig rudderServerConfig2 = (RudderServerConfig) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    openFileInput.close();
                    rudderServerConfig = rudderServerConfig2;
                } catch (Exception e2) {
                    e = e2;
                    rudderServerConfig = rudderServerConfig2;
                    try {
                        RudderLogger.logError((String) "RudderServerConfigManager: getRudderServerConfig: Failed to read RudderServerConfig Object from File");
                        e.printStackTrace();
                    } catch (Throwable unused) {
                    }
                    return rudderServerConfig;
                } catch (Throwable unused2) {
                    rudderServerConfig = rudderServerConfig2;
                    return rudderServerConfig;
                }
            }
            return rudderServerConfig;
        } catch (Exception e3) {
            e = e3;
            RudderLogger.logError((String) "RudderServerConfigManager: getRudderServerConfig: Failed to read RudderServerConfig Object from File");
            e.printStackTrace();
            return rudderServerConfig;
        }
    }

    public void saveRudderServerConfig(RudderServerConfig rudderServerConfig) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(RUDDER_SERVER_CONFIG_FILE_NAME, 0);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(openFileOutput);
            objectOutputStream.writeObject(rudderServerConfig);
            objectOutputStream.close();
            openFileOutput.close();
        } catch (Exception e2) {
            RudderLogger.logError((String) "RudderServerConfigManager: saveRudderServerConfig: Exception while saving RudderServerConfig Object to File");
            e2.printStackTrace();
        }
    }
}

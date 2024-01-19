package in.juspay.hypersdk.services;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.core.JuspayLogger;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.Labels.HyperSdk;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.PaymentConstants.Event;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.data.KeyValueStore;
import in.juspay.hypersdk.data.SdkInfo;
import in.juspay.hypersdk.security.EncryptionHelper;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FileProviderService {
    public static final String LOG_TAG = "FileProviderService";
    public static int maxSecondsToLoad = 60;
    public final Map<String, String> fileCache = new HashMap();
    public final List<String> fileCacheWhiteList = new ArrayList();
    public final JuspayServices juspayServices;
    public boolean shouldCheckInternalAssets = true;

    public FileProviderService(JuspayServices juspayServices2) {
        this.juspayServices = juspayServices2;
    }

    private void cacheFile(String str, String str2) {
        this.fileCache.put(str, str2);
        JuspayServices juspayServices2 = this.juspayServices;
        juspayServices2.sdkDebug(LOG_TAG, "Caching file: " + str);
    }

    private void copyFile(Context context, String str, String str2) {
        SdkTracker sdkTracker;
        String str3;
        StringBuilder sb;
        FileOutputStream fileOutputStream;
        try {
            createJuspayDir(context);
            createRequiredDir(context, str2);
            JuspayServices juspayServices2 = this.juspayServices;
            juspayServices2.sdkDebug(LOG_TAG, "copyFile: " + str + "   " + str2);
            FileInputStream fileInputStream = new FileInputStream(getFileFromInternalStorage(context, str));
            try {
                fileOutputStream = new FileOutputStream(getFileFromInternalStorage(context, str2));
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        fileInputStream.close();
                        return;
                    }
                }
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
            sdkTracker.trackException("action", "system", System.FILE_PROVIDER_SERVICE, GeneratedOutlineSupport.outline62(sb, str3, str), e);
            return;
            throw th;
        } catch (FileNotFoundException e2) {
            e = e2;
            sdkTracker = this.juspayServices.getSdkTracker();
            sb = new StringBuilder();
            str3 = "File not found: ";
        } catch (Exception e3) {
            e = e3;
            sdkTracker = this.juspayServices.getSdkTracker();
            sb = new StringBuilder();
            str3 = "Exception: ";
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    private void createCertDir(Context context) {
        File file = new File(context.getDir("juspay", 0), "certificates_v1");
        if (!file.exists()) {
            file.mkdir();
        }
    }

    private void createJuspayDir(Context context) {
        File file = new File(context.getCacheDir(), "juspay");
        if (!file.exists()) {
            file.mkdir();
        }
    }

    private void createRequiredDir(Context context, String str) {
        if (str.contains("/")) {
            File file = new File(context.getDir("juspay", 0), str.substring(0, str.lastIndexOf("/")));
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }

    private void deleteFileFromCache(String str) {
        if (isFileCached(str)) {
            this.fileCache.remove(str);
        }
    }

    private File getFileFromInternalStorage(Context context, String str) {
        JuspayServices juspayServices2 = this.juspayServices;
        juspayServices2.sdkDebug(LOG_TAG, "Context while reading Internal Storage :" + context);
        JuspayServices juspayServices3 = this.juspayServices;
        juspayServices3.sdkDebug(LOG_TAG, "Getting file from internal storage. Filename: " + str);
        return new File(context.getDir("juspay", 0), str);
    }

    private void initialiseHashAndStatus(String str, final String str2, String str3, final int i) {
        JSONObject jSONObject;
        this.juspayServices.sdkDebug(LOG_TAG, "initialiseHashAndStatus: starting the initialise");
        try {
            JSONObject jSONObject2 = new JSONObject(KeyValueStore.read(this.juspayServices, PaymentConstants.JP_HASH_AND_STATUS, "{}"));
            if (jSONObject2.has(str2)) {
                JuspayServices juspayServices2 = this.juspayServices;
                juspayServices2.sdkDebug(LOG_TAG, "initialiseHashAndStatus: found the file name" + str2);
                jSONObject = jSONObject2.getJSONObject(str2);
            } else {
                JuspayServices juspayServices3 = this.juspayServices;
                juspayServices3.sdkDebug(LOG_TAG, "initialiseHashAndStatus: not found the file name" + str2);
                jSONObject = new JSONObject();
            }
            jSONObject.put("status", "in_progress");
            jSONObject.put("hashLoaded", str);
            jSONObject.put("used", str3);
            if (!str3.equalsIgnoreCase("asset")) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep((long) (i * 1000));
                            JSONObject jSONObject = new JSONObject(KeyValueStore.read(FileProviderService.this.juspayServices, PaymentConstants.JP_HASH_AND_STATUS, "{}"));
                            JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                            if (jSONObject2.getString("status").equals("in_progress") && KeyValueStore.read(FileProviderService.this.juspayServices, PaymentConstants.ASSET_MANAGE, BaseParser.FALSE).equals(BaseParser.TRUE)) {
                                jSONObject2.put("status", "not_loaded");
                                jSONObject.put(str2, jSONObject2);
                                KeyValueStore.write(FileProviderService.this.juspayServices, PaymentConstants.JP_HASH_AND_STATUS, jSONObject.toString());
                                JSONObject jSONObject3 = new JSONObject(KeyValueStore.read(FileProviderService.this.juspayServices, PaymentConstants.JP_BLOCKED_HASH, "{}"));
                                if (jSONObject2.getString("status").equalsIgnoreCase("not_loaded")) {
                                    JSONObject jSONObject4 = jSONObject3.has(str2) ? jSONObject3.getJSONObject(str2) : new JSONObject();
                                    jSONObject4.put(jSONObject2.get("used") + "_hash", jSONObject2.get("hashLoaded"));
                                    jSONObject3.put(str2, jSONObject4);
                                }
                                KeyValueStore.write(FileProviderService.this.juspayServices, PaymentConstants.JP_BLOCKED_HASH, jSONObject3.toString());
                                FileProviderService.this.juspayServices.addJsToWebView(String.format("window.onMerchantEvent('%s',atob('%s'));", new Object[]{"respawn", Base64.encodeToString(str2.getBytes(), 2)}));
                            }
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                }).start();
            }
            jSONObject2.put(str2, jSONObject);
            this.juspayServices.sdkDebug(LOG_TAG, "initialiseHashAndStatus: initialised");
            KeyValueStore.write(this.juspayServices, PaymentConstants.JP_HASH_AND_STATUS, jSONObject2.toString());
            this.juspayServices.sdkDebug(LOG_TAG, "initialiseHashAndStatus: done");
        } catch (Exception e2) {
            this.juspayServices.sdkDebug(LOG_TAG, "initialiseHashAndStatus: Exception");
            JuspayLogger.e(LOG_TAG, "initialiseHashAndStatus: Exception", e2);
        }
    }

    private Boolean isExternallyBlockedHash(String str) {
        if (KeyValueStore.read(this.juspayServices, PaymentConstants.ASSET_MANAGE, BaseParser.FALSE).equals(BaseParser.TRUE)) {
            try {
                JSONObject jSONObject = new JSONObject(KeyValueStore.read(this.juspayServices, "jp_external_blocked_hashes", "{}"));
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    JSONArray jSONArray = jSONObject.getJSONArray(keys.next());
                    int i = 0;
                    while (true) {
                        if (i < jSONArray.length()) {
                            if (jSONArray.getString(i).equals(str)) {
                                return Boolean.TRUE;
                            }
                            i++;
                        }
                    }
                }
            } catch (Exception e2) {
                this.juspayServices.getSdkTracker().trackException("action", "system", System.FILE_PROVIDER_SERVICE, "Exception: while checking isExternallyBlockedHash", e2);
            }
        }
        return Boolean.FALSE;
    }

    private boolean isFileCached(String str) {
        return this.fileCache.containsKey(str);
    }

    private boolean isHashPresent(String str, JSONObject jSONObject, String str2) {
        try {
            if (jSONObject.has(str2)) {
                String string = jSONObject.getString(str2);
                JuspayServices juspayServices2 = this.juspayServices;
                juspayServices2.sdkDebug(LOG_TAG, "readFromInternalStorage: blocked hash has " + str2 + " in it");
                if (string.equals(str) || isExternallyBlockedHash(str).booleanValue()) {
                    JuspayServices juspayServices3 = this.juspayServices;
                    juspayServices3.sdkDebug(LOG_TAG, "readFromInternalStorage: " + str2 + " blocked hash matched with the current hash- " + str);
                    this.juspayServices.sdkDebug(LOG_TAG, "readFromInternalStorage: before finding ");
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private String readFromAssets(Context context, String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            byte[] assetFileAsByte = getAssetFileAsByte(context, str);
            if (str.endsWith("jsa")) {
                JuspayServices juspayServices2 = this.juspayServices;
                juspayServices2.sdkDebug(LOG_TAG, "Read JSA Asset file " + str + " with encrypted hash - " + EncryptionHelper.md5(assetFileAsByte));
                return new String(EncryptionHelper.decryptThenGunzip(assetFileAsByte, context.getResources().getString(R.string.juspay_encryption_version)));
            }
            JuspayServices juspayServices3 = this.juspayServices;
            juspayServices3.sdkDebug(LOG_TAG, "Done reading " + str + " from assets");
            return new String(assetFileAsByte);
        } catch (Exception e2) {
            sdkTracker.trackException("action", "system", System.FILE_PROVIDER_SERVICE, GeneratedOutlineSupport.outline50("Exception trying to read from file: ", str), e2);
            return null;
        }
    }

    private void readFromInputStream(ByteArrayOutputStream byteArrayOutputStream, InputStream inputStream) {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private String readFromInternalStorage(Context context, String str, int i) {
        String str2;
        StringBuilder sb;
        Throwable th;
        Throwable th2;
        BufferedReader bufferedReader;
        Throwable th3;
        Context context2 = context;
        String str3 = str;
        int i2 = i;
        String appendSdkNameAndVersion = appendSdkNameAndVersion(str3);
        if (this.juspayServices.getSdkInfo().usesLocalAssets()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            if (appendSdkNameAndVersion.endsWith("jsa")) {
                byte[] decryptGunzipInternalStorage = decryptGunzipInternalStorage(context2, appendSdkNameAndVersion);
                this.juspayServices.sdkDebug(LOG_TAG, "readFromInternalStorage: started");
                this.juspayServices.sdkDebug(LOG_TAG, "readFromInternalStorage: asset manage is on");
                String str4 = "latest";
                try {
                    String md5 = EncryptionHelper.md5(decryptGunzipInternalStorage);
                    JuspayServices juspayServices2 = this.juspayServices;
                    juspayServices2.sdkDebug(LOG_TAG, "readFromInternalStorage: found the hash" + md5);
                    JSONObject jSONObject = new JSONObject(KeyValueStore.read(this.juspayServices, PaymentConstants.JP_BLOCKED_HASH, "{}"));
                    if (jSONObject.has(str3)) {
                        JuspayServices juspayServices3 = this.juspayServices;
                        juspayServices3.sdkDebug(LOG_TAG, "readFromInternalStorage: blocked hash has file name - " + str3);
                        JSONObject jSONObject2 = jSONObject.getJSONObject(str3);
                        if (isHashPresent(md5, jSONObject2, "latest_hash")) {
                            File dir = this.juspayServices.getContext().getDir("juspay", 0);
                            File file = new File(dir, "fb/" + appendSdkNameAndVersion);
                            JuspayServices juspayServices4 = this.juspayServices;
                            juspayServices4.sdkDebug(LOG_TAG, "readFromInternalStorage: after finding " + file.exists());
                            if (file.exists()) {
                                byte[] decryptGunzipInternalStorage2 = decryptGunzipInternalStorage(context2, "fb/" + appendSdkNameAndVersion);
                                md5 = EncryptionHelper.md5(decryptGunzipInternalStorage2);
                                if (KeyValueStore.read(this.juspayServices, PaymentConstants.ASSET_MANAGE, BaseParser.FALSE).equals(BaseParser.TRUE)) {
                                    decryptGunzipInternalStorage = decryptGunzipInternalStorage2;
                                }
                                if (isHashPresent(md5, jSONObject2, "fallback_hash")) {
                                    initialiseHashAndStatus(md5, str3, "asset", i2);
                                    return null;
                                }
                                str4 = Event.FALLBACK;
                            } else {
                                JuspayServices juspayServices5 = this.juspayServices;
                                juspayServices5.sdkDebug(LOG_TAG, "readFromInternalStorage: There is no fallback present- " + md5);
                                this.juspayServices.sdkDebug(LOG_TAG, "readFromInternalStorage: using asset");
                                initialiseHashAndStatus(md5, str3, "asset", i2);
                                return null;
                            }
                        }
                    }
                    JuspayServices juspayServices6 = this.juspayServices;
                    juspayServices6.sdkDebug(LOG_TAG, "readFromInternalStorage: the final status is - " + md5 + "   " + str3 + "   " + str4);
                    initialiseHashAndStatus(md5, str3, str4, i2);
                } catch (Exception e2) {
                    JuspayLogger.e(LOG_TAG, "Problem while smart fallback" + appendSdkNameAndVersion, e2);
                }
                if (decryptGunzipInternalStorage != null) {
                    JuspayServices juspayServices7 = this.juspayServices;
                    juspayServices7.sdkDebug(LOG_TAG, "Reading complete. From InternalStorage - " + appendSdkNameAndVersion);
                    return new String(decryptGunzipInternalStorage);
                }
            }
            FileInputStream fileInputStream = new FileInputStream(getFileFromInternalStorage(context2, appendSdkNameAndVersion));
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        int read = bufferedReader.read();
                        if (read != -1) {
                            sb2.append((char) read);
                        } else {
                            bufferedReader.close();
                            inputStreamReader.close();
                            String sb3 = sb2.toString();
                            fileInputStream.close();
                            return sb3;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    inputStreamReader.close();
                    throw th2;
                }
            } catch (Throwable th5) {
                th = th5;
                fileInputStream.close();
                throw th;
            }
        } catch (FileNotFoundException unused) {
            JuspayServices juspayServices8 = this.juspayServices;
            juspayServices8.sdkDebug(LOG_TAG, "File not found " + appendSdkNameAndVersion);
            return null;
        } catch (IOException e3) {
            e = e3;
            sb = new StringBuilder();
            str2 = "IOException. Could not read ";
            sb.append(str2);
            sb.append(appendSdkNameAndVersion);
            JuspayLogger.e(LOG_TAG, sb.toString(), e);
            return null;
        } catch (Exception e4) {
            e = e4;
            sb = new StringBuilder();
            str2 = "Could not read ";
            sb.append(str2);
            sb.append(appendSdkNameAndVersion);
            JuspayLogger.e(LOG_TAG, sb.toString(), e);
            return null;
        } catch (Throwable th6) {
            th.addSuppressed(th6);
        }
        throw th3;
    }

    private void updateFallback(Context context, String str, String str2) {
        SdkTracker sdkTracker;
        String str3;
        StringBuilder sb;
        if (str2.endsWith("jsa") && isFilePresent(context, str2)) {
            this.juspayServices.sdkDebug(LOG_TAG, GeneratedOutlineSupport.outline53("updateFallback: starting", str2, "  ", str));
            try {
                String md5 = EncryptionHelper.md5(decryptGunzipInternalStorage(context, str2));
                JSONObject jSONObject = new JSONObject(KeyValueStore.read(this.juspayServices, PaymentConstants.JP_BLOCKED_HASH, "{}"));
                this.juspayServices.sdkDebug(LOG_TAG, "updateFallback: got the blocked hash");
                if (jSONObject.has(str)) {
                    JuspayServices juspayServices2 = this.juspayServices;
                    juspayServices2.sdkDebug(LOG_TAG, "updateFallback: got the file name " + str);
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                    if (!jSONObject2.has("latest_hash") || !jSONObject2.getString("latest_hash").equals(md5)) {
                        this.juspayServices.sdkDebug(LOG_TAG, "updateFallback: wonderful.. copying to the fallback");
                        copyFile(context, str2, "fb/" + str2);
                        jSONObject2.remove("latest_hash");
                        jSONObject.put(str, jSONObject2);
                        KeyValueStore.write(this.juspayServices, PaymentConstants.JP_BLOCKED_HASH, jSONObject.toString());
                    } else {
                        return;
                    }
                } else {
                    copyFile(context, str2, "fb/" + str2);
                    JuspayServices juspayServices3 = this.juspayServices;
                    juspayServices3.sdkDebug(LOG_TAG, "updateFallback: we didn;t get the file name from blocked hash " + str2);
                    this.juspayServices.sdkDebug(LOG_TAG, "updateFallback: wonderful.. copying to the fallback");
                }
                this.juspayServices.sdkDebug(LOG_TAG, "updateFallback: file copied");
            } catch (FileNotFoundException e2) {
                e = e2;
                sdkTracker = this.juspayServices.getSdkTracker();
                sb = new StringBuilder();
                str3 = "File not found: ";
                sdkTracker.trackException("action", "system", HyperSdk.AUTO_FALLBACK, GeneratedOutlineSupport.outline62(sb, str3, str2), e);
            } catch (Exception e3) {
                e = e3;
                sdkTracker = this.juspayServices.getSdkTracker();
                sb = new StringBuilder();
                str3 = "Exception: ";
                sdkTracker.trackException("action", "system", HyperSdk.AUTO_FALLBACK, GeneratedOutlineSupport.outline62(sb, str3, str2), e);
            }
        }
    }

    private boolean writeToFile(Context context, String str, byte[] bArr, boolean z) {
        String str2;
        StringBuilder sb;
        FileOutputStream fileOutputStream;
        String appendSdkNameAndVersion = appendSdkNameAndVersion(str);
        updateFallback(context, str, appendSdkNameAndVersion);
        deleteFileFromCache(appendSdkNameAndVersion);
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            JuspayServices juspayServices2 = this.juspayServices;
            juspayServices2.sdkDebug(LOG_TAG, "Updating file in internal storage: " + appendSdkNameAndVersion);
            createJuspayDir(context);
            createRequiredDir(context, appendSdkNameAndVersion);
            if (z) {
                createCertDir(context);
            }
            fileOutputStream = new FileOutputStream(getFileFromInternalStorage(context, appendSdkNameAndVersion));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException e2) {
            e = e2;
            sb = new StringBuilder();
            str2 = "File not found: ";
            sdkTracker.trackException("action", "system", System.FILE_PROVIDER_SERVICE, GeneratedOutlineSupport.outline62(sb, str2, appendSdkNameAndVersion), e);
            return false;
        } catch (IOException e3) {
            e = e3;
            sb = new StringBuilder();
            str2 = "IOException: ";
            sdkTracker.trackException("action", "system", System.FILE_PROVIDER_SERVICE, GeneratedOutlineSupport.outline62(sb, str2, appendSdkNameAndVersion), e);
            return false;
        } catch (Exception e4) {
            e = e4;
            sb = new StringBuilder();
            str2 = "Exception: ";
            sdkTracker.trackException("action", "system", System.FILE_PROVIDER_SERVICE, GeneratedOutlineSupport.outline62(sb, str2, appendSdkNameAndVersion), e);
            return false;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void addToFileCacheWhiteList(String str) {
        this.fileCacheWhiteList.add(str);
    }

    public String appendSdkNameAndVersion(String str) {
        String str2;
        StringBuilder sb;
        SdkInfo sdkInfo = this.juspayServices.getSdkInfo();
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf <= 0 || lastIndexOf >= str.length() - 1) {
            sb = GeneratedOutlineSupport.outline78(str, "_");
            sb.append(sdkInfo.getSdkName());
            sb.append("_");
            str2 = sdkInfo.getSdkVersion();
        } else {
            String substring = str.substring(0, lastIndexOf);
            str2 = str.substring(lastIndexOf);
            sb = GeneratedOutlineSupport.outline78(substring, "_");
            sb.append(sdkInfo.getSdkName());
            sb.append("_");
            sb.append(sdkInfo.getSdkVersion());
        }
        sb.append(str2);
        return sb.toString();
    }

    public void clearCache() {
        this.fileCache.clear();
        this.fileCacheWhiteList.clear();
    }

    public byte[] decryptGunzipAssetFile(Context context, String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        byte[] bArr = new byte[0];
        try {
            bArr = getAssetFileAsByte(context, str);
        } catch (Exception e2) {
            sdkTracker.trackException("action", "system", System.FILE_PROVIDER_SERVICE, GeneratedOutlineSupport.outline52("Exception in reading ", str, " from assets"), e2);
        }
        return EncryptionHelper.decryptThenGunzip(bArr, context.getResources().getString(R.string.juspay_encryption_version));
    }

    public byte[] decryptGunzipInternalStorage(Context context, String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            byte[] internalStorageFileAsByte = getInternalStorageFileAsByte(context, str);
            JuspayServices juspayServices2 = this.juspayServices;
            juspayServices2.sdkDebug(LOG_TAG, "Read Encrypted file from internalStorage - " + str + " with encrypted hash - " + EncryptionHelper.md5(internalStorageFileAsByte));
            return EncryptionHelper.decryptThenGunzip(internalStorageFileAsByte, context.getResources().getString(R.string.juspay_encryption_version));
        } catch (FileNotFoundException e2) {
            JuspayServices juspayServices3 = this.juspayServices;
            juspayServices3.sdkDebug(LOG_TAG, "No File to decrypt in internal storage: " + str);
            throw e2;
        } catch (Exception e3) {
            sdkTracker.trackException("action", "system", System.FILE_PROVIDER_SERVICE, GeneratedOutlineSupport.outline52("Exception in reading ", str, " from internal storage"), e3);
            return null;
        }
    }

    public boolean deleteFileFromInternalStorage(Context context, String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        RemoteAssetService remoteAssetService = this.juspayServices.getRemoteAssetService();
        File fileFromInternalStorage = getFileFromInternalStorage(context, str);
        if (fileFromInternalStorage.exists()) {
            JuspayServices juspayServices2 = this.juspayServices;
            juspayServices2.sdkDebug(LOG_TAG, "Deleting " + str + " from internal storage");
            JuspayLogger.e(LOG_TAG, "FILE CORRUPTED. DISABLING SDK");
            sdkTracker.trackAction("system", "warning", System.FILE_PROVIDER_SERVICE, "file_corrupted", str);
            try {
                remoteAssetService.resetMetadata(str.replace(".zip", ".jsa"));
            } catch (Exception e2) {
                sdkTracker.trackException("action", "system", System.FILE_PROVIDER_SERVICE, "Error while resetting etag", e2);
            }
            return fileFromInternalStorage.delete();
        }
        JuspayLogger.e(LOG_TAG, str + " not found");
        return false;
    }

    public byte[] getAssetFileAsByte(Context context, String str) {
        InputStream open;
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                AssetManager assets = context.getResources().getAssets();
                open = assets.open("juspay/" + str);
                readFromInputStream(byteArrayOutputStream, open);
                if (open != null) {
                    open.close();
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                byteArrayOutputStream.close();
                throw th;
            }
            throw th;
        } catch (FileNotFoundException e2) {
            sdkTracker.trackException("action", "system", System.FILE_PROVIDER_SERVICE, GeneratedOutlineSupport.outline50("Could not read ", str), e2);
            throw new RuntimeException(e2);
        } catch (IOException e3) {
            sdkTracker.trackException("action", "system", System.FILE_PROVIDER_SERVICE, GeneratedOutlineSupport.outline50("Could not read ", str), e3);
            deleteFileFromInternalStorage(context, str);
            throw new RuntimeException(e3);
        } catch (Exception e4) {
            sdkTracker.trackException("action", "system", System.FILE_PROVIDER_SERVICE, GeneratedOutlineSupport.outline50("Exception: Could not read ", str), e4);
            deleteFileFromInternalStorage(context, str);
            return new byte[0];
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    public byte[] getInternalStorageFileAsByte(Context context, String str) {
        FileInputStream fileInputStream;
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        RemoteAssetService remoteAssetService = this.juspayServices.getRemoteAssetService();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(getFileFromInternalStorage(context, str));
                readFromInputStream(byteArrayOutputStream, fileInputStream);
                fileInputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                byteArrayOutputStream.close();
                throw th;
            }
            throw th;
        } catch (FileNotFoundException e2) {
            JuspayServices juspayServices2 = this.juspayServices;
            juspayServices2.sdkDebug(LOG_TAG, "File not found " + str);
            try {
                remoteAssetService.resetMetadata(str.replace(".zip", ".jsa"));
            } catch (JSONException unused) {
                sdkTracker.trackException("action", "system", System.FILE_PROVIDER_SERVICE, GeneratedOutlineSupport.outline50("Couldn't reset ", str), e2);
            }
            throw e2;
        } catch (IOException e3) {
            sdkTracker.trackException("action", "system", System.FILE_PROVIDER_SERVICE, GeneratedOutlineSupport.outline50("Could not read ", str), e3);
            deleteFileFromInternalStorage(context, str);
            throw new RuntimeException(e3);
        } catch (Exception e4) {
            sdkTracker.trackException("action", "system", System.FILE_PROVIDER_SERVICE, GeneratedOutlineSupport.outline50("Exception: Could not read ", str), e4);
            deleteFileFromInternalStorage(context, str);
            throw new RuntimeException(e4);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    public boolean isFilePresent(Context context, String str) {
        boolean z = true;
        if (this.shouldCheckInternalAssets && new File(context.getDir("juspay", 0), appendSdkNameAndVersion(str)).exists()) {
            return true;
        }
        try {
            AssetManager assets = context.getResources().getAssets();
            InputStream open = assets.open("juspay/" + str);
            if (open == null) {
                z = false;
            }
            if (open != null) {
                open.close();
            }
            return z;
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean isShouldCheckInternalAssets() {
        return this.shouldCheckInternalAssets;
    }

    public String readFromCache(String str) {
        if (!isFileCached(str)) {
            return null;
        }
        String str2 = this.fileCache.get(str);
        JuspayServices juspayServices2 = this.juspayServices;
        juspayServices2.sdkDebug(LOG_TAG, "Returning cached value of the file: " + str);
        JuspayServices juspayServices3 = this.juspayServices;
        juspayServices3.sdkDebug(LOG_TAG, "Cached: " + str2);
        return str2;
    }

    public String readFromFile(Context context, String str) {
        return readFromFile(context, str, true, maxSecondsToLoad);
    }

    public String readFromFile(Context context, String str, int i) {
        return readFromFile(context, str, true, i);
    }

    public String readFromFile(Context context, String str, boolean z) {
        return readFromFile(context, str, z, maxSecondsToLoad);
    }

    public String readFromFile(Context context, String str, boolean z, int i) {
        String readFromCache = z ? readFromCache(str) : null;
        if (readFromCache == null && this.shouldCheckInternalAssets) {
            readFromCache = readFromInternalStorage(context, str, i);
        }
        if (readFromCache == null) {
            readFromCache = readFromAssets(context, str);
        }
        if (this.fileCacheWhiteList.contains(str) && readFromCache != null) {
            cacheFile(str, readFromCache);
        }
        return readFromCache == null ? "" : readFromCache;
    }

    public void setShouldCheckInternalAssets(boolean z) {
        this.shouldCheckInternalAssets = z;
    }

    public boolean updateCertificate(Context context, String str, byte[] bArr) {
        return writeToFile(context, str, bArr, true);
    }

    public boolean updateFile(Context context, String str, byte[] bArr) {
        return writeToFile(context, str, bArr, false);
    }
}

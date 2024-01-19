package in.juspay.hypersdk.services;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.data.KeyValueStore;
import in.juspay.hypersdk.data.SessionInfo;
import in.juspay.hypersdk.security.EncryptionHelper;
import in.juspay.hypersdk.utils.network.NetUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;
import org.json.JSONException;
import org.json.JSONObject;

public class RemoteAssetService {
    public static final String LOG_TAG = "RemoteAssetService";
    public Object assetMetaDataLock = new Object();
    public JSONObject assetMetadata;
    public JuspayServices juspayServices;
    public final String sdkName;

    public static class AssetDownloadTask extends AsyncTask<Void, Void, Boolean> {
        public String callback;
        public Context context;
        public String fileName;
        public String location;
        public RemoteAssetService remoteAssetService;
        public long ttlInMilliSeconds;

        public AssetDownloadTask(Context context2, String str, String str2, String str3, long j, RemoteAssetService remoteAssetService2) {
            this.location = str;
            this.fileName = str2;
            this.callback = str3;
            this.ttlInMilliSeconds = j;
            this.remoteAssetService = remoteAssetService2;
            this.context = context2;
        }

        public Boolean doInBackground(Void... voidArr) {
            if (this.context != null) {
                try {
                    if (!this.location.contains("certificates")) {
                        return Boolean.valueOf(this.remoteAssetService.getContent(this.context, this.location, this.fileName, this.ttlInMilliSeconds));
                    }
                    this.remoteAssetService.updateCertificates(this.context, this.location, this.ttlInMilliSeconds);
                } catch (Exception e2) {
                    Exception exc = e2;
                    SdkTracker sdkTracker = this.remoteAssetService.juspayServices.getSdkTracker();
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Could not renew file ");
                    outline73.append(this.location);
                    outline73.append(": ");
                    outline73.append(exc.getMessage());
                    sdkTracker.trackAndLogException(RemoteAssetService.LOG_TAG, "action", "system", System.REMOTE_ASSET_SERVICE, outline73.toString(), exc);
                }
            }
            return Boolean.FALSE;
        }

        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            String str = this.callback;
            if (str != null) {
                String format = String.format("window.callUICallback('%s', '%b', '%s', '%s');", new Object[]{str, bool, this.location, this.remoteAssetService.juspayServices.getFileProviderService().appendSdkNameAndVersion(this.fileName)});
                this.remoteAssetService.juspayServices.sdkDebug(RemoteAssetService.LOG_TAG, format);
                this.remoteAssetService.juspayServices.addJsToWebView(format);
            }
        }
    }

    public RemoteAssetService(JuspayServices juspayServices2) {
        this.juspayServices = juspayServices2;
        this.sdkName = juspayServices2.getSdkInfo().getSdkName();
    }

    private String decideAndUpdateInternalStorage(Context context, byte[] bArr, String str, String str2) {
        boolean z;
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        FileProviderService fileProviderService = this.juspayServices.getFileProviderService();
        String md5 = EncryptionHelper.md5(bArr);
        if (md5 == null) {
            md5 = "";
        }
        String str3 = md5;
        JuspayServices juspayServices2 = this.juspayServices;
        juspayServices2.sdkDebug(LOG_TAG, "hashInDisk: " + str);
        JuspayServices juspayServices3 = this.juspayServices;
        juspayServices3.sdkDebug(LOG_TAG, "newHash: " + str3);
        StringBuilder sb = new StringBuilder();
        sb.append("Hash of used file '");
        sdkTracker.trackAction("system", "info", System.REMOTE_ASSET_SERVICE, "remote_asset_service_update_hash", GeneratedOutlineSupport.outline63(sb, str2, "' is now ", str3));
        if (str == null || !str.equals(str3)) {
            sdkTracker.trackAction("system", "info", System.REMOTE_ASSET_SERVICE, "remote_asset_service_compare_hash", GeneratedOutlineSupport.outline52("Remote hash differs from disk hash. Updating asset '", str2, "'"));
            z = fileProviderService.updateFile(context, str2, bArr);
        } else {
            sdkTracker.trackAction("system", "info", System.REMOTE_ASSET_SERVICE, "remote_asset_service_compare_hash", GeneratedOutlineSupport.outline52("Remote hash is same as disk hash. Not updating asset '", str2, "'"));
            z = false;
        }
        if (z) {
            return str3;
        }
        return null;
    }

    private byte[] download(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("ts", String.valueOf(System.currentTimeMillis()));
        hashMap.put(Names.IF_NONE_MATCH, str);
        hashMap.put("Accept-Encoding", "gzip");
        JuspayServices juspayServices2 = this.juspayServices;
        juspayServices2.sdkDebug(LOG_TAG, "START fetching content from: " + str2);
        try {
            return new NetUtils(0, 0, false).fetchIfModified(str2, hashMap);
        } catch (Exception e2) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", System.REMOTE_ASSET_SERVICE, "Error While Downloading File", e2);
            return null;
        }
    }

    private long getAssetTtl() {
        return Long.parseLong(KeyValueStore.read(this.juspayServices.getContext(), this.sdkName, ServiceConstants.KEY_REMOTE_ASSET_TTL, String.valueOf(3600000)));
    }

    private boolean getContent(Context context, String str, long j) {
        return getContent(context, str, null, j);
    }

    /* access modifiers changed from: private */
    public boolean getContent(Context context, String str, String str2, long j) {
        String str3;
        boolean z;
        Throwable th;
        Context context2 = context;
        SessionInfo sessionInfo = this.juspayServices.getSessionInfo();
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        FileProviderService fileProviderService = this.juspayServices.getFileProviderService();
        String replace = !sessionInfo.isVerifyAssetsEnabled() ? str.replace(".zip", ".jsa") : str;
        String substring = str2 == null ? replace.substring(replace.lastIndexOf("/") + 1) : str2;
        String replace2 = substring.replace(".zip", ".jsa");
        JSONObject metadata = getMetadata(replace2);
        String str4 = "";
        if (metadata.getString(ServiceConstants.ATTR_LAST_CHECKED) != null) {
            str3 = metadata.getString(PaymentConstants.ATTR_HASH_IN_DISK);
            str4 = metadata.getString(ServiceConstants.ATTR_ZIPHASH_IN_DISK);
        } else if (!substring.contains(".zip")) {
            FileInputStream fileInputStream = new FileInputStream(fileProviderService.readFromFile(context2, substring, false));
            try {
                str3 = EncryptionHelper.md5((InputStream) fileInputStream);
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            str3 = str4;
        }
        byte[] download = download(str4, replace);
        if (download != null) {
            str4 = EncryptionHelper.md5(download);
            z = true;
        } else {
            z = false;
        }
        byte[] unZipAndVerify = unZipAndVerify(context2, download, substring);
        if (unZipAndVerify == null) {
            if (!z) {
                sdkTracker.trackAction("system", "info", System.REMOTE_ASSET_SERVICE, "remote_asset_service_etag_match", GeneratedOutlineSupport.outline53("ETAG matches for '", substring, "'. Not downloading from ", replace));
                return false;
            }
            unZipAndVerify = EncryptionHelper.v1Encrypt(fileProviderService.readFromFile(context2, replace2, false).getBytes());
        }
        if (unZipAndVerify != null) {
            JuspayServices juspayServices2 = this.juspayServices;
            juspayServices2.sdkDebug(LOG_TAG, "DONE fetching content from: " + replace);
            JuspayServices juspayServices3 = this.juspayServices;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Text: ");
            outline73.append(new String(unZipAndVerify));
            juspayServices3.sdkDebug(LOG_TAG, outline73.toString());
        }
        String decideAndUpdateInternalStorage = decideAndUpdateInternalStorage(context2, unZipAndVerify, str3, replace2);
        if (decideAndUpdateInternalStorage != null) {
            metadata.put(ServiceConstants.ATTR_LAST_CHECKED, System.currentTimeMillis());
            metadata.put(PaymentConstants.ATTR_HASH_IN_DISK, decideAndUpdateInternalStorage);
            metadata.put(ServiceConstants.ATTR_ZIPHASH_IN_DISK, str4);
            setMetadata(replace2, metadata);
        }
        return true;
        throw th;
    }

    private synchronized void setMetadata(String str, JSONObject jSONObject) {
        if (this.assetMetadata == null) {
            getMetadata(str);
        }
        this.assetMetadata.put(str, jSONObject);
        KeyValueStore.write(this.juspayServices.getContext(), this.sdkName, ServiceConstants.ASSET_METADATA_FILE_NAME, this.assetMetadata.toString());
    }

    private byte[] unZipAndVerify(Context context, byte[] bArr, String str) {
        ZipInputStream zipInputStream;
        Throwable th;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        ObjectInputStream objectInputStream;
        FileProviderService fileProviderService = this.juspayServices.getFileProviderService();
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        if (bArr == null || !str.contains(".zip")) {
            return bArr;
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                zipInputStream = new ZipInputStream(byteArrayInputStream);
                byte[] bArr2 = null;
                byte[] bArr3 = null;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr4 = new byte[1024];
                            while (true) {
                                int read = zipInputStream.read(bArr4);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr4, 0, read);
                            }
                            zipInputStream.closeEntry();
                            byteArrayOutputStream.close();
                            if (nextEntry.getName().contains("signature")) {
                                bArr2 = Base64.decode(byteArrayOutputStream.toByteArray(), 2);
                            } else if (nextEntry.getName().contains(".jsa") || (str.contains("certificate") && nextEntry.getName().contains(".zip"))) {
                                bArr3 = byteArrayOutputStream.toByteArray();
                            }
                        } else {
                            try {
                                break;
                            } catch (ClassNotFoundException e2) {
                                th = e2;
                                str2 = LOG_TAG;
                                str3 = "action";
                                str4 = "system";
                                str5 = System.REMOTE_ASSET_SERVICE;
                                str6 = "Exception while Reading Public Key";
                                sdkTracker.trackAndLogException(str2, str3, str4, str5, str6, th);
                                zipInputStream.close();
                                byteArrayInputStream.close();
                                return null;
                            } catch (NoSuchAlgorithmException e3) {
                                th = e3;
                                str2 = LOG_TAG;
                                str3 = "action";
                                str4 = "system";
                                str5 = System.REMOTE_ASSET_SERVICE;
                                str6 = "DSA Algorithm not found";
                                sdkTracker.trackAndLogException(str2, str3, str4, str5, str6, th);
                                zipInputStream.close();
                                byteArrayInputStream.close();
                                return null;
                            } catch (InvalidKeyException e4) {
                                th = e4;
                                str2 = LOG_TAG;
                                str3 = "action";
                                str4 = "system";
                                str5 = System.REMOTE_ASSET_SERVICE;
                                str6 = "Key Used was Invalid";
                                sdkTracker.trackAndLogException(str2, str3, str4, str5, str6, th);
                                zipInputStream.close();
                                byteArrayInputStream.close();
                                return null;
                            } catch (SignatureException e5) {
                                th = e5;
                                str2 = LOG_TAG;
                                str3 = "action";
                                str4 = "system";
                                str5 = System.REMOTE_ASSET_SERVICE;
                                str6 = "Exception while matching Signature for file";
                                sdkTracker.trackAndLogException(str2, str3, str4, str5, str6, th);
                                zipInputStream.close();
                                byteArrayInputStream.close();
                                return null;
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                    } catch (Exception e6) {
                        sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.REMOTE_ASSET_SERVICE, "Exception while verifying Signature", e6);
                    }
                }
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(fileProviderService.getAssetFileAsByte(context, "remoteAssetPublicKey")));
                Signature instance = Signature.getInstance("DSA");
                instance.initVerify((PublicKey) objectInputStream.readObject());
                instance.update(bArr3);
                if (!instance.verify(bArr2)) {
                    sdkTracker.trackAction("system", "info", System.REMOTE_ASSET_SERVICE, "signature_not_verified", str);
                    objectInputStream.close();
                    zipInputStream.close();
                    byteArrayInputStream.close();
                    return null;
                }
                sdkTracker.trackAction("system", "info", System.REMOTE_ASSET_SERVICE, "signature_verified", str);
                objectInputStream.close();
                zipInputStream.close();
                byteArrayInputStream.close();
                return bArr3;
            } catch (Throwable th3) {
                byteArrayInputStream.close();
                throw th3;
            }
        } catch (IOException e7) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.REMOTE_ASSET_SERVICE, "IOException while verifying Signature", e7);
        } catch (Throwable th4) {
            th3.addSuppressed(th4);
        }
        throw th;
        throw th;
    }

    private String unzipAndUpdateInternalStorage(Context context, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileProviderService fileProviderService = this.juspayServices.getFileProviderService();
        String md5 = EncryptionHelper.md5(bArr);
        if (md5 == null) {
            md5 = "";
        }
        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(bArr));
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    String name = nextEntry.getName();
                    if (!nextEntry.isDirectory()) {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            int read = zipInputStream.read();
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(read);
                        }
                        fileProviderService.updateCertificate(context, name, byteArrayOutputStream.toByteArray());
                        byteArrayOutputStream.close();
                    }
                } else {
                    zipInputStream.close();
                    return md5;
                }
            } catch (Throwable th) {
                try {
                    zipInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        throw th;
    }

    /* access modifiers changed from: private */
    public void updateCertificates(Context context, String str, long j) {
        String str2;
        String str3;
        boolean z;
        String str4;
        Context context2 = context;
        String str5 = str;
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        JSONObject metadata = getMetadata(str5);
        String substring = str5.substring(str5.lastIndexOf("/") + 1);
        if (metadata.getString(ServiceConstants.ATTR_LAST_CHECKED) != null) {
            str3 = metadata.getString(PaymentConstants.ATTR_HASH_IN_DISK);
            str2 = metadata.getString(ServiceConstants.ATTR_ZIPHASH_IN_DISK);
        } else {
            str3 = "";
            str2 = str3;
        }
        byte[] download = download(str2, str5);
        if (download != null) {
            str4 = EncryptionHelper.md5(download);
            z = true;
        } else {
            str4 = str2;
            z = false;
        }
        byte[] unZipAndVerify = unZipAndVerify(context2, download, substring);
        JuspayServices juspayServices2 = this.juspayServices;
        juspayServices2.sdkDebug(LOG_TAG, "DONE fetching content from: " + str5);
        JuspayServices juspayServices3 = this.juspayServices;
        StringBuilder sb = new StringBuilder();
        byte[] bArr = unZipAndVerify;
        sb.append("hashInDisk: ");
        sb.append(str3);
        juspayServices3.sdkDebug(LOG_TAG, sb.toString());
        this.juspayServices.sdkDebug(LOG_TAG, "newHash: ");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Hash of used file '");
        sb2.append(substring);
        String outline62 = GeneratedOutlineSupport.outline62(sb2, "' is now ", "");
        String str6 = ServiceConstants.ATTR_ZIPHASH_IN_DISK;
        byte[] bArr2 = bArr;
        sdkTracker.trackAction("system", "info", System.REMOTE_ASSET_SERVICE, "remote_asset_service_update_hash", outline62);
        if (bArr2 != null) {
            String unzipAndUpdateInternalStorage = unzipAndUpdateInternalStorage(context2, bArr2);
            metadata.put(ServiceConstants.ATTR_LAST_CHECKED, System.currentTimeMillis());
            metadata.put(PaymentConstants.ATTR_HASH_IN_DISK, unzipAndUpdateInternalStorage);
            metadata.put(str6, str4);
            setMetadata(str5, metadata);
        } else if (!z) {
            sdkTracker.trackAction("system", "info", System.REMOTE_ASSET_SERVICE, "remote_asset_service_etag_match", GeneratedOutlineSupport.outline53("ETAG matches for '", substring, "'. Not downloading from ", str5));
        }
    }

    public boolean getContent(Context context, String str) {
        return getContent(context, str, getAssetTtl());
    }

    public synchronized JSONObject getMetadata(String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            this.assetMetadata = new JSONObject(KeyValueStore.read(this.juspayServices.getContext(), this.sdkName, ServiceConstants.ASSET_METADATA_FILE_NAME, "{}"));
            JuspayServices juspayServices2 = this.juspayServices;
            juspayServices2.sdkDebug(LOG_TAG, "assetMetadata: " + this.assetMetadata);
            if (!this.assetMetadata.has(str)) {
                this.assetMetadata.put(str, new JSONObject());
                ((JSONObject) this.assetMetadata.get(str)).put(ServiceConstants.ATTR_LAST_CHECKED, 0);
                ((JSONObject) this.assetMetadata.get(str)).put(PaymentConstants.ATTR_HASH_IN_DISK, "");
                ((JSONObject) this.assetMetadata.get(str)).put(ServiceConstants.ATTR_ZIPHASH_IN_DISK, "");
            }
        } catch (JSONException e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.REMOTE_ASSET_SERVICE, "Exception trying to read from KeyStore: asset_metadata.json", e2);
            throw new RuntimeException("Unexpected internal error.", e2);
        }
        return (JSONObject) this.assetMetadata.get(str);
    }

    public void renewFile(Context context, String str, String str2) {
        renewFile(context, str, str2, getAssetTtl(), null);
    }

    public void renewFile(Context context, String str, String str2, long j, String str3) {
        JuspayServices juspayServices2 = this.juspayServices;
        juspayServices2.sdkDebug(LOG_TAG, "Looking to renew file: " + str);
        AssetDownloadTask assetDownloadTask = new AssetDownloadTask(context, str, str3, str2, j, this);
        assetDownloadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void renewFile(Context context, String str, String str2, String str3) {
        renewFile(context, str, str2, getAssetTtl(), str3);
    }

    public synchronized void resetMetadata(String str) {
        if (this.assetMetadata == null) {
            getMetadata(str);
        }
        this.assetMetadata.remove(str);
        KeyValueStore.write(this.juspayServices.getContext(), this.sdkName, ServiceConstants.ASSET_METADATA_FILE_NAME, this.assetMetadata.toString());
    }
}

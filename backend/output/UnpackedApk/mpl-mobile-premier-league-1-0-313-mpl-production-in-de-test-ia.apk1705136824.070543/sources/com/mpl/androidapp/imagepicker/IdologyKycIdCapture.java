package com.mpl.androidapp.imagepicker;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.idology.cameralibrary.ActivationKey;
import com.idology.cameralibrary.CameraActivity;
import com.idology.cameralibrary.CameraCallBack2;
import com.idology.cameralibrary.CameraLib;
import com.idology.cameralibrary.CameraSdkSettings$DocumentType;
import com.idology.cameralibrary.Constants;
import com.idology.cameralibrary.IActivationKeyProvider;
import com.idology.cameralibrary.IPublicKeyProvider;
import com.mpl.androidapp.R;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.payment.gopay.GopayLinkingHandler;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class IdologyKycIdCapture implements KycIdProvider {
    public static final String DOC_TYPE_ANY = "Any";
    public static final String DOC_TYPE_DL_ONLY = "DriverLicenseOnly";
    public static final String DOC_TYPE_PASSPORT_ONLY = "PassportOnly";
    public static final String IDO_BACK_IMAGE_KEY = "Back_Image";
    public static final String IDO_FRONT_IMAGE_KEY = "Front_Image";
    public static final String LOCAL_BACK_IMAGE_NAME = "back_ido_kyc_doc";
    public static final String LOCAL_FRONT_IMAGE_NAME = "front_ido_kyc_doc";
    public static final String TAG = "IdologyKycIdCapture";
    public Activity activity;
    public CameraCallBack2 cameraCallBack = new CameraCallBack2() {
        public void captureResults(final HashMap<String, String> hashMap) {
            hashMap.toString();
            new Thread(new Runnable() {
                public void run() {
                    IdologyKycIdCapture.this.writeImagesAsFile(hashMap);
                }
            }).run();
        }
    };
    public String documentType;
    public IdCaptureListener idCaptureListener;

    public IdologyKycIdCapture(Activity activity2) {
        this.activity = activity2;
    }

    private void sendFailureResponse(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", GopayLinkingHandler.STATUS_FAIL);
            jSONObject.put("reason", str);
            MLogger.d(TAG, "RESOLVING failure" + jSONObject.toString());
            final String jSONObject2 = jSONObject.toString();
            this.activity.runOnUiThread(new Runnable() {
                public void run() {
                    IdologyKycIdCapture.this.idCaptureListener.onIdCaptureFail(jSONObject2);
                }
            });
        } catch (JSONException unused) {
            MLogger.d(TAG, "e.printStackTrace()");
        }
    }

    private void sendSuccessResponse(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", "SUCCESS");
            jSONObject.put("frontpath", str);
            jSONObject.put("backpath", str2);
            jSONObject.put("frontImage", str3);
            jSONObject.put("backImage", str4);
            MLogger.d(TAG, "RESOLVING SUCCESS" + jSONObject.toString());
            final String jSONObject2 = jSONObject.toString();
            this.activity.runOnUiThread(new Runnable() {
                public void run() {
                    IdologyKycIdCapture.this.idCaptureListener.onIdCaptureSuccess(jSONObject2);
                }
            });
        } catch (JSONException unused) {
            MLogger.d(TAG, "e.printStackTrace()");
        }
    }

    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r11v2, types: [java.io.BufferedWriter] */
    /* JADX WARNING: type inference failed for: r10v3, types: [java.io.FileWriter] */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: type inference failed for: r11v4, types: [java.io.FileWriter] */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.BufferedWriter] */
    /* JADX WARNING: type inference failed for: r11v5 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r11v6, types: [java.io.FileWriter] */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.io.BufferedWriter] */
    /* JADX WARNING: type inference failed for: r11v7 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r11v8 */
    /* JADX WARNING: type inference failed for: r11v9 */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r11v10 */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r11v11, types: [java.io.FileWriter, java.io.Writer] */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9, types: [java.io.BufferedWriter] */
    /* JADX WARNING: type inference failed for: r10v7 */
    /* JADX WARNING: type inference failed for: r10v8 */
    /* JADX WARNING: type inference failed for: r11v12 */
    /* JADX WARNING: type inference failed for: r11v13 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r11v14 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r11v15 */
    /* JADX WARNING: type inference failed for: r11v16 */
    /* JADX WARNING: type inference failed for: r11v17 */
    /* JADX WARNING: type inference failed for: r11v18 */
    /* JADX WARNING: type inference failed for: r11v19 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r11v3
      assigns: []
      uses: []
      mth insns count: 88
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 14 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String writeFileUsingFileWriter(java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            android.app.Activity r1 = r8.activity
            java.io.File r1 = r1.getFilesDir()
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r11 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r11)
            long r3 = java.lang.System.currentTimeMillis()
            r11.append(r3)
            java.lang.String r3 = "."
            r11.append(r3)
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r2.<init>(r1, r10)
            r10 = 0
            java.io.FileWriter r11 = new java.io.FileWriter     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x006f, all -> 0x006c }
            r11.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x006f, all -> 0x006c }
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0061 }
            r1.<init>(r11)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0061 }
            r1.write(r9)     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005d }
            java.lang.String r9 = "IdologyKycIdCapture"
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005d }
            r4 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005d }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005d }
            java.lang.String r6 = "Wrote file successfully!"
            r5.append(r6)     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005d }
            java.lang.String r6 = r2.getAbsolutePath()     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005d }
            r5.append(r6)     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005d }
            java.lang.String r5 = r5.toString()     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005d }
            r3[r4] = r5     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005d }
            com.mpl.androidapp.utils.MLogger.d(r9, r3)     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005d }
            java.lang.String r9 = r2.getAbsolutePath()     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005d }
            r11.close()     // Catch:{ IOException -> 0x005c }
            r1.close()     // Catch:{ IOException -> 0x005c }
        L_0x005c:
            return r9
        L_0x005d:
            r9 = move-exception
            goto L_0x0072
        L_0x005f:
            r9 = move-exception
            goto L_0x009c
        L_0x0061:
            r9 = move-exception
        L_0x0062:
            r7 = r11
            r11 = r10
            r10 = r7
            goto L_0x00c6
        L_0x0066:
            r9 = move-exception
            r1 = r10
            goto L_0x0072
        L_0x0069:
            r9 = move-exception
            r1 = r10
            goto L_0x009c
        L_0x006c:
            r9 = move-exception
            r11 = r10
            goto L_0x00c6
        L_0x006f:
            r9 = move-exception
            r11 = r10
            r1 = r11
        L_0x0072:
            java.lang.String r2 = "IOException when writing files in IdologyKycCapture "
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c3 }
            r3.<init>()     // Catch:{ all -> 0x00c3 }
            r3.append(r2)     // Catch:{ all -> 0x00c3 }
            r3.append(r9)     // Catch:{ all -> 0x00c3 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x00c3 }
            if (r2 == 0) goto L_0x008f
            java.lang.String r2 = r9.getMessage()     // Catch:{ all -> 0x00c3 }
            if (r2 == 0) goto L_0x008f
            java.lang.String r0 = r9.getMessage()     // Catch:{ all -> 0x00c3 }
        L_0x008f:
            r8.sendFailureResponse(r0)     // Catch:{ all -> 0x00c3 }
            r11.close()     // Catch:{ IOException -> 0x0098 }
            r1.close()     // Catch:{ IOException -> 0x0098 }
        L_0x0098:
            return r10
        L_0x0099:
            r9 = move-exception
            r11 = r10
            r1 = r11
        L_0x009c:
            java.lang.String r2 = "File not found exception when writing files in IdologyKycCapture "
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c3 }
            r3.<init>()     // Catch:{ all -> 0x00c3 }
            r3.append(r2)     // Catch:{ all -> 0x00c3 }
            r3.append(r9)     // Catch:{ all -> 0x00c3 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x00c3 }
            if (r2 == 0) goto L_0x00b9
            java.lang.String r2 = r9.getMessage()     // Catch:{ all -> 0x00c3 }
            if (r2 == 0) goto L_0x00b9
            java.lang.String r0 = r9.getMessage()     // Catch:{ all -> 0x00c3 }
        L_0x00b9:
            r8.sendFailureResponse(r0)     // Catch:{ all -> 0x00c3 }
            r11.close()     // Catch:{ IOException -> 0x00c2 }
            r1.close()     // Catch:{ IOException -> 0x00c2 }
        L_0x00c2:
            return r10
        L_0x00c3:
            r9 = move-exception
            r10 = r1
            goto L_0x0062
        L_0x00c6:
            r10.close()     // Catch:{ IOException -> 0x00cc }
            r11.close()     // Catch:{ IOException -> 0x00cc }
        L_0x00cc:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.imagepicker.IdologyKycIdCapture.writeFileUsingFileWriter(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public void captureIds(final String str, IdCaptureListener idCaptureListener2) {
        this.documentType = str;
        this.idCaptureListener = idCaptureListener2;
        if (VERSION.SDK_INT < 23) {
            idCaptureListener2.onError("Not supported below android M");
        } else if (DOC_TYPE_PASSPORT_ONLY.equals(str) || DOC_TYPE_DL_ONLY.equals(str) || DOC_TYPE_ANY.equals(str)) {
            AnonymousClass2 r10 = new IActivationKeyProvider() {
                public InputStream getActivationKeyInputStream() {
                    return IdologyKycIdCapture.this.activity.getResources().openRawResource(R.raw.activation_key);
                }
            };
            AnonymousClass3 r0 = new IPublicKeyProvider() {
                public InputStream getPublicKeyInputStream() {
                    return IdologyKycIdCapture.this.activity.getResources().openRawResource(R.raw.idology_pub);
                }
            };
            AnonymousClass4 r1 = new Object() {
                public String enabledDocumentType() {
                    if (IdologyKycIdCapture.DOC_TYPE_ANY.equals(str)) {
                        return IdologyKycIdCapture.DOC_TYPE_DL_ONLY;
                    }
                    return str;
                }

                public InputStream getActivationKeyInputStream() {
                    return IdologyKycIdCapture.this.activity.getResources().openRawResource(R.raw.activation_key);
                }

                public InputStream getPublicKeyInputStream() {
                    return IdologyKycIdCapture.this.activity.getResources().openRawResource(R.raw.idology_pub);
                }

                public boolean isDefaultBackImageFlash() {
                    return false;
                }

                public boolean isEnabled(CameraSdkSettings$DocumentType cameraSdkSettings$DocumentType) {
                    MLogger.d(MLogger.TAG, "is enabled called with documentType " + cameraSdkSettings$DocumentType);
                    return true;
                }

                public boolean isStandardImageSize() {
                    return false;
                }
            };
            Activity activity2 = this.activity;
            CameraCallBack2 cameraCallBack2 = this.cameraCallBack;
            Constants constants = Constants.ourInstance;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity2);
            CameraLib.mCameraCallBack = cameraCallBack2;
            try {
                constants.activationKey = ActivationKey.validateActivationKey(r10, r0);
                constants.useSelfie = defaultSharedPreferences.getBoolean("UseSelfie", false);
            } catch (Exception e2) {
                e2.getMessage();
            }
            boolean z = constants.useSelfie;
            boolean isDefaultBackImageFlash = r1.isDefaultBackImageFlash();
            String enabledDocumentType = r1.enabledDocumentType();
            r1.isStandardImageSize();
            SharedPreferences defaultSharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(activity2);
            Constants constants2 = Constants.ourInstance;
            Intent intent = new Intent(activity2, CameraActivity.class);
            Objects.requireNonNull(constants2);
            intent.putExtra("UseSelfie", z);
            Objects.requireNonNull(constants2);
            intent.putExtra("DefaultBackImageFlash", isDefaultBackImageFlash);
            Objects.requireNonNull(constants2);
            intent.putExtra("DocumentType", enabledDocumentType);
            Objects.requireNonNull(constants2);
            Objects.requireNonNull(constants2);
            intent.putExtra("StandardImageSize", defaultSharedPreferences2.getBoolean("StandardImageSize", false));
            activity2.startActivity(intent);
        } else {
            idCaptureListener2.onError("DocumentType not supported");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeImagesAsFile(java.util.HashMap<java.lang.String, java.lang.String> r7) {
        /*
            r6 = this;
            java.lang.String r0 = r6.documentType
            int r1 = r0.hashCode()
            r2 = -1689504219(0xffffffff9b4c3625, float:-1.689198E-22)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L_0x002c
            r2 = 65996(0x101cc, float:9.248E-41)
            if (r1 == r2) goto L_0x0022
            r2 = 1431247614(0x554f1afe, float:1.4232177E13)
            if (r1 == r2) goto L_0x0018
            goto L_0x0036
        L_0x0018:
            java.lang.String r1 = "PassportOnly"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = 0
            goto L_0x0037
        L_0x0022:
            java.lang.String r1 = "Any"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = 2
            goto L_0x0037
        L_0x002c:
            java.lang.String r1 = "DriverLicenseOnly"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = 1
            goto L_0x0037
        L_0x0036:
            r0 = -1
        L_0x0037:
            java.lang.String r1 = "front_ido_kyc_doc"
            java.lang.String r2 = "txt"
            java.lang.String r5 = "Front_Image"
            if (r0 == 0) goto L_0x009b
            if (r0 == r4) goto L_0x0045
            if (r0 == r3) goto L_0x0045
            goto L_0x00ca
        L_0x0045:
            boolean r0 = r7.containsKey(r5)
            if (r0 == 0) goto L_0x0095
            java.lang.Object r0 = r7.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0095
            java.lang.String r0 = "Back_Image"
            boolean r3 = r7.containsKey(r0)
            if (r3 == 0) goto L_0x0095
            java.lang.Object r3 = r7.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0095
            java.lang.Object r3 = r7.get(r5)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r1 = r6.writeFileUsingFileWriter(r3, r2, r1)
            java.lang.Object r3 = r7.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "back_ido_kyc_doc"
            java.lang.String r2 = r6.writeFileUsingFileWriter(r3, r2, r4)
            if (r1 == 0) goto L_0x00ca
            if (r2 == 0) goto L_0x00ca
            java.lang.Object r3 = r7.get(r5)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r7 = r7.get(r0)
            java.lang.String r7 = (java.lang.String) r7
            r6.sendSuccessResponse(r1, r2, r3, r7)
            goto L_0x00ca
        L_0x0095:
            java.lang.String r7 = "Image strings not received from sdk"
            r6.sendFailureResponse(r7)
            goto L_0x00ca
        L_0x009b:
            boolean r0 = r7.containsKey(r5)
            if (r0 == 0) goto L_0x00c5
            java.lang.Object r0 = r7.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00c5
            java.lang.Object r0 = r7.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r6.writeFileUsingFileWriter(r0, r2, r1)
            if (r0 == 0) goto L_0x00ca
            java.lang.Object r7 = r7.get(r5)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r1 = ""
            r6.sendSuccessResponse(r0, r1, r7, r1)
            goto L_0x00ca
        L_0x00c5:
            java.lang.String r7 = "Image string not received from sdk"
            r6.sendFailureResponse(r7)
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.imagepicker.IdologyKycIdCapture.writeImagesAsFile(java.util.HashMap):void");
    }
}

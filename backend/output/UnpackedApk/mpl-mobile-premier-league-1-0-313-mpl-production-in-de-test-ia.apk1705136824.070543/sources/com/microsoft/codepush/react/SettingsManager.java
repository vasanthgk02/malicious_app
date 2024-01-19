package com.microsoft.codepush.react;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingsManager {
    public SharedPreferences mSettings;

    public SettingsManager(Context context) {
        this.mSettings = context.getSharedPreferences("CodePush", 0);
    }

    public JSONArray getFailedUpdates() {
        String string = this.mSettings.getString("CODE_PUSH_FAILED_UPDATES", null);
        if (string == null) {
            return new JSONArray();
        }
        try {
            return new JSONArray(string);
        } catch (JSONException unused) {
            JSONArray jSONArray = new JSONArray();
            this.mSettings.edit().putString("CODE_PUSH_FAILED_UPDATES", jSONArray.toString()).commit();
            return jSONArray;
        }
    }

    public JSONObject getLatestRollbackInfo() {
        String string = this.mSettings.getString("LATEST_ROLLBACK_INFO", null);
        if (string == null) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            return null;
        }
    }

    public JSONObject getPendingUpdate() {
        String string = this.mSettings.getString("CODE_PUSH_PENDING_UPDATE", null);
        if (string == null) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean isFailedHash(String str) {
        JSONArray failedUpdates = getFailedUpdates();
        if (str != null) {
            int i = 0;
            while (i < failedUpdates.length()) {
                try {
                    if (str.equals(failedUpdates.getJSONObject(i).getString("packageHash"))) {
                        return true;
                    }
                    i++;
                } catch (JSONException e2) {
                    throw new CodePushUnknownException("Unable to read failedUpdates data stored in SharedPreferences.", e2);
                }
            }
        }
        return false;
    }

    public boolean isPendingUpdate(String str) {
        JSONObject pendingUpdate = getPendingUpdate();
        if (pendingUpdate != null) {
            try {
                if (!pendingUpdate.getBoolean("isLoading") && (str == null || pendingUpdate.getString(Response.HASH).equals(str))) {
                    return true;
                }
            } catch (JSONException e2) {
                throw new CodePushUnknownException("Unable to read pending update metadata in isPendingUpdate.", e2);
            }
        }
        return false;
    }

    public void removePendingUpdate() {
        this.mSettings.edit().remove("CODE_PUSH_PENDING_UPDATE").commit();
    }

    public void saveFailedUpdate(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            if (!isFailedHash(jSONObject.getString("packageHash"))) {
                String string = this.mSettings.getString("CODE_PUSH_FAILED_UPDATES", null);
                if (string == null) {
                    jSONArray = new JSONArray();
                } else {
                    try {
                        jSONArray = new JSONArray(string);
                    } catch (JSONException e2) {
                        throw new CodePushMalformedDataException(GeneratedOutlineSupport.outline52("Unable to parse failed updates information ", string, " stored in SharedPreferences"), (Throwable) e2);
                    }
                }
                jSONArray.put(jSONObject);
                this.mSettings.edit().putString("CODE_PUSH_FAILED_UPDATES", jSONArray.toString()).commit();
            }
        } catch (JSONException e3) {
            throw new CodePushUnknownException("Unable to read package hash from package.", e3);
        }
    }

    public void savePendingUpdate(String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Response.HASH, str);
            jSONObject.put("isLoading", z);
            this.mSettings.edit().putString("CODE_PUSH_PENDING_UPDATE", jSONObject.toString()).commit();
        } catch (JSONException e2) {
            throw new CodePushUnknownException("Unable to save pending update.", e2);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:0|(3:2|3|(1:5))(1:6)|7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0044, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004c, code lost:
        throw new com.microsoft.codepush.react.CodePushUnknownException("Unable to save latest rollback info.", r7);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setLatestRollbackInfo(java.lang.String r7) {
        /*
            r6 = this;
            org.json.JSONObject r0 = r6.getLatestRollbackInfo()
            java.lang.String r1 = "count"
            java.lang.String r2 = "packageHash"
            r3 = 0
            if (r0 == 0) goto L_0x001a
            java.lang.String r4 = r0.getString(r2)     // Catch:{ JSONException -> 0x001f }
            boolean r4 = r4.equals(r7)     // Catch:{ JSONException -> 0x001f }
            if (r4 == 0) goto L_0x001f
            int r3 = r0.getInt(r1)     // Catch:{ JSONException -> 0x001f }
            goto L_0x001f
        L_0x001a:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
        L_0x001f:
            r0.put(r2, r7)     // Catch:{ JSONException -> 0x0044 }
            java.lang.String r7 = "time"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0044 }
            r0.put(r7, r4)     // Catch:{ JSONException -> 0x0044 }
            int r3 = r3 + 1
            r0.put(r1, r3)     // Catch:{ JSONException -> 0x0044 }
            android.content.SharedPreferences r7 = r6.mSettings     // Catch:{ JSONException -> 0x0044 }
            android.content.SharedPreferences$Editor r7 = r7.edit()     // Catch:{ JSONException -> 0x0044 }
            java.lang.String r1 = "LATEST_ROLLBACK_INFO"
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0044 }
            android.content.SharedPreferences$Editor r7 = r7.putString(r1, r0)     // Catch:{ JSONException -> 0x0044 }
            r7.commit()     // Catch:{ JSONException -> 0x0044 }
            return
        L_0x0044:
            r7 = move-exception
            com.microsoft.codepush.react.CodePushUnknownException r0 = new com.microsoft.codepush.react.CodePushUnknownException
            java.lang.String r1 = "Unable to save latest rollback info."
            r0.<init>(r1, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.codepush.react.SettingsManager.setLatestRollbackInfo(java.lang.String):void");
    }
}

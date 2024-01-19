package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.SMTEventParamKeys;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class Store {
    public final SharedPreferences store;

    public static class Token {
        public static final long REFRESH_PERIOD_MILLIS = TimeUnit.DAYS.toMillis(7);
        public final String appVersion;
        public final long timestamp;
        public final String token;

        public Token(String str, String str2, long j) {
            this.token = str;
            this.appVersion = str2;
            this.timestamp = j;
        }

        public static String encode(String str, String str2, long j) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put(SMTEventParamKeys.SMT_APP_VERSION, str2);
                jSONObject.put("timestamp", j);
                return jSONObject.toString();
            } catch (JSONException e2) {
                "Failed to encode token: " + e2;
                return null;
            }
        }

        public static Token parse(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new Token(str, null, 0);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new Token(jSONObject.getString("token"), jSONObject.getString(SMTEventParamKeys.SMT_APP_VERSION), jSONObject.getLong("timestamp"));
            } catch (JSONException e2) {
                "Failed to parse token: " + e2;
                return null;
            }
        }
    }

    public Store(Context context) {
        boolean isEmpty;
        this.store = context.getSharedPreferences("com.google.android.gms.appid", 0);
        File file = new File(ContextCompat.getNoBackupFilesDir(context), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    synchronized (this) {
                        isEmpty = this.store.getAll().isEmpty();
                    }
                    if (!isEmpty) {
                        synchronized (this) {
                            this.store.edit().clear().commit();
                        }
                    }
                }
            } catch (IOException e2) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    e2.getMessage();
                }
            }
        }
    }

    public final String createTokenKey(String str, String str2) {
        return GeneratedOutlineSupport.outline54(str, "|T|", str2, "|", "*");
    }

    public synchronized void saveToken(String str, String str2, String str3, String str4) {
        String encode = Token.encode(str3, str4, System.currentTimeMillis());
        if (encode != null) {
            Editor edit = this.store.edit();
            edit.putString(createTokenKey(str, str2), encode);
            edit.commit();
        }
    }
}

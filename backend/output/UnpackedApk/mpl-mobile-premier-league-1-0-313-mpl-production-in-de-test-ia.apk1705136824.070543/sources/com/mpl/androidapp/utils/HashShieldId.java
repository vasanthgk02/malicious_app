package com.mpl.androidapp.utils;

import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;

public class HashShieldId {
    public static final String TAG = "hashShieldId";

    public static String generateHash(String str) {
        String valueOf = String.valueOf(System.currentTimeMillis());
        String generateSHA256 = generateSHA256(valueOf);
        MLogger.d("hashShieldId", GeneratedOutlineSupport.outline50("hash generated for time: ", generateSHA256));
        String generateSHA2562 = generateSHA256(str);
        MLogger.d("hashShieldId", GeneratedOutlineSupport.outline50("hash generated for shieldId: ", generateSHA2562));
        String generateSHA2563 = generateSHA256(generateSHA256 + generateSHA2562 + generateSHA256);
        MLogger.d("hashShieldId", GeneratedOutlineSupport.outline50("final hash: ", generateSHA2563));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bonusCoupon", generateSHA2563);
            jSONObject.put("bonusTime", valueOf);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String generateSHA256(String str) {
        try {
            return Base64.encodeToString(MessageDigest.getInstance("SHA-256").digest(str.getBytes(StandardCharsets.UTF_8)), 2);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}

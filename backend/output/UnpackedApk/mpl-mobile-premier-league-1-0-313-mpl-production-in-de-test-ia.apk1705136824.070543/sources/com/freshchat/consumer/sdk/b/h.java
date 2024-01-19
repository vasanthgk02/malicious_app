package com.freshchat.consumer.sdk.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Build;
import android.provider.Settings.Secure;
import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import in.juspay.hypersdk.security.EncryptionHelper;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class h implements SharedPreferences {
    public static SharedPreferences cH;
    public static byte[] cI;
    public static boolean cJ;
    public static int fB;

    public static class a implements Editor {
        public Editor dQ;

        public a() {
            this.dQ = h.cH.edit();
        }

        @TargetApi(9)
        public void apply() {
            this.dQ.apply();
        }

        public Editor clear() {
            this.dQ.clear();
            return this;
        }

        public boolean commit() {
            return this.dQ.commit();
        }

        public Editor putBoolean(String str, boolean z) {
            this.dQ.putString(h.M(str), h.M(Boolean.toString(z)));
            return this;
        }

        public Editor putFloat(String str, float f2) {
            this.dQ.putString(h.M(str), h.M(Float.toString(f2)));
            return this;
        }

        public Editor putInt(String str, int i) {
            this.dQ.putString(h.M(str), h.M(Integer.toString(i)));
            return this;
        }

        public Editor putLong(String str, long j) {
            this.dQ.putString(h.M(str), h.M(Long.toString(j)));
            return this;
        }

        public Editor putString(String str, String str2) {
            this.dQ.putString(h.M(str), h.M(str2));
            return this;
        }

        @TargetApi(11)
        public Editor putStringSet(String str, Set<String> set) {
            HashSet hashSet = new HashSet(set.size());
            for (String O : set) {
                hashSet.add(h.M(O));
            }
            this.dQ.putStringSet(h.M(str), hashSet);
            return this;
        }

        public Editor remove(String str) {
            this.dQ.remove(h.M(str));
            return this;
        }
    }

    public h(Context context, String str) {
        if (cH == null) {
            cH = context.getSharedPreferences(str, 0);
        }
        try {
            String k = k(context);
            String string = cH.getString(k, null);
            if (string == null) {
                string = bb();
                cH.edit().putString(k, string).commit();
                ix();
            } else {
                fB = cH.getInt("PREF_ALG_VER", 1);
            }
            ai.i("FRESHCHAT", "Shared Preference encryption version " + fB);
            cI = decode(string);
        } catch (Exception e2) {
            if (cJ) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error init:");
                outline73.append(e2.getMessage());
                ai.e("FRESHCHAT", outline73.toString());
            }
            throw new IllegalStateException(e2);
        }
    }

    public static String M(String str) {
        if (!(str == null || str.length() == 0)) {
            try {
                Cipher eP = eP();
                byte[] doFinal = eP.doFinal(str.getBytes("UTF-8"));
                if (fB == 3) {
                    doFinal = k.a(eP.getIV(), doFinal);
                }
                return encode(doFinal);
            } catch (Exception e2) {
                if (cJ) {
                    ai.w("FRESHCHAT", "encrypt", e2);
                }
                str = null;
            }
        }
        return str;
    }

    public static String N(String str) {
        if (!(str == null || str.length() == 0)) {
            try {
                byte[] decode = decode(str);
                Cipher a2 = a(decode);
                return new String(fB == 3 ? a2.doFinal(decode, 12, decode.length - 12) : a2.doFinal(decode), "UTF-8");
            } catch (Exception e2) {
                if (cJ) {
                    ai.w("FRESHCHAT", "decrypt", e2);
                }
                str = null;
            }
        }
        return str;
    }

    public static Cipher a(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher iw = iw();
        int i = fB;
        if (i == 3) {
            iw.init(2, new SecretKeySpec(cI, getTransformation()), new IvParameterSpec(bArr, 0, 12));
        } else if (i == 2 || i == 4) {
            iw.init(2, new SecretKeySpec(cI, getTransformation()), new IvParameterSpec(new byte[iw.getBlockSize()]));
        } else {
            iw.init(2, new SecretKeySpec(cI, getTransformation()));
        }
        return iw;
    }

    public static SecretKey a(char[] cArr, byte[] bArr, String str, int i, int i2) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException {
        if (i == 0) {
            i = 1000;
        }
        return SecretKeyFactory.getInstance(str, "BC").generateSecret(new PBEKeySpec(cArr, bArr, i, i2));
    }

    public static String bb() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        KeyGenerator instance = KeyGenerator.getInstance(EncryptionHelper.algorithm);
        try {
            instance.init(256, secureRandom);
        } catch (Exception unused) {
            try {
                instance.init(192, secureRandom);
            } catch (Exception unused2) {
                instance.init(128, secureRandom);
            }
        }
        return encode(instance.generateKey().getEncoded());
    }

    public static byte[] decode(String str) {
        return Base64.decode(str, 3);
    }

    public static Cipher eP() throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher iw = iw();
        int i = fB;
        if (i == 3) {
            iw.init(1, new SecretKeySpec(cI, getTransformation()), new IvParameterSpec(iv()));
        } else if (i == 2 || i == 4) {
            iw.init(1, new SecretKeySpec(cI, getTransformation()), new IvParameterSpec(new byte[iw.getBlockSize()]));
        } else {
            iw.init(1, new SecretKeySpec(cI, getTransformation()));
        }
        return iw;
    }

    public static String encode(byte[] bArr) {
        return Base64.encodeToString(bArr, 3);
    }

    public static String getTransformation() {
        return fB >= 2 ? "AES/GCM/NoPadding" : EncryptionHelper.algorithm;
    }

    public static byte[] iv() {
        byte[] bArr = new byte[12];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public static Cipher iw() throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException {
        return fB >= 2 ? Cipher.getInstance(getTransformation()) : Cipher.getInstance(getTransformation(), "BC");
    }

    private void ix() {
        fB = 4;
        cH.edit().putInt("PREF_ALG_VER", 4).commit();
    }

    public static String k(Context context) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException {
        SecretKey secretKey;
        char[] charArray = context.getPackageName().toCharArray();
        byte[] bytes = l(context).getBytes();
        try {
            secretKey = a(charArray, bytes, "PBKDF2WithHmacSHA1", 2000, 256);
        } catch (NoSuchAlgorithmException unused) {
            secretKey = a(charArray, bytes, "PBEWithMD5AndDES", 2000, 256);
        }
        return encode(secretKey.getEncoded());
    }

    public static String l(Context context) {
        String str = null;
        try {
            str = (String) Build.class.getField("SERIAL").get(null);
        } catch (Exception unused) {
        }
        return as.isEmpty(str) ? Secure.getString(context.getContentResolver(), "android_id") : str;
    }

    /* renamed from: ci */
    public a edit() {
        return new a();
    }

    public boolean contains(String str) {
        return cH.contains(M(str));
    }

    public boolean eO() {
        return fB != 4;
    }

    public Map<String, String> getAll() {
        Map<String, ?> all = cH.getAll();
        HashMap hashMap = new HashMap(all.size());
        for (Entry next : all.entrySet()) {
            try {
                hashMap.put(N((String) next.getKey()), N(next.getValue().toString()));
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }

    public boolean getBoolean(String str, boolean z) {
        String string = cH.getString(M(str), null);
        if (string == null) {
            return z;
        }
        try {
            return Boolean.parseBoolean(N(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    public float getFloat(String str, float f2) {
        String string = cH.getString(M(str), null);
        if (string == null) {
            return f2;
        }
        try {
            return Float.parseFloat(N(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    public int getInt(String str, int i) {
        String string = cH.getString(M(str), null);
        if (string == null) {
            return i;
        }
        try {
            return Integer.parseInt(N(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    public long getLong(String str, long j) {
        String string = cH.getString(M(str), null);
        if (string == null) {
            return j;
        }
        try {
            return Long.parseLong(N(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    public String getString(String str, String str2) {
        String string = cH.getString(M(str), null);
        return string != null ? N(string) : str2;
    }

    @TargetApi(11)
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> stringSet = cH.getStringSet(M(str), null);
        if (stringSet == null) {
            return set;
        }
        HashSet hashSet = new HashSet(stringSet.size());
        for (String N : stringSet) {
            hashSet.add(N(N));
        }
        return hashSet;
    }

    public boolean jM() {
        return fB == 3;
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        cH.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        cH.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}

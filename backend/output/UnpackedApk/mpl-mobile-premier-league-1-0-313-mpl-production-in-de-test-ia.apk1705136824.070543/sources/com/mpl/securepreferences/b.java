package com.mpl.securepreferences;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Base64;
import com.mpl.securepreferences.a.C0000a;
import com.mpl.securepreferences.a.c;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: SecurePreferences */
public class b implements SharedPreferences {

    /* renamed from: a  reason: collision with root package name */
    public static final String f980a = b.class.getName();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f981b = false;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f982c;

    /* renamed from: d  reason: collision with root package name */
    public c f983d;

    /* renamed from: e  reason: collision with root package name */
    public String f984e;

    /* compiled from: SecurePreferences */
    public final class a implements Editor {

        /* renamed from: b  reason: collision with root package name */
        public Editor f986b;

        @TargetApi(9)
        public void apply() {
            this.f986b.apply();
        }

        public Editor clear() {
            this.f986b.clear();
            return this;
        }

        public boolean commit() {
            return this.f986b.commit();
        }

        public Editor putBoolean(String str, boolean z) {
            this.f986b.putString(b.b(str), b.this.c(Boolean.toString(z)));
            return this;
        }

        public Editor putFloat(String str, float f2) {
            this.f986b.putString(b.b(str), b.this.c(Float.toString(f2)));
            return this;
        }

        public Editor putInt(String str, int i) {
            this.f986b.putString(b.b(str), b.this.c(Integer.toString(i)));
            return this;
        }

        public Editor putLong(String str, long j) {
            this.f986b.putString(b.b(str), b.this.c(Long.toString(j)));
            return this;
        }

        public Editor putString(String str, String str2) {
            this.f986b.putString(b.b(str), b.this.c(str2));
            return this;
        }

        @TargetApi(11)
        public Editor putStringSet(String str, Set<String> set) {
            HashSet hashSet = new HashSet(set.size());
            for (String a2 : set) {
                hashSet.add(b.this.c(a2));
            }
            this.f986b.putStringSet(b.b(str), hashSet);
            return this;
        }

        public Editor remove(String str) {
            this.f986b.remove(b.b(str));
            return this;
        }

        public a() {
            this.f986b = b.this.f982c.edit();
        }
    }

    public b(Context context, String str, String str2, int i) {
        this(context, null, str, str2, i < 1 ? 10000 : i);
    }

    public static String b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            instance.update(bytes, 0, bytes.length);
            return Base64.encodeToString(instance.digest(), 2);
        } catch (NoSuchAlgorithmException unused) {
            boolean z = f981b;
            return null;
        }
    }

    /* access modifiers changed from: private */
    public String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return a.a(str, this.f983d).toString();
        } catch (GeneralSecurityException unused) {
            boolean z = f981b;
            return null;
        } catch (UnsupportedEncodingException unused2) {
            boolean z2 = f981b;
            return null;
        }
    }

    private String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return a.a(new C0000a(str), this.f983d);
        } catch (GeneralSecurityException unused) {
            boolean z = f981b;
            return null;
        } catch (UnsupportedEncodingException unused2) {
            boolean z2 = f981b;
            return null;
        }
    }

    public boolean contains(String str) {
        return this.f982c.contains(b(str));
    }

    public Map<String, String> getAll() {
        Map<String, ?> all = this.f982c.getAll();
        HashMap hashMap = new HashMap(all.size());
        for (Entry next : all.entrySet()) {
            try {
                Object value = next.getValue();
                if (value != null && !value.equals(this.f983d.toString())) {
                    hashMap.put(next.getKey(), d(value.toString()));
                }
            } catch (Exception unused) {
                boolean z = f981b;
                hashMap.put(next.getKey(), next.getValue().toString());
            }
        }
        return hashMap;
    }

    public boolean getBoolean(String str, boolean z) {
        String string = this.f982c.getString(b(str), null);
        if (string == null) {
            return z;
        }
        try {
            return Boolean.parseBoolean(d(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    public float getFloat(String str, float f2) {
        String string = this.f982c.getString(b(str), null);
        if (string == null) {
            return f2;
        }
        try {
            return Float.parseFloat(d(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    public int getInt(String str, int i) {
        String string = this.f982c.getString(b(str), null);
        if (string == null) {
            return i;
        }
        try {
            return Integer.parseInt(d(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    public long getLong(String str, long j) {
        String string = this.f982c.getString(b(str), null);
        if (string == null) {
            return j;
        }
        try {
            return Long.parseLong(d(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    public String getString(String str, String str2) {
        String string = this.f982c.getString(b(str), null);
        return string != null ? d(string) : str2;
    }

    @TargetApi(11)
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> stringSet = this.f982c.getStringSet(b(str), null);
        if (stringSet == null) {
            return set;
        }
        HashSet hashSet = new HashSet(stringSet.size());
        for (String d2 : stringSet) {
            hashSet.add(d(d2));
        }
        return hashSet;
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f982c.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f982c.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public b(Context context, c cVar, String str, String str2, int i) {
        if (this.f982c == null) {
            this.f982c = a(context, str2);
        }
        if (cVar != null) {
            this.f983d = cVar;
        } else if (TextUtils.isEmpty(str)) {
            try {
                String a2 = a(context, i);
                String string = this.f982c.getString(a2, null);
                if (string == null) {
                    this.f983d = a.a();
                    boolean commit = this.f982c.edit().putString(a2, this.f983d.toString()).commit();
                } else {
                    this.f983d = a.a(string);
                }
                if (this.f983d == null) {
                    throw new GeneralSecurityException("Problem generating Key");
                }
            } catch (GeneralSecurityException e2) {
                if (f981b) {
                    e2.getMessage();
                }
                throw new IllegalStateException(e2);
            }
        } else {
            try {
                c a3 = a.a(str, a(context).getBytes(), i);
                this.f983d = a3;
                if (a3 == null) {
                    throw new GeneralSecurityException("Problem generating Key From Password");
                }
            } catch (GeneralSecurityException e3) {
                if (f981b) {
                    e3.getMessage();
                }
                throw new IllegalStateException(e3);
            }
        }
    }

    public static String a(Context context) {
        try {
            String str = (String) Build.class.getField("SERIAL").get(null);
            return TextUtils.isEmpty(str) ? Secure.getString(context.getContentResolver(), "android_id") : str;
        } catch (Exception unused) {
            return Secure.getString(context.getContentResolver(), "android_id");
        }
    }

    private void b() {
        this.f983d = null;
    }

    private SharedPreferences a(Context context, String str) {
        this.f984e = this.f984e;
        if (TextUtils.isEmpty(str)) {
            return PreferenceManager.getDefaultSharedPreferences(context);
        }
        return context.getSharedPreferences(str, 0);
    }

    private String a(Context context, int i) {
        return b(a.a(context.getPackageName(), a(context).getBytes(), i).toString());
    }

    public void a(String str, Context context, int i) {
        c a2 = a.a(str, a(context).getBytes(), i);
        Map<String, ?> all = this.f982c.getAll();
        HashMap hashMap = new HashMap(all.size());
        for (String next : all.keySet()) {
            Object obj = all.get(next);
            if (obj instanceof String) {
                hashMap.put(next, d((String) obj));
            }
        }
        b();
        Editor edit = this.f982c.edit();
        edit.clear();
        edit.commit();
        this.f982c = null;
        SharedPreferences a3 = a(context, this.f984e);
        this.f982c = a3;
        this.f983d = a2;
        Editor edit2 = a3.edit();
        for (String str2 : hashMap.keySet()) {
            edit2.putString(str2, c((String) hashMap.get(str2)));
        }
        edit2.commit();
    }

    public b(Context context, String str, String str2) {
        this(context, str, str2, 0);
    }

    public void a(String str, Context context) {
        a(str, context, 10000);
    }

    /* renamed from: a */
    public a edit() {
        return new a();
    }
}
